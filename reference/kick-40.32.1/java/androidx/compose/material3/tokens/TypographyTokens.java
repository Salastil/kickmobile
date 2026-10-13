package androidx.compose.material3.tokens;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.GenericFontFamily;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TypographyTokens.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b=\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0011\u0010\u001e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0011\u0010 \u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000bR\u0011\u0010\"\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0011\u0010$\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000bR\u0011\u0010&\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000bR\u0011\u0010(\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000bR\u0011\u0010*\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000bR\u0011\u0010,\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000bR\u0011\u0010.\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000bR\u0011\u00100\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u000bR\u0011\u00102\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u000bR\u0011\u00104\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u000bR\u0011\u00106\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u000bR\u0011\u00108\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u000bR\u0011\u0010:\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u000bR\u0011\u0010<\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000bR\u0011\u0010>\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u000bR\u0011\u0010@\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u000bR\u0011\u0010B\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000bR\u0011\u0010D\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u000b¨\u0006F"}, d2 = {"Landroidx/compose/material3/tokens/TypographyTokens;", "", ViewProps.FONT_FAMILY, "Landroidx/compose/ui/text/font/FontFamily;", "<init>", "(Landroidx/compose/ui/text/font/FontFamily;)V", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "BodyLarge", "Landroidx/compose/ui/text/TextStyle;", "getBodyLarge", "()Landroidx/compose/ui/text/TextStyle;", "BodyMedium", "getBodyMedium", "BodySmall", "getBodySmall", "DisplayLarge", "getDisplayLarge", "DisplayMedium", "getDisplayMedium", "DisplaySmall", "getDisplaySmall", "HeadlineLarge", "getHeadlineLarge", "HeadlineMedium", "getHeadlineMedium", "HeadlineSmall", "getHeadlineSmall", "LabelLarge", "getLabelLarge", "LabelMedium", "getLabelMedium", "LabelSmall", "getLabelSmall", "TitleLarge", "getTitleLarge", "TitleMedium", "getTitleMedium", "TitleSmall", "getTitleSmall", "BodyLargeEmphasized", "getBodyLargeEmphasized", "BodyMediumEmphasized", "getBodyMediumEmphasized", "BodySmallEmphasized", "getBodySmallEmphasized", "DisplayLargeEmphasized", "getDisplayLargeEmphasized", "DisplayMediumEmphasized", "getDisplayMediumEmphasized", "DisplaySmallEmphasized", "getDisplaySmallEmphasized", "HeadlineLargeEmphasized", "getHeadlineLargeEmphasized", "HeadlineMediumEmphasized", "getHeadlineMediumEmphasized", "HeadlineSmallEmphasized", "getHeadlineSmallEmphasized", "LabelLargeEmphasized", "getLabelLargeEmphasized", "LabelMediumEmphasized", "getLabelMediumEmphasized", "LabelSmallEmphasized", "getLabelSmallEmphasized", "TitleLargeEmphasized", "getTitleLargeEmphasized", "TitleMediumEmphasized", "getTitleMediumEmphasized", "TitleSmallEmphasized", "getTitleSmallEmphasized", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TypographyTokens {
    public static final int $stable = 0;
    private final TextStyle BodyLarge;
    private final TextStyle BodyLargeEmphasized;
    private final TextStyle BodyMedium;
    private final TextStyle BodyMediumEmphasized;
    private final TextStyle BodySmall;
    private final TextStyle BodySmallEmphasized;
    private final TextStyle DisplayLarge;
    private final TextStyle DisplayLargeEmphasized;
    private final TextStyle DisplayMedium;
    private final TextStyle DisplayMediumEmphasized;
    private final TextStyle DisplaySmall;
    private final TextStyle DisplaySmallEmphasized;
    private final TextStyle HeadlineLarge;
    private final TextStyle HeadlineLargeEmphasized;
    private final TextStyle HeadlineMedium;
    private final TextStyle HeadlineMediumEmphasized;
    private final TextStyle HeadlineSmall;
    private final TextStyle HeadlineSmallEmphasized;
    private final TextStyle LabelLarge;
    private final TextStyle LabelLargeEmphasized;
    private final TextStyle LabelMedium;
    private final TextStyle LabelMediumEmphasized;
    private final TextStyle LabelSmall;
    private final TextStyle LabelSmallEmphasized;
    private final TextStyle TitleLarge;
    private final TextStyle TitleLargeEmphasized;
    private final TextStyle TitleMedium;
    private final TextStyle TitleMediumEmphasized;
    private final TextStyle TitleSmall;
    private final TextStyle TitleSmallEmphasized;
    private final FontFamily fontFamily;

    /* JADX WARN: Multi-variable type inference failed */
    public TypographyTokens() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TypographyTokens(FontFamily fontFamily) {
        GenericFontFamily genericFontFamily = fontFamily;
        this.fontFamily = genericFontFamily;
        TextStyle defaultTextStyle = TypographyTokensKt.getDefaultTextStyle();
        FontFamily bodyLargeFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getBodyLargeFont() : genericFontFamily;
        this.BodyLarge = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle, 0L, TypeScaleTokens.INSTANCE.m6284getBodyLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyLargeWeight(), null, null, bodyLargeFont, null, TypeScaleTokens.INSTANCE.m6285getBodyLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6283getBodyLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle2 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily bodyMediumFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getBodyMediumFont() : genericFontFamily;
        this.BodyMedium = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle2, 0L, TypeScaleTokens.INSTANCE.m6290getBodyMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyMediumWeight(), null, null, bodyMediumFont, null, TypeScaleTokens.INSTANCE.m6291getBodyMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6289getBodyMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle3 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily bodySmallFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getBodySmallFont() : genericFontFamily;
        this.BodySmall = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle3, 0L, TypeScaleTokens.INSTANCE.m6296getBodySmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodySmallWeight(), null, null, bodySmallFont, null, TypeScaleTokens.INSTANCE.m6297getBodySmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6295getBodySmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle4 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily displayLargeFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getDisplayLargeFont() : genericFontFamily;
        this.DisplayLarge = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle4, 0L, TypeScaleTokens.INSTANCE.m6302getDisplayLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayLargeWeight(), null, null, displayLargeFont, null, TypeScaleTokens.INSTANCE.m6303getDisplayLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6301getDisplayLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle5 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily displayMediumFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getDisplayMediumFont() : genericFontFamily;
        this.DisplayMedium = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle5, 0L, TypeScaleTokens.INSTANCE.m6308getDisplayMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayMediumWeight(), null, null, displayMediumFont, null, TypeScaleTokens.INSTANCE.m6309getDisplayMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6307getDisplayMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle6 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily displaySmallFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getDisplaySmallFont() : genericFontFamily;
        this.DisplaySmall = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle6, 0L, TypeScaleTokens.INSTANCE.m6314getDisplaySmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplaySmallWeight(), null, null, displaySmallFont, null, TypeScaleTokens.INSTANCE.m6315getDisplaySmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6313getDisplaySmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle7 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily headlineLargeFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getHeadlineLargeFont() : genericFontFamily;
        this.HeadlineLarge = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle7, 0L, TypeScaleTokens.INSTANCE.m6320getHeadlineLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineLargeWeight(), null, null, headlineLargeFont, null, TypeScaleTokens.INSTANCE.m6321getHeadlineLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6319getHeadlineLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle8 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily headlineMediumFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getHeadlineMediumFont() : genericFontFamily;
        this.HeadlineMedium = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle8, 0L, TypeScaleTokens.INSTANCE.m6326getHeadlineMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineMediumWeight(), null, null, headlineMediumFont, null, TypeScaleTokens.INSTANCE.m6327getHeadlineMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6325getHeadlineMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle9 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily headlineSmallFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getHeadlineSmallFont() : genericFontFamily;
        this.HeadlineSmall = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle9, 0L, TypeScaleTokens.INSTANCE.m6332getHeadlineSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineSmallWeight(), null, null, headlineSmallFont, null, TypeScaleTokens.INSTANCE.m6333getHeadlineSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6331getHeadlineSmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle10 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily labelLargeFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getLabelLargeFont() : genericFontFamily;
        this.LabelLarge = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle10, 0L, TypeScaleTokens.INSTANCE.m6338getLabelLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelLargeWeight(), null, null, labelLargeFont, null, TypeScaleTokens.INSTANCE.m6339getLabelLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6337getLabelLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle11 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily labelMediumFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getLabelMediumFont() : genericFontFamily;
        this.LabelMedium = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle11, 0L, TypeScaleTokens.INSTANCE.m6344getLabelMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelMediumWeight(), null, null, labelMediumFont, null, TypeScaleTokens.INSTANCE.m6345getLabelMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6343getLabelMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle12 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily labelSmallFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getLabelSmallFont() : genericFontFamily;
        this.LabelSmall = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle12, 0L, TypeScaleTokens.INSTANCE.m6350getLabelSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelSmallWeight(), null, null, labelSmallFont, null, TypeScaleTokens.INSTANCE.m6351getLabelSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6349getLabelSmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle13 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily titleLargeFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getTitleLargeFont() : genericFontFamily;
        this.TitleLarge = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle13, 0L, TypeScaleTokens.INSTANCE.m6356getTitleLargeSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleLargeWeight(), null, null, titleLargeFont, null, TypeScaleTokens.INSTANCE.m6357getTitleLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6355getTitleLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle14 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily titleMediumFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getTitleMediumFont() : genericFontFamily;
        this.TitleMedium = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle14, 0L, TypeScaleTokens.INSTANCE.m6362getTitleMediumSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleMediumWeight(), null, null, titleMediumFont, null, TypeScaleTokens.INSTANCE.m6363getTitleMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6361getTitleMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle15 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily titleSmallFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getTitleSmallFont() : genericFontFamily;
        this.TitleSmall = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle15, 0L, TypeScaleTokens.INSTANCE.m6368getTitleSmallSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleSmallWeight(), null, null, titleSmallFont, null, TypeScaleTokens.INSTANCE.m6369getTitleSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6367getTitleSmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle16 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily bodyLargeEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getBodyLargeEmphasizedFont() : genericFontFamily;
        this.BodyLargeEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle16, 0L, TypeScaleTokens.INSTANCE.m6281getBodyLargeEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyLargeEmphasizedWeight(), null, null, bodyLargeEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6282getBodyLargeEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6280getBodyLargeEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle17 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily bodyMediumEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getBodyMediumEmphasizedFont() : genericFontFamily;
        this.BodyMediumEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle17, 0L, TypeScaleTokens.INSTANCE.m6287getBodyMediumEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodyMediumEmphasizedWeight(), null, null, bodyMediumEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6288getBodyMediumEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6286getBodyMediumEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle18 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily bodySmallEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getBodySmallEmphasizedFont() : genericFontFamily;
        this.BodySmallEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle18, 0L, TypeScaleTokens.INSTANCE.m6293getBodySmallEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getBodySmallEmphasizedWeight(), null, null, bodySmallEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6294getBodySmallEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6292getBodySmallEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle19 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily displayLargeEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getDisplayLargeEmphasizedFont() : genericFontFamily;
        this.DisplayLargeEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle19, 0L, TypeScaleTokens.INSTANCE.m6299getDisplayLargeEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayLargeEmphasizedWeight(), null, null, displayLargeEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6300getDisplayLargeEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6298getDisplayLargeEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle20 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily displayMediumEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getDisplayMediumEmphasizedFont() : genericFontFamily;
        this.DisplayMediumEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle20, 0L, TypeScaleTokens.INSTANCE.m6305getDisplayMediumEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplayMediumEmphasizedWeight(), null, null, displayMediumEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6306getDisplayMediumEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6304getDisplayMediumEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle21 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily displaySmallEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getDisplaySmallEmphasizedFont() : genericFontFamily;
        this.DisplaySmallEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle21, 0L, TypeScaleTokens.INSTANCE.m6311getDisplaySmallEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getDisplaySmallEmphasizedWeight(), null, null, displaySmallEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6312getDisplaySmallEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6310getDisplaySmallEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle22 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily headlineLargeEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getHeadlineLargeEmphasizedFont() : genericFontFamily;
        this.HeadlineLargeEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle22, 0L, TypeScaleTokens.INSTANCE.m6317getHeadlineLargeEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineLargeEmphasizedWeight(), null, null, headlineLargeEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6318getHeadlineLargeEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6316getHeadlineLargeEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle23 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily headlineMediumEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getHeadlineMediumEmphasizedFont() : genericFontFamily;
        this.HeadlineMediumEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle23, 0L, TypeScaleTokens.INSTANCE.m6323getHeadlineMediumEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineMediumEmphasizedWeight(), null, null, headlineMediumEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6324getHeadlineMediumEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6322getHeadlineMediumEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle24 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily headlineSmallEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getHeadlineSmallEmphasizedFont() : genericFontFamily;
        this.HeadlineSmallEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle24, 0L, TypeScaleTokens.INSTANCE.m6329getHeadlineSmallEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getHeadlineSmallEmphasizedWeight(), null, null, headlineSmallEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6330getHeadlineSmallEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6328getHeadlineSmallEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle25 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily labelLargeEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getLabelLargeEmphasizedFont() : genericFontFamily;
        this.LabelLargeEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle25, 0L, TypeScaleTokens.INSTANCE.m6335getLabelLargeEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelLargeEmphasizedWeight(), null, null, labelLargeEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6336getLabelLargeEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6334getLabelLargeEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle26 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily labelMediumEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getLabelMediumEmphasizedFont() : genericFontFamily;
        this.LabelMediumEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle26, 0L, TypeScaleTokens.INSTANCE.m6341getLabelMediumEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelMediumEmphasizedWeight(), null, null, labelMediumEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6342getLabelMediumEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6340getLabelMediumEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle27 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily labelSmallEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getLabelSmallEmphasizedFont() : genericFontFamily;
        this.LabelSmallEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle27, 0L, TypeScaleTokens.INSTANCE.m6347getLabelSmallEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getLabelSmallEmphasizedWeight(), null, null, labelSmallEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6348getLabelSmallEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6346getLabelSmallEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle28 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily titleLargeEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getTitleLargeEmphasizedFont() : genericFontFamily;
        this.TitleLargeEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle28, 0L, TypeScaleTokens.INSTANCE.m6353getTitleLargeEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleLargeEmphasizedWeight(), null, null, titleLargeEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6354getTitleLargeEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6352getTitleLargeEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle29 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily titleMediumEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getTitleMediumEmphasizedFont() : genericFontFamily;
        this.TitleMediumEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle29, 0L, TypeScaleTokens.INSTANCE.m6359getTitleMediumEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleMediumEmphasizedWeight(), null, null, titleMediumEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6360getTitleMediumEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6358getTitleMediumEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle30 = TypographyTokensKt.getDefaultTextStyle();
        FontFamily titleSmallEmphasizedFont = genericFontFamily == null ? TypeScaleTokens.INSTANCE.getTitleSmallEmphasizedFont() : genericFontFamily;
        this.TitleSmallEmphasized = TextStyle.m9611copyp1EtxEg$default(defaultTextStyle30, 0L, TypeScaleTokens.INSTANCE.m6365getTitleSmallEmphasizedSizeXSAIIZE(), TypeScaleTokens.INSTANCE.getTitleSmallEmphasizedWeight(), null, null, titleSmallEmphasizedFont, null, TypeScaleTokens.INSTANCE.m6366getTitleSmallEmphasizedTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, TypeScaleTokens.INSTANCE.m6364getTitleSmallEmphasizedLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
    }

    public /* synthetic */ TypographyTokens(FontFamily fontFamily, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : fontFamily);
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final TextStyle getBodyLarge() {
        return this.BodyLarge;
    }

    public final TextStyle getBodyMedium() {
        return this.BodyMedium;
    }

    public final TextStyle getBodySmall() {
        return this.BodySmall;
    }

    public final TextStyle getDisplayLarge() {
        return this.DisplayLarge;
    }

    public final TextStyle getDisplayMedium() {
        return this.DisplayMedium;
    }

    public final TextStyle getDisplaySmall() {
        return this.DisplaySmall;
    }

    public final TextStyle getHeadlineLarge() {
        return this.HeadlineLarge;
    }

    public final TextStyle getHeadlineMedium() {
        return this.HeadlineMedium;
    }

    public final TextStyle getHeadlineSmall() {
        return this.HeadlineSmall;
    }

    public final TextStyle getLabelLarge() {
        return this.LabelLarge;
    }

    public final TextStyle getLabelMedium() {
        return this.LabelMedium;
    }

    public final TextStyle getLabelSmall() {
        return this.LabelSmall;
    }

    public final TextStyle getTitleLarge() {
        return this.TitleLarge;
    }

    public final TextStyle getTitleMedium() {
        return this.TitleMedium;
    }

    public final TextStyle getTitleSmall() {
        return this.TitleSmall;
    }

    public final TextStyle getBodyLargeEmphasized() {
        return this.BodyLargeEmphasized;
    }

    public final TextStyle getBodyMediumEmphasized() {
        return this.BodyMediumEmphasized;
    }

    public final TextStyle getBodySmallEmphasized() {
        return this.BodySmallEmphasized;
    }

    public final TextStyle getDisplayLargeEmphasized() {
        return this.DisplayLargeEmphasized;
    }

    public final TextStyle getDisplayMediumEmphasized() {
        return this.DisplayMediumEmphasized;
    }

    public final TextStyle getDisplaySmallEmphasized() {
        return this.DisplaySmallEmphasized;
    }

    public final TextStyle getHeadlineLargeEmphasized() {
        return this.HeadlineLargeEmphasized;
    }

    public final TextStyle getHeadlineMediumEmphasized() {
        return this.HeadlineMediumEmphasized;
    }

    public final TextStyle getHeadlineSmallEmphasized() {
        return this.HeadlineSmallEmphasized;
    }

    public final TextStyle getLabelLargeEmphasized() {
        return this.LabelLargeEmphasized;
    }

    public final TextStyle getLabelMediumEmphasized() {
        return this.LabelMediumEmphasized;
    }

    public final TextStyle getLabelSmallEmphasized() {
        return this.LabelSmallEmphasized;
    }

    public final TextStyle getTitleLargeEmphasized() {
        return this.TitleLargeEmphasized;
    }

    public final TextStyle getTitleMediumEmphasized() {
        return this.TitleMediumEmphasized;
    }

    public final TextStyle getTitleSmallEmphasized() {
        return this.TitleSmallEmphasized;
    }
}
