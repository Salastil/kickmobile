package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.internal.DraggableAnchorsKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationRailBaselineItemTokens;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailExpandedTokens;
import androidx.compose.material3.tokens.NavigationRailHorizontalItemTokens;
import androidx.compose.material3.tokens.NavigationRailVerticalItemTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u001a}\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0014\u001as\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0015\u001au\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\u001a\u001a§\u0001\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b#\u0010$\u001a\u009d\u0001\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010!\u001a\u00020\"2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b%\u0010&\u001a\u0093\u0001\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00182\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010,\u001a\u00020\u00182\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00182\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\b\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u00020\u0012H\u0007¢\u0006\u0004\b4\u00105\u001a\u0089\u0001\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00182\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010,\u001a\u00020\u00182\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00182\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\b\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u000102H\u0007¢\u0006\u0004\b6\u00107\u001a\u008b\u0001\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00182\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00182\b\b\u0002\u0010,\u001a\u00020\u00182\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\b\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u000102H\u0007¢\u0006\u0004\b6\u00108\u001aÉ\u0001\u00109\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u00182\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<2\u0006\u0010?\u001a\u00020@2\u001c\u0010A\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010C\u0012\u0006\u0012\u0004\u0018\u00010D0B2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010E\u001a\u00020F2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010G\u001a\u00020 2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\bI\u0010J\u001a\u001c\u0010K\u001a\u00020=*\u00020L2\u0006\u0010M\u001a\u00020=2\u0006\u0010N\u001a\u00020\u0018H\u0002\u001a\u0014\u0010O\u001a\u00020=*\u00020L2\u0006\u0010M\u001a\u00020=H\u0002\"\u0016\u0010P\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010S\u001a\u0004\bQ\u0010R\"\u0016\u0010T\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010S\u001a\u0004\bU\u0010R\"\u0010\u0010V\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010S\"\u0010\u0010W\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010S\"\u0010\u0010X\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010S\"\u0010\u0010Y\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010S\"\u0010\u0010Z\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010S\"\u0010\u0010[\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010S\"\u0010\u0010\\\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010S\"\u0010\u0010]\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010S\"\u0010\u0010^\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010S\"\u0010\u0010_\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010S\"\u0010\u0010`\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010S\"\u000e\u0010a\u001a\u00020=X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010b\u001a\u00020cX\u0082T¢\u0006\u0002\n\u0000\"\"\u0010d\u001a\b\u0012\u0004\u0012\u00020f0e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\"\u0010k\u001a\b\u0012\u0004\u0012\u00020l0e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bm\u0010h\u001a\u0004\bn\u0010j¨\u0006o²\u0006\n\u0010p\u001a\u00020qX\u008a\u008e\u0002²\u0006\n\u0010r\u001a\u00020qX\u008a\u008e\u0002²\u0006\n\u0010s\u001a\u00020 X\u008a\u0084\u0002²\u0006\n\u0010t\u001a\u00020 X\u008a\u0084\u0002²\u0006\n\u0010u\u001a\u00020 X\u008a\u0084\u0002²\u0006\n\u0010v\u001a\u00020 X\u008a\u0084\u0002"}, d2 = {"WideNavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/WideNavigationRailState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/WideNavigationRailColors;", WideNavigationRailKt.HeaderLayoutIdTag, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "WideNavigationRailLayout", "isModal", "", "expanded", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/WideNavigationRailColors;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ModalWideNavigationRail", "hideOnCollapse", "collapsedShape", "expandedShape", "expandedHeaderTopPadding", "Landroidx/compose/ui/unit/Dp;", "expandedProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "ModalWideNavigationRail-xKBSf-U", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/material3/ModalWideNavigationRailProperties;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "ModalWideNavigationRail-k3FuEkE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/material3/ModalWideNavigationRailProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "WideNavigationRailItem", "selected", ViewProps.ON_CLICK, "icon", "label", "railExpanded", "enabled", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicatorPadding", "WideNavigationRailItem-U_vOP4k", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/Modifier;ZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "WideNavigationRailItem-pli-t6k", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/Modifier;ZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ModalWideNavigationRailContent", "isStandaloneModal", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "modalAnimateToDismiss", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "railState", "Landroidx/compose/material3/ModalWideNavigationRailState;", "openModalRailMaxWidth", "gesturesEnabled", "ModalWideNavigationRailContent-_zuB-KE", "(ZZLandroidx/compose/animation/core/Animatable;Landroidx/compose/material3/RailPredictiveBackState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ModalWideNavigationRailState;Landroidx/compose/material3/WideNavigationRailColors;Landroidx/compose/ui/graphics/Shape;FLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "swipeEdgeMatchesRail", "calculatePredictiveBackScaleY", "WNRItemNoLabelIndicatorPadding", "getWNRItemNoLabelIndicatorPadding", "()F", "F", "WNRItemHorizontalPadding", "getWNRItemHorizontalPadding", "WNRVerticalPadding", "WNRHeaderPadding", "CollapsedRailWidth", "ExpandedRailMinWidth", "ExpandedRailMaxWidth", "TopIconItemMinHeight", "ItemTopIconIndicatorVerticalPadding", "ItemTopIconIndicatorHorizontalPadding", "ItemStartIconIndicatorVerticalPadding", "PredictiveBackMaxScaleXDistance", "PredictiveBackMaxScaleYDistance", "PredictiveBackPivotFractionY", "HeaderLayoutIdTag", "", "LocalWideNavigationRailOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/WideNavigationRailOverride;", "getLocalWideNavigationRailOverride$annotations", "()V", "getLocalWideNavigationRailOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalModalWideNavigationRailOverride", "Landroidx/compose/material3/ModalWideNavigationRailOverride;", "getLocalModalWideNavigationRailOverride$annotations", "getLocalModalWideNavigationRailOverride", "material3", "currentWidth", "", "actualMaxExpandedWidth", ViewProps.MIN_WIDTH, "widthFullRange", "itemVerticalSpacedBy", "itemMinHeight"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class WideNavigationRailKt {
    private static final String HeaderLayoutIdTag = "header";
    private static final float PredictiveBackPivotFractionY = 0.5f;
    private static final float WNRItemNoLabelIndicatorPadding = Dp.m10168constructorimpl(Dp.m10168constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m6000getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5983getIconSizeD9Ej5fM()) / 2.0f);
    private static final float WNRItemHorizontalPadding = Dp.m10168constructorimpl(20.0f);
    private static final float WNRVerticalPadding = NavigationRailCollapsedTokens.INSTANCE.m5988getTopSpaceD9Ej5fM();
    private static final float WNRHeaderPadding = NavigationRailBaselineItemTokens.INSTANCE.m5982getHeaderSpaceMinimumD9Ej5fM();
    private static final float CollapsedRailWidth = NavigationRailCollapsedTokens.INSTANCE.m5985getContainerWidthD9Ej5fM();
    private static final float ExpandedRailMinWidth = NavigationRailExpandedTokens.INSTANCE.m5991getContainerWidthMinimumD9Ej5fM();
    private static final float ExpandedRailMaxWidth = NavigationRailExpandedTokens.INSTANCE.m5990getContainerWidthMaximumD9Ej5fM();
    private static final float TopIconItemMinHeight = NavigationRailBaselineItemTokens.INSTANCE.m5980getContainerHeightD9Ej5fM();
    private static final float ItemTopIconIndicatorVerticalPadding = Dp.m10168constructorimpl(Dp.m10168constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5999getActiveIndicatorHeightD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5983getIconSizeD9Ej5fM()) / 2.0f);
    private static final float ItemTopIconIndicatorHorizontalPadding = Dp.m10168constructorimpl(Dp.m10168constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m6000getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5983getIconSizeD9Ej5fM()) / 2.0f);
    private static final float ItemStartIconIndicatorVerticalPadding = Dp.m10168constructorimpl(Dp.m10168constructorimpl(NavigationRailHorizontalItemTokens.INSTANCE.m5994getActiveIndicatorHeightD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5983getIconSizeD9Ej5fM()) / 2.0f);
    private static final float PredictiveBackMaxScaleXDistance = Dp.m10168constructorimpl(24.0f);
    private static final float PredictiveBackMaxScaleYDistance = Dp.m10168constructorimpl(48.0f);
    private static final ProvidableCompositionLocal<WideNavigationRailOverride> LocalWideNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda16
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DefaultWideNavigationRailOverride.INSTANCE;
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<ModalWideNavigationRailOverride> LocalModalWideNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda17
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DefaultModalWideNavigationRailOverride.INSTANCE;
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ModalWideNavigationRailContent__zuB_KE$lambda$0$0(float f) {
        return f * 0.5f;
    }

    static final Unit ModalWideNavigationRailContent__zuB_KE$lambda$6(boolean z, boolean z2, Animatable animatable, RailPredictiveBackState railPredictiveBackState, Function1 function1, Modifier modifier, ModalWideNavigationRailState modalWideNavigationRailState, WideNavigationRailColors wideNavigationRailColors, Shape shape, float f, Function2 function2, WindowInsets windowInsets, boolean z3, Arrangement.Vertical vertical, PaddingValues paddingValues, Function2 function3, int i, int i2, Composer composer, int i3) {
        m5250ModalWideNavigationRailContent_zuBKE(z, z2, animatable, railPredictiveBackState, function1, modifier, modalWideNavigationRailState, wideNavigationRailColors, shape, f, function2, windowInsets, z3, vertical, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRail_k3FuEkE$lambda$0(Modifier modifier, WideNavigationRailState wideNavigationRailState, boolean z, Shape shape, Shape shape2, WideNavigationRailColors wideNavigationRailColors, Function2 function2, float f, WindowInsets windowInsets, Arrangement.Vertical vertical, ModalWideNavigationRailProperties modalWideNavigationRailProperties, Function2 function3, int i, int i2, int i3, Composer composer, int i4) {
        m5248ModalWideNavigationRailk3FuEkE(modifier, wideNavigationRailState, z, shape, shape2, wideNavigationRailColors, function2, f, windowInsets, vertical, modalWideNavigationRailProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRail_xKBSf_U$lambda$1(Modifier modifier, WideNavigationRailState wideNavigationRailState, boolean z, Shape shape, Shape shape2, WideNavigationRailColors wideNavigationRailColors, Function2 function2, float f, WindowInsets windowInsets, Arrangement.Vertical vertical, ModalWideNavigationRailProperties modalWideNavigationRailProperties, PaddingValues paddingValues, Function2 function3, int i, int i2, int i3, Composer composer, int i4) {
        m5249ModalWideNavigationRailxKBSfU(modifier, wideNavigationRailState, z, shape, shape2, wideNavigationRailColors, function2, f, windowInsets, vertical, modalWideNavigationRailProperties, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit WideNavigationRail$lambda$1(Modifier modifier, WideNavigationRailState wideNavigationRailState, Shape shape, WideNavigationRailColors wideNavigationRailColors, Function2 function2, WindowInsets windowInsets, Arrangement.Vertical vertical, PaddingValues paddingValues, Function2 function3, int i, int i2, Composer composer, int i3) {
        WideNavigationRail(modifier, wideNavigationRailState, shape, wideNavigationRailColors, function2, windowInsets, vertical, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit WideNavigationRail$lambda$2(Modifier modifier, WideNavigationRailState wideNavigationRailState, Shape shape, WideNavigationRailColors wideNavigationRailColors, Function2 function2, WindowInsets windowInsets, Arrangement.Vertical vertical, Function2 function3, int i, int i2, Composer composer, int i3) {
        WideNavigationRail(modifier, wideNavigationRailState, shape, wideNavigationRailColors, function2, windowInsets, vertical, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit WideNavigationRailItem_U_vOP4k$lambda$1(boolean z, Function0 function0, Function2 function2, Function2 function3, boolean z2, Modifier modifier, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, PaddingValues paddingValues, int i2, int i3, int i4, Composer composer, int i5) {
        m5251WideNavigationRailItemU_vOP4k(z, function0, function2, function3, z2, modifier, z3, i, navigationItemColors, mutableInteractionSource, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    static final Unit WideNavigationRailItem_pli_t6k$lambda$0(boolean z, Function0 function0, Function2 function2, Function2 function3, boolean z2, Modifier modifier, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        m5253WideNavigationRailItemplit6k(z, function0, function2, function3, z2, modifier, z3, i, navigationItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit WideNavigationRailItem_pli_t6k$lambda$1(boolean z, Function0 function0, Function2 function2, Function2 function3, Modifier modifier, boolean z2, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        m5252WideNavigationRailItemplit6k(z, function0, function2, function3, modifier, z2, z3, i, navigationItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit WideNavigationRailLayout$lambda$11(Modifier modifier, boolean z, boolean z2, WideNavigationRailColors wideNavigationRailColors, Shape shape, Function2 function2, WindowInsets windowInsets, Arrangement.Vertical vertical, PaddingValues paddingValues, Function2 function3, int i, Composer composer, int i2) {
        WideNavigationRailLayout(modifier, z, z2, wideNavigationRailColors, shape, function2, windowInsets, vertical, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getLocalModalWideNavigationRailOverride$annotations() {
    }

    public static /* synthetic */ void getLocalWideNavigationRailOverride$annotations() {
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0118  */
    /* JADX WARN: Code duplicated, block: B:101:0x011a  */
    /* JADX WARN: Code duplicated, block: B:104:0x0123  */
    /* JADX WARN: Code duplicated, block: B:106:0x0135  */
    /* JADX WARN: Code duplicated, block: B:126:0x016e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0170  */
    /* JADX WARN: Code duplicated, block: B:130:0x017c  */
    /* JADX WARN: Code duplicated, block: B:131:0x0184  */
    /* JADX WARN: Code duplicated, block: B:134:0x018b  */
    /* JADX WARN: Code duplicated, block: B:137:0x0198  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:142:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:145:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:147:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:151:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:154:0x0215  */
    /* JADX WARN: Code duplicated, block: B:156:0x022a  */
    /* JADX WARN: Code duplicated, block: B:159:0x023d  */
    /* JADX WARN: Code duplicated, block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00df  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:88:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:93:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:95:0x0104  */
    /* JADX WARN: Code duplicated, block: B:96:0x0107  */
    public static final void WideNavigationRail(Modifier modifier, WideNavigationRailState wideNavigationRailState, Shape shape, WideNavigationRailColors wideNavigationRailColors, Function2<? super Composer, ? super Integer, Unit> function2, WindowInsets windowInsets, Arrangement.Vertical vertical, PaddingValues paddingValues, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        WideNavigationRailColors wideNavigationRailColorsColors;
        Function2<? super Composer, ? super Integer, Unit> function4;
        WindowInsets windowInsets2;
        Arrangement.Vertical arrangement;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        boolean z;
        final Modifier modifier3;
        final Shape shape3;
        final WideNavigationRailColors wideNavigationRailColors2;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final WindowInsets windowInsets3;
        final Arrangement.Vertical vertical2;
        final PaddingValues paddingValues3;
        final WideNavigationRailState wideNavigationRailState2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        WideNavigationRailState wideNavigationRailStateRememberWideNavigationRailState;
        WideNavigationRailState wideNavigationRailState3;
        PaddingValues contentPadding;
        Modifier modifier4;
        Shape shape4;
        WideNavigationRailColors wideNavigationRailColors3;
        Function2<? super Composer, ? super Integer, Unit> function6;
        WindowInsets windowInsets4;
        Arrangement.Vertical vertical3;
        int i6;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-477658179);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRail)N(modifier,state,shape,colors,header,windowInsets,arrangement,contentPadding,content)173@8701L7,*185@9117L20:WideNavigationRail.kt#uh7d8r");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) != 0) {
                i7 = 16;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(wideNavigationRailState) : composerStartRestartGroup.changedInstance(wideNavigationRailState)) {
                    i7 = 32;
                } else {
                    i7 = 16;
                }
            }
            i3 |= i7;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                int i9 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            i3 |= i9;
        } else {
            shape2 = shape;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                wideNavigationRailColorsColors = wideNavigationRailColors;
                int i10 = composerStartRestartGroup.changed(wideNavigationRailColorsColors) ? 2048 : 1024;
                i3 |= i10;
            } else {
                wideNavigationRailColorsColors = wideNavigationRailColors;
            }
            i3 |= i10;
        } else {
            wideNavigationRailColorsColors = wideNavigationRailColors;
        }
        int i11 = i2 & 16;
        if (i11 == 0) {
            if ((i & 24576) == 0) {
                function4 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    windowInsets2 = windowInsets;
                    int i12 = composerStartRestartGroup.changed(windowInsets2) ? 131072 : 65536;
                    i3 |= i12;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    arrangement = vertical;
                    int i13 = composerStartRestartGroup.changed(arrangement) ? 1048576 : 524288;
                    i3 |= i13;
                } else {
                    arrangement = vertical;
                }
                i3 |= i13;
            } else {
                arrangement = vertical;
            }
            i4 = i2 & 128;
            if (i4 != 0) {
                if ((12582912 & i) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i5 = 8388608;
                    } else {
                        i5 = 4194304;
                    }
                    i3 |= i5;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i6 = 67108864;
                    } else {
                        i6 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i6;
                }
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "164@8176L33,165@8257L5,166@8330L8,168@8446L12");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 2) != 0) {
                            wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                            i3 &= -113;
                        } else {
                            wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i11 != 0) {
                            function4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                            i3 &= -3670017;
                        }
                        if (i4 != 0) {
                            contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                            wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                            modifier4 = modifier2;
                            shape4 = shape2;
                            wideNavigationRailColors3 = wideNavigationRailColorsColors;
                            function6 = function4;
                            windowInsets4 = windowInsets2;
                            vertical3 = arrangement;
                        } else {
                            wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-477658179, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:172)");
                        }
                        ProvidableCompositionLocal<WideNavigationRailOverride> providableCompositionLocal = LocalWideNavigationRailOverride;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ((WideNavigationRailOverride) objConsume).WideNavigationRail(new WideNavigationRailOverrideScope(modifier4, wideNavigationRailState3, shape4, wideNavigationRailColors3, function6, windowInsets4, vertical3, contentPadding, function3), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        wideNavigationRailState2 = wideNavigationRailState3;
                        shape3 = shape4;
                        wideNavigationRailColors2 = wideNavigationRailColors3;
                        function5 = function6;
                        windowInsets3 = windowInsets4;
                        vertical2 = vertical3;
                        paddingValues3 = contentPadding;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        wideNavigationRailState3 = wideNavigationRailState;
                    }
                    modifier4 = modifier2;
                    shape4 = shape2;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function6 = function4;
                    windowInsets4 = windowInsets2;
                    vertical3 = arrangement;
                    contentPadding = paddingValues2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-477658179, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:172)");
                    }
                    ProvidableCompositionLocal<WideNavigationRailOverride> providableCompositionLocal2 = LocalWideNavigationRailOverride;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ((WideNavigationRailOverride) objConsume2).WideNavigationRail(new WideNavigationRailOverrideScope(modifier4, wideNavigationRailState3, shape4, wideNavigationRailColors3, function6, windowInsets4, vertical3, contentPadding, function3), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    wideNavigationRailState2 = wideNavigationRailState3;
                    shape3 = shape4;
                    wideNavigationRailColors2 = wideNavigationRailColors3;
                    function5 = function6;
                    windowInsets3 = windowInsets4;
                    vertical2 = vertical3;
                    paddingValues3 = contentPadding;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    shape3 = shape2;
                    wideNavigationRailColors2 = wideNavigationRailColorsColors;
                    function5 = function4;
                    windowInsets3 = windowInsets2;
                    vertical2 = arrangement;
                    paddingValues3 = paddingValues2;
                    wideNavigationRailState2 = wideNavigationRailState;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRail$lambda$1(modifier3, wideNavigationRailState2, shape3, wideNavigationRailColors2, function5, windowInsets3, vertical2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            paddingValues2 = paddingValues;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 67108864;
                } else {
                    i6 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i3 |= i6;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "164@8176L33,165@8257L5,166@8330L8,168@8446L12");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 2) != 0) {
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i3 &= -113;
                    } else {
                        wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i11 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        i3 &= -3670017;
                    }
                    if (i4 != 0) {
                        contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        modifier4 = modifier2;
                        shape4 = shape2;
                        wideNavigationRailColors3 = wideNavigationRailColorsColors;
                        function6 = function4;
                        windowInsets4 = windowInsets2;
                        vertical3 = arrangement;
                    } else {
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        modifier4 = modifier2;
                        shape4 = shape2;
                        wideNavigationRailColors3 = wideNavigationRailColorsColors;
                        function6 = function4;
                        windowInsets4 = windowInsets2;
                        vertical3 = arrangement;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 2) != 0) {
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i3 &= -113;
                    } else {
                        wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i11 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        i3 &= -3670017;
                    }
                    if (i4 != 0) {
                        contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        modifier4 = modifier2;
                        shape4 = shape2;
                        wideNavigationRailColors3 = wideNavigationRailColorsColors;
                        function6 = function4;
                        windowInsets4 = windowInsets2;
                        vertical3 = arrangement;
                    } else {
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        modifier4 = modifier2;
                        shape4 = shape2;
                        wideNavigationRailColors3 = wideNavigationRailColorsColors;
                        function6 = function4;
                        windowInsets4 = windowInsets2;
                        vertical3 = arrangement;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-477658179, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:172)");
                }
                ProvidableCompositionLocal<WideNavigationRailOverride> providableCompositionLocal3 = LocalWideNavigationRailOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(providableCompositionLocal3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((WideNavigationRailOverride) objConsume3).WideNavigationRail(new WideNavigationRailOverrideScope(modifier4, wideNavigationRailState3, shape4, wideNavigationRailColors3, function6, windowInsets4, vertical3, contentPadding, function3), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                wideNavigationRailState2 = wideNavigationRailState3;
                shape3 = shape4;
                wideNavigationRailColors2 = wideNavigationRailColors3;
                function5 = function6;
                windowInsets3 = windowInsets4;
                vertical2 = vertical3;
                paddingValues3 = contentPadding;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                shape3 = shape2;
                wideNavigationRailColors2 = wideNavigationRailColorsColors;
                function5 = function4;
                windowInsets3 = windowInsets2;
                vertical2 = arrangement;
                paddingValues3 = paddingValues2;
                wideNavigationRailState2 = wideNavigationRailState;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRail$lambda$1(modifier3, wideNavigationRailState2, shape3, wideNavigationRailColors2, function5, windowInsets3, vertical2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function4 = function2;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                windowInsets2 = windowInsets;
                if (composerStartRestartGroup.changed(windowInsets2)) {
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            i3 |= i12;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                arrangement = vertical;
                if (composerStartRestartGroup.changed(arrangement)) {
                }
                i3 |= i13;
            } else {
                arrangement = vertical;
            }
            i3 |= i13;
        } else {
            arrangement = vertical;
        }
        i4 = i2 & 128;
        if (i4 != 0) {
            if ((12582912 & i) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i5 = 8388608;
                } else {
                    i5 = 4194304;
                }
                i3 |= i5;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 67108864;
                } else {
                    i6 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i3 |= i6;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "164@8176L33,165@8257L5,166@8330L8,168@8446L12");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 2) != 0) {
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i3 &= -113;
                    } else {
                        wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i11 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        i3 &= -3670017;
                    }
                    if (i4 != 0) {
                        contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        modifier4 = modifier2;
                        shape4 = shape2;
                        wideNavigationRailColors3 = wideNavigationRailColorsColors;
                        function6 = function4;
                        windowInsets4 = windowInsets2;
                        vertical3 = arrangement;
                    } else {
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        modifier4 = modifier2;
                        shape4 = shape2;
                        wideNavigationRailColors3 = wideNavigationRailColorsColors;
                        function6 = function4;
                        windowInsets4 = windowInsets2;
                        vertical3 = arrangement;
                        contentPadding = paddingValues2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 2) != 0) {
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i3 &= -113;
                    } else {
                        wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i11 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        i3 &= -3670017;
                    }
                    if (i4 != 0) {
                        contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        modifier4 = modifier2;
                        shape4 = shape2;
                        wideNavigationRailColors3 = wideNavigationRailColorsColors;
                        function6 = function4;
                        windowInsets4 = windowInsets2;
                        vertical3 = arrangement;
                    } else {
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        modifier4 = modifier2;
                        shape4 = shape2;
                        wideNavigationRailColors3 = wideNavigationRailColorsColors;
                        function6 = function4;
                        windowInsets4 = windowInsets2;
                        vertical3 = arrangement;
                        contentPadding = paddingValues2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-477658179, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:172)");
                }
                ProvidableCompositionLocal<WideNavigationRailOverride> providableCompositionLocal4 = LocalWideNavigationRailOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(providableCompositionLocal4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((WideNavigationRailOverride) objConsume4).WideNavigationRail(new WideNavigationRailOverrideScope(modifier4, wideNavigationRailState3, shape4, wideNavigationRailColors3, function6, windowInsets4, vertical3, contentPadding, function3), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                wideNavigationRailState2 = wideNavigationRailState3;
                shape3 = shape4;
                wideNavigationRailColors2 = wideNavigationRailColors3;
                function5 = function6;
                windowInsets3 = windowInsets4;
                vertical2 = vertical3;
                paddingValues3 = contentPadding;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                shape3 = shape2;
                wideNavigationRailColors2 = wideNavigationRailColorsColors;
                function5 = function4;
                windowInsets3 = windowInsets2;
                vertical2 = arrangement;
                paddingValues3 = paddingValues2;
                wideNavigationRailState2 = wideNavigationRailState;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRail$lambda$1(modifier3, wideNavigationRailState2, shape3, wideNavigationRailColors2, function5, windowInsets3, vertical2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 12582912;
        paddingValues2 = paddingValues;
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i6 = 67108864;
            } else {
                i6 = GroupFlagsKt.HasAuxSlotFlag;
            }
            i3 |= i6;
        }
        if ((i3 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "164@8176L33,165@8257L5,166@8330L8,168@8446L12");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 2) != 0) {
                    wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                    i3 &= -113;
                } else {
                    wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i11 != 0) {
                    function4 = null;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                }
                if ((i2 & 64) != 0) {
                    arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    i3 &= -3670017;
                }
                if (i4 != 0) {
                    contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    modifier4 = modifier2;
                    shape4 = shape2;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function6 = function4;
                    windowInsets4 = windowInsets2;
                    vertical3 = arrangement;
                } else {
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    modifier4 = modifier2;
                    shape4 = shape2;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function6 = function4;
                    windowInsets4 = windowInsets2;
                    vertical3 = arrangement;
                    contentPadding = paddingValues2;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 2) != 0) {
                    wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                    i3 &= -113;
                } else {
                    wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i11 != 0) {
                    function4 = null;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                }
                if ((i2 & 64) != 0) {
                    arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    i3 &= -3670017;
                }
                if (i4 != 0) {
                    contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    modifier4 = modifier2;
                    shape4 = shape2;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function6 = function4;
                    windowInsets4 = windowInsets2;
                    vertical3 = arrangement;
                } else {
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    modifier4 = modifier2;
                    shape4 = shape2;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function6 = function4;
                    windowInsets4 = windowInsets2;
                    vertical3 = arrangement;
                    contentPadding = paddingValues2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-477658179, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:172)");
            }
            ProvidableCompositionLocal<WideNavigationRailOverride> providableCompositionLocal5 = LocalWideNavigationRailOverride;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume5 = composerStartRestartGroup.consume(providableCompositionLocal5);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ((WideNavigationRailOverride) objConsume5).WideNavigationRail(new WideNavigationRailOverrideScope(modifier4, wideNavigationRailState3, shape4, wideNavigationRailColors3, function6, windowInsets4, vertical3, contentPadding, function3), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            wideNavigationRailState2 = wideNavigationRailState3;
            shape3 = shape4;
            wideNavigationRailColors2 = wideNavigationRailColors3;
            function5 = function6;
            windowInsets3 = windowInsets4;
            vertical2 = vertical3;
            paddingValues3 = contentPadding;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            shape3 = shape2;
            wideNavigationRailColors2 = wideNavigationRailColorsColors;
            function5 = function4;
            windowInsets3 = windowInsets2;
            vertical2 = arrangement;
            paddingValues3 = paddingValues2;
            wideNavigationRailState2 = wideNavigationRailState;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRail$lambda$1(modifier3, wideNavigationRailState2, shape3, wideNavigationRailColors2, function5, windowInsets3, vertical2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:117:0x014b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x014d  */
    /* JADX WARN: Code duplicated, block: B:119:0x0152  */
    /* JADX WARN: Code duplicated, block: B:122:0x0158  */
    /* JADX WARN: Code duplicated, block: B:125:0x0164  */
    /* JADX WARN: Code duplicated, block: B:128:0x0171  */
    /* JADX WARN: Code duplicated, block: B:130:0x017c  */
    /* JADX WARN: Code duplicated, block: B:133:0x0181  */
    /* JADX WARN: Code duplicated, block: B:136:0x018f  */
    /* JADX WARN: Code duplicated, block: B:137:0x019f  */
    /* JADX WARN: Code duplicated, block: B:140:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:143:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:145:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:148:0x020a  */
    /* JADX WARN: Code duplicated, block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:94:0x0105  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of function with contentPadding parameter")
    public static final /* synthetic */ void WideNavigationRail(Modifier modifier, WideNavigationRailState wideNavigationRailState, Shape shape, WideNavigationRailColors wideNavigationRailColors, Function2 function2, WindowInsets windowInsets, Arrangement.Vertical vertical, final Function2 function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        WideNavigationRailColors wideNavigationRailColorsColors;
        Function2 function4;
        WindowInsets windowInsets2;
        Arrangement.Vertical arrangement;
        boolean z;
        Composer composer2;
        final WideNavigationRailState wideNavigationRailState2;
        final Modifier modifier3;
        final Shape shape3;
        final WideNavigationRailColors wideNavigationRailColors2;
        final Function2 function5;
        final WindowInsets windowInsets3;
        final Arrangement.Vertical vertical2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        WideNavigationRailColors wideNavigationRailColors3;
        Function2 function6;
        WindowInsets windowInsets4;
        WideNavigationRailState wideNavigationRailState3;
        Modifier modifier4;
        Shape shape4;
        int i4;
        int i5;
        WideNavigationRailState wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
        Composer composerStartRestartGroup = composer.startRestartGroup(164193188);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRail)N(modifier,state,shape,colors,header,windowInsets,arrangement,content)236@11698L317:WideNavigationRail.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) != 0) {
                i5 = 16;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(wideNavigationRailStateRememberWideNavigationRailState) : composerStartRestartGroup.changedInstance(wideNavigationRailStateRememberWideNavigationRailState)) {
                    i5 = 32;
                } else {
                    i5 = 16;
                }
            }
            i3 |= i5;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                int i7 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                i3 |= i7;
            } else {
                shape2 = shape;
            }
            i3 |= i7;
        } else {
            shape2 = shape;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                wideNavigationRailColorsColors = wideNavigationRailColors;
                int i8 = composerStartRestartGroup.changed(wideNavigationRailColorsColors) ? 2048 : 1024;
                i3 |= i8;
            } else {
                wideNavigationRailColorsColors = wideNavigationRailColors;
            }
            i3 |= i8;
        } else {
            wideNavigationRailColorsColors = wideNavigationRailColors;
        }
        int i9 = i2 & 16;
        if (i9 == 0) {
            if ((i & 24576) == 0) {
                function4 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    windowInsets2 = windowInsets;
                    int i10 = composerStartRestartGroup.changed(windowInsets2) ? 131072 : 65536;
                    i3 |= i10;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i10;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    arrangement = vertical;
                    int i11 = composerStartRestartGroup.changed(arrangement) ? 1048576 : 524288;
                    i3 |= i11;
                } else {
                    arrangement = vertical;
                }
                i3 |= i11;
            } else {
                arrangement = vertical;
            }
            if ((i & 12582912) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i4 = 8388608;
                } else {
                    i4 = 4194304;
                }
                i3 |= i4;
            }
            if ((4793491 & i3) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "228@11289L33,229@11370L5,230@11443L8,232@11559L12");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i9 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        shape4 = shape2;
                        wideNavigationRailColors3 = wideNavigationRailColorsColors;
                        function6 = function4;
                        windowInsets4 = windowInsets2;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        modifier4 = companion;
                    } else {
                        wideNavigationRailColors3 = wideNavigationRailColorsColors;
                        function6 = function4;
                        windowInsets4 = windowInsets2;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(164193188, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:235)");
                    }
                    composer2 = composerStartRestartGroup;
                    WideNavigationRail(modifier4, wideNavigationRailState3, shape4, wideNavigationRailColors3, function6, windowInsets4, arrangement, WideNavigationRailDefaults.INSTANCE.getContentPadding(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    wideNavigationRailState2 = wideNavigationRailState3;
                    shape3 = shape4;
                    wideNavigationRailColors2 = wideNavigationRailColors3;
                    function5 = function6;
                    windowInsets3 = windowInsets4;
                    vertical2 = arrangement;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                    }
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function6 = function4;
                    windowInsets4 = windowInsets2;
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    modifier4 = modifier2;
                }
                shape4 = shape2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(164193188, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:235)");
                }
                composer2 = composerStartRestartGroup;
                WideNavigationRail(modifier4, wideNavigationRailState3, shape4, wideNavigationRailColors3, function6, windowInsets4, arrangement, WideNavigationRailDefaults.INSTANCE.getContentPadding(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                wideNavigationRailState2 = wideNavigationRailState3;
                shape3 = shape4;
                wideNavigationRailColors2 = wideNavigationRailColors3;
                function5 = function6;
                windowInsets3 = windowInsets4;
                vertical2 = arrangement;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                wideNavigationRailState2 = wideNavigationRailStateRememberWideNavigationRailState;
                modifier3 = modifier2;
                shape3 = shape2;
                wideNavigationRailColors2 = wideNavigationRailColorsColors;
                function5 = function4;
                windowInsets3 = windowInsets2;
                vertical2 = arrangement;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRail$lambda$2(modifier3, wideNavigationRailState2, shape3, wideNavigationRailColors2, function5, windowInsets3, vertical2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function4 = function2;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                windowInsets2 = windowInsets;
                if (composerStartRestartGroup.changed(windowInsets2)) {
                }
                i3 |= i10;
            } else {
                windowInsets2 = windowInsets;
            }
            i3 |= i10;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                arrangement = vertical;
                if (composerStartRestartGroup.changed(arrangement)) {
                }
                i3 |= i11;
            } else {
                arrangement = vertical;
            }
            i3 |= i11;
        } else {
            arrangement = vertical;
        }
        if ((i & 12582912) != 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i4 = 8388608;
            } else {
                i4 = 4194304;
            }
            i3 |= i4;
        }
        if ((4793491 & i3) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "228@11289L33,229@11370L5,230@11443L8,232@11559L12");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i9 != 0) {
                    function4 = null;
                }
                if ((i2 & 32) != 0) {
                    windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    shape4 = shape2;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function6 = function4;
                    windowInsets4 = windowInsets2;
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    modifier4 = companion;
                } else {
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function6 = function4;
                    windowInsets4 = windowInsets2;
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    modifier4 = companion;
                    shape4 = shape2;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i9 != 0) {
                    function4 = null;
                }
                if ((i2 & 32) != 0) {
                    windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    shape4 = shape2;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function6 = function4;
                    windowInsets4 = windowInsets2;
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    modifier4 = companion;
                } else {
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function6 = function4;
                    windowInsets4 = windowInsets2;
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    modifier4 = companion;
                    shape4 = shape2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(164193188, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:235)");
            }
            composer2 = composerStartRestartGroup;
            WideNavigationRail(modifier4, wideNavigationRailState3, shape4, wideNavigationRailColors3, function6, windowInsets4, arrangement, WideNavigationRailDefaults.INSTANCE.getContentPadding(), function3, composer2, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | ((i3 << 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            wideNavigationRailState2 = wideNavigationRailState3;
            shape3 = shape4;
            wideNavigationRailColors2 = wideNavigationRailColors3;
            function5 = function6;
            windowInsets3 = windowInsets4;
            vertical2 = arrangement;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            wideNavigationRailState2 = wideNavigationRailStateRememberWideNavigationRailState;
            modifier3 = modifier2;
            shape3 = shape2;
            wideNavigationRailColors2 = wideNavigationRailColorsColors;
            function5 = function4;
            windowInsets3 = windowInsets2;
            vertical2 = arrangement;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRail$lambda$2(modifier3, wideNavigationRailState2, shape3, wideNavigationRailColors2, function5, windowInsets3, vertical2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WideNavigationRailLayout(final Modifier modifier, final boolean z, final boolean z2, final WideNavigationRailColors wideNavigationRailColors, final Shape shape, final Function2<? super Composer, ? super Integer, Unit> function2, final WindowInsets windowInsets, final Arrangement.Vertical vertical, final PaddingValues paddingValues, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        WideNavigationRailColors wideNavigationRailColors2;
        float fM10182unboximpl;
        float fM10168constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1072361515);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRailLayout)N(modifier,isModal,expanded,colors,shape,header,windowInsets,arrangement,contentPadding,content)286@13181L33,287@13249L33,289@13358L7,296@13624L11,297@13699L11,299@13739L195,304@13969L195,309@14205L170,314@14409L154,324@14809L9112,319@14569L9352:WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            wideNavigationRailColors2 = wideNavigationRailColors;
            i2 |= composerStartRestartGroup.changed(wideNavigationRailColors2) ? 2048 : 1024;
        } else {
            wideNavigationRailColors2 = wideNavigationRailColors;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= composerStartRestartGroup.changed(vertical) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(paddingValues) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((805306368 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((306783379 & i2) != 306783378, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1072361515, i2, -1, "androidx.compose.material3.WideNavigationRailLayout (WideNavigationRail.kt:285)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 252746838, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 252749014, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (Dp.m10173equalsimpl0(((Dp) objConsume).m10182unboximpl(), Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM())) {
                composerStartRestartGroup.startReplaceGroup(-754580399);
                composerStartRestartGroup.endReplaceGroup();
                fM10182unboximpl = Dp.m10168constructorimpl(0.0f);
            } else {
                composerStartRestartGroup.startReplaceGroup(-754545431);
                ComposerKt.sourceInformation(composerStartRestartGroup, "292@13470L7");
                ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fM10182unboximpl = ((Dp) objConsume2).m10182unboximpl();
                composerStartRestartGroup.endReplaceGroup();
            }
            final float f = fM10182unboximpl;
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
            final State<Dp> stateM1455animateDpAsStateAjpBEmI = AnimateAsStateKt.m1455animateDpAsStateAjpBEmI(!z2 ? CollapsedRailWidth : ExpandedRailMinWidth, !z ? finiteAnimationSpecValue : finiteAnimationSpecValue2, null, null, composerStartRestartGroup, 0, 12);
            float f2 = !z2 ? CollapsedRailWidth : ExpandedRailMaxWidth;
            if (!z) {
                finiteAnimationSpecValue2 = finiteAnimationSpecValue;
            }
            final State<Dp> stateM1455animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m1455animateDpAsStateAjpBEmI(f2, finiteAnimationSpecValue2, null, null, composerStartRestartGroup, 0, 12);
            if (!z2) {
                fM10168constructorimpl = NavigationRailCollapsedTokens.INSTANCE.m5986getItemVerticalSpaceD9Ej5fM();
            } else {
                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
            }
            FiniteAnimationSpec finiteAnimationSpec = finiteAnimationSpecValue;
            final State<Dp> stateM1455animateDpAsStateAjpBEmI3 = AnimateAsStateKt.m1455animateDpAsStateAjpBEmI(fM10168constructorimpl, finiteAnimationSpec, null, null, composerStartRestartGroup, 0, 12);
            final State<Dp> stateM1455animateDpAsStateAjpBEmI4 = AnimateAsStateKt.m1455animateDpAsStateAjpBEmI(!z2 ? TopIconItemMinHeight : f, finiteAnimationSpec, null, null, composerStartRestartGroup, 0, 12);
            int i3 = i2;
            SurfaceKt.m4781SurfaceT9BRK9s(modifier, shape, !z ? wideNavigationRailColors2.getContainerColor() : wideNavigationRailColors2.getModalContainerColor(), !z ? wideNavigationRailColors2.getContentColor() : wideNavigationRailColors2.getModalContentColor(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(512862384, true, new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRailLayout$lambda$10(windowInsets, paddingValues, function2, z2, f, stateM1455animateDpAsStateAjpBEmI, stateM1455animateDpAsStateAjpBEmI4, stateM1455animateDpAsStateAjpBEmI2, mutableIntState2, mutableIntState, vertical, stateM1455animateDpAsStateAjpBEmI3, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12582912 | ((i3 >> 9) & 112), 112);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRailLayout$lambda$11(modifier, z, z2, wideNavigationRailColors, shape, function2, windowInsets, vertical, paddingValues, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int WideNavigationRailLayout$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int WideNavigationRailLayout$lambda$4(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WideNavigationRailLayout$lambda$10$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    static final Unit WideNavigationRailLayout$lambda$10(WindowInsets windowInsets, PaddingValues paddingValues, Function2 function2, boolean z, float f, State state, State state2, State state3, MutableIntState mutableIntState, MutableIntState mutableIntState2, Arrangement.Vertical vertical, State state4, Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C332@15118L27,325@14819L9096:WideNavigationRail.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(512862384, i, -1, "androidx.compose.material3.WideNavigationRailLayout.<anonymous> (WideNavigationRail.kt:325)");
            }
            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.padding(SizeKt.m2424widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets), 0.0f, ExpandedRailMaxWidth, 1, null), paddingValues));
            ComposerKt.sourceInformationMarkerStart(composer, -1060478101, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.WideNavigationRailLayout$lambda$10$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierSelectableGroup, false, (Function1) objRememberedValue, 1, null);
            WideNavigationRailKt$WideNavigationRailLayout$1$2 wideNavigationRailKt$WideNavigationRailLayout$1$2 = new WideNavigationRailKt$WideNavigationRailLayout$1$2(function2, z, f, state, state2, state3, mutableIntState, mutableIntState2, vertical, state4);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSemantics$default);
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
            Updater.m6446setimpl(composerM6438constructorimpl, wideNavigationRailKt$WideNavigationRailLayout$1$2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1497277246, "C337@15318L9:WideNavigationRail.kt#uh7d8r");
            if (function2 != null) {
                composer.startReplaceGroup(1497295659);
                ComposerKt.sourceInformation(composer, "335@15229L54");
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, HeaderLayoutIdTag);
                ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierLayoutId);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                Composer composerM6438constructorimpl2 = Updater.m6438constructorimpl(composer);
                Updater.m6446setimpl(composerM6438constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6446setimpl(composerM6438constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6446setimpl(composerM6438constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6444reconcileimpl(composerM6438constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6446setimpl(composerM6438constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 1068739171, "C335@15273L8:WideNavigationRail.kt#uh7d8r");
                function2.invoke(composer, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1497385993);
                composer.endReplaceGroup();
            }
            function3.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0122  */
    /* JADX WARN: Code duplicated, block: B:109:0x0138  */
    /* JADX WARN: Code duplicated, block: B:112:0x013e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0145  */
    /* JADX WARN: Code duplicated, block: B:115:0x0149  */
    /* JADX WARN: Code duplicated, block: B:117:0x0153  */
    /* JADX WARN: Code duplicated, block: B:118:0x0156  */
    /* JADX WARN: Code duplicated, block: B:120:0x015b  */
    /* JADX WARN: Code duplicated, block: B:123:0x0165  */
    /* JADX WARN: Code duplicated, block: B:124:0x0168  */
    /* JADX WARN: Code duplicated, block: B:126:0x016c  */
    /* JADX WARN: Code duplicated, block: B:128:0x0176  */
    /* JADX WARN: Code duplicated, block: B:129:0x0179  */
    /* JADX WARN: Code duplicated, block: B:134:0x0186  */
    /* JADX WARN: Code duplicated, block: B:136:0x018e  */
    /* JADX WARN: Code duplicated, block: B:137:0x0191  */
    /* JADX WARN: Code duplicated, block: B:139:0x0196  */
    /* JADX WARN: Code duplicated, block: B:142:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:146:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:149:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:151:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:173:0x0215 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:174:0x0217  */
    /* JADX WARN: Code duplicated, block: B:175:0x021c  */
    /* JADX WARN: Code duplicated, block: B:178:0x0222  */
    /* JADX WARN: Code duplicated, block: B:179:0x022a  */
    /* JADX WARN: Code duplicated, block: B:181:0x022e  */
    /* JADX WARN: Code duplicated, block: B:182:0x0230  */
    /* JADX WARN: Code duplicated, block: B:185:0x0237  */
    /* JADX WARN: Code duplicated, block: B:188:0x0243  */
    /* JADX WARN: Code duplicated, block: B:189:0x024e  */
    /* JADX WARN: Code duplicated, block: B:192:0x0253  */
    /* JADX WARN: Code duplicated, block: B:193:0x025e  */
    /* JADX WARN: Code duplicated, block: B:195:0x0261  */
    /* JADX WARN: Code duplicated, block: B:197:0x0264  */
    /* JADX WARN: Code duplicated, block: B:198:0x026a  */
    /* JADX WARN: Code duplicated, block: B:201:0x0270  */
    /* JADX WARN: Code duplicated, block: B:202:0x027b  */
    /* JADX WARN: Code duplicated, block: B:205:0x0281  */
    /* JADX WARN: Code duplicated, block: B:206:0x028d  */
    /* JADX WARN: Code duplicated, block: B:208:0x0291  */
    /* JADX WARN: Code duplicated, block: B:209:0x0298  */
    /* JADX WARN: Code duplicated, block: B:211:0x029c  */
    /* JADX WARN: Code duplicated, block: B:212:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:215:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:218:0x030e  */
    /* JADX WARN: Code duplicated, block: B:220:0x0329  */
    /* JADX WARN: Code duplicated, block: B:223:0x0346  */
    /* JADX WARN: Code duplicated, block: B:225:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x008e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x009a  */
    /* JADX WARN: Code duplicated, block: B:54:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:90:0x0104  */
    /* JADX WARN: Code duplicated, block: B:98:0x011a  */
    /* JADX INFO: renamed from: ModalWideNavigationRail-xKBSf-U, reason: not valid java name */
    public static final void m5249ModalWideNavigationRailxKBSfU(Modifier modifier, WideNavigationRailState wideNavigationRailState, boolean z, Shape shape, Shape shape2, WideNavigationRailColors wideNavigationRailColors, Function2<? super Composer, ? super Integer, Unit> function2, float f, WindowInsets windowInsets, Arrangement.Vertical vertical, ModalWideNavigationRailProperties modalWideNavigationRailProperties, PaddingValues paddingValues, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        Shape modalCollapsedShape;
        Shape shape3;
        WideNavigationRailColors wideNavigationRailColors2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function4;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z2;
        final WideNavigationRailState wideNavigationRailState2;
        final float f2;
        final WindowInsets windowInsets2;
        final Shape shape4;
        final Shape shape5;
        final WideNavigationRailColors wideNavigationRailColors3;
        Function2<? super Composer, ? super Integer, Unit> function5;
        final boolean z3;
        final Arrangement.Vertical vertical2;
        final ModalWideNavigationRailProperties modalWideNavigationRailProperties2;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        WideNavigationRailState wideNavigationRailStateRememberWideNavigationRailState;
        boolean z4;
        Shape modalExpandedShape;
        WideNavigationRailColors wideNavigationRailColorsColors;
        float fM10168constructorimpl;
        WindowInsets windowInsets3;
        Arrangement.Vertical arrangement;
        ModalWideNavigationRailProperties modalExpandedProperties;
        PaddingValues contentPadding;
        Modifier modifier3;
        boolean z5;
        WideNavigationRailState wideNavigationRailState3;
        Shape shape6;
        WindowInsets windowInsets4;
        Shape shape7;
        WideNavigationRailColors wideNavigationRailColors4;
        float f3;
        Arrangement.Vertical vertical3;
        ModalWideNavigationRailProperties modalWideNavigationRailProperties3;
        int i15;
        int i16;
        int i17;
        Composer composerStartRestartGroup = composer.startRestartGroup(-94259026);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalWideNavigationRail)N(modifier,state,hideOnCollapse,collapsedShape,expandedShape,colors,header,expandedHeaderTopPadding:c#ui.unit.Dp,windowInsets,arrangement,expandedProperties,contentPadding,content)570@28316L7,*570@28333L25:WideNavigationRail.kt#uh7d8r");
        int i18 = i3 & 1;
        if (i18 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 48) == 0) {
            if ((i3 & 2) != 0) {
                i17 = 16;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(wideNavigationRailState) : composerStartRestartGroup.changedInstance(wideNavigationRailState)) {
                    i17 = 32;
                } else {
                    i17 = 16;
                }
            }
            i4 |= i17;
        }
        int i19 = i3 & 4;
        if (i19 == 0) {
            if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    modalCollapsedShape = shape;
                    int i20 = composerStartRestartGroup.changed(modalCollapsedShape) ? 2048 : 1024;
                    i4 |= i20;
                } else {
                    modalCollapsedShape = shape;
                }
                i4 |= i20;
            } else {
                modalCollapsedShape = shape;
            }
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    shape3 = shape2;
                    int i21 = composerStartRestartGroup.changed(shape3) ? 16384 : 8192;
                    i4 |= i21;
                } else {
                    shape3 = shape2;
                }
                i4 |= i21;
            } else {
                shape3 = shape2;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                wideNavigationRailColors2 = wideNavigationRailColors;
                if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(wideNavigationRailColors2)) {
                    i16 = 65536;
                } else {
                    i16 = 131072;
                }
                i4 |= i16;
            } else {
                wideNavigationRailColors2 = wideNavigationRailColors;
            }
            i5 = i3 & 64;
            if (i5 != 0) {
                i4 |= 1572864;
                function4 = function2;
            } else {
                function4 = function2;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                    i4 |= i6;
                }
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i4 |= i8;
            }
            if ((i & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            if ((i & 805306368) != 0) {
                i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(vertical)) ? 268435456 : 536870912;
            }
            i9 = i3 & 1024;
            if (i9 != 0) {
                i10 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(modalWideNavigationRailProperties)) {
                    i11 = 4;
                } else {
                    i11 = 2;
                }
                i10 = i2 | i11;
            } else {
                i10 = i2;
            }
            i12 = i3 & 2048;
            if (i12 != 0) {
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i13 = 32;
                    } else {
                        i13 = 16;
                    }
                    i10 |= i13;
                }
                if ((i2 & 384) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i15 = 256;
                    } else {
                        i15 = 128;
                    }
                    i10 |= i15;
                }
                i14 = i10;
                if ((i4 & 306783379) == 306783378 || (i14 & 147) != 146) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "540@26888L33,542@27015L19,543@27090L18,544@27176L8,547@27333L12");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i18 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i3 & 2) != 0) {
                            wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                            i4 &= -113;
                        } else {
                            wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                        }
                        if (i19 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if ((i3 & 8) != 0) {
                            modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if ((i3 & 16) != 0) {
                            modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            modalExpandedShape = shape3;
                        }
                        if ((i3 & 32) != 0) {
                            wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i4 &= -458753;
                        } else {
                            wideNavigationRailColorsColors = wideNavigationRailColors2;
                        }
                        if (i5 != 0) {
                            function4 = null;
                        }
                        if (i7 != 0) {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        } else {
                            fM10168constructorimpl = f;
                        }
                        if ((i3 & 256) != 0) {
                            windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            windowInsets3 = windowInsets;
                        }
                        if ((i3 & 512) != 0) {
                            arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                            i4 &= -1879048193;
                        } else {
                            arrangement = vertical;
                        }
                        if (i9 != 0) {
                            modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                        } else {
                            modalExpandedProperties = modalWideNavigationRailProperties;
                        }
                        if (i12 != 0) {
                            modifier3 = companion;
                            z5 = z4;
                            wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                            shape6 = modalCollapsedShape;
                            windowInsets4 = windowInsets3;
                            shape7 = modalExpandedShape;
                            wideNavigationRailColors4 = wideNavigationRailColorsColors;
                            f3 = fM10168constructorimpl;
                            function5 = function4;
                            vertical3 = arrangement;
                            modalWideNavigationRailProperties3 = modalExpandedProperties;
                            contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                            modifier3 = companion;
                            z5 = z4;
                            wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                            shape6 = modalCollapsedShape;
                            windowInsets4 = windowInsets3;
                            shape7 = modalExpandedShape;
                            wideNavigationRailColors4 = wideNavigationRailColorsColors;
                            f3 = fM10168constructorimpl;
                            function5 = function4;
                            vertical3 = arrangement;
                            modalWideNavigationRailProperties3 = modalExpandedProperties;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 2) != 0) {
                            i4 &= -113;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                        }
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                        }
                        if ((i3 & 256) != 0) {
                            i4 &= -234881025;
                        }
                        if ((i3 & 512) != 0) {
                            i4 &= -1879048193;
                        }
                        wideNavigationRailState3 = wideNavigationRailState;
                        z5 = z;
                        f3 = f;
                        windowInsets4 = windowInsets;
                        vertical3 = vertical;
                        modalWideNavigationRailProperties3 = modalWideNavigationRailProperties;
                        contentPadding = paddingValues;
                        shape6 = modalCollapsedShape;
                        modifier3 = modifier2;
                        shape7 = shape3;
                        wideNavigationRailColors4 = wideNavigationRailColors2;
                        function5 = function4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-94259026, i4, i14, "androidx.compose.material3.ModalWideNavigationRail (WideNavigationRail.kt:553)");
                    }
                    ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope = new ModalWideNavigationRailOverrideScope(modifier3, wideNavigationRailState3, z5, shape6, shape7, wideNavigationRailColors4, function5, f3, windowInsets4, vertical3, modalWideNavigationRailProperties3, contentPadding, function3, null);
                    ProvidableCompositionLocal<ModalWideNavigationRailOverride> providableCompositionLocal = LocalModalWideNavigationRailOverride;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ((ModalWideNavigationRailOverride) objConsume).ModalWideNavigationRail(modalWideNavigationRailOverrideScope, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    wideNavigationRailState2 = wideNavigationRailState3;
                    z3 = z5;
                    shape4 = shape6;
                    shape5 = shape7;
                    wideNavigationRailColors3 = wideNavigationRailColors4;
                    f2 = f3;
                    windowInsets2 = windowInsets4;
                    vertical2 = vertical3;
                    modalWideNavigationRailProperties2 = modalWideNavigationRailProperties3;
                    paddingValues2 = contentPadding;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    wideNavigationRailState2 = wideNavigationRailState;
                    f2 = f;
                    windowInsets2 = windowInsets;
                    shape4 = modalCollapsedShape;
                    shape5 = shape3;
                    wideNavigationRailColors3 = wideNavigationRailColors2;
                    function5 = function4;
                    z3 = z;
                    vertical2 = vertical;
                    modalWideNavigationRailProperties2 = modalWideNavigationRailProperties;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    final Function2<? super Composer, ? super Integer, Unit> function6 = function5;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.ModalWideNavigationRail_xKBSf_U$lambda$1(modifier4, wideNavigationRailState2, z3, shape4, shape5, wideNavigationRailColors3, function6, f2, windowInsets2, vertical2, modalWideNavigationRailProperties2, paddingValues2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i10 |= 48;
            if ((i2 & 384) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
                i10 |= i15;
            }
            i14 = i10;
            if ((i4 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "540@26888L33,542@27015L19,543@27090L18,544@27176L8,547@27333L12");
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i4 &= -113;
                    } else {
                        wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    }
                    if (i19 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if ((i3 & 8) != 0) {
                        modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        modalExpandedShape = shape3;
                    }
                    if ((i3 & 32) != 0) {
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    } else {
                        wideNavigationRailColorsColors = wideNavigationRailColors2;
                    }
                    if (i5 != 0) {
                        function4 = null;
                    }
                    if (i7 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f;
                    }
                    if ((i3 & 256) != 0) {
                        windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        windowInsets3 = windowInsets;
                    }
                    if ((i3 & 512) != 0) {
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        i4 &= -1879048193;
                    } else {
                        arrangement = vertical;
                    }
                    if (i9 != 0) {
                        modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                    } else {
                        modalExpandedProperties = modalWideNavigationRailProperties;
                    }
                    if (i12 != 0) {
                        modifier3 = companion;
                        z5 = z4;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        shape6 = modalCollapsedShape;
                        windowInsets4 = windowInsets3;
                        shape7 = modalExpandedShape;
                        wideNavigationRailColors4 = wideNavigationRailColorsColors;
                        f3 = fM10168constructorimpl;
                        function5 = function4;
                        vertical3 = arrangement;
                        modalWideNavigationRailProperties3 = modalExpandedProperties;
                        contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = companion;
                        z5 = z4;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        shape6 = modalCollapsedShape;
                        windowInsets4 = windowInsets3;
                        shape7 = modalExpandedShape;
                        wideNavigationRailColors4 = wideNavigationRailColorsColors;
                        f3 = fM10168constructorimpl;
                        function5 = function4;
                        vertical3 = arrangement;
                        modalWideNavigationRailProperties3 = modalExpandedProperties;
                    }
                } else {
                    if (i18 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i4 &= -113;
                    } else {
                        wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    }
                    if (i19 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if ((i3 & 8) != 0) {
                        modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        modalExpandedShape = shape3;
                    }
                    if ((i3 & 32) != 0) {
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    } else {
                        wideNavigationRailColorsColors = wideNavigationRailColors2;
                    }
                    if (i5 != 0) {
                        function4 = null;
                    }
                    if (i7 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f;
                    }
                    if ((i3 & 256) != 0) {
                        windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        windowInsets3 = windowInsets;
                    }
                    if ((i3 & 512) != 0) {
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        i4 &= -1879048193;
                    } else {
                        arrangement = vertical;
                    }
                    if (i9 != 0) {
                        modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                    } else {
                        modalExpandedProperties = modalWideNavigationRailProperties;
                    }
                    if (i12 != 0) {
                        modifier3 = companion;
                        z5 = z4;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        shape6 = modalCollapsedShape;
                        windowInsets4 = windowInsets3;
                        shape7 = modalExpandedShape;
                        wideNavigationRailColors4 = wideNavigationRailColorsColors;
                        f3 = fM10168constructorimpl;
                        function5 = function4;
                        vertical3 = arrangement;
                        modalWideNavigationRailProperties3 = modalExpandedProperties;
                        contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = companion;
                        z5 = z4;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        shape6 = modalCollapsedShape;
                        windowInsets4 = windowInsets3;
                        shape7 = modalExpandedShape;
                        wideNavigationRailColors4 = wideNavigationRailColorsColors;
                        f3 = fM10168constructorimpl;
                        function5 = function4;
                        vertical3 = arrangement;
                        modalWideNavigationRailProperties3 = modalExpandedProperties;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-94259026, i4, i14, "androidx.compose.material3.ModalWideNavigationRail (WideNavigationRail.kt:553)");
                }
                ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope2 = new ModalWideNavigationRailOverrideScope(modifier3, wideNavigationRailState3, z5, shape6, shape7, wideNavigationRailColors4, function5, f3, windowInsets4, vertical3, modalWideNavigationRailProperties3, contentPadding, function3, null);
                ProvidableCompositionLocal<ModalWideNavigationRailOverride> providableCompositionLocal2 = LocalModalWideNavigationRailOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((ModalWideNavigationRailOverride) objConsume2).ModalWideNavigationRail(modalWideNavigationRailOverrideScope2, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                wideNavigationRailState2 = wideNavigationRailState3;
                z3 = z5;
                shape4 = shape6;
                shape5 = shape7;
                wideNavigationRailColors3 = wideNavigationRailColors4;
                f2 = f3;
                windowInsets2 = windowInsets4;
                vertical2 = vertical3;
                modalWideNavigationRailProperties2 = modalWideNavigationRailProperties3;
                paddingValues2 = contentPadding;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                wideNavigationRailState2 = wideNavigationRailState;
                f2 = f;
                windowInsets2 = windowInsets;
                shape4 = modalCollapsedShape;
                shape5 = shape3;
                wideNavigationRailColors3 = wideNavigationRailColors2;
                function5 = function4;
                z3 = z;
                vertical2 = vertical;
                modalWideNavigationRailProperties2 = modalWideNavigationRailProperties;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier2;
                final Function2 function7 = function5;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.ModalWideNavigationRail_xKBSf_U$lambda$1(modifier5, wideNavigationRailState2, z3, shape4, shape5, wideNavigationRailColors3, function7, f2, windowInsets2, vertical2, modalWideNavigationRailProperties2, paddingValues2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        if ((i & 3072) == 0) {
            if ((i3 & 8) == 0) {
                modalCollapsedShape = shape;
                if (composerStartRestartGroup.changed(modalCollapsedShape)) {
                }
                i4 |= i20;
            } else {
                modalCollapsedShape = shape;
            }
            i4 |= i20;
        } else {
            modalCollapsedShape = shape;
        }
        if ((i & 24576) == 0) {
            if ((i3 & 16) == 0) {
                shape3 = shape2;
                if (composerStartRestartGroup.changed(shape3)) {
                }
                i4 |= i21;
            } else {
                shape3 = shape2;
            }
            i4 |= i21;
        } else {
            shape3 = shape2;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            wideNavigationRailColors2 = wideNavigationRailColors;
            if ((i3 & 32) == 0) {
                i16 = 65536;
            } else {
                i16 = 65536;
            }
            i4 |= i16;
        } else {
            wideNavigationRailColors2 = wideNavigationRailColors;
        }
        i5 = i3 & 64;
        if (i5 != 0) {
            i4 |= 1572864;
            function4 = function2;
        } else {
            function4 = function2;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i4 |= i6;
            }
        }
        i7 = i3 & 128;
        if (i7 != 0) {
            i4 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i8 = 8388608;
            } else {
                i8 = 4194304;
            }
            i4 |= i8;
        }
        if ((i & 100663296) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
        }
        if ((i & 805306368) != 0) {
            i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(vertical)) ? 268435456 : 536870912;
        }
        i9 = i3 & 1024;
        if (i9 != 0) {
            i10 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changed(modalWideNavigationRailProperties)) {
                i11 = 4;
            } else {
                i11 = 2;
            }
            i10 = i2 | i11;
        } else {
            i10 = i2;
        }
        i12 = i3 & 2048;
        if (i12 != 0) {
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i13 = 32;
                } else {
                    i13 = 16;
                }
                i10 |= i13;
            }
            if ((i2 & 384) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
                i10 |= i15;
            }
            i14 = i10;
            if ((i4 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "540@26888L33,542@27015L19,543@27090L18,544@27176L8,547@27333L12");
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i4 &= -113;
                    } else {
                        wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    }
                    if (i19 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if ((i3 & 8) != 0) {
                        modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        modalExpandedShape = shape3;
                    }
                    if ((i3 & 32) != 0) {
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    } else {
                        wideNavigationRailColorsColors = wideNavigationRailColors2;
                    }
                    if (i5 != 0) {
                        function4 = null;
                    }
                    if (i7 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f;
                    }
                    if ((i3 & 256) != 0) {
                        windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        windowInsets3 = windowInsets;
                    }
                    if ((i3 & 512) != 0) {
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        i4 &= -1879048193;
                    } else {
                        arrangement = vertical;
                    }
                    if (i9 != 0) {
                        modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                    } else {
                        modalExpandedProperties = modalWideNavigationRailProperties;
                    }
                    if (i12 != 0) {
                        modifier3 = companion;
                        z5 = z4;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        shape6 = modalCollapsedShape;
                        windowInsets4 = windowInsets3;
                        shape7 = modalExpandedShape;
                        wideNavigationRailColors4 = wideNavigationRailColorsColors;
                        f3 = fM10168constructorimpl;
                        function5 = function4;
                        vertical3 = arrangement;
                        modalWideNavigationRailProperties3 = modalExpandedProperties;
                        contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = companion;
                        z5 = z4;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        shape6 = modalCollapsedShape;
                        windowInsets4 = windowInsets3;
                        shape7 = modalExpandedShape;
                        wideNavigationRailColors4 = wideNavigationRailColorsColors;
                        f3 = fM10168constructorimpl;
                        function5 = function4;
                        vertical3 = arrangement;
                        modalWideNavigationRailProperties3 = modalExpandedProperties;
                    }
                } else {
                    if (i18 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i4 &= -113;
                    } else {
                        wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    }
                    if (i19 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if ((i3 & 8) != 0) {
                        modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        modalExpandedShape = shape3;
                    }
                    if ((i3 & 32) != 0) {
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    } else {
                        wideNavigationRailColorsColors = wideNavigationRailColors2;
                    }
                    if (i5 != 0) {
                        function4 = null;
                    }
                    if (i7 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f;
                    }
                    if ((i3 & 256) != 0) {
                        windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        windowInsets3 = windowInsets;
                    }
                    if ((i3 & 512) != 0) {
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        i4 &= -1879048193;
                    } else {
                        arrangement = vertical;
                    }
                    if (i9 != 0) {
                        modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                    } else {
                        modalExpandedProperties = modalWideNavigationRailProperties;
                    }
                    if (i12 != 0) {
                        modifier3 = companion;
                        z5 = z4;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        shape6 = modalCollapsedShape;
                        windowInsets4 = windowInsets3;
                        shape7 = modalExpandedShape;
                        wideNavigationRailColors4 = wideNavigationRailColorsColors;
                        f3 = fM10168constructorimpl;
                        function5 = function4;
                        vertical3 = arrangement;
                        modalWideNavigationRailProperties3 = modalExpandedProperties;
                        contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                        modifier3 = companion;
                        z5 = z4;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        shape6 = modalCollapsedShape;
                        windowInsets4 = windowInsets3;
                        shape7 = modalExpandedShape;
                        wideNavigationRailColors4 = wideNavigationRailColorsColors;
                        f3 = fM10168constructorimpl;
                        function5 = function4;
                        vertical3 = arrangement;
                        modalWideNavigationRailProperties3 = modalExpandedProperties;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-94259026, i4, i14, "androidx.compose.material3.ModalWideNavigationRail (WideNavigationRail.kt:553)");
                }
                ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope3 = new ModalWideNavigationRailOverrideScope(modifier3, wideNavigationRailState3, z5, shape6, shape7, wideNavigationRailColors4, function5, f3, windowInsets4, vertical3, modalWideNavigationRailProperties3, contentPadding, function3, null);
                ProvidableCompositionLocal<ModalWideNavigationRailOverride> providableCompositionLocal3 = LocalModalWideNavigationRailOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(providableCompositionLocal3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((ModalWideNavigationRailOverride) objConsume3).ModalWideNavigationRail(modalWideNavigationRailOverrideScope3, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                wideNavigationRailState2 = wideNavigationRailState3;
                z3 = z5;
                shape4 = shape6;
                shape5 = shape7;
                wideNavigationRailColors3 = wideNavigationRailColors4;
                f2 = f3;
                windowInsets2 = windowInsets4;
                vertical2 = vertical3;
                modalWideNavigationRailProperties2 = modalWideNavigationRailProperties3;
                paddingValues2 = contentPadding;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                wideNavigationRailState2 = wideNavigationRailState;
                f2 = f;
                windowInsets2 = windowInsets;
                shape4 = modalCollapsedShape;
                shape5 = shape3;
                wideNavigationRailColors3 = wideNavigationRailColors2;
                function5 = function4;
                z3 = z;
                vertical2 = vertical;
                modalWideNavigationRailProperties2 = modalWideNavigationRailProperties;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier6 = modifier2;
                final Function2 function8 = function5;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.ModalWideNavigationRail_xKBSf_U$lambda$1(modifier6, wideNavigationRailState2, z3, shape4, shape5, wideNavigationRailColors3, function8, f2, windowInsets2, vertical2, modalWideNavigationRailProperties2, paddingValues2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i10 |= 48;
        if ((i2 & 384) != 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i10 |= i15;
        }
        i14 = i10;
        if ((i4 & 306783379) == 306783378) {
            z2 = true;
        } else {
            z2 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "540@26888L33,542@27015L19,543@27090L18,544@27176L8,547@27333L12");
            if ((i & 1) != 0) {
                if (i18 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 2) != 0) {
                    wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                    i4 &= -113;
                } else {
                    wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                }
                if (i19 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if ((i3 & 8) != 0) {
                    modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                }
                if ((i3 & 16) != 0) {
                    modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    modalExpandedShape = shape3;
                }
                if ((i3 & 32) != 0) {
                    wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -458753;
                } else {
                    wideNavigationRailColorsColors = wideNavigationRailColors2;
                }
                if (i5 != 0) {
                    function4 = null;
                }
                if (i7 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                } else {
                    fM10168constructorimpl = f;
                }
                if ((i3 & 256) != 0) {
                    windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i4 &= -234881025;
                } else {
                    windowInsets3 = windowInsets;
                }
                if ((i3 & 512) != 0) {
                    arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    i4 &= -1879048193;
                } else {
                    arrangement = vertical;
                }
                if (i9 != 0) {
                    modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                } else {
                    modalExpandedProperties = modalWideNavigationRailProperties;
                }
                if (i12 != 0) {
                    modifier3 = companion;
                    z5 = z4;
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    shape6 = modalCollapsedShape;
                    windowInsets4 = windowInsets3;
                    shape7 = modalExpandedShape;
                    wideNavigationRailColors4 = wideNavigationRailColorsColors;
                    f3 = fM10168constructorimpl;
                    function5 = function4;
                    vertical3 = arrangement;
                    modalWideNavigationRailProperties3 = modalExpandedProperties;
                    contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                    modifier3 = companion;
                    z5 = z4;
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    shape6 = modalCollapsedShape;
                    windowInsets4 = windowInsets3;
                    shape7 = modalExpandedShape;
                    wideNavigationRailColors4 = wideNavigationRailColorsColors;
                    f3 = fM10168constructorimpl;
                    function5 = function4;
                    vertical3 = arrangement;
                    modalWideNavigationRailProperties3 = modalExpandedProperties;
                }
            } else {
                if (i18 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 2) != 0) {
                    wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                    i4 &= -113;
                } else {
                    wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                }
                if (i19 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if ((i3 & 8) != 0) {
                    modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                }
                if ((i3 & 16) != 0) {
                    modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    modalExpandedShape = shape3;
                }
                if ((i3 & 32) != 0) {
                    wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -458753;
                } else {
                    wideNavigationRailColorsColors = wideNavigationRailColors2;
                }
                if (i5 != 0) {
                    function4 = null;
                }
                if (i7 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                } else {
                    fM10168constructorimpl = f;
                }
                if ((i3 & 256) != 0) {
                    windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i4 &= -234881025;
                } else {
                    windowInsets3 = windowInsets;
                }
                if ((i3 & 512) != 0) {
                    arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    i4 &= -1879048193;
                } else {
                    arrangement = vertical;
                }
                if (i9 != 0) {
                    modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                } else {
                    modalExpandedProperties = modalWideNavigationRailProperties;
                }
                if (i12 != 0) {
                    modifier3 = companion;
                    z5 = z4;
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    shape6 = modalCollapsedShape;
                    windowInsets4 = windowInsets3;
                    shape7 = modalExpandedShape;
                    wideNavigationRailColors4 = wideNavigationRailColorsColors;
                    f3 = fM10168constructorimpl;
                    function5 = function4;
                    vertical3 = arrangement;
                    modalWideNavigationRailProperties3 = modalExpandedProperties;
                    contentPadding = WideNavigationRailDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                    modifier3 = companion;
                    z5 = z4;
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    shape6 = modalCollapsedShape;
                    windowInsets4 = windowInsets3;
                    shape7 = modalExpandedShape;
                    wideNavigationRailColors4 = wideNavigationRailColorsColors;
                    f3 = fM10168constructorimpl;
                    function5 = function4;
                    vertical3 = arrangement;
                    modalWideNavigationRailProperties3 = modalExpandedProperties;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-94259026, i4, i14, "androidx.compose.material3.ModalWideNavigationRail (WideNavigationRail.kt:553)");
            }
            ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope4 = new ModalWideNavigationRailOverrideScope(modifier3, wideNavigationRailState3, z5, shape6, shape7, wideNavigationRailColors4, function5, f3, windowInsets4, vertical3, modalWideNavigationRailProperties3, contentPadding, function3, null);
            ProvidableCompositionLocal<ModalWideNavigationRailOverride> providableCompositionLocal4 = LocalModalWideNavigationRailOverride;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(providableCompositionLocal4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ((ModalWideNavigationRailOverride) objConsume4).ModalWideNavigationRail(modalWideNavigationRailOverrideScope4, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            wideNavigationRailState2 = wideNavigationRailState3;
            z3 = z5;
            shape4 = shape6;
            shape5 = shape7;
            wideNavigationRailColors3 = wideNavigationRailColors4;
            f2 = f3;
            windowInsets2 = windowInsets4;
            vertical2 = vertical3;
            modalWideNavigationRailProperties2 = modalWideNavigationRailProperties3;
            paddingValues2 = contentPadding;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            wideNavigationRailState2 = wideNavigationRailState;
            f2 = f;
            windowInsets2 = windowInsets;
            shape4 = modalCollapsedShape;
            shape5 = shape3;
            wideNavigationRailColors3 = wideNavigationRailColors2;
            function5 = function4;
            z3 = z;
            vertical2 = vertical;
            modalWideNavigationRailProperties2 = modalWideNavigationRailProperties;
            paddingValues2 = paddingValues;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier2;
            final Function2 function9 = function5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.ModalWideNavigationRail_xKBSf_U$lambda$1(modifier7, wideNavigationRailState2, z3, shape4, shape5, wideNavigationRailColors3, function9, f2, windowInsets2, vertical2, modalWideNavigationRailProperties2, paddingValues2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x011e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0134  */
    /* JADX WARN: Code duplicated, block: B:112:0x013a  */
    /* JADX WARN: Code duplicated, block: B:113:0x0141  */
    /* JADX WARN: Code duplicated, block: B:115:0x0145  */
    /* JADX WARN: Code duplicated, block: B:117:0x014f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0152  */
    /* JADX WARN: Code duplicated, block: B:120:0x0157  */
    /* JADX WARN: Code duplicated, block: B:123:0x0163  */
    /* JADX WARN: Code duplicated, block: B:125:0x0169  */
    /* JADX WARN: Code duplicated, block: B:126:0x016c  */
    /* JADX WARN: Code duplicated, block: B:134:0x0188  */
    /* JADX WARN: Code duplicated, block: B:137:0x0191  */
    /* JADX WARN: Code duplicated, block: B:162:0x01ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:163:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:164:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:167:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:168:0x0205  */
    /* JADX WARN: Code duplicated, block: B:171:0x020b  */
    /* JADX WARN: Code duplicated, block: B:174:0x0211  */
    /* JADX WARN: Code duplicated, block: B:175:0x021a  */
    /* JADX WARN: Code duplicated, block: B:178:0x021f  */
    /* JADX WARN: Code duplicated, block: B:179:0x0228  */
    /* JADX WARN: Code duplicated, block: B:182:0x022d  */
    /* JADX WARN: Code duplicated, block: B:183:0x0239  */
    /* JADX WARN: Code duplicated, block: B:186:0x023e  */
    /* JADX WARN: Code duplicated, block: B:188:0x0241  */
    /* JADX WARN: Code duplicated, block: B:189:0x0247  */
    /* JADX WARN: Code duplicated, block: B:192:0x024c  */
    /* JADX WARN: Code duplicated, block: B:193:0x0257  */
    /* JADX WARN: Code duplicated, block: B:196:0x025d  */
    /* JADX WARN: Code duplicated, block: B:197:0x0268  */
    /* JADX WARN: Code duplicated, block: B:199:0x026c  */
    /* JADX WARN: Code duplicated, block: B:200:0x0285  */
    /* JADX WARN: Code duplicated, block: B:204:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:207:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:209:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:212:0x0304  */
    /* JADX WARN: Code duplicated, block: B:214:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:90:0x0100  */
    /* JADX WARN: Code duplicated, block: B:98:0x0116  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of function with contentPadding parameter")
    /* JADX INFO: renamed from: ModalWideNavigationRail-k3FuEkE, reason: not valid java name */
    public static final /* synthetic */ void m5248ModalWideNavigationRailk3FuEkE(Modifier modifier, WideNavigationRailState wideNavigationRailState, boolean z, Shape shape, Shape shape2, WideNavigationRailColors wideNavigationRailColors, Function2 function2, float f, WindowInsets windowInsets, Arrangement.Vertical vertical, ModalWideNavigationRailProperties modalWideNavigationRailProperties, final Function2 function3, Composer composer, final int i, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape3;
        Shape shape4;
        int i5;
        Function2 function4;
        int i6;
        int i7;
        float f2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z3;
        Composer composer2;
        final WideNavigationRailState wideNavigationRailState2;
        final WindowInsets windowInsets2;
        final Function2 function5;
        final Modifier modifier3;
        final float f3;
        final boolean z4;
        final Shape shape5;
        final Shape shape6;
        final WideNavigationRailColors wideNavigationRailColors2;
        final Arrangement.Vertical vertical2;
        final ModalWideNavigationRailProperties modalWideNavigationRailProperties2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        WideNavigationRailState wideNavigationRailStateRememberWideNavigationRailState;
        Shape modalCollapsedShape;
        Shape modalExpandedShape;
        WideNavigationRailColors wideNavigationRailColorsColors;
        Function2 function6;
        float fM10168constructorimpl;
        WindowInsets windowInsets3;
        Arrangement.Vertical arrangement;
        ModalWideNavigationRailProperties modalExpandedProperties;
        Shape shape7;
        WideNavigationRailColors wideNavigationRailColors3;
        int i13;
        int i14;
        int i15;
        Composer composerStartRestartGroup = composer.startRestartGroup(-38559147);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalWideNavigationRail)N(modifier,state,hideOnCollapse,collapsedShape,expandedShape,colors,header,expandedHeaderTopPadding:c#ui.unit.Dp,windowInsets,arrangement,expandedProperties,content)628@31609L530:WideNavigationRail.kt#uh7d8r");
        int i16 = i3 & 1;
        if (i16 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 48) == 0) {
            if ((i3 & 2) != 0) {
                i15 = 16;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(wideNavigationRailState) : composerStartRestartGroup.changedInstance(wideNavigationRailState)) {
                    i15 = 32;
                } else {
                    i15 = 16;
                }
            }
            i4 |= i15;
        }
        int i17 = i3 & 4;
        if (i17 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    shape3 = shape;
                    int i18 = composerStartRestartGroup.changed(shape3) ? 2048 : 1024;
                    i4 |= i18;
                } else {
                    shape3 = shape;
                }
                i4 |= i18;
            } else {
                shape3 = shape;
            }
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    shape4 = shape2;
                    int i19 = composerStartRestartGroup.changed(shape4) ? 16384 : 8192;
                    i4 |= i19;
                } else {
                    shape4 = shape2;
                }
                i4 |= i19;
            } else {
                shape4 = shape2;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(wideNavigationRailColors)) {
                    i14 = 65536;
                } else {
                    i14 = 131072;
                }
                i4 |= i14;
            }
            i5 = i3 & 64;
            if (i5 != 0) {
                i4 |= 1572864;
                function4 = function2;
            } else {
                function4 = function2;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                    i4 |= i6;
                }
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
            }
            if ((i & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            if ((i & 805306368) != 0) {
                i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(vertical)) ? 268435456 : 536870912;
            }
            i9 = i3 & 1024;
            if (i9 != 0) {
                i10 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(modalWideNavigationRailProperties)) {
                    i11 = 4;
                } else {
                    i11 = 2;
                }
                i10 = i2 | i11;
            } else {
                i10 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 32;
                } else {
                    i13 = 16;
                }
                i10 |= i13;
            }
            i12 = i10;
            if ((i4 & 306783379) == 306783378 || (i12 & 19) != 18) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "615@30905L33,617@31032L19,618@31107L18,619@31193L8,622@31350L12");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i16 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        z5 = false;
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i4 &= -113;
                    } else {
                        z5 = false;
                        wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    }
                    if (i17 == 0) {
                        z5 = z2;
                    }
                    if ((i3 & 8) != 0) {
                        modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        modalCollapsedShape = shape3;
                    }
                    if ((i3 & 16) != 0) {
                        modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        modalExpandedShape = shape4;
                    }
                    if ((i3 & 32) != 0) {
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    } else {
                        wideNavigationRailColorsColors = wideNavigationRailColors;
                    }
                    function6 = i5 == 0 ? function4 : null;
                    if (i7 != 0) {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    } else {
                        fM10168constructorimpl = f2;
                    }
                    if ((i3 & 256) != 0) {
                        windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        windowInsets3 = windowInsets;
                    }
                    if ((i3 & 512) != 0) {
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        i4 &= -1879048193;
                    } else {
                        arrangement = vertical;
                    }
                    if (i9 != 0) {
                        modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                    } else {
                        modalExpandedProperties = modalWideNavigationRailProperties;
                    }
                    shape7 = modalExpandedShape;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 2) != 0) {
                        i4 &= -113;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                    }
                    if ((i3 & 256) != 0) {
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i4 &= -1879048193;
                    }
                    wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    wideNavigationRailColors3 = wideNavigationRailColors;
                    windowInsets3 = windowInsets;
                    arrangement = vertical;
                    modalExpandedProperties = modalWideNavigationRailProperties;
                    function6 = function4;
                    companion = modifier2;
                    fM10168constructorimpl = f2;
                    z5 = z2;
                    modalCollapsedShape = shape3;
                    shape7 = shape4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-38559147, i4, i12, "androidx.compose.material3.ModalWideNavigationRail (WideNavigationRail.kt:627)");
                }
                composer2 = composerStartRestartGroup;
                m5249ModalWideNavigationRailxKBSfU(companion, wideNavigationRailStateRememberWideNavigationRailState, z5, modalCollapsedShape, shape7, wideNavigationRailColors3, function6, fM10168constructorimpl, windowInsets3, arrangement, modalExpandedProperties, WideNavigationRailDefaults.INSTANCE.getContentPadding(), function3, composer2, i4 & 2147483646, (i12 & 14) | 48 | ((i12 << 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                wideNavigationRailState2 = wideNavigationRailStateRememberWideNavigationRailState;
                z4 = z5;
                shape5 = modalCollapsedShape;
                shape6 = shape7;
                wideNavigationRailColors2 = wideNavigationRailColors3;
                function5 = function6;
                f3 = fM10168constructorimpl;
                windowInsets2 = windowInsets3;
                vertical2 = arrangement;
                modalWideNavigationRailProperties2 = modalExpandedProperties;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                wideNavigationRailState2 = wideNavigationRailState;
                windowInsets2 = windowInsets;
                function5 = function4;
                modifier3 = modifier2;
                f3 = f2;
                z4 = z2;
                shape5 = shape3;
                shape6 = shape4;
                wideNavigationRailColors2 = wideNavigationRailColors;
                vertical2 = vertical;
                modalWideNavigationRailProperties2 = modalWideNavigationRailProperties;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.ModalWideNavigationRail_k3FuEkE$lambda$0(modifier3, wideNavigationRailState2, z4, shape5, shape6, wideNavigationRailColors2, function5, f3, windowInsets2, vertical2, modalWideNavigationRailProperties2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i3 & 8) == 0) {
                shape3 = shape;
                if (composerStartRestartGroup.changed(shape3)) {
                }
                i4 |= i18;
            } else {
                shape3 = shape;
            }
            i4 |= i18;
        } else {
            shape3 = shape;
        }
        if ((i & 24576) == 0) {
            if ((i3 & 16) == 0) {
                shape4 = shape2;
                if (composerStartRestartGroup.changed(shape4)) {
                }
                i4 |= i19;
            } else {
                shape4 = shape2;
            }
            i4 |= i19;
        } else {
            shape4 = shape2;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            if ((i3 & 32) == 0) {
                i14 = 65536;
            } else {
                i14 = 65536;
            }
            i4 |= i14;
        }
        i5 = i3 & 64;
        if (i5 != 0) {
            i4 |= 1572864;
            function4 = function2;
        } else {
            function4 = function2;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i4 |= i6;
            }
        }
        i7 = i3 & 128;
        if (i7 != 0) {
            i4 |= 12582912;
            f2 = f;
        } else {
            f2 = f;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i4 |= i8;
            }
        }
        if ((i & 100663296) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
        }
        if ((i & 805306368) != 0) {
            i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(vertical)) ? 268435456 : 536870912;
        }
        i9 = i3 & 1024;
        if (i9 != 0) {
            i10 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changed(modalWideNavigationRailProperties)) {
                i11 = 4;
            } else {
                i11 = 2;
            }
            i10 = i2 | i11;
        } else {
            i10 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i10 |= i13;
        }
        i12 = i10;
        if ((i4 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "615@30905L33,617@31032L19,618@31107L18,619@31193L8,622@31350L12");
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 2) != 0) {
                    z5 = false;
                    wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                    i4 &= -113;
                } else {
                    z5 = false;
                    wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                }
                if (i17 == 0) {
                    z5 = z2;
                }
                if ((i3 & 8) != 0) {
                    modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    modalCollapsedShape = shape3;
                }
                if ((i3 & 16) != 0) {
                    modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    modalExpandedShape = shape4;
                }
                if ((i3 & 32) != 0) {
                    wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -458753;
                } else {
                    wideNavigationRailColorsColors = wideNavigationRailColors;
                }
                if (i5 == 0) {
                }
                if (i7 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                } else {
                    fM10168constructorimpl = f2;
                }
                if ((i3 & 256) != 0) {
                    windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i4 &= -234881025;
                } else {
                    windowInsets3 = windowInsets;
                }
                if ((i3 & 512) != 0) {
                    arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    i4 &= -1879048193;
                } else {
                    arrangement = vertical;
                }
                if (i9 != 0) {
                    modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                } else {
                    modalExpandedProperties = modalWideNavigationRailProperties;
                }
                shape7 = modalExpandedShape;
                wideNavigationRailColors3 = wideNavigationRailColorsColors;
            } else {
                if (i16 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 2) != 0) {
                    z5 = false;
                    wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                    i4 &= -113;
                } else {
                    z5 = false;
                    wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                }
                if (i17 == 0) {
                    z5 = z2;
                }
                if ((i3 & 8) != 0) {
                    modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    modalCollapsedShape = shape3;
                }
                if ((i3 & 16) != 0) {
                    modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    modalExpandedShape = shape4;
                }
                if ((i3 & 32) != 0) {
                    wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -458753;
                } else {
                    wideNavigationRailColorsColors = wideNavigationRailColors;
                }
                if (i5 == 0) {
                }
                if (i7 != 0) {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                } else {
                    fM10168constructorimpl = f2;
                }
                if ((i3 & 256) != 0) {
                    windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i4 &= -234881025;
                } else {
                    windowInsets3 = windowInsets;
                }
                if ((i3 & 512) != 0) {
                    arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    i4 &= -1879048193;
                } else {
                    arrangement = vertical;
                }
                if (i9 != 0) {
                    modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                } else {
                    modalExpandedProperties = modalWideNavigationRailProperties;
                }
                shape7 = modalExpandedShape;
                wideNavigationRailColors3 = wideNavigationRailColorsColors;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-38559147, i4, i12, "androidx.compose.material3.ModalWideNavigationRail (WideNavigationRail.kt:627)");
            }
            composer2 = composerStartRestartGroup;
            m5249ModalWideNavigationRailxKBSfU(companion, wideNavigationRailStateRememberWideNavigationRailState, z5, modalCollapsedShape, shape7, wideNavigationRailColors3, function6, fM10168constructorimpl, windowInsets3, arrangement, modalExpandedProperties, WideNavigationRailDefaults.INSTANCE.getContentPadding(), function3, composer2, i4 & 2147483646, (i12 & 14) | 48 | ((i12 << 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            wideNavigationRailState2 = wideNavigationRailStateRememberWideNavigationRailState;
            z4 = z5;
            shape5 = modalCollapsedShape;
            shape6 = shape7;
            wideNavigationRailColors2 = wideNavigationRailColors3;
            function5 = function6;
            f3 = fM10168constructorimpl;
            windowInsets2 = windowInsets3;
            vertical2 = arrangement;
            modalWideNavigationRailProperties2 = modalExpandedProperties;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            wideNavigationRailState2 = wideNavigationRailState;
            windowInsets2 = windowInsets;
            function5 = function4;
            modifier3 = modifier2;
            f3 = f2;
            z4 = z2;
            shape5 = shape3;
            shape6 = shape4;
            wideNavigationRailColors2 = wideNavigationRailColors;
            vertical2 = vertical;
            modalWideNavigationRailProperties2 = modalWideNavigationRailProperties;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.ModalWideNavigationRail_k3FuEkE$lambda$0(modifier3, wideNavigationRailState2, z4, shape5, shape6, wideNavigationRailColors2, function5, f3, windowInsets2, vertical2, modalWideNavigationRailProperties2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x011b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:105:0x0122  */
    /* JADX WARN: Code duplicated, block: B:108:0x0134  */
    /* JADX WARN: Code duplicated, block: B:112:0x013c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0146  */
    /* JADX WARN: Code duplicated, block: B:117:0x0159  */
    /* JADX WARN: Code duplicated, block: B:131:0x0189 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x018b  */
    /* JADX WARN: Code duplicated, block: B:135:0x0193  */
    /* JADX WARN: Code duplicated, block: B:138:0x0199  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:143:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:146:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:149:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:150:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:154:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:156:0x0209  */
    /* JADX WARN: Code duplicated, block: B:158:0x0228  */
    /* JADX WARN: Code duplicated, block: B:160:0x023a  */
    /* JADX WARN: Code duplicated, block: B:163:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:165:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:168:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:84:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:92:0x0101  */
    /* JADX WARN: Code duplicated, block: B:93:0x0104  */
    /* JADX WARN: Code duplicated, block: B:97:0x010c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0110  */
    /* JADX INFO: renamed from: WideNavigationRailItem-U_vOP4k, reason: not valid java name */
    public static final void m5251WideNavigationRailItemU_vOP4k(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final boolean z2, Modifier modifier, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, PaddingValues paddingValues, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Function0<Unit> function1;
        Function2<? super Composer, ? super Integer, Unit> function4;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Modifier modifier2;
        int i6;
        boolean z4;
        int i7;
        int iM5246iconPositionFors8pcRp0;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z5;
        Composer composer2;
        final NavigationItemColors navigationItemColors2;
        final PaddingValues paddingValues2;
        final int i12;
        final Modifier modifier3;
        final boolean z6;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        NavigationItemColors navigationItemColorsColors;
        MutableInteractionSource mutableInteractionSource3;
        Composer composer3;
        PaddingValues paddingValuesIndicatorPadding;
        int i14;
        NavigationItemColors navigationItemColors3;
        Modifier modifier4;
        int i15;
        boolean z7;
        MutableInteractionSource mutableInteractionSource4;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(1807770593);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRailItem)N(selected,onClick,icon,label,railExpanded,modifier,enabled,iconPosition:c#material3.NavigationItemIconPosition,colors,interactionSource,indicatorPadding)863@42356L5,865@42529L5,866@42619L5,859@42176L1005:WideNavigationRail.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            function1 = function0;
            i5 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        if ((i2 & 384) == 0) {
            function4 = function2;
            i5 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
        } else {
            function4 = function2;
        }
        if ((i2 & 3072) == 0) {
            function5 = function3;
            i5 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function3;
        }
        if ((i2 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        int i16 = i4 & 32;
        if (i16 == 0) {
            if ((196608 & i2) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            i6 = i4 & 64;
            if (i6 != 0) {
                if ((1572864 & i2) == 0) {
                    z4 = z3;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i5 |= i7;
                }
                if ((i2 & 12582912) == 0) {
                    if ((i4 & 128) == 0) {
                        iM5246iconPositionFors8pcRp0 = i;
                        int i17 = composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0) ? 8388608 : 4194304;
                        i5 |= i17;
                    } else {
                        iM5246iconPositionFors8pcRp0 = i;
                    }
                    i5 |= i17;
                } else {
                    iM5246iconPositionFors8pcRp0 = i;
                }
                if ((i2 & 100663296) != 0) {
                    i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
                }
                i8 = i4 & 512;
                if (i8 != 0) {
                    i5 |= 805306368;
                } else if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 536870912;
                    } else {
                        i9 = 268435456;
                    }
                    i5 |= i9;
                }
                if ((i3 & 6) == 0) {
                    i10 = i3 | (((i4 & 1024) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 2 : 4);
                } else {
                    i10 = i3;
                }
                i11 = i5;
                if ((i5 & 306783379) == 306783378 || (i10 & 3) != 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "851@41855L8,854@41999L45");
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        boolean z8 = i6 == 0 ? z4 : true;
                        if ((i4 & 128) != 0) {
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                            i13 = i11 & (-29360129);
                        } else {
                            i13 = i11;
                        }
                        if ((i4 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i8 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i4 & 1024) != 0) {
                            composer3 = composerStartRestartGroup;
                            i10 &= -15;
                            paddingValuesIndicatorPadding = WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i13 >> 12) & 14) | 3072, 6);
                        } else {
                            composer3 = composerStartRestartGroup;
                            paddingValuesIndicatorPadding = paddingValues;
                        }
                        i14 = iM5246iconPositionFors8pcRp0;
                        navigationItemColors3 = navigationItemColorsColors;
                        modifier4 = modifier2;
                        i15 = i10;
                        z7 = z8;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i13 = (i4 & 128) != 0 ? i11 & (-29360129) : i11;
                        if ((i4 & 256) != 0) {
                            i13 &= -234881025;
                        }
                        if ((i4 & 1024) != 0) {
                            i10 &= -15;
                        }
                        navigationItemColors3 = navigationItemColors;
                        mutableInteractionSource3 = mutableInteractionSource;
                        paddingValuesIndicatorPadding = paddingValues;
                        composer3 = composerStartRestartGroup;
                        i14 = iM5246iconPositionFors8pcRp0;
                        modifier4 = modifier2;
                        z7 = z4;
                        i15 = i10;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1807770593, i13, i15, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:855)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composer3.startReplaceGroup(699505146);
                        ComposerKt.sourceInformation(composer3, "857@42131L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, 2100774664, "CC(remember):WideNavigationRail.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composer3.startReplaceGroup(2100774013);
                        composer3.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    int i18 = i13 >> 6;
                    composer2 = composer3;
                    NavigationItemKt.m4424AnimatedNavigationItemj37qMnw(z, function1, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composer3, 6), NavigationRailVerticalItemTokens.INSTANCE.m6000getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composer3, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composer3, 6), paddingValuesIndicatorPadding, NavigationRailVerticalItemTokens.INSTANCE.m6001getIconLabelSpaceD9Ej5fM(), WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5997getIconLabelSpaceD9Ej5fM(), WNRItemHorizontalPadding, navigationItemColors3, modifier4, z7, function5, i14, mutableInteractionSource4, composer2, (i13 & 14) | 905994240 | (i13 & 112) | (i13 & 896) | ((i15 << 21) & 29360128), ((i13 >> 18) & 896) | 54 | (i18 & 7168) | (i18 & 57344) | ((i13 << 6) & 458752) | ((i13 >> 3) & 3670016));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    paddingValues2 = paddingValuesIndicatorPadding;
                    navigationItemColors2 = navigationItemColors3;
                    modifier3 = modifier4;
                    z6 = z7;
                    i12 = i14;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    paddingValues2 = paddingValues;
                    i12 = iM5246iconPositionFors8pcRp0;
                    modifier3 = modifier2;
                    z6 = z4;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_U_vOP4k$lambda$1(z, function0, function2, function3, z2, modifier3, z6, i12, navigationItemColors2, mutableInteractionSource2, paddingValues2, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 1572864;
            z4 = z3;
            if ((i2 & 12582912) == 0) {
                if ((i4 & 128) == 0) {
                    iM5246iconPositionFors8pcRp0 = i;
                    if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                    }
                    i5 |= i17;
                } else {
                    iM5246iconPositionFors8pcRp0 = i;
                }
                i5 |= i17;
            } else {
                iM5246iconPositionFors8pcRp0 = i;
            }
            if ((i2 & 100663296) != 0) {
                i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i8 = i4 & 512;
            if (i8 != 0) {
                i5 |= 805306368;
            } else if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 536870912;
                } else {
                    i9 = 268435456;
                }
                i5 |= i9;
            }
            if ((i3 & 6) == 0) {
                i10 = i3 | (((i4 & 1024) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 2 : 4);
            } else {
                i10 = i3;
            }
            i11 = i5;
            if ((i5 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "851@41855L8,854@41999L45");
                if ((i2 & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 == 0) {
                    }
                    if ((i4 & 128) != 0) {
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                        i13 = i11 & (-29360129);
                    } else {
                        i13 = i11;
                    }
                    if ((i4 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i8 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i4 & 1024) != 0) {
                        composer3 = composerStartRestartGroup;
                        i10 &= -15;
                        paddingValuesIndicatorPadding = WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i13 >> 12) & 14) | 3072, 6);
                    } else {
                        composer3 = composerStartRestartGroup;
                        paddingValuesIndicatorPadding = paddingValues;
                    }
                    i14 = iM5246iconPositionFors8pcRp0;
                    navigationItemColors3 = navigationItemColorsColors;
                    modifier4 = modifier2;
                    i15 = i10;
                    z7 = z8;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 == 0) {
                    }
                    if ((i4 & 128) != 0) {
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                        i13 = i11 & (-29360129);
                    } else {
                        i13 = i11;
                    }
                    if ((i4 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i8 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i4 & 1024) != 0) {
                        composer3 = composerStartRestartGroup;
                        i10 &= -15;
                        paddingValuesIndicatorPadding = WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i13 >> 12) & 14) | 3072, 6);
                    } else {
                        composer3 = composerStartRestartGroup;
                        paddingValuesIndicatorPadding = paddingValues;
                    }
                    i14 = iM5246iconPositionFors8pcRp0;
                    navigationItemColors3 = navigationItemColorsColors;
                    modifier4 = modifier2;
                    i15 = i10;
                    z7 = z8;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1807770593, i13, i15, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:855)");
                }
                if (mutableInteractionSource3 == null) {
                    composer3.startReplaceGroup(699505146);
                    ComposerKt.sourceInformation(composer3, "857@42131L39");
                    ComposerKt.sourceInformationMarkerStart(composer3, 2100774664, "CC(remember):WideNavigationRail.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composer3.startReplaceGroup(2100774013);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                int i19 = i13 >> 6;
                composer2 = composer3;
                NavigationItemKt.m4424AnimatedNavigationItemj37qMnw(z, function1, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composer3, 6), NavigationRailVerticalItemTokens.INSTANCE.m6000getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composer3, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composer3, 6), paddingValuesIndicatorPadding, NavigationRailVerticalItemTokens.INSTANCE.m6001getIconLabelSpaceD9Ej5fM(), WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5997getIconLabelSpaceD9Ej5fM(), WNRItemHorizontalPadding, navigationItemColors3, modifier4, z7, function5, i14, mutableInteractionSource4, composer2, (i13 & 14) | 905994240 | (i13 & 112) | (i13 & 896) | ((i15 << 21) & 29360128), ((i13 >> 18) & 896) | 54 | (i19 & 7168) | (i19 & 57344) | ((i13 << 6) & 458752) | ((i13 >> 3) & 3670016));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                paddingValues2 = paddingValuesIndicatorPadding;
                navigationItemColors2 = navigationItemColors3;
                modifier3 = modifier4;
                z6 = z7;
                i12 = i14;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationItemColors2 = navigationItemColors;
                paddingValues2 = paddingValues;
                i12 = iM5246iconPositionFors8pcRp0;
                modifier3 = modifier2;
                z6 = z4;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_U_vOP4k$lambda$1(z, function0, function2, function3, z2, modifier3, z6, i12, navigationItemColors2, mutableInteractionSource2, paddingValues2, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        i6 = i4 & 64;
        if (i6 != 0) {
            if ((1572864 & i2) == 0) {
                z4 = z3;
                if (composerStartRestartGroup.changed(z4)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i5 |= i7;
            }
            if ((i2 & 12582912) == 0) {
                if ((i4 & 128) == 0) {
                    iM5246iconPositionFors8pcRp0 = i;
                    if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                    }
                    i5 |= i17;
                } else {
                    iM5246iconPositionFors8pcRp0 = i;
                }
                i5 |= i17;
            } else {
                iM5246iconPositionFors8pcRp0 = i;
            }
            if ((i2 & 100663296) != 0) {
                i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i8 = i4 & 512;
            if (i8 != 0) {
                i5 |= 805306368;
            } else if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 536870912;
                } else {
                    i9 = 268435456;
                }
                i5 |= i9;
            }
            if ((i3 & 6) == 0) {
                i10 = i3 | (((i4 & 1024) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 2 : 4);
            } else {
                i10 = i3;
            }
            i11 = i5;
            if ((i5 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "851@41855L8,854@41999L45");
                if ((i2 & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 == 0) {
                    }
                    if ((i4 & 128) != 0) {
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                        i13 = i11 & (-29360129);
                    } else {
                        i13 = i11;
                    }
                    if ((i4 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i8 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i4 & 1024) != 0) {
                        composer3 = composerStartRestartGroup;
                        i10 &= -15;
                        paddingValuesIndicatorPadding = WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i13 >> 12) & 14) | 3072, 6);
                    } else {
                        composer3 = composerStartRestartGroup;
                        paddingValuesIndicatorPadding = paddingValues;
                    }
                    i14 = iM5246iconPositionFors8pcRp0;
                    navigationItemColors3 = navigationItemColorsColors;
                    modifier4 = modifier2;
                    i15 = i10;
                    z7 = z8;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 == 0) {
                    }
                    if ((i4 & 128) != 0) {
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                        i13 = i11 & (-29360129);
                    } else {
                        i13 = i11;
                    }
                    if ((i4 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i8 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i4 & 1024) != 0) {
                        composer3 = composerStartRestartGroup;
                        i10 &= -15;
                        paddingValuesIndicatorPadding = WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i13 >> 12) & 14) | 3072, 6);
                    } else {
                        composer3 = composerStartRestartGroup;
                        paddingValuesIndicatorPadding = paddingValues;
                    }
                    i14 = iM5246iconPositionFors8pcRp0;
                    navigationItemColors3 = navigationItemColorsColors;
                    modifier4 = modifier2;
                    i15 = i10;
                    z7 = z8;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1807770593, i13, i15, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:855)");
                }
                if (mutableInteractionSource3 == null) {
                    composer3.startReplaceGroup(699505146);
                    ComposerKt.sourceInformation(composer3, "857@42131L39");
                    ComposerKt.sourceInformationMarkerStart(composer3, 2100774664, "CC(remember):WideNavigationRail.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composer3.startReplaceGroup(2100774013);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                int i110 = i13 >> 6;
                composer2 = composer3;
                NavigationItemKt.m4424AnimatedNavigationItemj37qMnw(z, function1, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composer3, 6), NavigationRailVerticalItemTokens.INSTANCE.m6000getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composer3, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composer3, 6), paddingValuesIndicatorPadding, NavigationRailVerticalItemTokens.INSTANCE.m6001getIconLabelSpaceD9Ej5fM(), WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5997getIconLabelSpaceD9Ej5fM(), WNRItemHorizontalPadding, navigationItemColors3, modifier4, z7, function5, i14, mutableInteractionSource4, composer2, (i13 & 14) | 905994240 | (i13 & 112) | (i13 & 896) | ((i15 << 21) & 29360128), ((i13 >> 18) & 896) | 54 | (i110 & 7168) | (i110 & 57344) | ((i13 << 6) & 458752) | ((i13 >> 3) & 3670016));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                paddingValues2 = paddingValuesIndicatorPadding;
                navigationItemColors2 = navigationItemColors3;
                modifier3 = modifier4;
                z6 = z7;
                i12 = i14;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationItemColors2 = navigationItemColors;
                paddingValues2 = paddingValues;
                i12 = iM5246iconPositionFors8pcRp0;
                modifier3 = modifier2;
                z6 = z4;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_U_vOP4k$lambda$1(z, function0, function2, function3, z2, modifier3, z6, i12, navigationItemColors2, mutableInteractionSource2, paddingValues2, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 1572864;
        z4 = z3;
        if ((i2 & 12582912) == 0) {
            if ((i4 & 128) == 0) {
                iM5246iconPositionFors8pcRp0 = i;
                if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                }
                i5 |= i17;
            } else {
                iM5246iconPositionFors8pcRp0 = i;
            }
            i5 |= i17;
        } else {
            iM5246iconPositionFors8pcRp0 = i;
        }
        if ((i2 & 100663296) != 0) {
            i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
        }
        i8 = i4 & 512;
        if (i8 != 0) {
            i5 |= 805306368;
        } else if ((i2 & 805306368) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i9 = 536870912;
            } else {
                i9 = 268435456;
            }
            i5 |= i9;
        }
        if ((i3 & 6) == 0) {
            i10 = i3 | (((i4 & 1024) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 2 : 4);
        } else {
            i10 = i3;
        }
        i11 = i5;
        if ((i5 & 306783379) == 306783378) {
            z5 = true;
        } else {
            z5 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i11 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "851@41855L8,854@41999L45");
            if ((i2 & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 == 0) {
                }
                if ((i4 & 128) != 0) {
                    iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                    i13 = i11 & (-29360129);
                } else {
                    i13 = i11;
                }
                if ((i4 & 256) != 0) {
                    navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i13 &= -234881025;
                } else {
                    navigationItemColorsColors = navigationItemColors;
                }
                if (i8 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i4 & 1024) != 0) {
                    composer3 = composerStartRestartGroup;
                    i10 &= -15;
                    paddingValuesIndicatorPadding = WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i13 >> 12) & 14) | 3072, 6);
                } else {
                    composer3 = composerStartRestartGroup;
                    paddingValuesIndicatorPadding = paddingValues;
                }
                i14 = iM5246iconPositionFors8pcRp0;
                navigationItemColors3 = navigationItemColorsColors;
                modifier4 = modifier2;
                i15 = i10;
                z7 = z8;
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 == 0) {
                }
                if ((i4 & 128) != 0) {
                    iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                    i13 = i11 & (-29360129);
                } else {
                    i13 = i11;
                }
                if ((i4 & 256) != 0) {
                    navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i13 &= -234881025;
                } else {
                    navigationItemColorsColors = navigationItemColors;
                }
                if (i8 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i4 & 1024) != 0) {
                    composer3 = composerStartRestartGroup;
                    i10 &= -15;
                    paddingValuesIndicatorPadding = WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i13 >> 12) & 14) | 3072, 6);
                } else {
                    composer3 = composerStartRestartGroup;
                    paddingValuesIndicatorPadding = paddingValues;
                }
                i14 = iM5246iconPositionFors8pcRp0;
                navigationItemColors3 = navigationItemColorsColors;
                modifier4 = modifier2;
                i15 = i10;
                z7 = z8;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1807770593, i13, i15, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:855)");
            }
            if (mutableInteractionSource3 == null) {
                composer3.startReplaceGroup(699505146);
                ComposerKt.sourceInformation(composer3, "857@42131L39");
                ComposerKt.sourceInformationMarkerStart(composer3, 2100774664, "CC(remember):WideNavigationRail.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceGroup();
                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
            } else {
                composer3.startReplaceGroup(2100774013);
                composer3.endReplaceGroup();
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            int i111 = i13 >> 6;
            composer2 = composer3;
            NavigationItemKt.m4424AnimatedNavigationItemj37qMnw(z, function1, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composer3, 6), NavigationRailVerticalItemTokens.INSTANCE.m6000getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composer3, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composer3, 6), paddingValuesIndicatorPadding, NavigationRailVerticalItemTokens.INSTANCE.m6001getIconLabelSpaceD9Ej5fM(), WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5997getIconLabelSpaceD9Ej5fM(), WNRItemHorizontalPadding, navigationItemColors3, modifier4, z7, function5, i14, mutableInteractionSource4, composer2, (i13 & 14) | 905994240 | (i13 & 112) | (i13 & 896) | ((i15 << 21) & 29360128), ((i13 >> 18) & 896) | 54 | (i111 & 7168) | (i111 & 57344) | ((i13 << 6) & 458752) | ((i13 >> 3) & 3670016));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource2 = mutableInteractionSource3;
            paddingValues2 = paddingValuesIndicatorPadding;
            navigationItemColors2 = navigationItemColors3;
            modifier3 = modifier4;
            z6 = z7;
            i12 = i14;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            navigationItemColors2 = navigationItemColors;
            paddingValues2 = paddingValues;
            i12 = iM5246iconPositionFors8pcRp0;
            modifier3 = modifier2;
            z6 = z4;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRailItem_U_vOP4k$lambda$1(z, function0, function2, function3, z2, modifier3, z6, i12, navigationItemColors2, mutableInteractionSource2, paddingValues2, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012c  */
    /* JADX WARN: Code duplicated, block: B:111:0x0144 A[PHI: r0 r3 r6 r13 r14
      0x0144: PHI (r0v26 int) = (r0v13 int), (r0v30 int), (r0v31 int) binds: [B:125:0x0176, B:109:0x0141, B:110:0x0143] A[DONT_GENERATE, DONT_INLINE]
      0x0144: PHI (r3v11 androidx.compose.ui.Modifier) = (r3v5 androidx.compose.ui.Modifier), (r3v3 androidx.compose.ui.Modifier), (r3v3 androidx.compose.ui.Modifier) binds: [B:125:0x0176, B:109:0x0141, B:110:0x0143] A[DONT_GENERATE, DONT_INLINE]
      0x0144: PHI (r6v12 boolean) = (r6v6 boolean), (r6v3 boolean), (r6v3 boolean) binds: [B:125:0x0176, B:109:0x0141, B:110:0x0143] A[DONT_GENERATE, DONT_INLINE]
      0x0144: PHI (r13v14 int) = (r13v9 int), (r13v7 int), (r13v7 int) binds: [B:125:0x0176, B:109:0x0141, B:110:0x0143] A[DONT_GENERATE, DONT_INLINE]
      0x0144: PHI (r14v9 androidx.compose.material3.NavigationItemColors) = 
      (r14v4 androidx.compose.material3.NavigationItemColors)
      (r14v3 androidx.compose.material3.NavigationItemColors)
      (r14v3 androidx.compose.material3.NavigationItemColors)
     binds: [B:125:0x0176, B:109:0x0141, B:110:0x0143] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:113:0x014b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x014d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0154  */
    /* JADX WARN: Code duplicated, block: B:119:0x015a  */
    /* JADX WARN: Code duplicated, block: B:120:0x0164  */
    /* JADX WARN: Code duplicated, block: B:123:0x016a  */
    /* JADX WARN: Code duplicated, block: B:124:0x0175  */
    /* JADX WARN: Code duplicated, block: B:126:0x0178  */
    /* JADX WARN: Code duplicated, block: B:129:0x0184  */
    /* JADX WARN: Code duplicated, block: B:132:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0093  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:57:0x009e  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00db  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:95:0x010e  */
    /* JADX WARN: Code duplicated, block: B:96:0x0111  */
    /* JADX WARN: Code duplicated, block: B:99:0x011a  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of function with indicatorPadding parameter")
    /* JADX INFO: renamed from: WideNavigationRailItem-pli-t6k, reason: not valid java name */
    public static final /* synthetic */ void m5253WideNavigationRailItemplit6k(final boolean z, final Function0 function0, final Function2 function2, final Function2 function3, final boolean z2, Modifier modifier, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        int iM5246iconPositionFors8pcRp0;
        NavigationItemColors navigationItemColorsColors;
        int i7;
        int i8;
        int i9;
        boolean z5;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z6;
        final int i10;
        final NavigationItemColors navigationItemColors2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        int i12;
        MutableInteractionSource mutableInteractionSource3;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1894733304);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRailItem)N(selected,onClick,icon,label,railExpanded,modifier,enabled,iconPosition:c#material3.NavigationItemIconPosition,colors,interactionSource)944@46196L45,933@45947L301:WideNavigationRail.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        int i14 = i3 & 32;
        if (i14 == 0) {
            if ((196608 & i2) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            i5 = i3 & 64;
            if (i5 != 0) {
                if ((1572864 & i2) == 0) {
                    z4 = z3;
                    if (composerStartRestartGroup.changed(z4)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                    i4 |= i6;
                }
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        iM5246iconPositionFors8pcRp0 = i;
                        int i15 = composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0) ? 8388608 : 4194304;
                        i4 |= i15;
                    } else {
                        iM5246iconPositionFors8pcRp0 = i;
                    }
                    i4 |= i15;
                } else {
                    iM5246iconPositionFors8pcRp0 = i;
                }
                if ((100663296 & i2) == 0) {
                    if ((i3 & 256) == 0) {
                        navigationItemColorsColors = navigationItemColors;
                        if (composerStartRestartGroup.changed(navigationItemColorsColors)) {
                            i13 = 67108864;
                        }
                        i4 |= i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    i13 = GroupFlagsKt.HasAuxSlotFlag;
                    i4 |= i13;
                } else {
                    navigationItemColorsColors = navigationItemColors;
                }
                i7 = i3 & 512;
                if (i7 != 0) {
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i8 = 536870912;
                        } else {
                            i8 = 268435456;
                        }
                        i4 |= i8;
                    }
                    i9 = i4;
                    if ((i4 & 306783379) != 306783378) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "930@45872L8");
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z4 = true;
                            }
                            if ((i3 & 128) != 0) {
                                i11 = i9 & (-29360129);
                                iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                            } else {
                                i11 = i9;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i12 = (-234881025) & i11;
                            } else {
                                i12 = i11;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            }
                            int i16 = iM5246iconPositionFors8pcRp0;
                            NavigationItemColors navigationItemColors3 = navigationItemColorsColors;
                            Modifier modifier4 = modifier2;
                            boolean z7 = z4;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:933)");
                            }
                            int i17 = i12;
                            m5251WideNavigationRailItemU_vOP4k(z, function0, function2, function3, z2, modifier4, z7, i16, navigationItemColors3, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i17 >> 12) & 14) | 3072, 6), composerStartRestartGroup, 2147483646 & i17, 0, 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource3;
                            navigationItemColors2 = navigationItemColors3;
                            i10 = i16;
                            z6 = z7;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i12 = (i3 & 128) != 0 ? i9 & (-29360129) : i9;
                            if ((i3 & 256) != 0) {
                                i12 &= -234881025;
                            }
                        }
                        mutableInteractionSource3 = mutableInteractionSource;
                        int i18 = iM5246iconPositionFors8pcRp0;
                        NavigationItemColors navigationItemColors4 = navigationItemColorsColors;
                        Modifier modifier5 = modifier2;
                        boolean z8 = z4;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:933)");
                        }
                        int i19 = i12;
                        m5251WideNavigationRailItemU_vOP4k(z, function0, function2, function3, z2, modifier5, z8, i18, navigationItemColors4, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i19 >> 12) & 14) | 3072, 6), composerStartRestartGroup, 2147483646 & i19, 0, 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource3;
                        navigationItemColors2 = navigationItemColors4;
                        i10 = i18;
                        z6 = z8;
                        modifier3 = modifier5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        z6 = z4;
                        i10 = iM5246iconPositionFors8pcRp0;
                        navigationItemColors2 = navigationItemColorsColors;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$0(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                i9 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "930@45872L8");
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if ((i3 & 128) != 0) {
                            i11 = i9 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                        } else {
                            i11 = i9;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i12 = (-234881025) & i11;
                        } else {
                            i12 = i11;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if ((i3 & 128) != 0) {
                            i11 = i9 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                        } else {
                            i11 = i9;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i12 = (-234881025) & i11;
                        } else {
                            i12 = i11;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    int i110 = iM5246iconPositionFors8pcRp0;
                    NavigationItemColors navigationItemColors5 = navigationItemColorsColors;
                    Modifier modifier6 = modifier2;
                    boolean z9 = z4;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:933)");
                    }
                    int i111 = i12;
                    m5251WideNavigationRailItemU_vOP4k(z, function0, function2, function3, z2, modifier6, z9, i110, navigationItemColors5, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i111 >> 12) & 14) | 3072, 6), composerStartRestartGroup, 2147483646 & i111, 0, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationItemColors2 = navigationItemColors5;
                    i10 = i110;
                    z6 = z9;
                    modifier3 = modifier6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z6 = z4;
                    i10 = iM5246iconPositionFors8pcRp0;
                    navigationItemColors2 = navigationItemColorsColors;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$0(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
            z4 = z3;
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    iM5246iconPositionFors8pcRp0 = i;
                    if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                    }
                    i4 |= i15;
                } else {
                    iM5246iconPositionFors8pcRp0 = i;
                }
                i4 |= i15;
            } else {
                iM5246iconPositionFors8pcRp0 = i;
            }
            if ((100663296 & i2) == 0) {
                if ((i3 & 256) == 0) {
                    navigationItemColorsColors = navigationItemColors;
                    if (composerStartRestartGroup.changed(navigationItemColorsColors)) {
                        i13 = 67108864;
                    }
                    i4 |= i13;
                } else {
                    navigationItemColorsColors = navigationItemColors;
                }
                i13 = GroupFlagsKt.HasAuxSlotFlag;
                i4 |= i13;
            } else {
                navigationItemColorsColors = navigationItemColors;
            }
            i7 = i3 & 512;
            if (i7 != 0) {
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = 536870912;
                    } else {
                        i8 = 268435456;
                    }
                    i4 |= i8;
                }
                i9 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "930@45872L8");
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if ((i3 & 128) != 0) {
                            i11 = i9 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                        } else {
                            i11 = i9;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i12 = (-234881025) & i11;
                        } else {
                            i12 = i11;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if ((i3 & 128) != 0) {
                            i11 = i9 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                        } else {
                            i11 = i9;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i12 = (-234881025) & i11;
                        } else {
                            i12 = i11;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    int i112 = iM5246iconPositionFors8pcRp0;
                    NavigationItemColors navigationItemColors6 = navigationItemColorsColors;
                    Modifier modifier7 = modifier2;
                    boolean z10 = z4;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:933)");
                    }
                    int i113 = i12;
                    m5251WideNavigationRailItemU_vOP4k(z, function0, function2, function3, z2, modifier7, z10, i112, navigationItemColors6, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i113 >> 12) & 14) | 3072, 6), composerStartRestartGroup, 2147483646 & i113, 0, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationItemColors2 = navigationItemColors6;
                    i10 = i112;
                    z6 = z10;
                    modifier3 = modifier7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z6 = z4;
                    i10 = iM5246iconPositionFors8pcRp0;
                    navigationItemColors2 = navigationItemColorsColors;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$0(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i9 = i4;
            if ((i4 & 306783379) != 306783378) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "930@45872L8");
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    }
                    if ((i3 & 128) != 0) {
                        i11 = i9 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                    } else {
                        i11 = i9;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i12 = (-234881025) & i11;
                    } else {
                        i12 = i11;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    }
                    if ((i3 & 128) != 0) {
                        i11 = i9 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                    } else {
                        i11 = i9;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i12 = (-234881025) & i11;
                    } else {
                        i12 = i11;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                int i114 = iM5246iconPositionFors8pcRp0;
                NavigationItemColors navigationItemColors7 = navigationItemColorsColors;
                Modifier modifier8 = modifier2;
                boolean z11 = z4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:933)");
                }
                int i115 = i12;
                m5251WideNavigationRailItemU_vOP4k(z, function0, function2, function3, z2, modifier8, z11, i114, navigationItemColors7, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i115 >> 12) & 14) | 3072, 6), composerStartRestartGroup, 2147483646 & i115, 0, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationItemColors2 = navigationItemColors7;
                i10 = i114;
                z6 = z11;
                modifier3 = modifier8;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                z6 = z4;
                i10 = iM5246iconPositionFors8pcRp0;
                navigationItemColors2 = navigationItemColorsColors;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$0(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        i5 = i3 & 64;
        if (i5 != 0) {
            if ((1572864 & i2) == 0) {
                z4 = z3;
                if (composerStartRestartGroup.changed(z4)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i4 |= i6;
            }
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    iM5246iconPositionFors8pcRp0 = i;
                    if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                    }
                    i4 |= i15;
                } else {
                    iM5246iconPositionFors8pcRp0 = i;
                }
                i4 |= i15;
            } else {
                iM5246iconPositionFors8pcRp0 = i;
            }
            if ((100663296 & i2) == 0) {
                if ((i3 & 256) == 0) {
                    navigationItemColorsColors = navigationItemColors;
                    if (composerStartRestartGroup.changed(navigationItemColorsColors)) {
                        i13 = 67108864;
                    }
                    i4 |= i13;
                } else {
                    navigationItemColorsColors = navigationItemColors;
                }
                i13 = GroupFlagsKt.HasAuxSlotFlag;
                i4 |= i13;
            } else {
                navigationItemColorsColors = navigationItemColors;
            }
            i7 = i3 & 512;
            if (i7 != 0) {
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = 536870912;
                    } else {
                        i8 = 268435456;
                    }
                    i4 |= i8;
                }
                i9 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "930@45872L8");
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if ((i3 & 128) != 0) {
                            i11 = i9 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                        } else {
                            i11 = i9;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i12 = (-234881025) & i11;
                        } else {
                            i12 = i11;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if ((i3 & 128) != 0) {
                            i11 = i9 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                        } else {
                            i11 = i9;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i12 = (-234881025) & i11;
                        } else {
                            i12 = i11;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    int i116 = iM5246iconPositionFors8pcRp0;
                    NavigationItemColors navigationItemColors8 = navigationItemColorsColors;
                    Modifier modifier9 = modifier2;
                    boolean z12 = z4;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:933)");
                    }
                    int i117 = i12;
                    m5251WideNavigationRailItemU_vOP4k(z, function0, function2, function3, z2, modifier9, z12, i116, navigationItemColors8, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i117 >> 12) & 14) | 3072, 6), composerStartRestartGroup, 2147483646 & i117, 0, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationItemColors2 = navigationItemColors8;
                    i10 = i116;
                    z6 = z12;
                    modifier3 = modifier9;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z6 = z4;
                    i10 = iM5246iconPositionFors8pcRp0;
                    navigationItemColors2 = navigationItemColorsColors;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$0(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i9 = i4;
            if ((i4 & 306783379) != 306783378) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "930@45872L8");
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    }
                    if ((i3 & 128) != 0) {
                        i11 = i9 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                    } else {
                        i11 = i9;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i12 = (-234881025) & i11;
                    } else {
                        i12 = i11;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    }
                    if ((i3 & 128) != 0) {
                        i11 = i9 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                    } else {
                        i11 = i9;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i12 = (-234881025) & i11;
                    } else {
                        i12 = i11;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                int i118 = iM5246iconPositionFors8pcRp0;
                NavigationItemColors navigationItemColors9 = navigationItemColorsColors;
                Modifier modifier10 = modifier2;
                boolean z13 = z4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:933)");
                }
                int i119 = i12;
                m5251WideNavigationRailItemU_vOP4k(z, function0, function2, function3, z2, modifier10, z13, i118, navigationItemColors9, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i119 >> 12) & 14) | 3072, 6), composerStartRestartGroup, 2147483646 & i119, 0, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationItemColors2 = navigationItemColors9;
                i10 = i118;
                z6 = z13;
                modifier3 = modifier10;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                z6 = z4;
                i10 = iM5246iconPositionFors8pcRp0;
                navigationItemColors2 = navigationItemColorsColors;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$0(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 1572864;
        z4 = z3;
        if ((12582912 & i2) == 0) {
            if ((i3 & 128) == 0) {
                iM5246iconPositionFors8pcRp0 = i;
                if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                }
                i4 |= i15;
            } else {
                iM5246iconPositionFors8pcRp0 = i;
            }
            i4 |= i15;
        } else {
            iM5246iconPositionFors8pcRp0 = i;
        }
        if ((100663296 & i2) == 0) {
            if ((i3 & 256) == 0) {
                navigationItemColorsColors = navigationItemColors;
                if (composerStartRestartGroup.changed(navigationItemColorsColors)) {
                    i13 = 67108864;
                }
                i4 |= i13;
            } else {
                navigationItemColorsColors = navigationItemColors;
            }
            i13 = GroupFlagsKt.HasAuxSlotFlag;
            i4 |= i13;
        } else {
            navigationItemColorsColors = navigationItemColors;
        }
        i7 = i3 & 512;
        if (i7 != 0) {
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i8 = 536870912;
                } else {
                    i8 = 268435456;
                }
                i4 |= i8;
            }
            i9 = i4;
            if ((i4 & 306783379) != 306783378) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "930@45872L8");
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    }
                    if ((i3 & 128) != 0) {
                        i11 = i9 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                    } else {
                        i11 = i9;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i12 = (-234881025) & i11;
                    } else {
                        i12 = i11;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    }
                    if ((i3 & 128) != 0) {
                        i11 = i9 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                    } else {
                        i11 = i9;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i12 = (-234881025) & i11;
                    } else {
                        i12 = i11;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                int i1110 = iM5246iconPositionFors8pcRp0;
                NavigationItemColors navigationItemColors10 = navigationItemColorsColors;
                Modifier modifier11 = modifier2;
                boolean z14 = z4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:933)");
                }
                int i1111 = i12;
                m5251WideNavigationRailItemU_vOP4k(z, function0, function2, function3, z2, modifier11, z14, i1110, navigationItemColors10, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i1111 >> 12) & 14) | 3072, 6), composerStartRestartGroup, 2147483646 & i1111, 0, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationItemColors2 = navigationItemColors10;
                i10 = i1110;
                z6 = z14;
                modifier3 = modifier11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                z6 = z4;
                i10 = iM5246iconPositionFors8pcRp0;
                navigationItemColors2 = navigationItemColorsColors;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$0(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i9 = i4;
        if ((i4 & 306783379) != 306783378) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "930@45872L8");
            if ((i2 & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    z4 = true;
                }
                if ((i3 & 128) != 0) {
                    i11 = i9 & (-29360129);
                    iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                } else {
                    i11 = i9;
                }
                if ((i3 & 256) != 0) {
                    navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i12 = (-234881025) & i11;
                } else {
                    i12 = i11;
                }
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    z4 = true;
                }
                if ((i3 & 128) != 0) {
                    i11 = i9 & (-29360129);
                    iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z2);
                } else {
                    i11 = i9;
                }
                if ((i3 & 256) != 0) {
                    navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i12 = (-234881025) & i11;
                } else {
                    i12 = i11;
                }
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            }
            int i1112 = iM5246iconPositionFors8pcRp0;
            NavigationItemColors navigationItemColors11 = navigationItemColorsColors;
            Modifier modifier12 = modifier2;
            boolean z15 = z4;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:933)");
            }
            int i1113 = i12;
            m5251WideNavigationRailItemU_vOP4k(z, function0, function2, function3, z2, modifier12, z15, i1112, navigationItemColors11, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z2, null, null, composerStartRestartGroup, ((i1113 >> 12) & 14) | 3072, 6), composerStartRestartGroup, 2147483646 & i1113, 0, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource2 = mutableInteractionSource3;
            navigationItemColors2 = navigationItemColors11;
            i10 = i1112;
            z6 = z15;
            modifier3 = modifier12;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            z6 = z4;
            i10 = iM5246iconPositionFors8pcRp0;
            navigationItemColors2 = navigationItemColorsColors;
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$0(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0122  */
    /* JADX WARN: Code duplicated, block: B:102:0x0125  */
    /* JADX WARN: Code duplicated, block: B:105:0x012f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0141  */
    /* JADX WARN: Code duplicated, block: B:119:0x0166 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x0168  */
    /* JADX WARN: Code duplicated, block: B:123:0x0170  */
    /* JADX WARN: Code duplicated, block: B:125:0x0174  */
    /* JADX WARN: Code duplicated, block: B:128:0x017a  */
    /* JADX WARN: Code duplicated, block: B:129:0x0184  */
    /* JADX WARN: Code duplicated, block: B:132:0x018a  */
    /* JADX WARN: Code duplicated, block: B:133:0x0194  */
    /* JADX WARN: Code duplicated, block: B:135:0x0198  */
    /* JADX WARN: Code duplicated, block: B:136:0x019e  */
    /* JADX WARN: Code duplicated, block: B:140:0x01af  */
    /* JADX WARN: Code duplicated, block: B:143:0x0207  */
    /* JADX WARN: Code duplicated, block: B:145:0x0217  */
    /* JADX WARN: Code duplicated, block: B:148:0x022a  */
    /* JADX WARN: Code duplicated, block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:57:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00db  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:87:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:93:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:95:0x0106  */
    /* JADX WARN: Code duplicated, block: B:96:0x0109  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of function with indicatorPadding required railExpanded parameters")
    /* JADX INFO: renamed from: WideNavigationRailItem-pli-t6k, reason: not valid java name */
    public static final /* synthetic */ void m5252WideNavigationRailItemplit6k(final boolean z, final Function0 function0, final Function2 function2, final Function2 function3, Modifier modifier, boolean z2, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        int i4;
        Function2 function4;
        Function2 function5;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        int i7;
        boolean z5;
        int i8;
        int iM5246iconPositionFors8pcRp0;
        int i9;
        int i10;
        int i11;
        boolean z6;
        Composer composer2;
        final NavigationItemColors navigationItemColors2;
        final Modifier modifier3;
        final boolean z7;
        final boolean z8;
        final int i12;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z9;
        int i13;
        NavigationItemColors navigationItemColorsColors;
        MutableInteractionSource mutableInteractionSource3;
        int i14;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1198748736);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRailItem)N(selected,onClick,icon,label,modifier,enabled,railExpanded,iconPosition:c#material3.NavigationItemIconPosition,colors,interactionSource)1012@49336L45,1001@49087L301:WideNavigationRail.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            function4 = function2;
            i4 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
        } else {
            function4 = function2;
        }
        if ((i2 & 3072) == 0) {
            function5 = function3;
            i4 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function3;
        }
        int i15 = i3 & 16;
        if (i15 == 0) {
            if ((i2 & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                if ((196608 & i2) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    if ((1572864 & i2) == 0) {
                        z5 = z3;
                        if (composerStartRestartGroup.changed(z5)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                        i4 |= i8;
                    }
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            iM5246iconPositionFors8pcRp0 = i;
                            int i16 = composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0) ? 8388608 : 4194304;
                            i4 |= i16;
                        } else {
                            iM5246iconPositionFors8pcRp0 = i;
                        }
                        i4 |= i16;
                    } else {
                        iM5246iconPositionFors8pcRp0 = i;
                    }
                    if ((i2 & 100663296) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
                    }
                    i9 = i3 & 512;
                    if (i9 != 0) {
                        if ((i2 & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i10 = 536870912;
                            } else {
                                i10 = 268435456;
                            }
                            i4 |= i10;
                        }
                        i11 = i4;
                        if ((i4 & 306783379) != 306783378) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                z9 = i5 == 0 ? z4 : true;
                                if (i7 != 0) {
                                    z5 = false;
                                }
                                if ((i3 & 128) != 0) {
                                    i13 = i11 & (-29360129);
                                    iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                                } else {
                                    i13 = i11;
                                }
                                if ((i3 & 256) != 0) {
                                    navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    i13 = (-234881025) & i13;
                                } else {
                                    navigationItemColorsColors = navigationItemColors;
                                }
                                if (i9 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                i14 = i13;
                                modifier4 = modifier2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                i14 = (i3 & 128) != 0 ? i11 & (-29360129) : i11;
                                if ((i3 & 256) != 0) {
                                    i14 &= -234881025;
                                }
                                navigationItemColorsColors = navigationItemColors;
                                mutableInteractionSource3 = mutableInteractionSource;
                                modifier4 = modifier2;
                                z9 = z4;
                            }
                            boolean z10 = z5;
                            int i17 = iM5246iconPositionFors8pcRp0;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                            }
                            composer2 = composerStartRestartGroup;
                            int i18 = i14 << 3;
                            m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z10, modifier4, z9, i17, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z10, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i18) | (i18 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z8 = z10;
                            modifier3 = modifier4;
                            z7 = z9;
                            i12 = i17;
                            navigationItemColors2 = navigationItemColorsColors;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            navigationItemColors2 = navigationItemColors;
                            modifier3 = modifier2;
                            z7 = z4;
                            z8 = z5;
                            i12 = iM5246iconPositionFors8pcRp0;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i4 |= 805306368;
                    i11 = i4;
                    if ((i4 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        }
                        boolean z11 = z5;
                        int i19 = iM5246iconPositionFors8pcRp0;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                        }
                        composer2 = composerStartRestartGroup;
                        int i110 = i14 << 3;
                        m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z11, modifier4, z9, i19, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z11, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i110) | (i110 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z8 = z11;
                        modifier3 = modifier4;
                        z7 = z9;
                        i12 = i19;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        navigationItemColors2 = navigationItemColors;
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z5;
                        i12 = iM5246iconPositionFors8pcRp0;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 1572864;
                z5 = z3;
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        iM5246iconPositionFors8pcRp0 = i;
                        if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                        }
                        i4 |= i16;
                    } else {
                        iM5246iconPositionFors8pcRp0 = i;
                    }
                    i4 |= i16;
                } else {
                    iM5246iconPositionFors8pcRp0 = i;
                }
                if ((i2 & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                        i4 |= i10;
                    }
                    i11 = i4;
                    if ((i4 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        }
                        boolean z12 = z5;
                        int i111 = iM5246iconPositionFors8pcRp0;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                        }
                        composer2 = composerStartRestartGroup;
                        int i112 = i14 << 3;
                        m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z12, modifier4, z9, i111, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z12, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i112) | (i112 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z8 = z12;
                        modifier3 = modifier4;
                        z7 = z9;
                        i12 = i111;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        navigationItemColors2 = navigationItemColors;
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z5;
                        i12 = iM5246iconPositionFors8pcRp0;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                i11 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    }
                    boolean z13 = z5;
                    int i113 = iM5246iconPositionFors8pcRp0;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i114 = i14 << 3;
                    m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z13, modifier4, z9, i113, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z13, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i114) | (i114 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z13;
                    modifier3 = modifier4;
                    z7 = z9;
                    i12 = i113;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    i12 = iM5246iconPositionFors8pcRp0;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z4 = z2;
            i7 = i3 & 64;
            if (i7 != 0) {
                if ((1572864 & i2) == 0) {
                    z5 = z3;
                    if (composerStartRestartGroup.changed(z5)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        iM5246iconPositionFors8pcRp0 = i;
                        if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                        }
                        i4 |= i16;
                    } else {
                        iM5246iconPositionFors8pcRp0 = i;
                    }
                    i4 |= i16;
                } else {
                    iM5246iconPositionFors8pcRp0 = i;
                }
                if ((i2 & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                        i4 |= i10;
                    }
                    i11 = i4;
                    if ((i4 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        }
                        boolean z14 = z5;
                        int i115 = iM5246iconPositionFors8pcRp0;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                        }
                        composer2 = composerStartRestartGroup;
                        int i116 = i14 << 3;
                        m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z14, modifier4, z9, i115, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z14, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i116) | (i116 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z8 = z14;
                        modifier3 = modifier4;
                        z7 = z9;
                        i12 = i115;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        navigationItemColors2 = navigationItemColors;
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z5;
                        i12 = iM5246iconPositionFors8pcRp0;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                i11 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    }
                    boolean z15 = z5;
                    int i117 = iM5246iconPositionFors8pcRp0;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i118 = i14 << 3;
                    m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z15, modifier4, z9, i117, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z15, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i118) | (i118 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z15;
                    modifier3 = modifier4;
                    z7 = z9;
                    i12 = i117;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    i12 = iM5246iconPositionFors8pcRp0;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
            z5 = z3;
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    iM5246iconPositionFors8pcRp0 = i;
                    if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                    }
                    i4 |= i16;
                } else {
                    iM5246iconPositionFors8pcRp0 = i;
                }
                i4 |= i16;
            } else {
                iM5246iconPositionFors8pcRp0 = i;
            }
            if ((i2 & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                i11 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    }
                    boolean z16 = z5;
                    int i119 = iM5246iconPositionFors8pcRp0;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i1110 = i14 << 3;
                    m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z16, modifier4, z9, i119, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z16, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i1110) | (i1110 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z16;
                    modifier3 = modifier4;
                    z7 = z9;
                    i12 = i119;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    i12 = iM5246iconPositionFors8pcRp0;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i11 = i4;
            if ((i4 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                }
                boolean z17 = z5;
                int i1111 = iM5246iconPositionFors8pcRp0;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                }
                composer2 = composerStartRestartGroup;
                int i1112 = i14 << 3;
                m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z17, modifier4, z9, i1111, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z17, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i1112) | (i1112 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z17;
                modifier3 = modifier4;
                z7 = z9;
                i12 = i1111;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationItemColors2 = navigationItemColors;
                modifier3 = modifier2;
                z7 = z4;
                z8 = z5;
                i12 = iM5246iconPositionFors8pcRp0;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        i5 = i3 & 32;
        if (i5 != 0) {
            if ((196608 & i2) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                if ((1572864 & i2) == 0) {
                    z5 = z3;
                    if (composerStartRestartGroup.changed(z5)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        iM5246iconPositionFors8pcRp0 = i;
                        if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                        }
                        i4 |= i16;
                    } else {
                        iM5246iconPositionFors8pcRp0 = i;
                    }
                    i4 |= i16;
                } else {
                    iM5246iconPositionFors8pcRp0 = i;
                }
                if ((i2 & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                        i4 |= i10;
                    }
                    i11 = i4;
                    if ((i4 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        }
                        boolean z18 = z5;
                        int i1113 = iM5246iconPositionFors8pcRp0;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                        }
                        composer2 = composerStartRestartGroup;
                        int i1114 = i14 << 3;
                        m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z18, modifier4, z9, i1113, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z18, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i1114) | (i1114 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z8 = z18;
                        modifier3 = modifier4;
                        z7 = z9;
                        i12 = i1113;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        navigationItemColors2 = navigationItemColors;
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z5;
                        i12 = iM5246iconPositionFors8pcRp0;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                i11 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    }
                    boolean z19 = z5;
                    int i1115 = iM5246iconPositionFors8pcRp0;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i1116 = i14 << 3;
                    m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z19, modifier4, z9, i1115, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z19, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i1116) | (i1116 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z19;
                    modifier3 = modifier4;
                    z7 = z9;
                    i12 = i1115;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    i12 = iM5246iconPositionFors8pcRp0;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
            z5 = z3;
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    iM5246iconPositionFors8pcRp0 = i;
                    if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                    }
                    i4 |= i16;
                } else {
                    iM5246iconPositionFors8pcRp0 = i;
                }
                i4 |= i16;
            } else {
                iM5246iconPositionFors8pcRp0 = i;
            }
            if ((i2 & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                i11 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    }
                    boolean z110 = z5;
                    int i1117 = iM5246iconPositionFors8pcRp0;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i1118 = i14 << 3;
                    m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z110, modifier4, z9, i1117, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z110, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i1118) | (i1118 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z110;
                    modifier3 = modifier4;
                    z7 = z9;
                    i12 = i1117;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    i12 = iM5246iconPositionFors8pcRp0;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i11 = i4;
            if ((i4 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                }
                boolean z111 = z5;
                int i1119 = iM5246iconPositionFors8pcRp0;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                }
                composer2 = composerStartRestartGroup;
                int i11110 = i14 << 3;
                m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z111, modifier4, z9, i1119, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z111, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i11110) | (i11110 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z111;
                modifier3 = modifier4;
                z7 = z9;
                i12 = i1119;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationItemColors2 = navigationItemColors;
                modifier3 = modifier2;
                z7 = z4;
                z8 = z5;
                i12 = iM5246iconPositionFors8pcRp0;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z4 = z2;
        i7 = i3 & 64;
        if (i7 != 0) {
            if ((1572864 & i2) == 0) {
                z5 = z3;
                if (composerStartRestartGroup.changed(z5)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    iM5246iconPositionFors8pcRp0 = i;
                    if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                    }
                    i4 |= i16;
                } else {
                    iM5246iconPositionFors8pcRp0 = i;
                }
                i4 |= i16;
            } else {
                iM5246iconPositionFors8pcRp0 = i;
            }
            if ((i2 & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                i11 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    }
                    boolean z112 = z5;
                    int i11111 = iM5246iconPositionFors8pcRp0;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i11112 = i14 << 3;
                    m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z112, modifier4, z9, i11111, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z112, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i11112) | (i11112 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z112;
                    modifier3 = modifier4;
                    z7 = z9;
                    i12 = i11111;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    i12 = iM5246iconPositionFors8pcRp0;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i11 = i4;
            if ((i4 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                }
                boolean z113 = z5;
                int i11113 = iM5246iconPositionFors8pcRp0;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                }
                composer2 = composerStartRestartGroup;
                int i11114 = i14 << 3;
                m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z113, modifier4, z9, i11113, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z113, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i11114) | (i11114 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z113;
                modifier3 = modifier4;
                z7 = z9;
                i12 = i11113;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationItemColors2 = navigationItemColors;
                modifier3 = modifier2;
                z7 = z4;
                z8 = z5;
                i12 = iM5246iconPositionFors8pcRp0;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 1572864;
        z5 = z3;
        if ((12582912 & i2) == 0) {
            if ((i3 & 128) == 0) {
                iM5246iconPositionFors8pcRp0 = i;
                if (composerStartRestartGroup.changed(iM5246iconPositionFors8pcRp0)) {
                }
                i4 |= i16;
            } else {
                iM5246iconPositionFors8pcRp0 = i;
            }
            i4 |= i16;
        } else {
            iM5246iconPositionFors8pcRp0 = i;
        }
        if ((i2 & 100663296) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
        }
        i9 = i3 & 512;
        if (i9 != 0) {
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i10 = 536870912;
                } else {
                    i10 = 268435456;
                }
                i4 |= i10;
            }
            i11 = i4;
            if ((i4 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                }
                boolean z114 = z5;
                int i11115 = iM5246iconPositionFors8pcRp0;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
                }
                composer2 = composerStartRestartGroup;
                int i11116 = i14 << 3;
                m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z114, modifier4, z9, i11115, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z114, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i11116) | (i11116 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z114;
                modifier3 = modifier4;
                z7 = z9;
                i12 = i11115;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationItemColors2 = navigationItemColors;
                modifier3 = modifier2;
                z7 = z4;
                z8 = z5;
                i12 = iM5246iconPositionFors8pcRp0;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i11 = i4;
        if ((i4 & 306783379) != 306783378) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "998@49012L8");
            if ((i2 & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 == 0) {
                }
                if (i7 != 0) {
                    z5 = false;
                }
                if ((i3 & 128) != 0) {
                    i13 = i11 & (-29360129);
                    iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                } else {
                    i13 = i11;
                }
                if ((i3 & 256) != 0) {
                    navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i13 = (-234881025) & i13;
                } else {
                    navigationItemColorsColors = navigationItemColors;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                i14 = i13;
                modifier4 = modifier2;
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 == 0) {
                }
                if (i7 != 0) {
                    z5 = false;
                }
                if ((i3 & 128) != 0) {
                    i13 = i11 & (-29360129);
                    iM5246iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m5246iconPositionFors8pcRp0(z5);
                } else {
                    i13 = i11;
                }
                if ((i3 & 256) != 0) {
                    navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i13 = (-234881025) & i13;
                } else {
                    navigationItemColorsColors = navigationItemColors;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                i14 = i13;
                modifier4 = modifier2;
            }
            boolean z115 = z5;
            int i11117 = iM5246iconPositionFors8pcRp0;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:1001)");
            }
            composer2 = composerStartRestartGroup;
            int i11118 = i14 << 3;
            m5251WideNavigationRailItemU_vOP4k(z, function0, function4, function5, z115, modifier4, z9, i11117, navigationItemColorsColors, mutableInteractionSource3, WideNavigationRailItemDefaults.INSTANCE.indicatorPadding(z115, null, null, composerStartRestartGroup, ((i14 >> 18) & 14) | 3072, 6), composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i11118) | (i11118 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z8 = z115;
            modifier3 = modifier4;
            z7 = z9;
            i12 = i11117;
            navigationItemColors2 = navigationItemColorsColors;
            mutableInteractionSource2 = mutableInteractionSource3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            navigationItemColors2 = navigationItemColors;
            modifier3 = modifier2;
            z7 = z4;
            z8 = z5;
            i12 = iM5246iconPositionFors8pcRp0;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ModalWideNavigationRailContent-_zuB-KE, reason: not valid java name */
    public static final void m5250ModalWideNavigationRailContent_zuBKE(final boolean z, final boolean z2, final Animatable<Float, AnimationVector1D> animatable, final RailPredictiveBackState railPredictiveBackState, final Function1<? super Continuation<? super Unit>, ? extends Object> function1, final Modifier modifier, final ModalWideNavigationRailState modalWideNavigationRailState, final WideNavigationRailColors wideNavigationRailColors, final Shape shape, final float f, final Function2<? super Composer, ? super Integer, Unit> function2, final WindowInsets windowInsets, final boolean z3, final Arrangement.Vertical vertical, final PaddingValues paddingValues, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        WideNavigationRailColors wideNavigationRailColors2;
        int i4;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1307377989);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalWideNavigationRailContent)N(expanded,isStandaloneModal,predictiveBackProgress,predictiveBackState,modalAnimateToDismiss,modifier,railState,colors,shape,openModalRailMaxWidth:c#ui.unit.Dp,header,windowInsets,gesturesEnabled,arrangement,contentPadding,content)1448@68934L7,1449@68989L55,1453@69223L31,1451@69120L198,1458@69356L579,1481@70220L29,1482@70281L904,1501@71278L627,1523@72189L1356,1473@69941L3604:WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(animatable) : composerStartRestartGroup.changedInstance(animatable) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(railPredictiveBackState) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(modalWideNavigationRailState) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            wideNavigationRailColors2 = wideNavigationRailColors;
            i3 |= composerStartRestartGroup.changed(wideNavigationRailColors2) ? 8388608 : 4194304;
        } else {
            wideNavigationRailColors2 = wideNavigationRailColors;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(function2) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(windowInsets) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(vertical) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(paddingValues) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        int i5 = i4;
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (74899 & i5) == 74898) ? false : true, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1307377989, i3, i5, "androidx.compose.material3.ModalWideNavigationRailContent (WideNavigationRail.kt:1447)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final boolean z4 = objConsume == LayoutDirection.Rtl;
            Strings.Companion companion = Strings.INSTANCE;
            final String strM5501getString2EP1pXo = Strings_androidKt.m5501getString2EP1pXo(Strings.m5417constructorimpl(R.string.m3c_wide_navigation_rail_pane_title), composerStartRestartGroup, 0);
            AnchoredDraggableDefaults anchoredDraggableDefaults = AnchoredDraggableDefaults.INSTANCE;
            AnchoredDraggableState<WideNavigationRailValue> anchoredDraggableState$material3 = modalWideNavigationRailState.getAnchoredDraggableState$material3();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2035139804, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Float.valueOf(WideNavigationRailKt.ModalWideNavigationRailContent__zuB_KE$lambda$0$0(((Float) obj).floatValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TargetedFlingBehavior targetedFlingBehaviorFlingBehavior = anchoredDraggableDefaults.flingBehavior(anchoredDraggableState$material3, (Function1) objRememberedValue, modalWideNavigationRailState.getAnimationSpec(), composerStartRestartGroup, (AnchoredDraggableDefaults.$stable << 9) | 48, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2035135000, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(targetedFlingBehaviorFlingBehavior);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1(targetedFlingBehaviorFlingBehavior, function1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1 wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1 = (WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long modalContainerColor = wideNavigationRailColors2.getModalContainerColor();
            long modalContentColor = wideNavigationRailColors2.getModalContentColor();
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.m2424widthInVpY3zN4$default(modifier, 0.0f, f, 1, null), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2035107902, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(strM5501getString2EP1pXo);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent__zuB_KE$lambda$2$0(strM5501getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierFillMaxHeight$default, false, (Function1) objRememberedValue3, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2035105075, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 7168) == 2048) | ((i3 & 896) == 256 || ((i3 & 512) != 0 && composerStartRestartGroup.changedInstance(animatable))) | composerStartRestartGroup.changedInstance(modalWideNavigationRailState) | composerStartRestartGroup.changed(z4);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent__zuB_KE$lambda$3$0(animatable, modalWideNavigationRailState, railPredictiveBackState, z4, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierSemantics$default, (Function1) objRememberedValue4);
            AnchoredDraggableState<WideNavigationRailValue> anchoredDraggableState$material4 = modalWideNavigationRailState.getAnchoredDraggableState$material3();
            Orientation orientation = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2035073448, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChangedInstance2 = ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(modalWideNavigationRailState);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent__zuB_KE$lambda$4$0(z2, modalWideNavigationRailState, (IntSize) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(DraggableAnchorsKt.draggableAnchors(modifierGraphicsLayer, anchoredDraggableState$material4, orientation, (Function2) objRememberedValue5), modalWideNavigationRailState.getAnchoredDraggableState$material3(), Orientation.Horizontal, z3, null, null, wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1, 24, null);
            composer2 = composerStartRestartGroup;
            final WideNavigationRailColors wideNavigationRailColors3 = wideNavigationRailColors2;
            SurfaceKt.m4781SurfaceT9BRK9s(modifierAnchoredDraggable$default, shape, modalContainerColor, modalContentColor, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(131156832, true, new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.ModalWideNavigationRailContent__zuB_KE$lambda$5(animatable, railPredictiveBackState, z4, z, wideNavigationRailColors3, shape, function2, windowInsets, vertical, paddingValues, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, ((i3 >> 21) & 112) | 12582912, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.ModalWideNavigationRailContent__zuB_KE$lambda$6(z, z2, animatable, railPredictiveBackState, function1, modifier, modalWideNavigationRailState, wideNavigationRailColors, shape, f, function2, windowInsets, z3, vertical, paddingValues, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRailContent__zuB_KE$lambda$2$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRailContent__zuB_KE$lambda$3$0(Animatable animatable, ModalWideNavigationRailState modalWideNavigationRailState, RailPredictiveBackState railPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fFloatValue = ((Number) animatable.getValue()).floatValue();
        if (fFloatValue <= 0.0f) {
            return Unit.INSTANCE;
        }
        float currentOffset = modalWideNavigationRailState.getCurrentOffset();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32));
        if (!Float.isNaN(currentOffset) && !Float.isNaN(fIntBitsToFloat) && fIntBitsToFloat != 0.0f) {
            graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX(graphicsLayerScope, fFloatValue, railPredictiveBackState.getSwipeEdgeMatchesRail()));
            graphicsLayerScope.setScaleY(calculatePredictiveBackScaleY(graphicsLayerScope, fFloatValue));
            graphicsLayerScope.mo7539setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 1.0f : 0.0f, 0.5f));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair ModalWideNavigationRailContent__zuB_KE$lambda$4$0(boolean z, ModalWideNavigationRailState modalWideNavigationRailState, IntSize intSize, Constraints constraints) {
        final float f = 0.0f;
        final float f2 = z ? -((int) (intSize.m10343unboximpl() >> 32)) : 0.0f;
        return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WideNavigationRailKt.ModalWideNavigationRailContent__zuB_KE$lambda$4$0$0(f2, f, (DraggableAnchorsConfig) obj);
            }
        }), modalWideNavigationRailState.getTargetValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRailContent__zuB_KE$lambda$4$0$0(float f, float f2, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(WideNavigationRailValue.Collapsed, f);
        draggableAnchorsConfig.at(WideNavigationRailValue.Expanded, f2);
        return Unit.INSTANCE;
    }

    static final Unit ModalWideNavigationRailContent__zuB_KE$lambda$5(final Animatable animatable, final RailPredictiveBackState railPredictiveBackState, final boolean z, boolean z2, WideNavigationRailColors wideNavigationRailColors, Shape shape, Function2 function2, WindowInsets windowInsets, Arrangement.Vertical vertical, PaddingValues paddingValues, Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1526@72287L939,1524@72199L1340:WideNavigationRail.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(131156832, i, -1, "androidx.compose.material3.ModalWideNavigationRailContent.<anonymous> (WideNavigationRail.kt:1524)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1487668043, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(animatable) | composer.changed(railPredictiveBackState) | composer.changed(z);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent__zuB_KE$lambda$5$0$0(animatable, railPredictiveBackState, z, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            WideNavigationRailLayout(GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue), true, z2, wideNavigationRailColors, shape, function2, windowInsets, vertical, paddingValues, function3, composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRailContent__zuB_KE$lambda$5$0$0(Animatable animatable, RailPredictiveBackState railPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fFloatValue = ((Number) animatable.getValue()).floatValue();
        if (fFloatValue <= 0.0f) {
            return Unit.INSTANCE;
        }
        float fCalculatePredictiveBackScaleX = calculatePredictiveBackScaleX(graphicsLayerScope, fFloatValue, railPredictiveBackState.getSwipeEdgeMatchesRail());
        graphicsLayerScope.setScaleX(fCalculatePredictiveBackScaleX == 0.0f ? 1.0f : calculatePredictiveBackScaleY(graphicsLayerScope, fFloatValue) / fCalculatePredictiveBackScaleX);
        graphicsLayerScope.mo7539setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.5f));
        return Unit.INSTANCE;
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, float f, boolean z) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return (((z ? 1.0f : -1.0f) * MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo1734toPx0680j_4(PredictiveBackMaxScaleXDistance), fIntBitsToFloat), f)) / fIntBitsToFloat) + 1.0f;
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo1734toPx0680j_4(PredictiveBackMaxScaleYDistance), fIntBitsToFloat), f) / fIntBitsToFloat);
    }

    public static final float getWNRItemNoLabelIndicatorPadding() {
        return WNRItemNoLabelIndicatorPadding;
    }

    public static final float getWNRItemHorizontalPadding() {
        return WNRItemHorizontalPadding;
    }

    public static final ProvidableCompositionLocal<WideNavigationRailOverride> getLocalWideNavigationRailOverride() {
        return LocalWideNavigationRailOverride;
    }

    public static final ProvidableCompositionLocal<ModalWideNavigationRailOverride> getLocalModalWideNavigationRailOverride() {
        return LocalModalWideNavigationRailOverride;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$6(State<Dp> state) {
        return state.getValue().m10182unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$7(State<Dp> state) {
        return state.getValue().m10182unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$8(State<Dp> state) {
        return state.getValue().m10182unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$9(State<Dp> state) {
        return state.getValue().m10182unboximpl();
    }
}
