package com.facebook.fresco.vito.provider.impl.kotlin;

import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.fresco.vito.core.FrescoController2;
import com.facebook.fresco.vito.core.FrescoVitoConfig;
import com.facebook.fresco.vito.core.FrescoVitoPrefetcher;
import com.facebook.fresco.vito.core.ImagePipelineUtils;
import com.facebook.fresco.vito.core.VitoImagePipeline;
import com.facebook.fresco.vito.core.impl.DebugOverlayHandler;
import com.facebook.fresco.vito.core.impl.FrescoVitoPrefetcherImpl;
import com.facebook.fresco.vito.core.impl.KFrescoController;
import com.facebook.fresco.vito.core.impl.VitoImagePipelineImpl;
import com.facebook.fresco.vito.drawable.ArrayVitoDrawableFactory;
import com.facebook.fresco.vito.draweesupport.DrawableFactoryWrapper;
import com.facebook.fresco.vito.options.ImageOptionsDrawableFactory;
import com.facebook.fresco.vito.provider.impl.NoOpCallerContextVerifier;
import com.facebook.fresco.vito.provider.setup.FrescoVitoSetup;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KFrescoVitoProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010!\u001a\u00020\u0018H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lcom/facebook/fresco/vito/provider/impl/kotlin/KFrescoVitoProvider;", "Lcom/facebook/fresco/vito/provider/setup/FrescoVitoSetup;", "vitoConfig", "Lcom/facebook/fresco/vito/core/FrescoVitoConfig;", "frescoImagePipeline", "Lcom/facebook/imagepipeline/core/ImagePipeline;", "imagePipelineUtils", "Lcom/facebook/fresco/vito/core/ImagePipelineUtils;", "uiThreadExecutor", "Ljava/util/concurrent/Executor;", "lightweightBackgroundExecutor", "callerContextVerifier", "Lcom/facebook/callercontext/CallerContextVerifier;", "debugOverlayHandler", "Lcom/facebook/fresco/vito/core/impl/DebugOverlayHandler;", "<init>", "(Lcom/facebook/fresco/vito/core/FrescoVitoConfig;Lcom/facebook/imagepipeline/core/ImagePipeline;Lcom/facebook/fresco/vito/core/ImagePipelineUtils;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/facebook/callercontext/CallerContextVerifier;Lcom/facebook/fresco/vito/core/impl/DebugOverlayHandler;)V", "_imagePipeline", "Lcom/facebook/fresco/vito/core/VitoImagePipeline;", "get_imagePipeline", "()Lcom/facebook/fresco/vito/core/VitoImagePipeline;", "_imagePipeline$delegate", "Lkotlin/Lazy;", "_controller", "Lcom/facebook/fresco/vito/core/FrescoController2;", "get_controller", "()Lcom/facebook/fresco/vito/core/FrescoController2;", "_controller$delegate", "_prefetcher", "Lcom/facebook/fresco/vito/core/FrescoVitoPrefetcher;", "get_prefetcher", "()Lcom/facebook/fresco/vito/core/FrescoVitoPrefetcher;", "_prefetcher$delegate", "getController", "getPrefetcher", "getImagePipeline", "getConfig", "getFactory", "Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;", "provider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KFrescoVitoProvider implements FrescoVitoSetup {

    /* JADX INFO: renamed from: _controller$delegate, reason: from kotlin metadata */
    private final Lazy _controller;

    /* JADX INFO: renamed from: _imagePipeline$delegate, reason: from kotlin metadata */
    private final Lazy _imagePipeline;

    /* JADX INFO: renamed from: _prefetcher$delegate, reason: from kotlin metadata */
    private final Lazy _prefetcher;
    private final CallerContextVerifier callerContextVerifier;
    private final DebugOverlayHandler debugOverlayHandler;
    private final ImagePipeline frescoImagePipeline;
    private final ImagePipelineUtils imagePipelineUtils;
    private final Executor lightweightBackgroundExecutor;
    private final Executor uiThreadExecutor;
    private final FrescoVitoConfig vitoConfig;

    public KFrescoVitoProvider(FrescoVitoConfig vitoConfig, ImagePipeline frescoImagePipeline, ImagePipelineUtils imagePipelineUtils, Executor uiThreadExecutor, Executor lightweightBackgroundExecutor, CallerContextVerifier callerContextVerifier, DebugOverlayHandler debugOverlayHandler) {
        Intrinsics.checkNotNullParameter(vitoConfig, "vitoConfig");
        Intrinsics.checkNotNullParameter(frescoImagePipeline, "frescoImagePipeline");
        Intrinsics.checkNotNullParameter(imagePipelineUtils, "imagePipelineUtils");
        Intrinsics.checkNotNullParameter(uiThreadExecutor, "uiThreadExecutor");
        Intrinsics.checkNotNullParameter(lightweightBackgroundExecutor, "lightweightBackgroundExecutor");
        Intrinsics.checkNotNullParameter(callerContextVerifier, "callerContextVerifier");
        this.vitoConfig = vitoConfig;
        this.frescoImagePipeline = frescoImagePipeline;
        this.imagePipelineUtils = imagePipelineUtils;
        this.uiThreadExecutor = uiThreadExecutor;
        this.lightweightBackgroundExecutor = lightweightBackgroundExecutor;
        this.callerContextVerifier = callerContextVerifier;
        this.debugOverlayHandler = debugOverlayHandler;
        this._imagePipeline = LazyKt.lazy(new Function0() { // from class: com.facebook.fresco.vito.provider.impl.kotlin.KFrescoVitoProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KFrescoVitoProvider._imagePipeline_delegate$lambda$0(this.f$0);
            }
        });
        this._controller = LazyKt.lazy(new Function0() { // from class: com.facebook.fresco.vito.provider.impl.kotlin.KFrescoVitoProvider$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KFrescoVitoProvider._controller_delegate$lambda$2(this.f$0);
            }
        });
        this._prefetcher = LazyKt.lazy(new Function0() { // from class: com.facebook.fresco.vito.provider.impl.kotlin.KFrescoVitoProvider$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return KFrescoVitoProvider._prefetcher_delegate$lambda$3(this.f$0);
            }
        });
    }

    public /* synthetic */ KFrescoVitoProvider(FrescoVitoConfig frescoVitoConfig, ImagePipeline imagePipeline, ImagePipelineUtils imagePipelineUtils, Executor executor, Executor executor2, NoOpCallerContextVerifier noOpCallerContextVerifier, DebugOverlayHandler debugOverlayHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(frescoVitoConfig, imagePipeline, imagePipelineUtils, executor, executor2, (i & 32) != 0 ? NoOpCallerContextVerifier.INSTANCE : noOpCallerContextVerifier, (i & 64) != 0 ? null : debugOverlayHandler);
    }

    private final VitoImagePipeline get_imagePipeline() {
        return (VitoImagePipeline) this._imagePipeline.getValue();
    }

    static final VitoImagePipelineImpl _imagePipeline_delegate$lambda$0(KFrescoVitoProvider kFrescoVitoProvider) {
        return new VitoImagePipelineImpl(kFrescoVitoProvider.frescoImagePipeline, kFrescoVitoProvider.imagePipelineUtils, kFrescoVitoProvider.vitoConfig);
    }

    private final FrescoController2 get_controller() {
        return (FrescoController2) this._controller.getValue();
    }

    static final KFrescoController _controller_delegate$lambda$2(KFrescoVitoProvider kFrescoVitoProvider) {
        KFrescoController kFrescoController = new KFrescoController(kFrescoVitoProvider.vitoConfig, kFrescoVitoProvider.get_imagePipeline(), kFrescoVitoProvider.uiThreadExecutor, kFrescoVitoProvider.lightweightBackgroundExecutor, null, null, null, kFrescoVitoProvider.getFactory(), 112, null);
        kFrescoController.setDebugOverlayHandler(kFrescoVitoProvider.debugOverlayHandler);
        return kFrescoController;
    }

    private final FrescoVitoPrefetcher get_prefetcher() {
        return (FrescoVitoPrefetcher) this._prefetcher.getValue();
    }

    static final FrescoVitoPrefetcherImpl _prefetcher_delegate$lambda$3(KFrescoVitoProvider kFrescoVitoProvider) {
        return new FrescoVitoPrefetcherImpl(kFrescoVitoProvider.frescoImagePipeline, kFrescoVitoProvider.imagePipelineUtils, kFrescoVitoProvider.callerContextVerifier);
    }

    @Override // com.facebook.fresco.vito.provider.setup.FrescoVitoSetup
    /* JADX INFO: renamed from: getController */
    public FrescoController2 getFrescoController() {
        return get_controller();
    }

    @Override // com.facebook.fresco.vito.provider.setup.FrescoVitoSetup
    /* JADX INFO: renamed from: getPrefetcher */
    public FrescoVitoPrefetcher getFrescoVitoPrefetcher() {
        return get_prefetcher();
    }

    @Override // com.facebook.fresco.vito.provider.setup.FrescoVitoSetup
    /* JADX INFO: renamed from: getImagePipeline */
    public VitoImagePipeline getVitoImagePipeline() {
        return get_imagePipeline();
    }

    @Override // com.facebook.fresco.vito.provider.setup.FrescoVitoSetup
    /* JADX INFO: renamed from: getConfig, reason: from getter */
    public FrescoVitoConfig getVitoConfig() {
        return this.vitoConfig;
    }

    private final ImageOptionsDrawableFactory getFactory() {
        DrawableFactory animatedDrawableFactory = ImagePipelineFactory.getInstance().getAnimatedDrawableFactory(null);
        ImageOptionsDrawableFactory imageOptionsDrawableFactoryWrap = animatedDrawableFactory != null ? DrawableFactoryWrapper.INSTANCE.wrap(animatedDrawableFactory) : null;
        DrawableFactory xmlDrawableFactory = ImagePipelineFactory.getInstance().getXmlDrawableFactory();
        List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new ImageOptionsDrawableFactory[]{imageOptionsDrawableFactoryWrap, xmlDrawableFactory != null ? DrawableFactoryWrapper.INSTANCE.wrap(xmlDrawableFactory) : null});
        int size = listListOfNotNull.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return (ImageOptionsDrawableFactory) listListOfNotNull.get(0);
        }
        ImageOptionsDrawableFactory[] imageOptionsDrawableFactoryArr = (ImageOptionsDrawableFactory[]) listListOfNotNull.toArray(new ImageOptionsDrawableFactory[0]);
        return new ArrayVitoDrawableFactory((ImageOptionsDrawableFactory[]) Arrays.copyOf(imageOptionsDrawableFactoryArr, imageOptionsDrawableFactoryArr.length));
    }
}
