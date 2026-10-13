package com.facebook.fresco.vito.core;

import android.net.Uri;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.common.internal.Supplier;
import kotlin.Metadata;

/* JADX INFO: compiled from: FrescoVitoConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0007H&J\b\u0010\u0014\u001a\u00020\u0007H&J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H&J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u0019\u001a\u00020\u0007H&J\b\u0010\u001a\u001a\u00020\u0007H&J\b\u0010\u001b\u001a\u00020\u0007H&J\b\u0010\u001c\u001a\u00020\u0007H&J\b\u0010\u001d\u001a\u00020\u0007H&J\b\u0010\u001e\u001a\u00020\u0007H&J\b\u0010\u001f\u001a\u00020\u0007H&J\b\u0010 \u001a\u00020\u0007H&J\b\u0010!\u001a\u00020\u0007H&J\b\u0010\"\u001a\u00020\u0007H&J\b\u0010#\u001a\u00020\u0007H&J\b\u0010$\u001a\u00020\u0012H&J\b\u0010%\u001a\u00020\u0007H&J\b\u0010&\u001a\u00020\u0007H&J\b\u0010'\u001a\u00020\u0007H&J\b\u0010(\u001a\u00020\u0007H&J\u001c\u0010)\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010*\u001a\u0004\u0018\u00010+H&J\u001c\u0010,\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010*\u001a\u0004\u0018\u00010+H&J\u0012\u0010-\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H&J\b\u0010.\u001a\u00020\u0007H&J\b\u0010/\u001a\u00020\u0007H&J\b\u00100\u001a\u00020\u0007H&J\b\u00101\u001a\u00020\u0007H&J\u0012\u00102\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u000104H&J\b\u00105\u001a\u00020\u0007H&J\b\u00106\u001a\u00020\u0007H&J\b\u00107\u001a\u00020\u0007H&J\b\u00108\u001a\u00020\u0007H\u0016J\b\u00109\u001a\u00020\u0007H\u0016J\b\u0010:\u001a\u00020\u0007H\u0016J\b\u0010;\u001a\u00020\u0007H\u0016J\b\u0010<\u001a\u00020\u0007H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006=À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/FrescoVitoConfig;", "", "prefetchConfig", "Lcom/facebook/fresco/vito/core/PrefetchConfig;", "getPrefetchConfig", "()Lcom/facebook/fresco/vito/core/PrefetchConfig;", "submitFetchOnBgThread", "", "useBind", "useMount", "useUnmount", "useUnbind", "useDetached", "onUnbindReleaseStrategy", "Lcom/facebook/fresco/vito/core/ReleaseStrategy;", "onUnmountReleaseStrategy", "onDetachedReleaseStrategy", "releaseDelayMs", "", "useBindOnly", "useNewReleaseCallback", "useNativeRounding", "Lcom/facebook/common/internal/Supplier;", "layoutPrefetchingEnabled", "callerContext", "useSmartPropertyDiffing", "onlyStopAnimationWhenAutoPlayEnabled", "fastPathForEmptyRequests", "enableWindowWideColorGamut", "handleImageResultInBackground", "useIntermediateImagesAsPlaceholder", "fallbackToDefaultImageOptions", "experimentalDynamicSizeVito2", "experimentalDynamicSizeBloksDisableDiskCacheCheck", "experimentalDynamicSizeWithCacheFallbackVito2", "experimentalDynamicSizeOnPrepareMainThreadVito2", "experimentalDynamicSizeDiskCacheCheckTimeoutMs", "experimentalDynamicSizeUseSfOnDiskCacheTimeout", "isAppStarting", "experimentalDynamicSizeDisableWhenAppIsStarting", "experimentalDynamicSizeCheckIfProductIsEnabled", "experimentalDynamicSizeIsProductEnabled", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", "experimentalDynamicSizeIsFallbackEnabled", "isCallerContextBloks", "experimentalResetVitoImageRequestListener", "experimentalResetLocalVitoImageRequestListener", "experimentalResetLocalImagePerfStateListener", "experimentalResetControllerListener2", "experimentalDynamicSizeIsUriEligible", "uri", "Landroid/net/Uri;", "enablePrepareToDrawOnFetch", "experimentalOptimizeAlphaHandling", "enableRetriggerListenersIfImageAlreadySet", "fixOnBindRetriggerListenersClobber", "disableBitmapCacheShortcut", "useOfferBackOnRelease", "useOfferBackOnReleaseForNonBitmapImage", "releaseImageOnVisibilityGoneImmediately", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FrescoVitoConfig {
    default boolean disableBitmapCacheShortcut() {
        return false;
    }

    boolean enablePrepareToDrawOnFetch();

    boolean enableRetriggerListenersIfImageAlreadySet();

    boolean enableWindowWideColorGamut();

    boolean experimentalDynamicSizeBloksDisableDiskCacheCheck();

    boolean experimentalDynamicSizeCheckIfProductIsEnabled();

    boolean experimentalDynamicSizeDisableWhenAppIsStarting();

    long experimentalDynamicSizeDiskCacheCheckTimeoutMs();

    boolean experimentalDynamicSizeIsFallbackEnabled(Object callerContext, ContextChain contextChain);

    boolean experimentalDynamicSizeIsProductEnabled(Object callerContext, ContextChain contextChain);

    boolean experimentalDynamicSizeIsUriEligible(Uri uri);

    boolean experimentalDynamicSizeOnPrepareMainThreadVito2();

    boolean experimentalDynamicSizeUseSfOnDiskCacheTimeout();

    boolean experimentalDynamicSizeVito2();

    boolean experimentalDynamicSizeWithCacheFallbackVito2();

    boolean experimentalOptimizeAlphaHandling();

    boolean experimentalResetControllerListener2();

    boolean experimentalResetLocalImagePerfStateListener();

    boolean experimentalResetLocalVitoImageRequestListener();

    boolean experimentalResetVitoImageRequestListener();

    boolean fallbackToDefaultImageOptions();

    boolean fastPathForEmptyRequests();

    default boolean fixOnBindRetriggerListenersClobber() {
        return false;
    }

    PrefetchConfig getPrefetchConfig();

    boolean handleImageResultInBackground();

    boolean isAppStarting();

    boolean isCallerContextBloks(Object callerContext);

    boolean layoutPrefetchingEnabled(Object callerContext);

    ReleaseStrategy onDetachedReleaseStrategy();

    ReleaseStrategy onUnbindReleaseStrategy();

    ReleaseStrategy onUnmountReleaseStrategy();

    boolean onlyStopAnimationWhenAutoPlayEnabled();

    long releaseDelayMs();

    default boolean releaseImageOnVisibilityGoneImmediately() {
        return false;
    }

    boolean submitFetchOnBgThread();

    boolean useBind();

    boolean useBindOnly();

    boolean useDetached();

    boolean useIntermediateImagesAsPlaceholder();

    boolean useMount();

    Supplier<Boolean> useNativeRounding();

    boolean useNewReleaseCallback();

    default boolean useOfferBackOnRelease() {
        return false;
    }

    default boolean useOfferBackOnReleaseForNonBitmapImage() {
        return false;
    }

    boolean useSmartPropertyDiffing();

    boolean useUnbind();

    boolean useUnmount();

    /* JADX INFO: compiled from: FrescoVitoConfig.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean fixOnBindRetriggerListenersClobber(FrescoVitoConfig frescoVitoConfig) {
            return FrescoVitoConfig.super.fixOnBindRetriggerListenersClobber();
        }

        @Deprecated
        public static boolean disableBitmapCacheShortcut(FrescoVitoConfig frescoVitoConfig) {
            return FrescoVitoConfig.super.disableBitmapCacheShortcut();
        }

        @Deprecated
        public static boolean useOfferBackOnRelease(FrescoVitoConfig frescoVitoConfig) {
            return FrescoVitoConfig.super.useOfferBackOnRelease();
        }

        @Deprecated
        public static boolean useOfferBackOnReleaseForNonBitmapImage(FrescoVitoConfig frescoVitoConfig) {
            return FrescoVitoConfig.super.useOfferBackOnReleaseForNonBitmapImage();
        }

        @Deprecated
        public static boolean releaseImageOnVisibilityGoneImmediately(FrescoVitoConfig frescoVitoConfig) {
            return FrescoVitoConfig.super.releaseImageOnVisibilityGoneImmediately();
        }
    }
}
