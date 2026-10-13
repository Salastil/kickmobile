package expo.modules.ui;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNHostView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u001cJ \u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u000eH\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\r\u0010*\u001a\u00020\u001aH\u0000¢\u0006\u0002\b+J\u0011\u0010,\u001a\u00020\u001a*\u00020-H\u0017¢\u0006\u0002\u0010.J\r\u0010/\u001a\u000200H\u0003¢\u0006\u0002\u00101J\r\u00102\u001a\u000200H\u0003¢\u0006\u0002\u00101J\r\u00103\u001a\u000200H\u0003¢\u0006\u0002\u00101J\r\u00104\u001a\u000200H\u0003¢\u0006\u0002\u00101J!\u00105\u001a\u0002002\b\b\u0002\u00106\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u00020\u0012H\u0003¢\u0006\u0002\u00108R\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lexpo/modules/ui/RNHostView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/RNHostViewProps;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/RNHostViewProps;", "childViewState", "Landroidx/compose/runtime/MutableState;", "Landroid/view/View;", "wrapperState", "Lexpo/modules/ui/TouchDispatchingRootViewGroup;", "layoutRootState", "", "layoutRoot", "getLayoutRoot", "()Z", "lastContentOriginX", "", "lastContentOriginY", "setLayoutRoot", "", "value", "setLayoutRoot$expo_ui_release", "childSizeState", "Landroidx/compose/ui/unit/IntSize;", "childLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "addView", "child", FirebaseAnalytics.Param.INDEX, "", "params", "Landroid/view/ViewGroup$LayoutParams;", "removeView", "view", "removeViewAt", "clearPublishedContentOrigin", "clearPublishedContentOrigin$expo_ui_release", "Content", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "applySizeFromYogaNodeModifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "applyHeightFromYogaNodeModifier", "applyWidthFromYogaNodeModifier", "publishContentOriginModifier", "reportSizeToYogaNodeModifier", "reportWidth", "reportHeight", "(ZZLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "Companion", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RNHostView extends ExpoComposeView<RNHostViewProps> {
    private static final String TAG = "RNHostView";
    private final View.OnLayoutChangeListener childLayoutListener;
    private final MutableState<IntSize> childSizeState;
    private final MutableState<View> childViewState;
    private double lastContentOriginX;
    private double lastContentOriginY;
    private final MutableState<Boolean> layoutRootState;
    private final RNHostViewProps props;
    private final MutableState<TouchDispatchingRootViewGroup> wrapperState;
    public static final int $stable = 8;

    static final Unit Content$lambda$6(RNHostView rNHostView, ComposableScope composableScope, int i, Composer composer, int i2) {
        rNHostView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNHostView(Context context, AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new RNHostViewProps(null, null, null, null, 15, null);
        this.childViewState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.wrapperState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.layoutRootState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.lastContentOriginX = Double.NaN;
        this.lastContentOriginY = Double.NaN;
        this.childSizeState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m10331boximpl(IntSize.INSTANCE.m10344getZeroYbymL2g()), null, 2, null);
        this.childLayoutListener = new View.OnLayoutChangeListener() { // from class: expo.modules.ui.RNHostView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.childSizeState.setValue(IntSize.m10331boximpl(IntSize.m10334constructorimpl((((long) (i3 - i)) << 32) | (((long) (i4 - i2)) & 4294967295L))));
            }
        };
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public RNHostViewProps getProps() {
        return this.props;
    }

    private final boolean getLayoutRoot() {
        return this.layoutRootState.getValue().booleanValue();
    }

    public final void setLayoutRoot$expo_ui_release(boolean value) {
        boolean z = this.layoutRootState.getValue().booleanValue() != value;
        this.layoutRootState.setValue(Boolean.valueOf(value));
        TouchDispatchingRootViewGroup value2 = this.wrapperState.getValue();
        if (value2 != null) {
            value2.setDispatchesTouchesToJS(value);
        }
        if (z && value) {
            clearPublishedContentOrigin$expo_ui_release();
        }
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        long jM10344getZeroYbymL2g;
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        this.childViewState.setValue(child);
        MutableState<IntSize> mutableState = this.childSizeState;
        if (child.getWidth() <= 0 || child.getHeight() <= 0) {
            jM10344getZeroYbymL2g = IntSize.INSTANCE.m10344getZeroYbymL2g();
        } else {
            jM10344getZeroYbymL2g = IntSize.m10334constructorimpl((((long) child.getWidth()) << 32) | (((long) child.getHeight()) & 4294967295L));
        }
        mutableState.setValue(IntSize.m10331boximpl(jM10344getZeroYbymL2g));
        child.addOnLayoutChangeListener(this.childLayoutListener);
        Context context = child.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TouchDispatchingRootViewGroup touchDispatchingRootViewGroup = new TouchDispatchingRootViewGroup(context);
        touchDispatchingRootViewGroup.setDispatchesTouchesToJS(getLayoutRoot());
        Context context2 = child.getContext();
        ReactContext reactContext = context2 instanceof ReactContext ? (ReactContext) context2 : null;
        if (reactContext != null) {
            touchDispatchingRootViewGroup.setEventDispatcher(UIManagerHelper.getEventDispatcherForReactTag(reactContext, child.getId()));
        } else {
            Log.e(TAG, "RNHostView: child context is not a ReactContext, touch events will not be dispatched to JS");
        }
        touchDispatchingRootViewGroup.addView(child, new FrameLayout.LayoutParams(-1, -1));
        this.wrapperState.setValue(touchDispatchingRootViewGroup);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual(view, this.childViewState.getValue())) {
            view.removeOnLayoutChangeListener(this.childLayoutListener);
            TouchDispatchingRootViewGroup value = this.wrapperState.getValue();
            if (value != null) {
                value.removeView(view);
            }
            clearPublishedContentOrigin$expo_ui_release();
            this.childViewState.setValue(null);
            this.wrapperState.setValue(null);
            return;
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int index) {
        View value = this.childViewState.getValue();
        if (value != null) {
            value.removeOnLayoutChangeListener(this.childLayoutListener);
            TouchDispatchingRootViewGroup value2 = this.wrapperState.getValue();
            if (value2 != null) {
                value2.removeView(value);
            }
        }
        clearPublishedContentOrigin$expo_ui_release();
        this.childViewState.setValue(null);
        this.wrapperState.setValue(null);
    }

    public final void clearPublishedContentOrigin$expo_ui_release() {
        this.lastContentOriginX = Double.NaN;
        this.lastContentOriginY = Double.NaN;
        getShadowNodeProxy().clearContentOrigin();
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        final RNHostView rNHostView;
        Modifier modifierThen;
        RNHostView rNHostView2;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1802934975);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content):RNHostView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            rNHostView = this;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1802934975, i2, -1, "expo.modules.ui.RNHostView.Content (RNHostView.kt:154)");
            }
            Boolean value = getProps().getMatchContentsHorizontal().getValue();
            boolean zBooleanValue = value != null ? value.booleanValue() : false;
            Boolean value2 = getProps().getMatchContentsVertical().getValue();
            boolean zBooleanValue2 = value2 != null ? value2.booleanValue() : false;
            final TouchDispatchingRootViewGroup value3 = this.wrapperState.getValue();
            if (value3 == null) {
                composerStartRestartGroup.startReplaceGroup(1625471134);
                composerStartRestartGroup.endReplaceGroup();
                rNHostView = this;
            } else {
                composerStartRestartGroup.startReplaceGroup(1625471135);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*180@7402L79,182@7526L30,185@7596L63,184@7565L132");
                if (this.childViewState.getValue() == null) {
                    rNHostView = this;
                } else {
                    if (zBooleanValue && zBooleanValue2) {
                        composerStartRestartGroup.startReplaceGroup(-1261733142);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "162@6637L31");
                        modifierThen = applySizeFromYogaNodeModifier(composerStartRestartGroup, (i2 >> 3) & 14);
                        composerStartRestartGroup.endReplaceGroup();
                        rNHostView = this;
                    } else {
                        if (zBooleanValue2) {
                            composerStartRestartGroup.startReplaceGroup(-1261726894);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "166@6767L50,167@6837L33");
                            rNHostView2 = this;
                            modifierThen = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null).then(reportSizeToYogaNodeModifier(false, false, composerStartRestartGroup, ((i2 << 3) & 896) | 48, 1)).then(rNHostView2.applyHeightFromYogaNodeModifier(composerStartRestartGroup, (i2 >> 3) & 14));
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (zBooleanValue) {
                            composerStartRestartGroup.startReplaceGroup(-1261720335);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "171@6973L49,172@7042L32");
                            rNHostView2 = this;
                            modifierThen = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null).then(reportSizeToYogaNodeModifier(false, false, composerStartRestartGroup, ((i2 << 3) & 896) | 6, 2)).then(rNHostView2.applyWidthFromYogaNodeModifier(composerStartRestartGroup, (i2 >> 3) & 14));
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1261716689);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "176@7156L30");
                            rNHostView = this;
                            modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(reportSizeToYogaNodeModifier(false, false, composerStartRestartGroup, (i2 << 3) & 896, 3));
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        rNHostView = rNHostView2;
                    }
                    Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(rNHostView.getProps().getModifiers().getValue(), rNHostView.getAppContext(), composableScope, rNHostView.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | ((i2 << 6) & 896));
                    composerStartRestartGroup = composerStartRestartGroup;
                    Modifier modifierThen2 = modifierApplyModifiers.then(modifierThen).then(rNHostView.publishContentOriginModifier(composerStartRestartGroup, (i2 >> 3) & 14));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1261702422, "CC(remember):RNHostView.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(value3);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: expo.modules.ui.RNHostView$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RNHostView.Content$lambda$5$lambda$4$lambda$3(value3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue, modifierThen2, null, composerStartRestartGroup, 0, 4);
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.RNHostView$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RNHostView.Content$lambda$6(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final TouchDispatchingRootViewGroup Content$lambda$5$lambda$4$lambda$3(TouchDispatchingRootViewGroup touchDispatchingRootViewGroup, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        RNHostViewKt.detachForReuse(touchDispatchingRootViewGroup);
        return touchDispatchingRootViewGroup;
    }

    private final Modifier applySizeFromYogaNodeModifier(Composer composer, int i) {
        Modifier.Companion companionM2411requiredSizeVpY3zN4;
        int i2;
        ComposerKt.sourceInformationMarkerStart(composer, -161153148, "C(applySizeFromYogaNodeModifier)197@7910L7:RNHostView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-161153148, i, -1, "expo.modules.ui.RNHostView.applySizeFromYogaNodeModifier (RNHostView.kt:196)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume;
        long jM10343unboximpl = this.childSizeState.getValue().m10343unboximpl();
        int i3 = (int) (jM10343unboximpl >> 32);
        if (i3 > 0 && (i2 = (int) (jM10343unboximpl & 4294967295L)) > 0) {
            companionM2411requiredSizeVpY3zN4 = SizeKt.m2411requiredSizeVpY3zN4(SizeKt.wrapContentSize(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter(), true), density.mo1731toDpu2uoSUM(i3), density.mo1731toDpu2uoSUM(i2));
        } else {
            companionM2411requiredSizeVpY3zN4 = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return companionM2411requiredSizeVpY3zN4;
    }

    private final Modifier applyHeightFromYogaNodeModifier(Composer composer, int i) {
        composer.startReplaceGroup(1861292074);
        ComposerKt.sourceInformation(composer, "C(applyHeightFromYogaNodeModifier)232@9474L7:RNHostView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1861292074, i, -1, "expo.modules.ui.RNHostView.applyHeightFromYogaNodeModifier (RNHostView.kt:225)");
        }
        int iM10343unboximpl = (int) (this.childSizeState.getValue().m10343unboximpl() & 4294967295L);
        if (iM10343unboximpl <= 0) {
            Modifier.Companion companion = Modifier.INSTANCE;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return companion;
        }
        Modifier modifierWrapContentHeight = SizeKt.wrapContentHeight(Modifier.INSTANCE, Alignment.INSTANCE.getTop(), true);
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM2406requiredHeight3ABfNKs = SizeKt.m2406requiredHeight3ABfNKs(modifierWrapContentHeight, ((Density) objConsume).mo1731toDpu2uoSUM(iM10343unboximpl));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM2406requiredHeight3ABfNKs;
    }

    private final Modifier applyWidthFromYogaNodeModifier(Composer composer, int i) {
        composer.startReplaceGroup(-38907895);
        ComposerKt.sourceInformation(composer, "C(applyWidthFromYogaNodeModifier)243@9804L7:RNHostView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-38907895, i, -1, "expo.modules.ui.RNHostView.applyWidthFromYogaNodeModifier (RNHostView.kt:236)");
        }
        int iM10343unboximpl = (int) (this.childSizeState.getValue().m10343unboximpl() >> 32);
        if (iM10343unboximpl <= 0) {
            Modifier.Companion companion = Modifier.INSTANCE;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return companion;
        }
        Modifier modifierWrapContentWidth = SizeKt.wrapContentWidth(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally(), true);
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM2414requiredWidth3ABfNKs = SizeKt.m2414requiredWidth3ABfNKs(modifierWrapContentWidth, ((Density) objConsume).mo1731toDpu2uoSUM(iM10343unboximpl));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM2414requiredWidth3ABfNKs;
    }

    private final Modifier publishContentOriginModifier(Composer composer, int i) {
        composer.startReplaceGroup(-3523771);
        ComposerKt.sourceInformation(composer, "C(publishContentOriginModifier)257@10437L7,258@10486L395:RNHostView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-3523771, i, -1, "expo.modules.ui.RNHostView.publishContentOriginModifier (RNHostView.kt:252)");
        }
        if (getLayoutRoot()) {
            Modifier.Companion companion = Modifier.INSTANCE;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return companion;
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        Modifier.Companion companion2 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 908634544, "CC(remember):RNHostView.kt#9igjgp");
        boolean zChanged = composer.changed(density) | composer.changedInstance(this);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: expo.modules.ui.RNHostView$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RNHostView.publishContentOriginModifier$lambda$12$lambda$11(density, this, (LayoutCoordinates) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierOnGloballyPositioned;
    }

    static final Unit publishContentOriginModifier$lambda$12$lambda$11(Density density, RNHostView rNHostView, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        long jPositionInRoot = LayoutCoordinatesKt.positionInRoot(coordinates);
        double dMo1730toDpu2uoSUM = density.mo1730toDpu2uoSUM(Float.intBitsToFloat((int) (jPositionInRoot >> 32)));
        double dMo1730toDpu2uoSUM2 = density.mo1730toDpu2uoSUM(Float.intBitsToFloat((int) (jPositionInRoot & 4294967295L)));
        if (dMo1730toDpu2uoSUM != rNHostView.lastContentOriginX || dMo1730toDpu2uoSUM2 != rNHostView.lastContentOriginY) {
            rNHostView.lastContentOriginX = dMo1730toDpu2uoSUM;
            rNHostView.lastContentOriginY = dMo1730toDpu2uoSUM2;
            rNHostView.getShadowNodeProxy().setContentOrigin(dMo1730toDpu2uoSUM, dMo1730toDpu2uoSUM2);
        }
        return Unit.INSTANCE;
    }

    private final Modifier reportSizeToYogaNodeModifier(final boolean z, final boolean z2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 292046901, "C(reportSizeToYogaNodeModifier)N(reportWidth,reportHeight)276@11167L7,277@11209L355:RNHostView.kt#v15e7d");
        boolean z3 = true;
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(292046901, i, -1, "expo.modules.ui.RNHostView.reportSizeToYogaNodeModifier (RNHostView.kt:275)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1484204344, "CC(remember):RNHostView.kt#9igjgp");
        boolean zChanged = composer.changed(density) | composer.changedInstance(this) | ((((i & 14) ^ 6) > 4 && composer.changed(z)) || (i & 6) == 4);
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(z2)) && (i & 48) != 32) {
            z3 = false;
        }
        boolean z4 = zChanged | z3;
        Object objRememberedValue = composer.rememberedValue();
        if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: expo.modules.ui.RNHostView$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RNHostView.reportSizeToYogaNodeModifier$lambda$15$lambda$14(density, this, z, z2, (IntSize) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(companion, (Function1) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierOnSizeChanged;
    }

    static final Unit reportSizeToYogaNodeModifier$lambda$15$lambda$14(Density density, RNHostView rNHostView, boolean z, boolean z2, IntSize intSize) {
        rNHostView.getShadowNodeProxy().setViewSize(z ? density.mo1731toDpu2uoSUM((int) (intSize.m10343unboximpl() >> 32)) : Double.NaN, z2 ? density.mo1731toDpu2uoSUM((int) (intSize.m10343unboximpl() & 4294967295L)) : Double.NaN);
        return Unit.INSTANCE;
    }
}
