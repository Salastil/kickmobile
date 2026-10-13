package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.LoadingIndicatorDefaults;
import androidx.compose.material3.MotionSchemeKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PullToRefresh.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\u001a\u0095\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001e\b\u0002\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001e\b\u0002\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0017\u001aC\u0010\u0018\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001a\u001a\r\u0010\u001b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001c\u001a\b\u0010\u001d\u001a\u00020\tH\u0007\u001a\u001f\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0003¢\u0006\u0004\b#\u0010$\u001a;\u0010%\u001a\u00020\u0001*\u00020&2\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0013H\u0002¢\u0006\u0004\b.\u0010/\u001a\u0010\u00100\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020(H\u0002\u001aC\u00101\u001a\u00020\u0001*\u00020&2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020,2\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0013H\u0002¢\u0006\u0004\b5\u00106\"\u000e\u00107\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00108\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0010\u0010:\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0016\u0010;\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b<\u0010=\"\u0016\u0010>\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b?\u0010=\"\u0010\u0010@\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0010\u0010A\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0016\u0010B\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\bC\u0010=\"\u0016\u0010D\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\bE\u0010=\"\u000e\u0010F\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010G\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010H\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000¨\u0006I²\u0006\n\u0010J\u001a\u00020(X\u008a\u0084\u0002"}, d2 = {"PullToRefreshBox", "", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "indicator", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "enabled", "threshold", "Landroidx/compose/ui/unit/Dp;", "content", "PullToRefreshBox-gMrHQkA", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function3;ZFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "pullToRefresh", "pullToRefresh-Z4HSEVQ", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;", "rememberPullToRefreshState", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "PullToRefreshState", "CircularArrowProgressIndicator", "progress", "Landroidx/compose/material3/internal/FloatProducer;", "color", "Landroidx/compose/ui/graphics/Color;", "CircularArrowProgressIndicator-RPmYEkk", "(Landroidx/compose/material3/internal/FloatProducer;JLandroidx/compose/runtime/Composer;I)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "alpha", "", "values", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", "arcBounds", "Landroidx/compose/ui/geometry/Rect;", "strokeWidth", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "ArrowValues", "drawArrow", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "MaxProgressArc", "StrokeWidth", "F", "ArcRadius", "SpinnerSize", "getSpinnerSize", "()F", "SpinnerContainerSize", "getSpinnerContainerSize", "ArrowWidth", "ArrowHeight", "LoaderIndicatorHeight", "getLoaderIndicatorHeight", "LoaderIndicatorWidth", "getLoaderIndicatorWidth", "MinAlpha", "MaxAlpha", "DragMultiplier", "material3", "targetAlpha"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PullToRefreshKt {
    private static final float DragMultiplier = 0.5f;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float StrokeWidth = Dp.m10168constructorimpl(2.5f);
    private static final float ArcRadius = Dp.m10168constructorimpl(5.5f);
    private static final float SpinnerSize = Dp.m10168constructorimpl(16.0f);
    private static final float SpinnerContainerSize = Dp.m10168constructorimpl(40.0f);
    private static final float ArrowWidth = Dp.m10168constructorimpl(10.0f);
    private static final float ArrowHeight = Dp.m10168constructorimpl(5.0f);
    private static final float LoaderIndicatorHeight = LoadingIndicatorDefaults.INSTANCE.m4284getContainerHeightD9Ej5fM();
    private static final float LoaderIndicatorWidth = LoadingIndicatorDefaults.INSTANCE.m4285getContainerWidthD9Ej5fM();

    static final Unit CircularArrowProgressIndicator_RPmYEkk$lambda$5(FloatProducer floatProducer, long j, int i, Composer composer, int i2) {
        m5524CircularArrowProgressIndicatorRPmYEkk(floatProducer, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit PullToRefreshBox$lambda$1(boolean z, Function0 function0, Modifier modifier, PullToRefreshState pullToRefreshState, Alignment alignment, Function3 function3, Function3 function4, int i, int i2, Composer composer, int i3) {
        PullToRefreshBox(z, function0, modifier, pullToRefreshState, alignment, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit PullToRefreshBox_gMrHQkA$lambda$2(boolean z, Function0 function0, Modifier modifier, PullToRefreshState pullToRefreshState, Alignment alignment, Function3 function3, boolean z2, float f, Function3 function4, int i, int i2, Composer composer, int i3) {
        m5525PullToRefreshBoxgMrHQkA(z, function0, modifier, pullToRefreshState, alignment, function3, z2, f, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit PullToRefreshBox_gMrHQkA$lambda$0(PullToRefreshState pullToRefreshState, boolean z, BoxScope boxScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C140@6561L148:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(boxScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(419143791, i2, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox.<anonymous> (PullToRefresh.kt:140)");
            }
            PullToRefreshDefaults.INSTANCE.m5516Indicator2poqoh4(pullToRefreshState, z, boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), 0L, 0L, 0.0f, composer, 1572864, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0138 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x013a  */
    /* JADX WARN: Code duplicated, block: B:109:0x0143  */
    /* JADX WARN: Code duplicated, block: B:110:0x014b  */
    /* JADX WARN: Code duplicated, block: B:112:0x014e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0157  */
    /* JADX WARN: Code duplicated, block: B:117:0x016b  */
    /* JADX WARN: Code duplicated, block: B:119:0x016f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0176  */
    /* JADX WARN: Code duplicated, block: B:123:0x0181  */
    /* JADX WARN: Code duplicated, block: B:126:0x01df  */
    /* JADX WARN: Code duplicated, block: B:129:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:133:0x026c  */
    /* JADX WARN: Code duplicated, block: B:135:0x0273  */
    /* JADX WARN: Code duplicated, block: B:138:0x0284  */
    /* JADX WARN: Code duplicated, block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00df  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:92:0x010b  */
    /* JADX WARN: Code duplicated, block: B:93:0x010d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0116  */
    /* JADX WARN: Code duplicated, block: B:98:0x0122  */
    /* JADX INFO: renamed from: PullToRefreshBox-gMrHQkA, reason: not valid java name */
    public static final void m5525PullToRefreshBoxgMrHQkA(final boolean z, final Function0<Unit> function0, Modifier modifier, PullToRefreshState pullToRefreshState, Alignment alignment, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, boolean z2, float f, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        PullToRefreshState pullToRefreshState2;
        int i4;
        Alignment topStart;
        int i5;
        int i6;
        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z3;
        final float f2;
        final PullToRefreshState pullToRefreshState3;
        final boolean z4;
        final Modifier modifier3;
        final Alignment alignment2;
        final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final PullToRefreshState pullToRefreshStateRememberPullToRefreshState;
        boolean z5;
        float fM5522getPositionalThresholdD9Ej5fM;
        Function0<ComposeUiNode> constructor;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(492221845);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PullToRefreshBox)N(isRefreshing,onRefresh,modifier,state,contentAlignment,indicator,enabled,threshold:c#ui.unit.Dp,content)150@6863L313:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i13 = i2 & 4;
        if (i13 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    pullToRefreshState2 = pullToRefreshState;
                    int i14 = composerStartRestartGroup.changed(pullToRefreshState2) ? 2048 : 1024;
                    i3 |= i14;
                } else {
                    pullToRefreshState2 = pullToRefreshState;
                }
                i3 |= i14;
            } else {
                pullToRefreshState2 = pullToRefreshState;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    topStart = alignment;
                    if (composerStartRestartGroup.changed(topStart)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        function3RememberComposableLambda = function3;
                        if (composerStartRestartGroup.changedInstance(function3RememberComposableLambda)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(f)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i12 = 67108864;
                            } else {
                                i12 = GroupFlagsKt.HasAuxSlotFlag;
                            }
                            i3 |= i12;
                        }
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i2 & 8) != 0) {
                                    pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                                    i3 &= -7169;
                                } else {
                                    pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                                }
                                if (i4 != 0) {
                                    topStart = Alignment.INSTANCE.getTopStart();
                                }
                                if (i6 != 0) {
                                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                        }
                                    }, composerStartRestartGroup, 54);
                                }
                                z5 = i8 == 0 ? z2 : true;
                                if (i10 != 0) {
                                    fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                                } else {
                                    fM5522getPositionalThresholdD9Ej5fM = f;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                z5 = z2;
                                fM5522getPositionalThresholdD9Ej5fM = f;
                                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                            }
                            float f3 = fM5522getPositionalThresholdD9Ej5fM;
                            PullToRefreshState pullToRefreshState4 = pullToRefreshStateRememberPullToRefreshState;
                            boolean z6 = z5;
                            Modifier modifier4 = modifier2;
                            Modifier modifierM5529pullToRefreshZ4HSEVQ = m5529pullToRefreshZ4HSEVQ(modifier4, z, pullToRefreshState4, z6, f3, function0);
                            modifier2 = modifier4;
                            pullToRefreshState3 = pullToRefreshState4;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int i15 = i3;
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
                            Updater.m6446setimpl(composerM6438constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                            function4.invoke(boxScopeInstance, composerStartRestartGroup, Integer.valueOf(((i15 >> 21) & 112) | 6));
                            function3RememberComposableLambda.invoke(boxScopeInstance, composerStartRestartGroup, Integer.valueOf(((i15 >> 12) & 112) | 6));
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f2 = f3;
                            z4 = z6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            f2 = f;
                            pullToRefreshState3 = pullToRefreshState2;
                            z4 = z2;
                        }
                        modifier3 = modifier2;
                        alignment2 = topStart;
                        function5 = function3RememberComposableLambda;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i12 = 67108864;
                        } else {
                            i12 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                                i3 &= -7169;
                            } else {
                                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                            }
                            if (i4 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            }
                            if (i6 != 0) {
                                function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            if (i8 == 0) {
                            }
                            if (i10 != 0) {
                                fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                            } else {
                                fM5522getPositionalThresholdD9Ej5fM = f;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                                i3 &= -7169;
                            } else {
                                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                            }
                            if (i4 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            }
                            if (i6 != 0) {
                                function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            if (i8 == 0) {
                            }
                            if (i10 != 0) {
                                fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                            } else {
                                fM5522getPositionalThresholdD9Ej5fM = f;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                        }
                        float f4 = fM5522getPositionalThresholdD9Ej5fM;
                        PullToRefreshState pullToRefreshState5 = pullToRefreshStateRememberPullToRefreshState;
                        boolean z7 = z5;
                        Modifier modifier5 = modifier2;
                        Modifier modifierM5529pullToRefreshZ4HSEVQ2 = m5529pullToRefreshZ4HSEVQ(modifier5, z, pullToRefreshState5, z7, f4, function0);
                        modifier2 = modifier5;
                        pullToRefreshState3 = pullToRefreshState5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ2);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int i16 = i3;
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
                        Composer composerM6438constructorimpl2 = Updater.m6438constructorimpl(composerStartRestartGroup);
                        Updater.m6446setimpl(composerM6438constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6446setimpl(composerM6438constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6446setimpl(composerM6438constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6444reconcileimpl(composerM6438constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6446setimpl(composerM6438constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                        function4.invoke(boxScopeInstance2, composerStartRestartGroup, Integer.valueOf(((i16 >> 21) & 112) | 6));
                        function3RememberComposableLambda.invoke(boxScopeInstance2, composerStartRestartGroup, Integer.valueOf(((i16 >> 12) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f2 = f4;
                        z4 = z7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        f2 = f;
                        pullToRefreshState3 = pullToRefreshState2;
                        z4 = z2;
                    }
                    modifier3 = modifier2;
                    alignment2 = topStart;
                    function5 = function3RememberComposableLambda;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function3RememberComposableLambda = function3;
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i12 = 67108864;
                        } else {
                            i12 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                                i3 &= -7169;
                            } else {
                                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                            }
                            if (i4 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            }
                            if (i6 != 0) {
                                function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            if (i8 == 0) {
                            }
                            if (i10 != 0) {
                                fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                            } else {
                                fM5522getPositionalThresholdD9Ej5fM = f;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                                i3 &= -7169;
                            } else {
                                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                            }
                            if (i4 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            }
                            if (i6 != 0) {
                                function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            if (i8 == 0) {
                            }
                            if (i10 != 0) {
                                fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                            } else {
                                fM5522getPositionalThresholdD9Ej5fM = f;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                        }
                        float f5 = fM5522getPositionalThresholdD9Ej5fM;
                        PullToRefreshState pullToRefreshState6 = pullToRefreshStateRememberPullToRefreshState;
                        boolean z8 = z5;
                        Modifier modifier6 = modifier2;
                        Modifier modifierM5529pullToRefreshZ4HSEVQ3 = m5529pullToRefreshZ4HSEVQ(modifier6, z, pullToRefreshState6, z8, f5, function0);
                        modifier2 = modifier6;
                        pullToRefreshState3 = pullToRefreshState6;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ3);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int i17 = i3;
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
                        Composer composerM6438constructorimpl3 = Updater.m6438constructorimpl(composerStartRestartGroup);
                        Updater.m6446setimpl(composerM6438constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6446setimpl(composerM6438constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6446setimpl(composerM6438constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6444reconcileimpl(composerM6438constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6446setimpl(composerM6438constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                        function4.invoke(boxScopeInstance3, composerStartRestartGroup, Integer.valueOf(((i17 >> 21) & 112) | 6));
                        function3RememberComposableLambda.invoke(boxScopeInstance3, composerStartRestartGroup, Integer.valueOf(((i17 >> 12) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f2 = f5;
                        z4 = z8;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        f2 = f;
                        pullToRefreshState3 = pullToRefreshState2;
                        z4 = z2;
                    }
                    modifier3 = modifier2;
                    alignment2 = topStart;
                    function5 = function3RememberComposableLambda;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 67108864;
                    } else {
                        i12 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i12;
                }
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        } else {
                            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                            fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                        } else {
                            fM5522getPositionalThresholdD9Ej5fM = f;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        } else {
                            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                            fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                        } else {
                            fM5522getPositionalThresholdD9Ej5fM = f;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                    }
                    float f6 = fM5522getPositionalThresholdD9Ej5fM;
                    PullToRefreshState pullToRefreshState7 = pullToRefreshStateRememberPullToRefreshState;
                    boolean z9 = z5;
                    Modifier modifier7 = modifier2;
                    Modifier modifierM5529pullToRefreshZ4HSEVQ4 = m5529pullToRefreshZ4HSEVQ(modifier7, z, pullToRefreshState7, z9, f6, function0);
                    modifier2 = modifier7;
                    pullToRefreshState3 = pullToRefreshState7;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ4);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i18 = i3;
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
                    Composer composerM6438constructorimpl4 = Updater.m6438constructorimpl(composerStartRestartGroup);
                    Updater.m6446setimpl(composerM6438constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6446setimpl(composerM6438constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6446setimpl(composerM6438constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6444reconcileimpl(composerM6438constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6446setimpl(composerM6438constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                    function4.invoke(boxScopeInstance4, composerStartRestartGroup, Integer.valueOf(((i18 >> 21) & 112) | 6));
                    function3RememberComposableLambda.invoke(boxScopeInstance4, composerStartRestartGroup, Integer.valueOf(((i18 >> 12) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = f6;
                    z4 = z9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = f;
                    pullToRefreshState3 = pullToRefreshState2;
                    z4 = z2;
                }
                modifier3 = modifier2;
                alignment2 = topStart;
                function5 = function3RememberComposableLambda;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            topStart = alignment;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function3RememberComposableLambda = function3;
                    if (composerStartRestartGroup.changedInstance(function3RememberComposableLambda)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i12 = 67108864;
                        } else {
                            i12 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                                i3 &= -7169;
                            } else {
                                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                            }
                            if (i4 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            }
                            if (i6 != 0) {
                                function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            if (i8 == 0) {
                            }
                            if (i10 != 0) {
                                fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                            } else {
                                fM5522getPositionalThresholdD9Ej5fM = f;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                                i3 &= -7169;
                            } else {
                                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                            }
                            if (i4 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            }
                            if (i6 != 0) {
                                function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            if (i8 == 0) {
                            }
                            if (i10 != 0) {
                                fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                            } else {
                                fM5522getPositionalThresholdD9Ej5fM = f;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                        }
                        float f7 = fM5522getPositionalThresholdD9Ej5fM;
                        PullToRefreshState pullToRefreshState8 = pullToRefreshStateRememberPullToRefreshState;
                        boolean z10 = z5;
                        Modifier modifier8 = modifier2;
                        Modifier modifierM5529pullToRefreshZ4HSEVQ5 = m5529pullToRefreshZ4HSEVQ(modifier8, z, pullToRefreshState8, z10, f7, function0);
                        modifier2 = modifier8;
                        pullToRefreshState3 = pullToRefreshState8;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ5);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int i19 = i3;
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
                        Composer composerM6438constructorimpl5 = Updater.m6438constructorimpl(composerStartRestartGroup);
                        Updater.m6446setimpl(composerM6438constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6446setimpl(composerM6438constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6446setimpl(composerM6438constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6444reconcileimpl(composerM6438constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6446setimpl(composerM6438constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                        function4.invoke(boxScopeInstance5, composerStartRestartGroup, Integer.valueOf(((i19 >> 21) & 112) | 6));
                        function3RememberComposableLambda.invoke(boxScopeInstance5, composerStartRestartGroup, Integer.valueOf(((i19 >> 12) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f2 = f7;
                        z4 = z10;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        f2 = f;
                        pullToRefreshState3 = pullToRefreshState2;
                        z4 = z2;
                    }
                    modifier3 = modifier2;
                    alignment2 = topStart;
                    function5 = function3RememberComposableLambda;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 67108864;
                    } else {
                        i12 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i12;
                }
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        } else {
                            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                            fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                        } else {
                            fM5522getPositionalThresholdD9Ej5fM = f;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        } else {
                            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                            fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                        } else {
                            fM5522getPositionalThresholdD9Ej5fM = f;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                    }
                    float f8 = fM5522getPositionalThresholdD9Ej5fM;
                    PullToRefreshState pullToRefreshState9 = pullToRefreshStateRememberPullToRefreshState;
                    boolean z11 = z5;
                    Modifier modifier9 = modifier2;
                    Modifier modifierM5529pullToRefreshZ4HSEVQ6 = m5529pullToRefreshZ4HSEVQ(modifier9, z, pullToRefreshState9, z11, f8, function0);
                    modifier2 = modifier9;
                    pullToRefreshState3 = pullToRefreshState9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ6);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i110 = i3;
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
                    Composer composerM6438constructorimpl6 = Updater.m6438constructorimpl(composerStartRestartGroup);
                    Updater.m6446setimpl(composerM6438constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6446setimpl(composerM6438constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6446setimpl(composerM6438constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6444reconcileimpl(composerM6438constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6446setimpl(composerM6438constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                    function4.invoke(boxScopeInstance6, composerStartRestartGroup, Integer.valueOf(((i110 >> 21) & 112) | 6));
                    function3RememberComposableLambda.invoke(boxScopeInstance6, composerStartRestartGroup, Integer.valueOf(((i110 >> 12) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = f8;
                    z4 = z11;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = f;
                    pullToRefreshState3 = pullToRefreshState2;
                    z4 = z2;
                }
                modifier3 = modifier2;
                alignment2 = topStart;
                function5 = function3RememberComposableLambda;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3RememberComposableLambda = function3;
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 67108864;
                    } else {
                        i12 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i12;
                }
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        } else {
                            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                            fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                        } else {
                            fM5522getPositionalThresholdD9Ej5fM = f;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        } else {
                            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                            fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                        } else {
                            fM5522getPositionalThresholdD9Ej5fM = f;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                    }
                    float f9 = fM5522getPositionalThresholdD9Ej5fM;
                    PullToRefreshState pullToRefreshState10 = pullToRefreshStateRememberPullToRefreshState;
                    boolean z12 = z5;
                    Modifier modifier10 = modifier2;
                    Modifier modifierM5529pullToRefreshZ4HSEVQ7 = m5529pullToRefreshZ4HSEVQ(modifier10, z, pullToRefreshState10, z12, f9, function0);
                    modifier2 = modifier10;
                    pullToRefreshState3 = pullToRefreshState10;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ7);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i111 = i3;
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
                    Composer composerM6438constructorimpl7 = Updater.m6438constructorimpl(composerStartRestartGroup);
                    Updater.m6446setimpl(composerM6438constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6446setimpl(composerM6438constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6446setimpl(composerM6438constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6444reconcileimpl(composerM6438constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6446setimpl(composerM6438constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                    function4.invoke(boxScopeInstance7, composerStartRestartGroup, Integer.valueOf(((i111 >> 21) & 112) | 6));
                    function3RememberComposableLambda.invoke(boxScopeInstance7, composerStartRestartGroup, Integer.valueOf(((i111 >> 12) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = f9;
                    z4 = z12;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = f;
                    pullToRefreshState3 = pullToRefreshState2;
                    z4 = z2;
                }
                modifier3 = modifier2;
                alignment2 = topStart;
                function5 = function3RememberComposableLambda;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 67108864;
                } else {
                    i12 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i3 |= i12;
            }
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    } else {
                        pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                    } else {
                        fM5522getPositionalThresholdD9Ej5fM = f;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    } else {
                        pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                    } else {
                        fM5522getPositionalThresholdD9Ej5fM = f;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                }
                float f10 = fM5522getPositionalThresholdD9Ej5fM;
                PullToRefreshState pullToRefreshState11 = pullToRefreshStateRememberPullToRefreshState;
                boolean z13 = z5;
                Modifier modifier11 = modifier2;
                Modifier modifierM5529pullToRefreshZ4HSEVQ8 = m5529pullToRefreshZ4HSEVQ(modifier11, z, pullToRefreshState11, z13, f10, function0);
                modifier2 = modifier11;
                pullToRefreshState3 = pullToRefreshState11;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ8);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i112 = i3;
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
                Composer composerM6438constructorimpl8 = Updater.m6438constructorimpl(composerStartRestartGroup);
                Updater.m6446setimpl(composerM6438constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6446setimpl(composerM6438constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6446setimpl(composerM6438constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6444reconcileimpl(composerM6438constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6446setimpl(composerM6438constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                function4.invoke(boxScopeInstance8, composerStartRestartGroup, Integer.valueOf(((i112 >> 21) & 112) | 6));
                function3RememberComposableLambda.invoke(boxScopeInstance8, composerStartRestartGroup, Integer.valueOf(((i112 >> 12) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f10;
                z4 = z13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f2 = f;
                pullToRefreshState3 = pullToRefreshState2;
                z4 = z2;
            }
            modifier3 = modifier2;
            alignment2 = topStart;
            function5 = function3RememberComposableLambda;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                pullToRefreshState2 = pullToRefreshState;
                if (composerStartRestartGroup.changed(pullToRefreshState2)) {
                }
                i3 |= i14;
            } else {
                pullToRefreshState2 = pullToRefreshState;
            }
            i3 |= i14;
        } else {
            pullToRefreshState2 = pullToRefreshState;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                topStart = alignment;
                if (composerStartRestartGroup.changed(topStart)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function3RememberComposableLambda = function3;
                    if (composerStartRestartGroup.changedInstance(function3RememberComposableLambda)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i12 = 67108864;
                        } else {
                            i12 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                                i3 &= -7169;
                            } else {
                                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                            }
                            if (i4 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            }
                            if (i6 != 0) {
                                function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            if (i8 == 0) {
                            }
                            if (i10 != 0) {
                                fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                            } else {
                                fM5522getPositionalThresholdD9Ej5fM = f;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                                i3 &= -7169;
                            } else {
                                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                            }
                            if (i4 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            }
                            if (i6 != 0) {
                                function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            if (i8 == 0) {
                            }
                            if (i10 != 0) {
                                fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                            } else {
                                fM5522getPositionalThresholdD9Ej5fM = f;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                        }
                        float f11 = fM5522getPositionalThresholdD9Ej5fM;
                        PullToRefreshState pullToRefreshState12 = pullToRefreshStateRememberPullToRefreshState;
                        boolean z14 = z5;
                        Modifier modifier12 = modifier2;
                        Modifier modifierM5529pullToRefreshZ4HSEVQ9 = m5529pullToRefreshZ4HSEVQ(modifier12, z, pullToRefreshState12, z14, f11, function0);
                        modifier2 = modifier12;
                        pullToRefreshState3 = pullToRefreshState12;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ9);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int i113 = i3;
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
                        Composer composerM6438constructorimpl9 = Updater.m6438constructorimpl(composerStartRestartGroup);
                        Updater.m6446setimpl(composerM6438constructorimpl9, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6446setimpl(composerM6438constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6446setimpl(composerM6438constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6444reconcileimpl(composerM6438constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6446setimpl(composerM6438constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                        function4.invoke(boxScopeInstance9, composerStartRestartGroup, Integer.valueOf(((i113 >> 21) & 112) | 6));
                        function3RememberComposableLambda.invoke(boxScopeInstance9, composerStartRestartGroup, Integer.valueOf(((i113 >> 12) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f2 = f11;
                        z4 = z14;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        f2 = f;
                        pullToRefreshState3 = pullToRefreshState2;
                        z4 = z2;
                    }
                    modifier3 = modifier2;
                    alignment2 = topStart;
                    function5 = function3RememberComposableLambda;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 67108864;
                    } else {
                        i12 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i12;
                }
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        } else {
                            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                            fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                        } else {
                            fM5522getPositionalThresholdD9Ej5fM = f;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        } else {
                            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                            fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                        } else {
                            fM5522getPositionalThresholdD9Ej5fM = f;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                    }
                    float f12 = fM5522getPositionalThresholdD9Ej5fM;
                    PullToRefreshState pullToRefreshState13 = pullToRefreshStateRememberPullToRefreshState;
                    boolean z15 = z5;
                    Modifier modifier13 = modifier2;
                    Modifier modifierM5529pullToRefreshZ4HSEVQ10 = m5529pullToRefreshZ4HSEVQ(modifier13, z, pullToRefreshState13, z15, f12, function0);
                    modifier2 = modifier13;
                    pullToRefreshState3 = pullToRefreshState13;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ10);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i114 = i3;
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
                    Composer composerM6438constructorimpl10 = Updater.m6438constructorimpl(composerStartRestartGroup);
                    Updater.m6446setimpl(composerM6438constructorimpl10, measurePolicyMaybeCachedBoxMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6446setimpl(composerM6438constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6446setimpl(composerM6438constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6444reconcileimpl(composerM6438constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6446setimpl(composerM6438constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                    function4.invoke(boxScopeInstance10, composerStartRestartGroup, Integer.valueOf(((i114 >> 21) & 112) | 6));
                    function3RememberComposableLambda.invoke(boxScopeInstance10, composerStartRestartGroup, Integer.valueOf(((i114 >> 12) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = f12;
                    z4 = z15;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = f;
                    pullToRefreshState3 = pullToRefreshState2;
                    z4 = z2;
                }
                modifier3 = modifier2;
                alignment2 = topStart;
                function5 = function3RememberComposableLambda;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3RememberComposableLambda = function3;
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 67108864;
                    } else {
                        i12 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i12;
                }
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        } else {
                            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                            fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                        } else {
                            fM5522getPositionalThresholdD9Ej5fM = f;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        } else {
                            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                            fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                        } else {
                            fM5522getPositionalThresholdD9Ej5fM = f;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                    }
                    float f13 = fM5522getPositionalThresholdD9Ej5fM;
                    PullToRefreshState pullToRefreshState14 = pullToRefreshStateRememberPullToRefreshState;
                    boolean z16 = z5;
                    Modifier modifier14 = modifier2;
                    Modifier modifierM5529pullToRefreshZ4HSEVQ11 = m5529pullToRefreshZ4HSEVQ(modifier14, z, pullToRefreshState14, z16, f13, function0);
                    modifier2 = modifier14;
                    pullToRefreshState3 = pullToRefreshState14;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ11);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i115 = i3;
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
                    Composer composerM6438constructorimpl11 = Updater.m6438constructorimpl(composerStartRestartGroup);
                    Updater.m6446setimpl(composerM6438constructorimpl11, measurePolicyMaybeCachedBoxMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6446setimpl(composerM6438constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6446setimpl(composerM6438constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6444reconcileimpl(composerM6438constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6446setimpl(composerM6438constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                    function4.invoke(boxScopeInstance11, composerStartRestartGroup, Integer.valueOf(((i115 >> 21) & 112) | 6));
                    function3RememberComposableLambda.invoke(boxScopeInstance11, composerStartRestartGroup, Integer.valueOf(((i115 >> 12) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = f13;
                    z4 = z16;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = f;
                    pullToRefreshState3 = pullToRefreshState2;
                    z4 = z2;
                }
                modifier3 = modifier2;
                alignment2 = topStart;
                function5 = function3RememberComposableLambda;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 67108864;
                } else {
                    i12 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i3 |= i12;
            }
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    } else {
                        pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                    } else {
                        fM5522getPositionalThresholdD9Ej5fM = f;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    } else {
                        pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                    } else {
                        fM5522getPositionalThresholdD9Ej5fM = f;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                }
                float f14 = fM5522getPositionalThresholdD9Ej5fM;
                PullToRefreshState pullToRefreshState15 = pullToRefreshStateRememberPullToRefreshState;
                boolean z17 = z5;
                Modifier modifier15 = modifier2;
                Modifier modifierM5529pullToRefreshZ4HSEVQ12 = m5529pullToRefreshZ4HSEVQ(modifier15, z, pullToRefreshState15, z17, f14, function0);
                modifier2 = modifier15;
                pullToRefreshState3 = pullToRefreshState15;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ12);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i116 = i3;
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
                Composer composerM6438constructorimpl12 = Updater.m6438constructorimpl(composerStartRestartGroup);
                Updater.m6446setimpl(composerM6438constructorimpl12, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6446setimpl(composerM6438constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6446setimpl(composerM6438constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6444reconcileimpl(composerM6438constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6446setimpl(composerM6438constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                function4.invoke(boxScopeInstance12, composerStartRestartGroup, Integer.valueOf(((i116 >> 21) & 112) | 6));
                function3RememberComposableLambda.invoke(boxScopeInstance12, composerStartRestartGroup, Integer.valueOf(((i116 >> 12) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f14;
                z4 = z17;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f2 = f;
                pullToRefreshState3 = pullToRefreshState2;
                z4 = z2;
            }
            modifier3 = modifier2;
            alignment2 = topStart;
            function5 = function3RememberComposableLambda;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        topStart = alignment;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                function3RememberComposableLambda = function3;
                if (composerStartRestartGroup.changedInstance(function3RememberComposableLambda)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 67108864;
                    } else {
                        i12 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i12;
                }
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        } else {
                            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                            fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                        } else {
                            fM5522getPositionalThresholdD9Ej5fM = f;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        } else {
                            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        if (i8 == 0) {
                        }
                        if (i10 != 0) {
                            fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                        } else {
                            fM5522getPositionalThresholdD9Ej5fM = f;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                    }
                    float f15 = fM5522getPositionalThresholdD9Ej5fM;
                    PullToRefreshState pullToRefreshState16 = pullToRefreshStateRememberPullToRefreshState;
                    boolean z18 = z5;
                    Modifier modifier16 = modifier2;
                    Modifier modifierM5529pullToRefreshZ4HSEVQ13 = m5529pullToRefreshZ4HSEVQ(modifier16, z, pullToRefreshState16, z18, f15, function0);
                    modifier2 = modifier16;
                    pullToRefreshState3 = pullToRefreshState16;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ13);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i117 = i3;
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
                    Composer composerM6438constructorimpl13 = Updater.m6438constructorimpl(composerStartRestartGroup);
                    Updater.m6446setimpl(composerM6438constructorimpl13, measurePolicyMaybeCachedBoxMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6446setimpl(composerM6438constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6446setimpl(composerM6438constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6444reconcileimpl(composerM6438constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6446setimpl(composerM6438constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                    function4.invoke(boxScopeInstance13, composerStartRestartGroup, Integer.valueOf(((i117 >> 21) & 112) | 6));
                    function3RememberComposableLambda.invoke(boxScopeInstance13, composerStartRestartGroup, Integer.valueOf(((i117 >> 12) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = f15;
                    z4 = z18;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = f;
                    pullToRefreshState3 = pullToRefreshState2;
                    z4 = z2;
                }
                modifier3 = modifier2;
                alignment2 = topStart;
                function5 = function3RememberComposableLambda;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 67108864;
                } else {
                    i12 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i3 |= i12;
            }
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    } else {
                        pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                    } else {
                        fM5522getPositionalThresholdD9Ej5fM = f;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    } else {
                        pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                    } else {
                        fM5522getPositionalThresholdD9Ej5fM = f;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                }
                float f16 = fM5522getPositionalThresholdD9Ej5fM;
                PullToRefreshState pullToRefreshState17 = pullToRefreshStateRememberPullToRefreshState;
                boolean z19 = z5;
                Modifier modifier17 = modifier2;
                Modifier modifierM5529pullToRefreshZ4HSEVQ14 = m5529pullToRefreshZ4HSEVQ(modifier17, z, pullToRefreshState17, z19, f16, function0);
                modifier2 = modifier17;
                pullToRefreshState3 = pullToRefreshState17;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ14);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i118 = i3;
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
                Composer composerM6438constructorimpl14 = Updater.m6438constructorimpl(composerStartRestartGroup);
                Updater.m6446setimpl(composerM6438constructorimpl14, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6446setimpl(composerM6438constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6446setimpl(composerM6438constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6444reconcileimpl(composerM6438constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6446setimpl(composerM6438constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                function4.invoke(boxScopeInstance14, composerStartRestartGroup, Integer.valueOf(((i118 >> 21) & 112) | 6));
                function3RememberComposableLambda.invoke(boxScopeInstance14, composerStartRestartGroup, Integer.valueOf(((i118 >> 12) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f16;
                z4 = z19;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f2 = f;
                pullToRefreshState3 = pullToRefreshState2;
                z4 = z2;
            }
            modifier3 = modifier2;
            alignment2 = topStart;
            function5 = function3RememberComposableLambda;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function3RememberComposableLambda = function3;
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        i10 = i2 & 128;
        if (i10 != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 67108864;
                } else {
                    i12 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i3 |= i12;
            }
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    } else {
                        pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                    } else {
                        fM5522getPositionalThresholdD9Ej5fM = f;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    } else {
                        pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                    } else {
                        fM5522getPositionalThresholdD9Ej5fM = f;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
                }
                float f17 = fM5522getPositionalThresholdD9Ej5fM;
                PullToRefreshState pullToRefreshState18 = pullToRefreshStateRememberPullToRefreshState;
                boolean z110 = z5;
                Modifier modifier18 = modifier2;
                Modifier modifierM5529pullToRefreshZ4HSEVQ15 = m5529pullToRefreshZ4HSEVQ(modifier18, z, pullToRefreshState18, z110, f17, function0);
                modifier2 = modifier18;
                pullToRefreshState3 = pullToRefreshState18;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ15);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i119 = i3;
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
                Composer composerM6438constructorimpl15 = Updater.m6438constructorimpl(composerStartRestartGroup);
                Updater.m6446setimpl(composerM6438constructorimpl15, measurePolicyMaybeCachedBoxMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6446setimpl(composerM6438constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6446setimpl(composerM6438constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6444reconcileimpl(composerM6438constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6446setimpl(composerM6438constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
                function4.invoke(boxScopeInstance15, composerStartRestartGroup, Integer.valueOf(((i119 >> 21) & 112) | 6));
                function3RememberComposableLambda.invoke(boxScopeInstance15, composerStartRestartGroup, Integer.valueOf(((i119 >> 12) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f17;
                z4 = z110;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f2 = f;
                pullToRefreshState3 = pullToRefreshState2;
                z4 = z2;
            }
            modifier3 = modifier2;
            alignment2 = topStart;
            function5 = function3RememberComposableLambda;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 12582912;
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i12 = 67108864;
            } else {
                i12 = GroupFlagsKt.HasAuxSlotFlag;
            }
            i3 |= i12;
        }
        if ((i3 & 38347923) != 38347922) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "137@6418L28,139@6551L164");
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                    i3 &= -7169;
                } else {
                    pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                }
                if (i4 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                }
                if (i6 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                if (i8 == 0) {
                }
                if (i10 != 0) {
                    fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                } else {
                    fM5522getPositionalThresholdD9Ej5fM = f;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                    i3 &= -7169;
                } else {
                    pullToRefreshStateRememberPullToRefreshState = pullToRefreshState2;
                }
                if (i4 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                }
                if (i6 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(419143791, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                if (i8 == 0) {
                }
                if (i10 != 0) {
                    fM5522getPositionalThresholdD9Ej5fM = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
                } else {
                    fM5522getPositionalThresholdD9Ej5fM = f;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(492221845, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:149)");
            }
            float f18 = fM5522getPositionalThresholdD9Ej5fM;
            PullToRefreshState pullToRefreshState19 = pullToRefreshStateRememberPullToRefreshState;
            boolean z111 = z5;
            Modifier modifier19 = modifier2;
            Modifier modifierM5529pullToRefreshZ4HSEVQ16 = m5529pullToRefreshZ4HSEVQ(modifier19, z, pullToRefreshState19, z111, f18, function0);
            modifier2 = modifier19;
            pullToRefreshState3 = pullToRefreshState19;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5529pullToRefreshZ4HSEVQ16);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i1110 = i3;
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
            Composer composerM6438constructorimpl16 = Updater.m6438constructorimpl(composerStartRestartGroup);
            Updater.m6446setimpl(composerM6438constructorimpl16, measurePolicyMaybeCachedBoxMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6446setimpl(composerM6438constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6446setimpl(composerM6438constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6444reconcileimpl(composerM6438constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6446setimpl(composerM6438constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1940699061, "C160@7141L9,161@7159L11:PullToRefresh.kt#djiw08");
            function4.invoke(boxScopeInstance16, composerStartRestartGroup, Integer.valueOf(((i1110 >> 21) & 112) | 6));
            function3RememberComposableLambda.invoke(boxScopeInstance16, composerStartRestartGroup, Integer.valueOf(((i1110 >> 12) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f2 = f18;
            z4 = z111;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            f2 = f;
            pullToRefreshState3 = pullToRefreshState2;
            z4 = z2;
        }
        modifier3 = modifier2;
        alignment2 = topStart;
        function5 = function3RememberComposableLambda;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PullToRefreshKt.PullToRefreshBox_gMrHQkA$lambda$2(z, function0, modifier3, pullToRefreshState3, alignment2, function5, z4, f2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit PullToRefreshBox$lambda$0(PullToRefreshState pullToRefreshState, boolean z, BoxScope boxScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C177@7616L148:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(boxScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1028036671, i2, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox.<anonymous> (PullToRefresh.kt:177)");
            }
            PullToRefreshDefaults.INSTANCE.m5516Indicator2poqoh4(pullToRefreshState, z, boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), 0L, 0L, 0.0f, composer, 1572864, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x016f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0177  */
    /* JADX WARN: Code duplicated, block: B:107:0x0184  */
    /* JADX WARN: Code duplicated, block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x0079  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x0095  */
    /* JADX WARN: Code duplicated, block: B:58:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:93:0x0109  */
    /* JADX WARN: Code duplicated, block: B:95:0x0112  */
    /* JADX WARN: Code duplicated, block: B:96:0x0128  */
    /* JADX WARN: Code duplicated, block: B:99:0x0134  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the PullToRefreshBox that takes enabled and threshold parameters")
    public static final /* synthetic */ void PullToRefreshBox(final boolean z, final Function0 function0, Modifier modifier, PullToRefreshState pullToRefreshState, Alignment alignment, Function3 function3, final Function3 function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final PullToRefreshState pullToRefreshStateRememberPullToRefreshState;
        int i4;
        Alignment topStart;
        int i5;
        int i6;
        Function3 function5;
        int i7;
        Function3 function6;
        boolean z2;
        final Modifier modifier3;
        final PullToRefreshState pullToRefreshState2;
        final Alignment alignment2;
        final Function3 function7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i8;
        Modifier modifier4;
        Function3 function3RememberComposableLambda;
        PullToRefreshState pullToRefreshState3;
        Alignment alignment3;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-532332839);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PullToRefreshBox)N(isRefreshing,onRefresh,modifier,state,contentAlignment,indicator,content)185@7826L333:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i10 = i2 & 4;
        if (i10 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    pullToRefreshStateRememberPullToRefreshState = pullToRefreshState;
                    int i11 = composerStartRestartGroup.changed(pullToRefreshStateRememberPullToRefreshState) ? 2048 : 1024;
                    i3 |= i11;
                } else {
                    pullToRefreshStateRememberPullToRefreshState = pullToRefreshState;
                }
                i3 |= i11;
            } else {
                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    topStart = alignment;
                    if (composerStartRestartGroup.changed(topStart)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((1572864 & i) == 0) {
                        function6 = function4;
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    } else {
                        function6 = function4;
                    }
                    if ((599187 & i3) != 599186) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "174@7473L28,176@7606L164");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            }
                            if (i4 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            }
                            if (i6 != 0) {
                                function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i8 = i3;
                                modifier4 = companion;
                                pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                                alignment3 = topStart;
                            } else {
                                i8 = i3;
                                modifier4 = companion;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:184)");
                            }
                            m5525PullToRefreshBoxgMrHQkA(z, function0, modifier4, pullToRefreshState3, alignment3, function3RememberComposableLambda, true, PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM(), function6, composerStartRestartGroup, (i8 & 14) | 14155776 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | ((i8 << 6) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function7 = function3RememberComposableLambda;
                            alignment2 = alignment3;
                            pullToRefreshState2 = pullToRefreshState3;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            i8 = i3;
                            modifier4 = modifier2;
                        }
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                        function3RememberComposableLambda = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:184)");
                        }
                        m5525PullToRefreshBoxgMrHQkA(z, function0, modifier4, pullToRefreshState3, alignment3, function3RememberComposableLambda, true, PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM(), function6, composerStartRestartGroup, (i8 & 14) | 14155776 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | ((i8 << 6) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function7 = function3RememberComposableLambda;
                        alignment2 = alignment3;
                        pullToRefreshState2 = pullToRefreshState3;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
                        alignment2 = topStart;
                        function7 = function5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$1(z, function0, modifier3, pullToRefreshState2, alignment2, function7, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
                if ((1572864 & i) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                } else {
                    function6 = function4;
                }
                if ((599187 & i3) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "174@7473L28,176@7606L164");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i8 = i3;
                            modifier4 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment3 = topStart;
                        } else {
                            i8 = i3;
                            modifier4 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment3 = topStart;
                            function3RememberComposableLambda = function5;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i8 = i3;
                            modifier4 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment3 = topStart;
                        } else {
                            i8 = i3;
                            modifier4 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment3 = topStart;
                            function3RememberComposableLambda = function5;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:184)");
                    }
                    m5525PullToRefreshBoxgMrHQkA(z, function0, modifier4, pullToRefreshState3, alignment3, function3RememberComposableLambda, true, PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM(), function6, composerStartRestartGroup, (i8 & 14) | 14155776 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | ((i8 << 6) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function7 = function3RememberComposableLambda;
                    alignment2 = alignment3;
                    pullToRefreshState2 = pullToRefreshState3;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
                    alignment2 = topStart;
                    function7 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshKt.PullToRefreshBox$lambda$1(z, function0, modifier3, pullToRefreshState2, alignment2, function7, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            topStart = alignment;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                } else {
                    function6 = function4;
                }
                if ((599187 & i3) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "174@7473L28,176@7606L164");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i8 = i3;
                            modifier4 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment3 = topStart;
                        } else {
                            i8 = i3;
                            modifier4 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment3 = topStart;
                            function3RememberComposableLambda = function5;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i8 = i3;
                            modifier4 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment3 = topStart;
                        } else {
                            i8 = i3;
                            modifier4 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment3 = topStart;
                            function3RememberComposableLambda = function5;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:184)");
                    }
                    m5525PullToRefreshBoxgMrHQkA(z, function0, modifier4, pullToRefreshState3, alignment3, function3RememberComposableLambda, true, PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM(), function6, composerStartRestartGroup, (i8 & 14) | 14155776 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | ((i8 << 6) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function7 = function3RememberComposableLambda;
                    alignment2 = alignment3;
                    pullToRefreshState2 = pullToRefreshState3;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
                    alignment2 = topStart;
                    function7 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshKt.PullToRefreshBox$lambda$1(z, function0, modifier3, pullToRefreshState2, alignment2, function7, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            if ((1572864 & i) == 0) {
                function6 = function4;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                function6 = function4;
            }
            if ((599187 & i3) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "174@7473L28,176@7606L164");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i8 = i3;
                        modifier4 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                    } else {
                        i8 = i3;
                        modifier4 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                        function3RememberComposableLambda = function5;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i8 = i3;
                        modifier4 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                    } else {
                        i8 = i3;
                        modifier4 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                        function3RememberComposableLambda = function5;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:184)");
                }
                m5525PullToRefreshBoxgMrHQkA(z, function0, modifier4, pullToRefreshState3, alignment3, function3RememberComposableLambda, true, PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM(), function6, composerStartRestartGroup, (i8 & 14) | 14155776 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | ((i8 << 6) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function7 = function3RememberComposableLambda;
                alignment2 = alignment3;
                pullToRefreshState2 = pullToRefreshState3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
                alignment2 = topStart;
                function7 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshKt.PullToRefreshBox$lambda$1(z, function0, modifier3, pullToRefreshState2, alignment2, function7, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState;
                if (composerStartRestartGroup.changed(pullToRefreshStateRememberPullToRefreshState)) {
                }
                i3 |= i11;
            } else {
                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState;
            }
            i3 |= i11;
        } else {
            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                topStart = alignment;
                if (composerStartRestartGroup.changed(topStart)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                } else {
                    function6 = function4;
                }
                if ((599187 & i3) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "174@7473L28,176@7606L164");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i8 = i3;
                            modifier4 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment3 = topStart;
                        } else {
                            i8 = i3;
                            modifier4 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment3 = topStart;
                            function3RememberComposableLambda = function5;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i8 = i3;
                            modifier4 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment3 = topStart;
                        } else {
                            i8 = i3;
                            modifier4 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment3 = topStart;
                            function3RememberComposableLambda = function5;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:184)");
                    }
                    m5525PullToRefreshBoxgMrHQkA(z, function0, modifier4, pullToRefreshState3, alignment3, function3RememberComposableLambda, true, PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM(), function6, composerStartRestartGroup, (i8 & 14) | 14155776 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | ((i8 << 6) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function7 = function3RememberComposableLambda;
                    alignment2 = alignment3;
                    pullToRefreshState2 = pullToRefreshState3;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
                    alignment2 = topStart;
                    function7 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshKt.PullToRefreshBox$lambda$1(z, function0, modifier3, pullToRefreshState2, alignment2, function7, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            if ((1572864 & i) == 0) {
                function6 = function4;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                function6 = function4;
            }
            if ((599187 & i3) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "174@7473L28,176@7606L164");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i8 = i3;
                        modifier4 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                    } else {
                        i8 = i3;
                        modifier4 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                        function3RememberComposableLambda = function5;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i8 = i3;
                        modifier4 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                    } else {
                        i8 = i3;
                        modifier4 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                        function3RememberComposableLambda = function5;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:184)");
                }
                m5525PullToRefreshBoxgMrHQkA(z, function0, modifier4, pullToRefreshState3, alignment3, function3RememberComposableLambda, true, PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM(), function6, composerStartRestartGroup, (i8 & 14) | 14155776 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | ((i8 << 6) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function7 = function3RememberComposableLambda;
                alignment2 = alignment3;
                pullToRefreshState2 = pullToRefreshState3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
                alignment2 = topStart;
                function7 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshKt.PullToRefreshBox$lambda$1(z, function0, modifier3, pullToRefreshState2, alignment2, function7, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        topStart = alignment;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((1572864 & i) == 0) {
                function6 = function4;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                function6 = function4;
            }
            if ((599187 & i3) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "174@7473L28,176@7606L164");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i8 = i3;
                        modifier4 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                    } else {
                        i8 = i3;
                        modifier4 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                        function3RememberComposableLambda = function5;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i8 = i3;
                        modifier4 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                    } else {
                        i8 = i3;
                        modifier4 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment3 = topStart;
                        function3RememberComposableLambda = function5;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:184)");
                }
                m5525PullToRefreshBoxgMrHQkA(z, function0, modifier4, pullToRefreshState3, alignment3, function3RememberComposableLambda, true, PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM(), function6, composerStartRestartGroup, (i8 & 14) | 14155776 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | ((i8 << 6) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function7 = function3RememberComposableLambda;
                alignment2 = alignment3;
                pullToRefreshState2 = pullToRefreshState3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
                alignment2 = topStart;
                function7 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshKt.PullToRefreshBox$lambda$1(z, function0, modifier3, pullToRefreshState2, alignment2, function7, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function5 = function3;
        if ((1572864 & i) == 0) {
            function6 = function4;
            if (composerStartRestartGroup.changedInstance(function6)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        } else {
            function6 = function4;
        }
        if ((599187 & i3) != 599186) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "174@7473L28,176@7606L164");
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                }
                if (i4 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                }
                if (i6 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    i8 = i3;
                    modifier4 = companion;
                    pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                    alignment3 = topStart;
                } else {
                    i8 = i3;
                    modifier4 = companion;
                    pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                    alignment3 = topStart;
                    function3RememberComposableLambda = function5;
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                }
                if (i4 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                }
                if (i6 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    i8 = i3;
                    modifier4 = companion;
                    pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                    alignment3 = topStart;
                } else {
                    i8 = i3;
                    modifier4 = companion;
                    pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                    alignment3 = topStart;
                    function3RememberComposableLambda = function5;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:184)");
            }
            m5525PullToRefreshBoxgMrHQkA(z, function0, modifier4, pullToRefreshState3, alignment3, function3RememberComposableLambda, true, PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM(), function6, composerStartRestartGroup, (i8 & 14) | 14155776 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | ((i8 << 6) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function7 = function3RememberComposableLambda;
            alignment2 = alignment3;
            pullToRefreshState2 = pullToRefreshState3;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
            alignment2 = topStart;
            function7 = function5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PullToRefreshKt.PullToRefreshBox$lambda$1(z, function0, modifier3, pullToRefreshState2, alignment2, function7, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: pullToRefresh-Z4HSEVQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m5530pullToRefreshZ4HSEVQ$default(Modifier modifier, boolean z, PullToRefreshState pullToRefreshState, boolean z2, float f, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            f = PullToRefreshDefaults.INSTANCE.m5522getPositionalThresholdD9Ej5fM();
        }
        return m5529pullToRefreshZ4HSEVQ(modifier, z, pullToRefreshState, z3, f, function0);
    }

    /* JADX INFO: renamed from: pullToRefresh-Z4HSEVQ, reason: not valid java name */
    public static final Modifier m5529pullToRefreshZ4HSEVQ(Modifier modifier, boolean z, PullToRefreshState pullToRefreshState, boolean z2, float f, Function0<Unit> function0) {
        return modifier.then(new PullToRefreshElement(z, function0, z2, pullToRefreshState, f, null));
    }

    public static final PullToRefreshState rememberPullToRefreshState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 318623070, "C(rememberPullToRefreshState)732@28863L28,732@28808L83:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(318623070, i, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:731)");
        }
        Object[] objArr = new Object[0];
        Saver<PullToRefreshStateImpl, Float> saver = PullToRefreshStateImpl.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, 1254096154, "CC(remember):PullToRefresh.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PullToRefreshKt.rememberPullToRefreshState$lambda$0$0();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        PullToRefreshStateImpl pullToRefreshStateImpl = (PullToRefreshStateImpl) RememberSaveableKt.m6709rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composer, 384);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return pullToRefreshStateImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PullToRefreshStateImpl rememberPullToRefreshState$lambda$0$0() {
        return new PullToRefreshStateImpl();
    }

    public static final PullToRefreshState PullToRefreshState() {
        return new PullToRefreshStateImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CircularArrowProgressIndicator-RPmYEkk, reason: not valid java name */
    public static final void m5524CircularArrowProgressIndicatorRPmYEkk(final FloatProducer floatProducer, final long j, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1353562852);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularArrowProgressIndicator)N(progress,color:c#ui.graphics.Color)778@30208L61,780@30370L76,785@30673L7,783@30548L143,790@30766L175,796@30983L443,788@30697L729:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(floatProducer) : composerStartRestartGroup.changedInstance(floatProducer) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1353562852, i2, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:777)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 601192889, "CC(remember):PullToRefresh.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Object obj = objRememberedValue;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Path Path = AndroidPath_androidKt.Path();
                Path.mo7208setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m7634getEvenOddRgk1Os());
                composerStartRestartGroup.updateRememberedValue(Path);
                obj = Path;
            }
            final Path path = (Path) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 601198088, "CC(remember):PullToRefresh.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$1$0(floatProducer));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowProgressIndicator_RPmYEkk$lambda$2((State) objRememberedValue2), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 601210859, "CC(remember):PullToRefresh.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(floatProducer));
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$3$0(floatProducer, (SemanticsPropertyReceiver) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM2417size3ABfNKs = SizeKt.m2417size3ABfNKs(SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue3), SpinnerSize);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 601218071, "CC(remember):PullToRefresh.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState) | (i3 == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(floatProducer))) | ((i2 & 112) == 32) | composerStartRestartGroup.changedInstance(path);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$4$0(floatProducer, stateAnimateFloatAsState, j, path, (DrawScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function1);
                objRememberedValue4 = function1;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierM2417size3ABfNKs, (Function1) objRememberedValue4, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$5(floatProducer, j, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularArrowProgressIndicator_RPmYEkk$lambda$1$0(FloatProducer floatProducer) {
        if (floatProducer.invoke() >= 1.0f) {
            return 1.0f;
        }
        return MinAlpha;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularArrowProgressIndicator_RPmYEkk$lambda$3$0(FloatProducer floatProducer, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (floatProducer.invoke() > 0.0f) {
            SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(floatProducer.invoke(), RangesKt.rangeTo(0.0f, 1.0f), 0));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularArrowProgressIndicator_RPmYEkk$lambda$4$0(FloatProducer floatProducer, State state, long j, Path path, DrawScope drawScope) {
        ArrowValues ArrowValues = ArrowValues(floatProducer.invoke());
        float fFloatValue = ((Number) state.getValue()).floatValue();
        float rotation = ArrowValues.getRotation();
        long jMo7911getCenterF1C5BW0 = drawScope.mo7911getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo7833getSizeNHjbRc = drawContext.mo7833getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo7839rotateUv8p0NA(rotation, jMo7911getCenterF1C5BW0);
            float f = drawScope.mo1734toPx0680j_4(ArcRadius);
            float f2 = StrokeWidth;
            Rect rectM7112Rect3MmeM6k = RectKt.m7112Rect3MmeM6k(androidx.compose.ui.geometry.SizeKt.m7152getCenteruvyYCjk(drawScope.mo7912getSizeNHjbRc()), f + (drawScope.mo1734toPx0680j_4(f2) / 2.0f));
            m5528drawCircularIndicatorKzyDr3Q(drawScope, j, fFloatValue, ArrowValues, rectM7112Rect3MmeM6k, f2);
            m5527drawArrowuDrxG_w(drawScope, path, rectM7112Rect3MmeM6k, j, fFloatValue, ArrowValues, f2);
            return Unit.INSTANCE;
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo7834setSizeuvyYCjk(jMo7833getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: drawCircularIndicator-KzyDr3Q, reason: not valid java name */
    private static final void m5528drawCircularIndicatorKzyDr3Q(DrawScope drawScope, long j, float f, ArrowValues arrowValues, Rect rect, float f2) {
        DrawScope.m7891drawArcyD3GUKo$default(drawScope, j, arrowValues.getStartAngle(), arrowValues.getEndAngle() - arrowValues.getStartAngle(), false, rect.m7108getTopLeftF1C5BW0(), rect.m7106getSizeNHjbRc(), f, new Stroke(drawScope.mo1734toPx0680j_4(f2), 0.0f, StrokeCap.INSTANCE.m7712getButtKaPHkGw(), 0, null, 26, null), null, 0, 768, null);
    }

    private static final ArrowValues ArrowValues(float f) {
        float fMax = (Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * 5.0f) / 3.0f;
        float fCoerceIn = RangesKt.coerceIn(Math.abs(f) - 1.0f, 0.0f, 2.0f);
        float fPow = (((0.4f * fMax) - 0.25f) + (fCoerceIn - (((float) Math.pow(fCoerceIn, 2.0d)) / 4.0f))) * 0.5f;
        return new ArrowValues(fPow, fPow * 360.0f, ((0.8f * fMax) + fPow) * 360.0f, Math.min(1.0f, fMax));
    }

    /* JADX INFO: renamed from: drawArrow-uDrxG_w, reason: not valid java name */
    private static final void m5527drawArrowuDrxG_w(DrawScope drawScope, Path path, Rect rect, long j, float f, ArrowValues arrowValues, float f2) {
        path.reset();
        path.moveTo(0.0f, 0.0f);
        float f3 = ArrowWidth;
        path.lineTo((drawScope.mo1734toPx0680j_4(f3) * arrowValues.getScale()) / 2.0f, drawScope.mo1734toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        path.lineTo(drawScope.mo1734toPx0680j_4(f3) * arrowValues.getScale(), 0.0f);
        float fMin = ((Math.min(rect.getRight() - rect.getLeft(), rect.getBottom() - rect.getTop()) / 2.0f) + Float.intBitsToFloat((int) (rect.m7103getCenterF1C5BW0() >> 32))) - ((drawScope.mo1734toPx0680j_4(f3) * arrowValues.getScale()) / 2.0f);
        path.mo7210translatek4lQ0M(Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (rect.m7103getCenterF1C5BW0() & 4294967295L)) - drawScope.mo1734toPx0680j_4(f2))) & 4294967295L) | (Float.floatToRawIntBits(fMin) << 32)));
        float endAngle = arrowValues.getEndAngle() - drawScope.mo1734toPx0680j_4(f2);
        long jMo7911getCenterF1C5BW0 = drawScope.mo7911getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo7833getSizeNHjbRc = drawContext.mo7833getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo7839rotateUv8p0NA(endAngle, jMo7911getCenterF1C5BW0);
            DrawScope.m7902drawPathLG529CI$default(drawScope, path, j, f, new Stroke(drawScope.mo1734toPx0680j_4(f2), 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo7834setSizeuvyYCjk(jMo7833getSizeNHjbRc);
        }
    }

    public static final float getSpinnerSize() {
        return SpinnerSize;
    }

    public static final float getSpinnerContainerSize() {
        return SpinnerContainerSize;
    }

    public static final float getLoaderIndicatorHeight() {
        return LoaderIndicatorHeight;
    }

    public static final float getLoaderIndicatorWidth() {
        return LoaderIndicatorWidth;
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }
}
