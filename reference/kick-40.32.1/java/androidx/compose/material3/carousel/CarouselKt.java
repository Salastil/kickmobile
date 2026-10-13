package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Carousel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u001021\u0010\u0011\u001a-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0084\u0001\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u001021\u0010\u0011\u001a-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u009a\u0001\u0010 \u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u001021\u0010\u0011\u001a-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\"\u0010#\u001aÂ\u0001\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&26\u0010'\u001a2\u0012\u0013\u0012\u00110(¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b()\u0012\u0013\u0012\u00110(¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020*0\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f21\u0010\u0011\u001a-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0004\b,\u0010-\u001a\u0019\u0010.\u001a\u00020(*\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010/\u001a\u0019\u00100\u001a\u00020(*\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0003¢\u0006\u0002\u0010/\u001a:\u00101\u001a\u00020\u0007*\u00020\u00072\u0006\u00102\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\f\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0000\u001a7\u0010:\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020\u0005H\u0002¢\u0006\u0004\b@\u0010A\u001a\u0018\u0010B\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u000205H\u0000\u001a\u0018\u0010C\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u000205H\u0001\u001a \u0010D\u001a\u00020(2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020(H\u0002¨\u0006I"}, d2 = {"HorizontalMultiBrowseCarousel", "", "state", "Landroidx/compose/material3/carousel/CarouselState;", "preferredItemWidth", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "itemSpacing", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "minSmallItemWidth", "maxSmallItemWidth", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function2;", "Landroidx/compose/material3/carousel/CarouselItemScope;", "", "Lkotlin/ParameterName;", "name", "itemIndex", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalMultiBrowseCarousel-3tcCNu0", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;ZFFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalUncontainedCarousel", "itemWidth", "HorizontalUncontainedCarousel-VUP9l70", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalCenteredHeroCarousel", "maxItemWidth", "HorizontalCenteredHeroCarousel-p2lB3Bg", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/ui/Modifier;FFLandroidx/compose/foundation/gestures/TargetedFlingBehavior;ZFFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "Carousel", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "keylineList", "", "availableSpace", "Landroidx/compose/material3/carousel/KeylineList;", "maxNonFocalVisibleItemCount", "Carousel-cJHQLPU", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ILandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "calculateBeforeContentPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)F", "calculateAfterContentPadding", "carouselItem", FirebaseAnalytics.Param.INDEX, "strategy", "Lkotlin/Function0;", "Landroidx/compose/material3/carousel/Strategy;", "carouselItemDrawInfo", "Landroidx/compose/material3/carousel/CarouselItemDrawInfoImpl;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "drawDebugLines", "pageSize", "Landroidx/compose/material3/carousel/CarouselPageSize;", "strokeColor", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "drawDebugLines-1Yev-eo", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/material3/carousel/CarouselPageSize;JF)Landroidx/compose/ui/Modifier;", "calculateCurrentScrollOffset", "calculateMaxScrollOffset", "getProgress", "before", "Landroidx/compose/material3/carousel/Keyline;", "after", "unadjustedOffset", "material3"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CarouselKt {
    static final Unit Carousel_cJHQLPU$lambda$5(CarouselState carouselState, Orientation orientation, Function2 function2, PaddingValues paddingValues, int i, Modifier modifier, float f, TargetedFlingBehavior targetedFlingBehavior, boolean z, Function4 function4, int i2, int i3, Composer composer, int i4) {
        m5276CarouselcJHQLPU(carouselState, orientation, function2, paddingValues, i, modifier, f, targetedFlingBehavior, z, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(CarouselState carouselState, Modifier modifier, float f, float f2, TargetedFlingBehavior targetedFlingBehavior, boolean z, float f3, float f4, PaddingValues paddingValues, Function4 function4, int i, int i2, Composer composer, int i3) {
        m5277HorizontalCenteredHeroCarouselp2lB3Bg(carouselState, modifier, f, f2, targetedFlingBehavior, z, f3, f4, paddingValues, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(CarouselState carouselState, float f, Modifier modifier, float f2, TargetedFlingBehavior targetedFlingBehavior, boolean z, float f3, float f4, PaddingValues paddingValues, Function4 function4, int i, int i2, Composer composer, int i3) {
        m5278HorizontalMultiBrowseCarousel3tcCNu0(carouselState, f, modifier, f2, targetedFlingBehavior, z, f3, f4, paddingValues, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit HorizontalUncontainedCarousel_VUP9l70$lambda$1(CarouselState carouselState, float f, Modifier modifier, float f2, TargetedFlingBehavior targetedFlingBehavior, boolean z, PaddingValues paddingValues, Function4 function4, int i, int i2, Composer composer, int i3) {
        m5279HorizontalUncontainedCarouselVUP9l70(carouselState, f, modifier, f2, targetedFlingBehavior, z, paddingValues, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012b  */
    /* JADX WARN: Code duplicated, block: B:102:0x012e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0138  */
    /* JADX WARN: Code duplicated, block: B:107:0x0147  */
    /* JADX WARN: Code duplicated, block: B:115:0x0168 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x016a  */
    /* JADX WARN: Code duplicated, block: B:117:0x0171  */
    /* JADX WARN: Code duplicated, block: B:120:0x0177  */
    /* JADX WARN: Code duplicated, block: B:123:0x0180  */
    /* JADX WARN: Code duplicated, block: B:124:0x0196  */
    /* JADX WARN: Code duplicated, block: B:126:0x019c  */
    /* JADX WARN: Code duplicated, block: B:128:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:131:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:137:0x01da  */
    /* JADX WARN: Code duplicated, block: B:140:0x0210  */
    /* JADX WARN: Code duplicated, block: B:141:0x0213  */
    /* JADX WARN: Code duplicated, block: B:144:0x0226  */
    /* JADX WARN: Code duplicated, block: B:145:0x0229  */
    /* JADX WARN: Code duplicated, block: B:148:0x0237  */
    /* JADX WARN: Code duplicated, block: B:151:0x0241  */
    /* JADX WARN: Code duplicated, block: B:155:0x024f  */
    /* JADX WARN: Code duplicated, block: B:158:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:160:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:163:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:55:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:79:0x00df  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:94:0x010e  */
    /* JADX WARN: Code duplicated, block: B:96:0x0114  */
    /* JADX WARN: Code duplicated, block: B:97:0x0117  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: HorizontalMultiBrowseCarousel-3tcCNu0, reason: not valid java name */
    public static final void m5278HorizontalMultiBrowseCarousel3tcCNu0(final CarouselState carouselState, final float f, Modifier modifier, float f2, TargetedFlingBehavior targetedFlingBehavior, boolean z, float f3, float f4, PaddingValues paddingValues, final Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        float fM10168constructorimpl;
        int i5;
        TargetedFlingBehavior targetedFlingBehaviorSingleAdvanceFlingBehavior;
        int i6;
        boolean z2;
        int i7;
        int i8;
        final float fM5270getMinSmallItemSizeD9Ej5fM;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z3;
        float f5;
        float f6;
        final TargetedFlingBehavior targetedFlingBehavior2;
        boolean z4;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        CarouselState carouselState2;
        float fM5269getMaxSmallItemSizeD9Ej5fM;
        float f7;
        float f8;
        TargetedFlingBehavior targetedFlingBehavior3;
        Modifier modifier4;
        int i15;
        PaddingValues paddingValuesM2343PaddingValues0680j_4;
        final Density density;
        boolean z5;
        boolean z6;
        boolean z7;
        Object objRememberedValue;
        float f9;
        int i16;
        Composer composerStartRestartGroup = composer.startRestartGroup(-221490402);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalMultiBrowseCarousel)N(state,preferredItemWidth:c#ui.unit.Dp,modifier,itemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,minSmallItemWidth:c#ui.unit.Dp,maxSmallItemWidth:c#ui.unit.Dp,contentPadding,content)121@6255L7,125@6368L565,122@6267L1107:Carousel.kt#dcf9yb");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(carouselState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        int i17 = i2 & 4;
        if (i17 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    fM10168constructorimpl = f2;
                    if (composerStartRestartGroup.changed(fM10168constructorimpl)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                        int i18 = composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior) ? 16384 : 8192;
                        i3 |= i18;
                    } else {
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    }
                    i3 |= i18;
                } else {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                        fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    } else {
                        fM5270getMinSmallItemSizeD9Ej5fM = f3;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f4)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i13 = 67108864;
                            } else {
                                i13 = GroupFlagsKt.HasAuxSlotFlag;
                            }
                            i3 |= i13;
                        }
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i16 = 536870912;
                            } else {
                                i16 = 268435456;
                            }
                            i3 |= i16;
                        }
                        i14 = i3;
                        if ((i14 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i17 != 0) {
                                    modifier3 = Modifier.INSTANCE;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i4 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                }
                                if ((i2 & 16) != 0) {
                                    int i19 = (i14 & 14) | 384;
                                    carouselState2 = carouselState;
                                    i14 &= -57345;
                                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i19, 2);
                                } else {
                                    carouselState2 = carouselState;
                                }
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                if (i8 != 0) {
                                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                                }
                                if (i10 != 0) {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                                } else {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                                }
                                if (i12 != 0) {
                                    f6 = fM10168constructorimpl;
                                    z4 = z2;
                                    modifier4 = modifier3;
                                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                    f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    i15 = i14;
                                } else {
                                    f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    f6 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    z4 = z2;
                                    modifier4 = modifier3;
                                    i15 = i14;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                                }
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                density = (Density) objConsume;
                                Orientation orientation = Orientation.Horizontal;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                                boolean zChanged = composerStartRestartGroup.changed(density);
                                if ((i15 & 112) == 32) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                boolean zChangedInstance = zChanged | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                                if ((i15 & 3670016) == 1048576) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                z7 = zChangedInstance | z6 | ((i15 & 29360128) == 8388608);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z7 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    final CarouselState carouselState3 = carouselState2;
                                    final float f10 = f8;
                                    final float f11 = f7;
                                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState3, f10, f11, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                        }
                                    };
                                    f9 = f10;
                                    f5 = f11;
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    f9 = f8;
                                    f5 = f7;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i20 = i15 << 9;
                                PaddingValues paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                                m5276CarouselcJHQLPU(carouselState, orientation, (Function2) objRememberedValue, paddingValues3, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i20) | (i20 & 3670016) | (i20 & 29360128) | (i20 & 234881024) | (1879048192 & i15), 0);
                                composerStartRestartGroup = composerStartRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                paddingValues2 = paddingValues3;
                                modifier2 = modifier4;
                                targetedFlingBehavior2 = targetedFlingBehavior3;
                                fM5270getMinSmallItemSizeD9Ej5fM = f9;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i14 &= -57345;
                                }
                                carouselState2 = carouselState;
                                modifier4 = modifier2;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f6 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                z4 = z2;
                                i15 = i14;
                                f7 = f4;
                            }
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                            }
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume2;
                            Orientation orientation2 = Orientation.Horizontal;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                            boolean zChanged2 = composerStartRestartGroup.changed(density);
                            if ((i15 & 112) == 32) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            boolean zChangedInstance2 = zChanged2 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                            if ((i15 & 3670016) == 1048576) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            z7 = zChangedInstance2 | z6 | ((i15 & 29360128) == 8388608);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z7) {
                                final CarouselState carouselState4 = carouselState2;
                                final float f12 = f8;
                                final float f13 = f7;
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState4, f12, f13, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                f9 = f12;
                                f5 = f13;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                final CarouselState carouselState5 = carouselState2;
                                final float f14 = f8;
                                final float f15 = f7;
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState5, f14, f15, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                f9 = f14;
                                f5 = f15;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i21 = i15 << 9;
                            PaddingValues paddingValues4 = paddingValuesM2343PaddingValues0680j_4;
                            m5276CarouselcJHQLPU(carouselState, orientation2, (Function2) objRememberedValue, paddingValues4, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i21) | (i21 & 3670016) | (i21 & 29360128) | (i21 & 234881024) | (1879048192 & i15), 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues4;
                            modifier2 = modifier4;
                            targetedFlingBehavior2 = targetedFlingBehavior3;
                            fM5270getMinSmallItemSizeD9Ej5fM = f9;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            f5 = f4;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final Modifier modifier5 = modifier2;
                            final float f16 = f6;
                            final boolean z8 = z4;
                            final float f17 = f5;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier5, f16, targetedFlingBehavior2, z8, fM5270getMinSmallItemSizeD9Ej5fM, f17, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i16 = 536870912;
                        } else {
                            i16 = 268435456;
                        }
                        i3 |= i16;
                    }
                    i14 = i3;
                    if ((i14 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i110 = (i14 & 14) | 384;
                                carouselState2 = carouselState;
                                i14 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i110, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i12 != 0) {
                                f6 = fM10168constructorimpl;
                                z4 = z2;
                                modifier4 = modifier3;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                i15 = i14;
                            } else {
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f6 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                z4 = z2;
                                modifier4 = modifier3;
                                i15 = i14;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i111 = (i14 & 14) | 384;
                                carouselState2 = carouselState;
                                i14 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i111, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i12 != 0) {
                                f6 = fM10168constructorimpl;
                                z4 = z2;
                                modifier4 = modifier3;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                i15 = i14;
                            } else {
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f6 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                z4 = z2;
                                modifier4 = modifier3;
                                i15 = i14;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                        }
                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume3;
                        Orientation orientation3 = Orientation.Horizontal;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged3 = composerStartRestartGroup.changed(density);
                        if ((i15 & 112) == 32) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance3 = zChanged3 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i15 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance3 | z6 | ((i15 & 29360128) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState6 = carouselState2;
                            final float f18 = f8;
                            final float f19 = f7;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState6, f18, f19, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f9 = f18;
                            f5 = f19;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState7 = carouselState2;
                            final float f110 = f8;
                            final float f111 = f7;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState7, f110, f111, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f9 = f110;
                            f5 = f111;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i22 = i15 << 9;
                        PaddingValues paddingValues5 = paddingValuesM2343PaddingValues0680j_4;
                        m5276CarouselcJHQLPU(carouselState, orientation3, (Function2) objRememberedValue, paddingValues5, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i22) | (i22 & 3670016) | (i22 & 29360128) | (i22 & 234881024) | (1879048192 & i15), 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues5;
                        modifier2 = modifier4;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        fM5270getMinSmallItemSizeD9Ej5fM = f9;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        f5 = f4;
                        f6 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier6 = modifier2;
                        final float f112 = f6;
                        final boolean z9 = z4;
                        final float f113 = f5;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier6, f112, targetedFlingBehavior2, z9, fM5270getMinSmallItemSizeD9Ej5fM, f113, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                } else {
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i13 = 67108864;
                        } else {
                            i13 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i13;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i16 = 536870912;
                        } else {
                            i16 = 268435456;
                        }
                        i3 |= i16;
                    }
                    i14 = i3;
                    if ((i14 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i112 = (i14 & 14) | 384;
                                carouselState2 = carouselState;
                                i14 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i112, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i12 != 0) {
                                f6 = fM10168constructorimpl;
                                z4 = z2;
                                modifier4 = modifier3;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                i15 = i14;
                            } else {
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f6 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                z4 = z2;
                                modifier4 = modifier3;
                                i15 = i14;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i113 = (i14 & 14) | 384;
                                carouselState2 = carouselState;
                                i14 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i113, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i12 != 0) {
                                f6 = fM10168constructorimpl;
                                z4 = z2;
                                modifier4 = modifier3;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                i15 = i14;
                            } else {
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f6 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                z4 = z2;
                                modifier4 = modifier3;
                                i15 = i14;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                        }
                        ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume4;
                        Orientation orientation4 = Orientation.Horizontal;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged4 = composerStartRestartGroup.changed(density);
                        if ((i15 & 112) == 32) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance4 = zChanged4 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i15 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance4 | z6 | ((i15 & 29360128) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState8 = carouselState2;
                            final float f114 = f8;
                            final float f115 = f7;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState8, f114, f115, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f9 = f114;
                            f5 = f115;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState9 = carouselState2;
                            final float f116 = f8;
                            final float f117 = f7;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState9, f116, f117, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f9 = f116;
                            f5 = f117;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i23 = i15 << 9;
                        PaddingValues paddingValues6 = paddingValuesM2343PaddingValues0680j_4;
                        m5276CarouselcJHQLPU(carouselState, orientation4, (Function2) objRememberedValue, paddingValues6, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i23) | (i23 & 3670016) | (i23 & 29360128) | (i23 & 234881024) | (1879048192 & i15), 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues6;
                        modifier2 = modifier4;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        fM5270getMinSmallItemSizeD9Ej5fM = f9;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        f5 = f4;
                        f6 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier7 = modifier2;
                        final float f118 = f6;
                        final boolean z10 = z4;
                        final float f119 = f5;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier7, f118, targetedFlingBehavior2, z10, fM5270getMinSmallItemSizeD9Ej5fM, f119, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i16 = 536870912;
                    } else {
                        i16 = 268435456;
                    }
                    i3 |= i16;
                }
                i14 = i3;
                if ((i14 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i114 = (i14 & 14) | 384;
                            carouselState2 = carouselState;
                            i14 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i114, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i12 != 0) {
                            f6 = fM10168constructorimpl;
                            z4 = z2;
                            modifier4 = modifier3;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            i15 = i14;
                        } else {
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            modifier4 = modifier3;
                            i15 = i14;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i115 = (i14 & 14) | 384;
                            carouselState2 = carouselState;
                            i14 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i115, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i12 != 0) {
                            f6 = fM10168constructorimpl;
                            z4 = z2;
                            modifier4 = modifier3;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            i15 = i14;
                        } else {
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            modifier4 = modifier3;
                            i15 = i14;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                    }
                    ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume5;
                    Orientation orientation5 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged5 = composerStartRestartGroup.changed(density);
                    if ((i15 & 112) == 32) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance5 = zChanged5 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i15 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance5 | z6 | ((i15 & 29360128) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState10 = carouselState2;
                        final float f1110 = f8;
                        final float f1111 = f7;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState10, f1110, f1111, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f9 = f1110;
                        f5 = f1111;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState11 = carouselState2;
                        final float f1112 = f8;
                        final float f1113 = f7;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState11, f1112, f1113, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f9 = f1112;
                        f5 = f1113;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i24 = i15 << 9;
                    PaddingValues paddingValues7 = paddingValuesM2343PaddingValues0680j_4;
                    m5276CarouselcJHQLPU(carouselState, orientation5, (Function2) objRememberedValue, paddingValues7, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i24) | (i24 & 3670016) | (i24 & 29360128) | (i24 & 234881024) | (1879048192 & i15), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues7;
                    modifier2 = modifier4;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    fM5270getMinSmallItemSizeD9Ej5fM = f9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f5 = f4;
                    f6 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier8 = modifier2;
                    final float f1114 = f6;
                    final boolean z11 = z4;
                    final float f1115 = f5;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier8, f1114, targetedFlingBehavior2, z11, fM5270getMinSmallItemSizeD9Ej5fM, f1115, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            fM10168constructorimpl = f2;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                    }
                    i3 |= i18;
                } else {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                }
                i3 |= i18;
            } else {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                } else {
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i13 = 67108864;
                        } else {
                            i13 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i13;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i16 = 536870912;
                        } else {
                            i16 = 268435456;
                        }
                        i3 |= i16;
                    }
                    i14 = i3;
                    if ((i14 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i116 = (i14 & 14) | 384;
                                carouselState2 = carouselState;
                                i14 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i116, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i12 != 0) {
                                f6 = fM10168constructorimpl;
                                z4 = z2;
                                modifier4 = modifier3;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                i15 = i14;
                            } else {
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f6 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                z4 = z2;
                                modifier4 = modifier3;
                                i15 = i14;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i117 = (i14 & 14) | 384;
                                carouselState2 = carouselState;
                                i14 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i117, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i12 != 0) {
                                f6 = fM10168constructorimpl;
                                z4 = z2;
                                modifier4 = modifier3;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                i15 = i14;
                            } else {
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f6 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                z4 = z2;
                                modifier4 = modifier3;
                                i15 = i14;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                        }
                        ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume6;
                        Orientation orientation6 = Orientation.Horizontal;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged6 = composerStartRestartGroup.changed(density);
                        if ((i15 & 112) == 32) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance6 = zChanged6 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i15 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance6 | z6 | ((i15 & 29360128) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState12 = carouselState2;
                            final float f1116 = f8;
                            final float f1117 = f7;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState12, f1116, f1117, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f9 = f1116;
                            f5 = f1117;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState13 = carouselState2;
                            final float f1118 = f8;
                            final float f1119 = f7;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState13, f1118, f1119, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f9 = f1118;
                            f5 = f1119;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i25 = i15 << 9;
                        PaddingValues paddingValues8 = paddingValuesM2343PaddingValues0680j_4;
                        m5276CarouselcJHQLPU(carouselState, orientation6, (Function2) objRememberedValue, paddingValues8, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i25) | (i25 & 3670016) | (i25 & 29360128) | (i25 & 234881024) | (1879048192 & i15), 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues8;
                        modifier2 = modifier4;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        fM5270getMinSmallItemSizeD9Ej5fM = f9;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        f5 = f4;
                        f6 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier9 = modifier2;
                        final float f11110 = f6;
                        final boolean z12 = z4;
                        final float f11111 = f5;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier9, f11110, targetedFlingBehavior2, z12, fM5270getMinSmallItemSizeD9Ej5fM, f11111, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i16 = 536870912;
                    } else {
                        i16 = 268435456;
                    }
                    i3 |= i16;
                }
                i14 = i3;
                if ((i14 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i118 = (i14 & 14) | 384;
                            carouselState2 = carouselState;
                            i14 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i118, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i12 != 0) {
                            f6 = fM10168constructorimpl;
                            z4 = z2;
                            modifier4 = modifier3;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            i15 = i14;
                        } else {
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            modifier4 = modifier3;
                            i15 = i14;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i119 = (i14 & 14) | 384;
                            carouselState2 = carouselState;
                            i14 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i119, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i12 != 0) {
                            f6 = fM10168constructorimpl;
                            z4 = z2;
                            modifier4 = modifier3;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            i15 = i14;
                        } else {
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            modifier4 = modifier3;
                            i15 = i14;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                    }
                    ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume7;
                    Orientation orientation7 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged7 = composerStartRestartGroup.changed(density);
                    if ((i15 & 112) == 32) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance7 = zChanged7 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i15 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance7 | z6 | ((i15 & 29360128) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState14 = carouselState2;
                        final float f11112 = f8;
                        final float f11113 = f7;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState14, f11112, f11113, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f9 = f11112;
                        f5 = f11113;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState15 = carouselState2;
                        final float f11114 = f8;
                        final float f11115 = f7;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState15, f11114, f11115, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f9 = f11114;
                        f5 = f11115;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i26 = i15 << 9;
                    PaddingValues paddingValues9 = paddingValuesM2343PaddingValues0680j_4;
                    m5276CarouselcJHQLPU(carouselState, orientation7, (Function2) objRememberedValue, paddingValues9, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i26) | (i26 & 3670016) | (i26 & 29360128) | (i26 & 234881024) | (1879048192 & i15), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues9;
                    modifier2 = modifier4;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    fM5270getMinSmallItemSizeD9Ej5fM = f9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f5 = f4;
                    f6 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier10 = modifier2;
                    final float f11116 = f6;
                    final boolean z13 = z4;
                    final float f11117 = f5;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier10, f11116, targetedFlingBehavior2, z13, fM5270getMinSmallItemSizeD9Ej5fM, f11117, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
            } else {
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i13 = 67108864;
                    } else {
                        i13 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i13;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i16 = 536870912;
                    } else {
                        i16 = 268435456;
                    }
                    i3 |= i16;
                }
                i14 = i3;
                if ((i14 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i1110 = (i14 & 14) | 384;
                            carouselState2 = carouselState;
                            i14 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1110, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i12 != 0) {
                            f6 = fM10168constructorimpl;
                            z4 = z2;
                            modifier4 = modifier3;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            i15 = i14;
                        } else {
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            modifier4 = modifier3;
                            i15 = i14;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i1111 = (i14 & 14) | 384;
                            carouselState2 = carouselState;
                            i14 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1111, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i12 != 0) {
                            f6 = fM10168constructorimpl;
                            z4 = z2;
                            modifier4 = modifier3;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            i15 = i14;
                        } else {
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            modifier4 = modifier3;
                            i15 = i14;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                    }
                    ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume8 = composerStartRestartGroup.consume(localDensity8);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume8;
                    Orientation orientation8 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged8 = composerStartRestartGroup.changed(density);
                    if ((i15 & 112) == 32) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance8 = zChanged8 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i15 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance8 | z6 | ((i15 & 29360128) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState16 = carouselState2;
                        final float f11118 = f8;
                        final float f11119 = f7;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState16, f11118, f11119, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f9 = f11118;
                        f5 = f11119;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState17 = carouselState2;
                        final float f111110 = f8;
                        final float f111111 = f7;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState17, f111110, f111111, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f9 = f111110;
                        f5 = f111111;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i27 = i15 << 9;
                    PaddingValues paddingValues10 = paddingValuesM2343PaddingValues0680j_4;
                    m5276CarouselcJHQLPU(carouselState, orientation8, (Function2) objRememberedValue, paddingValues10, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i27) | (i27 & 3670016) | (i27 & 29360128) | (i27 & 234881024) | (1879048192 & i15), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues10;
                    modifier2 = modifier4;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    fM5270getMinSmallItemSizeD9Ej5fM = f9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f5 = f4;
                    f6 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier11 = modifier2;
                    final float f111112 = f6;
                    final boolean z14 = z4;
                    final float f111113 = f5;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier11, f111112, targetedFlingBehavior2, z14, fM5270getMinSmallItemSizeD9Ej5fM, f111113, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i16 = 536870912;
                } else {
                    i16 = 268435456;
                }
                i3 |= i16;
            }
            i14 = i3;
            if ((i14 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i1112 = (i14 & 14) | 384;
                        carouselState2 = carouselState;
                        i14 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1112, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i12 != 0) {
                        f6 = fM10168constructorimpl;
                        z4 = z2;
                        modifier4 = modifier3;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        i15 = i14;
                    } else {
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f6 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        modifier4 = modifier3;
                        i15 = i14;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                    }
                } else {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i1113 = (i14 & 14) | 384;
                        carouselState2 = carouselState;
                        i14 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1113, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i12 != 0) {
                        f6 = fM10168constructorimpl;
                        z4 = z2;
                        modifier4 = modifier3;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        i15 = i14;
                    } else {
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f6 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        modifier4 = modifier3;
                        i15 = i14;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                }
                ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume9 = composerStartRestartGroup.consume(localDensity9);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume9;
                Orientation orientation9 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged9 = composerStartRestartGroup.changed(density);
                if ((i15 & 112) == 32) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChangedInstance9 = zChanged9 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                if ((i15 & 3670016) == 1048576) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance9 | z6 | ((i15 & 29360128) == 8388608);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    final CarouselState carouselState18 = carouselState2;
                    final float f111114 = f8;
                    final float f111115 = f7;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState18, f111114, f111115, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f9 = f111114;
                    f5 = f111115;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final CarouselState carouselState19 = carouselState2;
                    final float f111116 = f8;
                    final float f111117 = f7;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState19, f111116, f111117, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f9 = f111116;
                    f5 = f111117;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i28 = i15 << 9;
                PaddingValues paddingValues11 = paddingValuesM2343PaddingValues0680j_4;
                m5276CarouselcJHQLPU(carouselState, orientation9, (Function2) objRememberedValue, paddingValues11, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i28) | (i28 & 3670016) | (i28 & 29360128) | (i28 & 234881024) | (1879048192 & i15), 0);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues11;
                modifier2 = modifier4;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                fM5270getMinSmallItemSizeD9Ej5fM = f9;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f5 = f4;
                f6 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                z4 = z2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier12 = modifier2;
                final float f111118 = f6;
                final boolean z15 = z4;
                final float f111119 = f5;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier12, f111118, targetedFlingBehavior2, z15, fM5270getMinSmallItemSizeD9Ej5fM, f111119, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                fM10168constructorimpl = f2;
                if (composerStartRestartGroup.changed(fM10168constructorimpl)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                    }
                    i3 |= i18;
                } else {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                }
                i3 |= i18;
            } else {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                } else {
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i13 = 67108864;
                        } else {
                            i13 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i13;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i16 = 536870912;
                        } else {
                            i16 = 268435456;
                        }
                        i3 |= i16;
                    }
                    i14 = i3;
                    if ((i14 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i1114 = (i14 & 14) | 384;
                                carouselState2 = carouselState;
                                i14 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1114, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i12 != 0) {
                                f6 = fM10168constructorimpl;
                                z4 = z2;
                                modifier4 = modifier3;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                i15 = i14;
                            } else {
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f6 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                z4 = z2;
                                modifier4 = modifier3;
                                i15 = i14;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i1115 = (i14 & 14) | 384;
                                carouselState2 = carouselState;
                                i14 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1115, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i10 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i12 != 0) {
                                f6 = fM10168constructorimpl;
                                z4 = z2;
                                modifier4 = modifier3;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                i15 = i14;
                            } else {
                                f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f6 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                z4 = z2;
                                modifier4 = modifier3;
                                i15 = i14;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                        }
                        ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localDensity10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume10;
                        Orientation orientation10 = Orientation.Horizontal;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged10 = composerStartRestartGroup.changed(density);
                        if ((i15 & 112) == 32) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance10 = zChanged10 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i15 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance10 | z6 | ((i15 & 29360128) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState110 = carouselState2;
                            final float f1111110 = f8;
                            final float f1111111 = f7;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState110, f1111110, f1111111, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f9 = f1111110;
                            f5 = f1111111;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState111 = carouselState2;
                            final float f1111112 = f8;
                            final float f1111113 = f7;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState111, f1111112, f1111113, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f9 = f1111112;
                            f5 = f1111113;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i29 = i15 << 9;
                        PaddingValues paddingValues12 = paddingValuesM2343PaddingValues0680j_4;
                        m5276CarouselcJHQLPU(carouselState, orientation10, (Function2) objRememberedValue, paddingValues12, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i29) | (i29 & 3670016) | (i29 & 29360128) | (i29 & 234881024) | (1879048192 & i15), 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues12;
                        modifier2 = modifier4;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        fM5270getMinSmallItemSizeD9Ej5fM = f9;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        f5 = f4;
                        f6 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier13 = modifier2;
                        final float f1111114 = f6;
                        final boolean z16 = z4;
                        final float f1111115 = f5;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier13, f1111114, targetedFlingBehavior2, z16, fM5270getMinSmallItemSizeD9Ej5fM, f1111115, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i16 = 536870912;
                    } else {
                        i16 = 268435456;
                    }
                    i3 |= i16;
                }
                i14 = i3;
                if ((i14 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i1116 = (i14 & 14) | 384;
                            carouselState2 = carouselState;
                            i14 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1116, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i12 != 0) {
                            f6 = fM10168constructorimpl;
                            z4 = z2;
                            modifier4 = modifier3;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            i15 = i14;
                        } else {
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            modifier4 = modifier3;
                            i15 = i14;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i1117 = (i14 & 14) | 384;
                            carouselState2 = carouselState;
                            i14 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1117, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i12 != 0) {
                            f6 = fM10168constructorimpl;
                            z4 = z2;
                            modifier4 = modifier3;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            i15 = i14;
                        } else {
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            modifier4 = modifier3;
                            i15 = i14;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                    }
                    ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume11 = composerStartRestartGroup.consume(localDensity11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume11;
                    Orientation orientation11 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged11 = composerStartRestartGroup.changed(density);
                    if ((i15 & 112) == 32) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance11 = zChanged11 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i15 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance11 | z6 | ((i15 & 29360128) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState112 = carouselState2;
                        final float f1111116 = f8;
                        final float f1111117 = f7;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState112, f1111116, f1111117, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f9 = f1111116;
                        f5 = f1111117;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState113 = carouselState2;
                        final float f1111118 = f8;
                        final float f1111119 = f7;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState113, f1111118, f1111119, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f9 = f1111118;
                        f5 = f1111119;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i210 = i15 << 9;
                    PaddingValues paddingValues13 = paddingValuesM2343PaddingValues0680j_4;
                    m5276CarouselcJHQLPU(carouselState, orientation11, (Function2) objRememberedValue, paddingValues13, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i210) | (i210 & 3670016) | (i210 & 29360128) | (i210 & 234881024) | (1879048192 & i15), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues13;
                    modifier2 = modifier4;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    fM5270getMinSmallItemSizeD9Ej5fM = f9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f5 = f4;
                    f6 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier14 = modifier2;
                    final float f11111110 = f6;
                    final boolean z17 = z4;
                    final float f11111111 = f5;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier14, f11111110, targetedFlingBehavior2, z17, fM5270getMinSmallItemSizeD9Ej5fM, f11111111, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
            } else {
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i13 = 67108864;
                    } else {
                        i13 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i13;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i16 = 536870912;
                    } else {
                        i16 = 268435456;
                    }
                    i3 |= i16;
                }
                i14 = i3;
                if ((i14 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i1118 = (i14 & 14) | 384;
                            carouselState2 = carouselState;
                            i14 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1118, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i12 != 0) {
                            f6 = fM10168constructorimpl;
                            z4 = z2;
                            modifier4 = modifier3;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            i15 = i14;
                        } else {
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            modifier4 = modifier3;
                            i15 = i14;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i1119 = (i14 & 14) | 384;
                            carouselState2 = carouselState;
                            i14 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1119, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i12 != 0) {
                            f6 = fM10168constructorimpl;
                            z4 = z2;
                            modifier4 = modifier3;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            i15 = i14;
                        } else {
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            modifier4 = modifier3;
                            i15 = i14;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                    }
                    ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume12 = composerStartRestartGroup.consume(localDensity12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume12;
                    Orientation orientation12 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged12 = composerStartRestartGroup.changed(density);
                    if ((i15 & 112) == 32) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance12 = zChanged12 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i15 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance12 | z6 | ((i15 & 29360128) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState114 = carouselState2;
                        final float f11111112 = f8;
                        final float f11111113 = f7;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState114, f11111112, f11111113, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f9 = f11111112;
                        f5 = f11111113;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState115 = carouselState2;
                        final float f11111114 = f8;
                        final float f11111115 = f7;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState115, f11111114, f11111115, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f9 = f11111114;
                        f5 = f11111115;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211 = i15 << 9;
                    PaddingValues paddingValues14 = paddingValuesM2343PaddingValues0680j_4;
                    m5276CarouselcJHQLPU(carouselState, orientation12, (Function2) objRememberedValue, paddingValues14, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i211) | (i211 & 3670016) | (i211 & 29360128) | (i211 & 234881024) | (1879048192 & i15), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues14;
                    modifier2 = modifier4;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    fM5270getMinSmallItemSizeD9Ej5fM = f9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f5 = f4;
                    f6 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier15 = modifier2;
                    final float f11111116 = f6;
                    final boolean z18 = z4;
                    final float f11111117 = f5;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier15, f11111116, targetedFlingBehavior2, z18, fM5270getMinSmallItemSizeD9Ej5fM, f11111117, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i16 = 536870912;
                } else {
                    i16 = 268435456;
                }
                i3 |= i16;
            }
            i14 = i3;
            if ((i14 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i11110 = (i14 & 14) | 384;
                        carouselState2 = carouselState;
                        i14 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i11110, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i12 != 0) {
                        f6 = fM10168constructorimpl;
                        z4 = z2;
                        modifier4 = modifier3;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        i15 = i14;
                    } else {
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f6 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        modifier4 = modifier3;
                        i15 = i14;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                    }
                } else {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i11111 = (i14 & 14) | 384;
                        carouselState2 = carouselState;
                        i14 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i11111, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i12 != 0) {
                        f6 = fM10168constructorimpl;
                        z4 = z2;
                        modifier4 = modifier3;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        i15 = i14;
                    } else {
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f6 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        modifier4 = modifier3;
                        i15 = i14;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                }
                ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume13 = composerStartRestartGroup.consume(localDensity13);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume13;
                Orientation orientation13 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged13 = composerStartRestartGroup.changed(density);
                if ((i15 & 112) == 32) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChangedInstance13 = zChanged13 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                if ((i15 & 3670016) == 1048576) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance13 | z6 | ((i15 & 29360128) == 8388608);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    final CarouselState carouselState116 = carouselState2;
                    final float f11111118 = f8;
                    final float f11111119 = f7;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState116, f11111118, f11111119, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f9 = f11111118;
                    f5 = f11111119;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final CarouselState carouselState117 = carouselState2;
                    final float f111111110 = f8;
                    final float f111111111 = f7;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState117, f111111110, f111111111, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f9 = f111111110;
                    f5 = f111111111;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i212 = i15 << 9;
                PaddingValues paddingValues15 = paddingValuesM2343PaddingValues0680j_4;
                m5276CarouselcJHQLPU(carouselState, orientation13, (Function2) objRememberedValue, paddingValues15, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i212) | (i212 & 3670016) | (i212 & 29360128) | (i212 & 234881024) | (1879048192 & i15), 0);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues15;
                modifier2 = modifier4;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                fM5270getMinSmallItemSizeD9Ej5fM = f9;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f5 = f4;
                f6 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                z4 = z2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier16 = modifier2;
                final float f111111112 = f6;
                final boolean z19 = z4;
                final float f111111113 = f5;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier16, f111111112, targetedFlingBehavior2, z19, fM5270getMinSmallItemSizeD9Ej5fM, f111111113, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        fM10168constructorimpl = f2;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                }
                i3 |= i18;
            } else {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
            }
            i3 |= i18;
        } else {
            targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
            } else {
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i13 = 67108864;
                    } else {
                        i13 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i13;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i16 = 536870912;
                    } else {
                        i16 = 268435456;
                    }
                    i3 |= i16;
                }
                i14 = i3;
                if ((i14 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i11112 = (i14 & 14) | 384;
                            carouselState2 = carouselState;
                            i14 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i11112, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i12 != 0) {
                            f6 = fM10168constructorimpl;
                            z4 = z2;
                            modifier4 = modifier3;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            i15 = i14;
                        } else {
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            modifier4 = modifier3;
                            i15 = i14;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i11113 = (i14 & 14) | 384;
                            carouselState2 = carouselState;
                            i14 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i11113, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i10 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i12 != 0) {
                            f6 = fM10168constructorimpl;
                            z4 = z2;
                            modifier4 = modifier3;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            i15 = i14;
                        } else {
                            f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f6 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            modifier4 = modifier3;
                            i15 = i14;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                    }
                    ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localDensity14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume14;
                    Orientation orientation14 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged14 = composerStartRestartGroup.changed(density);
                    if ((i15 & 112) == 32) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance14 = zChanged14 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i15 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance14 | z6 | ((i15 & 29360128) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState118 = carouselState2;
                        final float f111111114 = f8;
                        final float f111111115 = f7;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState118, f111111114, f111111115, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f9 = f111111114;
                        f5 = f111111115;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState119 = carouselState2;
                        final float f111111116 = f8;
                        final float f111111117 = f7;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState119, f111111116, f111111117, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f9 = f111111116;
                        f5 = f111111117;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i213 = i15 << 9;
                    PaddingValues paddingValues16 = paddingValuesM2343PaddingValues0680j_4;
                    m5276CarouselcJHQLPU(carouselState, orientation14, (Function2) objRememberedValue, paddingValues16, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i213) | (i213 & 3670016) | (i213 & 29360128) | (i213 & 234881024) | (1879048192 & i15), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues16;
                    modifier2 = modifier4;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    fM5270getMinSmallItemSizeD9Ej5fM = f9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f5 = f4;
                    f6 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier17 = modifier2;
                    final float f111111118 = f6;
                    final boolean z110 = z4;
                    final float f111111119 = f5;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier17, f111111118, targetedFlingBehavior2, z110, fM5270getMinSmallItemSizeD9Ej5fM, f111111119, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i16 = 536870912;
                } else {
                    i16 = 268435456;
                }
                i3 |= i16;
            }
            i14 = i3;
            if ((i14 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i11114 = (i14 & 14) | 384;
                        carouselState2 = carouselState;
                        i14 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i11114, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i12 != 0) {
                        f6 = fM10168constructorimpl;
                        z4 = z2;
                        modifier4 = modifier3;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        i15 = i14;
                    } else {
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f6 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        modifier4 = modifier3;
                        i15 = i14;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                    }
                } else {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i11115 = (i14 & 14) | 384;
                        carouselState2 = carouselState;
                        i14 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i11115, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i12 != 0) {
                        f6 = fM10168constructorimpl;
                        z4 = z2;
                        modifier4 = modifier3;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        i15 = i14;
                    } else {
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f6 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        modifier4 = modifier3;
                        i15 = i14;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                }
                ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(localDensity15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume15;
                Orientation orientation15 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged15 = composerStartRestartGroup.changed(density);
                if ((i15 & 112) == 32) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChangedInstance15 = zChanged15 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                if ((i15 & 3670016) == 1048576) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance15 | z6 | ((i15 & 29360128) == 8388608);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    final CarouselState carouselState1110 = carouselState2;
                    final float f1111111110 = f8;
                    final float f1111111111 = f7;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState1110, f1111111110, f1111111111, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f9 = f1111111110;
                    f5 = f1111111111;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final CarouselState carouselState1111 = carouselState2;
                    final float f1111111112 = f8;
                    final float f1111111113 = f7;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState1111, f1111111112, f1111111113, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f9 = f1111111112;
                    f5 = f1111111113;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i214 = i15 << 9;
                PaddingValues paddingValues17 = paddingValuesM2343PaddingValues0680j_4;
                m5276CarouselcJHQLPU(carouselState, orientation15, (Function2) objRememberedValue, paddingValues17, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i214) | (i214 & 3670016) | (i214 & 29360128) | (i214 & 234881024) | (1879048192 & i15), 0);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues17;
                modifier2 = modifier4;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                fM5270getMinSmallItemSizeD9Ej5fM = f9;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f5 = f4;
                f6 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                z4 = z2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier18 = modifier2;
                final float f1111111114 = f6;
                final boolean z111 = z4;
                final float f1111111115 = f5;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier18, f1111111114, targetedFlingBehavior2, z111, fM5270getMinSmallItemSizeD9Ej5fM, f1111111115, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
            fM5270getMinSmallItemSizeD9Ej5fM = f3;
        } else {
            fM5270getMinSmallItemSizeD9Ej5fM = f3;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
        }
        i10 = i2 & 128;
        if (i10 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(f4)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i3 |= i11;
        }
        i12 = i2 & 256;
        if (i12 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i13 = 67108864;
                } else {
                    i13 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i3 |= i13;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i16 = 536870912;
                } else {
                    i16 = 268435456;
                }
                i3 |= i16;
            }
            i14 = i3;
            if ((i14 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i11116 = (i14 & 14) | 384;
                        carouselState2 = carouselState;
                        i14 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i11116, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i12 != 0) {
                        f6 = fM10168constructorimpl;
                        z4 = z2;
                        modifier4 = modifier3;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        i15 = i14;
                    } else {
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f6 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        modifier4 = modifier3;
                        i15 = i14;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                    }
                } else {
                    if (i17 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i11117 = (i14 & 14) | 384;
                        carouselState2 = carouselState;
                        i14 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i11117, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i10 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i12 != 0) {
                        f6 = fM10168constructorimpl;
                        z4 = z2;
                        modifier4 = modifier3;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        i15 = i14;
                    } else {
                        f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f6 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        modifier4 = modifier3;
                        i15 = i14;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
                }
                ProvidableCompositionLocal<Density> localDensity16 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume16 = composerStartRestartGroup.consume(localDensity16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume16;
                Orientation orientation16 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged16 = composerStartRestartGroup.changed(density);
                if ((i15 & 112) == 32) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChangedInstance16 = zChanged16 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                if ((i15 & 3670016) == 1048576) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance16 | z6 | ((i15 & 29360128) == 8388608);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    final CarouselState carouselState1112 = carouselState2;
                    final float f1111111116 = f8;
                    final float f1111111117 = f7;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState1112, f1111111116, f1111111117, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f9 = f1111111116;
                    f5 = f1111111117;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final CarouselState carouselState1113 = carouselState2;
                    final float f1111111118 = f8;
                    final float f1111111119 = f7;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState1113, f1111111118, f1111111119, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f9 = f1111111118;
                    f5 = f1111111119;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i215 = i15 << 9;
                PaddingValues paddingValues18 = paddingValuesM2343PaddingValues0680j_4;
                m5276CarouselcJHQLPU(carouselState, orientation16, (Function2) objRememberedValue, paddingValues18, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i215) | (i215 & 3670016) | (i215 & 29360128) | (i215 & 234881024) | (1879048192 & i15), 0);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues18;
                modifier2 = modifier4;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                fM5270getMinSmallItemSizeD9Ej5fM = f9;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f5 = f4;
                f6 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                z4 = z2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier19 = modifier2;
                final float f11111111110 = f6;
                final boolean z112 = z4;
                final float f11111111111 = f5;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier19, f11111111110, targetedFlingBehavior2, z112, fM5270getMinSmallItemSizeD9Ej5fM, f11111111111, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 100663296;
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i16 = 536870912;
            } else {
                i16 = 268435456;
            }
            i3 |= i16;
        }
        i14 = i3;
        if ((i14 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "114@5886L41");
            if ((i & 1) != 0) {
                if (i17 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
                if ((i2 & 16) != 0) {
                    int i11118 = (i14 & 14) | 384;
                    carouselState2 = carouselState;
                    i14 &= -57345;
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i11118, 2);
                } else {
                    carouselState2 = carouselState;
                }
                if (i6 != 0) {
                    z2 = true;
                }
                if (i8 != 0) {
                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                }
                if (i10 != 0) {
                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                } else {
                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                }
                if (i12 != 0) {
                    f6 = fM10168constructorimpl;
                    z4 = z2;
                    modifier4 = modifier3;
                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                    f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                    f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    i15 = i14;
                } else {
                    f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                    f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                    f6 = fM10168constructorimpl;
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    modifier4 = modifier3;
                    i15 = i14;
                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                }
            } else {
                if (i17 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
                if ((i2 & 16) != 0) {
                    int i11119 = (i14 & 14) | 384;
                    carouselState2 = carouselState;
                    i14 &= -57345;
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i11119, 2);
                } else {
                    carouselState2 = carouselState;
                }
                if (i6 != 0) {
                    z2 = true;
                }
                if (i8 != 0) {
                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                }
                if (i10 != 0) {
                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                } else {
                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                }
                if (i12 != 0) {
                    f6 = fM10168constructorimpl;
                    z4 = z2;
                    modifier4 = modifier3;
                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                    f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                    f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    i15 = i14;
                } else {
                    f7 = fM5269getMaxSmallItemSizeD9Ej5fM;
                    f8 = fM5270getMinSmallItemSizeD9Ej5fM;
                    f6 = fM10168constructorimpl;
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    modifier4 = modifier3;
                    i15 = i14;
                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-221490402, i15, -1, "androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel (Carousel.kt:120)");
            }
            ProvidableCompositionLocal<Density> localDensity17 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume17 = composerStartRestartGroup.consume(localDensity17);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume17;
            Orientation orientation17 = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1896111507, "CC(remember):Carousel.kt#9igjgp");
            boolean zChanged17 = composerStartRestartGroup.changed(density);
            if ((i15 & 112) == 32) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean zChangedInstance17 = zChanged17 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
            if ((i15 & 3670016) == 1048576) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 = zChangedInstance17 | z6 | ((i15 & 29360128) == 8388608);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z7) {
                final CarouselState carouselState1114 = carouselState2;
                final float f11111111112 = f8;
                final float f11111111113 = f7;
                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState1114, f11111111112, f11111111113, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                    }
                };
                f9 = f11111111112;
                f5 = f11111111113;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                final CarouselState carouselState1115 = carouselState2;
                final float f11111111114 = f8;
                final float f11111111115 = f7;
                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(density, f, carouselState1115, f11111111114, f11111111115, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                    }
                };
                f9 = f11111111114;
                f5 = f11111111115;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i216 = i15 << 9;
            PaddingValues paddingValues19 = paddingValuesM2343PaddingValues0680j_4;
            m5276CarouselcJHQLPU(carouselState, orientation17, (Function2) objRememberedValue, paddingValues19, 2, modifier4, f6, targetedFlingBehavior3, z4, function4, composerStartRestartGroup, (i15 & 14) | 24624 | ((i15 >> 15) & 7168) | (458752 & i216) | (i216 & 3670016) | (i216 & 29360128) | (i216 & 234881024) | (1879048192 & i15), 0);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            paddingValues2 = paddingValues19;
            modifier2 = modifier4;
            targetedFlingBehavior2 = targetedFlingBehavior3;
            fM5270getMinSmallItemSizeD9Ej5fM = f9;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            f5 = f4;
            f6 = fM10168constructorimpl;
            targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
            z4 = z2;
            paddingValues2 = paddingValues;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier110 = modifier2;
            final float f11111111116 = f6;
            final boolean z113 = z4;
            final float f11111111117 = f5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CarouselKt.HorizontalMultiBrowseCarousel_3tcCNu0$lambda$1(carouselState, f, modifier110, f11111111116, targetedFlingBehavior2, z113, fM5270getMinSmallItemSizeD9Ej5fM, f11111111117, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeylineList HorizontalMultiBrowseCarousel_3tcCNu0$lambda$0$0(Density density, float f, CarouselState carouselState, float f2, float f3, float f4, float f5) {
        return KeylinesKt.multiBrowseKeylineList(density, f4, density.mo1734toPx0680j_4(f), f5, carouselState.getPagerState().getPageCountState().getValue().invoke().intValue(), density.mo1734toPx0680j_4(f2), density.mo1734toPx0680j_4(f3));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0137  */
    /* JADX WARN: Code duplicated, block: B:103:0x0140  */
    /* JADX WARN: Code duplicated, block: B:104:0x014a  */
    /* JADX WARN: Code duplicated, block: B:106:0x014e  */
    /* JADX WARN: Code duplicated, block: B:108:0x0152  */
    /* JADX WARN: Code duplicated, block: B:111:0x0171  */
    /* JADX WARN: Code duplicated, block: B:114:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:117:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:119:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:122:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:124:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:127:0x020f  */
    /* JADX WARN: Code duplicated, block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0092  */
    /* JADX WARN: Code duplicated, block: B:57:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x009d  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:87:0x0102  */
    /* JADX WARN: Code duplicated, block: B:93:0x0113 A[PHI: r6 r7 r8 r11 r13
      0x0113: PHI (r6v24 androidx.compose.ui.Modifier) = (r6v5 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:107:0x0150, B:92:0x0110] A[DONT_GENERATE, DONT_INLINE]
      0x0113: PHI (r7v13 int) = (r7v8 int), (r7v15 int) binds: [B:107:0x0150, B:92:0x0110] A[DONT_GENERATE, DONT_INLINE]
      0x0113: PHI (r8v10 float) = (r8v4 float), (r8v2 float) binds: [B:107:0x0150, B:92:0x0110] A[DONT_GENERATE, DONT_INLINE]
      0x0113: PHI (r11v11 androidx.compose.foundation.gestures.TargetedFlingBehavior) = 
      (r11v8 androidx.compose.foundation.gestures.TargetedFlingBehavior)
      (r11v6 androidx.compose.foundation.gestures.TargetedFlingBehavior)
     binds: [B:107:0x0150, B:92:0x0110] A[DONT_GENERATE, DONT_INLINE]
      0x0113: PHI (r13v10 boolean) = (r13v4 boolean), (r13v3 boolean) binds: [B:107:0x0150, B:92:0x0110] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x012d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x012f  */
    /* JADX INFO: renamed from: HorizontalUncontainedCarousel-VUP9l70, reason: not valid java name */
    public static final void m5279HorizontalUncontainedCarouselVUP9l70(final CarouselState carouselState, final float f, Modifier modifier, float f2, TargetedFlingBehavior targetedFlingBehavior, boolean z, PaddingValues paddingValues, final Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        float fM10168constructorimpl;
        int i5;
        TargetedFlingBehavior targetedFlingBehaviorNoSnapFlingBehavior;
        int i6;
        boolean z2;
        int i7;
        int i8;
        PaddingValues paddingValues2;
        int i9;
        int i10;
        boolean z3;
        boolean z4;
        Composer composer2;
        final Modifier modifier3;
        final float f3;
        final TargetedFlingBehavior targetedFlingBehavior2;
        final boolean z5;
        final PaddingValues paddingValues3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        PaddingValues paddingValuesM2343PaddingValues0680j_4;
        boolean z6;
        Modifier modifier4;
        float f4;
        TargetedFlingBehavior targetedFlingBehavior3;
        int i12;
        final Density density;
        boolean z7;
        Object objRememberedValue;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(534621863);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalUncontainedCarousel)N(state,itemWidth:c#ui.unit.Dp,modifier,itemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,contentPadding,content)189@9347L7,193@9460L337,190@9359L866:Carousel.kt#dcf9yb");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(carouselState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        int i14 = i2 & 4;
        if (i14 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    fM10168constructorimpl = f2;
                    if (composerStartRestartGroup.changed(fM10168constructorimpl)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        targetedFlingBehaviorNoSnapFlingBehavior = targetedFlingBehavior;
                        int i15 = composerStartRestartGroup.changed(targetedFlingBehaviorNoSnapFlingBehavior) ? 16384 : 8192;
                        i3 |= i15;
                    } else {
                        targetedFlingBehaviorNoSnapFlingBehavior = targetedFlingBehavior;
                    }
                    i3 |= i15;
                } else {
                    targetedFlingBehaviorNoSnapFlingBehavior = targetedFlingBehavior;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        if ((1572864 & i) == 0) {
                            paddingValues2 = paddingValues;
                            if (composerStartRestartGroup.changed(paddingValues2)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i13 = 8388608;
                            } else {
                                i13 = 4194304;
                            }
                            i3 |= i13;
                        }
                        i10 = i3;
                        z3 = false;
                        if ((i3 & 4793491) != 4793490) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                }
                                if ((i2 & 16) != 0) {
                                    i11 = i10 & (-57345);
                                    targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                                } else {
                                    i11 = i10;
                                }
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                if (i8 != 0) {
                                    boolean z8 = z2;
                                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                    z3 = false;
                                    z6 = z8;
                                    modifier4 = modifier2;
                                    f4 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                    i12 = 534621863;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                                }
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                density = (Density) objConsume;
                                Orientation orientation = Orientation.Horizontal;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                                boolean zChanged = composerStartRestartGroup.changed(density);
                                if ((i11 & 112) == 32) {
                                    z3 = true;
                                }
                                z7 = z3 | zChanged;
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z7 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i16 = i11 << 9;
                                composer2 = composerStartRestartGroup;
                                m5276CarouselcJHQLPU(carouselState, orientation, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i16) | (3670016 & i16) | (29360128 & i16) | (i16 & 234881024) | ((i11 << 6) & 1879048192), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                                modifier3 = modifier4;
                                f3 = f4;
                                targetedFlingBehavior2 = targetedFlingBehavior3;
                                z5 = z6;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i11 = i10 & (-57345);
                                } else {
                                    targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                    i11 = i10;
                                    i12 = 534621863;
                                    f4 = fM10168constructorimpl;
                                }
                                z6 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                                modifier4 = modifier2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                                }
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                density = (Density) objConsume2;
                                Orientation orientation2 = Orientation.Horizontal;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                                boolean zChanged2 = composerStartRestartGroup.changed(density);
                                if ((i11 & 112) == 32) {
                                    z3 = true;
                                }
                                z7 = z3 | zChanged2;
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z7) {
                                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i17 = i11 << 9;
                                composer2 = composerStartRestartGroup;
                                m5276CarouselcJHQLPU(carouselState, orientation2, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i17) | (3670016 & i17) | (29360128 & i17) | (i17 & 234881024) | ((i11 << 6) & 1879048192), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                                modifier3 = modifier4;
                                f3 = f4;
                                targetedFlingBehavior2 = targetedFlingBehavior3;
                                z5 = z6;
                            }
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                            }
                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume3;
                            Orientation orientation3 = Orientation.Horizontal;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                            boolean zChanged3 = composerStartRestartGroup.changed(density);
                            if ((i11 & 112) == 32) {
                                z3 = true;
                            }
                            z7 = z3 | zChanged3;
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z7) {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i18 = i11 << 9;
                            composer2 = composerStartRestartGroup;
                            m5276CarouselcJHQLPU(carouselState, orientation3, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (i18 & 234881024) | ((i11 << 6) & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                            modifier3 = modifier4;
                            f3 = f4;
                            targetedFlingBehavior2 = targetedFlingBehavior3;
                            z5 = z6;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            f3 = fM10168constructorimpl;
                            targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                            z5 = z2;
                            paddingValues3 = paddingValues2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    paddingValues2 = paddingValues;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i3 |= i13;
                    }
                    i10 = i3;
                    z3 = false;
                    if ((i3 & 4793491) != 4793490) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i10 & (-57345);
                                targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                            } else {
                                i11 = i10;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                boolean z9 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                z3 = false;
                                z6 = z9;
                                modifier4 = modifier2;
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                            } else {
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                                z6 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                                modifier4 = modifier2;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i10 & (-57345);
                                targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                            } else {
                                i11 = i10;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                boolean z10 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                z3 = false;
                                z6 = z10;
                                modifier4 = modifier2;
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                            } else {
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                                z6 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                                modifier4 = modifier2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                        }
                        ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume4;
                        Orientation orientation4 = Orientation.Horizontal;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged4 = composerStartRestartGroup.changed(density);
                        if ((i11 & 112) == 32) {
                            z3 = true;
                        }
                        z7 = z3 | zChanged4;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i19 = i11 << 9;
                        composer2 = composerStartRestartGroup;
                        m5276CarouselcJHQLPU(carouselState, orientation4, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i19) | (3670016 & i19) | (29360128 & i19) | (i19 & 234881024) | ((i11 << 6) & 1879048192), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                        modifier3 = modifier4;
                        f3 = f4;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z5 = z6;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        f3 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                        z5 = z2;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i3 |= i13;
                    }
                    i10 = i3;
                    z3 = false;
                    if ((i3 & 4793491) != 4793490) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i10 & (-57345);
                                targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                            } else {
                                i11 = i10;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                boolean z11 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                z3 = false;
                                z6 = z11;
                                modifier4 = modifier2;
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                            } else {
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                                z6 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                                modifier4 = modifier2;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i10 & (-57345);
                                targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                            } else {
                                i11 = i10;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                boolean z12 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                z3 = false;
                                z6 = z12;
                                modifier4 = modifier2;
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                            } else {
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                                z6 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                                modifier4 = modifier2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                        }
                        ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume5;
                        Orientation orientation5 = Orientation.Horizontal;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged5 = composerStartRestartGroup.changed(density);
                        if ((i11 & 112) == 32) {
                            z3 = true;
                        }
                        z7 = z3 | zChanged5;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i110 = i11 << 9;
                        composer2 = composerStartRestartGroup;
                        m5276CarouselcJHQLPU(carouselState, orientation5, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i110) | (3670016 & i110) | (29360128 & i110) | (i110 & 234881024) | ((i11 << 6) & 1879048192), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                        modifier3 = modifier4;
                        f3 = f4;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z5 = z6;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        f3 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                        z5 = z2;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                paddingValues2 = paddingValues;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                i10 = i3;
                z3 = false;
                if ((i3 & 4793491) != 4793490) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            boolean z13 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            z3 = false;
                            z6 = z13;
                            modifier4 = modifier2;
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                        } else {
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            boolean z14 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            z3 = false;
                            z6 = z14;
                            modifier4 = modifier2;
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                        } else {
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                    }
                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume6;
                    Orientation orientation6 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged6 = composerStartRestartGroup.changed(density);
                    if ((i11 & 112) == 32) {
                        z3 = true;
                    }
                    z7 = z3 | zChanged6;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i111 = i11 << 9;
                    composer2 = composerStartRestartGroup;
                    m5276CarouselcJHQLPU(carouselState, orientation6, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i111) | (3670016 & i111) | (29360128 & i111) | (i111 & 234881024) | ((i11 << 6) & 1879048192), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                    modifier3 = modifier4;
                    f3 = f4;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z5 = z6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                    z5 = z2;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            fM10168constructorimpl = f2;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    targetedFlingBehaviorNoSnapFlingBehavior = targetedFlingBehavior;
                    if (composerStartRestartGroup.changed(targetedFlingBehaviorNoSnapFlingBehavior)) {
                    }
                    i3 |= i15;
                } else {
                    targetedFlingBehaviorNoSnapFlingBehavior = targetedFlingBehavior;
                }
                i3 |= i15;
            } else {
                targetedFlingBehaviorNoSnapFlingBehavior = targetedFlingBehavior;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i3 |= i13;
                    }
                    i10 = i3;
                    z3 = false;
                    if ((i3 & 4793491) != 4793490) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i10 & (-57345);
                                targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                            } else {
                                i11 = i10;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                boolean z15 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                z3 = false;
                                z6 = z15;
                                modifier4 = modifier2;
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                            } else {
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                                z6 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                                modifier4 = modifier2;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i10 & (-57345);
                                targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                            } else {
                                i11 = i10;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                boolean z16 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                z3 = false;
                                z6 = z16;
                                modifier4 = modifier2;
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                            } else {
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                                z6 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                                modifier4 = modifier2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                        }
                        ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume7;
                        Orientation orientation7 = Orientation.Horizontal;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged7 = composerStartRestartGroup.changed(density);
                        if ((i11 & 112) == 32) {
                            z3 = true;
                        }
                        z7 = z3 | zChanged7;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i112 = i11 << 9;
                        composer2 = composerStartRestartGroup;
                        m5276CarouselcJHQLPU(carouselState, orientation7, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i112) | (3670016 & i112) | (29360128 & i112) | (i112 & 234881024) | ((i11 << 6) & 1879048192), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                        modifier3 = modifier4;
                        f3 = f4;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z5 = z6;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        f3 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                        z5 = z2;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                paddingValues2 = paddingValues;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                i10 = i3;
                z3 = false;
                if ((i3 & 4793491) != 4793490) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            boolean z17 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            z3 = false;
                            z6 = z17;
                            modifier4 = modifier2;
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                        } else {
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            boolean z18 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            z3 = false;
                            z6 = z18;
                            modifier4 = modifier2;
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                        } else {
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                    }
                    ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume8 = composerStartRestartGroup.consume(localDensity8);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume8;
                    Orientation orientation8 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged8 = composerStartRestartGroup.changed(density);
                    if ((i11 & 112) == 32) {
                        z3 = true;
                    }
                    z7 = z3 | zChanged8;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i113 = i11 << 9;
                    composer2 = composerStartRestartGroup;
                    m5276CarouselcJHQLPU(carouselState, orientation8, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i113) | (3670016 & i113) | (29360128 & i113) | (i113 & 234881024) | ((i11 << 6) & 1879048192), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                    modifier3 = modifier4;
                    f3 = f4;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z5 = z6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                    z5 = z2;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                i10 = i3;
                z3 = false;
                if ((i3 & 4793491) != 4793490) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            boolean z19 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            z3 = false;
                            z6 = z19;
                            modifier4 = modifier2;
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                        } else {
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            boolean z110 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            z3 = false;
                            z6 = z110;
                            modifier4 = modifier2;
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                        } else {
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                    }
                    ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume9 = composerStartRestartGroup.consume(localDensity9);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume9;
                    Orientation orientation9 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged9 = composerStartRestartGroup.changed(density);
                    if ((i11 & 112) == 32) {
                        z3 = true;
                    }
                    z7 = z3 | zChanged9;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i114 = i11 << 9;
                    composer2 = composerStartRestartGroup;
                    m5276CarouselcJHQLPU(carouselState, orientation9, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i114) | (3670016 & i114) | (29360128 & i114) | (i114 & 234881024) | ((i11 << 6) & 1879048192), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                    modifier3 = modifier4;
                    f3 = f4;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z5 = z6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                    z5 = z2;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            paddingValues2 = paddingValues;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            i10 = i3;
            z3 = false;
            if ((i3 & 4793491) != 4793490) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        boolean z111 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        z3 = false;
                        z6 = z111;
                        modifier4 = modifier2;
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                    } else {
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                        z6 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                        modifier4 = modifier2;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        boolean z112 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        z3 = false;
                        z6 = z112;
                        modifier4 = modifier2;
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                    } else {
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                        z6 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                        modifier4 = modifier2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                }
                ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume10 = composerStartRestartGroup.consume(localDensity10);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume10;
                Orientation orientation10 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged10 = composerStartRestartGroup.changed(density);
                if ((i11 & 112) == 32) {
                    z3 = true;
                }
                z7 = z3 | zChanged10;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i115 = i11 << 9;
                composer2 = composerStartRestartGroup;
                m5276CarouselcJHQLPU(carouselState, orientation10, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i115) | (3670016 & i115) | (29360128 & i115) | (i115 & 234881024) | ((i11 << 6) & 1879048192), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                modifier3 = modifier4;
                f3 = f4;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                z5 = z6;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                f3 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                z5 = z2;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                fM10168constructorimpl = f2;
                if (composerStartRestartGroup.changed(fM10168constructorimpl)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    targetedFlingBehaviorNoSnapFlingBehavior = targetedFlingBehavior;
                    if (composerStartRestartGroup.changed(targetedFlingBehaviorNoSnapFlingBehavior)) {
                    }
                    i3 |= i15;
                } else {
                    targetedFlingBehaviorNoSnapFlingBehavior = targetedFlingBehavior;
                }
                i3 |= i15;
            } else {
                targetedFlingBehaviorNoSnapFlingBehavior = targetedFlingBehavior;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i3 |= i13;
                    }
                    i10 = i3;
                    z3 = false;
                    if ((i3 & 4793491) != 4793490) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i10 & (-57345);
                                targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                            } else {
                                i11 = i10;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                boolean z113 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                z3 = false;
                                z6 = z113;
                                modifier4 = modifier2;
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                            } else {
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                                z6 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                                modifier4 = modifier2;
                            }
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i10 & (-57345);
                                targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                            } else {
                                i11 = i10;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                boolean z114 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                z3 = false;
                                z6 = z114;
                                modifier4 = modifier2;
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                            } else {
                                f4 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                                i12 = 534621863;
                                z6 = z2;
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                                modifier4 = modifier2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                        }
                        ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11 = composerStartRestartGroup.consume(localDensity11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume11;
                        Orientation orientation11 = Orientation.Horizontal;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged11 = composerStartRestartGroup.changed(density);
                        if ((i11 & 112) == 32) {
                            z3 = true;
                        }
                        z7 = z3 | zChanged11;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i116 = i11 << 9;
                        composer2 = composerStartRestartGroup;
                        m5276CarouselcJHQLPU(carouselState, orientation11, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i116) | (3670016 & i116) | (29360128 & i116) | (i116 & 234881024) | ((i11 << 6) & 1879048192), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                        modifier3 = modifier4;
                        f3 = f4;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z5 = z6;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        f3 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                        z5 = z2;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                paddingValues2 = paddingValues;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                i10 = i3;
                z3 = false;
                if ((i3 & 4793491) != 4793490) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            boolean z115 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            z3 = false;
                            z6 = z115;
                            modifier4 = modifier2;
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                        } else {
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            boolean z116 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            z3 = false;
                            z6 = z116;
                            modifier4 = modifier2;
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                        } else {
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                    }
                    ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume12 = composerStartRestartGroup.consume(localDensity12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume12;
                    Orientation orientation12 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged12 = composerStartRestartGroup.changed(density);
                    if ((i11 & 112) == 32) {
                        z3 = true;
                    }
                    z7 = z3 | zChanged12;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i117 = i11 << 9;
                    composer2 = composerStartRestartGroup;
                    m5276CarouselcJHQLPU(carouselState, orientation12, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i117) | (3670016 & i117) | (29360128 & i117) | (i117 & 234881024) | ((i11 << 6) & 1879048192), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                    modifier3 = modifier4;
                    f3 = f4;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z5 = z6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                    z5 = z2;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                i10 = i3;
                z3 = false;
                if ((i3 & 4793491) != 4793490) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            boolean z117 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            z3 = false;
                            z6 = z117;
                            modifier4 = modifier2;
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                        } else {
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            boolean z118 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            z3 = false;
                            z6 = z118;
                            modifier4 = modifier2;
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                        } else {
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                    }
                    ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume13 = composerStartRestartGroup.consume(localDensity13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume13;
                    Orientation orientation13 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged13 = composerStartRestartGroup.changed(density);
                    if ((i11 & 112) == 32) {
                        z3 = true;
                    }
                    z7 = z3 | zChanged13;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i118 = i11 << 9;
                    composer2 = composerStartRestartGroup;
                    m5276CarouselcJHQLPU(carouselState, orientation13, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i118) | (3670016 & i118) | (29360128 & i118) | (i118 & 234881024) | ((i11 << 6) & 1879048192), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                    modifier3 = modifier4;
                    f3 = f4;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z5 = z6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                    z5 = z2;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            paddingValues2 = paddingValues;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            i10 = i3;
            z3 = false;
            if ((i3 & 4793491) != 4793490) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        boolean z119 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        z3 = false;
                        z6 = z119;
                        modifier4 = modifier2;
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                    } else {
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                        z6 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                        modifier4 = modifier2;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        boolean z1110 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        z3 = false;
                        z6 = z1110;
                        modifier4 = modifier2;
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                    } else {
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                        z6 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                        modifier4 = modifier2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                }
                ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume14 = composerStartRestartGroup.consume(localDensity14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume14;
                Orientation orientation14 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged14 = composerStartRestartGroup.changed(density);
                if ((i11 & 112) == 32) {
                    z3 = true;
                }
                z7 = z3 | zChanged14;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i119 = i11 << 9;
                composer2 = composerStartRestartGroup;
                m5276CarouselcJHQLPU(carouselState, orientation14, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i119) | (3670016 & i119) | (29360128 & i119) | (i119 & 234881024) | ((i11 << 6) & 1879048192), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                modifier3 = modifier4;
                f3 = f4;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                z5 = z6;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                f3 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                z5 = z2;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        fM10168constructorimpl = f2;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                targetedFlingBehaviorNoSnapFlingBehavior = targetedFlingBehavior;
                if (composerStartRestartGroup.changed(targetedFlingBehaviorNoSnapFlingBehavior)) {
                }
                i3 |= i15;
            } else {
                targetedFlingBehaviorNoSnapFlingBehavior = targetedFlingBehavior;
            }
            i3 |= i15;
        } else {
            targetedFlingBehaviorNoSnapFlingBehavior = targetedFlingBehavior;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                i10 = i3;
                z3 = false;
                if ((i3 & 4793491) != 4793490) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            boolean z1111 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            z3 = false;
                            z6 = z1111;
                            modifier4 = modifier2;
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                        } else {
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            boolean z1112 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            z3 = false;
                            z6 = z1112;
                            modifier4 = modifier2;
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                        } else {
                            f4 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                            i12 = 534621863;
                            z6 = z2;
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                            modifier4 = modifier2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                    }
                    ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume15 = composerStartRestartGroup.consume(localDensity15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume15;
                    Orientation orientation15 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged15 = composerStartRestartGroup.changed(density);
                    if ((i11 & 112) == 32) {
                        z3 = true;
                    }
                    z7 = z3 | zChanged15;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i1110 = i11 << 9;
                    composer2 = composerStartRestartGroup;
                    m5276CarouselcJHQLPU(carouselState, orientation15, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i1110) | (3670016 & i1110) | (29360128 & i1110) | (i1110 & 234881024) | ((i11 << 6) & 1879048192), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                    modifier3 = modifier4;
                    f3 = f4;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z5 = z6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                    z5 = z2;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            paddingValues2 = paddingValues;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            i10 = i3;
            z3 = false;
            if ((i3 & 4793491) != 4793490) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        boolean z1113 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        z3 = false;
                        z6 = z1113;
                        modifier4 = modifier2;
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                    } else {
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                        z6 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                        modifier4 = modifier2;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        boolean z1114 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        z3 = false;
                        z6 = z1114;
                        modifier4 = modifier2;
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                    } else {
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                        z6 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                        modifier4 = modifier2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                }
                ProvidableCompositionLocal<Density> localDensity16 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume16 = composerStartRestartGroup.consume(localDensity16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume16;
                Orientation orientation16 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged16 = composerStartRestartGroup.changed(density);
                if ((i11 & 112) == 32) {
                    z3 = true;
                }
                z7 = z3 | zChanged16;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i1111 = i11 << 9;
                composer2 = composerStartRestartGroup;
                m5276CarouselcJHQLPU(carouselState, orientation16, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i1111) | (3670016 & i1111) | (29360128 & i1111) | (i1111 & 234881024) | ((i11 << 6) & 1879048192), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                modifier3 = modifier4;
                f3 = f4;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                z5 = z6;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                f3 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                z5 = z2;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        i8 = i2 & 64;
        if (i8 != 0) {
            if ((1572864 & i) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            i10 = i3;
            z3 = false;
            if ((i3 & 4793491) != 4793490) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        boolean z1115 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        z3 = false;
                        z6 = z1115;
                        modifier4 = modifier2;
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                    } else {
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                        z6 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                        modifier4 = modifier2;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        boolean z1116 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        z3 = false;
                        z6 = z1116;
                        modifier4 = modifier2;
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                    } else {
                        f4 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                        i12 = 534621863;
                        z6 = z2;
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                        modifier4 = modifier2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
                }
                ProvidableCompositionLocal<Density> localDensity17 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume17 = composerStartRestartGroup.consume(localDensity17);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume17;
                Orientation orientation17 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged17 = composerStartRestartGroup.changed(density);
                if ((i11 & 112) == 32) {
                    z3 = true;
                }
                z7 = z3 | zChanged17;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i1112 = i11 << 9;
                composer2 = composerStartRestartGroup;
                m5276CarouselcJHQLPU(carouselState, orientation17, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i1112) | (3670016 & i1112) | (29360128 & i1112) | (i1112 & 234881024) | ((i11 << 6) & 1879048192), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                modifier3 = modifier4;
                f3 = f4;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                z5 = z6;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                f3 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
                z5 = z2;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        paddingValues2 = paddingValues;
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i13 = 8388608;
            } else {
                i13 = 4194304;
            }
            i3 |= i13;
        }
        i10 = i3;
        z3 = false;
        if ((i3 & 4793491) != 4793490) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "184@9124L21");
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
                if ((i2 & 16) != 0) {
                    i11 = i10 & (-57345);
                    targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                } else {
                    i11 = i10;
                }
                if (i6 != 0) {
                    z2 = true;
                }
                if (i8 != 0) {
                    boolean z1117 = z2;
                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                    z3 = false;
                    z6 = z1117;
                    modifier4 = modifier2;
                    f4 = fM10168constructorimpl;
                    targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                    i12 = 534621863;
                } else {
                    f4 = fM10168constructorimpl;
                    targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                    i12 = 534621863;
                    z6 = z2;
                    paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                    modifier4 = modifier2;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
                if ((i2 & 16) != 0) {
                    i11 = i10 & (-57345);
                    targetedFlingBehaviorNoSnapFlingBehavior = CarouselDefaults.INSTANCE.noSnapFlingBehavior(composerStartRestartGroup, 6);
                } else {
                    i11 = i10;
                }
                if (i6 != 0) {
                    z2 = true;
                }
                if (i8 != 0) {
                    boolean z1118 = z2;
                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                    z3 = false;
                    z6 = z1118;
                    modifier4 = modifier2;
                    f4 = fM10168constructorimpl;
                    targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                    i12 = 534621863;
                } else {
                    f4 = fM10168constructorimpl;
                    targetedFlingBehavior3 = targetedFlingBehaviorNoSnapFlingBehavior;
                    i12 = 534621863;
                    z6 = z2;
                    paddingValuesM2343PaddingValues0680j_4 = paddingValues2;
                    modifier4 = modifier2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.carousel.HorizontalUncontainedCarousel (Carousel.kt:188)");
            }
            ProvidableCompositionLocal<Density> localDensity18 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume18 = composerStartRestartGroup.consume(localDensity18);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume18;
            Orientation orientation18 = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1624447592, "CC(remember):Carousel.kt#9igjgp");
            boolean zChanged18 = composerStartRestartGroup.changed(density);
            if ((i11 & 112) == 32) {
                z3 = true;
            }
            z7 = z3 | zChanged18;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(density, f, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i1113 = i11 << 9;
            composer2 = composerStartRestartGroup;
            m5276CarouselcJHQLPU(carouselState, orientation18, (Function2) objRememberedValue, paddingValuesM2343PaddingValues0680j_4, 0, modifier4, f4, targetedFlingBehavior3, z6, function4, composer2, (i11 & 14) | 24624 | ((i11 >> 9) & 7168) | (458752 & i1113) | (3670016 & i1113) | (29360128 & i1113) | (i1113 & 234881024) | ((i11 << 6) & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
            modifier3 = modifier4;
            f3 = f4;
            targetedFlingBehavior2 = targetedFlingBehavior3;
            z5 = z6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            f3 = fM10168constructorimpl;
            targetedFlingBehavior2 = targetedFlingBehaviorNoSnapFlingBehavior;
            z5 = z2;
            paddingValues3 = paddingValues2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CarouselKt.HorizontalUncontainedCarousel_VUP9l70$lambda$1(carouselState, f, modifier3, f3, targetedFlingBehavior2, z5, paddingValues3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeylineList HorizontalUncontainedCarousel_VUP9l70$lambda$0$0(Density density, float f, float f2, float f3) {
        return KeylinesKt.uncontainedKeylineList(density, f2, density.mo1734toPx0680j_4(f), f3);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011f  */
    /* JADX WARN: Code duplicated, block: B:101:0x0122  */
    /* JADX WARN: Code duplicated, block: B:105:0x0136  */
    /* JADX WARN: Code duplicated, block: B:106:0x0139  */
    /* JADX WARN: Code duplicated, block: B:109:0x0143  */
    /* JADX WARN: Code duplicated, block: B:111:0x0152  */
    /* JADX WARN: Code duplicated, block: B:118:0x0172 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x0174  */
    /* JADX WARN: Code duplicated, block: B:120:0x017b  */
    /* JADX WARN: Code duplicated, block: B:122:0x017f  */
    /* JADX WARN: Code duplicated, block: B:125:0x018a  */
    /* JADX WARN: Code duplicated, block: B:128:0x0193  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:136:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:139:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:145:0x0222  */
    /* JADX WARN: Code duplicated, block: B:146:0x0225  */
    /* JADX WARN: Code duplicated, block: B:149:0x0238  */
    /* JADX WARN: Code duplicated, block: B:150:0x023b  */
    /* JADX WARN: Code duplicated, block: B:153:0x0248  */
    /* JADX WARN: Code duplicated, block: B:156:0x0252  */
    /* JADX WARN: Code duplicated, block: B:160:0x0262  */
    /* JADX WARN: Code duplicated, block: B:163:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:165:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:168:0x02db  */
    /* JADX WARN: Code duplicated, block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x009e  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:92:0x0105  */
    /* JADX WARN: Code duplicated, block: B:93:0x0108  */
    /* JADX WARN: Code duplicated, block: B:98:0x0119  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: HorizontalCenteredHeroCarousel-p2lB3Bg, reason: not valid java name */
    public static final void m5277HorizontalCenteredHeroCarouselp2lB3Bg(final CarouselState carouselState, Modifier modifier, float f, float f2, TargetedFlingBehavior targetedFlingBehavior, boolean z, float f3, float f4, PaddingValues paddingValues, final Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        float fM10188getUnspecifiedD9Ej5fM;
        int i5;
        int i6;
        float fM10168constructorimpl;
        int i7;
        TargetedFlingBehavior targetedFlingBehaviorSingleAdvanceFlingBehavior;
        int i8;
        boolean z2;
        int i9;
        int i10;
        final float fM5270getMinSmallItemSizeD9Ej5fM;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z3;
        final PaddingValues paddingValues2;
        final Modifier modifier3;
        final float f5;
        final TargetedFlingBehavior targetedFlingBehavior2;
        final boolean z4;
        Composer composer2;
        final float f6;
        final float f7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        CarouselState carouselState2;
        float fM5269getMaxSmallItemSizeD9Ej5fM;
        PaddingValues paddingValuesM2343PaddingValues0680j_4;
        float f8;
        float f9;
        float f10;
        TargetedFlingBehavior targetedFlingBehavior3;
        Modifier modifier5;
        int i17;
        final Density density;
        final float f11;
        boolean z5;
        boolean z6;
        boolean z7;
        Object objRememberedValue;
        float f12;
        float f13;
        int i18;
        Composer composerStartRestartGroup = composer.startRestartGroup(1493031269);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalCenteredHeroCarousel)N(state,modifier,maxItemWidth:c#ui.unit.Dp,itemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,minSmallItemWidth:c#ui.unit.Dp,maxSmallItemWidth:c#ui.unit.Dp,contentPadding,content)254@12506L7,258@12619L625,255@12518L1168:Carousel.kt#dcf9yb");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(carouselState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i19 = i2 & 2;
        if (i19 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    fM10188getUnspecifiedD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM10188getUnspecifiedD9Ej5fM)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        fM10168constructorimpl = f2;
                        if (composerStartRestartGroup.changed(fM10168constructorimpl)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        if ((i2 & 16) == 0) {
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                            int i20 = composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior) ? 16384 : 8192;
                            i3 |= i20;
                        } else {
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                        }
                        i3 |= i20;
                    } else {
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            z2 = z;
                            if (composerStartRestartGroup.changed(z2)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 64;
                        if (i10 != 0) {
                            i3 |= 1572864;
                            fM5270getMinSmallItemSizeD9Ej5fM = f3;
                        } else {
                            fM5270getMinSmallItemSizeD9Ej5fM = f3;
                            if ((i & 1572864) == 0) {
                                if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                                    i11 = 1048576;
                                } else {
                                    i11 = 524288;
                                }
                                i3 |= i11;
                            }
                        }
                        i12 = i2 & 128;
                        if (i12 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(f4)) {
                                i13 = 8388608;
                            } else {
                                i13 = 4194304;
                            }
                            i3 |= i13;
                        }
                        i14 = i2 & 256;
                        if (i14 != 0) {
                            if ((i & 100663296) == 0) {
                                if (composerStartRestartGroup.changed(paddingValues)) {
                                    i15 = 67108864;
                                } else {
                                    i15 = GroupFlagsKt.HasAuxSlotFlag;
                                }
                                i3 |= i15;
                            }
                            if ((i & 805306368) == 0) {
                                if (composerStartRestartGroup.changedInstance(function4)) {
                                    i18 = 536870912;
                                } else {
                                    i18 = 268435456;
                                }
                                i3 |= i18;
                            }
                            i16 = i3;
                            if ((i16 & 306783379) != 306783378) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i19 != 0) {
                                        modifier4 = Modifier.INSTANCE;
                                    } else {
                                        modifier4 = modifier2;
                                    }
                                    if (i4 != 0) {
                                        fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                                    }
                                    if (i6 != 0) {
                                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                    }
                                    if ((i2 & 16) != 0) {
                                        int i21 = (i16 & 14) | 384;
                                        carouselState2 = carouselState;
                                        i16 &= -57345;
                                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21, 2);
                                    } else {
                                        carouselState2 = carouselState;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if (i10 != 0) {
                                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                                    }
                                    if (i12 != 0) {
                                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                                    } else {
                                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                                    }
                                    if (i14 != 0) {
                                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                        f10 = fM10168constructorimpl;
                                        modifier5 = modifier4;
                                        i17 = i16;
                                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    } else {
                                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                        f10 = fM10168constructorimpl;
                                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                        modifier5 = modifier4;
                                        i17 = i16;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        i16 &= -57345;
                                    }
                                    carouselState2 = carouselState;
                                    f8 = f4;
                                    modifier5 = modifier2;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    f10 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    i17 = i16;
                                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                                }
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                density = (Density) objConsume;
                                Orientation orientation = Orientation.Horizontal;
                                f11 = f9;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                                boolean zChanged = composerStartRestartGroup.changed(density);
                                if ((i17 & 896) == 256) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                boolean zChangedInstance = zChanged | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                                if ((i17 & 3670016) == 1048576) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                z7 = zChangedInstance | z6 | ((29360128 & i17) == 8388608);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z7 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    final CarouselState carouselState3 = carouselState2;
                                    final float f14 = f8;
                                    final float f15 = fM10188getUnspecifiedD9Ej5fM;
                                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f15, carouselState3, f11, f14, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                        }
                                    };
                                    f12 = f15;
                                    f13 = f14;
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                } else {
                                    f13 = f8;
                                    f12 = fM10188getUnspecifiedD9Ej5fM;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i22 = i17 << 9;
                                PaddingValues paddingValues3 = paddingValuesM2343PaddingValues0680j_4;
                                boolean z8 = z2;
                                m5276CarouselcJHQLPU(carouselState, orientation, (Function2) objRememberedValue, paddingValues3, 2, modifier5, f10, targetedFlingBehavior3, z8, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i22 & 3670016) | (29360128 & i22) | (i22 & 234881024) | (1879048192 & i17), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                paddingValues2 = paddingValues3;
                                composer2 = composerStartRestartGroup;
                                modifier3 = modifier5;
                                f5 = f10;
                                targetedFlingBehavior2 = targetedFlingBehavior3;
                                z4 = z8;
                                f6 = f12;
                                fM5270getMinSmallItemSizeD9Ej5fM = f11;
                                f7 = f13;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                paddingValues2 = paddingValues;
                                modifier3 = modifier2;
                                f5 = fM10168constructorimpl;
                                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                z4 = z2;
                                composer2 = composerStartRestartGroup;
                                f6 = fM10188getUnspecifiedD9Ej5fM;
                                f7 = f4;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 100663296;
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i18 = 536870912;
                            } else {
                                i18 = 268435456;
                            }
                            i3 |= i18;
                        }
                        i16 = i3;
                        if ((i16 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                            if ((i & 1) != 0) {
                                if (i19 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i4 != 0) {
                                    fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                }
                                if ((i2 & 16) != 0) {
                                    int i23 = (i16 & 14) | 384;
                                    carouselState2 = carouselState;
                                    i16 &= -57345;
                                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i23, 2);
                                } else {
                                    carouselState2 = carouselState;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if (i10 != 0) {
                                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                                }
                                if (i12 != 0) {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                                } else {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                                }
                                if (i14 != 0) {
                                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                    f10 = fM10168constructorimpl;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                } else {
                                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    f10 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                }
                            } else {
                                if (i19 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i4 != 0) {
                                    fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                }
                                if ((i2 & 16) != 0) {
                                    int i24 = (i16 & 14) | 384;
                                    carouselState2 = carouselState;
                                    i16 &= -57345;
                                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i24, 2);
                                } else {
                                    carouselState2 = carouselState;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if (i10 != 0) {
                                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                                }
                                if (i12 != 0) {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                                } else {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                                }
                                if (i14 != 0) {
                                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                    f10 = fM10168constructorimpl;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                } else {
                                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    f10 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                            }
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume2;
                            Orientation orientation2 = Orientation.Horizontal;
                            f11 = f9;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                            boolean zChanged2 = composerStartRestartGroup.changed(density);
                            if ((i17 & 896) == 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            boolean zChangedInstance2 = zChanged2 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                            if ((i17 & 3670016) == 1048576) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            z7 = zChangedInstance2 | z6 | ((29360128 & i17) == 8388608);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z7) {
                                final CarouselState carouselState4 = carouselState2;
                                final float f16 = f8;
                                final float f17 = fM10188getUnspecifiedD9Ej5fM;
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f17, carouselState4, f11, f16, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                f12 = f17;
                                f13 = f16;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                final CarouselState carouselState5 = carouselState2;
                                final float f18 = f8;
                                final float f19 = fM10188getUnspecifiedD9Ej5fM;
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f19, carouselState5, f11, f18, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                f12 = f19;
                                f13 = f18;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i25 = i17 << 9;
                            PaddingValues paddingValues4 = paddingValuesM2343PaddingValues0680j_4;
                            boolean z9 = z2;
                            m5276CarouselcJHQLPU(carouselState, orientation2, (Function2) objRememberedValue, paddingValues4, 2, modifier5, f10, targetedFlingBehavior3, z9, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i25 & 3670016) | (29360128 & i25) | (i25 & 234881024) | (1879048192 & i17), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues4;
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier5;
                            f5 = f10;
                            targetedFlingBehavior2 = targetedFlingBehavior3;
                            z4 = z9;
                            f6 = f12;
                            fM5270getMinSmallItemSizeD9Ej5fM = f11;
                            f7 = f13;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            paddingValues2 = paddingValues;
                            modifier3 = modifier2;
                            f5 = fM10168constructorimpl;
                            targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            composer2 = composerStartRestartGroup;
                            f6 = fM10188getUnspecifiedD9Ej5fM;
                            f7 = f4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    z2 = z;
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                        fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    } else {
                        fM5270getMinSmallItemSizeD9Ej5fM = f3;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                                i11 = 1048576;
                            } else {
                                i11 = 524288;
                            }
                            i3 |= i11;
                        }
                    }
                    i12 = i2 & 128;
                    if (i12 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f4)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 256;
                    if (i14 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i15 = 67108864;
                            } else {
                                i15 = GroupFlagsKt.HasAuxSlotFlag;
                            }
                            i3 |= i15;
                        }
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i18 = 536870912;
                            } else {
                                i18 = 268435456;
                            }
                            i3 |= i18;
                        }
                        i16 = i3;
                        if ((i16 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                            if ((i & 1) != 0) {
                                if (i19 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i4 != 0) {
                                    fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                }
                                if ((i2 & 16) != 0) {
                                    int i26 = (i16 & 14) | 384;
                                    carouselState2 = carouselState;
                                    i16 &= -57345;
                                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i26, 2);
                                } else {
                                    carouselState2 = carouselState;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if (i10 != 0) {
                                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                                }
                                if (i12 != 0) {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                                } else {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                                }
                                if (i14 != 0) {
                                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                    f10 = fM10168constructorimpl;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                } else {
                                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    f10 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                }
                            } else {
                                if (i19 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i4 != 0) {
                                    fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                }
                                if ((i2 & 16) != 0) {
                                    int i27 = (i16 & 14) | 384;
                                    carouselState2 = carouselState;
                                    i16 &= -57345;
                                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i27, 2);
                                } else {
                                    carouselState2 = carouselState;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if (i10 != 0) {
                                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                                }
                                if (i12 != 0) {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                                } else {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                                }
                                if (i14 != 0) {
                                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                    f10 = fM10168constructorimpl;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                } else {
                                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    f10 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                            }
                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume3;
                            Orientation orientation3 = Orientation.Horizontal;
                            f11 = f9;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                            boolean zChanged3 = composerStartRestartGroup.changed(density);
                            if ((i17 & 896) == 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            boolean zChangedInstance3 = zChanged3 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                            if ((i17 & 3670016) == 1048576) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            z7 = zChangedInstance3 | z6 | ((29360128 & i17) == 8388608);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z7) {
                                final CarouselState carouselState6 = carouselState2;
                                final float f110 = f8;
                                final float f111 = fM10188getUnspecifiedD9Ej5fM;
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111, carouselState6, f11, f110, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                f12 = f111;
                                f13 = f110;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                final CarouselState carouselState7 = carouselState2;
                                final float f112 = f8;
                                final float f113 = fM10188getUnspecifiedD9Ej5fM;
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f113, carouselState7, f11, f112, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                f12 = f113;
                                f13 = f112;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i28 = i17 << 9;
                            PaddingValues paddingValues5 = paddingValuesM2343PaddingValues0680j_4;
                            boolean z10 = z2;
                            m5276CarouselcJHQLPU(carouselState, orientation3, (Function2) objRememberedValue, paddingValues5, 2, modifier5, f10, targetedFlingBehavior3, z10, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i28 & 3670016) | (29360128 & i28) | (i28 & 234881024) | (1879048192 & i17), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues5;
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier5;
                            f5 = f10;
                            targetedFlingBehavior2 = targetedFlingBehavior3;
                            z4 = z10;
                            f6 = f12;
                            fM5270getMinSmallItemSizeD9Ej5fM = f11;
                            f7 = f13;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            paddingValues2 = paddingValues;
                            modifier3 = modifier2;
                            f5 = fM10168constructorimpl;
                            targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            composer2 = composerStartRestartGroup;
                            f6 = fM10188getUnspecifiedD9Ej5fM;
                            f7 = f4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i3 |= i18;
                    }
                    i16 = i3;
                    if ((i16 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i29 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i29, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        } else {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i210 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i210, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                        }
                        ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume4;
                        Orientation orientation4 = Orientation.Horizontal;
                        f11 = f9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged4 = composerStartRestartGroup.changed(density);
                        if ((i17 & 896) == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance4 = zChanged4 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i17 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance4 | z6 | ((29360128 & i17) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState8 = carouselState2;
                            final float f114 = f8;
                            final float f115 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f115, carouselState8, f11, f114, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f115;
                            f13 = f114;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState9 = carouselState2;
                            final float f116 = f8;
                            final float f117 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f117, carouselState9, f11, f116, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f117;
                            f13 = f116;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i211 = i17 << 9;
                        PaddingValues paddingValues6 = paddingValuesM2343PaddingValues0680j_4;
                        boolean z11 = z2;
                        m5276CarouselcJHQLPU(carouselState, orientation4, (Function2) objRememberedValue, paddingValues6, 2, modifier5, f10, targetedFlingBehavior3, z11, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i211 & 3670016) | (29360128 & i211) | (i211 & 234881024) | (1879048192 & i17), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues6;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier5;
                        f5 = f10;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z4 = z11;
                        f6 = f12;
                        fM5270getMinSmallItemSizeD9Ej5fM = f11;
                        f7 = f13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        f5 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        composer2 = composerStartRestartGroup;
                        f6 = fM10188getUnspecifiedD9Ej5fM;
                        f7 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                fM10168constructorimpl = f2;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                        if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                        }
                        i3 |= i20;
                    } else {
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    }
                    i3 |= i20;
                } else {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                        fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    } else {
                        fM5270getMinSmallItemSizeD9Ej5fM = f3;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                                i11 = 1048576;
                            } else {
                                i11 = 524288;
                            }
                            i3 |= i11;
                        }
                    }
                    i12 = i2 & 128;
                    if (i12 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f4)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 256;
                    if (i14 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i15 = 67108864;
                            } else {
                                i15 = GroupFlagsKt.HasAuxSlotFlag;
                            }
                            i3 |= i15;
                        }
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i18 = 536870912;
                            } else {
                                i18 = 268435456;
                            }
                            i3 |= i18;
                        }
                        i16 = i3;
                        if ((i16 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                            if ((i & 1) != 0) {
                                if (i19 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i4 != 0) {
                                    fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                }
                                if ((i2 & 16) != 0) {
                                    int i212 = (i16 & 14) | 384;
                                    carouselState2 = carouselState;
                                    i16 &= -57345;
                                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i212, 2);
                                } else {
                                    carouselState2 = carouselState;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if (i10 != 0) {
                                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                                }
                                if (i12 != 0) {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                                } else {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                                }
                                if (i14 != 0) {
                                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                    f10 = fM10168constructorimpl;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                } else {
                                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    f10 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                }
                            } else {
                                if (i19 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i4 != 0) {
                                    fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                }
                                if ((i2 & 16) != 0) {
                                    int i213 = (i16 & 14) | 384;
                                    carouselState2 = carouselState;
                                    i16 &= -57345;
                                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i213, 2);
                                } else {
                                    carouselState2 = carouselState;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if (i10 != 0) {
                                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                                }
                                if (i12 != 0) {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                                } else {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                                }
                                if (i14 != 0) {
                                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                    f10 = fM10168constructorimpl;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                } else {
                                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    f10 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                            }
                            ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume5;
                            Orientation orientation5 = Orientation.Horizontal;
                            f11 = f9;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                            boolean zChanged5 = composerStartRestartGroup.changed(density);
                            if ((i17 & 896) == 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            boolean zChangedInstance5 = zChanged5 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                            if ((i17 & 3670016) == 1048576) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            z7 = zChangedInstance5 | z6 | ((29360128 & i17) == 8388608);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z7) {
                                final CarouselState carouselState10 = carouselState2;
                                final float f118 = f8;
                                final float f119 = fM10188getUnspecifiedD9Ej5fM;
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f119, carouselState10, f11, f118, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                f12 = f119;
                                f13 = f118;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                final CarouselState carouselState11 = carouselState2;
                                final float f1110 = f8;
                                final float f1111 = fM10188getUnspecifiedD9Ej5fM;
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111, carouselState11, f11, f1110, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                f12 = f1111;
                                f13 = f1110;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i214 = i17 << 9;
                            PaddingValues paddingValues7 = paddingValuesM2343PaddingValues0680j_4;
                            boolean z12 = z2;
                            m5276CarouselcJHQLPU(carouselState, orientation5, (Function2) objRememberedValue, paddingValues7, 2, modifier5, f10, targetedFlingBehavior3, z12, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i214 & 3670016) | (29360128 & i214) | (i214 & 234881024) | (1879048192 & i17), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues7;
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier5;
                            f5 = f10;
                            targetedFlingBehavior2 = targetedFlingBehavior3;
                            z4 = z12;
                            f6 = f12;
                            fM5270getMinSmallItemSizeD9Ej5fM = f11;
                            f7 = f13;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            paddingValues2 = paddingValues;
                            modifier3 = modifier2;
                            f5 = fM10168constructorimpl;
                            targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            composer2 = composerStartRestartGroup;
                            f6 = fM10188getUnspecifiedD9Ej5fM;
                            f7 = f4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i3 |= i18;
                    }
                    i16 = i3;
                    if ((i16 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i215 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i215, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        } else {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i216 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i216, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                        }
                        ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume6;
                        Orientation orientation6 = Orientation.Horizontal;
                        f11 = f9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged6 = composerStartRestartGroup.changed(density);
                        if ((i17 & 896) == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance6 = zChanged6 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i17 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance6 | z6 | ((29360128 & i17) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState12 = carouselState2;
                            final float f1112 = f8;
                            final float f1113 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1113, carouselState12, f11, f1112, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f1113;
                            f13 = f1112;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState13 = carouselState2;
                            final float f1114 = f8;
                            final float f1115 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1115, carouselState13, f11, f1114, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f1115;
                            f13 = f1114;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i217 = i17 << 9;
                        PaddingValues paddingValues8 = paddingValuesM2343PaddingValues0680j_4;
                        boolean z13 = z2;
                        m5276CarouselcJHQLPU(carouselState, orientation6, (Function2) objRememberedValue, paddingValues8, 2, modifier5, f10, targetedFlingBehavior3, z13, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i217 & 3670016) | (29360128 & i217) | (i217 & 234881024) | (1879048192 & i17), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues8;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier5;
                        f5 = f10;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z4 = z13;
                        f6 = f12;
                        fM5270getMinSmallItemSizeD9Ej5fM = f11;
                        f7 = f13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        f5 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        composer2 = composerStartRestartGroup;
                        f6 = fM10188getUnspecifiedD9Ej5fM;
                        f7 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                } else {
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 128;
                if (i12 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 256;
                if (i14 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i15 = 67108864;
                        } else {
                            i15 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i15;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i3 |= i18;
                    }
                    i16 = i3;
                    if ((i16 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i218 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i218, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        } else {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i219 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i219, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                        }
                        ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume7;
                        Orientation orientation7 = Orientation.Horizontal;
                        f11 = f9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged7 = composerStartRestartGroup.changed(density);
                        if ((i17 & 896) == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance7 = zChanged7 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i17 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance7 | z6 | ((29360128 & i17) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState14 = carouselState2;
                            final float f1116 = f8;
                            final float f1117 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1117, carouselState14, f11, f1116, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f1117;
                            f13 = f1116;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState15 = carouselState2;
                            final float f1118 = f8;
                            final float f1119 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1119, carouselState15, f11, f1118, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f1119;
                            f13 = f1118;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i2110 = i17 << 9;
                        PaddingValues paddingValues9 = paddingValuesM2343PaddingValues0680j_4;
                        boolean z14 = z2;
                        m5276CarouselcJHQLPU(carouselState, orientation7, (Function2) objRememberedValue, paddingValues9, 2, modifier5, f10, targetedFlingBehavior3, z14, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i2110 & 3670016) | (29360128 & i2110) | (i2110 & 234881024) | (1879048192 & i17), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues9;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier5;
                        f5 = f10;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z4 = z14;
                        f6 = f12;
                        fM5270getMinSmallItemSizeD9Ej5fM = f11;
                        f7 = f13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        f5 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        composer2 = composerStartRestartGroup;
                        f6 = fM10188getUnspecifiedD9Ej5fM;
                        f7 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i3 |= i18;
                }
                i16 = i3;
                if ((i16 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i2111 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    } else {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i2112 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2112, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                    }
                    ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume8 = composerStartRestartGroup.consume(localDensity8);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume8;
                    Orientation orientation8 = Orientation.Horizontal;
                    f11 = f9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged8 = composerStartRestartGroup.changed(density);
                    if ((i17 & 896) == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance8 = zChanged8 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i17 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance8 | z6 | ((29360128 & i17) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState16 = carouselState2;
                        final float f11110 = f8;
                        final float f11111 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111, carouselState16, f11, f11110, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f11111;
                        f13 = f11110;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState17 = carouselState2;
                        final float f11112 = f8;
                        final float f11113 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11113, carouselState17, f11, f11112, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f11113;
                        f13 = f11112;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2113 = i17 << 9;
                    PaddingValues paddingValues10 = paddingValuesM2343PaddingValues0680j_4;
                    boolean z15 = z2;
                    m5276CarouselcJHQLPU(carouselState, orientation8, (Function2) objRememberedValue, paddingValues10, 2, modifier5, f10, targetedFlingBehavior3, z15, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i2113 & 3670016) | (29360128 & i2113) | (i2113 & 234881024) | (1879048192 & i17), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues10;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    f5 = f10;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z15;
                    f6 = f12;
                    fM5270getMinSmallItemSizeD9Ej5fM = f11;
                    f7 = f13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    f5 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    f6 = fM10188getUnspecifiedD9Ej5fM;
                    f7 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            fM10188getUnspecifiedD9Ej5fM = f;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    fM10168constructorimpl = f2;
                    if (composerStartRestartGroup.changed(fM10168constructorimpl)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                        if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                        }
                        i3 |= i20;
                    } else {
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    }
                    i3 |= i20;
                } else {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                        fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    } else {
                        fM5270getMinSmallItemSizeD9Ej5fM = f3;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                                i11 = 1048576;
                            } else {
                                i11 = 524288;
                            }
                            i3 |= i11;
                        }
                    }
                    i12 = i2 & 128;
                    if (i12 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f4)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 256;
                    if (i14 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i15 = 67108864;
                            } else {
                                i15 = GroupFlagsKt.HasAuxSlotFlag;
                            }
                            i3 |= i15;
                        }
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i18 = 536870912;
                            } else {
                                i18 = 268435456;
                            }
                            i3 |= i18;
                        }
                        i16 = i3;
                        if ((i16 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                            if ((i & 1) != 0) {
                                if (i19 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i4 != 0) {
                                    fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                }
                                if ((i2 & 16) != 0) {
                                    int i2114 = (i16 & 14) | 384;
                                    carouselState2 = carouselState;
                                    i16 &= -57345;
                                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2114, 2);
                                } else {
                                    carouselState2 = carouselState;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if (i10 != 0) {
                                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                                }
                                if (i12 != 0) {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                                } else {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                                }
                                if (i14 != 0) {
                                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                    f10 = fM10168constructorimpl;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                } else {
                                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    f10 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                }
                            } else {
                                if (i19 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i4 != 0) {
                                    fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                }
                                if ((i2 & 16) != 0) {
                                    int i2115 = (i16 & 14) | 384;
                                    carouselState2 = carouselState;
                                    i16 &= -57345;
                                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2115, 2);
                                } else {
                                    carouselState2 = carouselState;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if (i10 != 0) {
                                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                                }
                                if (i12 != 0) {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                                } else {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                                }
                                if (i14 != 0) {
                                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                    f10 = fM10168constructorimpl;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                } else {
                                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    f10 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                            }
                            ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume9 = composerStartRestartGroup.consume(localDensity9);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume9;
                            Orientation orientation9 = Orientation.Horizontal;
                            f11 = f9;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                            boolean zChanged9 = composerStartRestartGroup.changed(density);
                            if ((i17 & 896) == 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            boolean zChangedInstance9 = zChanged9 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                            if ((i17 & 3670016) == 1048576) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            z7 = zChangedInstance9 | z6 | ((29360128 & i17) == 8388608);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z7) {
                                final CarouselState carouselState18 = carouselState2;
                                final float f11114 = f8;
                                final float f11115 = fM10188getUnspecifiedD9Ej5fM;
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11115, carouselState18, f11, f11114, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                f12 = f11115;
                                f13 = f11114;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                final CarouselState carouselState19 = carouselState2;
                                final float f11116 = f8;
                                final float f11117 = fM10188getUnspecifiedD9Ej5fM;
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11117, carouselState19, f11, f11116, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                f12 = f11117;
                                f13 = f11116;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i2116 = i17 << 9;
                            PaddingValues paddingValues11 = paddingValuesM2343PaddingValues0680j_4;
                            boolean z16 = z2;
                            m5276CarouselcJHQLPU(carouselState, orientation9, (Function2) objRememberedValue, paddingValues11, 2, modifier5, f10, targetedFlingBehavior3, z16, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i2116 & 3670016) | (29360128 & i2116) | (i2116 & 234881024) | (1879048192 & i17), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues11;
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier5;
                            f5 = f10;
                            targetedFlingBehavior2 = targetedFlingBehavior3;
                            z4 = z16;
                            f6 = f12;
                            fM5270getMinSmallItemSizeD9Ej5fM = f11;
                            f7 = f13;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            paddingValues2 = paddingValues;
                            modifier3 = modifier2;
                            f5 = fM10168constructorimpl;
                            targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            composer2 = composerStartRestartGroup;
                            f6 = fM10188getUnspecifiedD9Ej5fM;
                            f7 = f4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i3 |= i18;
                    }
                    i16 = i3;
                    if ((i16 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i2117 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2117, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        } else {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i2118 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2118, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                        }
                        ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localDensity10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume10;
                        Orientation orientation10 = Orientation.Horizontal;
                        f11 = f9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged10 = composerStartRestartGroup.changed(density);
                        if ((i17 & 896) == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance10 = zChanged10 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i17 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance10 | z6 | ((29360128 & i17) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState110 = carouselState2;
                            final float f11118 = f8;
                            final float f11119 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11119, carouselState110, f11, f11118, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f11119;
                            f13 = f11118;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState111 = carouselState2;
                            final float f111110 = f8;
                            final float f111111 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111111, carouselState111, f11, f111110, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f111111;
                            f13 = f111110;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i2119 = i17 << 9;
                        PaddingValues paddingValues12 = paddingValuesM2343PaddingValues0680j_4;
                        boolean z17 = z2;
                        m5276CarouselcJHQLPU(carouselState, orientation10, (Function2) objRememberedValue, paddingValues12, 2, modifier5, f10, targetedFlingBehavior3, z17, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i2119 & 3670016) | (29360128 & i2119) | (i2119 & 234881024) | (1879048192 & i17), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues12;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier5;
                        f5 = f10;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z4 = z17;
                        f6 = f12;
                        fM5270getMinSmallItemSizeD9Ej5fM = f11;
                        f7 = f13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        f5 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        composer2 = composerStartRestartGroup;
                        f6 = fM10188getUnspecifiedD9Ej5fM;
                        f7 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                } else {
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 128;
                if (i12 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 256;
                if (i14 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i15 = 67108864;
                        } else {
                            i15 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i15;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i3 |= i18;
                    }
                    i16 = i3;
                    if ((i16 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i21110 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21110, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        } else {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i21111 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21111, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                        }
                        ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11 = composerStartRestartGroup.consume(localDensity11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume11;
                        Orientation orientation11 = Orientation.Horizontal;
                        f11 = f9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged11 = composerStartRestartGroup.changed(density);
                        if ((i17 & 896) == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance11 = zChanged11 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i17 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance11 | z6 | ((29360128 & i17) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState112 = carouselState2;
                            final float f111112 = f8;
                            final float f111113 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111113, carouselState112, f11, f111112, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f111113;
                            f13 = f111112;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState113 = carouselState2;
                            final float f111114 = f8;
                            final float f111115 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111115, carouselState113, f11, f111114, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f111115;
                            f13 = f111114;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i21112 = i17 << 9;
                        PaddingValues paddingValues13 = paddingValuesM2343PaddingValues0680j_4;
                        boolean z18 = z2;
                        m5276CarouselcJHQLPU(carouselState, orientation11, (Function2) objRememberedValue, paddingValues13, 2, modifier5, f10, targetedFlingBehavior3, z18, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i21112 & 3670016) | (29360128 & i21112) | (i21112 & 234881024) | (1879048192 & i17), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues13;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier5;
                        f5 = f10;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z4 = z18;
                        f6 = f12;
                        fM5270getMinSmallItemSizeD9Ej5fM = f11;
                        f7 = f13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        f5 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        composer2 = composerStartRestartGroup;
                        f6 = fM10188getUnspecifiedD9Ej5fM;
                        f7 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i3 |= i18;
                }
                i16 = i3;
                if ((i16 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i21113 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21113, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    } else {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i21114 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21114, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                    }
                    ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume12 = composerStartRestartGroup.consume(localDensity12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume12;
                    Orientation orientation12 = Orientation.Horizontal;
                    f11 = f9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged12 = composerStartRestartGroup.changed(density);
                    if ((i17 & 896) == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance12 = zChanged12 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i17 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance12 | z6 | ((29360128 & i17) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState114 = carouselState2;
                        final float f111116 = f8;
                        final float f111117 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111117, carouselState114, f11, f111116, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f111117;
                        f13 = f111116;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState115 = carouselState2;
                        final float f111118 = f8;
                        final float f111119 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111119, carouselState115, f11, f111118, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f111119;
                        f13 = f111118;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21115 = i17 << 9;
                    PaddingValues paddingValues14 = paddingValuesM2343PaddingValues0680j_4;
                    boolean z19 = z2;
                    m5276CarouselcJHQLPU(carouselState, orientation12, (Function2) objRememberedValue, paddingValues14, 2, modifier5, f10, targetedFlingBehavior3, z19, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i21115 & 3670016) | (29360128 & i21115) | (i21115 & 234881024) | (1879048192 & i17), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues14;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    f5 = f10;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z19;
                    f6 = f12;
                    fM5270getMinSmallItemSizeD9Ej5fM = f11;
                    f7 = f13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    f5 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    f6 = fM10188getUnspecifiedD9Ej5fM;
                    f7 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            fM10168constructorimpl = f2;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                    }
                    i3 |= i20;
                } else {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                }
                i3 |= i20;
            } else {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                } else {
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 128;
                if (i12 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 256;
                if (i14 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i15 = 67108864;
                        } else {
                            i15 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i15;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i3 |= i18;
                    }
                    i16 = i3;
                    if ((i16 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i21116 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21116, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        } else {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i21117 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21117, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                        }
                        ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume13 = composerStartRestartGroup.consume(localDensity13);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume13;
                        Orientation orientation13 = Orientation.Horizontal;
                        f11 = f9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged13 = composerStartRestartGroup.changed(density);
                        if ((i17 & 896) == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance13 = zChanged13 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i17 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance13 | z6 | ((29360128 & i17) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState116 = carouselState2;
                            final float f1111110 = f8;
                            final float f1111111 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111111, carouselState116, f11, f1111110, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f1111111;
                            f13 = f1111110;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState117 = carouselState2;
                            final float f1111112 = f8;
                            final float f1111113 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111113, carouselState117, f11, f1111112, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f1111113;
                            f13 = f1111112;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i21118 = i17 << 9;
                        PaddingValues paddingValues15 = paddingValuesM2343PaddingValues0680j_4;
                        boolean z110 = z2;
                        m5276CarouselcJHQLPU(carouselState, orientation13, (Function2) objRememberedValue, paddingValues15, 2, modifier5, f10, targetedFlingBehavior3, z110, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i21118 & 3670016) | (29360128 & i21118) | (i21118 & 234881024) | (1879048192 & i17), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues15;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier5;
                        f5 = f10;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z4 = z110;
                        f6 = f12;
                        fM5270getMinSmallItemSizeD9Ej5fM = f11;
                        f7 = f13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        f5 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        composer2 = composerStartRestartGroup;
                        f6 = fM10188getUnspecifiedD9Ej5fM;
                        f7 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i3 |= i18;
                }
                i16 = i3;
                if ((i16 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i21119 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21119, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    } else {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i211110 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211110, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                    }
                    ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localDensity14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume14;
                    Orientation orientation14 = Orientation.Horizontal;
                    f11 = f9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged14 = composerStartRestartGroup.changed(density);
                    if ((i17 & 896) == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance14 = zChanged14 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i17 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance14 | z6 | ((29360128 & i17) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState118 = carouselState2;
                        final float f1111114 = f8;
                        final float f1111115 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111115, carouselState118, f11, f1111114, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f1111115;
                        f13 = f1111114;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState119 = carouselState2;
                        final float f1111116 = f8;
                        final float f1111117 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111117, carouselState119, f11, f1111116, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f1111117;
                        f13 = f1111116;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211111 = i17 << 9;
                    PaddingValues paddingValues16 = paddingValuesM2343PaddingValues0680j_4;
                    boolean z111 = z2;
                    m5276CarouselcJHQLPU(carouselState, orientation14, (Function2) objRememberedValue, paddingValues16, 2, modifier5, f10, targetedFlingBehavior3, z111, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i211111 & 3670016) | (29360128 & i211111) | (i211111 & 234881024) | (1879048192 & i17), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues16;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    f5 = f10;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z111;
                    f6 = f12;
                    fM5270getMinSmallItemSizeD9Ej5fM = f11;
                    f7 = f13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    f5 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    f6 = fM10188getUnspecifiedD9Ej5fM;
                    f7 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
            } else {
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 128;
            if (i12 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            i14 = i2 & 256;
            if (i14 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i15 = 67108864;
                    } else {
                        i15 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i15;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i3 |= i18;
                }
                i16 = i3;
                if ((i16 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i211112 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211112, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    } else {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i211113 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211113, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                    }
                    ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume15 = composerStartRestartGroup.consume(localDensity15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume15;
                    Orientation orientation15 = Orientation.Horizontal;
                    f11 = f9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged15 = composerStartRestartGroup.changed(density);
                    if ((i17 & 896) == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance15 = zChanged15 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i17 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance15 | z6 | ((29360128 & i17) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState1110 = carouselState2;
                        final float f1111118 = f8;
                        final float f1111119 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111119, carouselState1110, f11, f1111118, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f1111119;
                        f13 = f1111118;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState1111 = carouselState2;
                        final float f11111110 = f8;
                        final float f11111111 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111111, carouselState1111, f11, f11111110, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f11111111;
                        f13 = f11111110;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211114 = i17 << 9;
                    PaddingValues paddingValues17 = paddingValuesM2343PaddingValues0680j_4;
                    boolean z112 = z2;
                    m5276CarouselcJHQLPU(carouselState, orientation15, (Function2) objRememberedValue, paddingValues17, 2, modifier5, f10, targetedFlingBehavior3, z112, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i211114 & 3670016) | (29360128 & i211114) | (i211114 & 234881024) | (1879048192 & i17), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues17;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    f5 = f10;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z112;
                    f6 = f12;
                    fM5270getMinSmallItemSizeD9Ej5fM = f11;
                    f7 = f13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    f5 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    f6 = fM10188getUnspecifiedD9Ej5fM;
                    f7 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 536870912;
                } else {
                    i18 = 268435456;
                }
                i3 |= i18;
            }
            i16 = i3;
            if ((i16 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i211115 = (i16 & 14) | 384;
                        carouselState2 = carouselState;
                        i16 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211115, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i12 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f10 = fM10168constructorimpl;
                        modifier5 = modifier4;
                        i17 = i16;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    } else {
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f10 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier5 = modifier4;
                        i17 = i16;
                    }
                } else {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i211116 = (i16 & 14) | 384;
                        carouselState2 = carouselState;
                        i16 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211116, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i12 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f10 = fM10168constructorimpl;
                        modifier5 = modifier4;
                        i17 = i16;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    } else {
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f10 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier5 = modifier4;
                        i17 = i16;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                }
                ProvidableCompositionLocal<Density> localDensity16 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume16 = composerStartRestartGroup.consume(localDensity16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume16;
                Orientation orientation16 = Orientation.Horizontal;
                f11 = f9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged16 = composerStartRestartGroup.changed(density);
                if ((i17 & 896) == 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChangedInstance16 = zChanged16 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                if ((i17 & 3670016) == 1048576) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance16 | z6 | ((29360128 & i17) == 8388608);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    final CarouselState carouselState1112 = carouselState2;
                    final float f11111112 = f8;
                    final float f11111113 = fM10188getUnspecifiedD9Ej5fM;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111113, carouselState1112, f11, f11111112, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f12 = f11111113;
                    f13 = f11111112;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final CarouselState carouselState1113 = carouselState2;
                    final float f11111114 = f8;
                    final float f11111115 = fM10188getUnspecifiedD9Ej5fM;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111115, carouselState1113, f11, f11111114, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f12 = f11111115;
                    f13 = f11111114;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i211117 = i17 << 9;
                PaddingValues paddingValues18 = paddingValuesM2343PaddingValues0680j_4;
                boolean z113 = z2;
                m5276CarouselcJHQLPU(carouselState, orientation16, (Function2) objRememberedValue, paddingValues18, 2, modifier5, f10, targetedFlingBehavior3, z113, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i211117 & 3670016) | (29360128 & i211117) | (i211117 & 234881024) | (1879048192 & i17), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues18;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier5;
                f5 = f10;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                z4 = z113;
                f6 = f12;
                fM5270getMinSmallItemSizeD9Ej5fM = f11;
                f7 = f13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
                f5 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                z4 = z2;
                composer2 = composerStartRestartGroup;
                f6 = fM10188getUnspecifiedD9Ej5fM;
                f7 = f4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                fM10188getUnspecifiedD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM10188getUnspecifiedD9Ej5fM)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    fM10168constructorimpl = f2;
                    if (composerStartRestartGroup.changed(fM10168constructorimpl)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                        if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                        }
                        i3 |= i20;
                    } else {
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    }
                    i3 |= i20;
                } else {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                        fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    } else {
                        fM5270getMinSmallItemSizeD9Ej5fM = f3;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                                i11 = 1048576;
                            } else {
                                i11 = 524288;
                            }
                            i3 |= i11;
                        }
                    }
                    i12 = i2 & 128;
                    if (i12 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f4)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 256;
                    if (i14 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i15 = 67108864;
                            } else {
                                i15 = GroupFlagsKt.HasAuxSlotFlag;
                            }
                            i3 |= i15;
                        }
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i18 = 536870912;
                            } else {
                                i18 = 268435456;
                            }
                            i3 |= i18;
                        }
                        i16 = i3;
                        if ((i16 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                            if ((i & 1) != 0) {
                                if (i19 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i4 != 0) {
                                    fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                }
                                if ((i2 & 16) != 0) {
                                    int i211118 = (i16 & 14) | 384;
                                    carouselState2 = carouselState;
                                    i16 &= -57345;
                                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211118, 2);
                                } else {
                                    carouselState2 = carouselState;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if (i10 != 0) {
                                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                                }
                                if (i12 != 0) {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                                } else {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                                }
                                if (i14 != 0) {
                                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                    f10 = fM10168constructorimpl;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                } else {
                                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    f10 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                }
                            } else {
                                if (i19 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                } else {
                                    modifier4 = modifier2;
                                }
                                if (i4 != 0) {
                                    fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                                }
                                if ((i2 & 16) != 0) {
                                    int i211119 = (i16 & 14) | 384;
                                    carouselState2 = carouselState;
                                    i16 &= -57345;
                                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211119, 2);
                                } else {
                                    carouselState2 = carouselState;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if (i10 != 0) {
                                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                                }
                                if (i12 != 0) {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                                } else {
                                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                                }
                                if (i14 != 0) {
                                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                    f10 = fM10168constructorimpl;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                } else {
                                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                    f10 = fM10168constructorimpl;
                                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                    modifier5 = modifier4;
                                    i17 = i16;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                            }
                            ProvidableCompositionLocal<Density> localDensity17 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume17 = composerStartRestartGroup.consume(localDensity17);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume17;
                            Orientation orientation17 = Orientation.Horizontal;
                            f11 = f9;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                            boolean zChanged17 = composerStartRestartGroup.changed(density);
                            if ((i17 & 896) == 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            boolean zChangedInstance17 = zChanged17 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                            if ((i17 & 3670016) == 1048576) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            z7 = zChangedInstance17 | z6 | ((29360128 & i17) == 8388608);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z7) {
                                final CarouselState carouselState1114 = carouselState2;
                                final float f11111116 = f8;
                                final float f11111117 = fM10188getUnspecifiedD9Ej5fM;
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111117, carouselState1114, f11, f11111116, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                f12 = f11111117;
                                f13 = f11111116;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                final CarouselState carouselState1115 = carouselState2;
                                final float f11111118 = f8;
                                final float f11111119 = fM10188getUnspecifiedD9Ej5fM;
                                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111119, carouselState1115, f11, f11111118, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                    }
                                };
                                f12 = f11111119;
                                f13 = f11111118;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i2111110 = i17 << 9;
                            PaddingValues paddingValues19 = paddingValuesM2343PaddingValues0680j_4;
                            boolean z114 = z2;
                            m5276CarouselcJHQLPU(carouselState, orientation17, (Function2) objRememberedValue, paddingValues19, 2, modifier5, f10, targetedFlingBehavior3, z114, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i2111110 & 3670016) | (29360128 & i2111110) | (i2111110 & 234881024) | (1879048192 & i17), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues19;
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier5;
                            f5 = f10;
                            targetedFlingBehavior2 = targetedFlingBehavior3;
                            z4 = z114;
                            f6 = f12;
                            fM5270getMinSmallItemSizeD9Ej5fM = f11;
                            f7 = f13;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            paddingValues2 = paddingValues;
                            modifier3 = modifier2;
                            f5 = fM10168constructorimpl;
                            targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            z4 = z2;
                            composer2 = composerStartRestartGroup;
                            f6 = fM10188getUnspecifiedD9Ej5fM;
                            f7 = f4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i3 |= i18;
                    }
                    i16 = i3;
                    if ((i16 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i2111111 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111111, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        } else {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i2111112 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111112, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                        }
                        ProvidableCompositionLocal<Density> localDensity18 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume18 = composerStartRestartGroup.consume(localDensity18);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume18;
                        Orientation orientation18 = Orientation.Horizontal;
                        f11 = f9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged18 = composerStartRestartGroup.changed(density);
                        if ((i17 & 896) == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance18 = zChanged18 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i17 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance18 | z6 | ((29360128 & i17) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState1116 = carouselState2;
                            final float f111111110 = f8;
                            final float f111111111 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111111111, carouselState1116, f11, f111111110, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f111111111;
                            f13 = f111111110;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState1117 = carouselState2;
                            final float f111111112 = f8;
                            final float f111111113 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111111113, carouselState1117, f11, f111111112, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f111111113;
                            f13 = f111111112;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i2111113 = i17 << 9;
                        PaddingValues paddingValues110 = paddingValuesM2343PaddingValues0680j_4;
                        boolean z115 = z2;
                        m5276CarouselcJHQLPU(carouselState, orientation18, (Function2) objRememberedValue, paddingValues110, 2, modifier5, f10, targetedFlingBehavior3, z115, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i2111113 & 3670016) | (29360128 & i2111113) | (i2111113 & 234881024) | (1879048192 & i17), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues110;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier5;
                        f5 = f10;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z4 = z115;
                        f6 = f12;
                        fM5270getMinSmallItemSizeD9Ej5fM = f11;
                        f7 = f13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        f5 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        composer2 = composerStartRestartGroup;
                        f6 = fM10188getUnspecifiedD9Ej5fM;
                        f7 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                } else {
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 128;
                if (i12 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 256;
                if (i14 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i15 = 67108864;
                        } else {
                            i15 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i15;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i3 |= i18;
                    }
                    i16 = i3;
                    if ((i16 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i2111114 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111114, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        } else {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i2111115 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111115, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                        }
                        ProvidableCompositionLocal<Density> localDensity19 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume19 = composerStartRestartGroup.consume(localDensity19);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume19;
                        Orientation orientation19 = Orientation.Horizontal;
                        f11 = f9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged19 = composerStartRestartGroup.changed(density);
                        if ((i17 & 896) == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance19 = zChanged19 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i17 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance19 | z6 | ((29360128 & i17) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState1118 = carouselState2;
                            final float f111111114 = f8;
                            final float f111111115 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111111115, carouselState1118, f11, f111111114, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f111111115;
                            f13 = f111111114;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState1119 = carouselState2;
                            final float f111111116 = f8;
                            final float f111111117 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111111117, carouselState1119, f11, f111111116, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f111111117;
                            f13 = f111111116;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i2111116 = i17 << 9;
                        PaddingValues paddingValues111 = paddingValuesM2343PaddingValues0680j_4;
                        boolean z116 = z2;
                        m5276CarouselcJHQLPU(carouselState, orientation19, (Function2) objRememberedValue, paddingValues111, 2, modifier5, f10, targetedFlingBehavior3, z116, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i2111116 & 3670016) | (29360128 & i2111116) | (i2111116 & 234881024) | (1879048192 & i17), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues111;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier5;
                        f5 = f10;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z4 = z116;
                        f6 = f12;
                        fM5270getMinSmallItemSizeD9Ej5fM = f11;
                        f7 = f13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        f5 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        composer2 = composerStartRestartGroup;
                        f6 = fM10188getUnspecifiedD9Ej5fM;
                        f7 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i3 |= i18;
                }
                i16 = i3;
                if ((i16 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i2111117 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111117, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    } else {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i2111118 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111118, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                    }
                    ProvidableCompositionLocal<Density> localDensity110 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume110 = composerStartRestartGroup.consume(localDensity110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume110;
                    Orientation orientation110 = Orientation.Horizontal;
                    f11 = f9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged110 = composerStartRestartGroup.changed(density);
                    if ((i17 & 896) == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance110 = zChanged110 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i17 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance110 | z6 | ((29360128 & i17) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState11110 = carouselState2;
                        final float f111111118 = f8;
                        final float f111111119 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111111119, carouselState11110, f11, f111111118, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f111111119;
                        f13 = f111111118;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState11111 = carouselState2;
                        final float f1111111110 = f8;
                        final float f1111111111 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111111111, carouselState11111, f11, f1111111110, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f1111111111;
                        f13 = f1111111110;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2111119 = i17 << 9;
                    PaddingValues paddingValues112 = paddingValuesM2343PaddingValues0680j_4;
                    boolean z117 = z2;
                    m5276CarouselcJHQLPU(carouselState, orientation110, (Function2) objRememberedValue, paddingValues112, 2, modifier5, f10, targetedFlingBehavior3, z117, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i2111119 & 3670016) | (29360128 & i2111119) | (i2111119 & 234881024) | (1879048192 & i17), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues112;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    f5 = f10;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z117;
                    f6 = f12;
                    fM5270getMinSmallItemSizeD9Ej5fM = f11;
                    f7 = f13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    f5 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    f6 = fM10188getUnspecifiedD9Ej5fM;
                    f7 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            fM10168constructorimpl = f2;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                    }
                    i3 |= i20;
                } else {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                }
                i3 |= i20;
            } else {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                } else {
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 128;
                if (i12 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 256;
                if (i14 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i15 = 67108864;
                        } else {
                            i15 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i15;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i3 |= i18;
                    }
                    i16 = i3;
                    if ((i16 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i21111110 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21111110, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        } else {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i21111111 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21111111, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                        }
                        ProvidableCompositionLocal<Density> localDensity111 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume111 = composerStartRestartGroup.consume(localDensity111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume111;
                        Orientation orientation111 = Orientation.Horizontal;
                        f11 = f9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged111 = composerStartRestartGroup.changed(density);
                        if ((i17 & 896) == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance111 = zChanged111 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i17 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance111 | z6 | ((29360128 & i17) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState11112 = carouselState2;
                            final float f1111111112 = f8;
                            final float f1111111113 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111111113, carouselState11112, f11, f1111111112, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f1111111113;
                            f13 = f1111111112;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState11113 = carouselState2;
                            final float f1111111114 = f8;
                            final float f1111111115 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111111115, carouselState11113, f11, f1111111114, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f1111111115;
                            f13 = f1111111114;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i21111112 = i17 << 9;
                        PaddingValues paddingValues113 = paddingValuesM2343PaddingValues0680j_4;
                        boolean z118 = z2;
                        m5276CarouselcJHQLPU(carouselState, orientation111, (Function2) objRememberedValue, paddingValues113, 2, modifier5, f10, targetedFlingBehavior3, z118, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i21111112 & 3670016) | (29360128 & i21111112) | (i21111112 & 234881024) | (1879048192 & i17), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues113;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier5;
                        f5 = f10;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z4 = z118;
                        f6 = f12;
                        fM5270getMinSmallItemSizeD9Ej5fM = f11;
                        f7 = f13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        f5 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        composer2 = composerStartRestartGroup;
                        f6 = fM10188getUnspecifiedD9Ej5fM;
                        f7 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i3 |= i18;
                }
                i16 = i3;
                if ((i16 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i21111113 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21111113, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    } else {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i21111114 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21111114, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                    }
                    ProvidableCompositionLocal<Density> localDensity112 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume112 = composerStartRestartGroup.consume(localDensity112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume112;
                    Orientation orientation112 = Orientation.Horizontal;
                    f11 = f9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged112 = composerStartRestartGroup.changed(density);
                    if ((i17 & 896) == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance112 = zChanged112 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i17 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance112 | z6 | ((29360128 & i17) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState11114 = carouselState2;
                        final float f1111111116 = f8;
                        final float f1111111117 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111111117, carouselState11114, f11, f1111111116, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f1111111117;
                        f13 = f1111111116;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState11115 = carouselState2;
                        final float f1111111118 = f8;
                        final float f1111111119 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111111119, carouselState11115, f11, f1111111118, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f1111111119;
                        f13 = f1111111118;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21111115 = i17 << 9;
                    PaddingValues paddingValues114 = paddingValuesM2343PaddingValues0680j_4;
                    boolean z119 = z2;
                    m5276CarouselcJHQLPU(carouselState, orientation112, (Function2) objRememberedValue, paddingValues114, 2, modifier5, f10, targetedFlingBehavior3, z119, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i21111115 & 3670016) | (29360128 & i21111115) | (i21111115 & 234881024) | (1879048192 & i17), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues114;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    f5 = f10;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z119;
                    f6 = f12;
                    fM5270getMinSmallItemSizeD9Ej5fM = f11;
                    f7 = f13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    f5 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    f6 = fM10188getUnspecifiedD9Ej5fM;
                    f7 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
            } else {
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 128;
            if (i12 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            i14 = i2 & 256;
            if (i14 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i15 = 67108864;
                    } else {
                        i15 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i15;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i3 |= i18;
                }
                i16 = i3;
                if ((i16 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i21111116 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21111116, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    } else {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i21111117 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21111117, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                    }
                    ProvidableCompositionLocal<Density> localDensity113 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume113 = composerStartRestartGroup.consume(localDensity113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume113;
                    Orientation orientation113 = Orientation.Horizontal;
                    f11 = f9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged113 = composerStartRestartGroup.changed(density);
                    if ((i17 & 896) == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance113 = zChanged113 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i17 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance113 | z6 | ((29360128 & i17) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState11116 = carouselState2;
                        final float f11111111110 = f8;
                        final float f11111111111 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111111111, carouselState11116, f11, f11111111110, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f11111111111;
                        f13 = f11111111110;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState11117 = carouselState2;
                        final float f11111111112 = f8;
                        final float f11111111113 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111111113, carouselState11117, f11, f11111111112, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f11111111113;
                        f13 = f11111111112;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21111118 = i17 << 9;
                    PaddingValues paddingValues115 = paddingValuesM2343PaddingValues0680j_4;
                    boolean z1110 = z2;
                    m5276CarouselcJHQLPU(carouselState, orientation113, (Function2) objRememberedValue, paddingValues115, 2, modifier5, f10, targetedFlingBehavior3, z1110, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i21111118 & 3670016) | (29360128 & i21111118) | (i21111118 & 234881024) | (1879048192 & i17), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues115;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    f5 = f10;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z1110;
                    f6 = f12;
                    fM5270getMinSmallItemSizeD9Ej5fM = f11;
                    f7 = f13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    f5 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    f6 = fM10188getUnspecifiedD9Ej5fM;
                    f7 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 536870912;
                } else {
                    i18 = 268435456;
                }
                i3 |= i18;
            }
            i16 = i3;
            if ((i16 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i21111119 = (i16 & 14) | 384;
                        carouselState2 = carouselState;
                        i16 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21111119, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i12 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f10 = fM10168constructorimpl;
                        modifier5 = modifier4;
                        i17 = i16;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    } else {
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f10 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier5 = modifier4;
                        i17 = i16;
                    }
                } else {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i211111110 = (i16 & 14) | 384;
                        carouselState2 = carouselState;
                        i16 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211111110, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i12 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f10 = fM10168constructorimpl;
                        modifier5 = modifier4;
                        i17 = i16;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    } else {
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f10 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier5 = modifier4;
                        i17 = i16;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                }
                ProvidableCompositionLocal<Density> localDensity114 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume114 = composerStartRestartGroup.consume(localDensity114);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume114;
                Orientation orientation114 = Orientation.Horizontal;
                f11 = f9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged114 = composerStartRestartGroup.changed(density);
                if ((i17 & 896) == 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChangedInstance114 = zChanged114 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                if ((i17 & 3670016) == 1048576) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance114 | z6 | ((29360128 & i17) == 8388608);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    final CarouselState carouselState11118 = carouselState2;
                    final float f11111111114 = f8;
                    final float f11111111115 = fM10188getUnspecifiedD9Ej5fM;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111111115, carouselState11118, f11, f11111111114, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f12 = f11111111115;
                    f13 = f11111111114;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final CarouselState carouselState11119 = carouselState2;
                    final float f11111111116 = f8;
                    final float f11111111117 = fM10188getUnspecifiedD9Ej5fM;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111111117, carouselState11119, f11, f11111111116, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f12 = f11111111117;
                    f13 = f11111111116;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i211111111 = i17 << 9;
                PaddingValues paddingValues116 = paddingValuesM2343PaddingValues0680j_4;
                boolean z1111 = z2;
                m5276CarouselcJHQLPU(carouselState, orientation114, (Function2) objRememberedValue, paddingValues116, 2, modifier5, f10, targetedFlingBehavior3, z1111, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i211111111 & 3670016) | (29360128 & i211111111) | (i211111111 & 234881024) | (1879048192 & i17), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues116;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier5;
                f5 = f10;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                z4 = z1111;
                f6 = f12;
                fM5270getMinSmallItemSizeD9Ej5fM = f11;
                f7 = f13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
                f5 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                z4 = z2;
                composer2 = composerStartRestartGroup;
                f6 = fM10188getUnspecifiedD9Ej5fM;
                f7 = f4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        fM10188getUnspecifiedD9Ej5fM = f;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                fM10168constructorimpl = f2;
                if (composerStartRestartGroup.changed(fM10168constructorimpl)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                    }
                    i3 |= i20;
                } else {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                }
                i3 |= i20;
            } else {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                } else {
                    fM5270getMinSmallItemSizeD9Ej5fM = f3;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 128;
                if (i12 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 256;
                if (i14 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i15 = 67108864;
                        } else {
                            i15 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i3 |= i15;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i3 |= i18;
                    }
                    i16 = i3;
                    if ((i16 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i211111112 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211111112, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        } else {
                            if (i19 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i2 & 16) != 0) {
                                int i211111113 = (i16 & 14) | 384;
                                carouselState2 = carouselState;
                                i16 &= -57345;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211111113, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                            }
                            if (i12 != 0) {
                                fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                            } else {
                                fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                            }
                            if (i14 != 0) {
                                paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                                f10 = fM10168constructorimpl;
                                modifier5 = modifier4;
                                i17 = i16;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            } else {
                                paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                                f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                                f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                                f10 = fM10168constructorimpl;
                                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                                modifier5 = modifier4;
                                i17 = i16;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                        }
                        ProvidableCompositionLocal<Density> localDensity115 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume115 = composerStartRestartGroup.consume(localDensity115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume115;
                        Orientation orientation115 = Orientation.Horizontal;
                        f11 = f9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                        boolean zChanged115 = composerStartRestartGroup.changed(density);
                        if ((i17 & 896) == 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean zChangedInstance115 = zChanged115 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                        if ((i17 & 3670016) == 1048576) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance115 | z6 | ((29360128 & i17) == 8388608);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            final CarouselState carouselState111110 = carouselState2;
                            final float f11111111118 = f8;
                            final float f11111111119 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111111119, carouselState111110, f11, f11111111118, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f11111111119;
                            f13 = f11111111118;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            final CarouselState carouselState111111 = carouselState2;
                            final float f111111111110 = f8;
                            final float f111111111111 = fM10188getUnspecifiedD9Ej5fM;
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111111111111, carouselState111111, f11, f111111111110, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                                }
                            };
                            f12 = f111111111111;
                            f13 = f111111111110;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i211111114 = i17 << 9;
                        PaddingValues paddingValues117 = paddingValuesM2343PaddingValues0680j_4;
                        boolean z1112 = z2;
                        m5276CarouselcJHQLPU(carouselState, orientation115, (Function2) objRememberedValue, paddingValues117, 2, modifier5, f10, targetedFlingBehavior3, z1112, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i211111114 & 3670016) | (29360128 & i211111114) | (i211111114 & 234881024) | (1879048192 & i17), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues117;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier5;
                        f5 = f10;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z4 = z1112;
                        f6 = f12;
                        fM5270getMinSmallItemSizeD9Ej5fM = f11;
                        f7 = f13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        modifier3 = modifier2;
                        f5 = fM10168constructorimpl;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        z4 = z2;
                        composer2 = composerStartRestartGroup;
                        f6 = fM10188getUnspecifiedD9Ej5fM;
                        f7 = f4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i3 |= i18;
                }
                i16 = i3;
                if ((i16 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i211111115 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211111115, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    } else {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i211111116 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211111116, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                    }
                    ProvidableCompositionLocal<Density> localDensity116 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume116 = composerStartRestartGroup.consume(localDensity116);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume116;
                    Orientation orientation116 = Orientation.Horizontal;
                    f11 = f9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged116 = composerStartRestartGroup.changed(density);
                    if ((i17 & 896) == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance116 = zChanged116 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i17 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance116 | z6 | ((29360128 & i17) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState111112 = carouselState2;
                        final float f111111111112 = f8;
                        final float f111111111113 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111111111113, carouselState111112, f11, f111111111112, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f111111111113;
                        f13 = f111111111112;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState111113 = carouselState2;
                        final float f111111111114 = f8;
                        final float f111111111115 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111111111115, carouselState111113, f11, f111111111114, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f111111111115;
                        f13 = f111111111114;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211111117 = i17 << 9;
                    PaddingValues paddingValues118 = paddingValuesM2343PaddingValues0680j_4;
                    boolean z1113 = z2;
                    m5276CarouselcJHQLPU(carouselState, orientation116, (Function2) objRememberedValue, paddingValues118, 2, modifier5, f10, targetedFlingBehavior3, z1113, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i211111117 & 3670016) | (29360128 & i211111117) | (i211111117 & 234881024) | (1879048192 & i17), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues118;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    f5 = f10;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z1113;
                    f6 = f12;
                    fM5270getMinSmallItemSizeD9Ej5fM = f11;
                    f7 = f13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    f5 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    f6 = fM10188getUnspecifiedD9Ej5fM;
                    f7 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
            } else {
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 128;
            if (i12 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            i14 = i2 & 256;
            if (i14 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i15 = 67108864;
                    } else {
                        i15 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i15;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i3 |= i18;
                }
                i16 = i3;
                if ((i16 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i211111118 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211111118, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    } else {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i211111119 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i211111119, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                    }
                    ProvidableCompositionLocal<Density> localDensity117 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume117 = composerStartRestartGroup.consume(localDensity117);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume117;
                    Orientation orientation117 = Orientation.Horizontal;
                    f11 = f9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged117 = composerStartRestartGroup.changed(density);
                    if ((i17 & 896) == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance117 = zChanged117 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i17 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance117 | z6 | ((29360128 & i17) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState111114 = carouselState2;
                        final float f111111111116 = f8;
                        final float f111111111117 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111111111117, carouselState111114, f11, f111111111116, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f111111111117;
                        f13 = f111111111116;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState111115 = carouselState2;
                        final float f111111111118 = f8;
                        final float f111111111119 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f111111111119, carouselState111115, f11, f111111111118, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f111111111119;
                        f13 = f111111111118;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2111111110 = i17 << 9;
                    PaddingValues paddingValues119 = paddingValuesM2343PaddingValues0680j_4;
                    boolean z1114 = z2;
                    m5276CarouselcJHQLPU(carouselState, orientation117, (Function2) objRememberedValue, paddingValues119, 2, modifier5, f10, targetedFlingBehavior3, z1114, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i2111111110 & 3670016) | (29360128 & i2111111110) | (i2111111110 & 234881024) | (1879048192 & i17), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues119;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    f5 = f10;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z1114;
                    f6 = f12;
                    fM5270getMinSmallItemSizeD9Ej5fM = f11;
                    f7 = f13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    f5 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    f6 = fM10188getUnspecifiedD9Ej5fM;
                    f7 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 536870912;
                } else {
                    i18 = 268435456;
                }
                i3 |= i18;
            }
            i16 = i3;
            if ((i16 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i2111111111 = (i16 & 14) | 384;
                        carouselState2 = carouselState;
                        i16 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111111111, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i12 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f10 = fM10168constructorimpl;
                        modifier5 = modifier4;
                        i17 = i16;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    } else {
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f10 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier5 = modifier4;
                        i17 = i16;
                    }
                } else {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i2111111112 = (i16 & 14) | 384;
                        carouselState2 = carouselState;
                        i16 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111111112, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i12 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f10 = fM10168constructorimpl;
                        modifier5 = modifier4;
                        i17 = i16;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    } else {
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f10 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier5 = modifier4;
                        i17 = i16;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                }
                ProvidableCompositionLocal<Density> localDensity118 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume118 = composerStartRestartGroup.consume(localDensity118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume118;
                Orientation orientation118 = Orientation.Horizontal;
                f11 = f9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged118 = composerStartRestartGroup.changed(density);
                if ((i17 & 896) == 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChangedInstance118 = zChanged118 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                if ((i17 & 3670016) == 1048576) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance118 | z6 | ((29360128 & i17) == 8388608);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    final CarouselState carouselState111116 = carouselState2;
                    final float f1111111111110 = f8;
                    final float f1111111111111 = fM10188getUnspecifiedD9Ej5fM;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111111111111, carouselState111116, f11, f1111111111110, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f12 = f1111111111111;
                    f13 = f1111111111110;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final CarouselState carouselState111117 = carouselState2;
                    final float f1111111111112 = f8;
                    final float f1111111111113 = fM10188getUnspecifiedD9Ej5fM;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111111111113, carouselState111117, f11, f1111111111112, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f12 = f1111111111113;
                    f13 = f1111111111112;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2111111113 = i17 << 9;
                PaddingValues paddingValues1110 = paddingValuesM2343PaddingValues0680j_4;
                boolean z1115 = z2;
                m5276CarouselcJHQLPU(carouselState, orientation118, (Function2) objRememberedValue, paddingValues1110, 2, modifier5, f10, targetedFlingBehavior3, z1115, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i2111111113 & 3670016) | (29360128 & i2111111113) | (i2111111113 & 234881024) | (1879048192 & i17), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues1110;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier5;
                f5 = f10;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                z4 = z1115;
                f6 = f12;
                fM5270getMinSmallItemSizeD9Ej5fM = f11;
                f7 = f13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
                f5 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                z4 = z2;
                composer2 = composerStartRestartGroup;
                f6 = fM10188getUnspecifiedD9Ej5fM;
                f7 = f4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        fM10168constructorimpl = f2;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                }
                i3 |= i20;
            } else {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
            }
            i3 |= i20;
        } else {
            targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
        }
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
            } else {
                fM5270getMinSmallItemSizeD9Ej5fM = f3;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 128;
            if (i12 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            i14 = i2 & 256;
            if (i14 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i15 = 67108864;
                    } else {
                        i15 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i15;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i3 |= i18;
                }
                i16 = i3;
                if ((i16 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i2111111114 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111111114, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    } else {
                        if (i19 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i2 & 16) != 0) {
                            int i2111111115 = (i16 & 14) | 384;
                            carouselState2 = carouselState;
                            i16 &= -57345;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111111115, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                        }
                        if (i12 != 0) {
                            fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                        } else {
                            fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                        }
                        if (i14 != 0) {
                            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                            f10 = fM10168constructorimpl;
                            modifier5 = modifier4;
                            i17 = i16;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        } else {
                            paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                            f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                            f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                            f10 = fM10168constructorimpl;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier5 = modifier4;
                            i17 = i16;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                    }
                    ProvidableCompositionLocal<Density> localDensity119 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume119 = composerStartRestartGroup.consume(localDensity119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume119;
                    Orientation orientation119 = Orientation.Horizontal;
                    f11 = f9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                    boolean zChanged119 = composerStartRestartGroup.changed(density);
                    if ((i17 & 896) == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance119 = zChanged119 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                    if ((i17 & 3670016) == 1048576) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance119 | z6 | ((29360128 & i17) == 8388608);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        final CarouselState carouselState111118 = carouselState2;
                        final float f1111111111114 = f8;
                        final float f1111111111115 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111111111115, carouselState111118, f11, f1111111111114, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f1111111111115;
                        f13 = f1111111111114;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        final CarouselState carouselState111119 = carouselState2;
                        final float f1111111111116 = f8;
                        final float f1111111111117 = fM10188getUnspecifiedD9Ej5fM;
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111111111117, carouselState111119, f11, f1111111111116, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                            }
                        };
                        f12 = f1111111111117;
                        f13 = f1111111111116;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2111111116 = i17 << 9;
                    PaddingValues paddingValues1111 = paddingValuesM2343PaddingValues0680j_4;
                    boolean z1116 = z2;
                    m5276CarouselcJHQLPU(carouselState, orientation119, (Function2) objRememberedValue, paddingValues1111, 2, modifier5, f10, targetedFlingBehavior3, z1116, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i2111111116 & 3670016) | (29360128 & i2111111116) | (i2111111116 & 234881024) | (1879048192 & i17), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues1111;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier5;
                    f5 = f10;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z1116;
                    f6 = f12;
                    fM5270getMinSmallItemSizeD9Ej5fM = f11;
                    f7 = f13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    modifier3 = modifier2;
                    f5 = fM10168constructorimpl;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    f6 = fM10188getUnspecifiedD9Ej5fM;
                    f7 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 536870912;
                } else {
                    i18 = 268435456;
                }
                i3 |= i18;
            }
            i16 = i3;
            if ((i16 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i2111111117 = (i16 & 14) | 384;
                        carouselState2 = carouselState;
                        i16 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111111117, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i12 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f10 = fM10168constructorimpl;
                        modifier5 = modifier4;
                        i17 = i16;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    } else {
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f10 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier5 = modifier4;
                        i17 = i16;
                    }
                } else {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i2111111118 = (i16 & 14) | 384;
                        carouselState2 = carouselState;
                        i16 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i2111111118, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i12 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f10 = fM10168constructorimpl;
                        modifier5 = modifier4;
                        i17 = i16;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    } else {
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f10 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier5 = modifier4;
                        i17 = i16;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                }
                ProvidableCompositionLocal<Density> localDensity1110 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume1110 = composerStartRestartGroup.consume(localDensity1110);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume1110;
                Orientation orientation1110 = Orientation.Horizontal;
                f11 = f9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged1110 = composerStartRestartGroup.changed(density);
                if ((i17 & 896) == 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChangedInstance1110 = zChanged1110 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                if ((i17 & 3670016) == 1048576) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance1110 | z6 | ((29360128 & i17) == 8388608);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    final CarouselState carouselState1111110 = carouselState2;
                    final float f1111111111118 = f8;
                    final float f1111111111119 = fM10188getUnspecifiedD9Ej5fM;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f1111111111119, carouselState1111110, f11, f1111111111118, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f12 = f1111111111119;
                    f13 = f1111111111118;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final CarouselState carouselState1111111 = carouselState2;
                    final float f11111111111110 = f8;
                    final float f11111111111111 = fM10188getUnspecifiedD9Ej5fM;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111111111111, carouselState1111111, f11, f11111111111110, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f12 = f11111111111111;
                    f13 = f11111111111110;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2111111119 = i17 << 9;
                PaddingValues paddingValues1112 = paddingValuesM2343PaddingValues0680j_4;
                boolean z1117 = z2;
                m5276CarouselcJHQLPU(carouselState, orientation1110, (Function2) objRememberedValue, paddingValues1112, 2, modifier5, f10, targetedFlingBehavior3, z1117, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i2111111119 & 3670016) | (29360128 & i2111111119) | (i2111111119 & 234881024) | (1879048192 & i17), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues1112;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier5;
                f5 = f10;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                z4 = z1117;
                f6 = f12;
                fM5270getMinSmallItemSizeD9Ej5fM = f11;
                f7 = f13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
                f5 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                z4 = z2;
                composer2 = composerStartRestartGroup;
                f6 = fM10188getUnspecifiedD9Ej5fM;
                f7 = f4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        i10 = i2 & 64;
        if (i10 != 0) {
            i3 |= 1572864;
            fM5270getMinSmallItemSizeD9Ej5fM = f3;
        } else {
            fM5270getMinSmallItemSizeD9Ej5fM = f3;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(fM5270getMinSmallItemSizeD9Ej5fM)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
        }
        i12 = i2 & 128;
        if (i12 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(f4)) {
                i13 = 8388608;
            } else {
                i13 = 4194304;
            }
            i3 |= i13;
        }
        i14 = i2 & 256;
        if (i14 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i15 = 67108864;
                } else {
                    i15 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i3 |= i15;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i18 = 536870912;
                } else {
                    i18 = 268435456;
                }
                i3 |= i18;
            }
            i16 = i3;
            if ((i16 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i21111111110 = (i16 & 14) | 384;
                        carouselState2 = carouselState;
                        i16 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21111111110, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i12 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f10 = fM10168constructorimpl;
                        modifier5 = modifier4;
                        i17 = i16;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    } else {
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f10 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier5 = modifier4;
                        i17 = i16;
                    }
                } else {
                    if (i19 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i2 & 16) != 0) {
                        int i21111111111 = (i16 & 14) | 384;
                        carouselState2 = carouselState;
                        i16 &= -57345;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21111111111, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                    }
                    if (i12 != 0) {
                        fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                    } else {
                        fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                    }
                    if (i14 != 0) {
                        paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                        f10 = fM10168constructorimpl;
                        modifier5 = modifier4;
                        i17 = i16;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    } else {
                        paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                        f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                        f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                        f10 = fM10168constructorimpl;
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier5 = modifier4;
                        i17 = i16;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
                }
                ProvidableCompositionLocal<Density> localDensity1111 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume1111 = composerStartRestartGroup.consume(localDensity1111);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume1111;
                Orientation orientation1111 = Orientation.Horizontal;
                f11 = f9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
                boolean zChanged1111 = composerStartRestartGroup.changed(density);
                if ((i17 & 896) == 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChangedInstance1111 = zChanged1111 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
                if ((i17 & 3670016) == 1048576) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance1111 | z6 | ((29360128 & i17) == 8388608);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    final CarouselState carouselState1111112 = carouselState2;
                    final float f11111111111112 = f8;
                    final float f11111111111113 = fM10188getUnspecifiedD9Ej5fM;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111111111113, carouselState1111112, f11, f11111111111112, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f12 = f11111111111113;
                    f13 = f11111111111112;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final CarouselState carouselState1111113 = carouselState2;
                    final float f11111111111114 = f8;
                    final float f11111111111115 = fM10188getUnspecifiedD9Ej5fM;
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111111111115, carouselState1111113, f11, f11111111111114, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                        }
                    };
                    f12 = f11111111111115;
                    f13 = f11111111111114;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21111111112 = i17 << 9;
                PaddingValues paddingValues1113 = paddingValuesM2343PaddingValues0680j_4;
                boolean z1118 = z2;
                m5276CarouselcJHQLPU(carouselState, orientation1111, (Function2) objRememberedValue, paddingValues1113, 2, modifier5, f10, targetedFlingBehavior3, z1118, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i21111111112 & 3670016) | (29360128 & i21111111112) | (i21111111112 & 234881024) | (1879048192 & i17), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues1113;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier5;
                f5 = f10;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                z4 = z1118;
                f6 = f12;
                fM5270getMinSmallItemSizeD9Ej5fM = f11;
                f7 = f13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paddingValues2 = paddingValues;
                modifier3 = modifier2;
                f5 = fM10168constructorimpl;
                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                z4 = z2;
                composer2 = composerStartRestartGroup;
                f6 = fM10188getUnspecifiedD9Ej5fM;
                f7 = f4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 100663296;
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i18 = 536870912;
            } else {
                i18 = 268435456;
            }
            i3 |= i18;
        }
        i16 = i3;
        if ((i16 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i16 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "247@12137L41");
            if ((i & 1) != 0) {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                }
                if (i6 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
                if ((i2 & 16) != 0) {
                    int i21111111113 = (i16 & 14) | 384;
                    carouselState2 = carouselState;
                    i16 &= -57345;
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21111111113, 2);
                } else {
                    carouselState2 = carouselState;
                }
                if (i8 != 0) {
                    z2 = true;
                }
                if (i10 != 0) {
                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                }
                if (i12 != 0) {
                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                } else {
                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                }
                if (i14 != 0) {
                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                    f10 = fM10168constructorimpl;
                    modifier5 = modifier4;
                    i17 = i16;
                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                } else {
                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                    f10 = fM10168constructorimpl;
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    modifier5 = modifier4;
                    i17 = i16;
                }
            } else {
                if (i19 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    fM10188getUnspecifiedD9Ej5fM = Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM();
                }
                if (i6 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
                if ((i2 & 16) != 0) {
                    int i21111111114 = (i16 & 14) | 384;
                    carouselState2 = carouselState;
                    i16 &= -57345;
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i21111111114, 2);
                } else {
                    carouselState2 = carouselState;
                }
                if (i8 != 0) {
                    z2 = true;
                }
                if (i10 != 0) {
                    fM5270getMinSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5270getMinSmallItemSizeD9Ej5fM();
                }
                if (i12 != 0) {
                    fM5269getMaxSmallItemSizeD9Ej5fM = CarouselDefaults.INSTANCE.m5269getMaxSmallItemSizeD9Ej5fM();
                } else {
                    fM5269getMaxSmallItemSizeD9Ej5fM = f4;
                }
                if (i14 != 0) {
                    paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
                    f10 = fM10168constructorimpl;
                    modifier5 = modifier4;
                    i17 = i16;
                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                } else {
                    paddingValuesM2343PaddingValues0680j_4 = paddingValues;
                    f8 = fM5269getMaxSmallItemSizeD9Ej5fM;
                    f9 = fM5270getMinSmallItemSizeD9Ej5fM;
                    f10 = fM10168constructorimpl;
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    modifier5 = modifier4;
                    i17 = i16;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1493031269, i17, -1, "androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel (Carousel.kt:253)");
            }
            ProvidableCompositionLocal<Density> localDensity1112 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume1112 = composerStartRestartGroup.consume(localDensity1112);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume1112;
            Orientation orientation1112 = Orientation.Horizontal;
            f11 = f9;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 283996118, "CC(remember):Carousel.kt#9igjgp");
            boolean zChanged1112 = composerStartRestartGroup.changed(density);
            if ((i17 & 896) == 256) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean zChangedInstance1112 = zChanged1112 | z5 | composerStartRestartGroup.changedInstance(carouselState2);
            if ((i17 & 3670016) == 1048576) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 = zChangedInstance1112 | z6 | ((29360128 & i17) == 8388608);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z7) {
                final CarouselState carouselState1111114 = carouselState2;
                final float f11111111111116 = f8;
                final float f11111111111117 = fM10188getUnspecifiedD9Ej5fM;
                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111111111117, carouselState1111114, f11, f11111111111116, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                    }
                };
                f12 = f11111111111117;
                f13 = f11111111111116;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                final CarouselState carouselState1111115 = carouselState2;
                final float f11111111111118 = f8;
                final float f11111111111119 = fM10188getUnspecifiedD9Ej5fM;
                objRememberedValue = new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(density, f11111111111119, carouselState1111115, f11, f11111111111118, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
                    }
                };
                f12 = f11111111111119;
                f13 = f11111111111118;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i21111111115 = i17 << 9;
            PaddingValues paddingValues1114 = paddingValuesM2343PaddingValues0680j_4;
            boolean z1119 = z2;
            m5276CarouselcJHQLPU(carouselState, orientation1112, (Function2) objRememberedValue, paddingValues1114, 2, modifier5, f10, targetedFlingBehavior3, z1119, function4, composerStartRestartGroup, (i17 & 14) | 24624 | ((i17 >> 15) & 7168) | ((i17 << 12) & 458752) | (i21111111115 & 3670016) | (29360128 & i21111111115) | (i21111111115 & 234881024) | (1879048192 & i17), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            paddingValues2 = paddingValues1114;
            composer2 = composerStartRestartGroup;
            modifier3 = modifier5;
            f5 = f10;
            targetedFlingBehavior2 = targetedFlingBehavior3;
            z4 = z1119;
            f6 = f12;
            fM5270getMinSmallItemSizeD9Ej5fM = f11;
            f7 = f13;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            paddingValues2 = paddingValues;
            modifier3 = modifier2;
            f5 = fM10168constructorimpl;
            targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
            z4 = z2;
            composer2 = composerStartRestartGroup;
            f6 = fM10188getUnspecifiedD9Ej5fM;
            f7 = f4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CarouselKt.HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$1(carouselState, modifier3, f6, f5, targetedFlingBehavior2, z4, fM5270getMinSmallItemSizeD9Ej5fM, f7, paddingValues2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0145 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x0147  */
    /* JADX WARN: Code duplicated, block: B:107:0x014e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0152  */
    /* JADX WARN: Code duplicated, block: B:112:0x015c  */
    /* JADX WARN: Code duplicated, block: B:113:0x0175  */
    /* JADX WARN: Code duplicated, block: B:115:0x017a  */
    /* JADX WARN: Code duplicated, block: B:116:0x017d  */
    /* JADX WARN: Code duplicated, block: B:120:0x018d  */
    /* JADX WARN: Code duplicated, block: B:123:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:124:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:127:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:129:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:132:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:134:0x0218  */
    /* JADX WARN: Code duplicated, block: B:136:0x0275  */
    /* JADX WARN: Code duplicated, block: B:138:0x0279  */
    /* JADX WARN: Code duplicated, block: B:140:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:142:0x032f  */
    /* JADX WARN: Code duplicated, block: B:145:0x033e  */
    /* JADX WARN: Code duplicated, block: B:147:0x0348  */
    /* JADX WARN: Code duplicated, block: B:150:0x0355  */
    /* JADX WARN: Code duplicated, block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0097  */
    /* JADX WARN: Code duplicated, block: B:52:0x0099  */
    /* JADX WARN: Code duplicated, block: B:54:0x009c  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:91:0x010f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0111  */
    /* JADX WARN: Code duplicated, block: B:95:0x011a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0129  */
    /* JADX INFO: renamed from: Carousel-cJHQLPU, reason: not valid java name */
    public static final void m5276CarouselcJHQLPU(final CarouselState carouselState, final Orientation orientation, final Function2<? super Float, ? super Float, KeylineList> function2, final PaddingValues paddingValues, final int i, Modifier modifier, float f, TargetedFlingBehavior targetedFlingBehavior, boolean z, final Function4<? super CarouselItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        float fM10168constructorimpl;
        int i6;
        TargetedFlingBehavior targetedFlingBehaviorSingleAdvanceFlingBehavior;
        int i7;
        int i8;
        int i9;
        boolean z2;
        boolean z3;
        final boolean z4;
        final TargetedFlingBehavior targetedFlingBehavior2;
        final float f2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        final CarouselState carouselState2;
        boolean z5;
        TargetedFlingBehavior targetedFlingBehavior3;
        int i10;
        float f3;
        float fCalculateBeforeContentPadding;
        float fCalculateAfterContentPadding;
        boolean z6;
        Object objRememberedValue;
        final CarouselPageSize carouselPageSize;
        SnapPosition snapPositionKeylineSnapPosition;
        Object objRememberedValue2;
        Object objRememberedValue3;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2077912500);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Carousel)N(state,orientation,keylineList,contentPadding,maxNonFocalVisibleItemCount,modifier,itemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,content)323@15830L42,324@15918L41,326@15987L118:Carousel.kt#dcf9yb");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(carouselState) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(orientation.ordinal()) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(paddingValues) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 16384 : 8192;
        }
        int i12 = i3 & 32;
        if (i12 == 0) {
            if ((196608 & i2) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            i5 = i3 & 64;
            if (i5 != 0) {
                if ((1572864 & i2) == 0) {
                    fM10168constructorimpl = f;
                    if (composerStartRestartGroup.changed(fM10168constructorimpl)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                    i4 |= i6;
                }
                if ((i2 & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                        int i13 = composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior) ? 8388608 : 4194304;
                        i4 |= i13;
                    } else {
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    }
                    i4 |= i13;
                } else {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                }
                i7 = i3 & 256;
                if (i7 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i8 = 67108864;
                        } else {
                            i8 = GroupFlagsKt.HasAuxSlotFlag;
                        }
                        i4 |= i8;
                    }
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i11 = 536870912;
                        } else {
                            i11 = 268435456;
                        }
                        i4 |= i11;
                    }
                    i9 = i4;
                    z2 = true;
                    if ((i9 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "319@15629L41");
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i5 != 0) {
                                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                            }
                            if ((i3 & 128) != 0) {
                                int i14 = (i9 & 14) | 384;
                                carouselState2 = carouselState;
                                i9 &= -29360129;
                                z2 = true;
                                targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i14, 2);
                            } else {
                                carouselState2 = carouselState;
                            }
                            if (i7 != 0) {
                                z5 = z2;
                            } else {
                                z5 = z;
                            }
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                            modifier2 = modifier3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 128) != 0) {
                                i9 &= -29360129;
                            }
                            carouselState2 = carouselState;
                            z5 = z;
                            targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        }
                        i10 = i9;
                        f3 = fM10168constructorimpl;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2077912500, i10, -1, "androidx.compose.material3.carousel.Carousel (Carousel.kt:322)");
                        }
                        int i15 = ((i10 >> 9) & 14) | (i10 & 112);
                        fCalculateBeforeContentPadding = calculateBeforeContentPadding(paddingValues, orientation, composerStartRestartGroup, i15);
                        fCalculateAfterContentPadding = calculateAfterContentPadding(paddingValues, orientation, composerStartRestartGroup, i15);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285902946, "CC(remember):Carousel.kt#9igjgp");
                        if ((i10 & 896) == 256) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        carouselPageSize = (CarouselPageSize) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        snapPositionKeylineSnapPosition = KeylineSnapPositionKt.KeylineSnapPosition(carouselPageSize);
                        if (orientation == Orientation.Horizontal) {
                            composerStartRestartGroup.startReplaceGroup(273336201);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "347@16899L24,348@16935L1024,333@16218L1741");
                            CarouselPagerState pagerState = carouselState2.getPagerState();
                            PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default = PaddingKt.m2347PaddingValuesa9UjIt4$default(0.0f, paddingValues.getTop(), 0.0f, paddingValues.getBottom(), 5, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285932036, "CC(remember):Carousel.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CarouselKt.Carousel_cJHQLPU$lambda$1$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            PagerKt.m2626HorizontalPager8jOkeI(pagerState, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue3, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1817116752, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function4
                                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return CarouselKt.Carousel_cJHQLPU$lambda$2(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (orientation == Orientation.Vertical) {
                            composerStartRestartGroup.startReplaceGroup(275127381);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "382@18318L7,383@18410L7,391@18755L24,392@18791L1024,377@18022L1793");
                            CarouselPagerState pagerState2 = carouselState2.getPagerState();
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            float fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) objConsume);
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default2 = PaddingKt.m2347PaddingValuesa9UjIt4$default(fCalculateStartPadding, 0.0f, PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) objConsume2), 0.0f, 10, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285991428, "CC(remember):Carousel.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CarouselKt.Carousel_cJHQLPU$lambda$3$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            PagerKt.m2628VerticalPager8jOkeI(pagerState2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue2, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default2, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1042567175, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function4
                                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return CarouselKt.Carousel_cJHQLPU$lambda$4(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(276856406);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f2 = f3;
                        targetedFlingBehavior2 = targetedFlingBehavior3;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z4 = z;
                        targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        f2 = fM10168constructorimpl;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier4 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$5(carouselState, orientation, function2, paddingValues, i, modifier4, f2, targetedFlingBehavior2, z4, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i11 = 536870912;
                    } else {
                        i11 = 268435456;
                    }
                    i4 |= i11;
                }
                i9 = i4;
                z2 = true;
                if ((i9 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "319@15629L41");
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i3 & 128) != 0) {
                            int i16 = (i9 & 14) | 384;
                            carouselState2 = carouselState;
                            i9 &= -29360129;
                            z2 = true;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i16, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i7 != 0) {
                            z5 = z2;
                        } else {
                            z5 = z;
                        }
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier2 = modifier3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i3 & 128) != 0) {
                            int i17 = (i9 & 14) | 384;
                            carouselState2 = carouselState;
                            i9 &= -29360129;
                            z2 = true;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i17, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i7 != 0) {
                            z5 = z2;
                        } else {
                            z5 = z;
                        }
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier2 = modifier3;
                    }
                    i10 = i9;
                    f3 = fM10168constructorimpl;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2077912500, i10, -1, "androidx.compose.material3.carousel.Carousel (Carousel.kt:322)");
                    }
                    int i18 = ((i10 >> 9) & 14) | (i10 & 112);
                    fCalculateBeforeContentPadding = calculateBeforeContentPadding(paddingValues, orientation, composerStartRestartGroup, i18);
                    fCalculateAfterContentPadding = calculateAfterContentPadding(paddingValues, orientation, composerStartRestartGroup, i18);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285902946, "CC(remember):Carousel.kt#9igjgp");
                    if ((i10 & 896) == 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    carouselPageSize = (CarouselPageSize) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    snapPositionKeylineSnapPosition = KeylineSnapPositionKt.KeylineSnapPosition(carouselPageSize);
                    if (orientation == Orientation.Horizontal) {
                        composerStartRestartGroup.startReplaceGroup(273336201);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "347@16899L24,348@16935L1024,333@16218L1741");
                        CarouselPagerState pagerState3 = carouselState2.getPagerState();
                        PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default3 = PaddingKt.m2347PaddingValuesa9UjIt4$default(0.0f, paddingValues.getTop(), 0.0f, paddingValues.getBottom(), 5, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285932036, "CC(remember):Carousel.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CarouselKt.Carousel_cJHQLPU$lambda$1$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PagerKt.m2626HorizontalPager8jOkeI(pagerState3, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue3, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default3, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1817116752, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$2(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (orientation == Orientation.Vertical) {
                        composerStartRestartGroup.startReplaceGroup(275127381);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "382@18318L7,383@18410L7,391@18755L24,392@18791L1024,377@18022L1793");
                        CarouselPagerState pagerState4 = carouselState2.getPagerState();
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float fCalculateStartPadding2 = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) objConsume3);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume4 = composerStartRestartGroup.consume(localLayoutDirection4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default4 = PaddingKt.m2347PaddingValuesa9UjIt4$default(fCalculateStartPadding2, 0.0f, PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) objConsume4), 0.0f, 10, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285991428, "CC(remember):Carousel.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CarouselKt.Carousel_cJHQLPU$lambda$3$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PagerKt.m2628VerticalPager8jOkeI(pagerState4, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue2, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default4, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1042567175, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$4(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(276856406);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = f3;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    f2 = fM10168constructorimpl;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier5 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.Carousel_cJHQLPU$lambda$5(carouselState, orientation, function2, paddingValues, i, modifier5, f2, targetedFlingBehavior2, z4, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
            fM10168constructorimpl = f;
            if ((i2 & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                    }
                    i4 |= i13;
                } else {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                }
                i4 |= i13;
            } else {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
            }
            i7 = i3 & 256;
            if (i7 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i8 = 67108864;
                    } else {
                        i8 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i4 |= i8;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i11 = 536870912;
                    } else {
                        i11 = 268435456;
                    }
                    i4 |= i11;
                }
                i9 = i4;
                z2 = true;
                if ((i9 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "319@15629L41");
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i3 & 128) != 0) {
                            int i19 = (i9 & 14) | 384;
                            carouselState2 = carouselState;
                            i9 &= -29360129;
                            z2 = true;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i19, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i7 != 0) {
                            z5 = z2;
                        } else {
                            z5 = z;
                        }
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier2 = modifier3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i3 & 128) != 0) {
                            int i110 = (i9 & 14) | 384;
                            carouselState2 = carouselState;
                            i9 &= -29360129;
                            z2 = true;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i110, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i7 != 0) {
                            z5 = z2;
                        } else {
                            z5 = z;
                        }
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier2 = modifier3;
                    }
                    i10 = i9;
                    f3 = fM10168constructorimpl;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2077912500, i10, -1, "androidx.compose.material3.carousel.Carousel (Carousel.kt:322)");
                    }
                    int i111 = ((i10 >> 9) & 14) | (i10 & 112);
                    fCalculateBeforeContentPadding = calculateBeforeContentPadding(paddingValues, orientation, composerStartRestartGroup, i111);
                    fCalculateAfterContentPadding = calculateAfterContentPadding(paddingValues, orientation, composerStartRestartGroup, i111);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285902946, "CC(remember):Carousel.kt#9igjgp");
                    if ((i10 & 896) == 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    carouselPageSize = (CarouselPageSize) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    snapPositionKeylineSnapPosition = KeylineSnapPositionKt.KeylineSnapPosition(carouselPageSize);
                    if (orientation == Orientation.Horizontal) {
                        composerStartRestartGroup.startReplaceGroup(273336201);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "347@16899L24,348@16935L1024,333@16218L1741");
                        CarouselPagerState pagerState5 = carouselState2.getPagerState();
                        PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default5 = PaddingKt.m2347PaddingValuesa9UjIt4$default(0.0f, paddingValues.getTop(), 0.0f, paddingValues.getBottom(), 5, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285932036, "CC(remember):Carousel.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CarouselKt.Carousel_cJHQLPU$lambda$1$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PagerKt.m2626HorizontalPager8jOkeI(pagerState5, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue3, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default5, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1817116752, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$2(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (orientation == Orientation.Vertical) {
                        composerStartRestartGroup.startReplaceGroup(275127381);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "382@18318L7,383@18410L7,391@18755L24,392@18791L1024,377@18022L1793");
                        CarouselPagerState pagerState6 = carouselState2.getPagerState();
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume5 = composerStartRestartGroup.consume(localLayoutDirection5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float fCalculateStartPadding3 = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) objConsume5);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localLayoutDirection6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default6 = PaddingKt.m2347PaddingValuesa9UjIt4$default(fCalculateStartPadding3, 0.0f, PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) objConsume6), 0.0f, 10, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285991428, "CC(remember):Carousel.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CarouselKt.Carousel_cJHQLPU$lambda$3$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PagerKt.m2628VerticalPager8jOkeI(pagerState6, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue2, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default6, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1042567175, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$4(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(276856406);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = f3;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    f2 = fM10168constructorimpl;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier6 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.Carousel_cJHQLPU$lambda$5(carouselState, orientation, function2, paddingValues, i, modifier6, f2, targetedFlingBehavior2, z4, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i11 = 536870912;
                } else {
                    i11 = 268435456;
                }
                i4 |= i11;
            }
            i9 = i4;
            z2 = true;
            if ((i9 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "319@15629L41");
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i3 & 128) != 0) {
                        int i112 = (i9 & 14) | 384;
                        carouselState2 = carouselState;
                        i9 &= -29360129;
                        z2 = true;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i112, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i7 != 0) {
                        z5 = z2;
                    } else {
                        z5 = z;
                    }
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    modifier2 = modifier3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i3 & 128) != 0) {
                        int i113 = (i9 & 14) | 384;
                        carouselState2 = carouselState;
                        i9 &= -29360129;
                        z2 = true;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i113, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i7 != 0) {
                        z5 = z2;
                    } else {
                        z5 = z;
                    }
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    modifier2 = modifier3;
                }
                i10 = i9;
                f3 = fM10168constructorimpl;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2077912500, i10, -1, "androidx.compose.material3.carousel.Carousel (Carousel.kt:322)");
                }
                int i114 = ((i10 >> 9) & 14) | (i10 & 112);
                fCalculateBeforeContentPadding = calculateBeforeContentPadding(paddingValues, orientation, composerStartRestartGroup, i114);
                fCalculateAfterContentPadding = calculateAfterContentPadding(paddingValues, orientation, composerStartRestartGroup, i114);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285902946, "CC(remember):Carousel.kt#9igjgp");
                if ((i10 & 896) == 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                carouselPageSize = (CarouselPageSize) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                snapPositionKeylineSnapPosition = KeylineSnapPositionKt.KeylineSnapPosition(carouselPageSize);
                if (orientation == Orientation.Horizontal) {
                    composerStartRestartGroup.startReplaceGroup(273336201);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "347@16899L24,348@16935L1024,333@16218L1741");
                    CarouselPagerState pagerState7 = carouselState2.getPagerState();
                    PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default7 = PaddingKt.m2347PaddingValuesa9UjIt4$default(0.0f, paddingValues.getTop(), 0.0f, paddingValues.getBottom(), 5, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285932036, "CC(remember):Carousel.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$1$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PagerKt.m2626HorizontalPager8jOkeI(pagerState7, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue3, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default7, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1817116752, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return CarouselKt.Carousel_cJHQLPU$lambda$2(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (orientation == Orientation.Vertical) {
                    composerStartRestartGroup.startReplaceGroup(275127381);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "382@18318L7,383@18410L7,391@18755L24,392@18791L1024,377@18022L1793");
                    CarouselPagerState pagerState8 = carouselState2.getPagerState();
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localLayoutDirection7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fCalculateStartPadding4 = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) objConsume7);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection8 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume8 = composerStartRestartGroup.consume(localLayoutDirection8);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default8 = PaddingKt.m2347PaddingValuesa9UjIt4$default(fCalculateStartPadding4, 0.0f, PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) objConsume8), 0.0f, 10, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285991428, "CC(remember):Carousel.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$3$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PagerKt.m2628VerticalPager8jOkeI(pagerState8, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue2, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default8, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1042567175, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return CarouselKt.Carousel_cJHQLPU$lambda$4(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(276856406);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f3;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z;
                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                f2 = fM10168constructorimpl;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier7 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.Carousel_cJHQLPU$lambda$5(carouselState, orientation, function2, paddingValues, i, modifier7, f2, targetedFlingBehavior2, z4, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        i5 = i3 & 64;
        if (i5 != 0) {
            if ((1572864 & i2) == 0) {
                fM10168constructorimpl = f;
                if (composerStartRestartGroup.changed(fM10168constructorimpl)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i4 |= i6;
            }
            if ((i2 & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                    if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                    }
                    i4 |= i13;
                } else {
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                }
                i4 |= i13;
            } else {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
            }
            i7 = i3 & 256;
            if (i7 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i8 = 67108864;
                    } else {
                        i8 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i4 |= i8;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i11 = 536870912;
                    } else {
                        i11 = 268435456;
                    }
                    i4 |= i11;
                }
                i9 = i4;
                z2 = true;
                if ((i9 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "319@15629L41");
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i3 & 128) != 0) {
                            int i115 = (i9 & 14) | 384;
                            carouselState2 = carouselState;
                            i9 &= -29360129;
                            z2 = true;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i115, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i7 != 0) {
                            z5 = z2;
                        } else {
                            z5 = z;
                        }
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier2 = modifier3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i5 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        if ((i3 & 128) != 0) {
                            int i116 = (i9 & 14) | 384;
                            carouselState2 = carouselState;
                            i9 &= -29360129;
                            z2 = true;
                            targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i116, 2);
                        } else {
                            carouselState2 = carouselState;
                        }
                        if (i7 != 0) {
                            z5 = z2;
                        } else {
                            z5 = z;
                        }
                        targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                        modifier2 = modifier3;
                    }
                    i10 = i9;
                    f3 = fM10168constructorimpl;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2077912500, i10, -1, "androidx.compose.material3.carousel.Carousel (Carousel.kt:322)");
                    }
                    int i117 = ((i10 >> 9) & 14) | (i10 & 112);
                    fCalculateBeforeContentPadding = calculateBeforeContentPadding(paddingValues, orientation, composerStartRestartGroup, i117);
                    fCalculateAfterContentPadding = calculateAfterContentPadding(paddingValues, orientation, composerStartRestartGroup, i117);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285902946, "CC(remember):Carousel.kt#9igjgp");
                    if ((i10 & 896) == 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    carouselPageSize = (CarouselPageSize) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    snapPositionKeylineSnapPosition = KeylineSnapPositionKt.KeylineSnapPosition(carouselPageSize);
                    if (orientation == Orientation.Horizontal) {
                        composerStartRestartGroup.startReplaceGroup(273336201);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "347@16899L24,348@16935L1024,333@16218L1741");
                        CarouselPagerState pagerState9 = carouselState2.getPagerState();
                        PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default9 = PaddingKt.m2347PaddingValuesa9UjIt4$default(0.0f, paddingValues.getTop(), 0.0f, paddingValues.getBottom(), 5, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285932036, "CC(remember):Carousel.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CarouselKt.Carousel_cJHQLPU$lambda$1$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PagerKt.m2626HorizontalPager8jOkeI(pagerState9, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue3, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default9, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1817116752, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$2(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (orientation == Orientation.Vertical) {
                        composerStartRestartGroup.startReplaceGroup(275127381);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "382@18318L7,383@18410L7,391@18755L24,392@18791L1024,377@18022L1793");
                        CarouselPagerState pagerState10 = carouselState2.getPagerState();
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection9 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume9 = composerStartRestartGroup.consume(localLayoutDirection9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float fCalculateStartPadding5 = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) objConsume9);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection10 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localLayoutDirection10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default10 = PaddingKt.m2347PaddingValuesa9UjIt4$default(fCalculateStartPadding5, 0.0f, PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) objConsume10), 0.0f, 10, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285991428, "CC(remember):Carousel.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CarouselKt.Carousel_cJHQLPU$lambda$3$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PagerKt.m2628VerticalPager8jOkeI(pagerState10, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue2, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default10, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1042567175, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$4(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(276856406);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f2 = f3;
                    targetedFlingBehavior2 = targetedFlingBehavior3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z;
                    targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    f2 = fM10168constructorimpl;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier8 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CarouselKt.Carousel_cJHQLPU$lambda$5(carouselState, orientation, function2, paddingValues, i, modifier8, f2, targetedFlingBehavior2, z4, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i11 = 536870912;
                } else {
                    i11 = 268435456;
                }
                i4 |= i11;
            }
            i9 = i4;
            z2 = true;
            if ((i9 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "319@15629L41");
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i3 & 128) != 0) {
                        int i118 = (i9 & 14) | 384;
                        carouselState2 = carouselState;
                        i9 &= -29360129;
                        z2 = true;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i118, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i7 != 0) {
                        z5 = z2;
                    } else {
                        z5 = z;
                    }
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    modifier2 = modifier3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i3 & 128) != 0) {
                        int i119 = (i9 & 14) | 384;
                        carouselState2 = carouselState;
                        i9 &= -29360129;
                        z2 = true;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i119, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i7 != 0) {
                        z5 = z2;
                    } else {
                        z5 = z;
                    }
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    modifier2 = modifier3;
                }
                i10 = i9;
                f3 = fM10168constructorimpl;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2077912500, i10, -1, "androidx.compose.material3.carousel.Carousel (Carousel.kt:322)");
                }
                int i1110 = ((i10 >> 9) & 14) | (i10 & 112);
                fCalculateBeforeContentPadding = calculateBeforeContentPadding(paddingValues, orientation, composerStartRestartGroup, i1110);
                fCalculateAfterContentPadding = calculateAfterContentPadding(paddingValues, orientation, composerStartRestartGroup, i1110);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285902946, "CC(remember):Carousel.kt#9igjgp");
                if ((i10 & 896) == 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                carouselPageSize = (CarouselPageSize) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                snapPositionKeylineSnapPosition = KeylineSnapPositionKt.KeylineSnapPosition(carouselPageSize);
                if (orientation == Orientation.Horizontal) {
                    composerStartRestartGroup.startReplaceGroup(273336201);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "347@16899L24,348@16935L1024,333@16218L1741");
                    CarouselPagerState pagerState11 = carouselState2.getPagerState();
                    PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default11 = PaddingKt.m2347PaddingValuesa9UjIt4$default(0.0f, paddingValues.getTop(), 0.0f, paddingValues.getBottom(), 5, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285932036, "CC(remember):Carousel.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$1$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PagerKt.m2626HorizontalPager8jOkeI(pagerState11, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue3, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default11, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1817116752, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return CarouselKt.Carousel_cJHQLPU$lambda$2(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (orientation == Orientation.Vertical) {
                    composerStartRestartGroup.startReplaceGroup(275127381);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "382@18318L7,383@18410L7,391@18755L24,392@18791L1024,377@18022L1793");
                    CarouselPagerState pagerState12 = carouselState2.getPagerState();
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume11 = composerStartRestartGroup.consume(localLayoutDirection11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fCalculateStartPadding6 = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) objConsume11);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection12 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume12 = composerStartRestartGroup.consume(localLayoutDirection12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default12 = PaddingKt.m2347PaddingValuesa9UjIt4$default(fCalculateStartPadding6, 0.0f, PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) objConsume12), 0.0f, 10, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285991428, "CC(remember):Carousel.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$3$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PagerKt.m2628VerticalPager8jOkeI(pagerState12, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue2, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default12, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1042567175, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return CarouselKt.Carousel_cJHQLPU$lambda$4(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(276856406);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f3;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z;
                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                f2 = fM10168constructorimpl;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier9 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.Carousel_cJHQLPU$lambda$5(carouselState, orientation, function2, paddingValues, i, modifier9, f2, targetedFlingBehavior2, z4, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 1572864;
        fM10168constructorimpl = f;
        if ((i2 & 12582912) == 0) {
            if ((i3 & 128) == 0) {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
                if (composerStartRestartGroup.changed(targetedFlingBehaviorSingleAdvanceFlingBehavior)) {
                }
                i4 |= i13;
            } else {
                targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
            }
            i4 |= i13;
        } else {
            targetedFlingBehaviorSingleAdvanceFlingBehavior = targetedFlingBehavior;
        }
        i7 = i3 & 256;
        if (i7 != 0) {
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i8 = 67108864;
                } else {
                    i8 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i4 |= i8;
            }
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i11 = 536870912;
                } else {
                    i11 = 268435456;
                }
                i4 |= i11;
            }
            i9 = i4;
            z2 = true;
            if ((i9 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "319@15629L41");
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i3 & 128) != 0) {
                        int i1111 = (i9 & 14) | 384;
                        carouselState2 = carouselState;
                        i9 &= -29360129;
                        z2 = true;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1111, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i7 != 0) {
                        z5 = z2;
                    } else {
                        z5 = z;
                    }
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    modifier2 = modifier3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i5 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    if ((i3 & 128) != 0) {
                        int i1112 = (i9 & 14) | 384;
                        carouselState2 = carouselState;
                        i9 &= -29360129;
                        z2 = true;
                        targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1112, 2);
                    } else {
                        carouselState2 = carouselState;
                    }
                    if (i7 != 0) {
                        z5 = z2;
                    } else {
                        z5 = z;
                    }
                    targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                    modifier2 = modifier3;
                }
                i10 = i9;
                f3 = fM10168constructorimpl;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2077912500, i10, -1, "androidx.compose.material3.carousel.Carousel (Carousel.kt:322)");
                }
                int i1113 = ((i10 >> 9) & 14) | (i10 & 112);
                fCalculateBeforeContentPadding = calculateBeforeContentPadding(paddingValues, orientation, composerStartRestartGroup, i1113);
                fCalculateAfterContentPadding = calculateAfterContentPadding(paddingValues, orientation, composerStartRestartGroup, i1113);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285902946, "CC(remember):Carousel.kt#9igjgp");
                if ((i10 & 896) == 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                carouselPageSize = (CarouselPageSize) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                snapPositionKeylineSnapPosition = KeylineSnapPositionKt.KeylineSnapPosition(carouselPageSize);
                if (orientation == Orientation.Horizontal) {
                    composerStartRestartGroup.startReplaceGroup(273336201);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "347@16899L24,348@16935L1024,333@16218L1741");
                    CarouselPagerState pagerState13 = carouselState2.getPagerState();
                    PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default13 = PaddingKt.m2347PaddingValuesa9UjIt4$default(0.0f, paddingValues.getTop(), 0.0f, paddingValues.getBottom(), 5, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285932036, "CC(remember):Carousel.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$1$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PagerKt.m2626HorizontalPager8jOkeI(pagerState13, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue3, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default13, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1817116752, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return CarouselKt.Carousel_cJHQLPU$lambda$2(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (orientation == Orientation.Vertical) {
                    composerStartRestartGroup.startReplaceGroup(275127381);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "382@18318L7,383@18410L7,391@18755L24,392@18791L1024,377@18022L1793");
                    CarouselPagerState pagerState14 = carouselState2.getPagerState();
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection13 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume13 = composerStartRestartGroup.consume(localLayoutDirection13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fCalculateStartPadding7 = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) objConsume13);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection14 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localLayoutDirection14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default14 = PaddingKt.m2347PaddingValuesa9UjIt4$default(fCalculateStartPadding7, 0.0f, PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) objConsume14), 0.0f, 10, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285991428, "CC(remember):Carousel.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CarouselKt.Carousel_cJHQLPU$lambda$3$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PagerKt.m2628VerticalPager8jOkeI(pagerState14, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue2, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default14, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1042567175, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return CarouselKt.Carousel_cJHQLPU$lambda$4(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(276856406);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f3;
                targetedFlingBehavior2 = targetedFlingBehavior3;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z;
                targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                f2 = fM10168constructorimpl;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier10 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CarouselKt.Carousel_cJHQLPU$lambda$5(carouselState, orientation, function2, paddingValues, i, modifier10, f2, targetedFlingBehavior2, z4, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 100663296;
        if ((i2 & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i11 = 536870912;
            } else {
                i11 = 268435456;
            }
            i4 |= i11;
        }
        i9 = i4;
        z2 = true;
        if ((i9 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "319@15629L41");
            if ((i2 & 1) != 0) {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
                if ((i3 & 128) != 0) {
                    int i1114 = (i9 & 14) | 384;
                    carouselState2 = carouselState;
                    i9 &= -29360129;
                    z2 = true;
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1114, 2);
                } else {
                    carouselState2 = carouselState;
                }
                if (i7 != 0) {
                    z5 = z2;
                } else {
                    z5 = z;
                }
                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                modifier2 = modifier3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i5 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
                if ((i3 & 128) != 0) {
                    int i1115 = (i9 & 14) | 384;
                    carouselState2 = carouselState;
                    i9 &= -29360129;
                    z2 = true;
                    targetedFlingBehaviorSingleAdvanceFlingBehavior = CarouselDefaults.INSTANCE.singleAdvanceFlingBehavior(carouselState2, null, composerStartRestartGroup, i1115, 2);
                } else {
                    carouselState2 = carouselState;
                }
                if (i7 != 0) {
                    z5 = z2;
                } else {
                    z5 = z;
                }
                targetedFlingBehavior3 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
                modifier2 = modifier3;
            }
            i10 = i9;
            f3 = fM10168constructorimpl;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2077912500, i10, -1, "androidx.compose.material3.carousel.Carousel (Carousel.kt:322)");
            }
            int i1116 = ((i10 >> 9) & 14) | (i10 & 112);
            fCalculateBeforeContentPadding = calculateBeforeContentPadding(paddingValues, orientation, composerStartRestartGroup, i1116);
            fCalculateAfterContentPadding = calculateAfterContentPadding(paddingValues, orientation, composerStartRestartGroup, i1116);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285902946, "CC(remember):Carousel.kt#9igjgp");
            if ((i10 & 896) == 256) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new CarouselPageSize(function2, fCalculateBeforeContentPadding, fCalculateAfterContentPadding);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            carouselPageSize = (CarouselPageSize) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            snapPositionKeylineSnapPosition = KeylineSnapPositionKt.KeylineSnapPosition(carouselPageSize);
            if (orientation == Orientation.Horizontal) {
                composerStartRestartGroup.startReplaceGroup(273336201);
                ComposerKt.sourceInformation(composerStartRestartGroup, "347@16899L24,348@16935L1024,333@16218L1741");
                CarouselPagerState pagerState15 = carouselState2.getPagerState();
                PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default15 = PaddingKt.m2347PaddingValuesa9UjIt4$default(0.0f, paddingValues.getTop(), 0.0f, paddingValues.getBottom(), 5, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285932036, "CC(remember):Carousel.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CarouselKt.Carousel_cJHQLPU$lambda$1$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PagerKt.m2626HorizontalPager8jOkeI(pagerState15, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue3, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default15, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1817116752, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return CarouselKt.Carousel_cJHQLPU$lambda$2(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                composerStartRestartGroup.endReplaceGroup();
            } else if (orientation == Orientation.Vertical) {
                composerStartRestartGroup.startReplaceGroup(275127381);
                ComposerKt.sourceInformation(composerStartRestartGroup, "382@18318L7,383@18410L7,391@18755L24,392@18791L1024,377@18022L1793");
                CarouselPagerState pagerState16 = carouselState2.getPagerState();
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection15 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(localLayoutDirection15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fCalculateStartPadding8 = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) objConsume15);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection16 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume16 = composerStartRestartGroup.consume(localLayoutDirection16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PaddingValues paddingValuesM2347PaddingValuesa9UjIt4$default16 = PaddingKt.m2347PaddingValuesa9UjIt4$default(fCalculateStartPadding8, 0.0f, PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) objConsume16), 0.0f, 10, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285991428, "CC(remember):Carousel.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CarouselKt.Carousel_cJHQLPU$lambda$3$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PagerKt.m2628VerticalPager8jOkeI(pagerState16, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue2, 1, null), paddingValuesM2347PaddingValuesa9UjIt4$default16, carouselPageSize, i, f3, null, targetedFlingBehavior3, z5, false, null, null, snapPositionKeylineSnapPosition, null, ComposableLambdaKt.rememberComposableLambda(-1042567175, true, new Function4() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return CarouselKt.Carousel_cJHQLPU$lambda$4(carouselState2, carouselPageSize, function4, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 57344) | ((i10 >> 3) & 458752) | (i10 & 29360128) | (i10 & 234881024), 24576, 11840);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(276856406);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f2 = f3;
            targetedFlingBehavior2 = targetedFlingBehavior3;
            z4 = z5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z;
            targetedFlingBehavior2 = targetedFlingBehaviorSingleAdvanceFlingBehavior;
            f2 = fM10168constructorimpl;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier11 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CarouselKt.Carousel_cJHQLPU$lambda$5(carouselState, orientation, function2, paddingValues, i, modifier11, f2, targetedFlingBehavior2, z4, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Carousel_cJHQLPU$lambda$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m9387setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m9369getCarouselo7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Carousel_cJHQLPU$lambda$2(CarouselState carouselState, final CarouselPageSize carouselPageSize, Function4 function4, PagerScope pagerScope, int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(page)349@16980L39,350@17044L63,351@17136L390,368@17727L21,363@17540L409:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1817116752, i2, -1, "androidx.compose.material3.carousel.Carousel.<anonymous> (Carousel.kt:349)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1802492279, "CC(remember):Carousel.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new CarouselItemDrawInfoImpl();
            composer.updateRememberedValue(objRememberedValue);
        }
        final CarouselItemDrawInfoImpl carouselItemDrawInfoImpl = (CarouselItemDrawInfoImpl) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1802494351, "CC(remember):Carousel.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new CarouselItemScopeImpl(carouselItemDrawInfoImpl);
            composer.updateRememberedValue(objRememberedValue2);
        }
        CarouselItemScopeImpl carouselItemScopeImpl = (CarouselItemScopeImpl) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1802497622, "CC(remember):Carousel.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Shape() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$2$clipShape$1$1
                @Override // androidx.compose.ui.graphics.Shape
                /* JADX INFO: renamed from: createOutline-Pq9zytI */
                public Outline mo1614createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                    return new Outline.Rectangle(carouselItemDrawInfoImpl.getMaskRect());
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        CarouselKt$Carousel$2$clipShape$1$1 carouselKt$Carousel$2$clipShape$1$1 = (CarouselKt$Carousel$2$clipShape$1$1) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1802516165, "CC(remember):Carousel.kt#9igjgp");
        boolean zChanged = composer.changed(carouselPageSize);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return carouselPageSize.getStrategy();
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierCarouselItem = carouselItem(companion, i, carouselState, (Function0) objRememberedValue4, carouselItemDrawInfoImpl, carouselKt$Carousel$2$clipShape$1$1);
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierCarouselItem);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM6438constructorimpl = Updater.m6438constructorimpl(composer);
        Updater.m6446setimpl(composerM6438constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -868976154, "C373@17922L13:Carousel.kt#dcf9yb");
        function4.invoke(carouselItemScopeImpl, Integer.valueOf(i), composer, Integer.valueOf(i2 & 112));
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Carousel_cJHQLPU$lambda$3$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m9387setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m9369getCarouselo7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Carousel_cJHQLPU$lambda$4(CarouselState carouselState, final CarouselPageSize carouselPageSize, Function4 function4, PagerScope pagerScope, int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(page)393@18836L39,394@18900L63,395@18992L390,412@19583L21,407@19396L409:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1042567175, i2, -1, "androidx.compose.material3.carousel.Carousel.<anonymous> (Carousel.kt:393)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1179673728, "CC(remember):Carousel.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new CarouselItemDrawInfoImpl();
            composer.updateRememberedValue(objRememberedValue);
        }
        final CarouselItemDrawInfoImpl carouselItemDrawInfoImpl = (CarouselItemDrawInfoImpl) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1179671656, "CC(remember):Carousel.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new CarouselItemScopeImpl(carouselItemDrawInfoImpl);
            composer.updateRememberedValue(objRememberedValue2);
        }
        CarouselItemScopeImpl carouselItemScopeImpl = (CarouselItemScopeImpl) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1179668385, "CC(remember):Carousel.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Shape() { // from class: androidx.compose.material3.carousel.CarouselKt$Carousel$4$clipShape$1$1
                @Override // androidx.compose.ui.graphics.Shape
                /* JADX INFO: renamed from: createOutline-Pq9zytI */
                public Outline mo1614createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                    return new Outline.Rectangle(carouselItemDrawInfoImpl.getMaskRect());
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        CarouselKt$Carousel$4$clipShape$1$1 carouselKt$Carousel$4$clipShape$1$1 = (CarouselKt$Carousel$4$clipShape$1$1) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -1179649842, "CC(remember):Carousel.kt#9igjgp");
        boolean zChanged = composer.changed(carouselPageSize);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return carouselPageSize.getStrategy();
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierCarouselItem = carouselItem(companion, i, carouselState, (Function0) objRememberedValue4, carouselItemDrawInfoImpl, carouselKt$Carousel$4$clipShape$1$1);
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierCarouselItem);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM6438constructorimpl = Updater.m6438constructorimpl(composer);
        Updater.m6446setimpl(composerM6438constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1173158141, "C417@19778L13:Carousel.kt#dcf9yb");
        function4.invoke(carouselItemScopeImpl, Integer.valueOf(i), composer, Integer.valueOf(i2 & 112));
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final float calculateBeforeContentPadding(PaddingValues paddingValues, Orientation orientation, Composer composer, int i) {
        float fCalculateStartPadding;
        ComposerKt.sourceInformationMarkerStart(composer, 1896839347, "C(calculateBeforeContentPadding)N(orientation)432@20152L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896839347, i, -1, "androidx.compose.material3.carousel.calculateBeforeContentPadding (Carousel.kt:424)");
        }
        if (orientation == Orientation.Vertical) {
            composer.startReplaceGroup(-143576798);
            composer.endReplaceGroup();
            fCalculateStartPadding = paddingValues.getTop();
        } else {
            composer.startReplaceGroup(-143525276);
            ComposerKt.sourceInformation(composer, "429@20103L7");
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) objConsume);
            composer.endReplaceGroup();
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fMo1734toPx0680j_4 = ((Density) objConsume2).mo1734toPx0680j_4(fCalculateStartPadding);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fMo1734toPx0680j_4;
    }

    private static final float calculateAfterContentPadding(PaddingValues paddingValues, Orientation orientation, Composer composer, int i) {
        float fCalculateEndPadding;
        ComposerKt.sourceInformationMarkerStart(composer, 1018496720, "C(calculateAfterContentPadding)N(orientation)444@20510L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1018496720, i, -1, "androidx.compose.material3.carousel.calculateAfterContentPadding (Carousel.kt:436)");
        }
        if (orientation == Orientation.Vertical) {
            composer.startReplaceGroup(-1908011422);
            composer.endReplaceGroup();
            fCalculateEndPadding = paddingValues.getBottom();
        } else {
            composer.startReplaceGroup(-1907957079);
            ComposerKt.sourceInformation(composer, "441@20461L7");
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            fCalculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) objConsume);
            composer.endReplaceGroup();
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fMo1734toPx0680j_4 = ((Density) objConsume2).mo1734toPx0680j_4(fCalculateEndPadding);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fMo1734toPx0680j_4;
    }

    public static final Modifier carouselItem(Modifier modifier, final int i, final CarouselState carouselState, final Function0<Strategy> function0, final CarouselItemDrawInfoImpl carouselItemDrawInfoImpl, final Shape shape) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return CarouselKt.carouselItem$lambda$0(function0, carouselState, i, carouselItemDrawInfoImpl, shape, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    static final MeasureResult carouselItem$lambda$0(Function0 function0, final CarouselState carouselState, final int i, final CarouselItemDrawInfoImpl carouselItemDrawInfoImpl, final Shape shape, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        long jM10110copyZbe2FdA;
        final Strategy strategy = (Strategy) function0.invoke();
        if (!strategy.getIsValid()) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CarouselKt.carouselItem$lambda$0$0((Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        final boolean z = carouselState.getPagerState().getLayoutInfo().getOrientation() == Orientation.Vertical;
        final boolean z2 = measureScope.getLayoutDirection() == LayoutDirection.Rtl;
        float itemMainAxisSize = strategy.getItemMainAxisSize();
        if (z) {
            jM10110copyZbe2FdA = Constraints.m10110copyZbe2FdA(constraints.getValue(), Constraints.m10123getMinWidthimpl(constraints.getValue()), Constraints.m10121getMaxWidthimpl(constraints.getValue()), MathKt.roundToInt(itemMainAxisSize), MathKt.roundToInt(itemMainAxisSize));
        } else {
            jM10110copyZbe2FdA = Constraints.m10110copyZbe2FdA(constraints.getValue(), MathKt.roundToInt(itemMainAxisSize), MathKt.roundToInt(itemMainAxisSize), Constraints.m10122getMinHeightimpl(constraints.getValue()), Constraints.m10120getMaxHeightimpl(constraints.getValue()));
        }
        final Placeable placeableMo8808measureBRTryo0 = measurable.mo8808measureBRTryo0(jM10110copyZbe2FdA);
        final float f = 1.0f;
        if (i != carouselState.getPagerState().getCurrentPage()) {
            f = i == 0 ? 0.0f : 1.0f / i;
        }
        return MeasureScope.layout$default(measureScope, placeableMo8808measureBRTryo0.getWidth(), placeableMo8808measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CarouselKt.carouselItem$lambda$0$1(placeableMo8808measureBRTryo0, f, carouselState, strategy, i, z, carouselItemDrawInfoImpl, shape, z2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit carouselItem$lambda$0$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit carouselItem$lambda$0$1(Placeable placeable, float f, final CarouselState carouselState, final Strategy strategy, final int i, final boolean z, final CarouselItemDrawInfoImpl carouselItemDrawInfoImpl, final Shape shape, final boolean z2, Placeable.PlacementScope placementScope) {
        placementScope.placeWithLayer(placeable, 0, 0, f, new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CarouselKt.carouselItem$lambda$0$1$0(carouselState, strategy, i, z, carouselItemDrawInfoImpl, shape, z2, (GraphicsLayerScope) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit carouselItem$lambda$0$1$0(CarouselState carouselState, Strategy strategy, int i, boolean z, CarouselItemDrawInfoImpl carouselItemDrawInfoImpl, Shape shape, boolean z2, GraphicsLayerScope graphicsLayerScope) {
        float fCalculateCurrentScrollOffset = calculateCurrentScrollOffset(carouselState, strategy);
        float fCalculateMaxScrollOffset = calculateMaxScrollOffset(carouselState, strategy);
        KeylineList keylineListForScrollOffset$material3$default = Strategy.getKeylineListForScrollOffset$material3$default(strategy, fCalculateCurrentScrollOffset, fCalculateMaxScrollOffset, false, 4, null);
        KeylineList keylineListForScrollOffset$material3 = strategy.getKeylineListForScrollOffset$material3(fCalculateCurrentScrollOffset, fCalculateMaxScrollOffset, true);
        float itemMainAxisSize = ((i * (strategy.getItemMainAxisSize() + strategy.getItemSpacing())) + (strategy.getItemMainAxisSize() / 2.0f)) - fCalculateCurrentScrollOffset;
        Keyline keylineBefore = keylineListForScrollOffset$material3$default.getKeylineBefore(itemMainAxisSize);
        Keyline keylineAfter = keylineListForScrollOffset$material3$default.getKeylineAfter(itemMainAxisSize);
        Keyline keylineLerp = KeylineListKt.lerp(keylineBefore, keylineAfter, getProgress(keylineBefore, keylineAfter, itemMainAxisSize));
        boolean zAreEqual = Intrinsics.areEqual(keylineBefore, keylineAfter);
        float fIntBitsToFloat = (z ? Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L)) : strategy.getItemMainAxisSize()) / 2.0f;
        float itemMainAxisSize2 = (z ? strategy.getItemMainAxisSize() : Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L))) / 2.0f;
        float fIntBitsToFloat2 = (z ? Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32)) : keylineLerp.getSize()) / 2.0f;
        float size = (z ? keylineLerp.getSize() : Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L))) / 2.0f;
        Rect rect = new Rect(fIntBitsToFloat - fIntBitsToFloat2, itemMainAxisSize2 - size, fIntBitsToFloat + fIntBitsToFloat2, itemMainAxisSize2 + size);
        carouselItemDrawInfoImpl.setSizeState(keylineLerp.getSize());
        Iterator<Keyline> it = keylineListForScrollOffset$material3.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Keyline next = it.next();
        if (it.hasNext()) {
            float size2 = next.getSize();
            do {
                Keyline next2 = it.next();
                float size3 = next2.getSize();
                if (Float.compare(size2, size3) > 0) {
                    next = next2;
                    size2 = size3;
                }
            } while (it.hasNext());
        }
        carouselItemDrawInfoImpl.setMinSizeState(next.getSize());
        carouselItemDrawInfoImpl.setMaxSizeState(keylineListForScrollOffset$material3.getFirstFocal().getSize());
        carouselItemDrawInfoImpl.setMaskRectState(rect);
        graphicsLayerScope.setClip(!Intrinsics.areEqual(rect, new Rect(0.0f, 0.0f, Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32)), Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L)))));
        graphicsLayerScope.setShape(shape);
        float offset = keylineLerp.getOffset() - itemMainAxisSize;
        if (zAreEqual) {
            offset += (itemMainAxisSize - keylineLerp.getUnadjustedOffset()) / keylineLerp.getSize();
        }
        if (z) {
            graphicsLayerScope.setTranslationY(offset);
        } else {
            if (z2) {
                offset = -offset;
            }
            graphicsLayerScope.setTranslationX(offset);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawDebugLines-1Yev-eo$default, reason: not valid java name */
    static /* synthetic */ Modifier m5281drawDebugLines1Yeveo$default(Modifier modifier, CarouselState carouselState, CarouselPageSize carouselPageSize, long j, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            j = Color.INSTANCE.m7371getMagenta0d7_KjU();
        }
        long j2 = j;
        if ((i & 8) != 0) {
            f = Dp.m10168constructorimpl(4.0f);
        }
        return m5280drawDebugLines1Yeveo(modifier, carouselState, carouselPageSize, j2, f);
    }

    /* JADX INFO: renamed from: drawDebugLines-1Yev-eo, reason: not valid java name */
    private static final Modifier m5280drawDebugLines1Yeveo(Modifier modifier, final CarouselState carouselState, final CarouselPageSize carouselPageSize, final long j, final float f) {
        return DrawModifierKt.drawWithContent(modifier, new Function1() { // from class: androidx.compose.material3.carousel.CarouselKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CarouselKt.drawDebugLines_1Yev_eo$lambda$0(carouselPageSize, carouselState, f, j, (ContentDrawScope) obj);
            }
        });
    }

    static final Unit drawDebugLines_1Yev_eo$lambda$0(CarouselPageSize carouselPageSize, CarouselState carouselState, float f, long j, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        Strategy strategy = carouselPageSize.getStrategy();
        KeylineList keylineListForScrollOffset$material3$default = Strategy.getKeylineListForScrollOffset$material3$default(strategy, calculateCurrentScrollOffset(carouselState, strategy), calculateMaxScrollOffset(carouselState, strategy), false, 4, null);
        float f2 = contentDrawScope.mo1734toPx0680j_4(f);
        int i = 0;
        for (int size = keylineListForScrollOffset$material3$default.size(); i < size; size = size) {
            DrawScope.m7898drawLineNGM6Ib0$default(contentDrawScope, j, Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(keylineListForScrollOffset$material3$default.get(i).getOffset())) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(keylineListForScrollOffset$material3$default.get(i).getOffset())) << 32) | (((long) Float.floatToRawIntBits(100.0f)) & 4294967295L)), f2, 0, null, 0.0f, null, 0, 496, null);
            i++;
        }
        return Unit.INSTANCE;
    }

    public static final float calculateCurrentScrollOffset(CarouselState carouselState, Strategy strategy) {
        float itemMainAxisSize = strategy.getItemMainAxisSize() + strategy.getItemSpacing();
        return ((carouselState.getPagerState().getCurrentPage() * itemMainAxisSize) + (carouselState.getPagerState().getCurrentPageOffsetFraction() * itemMainAxisSize)) - KeylineSnapPositionKt.getSnapPositionOffset(strategy, carouselState.getPagerState().getCurrentPage(), carouselState.getPagerState().getPageCount());
    }

    public static final float calculateMaxScrollOffset(CarouselState carouselState, Strategy strategy) {
        float pageCount = carouselState.getPagerState().getPageCount();
        return RangesKt.coerceAtLeast(((strategy.getItemMainAxisSize() * pageCount) + (strategy.getItemSpacing() * (pageCount - 1.0f))) - strategy.getAvailableSpace(), 0.0f);
    }

    private static final float getProgress(Keyline keyline, Keyline keyline2, float f) {
        if (Intrinsics.areEqual(keyline, keyline2)) {
            return 1.0f;
        }
        return (f - keyline.getUnadjustedOffset()) / (keyline2.getUnadjustedOffset() - keyline.getUnadjustedOffset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeylineList HorizontalCenteredHeroCarousel_p2lB3Bg$lambda$0$0(Density density, float f, CarouselState carouselState, float f2, float f3, float f4, float f5) {
        return KeylinesKt.heroKeylineList(density, f4, !Float.isNaN(f) ? Float.valueOf(density.mo1734toPx0680j_4(f)) : null, f5, carouselState.getPagerState().getPageCountState().getValue().invoke().intValue(), true, density.mo1734toPx0680j_4(f2), density.mo1734toPx0680j_4(f3));
    }
}
