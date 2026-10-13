package androidx.compose.material3.internal;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MotionSchemeKt;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.TextFieldLabelScope;
import androidx.compose.material3.Typography;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.material3.tokens.TypeScaleTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.profileinstaller.ProfileVerifier;
import com.datadog.android.webview.internal.rum.WebViewRumEventMapper;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\u001a\u0099\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\n2\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\b¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010 \u001a\u0081\u0001\u0010!\u001a\u00020\u00012\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00162\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u001c\u0010-\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\b¢\u0006\u0002\b\u000eH\u0003¢\u0006\u0002\u0010.\u001a2\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020+2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\b<\u0010=\u001a*\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020:2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\b>\u0010?\u001a\u001c\u0010@\u001a\u00020A*\u00020A2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010B\u001a\u00020CH\u0000\u001a\u001c\u0010D\u001a\u00020A*\u00020A2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0000\u001a\u001a\u0010I\u001a\u00020A*\u00020A2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u0007H\u0000\u001a%\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#*\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010/\u001a\u00020\u0016H\u0003¢\u0006\u0002\u0010L\u001a%\u0010M\u001a\b\u0012\u0004\u0012\u00020$0#*\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010/\u001a\u00020\u0016H\u0003¢\u0006\u0002\u0010L\u001a%\u0010N\u001a\b\u0012\u0004\u0012\u00020$0#*\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010/\u001a\u00020\u0016H\u0003¢\u0006\u0002\u0010L\u001a/\u0010O\u001a\b\u0012\u0004\u0012\u00020:0#*\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020:H\u0003¢\u0006\u0004\bR\u0010S\u001a'\u0010T\u001a\b\u0012\u0004\u0012\u00020:0#*\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010U\u001a\u00020:H\u0003¢\u0006\u0004\bV\u0010W\u001a\r\u0010a\u001a\u00020KH\u0001¢\u0006\u0002\u0010b\u001a\r\u0010c\u001a\u00020KH\u0001¢\u0006\u0002\u0010b\"\u0018\u0010/\u001a\u00020\u0016*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101\"\u0018\u00102\u001a\u000203*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u00105\"\u0018\u00106\u001a\u000203*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b7\u00105\"\u000e\u0010X\u001a\u00020CX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010Y\u001a\u00020CX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010Z\u001a\u00020CX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u00020CX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\\\u001a\u00020CX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010]\u001a\u00020CX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u00020CX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010_\u001a\u00020CX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u00020CX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010d\u001a\u00020KX\u0080\u0004¢\u0006\n\n\u0002\u0010g\u001a\u0004\be\u0010f\"\u0016\u0010h\u001a\u00020KX\u0080\u0004¢\u0006\n\n\u0002\u0010g\u001a\u0004\bi\u0010f\"\u0016\u0010j\u001a\u00020KX\u0080\u0004¢\u0006\n\n\u0002\u0010g\u001a\u0004\bk\u0010f\"\u0016\u0010l\u001a\u00020KX\u0080\u0004¢\u0006\n\n\u0002\u0010g\u001a\u0004\bm\u0010f\"\u0016\u0010n\u001a\u00020KX\u0080\u0004¢\u0006\n\n\u0002\u0010g\u001a\u0004\bo\u0010f\"\u0016\u0010p\u001a\u00020KX\u0080\u0004¢\u0006\n\n\u0002\u0010g\u001a\u0004\bq\u0010f\"\u0016\u0010r\u001a\u00020KX\u0080\u0004¢\u0006\n\n\u0002\u0010g\u001a\u0004\bs\u0010f\"\u0016\u0010t\u001a\u00020KX\u0080\u0004¢\u0006\n\n\u0002\u0010g\u001a\u0004\bu\u0010f¨\u0006v²\u0006\n\u0010w\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u0010x\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"CommonDecorationBox", "", "type", "Landroidx/compose/material3/internal/TextFieldType;", "visualText", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Lkotlin/ExtensionFunctionType;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", WebViewRumEventMapper.CONTAINER_KEY_NAME, "(Landroidx/compose/material3/internal/TextFieldType;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DecoratedLabel", "labelProgress", "Landroidx/compose/runtime/State;", "", "isFocused", "overrideLabelTextStyleColor", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/material3/internal/InputPhase;", "bodySmall", "Landroidx/compose/ui/text/TextStyle;", "bodyLarge", "content", "(Landroidx/compose/runtime/State;Landroidx/compose/material3/TextFieldColors;ZZZZLandroidx/compose/animation/core/Transition;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "showExpandedLabel", "getShowExpandedLabel", "(Landroidx/compose/material3/TextFieldLabelPosition;)Z", "minimizedAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "getMinimizedAlignment", "(Landroidx/compose/material3/TextFieldLabelPosition;)Landroidx/compose/ui/Alignment$Horizontal;", "expandedAlignment", "getExpandedAlignment", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Decoration-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Decoration-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "defaultErrorSemantics", "Landroidx/compose/ui/Modifier;", "defaultErrorMessage", "", "textFieldBackground", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "shape", "Landroidx/compose/ui/graphics/Shape;", "textFieldLabelMinHeight", ViewProps.MIN_HEIGHT, "Landroidx/compose/ui/unit/Dp;", "(Landroidx/compose/animation/core/Transition;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "placeholderOpacity", "affixOpacity", "labelTextStyleColor", "focusedLabelTextStyleColor", "unfocusedLabelTextStyleColor", "labelTextStyleColor-1wkBAMs", "(Landroidx/compose/animation/core/Transition;JJLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "labelContentColor", "labelColor", "labelContentColor-RPmYEkk", "(Landroidx/compose/animation/core/Transition;JLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "TextFieldId", "PlaceholderId", "LabelId", "LeadingId", "TrailingId", "PrefixId", "SuffixId", "SupportingId", "ContainerId", "textFieldHorizontalIconPadding", "(Landroidx/compose/runtime/Composer;I)F", "minimizedLabelHalfHeight", "TextFieldPadding", "getTextFieldPadding", "()F", "F", "AboveLabelHorizontalPadding", "getAboveLabelHorizontalPadding", "AboveLabelBottomPadding", "getAboveLabelBottomPadding", "SupportingTopPadding", "getSupportingTopPadding", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "MinTextLineHeight", "getMinTextLineHeight", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "material3", "showPlaceholder", "showAffix"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextFieldImplKt {
    public static final String ContainerId = "Container";
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    public static final String TextFieldId = "TextField";
    public static final String TrailingId = "Trailing";
    private static final float TextFieldPadding = Dp.m10168constructorimpl(16.0f);
    private static final float AboveLabelHorizontalPadding = Dp.m10168constructorimpl(4.0f);
    private static final float AboveLabelBottomPadding = Dp.m10168constructorimpl(4.0f);
    private static final float SupportingTopPadding = Dp.m10168constructorimpl(4.0f);
    private static final float PrefixSuffixTextPadding = Dp.m10168constructorimpl(2.0f);
    private static final float MinTextLineHeight = Dp.m10168constructorimpl(24.0f);
    private static final float MinFocusedLabelLineHeight = Dp.m10168constructorimpl(16.0f);
    private static final float MinSupportingTextLineHeight = Dp.m10168constructorimpl(16.0f);

    /* JADX INFO: compiled from: TextFieldImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TextFieldType.values().length];
            try {
                iArr[TextFieldType.Filled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFieldType.Outlined.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[InputPhase.values().length];
            try {
                iArr2[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static final Unit CommonDecorationBox$lambda$18(TextFieldType textFieldType, CharSequence charSequence, Function2 function2, TextFieldLabelPosition textFieldLabelPosition, Function3 function3, Function2 function4, Function2 function5, Function2 function6, Function2 function7, Function2 function8, Function2 function9, boolean z, boolean z2, boolean z3, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, Function2 function10, int i, int i2, Composer composer, int i3) {
        CommonDecorationBox(textFieldType, charSequence, function2, textFieldLabelPosition, function3, function4, function5, function6, function7, function8, function9, z, z2, z3, interactionSource, paddingValues, textFieldColors, function10, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    static final Unit DecoratedLabel$lambda$5(State state, TextFieldColors textFieldColors, boolean z, boolean z2, boolean z3, boolean z4, Transition transition, TextStyle textStyle, TextStyle textStyle2, Function3 function3, int i, Composer composer, int i2) {
        DecoratedLabel(state, textFieldColors, z, z2, z3, z4, transition, textStyle, textStyle2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit Decoration_3J_VO9M$lambda$0(long j, TextStyle textStyle, Function2 function2, int i, Composer composer, int i2) {
        m5511Decoration3JVO9M(j, textStyle, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit Decoration_Iv8Zu3U$lambda$0(long j, Function2 function2, int i, Composer composer, int i2) {
        m5512DecorationIv8Zu3U(j, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CommonDecorationBox(final TextFieldType textFieldType, final CharSequence charSequence, final Function2<? super Composer, ? super Integer, Unit> function2, final TextFieldLabelPosition textFieldLabelPosition, final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final Function2<? super Composer, ? super Integer, Unit> function6, final Function2<? super Composer, ? super Integer, Unit> function7, final Function2<? super Composer, ? super Integer, Unit> function8, final Function2<? super Composer, ? super Integer, Unit> function9, final boolean z, final boolean z2, final boolean z3, final InteractionSource interactionSource, final PaddingValues paddingValues, final TextFieldColors textFieldColors, final Function2<? super Composer, ? super Integer, Unit> function10, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        Composer composer2;
        InputPhase inputPhase;
        final State<Float> stateLabelProgress;
        State<Float> statePlaceholderOpacity;
        boolean z4;
        final State<Float> stateAffixOpacity;
        Composer composer3;
        final boolean z5;
        boolean z6;
        final TextFieldColors textFieldColors2;
        ComposableLambda composableLambda;
        final State<Float> state;
        ComposableLambda composableLambdaRememberComposableLambda;
        ComposableLambda composableLambda2;
        ComposableLambda composableLambda3;
        ComposableLambda composableLambdaRememberComposableLambda2;
        ComposableLambda composableLambda4;
        ComposableLambda composableLambdaRememberComposableLambda3;
        Composer composerStartRestartGroup = composer.startRestartGroup(546805032);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CommonDecorationBox)N(type,visualText,innerTextField,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,singleLine,enabled,isError,interactionSource,contentPadding,colors,container)95@3914L25,103@4183L10,110@4517L59,156@6024L108,173@6696L102,211@8252L30,212@8318L33,213@8381L27:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(textFieldType.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i4 = i3 | (composerStartRestartGroup.changedInstance(charSequence) ? 32 : 16);
        } else {
            i4 = i3;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(textFieldLabelPosition) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function5) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function6) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function7) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function8) ? 536870912 : 268435456;
        }
        int i6 = i4;
        if ((i2 & 6) == 0) {
            i5 = i2 | (composerStartRestartGroup.changedInstance(function9) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(interactionSource) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= composerStartRestartGroup.changed(paddingValues) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i5 |= composerStartRestartGroup.changed(textFieldColors) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function10) ? 8388608 : 4194304;
        }
        int i7 = i5;
        if (composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (4793491 & i7) == 4793490) ? false : true, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(546805032, i6, i7, "androidx.compose.material3.internal.CommonDecorationBox (TextFieldImpl.kt:94)");
            }
            boolean zBooleanValue = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i7 >> 12) & 14).getValue().booleanValue();
            if (zBooleanValue) {
                inputPhase = InputPhase.Focused;
            } else {
                inputPhase = charSequence.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            Typography typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            final TextStyle bodyLarge = typography.getBodyLarge();
            final TextStyle bodySmall = typography.getBodySmall();
            final boolean z7 = (Color.m7339equalsimpl0(bodyLarge.m9628getColor0d7_KjU(), Color.INSTANCE.m7374getUnspecified0d7_KjU()) && !Color.m7339equalsimpl0(bodySmall.m9628getColor0d7_KjU(), Color.INSTANCE.m7374getUnspecified0d7_KjU())) || (!Color.m7339equalsimpl0(bodyLarge.m9628getColor0d7_KjU(), Color.INSTANCE.m7374getUnspecified0d7_KjU()) && Color.m7339equalsimpl0(bodySmall.m9628getColor0d7_KjU(), Color.INSTANCE.m7374getUnspecified0d7_KjU()));
            final Transition transitionUpdateTransition = TransitionKt.updateTransition(inputPhase, "TextFieldInputState", composerStartRestartGroup, 48, 0);
            boolean z8 = function3 != null && getShowExpandedLabel(textFieldLabelPosition);
            if (function3 != null) {
                composerStartRestartGroup.startReplaceGroup(-940723593);
                ComposerKt.sourceInformation(composerStartRestartGroup, "116@4732L32");
                stateLabelProgress = labelProgress(transitionUpdateTransition, z8, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-940652386);
                composerStartRestartGroup.endReplaceGroup();
                stateLabelProgress = null;
            }
            if (function4 != null) {
                composerStartRestartGroup.startReplaceGroup(-940561742);
                ComposerKt.sourceInformation(composerStartRestartGroup, "123@4895L37");
                statePlaceholderOpacity = placeholderOpacity(transitionUpdateTransition, z8, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-940485730);
                composerStartRestartGroup.endReplaceGroup();
                statePlaceholderOpacity = null;
            }
            if (function7 == null && function8 == null) {
                composerStartRestartGroup.startReplaceGroup(-940318082);
                composerStartRestartGroup.endReplaceGroup();
                stateAffixOpacity = null;
                z4 = false;
            } else {
                composerStartRestartGroup.startReplaceGroup(-940388328);
                ComposerKt.sourceInformation(composerStartRestartGroup, "130@5070L31");
                z4 = false;
                stateAffixOpacity = affixOpacity(transitionUpdateTransition, z8, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (function3 == null) {
                composerStartRestartGroup.startReplaceGroup(-940231841);
                composerStartRestartGroup.endReplaceGroup();
                z6 = z4;
                composer3 = composerStartRestartGroup;
                z5 = zBooleanValue;
                composableLambda = null;
                textFieldColors2 = textFieldColors;
            } else {
                composerStartRestartGroup.startReplaceGroup(-940231840);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*137@5226L521");
                composer3 = composerStartRestartGroup;
                z5 = zBooleanValue;
                z6 = false;
                textFieldColors2 = textFieldColors;
                ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(1632654811, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$0$0(stateLabelProgress, textFieldColors2, z2, z3, z5, z7, transitionUpdateTransition, bodySmall, bodyLarge, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda4;
            }
            final long jM4890placeholderColorXeAY9LY = textFieldColors2.m4890placeholderColorXeAY9LY(r13, r14, z5);
            ComposableLambda composableLambda5 = composableLambda;
            ComposerKt.sourceInformationMarkerStart(composer3, 1493716916, "CC(remember):TextFieldImpl.kt#9igjgp");
            Object objRememberedValue = composer3.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                state = statePlaceholderOpacity;
                objRememberedValue = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TextFieldImplKt.CommonDecorationBox$lambda$1$0(state));
                    }
                });
                composer3.updateRememberedValue(objRememberedValue);
            } else {
                state = statePlaceholderOpacity;
            }
            State state2 = (State) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (function4 != null && charSequence.length() == 0 && CommonDecorationBox$lambda$2(state2)) {
                composer3.startReplaceGroup(-939160356);
                ComposerKt.sourceInformation(composer3, "161@6301L282");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-720601610, true, new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$3(jM4890placeholderColorXeAY9LY, bodyLarge, function4, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(-938848683);
                composer3.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            }
            final long jM4891prefixColorXeAY9LY = textFieldColors2.m4891prefixColorXeAY9LY(r13, r14, z5);
            ComposerKt.sourceInformationMarkerStart(composer3, 1493738414, "CC(remember):TextFieldImpl.kt#9igjgp");
            Object objRememberedValue2 = composer3.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TextFieldImplKt.CommonDecorationBox$lambda$4$0(stateAffixOpacity));
                    }
                });
                composer3.updateRememberedValue(objRememberedValue2);
            }
            State state3 = (State) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (function7 == null || !CommonDecorationBox$lambda$5(state3)) {
                composer3.startReplaceGroup(-938405259);
                composer3.endReplaceGroup();
                composableLambda2 = null;
            } else {
                composer3.startReplaceGroup(-938552601);
                ComposerKt.sourceInformation(composer3, "178@6919L111");
                ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-1271185508, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$6(jM4891prefixColorXeAY9LY, bodyLarge, function7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
                composableLambda2 = composableLambdaRememberComposableLambda5;
            }
            final long jM4892suffixColorXeAY9LY = textFieldColors2.m4892suffixColorXeAY9LY(r13, r14, z5);
            if (function8 == null || !CommonDecorationBox$lambda$5(state3)) {
                composer3.startReplaceGroup(-938084843);
                composer3.endReplaceGroup();
                composableLambda3 = null;
            } else {
                composer3.startReplaceGroup(-938232185);
                ComposerKt.sourceInformation(composer3, "186@7242L111");
                ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(123777469, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$7(jM4892suffixColorXeAY9LY, bodyLarge, function8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
                composableLambda3 = composableLambdaRememberComposableLambda6;
            }
            final long jM4889leadingIconColorXeAY9LY = textFieldColors2.m4889leadingIconColorXeAY9LY(r13, r14, z5);
            if (function5 == null) {
                composer3.startReplaceGroup(-937922124);
                composer3.endReplaceGroup();
                composableLambdaRememberComposableLambda2 = null;
            } else {
                composer3.startReplaceGroup(-937922123);
                ComposerKt.sourceInformation(composer3, "*194@7560L61");
                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-906968406, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$8$0(jM4889leadingIconColorXeAY9LY, function5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
            }
            final long jM4895trailingIconColorXeAY9LY = textFieldColors2.m4895trailingIconColorXeAY9LY(r13, r14, z5);
            if (function6 == null) {
                composer3.startReplaceGroup(-937662189);
                composer3.endReplaceGroup();
                composableLambda4 = null;
            } else {
                composer3.startReplaceGroup(-937662188);
                ComposerKt.sourceInformation(composer3, "*200@7822L62");
                ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(-1287792574, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$9$0(jM4895trailingIconColorXeAY9LY, function6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
                composableLambda4 = composableLambdaRememberComposableLambda7;
            }
            final long jM4893supportingTextColorXeAY9LY = textFieldColors2.m4893supportingTextColorXeAY9LY(z2, z3, z5);
            if (function9 == null) {
                composer3.startReplaceGroup(-937391714);
                composer3.endReplaceGroup();
                composableLambdaRememberComposableLambda3 = null;
            } else {
                composer3.startReplaceGroup(-937391713);
                ComposerKt.sourceInformation(composer3, "*206@8093L115");
                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1612592437, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$10$0(jM4893supportingTextColorXeAY9LY, bodySmall, function9, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composer3, 1493788134, "CC(remember):TextFieldImpl.kt#9igjgp");
            final State<Float> state4 = stateLabelProgress;
            boolean zChanged = composer3.changed(state4);
            Object objRememberedValue3 = composer3.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(TextFieldImplKt.CommonDecorationBox$lambda$11$0(state4));
                    }
                };
                composer3.updateRememberedValue(objRememberedValue3);
            }
            final Function0 function0 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, 1493790249, "CC(remember):TextFieldImpl.kt#9igjgp");
            boolean zChanged2 = composer3.changed(state);
            Object objRememberedValue4 = composer3.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(TextFieldImplKt.CommonDecorationBox$lambda$12$0(state));
                    }
                };
                composer3.updateRememberedValue(objRememberedValue4);
            }
            Function0 function1 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, 1493792259, "CC(remember):TextFieldImpl.kt#9igjgp");
            boolean zChanged3 = composer3.changed(stateAffixOpacity);
            Object objRememberedValue5 = composer3.rememberedValue();
            if (zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(TextFieldImplKt.CommonDecorationBox$lambda$13$0(stateAffixOpacity));
                    }
                };
                composer3.updateRememberedValue(objRememberedValue5);
            }
            Function0 function11 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            int i8 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
            if (i8 == 1) {
                composer3.startReplaceGroup(-936973554);
                ComposerKt.sourceInformation(composer3, "216@8519L115,220@8648L773");
                Composer composer4 = composer3;
                TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2, composableLambda5, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, composableLambda4, composableLambda2, composableLambda3, z, textFieldLabelPosition, new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function0), new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function1), new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function11), ComposableLambdaKt.rememberComposableLambda(-358432442, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$14(function10, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composableLambdaRememberComposableLambda3, paddingValues, composer4, ((i6 >> 3) & 112) | 6 | ((i7 << 21) & 234881024) | ((i6 << 18) & 1879048192), (i7 & 458752) | 3072);
                composer2 = composer4;
                composer2.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            } else {
                if (i8 != 2) {
                    composer3.startReplaceGroup(1493796415);
                    composer3.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer3.startReplaceGroup(-935939642);
                ComposerKt.sourceInformation(composer3, "241@9528L38,242@9631L469,267@10611L619,256@10114L1442");
                ComposerKt.sourceInformationMarkerStart(composer3, 1493828974, "CC(remember):TextFieldImpl.kt#9igjgp");
                Object objRememberedValue6 = composer3.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m7130boximpl(Size.INSTANCE.m7151getZeroNHjbRc()), null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                final MutableState mutableState = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposableLambda composableLambda6 = composableLambda2;
                ComposableLambda composableLambda7 = composableLambda3;
                ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(-403938615, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldImplKt.CommonDecorationBox$lambda$16(mutableState, textFieldLabelPosition, paddingValues, function10, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                Modifier.Companion companion = Modifier.INSTANCE;
                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 = new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function0);
                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1 = new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function1);
                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2 = new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function11);
                Modifier.Companion companion2 = companion;
                ComposerKt.sourceInformationMarkerStart(composer3, 1493864211, "CC(remember):TextFieldImpl.kt#9igjgp");
                boolean zChanged4 = ((i6 & 7168) == 2048 ? true : z6) | composer3.changed(function0);
                Object objRememberedValue7 = composer3.rememberedValue();
                if (zChanged4 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TextFieldImplKt.CommonDecorationBox$lambda$17$0(textFieldLabelPosition, function0, mutableState, (Size) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Composer composer5 = composer3;
                OutlinedTextFieldKt.OutlinedTextFieldLayout(companion2, function2, composableLambdaRememberComposableLambda, composableLambda5, composableLambdaRememberComposableLambda2, composableLambda4, composableLambda6, composableLambda7, z, textFieldLabelPosition, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, (Function1) objRememberedValue7, composableLambdaRememberComposableLambda8, composableLambdaRememberComposableLambda3, paddingValues, composer5, ((i6 >> 3) & 112) | 6 | ((i7 << 21) & 234881024) | ((i6 << 18) & 1879048192), (3670016 & (i7 << 3)) | 24576);
                composer2 = composer5;
                composer2.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.CommonDecorationBox$lambda$18(textFieldType, charSequence, function2, textFieldLabelPosition, function3, function4, function5, function6, function7, function8, function9, z, z2, z3, interactionSource, paddingValues, textFieldColors, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$0$0(State state, TextFieldColors textFieldColors, boolean z, boolean z2, boolean z3, boolean z4, Transition transition, TextStyle textStyle, TextStyle textStyle2, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C138@5244L489:TextFieldImpl.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1632654811, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:138)");
            }
            DecoratedLabel(state, textFieldColors, z, z2, z3, z4, transition, textStyle, textStyle2, function3, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CommonDecorationBox$lambda$1$0(State state) {
        return (state != null ? ((Number) state.getValue()).floatValue() : 0.0f) > 0.0f;
    }

    static final Unit CommonDecorationBox$lambda$3(long j, TextStyle textStyle, Function2 function2, Modifier modifier, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(modifier)162@6331L238:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i |= composer.changed(modifier) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-720601610, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:162)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1119186161, "C163@6367L184:TextFieldImpl.kt#mqatfk");
            m5511Decoration3JVO9M(j, textStyle, function2, composer, 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CommonDecorationBox$lambda$4$0(State state) {
        return (state != null ? ((Number) state.getValue()).floatValue() : 0.0f) > 0.0f;
    }

    static final Unit CommonDecorationBox$lambda$6(long j, TextStyle textStyle, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C179@6937L79:TextFieldImpl.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1271185508, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:179)");
            }
            m5511Decoration3JVO9M(j, textStyle, function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit CommonDecorationBox$lambda$7(long j, TextStyle textStyle, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C187@7260L79:TextFieldImpl.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(123777469, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:187)");
            }
            m5511Decoration3JVO9M(j, textStyle, function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$8$0(long j, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C194@7562L57:TextFieldImpl.kt#mqatfk");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-906968406, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:194)");
            }
            m5512DecorationIv8Zu3U(j, function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$9$0(long j, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C200@7824L58:TextFieldImpl.kt#mqatfk");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1287792574, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:200)");
            }
            m5512DecorationIv8Zu3U(j, function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$10$0(long j, TextStyle textStyle, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C207@8111L83:TextFieldImpl.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1612592437, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:207)");
            }
            m5511Decoration3JVO9M(j, textStyle, function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CommonDecorationBox$lambda$11$0(State state) {
        if (state != null) {
            return ((Number) state.getValue()).floatValue();
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CommonDecorationBox$lambda$12$0(State state) {
        if (state != null) {
            return ((Number) state.getValue()).floatValue();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CommonDecorationBox$lambda$13$0(State state) {
        if (state != null) {
            return ((Number) state.getValue()).floatValue();
        }
        return 0.0f;
    }

    static final Unit CommonDecorationBox$lambda$14(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C217@8537L83:TextFieldImpl.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-358432442, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:217)");
            }
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, ContainerId);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierLayoutId);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1188034280, "C217@8607L11:TextFieldImpl.kt#mqatfk");
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

    static final Unit CommonDecorationBox$lambda$16(final MutableState mutableState, TextFieldLabelPosition textFieldLabelPosition, PaddingValues paddingValues, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C243@9649L437:TextFieldImpl.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-403938615, i, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:243)");
            }
            Modifier modifierOutlineCutout = OutlinedTextFieldKt.outlineCutout(LayoutIdKt.layoutId(Modifier.INSTANCE, ContainerId), new MutablePropertyReference0Impl(mutableState) { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$borderContainerWithId$1$1
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((MutableState) this.receiver).getValue();
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(Object obj) {
                    ((MutableState) this.receiver).setValue(obj);
                }
            }, getMinimizedAlignment(textFieldLabelPosition), paddingValues);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierOutlineCutout);
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
            ComposerKt.sourceInformationMarkerStart(composer, 843988021, "C252@10057L11:TextFieldImpl.kt#mqatfk");
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$17$0(TextFieldLabelPosition textFieldLabelPosition, Function0 function0, MutableState mutableState, Size size) {
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Above) {
            return Unit.INSTANCE;
        }
        float fFloatValue = ((Number) function0.invoke()).floatValue();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (size.m7147unboximpl() >> 32)) * fFloatValue;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size.m7147unboximpl() & 4294967295L)) * fFloatValue;
        if (Float.intBitsToFloat((int) (((Size) mutableState.getValue()).m7147unboximpl() >> 32)) != fIntBitsToFloat || Float.intBitsToFloat((int) (((Size) mutableState.getValue()).m7147unboximpl() & 4294967295L)) != fIntBitsToFloat2) {
            mutableState.setValue(Size.m7130boximpl(Size.m7133constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L))));
        }
        return Unit.INSTANCE;
    }

    private static final void DecoratedLabel(final State<Float> state, final TextFieldColors textFieldColors, final boolean z, final boolean z2, final boolean z3, final boolean z4, Transition<InputPhase> transition, final TextStyle textStyle, final TextStyle textStyle2, final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        State<Color> stateM5514labelTextStyleColor1wkBAMs;
        Transition<InputPhase> transition2 = transition;
        Composer composerStartRestartGroup = composer.startRestartGroup(376119213);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DecoratedLabel)N(labelProgress,colors,enabled,isError,isFocused,overrideLabelTextStyleColor,transition,bodySmall,bodyLarge,content)305@11965L171,328@12842L29,337@13221L24,337@13169L76:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textFieldColors) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(transition2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle2) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((805306368 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((306783379 & i2) != 306783378, i2 & 1)) {
            transition2 = transition2;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(376119213, i2, -1, "androidx.compose.material3.internal.DecoratedLabel (TextFieldImpl.kt:304)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 673322808, "CC(remember):TextFieldImpl.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new TextFieldLabelScope() { // from class: androidx.compose.material3.internal.TextFieldImplKt$DecoratedLabel$labelScope$1$1
                    @Override // androidx.compose.material3.TextFieldLabelScope
                    public float getLabelMinimizedProgress() {
                        State<Float> state2 = state;
                        if (state2 != null) {
                            return state2.getValue().floatValue();
                        }
                        return 1.0f;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final TextFieldImplKt$DecoratedLabel$labelScope$1$1 textFieldImplKt$DecoratedLabel$labelScope$1$1 = (TextFieldImplKt$DecoratedLabel$labelScope$1$1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long jM4888labelColorXeAY9LY = textFieldColors.m4888labelColorXeAY9LY(z, z2, z3);
            if (z4) {
                composerStartRestartGroup.startReplaceGroup(-601510006);
                ComposerKt.sourceInformation(composerStartRestartGroup, "315@12302L456");
                long jM9628getColor0d7_KjU = textStyle.m9628getColor0d7_KjU();
                if (z4 && jM9628getColor0d7_KjU == 16) {
                    jM9628getColor0d7_KjU = jM4888labelColorXeAY9LY;
                }
                long jM9628getColor0d7_KjU2 = textStyle2.m9628getColor0d7_KjU();
                if (z4 && jM9628getColor0d7_KjU2 == 16) {
                    jM9628getColor0d7_KjU2 = jM4888labelColorXeAY9LY;
                }
                stateM5514labelTextStyleColor1wkBAMs = m5514labelTextStyleColor1wkBAMs(transition2, jM9628getColor0d7_KjU, jM9628getColor0d7_KjU2, composerStartRestartGroup, (i2 >> 18) & 14);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-601031335);
                composerStartRestartGroup.endReplaceGroup();
                stateM5514labelTextStyleColor1wkBAMs = null;
            }
            State<Color> stateM5513labelContentColorRPmYEkk = m5513labelContentColorRPmYEkk(transition2, jM4888labelColorXeAY9LY, composerStartRestartGroup, (i2 >> 18) & 14);
            TextStyle textStyleLerp = TextStyleKt.lerp(textStyle2, textStyle, state != null ? state.getValue().floatValue() : 1.0f);
            if (z4) {
                Intrinsics.checkNotNull(stateM5514labelTextStyleColor1wkBAMs);
                textStyleLerp = TextStyle.m9611copyp1EtxEg$default(textStyleLerp, stateM5514labelTextStyleColor1wkBAMs.getValue().m7348unboximpl(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            }
            m5511Decoration3JVO9M(stateM5513labelContentColorRPmYEkk.getValue().m7348unboximpl(), textStyleLerp, ComposableLambdaKt.rememberComposableLambda(57043598, true, new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.DecoratedLabel$lambda$4(function3, textFieldImplKt$DecoratedLabel$labelScope$1$1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Transition<InputPhase> transition3 = transition2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.DecoratedLabel$lambda$5(state, textFieldColors, z, z2, z3, z4, transition3, textStyle, textStyle2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DecoratedLabel$lambda$4(Function3 function3, TextFieldImplKt$DecoratedLabel$labelScope$1$1 textFieldImplKt$DecoratedLabel$labelScope$1$1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C337@13234L9:TextFieldImpl.kt#mqatfk");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(57043598, i, -1, "androidx.compose.material3.internal.DecoratedLabel.<anonymous> (TextFieldImpl.kt:337)");
            }
            function3.invoke(textFieldImplKt$DecoratedLabel$labelScope$1$1, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final boolean getShowExpandedLabel(TextFieldLabelPosition textFieldLabelPosition) {
        return (textFieldLabelPosition instanceof TextFieldLabelPosition.Attached) && !((TextFieldLabelPosition.Attached) textFieldLabelPosition).getAlwaysMinimize();
    }

    public static final Alignment.Horizontal getMinimizedAlignment(TextFieldLabelPosition textFieldLabelPosition) {
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Above) {
            return ((TextFieldLabelPosition.Above) textFieldLabelPosition).getAlignment();
        }
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Attached) {
            return ((TextFieldLabelPosition.Attached) textFieldLabelPosition).getMinimizedAlignment();
        }
        throw new IllegalArgumentException("Unknown position: " + textFieldLabelPosition);
    }

    public static final Alignment.Horizontal getExpandedAlignment(TextFieldLabelPosition textFieldLabelPosition) {
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Above) {
            return ((TextFieldLabelPosition.Above) textFieldLabelPosition).getAlignment();
        }
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Attached) {
            return ((TextFieldLabelPosition.Attached) textFieldLabelPosition).getExpandedAlignment();
        }
        throw new IllegalArgumentException("Unknown position: " + textFieldLabelPosition);
    }

    /* JADX INFO: renamed from: Decoration-3J-VO9M, reason: not valid java name */
    private static final void m5511Decoration3JVO9M(long j, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function3;
        final TextStyle textStyle2;
        final long j2;
        Composer composerStartRestartGroup = composer.startRestartGroup(396611577);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(contentColor:c#ui.graphics.Color,textStyle,content)362@14214L62:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(396611577, i2, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:362)");
            }
            ProvideContentColorTextStyleKt.m5412ProvideContentColorTextStyle3JVO9M(j, textStyle, function2, composerStartRestartGroup, i2 & 1022);
            j2 = j;
            textStyle2 = textStyle;
            function3 = function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function3 = function2;
            textStyle2 = textStyle;
            j2 = j;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.Decoration_3J_VO9M$lambda$0(j2, textStyle2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: Decoration-Iv8Zu3U, reason: not valid java name */
    private static final void m5512DecorationIv8Zu3U(final long j, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(590397809);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(contentColor:c#ui.graphics.Color,content)367@14421L84:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(590397809, i2, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:367)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m7328boximpl(j)), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.Decoration_Iv8Zu3U$lambda$0(j, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z, final String str) {
        return z ? SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.defaultErrorSemantics$lambda$0(str, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null) : modifier;
    }

    static final Unit defaultErrorSemantics$lambda$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.error(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    public static final Modifier textFieldBackground(Modifier modifier, final ColorProducer colorProducer, final Shape shape) {
        return DrawModifierKt.drawWithCache(modifier, new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.textFieldBackground$lambda$0(shape, colorProducer, (CacheDrawScope) obj);
            }
        });
    }

    static final DrawResult textFieldBackground$lambda$0(Shape shape, final ColorProducer colorProducer, CacheDrawScope cacheDrawScope) {
        final Outline outlineMo1614createOutlinePq9zytI = shape.mo1614createOutlinePq9zytI(cacheDrawScope.m6853getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
        return cacheDrawScope.onDrawBehind(new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.textFieldBackground$lambda$0$0(outlineMo1614createOutlinePq9zytI, colorProducer, (DrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit textFieldBackground$lambda$0$0(Outline outline, ColorProducer colorProducer, DrawScope drawScope) {
        OutlineKt.m7611drawOutlinewDX37Ww$default(drawScope, outline, colorProducer.mo3885invoke0d7_KjU(), 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    public static final Modifier textFieldLabelMinHeight(Modifier modifier, final Function0<Dp> function0) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldImplKt.textFieldLabelMinHeight$lambda$0(function0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    static final MeasureResult textFieldLabelMinHeight$lambda$0(Function0 function0, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        float fM10182unboximpl = ((Dp) function0.invoke()).m10182unboximpl();
        final Placeable placeableMo8808measureBRTryo0 = measurable.mo8808measureBRTryo0(Constraints.m10111copyZbe2FdA$default(constraints.getValue(), 0, 0, ConstraintsKt.m10137constrainHeightK40F9xA(constraints.getValue(), !Dp.m10173equalsimpl0(fM10182unboximpl, Dp.INSTANCE.m10188getUnspecifiedD9Ej5fM()) ? measureScope.mo1728roundToPx0680j_4(fM10182unboximpl) : 0), 0, 11, null));
        return MeasureScope.layout$default(measureScope, placeableMo8808measureBRTryo0.getWidth(), placeableMo8808measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.textFieldLabelMinHeight$lambda$0$0(placeableMo8808measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit textFieldLabelMinHeight$lambda$0$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final State<Float> labelProgress(final Transition<InputPhase> transition, boolean z, Composer composer, int i) {
        Object currentState;
        float f;
        ComposerKt.sourceInformationMarkerStart(composer, 927190202, "C(labelProgress)N(showExpandedLabel)403@16059L14,404@16085L276:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(927190202, i, -1, "androidx.compose.material3.internal.labelProgress (TextFieldImpl.kt:402)");
        }
        final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer, 6);
        Function3 function3 = new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldImplKt.labelProgress$lambda$0(finiteAnimationSpecValue, (Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        };
        ComposerKt.sourceInformationMarkerStart(composer, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1971@84243L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int i2 = (((i & 14) | 384) & 14) | 3072;
        ComposerKt.sourceInformationMarkerStart(composer, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1868@79284L32,1875@79757L49,1875@79738L75,1876@79853L45,1876@79838L67,1878@79918L89:Transition.kt#pdpnli");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(1666827533);
            composer.endReplaceGroup();
            currentState = transition.getCurrentState();
        } else {
            composer.startReplaceGroup(1666573488);
            ComposerKt.sourceInformation(composer, "1864@79141L67");
            ComposerKt.sourceInformationMarkerStart(composer, -1054612652, "CC(remember):Transition.kt#9igjgp");
            boolean z2 = (((i2 & 14) ^ 6) > 4 && composer.changed(transition)) || (i2 & 6) == 4;
            currentState = composer.rememberedValue();
            if (z2 || currentState == Composer.INSTANCE.getEmpty()) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    InputPhase currentState2 = transition.getCurrentState();
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composer.updateRememberedValue(currentState2);
                    currentState = currentState2;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        InputPhase inputPhase = (InputPhase) currentState;
        composer.startReplaceGroup(1071902915);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1071902915, 0, -1, "androidx.compose.material3.internal.labelProgress.<anonymous> (TextFieldImpl.kt:405)");
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[inputPhase.ordinal()];
        float f2 = 1.0f;
        if (i3 == 1) {
            f = 1.0f;
        } else {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z) {
                f = 0.0f;
            }
            f = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(f);
        ComposerKt.sourceInformationMarkerStart(composer, -1054592958, "CC(remember):Transition.kt#9igjgp");
        int i4 = i2 & 14;
        int i5 = i4 ^ 6;
        boolean z3 = (i5 > 4 && composer.changed(transition)) || (i2 & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<InputPhase>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$labelProgress$$inlined$animateFloat$1
                /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.material3.internal.InputPhase, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final InputPhase invoke() {
                    return transition.getTargetState();
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        InputPhase inputPhase2 = (InputPhase) ((State) objRememberedValue).getValue();
        composer.startReplaceGroup(1071902915);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1071902915, 0, -1, "androidx.compose.material3.internal.labelProgress.<anonymous> (TextFieldImpl.kt:405)");
        }
        int i6 = WhenMappings.$EnumSwitchMapping$1[inputPhase2.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z) {
                f2 = 0.0f;
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf2 = Float.valueOf(f2);
        ComposerKt.sourceInformationMarkerStart(composer, -1054589890, "CC(remember):Transition.kt#9igjgp");
        boolean z4 = (i5 > 4 && composer.changed(transition)) || (i2 & 6) == 4;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<InputPhase>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$labelProgress$$inlined$animateFloat$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Transition.Segment<InputPhase> invoke() {
                    return transition.getSegment();
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<Float> stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, fValueOf, fValueOf2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue2).getValue(), composer, 0), vectorConverter, "LabelProgress", composer, i4 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCreateTransitionAnimation;
    }

    static final FiniteAnimationSpec labelProgress$lambda$0(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(1806589607);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1806589607, i, -1, "androidx.compose.material3.internal.labelProgress.<anonymous> (TextFieldImpl.kt:404)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:74:0x0172  */
    private static final State<Float> placeholderOpacity(final Transition<InputPhase> transition, boolean z, Composer composer, int i) {
        Object currentState;
        float f;
        ComposerKt.sourceInformationMarkerStart(composer, -1386921849, "C(placeholderOpacity)N(showExpandedLabel)415@16545L14,416@16630L14,417@16656L750:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1386921849, i, -1, "androidx.compose.material3.internal.placeholderOpacity (TextFieldImpl.kt:414)");
        }
        final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
        final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, composer, 6);
        Function3 function3 = new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldImplKt.placeholderOpacity$lambda$0(finiteAnimationSpecValue, finiteAnimationSpecValue2, (Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        };
        ComposerKt.sourceInformationMarkerStart(composer, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1971@84243L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int i2 = (((i & 14) | 384) & 14) | 3072;
        ComposerKt.sourceInformationMarkerStart(composer, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1868@79284L32,1875@79757L49,1875@79738L75,1876@79853L45,1876@79838L67,1878@79918L89:Transition.kt#pdpnli");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(1666827533);
            composer.endReplaceGroup();
            currentState = transition.getCurrentState();
        } else {
            composer.startReplaceGroup(1666573488);
            ComposerKt.sourceInformation(composer, "1864@79141L67");
            ComposerKt.sourceInformationMarkerStart(composer, -1054612652, "CC(remember):Transition.kt#9igjgp");
            boolean z2 = (((i2 & 14) ^ 6) > 4 && composer.changed(transition)) || (i2 & 6) == 4;
            currentState = composer.rememberedValue();
            if (z2 || currentState == Composer.INSTANCE.getEmpty()) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    InputPhase currentState2 = transition.getCurrentState();
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composer.updateRememberedValue(currentState2);
                    currentState = currentState2;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        InputPhase inputPhase = (InputPhase) currentState;
        composer.startReplaceGroup(-2037958114);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2037958114, 0, -1, "androidx.compose.material3.internal.placeholderOpacity.<anonymous> (TextFieldImpl.kt:432)");
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[inputPhase.ordinal()];
        float f2 = 0.0f;
        if (i3 == 1) {
            f = 1.0f;
        } else {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (!z) {
                f = 1.0f;
            }
            f = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(f);
        ComposerKt.sourceInformationMarkerStart(composer, -1054592958, "CC(remember):Transition.kt#9igjgp");
        int i4 = i2 & 14;
        int i5 = i4 ^ 6;
        boolean z3 = (i5 > 4 && composer.changed(transition)) || (i2 & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<InputPhase>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$placeholderOpacity$$inlined$animateFloat$1
                /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.material3.internal.InputPhase, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final InputPhase invoke() {
                    return transition.getTargetState();
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        InputPhase inputPhase2 = (InputPhase) ((State) objRememberedValue).getValue();
        composer.startReplaceGroup(-2037958114);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2037958114, 0, -1, "androidx.compose.material3.internal.placeholderOpacity.<anonymous> (TextFieldImpl.kt:432)");
        }
        int i6 = WhenMappings.$EnumSwitchMapping$1[inputPhase2.ordinal()];
        if (i6 == 1) {
            f2 = 1.0f;
        } else if (i6 != 2) {
            if (i6 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!z) {
            f2 = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf2 = Float.valueOf(f2);
        ComposerKt.sourceInformationMarkerStart(composer, -1054589890, "CC(remember):Transition.kt#9igjgp");
        boolean z4 = (i5 > 4 && composer.changed(transition)) || (i2 & 6) == 4;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<InputPhase>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$placeholderOpacity$$inlined$animateFloat$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Transition.Segment<InputPhase> invoke() {
                    return transition.getSegment();
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<Float> stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, fValueOf, fValueOf2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue2).getValue(), composer, 0), vectorConverter, "PlaceholderOpacity", composer, i4 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCreateTransitionAnimation;
    }

    static final FiniteAnimationSpec placeholderOpacity$lambda$0(FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(-1370891590);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1370891590, i, -1, "androidx.compose.material3.internal.placeholderOpacity.<anonymous> (TextFieldImpl.kt:420)");
        }
        if (!segment.isTransitioningTo(InputPhase.Focused, InputPhase.UnfocusedEmpty) && (segment.isTransitioningTo(InputPhase.UnfocusedEmpty, InputPhase.Focused) || segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, InputPhase.UnfocusedEmpty))) {
            finiteAnimationSpec = finiteAnimationSpec2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    private static final State<Float> affixOpacity(final Transition<InputPhase> transition, boolean z, Composer composer, int i) {
        Object currentState;
        float f;
        ComposerKt.sourceInformationMarkerStart(composer, -1040715446, "C(affixOpacity)N(showExpandedLabel)442@17584L14,443@17610L311:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1040715446, i, -1, "androidx.compose.material3.internal.affixOpacity (TextFieldImpl.kt:441)");
        }
        final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
        Function3 function3 = new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldImplKt.affixOpacity$lambda$0(finiteAnimationSpecValue, (Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        };
        ComposerKt.sourceInformationMarkerStart(composer, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1971@84243L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int i2 = (((i & 14) | 384) & 14) | 3072;
        ComposerKt.sourceInformationMarkerStart(composer, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1868@79284L32,1875@79757L49,1875@79738L75,1876@79853L45,1876@79838L67,1878@79918L89:Transition.kt#pdpnli");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(1666827533);
            composer.endReplaceGroup();
            currentState = transition.getCurrentState();
        } else {
            composer.startReplaceGroup(1666573488);
            ComposerKt.sourceInformation(composer, "1864@79141L67");
            ComposerKt.sourceInformationMarkerStart(composer, -1054612652, "CC(remember):Transition.kt#9igjgp");
            boolean z2 = (((i2 & 14) ^ 6) > 4 && composer.changed(transition)) || (i2 & 6) == 4;
            currentState = composer.rememberedValue();
            if (z2 || currentState == Composer.INSTANCE.getEmpty()) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    InputPhase currentState2 = transition.getCurrentState();
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composer.updateRememberedValue(currentState2);
                    currentState = currentState2;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        InputPhase inputPhase = (InputPhase) currentState;
        composer.startReplaceGroup(-2144425951);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2144425951, 0, -1, "androidx.compose.material3.internal.affixOpacity.<anonymous> (TextFieldImpl.kt:447)");
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[inputPhase.ordinal()];
        float f2 = 1.0f;
        if (i3 == 1) {
            f = 1.0f;
        } else {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z) {
                f = 0.0f;
            }
            f = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(f);
        ComposerKt.sourceInformationMarkerStart(composer, -1054592958, "CC(remember):Transition.kt#9igjgp");
        int i4 = i2 & 14;
        int i5 = i4 ^ 6;
        boolean z3 = (i5 > 4 && composer.changed(transition)) || (i2 & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<InputPhase>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$affixOpacity$$inlined$animateFloat$1
                /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.material3.internal.InputPhase, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final InputPhase invoke() {
                    return transition.getTargetState();
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        InputPhase inputPhase2 = (InputPhase) ((State) objRememberedValue).getValue();
        composer.startReplaceGroup(-2144425951);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2144425951, 0, -1, "androidx.compose.material3.internal.affixOpacity.<anonymous> (TextFieldImpl.kt:447)");
        }
        int i6 = WhenMappings.$EnumSwitchMapping$1[inputPhase2.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z) {
                f2 = 0.0f;
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf2 = Float.valueOf(f2);
        ComposerKt.sourceInformationMarkerStart(composer, -1054589890, "CC(remember):Transition.kt#9igjgp");
        boolean z4 = (i5 > 4 && composer.changed(transition)) || (i2 & 6) == 4;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<InputPhase>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$affixOpacity$$inlined$animateFloat$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Transition.Segment<InputPhase> invoke() {
                    return transition.getSegment();
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<Float> stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, fValueOf, fValueOf2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue2).getValue(), composer, 0), vectorConverter, "PrefixSuffixOpacity", composer, i4 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCreateTransitionAnimation;
    }

    static final FiniteAnimationSpec affixOpacity$lambda$0(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(-735253059);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-735253059, i, -1, "androidx.compose.material3.internal.affixOpacity.<anonymous> (TextFieldImpl.kt:445)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    /* JADX INFO: renamed from: labelTextStyleColor-1wkBAMs, reason: not valid java name */
    private static final State<Color> m5514labelTextStyleColor1wkBAMs(final Transition<InputPhase> transition, long j, long j2, Composer composer, int i) {
        Object currentState;
        ComposerKt.sourceInformationMarkerStart(composer, -182681442, "C(labelTextStyleColor)N(focusedLabelTextStyleColor:c#ui.graphics.Color,unfocusedLabelTextStyleColor:c#ui.graphics.Color)460@18155L14,461@18181L233:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-182681442, i, -1, "androidx.compose.material3.internal.labelTextStyleColor (TextFieldImpl.kt:459)");
        }
        final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
        Function3 function3 = new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldImplKt.labelTextStyleColor_1wkBAMs$lambda$0(finiteAnimationSpecValue, (Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        };
        int i2 = (i & 14) | 384;
        ComposerKt.sourceInformationMarkerStart(composer, -64433887, "CC(animateColor)N(transitionSpec,label,targetValueByState)67@3230L31,68@3297L58,70@3368L70:Transition.kt#xbi5r1");
        InputPhase targetState = transition.getTargetState();
        composer.startReplaceGroup(-759924327);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-759924327, 0, -1, "androidx.compose.material3.internal.labelTextStyleColor.<anonymous> (TextFieldImpl.kt:462)");
        }
        long j3 = WhenMappings.$EnumSwitchMapping$1[targetState.ordinal()] == 1 ? j : j2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        ColorSpace colorSpaceM7342getColorSpaceimpl = Color.m7342getColorSpaceimpl(j3);
        ComposerKt.sourceInformationMarkerStart(composer, -1791411589, "CC(remember):Transition.kt#9igjgp");
        boolean zChanged = composer.changed(colorSpaceM7342getColorSpaceimpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM7342getColorSpaceimpl);
            composer.updateRememberedValue(objRememberedValue);
        }
        TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i3 = (i2 & 14) | 3072;
        ComposerKt.sourceInformationMarkerStart(composer, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1868@79284L32,1875@79757L49,1875@79738L75,1876@79853L45,1876@79838L67,1878@79918L89:Transition.kt#pdpnli");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(1666827533);
            composer.endReplaceGroup();
            currentState = transition.getCurrentState();
        } else {
            composer.startReplaceGroup(1666573488);
            ComposerKt.sourceInformation(composer, "1864@79141L67");
            ComposerKt.sourceInformationMarkerStart(composer, -1054612652, "CC(remember):Transition.kt#9igjgp");
            boolean z = (((i3 & 14) ^ 6) > 4 && composer.changed(transition)) || (i3 & 6) == 4;
            currentState = composer.rememberedValue();
            if (z || currentState == Composer.INSTANCE.getEmpty()) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    InputPhase currentState2 = transition.getCurrentState();
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composer.updateRememberedValue(currentState2);
                    currentState = currentState2;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        InputPhase inputPhase = (InputPhase) currentState;
        composer.startReplaceGroup(-759924327);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-759924327, 0, -1, "androidx.compose.material3.internal.labelTextStyleColor.<anonymous> (TextFieldImpl.kt:462)");
        }
        long j4 = WhenMappings.$EnumSwitchMapping$1[inputPhase.ordinal()] == 1 ? j : j2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Color colorM7328boximpl = Color.m7328boximpl(j4);
        ComposerKt.sourceInformationMarkerStart(composer, -1054592958, "CC(remember):Transition.kt#9igjgp");
        int i4 = i3 & 14;
        int i5 = i4 ^ 6;
        boolean z2 = (i5 > 4 && composer.changed(transition)) || (i3 & 6) == 4;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<InputPhase>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$labelTextStyleColor-1wkBAMs$$inlined$animateColor$1
                /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.material3.internal.InputPhase, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final InputPhase invoke() {
                    return transition.getTargetState();
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        InputPhase inputPhase2 = (InputPhase) ((State) objRememberedValue2).getValue();
        composer.startReplaceGroup(-759924327);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-759924327, 0, -1, "androidx.compose.material3.internal.labelTextStyleColor.<anonymous> (TextFieldImpl.kt:462)");
        }
        long j5 = WhenMappings.$EnumSwitchMapping$1[inputPhase2.ordinal()] == 1 ? j : j2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Color colorM7328boximpl2 = Color.m7328boximpl(j5);
        ComposerKt.sourceInformationMarkerStart(composer, -1054589890, "CC(remember):Transition.kt#9igjgp");
        boolean z3 = (i5 > 4 && composer.changed(transition)) || (i3 & 6) == 4;
        Object objRememberedValue3 = composer.rememberedValue();
        if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<InputPhase>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$labelTextStyleColor-1wkBAMs$$inlined$animateColor$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Transition.Segment<InputPhase> invoke() {
                    return transition.getSegment();
                }
            });
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<Color> stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, colorM7328boximpl, colorM7328boximpl2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue3).getValue(), composer, 0), twoWayConverter, "LabelTextStyleColor", composer, i4 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCreateTransitionAnimation;
    }

    static final FiniteAnimationSpec labelTextStyleColor_1wkBAMs$lambda$0(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(1730286052);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1730286052, i, -1, "androidx.compose.material3.internal.labelTextStyleColor.<anonymous> (TextFieldImpl.kt:461)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    /* JADX INFO: renamed from: labelContentColor-RPmYEkk, reason: not valid java name */
    private static final State<Color> m5513labelContentColorRPmYEkk(final Transition<InputPhase> transition, long j, Composer composer, int i) {
        Object currentState;
        ComposerKt.sourceInformationMarkerStart(composer, -1365844622, "C(labelContentColor)N(labelColor:c#ui.graphics.Color)471@18582L14,473@18662L151:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1365844622, i, -1, "androidx.compose.material3.internal.labelContentColor (TextFieldImpl.kt:470)");
        }
        final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
        Function3 function3 = new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldImplKt.labelContentColor_RPmYEkk$lambda$0(finiteAnimationSpecValue, (Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        };
        int i2 = (i & 14) | 384;
        ComposerKt.sourceInformationMarkerStart(composer, -64433887, "CC(animateColor)N(transitionSpec,label,targetValueByState)67@3230L31,68@3297L58,70@3368L70:Transition.kt#xbi5r1");
        transition.getTargetState();
        composer.startReplaceGroup(1139343725);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1139343725, 0, -1, "androidx.compose.material3.internal.labelContentColor.<anonymous> (TextFieldImpl.kt:476)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        ColorSpace colorSpaceM7342getColorSpaceimpl = Color.m7342getColorSpaceimpl(j);
        ComposerKt.sourceInformationMarkerStart(composer, -1791411589, "CC(remember):Transition.kt#9igjgp");
        boolean zChanged = composer.changed(colorSpaceM7342getColorSpaceimpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM7342getColorSpaceimpl);
            composer.updateRememberedValue(objRememberedValue);
        }
        TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i3 = (i2 & 14) | 3072;
        ComposerKt.sourceInformationMarkerStart(composer, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1868@79284L32,1875@79757L49,1875@79738L75,1876@79853L45,1876@79838L67,1878@79918L89:Transition.kt#pdpnli");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(1666827533);
            composer.endReplaceGroup();
            currentState = transition.getCurrentState();
        } else {
            composer.startReplaceGroup(1666573488);
            ComposerKt.sourceInformation(composer, "1864@79141L67");
            ComposerKt.sourceInformationMarkerStart(composer, -1054612652, "CC(remember):Transition.kt#9igjgp");
            boolean z = (((i3 & 14) ^ 6) > 4 && composer.changed(transition)) || (i3 & 6) == 4;
            currentState = composer.rememberedValue();
            if (z || currentState == Composer.INSTANCE.getEmpty()) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    InputPhase currentState2 = transition.getCurrentState();
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composer.updateRememberedValue(currentState2);
                    currentState = currentState2;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        composer.startReplaceGroup(1139343725);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1139343725, 0, -1, "androidx.compose.material3.internal.labelContentColor.<anonymous> (TextFieldImpl.kt:476)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Color colorM7328boximpl = Color.m7328boximpl(j);
        ComposerKt.sourceInformationMarkerStart(composer, -1054592958, "CC(remember):Transition.kt#9igjgp");
        int i4 = i3 & 14;
        int i5 = i4 ^ 6;
        boolean z2 = (i5 > 4 && composer.changed(transition)) || (i3 & 6) == 4;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<InputPhase>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$labelContentColor-RPmYEkk$$inlined$animateColor$1
                /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.material3.internal.InputPhase, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final InputPhase invoke() {
                    return transition.getTargetState();
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.startReplaceGroup(1139343725);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1139343725, 0, -1, "androidx.compose.material3.internal.labelContentColor.<anonymous> (TextFieldImpl.kt:476)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Color colorM7328boximpl2 = Color.m7328boximpl(j);
        ComposerKt.sourceInformationMarkerStart(composer, -1054589890, "CC(remember):Transition.kt#9igjgp");
        boolean z3 = (i5 > 4 && composer.changed(transition)) || (i3 & 6) == 4;
        Object objRememberedValue3 = composer.rememberedValue();
        if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<InputPhase>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$labelContentColor-RPmYEkk$$inlined$animateColor$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Transition.Segment<InputPhase> invoke() {
                    return transition.getSegment();
                }
            });
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<Color> stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, colorM7328boximpl, colorM7328boximpl2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue3).getValue(), composer, 0), twoWayConverter, "LabelContentColor", composer, i4 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCreateTransitionAnimation;
    }

    static final FiniteAnimationSpec labelContentColor_RPmYEkk$lambda$0(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(-1207102280);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1207102280, i, -1, "androidx.compose.material3.internal.labelContentColor.<anonymous> (TextFieldImpl.kt:474)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    public static final float textFieldHorizontalIconPadding(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1986450462, "C(textFieldHorizontalIconPadding)506@19804L7:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1986450462, i, -1, "androidx.compose.material3.internal.textFieldHorizontalIconPadding (TextFieldImpl.kt:505)");
        }
        ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localMinimumInteractiveComponentSize);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fM10182unboximpl = ((Dp) objConsume).m10182unboximpl();
        if (Float.isNaN(fM10182unboximpl)) {
            fM10182unboximpl = Dp.m10168constructorimpl(0.0f);
        }
        float fM10168constructorimpl = Dp.m10168constructorimpl(RangesKt.coerceAtLeast(Dp.m10168constructorimpl(Dp.m10168constructorimpl(fM10182unboximpl - SmallIconButtonTokens.INSTANCE.m6186getIconSizeD9Ej5fM()) / 2.0f), Dp.m10168constructorimpl(0.0f)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fM10168constructorimpl;
    }

    public static final float minimizedLabelHalfHeight(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1251545215, "C(minimizedLabelHalfHeight)513@20104L10,516@20314L7:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1251545215, i, -1, "androidx.compose.material3.internal.minimizedLabelHalfHeight (TextFieldImpl.kt:512)");
        }
        long jM9637getLineHeightXSAIIZE = MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall().m9637getLineHeightXSAIIZE();
        long jM6295getBodySmallLineHeightXSAIIZE = TypeScaleTokens.INSTANCE.m6295getBodySmallLineHeightXSAIIZE();
        if (!TextUnit.m10365isSpimpl(jM9637getLineHeightXSAIIZE)) {
            jM9637getLineHeightXSAIIZE = jM6295getBodySmallLineHeightXSAIIZE;
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fM10168constructorimpl = Dp.m10168constructorimpl(((Density) objConsume).mo1729toDpGaN1DYA(jM9637getLineHeightXSAIIZE) / 2.0f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fM10168constructorimpl;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getAboveLabelHorizontalPadding() {
        return AboveLabelHorizontalPadding;
    }

    public static final float getAboveLabelBottomPadding() {
        return AboveLabelBottomPadding;
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    private static final boolean CommonDecorationBox$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean CommonDecorationBox$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
