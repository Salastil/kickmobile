package com.facebook.react.views.text.internal.span;

import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.text.ReactTypefaceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomStyleSpan.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eBG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/facebook/react/views/text/internal/span/CustomStyleSpan;", "Landroid/text/style/MetricAffectingSpan;", "Lcom/facebook/react/views/text/internal/span/ReactSpan;", "privateStyle", "", "privateWeight", "fontFeatureSettings", "", ViewProps.FONT_VARIATION_SETTINGS, ViewProps.FONT_FAMILY, "assetManager", "Landroid/content/res/AssetManager;", "fontWeightAdjustment", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/res/AssetManager;I)V", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontVariationSettings", "getFontFamily", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "updateMeasureState", "paint", "style", "getStyle", "()I", "weight", "getWeight", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomStyleSpan extends MetricAffectingSpan implements ReactSpan {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AssetManager assetManager;
    private final String fontFamily;
    private final String fontFeatureSettings;
    private final String fontVariationSettings;
    private final int fontWeightAdjustment;
    private final int privateStyle;
    private final int privateWeight;

    public /* synthetic */ CustomStyleSpan(int i, int i2, String str, String str2, String str3, AssetManager assetManager, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, str2, str3, assetManager, (i4 & 64) != 0 ? 0 : i3);
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    public final String getFontVariationSettings() {
        return this.fontVariationSettings;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public CustomStyleSpan(int i, int i2, String str, String str2, String str3, AssetManager assetManager, int i3) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        this.privateStyle = i;
        this.privateWeight = i2;
        this.fontFeatureSettings = str;
        this.fontVariationSettings = str2;
        this.fontFamily = str3;
        this.assetManager = assetManager;
        this.fontWeightAdjustment = i3;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        INSTANCE.apply(ds, this.privateStyle, this.privateWeight, this.fontFeatureSettings, this.fontVariationSettings, this.fontFamily, this.assetManager, this.fontWeightAdjustment);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        INSTANCE.apply(paint, this.privateStyle, this.privateWeight, this.fontFeatureSettings, this.fontVariationSettings, this.fontFamily, this.assetManager, this.fontWeightAdjustment);
    }

    public final int getStyle() {
        int i = this.privateStyle;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    public final int getWeight() {
        int i = this.privateWeight;
        if (i == -1) {
            return 400;
        }
        return i;
    }

    /* JADX INFO: compiled from: CustomStyleSpan.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/views/text/internal/span/CustomStyleSpan$Companion;", "", "<init>", "()V", "apply", "", "paint", "Landroid/graphics/Paint;", "style", "", "weight", "fontFeatureSettingsParam", "", "fontVariationSettingsParam", "family", "assetManager", "Landroid/content/res/AssetManager;", "fontWeightAdjustment", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void apply(Paint paint, int style, int weight, String fontFeatureSettingsParam, String fontVariationSettingsParam, String family, AssetManager assetManager, int fontWeightAdjustment) {
            Typeface typefaceApplyFontWeightAdjustment = ReactTypefaceUtils.applyFontWeightAdjustment(ReactTypefaceUtils.applyStyles(paint.getTypeface(), style, weight, family, assetManager), fontWeightAdjustment);
            paint.setFontFeatureSettings(fontFeatureSettingsParam);
            paint.setTypeface(typefaceApplyFontWeightAdjustment);
            ReactTypefaceUtils.INSTANCE.applyFontVariationSettings$ReactAndroid(paint, fontVariationSettingsParam);
            paint.setSubpixelText(true);
            paint.setLinearText(true);
        }
    }
}
