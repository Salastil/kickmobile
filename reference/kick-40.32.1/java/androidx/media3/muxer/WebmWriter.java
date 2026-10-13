package androidx.media3.muxer;

import android.util.SparseArray;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Util;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes5.dex */
final class WebmWriter {
    private static final int MAX_CLUSTER_DURATION_US = 2000000;
    private static final int TIMESTAMP_SCALE = 1000000;
    private long infoElementStart;
    private final SeekableMuxerOutput muxerOutput;
    private final boolean sampleCopyEnabled;
    private long segmentDataStart;
    private long trackElementStart;
    private boolean writtenSegmentHeader;
    private final List<Track> addedTracks = new ArrayList();
    private final List<ByteBuffer> cuePoints = new ArrayList();
    private final SparseArray<Long> prevPresentationTimeOfTrack = new SparseArray<>();
    private long firstSampleTimestampUs = C.TIME_UNSET;
    private long lastSampleEndsAtTimestampUs = C.TIME_UNSET;

    WebmWriter(SeekableMuxerOutput seekableMuxerOutput, boolean z) {
        this.muxerOutput = seekableMuxerOutput;
        this.sampleCopyEnabled = z;
    }

    public Track addTrack(int i, Format format) {
        Preconditions.checkArgument(!this.writtenSegmentHeader);
        Track track = new Track(i, format, 1, this.sampleCopyEnabled);
        this.addedTracks.add(track);
        return track;
    }

    public void writeSampleData(Track track, ByteBuffer byteBuffer, BufferInfo bufferInfo) throws IOException {
        long jMin;
        if (!this.writtenSegmentHeader) {
            writeSegmentHeader();
            this.writtenSegmentHeader = true;
        }
        if (shouldCreateCluster(track, bufferInfo)) {
            createCluster();
        }
        track.writeSampleData(byteBuffer, bufferInfo);
        long j = this.firstSampleTimestampUs;
        if (j == C.TIME_UNSET) {
            jMin = bufferInfo.presentationTimeUs;
        } else {
            jMin = Math.min(j, bufferInfo.presentationTimeUs);
        }
        this.firstSampleTimestampUs = jMin;
        this.lastSampleEndsAtTimestampUs = Math.max(this.lastSampleEndsAtTimestampUs, bufferInfo.presentationTimeUs + (bufferInfo.presentationTimeUs - this.prevPresentationTimeOfTrack.get(track.id, Long.valueOf(bufferInfo.presentationTimeUs)).longValue()));
        this.prevPresentationTimeOfTrack.put(track.id, Long.valueOf(bufferInfo.presentationTimeUs));
    }

    private void writeSegmentHeader() throws IOException {
        this.muxerOutput.write(WebmElements.createEbmlHeaderElement());
        this.muxerOutput.write(WebmElements.uintToMinimumLengthByteBuffer(408125543L));
        this.muxerOutput.write(WebmElements.uintToMinimumLengthByteBuffer(WebmConstants.MKV_UNKNOWN_LENGTH));
        this.segmentDataStart = this.muxerOutput.getPosition();
        this.muxerOutput.write(WebmElements.createVoidElement(72));
        this.infoElementStart = this.muxerOutput.getPosition();
        this.muxerOutput.write(WebmElements.createInfoElement(0.0f));
        this.trackElementStart = this.muxerOutput.getPosition();
        this.muxerOutput.write(WebmElements.createTrackElements(this.addedTracks));
    }

    private boolean shouldCreateCluster(Track track, BufferInfo bufferInfo) {
        if (track.pendingSamplesBufferInfo.isEmpty()) {
            return false;
        }
        if (MimeTypes.isVideo(track.format.sampleMimeType)) {
            return (bufferInfo.flags & 1) > 0;
        }
        return bufferInfo.presentationTimeUs - track.pendingSamplesBufferInfo.getFirst().presentationTimeUs > 2000000;
    }

