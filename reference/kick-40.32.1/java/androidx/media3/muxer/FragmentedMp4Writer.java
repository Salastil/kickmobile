package androidx.media3.muxer;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Util;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
final class FragmentedMp4Writer {
    private final AnnexBToAvccConverter annexBToAvccConverter;
    private final long fragmentDurationUs;
    private boolean headerCreated;
    private long maxTrackDurationUs;
    private final MetadataCollector metadataCollector;
    private int nextTrackId;
    private final PositionTrackingOutputChannel outputChannel;
    private final boolean sampleCopyEnabled;
    private Track videoTrack;
    private final int lastSampleDurationBehavior = 1;
    private final List<Track> tracks = new ArrayList();
    private long minInputPresentationTimeUs = Long.MAX_VALUE;
    private int currentFragmentSequenceNumber = 1;
    private final LinearByteBufferAllocator linearByteBufferAllocator = new LinearByteBufferAllocator(0);

    public static class SampleMetadata {
        public final int compositionTimeOffsetVu;
        public final int durationVu;
        public final int flags;
        public final int size;

        public SampleMetadata(int i, int i2, int i3, int i4) {
            this.durationVu = i;
            this.size = i2;
            this.flags = i3;
            this.compositionTimeOffsetVu = i4;
        }
    }

    private static class PositionTrackingOutputChannel implements WritableByteChannel {
        private final WritableByteChannel outputChannel;
        private long position = 0;

        public PositionTrackingOutputChannel(WritableByteChannel writableByteChannel) {
            this.outputChannel = writableByteChannel;
        }

        @Override // java.nio.channels.WritableByteChannel
        public int write(ByteBuffer byteBuffer) throws IOException {
            int iWrite = this.outputChannel.write(byteBuffer);
            this.position += (long) iWrite;
            return iWrite;
        }

        @Override // java.nio.channels.Channel
        public boolean isOpen() {
            return this.outputChannel.isOpen();
        }

        @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.outputChannel.close();
        }

