package expo.modules.ui.icon;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.unit.Dp;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.ui.ExpoUIModule;
import expo.modules.ui.ModifierRegistry;
import expo.modules.ui.UtilsKt;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IconView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015R\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016²\u0006\f\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u008a\u008e\u0002²\u0006\f\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u008a\u008e\u0002"}, d2 = {"Lexpo/modules/ui/icon/IconView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/icon/IconProps;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/icon/IconProps;", "iconLoader", "Lexpo/modules/ui/graphics/ImageLoader;", "getIconLoader", "()Lexpo/modules/ui/graphics/ImageLoader;", "iconLoader$delegate", "Lkotlin/Lazy;", "Content", "", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "drawable", "Landroid/graphics/drawable/Drawable;"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IconView extends ExpoComposeView<IconProps> {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: iconLoader$delegate, reason: from kotlin metadata */
    private final Lazy iconLoader;
    private final IconProps props;

    static final Unit Content$lambda$11(IconView iconView, ComposableScope composableScope, int i, Composer composer, int i2) {
        iconView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconView(Context context, final AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new IconProps(null, null, null, null, null, null, 63, null);
        this.iconLoader = LazyKt.lazy(new Function0() { // from class: expo.modules.ui.icon.IconView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IconView.iconLoader_delegate$lambda$1(appContext);
            }
        });
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public IconProps getProps() {
        return this.props;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageLoader getIconLoader() {
        return (ImageLoader) this.iconLoader.getValue();
    }

    static final ImageLoader iconLoader_delegate$lambda$1(AppContext appContext) {
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

    /* JADX WARN: Code duplicated, block: B:60:0x01dd  */
    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        final ComposableScope composableScope2;
        MutableState mutableState;
        VectorPainter vectorPainterRememberDrawablePainter;
        long jM7374getUnspecified0d7_KjU;
        Modifier.Companion companionM2417size3ABfNKs;
        this = this;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1204827952);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)61@2392L47,62@2460L44,65@2574L353,65@2551L376:IconView.kt#xj628g");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composableScope2 = composableScope;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1204827952, i3, -1, "expo.modules.ui.icon.IconView.Content (IconView.kt:53)");
            }
            ImageSource imageSourceComponent1 = this.getProps().getSource().component1();
            Color colorComponent1 = this.getProps().getTint().component1();
            boolean zBooleanValue = this.getProps().getInheritTint().component1().booleanValue();
            Integer numComponent1 = this.getProps().getSize().component1();
            String strComponent1 = this.getProps().getContentDescription().component1();
            List<Map<String, Dynamic>> listComponent1 = this.getProps().getModifiers().component1();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1801517919, "CC(remember):IconView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            VectorPainter vectorPainterRememberVectorPainter = null;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1801520092, "CC(remember):IconView.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1801524049, "CC(remember):IconView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(imageSourceComponent1) | composerStartRestartGroup.changedInstance(this);
            IconView$Content$1$1 iconView$Content$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || iconView$Content$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState3;
                iconView$Content$1$1RememberedValue = new IconView$Content$1$1(imageSourceComponent1, this, mutableState2, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(iconView$Content$1$1RememberedValue);
            } else {
                mutableState = mutableState3;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(imageSourceComponent1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) iconView$Content$1$1RememberedValue, composerStartRestartGroup, 0);
            ImageVector imageVectorContent$lambda$3 = Content$lambda$3(mutableState2);
            if (imageVectorContent$lambda$3 == null) {
                composerStartRestartGroup.startReplaceGroup(13108144);
            } else {
                composerStartRestartGroup.startReplaceGroup(13108145);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*79@3031L25");
                vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(imageVectorContent$lambda$3, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (vectorPainterRememberVectorPainter != null) {
                composerStartRestartGroup.startReplaceGroup(1801537801);
                composerStartRestartGroup.endReplaceGroup();
                vectorPainterRememberDrawablePainter = vectorPainterRememberVectorPainter;
            } else {
                composerStartRestartGroup.startReplaceGroup(1801539537);
                ComposerKt.sourceInformation(composerStartRestartGroup, "80@3068L33");
                vectorPainterRememberDrawablePainter = DrawablePainterKt.rememberDrawablePainter(Content$lambda$6(mutableState), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            Painter painter = vectorPainterRememberDrawablePainter;
            if (painter != null) {
                composerStartRestartGroup.startReplaceGroup(13265284);
                ComposerKt.sourceInformation(composerStartRestartGroup, "96@3605L74,90@3365L323");
                if (colorComponent1 != null) {
                    jM7374getUnspecified0d7_KjU = UtilsKt.getCompose(colorComponent1);
                } else if (zBooleanValue) {
                    composerStartRestartGroup.startReplaceGroup(13318883);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "86@3267L7");
                    ProvidableCompositionLocal<androidx.compose.ui.graphics.Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM7374getUnspecified0d7_KjU = ((androidx.compose.ui.graphics.Color) objConsume).m7348unboximpl();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(13372110);
                    composerStartRestartGroup.endReplaceGroup();
                    jM7374getUnspecified0d7_KjU = androidx.compose.ui.graphics.Color.INSTANCE.m7374getUnspecified0d7_KjU();
                }
                long j = jM7374getUnspecified0d7_KjU;
                Modifier.Companion companion = Modifier.INSTANCE;
                if (numComponent1 != null) {
                    companionM2417size3ABfNKs = SizeKt.m2417size3ABfNKs(Modifier.INSTANCE, Dp.m10168constructorimpl(numComponent1.intValue()));
                    if (companionM2417size3ABfNKs == null) {
                        companionM2417size3ABfNKs = Modifier.INSTANCE;
                    }
                } else {
                    companionM2417size3ABfNKs = Modifier.INSTANCE;
                }
                composableScope2 = composableScope;
                IconKt.m4153Iconww6aTOc(painter, strComponent1, companion.then(companionM2417size3ABfNKs).then(ModifierRegistry.INSTANCE.applyModifiers(listComponent1, getAppContext(), composableScope2, getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | ((i3 << 6) & 896))), j, composerStartRestartGroup, Painter.$stable, 0);
            } else {
                composableScope2 = composableScope;
                composerStartRestartGroup.startReplaceGroup(10105330);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.icon.IconView$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconView.Content$lambda$11(this.f$0, composableScope2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ImageVector Content$lambda$3(MutableState<ImageVector> mutableState) {
        return mutableState.getValue();
    }

    private static final Drawable Content$lambda$6(MutableState<Drawable> mutableState) {
        return mutableState.getValue();
    }
}