    private void createCluster() throws IOException {
        PriorityQueue priorityQueue = new PriorityQueue();
        int i = 0;
        boolean z = false;
        while (true) {
            if (i >= this.addedTracks.size()) {
                break;
            }
            Track track = this.addedTracks.get(i);
            while (!track.pendingSamplesByteBuffer.isEmpty()) {
                boolean zIsAudio = MimeTypes.isAudio(track.format.sampleMimeType);
                WebmFrame webmFrame = new WebmFrame(zIsAudio ? 2 : 1, track.pendingSamplesByteBuffer.removeFirst(), track.pendingSamplesBufferInfo.removeFirst(), zIsAudio);
                priorityQueue.add(webmFrame);
                if (!webmFrame.isAudioFrame.booleanValue() && (webmFrame.bufferInfo.flags & 1) > 0) {
                    z = true;
                }
            }
            i++;
        }
        if (priorityQueue.isEmpty()) {
            return;
        }
        WebmFrame webmFrame2 = (WebmFrame) Preconditions.checkNotNull((WebmFrame) priorityQueue.peek());
        long j = webmFrame2.bufferInfo.presentationTimeUs;
        ArrayList arrayList = new ArrayList();
        long jUsToSegmentTicks = usToSegmentTicks(j - this.firstSampleTimestampUs);
        arrayList.add(WebmElements.createUnsignedIntElement(231L, jUsToSegmentTicks));
        while (!priorityQueue.isEmpty()) {
            WebmFrame webmFrame3 = (WebmFrame) Preconditions.checkNotNull((WebmFrame) priorityQueue.poll());
            arrayList.add(WebmElements.createSimpleBlockElement(webmFrame3.trackNumber, usToSegmentTicks(webmFrame3.bufferInfo.presentationTimeUs - j), (webmFrame3.bufferInfo.flags & 1) > 0, webmFrame3.data));
        }
        long position = this.muxerOutput.getPosition() - this.segmentDataStart;
        this.muxerOutput.write(WebmElements.wrapIntoElement(524531317L, arrayList));
        this.cuePoints.add(WebmElements.createCuePointElement(jUsToSegmentTicks, z ? 1 : webmFrame2.trackNumber, position));
    }

    public void close() throws IOException {
        createCluster();
        long position = this.muxerOutput.getPosition();
        this.muxerOutput.write(WebmElements.wrapIntoElement(475249515L, this.cuePoints));
        long position2 = this.muxerOutput.getPosition();
        long j = this.segmentDataStart;
        this.muxerOutput.setPosition(j - 8);
        this.muxerOutput.write(EbmlUtils.encodeVIntWithWidth(position2 - j, 8));
        this.muxerOutput.setPosition(this.infoElementStart);
        this.muxerOutput.write(WebmElements.createInfoElement(usToSegmentTicks(this.lastSampleEndsAtTimestampUs - this.firstSampleTimestampUs)));
        Preconditions.checkState(this.muxerOutput.getPosition() == this.trackElementStart);
        this.muxerOutput.setPosition(this.segmentDataStart);
        long j2 = this.infoElementStart;
        long j3 = this.segmentDataStart;
        this.muxerOutput.write(WebmElements.createSeekHeadElement(j2 - j3, this.trackElementStart - j3, position - j3));
        this.muxerOutput.write(WebmElements.createVoidElement((int) (this.infoElementStart - this.muxerOutput.getPosition())));
    }

    private static final class WebmFrame implements Comparable<WebmFrame> {
        private final BufferInfo bufferInfo;
        private final ByteBuffer data;
        private final Boolean isAudioFrame;
        private final int trackNumber;

        WebmFrame(int i, ByteBuffer byteBuffer, BufferInfo bufferInfo, boolean z) {
            this.trackNumber = i;
            this.data = byteBuffer;
            this.bufferInfo = bufferInfo;
            this.isAudioFrame = Boolean.valueOf(z);
        }

        @Override // java.lang.Comparable
        public int compareTo(WebmFrame webmFrame) {
            int iCompare = Long.compare(this.bufferInfo.presentationTimeUs, webmFrame.bufferInfo.presentationTimeUs);
            return iCompare != 0 ? iCompare : Boolean.compare(this.isAudioFrame.booleanValue(), webmFrame.isAudioFrame.booleanValue());
        }
    }

    private long usToSegmentTicks(long j) {
        return Util.scaleLargeTimestamp(j, 1000L, 1000000L);
    }
}
