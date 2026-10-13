package androidx.camera.camera2.pipe.compat;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.OutputConfiguration;
import android.media.MediaCodec;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Parcelable;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.core.Log;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 (2\u00020\u0001:\u0001(B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J'\u0010 \u001a\u0004\u0018\u0001H!\"\b\b\u0000\u0010!*\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\u0016¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000f¨\u0006)"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidOutputConfiguration;", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "output", "Landroid/hardware/camera2/params/OutputConfiguration;", "surfaceSharing", "", "maxSharedSurfaceCount", "", "physicalCameraId", "Landroidx/camera/camera2/pipe/CameraId;", "<init>", "(Landroid/hardware/camera2/params/OutputConfiguration;ZILjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSurfaceSharing", "()Z", "getMaxSharedSurfaceCount", "()I", "getPhysicalCameraId-1LO98Z0", "()Ljava/lang/String;", "Ljava/lang/String;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "surfaces", "", "getSurfaces", "()Ljava/util/List;", "addSurface", "", "removeSurface", "surfaceGroupId", "getSurfaceGroupId", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidOutputConfiguration implements OutputConfigurationWrapper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int maxSharedSurfaceCount;
    private final OutputConfiguration output;
    private final String physicalCameraId;
    private final Surface surface;
    private final boolean surfaceSharing;

    public /* synthetic */ AndroidOutputConfiguration(OutputConfiguration outputConfiguration, boolean z, int i, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(outputConfiguration, z, i, str);
    }

    private AndroidOutputConfiguration(OutputConfiguration output, boolean z, int i, String str) {
        Intrinsics.checkNotNullParameter(output, "output");
        this.output = output;
        this.surfaceSharing = z;
        this.maxSharedSurfaceCount = i;
        this.physicalCameraId = str;
        this.surface = output.getSurface();
    }

    @Override // androidx.camera.camera2.pipe.compat.OutputConfigurationWrapper
    public boolean getSurfaceSharing() {
        return this.surfaceSharing;
    }

    @Override // androidx.camera.camera2.pipe.compat.OutputConfigurationWrapper
    public int getMaxSharedSurfaceCount() {
        return this.maxSharedSurfaceCount;
    }

    @Override // androidx.camera.camera2.pipe.compat.OutputConfigurationWrapper
    /* JADX INFO: renamed from: getPhysicalCameraId-1LO98Z0, reason: not valid java name and from getter */
    public String getPhysicalCameraId() {
        return this.physicalCameraId;
    }

    /* JADX INFO: compiled from: Configuration.kt */
    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u009b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010!*\u00020\u000bH\u0002J\f\u0010\"\u001a\u00020#*\u00020$H\u0002J\u001b\u0010%\u001a\u00020#*\u00020$2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Landroidx/camera/camera2/pipe/compat/AndroidOutputConfiguration$Companion;", "", "<init>", "()V", "create", "Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "surface", "Landroid/view/Surface;", "format", "", "outputType", "Landroidx/camera/camera2/pipe/OutputStream$OutputType;", "mirrorMode", "Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;", "timestampBase", "Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;", "dynamicRangeProfile", "Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;", "streamUseCase", "Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;", "sensorPixelModes", "", "Landroidx/camera/camera2/pipe/OutputStream$SensorPixelMode;", ContentDisposition.Parameters.Size, "Landroid/util/Size;", "surfaceSharing", "", "surfaceGroupId", "physicalCameraId", "Landroidx/camera/camera2/pipe/CameraId;", "create-gWWoySg", "(Landroid/view/Surface;Ljava/lang/Integer;Landroidx/camera/camera2/pipe/OutputStream$OutputType;Landroidx/camera/camera2/pipe/OutputStream$MirrorMode;Landroidx/camera/camera2/pipe/OutputStream$TimestampBase;Landroidx/camera/camera2/pipe/OutputStream$DynamicRangeProfile;Landroidx/camera/camera2/pipe/OutputStream$StreamUseCase;Ljava/util/List;Landroid/util/Size;ZILjava/lang/String;)Landroidx/camera/camera2/pipe/compat/OutputConfigurationWrapper;", "toKlass", "Ljava/lang/Class;", "enableSurfaceSharingCompat", "", "Landroid/hardware/camera2/params/OutputConfiguration;", "setPhysicalCameraIdCompat", "setPhysicalCameraIdCompat-8Ri2elo", "(Landroid/hardware/camera2/params/OutputConfiguration;Ljava/lang/String;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: create-gWWoySg$default, reason: not valid java name */
        public static /* synthetic */ OutputConfigurationWrapper m815creategWWoySg$default(Companion companion, Surface surface, Integer num, OutputStream.OutputType outputType, OutputStream.MirrorMode mirrorMode, OutputStream.TimestampBase timestampBase, OutputStream.DynamicRangeProfile dynamicRangeProfile, OutputStream.StreamUseCase streamUseCase, List list, Size size, boolean z, int i, String str, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                num = null;
            }
            if ((i2 & 4) != 0) {
                outputType = OutputStream.OutputType.INSTANCE.getSURFACE();
            }
            if ((i2 & 8) != 0) {
                mirrorMode = null;
            }
            if ((i2 & 16) != 0) {
                timestampBase = null;
            }
            if ((i2 & 32) != 0) {
                dynamicRangeProfile = null;
            }
            if ((i2 & 64) != 0) {
                streamUseCase = null;
            }
            if ((i2 & 128) != 0) {
                list = CollectionsKt.emptyList();
            }
            if ((i2 & 256) != 0) {
                size = null;
            }
            if ((i2 & 512) != 0) {
                z = false;
            }
            if ((i2 & 1024) != 0) {
                i = -1;
            }
            if ((i2 & 2048) != 0) {
                str = null;
            }
            return companion.m817creategWWoySg(surface, num, outputType, mirrorMode, timestampBase, dynamicRangeProfile, streamUseCase, list, size, z, i, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: create-gWWoySg, reason: not valid java name */
        public final OutputConfigurationWrapper m817creategWWoySg(Surface surface, Integer format, OutputStream.OutputType outputType, OutputStream.MirrorMode mirrorMode, OutputStream.TimestampBase timestampBase, OutputStream.DynamicRangeProfile dynamicRangeProfile, OutputStream.StreamUseCase streamUseCase, List<OutputStream.SensorPixelMode> sensorPixelModes, Size size, boolean surfaceSharing, int surfaceGroupId, String physicalCameraId) {
            OutputConfiguration outputConfigurationNewOutputConfiguration;
            OutputConfiguration outputConfiguration;
            OutputConfiguration outputConfiguration2;
            OutputConfiguration outputConfigurationNewImageReaderOutputConfiguration;
            Intrinsics.checkNotNullParameter(outputType, "outputType");
            Intrinsics.checkNotNullParameter(sensorPixelModes, "sensorPixelModes");
            if (!Intrinsics.areEqual(outputType, OutputStream.OutputType.INSTANCE.getSURFACE_DEFERRED_FOR_QUERY_ONLY$camera_camera2_pipe()) || Build.VERSION.SDK_INT < 35) {
                if (Intrinsics.areEqual(outputType, OutputStream.OutputType.INSTANCE.getSURFACE())) {
                    if (surface == 0) {
                        Objects.toString(OutputStream.OutputType.INSTANCE.getSURFACE());
                        throw new IllegalStateException("non-null surface!".toString());
                    }
                    try {
                        if (surfaceGroupId != -1) {
                            outputConfiguration = new OutputConfiguration(surfaceGroupId, surface);
                        } else {
                            outputConfiguration = new OutputConfiguration(surface);
                        }
                        surface = outputConfiguration;
                        outputConfiguration2 = surface;
                    } catch (Throwable th) {
                        if (!Log.INSTANCE.getWARN_LOGGABLE()) {
                            return null;
                        }
                        android.util.Log.w(Log.TAG, "Failed to create an OutputConfiguration for " + surface + '!', th);
                        return null;
                    }
                } else {
                    if (Build.VERSION.SDK_INT < 26) {
                        throw new IllegalStateException("Deferred OutputConfigurations are not supported on API " + Build.VERSION.SDK_INT + " (requires API 26)");
                    }
                    if (size == null) {
                        throw new IllegalStateException("Size must defined when creating a deferred OutputConfiguration.".toString());
                    }
                    outputConfigurationNewOutputConfiguration = Api26Compat.newOutputConfiguration(size, toKlass(outputType));
                }
            } else {
                if (format == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                if (size == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                outputConfigurationNewImageReaderOutputConfiguration = Api35Compat.newImageReaderOutputConfiguration(format.intValue(), size);
            }
            if (surfaceSharing) {
                outputConfiguration2 = outputConfigurationNewOutputConfiguration;
                outputConfiguration2 = outputConfigurationNewImageReaderOutputConfiguration;
                enableSurfaceSharingCompat(outputConfiguration2);
            }
            if (physicalCameraId != null) {
                m816setPhysicalCameraIdCompat8Ri2elo(outputConfiguration2, physicalCameraId);
            }
            if (mirrorMode != null) {
                if (Build.VERSION.SDK_INT >= 33) {
                    Api33Compat.setMirrorMode(outputConfiguration2, mirrorMode.m637unboximpl());
                } else {
                    if (!OutputStream.MirrorMode.m634equalsimpl0(mirrorMode.m637unboximpl(), OutputStream.MirrorMode.INSTANCE.m638getMIRROR_MODE_AUTODrUKqn0()) && Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Cannot set mirrorMode to a non-default value on API " + Build.VERSION.SDK_INT + ". This may result in unexpected behavior. Requested " + ((Object) OutputStream.MirrorMode.m636toStringimpl(mirrorMode.m637unboximpl())));
                    }
                }
            }
            if (timestampBase != null) {
                if (Build.VERSION.SDK_INT >= 33) {
                    Api33Compat.setTimestampBase(outputConfiguration2, timestampBase.m680unboximpl());
                } else {
                    if (!OutputStream.TimestampBase.m677equalsimpl0(timestampBase.m680unboximpl(), OutputStream.TimestampBase.INSTANCE.m682getTIMESTAMP_BASE_DEFAULT6HVI0MA()) && Log.INSTANCE.getINFO_LOGGABLE()) {
                        android.util.Log.i(Log.TAG, "The timestamp base on API " + Build.VERSION.SDK_INT + " will default to TIMESTAMP_BASE_DEFAULT, with which the camera device adjusts timestamps based on the output target. Requested " + ((Object) OutputStream.TimestampBase.m679toStringimpl(timestampBase.m680unboximpl())));
                    }
                }
            }
            if (dynamicRangeProfile != null) {
                if (Build.VERSION.SDK_INT >= 33) {
                    Api33Compat.setDynamicRangeProfile(outputConfiguration2, dynamicRangeProfile.m617unboximpl());
                } else {
                    if (!OutputStream.DynamicRangeProfile.m614equalsimpl0(dynamicRangeProfile.m617unboximpl(), OutputStream.DynamicRangeProfile.INSTANCE.m630getSTANDARDfFAQAUE()) && Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Cannot set dynamicRangeProfile to a non-default value on API " + Build.VERSION.SDK_INT + ". This may result in unexpected behavior. Requested " + ((Object) OutputStream.DynamicRangeProfile.m616toStringimpl(dynamicRangeProfile.m617unboximpl())));
                    }
                }
            }
            if (streamUseCase != null && Build.VERSION.SDK_INT >= 33) {
                Api33Compat.setStreamUseCase(outputConfiguration2, streamUseCase.m657unboximpl());
            }
            if (!sensorPixelModes.isEmpty()) {
                if (Build.VERSION.SDK_INT >= 31) {
                    Iterator<OutputStream.SensorPixelMode> it = sensorPixelModes.iterator();
                    while (it.hasNext()) {
                        Api31Compat.addSensorPixelModeUsed(outputConfiguration2, it.next().m648unboximpl());
                    }
                } else if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Cannot add sensorPixelModeUsed value on API " + Build.VERSION.SDK_INT + ". This may result in unexpected behavior. Requested " + sensorPixelModes);
                }
            }
            return new AndroidOutputConfiguration(outputConfiguration2, surfaceSharing, Build.VERSION.SDK_INT >= 28 ? Api28Compat.getMaxSharedSurfaceCount(outputConfiguration2) : 1, physicalCameraId, null);
        }

        private final Class<? extends Object> toKlass(OutputStream.OutputType outputType) {
            if (Intrinsics.areEqual(outputType, OutputStream.OutputType.INSTANCE.getSURFACE_TEXTURE())) {
                return SurfaceTexture.class;
            }
            if (Intrinsics.areEqual(outputType, OutputStream.OutputType.INSTANCE.getSURFACE_VIEW())) {
                return SurfaceHolder.class;
            }
            if (Intrinsics.areEqual(outputType, OutputStream.OutputType.INSTANCE.getMEDIA_CODEC())) {
                if (Build.VERSION.SDK_INT < 35) {
                    throw new IllegalStateException("OutputType.MEDIA_CODEC requires API 35 or higher.".toString());
                }
                return MediaCodec.class;
            }
            if (Intrinsics.areEqual(outputType, OutputStream.OutputType.INSTANCE.getMEDIA_RECORDER())) {
                if (Build.VERSION.SDK_INT < 35) {
                    throw new IllegalStateException("OutputType.MEDIA_RECORDER requires API 35 or higher.".toString());
                }
                return MediaRecorder.class;
            }
            throw new IllegalStateException("Unsupported OutputType: " + outputType);
        }

        private final void enableSurfaceSharingCompat(OutputConfiguration outputConfiguration) {
            if (Build.VERSION.SDK_INT >= 26) {
                Api26Compat.enableSurfaceSharing(outputConfiguration);
            }
        }

        /* JADX INFO: renamed from: setPhysicalCameraIdCompat-8Ri2elo, reason: not valid java name */
        private final void m816setPhysicalCameraIdCompat8Ri2elo(OutputConfiguration outputConfiguration, String str) {
            if (Build.VERSION.SDK_INT >= 28) {
                if (Build.VERSION.SDK_INT >= 28) {
                    Api28Compat.setPhysicalCameraId(outputConfiguration, str);
                }
            } else {
                throw new IllegalStateException(("physicalCameraId is not supported on API " + Build.VERSION.SDK_INT + " (requires API 28)").toString());
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.OutputConfigurationWrapper
    public Surface getSurface() {
        return this.surface;
    }

    @Override // androidx.camera.camera2.pipe.compat.OutputConfigurationWrapper
    public List<Surface> getSurfaces() {
        int i = Build.VERSION.SDK_INT;
        OutputConfiguration outputConfiguration = this.output;
        if (i >= 28) {
            return Api26Compat.getSurfaces(outputConfiguration);
        }
        return CollectionsKt.listOfNotNull(outputConfiguration.getSurface());
    }

    @Override // androidx.camera.camera2.pipe.compat.OutputConfigurationWrapper
    public int getSurfaceGroupId() {
        return this.output.getSurfaceGroupId();
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(OutputConfiguration.class))) {
            return null;
        }
        Parcelable parcelable = this.output;
        Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.AndroidOutputConfiguration.unwrapAs");
        return (T) parcelable;
    }

    public String toString() {
        return this.output.toString();
    }

    @Override // androidx.camera.camera2.pipe.compat.OutputConfigurationWrapper
    public void addSurface(Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        if (Build.VERSION.SDK_INT >= 26) {
            if (Build.VERSION.SDK_INT >= 26) {
                Api26Compat.addSurfaces(this.output, surface);
            }
        } else {
            throw new IllegalStateException(("addSurface is not supported on API " + Build.VERSION.SDK_INT + " (requires API 26)").toString());
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.OutputConfigurationWrapper
    public void removeSurface(Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        if (Build.VERSION.SDK_INT >= 28) {
            if (Build.VERSION.SDK_INT >= 28) {
                Api28Compat.removeSurface(this.output, surface);
            }
        } else {
            throw new IllegalStateException(("removeSurface is not supported on API " + Build.VERSION.SDK_INT + " (requires API 28)").toString());
        }
    }
}
