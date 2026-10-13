package expo.modules.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.LinearLayout;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.ui.colors.MaterialColorsKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: HostView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0017¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00160\u001b¢\u0006\u0002\b\u001cH\u0003¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0014J\r\u0010(\u001a\u00020\u0016H\u0000¢\u0006\u0002\b)J\b\u0010*\u001a\u00020+H\u0002R\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lexpo/modules/ui/HostView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/HostProps;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/HostProps;", "onLayoutContent", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/ui/LayoutContentEvent;", "getOnLayoutContent", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onLayoutContent$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "lastDispatchedContentSize", "Landroidx/compose/ui/unit/IntSize;", "Content", "", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "MaybeMatchContentsLayout", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "dispatchOnLayoutContent", ContentDisposition.Parameters.Size, "density", "Landroidx/compose/ui/unit/Density;", "dispatchOnLayoutContent-viCIZxY", "(JLandroidx/compose/ui/unit/Density;)V", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "onViewDidUpdateProps", "onViewDidUpdateProps$expo_ui_release", "findComposeView", "Landroidx/compose/ui/platform/ComposeView;", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HostView extends ExpoComposeView<HostProps> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(HostView.class, "onLayoutContent", "getOnLayoutContent()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    public static final int $stable = 8;
    private IntSize lastDispatchedContentSize;

    /* JADX INFO: renamed from: onLayoutContent$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onLayoutContent;
    private final HostProps props;

    /* JADX INFO: compiled from: HostView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExpoColorScheme.values().length];
            try {
                iArr[ExpoColorScheme.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExpoColorScheme.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final Unit Content$lambda$5(HostView hostView, ComposableScope composableScope, int i, Composer composer, int i2) {
        hostView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit MaybeMatchContentsLayout$lambda$11(HostView hostView, Function2 function2, int i, Composer composer, int i2) {
        hostView.MaybeMatchContentsLayout(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HostView(Context context, AppContext appContext) {
        super(context, appContext, true);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new HostProps(null, null, null, null, null, null, null, 127, null);
        this.onLayoutContent = new ViewEventDelegate(this, null);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public HostProps getProps() {
        return this.props;
    }

    private final ViewEventCallback<LayoutContentEvent> getOnLayoutContent() {
        return this.onLayoutContent.getValue(this, $$delegatedProperties[0]);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        boolean zIsSystemInDarkTheme;
        Color composeOrNull;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-968938567);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)124@4758L7,131@5019L86,145@5768L152,142@5628L292:HostView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-968938567, i2, -1, "expo.modules.ui.HostView.Content (HostView.kt:123)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ExpoColorScheme value = getProps().getColorScheme().getValue();
            int i3 = value == null ? -1 : WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            if (i3 == -1) {
                composerStartRestartGroup.startReplaceGroup(857947726);
                ComposerKt.sourceInformation(composerStartRestartGroup, "128@4902L21");
                zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i3 == 1) {
                composerStartRestartGroup.startReplaceGroup(826520882);
                composerStartRestartGroup.endReplaceGroup();
                zIsSystemInDarkTheme = true;
            } else {
                if (i3 != 2) {
                    composerStartRestartGroup.startReplaceGroup(857944043);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(826556631);
                composerStartRestartGroup.endReplaceGroup();
                zIsSystemInDarkTheme = false;
            }
            android.graphics.Color value2 = getProps().getSeedColor().getValue();
            final ColorScheme colorSchemeDefaultColorScheme = null;
            Integer numValueOf = (value2 == null || (composeOrNull = UtilsKt.getComposeOrNull(value2)) == null) ? null : Integer.valueOf(ColorKt.m7392toArgb8_81llA(composeOrNull.m7348unboximpl()));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 857951535, "CC(remember):HostView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(numValueOf) | composerStartRestartGroup.changed(zIsSystemInDarkTheme);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = numValueOf != null ? MaterialColorsKt.seedColorScheme(numValueOf.intValue(), zIsSystemInDarkTheme) : null;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ColorScheme colorScheme = (ColorScheme) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (colorScheme == null) {
                ExpoColorScheme value3 = getProps().getColorScheme().getValue();
                if (value3 != null) {
                    colorSchemeDefaultColorScheme = value3.toColorScheme(context);
                }
            } else {
                colorSchemeDefaultColorScheme = colorScheme;
            }
            if (colorSchemeDefaultColorScheme != null) {
                composerStartRestartGroup.startReplaceGroup(857955082);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(857958027);
                ComposerKt.sourceInformation(composerStartRestartGroup, "136@5251L21");
                colorSchemeDefaultColorScheme = ExpoColorScheme.INSTANCE.defaultColorScheme(context, DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0));
                composerStartRestartGroup.endReplaceGroup();
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{CompositionLocalsKt.getLocalLayoutDirection().provides(getProps().getLayoutDirection().getValue().toLayoutDirection()), ContentColorKt.getLocalContentColor().provides(Color.m7328boximpl(colorSchemeDefaultColorScheme.getOnSurface()))}, ComposableLambdaKt.rememberComposableLambda(-1708425095, true, new Function2() { // from class: expo.modules.ui.HostView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HostView.Content$lambda$4(colorSchemeDefaultColorScheme, this, composableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.HostView$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HostView.Content$lambda$5(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit Content$lambda$4(ColorScheme colorScheme, final HostView hostView, final ComposableScope composableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C146@5827L87,146@5776L138:HostView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1708425095, i, -1, "expo.modules.ui.HostView.Content.<anonymous> (HostView.kt:146)");
            }
            MaterialThemeKt.MaterialExpressiveTheme(colorScheme, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1415466780, true, new Function2() { // from class: expo.modules.ui.HostView$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HostView.Content$lambda$4$lambda$3(this.f$0, composableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 24576, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit Content$lambda$4$lambda$3(final HostView hostView, final ComposableScope composableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C147@5862L44,147@5837L69:HostView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1415466780, i, -1, "expo.modules.ui.HostView.Content.<anonymous>.<anonymous> (HostView.kt:147)");
            }
            hostView.MaybeMatchContentsLayout(ComposableLambdaKt.rememberComposableLambda(1584761494, true, new Function2() { // from class: expo.modules.ui.HostView$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HostView.Content$lambda$4$lambda$3$lambda$2(this.f$0, composableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit Content$lambda$4$lambda$3$lambda$2(HostView hostView, ComposableScope composableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C148@5874L22:HostView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1584761494, i, -1, "expo.modules.ui.HostView.Content.<anonymous>.<anonymous>.<anonymous> (HostView.kt:148)");
            }
            hostView.Children(composableScope, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private final void MaybeMatchContentsLayout(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        WindowInsets windowInsetsUnion;
        Modifier.Companion companionWrapContentWidth$default;
        Modifier.Companion companionWrapContentHeight$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(-148440405);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MaybeMatchContentsLayout)N(content)156@6045L7,157@6096L7,158@6151L7,163@6367L10,163@6397L13,191@7270L50,193@7352L1940,175@6858L2434:HostView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-148440405, i2, -1, "expo.modules.ui.HostView.MaybeMatchContentsLayout (HostView.kt:155)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Density density = (Density) objConsume;
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Configuration configuration = (Configuration) objConsume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
            int iMo1728roundToPx0680j_4 = density.mo1728roundToPx0680j_4(Dp.m10168constructorimpl(configuration.screenWidthDp));
            int iMo1728roundToPx0680j_5 = density.mo1728roundToPx0680j_4(Dp.m10168constructorimpl(configuration.screenHeightDp));
            WindowInsets windowInsetsUnion2 = WindowInsetsKt.union(WindowInsets_androidKt.getSystemBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), WindowInsets_androidKt.getDisplayCutout(WindowInsets.INSTANCE, composerStartRestartGroup, 6));
            if (getProps().getIgnoreSafeAreaKeyboardInsets().getValue().booleanValue()) {
                composerStartRestartGroup.startReplaceGroup(1628760831);
                composerStartRestartGroup.endReplaceGroup();
                windowInsetsUnion = windowInsetsUnion2;
            } else {
                composerStartRestartGroup.startReplaceGroup(1628791335);
                ComposerKt.sourceInformation(composerStartRestartGroup, "167@6551L3");
                windowInsetsUnion = WindowInsetsKt.union(windowInsetsUnion2, WindowInsets_androidKt.getIme(WindowInsets.INSTANCE, composerStartRestartGroup, 6));
                composerStartRestartGroup.endReplaceGroup();
            }
            int iCoerceAtLeast = RangesKt.coerceAtLeast((iMo1728roundToPx0680j_4 - windowInsetsUnion2.getLeft(density, layoutDirection)) - windowInsetsUnion2.getRight(density, layoutDirection), 0);
            int iCoerceAtLeast2 = RangesKt.coerceAtLeast((iMo1728roundToPx0680j_5 - windowInsetsUnion.getTop(density)) - windowInsetsUnion.getBottom(density), 0);
            Modifier.Companion companion = Modifier.INSTANCE;
            if (Intrinsics.areEqual((Object) getProps().getMatchContentsHorizontal().getValue(), (Object) true)) {
                companionWrapContentWidth$default = SizeKt.wrapContentWidth$default(Modifier.INSTANCE, null, false, 3, null);
            } else {
                companionWrapContentWidth$default = Modifier.INSTANCE;
            }
            Modifier modifierThen = companion.then(companionWrapContentWidth$default);
            if (Intrinsics.areEqual((Object) getProps().getMatchContentsVertical().getValue(), (Object) true)) {
                companionWrapContentHeight$default = SizeKt.wrapContentHeight$default(Modifier.INSTANCE, null, false, 3, null);
            } else {
                companionWrapContentHeight$default = Modifier.INSTANCE;
            }
            Modifier modifierThen2 = modifierThen.then(companionWrapContentHeight$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -917265443, "CC(remember):HostView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(density);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.HostView$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HostView.MaybeMatchContentsLayout$lambda$9$lambda$8(this.f$0, density, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierThen2, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -917260929, "CC(remember):HostView.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(iCoerceAtLeast) | composerStartRestartGroup.changed(iCoerceAtLeast2) | composerStartRestartGroup.changed(density);
            HostView$MaybeMatchContentsLayout$2$1 hostView$MaybeMatchContentsLayout$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || hostView$MaybeMatchContentsLayout$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                hostView$MaybeMatchContentsLayout$2$1RememberedValue = new HostView$MaybeMatchContentsLayout$2$1(this, iCoerceAtLeast, iCoerceAtLeast2, density);
                composerStartRestartGroup.updateRememberedValue(hostView$MaybeMatchContentsLayout$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) hostView$MaybeMatchContentsLayout$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2 & 14;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = ((i3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6438constructorimpl = Updater.m6438constructorimpl(composerStartRestartGroup);
            Updater.m6446setimpl(composerM6438constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.HostView$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HostView.MaybeMatchContentsLayout$lambda$11(this.f$0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit MaybeMatchContentsLayout$lambda$9$lambda$8(HostView hostView, Density density, IntSize intSize) {
        hostView.m12116dispatchOnLayoutContentviCIZxY(intSize.m10343unboximpl(), density);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: dispatchOnLayoutContent-viCIZxY, reason: not valid java name */
    private final void m12116dispatchOnLayoutContentviCIZxY(long size, Density density) {
        IntSize intSize = this.lastDispatchedContentSize;
        if (intSize == null ? false : IntSize.m10337equalsimpl0(intSize.m10343unboximpl(), size)) {
            return;
        }
        this.lastDispatchedContentSize = IntSize.m10331boximpl(size);
        Boolean value = getProps().getMatchContentsHorizontal().getValue();
        Boolean value2 = getProps().getMatchContentsVertical().getValue();
        final float fMo1731toDpu2uoSUM = density.mo1731toDpu2uoSUM((int) (size >> 32));
        final float fMo1731toDpu2uoSUM2 = density.mo1731toDpu2uoSUM((int) (size & 4294967295L));
        if (Intrinsics.areEqual((Object) value, (Object) true) || Intrinsics.areEqual((Object) value2, (Object) true)) {
            Float fValueOf = (!Intrinsics.areEqual((Object) value, (Object) true) || fMo1731toDpu2uoSUM <= 0.0f) ? null : Float.valueOf(fMo1731toDpu2uoSUM);
            Float fValueOf2 = (!Intrinsics.areEqual((Object) value2, (Object) true) || fMo1731toDpu2uoSUM2 <= 0.0f) ? null : Float.valueOf(fMo1731toDpu2uoSUM2);
            getShadowNodeProxy().setStyleSize(fValueOf != null ? Double.valueOf(fValueOf.floatValue()) : null, fValueOf2 != null ? Double.valueOf(fValueOf2.floatValue()) : null);
        }
        post(new Runnable() { // from class: expo.modules.ui.HostView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.getOnLayoutContent().invoke(new LayoutContentEvent(Double.valueOf(fMo1731toDpu2uoSUM), Double.valueOf(fMo1731toDpu2uoSUM2)));
            }
        });
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Boolean value = getProps().getMatchContentsHorizontal().getValue();
        Boolean value2 = getProps().getMatchContentsVertical().getValue();
        if (Intrinsics.areEqual((Object) value, (Object) true) || Intrinsics.areEqual((Object) value2, (Object) true)) {
            if (Intrinsics.areEqual((Object) value, (Object) true)) {
                widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            if (Intrinsics.areEqual((Object) value2, (Object) true)) {
                heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void onViewDidUpdateProps$expo_ui_release() {
        findComposeView().setLayoutParams(new LinearLayout.LayoutParams(Intrinsics.areEqual((Object) getProps().getMatchContentsHorizontal().getValue(), (Object) true) ? -2 : -1, Intrinsics.areEqual((Object) getProps().getMatchContentsVertical().getValue(), (Object) true) ? -2 : -1));
    }

    private final ComposeView findComposeView() {
        ComposeView composeView;
        int childCount = getChildCount();
        do {
            childCount--;
            if (-1 < childCount) {
                View childAt = getChildAt(childCount);
                composeView = childAt instanceof ComposeView ? (ComposeView) childAt : null;
            } else {
                throw new IllegalStateException("No ComposeView found in HostView");
            }
        } while (composeView == null);
        return composeView;
    }
}
