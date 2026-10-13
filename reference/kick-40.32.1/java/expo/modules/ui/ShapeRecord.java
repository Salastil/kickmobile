package expo.modules.ui;

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

/* JADX INFO: compiled from: ShapeView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00014BO\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003JQ\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\f\u0010/\u001a\u0006\u0012\u0002\b\u000300H\u0016J\t\u00101\u001a\u00020\u0007HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u001c\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\"¨\u00065"}, d2 = {"Lexpo/modules/ui/ShapeRecord;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "cornerRounding", "", "smoothing", "verticesCount", "", "innerRadius", "radius", "cornerRadii", "Lexpo/modules/ui/CornerRadii;", "type", "Lexpo/modules/ui/ShapeType;", "<init>", "(FFIFFLexpo/modules/ui/CornerRadii;Lexpo/modules/ui/ShapeType;)V", "getCornerRounding$annotations", "()V", "getCornerRounding", "()F", "getSmoothing$annotations", "getSmoothing", "getVerticesCount$annotations", "getVerticesCount", "()I", "getInnerRadius$annotations", "getInnerRadius", "getRadius$annotations", "getRadius", "getCornerRadii$annotations", "getCornerRadii", "()Lexpo/modules/ui/CornerRadii;", "getType$annotations", "getType", "()Lexpo/modules/ui/ShapeType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ShapeRecord implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public CornerRadii cornerRadii;
    public float cornerRounding;
    public float innerRadius;
    public float radius;
    public float smoothing;
    public ShapeType type;
    public int verticesCount;

    /* JADX INFO: compiled from: ShapeView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/ShapeRecord$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ShapeRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ShapeRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("cornerRounding", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 0, __pika, false, true, false), new PProperty("smoothing", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 1, __pika, false, true, false), new PProperty("verticesCount", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.INT, 2, __pika, false, true, false), new PProperty("innerRadius", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 3, __pika, false, true, false), new PProperty("radius", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 4, __pika, false, true, false), new PProperty("cornerRadii", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(CornerRadii.class, true, CornerRadii.__Pika.__pika$IntrospectionData), 5, __pika, false, true, false), new PProperty("type", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(ShapeType.class, false, null), 6, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    return Float.valueOf(((ShapeRecord) obj).getCornerRounding());
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    return Float.valueOf(((ShapeRecord) obj).getSmoothing());
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    return Integer.valueOf(((ShapeRecord) obj).getVerticesCount());
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    return Float.valueOf(((ShapeRecord) obj).getInnerRadius());
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    return Float.valueOf(((ShapeRecord) obj).getRadius());
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    return ((ShapeRecord) obj).getCornerRadii();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    return ((ShapeRecord) obj).getType();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((ShapeRecord) obj).cornerRounding = ((Float) obj2).floatValue();
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((ShapeRecord) obj).smoothing = ((Float) obj2).floatValue();
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    ((ShapeRecord) obj).verticesCount = ((Integer) obj2).intValue();
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((ShapeRecord) obj).innerRadius = ((Float) obj2).floatValue();
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((ShapeRecord) obj).radius = ((Float) obj2).floatValue();
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    ((ShapeRecord) obj).cornerRadii = (CornerRadii) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ShapeRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.ShapeType");
                    ((ShapeRecord) obj).type = (ShapeType) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public ShapeRecord() {
        this(0.0f, 0.0f, 0, 0.0f, 0.0f, null, null, 127, null);
    }

    public static /* synthetic */ ShapeRecord copy$default(ShapeRecord shapeRecord, float f, float f2, int i, float f3, float f4, CornerRadii cornerRadii, ShapeType shapeType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = shapeRecord.cornerRounding;
        }
        if ((i2 & 2) != 0) {
            f2 = shapeRecord.smoothing;
        }
        if ((i2 & 4) != 0) {
            i = shapeRecord.verticesCount;
        }
        if ((i2 & 8) != 0) {
            f3 = shapeRecord.innerRadius;
        }
        if ((i2 & 16) != 0) {
            f4 = shapeRecord.radius;
        }
        if ((i2 & 32) != 0) {
            cornerRadii = shapeRecord.cornerRadii;
        }
        if ((i2 & 64) != 0) {
            shapeType = shapeRecord.type;
        }
        CornerRadii cornerRadii2 = cornerRadii;
        ShapeType shapeType2 = shapeType;
        float f5 = f4;
        int i3 = i;
        return shapeRecord.copy(f, f2, i3, f3, f5, cornerRadii2, shapeType2);
    }

    @Field
    public static /* synthetic */ void getCornerRadii$annotations() {
    }

    @Field
    public static /* synthetic */ void getCornerRounding$annotations() {
    }

    @Field
    public static /* synthetic */ void getInnerRadius$annotations() {
    }

    @Field
    public static /* synthetic */ void getRadius$annotations() {
    }

    @Field
    public static /* synthetic */ void getSmoothing$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    @Field
    public static /* synthetic */ void getVerticesCount$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getCornerRounding() {
        return this.cornerRounding;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getSmoothing() {
        return this.smoothing;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVerticesCount() {
        return this.verticesCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getInnerRadius() {
        return this.innerRadius;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final CornerRadii getCornerRadii() {
        return this.cornerRadii;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ShapeType getType() {
        return this.type;
    }

    public final ShapeRecord copy(float cornerRounding, float smoothing, int verticesCount, float innerRadius, float radius, CornerRadii cornerRadii, ShapeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ShapeRecord(cornerRounding, smoothing, verticesCount, innerRadius, radius, cornerRadii, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShapeRecord)) {
            return false;
        }
        ShapeRecord shapeRecord = (ShapeRecord) other;
        return Float.compare(this.cornerRounding, shapeRecord.cornerRounding) == 0 && Float.compare(this.smoothing, shapeRecord.smoothing) == 0 && this.verticesCount == shapeRecord.verticesCount && Float.compare(this.innerRadius, shapeRecord.innerRadius) == 0 && Float.compare(this.radius, shapeRecord.radius) == 0 && Intrinsics.areEqual(this.cornerRadii, shapeRecord.cornerRadii) && this.type == shapeRecord.type;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((((((((Float.hashCode(this.cornerRounding) * 31) + Float.hashCode(this.smoothing)) * 31) + Integer.hashCode(this.verticesCount)) * 31) + Float.hashCode(this.innerRadius)) * 31) + Float.hashCode(this.radius)) * 31;
        CornerRadii cornerRadii = this.cornerRadii;
        return ((iHashCode + (cornerRadii == null ? 0 : cornerRadii.hashCode())) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ShapeRecord(cornerRounding=" + this.cornerRounding + ", smoothing=" + this.smoothing + ", verticesCount=" + this.verticesCount + ", innerRadius=" + this.innerRadius + ", radius=" + this.radius + ", cornerRadii=" + this.cornerRadii + ", type=" + this.type + ")";
    }

    public ShapeRecord(float f, float f2, int i, float f3, float f4, CornerRadii cornerRadii, ShapeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.cornerRounding = f;
        this.smoothing = f2;
        this.verticesCount = i;
        this.innerRadius = f3;
        this.radius = f4;
        this.cornerRadii = cornerRadii;
        this.type = type;
    }

    public final float getCornerRounding() {
        return this.cornerRounding;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    public final int getVerticesCount() {
        return this.verticesCount;
    }

    public final float getInnerRadius() {
        return this.innerRadius;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final CornerRadii getCornerRadii() {
        return this.cornerRadii;
    }

    public final ShapeType getType() {
        return this.type;
    }

    public /* synthetic */ ShapeRecord(float f, float f2, int i, float f3, float f4, CornerRadii cornerRadii, ShapeType shapeType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0f : f, (i2 & 2) != 0 ? 0.0f : f2, (i2 & 4) != 0 ? 6 : i, (i2 & 8) != 0 ? 0.0f : f3, (i2 & 16) != 0 ? 0.0f : f4, (i2 & 32) != 0 ? null : cornerRadii, (i2 & 64) != 0 ? ShapeType.CIRCLE : shapeType);
    }
}
