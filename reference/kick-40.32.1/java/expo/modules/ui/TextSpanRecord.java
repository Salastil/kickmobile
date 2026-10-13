package expo.modules.ui;

import android.graphics.Color;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PFunction;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001OB\u008f\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010=\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010B\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0096\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\f\u0010J\u001a\u0006\u0012\u0002\b\u00030KH\u0016J\t\u0010L\u001a\u00020MHÖ\u0001J\t\u0010N\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\"R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0004¢\u0006\u0010\n\u0002\u0010&\u0012\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010%R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010)R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010,R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001a\u001a\u0004\b.\u0010\u001cR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u001a\u001a\u0004\b0\u00101R \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0004¢\u0006\u0010\n\u0002\u0010&\u0012\u0004\b2\u0010\u001a\u001a\u0004\b3\u0010%R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u001a\u001a\u0004\b5\u0010\"R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108¨\u0006P"}, d2 = {"Lexpo/modules/ui/TextSpanRecord;", "Lexpo/modules/kotlin/records/Record;", "Lexpo/modules/ui/TextSpanStyle;", "Lio/github/expo/pika/PIntrospectionProvider;", "text", "", "children", "", "color", "Landroid/graphics/Color;", ViewProps.FONT_SIZE, "", ViewProps.FONT_WEIGHT, "Lexpo/modules/ui/TextFontWeight;", ViewProps.FONT_STYLE, "Lexpo/modules/ui/TextFontStyle;", ViewProps.FONT_FAMILY, "textDecoration", "Lexpo/modules/ui/TextDecorationType;", ViewProps.LETTER_SPACING, "background", "shadow", "Lexpo/modules/ui/TextShadowRecord;", "<init>", "(Ljava/lang/String;Ljava/util/List;Landroid/graphics/Color;Ljava/lang/Float;Lexpo/modules/ui/TextFontWeight;Lexpo/modules/ui/TextFontStyle;Ljava/lang/String;Lexpo/modules/ui/TextDecorationType;Ljava/lang/Float;Landroid/graphics/Color;Lexpo/modules/ui/TextShadowRecord;)V", "getText$annotations", "()V", "getText", "()Ljava/lang/String;", "getChildren$annotations", "getChildren", "()Ljava/util/List;", "getColor$annotations", "getColor", "()Landroid/graphics/Color;", "getFontSize$annotations", "getFontSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFontWeight$annotations", "getFontWeight", "()Lexpo/modules/ui/TextFontWeight;", "getFontStyle$annotations", "getFontStyle", "()Lexpo/modules/ui/TextFontStyle;", "getFontFamily$annotations", "getFontFamily", "getTextDecoration$annotations", "getTextDecoration", "()Lexpo/modules/ui/TextDecorationType;", "getLetterSpacing$annotations", "getLetterSpacing", "getBackground$annotations", "getBackground", "getShadow$annotations", "getShadow", "()Lexpo/modules/ui/TextShadowRecord;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/util/List;Landroid/graphics/Color;Ljava/lang/Float;Lexpo/modules/ui/TextFontWeight;Lexpo/modules/ui/TextFontStyle;Ljava/lang/String;Lexpo/modules/ui/TextDecorationType;Ljava/lang/Float;Landroid/graphics/Color;Lexpo/modules/ui/TextShadowRecord;)Lexpo/modules/ui/TextSpanRecord;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextSpanRecord implements Record, TextSpanStyle, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color background;
    public List<TextSpanRecord> children;
    public Color color;
    public String fontFamily;
    public Float fontSize;
    public TextFontStyle fontStyle;
    public TextFontWeight fontWeight;
    public Float letterSpacing;
    public TextShadowRecord shadow;
    public String text;
    public TextDecorationType textDecoration;

    /* JADX INFO: compiled from: TextView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/TextSpanRecord$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<TextSpanRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(TextSpanRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("text", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 0, __pika, false, true, false), new PProperty("children", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(TextSpanRecord.class, false, null)}), null), 1, __pika, false, true, false), new PProperty("color", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty(ViewProps.FONT_SIZE, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 3, __pika, false, true, false), new PProperty(ViewProps.FONT_WEIGHT, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(TextFontWeight.class, true, null), 4, __pika, false, true, false), new PProperty(ViewProps.FONT_STYLE, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(TextFontStyle.class, true, null), 5, __pika, false, true, false), new PProperty(ViewProps.FONT_FAMILY, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 6, __pika, false, true, false), new PProperty("textDecoration", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(TextDecorationType.class, true, null), 7, __pika, false, true, false), new PProperty(ViewProps.LETTER_SPACING, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 8, __pika, false, true, false), new PProperty("background", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 9, __pika, false, true, false), new PProperty("shadow", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(TextShadowRecord.class, true, TextShadowRecord.__Pika.__pika$IntrospectionData), 10, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("component9", PVisibility.PUBLIC), new PFunction("component10", PVisibility.PUBLIC), new PFunction("component11", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    return ((TextSpanRecord) obj).getText();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    return ((TextSpanRecord) obj).getChildren();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    return ((TextSpanRecord) obj).getColor();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    return ((TextSpanRecord) obj).getFontSize();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    return ((TextSpanRecord) obj).getFontWeight();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    return ((TextSpanRecord) obj).getFontStyle();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    return ((TextSpanRecord) obj).getFontFamily();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    return ((TextSpanRecord) obj).getTextDecoration();
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    return ((TextSpanRecord) obj).getLetterSpacing();
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    return ((TextSpanRecord) obj).getBackground();
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    return ((TextSpanRecord) obj).getShadow();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                    ((TextSpanRecord) obj).text = (String) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    ((TextSpanRecord) obj).children = (List) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    ((TextSpanRecord) obj).color = (Color) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    ((TextSpanRecord) obj).fontSize = (Float) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    ((TextSpanRecord) obj).fontWeight = (TextFontWeight) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    ((TextSpanRecord) obj).fontStyle = (TextFontStyle) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    ((TextSpanRecord) obj).fontFamily = (String) obj2;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    ((TextSpanRecord) obj).textDecoration = (TextDecorationType) obj2;
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    ((TextSpanRecord) obj).letterSpacing = (Float) obj2;
                    return;
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    ((TextSpanRecord) obj).background = (Color) obj2;
                    return;
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextSpanRecord");
                    ((TextSpanRecord) obj).shadow = (TextShadowRecord) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public TextSpanRecord() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextSpanRecord copy$default(TextSpanRecord textSpanRecord, String str, List list, Color color, Float f, TextFontWeight textFontWeight, TextFontStyle textFontStyle, String str2, TextDecorationType textDecorationType, Float f2, Color color2, TextShadowRecord textShadowRecord, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textSpanRecord.text;
        }
        if ((i & 2) != 0) {
            list = textSpanRecord.children;
        }
        if ((i & 4) != 0) {
            color = textSpanRecord.color;
        }
        if ((i & 8) != 0) {
            f = textSpanRecord.fontSize;
        }
        if ((i & 16) != 0) {
            textFontWeight = textSpanRecord.fontWeight;
        }
        if ((i & 32) != 0) {
            textFontStyle = textSpanRecord.fontStyle;
        }
        if ((i & 64) != 0) {
            str2 = textSpanRecord.fontFamily;
        }
        if ((i & 128) != 0) {
            textDecorationType = textSpanRecord.textDecoration;
        }
        if ((i & 256) != 0) {
            f2 = textSpanRecord.letterSpacing;
        }
        if ((i & 512) != 0) {
            color2 = textSpanRecord.background;
        }
        if ((i & 1024) != 0) {
            textShadowRecord = textSpanRecord.shadow;
        }
        Color color3 = color2;
        TextShadowRecord textShadowRecord2 = textShadowRecord;
        TextDecorationType textDecorationType2 = textDecorationType;
        Float f3 = f2;
        TextFontStyle textFontStyle2 = textFontStyle;
        String str3 = str2;
        TextFontWeight textFontWeight2 = textFontWeight;
        Color color4 = color;
        return textSpanRecord.copy(str, list, color4, f, textFontWeight2, textFontStyle2, str3, textDecorationType2, f3, color3, textShadowRecord2);
    }

    @Field
    public static /* synthetic */ void getBackground$annotations() {
    }

    @Field
    public static /* synthetic */ void getChildren$annotations() {
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
    public static /* synthetic */ void getFontStyle$annotations() {
    }

    @Field
    public static /* synthetic */ void getFontWeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getLetterSpacing$annotations() {
    }

    @Field
    public static /* synthetic */ void getShadow$annotations() {
    }

    @Field
    public static /* synthetic */ void getText$annotations() {
    }

    @Field
    public static /* synthetic */ void getTextDecoration$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Color getBackground() {
        return this.background;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final TextShadowRecord getShadow() {
        return this.shadow;
    }

    public final List<TextSpanRecord> component2() {
        return this.children;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TextFontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final TextFontStyle getFontStyle() {
        return this.fontStyle;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFontFamily() {
        return this.fontFamily;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final TextDecorationType getTextDecoration() {
        return this.textDecoration;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Float getLetterSpacing() {
        return this.letterSpacing;
    }

    public final TextSpanRecord copy(String text, List<TextSpanRecord> children, Color color, Float fontSize, TextFontWeight fontWeight, TextFontStyle fontStyle, String fontFamily, TextDecorationType textDecoration, Float letterSpacing, Color background, TextShadowRecord shadow) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new TextSpanRecord(text, children, color, fontSize, fontWeight, fontStyle, fontFamily, textDecoration, letterSpacing, background, shadow);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextSpanRecord)) {
            return false;
        }
        TextSpanRecord textSpanRecord = (TextSpanRecord) other;
        return Intrinsics.areEqual(this.text, textSpanRecord.text) && Intrinsics.areEqual(this.children, textSpanRecord.children) && Intrinsics.areEqual(this.color, textSpanRecord.color) && Intrinsics.areEqual((Object) this.fontSize, (Object) textSpanRecord.fontSize) && this.fontWeight == textSpanRecord.fontWeight && this.fontStyle == textSpanRecord.fontStyle && Intrinsics.areEqual(this.fontFamily, textSpanRecord.fontFamily) && this.textDecoration == textSpanRecord.textDecoration && Intrinsics.areEqual((Object) this.letterSpacing, (Object) textSpanRecord.letterSpacing) && Intrinsics.areEqual(this.background, textSpanRecord.background) && Intrinsics.areEqual(this.shadow, textSpanRecord.shadow);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        List<TextSpanRecord> list = this.children;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Color color = this.color;
        int iHashCode3 = (iHashCode2 + (color == null ? 0 : color.hashCode())) * 31;
        Float f = this.fontSize;
        int iHashCode4 = (iHashCode3 + (f == null ? 0 : f.hashCode())) * 31;
        TextFontWeight textFontWeight = this.fontWeight;
        int iHashCode5 = (iHashCode4 + (textFontWeight == null ? 0 : textFontWeight.hashCode())) * 31;
        TextFontStyle textFontStyle = this.fontStyle;
        int iHashCode6 = (iHashCode5 + (textFontStyle == null ? 0 : textFontStyle.hashCode())) * 31;
        String str = this.fontFamily;
        int iHashCode7 = (iHashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        TextDecorationType textDecorationType = this.textDecoration;
        int iHashCode8 = (iHashCode7 + (textDecorationType == null ? 0 : textDecorationType.hashCode())) * 31;
        Float f2 = this.letterSpacing;
        int iHashCode9 = (iHashCode8 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Color color2 = this.background;
        int iHashCode10 = (iHashCode9 + (color2 == null ? 0 : color2.hashCode())) * 31;
        TextShadowRecord textShadowRecord = this.shadow;
        return iHashCode10 + (textShadowRecord != null ? textShadowRecord.hashCode() : 0);
    }

    public String toString() {
        return "TextSpanRecord(text=" + this.text + ", children=" + this.children + ", color=" + this.color + ", fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ", fontFamily=" + this.fontFamily + ", textDecoration=" + this.textDecoration + ", letterSpacing=" + this.letterSpacing + ", background=" + this.background + ", shadow=" + this.shadow + ")";
    }

    public TextSpanRecord(String text, List<TextSpanRecord> list, Color color, Float f, TextFontWeight textFontWeight, TextFontStyle textFontStyle, String str, TextDecorationType textDecorationType, Float f2, Color color2, TextShadowRecord textShadowRecord) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.children = list;
        this.color = color;
        this.fontSize = f;
        this.fontWeight = textFontWeight;
        this.fontStyle = textFontStyle;
        this.fontFamily = str;
        this.textDecoration = textDecorationType;
        this.letterSpacing = f2;
        this.background = color2;
        this.shadow = textShadowRecord;
    }

    public /* synthetic */ TextSpanRecord(String str, List list, Color color, Float f, TextFontWeight textFontWeight, TextFontStyle textFontStyle, String str2, TextDecorationType textDecorationType, Float f2, Color color2, TextShadowRecord textShadowRecord, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : color, (i & 8) != 0 ? null : f, (i & 16) != 0 ? null : textFontWeight, (i & 32) != 0 ? null : textFontStyle, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : textDecorationType, (i & 256) != 0 ? null : f2, (i & 512) != 0 ? null : color2, (i & 1024) != 0 ? null : textShadowRecord);
    }

    @Override // expo.modules.ui.TextSpanStyle
    public String getText() {
        return this.text;
    }

    public final List<TextSpanRecord> getChildren() {
        return this.children;
    }

    @Override // expo.modules.ui.TextSpanStyle
    public Color getColor() {
        return this.color;
    }

    @Override // expo.modules.ui.TextSpanStyle
    public Float getFontSize() {
        return this.fontSize;
    }

    @Override // expo.modules.ui.TextSpanStyle
    public TextFontWeight getFontWeight() {
        return this.fontWeight;
    }

    @Override // expo.modules.ui.TextSpanStyle
    public TextFontStyle getFontStyle() {
        return this.fontStyle;
    }

    @Override // expo.modules.ui.TextSpanStyle
    public String getFontFamily() {
        return this.fontFamily;
    }

    @Override // expo.modules.ui.TextSpanStyle
    public TextDecorationType getTextDecoration() {
        return this.textDecoration;
    }

    @Override // expo.modules.ui.TextSpanStyle
    public Float getLetterSpacing() {
        return this.letterSpacing;
    }

    @Override // expo.modules.ui.TextSpanStyle
    public Color getBackground() {
        return this.background;
    }

    @Override // expo.modules.ui.TextSpanStyle
    public TextShadowRecord getShadow() {
        return this.shadow;
    }
}
