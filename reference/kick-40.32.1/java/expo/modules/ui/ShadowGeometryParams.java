package expo.modules.ui;

import android.graphics.Color;
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

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00013BQ\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003JS\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\f\u0010-\u001a\u0006\u0012\u0002\b\u00030.H\u0016J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0015R\u001c\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0015R\u001c\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0015¨\u00064"}, d2 = {"Lexpo/modules/ui/ShadowGeometryParams;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "shape", "Lexpo/modules/ui/BuiltinShapeRecord;", "radius", "", "spread", "color", "Landroid/graphics/Color;", "offsetX", "offsetY", "alpha", "<init>", "(Lexpo/modules/ui/BuiltinShapeRecord;FFLandroid/graphics/Color;FFF)V", "getShape$annotations", "()V", "getShape", "()Lexpo/modules/ui/BuiltinShapeRecord;", "getRadius$annotations", "getRadius", "()F", "getSpread$annotations", "getSpread", "getColor$annotations", "getColor", "()Landroid/graphics/Color;", "getOffsetX$annotations", "getOffsetX", "getOffsetY$annotations", "getOffsetY", "getAlpha$annotations", "getAlpha", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ShadowGeometryParams implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public float alpha;
    public Color color;
    public float offsetX;
    public float offsetY;
    public float radius;
    public BuiltinShapeRecord shape;
    public float spread;

    /* JADX INFO: compiled from: ModifierRegistry.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/ShadowGeometryParams$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ShadowGeometryParams> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ShadowGeometryParams.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("shape", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(BuiltinShapeRecord.class, true, null), 0, __pika, false, true, false), new PProperty("radius", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 1, __pika, false, true, false), new PProperty("spread", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 2, __pika, false, true, false), new PProperty("color", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 3, __pika, false, true, false), new PProperty("offsetX", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 4, __pika, false, true, false), new PProperty("offsetY", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 5, __pika, false, true, false), new PProperty("alpha", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 6, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    return ((ShadowGeometryParams) obj).getShape();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    return Float.valueOf(((ShadowGeometryParams) obj).getRadius());
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    return Float.valueOf(((ShadowGeometryParams) obj).getSpread());
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    return ((ShadowGeometryParams) obj).getColor();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    return Float.valueOf(((ShadowGeometryParams) obj).getOffsetX());
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    return Float.valueOf(((ShadowGeometryParams) obj).getOffsetY());
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    return Float.valueOf(((ShadowGeometryParams) obj).getAlpha());
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    ((ShadowGeometryParams) obj).shape = (BuiltinShapeRecord) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((ShadowGeometryParams) obj).radius = ((Float) obj2).floatValue();
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((ShadowGeometryParams) obj).spread = ((Float) obj2).floatValue();
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    ((ShadowGeometryParams) obj).color = (Color) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((ShadowGeometryParams) obj).offsetX = ((Float) obj2).floatValue();
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((ShadowGeometryParams) obj).offsetY = ((Float) obj2).floatValue();
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShadowGeometryParams");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((ShadowGeometryParams) obj).alpha = ((Float) obj2).floatValue();
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public ShadowGeometryParams() {
        this(null, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, 127, null);
    }

    public static /* synthetic */ ShadowGeometryParams copy$default(ShadowGeometryParams shadowGeometryParams, BuiltinShapeRecord builtinShapeRecord, float f, float f2, Color color, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            builtinShapeRecord = shadowGeometryParams.shape;
        }
        if ((i & 2) != 0) {
            f = shadowGeometryParams.radius;
        }
        if ((i & 4) != 0) {
            f2 = shadowGeometryParams.spread;
        }
        if ((i & 8) != 0) {
            color = shadowGeometryParams.color;
        }
        if ((i & 16) != 0) {
            f3 = shadowGeometryParams.offsetX;
        }
        if ((i & 32) != 0) {
            f4 = shadowGeometryParams.offsetY;
        }
        if ((i & 64) != 0) {
            f5 = shadowGeometryParams.alpha;
        }
        float f6 = f4;
        float f7 = f5;
        float f8 = f3;
        float f9 = f2;
        return shadowGeometryParams.copy(builtinShapeRecord, f, f9, color, f8, f6, f7);
    }

    @Field
    public static /* synthetic */ void getAlpha$annotations() {
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

    @Field
    public static /* synthetic */ void getRadius$annotations() {
    }

    @Field
    public static /* synthetic */ void getShape$annotations() {
    }

    @Field
    public static /* synthetic */ void getSpread$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BuiltinShapeRecord getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getSpread() {
        return this.spread;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getOffsetX() {
        return this.offsetX;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getOffsetY() {
        return this.offsetY;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    public final ShadowGeometryParams copy(BuiltinShapeRecord shape, float radius, float spread, Color color, float offsetX, float offsetY, float alpha) {
        return new ShadowGeometryParams(shape, radius, spread, color, offsetX, offsetY, alpha);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShadowGeometryParams)) {
            return false;
        }
        ShadowGeometryParams shadowGeometryParams = (ShadowGeometryParams) other;
        return Intrinsics.areEqual(this.shape, shadowGeometryParams.shape) && Float.compare(this.radius, shadowGeometryParams.radius) == 0 && Float.compare(this.spread, shadowGeometryParams.spread) == 0 && Intrinsics.areEqual(this.color, shadowGeometryParams.color) && Float.compare(this.offsetX, shadowGeometryParams.offsetX) == 0 && Float.compare(this.offsetY, shadowGeometryParams.offsetY) == 0 && Float.compare(this.alpha, shadowGeometryParams.alpha) == 0;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        BuiltinShapeRecord builtinShapeRecord = this.shape;
        int iHashCode = (((((builtinShapeRecord == null ? 0 : builtinShapeRecord.hashCode()) * 31) + Float.hashCode(this.radius)) * 31) + Float.hashCode(this.spread)) * 31;
        Color color = this.color;
        return ((((((iHashCode + (color != null ? color.hashCode() : 0)) * 31) + Float.hashCode(this.offsetX)) * 31) + Float.hashCode(this.offsetY)) * 31) + Float.hashCode(this.alpha);
    }

    public String toString() {
        return "ShadowGeometryParams(shape=" + this.shape + ", radius=" + this.radius + ", spread=" + this.spread + ", color=" + this.color + ", offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", alpha=" + this.alpha + ")";
    }

    public ShadowGeometryParams(BuiltinShapeRecord builtinShapeRecord, float f, float f2, Color color, float f3, float f4, float f5) {
        this.shape = builtinShapeRecord;
        this.radius = f;
        this.spread = f2;
        this.color = color;
        this.offsetX = f3;
        this.offsetY = f4;
        this.alpha = f5;
    }

    public /* synthetic */ ShadowGeometryParams(BuiltinShapeRecord builtinShapeRecord, float f, float f2, Color color, float f3, float f4, float f5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : builtinShapeRecord, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? 0.0f : f2, (i & 8) != 0 ? null : color, (i & 16) != 0 ? 0.0f : f3, (i & 32) != 0 ? 0.0f : f4, (i & 64) != 0 ? 1.0f : f5);
    }

    public final BuiltinShapeRecord getShape() {
        return this.shape;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getSpread() {
        return this.spread;
    }

    public final Color getColor() {
        return this.color;
    }

    public final float getOffsetX() {
        return this.offsetX;
    }

    public final float getOffsetY() {
        return this.offsetY;
    }

    public final float getAlpha() {
        return this.alpha;
    }
}
