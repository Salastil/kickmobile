package expo.modules.ui.textfield;

import android.graphics.Color;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import expo.modules.ui.TextAlignType;
import expo.modules.ui.TextFontWeight;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PFunction;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextFieldShared.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00018B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJb\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\f\u00103\u001a\u0006\u0012\u0002\b\u000304H\u0016J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\nHÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010!R \u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u001a¨\u00069"}, d2 = {"Lexpo/modules/ui/textfield/TextFieldTextStyleRecord;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", ViewProps.TEXT_ALIGN, "Lexpo/modules/ui/TextAlignType;", "color", "Landroid/graphics/Color;", ViewProps.FONT_SIZE, "", ViewProps.FONT_FAMILY, "", ViewProps.FONT_WEIGHT, "Lexpo/modules/ui/TextFontWeight;", ViewProps.LINE_HEIGHT, ViewProps.LETTER_SPACING, "<init>", "(Lexpo/modules/ui/TextAlignType;Landroid/graphics/Color;Ljava/lang/Float;Ljava/lang/String;Lexpo/modules/ui/TextFontWeight;Ljava/lang/Float;Ljava/lang/Float;)V", "getTextAlign$annotations", "()V", "getTextAlign", "()Lexpo/modules/ui/TextAlignType;", "getColor$annotations", "getColor", "()Landroid/graphics/Color;", "getFontSize$annotations", "getFontSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFontFamily$annotations", "getFontFamily", "()Ljava/lang/String;", "getFontWeight$annotations", "getFontWeight", "()Lexpo/modules/ui/TextFontWeight;", "getLineHeight$annotations", "getLineHeight", "getLetterSpacing$annotations", "getLetterSpacing", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lexpo/modules/ui/TextAlignType;Landroid/graphics/Color;Ljava/lang/Float;Ljava/lang/String;Lexpo/modules/ui/TextFontWeight;Ljava/lang/Float;Ljava/lang/Float;)Lexpo/modules/ui/textfield/TextFieldTextStyleRecord;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextFieldTextStyleRecord implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color color;
    public String fontFamily;
    public Float fontSize;
    public TextFontWeight fontWeight;
    public Float letterSpacing;
    public Float lineHeight;
    public TextAlignType textAlign;

    /* JADX INFO: compiled from: TextFieldShared.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/textfield/TextFieldTextStyleRecord$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<TextFieldTextStyleRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(TextFieldTextStyleRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty(ViewProps.TEXT_ALIGN, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(TextAlignType.class, true, null), 0, __pika, false, true, false), new PProperty("color", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty(ViewProps.FONT_SIZE, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 2, __pika, false, true, false), new PProperty(ViewProps.FONT_FAMILY, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 3, __pika, false, true, false), new PProperty(ViewProps.FONT_WEIGHT, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(TextFontWeight.class, true, null), 4, __pika, false, true, false), new PProperty(ViewProps.LINE_HEIGHT, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 5, __pika, false, true, false), new PProperty(ViewProps.LETTER_SPACING, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 6, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    return ((TextFieldTextStyleRecord) obj).getTextAlign();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    return ((TextFieldTextStyleRecord) obj).getColor();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    return ((TextFieldTextStyleRecord) obj).getFontSize();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    return ((TextFieldTextStyleRecord) obj).getFontFamily();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    return ((TextFieldTextStyleRecord) obj).getFontWeight();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    return ((TextFieldTextStyleRecord) obj).getLineHeight();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    return ((TextFieldTextStyleRecord) obj).getLetterSpacing();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    ((TextFieldTextStyleRecord) obj).textAlign = (TextAlignType) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    ((TextFieldTextStyleRecord) obj).color = (Color) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    ((TextFieldTextStyleRecord) obj).fontSize = (Float) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    ((TextFieldTextStyleRecord) obj).fontFamily = (String) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    ((TextFieldTextStyleRecord) obj).fontWeight = (TextFontWeight) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    ((TextFieldTextStyleRecord) obj).lineHeight = (Float) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldTextStyleRecord");
                    ((TextFieldTextStyleRecord) obj).letterSpacing = (Float) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public TextFieldTextStyleRecord() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ TextFieldTextStyleRecord copy$default(TextFieldTextStyleRecord textFieldTextStyleRecord, TextAlignType textAlignType, Color color, Float f, String str, TextFontWeight textFontWeight, Float f2, Float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlignType = textFieldTextStyleRecord.textAlign;
        }
        if ((i & 2) != 0) {
            color = textFieldTextStyleRecord.color;
        }
        if ((i & 4) != 0) {
            f = textFieldTextStyleRecord.fontSize;
        }
        if ((i & 8) != 0) {
            str = textFieldTextStyleRecord.fontFamily;
        }
        if ((i & 16) != 0) {
            textFontWeight = textFieldTextStyleRecord.fontWeight;
        }
        if ((i & 32) != 0) {
            f2 = textFieldTextStyleRecord.lineHeight;
        }
        if ((i & 64) != 0) {
            f3 = textFieldTextStyleRecord.letterSpacing;
        }
        Float f4 = f2;
        Float f5 = f3;
        TextFontWeight textFontWeight2 = textFontWeight;
        Float f6 = f;
        return textFieldTextStyleRecord.copy(textAlignType, color, f6, str, textFontWeight2, f4, f5);
    }

    @Field
    public static /* synthetic */ void getColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getFontFamily$annotations() {
    }

    @Field
    public static /* synthetic */ void getFontSize$annotations() {
    }

    @Field
    public static /* synthetic */ void getFontWeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getLetterSpacing$annotations() {
    }

    @Field
    public static /* synthetic */ void getLineHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getTextAlign$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TextAlignType getTextAlign() {
        return this.textAlign;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFontFamily() {
        return this.fontFamily;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TextFontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Float getLineHeight() {
        return this.lineHeight;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Float getLetterSpacing() {
        return this.letterSpacing;
    }

    public final TextFieldTextStyleRecord copy(TextAlignType textAlign, Color color, Float fontSize, String fontFamily, TextFontWeight fontWeight, Float lineHeight, Float letterSpacing) {
        return new TextFieldTextStyleRecord(textAlign, color, fontSize, fontFamily, fontWeight, lineHeight, letterSpacing);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextFieldTextStyleRecord)) {
            return false;
        }
        TextFieldTextStyleRecord textFieldTextStyleRecord = (TextFieldTextStyleRecord) other;
        return this.textAlign == textFieldTextStyleRecord.textAlign && Intrinsics.areEqual(this.color, textFieldTextStyleRecord.color) && Intrinsics.areEqual((Object) this.fontSize, (Object) textFieldTextStyleRecord.fontSize) && Intrinsics.areEqual(this.fontFamily, textFieldTextStyleRecord.fontFamily) && this.fontWeight == textFieldTextStyleRecord.fontWeight && Intrinsics.areEqual((Object) this.lineHeight, (Object) textFieldTextStyleRecord.lineHeight) && Intrinsics.areEqual((Object) this.letterSpacing, (Object) textFieldTextStyleRecord.letterSpacing);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        TextAlignType textAlignType = this.textAlign;
        int iHashCode = (textAlignType == null ? 0 : textAlignType.hashCode()) * 31;
        Color color = this.color;
        int iHashCode2 = (iHashCode + (color == null ? 0 : color.hashCode())) * 31;
        Float f = this.fontSize;
        int iHashCode3 = (iHashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        String str = this.fontFamily;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        TextFontWeight textFontWeight = this.fontWeight;
        int iHashCode5 = (iHashCode4 + (textFontWeight == null ? 0 : textFontWeight.hashCode())) * 31;
        Float f2 = this.lineHeight;
        int iHashCode6 = (iHashCode5 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.letterSpacing;
        return iHashCode6 + (f3 != null ? f3.hashCode() : 0);
    }

    public String toString() {
        return "TextFieldTextStyleRecord(textAlign=" + this.textAlign + ", color=" + this.color + ", fontSize=" + this.fontSize + ", fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", lineHeight=" + this.lineHeight + ", letterSpacing=" + this.letterSpacing + ")";
    }

    public TextFieldTextStyleRecord(TextAlignType textAlignType, Color color, Float f, String str, TextFontWeight textFontWeight, Float f2, Float f3) {
        this.textAlign = textAlignType;
        this.color = color;
        this.fontSize = f;
        this.fontFamily = str;
        this.fontWeight = textFontWeight;
        this.lineHeight = f2;
        this.letterSpacing = f3;
    }

    public /* synthetic */ TextFieldTextStyleRecord(TextAlignType textAlignType, Color color, Float f, String str, TextFontWeight textFontWeight, Float f2, Float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlignType, (i & 2) != 0 ? null : color, (i & 4) != 0 ? null : f, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : textFontWeight, (i & 32) != 0 ? null : f2, (i & 64) != 0 ? null : f3);
    }

    public final TextAlignType getTextAlign() {
        return this.textAlign;
    }

    public final Color getColor() {
        return this.color;
    }

    public final Float getFontSize() {
        return this.fontSize;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final TextFontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final Float getLineHeight() {
        return this.lineHeight;
    }

    public final Float getLetterSpacing() {
        return this.letterSpacing;
    }
}
