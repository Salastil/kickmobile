package expo.modules.ui.textfield;

import android.content.Context;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.AsyncFunctionHandle;
import expo.modules.kotlin.views.AsyncFunctionHandle2;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.GenericEventPayload1;
import expo.modules.ui.ModifierRegistry;
import expo.modules.ui.TextAlignType;
import expo.modules.ui.TextFontWeight;
import expo.modules.ui.TextViewKt;
import expo.modules.ui.UtilsKt;
import expo.modules.ui.state.ObservableState;
import expo.modules.ui.state.WorkletCallback;
import io.ktor.http.LinkHeader;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TextFieldShared.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0002\u0010\u0003\u001a\u000e\u0010\b\u001a\u00020\t*\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b*\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\u0019\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010\u0014\u001a\u008b\u0002\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2 \u0010\u001f\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\"0!j\u0002`#0 j\u0002`$2\b\u0010%\u001a\u0004\u0018\u00010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0(2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0(2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020,0(2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020,002\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c03\u0012\u0004\u0012\u00020,002\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020,002\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020,00H\u0007¢\u0006\u0002\u00108¨\u00069"}, d2 = {"toKeyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "", "(Ljava/lang/String;)I", "toCapitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "toImeAction", "Landroidx/compose/ui/text/input/ImeAction;", "toVisualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "toTextStyle", "Landroidx/compose/ui/text/TextStyle;", "Lexpo/modules/ui/textfield/TextFieldTextStyleRecord;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "extractSelection", "Landroidx/compose/ui/text/TextRange;", "Lexpo/modules/ui/state/ObservableState;", "textLength", "", "(Lexpo/modules/ui/state/ObservableState;I)J", "rememberTextFieldCore", "Lexpo/modules/ui/textfield/TextFieldCore;", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "value", "selection", "maxLength", "autoFocus", "", "keyboardOptionsRecord", "Lexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord;", "modifiers", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "onValueChangeSync", "Lexpo/modules/ui/state/WorkletCallback;", "setText", "Lexpo/modules/kotlin/views/AsyncFunctionHandle;", "setSelection", "Lexpo/modules/kotlin/views/AsyncFunctionHandle2;", "clear", "", "focus", "blur", "onValueChanged", "Lkotlin/Function1;", "Lexpo/modules/ui/textfield/TextFieldValuePayload;", "onFocusChange", "Lexpo/modules/ui/GenericEventPayload1;", "onKeyboardActionTriggered", "Lexpo/modules/ui/textfield/KeyboardActionEvent;", "onSelectionChanged", "Lexpo/modules/ui/textfield/TextFieldSelectionPayload;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/state/ObservableState;Lexpo/modules/ui/state/ObservableState;Ljava/lang/Integer;ZLexpo/modules/ui/textfield/TextFieldKeyboardOptionsRecord;Ljava/util/List;Lexpo/modules/ui/state/WorkletCallback;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle2;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lexpo/modules/kotlin/views/AsyncFunctionHandle;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lexpo/modules/ui/textfield/TextFieldCore;", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TextFieldSharedKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final int toKeyboardType(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1034364087:
                    if (str.equals("number")) {
                        return KeyboardType.INSTANCE.m9854getNumberPjHm6EE();
                    }
                    break;
                case 116076:
                    if (str.equals("uri")) {
                        return KeyboardType.INSTANCE.m9860getUriPjHm6EE();
                    }
                    break;
                case 3556653:
                    if (str.equals("text")) {
                        return KeyboardType.INSTANCE.m9858getTextPjHm6EE();
                    }
                    break;
                case 93106001:
                    if (str.equals("ascii")) {
                        return KeyboardType.INSTANCE.m9851getAsciiPjHm6EE();
                    }
                    break;
                case 96619420:
                    if (str.equals("email")) {
                        return KeyboardType.INSTANCE.m9853getEmailPjHm6EE();
                    }
                    break;
                case 106642798:
                    if (str.equals("phone")) {
                        return KeyboardType.INSTANCE.m9857getPhonePjHm6EE();
                    }
                    break;
                case 154509572:
                    if (str.equals("numberPassword")) {
                        return KeyboardType.INSTANCE.m9855getNumberPasswordPjHm6EE();
                    }
                    break;
                case 1216985755:
                    if (str.equals("password")) {
                        return KeyboardType.INSTANCE.m9856getPasswordPjHm6EE();
                    }
                    break;
                case 1542263633:
                    if (str.equals("decimal")) {
                        return KeyboardType.INSTANCE.m9852getDecimalPjHm6EE();
                    }
                    break;
            }
        }
        return KeyboardType.INSTANCE.m9858getTextPjHm6EE();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final int toCapitalization(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3387192:
                    if (str.equals("none")) {
                        return KeyboardCapitalization.INSTANCE.m9830getNoneIUNYP9k();
                    }
                    break;
                case 113318569:
                    if (str.equals("words")) {
                        return KeyboardCapitalization.INSTANCE.m9833getWordsIUNYP9k();
                    }
                    break;
                case 490141296:
                    if (str.equals("sentences")) {
                        return KeyboardCapitalization.INSTANCE.m9831getSentencesIUNYP9k();
                    }
                    break;
                case 1245424234:
                    if (str.equals("characters")) {
                        return KeyboardCapitalization.INSTANCE.m9829getCharactersIUNYP9k();
                    }
                    break;
            }
        }
        return KeyboardCapitalization.INSTANCE.m9830getNoneIUNYP9k();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final int toImeAction(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1273775369:
                    if (str.equals("previous")) {
                        return ImeAction.INSTANCE.m9802getPreviouseUduSuo();
                    }
                    break;
                case -906336856:
                    if (str.equals("search")) {
                        return ImeAction.INSTANCE.m9803getSearcheUduSuo();
                    }
                    break;
                case 3304:
                    if (str.equals("go")) {
                        return ImeAction.INSTANCE.m9799getGoeUduSuo();
                    }
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        return ImeAction.INSTANCE.m9798getDoneeUduSuo();
                    }
                    break;
                case 3377907:
                    if (str.equals(LinkHeader.Rel.Next)) {
                        return ImeAction.INSTANCE.m9800getNexteUduSuo();
                    }
                    break;
                case 3387192:
                    if (str.equals("none")) {
                        return ImeAction.INSTANCE.m9801getNoneeUduSuo();
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        return ImeAction.INSTANCE.m9804getSendeUduSuo();
                    }
                    break;
                case 1544803905:
                    if (str.equals(Constants.COLLATION_DEFAULT)) {
                        return ImeAction.INSTANCE.m9797getDefaulteUduSuo();
                    }
                    break;
            }
        }
        return ImeAction.INSTANCE.m9797getDefaulteUduSuo();
    }

    public static final VisualTransformation toVisualTransformation(String str) {
        return Intrinsics.areEqual(str, "password") ? new PasswordVisualTransformation((char) 0, 1, null) : VisualTransformation.INSTANCE.getNone();
    }

    public static final TextStyle toTextStyle(TextFieldTextStyleRecord textFieldTextStyleRecord, Context context) {
        if (textFieldTextStyleRecord == null) {
            return TextStyle.INSTANCE.getDefault();
        }
        Color colorColorToComposeColorOrNull = UtilsKt.colorToComposeColorOrNull(textFieldTextStyleRecord.getColor());
        long jM7348unboximpl = colorColorToComposeColorOrNull != null ? colorColorToComposeColorOrNull.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
        Float fontSize = textFieldTextStyleRecord.getFontSize();
        long sp = fontSize != null ? TextUnitKt.getSp(fontSize.floatValue()) : TextUnit.INSTANCE.m10373getUnspecifiedXSAIIZE();
        TextFontWeight fontWeight = textFieldTextStyleRecord.getFontWeight();
        FontWeight composeFontWeight = fontWeight != null ? fontWeight.toComposeFontWeight() : null;
        FontFamily fontFamilyResolveFontFamily = context != null ? TextViewKt.resolveFontFamily(textFieldTextStyleRecord.getFontFamily(), context) : null;
        Float letterSpacing = textFieldTextStyleRecord.getLetterSpacing();
        long sp2 = letterSpacing != null ? TextUnitKt.getSp(letterSpacing.floatValue()) : TextUnit.INSTANCE.m10373getUnspecifiedXSAIIZE();
        Float lineHeight = textFieldTextStyleRecord.getLineHeight();
        long sp3 = lineHeight != null ? TextUnitKt.getSp(lineHeight.floatValue()) : TextUnit.INSTANCE.m10373getUnspecifiedXSAIIZE();
        TextAlignType textAlign = textFieldTextStyleRecord.getTextAlign();
        return new TextStyle(jM7348unboximpl, sp, composeFontWeight, (FontStyle) null, (FontSynthesis) null, fontFamilyResolveFontFamily, (String) null, sp2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, textAlign != null ? textAlign.m12127toComposeTextAligne0LSkKk() : TextAlign.INSTANCE.m10052getUnspecifiede0LSkKk(), 0, sp3, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16613208, (DefaultConstructorMarker) null);
    }

    private static final long extractSelection(ObservableState observableState, int i) {
        Object value = observableState.getValue();
        Map map = value instanceof Map ? (Map) value : null;
        Object obj = map != null ? map.get(ViewProps.START) : null;
        Number number = obj instanceof Number ? (Number) obj : null;
        int iCoerceIn = number != null ? RangesKt.coerceIn(number.intValue(), 0, i) : 0;
        Object obj2 = map != null ? map.get(ViewProps.END) : null;
        Number number2 = obj2 instanceof Number ? (Number) obj2 : null;
        return TextRangeKt.TextRange(iCoerceIn, number2 != null ? RangesKt.coerceIn(number2.intValue(), 0, i) : 0);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:103:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:106:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:109:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:111:0x03db  */
    /* JADX WARN: Code duplicated, block: B:112:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:115:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:116:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:119:0x0413  */
    /* JADX WARN: Code duplicated, block: B:121:0x041b  */
    /* JADX WARN: Code duplicated, block: B:124:0x043b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0441  */
    /* JADX WARN: Code duplicated, block: B:132:0x0454  */
    /* JADX WARN: Code duplicated, block: B:134:0x045c  */
    /* JADX WARN: Code duplicated, block: B:137:0x0473  */
    /* JADX WARN: Code duplicated, block: B:139:0x0479  */
    /* JADX WARN: Code duplicated, block: B:145:0x048c  */
    /* JADX WARN: Code duplicated, block: B:147:0x0494  */
    /* JADX WARN: Code duplicated, block: B:150:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:152:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:158:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:160:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:163:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:165:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:171:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:173:0x0504  */
    /* JADX WARN: Code duplicated, block: B:176:0x051b  */
    /* JADX WARN: Code duplicated, block: B:178:0x0521  */
    /* JADX WARN: Code duplicated, block: B:184:0x0534  */
    /* JADX WARN: Code duplicated, block: B:186:0x053c  */
    /* JADX WARN: Code duplicated, block: B:189:0x0553  */
    /* JADX WARN: Code duplicated, block: B:191:0x0559  */
    /* JADX WARN: Code duplicated, block: B:197:0x056c  */
    /* JADX WARN: Code duplicated, block: B:199:0x0574  */
    /* JADX WARN: Code duplicated, block: B:202:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:205:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:208:0x05d4 A[PHI: r9
      0x05d4: PHI (r9v11 kotlin.jvm.functions.Function1<? super expo.modules.ui.GenericEventPayload1<java.lang.Boolean>, kotlin.Unit>) = 
      (r9v8 kotlin.jvm.functions.Function1<? super expo.modules.ui.GenericEventPayload1<java.lang.Boolean>, kotlin.Unit>)
      (r9v12 kotlin.jvm.functions.Function1<? super expo.modules.ui.GenericEventPayload1<java.lang.Boolean>, kotlin.Unit>)
     binds: [B:207:0x05d2, B:203:0x05cb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:209:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:212:0x05de  */
    /* JADX WARN: Code duplicated, block: B:214:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:217:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:219:0x0618  */
    /* JADX WARN: Code duplicated, block: B:221:0x062e  */
    /* JADX WARN: Code duplicated, block: B:224:0x063f  */
    /* JADX WARN: Code duplicated, block: B:225:0x0643  */
    /* JADX WARN: Code duplicated, block: B:227:0x0646  */
    /* JADX WARN: Code duplicated, block: B:230:0x0664  */
    /* JADX WARN: Code duplicated, block: B:231:0x067f  */
    /* JADX WARN: Code duplicated, block: B:234:0x0698  */
    /* JADX WARN: Code duplicated, block: B:236:0x06a8  */
    /* JADX WARN: Code duplicated, block: B:239:0x06ca  */
    /* JADX WARN: Code duplicated, block: B:242:0x06d3  */
    /* JADX WARN: Code duplicated, block: B:245:0x06d9 A[PHI: r1
      0x06d9: PHI (r1v43 java.lang.Integer) = (r1v39 java.lang.Integer), (r1v44 java.lang.Integer) binds: [B:244:0x06d7, B:240:0x06d0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:246:0x06dc  */
    /* JADX WARN: Code duplicated, block: B:249:0x06ef  */
    /* JADX WARN: Code duplicated, block: B:251:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:257:0x070b  */
    /* JADX WARN: Code duplicated, block: B:260:0x0714  */
    /* JADX WARN: Code duplicated, block: B:264:0x071b  */
    /* JADX WARN: Code duplicated, block: B:267:0x072c  */
    /* JADX WARN: Code duplicated, block: B:271:0x0738  */
    /* JADX WARN: Code duplicated, block: B:274:0x0766  */
    /* JADX WARN: Code duplicated, block: B:73:0x02ee A[PHI: r6
      0x02ee: PHI (r6v33 expo.modules.kotlin.views.AsyncFunctionHandle2<java.lang.Integer, java.lang.Integer>) = 
      (r6v5 expo.modules.kotlin.views.AsyncFunctionHandle2<java.lang.Integer, java.lang.Integer>)
      (r6v34 expo.modules.kotlin.views.AsyncFunctionHandle2<java.lang.Integer, java.lang.Integer>)
     binds: [B:72:0x02ec, B:68:0x02e5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:79:0x0306  */
    /* JADX WARN: Code duplicated, block: B:84:0x033a  */
    /* JADX WARN: Code duplicated, block: B:87:0x037a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0383  */
    /* JADX WARN: Code duplicated, block: B:93:0x0389 A[PHI: r6
      0x0389: PHI (r6v31 expo.modules.kotlin.views.AsyncFunctionHandle<kotlin.Unit>) = 
      (r6v10 expo.modules.kotlin.views.AsyncFunctionHandle<kotlin.Unit>)
      (r6v32 expo.modules.kotlin.views.AsyncFunctionHandle<kotlin.Unit>)
     binds: [B:92:0x0387, B:88:0x0380] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:94:0x038c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0399  */
    /* JADX WARN: Code duplicated, block: B:99:0x03a1  */
    public static final TextFieldCore rememberTextFieldCore(final FunctionalComposableScope functionalComposableScope, final ObservableState value, final ObservableState selection, Integer num, boolean z, TextFieldKeyboardOptionsRecord textFieldKeyboardOptionsRecord, List<? extends Map<String, ? extends Dynamic>> modifiers, final WorkletCallback workletCallback, final AsyncFunctionHandle<String> setText, AsyncFunctionHandle2<Integer, Integer> setSelection, AsyncFunctionHandle<Unit> clear, final AsyncFunctionHandle<Unit> focus, final AsyncFunctionHandle<Unit> blur, Function1<? super TextFieldValuePayload, Unit> onValueChanged, Function1<? super GenericEventPayload1<Boolean>, Unit> onFocusChange, final Function1<? super KeyboardActionEvent, Unit> onKeyboardActionTriggered, final Function1<? super TextFieldSelectionPayload, Unit> onSelectionChanged, Composer composer, int i, int i2) {
        final AsyncFunctionHandle2<Integer, Integer> asyncFunctionHandle2;
        boolean z2;
        boolean zChanged;
        Object objRememberedValue;
        boolean zChangedInstance;
        Object objRememberedValue2;
        int i3;
        final State stateRememberUpdatedState;
        final AsyncFunctionHandle<Unit> asyncFunctionHandle;
        boolean z3;
        boolean zChanged2;
        Object objRememberedValue3;
        String keyboardType;
        boolean zBooleanValue;
        String capitalization;
        String imeAction;
        boolean zChangedInstance2;
        Object objRememberedValue4;
        final Function0 function0;
        boolean zChanged3;
        Object objRememberedValue5;
        boolean zChanged4;
        Object objRememberedValue6;
        boolean zChanged5;
        Object objRememberedValue7;
        boolean zChanged6;
        Object objRememberedValue8;
        boolean zChanged7;
        Object objRememberedValue9;
        boolean zChanged8;
        Object objRememberedValue10;
        final Function1<? super GenericEventPayload1<Boolean>, Unit> function1;
        boolean z4;
        Object objRememberedValue11;
        Object value2;
        String str;
        String str2;
        long jExtractSelection;
        Object objRememberedValue12;
        MutableState mutableState;
        final Integer num2;
        boolean z5;
        final Function1<? super TextFieldValuePayload, Unit> function2;
        boolean zChangedInstance3;
        Object obj;
        final MutableState mutableState2;
        Object objRememberedValue13;
        Boolean autoCorrectEnabled;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        Intrinsics.checkNotNullParameter(setText, "setText");
        Intrinsics.checkNotNullParameter(setSelection, "setSelection");
        Intrinsics.checkNotNullParameter(clear, "clear");
        Intrinsics.checkNotNullParameter(focus, "focus");
        Intrinsics.checkNotNullParameter(blur, "blur");
        Intrinsics.checkNotNullParameter(onValueChanged, "onValueChanged");
        Intrinsics.checkNotNullParameter(onFocusChange, "onFocusChange");
        Intrinsics.checkNotNullParameter(onKeyboardActionTriggered, "onKeyboardActionTriggered");
        Intrinsics.checkNotNullParameter(onSelectionChanged, "onSelectionChanged");
        ComposerKt.sourceInformationMarkerStart(composer, 289849202, "C(rememberTextFieldCore)N(value,selection,maxLength,autoFocus,keyboardOptionsRecord,modifiers,onValueChangeSync,setText,setSelection,clear,focus,blur,onValueChanged,onFocusChange,onKeyboardActionTriggered,onSelectionChanged)177@6045L7,178@6076L29,181@6144L195,181@6137L202,186@6355L39,186@6348L46,189@6409L35,189@6402L42,192@6467L241,192@6460L248,198@6724L80,198@6717L87,210@7189L32,212@7276L127,216@7416L123,220@7554L127,224@7700L135,228@7852L131,232@7998L127,239@8179L77,241@8313L85,252@8597L54,257@8830L1292:TextFieldShared.kt#2yem3u");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(289849202, i, i2, "expo.modules.ui.textfield.rememberTextFieldCore (TextFieldShared.kt:176)");
        }
        ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localFocusManager);
        ComposerKt.sourceInformationMarkerEnd(composer);
        FocusManager focusManager = (FocusManager) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, -627765585, "CC(remember):TextFieldShared.kt#9igjgp");
        Object objRememberedValue14 = composer.rememberedValue();
        if (objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue14 = new FocusRequester();
            composer.updateRememberedValue(objRememberedValue14);
        }
        FocusRequester focusRequester = (FocusRequester) objRememberedValue14;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -627763243, "CC(remember):TextFieldShared.kt#9igjgp");
        boolean zChangedInstance4 = composer.changedInstance(value) | composer.changedInstance(selection);
        Object objRememberedValue15 = composer.rememberedValue();
        if (zChangedInstance4 || objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue15 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$1$1(value, selection, null);
            composer.updateRememberedValue(objRememberedValue15);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i4 = (i << 6) & 896;
        int i5 = AsyncFunctionHandle.$stable | ((i >> 24) & 14) | (FunctionalComposableScope.$stable << 6) | i4;
        ComposerKt.sourceInformationMarkerStart(composer, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
        final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState((Function2) objRememberedValue15, composer, (i5 >> 3) & 14);
        String name = setText.getName();
        ComposerKt.sourceInformationMarkerStart(composer, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
        boolean z6 = true;
        boolean zChangedInstance5 = composer.changedInstance(functionalComposableScope) | ((((i5 & 14) ^ 6) > 4 && composer.changed(setText)) || (i5 & 6) == 4) | composer.changed(stateRememberUpdatedState2);
        Object objRememberedValue16 = composer.rememberedValue();
        if (zChangedInstance5 || objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue16 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$1

                /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(State state, Continuation continuation) {
                        super(2, continuation);
                        this.$currentHandler = state;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                        return invoke2(objArr, (Continuation<Object>) continuation);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                        return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object obj2;
                        Object[] objArr = (Object[]) this.L$0;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i != 0) {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        ResultKt.throwOnFailure(obj);
                        if (objArr.length == 0) {
                            obj2 = Unit.INSTANCE;
                        } else {
                            obj2 = objArr[0];
                        }
                        Function2 function2 = (Function2) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.label = 1;
                        Object objInvoke = function2.invoke(obj2, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    functionalComposableScope.getView().getFunctionHandlers().put(setText.getName(), new AnonymousClass1(stateRememberUpdatedState2, null));
                    final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                    final AsyncFunctionHandle asyncFunctionHandle3 = setText;
                    return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$1.2
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue16);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(name, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue16, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -627756647, "CC(remember):TextFieldShared.kt#9igjgp");
        Object objRememberedValue17 = composer.rememberedValue();
        if (objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue17 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$2$1(focusRequester, null);
            composer.updateRememberedValue(objRememberedValue17);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i6 = AsyncFunctionHandle.$stable | ((i2 >> 3) & 14) | (FunctionalComposableScope.$stable << 6) | i4;
        ComposerKt.sourceInformationMarkerStart(composer, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
        final State stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState((Function2) objRememberedValue17, composer, (i6 >> 3) & 14);
        String name2 = focus.getName();
        ComposerKt.sourceInformationMarkerStart(composer, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
        boolean zChangedInstance6 = ((((i6 & 14) ^ 6) > 4 && composer.changed(focus)) || (i6 & 6) == 4) | composer.changedInstance(functionalComposableScope) | composer.changed(stateRememberUpdatedState3);
        Object objRememberedValue18 = composer.rememberedValue();
        if (zChangedInstance6 || objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue18 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$2

                /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(State state, Continuation continuation) {
                        super(2, continuation);
                        this.$currentHandler = state;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                        return invoke2(objArr, (Continuation<Object>) continuation);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                        return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object obj2;
                        Object[] objArr = (Object[]) this.L$0;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i != 0) {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        ResultKt.throwOnFailure(obj);
                        if (objArr.length == 0) {
                            obj2 = Unit.INSTANCE;
                        } else {
                            obj2 = objArr[0];
                        }
                        Function2 function2 = (Function2) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.label = 1;
                        Object objInvoke = function2.invoke(obj2, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    functionalComposableScope.getView().getFunctionHandlers().put(focus.getName(), new AnonymousClass1(stateRememberUpdatedState3, null));
                    final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                    final AsyncFunctionHandle asyncFunctionHandle3 = focus;
                    return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$2.2
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue18);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(name2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue18, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -627754923, "CC(remember):TextFieldShared.kt#9igjgp");
        boolean zChangedInstance7 = composer.changedInstance(focusManager);
        Object objRememberedValue19 = composer.rememberedValue();
        if (zChangedInstance7 || objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue19 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$3$1(focusManager, null);
            composer.updateRememberedValue(objRememberedValue19);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i7 = AsyncFunctionHandle.$stable | ((i2 >> 6) & 14) | (FunctionalComposableScope.$stable << 6) | i4;
        ComposerKt.sourceInformationMarkerStart(composer, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
        final State stateRememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState((Function2) objRememberedValue19, composer, (i7 >> 3) & 14);
        String name3 = blur.getName();
        ComposerKt.sourceInformationMarkerStart(composer, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
        boolean zChangedInstance8 = ((((i7 & 14) ^ 6) > 4 && composer.changed(blur)) || (i7 & 6) == 4) | composer.changedInstance(functionalComposableScope) | composer.changed(stateRememberUpdatedState4);
        Object objRememberedValue20 = composer.rememberedValue();
        if (zChangedInstance8 || objRememberedValue20 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue20 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$3

                /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$3$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(State state, Continuation continuation) {
                        super(2, continuation);
                        this.$currentHandler = state;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                        return invoke2(objArr, (Continuation<Object>) continuation);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                        return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object obj2;
                        Object[] objArr = (Object[]) this.L$0;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i != 0) {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        ResultKt.throwOnFailure(obj);
                        if (objArr.length == 0) {
                            obj2 = Unit.INSTANCE;
                        } else {
                            obj2 = objArr[0];
                        }
                        Function2 function2 = (Function2) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.label = 1;
                        Object objInvoke = function2.invoke(obj2, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    functionalComposableScope.getView().getFunctionHandlers().put(blur.getName(), new AnonymousClass1(stateRememberUpdatedState4, null));
                    final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                    final AsyncFunctionHandle asyncFunctionHandle3 = blur;
                    return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$3.2
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue20);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(name3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue20, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -627752861, "CC(remember):TextFieldShared.kt#9igjgp");
        boolean zChangedInstance9 = composer.changedInstance(value) | composer.changedInstance(selection);
        Object objRememberedValue21 = composer.rememberedValue();
        if (zChangedInstance9 || objRememberedValue21 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue21 = (Function3) new TextFieldSharedKt$rememberTextFieldCore$4$1(value, selection, null);
            composer.updateRememberedValue(objRememberedValue21);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i8 = AsyncFunctionHandle2.$stable | ((i >> 27) & 14) | (FunctionalComposableScope.$stable << 6) | i4;
        ComposerKt.sourceInformationMarkerStart(composer, 1741791073, "CC(handle)402@13953L29,403@14010L239,403@13987L262:ExpoComposeView.kt#sri11g");
        final State stateRememberUpdatedState5 = SnapshotStateKt.rememberUpdatedState((Function3) objRememberedValue21, composer, (i8 >> 3) & 14);
        String name4 = setSelection.getName();
        ComposerKt.sourceInformationMarkerStart(composer, -1176016048, "CC(remember):ExpoComposeView.kt#9igjgp");
        boolean zChangedInstance10 = composer.changedInstance(functionalComposableScope);
        if (((i8 & 14) ^ 6) > 4) {
            asyncFunctionHandle2 = setSelection;
            if (composer.changed(asyncFunctionHandle2)) {
                z2 = true;
            }
            zChanged = z2 | zChangedInstance10 | composer.changed(stateRememberUpdatedState5);
            objRememberedValue = composer.rememberedValue();
            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$4

                    /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$4$1, reason: invalid class name */
                    /* JADX INFO: compiled from: ExpoComposeView.kt */
                    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$2$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$2$1$1", f = "ExpoComposeView.kt", i = {0, 0, 0}, l = {409}, m = "invokeSuspend", n = {"args", "p0", "p1"}, s = {"L$0", "L$1", "L$2"})
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                        final /* synthetic */ State $currentHandler;
                        /* synthetic */ Object L$0;
                        Object L$1;
                        Object L$2;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(State state, Continuation continuation) {
                            super(2, continuation);
                            this.$currentHandler = state;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                            return invoke2(objArr, (Continuation<Object>) continuation);
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                            return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object[] objArr = (Object[]) this.L$0;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i != 0) {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            ResultKt.throwOnFailure(obj);
                            Object obj2 = objArr[0];
                            Object obj3 = objArr[1];
                            Function3 function3 = (Function3) this.$currentHandler.getValue();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                            this.label = 1;
                            Object objInvoke = function3.invoke(obj2, obj3, this);
                            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        functionalComposableScope.getView().getFunctionHandlers().put(asyncFunctionHandle2.getName(), new AnonymousClass1(stateRememberUpdatedState5, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle2 asyncFunctionHandle3 = asyncFunctionHandle2;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$4.2
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                            }
                        };
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.DisposableEffect(name4, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627744798, "CC(remember):TextFieldShared.kt#9igjgp");
            zChangedInstance = composer.changedInstance(value) | composer.changedInstance(selection);
            objRememberedValue2 = composer.rememberedValue();
            if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$5$1(value, selection, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            i3 = AsyncFunctionHandle.$stable | (i2 & 14) | (FunctionalComposableScope.$stable << 6) | i4;
            ComposerKt.sourceInformationMarkerStart(composer, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState((Function2) objRememberedValue2, composer, (i3 >> 3) & 14);
            String name5 = clear.getName();
            ComposerKt.sourceInformationMarkerStart(composer, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
            boolean zChangedInstance11 = composer.changedInstance(functionalComposableScope);
            if (((i3 & 14) ^ 6) > 4) {
                asyncFunctionHandle = clear;
                if (!composer.changed(asyncFunctionHandle)) {
                    z3 = true;
                }
                zChanged2 = z3 | zChangedInstance11 | composer.changed(stateRememberUpdatedState);
                objRememberedValue3 = composer.rememberedValue();
                if (!zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5

                        /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5$1, reason: invalid class name */
                        /* JADX INFO: compiled from: ExpoComposeView.kt */
                        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                            final /* synthetic */ State $currentHandler;
                            /* synthetic */ Object L$0;
                            Object L$1;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(State state, Continuation continuation) {
                                super(2, continuation);
                                this.$currentHandler = state;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                                anonymousClass1.L$0 = obj;
                                return anonymousClass1;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                                return invoke2(objArr, (Continuation<Object>) continuation);
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                                return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object obj2;
                                Object[] objArr = (Object[]) this.L$0;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i != 0) {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                    return obj;
                                }
                                ResultKt.throwOnFailure(obj);
                                if (objArr.length == 0) {
                                    obj2 = Unit.INSTANCE;
                                } else {
                                    obj2 = objArr[0];
                                }
                                Function2 function2 = (Function2) this.$currentHandler.getValue();
                                this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                                this.label = 1;
                                Object objInvoke = function2.invoke(obj2, this);
                                return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            functionalComposableScope.getView().getFunctionHandlers().put(asyncFunctionHandle.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                            final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                            final AsyncFunctionHandle asyncFunctionHandle3 = asyncFunctionHandle;
                            return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5.2
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                                }
                            };
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.DisposableEffect(name5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                KeyboardOptions keyboardOptions = KeyboardOptions.INSTANCE.getDefault();
                if (textFieldKeyboardOptionsRecord != null) {
                    keyboardType = textFieldKeyboardOptionsRecord.getKeyboardType();
                } else {
                    keyboardType = null;
                }
                int keyboardType2 = toKeyboardType(keyboardType);
                if (textFieldKeyboardOptionsRecord != null || (autoCorrectEnabled = textFieldKeyboardOptionsRecord.getAutoCorrectEnabled()) == null) {
                    zBooleanValue = true;
                } else {
                    zBooleanValue = autoCorrectEnabled.booleanValue();
                }
                if (textFieldKeyboardOptionsRecord != null) {
                    capitalization = textFieldKeyboardOptionsRecord.getCapitalization();
                } else {
                    capitalization = null;
                }
                int capitalization2 = toCapitalization(capitalization);
                if (textFieldKeyboardOptionsRecord != null) {
                    imeAction = textFieldKeyboardOptionsRecord.getImeAction();
                } else {
                    imeAction = null;
                }
                KeyboardOptions keyboardOptionsM2890copyINvB4aQ$default = KeyboardOptions.m2890copyINvB4aQ$default(keyboardOptions, capitalization2, Boolean.valueOf(zBooleanValue), keyboardType2, toImeAction(imeAction), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 112, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer, -627729966, "CC(remember):TextFieldShared.kt#9igjgp");
                zChangedInstance2 = composer.changedInstance(value);
                objRememberedValue4 = composer.rememberedValue();
                if (!zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$8$lambda$7(value);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                function0 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -627727087, "CC(remember):TextFieldShared.kt#9igjgp");
                int i9 = (i2 & 458752) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                zChanged3 = ((i9 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
                objRememberedValue5 = composer.rememberedValue();
                if (!zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$10$lambda$9(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                Function1 function3 = (Function1) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -627722611, "CC(remember):TextFieldShared.kt#9igjgp");
                zChanged4 = ((i9 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
                objRememberedValue6 = composer.rememberedValue();
                if (!zChanged4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$12$lambda$11(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                Function1 function4 = (Function1) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -627718191, "CC(remember):TextFieldShared.kt#9igjgp");
                zChanged5 = ((i9 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
                objRememberedValue7 = composer.rememberedValue();
                if (!zChanged5 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$14$lambda$13(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                }
                Function1 function5 = (Function1) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -627713511, "CC(remember):TextFieldShared.kt#9igjgp");
                zChanged6 = ((i9 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
                objRememberedValue8 = composer.rememberedValue();
                if (!zChanged6 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$16$lambda$15(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                }
                Function1 function6 = (Function1) objRememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -627708651, "CC(remember):TextFieldShared.kt#9igjgp");
                zChanged7 = ((i9 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
                objRememberedValue9 = composer.rememberedValue();
                if (!zChanged7 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue9 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$18$lambda$17(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                }
                Function1 function7 = (Function1) objRememberedValue9;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -627703983, "CC(remember):TextFieldShared.kt#9igjgp");
                zChanged8 = ((i9 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
                objRememberedValue10 = composer.rememberedValue();
                if (!zChanged8 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue10 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$20$lambda$19(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                KeyboardActions keyboardActions = new KeyboardActions(function3, function4, function5, function6, function7, (Function1) objRememberedValue10);
                Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(ModifierRegistry.INSTANCE.applyModifiers(modifiers, functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer, ((i >> 18) & 14) | (AppContext.$stable << 3)), focusRequester);
                ComposerKt.sourceInformationMarkerStart(composer, -627693945, "CC(remember):TextFieldShared.kt#9igjgp");
                if (((57344 & i2) ^ 24576) > 16384) {
                    function1 = onFocusChange;
                    if (!composer.changed(function1)) {
                        z4 = true;
                    }
                    objRememberedValue11 = composer.rememberedValue();
                    if (!z4 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue11);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    Modifier modifierOnFocusChanged = FocusChangedModifierKt.onFocusChanged(modifierFocusRequester, (Function1) objRememberedValue11);
                    if (z) {
                        composer.startReplaceGroup(2016426704);
                        ComposerKt.sourceInformation(composer, "246@8444L33,246@8423L54");
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer, -627689805, "CC(remember):TextFieldShared.kt#9igjgp");
                        objRememberedValue13 = composer.rememberedValue();
                        if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue13 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$6$1(focusRequester, null);
                            composer.updateRememberedValue(objRememberedValue13);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue13, composer, 6);
                    } else {
                        composer.startReplaceGroup(2008074064);
                    }
                    composer.endReplaceGroup();
                    value2 = value.getValue();
                    if (value2 instanceof String) {
                        str = (String) value2;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str = "";
                    }
                    str2 = str;
                    jExtractSelection = extractSelection(selection, str2.length());
                    ComposerKt.sourceInformationMarkerStart(composer, -627684888, "CC(remember):TextFieldShared.kt#9igjgp");
                    objRememberedValue12 = composer.rememberedValue();
                    if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                        composer.updateRememberedValue(objRememberedValue12);
                    }
                    mutableState = (MutableState) objRememberedValue12;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (Intrinsics.areEqual(((TextFieldValue) mutableState.getValue()).getText(), str2) || !TextRange.m9591equalsimpl0(((TextFieldValue) mutableState.getValue()).getSelection(), jExtractSelection)) {
                        mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -627676194, "CC(remember):TextFieldShared.kt#9igjgp");
                    if (((i & 7168) ^ 3072) > 2048) {
                        num2 = num;
                        if (!composer.changed(num2)) {
                            z5 = true;
                        }
                        boolean zChangedInstance12 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
                        if (((i2 & 7168) ^ 3072) > 2048) {
                            function2 = onValueChanged;
                            if (!composer.changed(function2)) {
                            }
                            zChangedInstance3 = zChangedInstance12 | z6 | composer.changedInstance(workletCallback);
                            Object objRememberedValue22 = composer.rememberedValue();
                            if (!zChangedInstance3 || objRememberedValue22 == Composer.INSTANCE.getEmpty()) {
                                mutableState2 = mutableState;
                                obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                                    }
                                };
                                composer.updateRememberedValue(obj);
                            } else {
                                obj = objRememberedValue22;
                                mutableState2 = mutableState;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            TextFieldCore textFieldCore = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default, keyboardActions, modifierOnFocusChanged);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            return textFieldCore;
                        }
                        function2 = onValueChanged;
                        if ((i2 & 3072) != 2048) {
                            z6 = false;
                        }
                        zChangedInstance3 = zChangedInstance12 | z6 | composer.changedInstance(workletCallback);
                        Object objRememberedValue23 = composer.rememberedValue();
                        if (zChangedInstance3) {
                            mutableState2 = mutableState;
                            obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                                }
                            };
                            composer.updateRememberedValue(obj);
                        } else {
                            mutableState2 = mutableState;
                            obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                                }
                            };
                            composer.updateRememberedValue(obj);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        TextFieldCore textFieldCore2 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default, keyboardActions, modifierOnFocusChanged);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        return textFieldCore2;
                    }
                    num2 = num;
                    if ((i & 3072) == 2048) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean zChangedInstance13 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
                    if (((i2 & 7168) ^ 3072) > 2048) {
                        function2 = onValueChanged;
                        if (!composer.changed(function2)) {
                        }
                        zChangedInstance3 = zChangedInstance13 | z6 | composer.changedInstance(workletCallback);
                        Object objRememberedValue24 = composer.rememberedValue();
                        if (zChangedInstance3) {
                            mutableState2 = mutableState;
                            obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                                }
                            };
                            composer.updateRememberedValue(obj);
                        } else {
                            mutableState2 = mutableState;
                            obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                                }
                            };
                            composer.updateRememberedValue(obj);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        TextFieldCore textFieldCore3 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default, keyboardActions, modifierOnFocusChanged);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        return textFieldCore3;
                    }
                    function2 = onValueChanged;
                    if ((i2 & 3072) != 2048) {
                        z6 = false;
                    }
                    zChangedInstance3 = zChangedInstance13 | z6 | composer.changedInstance(workletCallback);
                    Object objRememberedValue25 = composer.rememberedValue();
                    if (zChangedInstance3) {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    } else {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TextFieldCore textFieldCore4 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default, keyboardActions, modifierOnFocusChanged);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return textFieldCore4;
                }
                function1 = onFocusChange;
                if ((i2 & 24576) == 16384) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                objRememberedValue11 = composer.rememberedValue();
                if (!z4) {
                    objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierOnFocusChanged2 = FocusChangedModifierKt.onFocusChanged(modifierFocusRequester, (Function1) objRememberedValue11);
                if (z) {
                    composer.startReplaceGroup(2016426704);
                    ComposerKt.sourceInformation(composer, "246@8444L33,246@8423L54");
                    Unit unit2 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer, -627689805, "CC(remember):TextFieldShared.kt#9igjgp");
                    objRememberedValue13 = composer.rememberedValue();
                    if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue13 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$6$1(focusRequester, null);
                        composer.updateRememberedValue(objRememberedValue13);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue13, composer, 6);
                } else {
                    composer.startReplaceGroup(2008074064);
                }
                composer.endReplaceGroup();
                value2 = value.getValue();
                if (value2 instanceof String) {
                    str = (String) value2;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                str2 = str;
                jExtractSelection = extractSelection(selection, str2.length());
                ComposerKt.sourceInformationMarkerStart(composer, -627684888, "CC(remember):TextFieldShared.kt#9igjgp");
                objRememberedValue12 = composer.rememberedValue();
                if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue12);
                }
                mutableState = (MutableState) objRememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (Intrinsics.areEqual(((TextFieldValue) mutableState.getValue()).getText(), str2)) {
                    mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
                } else {
                    mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
                }
                ComposerKt.sourceInformationMarkerStart(composer, -627676194, "CC(remember):TextFieldShared.kt#9igjgp");
                if (((i & 7168) ^ 3072) > 2048) {
                    num2 = num;
                    if (!composer.changed(num2)) {
                        z5 = true;
                    }
                    boolean zChangedInstance14 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
                    if (((i2 & 7168) ^ 3072) > 2048) {
                        function2 = onValueChanged;
                        if (!composer.changed(function2)) {
                        }
                        zChangedInstance3 = zChangedInstance14 | z6 | composer.changedInstance(workletCallback);
                        Object objRememberedValue26 = composer.rememberedValue();
                        if (zChangedInstance3) {
                            mutableState2 = mutableState;
                            obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                                }
                            };
                            composer.updateRememberedValue(obj);
                        } else {
                            mutableState2 = mutableState;
                            obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                                }
                            };
                            composer.updateRememberedValue(obj);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        TextFieldCore textFieldCore5 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default, keyboardActions, modifierOnFocusChanged2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        return textFieldCore5;
                    }
                    function2 = onValueChanged;
                    if ((i2 & 3072) != 2048) {
                        z6 = false;
                    }
                    zChangedInstance3 = zChangedInstance14 | z6 | composer.changedInstance(workletCallback);
                    Object objRememberedValue27 = composer.rememberedValue();
                    if (zChangedInstance3) {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    } else {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TextFieldCore textFieldCore6 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default, keyboardActions, modifierOnFocusChanged2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return textFieldCore6;
                }
                num2 = num;
                if ((i & 3072) == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChangedInstance15 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
                if (((i2 & 7168) ^ 3072) > 2048) {
                    function2 = onValueChanged;
                    if (!composer.changed(function2)) {
                    }
                    zChangedInstance3 = zChangedInstance15 | z6 | composer.changedInstance(workletCallback);
                    Object objRememberedValue28 = composer.rememberedValue();
                    if (zChangedInstance3) {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    } else {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TextFieldCore textFieldCore7 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default, keyboardActions, modifierOnFocusChanged2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return textFieldCore7;
                }
                function2 = onValueChanged;
                if ((i2 & 3072) != 2048) {
                    z6 = false;
                }
                zChangedInstance3 = zChangedInstance15 | z6 | composer.changedInstance(workletCallback);
                Object objRememberedValue29 = composer.rememberedValue();
                if (zChangedInstance3) {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                } else {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldCore textFieldCore8 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default, keyboardActions, modifierOnFocusChanged2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return textFieldCore8;
            }
            asyncFunctionHandle = clear;
            if ((i3 & 6) == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            zChanged2 = z3 | zChangedInstance11 | composer.changed(stateRememberUpdatedState);
            objRememberedValue3 = composer.rememberedValue();
            if (!zChanged2) {
                objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5

                    /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5$1, reason: invalid class name */
                    /* JADX INFO: compiled from: ExpoComposeView.kt */
                    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                        final /* synthetic */ State $currentHandler;
                        /* synthetic */ Object L$0;
                        Object L$1;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(State state, Continuation continuation) {
                            super(2, continuation);
                            this.$currentHandler = state;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                            return invoke2(objArr, (Continuation<Object>) continuation);
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                            return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object obj2;
                            Object[] objArr = (Object[]) this.L$0;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i != 0) {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            ResultKt.throwOnFailure(obj);
                            if (objArr.length == 0) {
                                obj2 = Unit.INSTANCE;
                            } else {
                                obj2 = objArr[0];
                            }
                            Function2 function2 = (Function2) this.$currentHandler.getValue();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            this.label = 1;
                            Object objInvoke = function2.invoke(obj2, this);
                            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        functionalComposableScope.getView().getFunctionHandlers().put(asyncFunctionHandle.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle asyncFunctionHandle3 = asyncFunctionHandle;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5.2
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                            }
                        };
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5

                    /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5$1, reason: invalid class name */
                    /* JADX INFO: compiled from: ExpoComposeView.kt */
                    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                        final /* synthetic */ State $currentHandler;
                        /* synthetic */ Object L$0;
                        Object L$1;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(State state, Continuation continuation) {
                            super(2, continuation);
                            this.$currentHandler = state;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                            return invoke2(objArr, (Continuation<Object>) continuation);
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                            return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object obj2;
                            Object[] objArr = (Object[]) this.L$0;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i != 0) {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            ResultKt.throwOnFailure(obj);
                            if (objArr.length == 0) {
                                obj2 = Unit.INSTANCE;
                            } else {
                                obj2 = objArr[0];
                            }
                            Function2 function2 = (Function2) this.$currentHandler.getValue();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            this.label = 1;
                            Object objInvoke = function2.invoke(obj2, this);
                            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        functionalComposableScope.getView().getFunctionHandlers().put(asyncFunctionHandle.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle asyncFunctionHandle3 = asyncFunctionHandle;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5.2
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                            }
                        };
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.DisposableEffect(name5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            KeyboardOptions keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
            if (textFieldKeyboardOptionsRecord != null) {
                keyboardType = textFieldKeyboardOptionsRecord.getKeyboardType();
            } else {
                keyboardType = null;
            }
            int keyboardType3 = toKeyboardType(keyboardType);
            if (textFieldKeyboardOptionsRecord != null) {
                zBooleanValue = true;
            } else {
                zBooleanValue = true;
            }
            if (textFieldKeyboardOptionsRecord != null) {
                capitalization = textFieldKeyboardOptionsRecord.getCapitalization();
            } else {
                capitalization = null;
            }
            int capitalization3 = toCapitalization(capitalization);
            if (textFieldKeyboardOptionsRecord != null) {
                imeAction = textFieldKeyboardOptionsRecord.getImeAction();
            } else {
                imeAction = null;
            }
            KeyboardOptions keyboardOptionsM2890copyINvB4aQ$default2 = KeyboardOptions.m2890copyINvB4aQ$default(keyboardOptions2, capitalization3, Boolean.valueOf(zBooleanValue), keyboardType3, toImeAction(imeAction), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 112, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, -627729966, "CC(remember):TextFieldShared.kt#9igjgp");
            zChangedInstance2 = composer.changedInstance(value);
            objRememberedValue4 = composer.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue4 = new Function0() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$8$lambda$7(value);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function0() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$8$lambda$7(value);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            function0 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627727087, "CC(remember):TextFieldShared.kt#9igjgp");
            int i10 = (i2 & 458752) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            zChanged3 = ((i10 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
            objRememberedValue5 = composer.rememberedValue();
            if (!zChanged3) {
                objRememberedValue5 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$10$lambda$9(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$10$lambda$9(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Function1 function8 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627722611, "CC(remember):TextFieldShared.kt#9igjgp");
            zChanged4 = ((i10 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
            objRememberedValue6 = composer.rememberedValue();
            if (!zChanged4) {
                objRememberedValue6 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$12$lambda$11(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$12$lambda$11(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            Function1 function9 = (Function1) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627718191, "CC(remember):TextFieldShared.kt#9igjgp");
            zChanged5 = ((i10 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
            objRememberedValue7 = composer.rememberedValue();
            if (!zChanged5) {
                objRememberedValue7 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$14$lambda$13(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$14$lambda$13(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            Function1 function10 = (Function1) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627713511, "CC(remember):TextFieldShared.kt#9igjgp");
            zChanged6 = ((i10 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
            objRememberedValue8 = composer.rememberedValue();
            if (!zChanged6) {
                objRememberedValue8 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$16$lambda$15(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$16$lambda$15(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            Function1 function11 = (Function1) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627708651, "CC(remember):TextFieldShared.kt#9igjgp");
            zChanged7 = ((i10 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
            objRememberedValue9 = composer.rememberedValue();
            if (!zChanged7) {
                objRememberedValue9 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$18$lambda$17(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$18$lambda$17(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            Function1 function12 = (Function1) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627703983, "CC(remember):TextFieldShared.kt#9igjgp");
            zChanged8 = ((i10 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
            objRememberedValue10 = composer.rememberedValue();
            if (!zChanged8) {
                objRememberedValue10 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$20$lambda$19(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            } else {
                objRememberedValue10 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$20$lambda$19(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            KeyboardActions keyboardActions2 = new KeyboardActions(function8, function9, function10, function11, function12, (Function1) objRememberedValue10);
            Modifier modifierFocusRequester2 = FocusRequesterModifierKt.focusRequester(ModifierRegistry.INSTANCE.applyModifiers(modifiers, functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer, ((i >> 18) & 14) | (AppContext.$stable << 3)), focusRequester);
            ComposerKt.sourceInformationMarkerStart(composer, -627693945, "CC(remember):TextFieldShared.kt#9igjgp");
            if (((57344 & i2) ^ 24576) > 16384) {
                function1 = onFocusChange;
                if (!composer.changed(function1)) {
                    z4 = true;
                }
                objRememberedValue11 = composer.rememberedValue();
                if (!z4) {
                    objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierOnFocusChanged3 = FocusChangedModifierKt.onFocusChanged(modifierFocusRequester2, (Function1) objRememberedValue11);
                if (z) {
                    composer.startReplaceGroup(2016426704);
                    ComposerKt.sourceInformation(composer, "246@8444L33,246@8423L54");
                    Unit unit3 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer, -627689805, "CC(remember):TextFieldShared.kt#9igjgp");
                    objRememberedValue13 = composer.rememberedValue();
                    if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue13 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$6$1(focusRequester, null);
                        composer.updateRememberedValue(objRememberedValue13);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue13, composer, 6);
                } else {
                    composer.startReplaceGroup(2008074064);
                }
                composer.endReplaceGroup();
                value2 = value.getValue();
                if (value2 instanceof String) {
                    str = (String) value2;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                str2 = str;
                jExtractSelection = extractSelection(selection, str2.length());
                ComposerKt.sourceInformationMarkerStart(composer, -627684888, "CC(remember):TextFieldShared.kt#9igjgp");
                objRememberedValue12 = composer.rememberedValue();
                if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue12);
                }
                mutableState = (MutableState) objRememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (Intrinsics.areEqual(((TextFieldValue) mutableState.getValue()).getText(), str2)) {
                    mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
                } else {
                    mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
                }
                ComposerKt.sourceInformationMarkerStart(composer, -627676194, "CC(remember):TextFieldShared.kt#9igjgp");
                if (((i & 7168) ^ 3072) > 2048) {
                    num2 = num;
                    if (!composer.changed(num2)) {
                        z5 = true;
                    }
                    boolean zChangedInstance16 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
                    if (((i2 & 7168) ^ 3072) > 2048) {
                        function2 = onValueChanged;
                        if (!composer.changed(function2)) {
                        }
                        zChangedInstance3 = zChangedInstance16 | z6 | composer.changedInstance(workletCallback);
                        Object objRememberedValue210 = composer.rememberedValue();
                        if (zChangedInstance3) {
                            mutableState2 = mutableState;
                            obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                                }
                            };
                            composer.updateRememberedValue(obj);
                        } else {
                            mutableState2 = mutableState;
                            obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                                }
                            };
                            composer.updateRememberedValue(obj);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        TextFieldCore textFieldCore9 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default2, keyboardActions2, modifierOnFocusChanged3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        return textFieldCore9;
                    }
                    function2 = onValueChanged;
                    if ((i2 & 3072) != 2048) {
                        z6 = false;
                    }
                    zChangedInstance3 = zChangedInstance16 | z6 | composer.changedInstance(workletCallback);
                    Object objRememberedValue211 = composer.rememberedValue();
                    if (zChangedInstance3) {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    } else {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TextFieldCore textFieldCore10 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default2, keyboardActions2, modifierOnFocusChanged3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return textFieldCore10;
                }
                num2 = num;
                if ((i & 3072) == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChangedInstance17 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
                if (((i2 & 7168) ^ 3072) > 2048) {
                    function2 = onValueChanged;
                    if (!composer.changed(function2)) {
                    }
                    zChangedInstance3 = zChangedInstance17 | z6 | composer.changedInstance(workletCallback);
                    Object objRememberedValue212 = composer.rememberedValue();
                    if (zChangedInstance3) {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    } else {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TextFieldCore textFieldCore11 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default2, keyboardActions2, modifierOnFocusChanged3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return textFieldCore11;
                }
                function2 = onValueChanged;
                if ((i2 & 3072) != 2048) {
                    z6 = false;
                }
                zChangedInstance3 = zChangedInstance17 | z6 | composer.changedInstance(workletCallback);
                Object objRememberedValue213 = composer.rememberedValue();
                if (zChangedInstance3) {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                } else {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldCore textFieldCore12 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default2, keyboardActions2, modifierOnFocusChanged3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return textFieldCore12;
            }
            function1 = onFocusChange;
            if ((i2 & 24576) == 16384) {
                z4 = true;
            } else {
                z4 = false;
            }
            objRememberedValue11 = composer.rememberedValue();
            if (!z4) {
                objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            } else {
                objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierOnFocusChanged4 = FocusChangedModifierKt.onFocusChanged(modifierFocusRequester2, (Function1) objRememberedValue11);
            if (z) {
                composer.startReplaceGroup(2016426704);
                ComposerKt.sourceInformation(composer, "246@8444L33,246@8423L54");
                Unit unit4 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -627689805, "CC(remember):TextFieldShared.kt#9igjgp");
                objRememberedValue13 = composer.rememberedValue();
                if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue13 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$6$1(focusRequester, null);
                    composer.updateRememberedValue(objRememberedValue13);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(unit4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue13, composer, 6);
            } else {
                composer.startReplaceGroup(2008074064);
            }
            composer.endReplaceGroup();
            value2 = value.getValue();
            if (value2 instanceof String) {
                str = (String) value2;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            str2 = str;
            jExtractSelection = extractSelection(selection, str2.length());
            ComposerKt.sourceInformationMarkerStart(composer, -627684888, "CC(remember):TextFieldShared.kt#9igjgp");
            objRememberedValue12 = composer.rememberedValue();
            if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                composer.updateRememberedValue(objRememberedValue12);
            }
            mutableState = (MutableState) objRememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (Intrinsics.areEqual(((TextFieldValue) mutableState.getValue()).getText(), str2)) {
                mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
            } else {
                mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
            }
            ComposerKt.sourceInformationMarkerStart(composer, -627676194, "CC(remember):TextFieldShared.kt#9igjgp");
            if (((i & 7168) ^ 3072) > 2048) {
                num2 = num;
                if (!composer.changed(num2)) {
                    z5 = true;
                }
                boolean zChangedInstance18 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
                if (((i2 & 7168) ^ 3072) > 2048) {
                    function2 = onValueChanged;
                    if (!composer.changed(function2)) {
                    }
                    zChangedInstance3 = zChangedInstance18 | z6 | composer.changedInstance(workletCallback);
                    Object objRememberedValue214 = composer.rememberedValue();
                    if (zChangedInstance3) {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    } else {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TextFieldCore textFieldCore13 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default2, keyboardActions2, modifierOnFocusChanged4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return textFieldCore13;
                }
                function2 = onValueChanged;
                if ((i2 & 3072) != 2048) {
                    z6 = false;
                }
                zChangedInstance3 = zChangedInstance18 | z6 | composer.changedInstance(workletCallback);
                Object objRememberedValue215 = composer.rememberedValue();
                if (zChangedInstance3) {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                } else {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldCore textFieldCore14 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default2, keyboardActions2, modifierOnFocusChanged4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return textFieldCore14;
            }
            num2 = num;
            if ((i & 3072) == 2048) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean zChangedInstance19 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
            if (((i2 & 7168) ^ 3072) > 2048) {
                function2 = onValueChanged;
                if (!composer.changed(function2)) {
                }
                zChangedInstance3 = zChangedInstance19 | z6 | composer.changedInstance(workletCallback);
                Object objRememberedValue216 = composer.rememberedValue();
                if (zChangedInstance3) {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                } else {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldCore textFieldCore15 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default2, keyboardActions2, modifierOnFocusChanged4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return textFieldCore15;
            }
            function2 = onValueChanged;
            if ((i2 & 3072) != 2048) {
                z6 = false;
            }
            zChangedInstance3 = zChangedInstance19 | z6 | composer.changedInstance(workletCallback);
            Object objRememberedValue217 = composer.rememberedValue();
            if (zChangedInstance3) {
                mutableState2 = mutableState;
                obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                mutableState2 = mutableState;
                obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldCore textFieldCore16 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default2, keyboardActions2, modifierOnFocusChanged4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return textFieldCore16;
        }
        asyncFunctionHandle2 = setSelection;
        if ((i8 & 6) == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        zChanged = z2 | zChangedInstance10 | composer.changed(stateRememberUpdatedState5);
        objRememberedValue = composer.rememberedValue();
        if (!zChanged) {
            objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$4

                /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$4$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$2$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$2$1$1", f = "ExpoComposeView.kt", i = {0, 0, 0}, l = {409}, m = "invokeSuspend", n = {"args", "p0", "p1"}, s = {"L$0", "L$1", "L$2"})
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(State state, Continuation continuation) {
                        super(2, continuation);
                        this.$currentHandler = state;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                        return invoke2(objArr, (Continuation<Object>) continuation);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                        return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object[] objArr = (Object[]) this.L$0;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i != 0) {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        ResultKt.throwOnFailure(obj);
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Function3 function3 = (Function3) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                        this.label = 1;
                        Object objInvoke = function3.invoke(obj2, obj3, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    functionalComposableScope.getView().getFunctionHandlers().put(asyncFunctionHandle2.getName(), new AnonymousClass1(stateRememberUpdatedState5, null));
                    final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                    final AsyncFunctionHandle2 asyncFunctionHandle3 = asyncFunctionHandle2;
                    return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$4.2
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        } else {
            objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$4

                /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$4$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$2$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$2$1$1", f = "ExpoComposeView.kt", i = {0, 0, 0}, l = {409}, m = "invokeSuspend", n = {"args", "p0", "p1"}, s = {"L$0", "L$1", "L$2"})
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(State state, Continuation continuation) {
                        super(2, continuation);
                        this.$currentHandler = state;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                        return invoke2(objArr, (Continuation<Object>) continuation);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                        return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object[] objArr = (Object[]) this.L$0;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i != 0) {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        ResultKt.throwOnFailure(obj);
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Function3 function3 = (Function3) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
                        this.label = 1;
                        Object objInvoke = function3.invoke(obj2, obj3, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    functionalComposableScope.getView().getFunctionHandlers().put(asyncFunctionHandle2.getName(), new AnonymousClass1(stateRememberUpdatedState5, null));
                    final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                    final AsyncFunctionHandle2 asyncFunctionHandle3 = asyncFunctionHandle2;
                    return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$4.2
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(name4, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -627744798, "CC(remember):TextFieldShared.kt#9igjgp");
        zChangedInstance = composer.changedInstance(value) | composer.changedInstance(selection);
        objRememberedValue2 = composer.rememberedValue();
        if (!zChangedInstance) {
            objRememberedValue2 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$5$1(value, selection, null);
            composer.updateRememberedValue(objRememberedValue2);
        } else {
            objRememberedValue2 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$5$1(value, selection, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        i3 = AsyncFunctionHandle.$stable | (i2 & 14) | (FunctionalComposableScope.$stable << 6) | i4;
        ComposerKt.sourceInformationMarkerStart(composer, 2099440920, "CC(handle)384@13416L29,385@13473L279,385@13450L302:ExpoComposeView.kt#sri11g");
        stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState((Function2) objRememberedValue2, composer, (i3 >> 3) & 14);
        String name6 = clear.getName();
        ComposerKt.sourceInformationMarkerStart(composer, -1071897393, "CC(remember):ExpoComposeView.kt#9igjgp");
        boolean zChangedInstance110 = composer.changedInstance(functionalComposableScope);
        if (((i3 & 14) ^ 6) > 4) {
            asyncFunctionHandle = clear;
            if (!composer.changed(asyncFunctionHandle)) {
                z3 = true;
            }
            zChanged2 = z3 | zChangedInstance110 | composer.changed(stateRememberUpdatedState);
            objRememberedValue3 = composer.rememberedValue();
            if (!zChanged2) {
                objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5

                    /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5$1, reason: invalid class name */
                    /* JADX INFO: compiled from: ExpoComposeView.kt */
                    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                        final /* synthetic */ State $currentHandler;
                        /* synthetic */ Object L$0;
                        Object L$1;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(State state, Continuation continuation) {
                            super(2, continuation);
                            this.$currentHandler = state;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                            return invoke2(objArr, (Continuation<Object>) continuation);
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                            return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object obj2;
                            Object[] objArr = (Object[]) this.L$0;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i != 0) {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            ResultKt.throwOnFailure(obj);
                            if (objArr.length == 0) {
                                obj2 = Unit.INSTANCE;
                            } else {
                                obj2 = objArr[0];
                            }
                            Function2 function2 = (Function2) this.$currentHandler.getValue();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            this.label = 1;
                            Object objInvoke = function2.invoke(obj2, this);
                            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        functionalComposableScope.getView().getFunctionHandlers().put(asyncFunctionHandle.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle asyncFunctionHandle3 = asyncFunctionHandle;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5.2
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                            }
                        };
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5

                    /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5$1, reason: invalid class name */
                    /* JADX INFO: compiled from: ExpoComposeView.kt */
                    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                        final /* synthetic */ State $currentHandler;
                        /* synthetic */ Object L$0;
                        Object L$1;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(State state, Continuation continuation) {
                            super(2, continuation);
                            this.$currentHandler = state;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                            return invoke2(objArr, (Continuation<Object>) continuation);
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                            return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object obj2;
                            Object[] objArr = (Object[]) this.L$0;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i != 0) {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            ResultKt.throwOnFailure(obj);
                            if (objArr.length == 0) {
                                obj2 = Unit.INSTANCE;
                            } else {
                                obj2 = objArr[0];
                            }
                            Function2 function2 = (Function2) this.$currentHandler.getValue();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                            this.label = 1;
                            Object objInvoke = function2.invoke(obj2, this);
                            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        functionalComposableScope.getView().getFunctionHandlers().put(asyncFunctionHandle.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                        final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                        final AsyncFunctionHandle asyncFunctionHandle3 = asyncFunctionHandle;
                        return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5.2
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                            }
                        };
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.DisposableEffect(name6, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            KeyboardOptions keyboardOptions3 = KeyboardOptions.INSTANCE.getDefault();
            if (textFieldKeyboardOptionsRecord != null) {
                keyboardType = textFieldKeyboardOptionsRecord.getKeyboardType();
            } else {
                keyboardType = null;
            }
            int keyboardType4 = toKeyboardType(keyboardType);
            if (textFieldKeyboardOptionsRecord != null) {
                zBooleanValue = true;
            } else {
                zBooleanValue = true;
            }
            if (textFieldKeyboardOptionsRecord != null) {
                capitalization = textFieldKeyboardOptionsRecord.getCapitalization();
            } else {
                capitalization = null;
            }
            int capitalization4 = toCapitalization(capitalization);
            if (textFieldKeyboardOptionsRecord != null) {
                imeAction = textFieldKeyboardOptionsRecord.getImeAction();
            } else {
                imeAction = null;
            }
            KeyboardOptions keyboardOptionsM2890copyINvB4aQ$default3 = KeyboardOptions.m2890copyINvB4aQ$default(keyboardOptions3, capitalization4, Boolean.valueOf(zBooleanValue), keyboardType4, toImeAction(imeAction), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 112, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, -627729966, "CC(remember):TextFieldShared.kt#9igjgp");
            zChangedInstance2 = composer.changedInstance(value);
            objRememberedValue4 = composer.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue4 = new Function0() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$8$lambda$7(value);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function0() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$8$lambda$7(value);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            function0 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627727087, "CC(remember):TextFieldShared.kt#9igjgp");
            int i11 = (i2 & 458752) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            zChanged3 = ((i11 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
            objRememberedValue5 = composer.rememberedValue();
            if (!zChanged3) {
                objRememberedValue5 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$10$lambda$9(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$10$lambda$9(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Function1 function13 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627722611, "CC(remember):TextFieldShared.kt#9igjgp");
            zChanged4 = ((i11 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
            objRememberedValue6 = composer.rememberedValue();
            if (!zChanged4) {
                objRememberedValue6 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$12$lambda$11(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$12$lambda$11(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            Function1 function14 = (Function1) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627718191, "CC(remember):TextFieldShared.kt#9igjgp");
            zChanged5 = ((i11 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
            objRememberedValue7 = composer.rememberedValue();
            if (!zChanged5) {
                objRememberedValue7 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$14$lambda$13(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$14$lambda$13(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            Function1 function15 = (Function1) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627713511, "CC(remember):TextFieldShared.kt#9igjgp");
            zChanged6 = ((i11 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
            objRememberedValue8 = composer.rememberedValue();
            if (!zChanged6) {
                objRememberedValue8 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$16$lambda$15(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$16$lambda$15(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            Function1 function16 = (Function1) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627708651, "CC(remember):TextFieldShared.kt#9igjgp");
            zChanged7 = ((i11 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
            objRememberedValue9 = composer.rememberedValue();
            if (!zChanged7) {
                objRememberedValue9 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$18$lambda$17(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$18$lambda$17(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            Function1 function17 = (Function1) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -627703983, "CC(remember):TextFieldShared.kt#9igjgp");
            zChanged8 = ((i11 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
            objRememberedValue10 = composer.rememberedValue();
            if (!zChanged8) {
                objRememberedValue10 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$20$lambda$19(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            } else {
                objRememberedValue10 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$20$lambda$19(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            KeyboardActions keyboardActions3 = new KeyboardActions(function13, function14, function15, function16, function17, (Function1) objRememberedValue10);
            Modifier modifierFocusRequester3 = FocusRequesterModifierKt.focusRequester(ModifierRegistry.INSTANCE.applyModifiers(modifiers, functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer, ((i >> 18) & 14) | (AppContext.$stable << 3)), focusRequester);
            ComposerKt.sourceInformationMarkerStart(composer, -627693945, "CC(remember):TextFieldShared.kt#9igjgp");
            if (((57344 & i2) ^ 24576) > 16384) {
                function1 = onFocusChange;
                if (!composer.changed(function1)) {
                    z4 = true;
                }
                objRememberedValue11 = composer.rememberedValue();
                if (!z4) {
                    objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierOnFocusChanged5 = FocusChangedModifierKt.onFocusChanged(modifierFocusRequester3, (Function1) objRememberedValue11);
                if (z) {
                    composer.startReplaceGroup(2016426704);
                    ComposerKt.sourceInformation(composer, "246@8444L33,246@8423L54");
                    Unit unit5 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer, -627689805, "CC(remember):TextFieldShared.kt#9igjgp");
                    objRememberedValue13 = composer.rememberedValue();
                    if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue13 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$6$1(focusRequester, null);
                        composer.updateRememberedValue(objRememberedValue13);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    EffectsKt.LaunchedEffect(unit5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue13, composer, 6);
                } else {
                    composer.startReplaceGroup(2008074064);
                }
                composer.endReplaceGroup();
                value2 = value.getValue();
                if (value2 instanceof String) {
                    str = (String) value2;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                str2 = str;
                jExtractSelection = extractSelection(selection, str2.length());
                ComposerKt.sourceInformationMarkerStart(composer, -627684888, "CC(remember):TextFieldShared.kt#9igjgp");
                objRememberedValue12 = composer.rememberedValue();
                if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue12);
                }
                mutableState = (MutableState) objRememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (Intrinsics.areEqual(((TextFieldValue) mutableState.getValue()).getText(), str2)) {
                    mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
                } else {
                    mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
                }
                ComposerKt.sourceInformationMarkerStart(composer, -627676194, "CC(remember):TextFieldShared.kt#9igjgp");
                if (((i & 7168) ^ 3072) > 2048) {
                    num2 = num;
                    if (!composer.changed(num2)) {
                        z5 = true;
                    }
                    boolean zChangedInstance111 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
                    if (((i2 & 7168) ^ 3072) > 2048) {
                        function2 = onValueChanged;
                        if (!composer.changed(function2)) {
                        }
                        zChangedInstance3 = zChangedInstance111 | z6 | composer.changedInstance(workletCallback);
                        Object objRememberedValue218 = composer.rememberedValue();
                        if (zChangedInstance3) {
                            mutableState2 = mutableState;
                            obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                                }
                            };
                            composer.updateRememberedValue(obj);
                        } else {
                            mutableState2 = mutableState;
                            obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                                }
                            };
                            composer.updateRememberedValue(obj);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        TextFieldCore textFieldCore17 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default3, keyboardActions3, modifierOnFocusChanged5);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        return textFieldCore17;
                    }
                    function2 = onValueChanged;
                    if ((i2 & 3072) != 2048) {
                        z6 = false;
                    }
                    zChangedInstance3 = zChangedInstance111 | z6 | composer.changedInstance(workletCallback);
                    Object objRememberedValue219 = composer.rememberedValue();
                    if (zChangedInstance3) {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    } else {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TextFieldCore textFieldCore18 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default3, keyboardActions3, modifierOnFocusChanged5);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return textFieldCore18;
                }
                num2 = num;
                if ((i & 3072) == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean zChangedInstance112 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
                if (((i2 & 7168) ^ 3072) > 2048) {
                    function2 = onValueChanged;
                    if (!composer.changed(function2)) {
                    }
                    zChangedInstance3 = zChangedInstance112 | z6 | composer.changedInstance(workletCallback);
                    Object objRememberedValue2110 = composer.rememberedValue();
                    if (zChangedInstance3) {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    } else {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TextFieldCore textFieldCore19 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default3, keyboardActions3, modifierOnFocusChanged5);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return textFieldCore19;
                }
                function2 = onValueChanged;
                if ((i2 & 3072) != 2048) {
                    z6 = false;
                }
                zChangedInstance3 = zChangedInstance112 | z6 | composer.changedInstance(workletCallback);
                Object objRememberedValue2111 = composer.rememberedValue();
                if (zChangedInstance3) {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                } else {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldCore textFieldCore110 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default3, keyboardActions3, modifierOnFocusChanged5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return textFieldCore110;
            }
            function1 = onFocusChange;
            if ((i2 & 24576) == 16384) {
                z4 = true;
            } else {
                z4 = false;
            }
            objRememberedValue11 = composer.rememberedValue();
            if (!z4) {
                objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            } else {
                objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierOnFocusChanged6 = FocusChangedModifierKt.onFocusChanged(modifierFocusRequester3, (Function1) objRememberedValue11);
            if (z) {
                composer.startReplaceGroup(2016426704);
                ComposerKt.sourceInformation(composer, "246@8444L33,246@8423L54");
                Unit unit6 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -627689805, "CC(remember):TextFieldShared.kt#9igjgp");
                objRememberedValue13 = composer.rememberedValue();
                if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue13 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$6$1(focusRequester, null);
                    composer.updateRememberedValue(objRememberedValue13);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(unit6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue13, composer, 6);
            } else {
                composer.startReplaceGroup(2008074064);
            }
            composer.endReplaceGroup();
            value2 = value.getValue();
            if (value2 instanceof String) {
                str = (String) value2;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            str2 = str;
            jExtractSelection = extractSelection(selection, str2.length());
            ComposerKt.sourceInformationMarkerStart(composer, -627684888, "CC(remember):TextFieldShared.kt#9igjgp");
            objRememberedValue12 = composer.rememberedValue();
            if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                composer.updateRememberedValue(objRememberedValue12);
            }
            mutableState = (MutableState) objRememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (Intrinsics.areEqual(((TextFieldValue) mutableState.getValue()).getText(), str2)) {
                mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
            } else {
                mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
            }
            ComposerKt.sourceInformationMarkerStart(composer, -627676194, "CC(remember):TextFieldShared.kt#9igjgp");
            if (((i & 7168) ^ 3072) > 2048) {
                num2 = num;
                if (!composer.changed(num2)) {
                    z5 = true;
                }
                boolean zChangedInstance113 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
                if (((i2 & 7168) ^ 3072) > 2048) {
                    function2 = onValueChanged;
                    if (!composer.changed(function2)) {
                    }
                    zChangedInstance3 = zChangedInstance113 | z6 | composer.changedInstance(workletCallback);
                    Object objRememberedValue2112 = composer.rememberedValue();
                    if (zChangedInstance3) {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    } else {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TextFieldCore textFieldCore111 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default3, keyboardActions3, modifierOnFocusChanged6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return textFieldCore111;
                }
                function2 = onValueChanged;
                if ((i2 & 3072) != 2048) {
                    z6 = false;
                }
                zChangedInstance3 = zChangedInstance113 | z6 | composer.changedInstance(workletCallback);
                Object objRememberedValue2113 = composer.rememberedValue();
                if (zChangedInstance3) {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                } else {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldCore textFieldCore112 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default3, keyboardActions3, modifierOnFocusChanged6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return textFieldCore112;
            }
            num2 = num;
            if ((i & 3072) == 2048) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean zChangedInstance114 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
            if (((i2 & 7168) ^ 3072) > 2048) {
                function2 = onValueChanged;
                if (!composer.changed(function2)) {
                }
                zChangedInstance3 = zChangedInstance114 | z6 | composer.changedInstance(workletCallback);
                Object objRememberedValue2114 = composer.rememberedValue();
                if (zChangedInstance3) {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                } else {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldCore textFieldCore113 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default3, keyboardActions3, modifierOnFocusChanged6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return textFieldCore113;
            }
            function2 = onValueChanged;
            if ((i2 & 3072) != 2048) {
                z6 = false;
            }
            zChangedInstance3 = zChangedInstance114 | z6 | composer.changedInstance(workletCallback);
            Object objRememberedValue2115 = composer.rememberedValue();
            if (zChangedInstance3) {
                mutableState2 = mutableState;
                obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                mutableState2 = mutableState;
                obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldCore textFieldCore114 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default3, keyboardActions3, modifierOnFocusChanged6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return textFieldCore114;
        }
        asyncFunctionHandle = clear;
        if ((i3 & 6) == 4) {
            z3 = true;
        } else {
            z3 = false;
        }
        zChanged2 = z3 | zChangedInstance110 | composer.changed(stateRememberUpdatedState);
        objRememberedValue3 = composer.rememberedValue();
        if (!zChanged2) {
            objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5

                /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(State state, Continuation continuation) {
                        super(2, continuation);
                        this.$currentHandler = state;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                        return invoke2(objArr, (Continuation<Object>) continuation);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                        return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object obj2;
                        Object[] objArr = (Object[]) this.L$0;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i != 0) {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        ResultKt.throwOnFailure(obj);
                        if (objArr.length == 0) {
                            obj2 = Unit.INSTANCE;
                        } else {
                            obj2 = objArr[0];
                        }
                        Function2 function2 = (Function2) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.label = 1;
                        Object objInvoke = function2.invoke(obj2, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    functionalComposableScope.getView().getFunctionHandlers().put(asyncFunctionHandle.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                    final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                    final AsyncFunctionHandle asyncFunctionHandle3 = asyncFunctionHandle;
                    return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5.2
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        } else {
            objRememberedValue3 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5

                /* JADX INFO: renamed from: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5$1, reason: invalid class name */
                /* JADX INFO: compiled from: ExpoComposeView.kt */
                @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "args", "", "expo/modules/kotlin/views/FunctionalComposableScope$handle$1$1$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "expo.modules.kotlin.views.FunctionalComposableScope$handle$1$1$1", f = "ExpoComposeView.kt", i = {0, 0}, l = {394}, m = "invokeSuspend", n = {"args", "arg"}, s = {"L$0", "L$1"})
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object[], Continuation<? super Object>, Object> {
                    final /* synthetic */ State $currentHandler;
                    /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(State state, Continuation continuation) {
                        super(2, continuation);
                        this.$currentHandler = state;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentHandler, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
                        return invoke2(objArr, (Continuation<Object>) continuation);
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
                        return ((AnonymousClass1) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object obj2;
                        Object[] objArr = (Object[]) this.L$0;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i != 0) {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        ResultKt.throwOnFailure(obj);
                        if (objArr.length == 0) {
                            obj2 = Unit.INSTANCE;
                        } else {
                            obj2 = objArr[0];
                        }
                        Function2 function2 = (Function2) this.$currentHandler.getValue();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.label = 1;
                        Object objInvoke = function2.invoke(obj2, this);
                        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    functionalComposableScope.getView().getFunctionHandlers().put(asyncFunctionHandle.getName(), new AnonymousClass1(stateRememberUpdatedState, null));
                    final FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
                    final AsyncFunctionHandle asyncFunctionHandle3 = asyncFunctionHandle;
                    return new DisposableEffectResult() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$rememberTextFieldCore$$inlined$handle$5.2
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            functionalComposableScope2.getView().getFunctionHandlers().remove(asyncFunctionHandle3.getName());
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(name6, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        KeyboardOptions keyboardOptions4 = KeyboardOptions.INSTANCE.getDefault();
        if (textFieldKeyboardOptionsRecord != null) {
            keyboardType = textFieldKeyboardOptionsRecord.getKeyboardType();
        } else {
            keyboardType = null;
        }
        int keyboardType5 = toKeyboardType(keyboardType);
        if (textFieldKeyboardOptionsRecord != null) {
            zBooleanValue = true;
        } else {
            zBooleanValue = true;
        }
        if (textFieldKeyboardOptionsRecord != null) {
            capitalization = textFieldKeyboardOptionsRecord.getCapitalization();
        } else {
            capitalization = null;
        }
        int capitalization5 = toCapitalization(capitalization);
        if (textFieldKeyboardOptionsRecord != null) {
            imeAction = textFieldKeyboardOptionsRecord.getImeAction();
        } else {
            imeAction = null;
        }
        KeyboardOptions keyboardOptionsM2890copyINvB4aQ$default4 = KeyboardOptions.m2890copyINvB4aQ$default(keyboardOptions4, capitalization5, Boolean.valueOf(zBooleanValue), keyboardType5, toImeAction(imeAction), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 112, (Object) null);
        ComposerKt.sourceInformationMarkerStart(composer, -627729966, "CC(remember):TextFieldShared.kt#9igjgp");
        zChangedInstance2 = composer.changedInstance(value);
        objRememberedValue4 = composer.rememberedValue();
        if (!zChangedInstance2) {
            objRememberedValue4 = new Function0() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$8$lambda$7(value);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        } else {
            objRememberedValue4 = new Function0() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$8$lambda$7(value);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        function0 = (Function0) objRememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -627727087, "CC(remember):TextFieldShared.kt#9igjgp");
        int i12 = (i2 & 458752) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        zChanged3 = ((i12 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
        objRememberedValue5 = composer.rememberedValue();
        if (!zChanged3) {
            objRememberedValue5 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$10$lambda$9(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        } else {
            objRememberedValue5 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$10$lambda$9(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        Function1 function18 = (Function1) objRememberedValue5;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -627722611, "CC(remember):TextFieldShared.kt#9igjgp");
        zChanged4 = ((i12 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
        objRememberedValue6 = composer.rememberedValue();
        if (!zChanged4) {
            objRememberedValue6 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$12$lambda$11(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue6);
        } else {
            objRememberedValue6 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$12$lambda$11(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue6);
        }
        Function1 function19 = (Function1) objRememberedValue6;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -627718191, "CC(remember):TextFieldShared.kt#9igjgp");
        zChanged5 = ((i12 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
        objRememberedValue7 = composer.rememberedValue();
        if (!zChanged5) {
            objRememberedValue7 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$14$lambda$13(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue7);
        } else {
            objRememberedValue7 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$14$lambda$13(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue7);
        }
        Function1 function110 = (Function1) objRememberedValue7;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -627713511, "CC(remember):TextFieldShared.kt#9igjgp");
        zChanged6 = ((i12 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
        objRememberedValue8 = composer.rememberedValue();
        if (!zChanged6) {
            objRememberedValue8 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$16$lambda$15(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue8);
        } else {
            objRememberedValue8 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$16$lambda$15(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue8);
        }
        Function1 function111 = (Function1) objRememberedValue8;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -627708651, "CC(remember):TextFieldShared.kt#9igjgp");
        zChanged7 = ((i12 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
        objRememberedValue9 = composer.rememberedValue();
        if (!zChanged7) {
            objRememberedValue9 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$18$lambda$17(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue9);
        } else {
            objRememberedValue9 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$18$lambda$17(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue9);
        }
        Function1 function112 = (Function1) objRememberedValue9;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -627703983, "CC(remember):TextFieldShared.kt#9igjgp");
        zChanged8 = ((i12 <= 131072 && composer.changed(onKeyboardActionTriggered)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changed(function0);
        objRememberedValue10 = composer.rememberedValue();
        if (!zChanged8) {
            objRememberedValue10 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$20$lambda$19(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue10);
        } else {
            objRememberedValue10 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$20$lambda$19(onKeyboardActionTriggered, function0, (KeyboardActionScope) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue10);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        KeyboardActions keyboardActions4 = new KeyboardActions(function18, function19, function110, function111, function112, (Function1) objRememberedValue10);
        Modifier modifierFocusRequester4 = FocusRequesterModifierKt.focusRequester(ModifierRegistry.INSTANCE.applyModifiers(modifiers, functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer, ((i >> 18) & 14) | (AppContext.$stable << 3)), focusRequester);
        ComposerKt.sourceInformationMarkerStart(composer, -627693945, "CC(remember):TextFieldShared.kt#9igjgp");
        if (((57344 & i2) ^ 24576) > 16384) {
            function1 = onFocusChange;
            if (!composer.changed(function1)) {
                z4 = true;
            }
            objRememberedValue11 = composer.rememberedValue();
            if (!z4) {
                objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            } else {
                objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierOnFocusChanged7 = FocusChangedModifierKt.onFocusChanged(modifierFocusRequester4, (Function1) objRememberedValue11);
            if (z) {
                composer.startReplaceGroup(2016426704);
                ComposerKt.sourceInformation(composer, "246@8444L33,246@8423L54");
                Unit unit7 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -627689805, "CC(remember):TextFieldShared.kt#9igjgp");
                objRememberedValue13 = composer.rememberedValue();
                if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue13 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$6$1(focusRequester, null);
                    composer.updateRememberedValue(objRememberedValue13);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(unit7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue13, composer, 6);
            } else {
                composer.startReplaceGroup(2008074064);
            }
            composer.endReplaceGroup();
            value2 = value.getValue();
            if (value2 instanceof String) {
                str = (String) value2;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            str2 = str;
            jExtractSelection = extractSelection(selection, str2.length());
            ComposerKt.sourceInformationMarkerStart(composer, -627684888, "CC(remember):TextFieldShared.kt#9igjgp");
            objRememberedValue12 = composer.rememberedValue();
            if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                composer.updateRememberedValue(objRememberedValue12);
            }
            mutableState = (MutableState) objRememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (Intrinsics.areEqual(((TextFieldValue) mutableState.getValue()).getText(), str2)) {
                mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
            } else {
                mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
            }
            ComposerKt.sourceInformationMarkerStart(composer, -627676194, "CC(remember):TextFieldShared.kt#9igjgp");
            if (((i & 7168) ^ 3072) > 2048) {
                num2 = num;
                if (!composer.changed(num2)) {
                    z5 = true;
                }
                boolean zChangedInstance115 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
                if (((i2 & 7168) ^ 3072) > 2048) {
                    function2 = onValueChanged;
                    if (!composer.changed(function2)) {
                    }
                    zChangedInstance3 = zChangedInstance115 | z6 | composer.changedInstance(workletCallback);
                    Object objRememberedValue2116 = composer.rememberedValue();
                    if (zChangedInstance3) {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    } else {
                        mutableState2 = mutableState;
                        obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                            }
                        };
                        composer.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TextFieldCore textFieldCore115 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default4, keyboardActions4, modifierOnFocusChanged7);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return textFieldCore115;
                }
                function2 = onValueChanged;
                if ((i2 & 3072) != 2048) {
                    z6 = false;
                }
                zChangedInstance3 = zChangedInstance115 | z6 | composer.changedInstance(workletCallback);
                Object objRememberedValue2117 = composer.rememberedValue();
                if (zChangedInstance3) {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                } else {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldCore textFieldCore116 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default4, keyboardActions4, modifierOnFocusChanged7);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return textFieldCore116;
            }
            num2 = num;
            if ((i & 3072) == 2048) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean zChangedInstance116 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
            if (((i2 & 7168) ^ 3072) > 2048) {
                function2 = onValueChanged;
                if (!composer.changed(function2)) {
                }
                zChangedInstance3 = zChangedInstance116 | z6 | composer.changedInstance(workletCallback);
                Object objRememberedValue2118 = composer.rememberedValue();
                if (zChangedInstance3) {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                } else {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldCore textFieldCore117 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default4, keyboardActions4, modifierOnFocusChanged7);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return textFieldCore117;
            }
            function2 = onValueChanged;
            if ((i2 & 3072) != 2048) {
                z6 = false;
            }
            zChangedInstance3 = zChangedInstance116 | z6 | composer.changedInstance(workletCallback);
            Object objRememberedValue2119 = composer.rememberedValue();
            if (zChangedInstance3) {
                mutableState2 = mutableState;
                obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                mutableState2 = mutableState;
                obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldCore textFieldCore118 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default4, keyboardActions4, modifierOnFocusChanged7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return textFieldCore118;
        }
        function1 = onFocusChange;
        if ((i2 & 24576) == 16384) {
            z4 = true;
        } else {
            z4 = false;
        }
        objRememberedValue11 = composer.rememberedValue();
        if (!z4) {
            objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue11);
        } else {
            objRememberedValue11 = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$22$lambda$21(function1, (FocusState) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue11);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierOnFocusChanged8 = FocusChangedModifierKt.onFocusChanged(modifierFocusRequester4, (Function1) objRememberedValue11);
        if (z) {
            composer.startReplaceGroup(2016426704);
            ComposerKt.sourceInformation(composer, "246@8444L33,246@8423L54");
            Unit unit8 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -627689805, "CC(remember):TextFieldShared.kt#9igjgp");
            objRememberedValue13 = composer.rememberedValue();
            if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue13 = (Function2) new TextFieldSharedKt$rememberTextFieldCore$6$1(focusRequester, null);
                composer.updateRememberedValue(objRememberedValue13);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(unit8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue13, composer, 6);
        } else {
            composer.startReplaceGroup(2008074064);
        }
        composer.endReplaceGroup();
        value2 = value.getValue();
        if (value2 instanceof String) {
            str = (String) value2;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        str2 = str;
        jExtractSelection = extractSelection(selection, str2.length());
        ComposerKt.sourceInformationMarkerStart(composer, -627684888, "CC(remember):TextFieldShared.kt#9igjgp");
        objRememberedValue12 = composer.rememberedValue();
        if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
            composer.updateRememberedValue(objRememberedValue12);
        }
        mutableState = (MutableState) objRememberedValue12;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (Intrinsics.areEqual(((TextFieldValue) mutableState.getValue()).getText(), str2)) {
            mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
        } else {
            mutableState.setValue(new TextFieldValue(str2, jExtractSelection, (TextRange) null, 4, (DefaultConstructorMarker) null));
        }
        ComposerKt.sourceInformationMarkerStart(composer, -627676194, "CC(remember):TextFieldShared.kt#9igjgp");
        if (((i & 7168) ^ 3072) > 2048) {
            num2 = num;
            if (!composer.changed(num2)) {
                z5 = true;
            }
            boolean zChangedInstance117 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
            if (((i2 & 7168) ^ 3072) > 2048) {
                function2 = onValueChanged;
                if (!composer.changed(function2)) {
                }
                zChangedInstance3 = zChangedInstance117 | z6 | composer.changedInstance(workletCallback);
                Object objRememberedValue21110 = composer.rememberedValue();
                if (zChangedInstance3) {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                } else {
                    mutableState2 = mutableState;
                    obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldCore textFieldCore119 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default4, keyboardActions4, modifierOnFocusChanged8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return textFieldCore119;
            }
            function2 = onValueChanged;
            if ((i2 & 3072) != 2048) {
                z6 = false;
            }
            zChangedInstance3 = zChangedInstance117 | z6 | composer.changedInstance(workletCallback);
            Object objRememberedValue21111 = composer.rememberedValue();
            if (zChangedInstance3) {
                mutableState2 = mutableState;
                obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                mutableState2 = mutableState;
                obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldCore textFieldCore1110 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default4, keyboardActions4, modifierOnFocusChanged8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return textFieldCore1110;
        }
        num2 = num;
        if ((i & 3072) == 2048) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean zChangedInstance118 = z5 | composer.changedInstance(selection) | ((((i2 & 3670016) ^ 1572864) <= 1048576 && composer.changed(onSelectionChanged)) || (i2 & 1572864) == 1048576) | composer.changedInstance(value);
        if (((i2 & 7168) ^ 3072) > 2048) {
            function2 = onValueChanged;
            if (!composer.changed(function2)) {
            }
            zChangedInstance3 = zChangedInstance118 | z6 | composer.changedInstance(workletCallback);
            Object objRememberedValue21112 = composer.rememberedValue();
            if (zChangedInstance3) {
                mutableState2 = mutableState;
                obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                mutableState2 = mutableState;
                obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldCore textFieldCore1111 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default4, keyboardActions4, modifierOnFocusChanged8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return textFieldCore1111;
        }
        function2 = onValueChanged;
        if ((i2 & 3072) != 2048) {
            z6 = false;
        }
        zChangedInstance3 = zChangedInstance118 | z6 | composer.changedInstance(workletCallback);
        Object objRememberedValue21113 = composer.rememberedValue();
        if (zChangedInstance3) {
            mutableState2 = mutableState;
            obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                }
            };
            composer.updateRememberedValue(obj);
        } else {
            mutableState2 = mutableState;
            obj = new Function1() { // from class: expo.modules.ui.textfield.TextFieldSharedKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return TextFieldSharedKt.rememberTextFieldCore$lambda$27$lambda$26(num2, mutableState2, selection, onSelectionChanged, value, function2, workletCallback, (TextFieldValue) obj2);
                }
            };
            composer.updateRememberedValue(obj);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextFieldCore textFieldCore1112 = new TextFieldCore((TextFieldValue) mutableState2.getValue(), (Function1) obj, keyboardOptionsM2890copyINvB4aQ$default4, keyboardActions4, modifierOnFocusChanged8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldCore1112;
    }

    static final String rememberTextFieldCore$lambda$8$lambda$7(ObservableState observableState) {
        Object value = observableState.getValue();
        String str = value instanceof String ? (String) value : null;
        return str == null ? "" : str;
    }

    static final Unit rememberTextFieldCore$lambda$10$lambda$9(Function1 function1, Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        KeyboardActions.mo2887defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m9798getDoneeUduSuo());
        function1.invoke(new KeyboardActionEvent("done", (String) function0.invoke()));
        return Unit.INSTANCE;
    }

    static final Unit rememberTextFieldCore$lambda$12$lambda$11(Function1 function1, Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        KeyboardActions.mo2887defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m9799getGoeUduSuo());
        function1.invoke(new KeyboardActionEvent("go", (String) function0.invoke()));
        return Unit.INSTANCE;
    }

    static final Unit rememberTextFieldCore$lambda$14$lambda$13(Function1 function1, Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        KeyboardActions.mo2887defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m9800getNexteUduSuo());
        function1.invoke(new KeyboardActionEvent(LinkHeader.Rel.Next, (String) function0.invoke()));
        return Unit.INSTANCE;
    }

    static final Unit rememberTextFieldCore$lambda$16$lambda$15(Function1 function1, Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        KeyboardActions.mo2887defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m9802getPreviouseUduSuo());
        function1.invoke(new KeyboardActionEvent("previous", (String) function0.invoke()));
        return Unit.INSTANCE;
    }

    static final Unit rememberTextFieldCore$lambda$18$lambda$17(Function1 function1, Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        KeyboardActions.mo2887defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m9803getSearcheUduSuo());
        function1.invoke(new KeyboardActionEvent("search", (String) function0.invoke()));
        return Unit.INSTANCE;
    }

    static final Unit rememberTextFieldCore$lambda$20$lambda$19(Function1 function1, Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        KeyboardActions.mo2887defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m9804getSendeUduSuo());
        function1.invoke(new KeyboardActionEvent("send", (String) function0.invoke()));
        return Unit.INSTANCE;
    }

    static final Unit rememberTextFieldCore$lambda$22$lambda$21(Function1 function1, FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        function1.invoke(new GenericEventPayload1(Boolean.valueOf(focusState.isFocused())));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:9:0x0051  */
    static final Unit rememberTextFieldCore$lambda$27$lambda$26(Integer num, MutableState mutableState, ObservableState observableState, Function1 function1, ObservableState observableState2, Function1 function2, WorkletCallback workletCallback, TextFieldValue incoming) {
        TextFieldValue textFieldValueM9862copy3r_uNRQ$default;
        Intrinsics.checkNotNullParameter(incoming, "incoming");
        if (num == null) {
            textFieldValueM9862copy3r_uNRQ$default = incoming;
        } else {
            int iIntValue = num.intValue();
            if (incoming.getText().length() > iIntValue) {
                String strSubstring = incoming.getText().substring(0, iIntValue);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                textFieldValueM9862copy3r_uNRQ$default = TextFieldValue.m9862copy3r_uNRQ$default(incoming, strSubstring, TextRangeKt.TextRange(RangesKt.coerceAtMost(TextRange.m9598getStartimpl(incoming.getSelection()), iIntValue), RangesKt.coerceAtMost(TextRange.m9593getEndimpl(incoming.getSelection()), iIntValue)), (TextRange) null, 4, (Object) null);
            } else {
                textFieldValueM9862copy3r_uNRQ$default = null;
            }
            if (textFieldValueM9862copy3r_uNRQ$default == null) {
                textFieldValueM9862copy3r_uNRQ$default = incoming;
            }
        }
        TextFieldValue textFieldValue = (TextFieldValue) mutableState.getValue();
        mutableState.setValue(textFieldValueM9862copy3r_uNRQ$default);
        if (!TextRange.m9591equalsimpl0(textFieldValueM9862copy3r_uNRQ$default.getSelection(), textFieldValue.getSelection())) {
            Object value = observableState.getValue();
            Map map = value instanceof Map ? (Map) value : null;
            Object obj = map != null ? map.get(ViewProps.START) : null;
            Number number = obj instanceof Number ? (Number) obj : null;
            Integer numValueOf = number != null ? Integer.valueOf(number.intValue()) : null;
            Object obj2 = map != null ? map.get(ViewProps.END) : null;
            Number number2 = obj2 instanceof Number ? (Number) obj2 : null;
            Integer numValueOf2 = number2 != null ? Integer.valueOf(number2.intValue()) : null;
            int iM9598getStartimpl = TextRange.m9598getStartimpl(textFieldValueM9862copy3r_uNRQ$default.getSelection());
            if (numValueOf != null && numValueOf.intValue() == iM9598getStartimpl) {
                int iM9593getEndimpl = TextRange.m9593getEndimpl(textFieldValueM9862copy3r_uNRQ$default.getSelection());
                if (numValueOf2 == null || numValueOf2.intValue() != iM9593getEndimpl) {
                    observableState.setValue(MapsKt.mapOf(TuplesKt.to(ViewProps.START, Integer.valueOf(TextRange.m9598getStartimpl(textFieldValueM9862copy3r_uNRQ$default.getSelection()))), TuplesKt.to(ViewProps.END, Integer.valueOf(TextRange.m9593getEndimpl(textFieldValueM9862copy3r_uNRQ$default.getSelection())))));
                }
            } else {
                observableState.setValue(MapsKt.mapOf(TuplesKt.to(ViewProps.START, Integer.valueOf(TextRange.m9598getStartimpl(textFieldValueM9862copy3r_uNRQ$default.getSelection()))), TuplesKt.to(ViewProps.END, Integer.valueOf(TextRange.m9593getEndimpl(textFieldValueM9862copy3r_uNRQ$default.getSelection())))));
            }
            function1.invoke(new TextFieldSelectionPayload(TextRange.m9598getStartimpl(textFieldValueM9862copy3r_uNRQ$default.getSelection()), TextRange.m9593getEndimpl(textFieldValueM9862copy3r_uNRQ$default.getSelection())));
        }
        if (!Intrinsics.areEqual(textFieldValueM9862copy3r_uNRQ$default.getText(), textFieldValue.getText())) {
            observableState2.setValue(textFieldValueM9862copy3r_uNRQ$default.getText());
            function2.invoke(new TextFieldValuePayload(textFieldValueM9862copy3r_uNRQ$default.getText(), new TextFieldSelectionPayload(TextRange.m9598getStartimpl(textFieldValueM9862copy3r_uNRQ$default.getSelection()), TextRange.m9593getEndimpl(textFieldValueM9862copy3r_uNRQ$default.getSelection()))));
            if (workletCallback != null) {
                workletCallback.invoke(textFieldValueM9862copy3r_uNRQ$default.getText());
            }
        }
        return Unit.INSTANCE;
    }
}
