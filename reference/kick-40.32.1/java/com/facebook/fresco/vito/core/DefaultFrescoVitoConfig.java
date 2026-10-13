package com.facebook.fresco.vito.core;

import android.net.Uri;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultFrescoVitoConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001:\u0001@B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\tH\u0016J\b\u0010#\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\tH\u0016J\u001c\u0010+\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001c\u0010.\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010/\u001a\u00020\tH\u0016J\u0012\u00100\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\tH\u0016J\b\u00104\u001a\u00020\tH\u0016J\b\u00105\u001a\u00020\tH\u0016J\b\u00106\u001a\u00020\tH\u0016J\u0012\u00107\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u00108\u001a\u00020\tH\u0016J\b\u00109\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020\tH\u0016J\b\u0010;\u001a\u00020\tH\u0016J\b\u0010<\u001a\u00020\tH\u0016J\b\u0010=\u001a\u00020\tH\u0016J\b\u0010>\u001a\u00020\tH\u0016J\b\u0010?\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006A"}, d2 = {"Lcom/facebook/fresco/vito/core/DefaultFrescoVitoConfig;", "Lcom/facebook/fresco/vito/core/FrescoVitoConfig;", "prefetchConfig", "Lcom/facebook/fresco/vito/core/PrefetchConfig;", "<init>", "(Lcom/facebook/fresco/vito/core/PrefetchConfig;)V", "getPrefetchConfig", "()Lcom/facebook/fresco/vito/core/PrefetchConfig;", "submitFetchOnBgThread", "", "useBind", "useMount", "useUnbind", "useDetached", "onUnbindReleaseStrategy", "Lcom/facebook/fresco/vito/core/ReleaseStrategy;", "onUnmountReleaseStrategy", "onDetachedReleaseStrategy", "releaseDelayMs", "", "useUnmount", "useBindOnly", "useNewReleaseCallback", "useNativeRounding", "Lcom/facebook/common/internal/Supplier;", "layoutPrefetchingEnabled", "callerContext", "", "useSmartPropertyDiffing", "onlyStopAnimationWhenAutoPlayEnabled", "fastPathForEmptyRequests", "enableWindowWideColorGamut", "handleImageResultInBackground", "useIntermediateImagesAsPlaceholder", "fallbackToDefaultImageOptions", "experimentalDynamicSizeVito2", "experimentalDynamicSizeWithCacheFallbackVito2", "experimentalDynamicSizeOnPrepareMainThreadVito2", "experimentalDynamicSizeDiskCacheCheckTimeoutMs", "experimentalDynamicSizeUseSfOnDiskCacheTimeout", "isAppStarting", "experimentalDynamicSizeDisableWhenAppIsStarting", "experimentalDynamicSizeCheckIfProductIsEnabled", "experimentalDynamicSizeIsProductEnabled", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", "experimentalDynamicSizeIsFallbackEnabled", "experimentalDynamicSizeBloksDisableDiskCacheCheck", "experimentalDynamicSizeIsUriEligible", "uri", "Landroid/net/Uri;", "experimentalResetVitoImageRequestListener", "experimentalResetLocalVitoImageRequestListener", "experimentalResetLocalImagePerfStateListener", "experimentalResetControllerListener2", "isCallerContextBloks", "enablePrepareToDrawOnFetch", "experimentalOptimizeAlphaHandling", "enableRetriggerListenersIfImageAlreadySet", "fixOnBindRetriggerListenersClobber", "disableBitmapCacheShortcut", "useOfferBackOnRelease", "useOfferBackOnReleaseForNonBitmapImage", "releaseImageOnVisibilityGoneImmediately", "DefaultPrefetchConfig", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DefaultFrescoVitoConfig implements FrescoVitoConfig {
    private final PrefetchConfig prefetchConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultFrescoVitoConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean disableBitmapCacheShortcut() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean enablePrepareToDrawOnFetch() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean enableRetriggerListenersIfImageAlreadySet() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean enableWindowWideColorGamut() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalDynamicSizeBloksDisableDiskCacheCheck() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalDynamicSizeCheckIfProductIsEnabled() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalDynamicSizeDisableWhenAppIsStarting() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public long experimentalDynamicSizeDiskCacheCheckTimeoutMs() {
        return 0L;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalDynamicSizeIsFallbackEnabled(Object callerContext, ContextChain contextChain) {
        return true;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalDynamicSizeIsProductEnabled(Object callerContext, ContextChain contextChain) {
        return true;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalDynamicSizeIsUriEligible(Uri uri) {
        return true;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalDynamicSizeOnPrepareMainThreadVito2() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalDynamicSizeUseSfOnDiskCacheTimeout() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalDynamicSizeVito2() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalDynamicSizeWithCacheFallbackVito2() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalOptimizeAlphaHandling() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalResetControllerListener2() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalResetLocalImagePerfStateListener() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalResetLocalVitoImageRequestListener() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean experimentalResetVitoImageRequestListener() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean fallbackToDefaultImageOptions() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean fastPathForEmptyRequests() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean fixOnBindRetriggerListenersClobber() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean handleImageResultInBackground() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean isAppStarting() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean isCallerContextBloks(Object callerContext) {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean layoutPrefetchingEnabled(Object callerContext) {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean onlyStopAnimationWhenAutoPlayEnabled() {
        return true;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public long releaseDelayMs() {
        return 80L;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean releaseImageOnVisibilityGoneImmediately() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean submitFetchOnBgThread() {
        return true;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean useBind() {
        return true;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean useBindOnly() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean useDetached() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean useIntermediateImagesAsPlaceholder() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean useMount() {
        return true;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean useNewReleaseCallback() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean useOfferBackOnRelease() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean useOfferBackOnReleaseForNonBitmapImage() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean useSmartPropertyDiffing() {
        return false;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean useUnbind() {
        return true;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public boolean useUnmount() {
        return true;
    }

    public DefaultFrescoVitoConfig(PrefetchConfig prefetchConfig) {
        Intrinsics.checkNotNullParameter(prefetchConfig, "prefetchConfig");
        this.prefetchConfig = prefetchConfig;
    }

    public /* synthetic */ DefaultFrescoVitoConfig(DefaultPrefetchConfig defaultPrefetchConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultPrefetchConfig() : defaultPrefetchConfig);
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public PrefetchConfig getPrefetchConfig() {
        return this.prefetchConfig;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public ReleaseStrategy onUnbindReleaseStrategy() {
        return ReleaseStrategy.DELAYED;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public ReleaseStrategy onUnmountReleaseStrategy() {
        return ReleaseStrategy.NEXT_FRAME;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public ReleaseStrategy onDetachedReleaseStrategy() {
        return ReleaseStrategy.NEXT_FRAME;
    }

    @Override // com.facebook.fresco.vito.core.FrescoVitoConfig
    public Supplier<Boolean> useNativeRounding() {
        return Suppliers.BOOLEAN_TRUE;
    }

    /* JADX INFO: compiled from: DefaultFrescoVitoConfig.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/facebook/fresco/vito/core/DefaultFrescoVitoConfig$DefaultPrefetchConfig;", "Lcom/facebook/fresco/vito/core/PrefetchConfig;", "<init>", "()V", "prefetchInOnPrepare", "", "prefetchInOnBoundsDefinedForDynamicSize", "prefetchTargetOnPrepare", "Lcom/facebook/fresco/vito/core/PrefetchTarget;", "prefetchTargetOnBoundsDefined", "closePrefetchDataSourceOnBindorOnMount", "closePrefetchDataSourceOnUnbind", "closePrefetchDataSourceOnUnmount", "closePrefetchDataSourceOnDetached", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class DefaultPrefetchConfig implements PrefetchConfig {
        @Override // com.facebook.fresco.vito.core.PrefetchConfig
        public boolean closePrefetchDataSourceOnBindorOnMount() {
            return true;
        }

        @Override // com.facebook.fresco.vito.core.PrefetchConfig
        public boolean closePrefetchDataSourceOnDetached() {
            return false;
        }

        @Override // com.facebook.fresco.vito.core.PrefetchConfig
        public boolean closePrefetchDataSourceOnUnbind() {
            return true;
        }

        @Override // com.facebook.fresco.vito.core.PrefetchConfig
        public boolean closePrefetchDataSourceOnUnmount() {
            return true;
        }

        @Override // com.facebook.fresco.vito.core.PrefetchConfig
        public boolean prefetchInOnBoundsDefinedForDynamicSize() {
            return false;
        }

        @Override // com.facebook.fresco.vito.core.PrefetchConfig
        public boolean prefetchInOnPrepare() {
            return true;
        }

        @Override // com.facebook.fresco.vito.core.PrefetchConfig
        public PrefetchTarget prefetchTargetOnPrepare() {
            return PrefetchTarget.MEMORY_DECODED;
        }

        @Override // com.facebook.fresco.vito.core.PrefetchConfig
        public PrefetchTarget prefetchTargetOnBoundsDefined() {
            return PrefetchTarget.MEMORY_DECODED;
        }
    }
}
