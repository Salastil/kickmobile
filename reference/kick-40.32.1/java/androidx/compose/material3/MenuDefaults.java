package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.material3.tokens.SegmentedMenuTokens;
import androidx.compose.material3.tokens.ShapeTokens;
import androidx.compose.material3.tokens.StandardMenuTokens;
import androidx.compose.material3.tokens.VibrantMenuTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MenuDefaults.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0002\u0010LJ\u001d\u0010M\u001a\u00020N2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0002\u0010OJ\r\u0010P\u001a\u00020QH\u0007¢\u0006\u0002\u0010RJ%\u0010S\u001a\u00020N2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010UJ\r\u0010S\u001a\u00020NH\u0007¢\u0006\u0002\u0010VJ%\u0010W\u001a\u00020H2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010YJ\r\u0010W\u001a\u00020HH\u0007¢\u0006\u0002\u0010ZJ4\u0010[\u001a\u00020\\2\b\b\u0002\u0010]\u001a\u00020^2\b\b\u0002\u0010_\u001a\u00020@2\u0011\u0010`\u001a\r\u0012\u0004\u0012\u00020\\0a¢\u0006\u0002\bbH\u0007¢\u0006\u0002\u0010cJ*\u0010g\u001a\u00020\\2\b\b\u0002\u0010_\u001a\u00020@2\u0011\u0010`\u001a\r\u0012\u0004\u0012\u00020\\0a¢\u0006\u0002\bbH\u0007¢\u0006\u0002\u0010hJ3\u0010i\u001a\u00020\\2\u0011\u0010j\u001a\r\u0012\u0004\u0012\u00020\\0a¢\u0006\u0002\bb2\u0011\u0010`\u001a\r\u0012\u0004\u0012\u00020\\0a¢\u0006\u0002\bbH\u0007¢\u0006\u0002\u0010kJK\u0010P\u001a\u00020Q2\b\b\u0002\u0010l\u001a\u00020\u00142\b\b\u0002\u0010m\u001a\u00020\u00142\b\b\u0002\u0010n\u001a\u00020\u00142\b\b\u0002\u0010o\u001a\u00020\u00142\b\b\u0002\u0010p\u001a\u00020\u00142\b\b\u0002\u0010q\u001a\u00020\u0014H\u0007¢\u0006\u0004\br\u0010sJ}\u0010t\u001a\u00020Q2\b\b\u0002\u0010l\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010m\u001a\u00020\u00142\b\b\u0002\u0010n\u001a\u00020\u00142\b\b\u0002\u0010o\u001a\u00020\u00142\b\b\u0002\u0010p\u001a\u00020\u00142\b\b\u0002\u0010q\u001a\u00020\u00142\b\b\u0002\u0010u\u001a\u00020\u00142\b\b\u0002\u0010v\u001a\u00020\u00142\b\b\u0002\u0010w\u001a\u00020\u00142\b\b\u0002\u0010x\u001a\u00020\u0014H\u0007¢\u0006\u0004\by\u0010zJ}\u0010{\u001a\u00020Q2\b\b\u0002\u0010l\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010m\u001a\u00020\u00142\b\b\u0002\u0010n\u001a\u00020\u00142\b\b\u0002\u0010o\u001a\u00020\u00142\b\b\u0002\u0010p\u001a\u00020\u00142\b\b\u0002\u0010q\u001a\u00020\u00142\b\b\u0002\u0010u\u001a\u00020\u00142\b\b\u0002\u0010v\u001a\u00020\u00142\b\b\u0002\u0010w\u001a\u00020\u00142\b\b\u0002\u0010x\u001a\u00020\u0014H\u0007¢\u0006\u0004\b|\u0010zR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00148GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u00148GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u0016R\u001a\u0010\u001e\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u0012R\u001a\u0010!\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u0012R\u001a\u0010$\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u0012R\u001a\u0010'\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u0012R\u001a\u0010*\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010\u0012R\u001a\u0010-\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u0012R\u001a\u00100\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0019\u001a\u0004\b2\u0010\u0012R\u001a\u00103\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0019\u001a\u0004\b5\u0010\u0012R\u001a\u00106\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0019\u001a\u0004\b8\u0010\u0012R\u001a\u00109\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0019\u001a\u0004\b;\u0010\u0012R\u001e\u0010<\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b=\u0010\u0003\u001a\u0004\b>\u0010\u0007R\u001c\u0010?\u001a\u00020@8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\u0003\u001a\u0004\bB\u0010CR\u001c\u0010D\u001a\u00020@8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010\u0003\u001a\u0004\bF\u0010CR\u001c\u0010d\u001a\u00020@8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u0010\u0003\u001a\u0004\bf\u0010CR\u0019\u0010}\u001a\u00020Q*\u00020~8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001R#\u0010\u0081\u0001\u001a\u00020Q*\u00020~8@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0080\u0001R#\u0010\u0085\u0001\u001a\u00020Q*\u00020~8@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u0086\u0001\u0010\u0083\u0001\u001a\u0006\b\u0087\u0001\u0010\u0080\u0001R\u0013\u0010\u0088\u0001\u001a\u00020@¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010CR\u0011\u0010\u008a\u0001\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0013\u0010\u008b\u0001\u001a\u00020@¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010CR\u0013\u0010\u008d\u0001\u001a\u00020@¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010CR$\u0010\u008f\u0001\u001a\u00020N*\u00030\u0090\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R$\u0010\u0095\u0001\u001a\u00020N*\u00030\u0090\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u0096\u0001\u0010\u0092\u0001\u001a\u0006\b\u0097\u0001\u0010\u0094\u0001R$\u0010\u0098\u0001\u001a\u00020N*\u00030\u0090\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u0099\u0001\u0010\u0092\u0001\u001a\u0006\b\u009a\u0001\u0010\u0094\u0001R$\u0010\u009b\u0001\u001a\u00020N*\u00030\u0090\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u009c\u0001\u0010\u0092\u0001\u001a\u0006\b\u009d\u0001\u0010\u0094\u0001R$\u0010\u009e\u0001\u001a\u00020H*\u00030\u0090\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u009f\u0001\u0010\u0092\u0001\u001a\u0006\b \u0001\u0010¡\u0001R$\u0010¢\u0001\u001a\u00020H*\u00030\u0090\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b£\u0001\u0010\u0092\u0001\u001a\u0006\b¤\u0001\u0010¡\u0001R$\u0010¥\u0001\u001a\u00020H*\u00030\u0090\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b¦\u0001\u0010\u0092\u0001\u001a\u0006\b§\u0001\u0010¡\u0001R$\u0010¨\u0001\u001a\u00020H*\u00030\u0090\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b©\u0001\u0010\u0092\u0001\u001a\u0006\bª\u0001\u0010¡\u0001¨\u0006«\u0001"}, d2 = {"Landroidx/compose/material3/MenuDefaults;", "", "<init>", "()V", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "ShadowElevation", "getShadowElevation-D9Ej5fM", "LeadingIconSize", "getLeadingIconSize-D9Ej5fM", "TrailingIconSize", "getTrailingIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "groupStandardContainerColor", "getGroupStandardContainerColor$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getGroupStandardContainerColor", "groupVibrantContainerColor", "getGroupVibrantContainerColor$annotations", "getGroupVibrantContainerColor", "leadingGroupShape", "getLeadingGroupShape$annotations", "getLeadingGroupShape", "middleGroupShape", "getMiddleGroupShape$annotations", "getMiddleGroupShape", "trailingGroupShape", "getTrailingGroupShape$annotations", "getTrailingGroupShape", "leadingItemShape", "getLeadingItemShape$annotations", "getLeadingItemShape", "middleItemShape", "getMiddleItemShape$annotations", "getMiddleItemShape", "trailingItemShape", "getTrailingItemShape$annotations", "getTrailingItemShape", "standaloneItemShape", "getStandaloneItemShape$annotations", "getStandaloneItemShape", "selectedItemShape", "getSelectedItemShape$annotations", "getSelectedItemShape", "standaloneGroupShape", "getStandaloneGroupShape$annotations", "getStandaloneGroupShape", "inactiveGroupShape", "getInactiveGroupShape$annotations", "getInactiveGroupShape", "GroupSpacing", "getGroupSpacing-D9Ej5fM$annotations", "getGroupSpacing-D9Ej5fM", "HorizontalDividerPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getHorizontalDividerPadding$annotations", "getHorizontalDividerPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DropdownMenuGroupLabelHorizontalPadding", "getDropdownMenuGroupLabelHorizontalPadding$annotations", "getDropdownMenuGroupLabelHorizontalPadding", "groupShape", "Landroidx/compose/material3/MenuGroupShapes;", FirebaseAnalytics.Param.INDEX, "", "count", "(IILandroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuGroupShapes;", "itemShape", "Landroidx/compose/material3/MenuItemShapes;", "(IILandroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuItemShapes;", "itemColors", "Landroidx/compose/material3/MenuItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuItemColors;", "itemShapes", "selectedShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuItemShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuItemShapes;", "groupShapes", "inactiveShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuGroupShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuGroupShapes;", TextFieldImplKt.LabelId, "", "contentAlignment", "Landroidx/compose/ui/Alignment;", ViewProps.PADDING, "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Alignment;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemTrailingLabelHorizontalPadding", "getDropdownMenuItemTrailingLabelHorizontalPadding$annotations", "getDropdownMenuItemTrailingLabelHorizontalPadding", "DropdownMenuItemTrailingLabel", "(Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LabelWithSupportingText", "supportingText", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "textColor", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "itemColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuItemColors;", "selectableItemColors", "selectedContainerColor", "selectedTextColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "selectableItemColors-HlaysQ4", "(JJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/MenuItemColors;", "selectableItemVibrantColors", "selectableItemVibrantColors-HlaysQ4", "defaultMenuItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultMenuItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/MenuItemColors;", "defaultMenuSelectableItemColors", "getDefaultMenuSelectableItemColors$material3$annotations", "(Landroidx/compose/material3/ColorScheme;)V", "getDefaultMenuSelectableItemColors$material3", "defaultMenuSelectableItemVibrantColors", "getDefaultMenuSelectableItemVibrantColors$material3$annotations", "getDefaultMenuSelectableItemVibrantColors$material3", "DropdownMenuItemContentPadding", "getDropdownMenuItemContentPadding", "SelectableItemVerticalPadding", "DropdownMenuSelectableItemContentPadding", "getDropdownMenuSelectableItemContentPadding", "DropdownMenuGroupContentPadding", "getDropdownMenuGroupContentPadding", "defaultMenuStandaloneItemShapes", "Landroidx/compose/material3/Shapes;", "getDefaultMenuStandaloneItemShapes$material3$annotations", "(Landroidx/compose/material3/Shapes;)V", "getDefaultMenuStandaloneItemShapes$material3", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/MenuItemShapes;", "defaultMenuLeadingItemShapes", "getDefaultMenuLeadingItemShapes$material3$annotations", "getDefaultMenuLeadingItemShapes$material3", "defaultMenuMiddleItemShapes", "getDefaultMenuMiddleItemShapes$material3$annotations", "getDefaultMenuMiddleItemShapes$material3", "defaultMenuTrailingItemShapes", "getDefaultMenuTrailingItemShapes$material3$annotations", "getDefaultMenuTrailingItemShapes$material3", "defaultMenuStandaloneGroupShapes", "getDefaultMenuStandaloneGroupShapes$material3$annotations", "getDefaultMenuStandaloneGroupShapes$material3", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/MenuGroupShapes;", "defaultMenuLeadingGroupShapes", "getDefaultMenuLeadingGroupShapes$material3$annotations", "getDefaultMenuLeadingGroupShapes$material3", "defaultMenuMiddleGroupShapes", "getDefaultMenuMiddleGroupShapes$material3$annotations", "getDefaultMenuMiddleGroupShapes$material3", "defaultMenuTrailingGroupShapes", "getDefaultMenuTrailingGroupShapes$material3$annotations", "getDefaultMenuTrailingGroupShapes$material3", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuDefaults {
    public static final int $stable = 0;
    private static final PaddingValues DropdownMenuGroupContentPadding;
    private static final PaddingValues DropdownMenuGroupLabelHorizontalPadding;
    private static final PaddingValues DropdownMenuItemContentPadding;
    private static final PaddingValues DropdownMenuItemTrailingLabelHorizontalPadding;
    private static final PaddingValues DropdownMenuSelectableItemContentPadding;
    private static final float GroupSpacing;
    private static final PaddingValues HorizontalDividerPadding;
    private static final float SelectableItemVerticalPadding;
    private static final float TrailingIconSize;
    public static final MenuDefaults INSTANCE = new MenuDefaults();
    private static final float TonalElevation = ElevationTokens.INSTANCE.m5774getLevel0D9Ej5fM();
    private static final float ShadowElevation = MenuTokens.INSTANCE.m5957getContainerElevationD9Ej5fM();
    private static final float LeadingIconSize = SegmentedMenuTokens.INSTANCE.m6157getItemLeadingIconSizeD9Ej5fM();

    static final Unit DropdownMenuItemTrailingLabel$lambda$1(MenuDefaults menuDefaults, PaddingValues paddingValues, Function2 function2, int i, int i2, Composer composer, int i3) {
        menuDefaults.DropdownMenuItemTrailingLabel(paddingValues, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Label$lambda$1(MenuDefaults menuDefaults, Alignment alignment, PaddingValues paddingValues, Function2 function2, int i, int i2, Composer composer, int i3) {
        menuDefaults.Label(alignment, paddingValues, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit LabelWithSupportingText$lambda$1(MenuDefaults menuDefaults, Function2 function2, Function2 function3, int i, Composer composer, int i2) {
        menuDefaults.LabelWithSupportingText(function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getDefaultMenuLeadingGroupShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuLeadingItemShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuMiddleGroupShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuMiddleItemShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuSelectableItemColors$material3$annotations(ColorScheme colorScheme) {
    }

    public static /* synthetic */ void getDefaultMenuSelectableItemVibrantColors$material3$annotations(ColorScheme colorScheme) {
    }

    public static /* synthetic */ void getDefaultMenuStandaloneGroupShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuStandaloneItemShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuTrailingGroupShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuTrailingItemShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDropdownMenuGroupLabelHorizontalPadding$annotations() {
    }

    public static /* synthetic */ void getDropdownMenuItemTrailingLabelHorizontalPadding$annotations() {
    }

    /* JADX INFO: renamed from: getGroupSpacing-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m4306getGroupSpacingD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getGroupStandardContainerColor$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getGroupVibrantContainerColor$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getHorizontalDividerPadding$annotations() {
    }

    public static /* synthetic */ void getInactiveGroupShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getLeadingGroupShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getLeadingItemShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getMiddleGroupShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getMiddleItemShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getSelectedItemShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getStandaloneGroupShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getStandaloneItemShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getTrailingGroupShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getTrailingItemShape$annotations(Composer composer, int i) {
    }

    private MenuDefaults() {
    }

    static {
        float fM6160getItemTrailingIconSizeD9Ej5fM;
        PaddingValues paddingValuesM2343PaddingValues0680j_4;
        PaddingValues paddingValuesM2344PaddingValuesYgX7TsA;
        if (!PrecisionPointer.getShouldUsePrecisionPointerComponentSizing().getValue().booleanValue()) {
            fM6160getItemTrailingIconSizeD9Ej5fM = SegmentedMenuTokens.INSTANCE.m6160getItemTrailingIconSizeD9Ej5fM();
        } else {
            fM6160getItemTrailingIconSizeD9Ej5fM = Dp.m10168constructorimpl(24.0f);
        }
        TrailingIconSize = fM6160getItemTrailingIconSizeD9Ej5fM;
        GroupSpacing = SegmentedMenuTokens.INSTANCE.m6162getSegmentedGapD9Ej5fM();
        HorizontalDividerPadding = PaddingKt.m2344PaddingValuesYgX7TsA(Dp.m10168constructorimpl(12.0f), Dp.m10168constructorimpl(2.0f));
        DropdownMenuGroupLabelHorizontalPadding = PaddingKt.m2347PaddingValuesa9UjIt4$default(Dp.m10168constructorimpl(12.0f), 0.0f, Dp.m10168constructorimpl(4.0f), 0.0f, 10, null);
        if (PrecisionPointer.getShouldUsePrecisionPointerComponentSizing().getValue().booleanValue()) {
            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2347PaddingValuesa9UjIt4$default(Dp.m10168constructorimpl(0.0f), 0.0f, Dp.m10168constructorimpl(6.0f), 0.0f, 10, null);
        } else {
            paddingValuesM2343PaddingValues0680j_4 = PaddingKt.m2343PaddingValues0680j_4(Dp.m10168constructorimpl(0.0f));
        }
        DropdownMenuItemTrailingLabelHorizontalPadding = paddingValuesM2343PaddingValues0680j_4;
        DropdownMenuItemContentPadding = PaddingKt.m2344PaddingValuesYgX7TsA(MenuKt.getDropdownMenuItemHorizontalPadding(), Dp.m10168constructorimpl(0.0f));
        float fM10168constructorimpl = Dp.m10168constructorimpl(12.0f);
        SelectableItemVerticalPadding = fM10168constructorimpl;
        if (PrecisionPointer.getShouldUsePrecisionPointerComponentSizing().getValue().booleanValue()) {
            paddingValuesM2344PaddingValuesYgX7TsA = PaddingKt.m2346PaddingValuesa9UjIt4(Dp.m10168constructorimpl(16.0f), fM10168constructorimpl, Dp.m10168constructorimpl(10.0f), fM10168constructorimpl);
        } else {
            paddingValuesM2344PaddingValuesYgX7TsA = PaddingKt.m2344PaddingValuesYgX7TsA(MenuKt.getDropdownMenuItemHorizontalPadding(), fM10168constructorimpl);
        }
        DropdownMenuSelectableItemContentPadding = paddingValuesM2344PaddingValuesYgX7TsA;
        DropdownMenuGroupContentPadding = PaddingKt.m2344PaddingValuesYgX7TsA(Dp.m10168constructorimpl(0.0f), MenuKt.getDropdownMenuGroupVerticalPadding());
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m4310getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    /* JADX INFO: renamed from: getShadowElevation-D9Ej5fM, reason: not valid java name */
    public final float m4309getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    /* JADX INFO: renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m4308getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* JADX INFO: renamed from: getTrailingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m4311getTrailingIconSizeD9Ej5fM() {
        return TrailingIconSize;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1323260959, "C(<get-shape>)61@2468L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1323260959, i, -1, "androidx.compose.material3.MenuDefaults.<get-shape> (MenuDefaults.kt:61)");
        }
        Shape value = ShapesKt.getValue(MenuTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2079969291, "C(<get-containerColor>)65@2603L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079969291, i, -1, "androidx.compose.material3.MenuDefaults.<get-containerColor> (MenuDefaults.kt:65)");
        }
        long value = ColorSchemeKt.getValue(MenuTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getGroupStandardContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1413243877, "C(<get-groupStandardContainerColor>)78@3133L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413243877, i, -1, "androidx.compose.material3.MenuDefaults.<get-groupStandardContainerColor> (MenuDefaults.kt:78)");
        }
        long value = ColorSchemeKt.getValue(StandardMenuTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getGroupVibrantContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1621528555, "C(<get-groupVibrantContainerColor>)91@3660L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1621528555, i, -1, "androidx.compose.material3.MenuDefaults.<get-groupVibrantContainerColor> (MenuDefaults.kt:91)");
        }
        long value = ColorSchemeKt.getValue(VibrantMenuTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLeadingGroupShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1396735891, "C(<get-leadingGroupShape>):MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1396735891, i, -1, "androidx.compose.material3.MenuDefaults.<get-leadingGroupShape> (MenuDefaults.kt:98)");
        }
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueLarge(), ShapeTokens.INSTANCE.getCornerValueLarge(), ShapeTokens.INSTANCE.getCornerValueSmall(), ShapeTokens.INSTANCE.getCornerValueSmall());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShape;
    }

    public final Shape getMiddleGroupShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1680742419, "C(<get-middleGroupShape>)108@4307L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1680742419, i, -1, "androidx.compose.material3.MenuDefaults.<get-middleGroupShape> (MenuDefaults.kt:108)");
        }
        Shape value = ShapesKt.getValue(SegmentedMenuTokens.INSTANCE.getGroupShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getTrailingGroupShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 190977843, "C(<get-trailingGroupShape>):MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(190977843, i, -1, "androidx.compose.material3.MenuDefaults.<get-trailingGroupShape> (MenuDefaults.kt:115)");
        }
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueSmall(), ShapeTokens.INSTANCE.getCornerValueSmall(), ShapeTokens.INSTANCE.getCornerValueLarge(), ShapeTokens.INSTANCE.getCornerValueLarge());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShape;
    }

    public final Shape getLeadingItemShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1207397875, "C(<get-leadingItemShape>):MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1207397875, i, -1, "androidx.compose.material3.MenuDefaults.<get-leadingItemShape> (MenuDefaults.kt:127)");
        }
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueMedium(), ShapeTokens.INSTANCE.getCornerValueMedium(), ShapeTokens.INSTANCE.getCornerValueExtraSmall(), ShapeTokens.INSTANCE.getCornerValueExtraSmall());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShape;
    }

    public final Shape getMiddleItemShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -828031119, "C(<get-middleItemShape>)137@5429L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-828031119, i, -1, "androidx.compose.material3.MenuDefaults.<get-middleItemShape> (MenuDefaults.kt:137)");
        }
        Shape value = ShapesKt.getValue(SegmentedMenuTokens.INSTANCE.getItemShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getTrailingItemShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 159265919, "C(<get-trailingItemShape>):MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(159265919, i, -1, "androidx.compose.material3.MenuDefaults.<get-trailingItemShape> (MenuDefaults.kt:144)");
        }
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueExtraSmall(), ShapeTokens.INSTANCE.getCornerValueExtraSmall(), ShapeTokens.INSTANCE.getCornerValueMedium(), ShapeTokens.INSTANCE.getCornerValueMedium());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShape;
    }

    public final Shape getStandaloneItemShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1501278127, "C(<get-standaloneItemShape>)154@6079L15:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1501278127, i, -1, "androidx.compose.material3.MenuDefaults.<get-standaloneItemShape> (MenuDefaults.kt:154)");
        }
        Shape middleItemShape = getMiddleItemShape(composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return middleItemShape;
    }

    public final Shape getSelectedItemShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 642731453, "C(<get-selectedItemShape>)159@6287L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(642731453, i, -1, "androidx.compose.material3.MenuDefaults.<get-selectedItemShape> (MenuDefaults.kt:159)");
        }
        Shape value = ShapesKt.getValue(SegmentedMenuTokens.INSTANCE.getItemSelectedShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getStandaloneGroupShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 555378067, "C(<get-standaloneGroupShape>)164@6496L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(555378067, i, -1, "androidx.compose.material3.MenuDefaults.<get-standaloneGroupShape> (MenuDefaults.kt:164)");
        }
        Shape value = ShapesKt.getValue(SegmentedMenuTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getInactiveGroupShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 823797139, "C(<get-inactiveGroupShape>)169@6724L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(823797139, i, -1, "androidx.compose.material3.MenuDefaults.<get-inactiveGroupShape> (MenuDefaults.kt:169)");
        }
        Shape value = ShapesKt.getValue(SegmentedMenuTokens.INSTANCE.getInactiveContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getGroupSpacing-D9Ej5fM, reason: not valid java name */
    public final float m4307getGroupSpacingD9Ej5fM() {
        return GroupSpacing;
    }

    public final PaddingValues getHorizontalDividerPadding() {
        return HorizontalDividerPadding;
    }

    public final PaddingValues getDropdownMenuGroupLabelHorizontalPadding() {
        return DropdownMenuGroupLabelHorizontalPadding;
    }

    public final MenuGroupShapes groupShape(int i, int i2, Composer composer, int i3) {
        MenuGroupShapes defaultMenuMiddleGroupShapes$material3;
        composer.startReplaceGroup(169026395);
        ComposerKt.sourceInformation(composer, "C(groupShape)N(index,count):MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(169026395, i3, -1, "androidx.compose.material3.MenuDefaults.groupShape (MenuDefaults.kt:194)");
        }
        if (i2 == 1) {
            composer.startReplaceGroup(1763746483);
            ComposerKt.sourceInformation(composer, "196@7898L6");
            MenuGroupShapes defaultMenuStandaloneGroupShapes$material3 = getDefaultMenuStandaloneGroupShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return defaultMenuStandaloneGroupShapes$material3;
        }
        composer.startReplaceGroup(1763827207);
        composer.endReplaceGroup();
        if (i == 0) {
            composer.startReplaceGroup(-774384072);
            ComposerKt.sourceInformation(composer, "200@8010L6");
            defaultMenuMiddleGroupShapes$material3 = getDefaultMenuLeadingGroupShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
        } else if (i == i2 - 1) {
            composer.startReplaceGroup(-774381639);
            ComposerKt.sourceInformation(composer, "201@8086L6");
            defaultMenuMiddleGroupShapes$material3 = getDefaultMenuTrailingGroupShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-774379337);
            ComposerKt.sourceInformation(composer, "202@8158L6");
            defaultMenuMiddleGroupShapes$material3 = getDefaultMenuMiddleGroupShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return defaultMenuMiddleGroupShapes$material3;
    }

    public final MenuItemShapes itemShape(int i, int i2, Composer composer, int i3) {
        MenuItemShapes defaultMenuMiddleItemShapes$material3;
        composer.startReplaceGroup(-1676944645);
        ComposerKt.sourceInformation(composer, "C(itemShape)N(index,count):MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1676944645, i3, -1, "androidx.compose.material3.MenuDefaults.itemShape (MenuDefaults.kt:217)");
        }
        if (i2 == 1) {
            composer.startReplaceGroup(1201749812);
            ComposerKt.sourceInformation(composer, "219@8877L6");
            MenuItemShapes defaultMenuStandaloneItemShapes$material3 = getDefaultMenuStandaloneItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return defaultMenuStandaloneItemShapes$material3;
        }
        composer.startReplaceGroup(1201829575);
        composer.endReplaceGroup();
        if (i == 0) {
            composer.startReplaceGroup(-931060361);
            ComposerKt.sourceInformation(composer, "223@8988L6");
            defaultMenuMiddleItemShapes$material3 = getDefaultMenuLeadingItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
        } else if (i == i2 - 1) {
            composer.startReplaceGroup(-931057960);
            ComposerKt.sourceInformation(composer, "224@9063L6");
            defaultMenuMiddleItemShapes$material3 = getDefaultMenuTrailingItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-931055690);
            ComposerKt.sourceInformation(composer, "225@9134L6");
            defaultMenuMiddleItemShapes$material3 = getDefaultMenuMiddleItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return defaultMenuMiddleItemShapes$material3;
    }

    public final MenuItemColors itemColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1208055030, "C(itemColors)233@9394L11:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1208055030, i, -1, "androidx.compose.material3.MenuDefaults.itemColors (MenuDefaults.kt:233)");
        }
        MenuItemColors defaultMenuItemColors$material3 = getDefaultMenuItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultMenuItemColors$material3;
    }

    public final MenuItemShapes itemShapes(Shape shape, Shape shape2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -402947630, "C(itemShapes)N(shape,selectedShape)250@10150L6:MenuDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = null;
        }
        if ((i2 & 2) != 0) {
            shape2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-402947630, i, -1, "androidx.compose.material3.MenuDefaults.itemShapes (MenuDefaults.kt:250)");
        }
        MenuItemShapes menuItemShapesCopy = getDefaultMenuStandaloneItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6)).copy(shape, shape2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return menuItemShapesCopy;
    }

    public final MenuItemShapes itemShapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -67210362, "C(itemShapes)267@10819L6:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-67210362, i, -1, "androidx.compose.material3.MenuDefaults.itemShapes (MenuDefaults.kt:267)");
        }
        MenuItemShapes defaultMenuStandaloneItemShapes$material3 = getDefaultMenuStandaloneItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultMenuStandaloneItemShapes$material3;
    }

    public final MenuGroupShapes groupShapes(Shape shape, Shape shape2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1616512324, "C(groupShapes)N(shape,inactiveShape)284@11594L6:MenuDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = null;
        }
        if ((i2 & 2) != 0) {
            shape2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1616512324, i, -1, "androidx.compose.material3.MenuDefaults.groupShapes (MenuDefaults.kt:284)");
        }
        MenuGroupShapes menuGroupShapesCopy = getDefaultMenuStandaloneGroupShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6)).copy(shape, shape2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return menuGroupShapesCopy;
    }

    public final MenuGroupShapes groupShapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1317759024, "C(groupShapes)298@12196L6:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1317759024, i, -1, "androidx.compose.material3.MenuDefaults.groupShapes (MenuDefaults.kt:298)");
        }
        MenuGroupShapes defaultMenuStandaloneGroupShapes$material3 = getDefaultMenuStandaloneGroupShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultMenuStandaloneGroupShapes$material3;
    }

    public final void Label(final Alignment alignment, final PaddingValues paddingValues, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1670978104);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Label)N(contentAlignment,padding,content)317@12966L10,317@12989L489,317@12935L543:MenuDefaults.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(alignment) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(paddingValues)) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i4 != 0) {
                    alignment = Alignment.INSTANCE.getCenterStart();
                }
                if ((i2 & 2) != 0) {
                    paddingValues = DropdownMenuGroupLabelHorizontalPadding;
                    i3 &= -113;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1670978104, i3, -1, "androidx.compose.material3.MenuDefaults.Label (MenuDefaults.kt:315)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getLabelLarge(), ComposableLambdaKt.rememberComposableLambda(-1723175511, true, new Function2() { // from class: androidx.compose.material3.MenuDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuDefaults.Label$lambda$0(paddingValues, alignment, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Alignment alignment2 = alignment;
        final PaddingValues paddingValues2 = paddingValues;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuDefaults$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuDefaults.Label$lambda$1(this.f$0, alignment2, paddingValues2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit Label$lambda$0(PaddingValues paddingValues, Alignment alignment, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C318@13003L465:MenuDefaults.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1723175511, i, -1, "androidx.compose.material3.MenuDefaults.Label.<anonymous> (MenuDefaults.kt:318)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.m2421sizeInqDBjuR0$default(Modifier.INSTANCE, MenuKt.getDropdownMenuItemDefaultMinWidth(), MenuKt.getDropdownMenuGroupDefaultMinHeight(), MenuKt.getDropdownMenuItemDefaultMaxWidth(), 0.0f, 8, null), paddingValues);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1234737845, "C328@13445L9:MenuDefaults.kt#uh7d8r");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public final PaddingValues getDropdownMenuItemTrailingLabelHorizontalPadding() {
        return DropdownMenuItemTrailingLabelHorizontalPadding;
    }

    public final void DropdownMenuItemTrailingLabel(final PaddingValues paddingValues, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-886948382);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItemTrailingLabel)N(padding,content)359@14519L10,359@14542L79,359@14488L133:MenuDefaults.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (((i2 & 1) == 0 && composerStartRestartGroup.changed(paddingValues)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(this) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
            } else if ((i2 & 1) != 0) {
                paddingValues = DropdownMenuItemTrailingLabelHorizontalPadding;
                i3 &= -15;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-886948382, i3, -1, "androidx.compose.material3.MenuDefaults.DropdownMenuItemTrailingLabel (MenuDefaults.kt:357)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getLabelLarge(), ComposableLambdaKt.rememberComposableLambda(-2074069101, true, new Function2() { // from class: androidx.compose.material3.MenuDefaults$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuDefaults.DropdownMenuItemTrailingLabel$lambda$0(paddingValues, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final PaddingValues paddingValues2 = paddingValues;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuDefaults.DropdownMenuItemTrailingLabel$lambda$1(this.f$0, paddingValues2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DropdownMenuItemTrailingLabel$lambda$0(PaddingValues paddingValues, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C360@14556L55:MenuDefaults.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2074069101, i, -1, "androidx.compose.material3.MenuDefaults.DropdownMenuItemTrailingLabel.<anonymous> (MenuDefaults.kt:360)");
            }
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, paddingValues);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1238126497, "C360@14600L9:MenuDefaults.kt#uh7d8r");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed in favor of the DropdownMenuItem APIs that have supportingText as a parameter.")
    public final void LabelWithSupportingText(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1578800865);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LabelWithSupportingText)N(supportingText,content)382@15325L195:MenuDefaults.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1578800865, i2, -1, "androidx.compose.material3.MenuDefaults.LabelWithSupportingText (MenuDefaults.kt:380)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m6446setimpl(composerM6438constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1071671318, "C383@15377L10,383@15346L72,384@15462L10,384@15431L79:MenuDefaults.kt#uh7d8r");
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getLabelLarge(), function3, composerStartRestartGroup, i2 & 112);
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getBodyMedium(), function2, composerStartRestartGroup, (i2 << 3) & 112);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuDefaults$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuDefaults.LabelWithSupportingText$lambda$1(this.f$0, function2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: itemColors-5tl4gsc, reason: not valid java name */
    public final MenuItemColors m4312itemColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -234858382, "C(itemColors)N(textColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color)411@16733L11:MenuDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        long jM7374getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        long jM7374getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-234858382, i, -1, "androidx.compose.material3.MenuDefaults.itemColors (MenuDefaults.kt:411)");
        }
        MenuItemColors menuItemColorsM4329copytNS2XkQ = getDefaultMenuItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4329copytNS2XkQ(jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4, jM7374getUnspecified0d7_KjU5, jM7374getUnspecified0d7_KjU6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return menuItemColorsM4329copytNS2XkQ;
    }

    /* JADX INFO: renamed from: selectableItemColors-HlaysQ4, reason: not valid java name */
    public final MenuItemColors m4313selectableItemColorsHlaysQ4(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 205867483, "C(selectableItemColors)N(textColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color,selectedTrailingIconColor:c#ui.graphics.Color)457@19203L11:MenuDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        long jM7374getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        long jM7374getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j6;
        long jM7374getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j7;
        long jM7374getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j8;
        long jM7374getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j9;
        long jM7374getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j10;
        long jM7374getUnspecified0d7_KjU11 = (i3 & 1024) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(205867483, i, i2, "androidx.compose.material3.MenuDefaults.selectableItemColors (MenuDefaults.kt:457)");
        }
        MenuItemColors menuItemColorsM4316copy2qZNXz8$default = MenuItemColors.m4316copy2qZNXz8$default(getDefaultMenuSelectableItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4, jM7374getUnspecified0d7_KjU5, 0L, jM7374getUnspecified0d7_KjU6, jM7374getUnspecified0d7_KjU7, jM7374getUnspecified0d7_KjU9, jM7374getUnspecified0d7_KjU8, jM7374getUnspecified0d7_KjU10, jM7374getUnspecified0d7_KjU11, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return menuItemColorsM4316copy2qZNXz8$default;
    }

    /* JADX INFO: renamed from: selectableItemVibrantColors-HlaysQ4, reason: not valid java name */
    public final MenuItemColors m4314selectableItemVibrantColorsHlaysQ4(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1727700721, "C(selectableItemVibrantColors)N(textColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color,selectedTrailingIconColor:c#ui.graphics.Color)508@21978L11:MenuDefaults.kt#uh7d8r");
        long jM7374getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j;
        long jM7374getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j2;
        long jM7374getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j3;
        long jM7374getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j4;
        long jM7374getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j5;
        long jM7374getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j6;
        long jM7374getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j7;
        long jM7374getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j8;
        long jM7374getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j9;
        long jM7374getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j10;
        long jM7374getUnspecified0d7_KjU11 = (i3 & 1024) != 0 ? Color.INSTANCE.m7374getUnspecified0d7_KjU() : j11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1727700721, i, i2, "androidx.compose.material3.MenuDefaults.selectableItemVibrantColors (MenuDefaults.kt:508)");
        }
        MenuItemColors menuItemColorsM4316copy2qZNXz8$default = MenuItemColors.m4316copy2qZNXz8$default(getDefaultMenuSelectableItemVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM7374getUnspecified0d7_KjU, jM7374getUnspecified0d7_KjU2, jM7374getUnspecified0d7_KjU3, jM7374getUnspecified0d7_KjU4, jM7374getUnspecified0d7_KjU5, 0L, jM7374getUnspecified0d7_KjU6, jM7374getUnspecified0d7_KjU7, jM7374getUnspecified0d7_KjU9, jM7374getUnspecified0d7_KjU8, jM7374getUnspecified0d7_KjU10, jM7374getUnspecified0d7_KjU11, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return menuItemColorsM4316copy2qZNXz8$default;
    }

    public final MenuItemColors getDefaultMenuItemColors$material3(ColorScheme colorScheme) {
        MenuItemColors defaultMenuItemColorsCached$material3 = colorScheme.getDefaultMenuItemColorsCached();
        if (defaultMenuItemColorsCached$material3 != null) {
            return defaultMenuItemColorsCached$material3;
        }
        MenuItemColors menuItemColors = new MenuItemColors(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemTrailingIconColor()), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledLabelTextColor()), ListTokens.INSTANCE.getItemDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledLeadingIconColor()), ListTokens.INSTANCE.getItemDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledTrailingIconColor()), ListTokens.INSTANCE.getItemDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultMenuItemColorsCached$material3(menuItemColors);
        return menuItemColors;
    }

    public final MenuItemColors getDefaultMenuSelectableItemColors$material3(ColorScheme colorScheme) {
        MenuItemColors defaultMenuSelectableItemColorsCached$material3 = colorScheme.getDefaultMenuSelectableItemColorsCached();
        if (defaultMenuSelectableItemColorsCached$material3 != null) {
            return defaultMenuSelectableItemColorsCached$material3;
        }
        long jFromToken = ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemLabelTextColor());
        long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getContainerColor());
        MenuItemColors menuItemColors = new MenuItemColors(jFromToken, ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemTrailingIconColor()), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemDisabledLabelTextColor()), StandardMenuTokens.INSTANCE.getItemDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemDisabledLeadingIconColor()), StandardMenuTokens.INSTANCE.getItemDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemDisabledTrailingIconColor()), StandardMenuTokens.INSTANCE.getItemDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), jFromToken2, ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemSelectedTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemSelectedContainerColor()), null);
        colorScheme.setDefaultMenuSelectableItemColorsCached$material3(menuItemColors);
        return menuItemColors;
    }

    public final MenuItemColors getDefaultMenuSelectableItemVibrantColors$material3(ColorScheme colorScheme) {
        MenuItemColors defaultMenuSelectableItemVibrantColorsCached$material3 = colorScheme.getDefaultMenuSelectableItemVibrantColorsCached();
        if (defaultMenuSelectableItemVibrantColorsCached$material3 != null) {
            return defaultMenuSelectableItemVibrantColorsCached$material3;
        }
        long jFromToken = ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemLabelTextColor());
        long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getContainerColor());
        MenuItemColors menuItemColors = new MenuItemColors(jFromToken, ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemTrailingIconColor()), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemDisabledLabelTextColor()), VibrantMenuTokens.INSTANCE.getItemDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemDisabledLeadingIconColor()), VibrantMenuTokens.INSTANCE.getItemDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m7337copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemDisabledTrailingIconColor()), VibrantMenuTokens.INSTANCE.getItemDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), jFromToken2, ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemSelectedTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemSelectedContainerColor()), null);
        colorScheme.setDefaultMenuSelectableItemVibrantColorsCached$material3(menuItemColors);
        return menuItemColors;
    }

    public final PaddingValues getDropdownMenuItemContentPadding() {
        return DropdownMenuItemContentPadding;
    }

    public final PaddingValues getDropdownMenuSelectableItemContentPadding() {
        return DropdownMenuSelectableItemContentPadding;
    }

    public final PaddingValues getDropdownMenuGroupContentPadding() {
        return DropdownMenuGroupContentPadding;
    }

    public final MenuItemShapes getDefaultMenuStandaloneItemShapes$material3(Shapes shapes) {
        MenuItemShapes defaultMenuStandaloneItemShapesCached$material3 = shapes.getDefaultMenuStandaloneItemShapesCached();
        if (defaultMenuStandaloneItemShapesCached$material3 != null) {
            return defaultMenuStandaloneItemShapesCached$material3;
        }
        MenuItemShapes menuItemShapes = new MenuItemShapes(ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getItemShape()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getItemSelectedShape()));
        shapes.setDefaultMenuStandaloneItemShapesCached$material3(menuItemShapes);
        return menuItemShapes;
    }

    public final MenuItemShapes getDefaultMenuLeadingItemShapes$material3(Shapes shapes) {
        MenuItemShapes defaultMenuLeadingItemShapesCached$material3 = shapes.getDefaultMenuLeadingItemShapesCached();
        if (defaultMenuLeadingItemShapesCached$material3 != null) {
            return defaultMenuLeadingItemShapesCached$material3;
        }
        MenuItemShapes menuItemShapes = new MenuItemShapes(new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueMedium(), ShapeTokens.INSTANCE.getCornerValueMedium(), ShapeTokens.INSTANCE.getCornerValueExtraSmall(), ShapeTokens.INSTANCE.getCornerValueExtraSmall()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getItemSelectedShape()));
        shapes.setDefaultMenuLeadingItemShapesCached$material3(menuItemShapes);
        return menuItemShapes;
    }

    public final MenuItemShapes getDefaultMenuMiddleItemShapes$material3(Shapes shapes) {
        MenuItemShapes defaultMenuMiddleItemShapesCached$material3 = shapes.getDefaultMenuMiddleItemShapesCached();
        if (defaultMenuMiddleItemShapesCached$material3 != null) {
            return defaultMenuMiddleItemShapesCached$material3;
        }
        MenuItemShapes menuItemShapes = new MenuItemShapes(ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getItemShape()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getItemSelectedShape()));
        shapes.setDefaultMenuMiddleItemShapesCached$material3(menuItemShapes);
        return menuItemShapes;
    }

    public final MenuItemShapes getDefaultMenuTrailingItemShapes$material3(Shapes shapes) {
        MenuItemShapes defaultMenuTrailingItemShapesCached$material3 = shapes.getDefaultMenuTrailingItemShapesCached();
        if (defaultMenuTrailingItemShapesCached$material3 != null) {
            return defaultMenuTrailingItemShapesCached$material3;
        }
        MenuItemShapes menuItemShapes = new MenuItemShapes(new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueExtraSmall(), ShapeTokens.INSTANCE.getCornerValueExtraSmall(), ShapeTokens.INSTANCE.getCornerValueMedium(), ShapeTokens.INSTANCE.getCornerValueMedium()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getItemSelectedShape()));
        shapes.setDefaultMenuTrailingItemShapesCached$material3(menuItemShapes);
        return menuItemShapes;
    }

    public final MenuGroupShapes getDefaultMenuStandaloneGroupShapes$material3(Shapes shapes) {
        MenuGroupShapes defaultMenuStandaloneGroupShapesCached$material3 = shapes.getDefaultMenuStandaloneGroupShapesCached();
        if (defaultMenuStandaloneGroupShapesCached$material3 != null) {
            return defaultMenuStandaloneGroupShapesCached$material3;
        }
        MenuGroupShapes menuGroupShapes = new MenuGroupShapes(ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getContainerShape()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getInactiveContainerShape()));
        shapes.setDefaultMenuStandaloneGroupShapesCached$material3(menuGroupShapes);
        return menuGroupShapes;
    }

    public final MenuGroupShapes getDefaultMenuLeadingGroupShapes$material3(Shapes shapes) {
        MenuGroupShapes defaultMenuLeadingGroupShapesCached$material3 = shapes.getDefaultMenuLeadingGroupShapesCached();
        if (defaultMenuLeadingGroupShapesCached$material3 != null) {
            return defaultMenuLeadingGroupShapesCached$material3;
        }
        MenuGroupShapes menuGroupShapes = new MenuGroupShapes(new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueLarge(), ShapeTokens.INSTANCE.getCornerValueLarge(), ShapeTokens.INSTANCE.getCornerValueSmall(), ShapeTokens.INSTANCE.getCornerValueSmall()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getInactiveContainerShape()));
        shapes.setDefaultMenuLeadingGroupShapesCached$material3(menuGroupShapes);
        return menuGroupShapes;
    }

    public final MenuGroupShapes getDefaultMenuMiddleGroupShapes$material3(Shapes shapes) {
        MenuGroupShapes defaultMenuMiddleGroupShapesCached$material3 = shapes.getDefaultMenuMiddleGroupShapesCached();
        if (defaultMenuMiddleGroupShapesCached$material3 != null) {
            return defaultMenuMiddleGroupShapesCached$material3;
        }
        MenuGroupShapes menuGroupShapes = new MenuGroupShapes(ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getGroupShape()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getInactiveContainerShape()));
        shapes.setDefaultMenuMiddleGroupShapesCached$material3(menuGroupShapes);
        return menuGroupShapes;
    }

    public final MenuGroupShapes getDefaultMenuTrailingGroupShapes$material3(Shapes shapes) {
        MenuGroupShapes defaultMenuTrailingGroupShapesCached$material3 = shapes.getDefaultMenuTrailingGroupShapesCached();
        if (defaultMenuTrailingGroupShapesCached$material3 != null) {
            return defaultMenuTrailingGroupShapesCached$material3;
        }
        MenuGroupShapes menuGroupShapes = new MenuGroupShapes(new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueSmall(), ShapeTokens.INSTANCE.getCornerValueSmall(), ShapeTokens.INSTANCE.getCornerValueLarge(), ShapeTokens.INSTANCE.getCornerValueLarge()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getInactiveContainerShape()));
        shapes.setDefaultMenuTrailingGroupShapesCached$material3(menuGroupShapes);
        return menuGroupShapes;
    }
}
