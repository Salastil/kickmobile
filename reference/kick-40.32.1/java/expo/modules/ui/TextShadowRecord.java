package expo.modules.ui;

import android.graphics.Color;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shadow;
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

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0018J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\f\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0016J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u0011R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u0011¨\u0006*"}, d2 = {"Lexpo/modules/ui/TextShadowRecord;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "color", "Landroid/graphics/Color;", "offsetX", "", "offsetY", "blurRadius", "<init>", "(Landroid/graphics/Color;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getColor$annotations", "()V", "getColor", "()Landroid/graphics/Color;", "getOffsetX$annotations", "getOffsetX", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getOffsetY$annotations", "getOffsetY", "getBlurRadius$annotations", "getBlurRadius", "toComposeShadow", "Landroidx/compose/ui/graphics/Shadow;", "component1", "component2", "component3", "component4", "copy", "(Landroid/graphics/Color;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lexpo/modules/ui/TextShadowRecord;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextShadowRecord implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Float blurRadius;
    public Color color;
    public Float offsetX;
    public Float offsetY;

    /* JADX INFO: compiled from: TextView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/TextShadowRecord$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<TextShadowRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(TextShadowRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("color", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 0, __pika, false, true, false), new PProperty("offsetX", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 1, __pika, false, true, false), new PProperty("offsetY", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 2, __pika, false, true, false), new PProperty("blurRadius", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 3, __pika, false, true, false)}, new PFunction[]{new PFunction("toComposeShadow", PVisibility.PUBLIC), new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextShadowRecord");
                return ((TextShadowRecord) obj).getColor();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextShadowRecord");
                return ((TextShadowRecord) obj).getOffsetX();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextShadowRecord");
                return ((TextShadowRecord) obj).getOffsetY();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextShadowRecord");
            return ((TextShadowRecord) obj).getBlurRadius();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextShadowRecord");
                ((TextShadowRecord) obj).color = (Color) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextShadowRecord");
                ((TextShadowRecord) obj).offsetX = (Float) obj2;
            } else if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextShadowRecord");
                ((TextShadowRecord) obj).offsetY = (Float) obj2;
            } else {
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TextShadowRecord");
                ((TextShadowRecord) obj).blurRadius = (Float) obj2;
            }
        }
    }

    public TextShadowRecord() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TextShadowRecord copy$default(TextShadowRecord textShadowRecord, Color color, Float f, Float f2, Float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            color = textShadowRecord.color;
        }
        if ((i & 2) != 0) {
            f = textShadowRecord.offsetX;
        }
        if ((i & 4) != 0) {
            f2 = textShadowRecord.offsetY;
        }
        if ((i & 8) != 0) {
            f3 = textShadowRecord.blurRadius;
        }
        return textShadowRecord.copy(color, f, f2, f3);
    }

    @Field
    public static /* synthetic */ void getBlurRadius$annotations() {
    }

    @Field
    public static /* synthetic */ void getColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getOffsetX$annotations() {
    }

    @Field
    public static /* synthetic */ void getOffsetY$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getOffsetX() {
        return this.offsetX;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getOffsetY() {
        return this.offsetY;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getBlurRadius() {
        return this.blurRadius;
    }

    public final TextShadowRecord copy(Color color, Float offsetX, Float offsetY, Float blurRadius) {
        return new TextShadowRecord(color, offsetX, offsetY, blurRadius);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextShadowRecord)) {
            return false;
        }
        TextShadowRecord textShadowRecord = (TextShadowRecord) other;
        return Intrinsics.areEqual(this.color, textShadowRecord.color) && Intrinsics.areEqual((Object) this.offsetX, (Object) textShadowRecord.offsetX) && Intrinsics.areEqual((Object) this.offsetY, (Object) textShadowRecord.offsetY) && Intrinsics.areEqual((Object) this.blurRadius, (Object) textShadowRecord.blurRadius);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Color color = this.color;
        int iHashCode = (color == null ? 0 : color.hashCode()) * 31;
        Float f = this.offsetX;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.offsetY;
        int iHashCode3 = (iHashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.blurRadius;
        return iHashCode3 + (f3 != null ? f3.hashCode() : 0);
    }

    public String toString() {
        return "TextShadowRecord(color=" + this.color + ", offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", blurRadius=" + this.blurRadius + ")";
    }

    public TextShadowRecord(Color color, Float f, Float f2, Float f3) {
        this.color = color;
        this.offsetX = f;
        this.offsetY = f2;
        this.blurRadius = f3;
    }

    public /* synthetic */ TextShadowRecord(Color color, Float f, Float f2, Float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color, (i & 2) != 0 ? null : f, (i & 4) != 0 ? null : f2, (i & 8) != 0 ? null : f3);
    }

    public final Color getColor() {
        return this.color;
    }

    public final Float getOffsetX() {
        return this.offsetX;
    }

    public final Float getOffsetY() {
        return this.offsetY;
    }

    public final Float getBlurRadius() {
        return this.blurRadius;
    }

    public final Shadow toComposeShadow() {
        androidx.compose.ui.graphics.Color colorColorToComposeColorOrNull = UtilsKt.colorToComposeColorOrNull(this.color);
        long jM7348unboximpl = colorColorToComposeColorOrNull != null ? colorColorToComposeColorOrNull.m7348unboximpl() : androidx.compose.ui.graphics.Color.INSTANCE.m7364getBlack0d7_KjU();
        Float f = this.offsetX;
        float fFloatValue = f != null ? f.floatValue() : 0.0f;
        Float f2 = this.offsetY;
        long jM7065constructorimpl = Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(fFloatValue)) << 32) | (((long) Float.floatToRawIntBits(f2 != null ? f2.floatValue() : 0.0f)) & 4294967295L));
        Float f3 = this.blurRadius;
        return new Shadow(jM7348unboximpl, jM7065constructorimpl, f3 != null ? f3.floatValue() : 0.0f, null);
    }
}
