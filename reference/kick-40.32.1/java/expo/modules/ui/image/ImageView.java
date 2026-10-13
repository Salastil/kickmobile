package expo.modules.ui.image;

import android.content.Context;
import android.graphics.Color;
import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.ui.ExpoUIModule;
import expo.modules.ui.ModifierRegistry;
import expo.modules.ui.UtilsKt;
import expo.modules.ui.convertibles.ContentAlignment;
import expo.modules.ui.graphics.DrawablePainterKt;
import expo.modules.ui.graphics.ImageLoader;
import expo.modules.ui.graphics.ImageSource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ImageView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u001d\u001a\u00020\u000e*\u00020\u001eH\u0017¢\u0006\u0002\u0010\u001fR\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0015\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006 ²\u0006\n\u0010!\u001a\u00020\"X\u008a\u008e\u0002"}, d2 = {"Lexpo/modules/ui/image/ImageView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/image/ImageProps;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/image/ImageProps;", "onLoad", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "", "getOnLoad", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onLoad$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "onError", "Lexpo/modules/ui/image/ImageErrorEvent;", "getOnError", "onError$delegate", "imageLoader", "Lexpo/modules/ui/graphics/ImageLoader;", "getImageLoader", "()Lexpo/modules/ui/graphics/ImageLoader;", "imageLoader$delegate", "Lkotlin/Lazy;", "Content", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release", "loadedImage", "Lexpo/modules/ui/graphics/ImageLoader$ImageResult;"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageView extends ExpoComposeView<ImageProps> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ImageView.class, "onLoad", "getOnLoad()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(ImageView.class, "onError", "getOnError()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    public static final int $stable = 8;

    /* JADX INFO: renamed from: imageLoader$delegate, reason: from kotlin metadata */
    private final Lazy imageLoader;

    /* JADX INFO: renamed from: onError$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onError;

    /* JADX INFO: renamed from: onLoad$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onLoad;
    private final ImageProps props;

    static final Unit Content$lambda$9(ImageView imageView, ComposableScope composableScope, int i, Composer composer, int i2) {
        imageView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageView(Context context, final AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new ImageProps(null, null, null, null, null, null, null, 127, null);
        ImageView imageView = this;
        this.onLoad = new ViewEventDelegate(imageView, null);
        this.onError = new ViewEventDelegate(imageView, null);
        this.imageLoader = LazyKt.lazy(new Function0() { // from class: expo.modules.ui.image.ImageView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImageView.imageLoader_delegate$lambda$1(appContext);
            }
        });
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public ImageProps getProps() {
        return this.props;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewEventCallback<Unit> getOnLoad() {
        return this.onLoad.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewEventCallback<ImageErrorEvent> getOnError() {
        return this.onError.getValue(this, $$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageLoader getImageLoader() {
        return (ImageLoader) this.imageLoader.getValue();
    }

    static final ImageLoader imageLoader_delegate$lambda$1(AppContext appContext) {
        Object next;
        Iterator<T> it = appContext.getRegistry().getRegistry().values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((ModuleHolder) next).getModule() instanceof ExpoUIModule));
        ModuleHolder moduleHolder = (ModuleHolder) next;
        Module module = moduleHolder != null ? moduleHolder.getModule() : null;
        if (!(module instanceof ExpoUIModule)) {
            module = null;
        }
        ExpoUIModule expoUIModule = (ExpoUIModule) module;
        ImageLoader imageLoader = expoUIModule != null ? expoUIModule.getImageLoader() : null;
        if (imageLoader != null) {
            return imageLoader;
        }
        throw new IllegalArgumentException("ExpoUIModule.imageLoader is not initialized".toString());
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        Composer composer2;
        int i3;
        VectorPainter vectorPainterRememberVectorPainter;
        VectorPainter vectorPainterRememberDrawablePainter;
        ColorFilter colorFilterM7379tintxETnrds$default;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(1464400690);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)96@3522L62,98@3613L524,98@3590L547,127@4684L114,120@4359L445:ImageView.kt#pymzr8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1464400690, i2, -1, "expo.modules.ui.image.ImageView.Content (ImageView.kt:87)");
            }
            ImageSource imageSourceComponent1 = getProps().getSource().component1();
            ImageContentScale imageContentScaleComponent1 = getProps().getContentScale().component1();
            ContentAlignment contentAlignmentComponent1 = getProps().getAlignment().component1();
            String strComponent1 = getProps().getContentDescription().component1();
            Color colorComponent1 = getProps().getTint().component1();
            float fFloatValue = getProps().getAlpha().component1().floatValue();
            List<Map<String, Dynamic>> listComponent1 = getProps().getModifiers().component1();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1460198896, "CC(remember):ImageView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(imageSourceComponent1);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new ImageLoader.ImageResult(null, null, null, 7, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1460195522, "CC(remember):ImageView.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(imageSourceComponent1) | composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(mutableState);
            ImageView$Content$1$1 imageView$Content$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || imageView$Content$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                imageView$Content$1$1RememberedValue = new ImageView$Content$1$1(imageSourceComponent1, this, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(imageView$Content$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(imageSourceComponent1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) imageView$Content$1$1RememberedValue, composerStartRestartGroup, 0);
            ImageVector imageVector = Content$lambda$3(mutableState).getImageVector();
            if (imageVector == null) {
                composerStartRestartGroup.startReplaceGroup(1979128302);
                composerStartRestartGroup.endReplaceGroup();
                vectorPainterRememberVectorPainter = null;
                i3 = 0;
            } else {
                composerStartRestartGroup.startReplaceGroup(1979128303);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*116@4188L25");
                i3 = 0;
                vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(imageVector, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (vectorPainterRememberVectorPainter != null) {
                composerStartRestartGroup.startReplaceGroup(-1460178525);
                composerStartRestartGroup.endReplaceGroup();
                vectorPainterRememberDrawablePainter = vectorPainterRememberVectorPainter;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1460176417);
                ComposerKt.sourceInformation(composerStartRestartGroup, "117@4225L45");
                vectorPainterRememberDrawablePainter = DrawablePainterKt.rememberDrawablePainter(Content$lambda$3(mutableState).getDrawable(), composerStartRestartGroup, i3);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (vectorPainterRememberDrawablePainter != null) {
                colorFilterM7379tintxETnrds$default = null;
                composerStartRestartGroup.startReplaceGroup(-1460178442);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1979226759);
                ComposerKt.sourceInformation(composerStartRestartGroup, "118@4280L73");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1460174629, "CC(remember):ImageView.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    colorFilterM7379tintxETnrds$default = null;
                    objRememberedValue2 = new ColorPainter(androidx.compose.ui.graphics.Color.INSTANCE.m7373getTransparent0d7_KjU(), null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    colorFilterM7379tintxETnrds$default = null;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                vectorPainterRememberDrawablePainter = (ColorPainter) objRememberedValue2;
            }
            Painter painter = vectorPainterRememberDrawablePainter;
            ContentScale composeContentScale = imageContentScaleComponent1.toComposeContentScale();
            Alignment composeAlignment = contentAlignmentComponent1.toComposeAlignment();
            if (colorComponent1 != null) {
                colorFilterM7379tintxETnrds$default = ColorFilter.Companion.m7379tintxETnrds$default(ColorFilter.INSTANCE, UtilsKt.getCompose(colorComponent1), 0, 2, null);
            }
            composer2 = composerStartRestartGroup;
            ImageKt.Image(painter, strComponent1, ModifierRegistry.INSTANCE.applyModifiers(listComponent1, getAppContext(), composableScope, getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | ((i2 << 6) & 896)), composeAlignment, composeContentScale, RangesKt.coerceIn(fFloatValue, 0.0f, 1.0f), colorFilterM7379tintxETnrds$default, composer2, Painter.$stable, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.image.ImageView$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageView.Content$lambda$9(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ImageLoader.ImageResult Content$lambda$3(MutableState<ImageLoader.ImageResult> mutableState) {
        return mutableState.getValue();
    }
}
