package androidx.camera.video;

import android.util.LruCache;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.AdapterCameraInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.encoder.VideoEncoderInfoImpl;
import com.datadog.trace.api.DDSpanTypes;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EncoderProfilesResolverFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0002R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014²\u0006\n\u0010\u0010\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"Landroidx/camera/video/EncoderProfilesResolverFactory;", "", "<init>", "()V", DDSpanTypes.CACHE, "Landroid/util/LruCache;", "Landroidx/camera/video/EncoderProfilesResolverFactory$CacheKey;", "Landroidx/camera/video/EncoderProfilesResolver;", "getResolver", "cameraInfo", "Landroidx/camera/core/CameraInfo;", "videoRecordingType", "", "videoCapabilitiesSource", "videoEncoderInfoFinder", "Landroidx/camera/video/internal/encoder/VideoEncoderInfo$Finder;", "createResolver", "shouldSkipCache", "", "CacheKey", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EncoderProfilesResolverFactory {
    public static final EncoderProfilesResolverFactory INSTANCE = new EncoderProfilesResolverFactory();
    private static final LruCache<CacheKey, EncoderProfilesResolver> cache = new LruCache<>(16);

    private EncoderProfilesResolverFactory() {
    }

    public static /* synthetic */ EncoderProfilesResolver getResolver$default(CameraInfo cameraInfo, int i, int i2, VideoEncoderInfo.Finder finder, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 1;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        if ((i3 & 8) != 0) {
            finder = VideoEncoderInfoImpl.FINDER;
        }
        return getResolver(cameraInfo, i, i2, finder);
    }

    @JvmStatic
    public static final EncoderProfilesResolver getResolver(final CameraInfo cameraInfo, final int videoRecordingType, final int videoCapabilitiesSource, final VideoEncoderInfo.Finder videoEncoderInfoFinder) {
        EncoderProfilesResolver resolver$lambda$1;
        Intrinsics.checkNotNullParameter(cameraInfo, "cameraInfo");
        Intrinsics.checkNotNullParameter(videoEncoderInfoFinder, "videoEncoderInfoFinder");
        Lazy lazy = LazyKt.lazy(new Function0() { // from class: androidx.camera.video.EncoderProfilesResolverFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EncoderProfilesResolverFactory.INSTANCE.createResolver(cameraInfo, videoRecordingType, videoCapabilitiesSource, videoEncoderInfoFinder);
            }
        });
        if (INSTANCE.shouldSkipCache(cameraInfo)) {
            return getResolver$lambda$1(lazy);
        }
        AdapterCameraInfo adapterCameraInfo = (AdapterCameraInfo) cameraInfo;
        String cameraId = adapterCameraInfo.getCameraId();
        Intrinsics.checkNotNullExpressionValue(cameraId, "getCameraId(...)");
        CameraConfig cameraConfig = adapterCameraInfo.getCameraConfig();
        Intrinsics.checkNotNullExpressionValue(cameraConfig, "getCameraConfig(...)");
        CacheKey cacheKey = new CacheKey(cameraId, cameraConfig, videoRecordingType, videoCapabilitiesSource, videoEncoderInfoFinder);
        LruCache<CacheKey, EncoderProfilesResolver> lruCache = cache;
        synchronized (lruCache) {
            resolver$lambda$1 = lruCache.get(cacheKey);
            if (resolver$lambda$1 == null) {
                resolver$lambda$1 = getResolver$lambda$1(lazy);
                lruCache.put(cacheKey, resolver$lambda$1);
            }
        }
        return resolver$lambda$1;
    }

    private static final EncoderProfilesResolver getResolver$lambda$1(Lazy<EncoderProfilesResolver> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EncoderProfilesResolver createResolver(CameraInfo cameraInfo, int videoRecordingType, int videoCapabilitiesSource, VideoEncoderInfo.Finder videoEncoderInfoFinder) {
        Intrinsics.checkNotNull(cameraInfo, "null cannot be cast to non-null type androidx.camera.core.impl.CameraInfoInternal");
        CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) cameraInfo;
        int i = videoRecordingType != 2 ? 1 : 2;
        EncoderProfilesProvider encoderProfilesProviderResolve = EncoderProfilesProviderResolver.INSTANCE.resolve(cameraInfoInternal, videoCapabilitiesSource, i, videoEncoderInfoFinder);
        Set<DynamicRange> supportedDynamicRanges = cameraInfoInternal.getSupportedDynamicRanges();
        Intrinsics.checkNotNullExpressionValue(supportedDynamicRanges, "getSupportedDynamicRanges(...)");
        return new EncoderProfilesResolver(encoderProfilesProviderResolve, i, supportedDynamicRanges);
    }

    private final boolean shouldSkipCache(CameraInfo cameraInfo) {
        if (cameraInfo instanceof AdapterCameraInfo) {
            AdapterCameraInfo adapterCameraInfo = (AdapterCameraInfo) cameraInfo;
            if (!adapterCameraInfo.isExternalCamera() && adapterCameraInfo.getLensFacing() != -1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: compiled from: EncoderProfilesResolverFactory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Landroidx/camera/video/EncoderProfilesResolverFactory$CacheKey;", "", "cameraId", "", "cameraConfig", "videoRecordingType", "", "videoCapabilitiesSource", "videoEncoderInfoFinder", "Landroidx/camera/video/internal/encoder/VideoEncoderInfo$Finder;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;IILandroidx/camera/video/internal/encoder/VideoEncoderInfo$Finder;)V", "getCameraId", "()Ljava/lang/String;", "getCameraConfig", "()Ljava/lang/Object;", "getVideoRecordingType", "()I", "getVideoCapabilitiesSource", "getVideoEncoderInfoFinder", "()Landroidx/camera/video/internal/encoder/VideoEncoderInfo$Finder;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class CacheKey {
        private final Object cameraConfig;
        private final String cameraId;
        private final int videoCapabilitiesSource;
        private final VideoEncoderInfo.Finder videoEncoderInfoFinder;
        private final int videoRecordingType;

        public static /* synthetic */ CacheKey copy$default(CacheKey cacheKey, String str, Object obj, int i, int i2, VideoEncoderInfo.Finder finder, int i3, Object obj2) {
            if ((i3 & 1) != 0) {
                str = cacheKey.cameraId;
            }
            if ((i3 & 2) != 0) {
                obj = cacheKey.cameraConfig;
            }
            if ((i3 & 4) != 0) {
                i = cacheKey.videoRecordingType;
            }
            if ((i3 & 8) != 0) {
                i2 = cacheKey.videoCapabilitiesSource;
            }
            if ((i3 & 16) != 0) {
                finder = cacheKey.videoEncoderInfoFinder;
            }
            VideoEncoderInfo.Finder finder2 = finder;
            int i4 = i;
            return cacheKey.copy(str, obj, i4, i2, finder2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCameraId() {
            return this.cameraId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Object getCameraConfig() {
            return this.cameraConfig;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getVideoRecordingType() {
            return this.videoRecordingType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getVideoCapabilitiesSource() {
            return this.videoCapabilitiesSource;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final VideoEncoderInfo.Finder getVideoEncoderInfoFinder() {
            return this.videoEncoderInfoFinder;
        }

        public final CacheKey copy(String cameraId, Object cameraConfig, int videoRecordingType, int videoCapabilitiesSource, VideoEncoderInfo.Finder videoEncoderInfoFinder) {
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            Intrinsics.checkNotNullParameter(cameraConfig, "cameraConfig");
            Intrinsics.checkNotNullParameter(videoEncoderInfoFinder, "videoEncoderInfoFinder");
            return new CacheKey(cameraId, cameraConfig, videoRecordingType, videoCapabilitiesSource, videoEncoderInfoFinder);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) other;
            return Intrinsics.areEqual(this.cameraId, cacheKey.cameraId) && Intrinsics.areEqual(this.cameraConfig, cacheKey.cameraConfig) && this.videoRecordingType == cacheKey.videoRecordingType && this.videoCapabilitiesSource == cacheKey.videoCapabilitiesSource && Intrinsics.areEqual(this.videoEncoderInfoFinder, cacheKey.videoEncoderInfoFinder);
        }

        public int hashCode() {
            return (((((((this.cameraId.hashCode() * 31) + this.cameraConfig.hashCode()) * 31) + Integer.hashCode(this.videoRecordingType)) * 31) + Integer.hashCode(this.videoCapabilitiesSource)) * 31) + this.videoEncoderInfoFinder.hashCode();
        }

        public String toString() {
            return "CacheKey(cameraId=" + this.cameraId + ", cameraConfig=" + this.cameraConfig + ", videoRecordingType=" + this.videoRecordingType + ", videoCapabilitiesSource=" + this.videoCapabilitiesSource + ", videoEncoderInfoFinder=" + this.videoEncoderInfoFinder + ')';
        }

        public CacheKey(String cameraId, Object cameraConfig, int i, int i2, VideoEncoderInfo.Finder videoEncoderInfoFinder) {
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            Intrinsics.checkNotNullParameter(cameraConfig, "cameraConfig");
            Intrinsics.checkNotNullParameter(videoEncoderInfoFinder, "videoEncoderInfoFinder");
            this.cameraId = cameraId;
            this.cameraConfig = cameraConfig;
            this.videoRecordingType = i;
            this.videoCapabilitiesSource = i2;
            this.videoEncoderInfoFinder = videoEncoderInfoFinder;
        }

        public final String getCameraId() {
            return this.cameraId;
        }

        public final Object getCameraConfig() {
            return this.cameraConfig;
        }

        public final int getVideoRecordingType() {
            return this.videoRecordingType;
        }

        public final int getVideoCapabilitiesSource() {
            return this.videoCapabilitiesSource;
        }

        public final VideoEncoderInfo.Finder getVideoEncoderInfoFinder() {
            return this.videoEncoderInfoFinder;
        }
    }
}
