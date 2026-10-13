package androidx.camera.camera2.pipe.graph;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraController;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.CameraStreamConfigurationMap;
import androidx.camera.camera2.pipe.ImageSourceConfig;
import androidx.camera.camera2.pipe.InputStream;
import androidx.camera.camera2.pipe.InputStreamId;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.StreamFormat;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.compat.Api24Compat;
import androidx.camera.camera2.pipe.config.CameraGraphScope;
import androidx.camera.camera2.pipe.media.ImageSource;
import androidx.camera.camera2.pipe.media.ImageSources;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;

/* JADX INFO: compiled from: StreamGraphImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraGraphScope
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 V2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0005RSTUVB/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u00102\u001a\u0004\u0018\u00010\u00182\u0006\u00103\u001a\u00020\u0017H\u0096\u0002J#\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020#2\b\u00107\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u0004\u0018\u00010$2\u0006\u00106\u001a\u00020#H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u0004\u0018\u00010\u00172\u0006\u00106\u001a\u00020#¢\u0006\u0004\b?\u0010@J\u0012\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020F2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170\u001aH\u0002J\u0018\u0010H\u001a\u00020I2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010J\u001a\u00020KH\u0016J\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aH\u0002J\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aH\u0002J\b\u0010P\u001a\u00020QH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001b0\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020#0,X\u0096\u0004¢\u0006\n\n\u0002\b/\u001a\u0004\b-\u0010.R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001d¨\u0006W"}, d2 = {"Landroidx/camera/camera2/pipe/graph/StreamGraphImpl;", "Landroidx/camera/camera2/pipe/StreamGraph;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "imageSources", "Landroidx/camera/camera2/pipe/media/ImageSources;", "cameraControllerProvider", "Ljavax/inject/Provider;", "Landroidx/camera/camera2/pipe/CameraController;", "<init>", "(Landroidx/camera/camera2/pipe/CameraMetadata;Landroidx/camera/camera2/pipe/CameraGraph$Config;Landroidx/camera/camera2/pipe/media/ImageSources;Ljavax/inject/Provider;)V", "getCameraMetadata", "()Landroidx/camera/camera2/pipe/CameraMetadata;", "getGraphConfig", "()Landroidx/camera/camera2/pipe/CameraGraph$Config;", "getImageSources", "()Landroidx/camera/camera2/pipe/media/ImageSources;", "_streamMap", "", "Landroidx/camera/camera2/pipe/CameraStream$Config;", "Landroidx/camera/camera2/pipe/CameraStream;", "outputConfigs", "", "Landroidx/camera/camera2/pipe/graph/StreamGraphImpl$OutputConfig;", "getOutputConfigs$camera_camera2_pipe", "()Ljava/util/List;", "outputConfigMap", "Landroidx/camera/camera2/pipe/OutputStream;", "getOutputConfigMap$camera_camera2_pipe", "()Ljava/util/Map;", "imageSourceMap", "Landroidx/camera/camera2/pipe/StreamId;", "Landroidx/camera/camera2/pipe/media/ImageSource;", "getImageSourceMap$camera_camera2_pipe", "inputs", "Landroidx/camera/camera2/pipe/InputStream;", "getInputs", "streams", "getStreams", "streamIds", "", "getStreamIds", "()Ljava/util/Set;", "streamIds$1", "outputs", "getOutputs", "get", "config", "getOutputLatency", "Landroidx/camera/camera2/pipe/StreamGraph$OutputLatency;", "streamId", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "getOutputLatency-IL232MI", "(ILandroidx/camera/camera2/pipe/OutputId;)Landroidx/camera/camera2/pipe/StreamGraph$OutputLatency;", "getImageSource", "getImageSource-aKI5c8E", "(I)Landroidx/camera/camera2/pipe/media/ImageSource;", "getCameraStreamConfig", "getCameraStreamConfig-aKI5c8E", "(I)Landroidx/camera/camera2/pipe/CameraStream$Config;", "getOutputConfigurationOrNull", "Landroid/hardware/camera2/params/OutputConfiguration;", "outputConfig", "Landroidx/camera/camera2/pipe/OutputStream$Config;", "computeNextSurfaceGroupId", "", "readExistingGroupNumbers", "computeIfDeferredStreamsAreSupported", "", "toString", "", "sortOutputsByPreviewStream", "unsortedStreams", "sortOutputsByVideoStream", "unsortedOutputs", "close", "", "OutputConfig", "OutputStreamImpl", "InputStreamImpl", "SurfaceListener", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamGraphImpl implements StreamGraph, AutoCloseable {
    private final Map<CameraStream.Config, CameraStream> _streamMap;
    private final Provider<CameraController> cameraControllerProvider;
    private final CameraMetadata cameraMetadata;
    private final CameraGraph.Config graphConfig;
    private final Map<StreamId, ImageSource> imageSourceMap;
    private final ImageSources imageSources;
    private final List<InputStream> inputs;
    private final Map<OutputStream, OutputConfig> outputConfigMap;
    private final List<OutputConfig> outputConfigs;
    private final List<OutputStream> outputs;

    /* JADX INFO: renamed from: streamIds$1, reason: from kotlin metadata */
    private final Set<StreamId> streamIds;
    private final List<CameraStream> streams;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicInt streamIds = AtomicFU.atomic(0);
    private static final AtomicInt outputIds = AtomicFU.atomic(0);
    private static final AtomicInt inputIds = AtomicFU.atomic(0);
    private static final AtomicInt configIds = AtomicFU.atomic(0);
    private static final AtomicInt groupIds = AtomicFU.atomic(0);
    private static final List<OutputStream.OutputType> previewOutputTypes = CollectionsKt.listOf((Object[]) new OutputStream.OutputType[]{OutputStream.OutputType.INSTANCE.getSURFACE_VIEW(), OutputStream.OutputType.INSTANCE.getSURFACE_TEXTURE()});
    private static final Comparator<CameraStream> previewOutputTypesComparator = new Comparator() { // from class: androidx.camera.camera2.pipe.graph.StreamGraphImpl$special$$inlined$compareBy$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Iterator<T> it = ((CameraStream) t).getOutputs().iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Integer numValueOf = Integer.valueOf(CollectionsKt.indexOf((List<? extends OutputStream.OutputType>) StreamGraphImpl.previewOutputTypes, ((OutputStream) it.next()).getOutputType()));
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(CollectionsKt.indexOf((List<? extends OutputStream.OutputType>) StreamGraphImpl.previewOutputTypes, ((OutputStream) it.next()).getOutputType()));
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
            Iterator<T> it2 = ((CameraStream) t2).getOutputs().iterator();
            if (it2.hasNext()) {
                Integer numValueOf3 = Integer.valueOf(CollectionsKt.indexOf((List<? extends OutputStream.OutputType>) StreamGraphImpl.previewOutputTypes, ((OutputStream) it2.next()).getOutputType()));
                while (it2.hasNext()) {
                    Integer numValueOf4 = Integer.valueOf(CollectionsKt.indexOf((List<? extends OutputStream.OutputType>) StreamGraphImpl.previewOutputTypes, ((OutputStream) it2.next()).getOutputType()));
                    if (numValueOf3.compareTo(numValueOf4) < 0) {
                        numValueOf3 = numValueOf4;
                    }
                }
                return ComparisonsKt.compareValues(numValueOf, numValueOf3);
            }
            throw new NoSuchElementException();
        }
    };
    private static final List<StreamFormat> previewFormats = CollectionsKt.listOf((Object[]) new StreamFormat[]{StreamFormat.m745boximpl(StreamFormat.INSTANCE.m771getUNKNOWN8FPWQzE()), StreamFormat.m745boximpl(StreamFormat.INSTANCE.m764getPRIVATE8FPWQzE())});
    private static final Comparator<CameraStream> previewFormatComparator = new Comparator() { // from class: androidx.camera.camera2.pipe.graph.StreamGraphImpl$special$$inlined$compareBy$2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Iterator<T> it = ((CameraStream) t).getOutputs().iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Integer numValueOf = Integer.valueOf(StreamGraphImpl.previewFormats.indexOf(StreamFormat.m745boximpl(((OutputStream) it.next()).getFormat())));
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(StreamGraphImpl.previewFormats.indexOf(StreamFormat.m745boximpl(((OutputStream) it.next()).getFormat())));
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
            Iterator<T> it2 = ((CameraStream) t2).getOutputs().iterator();
            if (it2.hasNext()) {
                Integer numValueOf3 = Integer.valueOf(StreamGraphImpl.previewFormats.indexOf(StreamFormat.m745boximpl(((OutputStream) it2.next()).getFormat())));
                while (it2.hasNext()) {
                    Integer numValueOf4 = Integer.valueOf(StreamGraphImpl.previewFormats.indexOf(StreamFormat.m745boximpl(((OutputStream) it2.next()).getFormat())));
                    if (numValueOf3.compareTo(numValueOf4) < 0) {
                        numValueOf3 = numValueOf4;
                    }
                }
                return ComparisonsKt.compareValues(numValueOf, numValueOf3);
            }
            throw new NoSuchElementException();
        }
    };

    /* JADX INFO: compiled from: StreamGraphImpl.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/graph/StreamGraphImpl$SurfaceListener;", "", "onSurfaceMapUpdated", "", "surfaces", "", "Landroidx/camera/camera2/pipe/StreamId;", "Landroid/view/Surface;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SurfaceListener {
        void onSurfaceMapUpdated(Map<StreamId, ? extends Surface> surfaces);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0109  */
    @Inject
    public StreamGraphImpl(CameraMetadata cameraMetadata, CameraGraph.Config graphConfig, ImageSources imageSources, Provider<CameraController> cameraControllerProvider) {
        DefaultConstructorMarker defaultConstructorMarker;
        CameraGraph.Config config;
        ArrayList arrayListEmptyList;
        OutputStream.OutputType outputType$camera_camera2_pipe;
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        Intrinsics.checkNotNullParameter(graphConfig, "graphConfig");
        Intrinsics.checkNotNullParameter(imageSources, "imageSources");
        Intrinsics.checkNotNullParameter(cameraControllerProvider, "cameraControllerProvider");
        this.cameraMetadata = cameraMetadata;
        this.graphConfig = graphConfig;
        this.imageSources = imageSources;
        this.cameraControllerProvider = cameraControllerProvider;
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList2 = new ArrayList();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        boolean zComputeIfDeferredStreamsAreSupported = computeIfDeferredStreamsAreSupported(cameraMetadata, graphConfig);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (List<CameraStream.Config> list : graphConfig.getExclusiveStreamGroups()) {
            if (list.isEmpty()) {
                throw new IllegalStateException("Check failed.");
            }
            int iComputeNextSurfaceGroupId = computeNextSurfaceGroupId(this.graphConfig);
            for (CameraStream.Config config2 : list) {
                if (linkedHashMap3.containsKey(config2)) {
                    throw new IllegalStateException("Check failed.");
                }
                linkedHashMap3.put(config2, Integer.valueOf(iComputeNextSurfaceGroupId));
            }
        }
        Iterator<CameraStream.Config> it = this.graphConfig.getStreams().iterator();
        while (true) {
            defaultConstructorMarker = null;
            if (!it.hasNext()) {
                break;
            }
            CameraStream.Config next = it.next();
            for (OutputStream.Config config3 : next.getOutputs()) {
                if (!linkedHashMap.containsKey(config3)) {
                    int iM986nextConfigIdhoCEiqs$camera_camera2_pipe = INSTANCE.m986nextConfigIdhoCEiqs$camera_camera2_pipe();
                    Size size = config3.getSize();
                    int iM602getFormat8FPWQzE = config3.getFormat();
                    String strM600getCamera1LO98Z0 = config3.getCamera();
                    String strM385getCameraDz_R5H8 = strM600getCamera1LO98Z0 == null ? this.graphConfig.m385getCameraDz_R5H8() : strM600getCamera1LO98Z0;
                    Integer num = (Integer) linkedHashMap3.get(next);
                    if (zComputeIfDeferredStreamsAreSupported) {
                        OutputStream.Config.LazyOutputConfig lazyOutputConfig = config3 instanceof OutputStream.Config.LazyOutputConfig ? (OutputStream.Config.LazyOutputConfig) config3 : null;
                        if (lazyOutputConfig != null) {
                            outputType$camera_camera2_pipe = lazyOutputConfig.getOutputType();
                        } else {
                            outputType$camera_camera2_pipe = null;
                        }
                    } else {
                        outputType$camera_camera2_pipe = null;
                    }
                    OutputConfig outputConfig = new OutputConfig(iM986nextConfigIdhoCEiqs$camera_camera2_pipe, size, iM602getFormat8FPWQzE, strM385getCameraDz_R5H8, num, getOutputConfigurationOrNull(config3), outputType$camera_camera2_pipe, config3.getMirrorMode(), config3.getTimestampBase(), config3.getDynamicRangeProfile(), config3.getStreamUseCase(), config3.getStreamUseHint(), config3.getSensorPixelModes(), null);
                    linkedHashMap.put(config3, outputConfig);
                    arrayList.add(outputConfig);
                }
            }
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        int size2 = this.graphConfig.getStreams().size();
        int i = 0;
        while (true) {
            config = this.graphConfig;
            if (i >= size2) {
                break;
            }
            CameraStream.Config config4 = config.getStreams().get(i);
            List<OutputStream.Config> outputs = config4.getOutputs();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(outputs, 10));
            Iterator<T> it2 = outputs.iterator();
            while (it2.hasNext()) {
                Object obj = linkedHashMap.get((OutputStream.Config) it2.next());
                Intrinsics.checkNotNull(obj);
                OutputConfig outputConfig2 = (OutputConfig) obj;
                OutputStreamImpl outputStreamImpl = new OutputStreamImpl(INSTANCE.m988nextOutputId4LaLFng$camera_camera2_pipe(), outputConfig2.getSize(), outputConfig2.getFormat(), outputConfig2.getCamera(), outputConfig2.getMirrorMode(), outputConfig2.getTimestampBase(), outputConfig2.getDynamicRangeProfile(), outputConfig2.getStreamUseCase(), outputConfig2.getDeferredOutputType(), outputConfig2.getStreamUseHint(), null);
                linkedHashMap4.put(outputStreamImpl, outputConfig2);
                arrayList3.add(outputStreamImpl);
            }
            ArrayList arrayList4 = arrayList3;
            CameraStream cameraStream = new CameraStream(INSTANCE.m989nextStreamIdptHMqGs$camera_camera2_pipe(), arrayList4, defaultConstructorMarker);
            linkedHashMap2.put(config4, cameraStream);
            arrayList2.add(cameraStream);
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                ((OutputStreamImpl) it3.next()).setStream(cameraStream);
            }
            Iterator<OutputStream.Config> it4 = config4.getOutputs().iterator();
            while (it4.hasNext()) {
                Object obj2 = linkedHashMap.get(it4.next());
                Intrinsics.checkNotNull(obj2);
                ((OutputConfig) obj2).getStreamBuilder$camera_camera2_pipe().add(cameraStream);
            }
            i++;
        }
        List<InputStream.Config> input = config.getInput();
        if (input == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            List<InputStream.Config> list2 = input;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (InputStream.Config config5 : list2) {
                arrayList5.add(new InputStreamImpl(INSTANCE.m987nextInputIdm1bwn9M$camera_camera2_pipe(), config5.getMaxImages(), config5.getStreamFormat(), defaultConstructorMarker));
            }
            arrayListEmptyList = arrayList5;
        }
        this.inputs = arrayListEmptyList;
        this.streams = sortOutputsByVideoStream(sortOutputsByPreviewStream(arrayList2));
        List<CameraStream> streams = getStreams();
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(streams, 10));
        Iterator<T> it5 = streams.iterator();
        while (it5.hasNext()) {
            arrayList6.add(StreamId.m791boximpl(((CameraStream) it5.next()).getId()));
        }
        this.streamIds = CollectionsKt.toSet(arrayList6);
        this._streamMap = linkedHashMap2;
        this.outputConfigs = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.camera.camera2.pipe.graph.StreamGraphImpl$special$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Iterator<T> it6 = ((StreamGraphImpl.OutputConfig) t).getStreams().iterator();
                if (!it6.hasNext()) {
                    throw new NoSuchElementException();
                }
                Integer numValueOf = Integer.valueOf(this.this$0.getStreams().indexOf((CameraStream) it6.next()));
                while (it6.hasNext()) {
                    Integer numValueOf2 = Integer.valueOf(this.this$0.getStreams().indexOf((CameraStream) it6.next()));
                    if (numValueOf.compareTo(numValueOf2) > 0) {
                        numValueOf = numValueOf2;
                    }
                }
                Integer num2 = numValueOf;
                Iterator<T> it7 = ((StreamGraphImpl.OutputConfig) t2).getStreams().iterator();
                if (it7.hasNext()) {
                    Integer numValueOf3 = Integer.valueOf(this.this$0.getStreams().indexOf((CameraStream) it7.next()));
                    while (it7.hasNext()) {
                        Integer numValueOf4 = Integer.valueOf(this.this$0.getStreams().indexOf((CameraStream) it7.next()));
                        if (numValueOf3.compareTo(numValueOf4) > 0) {
                            numValueOf3 = numValueOf4;
                        }
                    }
                    return ComparisonsKt.compareValues(num2, numValueOf3);
                }
                throw new NoSuchElementException();
            }
        });
        this.outputConfigMap = linkedHashMap4;
        List<CameraStream> streams2 = getStreams();
        ArrayList arrayList7 = new ArrayList();
        Iterator<T> it6 = streams2.iterator();
        while (it6.hasNext()) {
            CollectionsKt.addAll(arrayList7, ((CameraStream) it6.next()).getOutputs());
        }
        this.outputs = arrayList7;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (CameraStream.Config config6 : this.graphConfig.getStreams()) {
            ImageSourceConfig imageSourceConfig = config6.getImageSourceConfig();
            if (imageSourceConfig != null) {
                CameraStream cameraStream2 = this._streamMap.get(config6);
                if (cameraStream2 == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                CameraStream cameraStream3 = cameraStream2;
                mapCreateMapBuilder.put(StreamId.m791boximpl(cameraStream3.getId()), this.imageSources.createImageSource(cameraStream3, imageSourceConfig));
            }
        }
        this.imageSourceMap = MapsKt.build(mapCreateMapBuilder);
    }

    public final CameraMetadata getCameraMetadata() {
        return this.cameraMetadata;
    }

    public final CameraGraph.Config getGraphConfig() {
        return this.graphConfig;
    }

    public final ImageSources getImageSources() {
        return this.imageSources;
    }

    public final List<OutputConfig> getOutputConfigs$camera_camera2_pipe() {
        return this.outputConfigs;
    }

    public final Map<OutputStream, OutputConfig> getOutputConfigMap$camera_camera2_pipe() {
        return this.outputConfigMap;
    }

    public final Map<StreamId, ImageSource> getImageSourceMap$camera_camera2_pipe() {
        return this.imageSourceMap;
    }

    @Override // androidx.camera.camera2.pipe.StreamGraph
    public List<InputStream> getInputs() {
        return this.inputs;
    }

    @Override // androidx.camera.camera2.pipe.StreamGraph
    public List<CameraStream> getStreams() {
        return this.streams;
    }

    @Override // androidx.camera.camera2.pipe.StreamGraph
    public Set<StreamId> getStreamIds() {
        return this.streamIds;
    }

    @Override // androidx.camera.camera2.pipe.StreamGraph
    public List<OutputStream> getOutputs() {
        return this.outputs;
    }

    @Override // androidx.camera.camera2.pipe.StreamGraph
    public CameraStream get(CameraStream.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return this._streamMap.get(config);
    }

    @Override // androidx.camera.camera2.pipe.StreamGraph
    /* JADX INFO: renamed from: getOutputLatency-IL232MI */
    public StreamGraph.OutputLatency mo787getOutputLatencyIL232MI(int streamId, OutputId outputId) {
        StreamGraph.OutputLatency outputLatencyMo304getOutputLatencyn5Pu2dI = this.cameraControllerProvider.get().mo304getOutputLatencyn5Pu2dI(StreamId.m791boximpl(streamId));
        if (outputLatencyMo304getOutputLatencyn5Pu2dI != null) {
            return outputLatencyMo304getOutputLatencyn5Pu2dI;
        }
        CameraStream cameraStream = m784getaKI5c8E(streamId);
        OutputStream outputStream = outputId != null ? m785getiYJqvbA(outputId.m577unboximpl()) : null;
        if (cameraStream == null) {
            throw new IllegalStateException(("No stream found for given streamId " + ((Object) StreamId.m796toStringimpl(streamId))).toString());
        }
        if (cameraStream.getOutputs().size() == 1) {
            outputStream = (OutputStream) CollectionsKt.single((List) cameraStream.getOutputs());
            Unit unit = Unit.INSTANCE;
        } else if (outputStream == null) {
            throw new IllegalStateException(("Output must be specified for MultiResolution use case. No output found for given outputId " + outputId).toString());
        }
        CameraStreamConfigurationMap streamConfigurationMap = CameraMetadata.INSTANCE.getStreamConfigurationMap(this.cameraMetadata);
        Long lValueOf = streamConfigurationMap != null ? Long.valueOf(streamConfigurationMap.mo4getOutputStallDurationlomOqCM(outputStream.getFormat(), outputStream.getSize())) : null;
        if (lValueOf != null) {
            return new StreamGraph.OutputLatency(lValueOf.longValue(), 0L);
        }
        return null;
    }

    @Override // androidx.camera.camera2.pipe.StreamGraph
    /* JADX INFO: renamed from: getImageSource-aKI5c8E */
    public ImageSource mo786getImageSourceaKI5c8E(int streamId) {
        return this.imageSourceMap.get(StreamId.m791boximpl(streamId));
    }

    /* JADX INFO: renamed from: getCameraStreamConfig-aKI5c8E, reason: not valid java name */
    public final CameraStream.Config m985getCameraStreamConfigaKI5c8E(int streamId) {
        Object next;
        Iterator<T> it = this._streamMap.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!StreamId.m794equalsimpl0(((CameraStream) ((Map.Entry) next).getValue()).getId(), streamId));
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (CameraStream.Config) entry.getKey();
        }
        return null;
    }

    /* JADX INFO: compiled from: StreamGraphImpl.kt */
    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010G\u001a\u00020HH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010:R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020=0\u001b8F¢\u0006\u0006\u001a\u0004\b@\u0010:R\u0011\u0010A\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0011\u0010E\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\bF\u0010D¨\u0006I"}, d2 = {"Landroidx/camera/camera2/pipe/graph/StreamGraphImpl$OutputConfig;", "", "id", "Landroidx/camera/camera2/pipe/graph/OutputConfigId;", ContentDisposition.Parameters.Size, "Landroid/util/Size;", "format", "Landroidx/camera/camera2/pipe/StreamFormat;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "groupNumber", "", "externalOutputConfig", "Landroid/hardware/camera2/params/OutputConfiguration;", "deferredOutputType", "Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "mirrorMode", "Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "timestampBase", "Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "streamUseCase", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "streamUseHint", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "sensorPixelModes", "", "Landroidx/camera/camera2/pipe/OutputStream$SensorPixelMode;", "<init>", "(ILandroid/util/Size;ILjava/lang/String;Ljava/lang/Integer;Landroid/hardware/camera2/params/OutputConfiguration;Landroidx/camera/camera2/pipe/OutputStream$OutputType;Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId-hoCEiqs", "()I", "I", "getSize", "()Landroid/util/Size;", "getFormat-8FPWQzE", "getCamera-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "getGroupNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExternalOutputConfig", "()Landroid/hardware/camera2/params/OutputConfiguration;", "getDeferredOutputType", "()Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "getMirrorMode-dO1_9xk", "()Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "getTimestampBase-pcPfPbY", "()Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "getDynamicRangeProfile-OoVcG5w", "()Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "getStreamUseCase-8x2ez34", "()Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "getStreamUseHint-HIPxoCc", "()Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "getSensorPixelModes", "()Ljava/util/List;", "streamBuilder", "", "Landroidx/camera/camera2/pipe/CameraStream;", "getStreamBuilder$camera_camera2_pipe", "streams", "getStreams", "deferrable", "", "getDeferrable", "()Z", "surfaceSharing", "getSurfaceSharing", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OutputConfig {
        private final String camera;
        private final OutputStream.OutputType deferredOutputType;
        private final OutputStream.DynamicRangeProfile dynamicRangeProfile;
        private final OutputConfiguration externalOutputConfig;
        private final int format;
        private final Integer groupNumber;
        private final int id;
        private final OutputStream.MirrorMode mirrorMode;
        private final List<OutputStream.SensorPixelMode> sensorPixelModes;
        private final Size size;
        private final List<CameraStream> streamBuilder;
        private final OutputStream.StreamUseCase streamUseCase;
        private final OutputStream.StreamUseHint streamUseHint;
        private final OutputStream.TimestampBase timestampBase;

        public /* synthetic */ OutputConfig(int i, Size size, int i2, String str, Integer num, OutputConfiguration outputConfiguration, OutputStream.OutputType outputType, OutputStream.MirrorMode mirrorMode, OutputStream.TimestampBase timestampBase, OutputStream.DynamicRangeProfile dynamicRangeProfile, OutputStream.StreamUseCase streamUseCase, OutputStream.StreamUseHint streamUseHint, List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, size, i2, str, num, outputConfiguration, outputType, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, streamUseHint, list);
        }

        private OutputConfig(int i, Size size, int i2, String camera, Integer num, OutputConfiguration outputConfiguration, OutputStream.OutputType outputType, OutputStream.MirrorMode mirrorMode, OutputStream.TimestampBase timestampBase, OutputStream.DynamicRangeProfile dynamicRangeProfile, OutputStream.StreamUseCase streamUseCase, OutputStream.StreamUseHint streamUseHint, List<OutputStream.SensorPixelMode> sensorPixelModes) {
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(camera, "camera");
            Intrinsics.checkNotNullParameter(sensorPixelModes, "sensorPixelModes");
            this.id = i;
            this.size = size;
            this.format = i2;
            this.camera = camera;
            this.groupNumber = num;
            this.externalOutputConfig = outputConfiguration;
            this.deferredOutputType = outputType;
            this.mirrorMode = mirrorMode;
            this.timestampBase = timestampBase;
            this.dynamicRangeProfile = dynamicRangeProfile;
            this.streamUseCase = streamUseCase;
            this.streamUseHint = streamUseHint;
            this.sensorPixelModes = sensorPixelModes;
            this.streamBuilder = new ArrayList();
        }

        /* JADX INFO: renamed from: getId-hoCEiqs, reason: not valid java name and from getter */
        public final int getId() {
            return this.id;
        }

        public final Size getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: getFormat-8FPWQzE, reason: not valid java name and from getter */
        public final int getFormat() {
            return this.format;
        }

        /* JADX INFO: renamed from: getCamera-Dz_R5H8, reason: not valid java name and from getter */
        public final String getCamera() {
            return this.camera;
        }

        public final Integer getGroupNumber() {
            return this.groupNumber;
        }

        public final OutputConfiguration getExternalOutputConfig() {
            return this.externalOutputConfig;
        }

        public final OutputStream.OutputType getDeferredOutputType() {
            return this.deferredOutputType;
        }

        /* JADX INFO: renamed from: getMirrorMode-dO1_9xk, reason: not valid java name and from getter */
        public final OutputStream.MirrorMode getMirrorMode() {
            return this.mirrorMode;
        }

        /* JADX INFO: renamed from: getTimestampBase-pcPfPbY, reason: not valid java name and from getter */
        public final OutputStream.TimestampBase getTimestampBase() {
            return this.timestampBase;
        }

        /* JADX INFO: renamed from: getDynamicRangeProfile-OoVcG5w, reason: not valid java name and from getter */
        public final OutputStream.DynamicRangeProfile getDynamicRangeProfile() {
            return this.dynamicRangeProfile;
        }

        /* JADX INFO: renamed from: getStreamUseCase-8x2ez34, reason: not valid java name and from getter */
        public final OutputStream.StreamUseCase getStreamUseCase() {
            return this.streamUseCase;
        }

        /* JADX INFO: renamed from: getStreamUseHint-HIPxoCc, reason: not valid java name and from getter */
        public final OutputStream.StreamUseHint getStreamUseHint() {
            return this.streamUseHint;
        }

        public final List<OutputStream.SensorPixelMode> getSensorPixelModes() {
            return this.sensorPixelModes;
        }

        public final List<CameraStream> getStreamBuilder$camera_camera2_pipe() {
            return this.streamBuilder;
        }

        public final List<CameraStream> getStreams() {
            return this.streamBuilder;
        }

        public final boolean getDeferrable() {
            return this.deferredOutputType != null;
        }

        public final boolean getSurfaceSharing() {
            return this.streamBuilder.size() > 1;
        }

        public String toString() {
            return OutputConfigId.m971toStringimpl(this.id);
        }
    }

    /* JADX INFO: compiled from: StreamGraphImpl.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\b\u00103\u001a\u000204H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00065"}, d2 = {"Landroidx/camera/camera2/pipe/graph/StreamGraphImpl$OutputStreamImpl;", "Landroidx/camera/camera2/pipe/OutputStream;", "id", "Landroidx/camera/camera2/pipe/OutputId;", ContentDisposition.Parameters.Size, "Landroid/util/Size;", "format", "Landroidx/camera/camera2/pipe/StreamFormat;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "mirrorMode", "Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "timestampBase", "Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "streamUseCase", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "outputType", "Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "streamUseHint", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "<init>", "(ILandroid/util/Size;ILjava/lang/String;Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;Landroidx/camera/camera2/pipe/OutputStream$OutputType;Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId-4LaLFng", "()I", "I", "getSize", "()Landroid/util/Size;", "getFormat-8FPWQzE", "getCamera-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "getMirrorMode-dO1_9xk", "()Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "getTimestampBase-pcPfPbY", "()Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "getDynamicRangeProfile-OoVcG5w", "()Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "getStreamUseCase-8x2ez34", "()Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "getOutputType", "()Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "getStreamUseHint-HIPxoCc", "()Landroidx/camera/camera2/pipe/OutputStream$StreamUseHint;", "stream", "Landroidx/camera/camera2/pipe/CameraStream;", "getStream", "()Landroidx/camera/camera2/pipe/CameraStream;", "setStream", "(Landroidx/camera/camera2/pipe/CameraStream;)V", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OutputStreamImpl implements OutputStream {
        private final String camera;
        private final OutputStream.DynamicRangeProfile dynamicRangeProfile;
        private final int format;
        private final int id;
        private final OutputStream.MirrorMode mirrorMode;
        private final OutputStream.OutputType outputType;
        private final Size size;
        public CameraStream stream;
        private final OutputStream.StreamUseCase streamUseCase;
        private final OutputStream.StreamUseHint streamUseHint;
        private final OutputStream.TimestampBase timestampBase;

        public /* synthetic */ OutputStreamImpl(int i, Size size, int i2, String str, OutputStream.MirrorMode mirrorMode, OutputStream.TimestampBase timestampBase, OutputStream.DynamicRangeProfile dynamicRangeProfile, OutputStream.StreamUseCase streamUseCase, OutputStream.OutputType outputType, OutputStream.StreamUseHint streamUseHint, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, size, i2, str, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, outputType, streamUseHint);
        }

        private OutputStreamImpl(int i, Size size, int i2, String camera, OutputStream.MirrorMode mirrorMode, OutputStream.TimestampBase timestampBase, OutputStream.DynamicRangeProfile dynamicRangeProfile, OutputStream.StreamUseCase streamUseCase, OutputStream.OutputType outputType, OutputStream.StreamUseHint streamUseHint) {
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(camera, "camera");
            this.id = i;
            this.size = size;
            this.format = i2;
            this.camera = camera;
            this.mirrorMode = mirrorMode;
            this.timestampBase = timestampBase;
            this.dynamicRangeProfile = dynamicRangeProfile;
            this.streamUseCase = streamUseCase;
            this.outputType = outputType;
            this.streamUseHint = streamUseHint;
        }

        public /* synthetic */ OutputStreamImpl(int i, Size size, int i2, String str, OutputStream.MirrorMode mirrorMode, OutputStream.TimestampBase timestampBase, OutputStream.DynamicRangeProfile dynamicRangeProfile, OutputStream.StreamUseCase streamUseCase, OutputStream.OutputType outputType, OutputStream.StreamUseHint streamUseHint, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, size, i2, str, (i3 & 16) != 0 ? null : mirrorMode, (i3 & 32) != 0 ? null : timestampBase, (i3 & 64) != 0 ? null : dynamicRangeProfile, (i3 & 128) != 0 ? null : streamUseCase, (i3 & 256) != 0 ? null : outputType, (i3 & 512) != 0 ? null : streamUseHint, null);
        }

        @Override // androidx.camera.camera2.pipe.OutputStream
        /* JADX INFO: renamed from: getId-4LaLFng, reason: from getter */
        public int getId() {
            return this.id;
        }

        @Override // androidx.camera.camera2.pipe.OutputStream
        public Size getSize() {
            return this.size;
        }

        @Override // androidx.camera.camera2.pipe.OutputStream
        /* JADX INFO: renamed from: getFormat-8FPWQzE, reason: from getter */
        public int getFormat() {
            return this.format;
        }

        @Override // androidx.camera.camera2.pipe.OutputStream
        /* JADX INFO: renamed from: getCamera-Dz_R5H8, reason: from getter */
        public String getCamera() {
            return this.camera;
        }

        @Override // androidx.camera.camera2.pipe.OutputStream
        /* JADX INFO: renamed from: getMirrorMode-dO1_9xk, reason: from getter */
        public OutputStream.MirrorMode getMirrorMode() {
            return this.mirrorMode;
        }

        @Override // androidx.camera.camera2.pipe.OutputStream
        /* JADX INFO: renamed from: getTimestampBase-pcPfPbY, reason: from getter */
        public OutputStream.TimestampBase getTimestampBase() {
            return this.timestampBase;
        }

        @Override // androidx.camera.camera2.pipe.OutputStream
        /* JADX INFO: renamed from: getDynamicRangeProfile-OoVcG5w, reason: from getter */
        public OutputStream.DynamicRangeProfile getDynamicRangeProfile() {
            return this.dynamicRangeProfile;
        }

        @Override // androidx.camera.camera2.pipe.OutputStream
        /* JADX INFO: renamed from: getStreamUseCase-8x2ez34, reason: from getter */
        public OutputStream.StreamUseCase getStreamUseCase() {
            return this.streamUseCase;
        }

        @Override // androidx.camera.camera2.pipe.OutputStream
        public OutputStream.OutputType getOutputType() {
            return this.outputType;
        }

        @Override // androidx.camera.camera2.pipe.OutputStream
        /* JADX INFO: renamed from: getStreamUseHint-HIPxoCc, reason: from getter */
        public OutputStream.StreamUseHint getStreamUseHint() {
            return this.streamUseHint;
        }

        @Override // androidx.camera.camera2.pipe.OutputStream
        public CameraStream getStream() {
            CameraStream cameraStream = this.stream;
            if (cameraStream != null) {
                return cameraStream;
            }
            Intrinsics.throwUninitializedPropertyAccessException("stream");
            return null;
        }

        public void setStream(CameraStream cameraStream) {
            Intrinsics.checkNotNullParameter(cameraStream, "<set-?>");
            this.stream = cameraStream;
        }

        public String toString() {
            return OutputId.m576toStringimpl(getId());
        }
    }

    /* JADX INFO: compiled from: StreamGraphImpl.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/pipe/graph/StreamGraphImpl$InputStreamImpl;", "Landroidx/camera/camera2/pipe/InputStream;", "id", "Landroidx/camera/camera2/pipe/InputStreamId;", "maxImages", "", "format", "Landroidx/camera/camera2/pipe/StreamFormat;", "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId-m1bwn9M", "()I", "I", "getMaxImages", "getFormat-8FPWQzE", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class InputStreamImpl implements InputStream {
        private final int format;
        private final int id;
        private final int maxImages;

        public /* synthetic */ InputStreamImpl(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, i3);
        }

        private InputStreamImpl(int i, int i2, int i3) {
            this.id = i;
            this.maxImages = i2;
            this.format = i3;
        }

        @Override // androidx.camera.camera2.pipe.InputStream
        /* JADX INFO: renamed from: getId-m1bwn9M, reason: from getter */
        public int getId() {
            return this.id;
        }

        @Override // androidx.camera.camera2.pipe.InputStream
        public int getMaxImages() {
            return this.maxImages;
        }

        @Override // androidx.camera.camera2.pipe.InputStream
        /* JADX INFO: renamed from: getFormat-8FPWQzE, reason: from getter */
        public int getFormat() {
            return this.format;
        }
    }

    private final OutputConfiguration getOutputConfigurationOrNull(OutputStream.Config outputConfig) {
        if (Build.VERSION.SDK_INT >= 33) {
            OutputStream.Config.ExternalOutputConfig externalOutputConfig = outputConfig instanceof OutputStream.Config.ExternalOutputConfig ? (OutputStream.Config.ExternalOutputConfig) outputConfig : null;
            if (externalOutputConfig != null) {
                return externalOutputConfig.getOutput();
            }
        }
        return null;
    }

    private final int computeNextSurfaceGroupId(CameraGraph.Config graphConfig) {
        List<Integer> existingGroupNumbers = readExistingGroupNumbers(graphConfig.getStreams());
        int iNextGroupId$camera_camera2_pipe = INSTANCE.nextGroupId$camera_camera2_pipe();
        while (existingGroupNumbers.contains(Integer.valueOf(iNextGroupId$camera_camera2_pipe))) {
            iNextGroupId$camera_camera2_pipe = INSTANCE.nextGroupId$camera_camera2_pipe();
        }
        return iNextGroupId$camera_camera2_pipe;
    }

    private final List<Integer> readExistingGroupNumbers(List<CameraStream.Config> outputs) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = outputs.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((CameraStream.Config) it.next()).getOutputs());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof OutputStream.Config.ExternalOutputConfig) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            int surfaceGroupId = Api24Compat.getSurfaceGroupId(((OutputStream.Config.ExternalOutputConfig) it2.next()).getOutput());
            if (!arrayList3.contains(Integer.valueOf(surfaceGroupId))) {
                arrayList3.add(Integer.valueOf(surfaceGroupId));
            }
        }
        return arrayList3;
    }

    private final boolean computeIfDeferredStreamsAreSupported(CameraMetadata cameraMetadata, CameraGraph.Config graphConfig) {
        if (Build.VERSION.SDK_INT < 26 || !CameraGraph.OperatingMode.m410equalsimpl0(graphConfig.m389getSessionMode2uNL3no(), CameraGraph.OperatingMode.INSTANCE.m417getNORMAL2uNL3no()) || CameraMetadata.INSTANCE.isHardwareLevelLegacy(cameraMetadata) || CameraMetadata.INSTANCE.isHardwareLevelLimited(cameraMetadata)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 28 || !CameraMetadata.INSTANCE.isHardwareLevelExternal(cameraMetadata);
    }

    public String toString() {
        return "StreamGraph(" + this._streamMap + ')';
    }

    private final List<CameraStream> sortOutputsByPreviewStream(List<CameraStream> unsortedStreams) {
        List<CameraStream> list = unsortedStreams;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            List<OutputStream> outputs = ((CameraStream) obj).getOutputs();
            if (!(outputs instanceof Collection) || !outputs.isEmpty()) {
                Iterator<T> it = outputs.iterator();
                while (true) {
                    if (it.hasNext()) {
                        OutputStream.StreamUseCase streamUseCase = ((OutputStream) it.next()).getStreamUseCase();
                        if (streamUseCase == null ? false : OutputStream.StreamUseCase.m654equalsimpl0(streamUseCase.m657unboximpl(), OutputStream.StreamUseCase.INSTANCE.m660getPREVIEWvrKr8v8())) {
                            arrayList.add(obj);
                            break;
                        }
                    }
                }
            }
            arrayList2.add(obj);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list2 = (List) pair.component1();
        List list3 = (List) pair.component2();
        List list4 = list2;
        if (!list4.isEmpty()) {
            return CollectionsKt.plus((Collection) list4, (Iterable) list3);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list) {
            List<OutputStream> outputs2 = ((CameraStream) obj2).getOutputs();
            if (!(outputs2 instanceof Collection) || !outputs2.isEmpty()) {
                Iterator<T> it2 = outputs2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (CollectionsKt.contains(previewOutputTypes, ((OutputStream) it2.next()).getOutputType())) {
                            arrayList3.add(obj2);
                            break;
                        }
                    }
                }
            }
            arrayList4.add(obj2);
        }
        Pair pair2 = new Pair(arrayList3, arrayList4);
        List list5 = (List) pair2.component1();
        List list6 = (List) pair2.component2();
        if (!list5.isEmpty()) {
            return CollectionsKt.plus((Collection) CollectionsKt.sortedWith(list5, previewOutputTypesComparator), (Iterable) list6);
        }
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        for (Object obj3 : list) {
            List<OutputStream> outputs3 = ((CameraStream) obj3).getOutputs();
            if (!(outputs3 instanceof Collection) || !outputs3.isEmpty()) {
                Iterator<T> it3 = outputs3.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (previewFormats.contains(StreamFormat.m745boximpl(((OutputStream) it3.next()).getFormat()))) {
                            arrayList5.add(obj3);
                            break;
                        }
                    }
                }
            }
            arrayList6.add(obj3);
        }
        Pair pair3 = new Pair(arrayList5, arrayList6);
        List list7 = (List) pair3.component1();
        return !list7.isEmpty() ? CollectionsKt.plus((Collection) CollectionsKt.sortedWith(list7, previewFormatComparator), (Iterable) pair3.component2()) : unsortedStreams;
    }

    private final List<CameraStream> sortOutputsByVideoStream(List<CameraStream> unsortedOutputs) {
        List<CameraStream> list = unsortedOutputs;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            List<OutputStream> outputs = ((CameraStream) obj).getOutputs();
            if (!(outputs instanceof Collection) || !outputs.isEmpty()) {
                Iterator<T> it = outputs.iterator();
                while (true) {
                    if (it.hasNext()) {
                        OutputStream.StreamUseCase streamUseCase = ((OutputStream) it.next()).getStreamUseCase();
                        if (streamUseCase == null ? false : OutputStream.StreamUseCase.m654equalsimpl0(streamUseCase.m657unboximpl(), OutputStream.StreamUseCase.INSTANCE.m664getVIDEO_RECORDvrKr8v8())) {
                            arrayList.add(obj);
                            break;
                        }
                    }
                }
            }
            arrayList2.add(obj);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list2 = (List) pair.component1();
        List list3 = (List) pair.component2();
        if (!list2.isEmpty()) {
            return CollectionsKt.plus((Collection) list3, (Iterable) list2);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list) {
            List<OutputStream> outputs2 = ((CameraStream) obj2).getOutputs();
            if (!(outputs2 instanceof Collection) || !outputs2.isEmpty()) {
                Iterator<T> it2 = outputs2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        OutputStream.StreamUseHint streamUseHint = ((OutputStream) it2.next()).getStreamUseHint();
                        if (streamUseHint == null ? false : OutputStream.StreamUseHint.m668equalsimpl0(streamUseHint.m671unboximpl(), OutputStream.StreamUseHint.INSTANCE.m673getVIDEO_RECORD4VYZOf8())) {
                            arrayList3.add(obj2);
                            break;
                        }
                    }
                }
            }
            arrayList4.add(obj2);
        }
        Pair pair2 = new Pair(arrayList3, arrayList4);
        List list4 = (List) pair2.component1();
        return !list4.isEmpty() ? CollectionsKt.plus((Collection) pair2.component2(), (Iterable) list4) : unsortedOutputs;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        Iterator<ImageSource> it = this.imageSourceMap.values().iterator();
        while (it.hasNext()) {
            UByte$$ExternalSyntheticBackport0.m12761m((Object) it.next());
        }
    }

    /* JADX INFO: compiled from: StreamGraphImpl.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0015\u0010\tJ\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/camera/camera2/pipe/graph/StreamGraphImpl$Companion;", "", "<init>", "()V", "streamIds", "Lkotlinx/atomicfu/AtomicInt;", "nextStreamId", "Landroidx/camera/camera2/pipe/StreamId;", "nextStreamId-ptHMqGs$camera_camera2_pipe", "()I", "outputIds", "nextOutputId", "Landroidx/camera/camera2/pipe/OutputId;", "nextOutputId-4LaLFng$camera_camera2_pipe", "inputIds", "nextInputId", "Landroidx/camera/camera2/pipe/InputStreamId;", "nextInputId-m1bwn9M$camera_camera2_pipe", "configIds", "nextConfigId", "Landroidx/camera/camera2/pipe/graph/OutputConfigId;", "nextConfigId-hoCEiqs$camera_camera2_pipe", "groupIds", "nextGroupId", "", "nextGroupId$camera_camera2_pipe", "previewOutputTypes", "", "Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "previewOutputTypesComparator", "Ljava/util/Comparator;", "Landroidx/camera/camera2/pipe/CameraStream;", "Lkotlin/Comparator;", "previewFormats", "Landroidx/camera/camera2/pipe/StreamFormat;", "previewFormatComparator", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: nextStreamId-ptHMqGs$camera_camera2_pipe, reason: not valid java name */
        public final int m989nextStreamIdptHMqGs$camera_camera2_pipe() {
            return StreamId.m792constructorimpl(StreamGraphImpl.streamIds.incrementAndGet());
        }

        /* JADX INFO: renamed from: nextOutputId-4LaLFng$camera_camera2_pipe, reason: not valid java name */
        public final int m988nextOutputId4LaLFng$camera_camera2_pipe() {
            return OutputId.m572constructorimpl(StreamGraphImpl.outputIds.incrementAndGet());
        }

        /* JADX INFO: renamed from: nextInputId-m1bwn9M$camera_camera2_pipe, reason: not valid java name */
        public final int m987nextInputIdm1bwn9M$camera_camera2_pipe() {
            return InputStreamId.m552constructorimpl(StreamGraphImpl.inputIds.incrementAndGet());
        }

        /* JADX INFO: renamed from: nextConfigId-hoCEiqs$camera_camera2_pipe, reason: not valid java name */
        public final int m986nextConfigIdhoCEiqs$camera_camera2_pipe() {
            return OutputConfigId.m967constructorimpl(StreamGraphImpl.configIds.incrementAndGet());
        }

        public final int nextGroupId$camera_camera2_pipe() {
            return StreamGraphImpl.groupIds.incrementAndGet();
        }
    }
}
