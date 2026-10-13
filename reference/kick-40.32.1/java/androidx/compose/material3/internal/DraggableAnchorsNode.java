package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchors;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.material3.ComposeMaterial3Flags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* JADX INFO: compiled from: DraggableAnchors.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003Bg\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012H\u0010\u0006\u001aD\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0004\u0012\u00028\u00000\u000e0\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\"\u001a\u00020#H\u0016Jf\u0010&\u001a\u00020#2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052H\u0010\u0006\u001aD\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0004\u0012\u00028\u00000\u000e0\u00072\u0006\u0010\u0010\u001a\u00020\u0011J#\u0010'\u001a\u00020(*\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b,\u0010-J\u0018\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020!H\u0002R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\\\u0010\u0006\u001aD\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0004\u0012\u00028\u00000\u000e0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u00062"}, d2 = {"Landroidx/compose/material3/internal/DraggableAnchorsNode;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "anchors", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/unit/Constraints;", CryptoServicesPermission.CONSTRAINTS, "Lkotlin/Pair;", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/gestures/Orientation;)V", "getState", "()Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "setState", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;)V", "getAnchors", "()Lkotlin/jvm/functions/Function2;", "setAnchors", "(Lkotlin/jvm/functions/Function2;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "didInitializeAnchors", "", "onDetach", "", "isReverseDirection", "()Z", "update", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "checkOffsetIsValid", "offset", "", "isLookingAhead", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DraggableAnchorsNode<T> extends Modifier.Node implements LayoutModifierNode {
    private Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends DraggableAnchors<T>, ? extends T>> anchors;
    private boolean didInitializeAnchors;
    private Orientation orientation;
    private AnchoredDraggableState<T> state;

    public DraggableAnchorsNode(AnchoredDraggableState<T> anchoredDraggableState, Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends DraggableAnchors<T>, ? extends T>> function2, Orientation orientation) {
        this.state = anchoredDraggableState;
        this.anchors = function2;
        this.orientation = orientation;
    }

    public final AnchoredDraggableState<T> getState() {
        return this.state;
    }

    public final void setState(AnchoredDraggableState<T> anchoredDraggableState) {
        this.state = anchoredDraggableState;
    }

    public final Function2<IntSize, Constraints, Pair<DraggableAnchors<T>, T>> getAnchors() {
        return this.anchors;
    }

    public final void setAnchors(Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends DraggableAnchors<T>, ? extends T>> function2) {
        this.anchors = function2;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.didInitializeAnchors = false;
    }

    private final boolean isReverseDirection() {
        return DelegatableNodeKt.requireLayoutDirection(this) == LayoutDirection.Rtl && this.orientation == Orientation.Horizontal;
    }

    public final void update(AnchoredDraggableState<T> state, Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends DraggableAnchors<T>, ? extends T>> anchors, Orientation orientation) {
        boolean z = ComposeMaterial3Flags.isAnchoredDraggableComponentsInvalidationFixEnabled && !Intrinsics.areEqual(this.state, state);
        this.state = state;
        this.anchors = anchors;
        this.orientation = orientation;
        if (z) {
            this.didInitializeAnchors = false;
            LayoutModifierNodeKt.invalidateMeasurement(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1339measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        Object objAnchorAt;
        final Placeable placeableMo8808measureBRTryo0 = measurable.mo8808measureBRTryo0(j);
        if (!measureScope.isLookingAhead() || !this.didInitializeAnchors) {
            Pair<? extends DraggableAnchors<T>, ? extends T> pairInvoke = this.anchors.invoke(IntSize.m10331boximpl(IntSize.m10334constructorimpl((((long) placeableMo8808measureBRTryo0.getWidth()) << 32) | (((long) placeableMo8808measureBRTryo0.getHeight()) & 4294967295L))), Constraints.m10108boximpl(j));
            DraggableAnchors<T> draggableAnchorsComponent1 = pairInvoke.component1();
            Object objComponent2 = pairInvoke.component2();
            if (ComposeMaterial3Flags.isAnchoredDraggableComponentsAnchorRecoveryEnabled) {
                if (!draggableAnchorsComponent1.hasPositionFor(objComponent2) && (objAnchorAt = draggableAnchorsComponent1.anchorAt(0)) != null) {
                    objComponent2 = objAnchorAt;
                }
                this.state.updateAnchors(draggableAnchorsComponent1, objComponent2);
            } else {
                this.state.updateAnchors(draggableAnchorsComponent1, objComponent2);
            }
            this.didInitializeAnchors = true;
        }
        this.didInitializeAnchors = measureScope.isLookingAhead() || this.didInitializeAnchors;
        return MeasureScope.layout$default(measureScope, placeableMo8808measureBRTryo0.getWidth(), placeableMo8808measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.internal.DraggableAnchorsNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DraggableAnchorsNode.measure_3p2s80s$lambda$0(measureScope, this, placeableMo8808measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(MeasureScope measureScope, DraggableAnchorsNode draggableAnchorsNode, final Placeable placeable, Placeable.PlacementScope placementScope) throws AnchoredDraggableUninitializedException {
        final float offset;
        if (measureScope.isLookingAhead()) {
            offset = draggableAnchorsNode.state.getAnchors().positionOf(draggableAnchorsNode.state.getTargetValue());
        } else {
            offset = draggableAnchorsNode.state.getOffset();
        }
        if (ComposeMaterial3Flags.isAnchoredDraggableComponentsStrictOffsetCheckEnabled) {
            draggableAnchorsNode.checkOffsetIsValid(offset, measureScope.isLookingAhead());
        } else if (Float.isNaN(offset)) {
            return Unit.INSTANCE;
        }
        final float f = draggableAnchorsNode.orientation == Orientation.Horizontal ? (draggableAnchorsNode.isReverseDirection() ? -1.0f : 1.0f) * offset : 0.0f;
        if (draggableAnchorsNode.orientation != Orientation.Vertical) {
            offset = 0.0f;
        }
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.material3.internal.DraggableAnchorsNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DraggableAnchorsNode.measure_3p2s80s$lambda$0$0(placeable, f, offset, (Placeable.PlacementScope) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0$0(Placeable placeable, float f, float f2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, MathKt.roundToInt(f), MathKt.roundToInt(f2), 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    private final void checkOffsetIsValid(float offset, boolean isLookingAhead) throws AnchoredDraggableUninitializedException {
        if (Float.isNaN(offset)) {
            throw new AnchoredDraggableUninitializedException(isLookingAhead, this.didInitializeAnchors, this.state.getAnchors(), this.state.getTargetValue());
        }
    }
}
