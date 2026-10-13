package expo.modules.ui.textfield;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MotionScheme;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.AsyncFunctionHandle;
import expo.modules.kotlin.views.AsyncFunctionHandle2;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.GenericEventPayload1;
import expo.modules.ui.ShapeViewKt;
import expo.modules.ui.SlotView;
import expo.modules.ui.SlotViewKt;
import expo.modules.ui.UtilsKt;
import expo.modules.ui.state.ObservableState;
import expo.modules.ui.state.WorkletCallback;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a»\u0001\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u00152\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0018\u0012\u0004\u0012\u00020\u00070\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00070\u00152\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00070\u0015H\u0007¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"toColors", "Landroidx/compose/material3/TextFieldColors;", "Lexpo/modules/ui/textfield/TextFieldColorsRecord;", "isOutlined", "", "(Lexpo/modules/ui/textfield/TextFieldColorsRecord;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "TextFieldContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/textfield/TextFieldProps;", "setText", "Lexpo/modules/kotlin/views/AsyncFunctionHandle;", "", "setSelection", "Lexpo/modules/kotlin/views/AsyncFunctionHandle2;", "", "clear", "focus", "blur", "onValueChanged", "Lkotlin/Function1;", "Lexpo/modules/ui/textfield/TextFieldValuePayload;", "onFocusChange", "Lexpo/modules/ui/GenericEventPayload1;", "onKeyboardActionTriggered", "Lexpo/modules/ui/textfield/KeyboardActionEvent;", "onSelectionChanged", "Lexpo/modules/ui/textfield/TextFieldSelectionPayload;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/textfield/TextFieldProps;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle2;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TextFieldKt {
    static final Unit TextFieldContent$lambda$16(FunctionalComposableScope functionalComposableScope, TextFieldProps textFieldProps, AsyncFunctionHandle asyncFunctionHandle, AsyncFunctionHandle2 asyncFunctionHandle2, AsyncFunctionHandle asyncFunctionHandle3, AsyncFunctionHandle asyncFunctionHandle4, AsyncFunctionHandle asyncFunctionHandle5, Function1 function1, Function1 function2, Function1 function3, Function1 function4, int i, int i2, Composer composer, int i3) {
        TextFieldContent(functionalComposableScope, textFieldProps, asyncFunctionHandle, asyncFunctionHandle2, asyncFunctionHandle3, asyncFunctionHandle4, asyncFunctionHandle5, function1, function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    public static final TextFieldColors toColors(TextFieldColorsRecord textFieldColorsRecord, boolean z, Composer composer, int i) {
        TextFieldColors textFieldColorsColors;
        Intrinsics.checkNotNullParameter(textFieldColorsRecord, "<this>");
        ComposerKt.sourceInformationMarkerStart(composer, -631920161, "C(toColors)N(isOutlined)114@4397L4117:TextField.kt#2yem3u");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-631920161, i, -1, "expo.modules.ui.textfield.toColors (TextField.kt:107)");
        }
        if (z) {
            composer.startReplaceGroup(-691737577);
            ComposerKt.sourceInformation(composer, "109@4247L8");
            textFieldColorsColors = OutlinedTextFieldDefaults.INSTANCE.colors(composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-691688225);
            ComposerKt.sourceInformation(composer, "111@4289L8");
            textFieldColorsColors = TextFieldDefaults.INSTANCE.colors(composer, 6);
            composer.endReplaceGroup();
        }
        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
        Color composeOrNull = UtilsKt.getComposeOrNull(textFieldColorsRecord.getFocusedTextColor());
        long jM7348unboximpl = composeOrNull != null ? composeOrNull.m7348unboximpl() : textFieldColorsColors.getFocusedTextColor();
        Color composeOrNull2 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getUnfocusedTextColor());
        long jM7348unboximpl2 = composeOrNull2 != null ? composeOrNull2.m7348unboximpl() : textFieldColorsColors.getUnfocusedTextColor();
        Color composeOrNull3 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getDisabledTextColor());
        long jM7348unboximpl3 = composeOrNull3 != null ? composeOrNull3.m7348unboximpl() : textFieldColorsColors.getDisabledTextColor();
        Color composeOrNull4 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getErrorTextColor());
        long jM7348unboximpl4 = composeOrNull4 != null ? composeOrNull4.m7348unboximpl() : textFieldColorsColors.getErrorTextColor();
        Color composeOrNull5 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getFocusedContainerColor());
        long jM7348unboximpl5 = composeOrNull5 != null ? composeOrNull5.m7348unboximpl() : textFieldColorsColors.getFocusedContainerColor();
        Color composeOrNull6 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getUnfocusedContainerColor());
        long jM7348unboximpl6 = composeOrNull6 != null ? composeOrNull6.m7348unboximpl() : textFieldColorsColors.getUnfocusedContainerColor();
        Color composeOrNull7 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getDisabledContainerColor());
        long jM7348unboximpl7 = composeOrNull7 != null ? composeOrNull7.m7348unboximpl() : textFieldColorsColors.getDisabledContainerColor();
        Color composeOrNull8 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getErrorContainerColor());
        long jM7348unboximpl8 = composeOrNull8 != null ? composeOrNull8.m7348unboximpl() : textFieldColorsColors.getErrorContainerColor();
        Color composeOrNull9 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getCursorColor());
        long jM7348unboximpl9 = composeOrNull9 != null ? composeOrNull9.m7348unboximpl() : textFieldColorsColors.getCursorColor();
        Color composeOrNull10 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getErrorCursorColor());
        long jM7348unboximpl10 = composeOrNull10 != null ? composeOrNull10.m7348unboximpl() : textFieldColorsColors.getErrorCursorColor();
        Color composeOrNull11 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getFocusedIndicatorColor());
        long jM7348unboximpl11 = composeOrNull11 != null ? composeOrNull11.m7348unboximpl() : textFieldColorsColors.getFocusedIndicatorColor();
        Color composeOrNull12 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getUnfocusedIndicatorColor());
        long jM7348unboximpl12 = composeOrNull12 != null ? composeOrNull12.m7348unboximpl() : textFieldColorsColors.getUnfocusedIndicatorColor();
        Color composeOrNull13 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getDisabledIndicatorColor());
        long jM7348unboximpl13 = composeOrNull13 != null ? composeOrNull13.m7348unboximpl() : textFieldColorsColors.getDisabledIndicatorColor();
        Color composeOrNull14 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getErrorIndicatorColor());
        long jM7348unboximpl14 = composeOrNull14 != null ? composeOrNull14.m7348unboximpl() : textFieldColorsColors.getErrorIndicatorColor();
        Color composeOrNull15 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getFocusedLeadingIconColor());
        long jM7348unboximpl15 = composeOrNull15 != null ? composeOrNull15.m7348unboximpl() : textFieldColorsColors.getFocusedLeadingIconColor();
        Color composeOrNull16 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getUnfocusedLeadingIconColor());
        long jM7348unboximpl16 = composeOrNull16 != null ? composeOrNull16.m7348unboximpl() : textFieldColorsColors.getUnfocusedLeadingIconColor();
        Color composeOrNull17 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getDisabledLeadingIconColor());
        long jM7348unboximpl17 = composeOrNull17 != null ? composeOrNull17.m7348unboximpl() : textFieldColorsColors.getDisabledLeadingIconColor();
        Color composeOrNull18 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getErrorLeadingIconColor());
        long jM7348unboximpl18 = composeOrNull18 != null ? composeOrNull18.m7348unboximpl() : textFieldColorsColors.getErrorLeadingIconColor();
        Color composeOrNull19 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getFocusedTrailingIconColor());
        long jM7348unboximpl19 = composeOrNull19 != null ? composeOrNull19.m7348unboximpl() : textFieldColorsColors.getFocusedTrailingIconColor();
        Color composeOrNull20 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getUnfocusedTrailingIconColor());
        long jM7348unboximpl20 = composeOrNull20 != null ? composeOrNull20.m7348unboximpl() : textFieldColorsColors.getUnfocusedTrailingIconColor();
        Color composeOrNull21 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getDisabledTrailingIconColor());
        long jM7348unboximpl21 = composeOrNull21 != null ? composeOrNull21.m7348unboximpl() : textFieldColorsColors.getDisabledTrailingIconColor();
        Color composeOrNull22 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getErrorTrailingIconColor());
        long jM7348unboximpl22 = composeOrNull22 != null ? composeOrNull22.m7348unboximpl() : textFieldColorsColors.getErrorTrailingIconColor();
        Color composeOrNull23 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getFocusedLabelColor());
        long jM7348unboximpl23 = composeOrNull23 != null ? composeOrNull23.m7348unboximpl() : textFieldColorsColors.getFocusedLabelColor();
        Color composeOrNull24 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getUnfocusedLabelColor());
        long jM7348unboximpl24 = composeOrNull24 != null ? composeOrNull24.m7348unboximpl() : textFieldColorsColors.getUnfocusedLabelColor();
        Color composeOrNull25 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getDisabledLabelColor());
        long jM7348unboximpl25 = composeOrNull25 != null ? composeOrNull25.m7348unboximpl() : textFieldColorsColors.getDisabledLabelColor();
        Color composeOrNull26 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getErrorLabelColor());
        long jM7348unboximpl26 = composeOrNull26 != null ? composeOrNull26.m7348unboximpl() : textFieldColorsColors.getErrorLabelColor();
        Color composeOrNull27 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getFocusedPlaceholderColor());
        long jM7348unboximpl27 = composeOrNull27 != null ? composeOrNull27.m7348unboximpl() : textFieldColorsColors.getFocusedPlaceholderColor();
        Color composeOrNull28 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getUnfocusedPlaceholderColor());
        long jM7348unboximpl28 = composeOrNull28 != null ? composeOrNull28.m7348unboximpl() : textFieldColorsColors.getUnfocusedPlaceholderColor();
        Color composeOrNull29 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getDisabledPlaceholderColor());
        long jM7348unboximpl29 = composeOrNull29 != null ? composeOrNull29.m7348unboximpl() : textFieldColorsColors.getDisabledPlaceholderColor();
        Color composeOrNull30 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getErrorPlaceholderColor());
        long jM7348unboximpl30 = composeOrNull30 != null ? composeOrNull30.m7348unboximpl() : textFieldColorsColors.getErrorPlaceholderColor();
        Color composeOrNull31 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getFocusedSupportingTextColor());
        long jM7348unboximpl31 = composeOrNull31 != null ? composeOrNull31.m7348unboximpl() : textFieldColorsColors.getFocusedSupportingTextColor();
        Color composeOrNull32 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getUnfocusedSupportingTextColor());
        long jM7348unboximpl32 = composeOrNull32 != null ? composeOrNull32.m7348unboximpl() : textFieldColorsColors.getUnfocusedSupportingTextColor();
        Color composeOrNull33 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getDisabledSupportingTextColor());
        long jM7348unboximpl33 = composeOrNull33 != null ? composeOrNull33.m7348unboximpl() : textFieldColorsColors.getDisabledSupportingTextColor();
        Color composeOrNull34 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getErrorSupportingTextColor());
        long jM7348unboximpl34 = composeOrNull34 != null ? composeOrNull34.m7348unboximpl() : textFieldColorsColors.getErrorSupportingTextColor();
        Color composeOrNull35 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getFocusedPrefixColor());
        long jM7348unboximpl35 = composeOrNull35 != null ? composeOrNull35.m7348unboximpl() : textFieldColorsColors.getFocusedPrefixColor();
        Color composeOrNull36 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getUnfocusedPrefixColor());
        long jM7348unboximpl36 = composeOrNull36 != null ? composeOrNull36.m7348unboximpl() : textFieldColorsColors.getUnfocusedPrefixColor();
        Color composeOrNull37 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getDisabledPrefixColor());
        long jM7348unboximpl37 = composeOrNull37 != null ? composeOrNull37.m7348unboximpl() : textFieldColorsColors.getDisabledPrefixColor();
        Color composeOrNull38 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getErrorPrefixColor());
        long jM7348unboximpl38 = composeOrNull38 != null ? composeOrNull38.m7348unboximpl() : textFieldColorsColors.getErrorPrefixColor();
        Color composeOrNull39 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getFocusedSuffixColor());
        long jM7348unboximpl39 = composeOrNull39 != null ? composeOrNull39.m7348unboximpl() : textFieldColorsColors.getFocusedSuffixColor();
        Color composeOrNull40 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getUnfocusedSuffixColor());
        long jM7348unboximpl40 = composeOrNull40 != null ? composeOrNull40.m7348unboximpl() : textFieldColorsColors.getUnfocusedSuffixColor();
        Color composeOrNull41 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getDisabledSuffixColor());
        long jM7348unboximpl41 = composeOrNull41 != null ? composeOrNull41.m7348unboximpl() : textFieldColorsColors.getDisabledSuffixColor();
        Color composeOrNull42 = UtilsKt.getComposeOrNull(textFieldColorsRecord.getErrorSuffixColor());
        TextFieldColors textFieldColorsM4907colors0hiis_0 = textFieldDefaults.m4907colors0hiis_0(jM7348unboximpl, jM7348unboximpl2, jM7348unboximpl3, jM7348unboximpl4, jM7348unboximpl5, jM7348unboximpl6, jM7348unboximpl7, jM7348unboximpl8, jM7348unboximpl9, jM7348unboximpl10, null, jM7348unboximpl11, jM7348unboximpl12, jM7348unboximpl13, jM7348unboximpl14, jM7348unboximpl15, jM7348unboximpl16, jM7348unboximpl17, jM7348unboximpl18, jM7348unboximpl19, jM7348unboximpl20, jM7348unboximpl21, jM7348unboximpl22, jM7348unboximpl23, jM7348unboximpl24, jM7348unboximpl25, jM7348unboximpl26, jM7348unboximpl27, jM7348unboximpl28, jM7348unboximpl29, jM7348unboximpl30, jM7348unboximpl31, jM7348unboximpl32, jM7348unboximpl33, jM7348unboximpl34, jM7348unboximpl35, jM7348unboximpl36, jM7348unboximpl37, jM7348unboximpl38, jM7348unboximpl39, jM7348unboximpl40, jM7348unboximpl41, composeOrNull42 != null ? composeOrNull42.m7348unboximpl() : textFieldColorsColors.getErrorSuffixColor(), composer, 0, 0, 0, 0, 3072, 1024, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM4907colors0hiis_0;
    }

    /* JADX WARN: Code duplicated, block: B:148:0x038e  */
    /* JADX WARN: Code duplicated, block: B:149:0x0394  */
    /* JADX WARN: Code duplicated, block: B:152:0x039d  */
    /* JADX WARN: Code duplicated, block: B:153:0x039f  */
    /* JADX WARN: Code duplicated, block: B:156:0x03aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:157:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:158:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:161:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:162:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:164:0x03fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:165:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:166:0x0415  */
    /* JADX WARN: Code duplicated, block: B:169:0x0432  */
    /* JADX WARN: Code duplicated, block: B:173:0x044a  */
    /* JADX WARN: Code duplicated, block: B:175:0x044e  */
    /* JADX WARN: Code duplicated, block: B:176:0x0453  */
    /* JADX WARN: Code duplicated, block: B:178:0x045d  */
    /* JADX WARN: Code duplicated, block: B:180:0x0464 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:181:0x0466  */
    /* JADX WARN: Code duplicated, block: B:182:0x0480  */
    /* JADX WARN: Code duplicated, block: B:184:0x0483  */
    /* JADX WARN: Code duplicated, block: B:185:0x0488  */
    /* JADX WARN: Code duplicated, block: B:189:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:192:0x054c  */
    public static final void TextFieldContent(final FunctionalComposableScope functionalComposableScope, final TextFieldProps props, final AsyncFunctionHandle<String> setText, final AsyncFunctionHandle2<Integer, Integer> setSelection, final AsyncFunctionHandle<Unit> clear, final AsyncFunctionHandle<Unit> focus, final AsyncFunctionHandle<Unit> blur, final Function1<? super TextFieldValuePayload, Unit> onValueChanged, final Function1<? super GenericEventPayload1<Boolean>, Unit> onFocusChange, final Function1<? super KeyboardActionEvent, Unit> onKeyboardActionTriggered, final Function1<? super TextFieldSelectionPayload, Unit> onSelectionChanged, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        ComposableLambda composableLambdaRememberComposableLambda;
        final ComposableLambda composableLambdaRememberComposableLambda2;
        final ComposableLambda composableLambdaRememberComposableLambda3;
        final ComposableLambda composableLambdaRememberComposableLambda4;
        final ComposableLambda composableLambdaRememberComposableLambda5;
        final ComposableLambda composableLambdaRememberComposableLambda6;
        final ComposableLambda composableLambdaRememberComposableLambda7;
        int iIntValue;
        final int i5;
        Integer minLines;
        final int iIntValue2;
        boolean z;
        Shape shapeShapeFromShapeRecord;
        TextFieldColorsRecord colors;
        TextFieldColors colors2;
        TextFieldColors textFieldColors;
        TextFieldSelectionColorsRecord textSelectionColors;
        Color composeOrNull;
        Color composeOrNull2;
        long handleColor;
        Color colorM7328boximpl;
        long backgroundColor;
        TextFieldColors textFieldColorsM4843copyejIjP34;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(setText, "setText");
        Intrinsics.checkNotNullParameter(setSelection, "setSelection");
        Intrinsics.checkNotNullParameter(clear, "clear");
        Intrinsics.checkNotNullParameter(focus, "focus");
        Intrinsics.checkNotNullParameter(blur, "blur");
        Intrinsics.checkNotNullParameter(onValueChanged, "onValueChanged");
        Intrinsics.checkNotNullParameter(onFocusChange, "onFocusChange");
        Intrinsics.checkNotNullParameter(onKeyboardActionTriggered, "onKeyboardActionTriggered");
        Intrinsics.checkNotNullParameter(onSelectionChanged, "onSelectionChanged");
        Composer composerStartRestartGroup = composer.startRestartGroup(122494448);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldContent)N(props,setText,setSelection,clear,focus,blur,onValueChanged,onFocusChange,onKeyboardActionTriggered,onSelectionChanged)205@10088L569,278@13240L1388,278@13176L1452:TextField.kt#2yem3u");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(setText) : composerStartRestartGroup.changedInstance(setText) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(setSelection) : composerStartRestartGroup.changedInstance(setSelection) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= (32768 & i) == 0 ? composerStartRestartGroup.changed(clear) : composerStartRestartGroup.changedInstance(clear) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= (262144 & i) == 0 ? composerStartRestartGroup.changed(focus) : composerStartRestartGroup.changedInstance(focus) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= (2097152 & i) == 0 ? composerStartRestartGroup.changed(blur) : composerStartRestartGroup.changedInstance(blur) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onValueChanged) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onFocusChange) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((805306368 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onKeyboardActionTriggered) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(onSelectionChanged) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(122494448, i3, i4, "expo.modules.ui.textfield.TextFieldContent (TextField.kt:204)");
            }
            ObservableState value = props.getValue();
            ObservableState selection = props.getSelection();
            Integer maxLength = props.getMaxLength();
            boolean autoFocus = props.getAutoFocus();
            TextFieldKeyboardOptionsRecord keyboardOptions = props.getKeyboardOptions();
            List<Map<String, Dynamic>> modifiers = props.getModifiers();
            WorkletCallback onValueChangeSync = props.getOnValueChangeSync();
            int i6 = FunctionalComposableScope.$stable | (i3 & 14) | (AsyncFunctionHandle.$stable << 24);
            int i7 = i3 << 18;
            int i8 = i3 >> 12;
            final TextFieldCore textFieldCoreRememberTextFieldCore = TextFieldSharedKt.rememberTextFieldCore(functionalComposableScope, value, selection, maxLength, autoFocus, keyboardOptions, modifiers, onValueChangeSync, setText, setSelection, clear, focus, blur, onValueChanged, onFocusChange, onKeyboardActionTriggered, onSelectionChanged, composerStartRestartGroup, i6 | (i7 & 234881024) | (AsyncFunctionHandle2.$stable << 27) | (i7 & 1879048192), (i8 & 896) | AsyncFunctionHandle.$stable | (i8 & 14) | (AsyncFunctionHandle.$stable << 3) | (i8 & 112) | (AsyncFunctionHandle.$stable << 6) | (i8 & 7168) | (57344 & i8) | (i8 & 458752) | ((i4 << 18) & 3670016));
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "label");
            if (slotViewFindChildSlotView == null) {
                composerStartRestartGroup.startReplaceGroup(-1488878932);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1488878931);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*225@10759L21");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-480386257, true, new Function2() { // from class: expo.modules.ui.textfield.TextFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldKt.TextFieldContent$lambda$1$lambda$0(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            final SlotView slotViewFindChildSlotView2 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "placeholder");
            if (slotViewFindChildSlotView2 == null) {
                composerStartRestartGroup.startReplaceGroup(-1488754932);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda2 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1488754931);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*226@10884L21");
                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-724836818, true, new Function2() { // from class: expo.modules.ui.textfield.TextFieldKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldKt.TextFieldContent$lambda$3$lambda$2(slotViewFindChildSlotView2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            final SlotView slotViewFindChildSlotView3 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "leadingIcon");
            if (slotViewFindChildSlotView3 == null) {
                composerStartRestartGroup.startReplaceGroup(-1488630932);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda3 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1488630931);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*227@11009L21");
                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(330301786, true, new Function2() { // from class: expo.modules.ui.textfield.TextFieldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldKt.TextFieldContent$lambda$5$lambda$4(slotViewFindChildSlotView3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            final SlotView slotViewFindChildSlotView4 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "trailingIcon");
            if (slotViewFindChildSlotView4 == null) {
                composerStartRestartGroup.startReplaceGroup(-1488504948);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda4 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1488504947);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*228@11136L21");
                composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(1331502332, true, new Function2() { // from class: expo.modules.ui.textfield.TextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldKt.TextFieldContent$lambda$7$lambda$6(slotViewFindChildSlotView4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            final SlotView slotViewFindChildSlotView5 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "prefix");
            if (slotViewFindChildSlotView5 == null) {
                composerStartRestartGroup.startReplaceGroup(-1488390868);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda5 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1488390867);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*229@11251L21");
                composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-1805119143, true, new Function2() { // from class: expo.modules.ui.textfield.TextFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldKt.TextFieldContent$lambda$9$lambda$8(slotViewFindChildSlotView5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            final SlotView slotViewFindChildSlotView6 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "suffix");
            if (slotViewFindChildSlotView6 == null) {
                composerStartRestartGroup.startReplaceGroup(-1488276788);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda6 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1488276787);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*230@11366L21");
                composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(1595635224, true, new Function2() { // from class: expo.modules.ui.textfield.TextFieldKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldKt.TextFieldContent$lambda$11$lambda$10(slotViewFindChildSlotView6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            final SlotView slotViewFindChildSlotView7 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "supportingText");
            if (slotViewFindChildSlotView7 == null) {
                composerStartRestartGroup.startReplaceGroup(-1488146836);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda7 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1488146835);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*231@11497L21");
                composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(1563284039, true, new Function2() { // from class: expo.modules.ui.textfield.TextFieldKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldKt.TextFieldContent$lambda$13$lambda$12(slotViewFindChildSlotView7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            final boolean singleLine = props.getSingleLine();
            Integer maxLines = props.getMaxLines();
            if (maxLines != null) {
                iIntValue = maxLines.intValue();
            } else {
                if (singleLine) {
                    i5 = 1;
                } else {
                    iIntValue = Integer.MAX_VALUE;
                }
                minLines = props.getMinLines();
                if (minLines != null) {
                    iIntValue2 = minLines.intValue();
                } else {
                    iIntValue2 = 1;
                }
                if (props.getVariant() == TextFieldVariant.OUTLINED) {
                    z = true;
                } else {
                    z = false;
                }
                shapeShapeFromShapeRecord = ShapeViewKt.shapeFromShapeRecord(props.getShape());
                if (shapeShapeFromShapeRecord == null) {
                    if (z) {
                        composerStartRestartGroup.startReplaceGroup(-1487800379);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "245@11866L5");
                        shapeShapeFromShapeRecord = OutlinedTextFieldDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1487750035);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "247@11909L5");
                        shapeShapeFromShapeRecord = TextFieldDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                }
                colors = props.getColors();
                if (colors == null) {
                    composerStartRestartGroup.startReplaceGroup(-1487680131);
                    composerStartRestartGroup.endReplaceGroup();
                    colors2 = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1753125636);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "249@11954L20");
                    colors2 = toColors(colors, z, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (colors2 == null) {
                    if (z) {
                        composerStartRestartGroup.startReplaceGroup(-1487635614);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "251@12032L8");
                        colors2 = OutlinedTextFieldDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1487582294);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "253@12078L8");
                        colors2 = TextFieldDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                }
                textFieldColors = colors2;
                textSelectionColors = props.getTextSelectionColors();
                if (textSelectionColors != null) {
                    composeOrNull = UtilsKt.getComposeOrNull(textSelectionColors.getHandleColor());
                    composeOrNull2 = UtilsKt.getComposeOrNull(textSelectionColors.getBackgroundColor());
                    if (composeOrNull == null || composeOrNull2 != null) {
                        if (composeOrNull != null) {
                            handleColor = composeOrNull.m7348unboximpl();
                        } else {
                            handleColor = textFieldColors.getTextSelectionColors().getHandleColor();
                        }
                        if (composeOrNull2 != null) {
                            backgroundColor = composeOrNull2.m7348unboximpl();
                        } else {
                            if (composeOrNull != null) {
                                colorM7328boximpl = Color.m7328boximpl(Color.m7337copywmQWz5c$default(composeOrNull.m7348unboximpl(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null));
                            } else {
                                colorM7328boximpl = null;
                            }
                            if (colorM7328boximpl != null) {
                                backgroundColor = colorM7328boximpl.m7348unboximpl();
                            } else {
                                backgroundColor = textFieldColors.getTextSelectionColors().getBackgroundColor();
                            }
                        }
                        textFieldColorsM4843copyejIjP34 = textFieldColors.m4843copyejIjP34(((-1025) & 1) != 0 ? textFieldColors.focusedTextColor : 0L, ((-1025) & 2) != 0 ? textFieldColors.unfocusedTextColor : 0L, ((-1025) & 4) != 0 ? textFieldColors.disabledTextColor : 0L, ((-1025) & 8) != 0 ? textFieldColors.errorTextColor : 0L, ((-1025) & 16) != 0 ? textFieldColors.focusedContainerColor : 0L, ((-1025) & 32) != 0 ? textFieldColors.unfocusedContainerColor : 0L, ((-1025) & 64) != 0 ? textFieldColors.disabledContainerColor : 0L, ((-1025) & 128) != 0 ? textFieldColors.errorContainerColor : 0L, ((-1025) & 256) != 0 ? textFieldColors.cursorColor : 0L, ((-1025) & 512) != 0 ? textFieldColors.errorCursorColor : 0L, ((-1025) & 1024) != 0 ? textFieldColors.textSelectionColors : new TextSelectionColors(handleColor, backgroundColor, null), ((-1025) & 2048) != 0 ? textFieldColors.focusedIndicatorColor : 0L, ((-1025) & 4096) != 0 ? textFieldColors.unfocusedIndicatorColor : 0L, ((-1025) & 8192) != 0 ? textFieldColors.disabledIndicatorColor : 0L, ((-1025) & 16384) != 0 ? textFieldColors.errorIndicatorColor : 0L, ((-1025) & 32768) != 0 ? textFieldColors.focusedLeadingIconColor : 0L, ((-1025) & 65536) != 0 ? textFieldColors.unfocusedLeadingIconColor : 0L, ((-1025) & 131072) != 0 ? textFieldColors.disabledLeadingIconColor : 0L, ((-1025) & 262144) != 0 ? textFieldColors.errorLeadingIconColor : 0L, ((-1025) & 524288) != 0 ? textFieldColors.focusedTrailingIconColor : 0L, ((-1025) & 1048576) != 0 ? textFieldColors.unfocusedTrailingIconColor : 0L, ((-1025) & 2097152) != 0 ? textFieldColors.disabledTrailingIconColor : 0L, ((-1025) & 4194304) != 0 ? textFieldColors.errorTrailingIconColor : 0L, ((-1025) & 8388608) != 0 ? textFieldColors.focusedLabelColor : 0L, ((-1025) & 16777216) != 0 ? textFieldColors.unfocusedLabelColor : 0L, ((-1025) & GroupFlagsKt.HasAuxSlotFlag) != 0 ? textFieldColors.disabledLabelColor : 0L, ((-1025) & 67108864) != 0 ? textFieldColors.errorLabelColor : 0L, ((-1025) & 134217728) != 0 ? textFieldColors.focusedPlaceholderColor : 0L, ((-1025) & 268435456) != 0 ? textFieldColors.unfocusedPlaceholderColor : 0L, ((-1025) & 536870912) != 0 ? textFieldColors.disabledPlaceholderColor : 0L, ((-1025) & 1073741824) != 0 ? textFieldColors.errorPlaceholderColor : 0L, ((-1025) & Integer.MIN_VALUE) != 0 ? textFieldColors.focusedSupportingTextColor : 0L, (2047 & 1) != 0 ? textFieldColors.unfocusedSupportingTextColor : 0L, (2047 & 2) != 0 ? textFieldColors.disabledSupportingTextColor : 0L, (2047 & 4) != 0 ? textFieldColors.errorSupportingTextColor : 0L, (2047 & 8) != 0 ? textFieldColors.focusedPrefixColor : 0L, (2047 & 16) != 0 ? textFieldColors.unfocusedPrefixColor : 0L, (2047 & 32) != 0 ? textFieldColors.disabledPrefixColor : 0L, (2047 & 64) != 0 ? textFieldColors.errorPrefixColor : 0L, (2047 & 128) != 0 ? textFieldColors.focusedSuffixColor : 0L, (2047 & 256) != 0 ? textFieldColors.unfocusedSuffixColor : 0L, (2047 & 512) != 0 ? textFieldColors.disabledSuffixColor : 0L, (2047 & 1024) != 0 ? textFieldColors.errorSuffixColor : 0L);
                    } else {
                        textFieldColorsM4843copyejIjP34 = textFieldColors;
                    }
                    if (textFieldColorsM4843copyejIjP34 != null) {
                        textFieldColors = textFieldColorsM4843copyejIjP34;
                    }
                }
                final TextStyle textStyle = TextFieldSharedKt.toTextStyle(props.getTextStyle(), functionalComposableScope.getAppContext().getReactContext());
                final VisualTransformation visualTransformation = TextFieldSharedKt.toVisualTransformation(props.getVisualTransformation());
                MotionScheme motionSchemeStandard = MotionScheme.INSTANCE.standard();
                final boolean z2 = z;
                final Shape shape = shapeShapeFromShapeRecord;
                final TextFieldColors textFieldColors2 = textFieldColors;
                final ComposableLambda composableLambda = composableLambdaRememberComposableLambda;
                Function2 function2 = new Function2() { // from class: expo.modules.ui.textfield.TextFieldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldKt.TextFieldContent$lambda$15(z2, textFieldCoreRememberTextFieldCore, props, textStyle, composableLambda, composableLambdaRememberComposableLambda2, composableLambdaRememberComposableLambda3, composableLambdaRememberComposableLambda4, composableLambdaRememberComposableLambda5, composableLambdaRememberComposableLambda6, composableLambdaRememberComposableLambda7, visualTransformation, singleLine, i5, iIntValue2, shape, textFieldColors2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                composer2 = composerStartRestartGroup;
                MaterialThemeKt.MaterialExpressiveTheme(null, motionSchemeStandard, null, null, ComposableLambdaKt.rememberComposableLambda(465425499, true, function2, composer2, 54), composer2, 24576, 13);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            i5 = iIntValue;
            minLines = props.getMinLines();
            if (minLines != null) {
                iIntValue2 = minLines.intValue();
            } else {
                iIntValue2 = 1;
            }
            if (props.getVariant() == TextFieldVariant.OUTLINED) {
                z = true;
            } else {
                z = false;
            }
            shapeShapeFromShapeRecord = ShapeViewKt.shapeFromShapeRecord(props.getShape());
            if (shapeShapeFromShapeRecord == null) {
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(-1487800379);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "245@11866L5");
                    shapeShapeFromShapeRecord = OutlinedTextFieldDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1487750035);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "247@11909L5");
                    shapeShapeFromShapeRecord = TextFieldDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            colors = props.getColors();
            if (colors == null) {
                composerStartRestartGroup.startReplaceGroup(-1487680131);
                composerStartRestartGroup.endReplaceGroup();
                colors2 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(1753125636);
                ComposerKt.sourceInformation(composerStartRestartGroup, "249@11954L20");
                colors2 = toColors(colors, z, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (colors2 == null) {
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(-1487635614);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "251@12032L8");
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1487582294);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "253@12078L8");
                    colors2 = TextFieldDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            textFieldColors = colors2;
            textSelectionColors = props.getTextSelectionColors();
            if (textSelectionColors != null) {
                composeOrNull = UtilsKt.getComposeOrNull(textSelectionColors.getHandleColor());
                composeOrNull2 = UtilsKt.getComposeOrNull(textSelectionColors.getBackgroundColor());
                if (composeOrNull == null) {
                    if (composeOrNull != null) {
                        handleColor = composeOrNull.m7348unboximpl();
                    } else {
                        handleColor = textFieldColors.getTextSelectionColors().getHandleColor();
                    }
                    if (composeOrNull2 != null) {
                        backgroundColor = composeOrNull2.m7348unboximpl();
                    } else {
                        if (composeOrNull != null) {
                            colorM7328boximpl = Color.m7328boximpl(Color.m7337copywmQWz5c$default(composeOrNull.m7348unboximpl(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null));
                        } else {
                            colorM7328boximpl = null;
                        }
                        if (colorM7328boximpl != null) {
                            backgroundColor = colorM7328boximpl.m7348unboximpl();
                        } else {
                            backgroundColor = textFieldColors.getTextSelectionColors().getBackgroundColor();
                        }
                    }
                    textFieldColorsM4843copyejIjP34 = textFieldColors.m4843copyejIjP34(((-1025) & 1) != 0 ? textFieldColors.focusedTextColor : 0L, ((-1025) & 2) != 0 ? textFieldColors.unfocusedTextColor : 0L, ((-1025) & 4) != 0 ? textFieldColors.disabledTextColor : 0L, ((-1025) & 8) != 0 ? textFieldColors.errorTextColor : 0L, ((-1025) & 16) != 0 ? textFieldColors.focusedContainerColor : 0L, ((-1025) & 32) != 0 ? textFieldColors.unfocusedContainerColor : 0L, ((-1025) & 64) != 0 ? textFieldColors.disabledContainerColor : 0L, ((-1025) & 128) != 0 ? textFieldColors.errorContainerColor : 0L, ((-1025) & 256) != 0 ? textFieldColors.cursorColor : 0L, ((-1025) & 512) != 0 ? textFieldColors.errorCursorColor : 0L, ((-1025) & 1024) != 0 ? textFieldColors.textSelectionColors : new TextSelectionColors(handleColor, backgroundColor, null), ((-1025) & 2048) != 0 ? textFieldColors.focusedIndicatorColor : 0L, ((-1025) & 4096) != 0 ? textFieldColors.unfocusedIndicatorColor : 0L, ((-1025) & 8192) != 0 ? textFieldColors.disabledIndicatorColor : 0L, ((-1025) & 16384) != 0 ? textFieldColors.errorIndicatorColor : 0L, ((-1025) & 32768) != 0 ? textFieldColors.focusedLeadingIconColor : 0L, ((-1025) & 65536) != 0 ? textFieldColors.unfocusedLeadingIconColor : 0L, ((-1025) & 131072) != 0 ? textFieldColors.disabledLeadingIconColor : 0L, ((-1025) & 262144) != 0 ? textFieldColors.errorLeadingIconColor : 0L, ((-1025) & 524288) != 0 ? textFieldColors.focusedTrailingIconColor : 0L, ((-1025) & 1048576) != 0 ? textFieldColors.unfocusedTrailingIconColor : 0L, ((-1025) & 2097152) != 0 ? textFieldColors.disabledTrailingIconColor : 0L, ((-1025) & 4194304) != 0 ? textFieldColors.errorTrailingIconColor : 0L, ((-1025) & 8388608) != 0 ? textFieldColors.focusedLabelColor : 0L, ((-1025) & 16777216) != 0 ? textFieldColors.unfocusedLabelColor : 0L, ((-1025) & GroupFlagsKt.HasAuxSlotFlag) != 0 ? textFieldColors.disabledLabelColor : 0L, ((-1025) & 67108864) != 0 ? textFieldColors.errorLabelColor : 0L, ((-1025) & 134217728) != 0 ? textFieldColors.focusedPlaceholderColor : 0L, ((-1025) & 268435456) != 0 ? textFieldColors.unfocusedPlaceholderColor : 0L, ((-1025) & 536870912) != 0 ? textFieldColors.disabledPlaceholderColor : 0L, ((-1025) & 1073741824) != 0 ? textFieldColors.errorPlaceholderColor : 0L, ((-1025) & Integer.MIN_VALUE) != 0 ? textFieldColors.focusedSupportingTextColor : 0L, (2047 & 1) != 0 ? textFieldColors.unfocusedSupportingTextColor : 0L, (2047 & 2) != 0 ? textFieldColors.disabledSupportingTextColor : 0L, (2047 & 4) != 0 ? textFieldColors.errorSupportingTextColor : 0L, (2047 & 8) != 0 ? textFieldColors.focusedPrefixColor : 0L, (2047 & 16) != 0 ? textFieldColors.unfocusedPrefixColor : 0L, (2047 & 32) != 0 ? textFieldColors.disabledPrefixColor : 0L, (2047 & 64) != 0 ? textFieldColors.errorPrefixColor : 0L, (2047 & 128) != 0 ? textFieldColors.focusedSuffixColor : 0L, (2047 & 256) != 0 ? textFieldColors.unfocusedSuffixColor : 0L, (2047 & 512) != 0 ? textFieldColors.disabledSuffixColor : 0L, (2047 & 1024) != 0 ? textFieldColors.errorSuffixColor : 0L);
                } else {
                    if (composeOrNull != null) {
                        handleColor = composeOrNull.m7348unboximpl();
                    } else {
                        handleColor = textFieldColors.getTextSelectionColors().getHandleColor();
                    }
                    if (composeOrNull2 != null) {
                        backgroundColor = composeOrNull2.m7348unboximpl();
                    } else {
                        if (composeOrNull != null) {
                            colorM7328boximpl = Color.m7328boximpl(Color.m7337copywmQWz5c$default(composeOrNull.m7348unboximpl(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null));
                        } else {
                            colorM7328boximpl = null;
                        }
                        if (colorM7328boximpl != null) {
                            backgroundColor = colorM7328boximpl.m7348unboximpl();
                        } else {
                            backgroundColor = textFieldColors.getTextSelectionColors().getBackgroundColor();
                        }
                    }
                    textFieldColorsM4843copyejIjP34 = textFieldColors.m4843copyejIjP34(((-1025) & 1) != 0 ? textFieldColors.focusedTextColor : 0L, ((-1025) & 2) != 0 ? textFieldColors.unfocusedTextColor : 0L, ((-1025) & 4) != 0 ? textFieldColors.disabledTextColor : 0L, ((-1025) & 8) != 0 ? textFieldColors.errorTextColor : 0L, ((-1025) & 16) != 0 ? textFieldColors.focusedContainerColor : 0L, ((-1025) & 32) != 0 ? textFieldColors.unfocusedContainerColor : 0L, ((-1025) & 64) != 0 ? textFieldColors.disabledContainerColor : 0L, ((-1025) & 128) != 0 ? textFieldColors.errorContainerColor : 0L, ((-1025) & 256) != 0 ? textFieldColors.cursorColor : 0L, ((-1025) & 512) != 0 ? textFieldColors.errorCursorColor : 0L, ((-1025) & 1024) != 0 ? textFieldColors.textSelectionColors : new TextSelectionColors(handleColor, backgroundColor, null), ((-1025) & 2048) != 0 ? textFieldColors.focusedIndicatorColor : 0L, ((-1025) & 4096) != 0 ? textFieldColors.unfocusedIndicatorColor : 0L, ((-1025) & 8192) != 0 ? textFieldColors.disabledIndicatorColor : 0L, ((-1025) & 16384) != 0 ? textFieldColors.errorIndicatorColor : 0L, ((-1025) & 32768) != 0 ? textFieldColors.focusedLeadingIconColor : 0L, ((-1025) & 65536) != 0 ? textFieldColors.unfocusedLeadingIconColor : 0L, ((-1025) & 131072) != 0 ? textFieldColors.disabledLeadingIconColor : 0L, ((-1025) & 262144) != 0 ? textFieldColors.errorLeadingIconColor : 0L, ((-1025) & 524288) != 0 ? textFieldColors.focusedTrailingIconColor : 0L, ((-1025) & 1048576) != 0 ? textFieldColors.unfocusedTrailingIconColor : 0L, ((-1025) & 2097152) != 0 ? textFieldColors.disabledTrailingIconColor : 0L, ((-1025) & 4194304) != 0 ? textFieldColors.errorTrailingIconColor : 0L, ((-1025) & 8388608) != 0 ? textFieldColors.focusedLabelColor : 0L, ((-1025) & 16777216) != 0 ? textFieldColors.unfocusedLabelColor : 0L, ((-1025) & GroupFlagsKt.HasAuxSlotFlag) != 0 ? textFieldColors.disabledLabelColor : 0L, ((-1025) & 67108864) != 0 ? textFieldColors.errorLabelColor : 0L, ((-1025) & 134217728) != 0 ? textFieldColors.focusedPlaceholderColor : 0L, ((-1025) & 268435456) != 0 ? textFieldColors.unfocusedPlaceholderColor : 0L, ((-1025) & 536870912) != 0 ? textFieldColors.disabledPlaceholderColor : 0L, ((-1025) & 1073741824) != 0 ? textFieldColors.errorPlaceholderColor : 0L, ((-1025) & Integer.MIN_VALUE) != 0 ? textFieldColors.focusedSupportingTextColor : 0L, (2047 & 1) != 0 ? textFieldColors.unfocusedSupportingTextColor : 0L, (2047 & 2) != 0 ? textFieldColors.disabledSupportingTextColor : 0L, (2047 & 4) != 0 ? textFieldColors.errorSupportingTextColor : 0L, (2047 & 8) != 0 ? textFieldColors.focusedPrefixColor : 0L, (2047 & 16) != 0 ? textFieldColors.unfocusedPrefixColor : 0L, (2047 & 32) != 0 ? textFieldColors.disabledPrefixColor : 0L, (2047 & 64) != 0 ? textFieldColors.errorPrefixColor : 0L, (2047 & 128) != 0 ? textFieldColors.focusedSuffixColor : 0L, (2047 & 256) != 0 ? textFieldColors.unfocusedSuffixColor : 0L, (2047 & 512) != 0 ? textFieldColors.disabledSuffixColor : 0L, (2047 & 1024) != 0 ? textFieldColors.errorSuffixColor : 0L);
                }
                if (textFieldColorsM4843copyejIjP34 != null) {
                    textFieldColors = textFieldColorsM4843copyejIjP34;
                }
            }
            final TextStyle textStyle2 = TextFieldSharedKt.toTextStyle(props.getTextStyle(), functionalComposableScope.getAppContext().getReactContext());
            final VisualTransformation visualTransformation2 = TextFieldSharedKt.toVisualTransformation(props.getVisualTransformation());
            MotionScheme motionSchemeStandard2 = MotionScheme.INSTANCE.standard();
            final boolean z3 = z;
            final Shape shape2 = shapeShapeFromShapeRecord;
            final TextFieldColors textFieldColors3 = textFieldColors;
            final Function2 composableLambda2 = composableLambdaRememberComposableLambda;
            Function2 function3 = new Function2() { // from class: expo.modules.ui.textfield.TextFieldKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldKt.TextFieldContent$lambda$15(z3, textFieldCoreRememberTextFieldCore, props, textStyle2, composableLambda2, composableLambdaRememberComposableLambda2, composableLambdaRememberComposableLambda3, composableLambdaRememberComposableLambda4, composableLambdaRememberComposableLambda5, composableLambdaRememberComposableLambda6, composableLambdaRememberComposableLambda7, visualTransformation2, singleLine, i5, iIntValue2, shape2, textFieldColors3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            composer2 = composerStartRestartGroup;
            MaterialThemeKt.MaterialExpressiveTheme(null, motionSchemeStandard2, null, null, ComposableLambdaKt.rememberComposableLambda(465425499, true, function3, composer2, 54), composer2, 24576, 13);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.textfield.TextFieldKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldKt.TextFieldContent$lambda$16(functionalComposableScope, props, setText, setSelection, clear, focus, blur, onValueChanged, onFocusChange, onKeyboardActionTriggered, onSelectionChanged, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit TextFieldContent$lambda$1$lambda$0(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C225@10766L12:TextField.kt#2yem3u");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-480386257, i, -1, "expo.modules.ui.textfield.TextFieldContent.<anonymous>.<anonymous> (TextField.kt:225)");
            }
            SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TextFieldContent$lambda$3$lambda$2(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C226@10891L12:TextField.kt#2yem3u");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-724836818, i, -1, "expo.modules.ui.textfield.TextFieldContent.<anonymous>.<anonymous> (TextField.kt:226)");
            }
            SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TextFieldContent$lambda$5$lambda$4(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C227@11016L12:TextField.kt#2yem3u");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(330301786, i, -1, "expo.modules.ui.textfield.TextFieldContent.<anonymous>.<anonymous> (TextField.kt:227)");
            }
            SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TextFieldContent$lambda$7$lambda$6(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C228@11143L12:TextField.kt#2yem3u");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1331502332, i, -1, "expo.modules.ui.textfield.TextFieldContent.<anonymous>.<anonymous> (TextField.kt:228)");
            }
            SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TextFieldContent$lambda$9$lambda$8(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C229@11258L12:TextField.kt#2yem3u");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1805119143, i, -1, "expo.modules.ui.textfield.TextFieldContent.<anonymous>.<anonymous> (TextField.kt:229)");
            }
            SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TextFieldContent$lambda$11$lambda$10(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C230@11373L12:TextField.kt#2yem3u");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1595635224, i, -1, "expo.modules.ui.textfield.TextFieldContent.<anonymous>.<anonymous> (TextField.kt:230)");
            }
            SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TextFieldContent$lambda$13$lambda$12(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C231@11504L12:TextField.kt#2yem3u");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1563284039, i, -1, "expo.modules.ui.textfield.TextFieldContent.<anonymous>.<anonymous> (TextField.kt:231)");
            }
            SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit TextFieldContent$lambda$15(boolean z, TextFieldCore textFieldCore, TextFieldProps textFieldProps, TextStyle textStyle, Function2 function2, Function2 function3, Function2 function4, Function2 function5, Function2 function6, Function2 function7, Function2 function8, VisualTransformation visualTransformation, boolean z2, int i, int i2, Shape shape, TextFieldColors textFieldColors, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C:TextField.kt#2yem3u");
        if (composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(465425499, i3, -1, "expo.modules.ui.textfield.TextFieldContent.<anonymous> (TextField.kt:279)");
            }
            if (z) {
                composer.startReplaceGroup(1336652189);
                ComposerKt.sourceInformation(composer, "280@13270L668");
                OutlinedTextFieldKt.OutlinedTextField(textFieldCore.getValue(), textFieldCore.getOnValueChange(), textFieldCore.getModifier(), textFieldProps.getEnabled(), textFieldProps.getReadOnly(), textStyle, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, (Function2<? super Composer, ? super Integer, Unit>) function6, (Function2<? super Composer, ? super Integer, Unit>) function7, (Function2<? super Composer, ? super Integer, Unit>) function8, textFieldProps.isError(), visualTransformation, textFieldCore.getKeyboardOptions(), textFieldCore.getKeyboardActions(), z2, i, i2, (MutableInteractionSource) null, shape, textFieldColors, composer, 0, 0, 0, 1048576);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1337334437);
                ComposerKt.sourceInformation(composer, "292@13958L660");
                androidx.compose.material3.TextFieldKt.TextField(textFieldCore.getValue(), textFieldCore.getOnValueChange(), textFieldCore.getModifier(), textFieldProps.getEnabled(), textFieldProps.getReadOnly(), textStyle, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, (Function2<? super Composer, ? super Integer, Unit>) function6, (Function2<? super Composer, ? super Integer, Unit>) function7, (Function2<? super Composer, ? super Integer, Unit>) function8, textFieldProps.isError(), visualTransformation, textFieldCore.getKeyboardOptions(), textFieldCore.getKeyboardActions(), z2, i, i2, (MutableInteractionSource) null, shape, textFieldColors, composer, 0, 0, 0, 1048576);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
