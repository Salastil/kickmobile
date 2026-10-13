package androidx.camera.camera2.pipe.media;

import android.hardware.camera2.MultiResolutionImageReader;
import android.hardware.camera2.params.MultiResolutionStreamInfo;
import android.hardware.camera2.params.OutputConfiguration;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraColorSpace$$ExternalSyntheticApiModelOutline6;
import androidx.camera.camera2.pipe.CameraOnActiveOutputSurfacesListener;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.PlatformApiCompat;
import androidx.camera.camera2.pipe.StreamFormat;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.compose.foundation.PreferKeepClearNode$$ExternalSyntheticApiModelOutline0;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.util.date.GMTDateParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;

/* JADX INFO: compiled from: AndroidImageReaders.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001FBe\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J&\u00107\u001a\u0002042\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00140\r2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0016J\b\u0010<\u001a\u000204H\u0016J\b\u0010=\u001a\u000204H\u0016J'\u0010>\u001a\u0004\u0018\u0001H?\"\b\b\u0000\u0010?*\u00020@2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0BH\u0016¢\u0006\u0002\u0010CJ\b\u0010D\u001a\u00020EH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001f0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R/\u0010%\u001a\u0004\u0018\u00010$2\b\u0010#\u001a\u0004\u0018\u00010$8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R/\u0010-\u001a\u0004\u0018\u00010,2\b\u0010#\u001a\u0004\u0018\u00010,8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010+\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006G"}, d2 = {"Landroidx/camera/camera2/pipe/media/AndroidMultiResolutionImageReader;", "Landroidx/camera/camera2/pipe/media/ImageReaderWrapper;", "Landroid/media/ImageReader$OnImageAvailableListener;", "Landroidx/camera/camera2/pipe/CameraOnActiveOutputSurfacesListener;", "multiResolutionImageReader", "Landroid/hardware/camera2/MultiResolutionImageReader;", "streamFormat", "Landroidx/camera/camera2/pipe/StreamFormat;", "capacity", "", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputConfigurations", "", "Landroid/hardware/camera2/params/OutputConfiguration;", "streamInfoToOutputIdMap", "", "Landroid/hardware/camera2/params/MultiResolutionStreamInfo;", "Landroidx/camera/camera2/pipe/OutputId;", "surfaceToOutputIdMap", "Landroid/view/Surface;", "concurrentOutputsEnabled", "", "<init>", "(Landroid/hardware/camera2/MultiResolutionImageReader;IIILjava/util/List;Ljava/util/Map;Ljava/util/Map;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "getCapacity", "()I", "getOutputConfigurations$camera_camera2_pipe", "()Ljava/util/List;", "singleOutputIdSets", "", "surface", "getSurface", "()Landroid/view/Surface;", "<set-?>", "Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnImageListener;", "onImageListener", "getOnImageListener", "()Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnImageListener;", "setOnImageListener", "(Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnImageListener;)V", "onImageListener$delegate", "Lkotlinx/atomicfu/AtomicRef;", "Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnExpectedOutputsListener;", "onExpectedOutputsListener", "getOnExpectedOutputsListener", "()Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnExpectedOutputsListener;", "setOnExpectedOutputsListener", "(Landroidx/camera/camera2/pipe/media/ImageReaderWrapper$OnExpectedOutputsListener;)V", "onExpectedOutputsListener$delegate", "onImageAvailable", "", "reader", "Landroid/media/ImageReader;", "onActiveOutputSurfaces", "activeOutputSurfaces", "timestamp", "", "frameNumber", "close", "flush", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidMultiResolutionImageReader implements ImageReaderWrapper, ImageReader.OnImageAvailableListener, CameraOnActiveOutputSurfacesListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int capacity;
    private final boolean concurrentOutputsEnabled;
    private final MultiResolutionImageReader multiResolutionImageReader;

    /* JADX INFO: renamed from: onExpectedOutputsListener$delegate, reason: from kotlin metadata */
    private final AtomicRef onExpectedOutputsListener;

    /* JADX INFO: renamed from: onImageListener$delegate, reason: from kotlin metadata */
    private final AtomicRef onImageListener;
    private final List<OutputConfiguration> outputConfigurations;
    private final Map<Surface, Set<OutputId>> singleOutputIdSets;
    private final int streamFormat;
    private final int streamId;
    private final Map<MultiResolutionStreamInfo, OutputId> streamInfoToOutputIdMap;
    private final Map<Surface, OutputId> surfaceToOutputIdMap;

    public /* synthetic */ AndroidMultiResolutionImageReader(MultiResolutionImageReader multiResolutionImageReader, int i, int i2, int i3, List list, Map map, Map map2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiResolutionImageReader, i, i2, i3, list, map, map2, z);
    }

    private AndroidMultiResolutionImageReader(MultiResolutionImageReader multiResolutionImageReader, int i, int i2, int i3, List<OutputConfiguration> outputConfigurations, Map<MultiResolutionStreamInfo, OutputId> streamInfoToOutputIdMap, Map<Surface, OutputId> surfaceToOutputIdMap, boolean z) {
        Intrinsics.checkNotNullParameter(multiResolutionImageReader, "multiResolutionImageReader");
        Intrinsics.checkNotNullParameter(outputConfigurations, "outputConfigurations");
        Intrinsics.checkNotNullParameter(streamInfoToOutputIdMap, "streamInfoToOutputIdMap");
        Intrinsics.checkNotNullParameter(surfaceToOutputIdMap, "surfaceToOutputIdMap");
        this.multiResolutionImageReader = multiResolutionImageReader;
        this.streamFormat = i;
        this.capacity = i2;
        this.streamId = i3;
        this.outputConfigurations = outputConfigurations;
        this.streamInfoToOutputIdMap = streamInfoToOutputIdMap;
        this.surfaceToOutputIdMap = surfaceToOutputIdMap;
        this.concurrentOutputsEnabled = z;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(surfaceToOutputIdMap.size()));
        Iterator<T> it = surfaceToOutputIdMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), SetsKt.setOf(entry.getValue()));
        }
        this.singleOutputIdSets = linkedHashMap;
        this.onImageListener = AtomicFU.atomic((Object) null);
        this.onExpectedOutputsListener = AtomicFU.atomic((Object) null);
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public int getCapacity() {
        return this.capacity;
    }

    public final List<OutputConfiguration> getOutputConfigurations$camera_camera2_pipe() {
        return this.outputConfigurations;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public Surface getSurface() {
        Surface surface = this.multiResolutionImageReader.getSurface();
        Intrinsics.checkNotNullExpressionValue(surface, "getSurface(...)");
        return surface;
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public ImageReaderWrapper.OnImageListener getOnImageListener() {
        return (ImageReaderWrapper.OnImageListener) this.onImageListener.getValue();
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public void setOnImageListener(ImageReaderWrapper.OnImageListener onImageListener) {
        this.onImageListener.setValue(onImageListener);
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public ImageReaderWrapper.OnExpectedOutputsListener getOnExpectedOutputsListener() {
        return (ImageReaderWrapper.OnExpectedOutputsListener) this.onExpectedOutputsListener.getValue();
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public void setOnExpectedOutputsListener(ImageReaderWrapper.OnExpectedOutputsListener onExpectedOutputsListener) {
        this.onExpectedOutputsListener.setValue(onExpectedOutputsListener);
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader reader) {
        ImageReaderWrapper.OnExpectedOutputsListener onExpectedOutputsListener;
        Image imageAcquireNextImage = reader != null ? reader.acquireNextImage() : null;
        if (imageAcquireNextImage != null) {
            ImageReaderWrapper.OnImageListener onImageListener = getOnImageListener();
            if (onImageListener == null) {
                imageAcquireNextImage.close();
                return;
            }
            MultiResolutionStreamInfo streamInfoForImageReader = this.multiResolutionImageReader.getStreamInfoForImageReader(reader);
            Intrinsics.checkNotNullExpressionValue(streamInfoForImageReader, "getStreamInfoForImageReader(...)");
            OutputId outputId = this.streamInfoToOutputIdMap.get(streamInfoForImageReader);
            if (outputId == null) {
                throw new IllegalStateException((this + ": Failed to find OutputId for " + reader + " based on streamInfo " + streamInfoForImageReader + '!').toString());
            }
            int iM577unboximpl = outputId.m577unboximpl();
            if (!this.concurrentOutputsEnabled && (onExpectedOutputsListener = getOnExpectedOutputsListener()) != null) {
                onExpectedOutputsListener.onExpectedOutputs(imageAcquireNextImage.getTimestamp(), SetsKt.setOf(OutputId.m571boximpl(iM577unboximpl)));
            }
            onImageListener.mo1057onImageAQuxepk(this.streamId, iM577unboximpl, new AndroidImage(imageAcquireNextImage));
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraOnActiveOutputSurfacesListener
    public void onActiveOutputSurfaces(List<? extends Surface> activeOutputSurfaces, long timestamp, long frameNumber) {
        Set<OutputId> set;
        Intrinsics.checkNotNullParameter(activeOutputSurfaces, "activeOutputSurfaces");
        if (activeOutputSurfaces.size() == 1) {
            Surface surface = activeOutputSurfaces.get(0);
            Set<OutputId> set2 = this.singleOutputIdSets.get(surface);
            if (set2 == null) {
                throw new IllegalStateException(("Unrecognized active surface in " + ((Object) StreamId.m796toStringimpl(this.streamId)) + ": " + surface).toString());
            }
            set = set2;
        } else {
            List<? extends Surface> list = activeOutputSurfaces;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Surface surface2 : list) {
                OutputId outputId = this.surfaceToOutputIdMap.get(surface2);
                if (outputId == null) {
                    throw new IllegalStateException(("Unrecognized active surface in " + ((Object) StreamId.m796toStringimpl(this.streamId)) + ": " + surface2).toString());
                }
                arrayList.add(OutputId.m571boximpl(outputId.m577unboximpl()));
            }
            set = CollectionsKt.toSet(arrayList);
        }
        ImageReaderWrapper.OnExpectedOutputsListener onExpectedOutputsListener = getOnExpectedOutputsListener();
        if (onExpectedOutputsListener != null) {
            onExpectedOutputsListener.onExpectedOutputs(timestamp, set);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.multiResolutionImageReader.close();
    }

    @Override // androidx.camera.camera2.pipe.media.ImageReaderWrapper
    public void flush() {
        this.multiResolutionImageReader.flush();
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(AndroidMultiResolutionImageReader.class))) {
            return (T) this;
        }
        if (Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m1678m$1()))) {
            return (T) this.multiResolutionImageReader;
        }
        return null;
    }

    public String toString() {
        String strJoinToString$default = CollectionsKt.joinToString$default(this.streamInfoToOutputIdMap.keySet(), null, "[", "]", 0, null, new Function1() { // from class: androidx.camera.camera2.pipe.media.AndroidMultiResolutionImageReader$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AndroidMultiResolutionImageReader.toString$lambda$0((MultiResolutionStreamInfo) obj);
            }
        }, 25, null);
        StringBuilder sb = new StringBuilder("MultiResolutionImageReader@");
        String string = Integer.toString(super.hashCode(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb.append(string);
        sb.append('-');
        sb.append(StreamFormat.m750getNameimpl(this.streamFormat));
        sb.append('-');
        sb.append(strJoinToString$default);
        return sb.toString();
    }

    static final CharSequence toString$lambda$0(MultiResolutionStreamInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getPhysicalCameraId() + ":w" + it.getWidth() + GMTDateParser.HOURS + it.getHeight();
    }

    /* JADX INFO: compiled from: AndroidImageReaders.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017JA\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/camera/camera2/pipe/media/AndroidMultiResolutionImageReader$Companion;", "", "<init>", "()V", "create", "Landroidx/camera/camera2/pipe/media/ImageReaderWrapper;", "outputFormat", "", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputs", "", "Landroidx/camera/camera2/pipe/OutputStream;", "capacity", "executor", "Ljava/util/concurrent/Executor;", "usageFlags", "", "enableConcurrentOutputs", "", "plaformApiCompat", "Landroidx/camera/camera2/pipe/PlatformApiCompat;", "create-wJp1_LU", "(IILjava/util/List;ILjava/util/concurrent/Executor;Ljava/lang/Long;ZLandroidx/camera/camera2/pipe/PlatformApiCompat;)Landroidx/camera/camera2/pipe/media/ImageReaderWrapper;", "cameraStream", "Landroidx/camera/camera2/pipe/CameraStream;", "platformApiCompat", "(Landroidx/camera/camera2/pipe/CameraStream;ILjava/util/concurrent/Executor;Ljava/lang/Long;ZLandroidx/camera/camera2/pipe/PlatformApiCompat;)Landroidx/camera/camera2/pipe/media/ImageReaderWrapper;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: create-wJp1_LU, reason: not valid java name */
        public final ImageReaderWrapper m1054createwJp1_LU(int outputFormat, int streamId, List<? extends OutputStream> outputs, int capacity, Executor executor, Long usageFlags, boolean enableConcurrentOutputs, PlatformApiCompat plaformApiCompat) {
            PlatformApiCompat platformApiCompat;
            MultiResolutionImageReader multiResolutionImageReaderM;
            Intrinsics.checkNotNullParameter(outputs, "outputs");
            Intrinsics.checkNotNullParameter(executor, "executor");
            if (capacity <= 0) {
                throw new IllegalArgumentException(("Capacity (" + capacity + ") must be > 0").toString());
            }
            if (capacity > 54) {
                throw new IllegalArgumentException("Capacity for creating new ImageSources is restricted to 54. Android has undocumented internal limits that are different depending on which device the MultiResolutionImageReader is created on.".toString());
            }
            if (enableConcurrentOutputs && (plaformApiCompat == null || !plaformApiCompat.isMultiResolutionConcurrentReadersEnabled())) {
                throw new IllegalArgumentException("Concurrent MultiResolutionImageReaders are not supported on this device".toString());
            }
            if (usageFlags != null && Build.VERSION.SDK_INT < 36 && Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Usage flags are only supported for API >= 36. Creating multiresolution image reader without usage flag.");
            }
            List<? extends OutputStream> list = outputs;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (OutputStream outputStream : list) {
                CameraColorSpace$$ExternalSyntheticApiModelOutline6.m274m$1();
                Pair pair = TuplesKt.to(CameraColorSpace$$ExternalSyntheticApiModelOutline6.m(outputStream.getSize().getWidth(), outputStream.getSize().getHeight(), outputStream.getCamera()), OutputId.m571boximpl(outputStream.getId()));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            Set setKeySet = linkedHashMap.keySet();
            if (plaformApiCompat != null && plaformApiCompat.isMultiResolutionConcurrentReadersEnabled()) {
                multiResolutionImageReaderM = plaformApiCompat.buildMultiResolutionImageReader(setKeySet, outputFormat, capacity, usageFlags, Boolean.valueOf(enableConcurrentOutputs));
                platformApiCompat = plaformApiCompat;
            } else {
                platformApiCompat = plaformApiCompat;
                if (usageFlags != null && Build.VERSION.SDK_INT >= 36) {
                    PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m1671m();
                    multiResolutionImageReaderM = PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m(setKeySet, outputFormat, capacity, usageFlags.longValue());
                } else {
                    PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m1671m();
                    multiResolutionImageReaderM = PreferKeepClearNode$$ExternalSyntheticApiModelOutline0.m(setKeySet, outputFormat, capacity);
                }
            }
            Collection collectionCreateInstancesForMultiResolutionOutput = OutputConfiguration.createInstancesForMultiResolutionOutput(multiResolutionImageReaderM);
            Intrinsics.checkNotNullExpressionValue(collectionCreateInstancesForMultiResolutionOutput, "createInstancesForMultiResolutionOutput(...)");
            List list2 = CollectionsKt.toList(collectionCreateInstancesForMultiResolutionOutput);
            if (list2.size() != outputs.size()) {
                throw new IllegalStateException("Check failed.");
            }
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            for (Pair pair2 : CollectionsKt.zip(list2, list)) {
                OutputConfiguration outputConfiguration = (OutputConfiguration) pair2.component1();
                OutputStream outputStream2 = (OutputStream) pair2.component2();
                Surface surface = outputConfiguration.getSurface();
                if (surface == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                mapCreateMapBuilder.put(surface, OutputId.m571boximpl(outputStream2.getId()));
            }
            AndroidMultiResolutionImageReader androidMultiResolutionImageReader = new AndroidMultiResolutionImageReader(multiResolutionImageReaderM, StreamFormat.m746constructorimpl(outputFormat), capacity, streamId, list2, linkedHashMap, MapsKt.build(mapCreateMapBuilder), enableConcurrentOutputs, null);
            if (platformApiCompat != null && platformApiCompat.isMultiResolutionConcurrentReadersEnabled() && enableConcurrentOutputs) {
                platformApiCompat.setOnActiveOutputSurfacesListener(multiResolutionImageReaderM, executor, androidMultiResolutionImageReader);
            }
            multiResolutionImageReaderM.setOnImageAvailableListener(androidMultiResolutionImageReader, executor);
            return androidMultiResolutionImageReader;
        }

        public final ImageReaderWrapper create(CameraStream cameraStream, int capacity, Executor executor, Long usageFlags, boolean enableConcurrentOutputs, PlatformApiCompat platformApiCompat) {
            Intrinsics.checkNotNullParameter(cameraStream, "cameraStream");
            Intrinsics.checkNotNullParameter(executor, "executor");
            List<OutputStream> outputs = cameraStream.getOutputs();
            if (outputs.isEmpty()) {
                throw new IllegalArgumentException((cameraStream + " outputs cannot be empty!").toString());
            }
            return m1054createwJp1_LU(((OutputStream) CollectionsKt.first((List) outputs)).getFormat(), cameraStream.getId(), outputs, capacity, executor, usageFlags, enableConcurrentOutputs, platformApiCompat);
        }
    }
}
