package expo.modules.ui;

import android.graphics.Color;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurfaceView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"SurfaceContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/SurfaceProps;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "onCheckedChange", "Lkotlin/Function1;", "", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SurfaceProps;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SurfaceViewKt {
    static final Unit SurfaceContent$lambda$10(FunctionalComposableScope functionalComposableScope, SurfaceProps surfaceProps, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        SurfaceContent(functionalComposableScope, surfaceProps, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SurfaceContent(final FunctionalComposableScope functionalComposableScope, final SurfaceProps props, final Function0<Unit> onClick, final Function1<? super Boolean, Unit> onCheckedChange, Composer composer, final int i) {
        int i2;
        Composer composer2;
        long jM7348unboximpl;
        long jM7348unboximpl2;
        boolean z;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-923732453);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SurfaceContent)N(props,onClick,onCheckedChange)44@1407L83,47@1652L77,50@1877L11,51@1912L201,58@2155L33:SurfaceView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCheckedChange) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-923732453, i3, -1, "expo.modules.ui.SurfaceContent (SurfaceView.kt:43)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Color color = props.getColor();
            androidx.compose.ui.graphics.Color colorM7328boximpl = color != null ? androidx.compose.ui.graphics.Color.m7328boximpl(UtilsKt.getCompose(color)) : null;
            if (colorM7328boximpl == null) {
                composerStartRestartGroup.startReplaceGroup(1351353410);
                ComposerKt.sourceInformation(composerStartRestartGroup, "45@1543L11");
                jM7348unboximpl = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1351351860);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = colorM7328boximpl.m7348unboximpl();
            }
            Color contentColor = props.getContentColor();
            androidx.compose.ui.graphics.Color colorM7328boximpl2 = contentColor != null ? androidx.compose.ui.graphics.Color.m7328boximpl(UtilsKt.getCompose(contentColor)) : null;
            if (colorM7328boximpl2 == null) {
                composerStartRestartGroup.startReplaceGroup(1351355345);
                ComposerKt.sourceInformation(composerStartRestartGroup, "46@1615L22");
                jM7348unboximpl2 = ColorSchemeKt.m3712contentColorForek8zF_U(jM7348unboximpl, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1351354384);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl2 = colorM7328boximpl2.m7348unboximpl();
            }
            ShapeRecord shape = props.getShape();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1351356584, "CC(remember):SurfaceView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(shape);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Shape shapeShapeFromShapeRecord = ShapeViewKt.shapeFromShapeRecord(props.getShape());
                if (shapeShapeFromShapeRecord == null) {
                    shapeShapeFromShapeRecord = RectangleShapeKt.getRectangleShape();
                }
                objRememberedValue = shapeShapeFromShapeRecord;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Shape shape2 = (Shape) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Float tonalElevation = props.getTonalElevation();
            float fM10168constructorimpl = Dp.m10168constructorimpl(tonalElevation != null ? tonalElevation.floatValue() : 0.0f);
            Float shadowElevation = props.getShadowElevation();
            float fM10168constructorimpl2 = Dp.m10168constructorimpl(shadowElevation != null ? shadowElevation.floatValue() : 0.0f);
            long outline = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOutline();
            SurfaceBorder border = props.getBorder();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1351365028, "CC(remember):SurfaceView.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(border) | composerStartRestartGroup.changed(outline);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                SurfaceBorder border2 = props.getBorder();
                if (border2 != null) {
                    androidx.compose.ui.graphics.Color composeOrNull = UtilsKt.getComposeOrNull(border2.getColor());
                    if (composeOrNull != null) {
                        outline = composeOrNull.m7348unboximpl();
                    }
                    objRememberedValue2 = BorderStrokeKt.m1584BorderStrokecXLIe8U(Dp.m10168constructorimpl(border2.getWidth()), outline);
                } else {
                    objRememberedValue2 = null;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            BorderStroke borderStroke = (BorderStroke) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1067291974, true, new Function2() { // from class: expo.modules.ui.SurfaceViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceViewKt.SurfaceContent$lambda$3(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            if (props.getChecked() != null) {
                composerStartRestartGroup.startReplaceGroup(1351376127);
                ComposerKt.sourceInformation(composerStartRestartGroup, "64@2318L23,62@2254L356");
                boolean zBooleanValue = props.getChecked().booleanValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1351377842, "CC(remember):SurfaceView.kt#9igjgp");
                z = (i3 & 7168) == 2048;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: expo.modules.ui.SurfaceViewKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SurfaceViewKt.SurfaceContent$lambda$5$lambda$4(onCheckedChange, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4783Surfaced85dljk(zBooleanValue, (Function1<? super Boolean, Unit>) objRememberedValue3, modifierApplyModifiers, props.getEnabled(), shape2, jM7348unboximpl, jM7348unboximpl2, fM10168constructorimpl, fM10168constructorimpl2, borderStroke, (MutableInteractionSource) null, composableLambdaRememberComposableLambda, composer2, 0, 48, 1024);
                composer2.endReplaceGroup();
            } else {
                long j = jM7348unboximpl2;
                if (props.getSelected() != null) {
                    composerStartRestartGroup.startReplaceGroup(1351389327);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "78@2725L13,76@2667L340");
                    boolean zBooleanValue2 = props.getSelected().booleanValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1351390856, "CC(remember):SurfaceView.kt#9igjgp");
                    z = (i3 & 896) == 256;
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: expo.modules.ui.SurfaceViewKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SurfaceViewKt.SurfaceContent$lambda$7$lambda$6(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4782Surfaced85dljk(zBooleanValue2, (Function0<Unit>) objRememberedValue4, modifierApplyModifiers, props.getEnabled(), shape2, jM7348unboximpl, j, fM10168constructorimpl, fM10168constructorimpl2, borderStroke, (MutableInteractionSource) null, composableLambdaRememberComposableLambda, composer2, 0, 48, 1024);
                    composer2.endReplaceGroup();
                } else if (props.getClickable()) {
                    composerStartRestartGroup.startReplaceGroup(1351401742);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "91@3081L13,90@3056L307");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1351402248, "CC(remember):SurfaceView.kt#9igjgp");
                    z = (i3 & 896) == 256;
                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: expo.modules.ui.SurfaceViewKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SurfaceViewKt.SurfaceContent$lambda$9$lambda$8(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SurfaceKt.m4784Surfaceo_FOJdg((Function0) objRememberedValue5, modifierApplyModifiers, props.getEnabled(), shape2, jM7348unboximpl, j, fM10168constructorimpl, fM10168constructorimpl2, borderStroke, null, composableLambdaRememberComposableLambda, composerStartRestartGroup, 0, 6, 512);
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1351413168);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "103@3415L245");
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4781SurfaceT9BRK9s(modifierApplyModifiers, shape2, jM7348unboximpl, j, fM10168constructorimpl, fM10168constructorimpl2, borderStroke, composableLambdaRememberComposableLambda, composer2, 12582912, 0);
                    composer2.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SurfaceViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceViewKt.SurfaceContent$lambda$10(functionalComposableScope, props, onClick, onCheckedChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SurfaceContent$lambda$3(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C58@2157L29:SurfaceView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1067291974, i, -1, "expo.modules.ui.SurfaceContent.<anonymous> (SurfaceView.kt:58)");
            }
            functionalComposableScope.Children(new UIComposableScope(null, null, null, null, 15, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit SurfaceContent$lambda$5$lambda$4(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    static final Unit SurfaceContent$lambda$7$lambda$6(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit SurfaceContent$lambda$9$lambda$8(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