        public long getPosition() {
            return this.position;
        }
    }

    public FragmentedMp4Writer(WritableByteChannel writableByteChannel, MetadataCollector metadataCollector, AnnexBToAvccConverter annexBToAvccConverter, long j, boolean z) {
        this.outputChannel = new PositionTrackingOutputChannel(writableByteChannel);
        this.metadataCollector = metadataCollector;
        this.annexBToAvccConverter = annexBToAvccConverter;
        this.fragmentDurationUs = j * 1000;
        this.sampleCopyEnabled = z;
    }

    public Track addTrack(int i, Format format) {
        int i2 = this.nextTrackId;
        this.nextTrackId = i2 + 1;
        Track track = new Track(i2, format, this.sampleCopyEnabled);
        this.tracks.add(track);
        if (MimeTypes.isVideo(format.sampleMimeType)) {
            this.videoTrack = track;
        }
        return track;
    }

    public void writeSampleData(Track track, ByteBuffer byteBuffer, BufferInfo bufferInfo) throws IOException {
        if (Objects.equals(track.format.sampleMimeType, "video/av01") && track.format.initializationData.isEmpty() && track.parsedCsd == null) {
            track.parsedCsd = Av1ConfigUtil.createAv1CodecConfigurationRecord(byteBuffer.duplicate());
        }
        if (!this.headerCreated) {
            createHeader();
            this.headerCreated = true;
        }
        if (shouldFlushPendingSamples(track, bufferInfo)) {
            createFragment();
        }
        track.writeSampleData(byteBuffer, bufferInfo);
        BufferInfo bufferInfo2 = (BufferInfo) Preconditions.checkNotNull(track.pendingSamplesBufferInfo.peekFirst());
        BufferInfo bufferInfo3 = (BufferInfo) Preconditions.checkNotNull(track.pendingSamplesBufferInfo.peekLast());
        this.minInputPresentationTimeUs = Math.min(this.minInputPresentationTimeUs, bufferInfo2.presentationTimeUs);
        this.maxTrackDurationUs = Math.max(this.maxTrackDurationUs, bufferInfo3.presentationTimeUs - bufferInfo2.presentationTimeUs);
    }

    public void close() throws IOException {
        try {
            createFragment();
        } finally {
            this.outputChannel.close();
        }
    }

    private static ImmutableList<ByteBuffer> createTrafBoxes(List<ProcessedTrackInfo> list, long j) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int iCalculateMoofBoxSize = calculateMoofBoxSize(list) + 8;
        for (int i = 0; i < list.size(); i++) {
            ProcessedTrackInfo processedTrackInfo = list.get(i);
            builder.add(Boxes.traf(Boxes.tfhd(processedTrackInfo.trackId, j), Boxes.trun(processedTrackInfo.trackFormat, processedTrackInfo.pendingSamplesMetadata, iCalculateMoofBoxSize, processedTrackInfo.hasBFrame)));
            iCalculateMoofBoxSize += processedTrackInfo.totalSamplesSize;
        }
        return builder.build();
    }

    private static int calculateMoofBoxSize(List<ProcessedTrackInfo> list) {
        int trunBoxContentSize = 0;
        for (int i = 0; i < list.size(); i++) {
            ProcessedTrackInfo processedTrackInfo = list.get(i);
            trunBoxContentSize += Boxes.getTrunBoxContentSize(processedTrackInfo.pendingSamplesMetadata.size(), processedTrackInfo.hasBFrame) + 40;
        }
        return 24 + trunBoxContentSize;
    }

    private void createHeader() throws IOException {
        this.outputChannel.write(Boxes.ftyp());
        this.outputChannel.write(Boxes.moov(this.tracks, this.metadataCollector, true, this.lastSampleDurationBehavior));
    }

    private boolean shouldFlushPendingSamples(Track track, BufferInfo bufferInfo) {
        Track track2 = this.videoTrack;
        if (track2 == null) {
            return this.maxTrackDurationUs >= this.fragmentDurationUs;
        }
        if (track.equals(track2) && track.hadKeyframe && (bufferInfo.flags & 1) > 0) {
            if (((BufferInfo) Preconditions.checkNotNull(track.pendingSamplesBufferInfo.peekLast())).presentationTimeUs - ((BufferInfo) Preconditions.checkNotNull(track.pendingSamplesBufferInfo.peekFirst())).presentationTimeUs >= this.fragmentDurationUs) {
                return true;
            }
        }
        return false;
    }

    private void createFragment() throws IOException {
        ImmutableList<ProcessedTrackInfo> immutableListProcessAllTracks = processAllTracks();
        ImmutableList<ByteBuffer> immutableListCreateTrafBoxes = createTrafBoxes(immutableListProcessAllTracks, this.outputChannel.getPosition());
        if (immutableListCreateTrafBoxes.isEmpty()) {
            return;
        }
        this.outputChannel.write(Boxes.moof(Boxes.mfhd(this.currentFragmentSequenceNumber), immutableListCreateTrafBoxes));
        writeMdatBox(immutableListProcessAllTracks);
        this.currentFragmentSequenceNumber++;
        this.maxTrackDurationUs = 0L;
    }

    private void writeMdatBox(List<ProcessedTrackInfo> list) throws IOException {
        long jRemaining = 0;
        for (int i = 0; i < list.size(); i++) {
            ProcessedTrackInfo processedTrackInfo = list.get(i);
            for (int i2 = 0; i2 < processedTrackInfo.pendingSamplesByteBuffer.size(); i2++) {
                jRemaining += (long) processedTrackInfo.pendingSamplesByteBuffer.get(i2).remaining();
            }
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        long j = 8 + jRemaining;
        Preconditions.checkArgument(j <= 4294967295L, "Only 32-bit long mdat size supported in the fragmented MP4");
        byteBufferAllocate.putInt((int) j);
        byteBufferAllocate.put(Util.getUtf8Bytes("mdat"));
        byteBufferAllocate.flip();
        this.outputChannel.write(byteBufferAllocate);
        for (int i3 = 0; i3 < list.size(); i3++) {
            ProcessedTrackInfo processedTrackInfo2 = list.get(i3);
            for (int i4 = 0; i4 < processedTrackInfo2.pendingSamplesByteBuffer.size(); i4++) {
                this.outputChannel.write(processedTrackInfo2.pendingSamplesByteBuffer.get(i4));
            }
        }
        this.linearByteBufferAllocator.reset();
    }

    private ImmutableList<ProcessedTrackInfo> processAllTracks() {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < this.tracks.size(); i++) {
            if (!this.tracks.get(i).pendingSamplesBufferInfo.isEmpty()) {
                builder.add(processTrack(i + 1, this.tracks.get(i)));
            }
        }
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProcessedTrackInfo processTrack(int i, Track track) {
        Preconditions.checkState(track.pendingSamplesByteBuffer.size() == track.pendingSamplesBufferInfo.size());
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList.Builder builder2 = new ImmutableList.Builder();
        if (AnnexBUtils.doesSampleContainAnnexBNalUnits(track.format)) {
            while (!track.pendingSamplesByteBuffer.isEmpty()) {
                ByteBuffer byteBufferProcess = this.annexBToAvccConverter.process(track.pendingSamplesByteBuffer.removeFirst(), this.linearByteBufferAllocator);
                builder.add(byteBufferProcess);
                BufferInfo bufferInfoRemoveFirst = track.pendingSamplesBufferInfo.removeFirst();
                builder2.add(new BufferInfo(bufferInfoRemoveFirst.presentationTimeUs, byteBufferProcess.remaining(), bufferInfoRemoveFirst.flags));
            }
        } else {
            builder.addAll((Iterable) track.pendingSamplesByteBuffer);
            track.pendingSamplesByteBuffer.clear();
            builder2.addAll((Iterable) track.pendingSamplesBufferInfo);
            track.pendingSamplesBufferInfo.clear();
        }
        ImmutableList immutableListBuild = builder2.build();
        List<Integer> listConvertPresentationTimestampsToDurationsVu = Boxes.convertPresentationTimestampsToDurationsVu(immutableListBuild, track.videoUnitTimebase(), 1, track.endOfStreamTimestampUs);
        List<Integer> listCalculateSampleCompositionTimeOffsets = Boxes.calculateSampleCompositionTimeOffsets(immutableListBuild, listConvertPresentationTimestampsToDurationsVu, track.videoUnitTimebase());
        boolean zIsEmpty = listCalculateSampleCompositionTimeOffsets.isEmpty();
        boolean z = !zIsEmpty;
        ImmutableList.Builder builder3 = new ImmutableList.Builder();
        int i2 = 0;
        for (int i3 = 0; i3 < immutableListBuild.size(); i3++) {
            i2 += ((BufferInfo) immutableListBuild.get(i3)).size;
            builder3.add(new SampleMetadata(listConvertPresentationTimestampsToDurationsVu.get(i3).intValue(), ((BufferInfo) immutableListBuild.get(i3)).size, ((BufferInfo) immutableListBuild.get(i3)).flags, !zIsEmpty ? listCalculateSampleCompositionTimeOffsets.get(i3).intValue() : 0));
        }
        return new ProcessedTrackInfo(i, track.format, i2, z, builder.build(), builder3.build());
    }

    private static class ProcessedTrackInfo {
        public final boolean hasBFrame;
        public final ImmutableList<ByteBuffer> pendingSamplesByteBuffer;
        public final ImmutableList<SampleMetadata> pendingSamplesMetadata;
        public final int totalSamplesSize;
        public final Format trackFormat;
        public final int trackId;

        public ProcessedTrackInfo(int i, Format format, int i2, boolean z, ImmutableList<ByteBuffer> immutableList, ImmutableList<SampleMetadata> immutableList2) {
            this.trackId = i;
            this.trackFormat = format;
            this.totalSamplesSize = i2;
            this.hasBFrame = z;
            this.pendingSamplesByteBuffer = immutableList;
            this.pendingSamplesMetadata = immutableList2;
        }
    }
}
