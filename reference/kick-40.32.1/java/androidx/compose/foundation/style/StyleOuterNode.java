package androidx.compose.foundation.style;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.border.BorderLogic;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.text.modifiers.TextStyleProviderNode;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.shadow.DropShadowPainter;
import androidx.compose.ui.graphics.shadow.InnerShadowPainter;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* JADX INFO: compiled from: StyleModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0019\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\"H\u0000¢\u0006\u0002\b?J\b\u0010@\u001a\u00020\"H\u0002J\b\u0010A\u001a\u00020\"H\u0002J#\u0010B\u001a\u00020C*\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ\f\u0010K\u001a\u00020\u0010*\u00020\"H\u0002J\f\u0010L\u001a\u00020\u0010*\u00020\"H\u0002J\f\u0010X\u001a\u00020P*\u00020OH\u0002J#\u0010b\u001a\u00020a*\u00020c2\u0006\u0010d\u001a\u00020Z2\u0006\u0010e\u001a\u00020_H\u0002¢\u0006\u0004\bf\u0010gJ\f\u0010h\u001a\u00020P*\u00020cH\u0016J$\u0010p\u001a\u00020P*\u00020c2\u0006\u0010q\u001a\u00020=2\u0006\u0010e\u001a\u00020_2\u0006\u0010r\u001a\u00020kH\u0002J\u0016\u0010s\u001a\u00020P2\u0006\u0010t\u001a\u00020u2\u0006\u0010e\u001a\u00020_J\u0012\u0010p\u001a\u00020P*\u00020c2\u0006\u0010v\u001a\u00020\"J$\u0010{\u001a\u00020P*\u00020c2\u0006\u0010q\u001a\u00020=2\u0006\u0010e\u001a\u00020_2\u0006\u0010r\u001a\u00020kH\u0002J\u0016\u0010|\u001a\u00020P2\u0006\u0010t\u001a\u00020u2\u0006\u0010e\u001a\u00020_J\u0012\u0010{\u001a\u00020P*\u00020c2\u0006\u0010v\u001a\u00020\"J\u0080\u0001\u0010}\u001a\u00020P*\u00020c2\u0006\u0010e\u001a\u00020_2\u0006\u0010~\u001a\u00020\u00102\u0006\u0010\u007f\u001a\u00020\u00102\u0007\u0010\u0080\u0001\u001a\u00020\u00102\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010\u0085\u0001\u001a\u00030\u0082\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010\u0087\u0001\u001a\u00030\u0082\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0012\u0010\u0090\u0001\u001a\u00020P2\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u0010J\t\u0010\u0092\u0001\u001a\u00020PH\u0016J\u0007\u0010\u0099\u0001\u001a\u00020PJ'\u0010\u009f\u0001\u001a\u00030 \u00012\b\u0010¡\u0001\u001a\u00030¢\u00012\b\u0010£\u0001\u001a\u00030 \u0001H\u0016¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u0019\u0010¬\u0001\u001a\u0004\u0018\u00010\"2\u0006\u0010<\u001a\u00020=H\u0000¢\u0006\u0003\b\u00ad\u0001J\u0011\u0010°\u0001\u001a\u0004\u0018\u00010\"H\u0000¢\u0006\u0003\b±\u0001J\u0017\u0010²\u0001\u001a\u00020P2\u0006\u0010\u000b\u001a\u00020\"H\u0000¢\u0006\u0003\b³\u0001J\t\u0010´\u0001\u001a\u00020PH\u0002J\t\u0010µ\u0001\u001a\u00020PH\u0002J\t\u0010¶\u0001\u001a\u00020PH\u0016R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00148@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00106\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R-\u0010M\u001a\u0015\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P\u0018\u00010N¢\u0006\u0002\bQX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR%\u0010V\u001a\u0013\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P0N¢\u0006\u0002\bQ8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bW\u0010SR\u0010\u0010Y\u001a\u00020ZX\u0082\u000e¢\u0006\u0004\n\u0002\u0010[R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010k\u0018\u00010jX\u0082\u000e¢\u0006\u0004\n\u0002\u0010lR\u001a\u0010m\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010n\u0018\u00010jX\u0082\u000e¢\u0006\u0004\n\u0002\u0010oR\u001a\u0010w\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010k\u0018\u00010jX\u0082\u000e¢\u0006\u0004\n\u0002\u0010lR\u001a\u0010x\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010y\u0018\u00010jX\u0082\u000e¢\u0006\u0004\n\u0002\u0010zR\u0017\u0010\u008d\u0001\u001a\u00020u8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\"\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R+\u0010\u009a\u0001\u001a\u0003H\u009b\u0001\"\u0005\b\u0000\u0010\u009b\u0001*\n\u0012\u0005\u0012\u0003H\u009b\u00010\u009c\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R(\u0010¦\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0000\u0018\u00010§\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R\u0011\u0010®\u0001\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¯\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006·\u0001"}, d2 = {"Landroidx/compose/foundation/style/StyleOuterNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Landroidx/compose/foundation/text/modifiers/TextStyleProviderNode;", "styleState", "Landroidx/compose/foundation/style/StyleState;", "style", "Landroidx/compose/foundation/style/Style;", "<init>", "(Landroidx/compose/foundation/style/StyleState;Landroidx/compose/foundation/style/Style;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "innerNodeField", "Landroidx/compose/foundation/style/StyleInnerNode;", "getInnerNodeField$foundation", "()Landroidx/compose/foundation/style/StyleInnerNode;", "setInnerNodeField$foundation", "(Landroidx/compose/foundation/style/StyleInnerNode;)V", "value", "innerNode", "getInnerNode$foundation", "setInnerNode$foundation", "getStyle$foundation", "()Landroidx/compose/foundation/style/Style;", "setStyle$foundation", "(Landroidx/compose/foundation/style/Style;)V", "_resolved", "Landroidx/compose/foundation/style/ResolvedStyle;", "_bufferOrNull", "bufferNonNull", "getBufferNonNull", "()Landroidx/compose/foundation/style/ResolvedStyle;", "animations", "Landroidx/compose/foundation/style/StyleAnimations;", "getAnimations$foundation", "()Landroidx/compose/foundation/style/StyleAnimations;", "setAnimations$foundation", "(Landroidx/compose/foundation/style/StyleAnimations;)V", "borderLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "borderLayerProvider", "Lkotlin/Function0;", "borderLogic", "Landroidx/compose/foundation/border/BorderLogic;", "_state", "currentInteractionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "state", "getState$foundation", "()Landroidx/compose/foundation/style/StyleState;", "setState$foundation", "(Landroidx/compose/foundation/style/StyleState;)V", "resolveAnimatedStyleFor", "flags", "", Constants.SENSITIVITY_BASE, "resolveAnimatedStyleFor$foundation", "currentLayerStyle", "currentLayoutStyle", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", CryptoServicesPermission.CONSTRAINTS, "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "shouldPlaceRelativeToRight", "shouldPlaceRelativeToBottom", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "getLayerBlock$foundation", "()Lkotlin/jvm/functions/Function1;", "setLayerBlock$foundation", "(Lkotlin/jvm/functions/Function1;)V", "layerBlockNonNull", "getLayerBlockNonNull$foundation", "updateLayer", "lastSize", "Landroidx/compose/ui/geometry/Size;", "J", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastShape", "Landroidx/compose/ui/graphics/Shape;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "getOutline", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", ContentDisposition.Parameters.Size, "shape", "getOutline-12SF9DM", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;JLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/graphics/Outline;", "draw", "lastInnerShadow", "", "Landroidx/compose/ui/graphics/shadow/Shadow;", "[Landroidx/compose/ui/graphics/shadow/Shadow;", "cachedInnerShadowPainters", "Landroidx/compose/ui/graphics/shadow/InnerShadowPainter;", "[Landroidx/compose/ui/graphics/shadow/InnerShadowPainter;", "drawInnerShadow", FirebaseAnalytics.Param.INDEX, "shadow", "reconcileInnerShadowCache", "shadowOrArray", "", "resolved", "lastDropShadow", "cachedDropShadowPainters", "Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "[Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "drawDropShadow", "reconcileDropShadowCache", "drawForShape", "hasBackground", "hasBorder", "hasForeground", "bgColor", "Landroidx/compose/ui/graphics/Color;", "bgBrush", "Landroidx/compose/ui/graphics/Brush;", ViewProps.BORDER_COLOR, "borderBrush", ViewProps.FOREGROUND_COLOR, "foregroundBrush", ViewProps.BORDER_WIDTH, "", "drawForShape-9zt3ed4", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/ui/graphics/Shape;ZZZJLandroidx/compose/ui/graphics/Brush;JLandroidx/compose/ui/graphics/Brush;JLandroidx/compose/ui/graphics/Brush;F)V", "traverseKey", "getTraverseKey", "()Ljava/lang/Object;", "resolveStyleAndInvalidate", "initial", "onObservedReadsChanged", "sourceJob", "Lkotlinx/coroutines/Job;", "getSourceJob", "()Lkotlinx/coroutines/Job;", "setSourceJob", "(Lkotlinx/coroutines/Job;)V", "updateInteractionSources", "currentValue", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/CompositionLocal;", "getCurrentValue", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "computeInheritedTextStyle", "Landroidx/compose/ui/text/TextStyle;", TypedValues.Cycle.S_WAVE_PHASE, "Landroidx/compose/foundation/text/modifiers/StylePhase;", "fallback", "computeInheritedTextStyle-B-LjeIk", "(ILandroidx/compose/ui/text/TextStyle;)Landroidx/compose/ui/text/TextStyle;", "ancestorNodes", "Landroidx/collection/MutableObjectList;", "getAncestorNodes$foundation", "()Landroidx/collection/MutableObjectList;", "setAncestorNodes$foundation", "(Landroidx/collection/MutableObjectList;)V", "resolveInheritedStyle", "resolveInheritedStyle$foundation", "cachedInheritedStyle", "inheritedStyleDirty", "getCachedInheritedStyle", "getCachedInheritedStyle$foundation", "saveInheritedStyles", "saveInheritedStyles$foundation", "invalidateTextLayout", "invalidateTextDraw", "onDetach", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StyleOuterNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, TraversableNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, CompositionLocalAccessorScope, TextStyleProviderNode {
    public static final int $stable = 8;
    private ResolvedStyle _bufferOrNull;
    private StyleState _state;
    private MutableObjectList<StyleOuterNode> ancestorNodes;
    private StyleAnimations animations;
    private GraphicsLayer borderLayer;
    private Function0<GraphicsLayer> borderLayerProvider;
    private DropShadowPainter[] cachedDropShadowPainters;
    private ResolvedStyle cachedInheritedStyle;
    private InnerShadowPainter[] cachedInnerShadowPainters;
    private InteractionSource currentInteractionSource;
    private boolean inheritedStyleDirty;
    private StyleInnerNode innerNodeField;
    private Shadow[] lastDropShadow;
    private Shadow[] lastInnerShadow;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Shape lastShape;
    private long lastSize;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Job sourceJob;
    private Style style;
    private ResolvedStyle _resolved = new ResolvedStyle();
    private final BorderLogic borderLogic = new BorderLogic();

    static final float drawForShape_9zt3ed4$lambda$0(float f) {
        return f;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public StyleOuterNode(MutableStyleState mutableStyleState, Style style) {
        this.style = style;
        this._state = mutableStyleState == null ? new MutableStyleState(null) : mutableStyleState;
        this.lastSize = Size.INSTANCE.m7150getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: getInnerNodeField$foundation, reason: from getter */
    public final StyleInnerNode getInnerNodeField() {
        return this.innerNodeField;
    }

    public final void setInnerNodeField$foundation(StyleInnerNode styleInnerNode) {
        this.innerNodeField = styleInnerNode;
    }

    public final StyleInnerNode getInnerNode$foundation() {
        StyleInnerNode styleInnerNode = this.innerNodeField;
        if (styleInnerNode != null) {
            return styleInnerNode;
        }
        throw new IllegalStateException("StyleOuterNode with no corresponding StyleInnerNode".toString());
    }

    public final void setInnerNode$foundation(StyleInnerNode styleInnerNode) {
        this.innerNodeField = styleInnerNode;
    }

    /* JADX INFO: renamed from: getStyle$foundation, reason: from getter */
    public final Style getStyle() {
        return this.style;
    }

    public final void setStyle$foundation(Style style) {
        this.style = style;
        resolveStyleAndInvalidate$default(this, false, 1, null);
    }

    private final ResolvedStyle getBufferNonNull() {
        if (this._bufferOrNull == null) {
            this._bufferOrNull = new ResolvedStyle();
        }
        ResolvedStyle resolvedStyle = this._bufferOrNull;
        Intrinsics.checkNotNull(resolvedStyle);
        return resolvedStyle;
    }

    /* JADX INFO: renamed from: getAnimations$foundation, reason: from getter */
    public final StyleAnimations getAnimations() {
        return this.animations;
    }

    public final void setAnimations$foundation(StyleAnimations styleAnimations) {
        this.animations = styleAnimations;
    }

    /* JADX INFO: renamed from: getState$foundation, reason: from getter */
    public final StyleState get_state() {
        return this._state;
    }

    public final void setState$foundation(StyleState styleState) {
        if (Intrinsics.areEqual(this._state, styleState)) {
            return;
        }
        this._state = styleState;
        resolveStyleAndInvalidate$default(this, false, 1, null);
        LayoutModifierNodeKt.invalidateLayer(getInnerNode$foundation());
    }

    public static /* synthetic */ ResolvedStyle resolveAnimatedStyleFor$foundation$default(StyleOuterNode styleOuterNode, int i, ResolvedStyle resolvedStyle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            resolvedStyle = styleOuterNode._resolved;
        }
        return styleOuterNode.resolveAnimatedStyleFor$foundation(i, resolvedStyle);
    }

    public final ResolvedStyle resolveAnimatedStyleFor$foundation(int flags, ResolvedStyle base) {
        StyleAnimations styleAnimations = this.animations;
        return (styleAnimations == null || !styleAnimations.isNotEmpty()) ? base : styleAnimations.withAnimations(DelegatableNodeKt.requireDensity(this), base, this, flags);
    }

    private final ResolvedStyle currentLayerStyle() {
        return resolveAnimatedStyleFor$foundation$default(this, 4, null, 2, null);
    }

    private final ResolvedStyle currentLayoutStyle() {
        return resolveAnimatedStyleFor$foundation$default(this, 8, null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:72:0x010f  */
    /* JADX WARN: Code duplicated, block: B:74:0x0119  */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1339measure3p2s80s(MeasureScope measureScope, Measurable measurable, final long j) {
        ResolvedStyle resolvedStyleCurrentLayoutStyle = currentLayoutStyle();
        float externalPaddingStart = resolvedStyleCurrentLayoutStyle.getExternalPaddingStart();
        float left = resolvedStyleCurrentLayoutStyle.getLeft();
        if (!Float.isNaN(left)) {
            externalPaddingStart += left;
        }
        final float f = externalPaddingStart;
        float externalPaddingEnd = resolvedStyleCurrentLayoutStyle.getExternalPaddingEnd();
        float right = resolvedStyleCurrentLayoutStyle.getRight();
        if (!Float.isNaN(right)) {
            externalPaddingEnd += right;
        }
        final float f2 = externalPaddingEnd;
        float externalPaddingTop = resolvedStyleCurrentLayoutStyle.getExternalPaddingTop();
        float top = resolvedStyleCurrentLayoutStyle.getTop();
        if (!Float.isNaN(top)) {
            externalPaddingTop += top;
        }
        final float f3 = externalPaddingTop;
        float externalPaddingBottom = resolvedStyleCurrentLayoutStyle.getExternalPaddingBottom();
        float bottom = resolvedStyleCurrentLayoutStyle.getBottom();
        if (!Float.isNaN(bottom)) {
            externalPaddingBottom += bottom;
        }
        final float f4 = externalPaddingBottom;
        int iRound = Math.round(f + f2);
        int iRound2 = Math.round(f3 + f4);
        int iM10123getMinWidthimpl = Constraints.m10123getMinWidthimpl(j) - iRound;
        if (iM10123getMinWidthimpl < 0) {
            iM10123getMinWidthimpl = 0;
        }
        int iM10121getMaxWidthimpl = Constraints.m10121getMaxWidthimpl(j);
        if (iM10121getMaxWidthimpl != Integer.MAX_VALUE && (iM10121getMaxWidthimpl = iM10121getMaxWidthimpl + iRound) < 0) {
            iM10121getMaxWidthimpl = 0;
        }
        int iM10122getMinHeightimpl = Constraints.m10122getMinHeightimpl(j) - iRound2;
        if (iM10122getMinHeightimpl < 0) {
            iM10122getMinHeightimpl = 0;
        }
        int iM10120getMaxHeightimpl = Constraints.m10120getMaxHeightimpl(j);
        int iRound3 = (iM10120getMaxHeightimpl == Integer.MAX_VALUE || (iM10120getMaxHeightimpl = iM10120getMaxHeightimpl + iRound2) >= 0) ? iM10120getMaxHeightimpl : 0;
        float minWidth = resolvedStyleCurrentLayoutStyle.getMinWidth();
        if (!Float.isNaN(minWidth)) {
            iM10123getMinWidthimpl = Math.round(minWidth);
        }
        float maxWidth = resolvedStyleCurrentLayoutStyle.getMaxWidth();
        if (!Float.isNaN(maxWidth)) {
            iM10121getMaxWidthimpl = Math.round(maxWidth);
        }
        float minHeight = resolvedStyleCurrentLayoutStyle.getMinHeight();
        if (!Float.isNaN(minHeight)) {
            iM10122getMinHeightimpl = Math.round(minHeight);
        }
        float maxHeight = resolvedStyleCurrentLayoutStyle.getMaxHeight();
        if (!Float.isNaN(maxHeight)) {
            iRound3 = Math.round(maxHeight);
        }
        if (!Float.isNaN(resolvedStyleCurrentLayoutStyle.getWidth())) {
            iM10123getMinWidthimpl = Math.round(resolvedStyleCurrentLayoutStyle.getWidth());
        } else {
            if (!Float.isNaN(resolvedStyleCurrentLayoutStyle.getWidthFraction()) && Constraints.m10117getHasBoundedWidthimpl(j)) {
                int iRound4 = Math.round(iM10121getMaxWidthimpl * resolvedStyleCurrentLayoutStyle.getWidthFraction());
                if (iRound4 >= iM10123getMinWidthimpl) {
                    iM10123getMinWidthimpl = iRound4;
                }
                if (iM10123getMinWidthimpl > iM10121getMaxWidthimpl) {
                    iM10123getMinWidthimpl = iM10121getMaxWidthimpl;
                }
            } else if (!Float.isNaN(resolvedStyleCurrentLayoutStyle.getLeft()) && !Float.isNaN(resolvedStyleCurrentLayoutStyle.getRight())) {
                iM10123getMinWidthimpl = iM10121getMaxWidthimpl;
            }
            if (!Float.isNaN(resolvedStyleCurrentLayoutStyle.getHeight())) {
                iM10122getMinHeightimpl = Math.round(resolvedStyleCurrentLayoutStyle.getHeight());
            } else {
                if (Float.isNaN(resolvedStyleCurrentLayoutStyle.getHeightFraction()) && Constraints.m10116getHasBoundedHeightimpl(j)) {
                    int iRound5 = Math.round(iRound3 * resolvedStyleCurrentLayoutStyle.getHeightFraction());
                    if (iRound5 >= iM10122getMinHeightimpl) {
                        iM10122getMinHeightimpl = iRound5;
                    }
                    if (iM10122getMinHeightimpl > iRound3) {
                        iM10122getMinHeightimpl = iRound3;
                    }
                } else if (!Float.isNaN(resolvedStyleCurrentLayoutStyle.getTop()) && !Float.isNaN(resolvedStyleCurrentLayoutStyle.getBottom())) {
                    iM10122getMinHeightimpl = iRound3;
                }
                final Placeable placeableMo8808measureBRTryo0 = measurable.mo8808measureBRTryo0(ConstraintsKt.Constraints(iM10123getMinWidthimpl, iM10121getMaxWidthimpl, iM10122getMinHeightimpl, iRound3));
                return MeasureScope.layout$default(measureScope, placeableMo8808measureBRTryo0.getWidth() + iRound, placeableMo8808measureBRTryo0.getHeight() + iRound2, null, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StyleOuterNode.measure_3p2s80s$lambda$0(this.f$0, j, placeableMo8808measureBRTryo0, f2, f, f4, f3, (Placeable.PlacementScope) obj);
                    }
                }, 4, null);
            }
            iRound3 = iM10122getMinHeightimpl;
            final Placeable placeableMo8808measureBRTryo1 = measurable.mo8808measureBRTryo0(ConstraintsKt.Constraints(iM10123getMinWidthimpl, iM10121getMaxWidthimpl, iM10122getMinHeightimpl, iRound3));
            return MeasureScope.layout$default(measureScope, placeableMo8808measureBRTryo1.getWidth() + iRound, placeableMo8808measureBRTryo1.getHeight() + iRound2, null, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StyleOuterNode.measure_3p2s80s$lambda$0(this.f$0, j, placeableMo8808measureBRTryo1, f2, f, f4, f3, (Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        iM10121getMaxWidthimpl = iM10123getMinWidthimpl;
        if (!Float.isNaN(resolvedStyleCurrentLayoutStyle.getHeight())) {
            iM10122getMinHeightimpl = Math.round(resolvedStyleCurrentLayoutStyle.getHeight());
        } else {
            if (Float.isNaN(resolvedStyleCurrentLayoutStyle.getHeightFraction())) {
            }
            if (!Float.isNaN(resolvedStyleCurrentLayoutStyle.getTop())) {
                iM10122getMinHeightimpl = iRound3;
            }
            final Placeable placeableMo8808measureBRTryo2 = measurable.mo8808measureBRTryo0(ConstraintsKt.Constraints(iM10123getMinWidthimpl, iM10121getMaxWidthimpl, iM10122getMinHeightimpl, iRound3));
            return MeasureScope.layout$default(measureScope, placeableMo8808measureBRTryo2.getWidth() + iRound, placeableMo8808measureBRTryo2.getHeight() + iRound2, null, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StyleOuterNode.measure_3p2s80s$lambda$0(this.f$0, j, placeableMo8808measureBRTryo2, f2, f, f4, f3, (Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        iRound3 = iM10122getMinHeightimpl;
        final Placeable placeableMo8808measureBRTryo3 = measurable.mo8808measureBRTryo0(ConstraintsKt.Constraints(iM10123getMinWidthimpl, iM10121getMaxWidthimpl, iM10122getMinHeightimpl, iRound3));
        return MeasureScope.layout$default(measureScope, placeableMo8808measureBRTryo3.getWidth() + iRound, placeableMo8808measureBRTryo3.getHeight() + iRound2, null, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StyleOuterNode.measure_3p2s80s$lambda$0(this.f$0, j, placeableMo8808measureBRTryo3, f2, f, f4, f3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(StyleOuterNode styleOuterNode, long j, Placeable placeable, float f, float f2, float f3, float f4, Placeable.PlacementScope placementScope) {
        int iRound;
        int iRound2;
        ResolvedStyle resolvedStyleCurrentLayoutStyle = styleOuterNode.currentLayoutStyle();
        if (styleOuterNode.shouldPlaceRelativeToRight(resolvedStyleCurrentLayoutStyle)) {
            iRound = (Constraints.m10121getMaxWidthimpl(j) - placeable.getWidth()) - Math.round(f);
        } else {
            iRound = Math.round(f2);
        }
        int i = iRound;
        if (styleOuterNode.shouldPlaceRelativeToBottom(resolvedStyleCurrentLayoutStyle)) {
            iRound2 = (Constraints.m10120getMaxHeightimpl(j) - placeable.getHeight()) - Math.round(f3);
        } else {
            iRound2 = Math.round(f4);
        }
        int i2 = iRound2;
        if ((resolvedStyleCurrentLayoutStyle.flags & 4) != 0) {
            Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, i, i2, 0.0f, styleOuterNode.getLayerBlockNonNull$foundation(), 4, (Object) null);
        } else {
            Placeable.PlacementScope.place$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    private final boolean shouldPlaceRelativeToRight(ResolvedStyle resolvedStyle) {
        return !Float.isNaN(resolvedStyle.getRight()) && Float.isNaN(resolvedStyle.getLeft());
    }

    private final boolean shouldPlaceRelativeToBottom(ResolvedStyle resolvedStyle) {
        return !Float.isNaN(resolvedStyle.getBottom()) && Float.isNaN(resolvedStyle.getTop());
    }

    public final Function1<GraphicsLayerScope, Unit> getLayerBlock$foundation() {
        return this.layerBlock;
    }

    public final void setLayerBlock$foundation(Function1<? super GraphicsLayerScope, Unit> function1) {
        this.layerBlock = function1;
    }

    public final Function1<GraphicsLayerScope, Unit> getLayerBlockNonNull$foundation() {
        Function1 function1 = this.layerBlock;
        if (function1 != null) {
            return function1;
        }
        Function1<GraphicsLayerScope, Unit> function2 = new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StyleOuterNode._get_layerBlockNonNull_$lambda$0$0(this.f$0, (GraphicsLayerScope) obj);
            }
        };
        this.layerBlock = function2;
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_layerBlockNonNull_$lambda$0$0(StyleOuterNode styleOuterNode, GraphicsLayerScope graphicsLayerScope) {
        styleOuterNode.updateLayer(graphicsLayerScope);
        return Unit.INSTANCE;
    }

    private final void updateLayer(GraphicsLayerScope graphicsLayerScope) {
        ResolvedStyle resolvedStyleCurrentLayerStyle = currentLayerStyle();
        graphicsLayerScope.setAlpha(resolvedStyleCurrentLayerStyle.getAlpha());
        graphicsLayerScope.setScaleX(resolvedStyleCurrentLayerStyle.getScaleX());
        graphicsLayerScope.setScaleY(resolvedStyleCurrentLayerStyle.getScaleY());
        graphicsLayerScope.setTranslationX(resolvedStyleCurrentLayerStyle.getTranslationX());
        graphicsLayerScope.setTranslationY(resolvedStyleCurrentLayerStyle.getTranslationY());
        graphicsLayerScope.setRotationX(resolvedStyleCurrentLayerStyle.getRotationX());
        graphicsLayerScope.setRotationY(resolvedStyleCurrentLayerStyle.getRotationY());
        graphicsLayerScope.setRotationZ(resolvedStyleCurrentLayerStyle.getRotationZ());
        graphicsLayerScope.mo7539setTransformOrigin__ExYCQ(resolvedStyleCurrentLayerStyle.getTransformOrigin());
        graphicsLayerScope.setClip(resolvedStyleCurrentLayerStyle.getClip());
        graphicsLayerScope.setShape(resolvedStyleCurrentLayerStyle.getShape());
    }

    /* JADX INFO: renamed from: getOutline-12SF9DM, reason: not valid java name */
    private final Outline m2771getOutline12SF9DM(ContentDrawScope contentDrawScope, long j, Shape shape) {
        Outline outlineMo1614createOutlinePq9zytI;
        if (Size.m7138equalsimpl0(this.lastSize, j) && this.lastLayoutDirection == contentDrawScope.getLayoutDirection() && Intrinsics.areEqual(this.lastShape, shape)) {
            outlineMo1614createOutlinePq9zytI = this.lastOutline;
            Intrinsics.checkNotNull(outlineMo1614createOutlinePq9zytI);
        } else {
            outlineMo1614createOutlinePq9zytI = shape.mo1614createOutlinePq9zytI(j, contentDrawScope.getLayoutDirection(), contentDrawScope);
        }
        this.lastOutline = outlineMo1614createOutlinePq9zytI;
        this.lastSize = j;
        this.lastLayoutDirection = contentDrawScope.getLayoutDirection();
        return outlineMo1614createOutlinePq9zytI;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        ResolvedStyle resolvedStyleResolveAnimatedStyleFor$foundation$default = resolveAnimatedStyleFor$foundation$default(this, 2, null, 2, null);
        long backgroundColor = resolvedStyleResolveAnimatedStyleFor$foundation$default.getBackgroundColor();
        Brush backgroundBrush = resolvedStyleResolveAnimatedStyleFor$foundation$default.getBackgroundBrush();
        long foregroundColor = resolvedStyleResolveAnimatedStyleFor$foundation$default.getForegroundColor();
        Brush foregroundBrush = resolvedStyleResolveAnimatedStyleFor$foundation$default.getForegroundBrush();
        long borderColor = resolvedStyleResolveAnimatedStyleFor$foundation$default.getBorderColor();
        Brush borderBrush = resolvedStyleResolveAnimatedStyleFor$foundation$default.getBorderBrush();
        float borderWidth = resolvedStyleResolveAnimatedStyleFor$foundation$default.getBorderWidth();
        float f = borderWidth / 2.0f;
        Shape shape = resolvedStyleResolveAnimatedStyleFor$foundation$default.getShape();
        boolean z = true;
        boolean z2 = f > 0.0f;
        boolean z3 = (backgroundColor == 16 && backgroundBrush == null) ? false : true;
        if (foregroundColor == 16 && foregroundBrush == null) {
            z = false;
        }
        drawDropShadow(contentDrawScope, resolvedStyleResolveAnimatedStyleFor$foundation$default);
        m2773drawForShape9zt3ed4(contentDrawScope, shape, z3, z2, z, backgroundColor, backgroundBrush, borderColor, borderBrush, foregroundColor, foregroundBrush, borderWidth);
        drawInnerShadow(contentDrawScope, resolvedStyleResolveAnimatedStyleFor$foundation$default);
        this.lastShape = shape;
    }

    private final void drawInnerShadow(ContentDrawScope contentDrawScope, int i, Shape shape, Shadow shadow) {
        Shadow[] shadowArr = this.lastInnerShadow;
        Shadow shadow2 = shadowArr != null ? (Shadow) ArraysKt.getOrNull(shadowArr, i) : null;
        InnerShadowPainter[] innerShadowPainterArr = this.cachedInnerShadowPainters;
        InnerShadowPainter innerShadowPainterCreateInnerShadowPainter = innerShadowPainterArr != null ? (InnerShadowPainter) ArraysKt.getOrNull(innerShadowPainterArr, i) : null;
        if (!Intrinsics.areEqual(shadow2, shadow) || innerShadowPainterCreateInnerShadowPainter == null) {
            innerShadowPainterCreateInnerShadowPainter = DelegatableNodeKt.requireGraphicsContext(this).getShadowContext().createInnerShadowPainter(shape, shadow);
        }
        Shadow[] shadowArr2 = this.lastInnerShadow;
        if (shadowArr2 != null) {
            shadowArr2[i] = shadow;
        }
        InnerShadowPainter[] innerShadowPainterArr2 = this.cachedInnerShadowPainters;
        if (innerShadowPainterArr2 != null) {
            innerShadowPainterArr2[i] = innerShadowPainterCreateInnerShadowPainter;
        }
        Painter.m8037drawx_KDEd0$default(innerShadowPainterCreateInnerShadowPainter, contentDrawScope, contentDrawScope.mo7912getSizeNHjbRc(), 0.0f, null, 6, null);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0037  */
    /* JADX WARN: Code duplicated, block: B:19:0x003b A[LOOP:0: B:18:0x0039->B:19:0x003b, LOOP_END] */
    public final void reconcileInnerShadowCache(Object shadowOrArray, Shape shape) {
        InnerShadowPainter[] innerShadowPainterArr;
        Shadow[] shadowArr = this.lastInnerShadow;
        InnerShadowPainter[] innerShadowPainterArr2 = this.cachedInnerShadowPainters;
        int length = shadowOrArray instanceof Object[] ? ((Object[]) shadowOrArray).length : 1;
        int i = 0;
        if (shadowArr == null || !Intrinsics.areEqual(this.lastShape, shape)) {
            Shadow[] shadowArr2 = new Shadow[length];
            for (int i2 = 0; i2 < length; i2++) {
                shadowArr2[i2] = null;
            }
            this.lastInnerShadow = shadowArr2;
            InnerShadowPainter[] innerShadowPainterArr3 = new InnerShadowPainter[length];
            while (i < length) {
                innerShadowPainterArr3[i] = null;
                i++;
            }
            this.cachedInnerShadowPainters = innerShadowPainterArr3;
            return;
        }
        if (shadowArr.length != length) {
            Object[] objArrCopyOf = Arrays.copyOf(shadowArr, length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            this.lastInnerShadow = (Shadow[]) objArrCopyOf;
            if (innerShadowPainterArr2 != null) {
                Object[] objArrCopyOf2 = Arrays.copyOf(innerShadowPainterArr2, length);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
                innerShadowPainterArr = (InnerShadowPainter[]) objArrCopyOf2;
                if (innerShadowPainterArr == null) {
                    innerShadowPainterArr = new InnerShadowPainter[length];
                    while (i < length) {
                        innerShadowPainterArr[i] = null;
                        i++;
                    }
                }
            } else {
                innerShadowPainterArr = new InnerShadowPainter[length];
                while (i < length) {
                    innerShadowPainterArr[i] = null;
                    i++;
                }
            }
            this.cachedInnerShadowPainters = innerShadowPainterArr;
        }
    }

    public final void drawInnerShadow(ContentDrawScope contentDrawScope, ResolvedStyle resolvedStyle) {
        Object innerShadow = resolvedStyle.getInnerShadow();
        if (innerShadow == null) {
            return;
        }
        Shape shape = resolvedStyle.getShape();
        reconcileInnerShadowCache(innerShadow, shape);
        if (innerShadow instanceof Object[]) {
            Object[] objArr = (Object[]) innerShadow;
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                if (obj instanceof Shadow) {
                    drawInnerShadow(contentDrawScope, i, shape, (Shadow) obj);
                }
            }
            return;
        }
        if (innerShadow instanceof Shadow) {
            drawInnerShadow(contentDrawScope, 0, shape, (Shadow) innerShadow);
        }
    }

    private final void drawDropShadow(ContentDrawScope contentDrawScope, int i, Shape shape, Shadow shadow) {
        Shadow[] shadowArr = this.lastDropShadow;
        Shadow shadow2 = shadowArr != null ? (Shadow) ArraysKt.getOrNull(shadowArr, i) : null;
        DropShadowPainter[] dropShadowPainterArr = this.cachedDropShadowPainters;
        DropShadowPainter dropShadowPainterCreateDropShadowPainter = dropShadowPainterArr != null ? (DropShadowPainter) ArraysKt.getOrNull(dropShadowPainterArr, i) : null;
        if (!Intrinsics.areEqual(shadow2, shadow) || dropShadowPainterCreateDropShadowPainter == null) {
            dropShadowPainterCreateDropShadowPainter = DelegatableNodeKt.requireGraphicsContext(this).getShadowContext().createDropShadowPainter(shape, shadow);
        }
        Shadow[] shadowArr2 = this.lastDropShadow;
        if (shadowArr2 != null) {
            shadowArr2[i] = shadow;
        }
        DropShadowPainter[] dropShadowPainterArr2 = this.cachedDropShadowPainters;
        if (dropShadowPainterArr2 != null) {
            dropShadowPainterArr2[i] = dropShadowPainterCreateDropShadowPainter;
        }
        Painter.m8037drawx_KDEd0$default(dropShadowPainterCreateDropShadowPainter, contentDrawScope, contentDrawScope.mo7912getSizeNHjbRc(), 0.0f, null, 6, null);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0037  */
    /* JADX WARN: Code duplicated, block: B:19:0x003b A[LOOP:0: B:18:0x0039->B:19:0x003b, LOOP_END] */
    public final void reconcileDropShadowCache(Object shadowOrArray, Shape shape) {
        DropShadowPainter[] dropShadowPainterArr;
        Shadow[] shadowArr = this.lastDropShadow;
        DropShadowPainter[] dropShadowPainterArr2 = this.cachedDropShadowPainters;
        int length = shadowOrArray instanceof Object[] ? ((Object[]) shadowOrArray).length : 1;
        int i = 0;
        if (shadowArr == null || !Intrinsics.areEqual(this.lastShape, shape)) {
            Shadow[] shadowArr2 = new Shadow[length];
            for (int i2 = 0; i2 < length; i2++) {
                shadowArr2[i2] = null;
            }
            this.lastDropShadow = shadowArr2;
            DropShadowPainter[] dropShadowPainterArr3 = new DropShadowPainter[length];
            while (i < length) {
                dropShadowPainterArr3[i] = null;
                i++;
            }
            this.cachedDropShadowPainters = dropShadowPainterArr3;
            return;
        }
        if (shadowArr.length != length) {
            Object[] objArrCopyOf = Arrays.copyOf(shadowArr, length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            this.lastDropShadow = (Shadow[]) objArrCopyOf;
            if (dropShadowPainterArr2 != null) {
                Object[] objArrCopyOf2 = Arrays.copyOf(dropShadowPainterArr2, length);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
                dropShadowPainterArr = (DropShadowPainter[]) objArrCopyOf2;
                if (dropShadowPainterArr == null) {
                    dropShadowPainterArr = new DropShadowPainter[length];
                    while (i < length) {
                        dropShadowPainterArr[i] = null;
                        i++;
                    }
                }
            } else {
                dropShadowPainterArr = new DropShadowPainter[length];
                while (i < length) {
                    dropShadowPainterArr[i] = null;
                    i++;
                }
            }
            this.cachedDropShadowPainters = dropShadowPainterArr;
        }
    }

    public final void drawDropShadow(ContentDrawScope contentDrawScope, ResolvedStyle resolvedStyle) {
        Object dropShadow = resolvedStyle.getDropShadow();
        if (dropShadow == null) {
            return;
        }
        Shape shape = resolvedStyle.getShape();
        reconcileDropShadowCache(dropShadow, shape);
        if (dropShadow instanceof Object[]) {
            Object[] objArr = (Object[]) dropShadow;
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                if (obj instanceof Shadow) {
                    drawDropShadow(contentDrawScope, i, shape, (Shadow) obj);
                }
            }
            return;
        }
        if (dropShadow instanceof Shadow) {
            drawDropShadow(contentDrawScope, 0, shape, (Shadow) dropShadow);
        }
    }

    /* JADX INFO: renamed from: drawForShape-9zt3ed4, reason: not valid java name */
    public final void m2773drawForShape9zt3ed4(ContentDrawScope contentDrawScope, Shape shape, boolean z, boolean z2, boolean z3, long j, Brush brush, long j2, Brush brush2, long j3, Brush brush3, final float f) {
        Outline outlineM2771getOutline12SF9DM = m2771getOutline12SF9DM(contentDrawScope, contentDrawScope.mo7912getSizeNHjbRc(), shape);
        if (z) {
            if (brush != null) {
                OutlineKt.m7609drawOutlinehn5TExg$default(contentDrawScope, outlineM2771getOutline12SF9DM, brush, 0.0f, null, null, 0, 60, null);
            } else {
                OutlineKt.m7611drawOutlinewDX37Ww$default(contentDrawScope, outlineM2771getOutline12SF9DM, j, 0.0f, null, null, 0, 60, null);
            }
        }
        contentDrawScope.drawContent();
        if (z3) {
            if (brush3 != null) {
                OutlineKt.m7609drawOutlinehn5TExg$default(contentDrawScope, outlineM2771getOutline12SF9DM, brush3, 0.0f, null, null, 0, 60, null);
            } else {
                OutlineKt.m7611drawOutlinewDX37Ww$default(contentDrawScope, outlineM2771getOutline12SF9DM, j3, 0.0f, null, null, 0, 60, null);
            }
        }
        if (z2) {
            SolidColor solidColor = brush2 == null ? new SolidColor(j2, null) : brush2;
            BorderLogic borderLogic = this.borderLogic;
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            Function0 function0 = new Function0() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(StyleOuterNode.drawForShape_9zt3ed4$lambda$0(f));
                }
            };
            Function0<GraphicsLayer> function1 = this.borderLayerProvider;
            if (function1 == null) {
                function1 = new Function0() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StyleOuterNode.drawForShape_9zt3ed4$lambda$1(this.f$0);
                    }
                };
                this.borderLayerProvider = function1;
                Unit unit = Unit.INSTANCE;
            }
            borderLogic.m1680drawBorder2gY9BTk$foundation(contentDrawScope2, function0, solidColor, function1, outlineM2771getOutline12SF9DM, (32 & 32) != 0 ? Offset.INSTANCE.m7089getZeroF1C5BW0() : 0L);
        }
    }

    static final GraphicsLayer drawForShape_9zt3ed4$lambda$1(StyleOuterNode styleOuterNode) {
        GraphicsLayer graphicsLayer = styleOuterNode.borderLayer;
        if (graphicsLayer != null) {
            return graphicsLayer;
        }
        GraphicsLayer graphicsLayerCreateGraphicsLayer = DelegatableNodeKt.requireGraphicsContext(styleOuterNode).createGraphicsLayer();
        styleOuterNode.borderLayer = graphicsLayerCreateGraphicsLayer;
        return graphicsLayerCreateGraphicsLayer;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return StyleModifierKt.OuterNodeKey;
    }

    public static /* synthetic */ void resolveStyleAndInvalidate$default(StyleOuterNode styleOuterNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        styleOuterNode.resolveStyleAndInvalidate(z);
    }

    public final void resolveStyleAndInvalidate(final boolean initial) {
        if (getIsAttached()) {
            final ResolvedStyle resolvedStyle = initial ? null : this._resolved;
            final ResolvedStyle bufferNonNull = initial ? this._resolved : getBufferNonNull();
            final Density densityRequireDensity = DelegatableNodeKt.requireDensity(this);
            bufferNonNull.clear$foundation();
            StyleAnimations styleAnimations = this.animations;
            if (styleAnimations != null) {
                styleAnimations.preResolve();
            }
            final Ref.IntRef intRef = new Ref.IntRef();
            ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StyleOuterNode.resolveStyleAndInvalidate$lambda$0(bufferNonNull, this, densityRequireDensity, resolvedStyle, intRef, initial);
                }
            });
            int iDiff$foundation$default = intRef.element | (resolvedStyle != null ? ResolvedStyle.diff$foundation$default(resolvedStyle, bufferNonNull, 0, 2, null) : bufferNonNull.flags);
            if (!Intrinsics.areEqual(this._state.getInteractionSource(), this.currentInteractionSource)) {
                updateInteractionSources();
            }
            if (initial) {
                return;
            }
            if ((iDiff$foundation$default & 1) != 0) {
                LayoutModifierNodeKt.invalidateMeasurement(getInnerNode$foundation());
            }
            if ((iDiff$foundation$default & 8) != 0) {
                LayoutModifierNodeKt.invalidateMeasurement(this);
            }
            if ((iDiff$foundation$default & 2) != 0) {
                LayoutModifierNodeKt.invalidateLayer(getInnerNode$foundation());
            }
            if ((iDiff$foundation$default & 4) != 0) {
                LayoutModifierNodeKt.updateLayerBlock(this, getLayerBlockNonNull$foundation());
            }
            if ((iDiff$foundation$default & 32) != 0) {
                invalidateTextLayout();
            }
            if ((iDiff$foundation$default & 64) != 0) {
                invalidateTextDraw();
            }
        }
    }

    static final Unit resolveStyleAndInvalidate$lambda$0(ResolvedStyle resolvedStyle, StyleOuterNode styleOuterNode, Density density, ResolvedStyle resolvedStyle2, Ref.IntRef intRef, boolean z) {
        resolvedStyle.resolve$foundation(styleOuterNode.style, styleOuterNode, density, false);
        styleOuterNode._resolved = resolvedStyle;
        styleOuterNode._bufferOrNull = resolvedStyle2;
        StyleAnimations styleAnimations = styleOuterNode.animations;
        intRef.element = styleAnimations != null ? styleAnimations.postResolve(styleOuterNode, density, !z) : 0;
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        resolveStyleAndInvalidate$default(this, false, 1, null);
    }

    public final Job getSourceJob() {
        return this.sourceJob;
    }

    public final void setSourceJob(Job job) {
        this.sourceJob = job;
    }

    public final void updateInteractionSources() {
        Job job = this.sourceJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        InteractionSource interactionSource = this._state.getInteractionSource();
        this.currentInteractionSource = interactionSource;
        if (interactionSource != null) {
            this.sourceJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(interactionSource, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.style.StyleOuterNode$updateInteractionSources$1, reason: invalid class name */
    /* JADX INFO: compiled from: StyleModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.style.StyleOuterNode$updateInteractionSources$1", f = "StyleModifier.kt", i = {}, l = {715}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InteractionSource $source;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InteractionSource interactionSource, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$source = interactionSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StyleOuterNode.this.new AnonymousClass1(this.$source, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (StyleOuterNode.this._state.processInteractions$foundation(this.$source, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionLocalAccessorScope
    public <T> T getCurrentValue(CompositionLocal<T> compositionLocal) {
        return (T) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, compositionLocal);
    }

    @Override // androidx.compose.foundation.text.modifiers.TextStyleProviderNode
    /* JADX INFO: renamed from: computeInheritedTextStyle-B-LjeIk, reason: not valid java name */
    public TextStyle mo2772computeInheritedTextStyleBLjeIk(int phase, TextStyle fallback) {
        TextStyle textStyle$foundation;
        ResolvedStyle resolvedStyleResolveInheritedStyle$foundation = resolveInheritedStyle$foundation(StyleModifierKt.m2770toFlagsuwmK9pY(phase));
        return (resolvedStyleResolveInheritedStyle$foundation == null || (textStyle$foundation = resolvedStyleResolveInheritedStyle$foundation.toTextStyle$foundation(fallback)) == null) ? fallback : textStyle$foundation;
    }

    public final MutableObjectList<StyleOuterNode> getAncestorNodes$foundation() {
        return this.ancestorNodes;
    }

    public final void setAncestorNodes$foundation(MutableObjectList<StyleOuterNode> mutableObjectList) {
        this.ancestorNodes = mutableObjectList;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0082  */
    /* JADX WARN: Code duplicated, block: B:77:0x0105  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, androidx.collection.MutableObjectList<androidx.compose.foundation.style.StyleOuterNode>] */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, androidx.collection.MutableObjectList, androidx.collection.MutableObjectList<androidx.compose.foundation.style.StyleOuterNode>] */
    public final ResolvedStyle resolveInheritedStyle$foundation(int flags) {
        StyleOuterNode styleOuterNode;
        StyleOuterNode styleOuterNode2;
        StyleAnimations styleAnimations;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = this.ancestorNodes;
        if ((this._resolved.flags & 96) != 0 || ((styleAnimations = this.animations) != null && styleAnimations.isNotEmpty())) {
            MutableObjectList mutableObjectList = (MutableObjectList) objectRef.element;
            MutableObjectList mutableObjectList2 = mutableObjectList;
            if (mutableObjectList == null) {
                ?? mutableObjectList3 = new MutableObjectList(0, 1, null);
                objectRef.element = mutableObjectList3;
                this.ancestorNodes = mutableObjectList3;
                mutableObjectList2 = mutableObjectList3;
            }
            mutableObjectList2.add(this);
        }
        StyleOuterNode styleOuterNode3 = this;
        TraversableNodeKt.traverseAncestors(styleOuterNode3, StyleModifierKt.OuterNodeKey, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StyleOuterNode.resolveInheritedStyle$lambda$1(objectRef, this, (TraversableNode) obj));
            }
        });
        ResolvedStyle cachedInheritedStyle$foundation = getCachedInheritedStyle$foundation();
        int size = cachedInheritedStyle$foundation != null ? -1 : -2;
        StyleAnimations styleAnimations2 = this.animations;
        boolean zIsNotEmpty = styleAnimations2 != null ? styleAnimations2.isNotEmpty() : false;
        int i = this._resolved.flags & 96;
        MutableObjectList mutableObjectList4 = (MutableObjectList) objectRef.element;
        if (mutableObjectList4 != null) {
            MutableObjectList mutableObjectList5 = mutableObjectList4;
            Object[] objArr = mutableObjectList5.content;
            int i2 = mutableObjectList5._size;
            for (int i3 = 0; i3 < i2; i3++) {
                StyleOuterNode styleOuterNode4 = (StyleOuterNode) objArr[i3];
                ResolvedStyle cachedInheritedStyle$foundation2 = styleOuterNode4.getCachedInheritedStyle$foundation();
                if (zIsNotEmpty) {
                    zIsNotEmpty = true;
                } else {
                    StyleAnimations styleAnimations3 = styleOuterNode4.animations;
                    if (styleAnimations3 != null ? styleAnimations3.isNotEmpty() : false) {
                        zIsNotEmpty = true;
                    } else {
                        zIsNotEmpty = false;
                    }
                }
                i |= styleOuterNode4._resolved.flags & 96;
                if (cachedInheritedStyle$foundation2 == null) {
                    cachedInheritedStyle$foundation = null;
                    size = -2;
                } else if (cachedInheritedStyle$foundation == null) {
                    size = i3;
                    cachedInheritedStyle$foundation = cachedInheritedStyle$foundation2;
                }
            }
        }
        if (i == 0) {
            return null;
        }
        if (cachedInheritedStyle$foundation != null && size < 0 && !zIsNotEmpty) {
            return cachedInheritedStyle$foundation;
        }
        if (objectRef.element != 0 && size < -1) {
            size = ((MutableObjectList) objectRef.element).getSize() - 1;
        }
        while (-2 < size) {
            if (size < 0) {
                styleOuterNode2 = this;
            } else {
                MutableObjectList mutableObjectList6 = (MutableObjectList) objectRef.element;
                if (mutableObjectList6 != null) {
                    styleOuterNode2 = (StyleOuterNode) mutableObjectList6.get(size);
                }
                size--;
            }
            ResolvedStyle resolvedStyle = styleOuterNode2.cachedInheritedStyle;
            if (resolvedStyle == null) {
                resolvedStyle = new ResolvedStyle();
            }
            if (cachedInheritedStyle$foundation != null) {
                cachedInheritedStyle$foundation.copyInheritedStylesInto$foundation(resolvedStyle);
            }
            resolvedStyle.applyInheritableStyles$foundation(styleOuterNode2._resolved);
            styleOuterNode2.saveInheritedStyles$foundation(resolvedStyle);
            cachedInheritedStyle$foundation = resolvedStyle;
            size--;
        }
        if (!zIsNotEmpty) {
            return cachedInheritedStyle$foundation;
        }
        ResolvedStyle resolvedStyle2 = new ResolvedStyle();
        if (cachedInheritedStyle$foundation != null) {
            cachedInheritedStyle$foundation.copyInheritedStylesInto$foundation(resolvedStyle2);
        }
        MutableObjectList mutableObjectList7 = (MutableObjectList) objectRef.element;
        int size2 = mutableObjectList7 != null ? mutableObjectList7.getSize() : 0;
        Density densityRequireDensity = DelegatableNodeKt.requireDensity(styleOuterNode3);
        for (int i4 = size2 - 1; -2 < i4; i4--) {
            if (i4 < 0) {
                styleOuterNode = this;
            } else {
                MutableObjectList mutableObjectList8 = (MutableObjectList) objectRef.element;
                if (mutableObjectList8 != null) {
                    styleOuterNode = (StyleOuterNode) mutableObjectList8.get(i4);
                }
            }
            StyleAnimations styleAnimations4 = styleOuterNode.animations;
            if (styleAnimations4 != null) {
                styleAnimations4.applyAnimationsTo(resolvedStyle2, densityRequireDensity, styleOuterNode, flags);
            }
        }
        return resolvedStyle2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, androidx.collection.MutableObjectList, androidx.collection.MutableObjectList<androidx.compose.foundation.style.StyleOuterNode>] */
    static final boolean resolveInheritedStyle$lambda$1(Ref.ObjectRef objectRef, StyleOuterNode styleOuterNode, TraversableNode traversableNode) {
        StyleAnimations styleAnimations;
        if (!(traversableNode instanceof StyleOuterNode)) {
            return true;
        }
        StyleOuterNode styleOuterNode2 = (StyleOuterNode) traversableNode;
        if ((styleOuterNode2._resolved.flags & 96) != 0 || ((styleAnimations = styleOuterNode2.animations) != null && styleAnimations.isNotEmpty())) {
            MutableObjectList mutableObjectList = (MutableObjectList) objectRef.element;
            MutableObjectList mutableObjectList2 = mutableObjectList;
            if (mutableObjectList == null) {
                ?? mutableObjectList3 = new MutableObjectList(0, 1, null);
                objectRef.element = mutableObjectList3;
                styleOuterNode.ancestorNodes = mutableObjectList3;
                mutableObjectList2 = mutableObjectList3;
            }
            mutableObjectList2.add(traversableNode);
        }
        return true;
    }

    public final ResolvedStyle getCachedInheritedStyle$foundation() {
        if (this.inheritedStyleDirty) {
            return null;
        }
        return this.cachedInheritedStyle;
    }

    public final void saveInheritedStyles$foundation(ResolvedStyle style) {
        this.inheritedStyleDirty = false;
        this.cachedInheritedStyle = style;
    }

    private final void invalidateTextLayout() {
        this.inheritedStyleDirty = true;
        DelegatableNodeKt.invalidateMeasurementForSubtree(this);
    }

    private final void invalidateTextDraw() {
        this.inheritedStyleDirty = true;
        DelegatableNodeKt.invalidateDrawForSubtree(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        GraphicsLayer graphicsLayer = this.borderLayer;
        if (graphicsLayer != null) {
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer);
            this.borderLayer = null;
        }
        this.borderLayerProvider = null;
    }
}
