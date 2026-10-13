package expo.modules.ui.textfield;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.AsyncFunctionHandle;
import expo.modules.kotlin.views.AsyncFunctionHandle2;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.GenericEventPayload1;
import expo.modules.ui.SlotView;
import expo.modules.ui.SlotViewKt;
import expo.modules.ui.UtilsKt;
import expo.modules.ui.state.ObservableState;
import expo.modules.ui.state.WorkletCallback;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicTextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a»\u0001\u0010\n\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00030\u00182\u0018\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001b\u0012\u0004\u0012\u00020\u00030\u00182\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00030\u00182\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00030\u0018H\u0007¢\u0006\u0002\u0010 \"$\u0010\u0000\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0002\b\u00040\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006¨\u0006!"}, d2 = {"LocalInnerTextField", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getLocalInnerTextField", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalTextFieldIsEmpty", "", "getLocalTextFieldIsEmpty", "BasicTextFieldContent", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/textfield/BasicTextFieldProps;", "setText", "Lexpo/modules/kotlin/views/AsyncFunctionHandle;", "", "setSelection", "Lexpo/modules/kotlin/views/AsyncFunctionHandle2;", "", "clear", "focus", "blur", "onValueChanged", "Lkotlin/Function1;", "Lexpo/modules/ui/textfield/TextFieldValuePayload;", "onFocusChange", "Lexpo/modules/ui/GenericEventPayload1;", "onKeyboardActionTriggered", "Lexpo/modules/ui/textfield/KeyboardActionEvent;", "onSelectionChanged", "Lexpo/modules/ui/textfield/TextFieldSelectionPayload;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/textfield/BasicTextFieldProps;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle2;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BasicTextFieldKt {
    private static final ProvidableCompositionLocal<Function2<Composer, Integer, Unit>> LocalInnerTextField = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: expo.modules.ui.textfield.BasicTextFieldKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BasicTextFieldKt.LocalInnerTextField$lambda$0();
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<Boolean> LocalTextFieldIsEmpty = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: expo.modules.ui.textfield.BasicTextFieldKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(BasicTextFieldKt.LocalTextFieldIsEmpty$lambda$1());
        }
    }, 1, null);

    static final Unit BasicTextFieldContent$lambda$9(FunctionalComposableScope functionalComposableScope, BasicTextFieldProps basicTextFieldProps, AsyncFunctionHandle asyncFunctionHandle, AsyncFunctionHandle2 asyncFunctionHandle2, AsyncFunctionHandle asyncFunctionHandle3, AsyncFunctionHandle asyncFunctionHandle4, AsyncFunctionHandle asyncFunctionHandle5, Function1 function1, Function1 function2, Function1 function3, Function1 function4, int i, int i2, Composer composer, int i3) {
        BasicTextFieldContent(functionalComposableScope, basicTextFieldProps, asyncFunctionHandle, asyncFunctionHandle2, asyncFunctionHandle3, asyncFunctionHandle4, asyncFunctionHandle5, function1, function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    static final Function2 LocalInnerTextField$lambda$0() {
        return null;
    }

    static final boolean LocalTextFieldIsEmpty$lambda$1() {
        return true;
    }

    public static final ProvidableCompositionLocal<Function2<Composer, Integer, Unit>> getLocalInnerTextField() {
        return LocalInnerTextField;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalTextFieldIsEmpty() {
        return LocalTextFieldIsEmpty;
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0217  */
    /* JADX WARN: Code duplicated, block: B:121:0x021d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0243  */
    /* JADX WARN: Code duplicated, block: B:125:0x0295  */
    /* JADX WARN: Code duplicated, block: B:128:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:129:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:132:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:136:0x0315  */
    /* JADX WARN: Code duplicated, block: B:138:0x0319  */
    /* JADX WARN: Code duplicated, block: B:139:0x031e  */
    /* JADX WARN: Code duplicated, block: B:141:0x0324 A[PHI: r11
      0x0324: PHI (r11v24 androidx.compose.ui.graphics.Color) = (r11v17 androidx.compose.ui.graphics.Color), (r11v19 androidx.compose.ui.graphics.Color) binds: [B:140:0x0322, B:146:0x0348] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:143:0x032b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:144:0x032d  */
    /* JADX WARN: Code duplicated, block: B:145:0x0347  */
    /* JADX WARN: Code duplicated, block: B:148:0x034b  */
    /* JADX WARN: Code duplicated, block: B:152:0x0358  */
    /* JADX WARN: Code duplicated, block: B:155:0x0369  */
    /* JADX WARN: Code duplicated, block: B:156:0x0370  */
    /* JADX WARN: Code duplicated, block: B:159:0x03b5  */
    public static final void BasicTextFieldContent(final FunctionalComposableScope functionalComposableScope, final BasicTextFieldProps props, final AsyncFunctionHandle<String> setText, final AsyncFunctionHandle2<Integer, Integer> setSelection, final AsyncFunctionHandle<Unit> clear, final AsyncFunctionHandle<Unit> focus, final AsyncFunctionHandle<Unit> blur, final Function1<? super TextFieldValuePayload, Unit> onValueChanged, final Function1<? super GenericEventPayload1<Boolean>, Unit> onFocusChange, final Function1<? super KeyboardActionEvent, Unit> onKeyboardActionTriggered, final Function1<? super TextFieldSelectionPayload, Unit> onSelectionChanged, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        int iIntValue;
        final int i5;
        Integer minLines;
        final int iIntValue2;
        TextStyle textStyle;
        Color composeOrNull;
        long jM7348unboximpl;
        ComposableLambda composableLambdaRememberComposableLambda;
        TextSelectionColors textSelectionColors;
        TextFieldSelectionColorsRecord textSelectionColors2;
        final SlotView slotViewFindChildSlotView;
        Color composeOrNull2;
        Color composeOrNull3;
        TextSelectionColors textSelectionColors3;
        long handleColor;
        long backgroundColor;
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
        Composer composerStartRestartGroup = composer.startRestartGroup(-1630468082);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicTextFieldContent)N(props,setText,setSelection,clear,focus,blur,onValueChanged,onFocusChange,onKeyboardActionTriggered,onSelectionChanged)127@4285L569,164@5448L7,181@6119L836,181@6043L912:BasicTextField.kt#2yem3u");
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
                ComposerKt.traceEventStart(-1630468082, i3, i4, "expo.modules.ui.textfield.BasicTextFieldContent (BasicTextField.kt:126)");
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
            final TextFieldCore textFieldCoreRememberTextFieldCore = TextFieldSharedKt.rememberTextFieldCore(functionalComposableScope, value, selection, maxLength, autoFocus, keyboardOptions, modifiers, onValueChangeSync, setText, setSelection, clear, focus, blur, onValueChanged, onFocusChange, onKeyboardActionTriggered, onSelectionChanged, composerStartRestartGroup, i6 | (i7 & 234881024) | (AsyncFunctionHandle2.$stable << 27) | (i7 & 1879048192), AsyncFunctionHandle.$stable | (i8 & 14) | (AsyncFunctionHandle.$stable << 3) | (i8 & 112) | (AsyncFunctionHandle.$stable << 6) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (i8 & 458752) | ((i4 << 18) & 3670016));
            composer2 = composerStartRestartGroup;
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
                composer2.startReplaceGroup(783279312);
                ComposerKt.sourceInformation(composer2, "");
                textStyle = TextFieldSharedKt.toTextStyle(props.getTextStyle(), functionalComposableScope.getAppContext().getReactContext());
                if (textStyle.m9628getColor0d7_KjU() == 16) {
                    composer2.startReplaceGroup(-341407079);
                    ComposerKt.sourceInformation(composer2, "156@5169L11");
                    textStyle = TextStyle.m9611copyp1EtxEg$default(textStyle, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-341337205);
                    composer2.endReplaceGroup();
                }
                final TextStyle textStyle2 = textStyle;
                composer2.endReplaceGroup();
                final VisualTransformation visualTransformation = TextFieldSharedKt.toVisualTransformation(props.getVisualTransformation());
                composeOrNull = UtilsKt.getComposeOrNull(props.getCursorColor());
                if (composeOrNull == null) {
                    composer2.startReplaceGroup(783288917);
                    ComposerKt.sourceInformation(composer2, "162@5385L11");
                    jM7348unboximpl = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary();
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(783287026);
                    composer2.endReplaceGroup();
                    jM7348unboximpl = composeOrNull.m7348unboximpl();
                }
                composableLambdaRememberComposableLambda = null;
                final SolidColor solidColor = new SolidColor(jM7348unboximpl, null);
                ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composer2.consume(localTextSelectionColors);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                textSelectionColors = (TextSelectionColors) objConsume;
                textSelectionColors2 = props.getTextSelectionColors();
                if (textSelectionColors2 != null) {
                    composeOrNull2 = UtilsKt.getComposeOrNull(textSelectionColors2.getHandleColor());
                    composeOrNull3 = UtilsKt.getComposeOrNull(textSelectionColors2.getBackgroundColor());
                    if (composeOrNull2 == null || composeOrNull3 != null) {
                        if (composeOrNull2 != null) {
                            handleColor = composeOrNull2.m7348unboximpl();
                        } else {
                            handleColor = textSelectionColors.getHandleColor();
                        }
                        if (composeOrNull3 == null) {
                            if (composeOrNull2 != null) {
                                composeOrNull3 = Color.m7328boximpl(Color.m7337copywmQWz5c$default(composeOrNull2.m7348unboximpl(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null));
                            } else {
                                composeOrNull3 = null;
                            }
                            if (composeOrNull3 != null) {
                                backgroundColor = composeOrNull3.m7348unboximpl();
                            } else {
                                backgroundColor = textSelectionColors.getBackgroundColor();
                            }
                        } else {
                            backgroundColor = composeOrNull3.m7348unboximpl();
                        }
                        textSelectionColors3 = new TextSelectionColors(handleColor, backgroundColor, null);
                    } else {
                        textSelectionColors3 = textSelectionColors;
                    }
                    if (textSelectionColors3 != null) {
                        textSelectionColors = textSelectionColors3;
                    }
                }
                slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "decorationBox");
                if (slotViewFindChildSlotView == null) {
                    composer2.startReplaceGroup(-1487246258);
                } else {
                    composer2.startReplaceGroup(-1487246257);
                    ComposerKt.sourceInformation(composer2, "*179@6016L21");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-752225625, true, new Function2() { // from class: expo.modules.ui.textfield.BasicTextFieldKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BasicTextFieldKt.BasicTextFieldContent$lambda$5$lambda$4(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54);
                }
                composer2.endReplaceGroup();
                ProvidedValue<TextSelectionColors> providedValueProvides = TextSelectionColorsKt.getLocalTextSelectionColors().provides(textSelectionColors);
                final ComposableLambda composableLambda = composableLambdaRememberComposableLambda;
                CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(-296187058, true, new Function2() { // from class: expo.modules.ui.textfield.BasicTextFieldKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BasicTextFieldKt.BasicTextFieldContent$lambda$8(textFieldCoreRememberTextFieldCore, props, textStyle2, singleLine, i5, iIntValue2, visualTransformation, solidColor, composableLambda, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, ProvidedValue.$stable | 48);
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
            composer2.startReplaceGroup(783279312);
            ComposerKt.sourceInformation(composer2, "");
            textStyle = TextFieldSharedKt.toTextStyle(props.getTextStyle(), functionalComposableScope.getAppContext().getReactContext());
            if (textStyle.m9628getColor0d7_KjU() == 16) {
                composer2.startReplaceGroup(-341407079);
                ComposerKt.sourceInformation(composer2, "156@5169L11");
                textStyle = TextStyle.m9611copyp1EtxEg$default(textStyle, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-341337205);
                composer2.endReplaceGroup();
            }
            final TextStyle textStyle3 = textStyle;
            composer2.endReplaceGroup();
            final VisualTransformation visualTransformation2 = TextFieldSharedKt.toVisualTransformation(props.getVisualTransformation());
            composeOrNull = UtilsKt.getComposeOrNull(props.getCursorColor());
            if (composeOrNull == null) {
                composer2.startReplaceGroup(783288917);
                ComposerKt.sourceInformation(composer2, "162@5385L11");
                jM7348unboximpl = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary();
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(783287026);
                composer2.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            composableLambdaRememberComposableLambda = null;
            final SolidColor solidColor2 = new SolidColor(jM7348unboximpl, null);
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors2 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer2.consume(localTextSelectionColors2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            textSelectionColors = (TextSelectionColors) objConsume2;
            textSelectionColors2 = props.getTextSelectionColors();
            if (textSelectionColors2 != null) {
                composeOrNull2 = UtilsKt.getComposeOrNull(textSelectionColors2.getHandleColor());
                composeOrNull3 = UtilsKt.getComposeOrNull(textSelectionColors2.getBackgroundColor());
                if (composeOrNull2 == null) {
                    if (composeOrNull2 != null) {
                        handleColor = composeOrNull2.m7348unboximpl();
                    } else {
                        handleColor = textSelectionColors.getHandleColor();
                    }
                    if (composeOrNull3 == null) {
                        if (composeOrNull2 != null) {
                            composeOrNull3 = Color.m7328boximpl(Color.m7337copywmQWz5c$default(composeOrNull2.m7348unboximpl(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null));
                        } else {
                            composeOrNull3 = null;
                        }
                        if (composeOrNull3 != null) {
                            backgroundColor = composeOrNull3.m7348unboximpl();
                        } else {
                            backgroundColor = textSelectionColors.getBackgroundColor();
                        }
                    } else {
                        backgroundColor = composeOrNull3.m7348unboximpl();
                    }
                    textSelectionColors3 = new TextSelectionColors(handleColor, backgroundColor, null);
                } else {
                    if (composeOrNull2 != null) {
                        handleColor = composeOrNull2.m7348unboximpl();
                    } else {
                        handleColor = textSelectionColors.getHandleColor();
                    }
                    if (composeOrNull3 == null) {
                        if (composeOrNull2 != null) {
                            composeOrNull3 = Color.m7328boximpl(Color.m7337copywmQWz5c$default(composeOrNull2.m7348unboximpl(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null));
                        } else {
                            composeOrNull3 = null;
                        }
                        if (composeOrNull3 != null) {
                            backgroundColor = composeOrNull3.m7348unboximpl();
                        } else {
                            backgroundColor = textSelectionColors.getBackgroundColor();
                        }
                    } else {
                        backgroundColor = composeOrNull3.m7348unboximpl();
                    }
                    textSelectionColors3 = new TextSelectionColors(handleColor, backgroundColor, null);
                }
                if (textSelectionColors3 != null) {
                    textSelectionColors = textSelectionColors3;
                }
            }
            slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "decorationBox");
            if (slotViewFindChildSlotView == null) {
                composer2.startReplaceGroup(-1487246258);
            } else {
                composer2.startReplaceGroup(-1487246257);
                ComposerKt.sourceInformation(composer2, "*179@6016L21");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-752225625, true, new Function2() { // from class: expo.modules.ui.textfield.BasicTextFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BasicTextFieldKt.BasicTextFieldContent$lambda$5$lambda$4(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
            }
            composer2.endReplaceGroup();
            ProvidedValue<TextSelectionColors> providedValueProvides2 = TextSelectionColorsKt.getLocalTextSelectionColors().provides(textSelectionColors);
            final Function2 composableLambda2 = composableLambdaRememberComposableLambda;
            CompositionLocalKt.CompositionLocalProvider(providedValueProvides2, ComposableLambdaKt.rememberComposableLambda(-296187058, true, new Function2() { // from class: expo.modules.ui.textfield.BasicTextFieldKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTextFieldKt.BasicTextFieldContent$lambda$8(textFieldCoreRememberTextFieldCore, props, textStyle3, singleLine, i5, iIntValue2, visualTransformation2, solidColor2, composableLambda2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.textfield.BasicTextFieldKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTextFieldKt.BasicTextFieldContent$lambda$9(functionalComposableScope, props, setText, setSelection, clear, focus, blur, onValueChanged, onFocusChange, onKeyboardActionTriggered, onSelectionChanged, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit BasicTextFieldContent$lambda$5$lambda$4(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C179@6023L12:BasicTextField.kt#2yem3u");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-752225625, i, -1, "expo.modules.ui.textfield.BasicTextFieldContent.<anonymous>.<anonymous> (BasicTextField.kt:179)");
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

    static final Unit BasicTextFieldContent$lambda$8(final TextFieldCore textFieldCore, BasicTextFieldProps basicTextFieldProps, TextStyle textStyle, boolean z, int i, int i2, VisualTransformation visualTransformation, SolidColor solidColor, final Function2 function2, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C196@6617L328,182@6125L826:BasicTextField.kt#2yem3u");
        if (!composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-296187058, i3, -1, "expo.modules.ui.textfield.BasicTextFieldContent.<anonymous> (BasicTextField.kt:182)");
            }
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(textFieldCore.getValue(), textFieldCore.getOnValueChange(), textFieldCore.getModifier(), basicTextFieldProps.getEnabled(), basicTextFieldProps.getReadOnly(), textStyle, textFieldCore.getKeyboardOptions(), textFieldCore.getKeyboardActions(), z, i, i2, visualTransformation, (Function1<? super TextLayoutResult, Unit>) null, (MutableInteractionSource) null, solidColor, ComposableLambdaKt.rememberComposableLambda(1248869425, true, new Function3() { // from class: expo.modules.ui.textfield.BasicTextFieldKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BasicTextFieldKt.BasicTextFieldContent$lambda$8$lambda$7(function2, textFieldCore, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 12288);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit BasicTextFieldContent$lambda$8$lambda$7(final Function2 function2, TextFieldCore textFieldCore, Function2 innerTextField, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        ComposerKt.sourceInformation(composer, "CN(innerTextField):BasicTextField.kt#2yem3u");
        if ((i & 6) == 0) {
            i |= composer.changedInstance(innerTextField) ? 4 : 2;
        }
        if (composer.shouldExecute((i & 19) != 18, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1248869425, i, -1, "expo.modules.ui.textfield.BasicTextFieldContent.<anonymous>.<anonymous> (BasicTextField.kt:197)");
            }
            if (function2 != null) {
                composer.startReplaceGroup(2062380753);
                ComposerKt.sourceInformation(composer, "201@6845L38,198@6681L202");
                ProvidedValue[] providedValueArr = new ProvidedValue[2];
                providedValueArr[0] = LocalInnerTextField.provides(innerTextField);
                providedValueArr[1] = LocalTextFieldIsEmpty.provides(Boolean.valueOf(textFieldCore.getValue().getText().length() == 0));
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.rememberComposableLambda(-1416165194, true, new Function2() { // from class: expo.modules.ui.textfield.BasicTextFieldKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BasicTextFieldKt.BasicTextFieldContent$lambda$8$lambda$7$lambda$6(function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, ProvidedValue.$stable | 48);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(2062603147);
                ComposerKt.sourceInformation(composer, "205@6911L16");
                innerTextField.invoke(composer, Integer.valueOf(i & 14));
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

    static final Unit BasicTextFieldContent$lambda$8$lambda$7$lambda$6(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C202@6859L12:BasicTextField.kt#2yem3u");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1416165194, i, -1, "expo.modules.ui.textfield.BasicTextFieldContent.<anonymous>.<anonymous>.<anonymous> (BasicTextField.kt:202)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
