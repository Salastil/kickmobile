package expo.modules.ui;

import android.content.Context;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.common.C;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.trace.internal.domain.event.SpanEventSerializer;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.common.assets.ReactFontManager;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\u0019\u0010\f\u001a\u00020\u0007*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"resolveFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "name", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "appendSpans", "", "Landroidx/compose/ui/text/AnnotatedString$Builder;", SpanEventSerializer.TAG_SPANS, "", "Lexpo/modules/ui/TextSpanRecord;", "TextContent", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/TextProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/TextProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TextViewKt {
    static final Unit TextContent$lambda$5(FunctionalComposableScope functionalComposableScope, TextProps textProps, int i, Composer composer, int i2) {
        TextContent(functionalComposableScope, textProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final FontFamily resolveFontFamily(String str, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case -1431958525:
                if (str.equals("monospace")) {
                    return FontFamily.INSTANCE.getMonospace();
                }
                break;
            case 109326717:
                if (str.equals(C.SERIF_NAME)) {
                    return FontFamily.INSTANCE.getSerif();
                }
                break;
            case 1126973893:
                if (str.equals("cursive")) {
                    return FontFamily.INSTANCE.getCursive();
                }
                break;
            case 1544803905:
                if (str.equals(Constants.COLLATION_DEFAULT)) {
                    return FontFamily.INSTANCE.getDefault();
                }
                break;
            case 2063328426:
                if (str.equals("sansSerif")) {
                    return FontFamily.INSTANCE.getSansSerif();
                }
                break;
        }
        return AndroidTypeface_androidKt.FontFamily(ReactFontManager.INSTANCE.getInstance().getTypeface(str, 0, context.getAssets()));
    }

    private static final void appendSpans(AnnotatedString.Builder builder, List<TextSpanRecord> list, Context context) {
        for (TextSpanRecord textSpanRecord : list) {
            Color colorColorToComposeColorOrNull = UtilsKt.colorToComposeColorOrNull(textSpanRecord.getColor());
            long jM7348unboximpl = colorColorToComposeColorOrNull != null ? colorColorToComposeColorOrNull.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Float fontSize = textSpanRecord.getFontSize();
            long sp = fontSize != null ? TextUnitKt.getSp(fontSize.floatValue()) : TextUnit.INSTANCE.m10373getUnspecifiedXSAIIZE();
            TextFontWeight fontWeight = textSpanRecord.getFontWeight();
            FontWeight composeFontWeight = fontWeight != null ? fontWeight.toComposeFontWeight() : null;
            TextFontStyle fontStyle = textSpanRecord.getFontStyle();
            FontStyle fontStyleM9725boximpl = fontStyle != null ? FontStyle.m9725boximpl(fontStyle.m12128toComposeFontStyle_LCdwA()) : null;
            FontFamily fontFamilyResolveFontFamily = context != null ? resolveFontFamily(textSpanRecord.getFontFamily(), context) : null;
            TextDecorationType textDecoration = textSpanRecord.getTextDecoration();
            TextDecoration composeTextDecoration = textDecoration != null ? textDecoration.toComposeTextDecoration() : null;
            Float letterSpacing = textSpanRecord.getLetterSpacing();
            long sp2 = letterSpacing != null ? TextUnitKt.getSp(letterSpacing.floatValue()) : TextUnit.INSTANCE.m10373getUnspecifiedXSAIIZE();
            Color colorColorToComposeColorOrNull2 = UtilsKt.colorToComposeColorOrNull(textSpanRecord.getBackground());
            long jM7348unboximpl2 = colorColorToComposeColorOrNull2 != null ? colorColorToComposeColorOrNull2.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            TextShadowRecord shadow = textSpanRecord.getShadow();
            SpanStyle spanStyle = new SpanStyle(jM7348unboximpl, sp, composeFontWeight, fontStyleM9725boximpl, (FontSynthesis) null, fontFamilyResolveFontFamily, (String) null, sp2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, jM7348unboximpl2, composeTextDecoration, shadow != null ? shadow.toComposeShadow() : null, (PlatformSpanStyle) null, (DrawStyle) null, 51024, (DefaultConstructorMarker) null);
            if (textSpanRecord.getChildren() != null) {
                int iPushStyle = builder.pushStyle(spanStyle);
                try {
                    appendSpans(builder, textSpanRecord.getChildren(), context);
                    Unit unit = Unit.INSTANCE;
                    builder.pop(iPushStyle);
                } catch (Throwable th) {
                    builder.pop(iPushStyle);
                    throw th;
                }
            } else {
                int iPushStyle2 = builder.pushStyle(spanStyle);
                try {
                    builder.append(textSpanRecord.getText());
                    Unit unit2 = Unit.INSTANCE;
                    builder.pop(iPushStyle2);
                } catch (Throwable th2) {
                    builder.pop(iPushStyle2);
                    throw th2;
                }
            }
        }
    }

    public static final void TextContent(final FunctionalComposableScope functionalComposableScope, final TextProps props, Composer composer, final int i) {
        int i2;
        TextStyle textStyle;
        AnnotatedString annotatedString;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2106325346);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextContent)N(props)312@10327L83,323@10622L335:TextView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2106325346, i2, -1, "expo.modules.ui.TextContent (TextView.kt:291)");
            }
            TypographyStyle typography = props.getTypography();
            if (typography == null) {
                composerStartRestartGroup.startReplaceGroup(-66011146);
                composerStartRestartGroup.endReplaceGroup();
                textStyle = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1249055381);
                ComposerKt.sourceInformation(composerStartRestartGroup, "293@9273L13");
                textStyle = typography.toTextStyle(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (textStyle == null) {
                textStyle = TextStyle.INSTANCE.getDefault();
            }
            long jColorToComposeColor = UtilsKt.colorToComposeColor(props.getColor());
            Float fontSize = props.getFontSize();
            long sp = fontSize != null ? TextUnitKt.getSp(fontSize.floatValue()) : TextUnit.INSTANCE.m10373getUnspecifiedXSAIIZE();
            TextFontWeight fontWeight = props.getFontWeight();
            FontWeight composeFontWeight = fontWeight != null ? fontWeight.toComposeFontWeight() : null;
            TextFontStyle fontStyle = props.getFontStyle();
            FontStyle fontStyleM9725boximpl = fontStyle != null ? FontStyle.m9725boximpl(fontStyle.m12128toComposeFontStyle_LCdwA()) : null;
            Context reactContext = functionalComposableScope.getAppContext().getReactContext();
            FontFamily fontFamilyResolveFontFamily = reactContext != null ? resolveFontFamily(props.getFontFamily(), reactContext) : null;
            TextDecorationType textDecoration = props.getTextDecoration();
            TextDecoration composeTextDecoration = textDecoration != null ? textDecoration.toComposeTextDecoration() : null;
            Float letterSpacing = props.getLetterSpacing();
            long sp2 = letterSpacing != null ? TextUnitKt.getSp(letterSpacing.floatValue()) : TextUnit.INSTANCE.m10373getUnspecifiedXSAIIZE();
            Float lineHeight = props.getLineHeight();
            long sp3 = lineHeight != null ? TextUnitKt.getSp(lineHeight.floatValue()) : TextUnit.INSTANCE.m10373getUnspecifiedXSAIIZE();
            TextLineBreakType lineBreak = props.getLineBreak();
            int iM12129toComposeLineBreakrAG3T2k = lineBreak != null ? lineBreak.m12129toComposeLineBreakrAG3T2k() : LineBreak.INSTANCE.m9964getUnspecifiedrAG3T2k();
            Color colorColorToComposeColorOrNull = UtilsKt.colorToComposeColorOrNull(props.getBackground());
            long jM7348unboximpl = colorColorToComposeColorOrNull != null ? colorColorToComposeColorOrNull.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            TextShadowRecord shadow = props.getShadow();
            TextStyle textStyleMerge = textStyle.merge(new TextStyle(jColorToComposeColor, sp, composeFontWeight, fontStyleM9725boximpl, (FontSynthesis) null, fontFamilyResolveFontFamily, (String) null, sp2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, jM7348unboximpl, composeTextDecoration, shadow != null ? shadow.toComposeShadow() : null, (DrawStyle) null, 0, 0, sp3, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, iM12129toComposeLineBreakrAG3T2k, 0, (TextMotion) null, 14534480, (DefaultConstructorMarker) null));
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            if (props.getSpans() != null) {
                Context reactContext2 = functionalComposableScope.getAppContext().getReactContext();
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                appendSpans(builder, props.getSpans(), reactContext2);
                annotatedString = builder.toAnnotatedString();
            } else {
                annotatedString = new AnnotatedString(props.getText(), null, 2, null);
            }
            AnnotatedString annotatedString2 = annotatedString;
            TextAlignType textAlign = props.getTextAlign();
            TextAlign textAlignM10039boximpl = textAlign != null ? TextAlign.m10039boximpl(textAlign.m12127toComposeTextAligne0LSkKk()) : null;
            TextOverflowType overflow = props.getOverflow();
            int iM12130toComposeTextOverflowgIe3tQ8 = overflow != null ? overflow.m12130toComposeTextOverflowgIe3tQ8() : TextOverflow.INSTANCE.m10103getClipgIe3tQ8();
            Boolean softWrap = props.getSoftWrap();
            boolean zBooleanValue = softWrap != null ? softWrap.booleanValue() : true;
            Integer maxLines = props.getMaxLines();
            int iIntValue = maxLines != null ? maxLines.intValue() : Integer.MAX_VALUE;
            Integer minLines = props.getMinLines();
            TextKt.m4930TextZ58ophY(annotatedString2, modifierApplyModifiers, 0L, null, 0L, null, null, null, 0L, null, textAlignM10039boximpl, 0L, iM12130toComposeTextOverflowgIe3tQ8, zBooleanValue, iIntValue, minLines != null ? minLines.intValue() : 1, null, null, textStyleMerge, composerStartRestartGroup, 0, 0, 199676);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.TextViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextViewKt.TextContent$lambda$5(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
