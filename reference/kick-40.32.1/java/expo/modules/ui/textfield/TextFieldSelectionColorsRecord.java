package expo.modules.ui.textfield;

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
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001bB\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\f\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u001c"}, d2 = {"Lexpo/modules/ui/textfield/TextFieldSelectionColorsRecord;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "handleColor", "Landroid/graphics/Color;", ViewProps.BACKGROUND_COLOR, "<init>", "(Landroid/graphics/Color;Landroid/graphics/Color;)V", "getHandleColor$annotations", "()V", "getHandleColor", "()Landroid/graphics/Color;", "getBackgroundColor$annotations", "getBackgroundColor", "component1", "component2", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextFieldSelectionColorsRecord implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color backgroundColor;
    public Color handleColor;

    /* JADX INFO: compiled from: TextField.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/textfield/TextFieldSelectionColorsRecord$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<TextFieldSelectionColorsRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(TextFieldSelectionColorsRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("handleColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 0, __pika, false, true, false), new PProperty(ViewProps.BACKGROUND_COLOR, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldSelectionColorsRecord");
                return ((TextFieldSelectionColorsRecord) obj).getHandleColor();
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldSelectionColorsRecord");
            return ((TextFieldSelectionColorsRecord) obj).getBackgroundColor();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldSelectionColorsRecord");
                ((TextFieldSelectionColorsRecord) obj).handleColor = (Color) obj2;
            } else {
                if (i != 1) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.textfield.TextFieldSelectionColorsRecord");
                ((TextFieldSelectionColorsRecord) obj).backgroundColor = (Color) obj2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldSelectionColorsRecord() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TextFieldSelectionColorsRecord copy$default(TextFieldSelectionColorsRecord textFieldSelectionColorsRecord, Color color, Color color2, int i, Object obj) {
        if ((i & 1) != 0) {
            color = textFieldSelectionColorsRecord.handleColor;
        }
        if ((i & 2) != 0) {
            color2 = textFieldSelectionColorsRecord.backgroundColor;
        }
        return textFieldSelectionColorsRecord.copy(color, color2);
    }

    @Field
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getHandleColor$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color getHandleColor() {
        return this.handleColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public final TextFieldSelectionColorsRecord copy(Color handleColor, Color backgroundColor) {
        return new TextFieldSelectionColorsRecord(handleColor, backgroundColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextFieldSelectionColorsRecord)) {
            return false;
        }
        TextFieldSelectionColorsRecord textFieldSelectionColorsRecord = (TextFieldSelectionColorsRecord) other;
        return Intrinsics.areEqual(this.handleColor, textFieldSelectionColorsRecord.handleColor) && Intrinsics.areEqual(this.backgroundColor, textFieldSelectionColorsRecord.backgroundColor);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Color color = this.handleColor;
        int iHashCode = (color == null ? 0 : color.hashCode()) * 31;
        Color color2 = this.backgroundColor;
        return iHashCode + (color2 != null ? color2.hashCode() : 0);
    }

    public String toString() {
        return "TextFieldSelectionColorsRecord(handleColor=" + this.handleColor + ", backgroundColor=" + this.backgroundColor + ")";
    }

    public TextFieldSelectionColorsRecord(Color color, Color color2) {
        this.handleColor = color;
        this.backgroundColor = color2;
    }

    public /* synthetic */ TextFieldSelectionColorsRecord(Color color, Color color2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color, (i & 2) != 0 ? null : color2);
    }

    public final Color getHandleColor() {
        return this.handleColor;
    }

    public final Color getBackgroundColor() {
        return this.backgroundColor;
    }
}
