package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Padding.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\b\u001a\u0015\u0010\u0016\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0087\u0002\u001a\u0015\u0010\u0018\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0087\u0002\u001a\u0019\u0010\u0019\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a\u0019\u0010\u001d\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a\u0017\u0010\u001e\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b!\u0010\"\u001a7\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {ViewProps.PADDING, "Landroidx/compose/ui/Modifier;", ViewProps.START, "Landroidx/compose/ui/unit/Dp;", ViewProps.TOP, ViewProps.END, ViewProps.BOTTOM, "padding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "horizontal", "vertical", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "all", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", "left", "right", "absolutePadding-qDBjuR0", "plus", "other", "minus", "calculateStartPadding", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateEndPadding", "PaddingValues", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "foundation-layout"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PaddingKt {
    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m2353paddingqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new PaddingElement(f, f2, f3, f4, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding_qDBjuR0$lambda$0(f, f2, f3, f4, (InspectorInfo) obj);
            }
        }, null));
    }

    static final Unit padding_qDBjuR0$lambda$0(float f, float f2, float f3, float f4, InspectorInfo inspectorInfo) {
        inspectorInfo.setName(ViewProps.PADDING);
        inspectorInfo.getProperties().set(ViewProps.START, Dp.m10166boximpl(f));
        inspectorInfo.getProperties().set(ViewProps.TOP, Dp.m10166boximpl(f2));
        inspectorInfo.getProperties().set(ViewProps.END, Dp.m10166boximpl(f3));
        inspectorInfo.getProperties().set(ViewProps.BOTTOM, Dp.m10166boximpl(f4));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m2351paddingVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new PaddingElement(f, f2, f, f2, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding_VpY3zN4$lambda$0(f, f2, (InspectorInfo) obj);
            }
        }, null));
    }

    static final Unit padding_VpY3zN4$lambda$0(float f, float f2, InspectorInfo inspectorInfo) {
        inspectorInfo.setName(ViewProps.PADDING);
        inspectorInfo.getProperties().set("horizontal", Dp.m10166boximpl(f));
        inspectorInfo.getProperties().set("vertical", Dp.m10166boximpl(f2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m2350padding3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new PaddingElement(f, f, f, f, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding_3ABfNKs$lambda$0(f, (InspectorInfo) obj);
            }
        }, null));
    }

    static final Unit padding_3ABfNKs$lambda$0(float f, InspectorInfo inspectorInfo) {
        inspectorInfo.setName(ViewProps.PADDING);
        inspectorInfo.setValue(Dp.m10166boximpl(f));
        return Unit.INSTANCE;
    }

    public static final Modifier padding(Modifier modifier, final PaddingValues paddingValues) {
        return modifier.then(new PaddingValuesElement(paddingValues, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding$lambda$0(paddingValues, (InspectorInfo) obj);
            }
        }));
    }

    static final Unit padding$lambda$0(PaddingValues paddingValues, InspectorInfo inspectorInfo) {
        inspectorInfo.setName(ViewProps.PADDING);
        inspectorInfo.getProperties().set("paddingValues", paddingValues);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0, reason: not valid java name */
    public static final Modifier m2348absolutePaddingqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new PaddingElement(f, f2, f3, f4, false, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.absolutePadding_qDBjuR0$lambda$0(f, f2, f3, f4, (InspectorInfo) obj);
            }
        }, null));
    }

    static final Unit absolutePadding_qDBjuR0$lambda$0(float f, float f2, float f3, float f4, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("absolutePadding");
        inspectorInfo.getProperties().set("left", Dp.m10166boximpl(f));
        inspectorInfo.getProperties().set(ViewProps.TOP, Dp.m10166boximpl(f2));
        inspectorInfo.getProperties().set("right", Dp.m10166boximpl(f3));
        inspectorInfo.getProperties().set(ViewProps.BOTTOM, Dp.m10166boximpl(f4));
        return Unit.INSTANCE;
    }

    public static final PaddingValues plus(final PaddingValues paddingValues, final PaddingValues paddingValues2) {
        return new PaddingValues() { // from class: androidx.compose.foundation.layout.PaddingKt.plus.1
            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
            public float mo2300calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
                return Dp.m10168constructorimpl(paddingValues.mo2300calculateLeftPaddingu2uoSUM(layoutDirection) + paddingValues2.mo2300calculateLeftPaddingu2uoSUM(layoutDirection));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
            public float getTop() {
                return Dp.m10168constructorimpl(paddingValues.getTop() + paddingValues2.getTop());
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
            public float mo2301calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
                return Dp.m10168constructorimpl(paddingValues.mo2301calculateRightPaddingu2uoSUM(layoutDirection) + paddingValues2.mo2301calculateRightPaddingu2uoSUM(layoutDirection));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
            public float getBottom() {
                return Dp.m10168constructorimpl(paddingValues.getBottom() + paddingValues2.getBottom());
            }
        };
    }

    public static final PaddingValues minus(final PaddingValues paddingValues, final PaddingValues paddingValues2) {
        return new PaddingValues() { // from class: androidx.compose.foundation.layout.PaddingKt.minus.1
            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
            public float mo2300calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
                return Dp.m10168constructorimpl(RangesKt.coerceAtLeast(Dp.m10168constructorimpl(paddingValues.mo2300calculateLeftPaddingu2uoSUM(layoutDirection) - paddingValues2.mo2300calculateLeftPaddingu2uoSUM(layoutDirection)), Dp.m10168constructorimpl(0.0f)));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
            public float getTop() {
                return Dp.m10168constructorimpl(RangesKt.coerceAtLeast(Dp.m10168constructorimpl(paddingValues.getTop() - paddingValues2.getTop()), Dp.m10168constructorimpl(0.0f)));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
            public float mo2301calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
                return Dp.m10168constructorimpl(RangesKt.coerceAtLeast(Dp.m10168constructorimpl(paddingValues.mo2301calculateRightPaddingu2uoSUM(layoutDirection) - paddingValues2.mo2301calculateRightPaddingu2uoSUM(layoutDirection)), Dp.m10168constructorimpl(0.0f)));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
            public float getBottom() {
                return Dp.m10168constructorimpl(RangesKt.coerceAtLeast(Dp.m10168constructorimpl(paddingValues.getBottom() - paddingValues2.getBottom()), Dp.m10168constructorimpl(0.0f)));
            }
        };
    }

    public static final float calculateStartPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.mo2300calculateLeftPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.mo2301calculateRightPaddingu2uoSUM(layoutDirection);
    }

    public static final float calculateEndPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.mo2301calculateRightPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.mo2300calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    /* JADX INFO: renamed from: PaddingValues-0680j_4, reason: not valid java name */
    public static final PaddingValues m2343PaddingValues0680j_4(float f) {
        return new PaddingValuesImpl(f, f, f, f, null);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValues m2344PaddingValuesYgX7TsA(float f, float f2) {
        return new PaddingValuesImpl(f, f2, f, f2, null);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValues m2346PaddingValuesa9UjIt4(float f, float f2, float f3, float f4) {
        return new PaddingValuesImpl(f, f2, f3, f4, null);
    }

    /* JADX INFO: renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2354paddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m10168constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m10168constructorimpl(0.0f);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m10168constructorimpl(0.0f);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m10168constructorimpl(0.0f);
        }
        return m2353paddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2352paddingVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m10168constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m10168constructorimpl(0.0f);
        }
        return m2351paddingVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2349absolutePaddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m10168constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m10168constructorimpl(0.0f);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m10168constructorimpl(0.0f);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m10168constructorimpl(0.0f);
        }
        return m2348absolutePaddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2345PaddingValuesYgX7TsA$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m10168constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m10168constructorimpl(0.0f);
        }
        return m2344PaddingValuesYgX7TsA(f, f2);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2347PaddingValuesa9UjIt4$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m10168constructorimpl(0.0f);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m10168constructorimpl(0.0f);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m10168constructorimpl(0.0f);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m10168constructorimpl(0.0f);
        }
        return m2346PaddingValuesa9UjIt4(f, f2, f3, f4);
    }
}
