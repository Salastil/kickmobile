package com.facebook.fresco.vito.provider.impl;

import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Supplier;
import com.facebook.fresco.vito.core.FrescoController2;
import com.facebook.fresco.vito.core.FrescoVitoConfig;
import com.facebook.fresco.vito.core.FrescoVitoPrefetcher;
import com.facebook.fresco.vito.core.ImagePerfLoggingListener;
import com.facebook.fresco.vito.core.ImagePipelineUtils;
import com.facebook.fresco.vito.core.VitoImagePerfListener;
import com.facebook.fresco.vito.core.VitoImagePipeline;
import com.facebook.fresco.vito.core.impl.FrescoController2Impl;
import com.facebook.fresco.vito.core.impl.FrescoVitoPrefetcherImpl;
import com.facebook.fresco.vito.core.impl.HierarcherImpl;
import com.facebook.fresco.vito.core.impl.VitoImagePipelineImpl;
import com.facebook.fresco.vito.core.impl.debug.DebugOverlayFactory2;
import com.facebook.fresco.vito.core.impl.debug.NoOpDebugOverlayFactory2;
import com.facebook.fresco.vito.drawable.ArrayVitoDrawableFactory;
import com.facebook.fresco.vito.drawable.BitmapDrawableFactory;
import com.facebook.fresco.vito.draweesupport.DrawableFactoryWrapper;
import com.facebook.fresco.vito.options.ImageOptionsDrawableFactory;
import com.facebook.fresco.vito.provider.setup.FrescoVitoSetup;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultFrescoVitoProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/facebook/fresco/vito/provider/impl/DefaultFrescoVitoProvider;", "Lcom/facebook/fresco/vito/provider/setup/FrescoVitoSetup;", "frescoVitoConfig", "Lcom/facebook/fresco/vito/core/FrescoVitoConfig;", "imagePipeline", "Lcom/facebook/imagepipeline/core/ImagePipeline;", "imagePipelineUtils", "Lcom/facebook/fresco/vito/core/ImagePipelineUtils;", "lightweightBackgroundThreadExecutor", "Ljava/util/concurrent/Executor;", "uiThreadExecutor", "callerContextVerifier", "Lcom/facebook/callercontext/CallerContextVerifier;", "vitoImagePerfListener", "Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "debugOverlayFactory", "Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayFactory2;", "imagePerfListenerSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/fresco/vito/core/ImagePerfLoggingListener;", "<init>", "(Lcom/facebook/fresco/vito/core/FrescoVitoConfig;Lcom/facebook/imagepipeline/core/ImagePipeline;Lcom/facebook/fresco/vito/core/ImagePipelineUtils;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/facebook/callercontext/CallerContextVerifier;Lcom/facebook/fresco/vito/core/VitoImagePerfListener;Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayFactory2;Lcom/facebook/common/internal/Supplier;)V", "frescoController", "Lcom/facebook/fresco/vito/core/FrescoController2;", "vitoImagePipeline", "Lcom/facebook/fresco/vito/core/VitoImagePipeline;", "frescoVitoPrefetcher", "Lcom/facebook/fresco/vito/core/FrescoVitoPrefetcher;", "getController", "getPrefetcher", "getImagePipeline", "getConfig", "Companion", "provider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultFrescoVitoProvider implements FrescoVitoSetup {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final FrescoController2 frescoController;
    private final FrescoVitoConfig frescoVitoConfig;
    private final FrescoVitoPrefetcher frescoVitoPrefetcher;
    private final VitoImagePipeline vitoImagePipeline;

    public DefaultFrescoVitoProvider(FrescoVitoConfig frescoVitoConfig, ImagePipeline imagePipeline, ImagePipelineUtils imagePipelineUtils, Executor lightweightBackgroundThreadExecutor, Executor uiThreadExecutor, CallerContextVerifier callerContextVerifier, VitoImagePerfListener vitoImagePerfListener, DebugOverlayFactory2 debugOverlayFactory, Supplier<ImagePerfLoggingListener> supplier) {
        Intrinsics.checkNotNullParameter(frescoVitoConfig, "frescoVitoConfig");
        Intrinsics.checkNotNullParameter(imagePipeline, "imagePipeline");
        Intrinsics.checkNotNullParameter(imagePipelineUtils, "imagePipelineUtils");
        Intrinsics.checkNotNullParameter(lightweightBackgroundThreadExecutor, "lightweightBackgroundThreadExecutor");
        Intrinsics.checkNotNullParameter(uiThreadExecutor, "uiThreadExecutor");
        Intrinsics.checkNotNullParameter(callerContextVerifier, "callerContextVerifier");
        Intrinsics.checkNotNullParameter(vitoImagePerfListener, "vitoImagePerfListener");
        Intrinsics.checkNotNullParameter(debugOverlayFactory, "debugOverlayFactory");
        this.frescoVitoConfig = frescoVitoConfig;
        if (!ImagePipelineFactory.hasBeenInitialized()) {
            throw new RuntimeException("Fresco must be initialized before DefaultFrescoVitoProvider can be used!");
        }
        this.frescoVitoPrefetcher = new FrescoVitoPrefetcherImpl(imagePipeline, imagePipelineUtils, callerContextVerifier);
        VitoImagePipelineImpl vitoImagePipelineImpl = new VitoImagePipelineImpl(imagePipeline, imagePipelineUtils, frescoVitoConfig);
        this.vitoImagePipeline = vitoImagePipelineImpl;
        this.frescoController = new FrescoController2Impl(frescoVitoConfig, new HierarcherImpl(INSTANCE.createDefaultDrawableFactory()), lightweightBackgroundThreadExecutor, uiThreadExecutor, vitoImagePipelineImpl, null, debugOverlayFactory, supplier, vitoImagePerfListener);
    }

    public /* synthetic */ DefaultFrescoVitoProvider(FrescoVitoConfig frescoVitoConfig, ImagePipeline imagePipeline, ImagePipelineUtils imagePipelineUtils, Executor executor, Executor executor2, CallerContextVerifier callerContextVerifier, VitoImagePerfListener vitoImagePerfListener, DebugOverlayFactory2 debugOverlayFactory2, Supplier supplier, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(frescoVitoConfig, imagePipeline, imagePipelineUtils, executor, executor2, callerContextVerifier, vitoImagePerfListener, (i & 128) != 0 ? new NoOpDebugOverlayFactory2() : debugOverlayFactory2, (i & 256) != 0 ? null : supplier);
    }

    @Override // com.facebook.fresco.vito.provider.setup.FrescoVitoSetup
    /* JADX INFO: renamed from: getController, reason: from getter */
    public FrescoController2 getFrescoController() {
        return this.frescoController;
    }

    @Override // com.facebook.fresco.vito.provider.setup.FrescoVitoSetup
    /* JADX INFO: renamed from: getPrefetcher, reason: from getter */
    public FrescoVitoPrefetcher getFrescoVitoPrefetcher() {
        return this.frescoVitoPrefetcher;
    }

    @Override // com.facebook.fresco.vito.provider.setup.FrescoVitoSetup
    /* JADX INFO: renamed from: getImagePipeline, reason: from getter */
    public VitoImagePipeline getVitoImagePipeline() {
        return this.vitoImagePipeline;
    }

    @Override // com.facebook.fresco.vito.provider.setup.FrescoVitoSetup
    /* JADX INFO: renamed from: getConfig, reason: from getter */
    public FrescoVitoConfig getFrescoVitoConfig() {
        return this.frescoVitoConfig;
    }

    /* JADX INFO: compiled from: DefaultFrescoVitoProvider.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/facebook/fresco/vito/provider/impl/DefaultFrescoVitoProvider$Companion;", "", "<init>", "()V", "createDefaultDrawableFactory", "Lcom/facebook/fresco/vito/options/ImageOptionsDrawableFactory;", "provider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ImageOptionsDrawableFactory createDefaultDrawableFactory() {
            DrawableFactory animatedDrawableFactory = ImagePipelineFactory.getInstance().getAnimatedDrawableFactory(null);
            ImageOptionsDrawableFactory imageOptionsDrawableFactoryWrap = animatedDrawableFactory != null ? DrawableFactoryWrapper.INSTANCE.wrap(animatedDrawableFactory) : null;
            BitmapDrawableFactory bitmapDrawableFactory = new BitmapDrawableFactory();
            DrawableFactory xmlDrawableFactory = ImagePipelineFactory.getInstance().getXmlDrawableFactory();
            List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new ImageOptionsDrawableFactory[]{bitmapDrawableFactory, imageOptionsDrawableFactoryWrap, xmlDrawableFactory != null ? DrawableFactoryWrapper.INSTANCE.wrap(xmlDrawableFactory) : null});
            if (listListOfNotNull.size() == 1) {
                return (ImageOptionsDrawableFactory) listListOfNotNull.get(0);
            }
            ImageOptionsDrawableFactory[] imageOptionsDrawableFactoryArr = (ImageOptionsDrawableFactory[]) listListOfNotNull.toArray(new ImageOptionsDrawableFactory[0]);
            return new ArrayVitoDrawableFactory((ImageOptionsDrawableFactory[]) Arrays.copyOf(imageOptionsDrawableFactoryArr, imageOptionsDrawableFactoryArr.length));
        }
    }
}
