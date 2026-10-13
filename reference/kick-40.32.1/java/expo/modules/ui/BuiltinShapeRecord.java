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

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00015BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003J`\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\f\u0010/\u001a\u0006\u0012\u0002\b\u000300H\u0016J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0015R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0015R \u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0015R \u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010!¨\u00066"}, d2 = {"Lexpo/modules/ui/BuiltinShapeRecord;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "type", "Lexpo/modules/ui/BuiltinShapeType;", "radius", "", "topStart", "topEnd", "bottomStart", "bottomEnd", "name", "Lexpo/modules/ui/MaterialShapeType;", "<init>", "(Lexpo/modules/ui/BuiltinShapeType;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/ui/MaterialShapeType;)V", "getType$annotations", "()V", "getType", "()Lexpo/modules/ui/BuiltinShapeType;", "getRadius$annotations", "getRadius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTopStart$annotations", "getTopStart", "getTopEnd$annotations", "getTopEnd", "getBottomStart$annotations", "getBottomStart", "getBottomEnd$annotations", "getBottomEnd", "getName$annotations", "getName", "()Lexpo/modules/ui/MaterialShapeType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lexpo/modules/ui/BuiltinShapeType;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/ui/MaterialShapeType;)Lexpo/modules/ui/BuiltinShapeRecord;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BuiltinShapeRecord implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public Float bottomEnd;
    public Float bottomStart;
    public MaterialShapeType name;
    public Float radius;
    public Float topEnd;
    public Float topStart;
    public BuiltinShapeType type;

    /* JADX INFO: compiled from: ModifierRegistry.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/BuiltinShapeRecord$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<BuiltinShapeRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(BuiltinShapeRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("type", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(BuiltinShapeType.class, false, null), 0, __pika, false, true, false), new PProperty("radius", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 1, __pika, false, true, false), new PProperty("topStart", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 2, __pika, false, true, false), new PProperty("topEnd", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 3, __pika, false, true, false), new PProperty("bottomStart", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 4, __pika, false, true, false), new PProperty("bottomEnd", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 5, __pika, false, true, false), new PProperty("name", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(MaterialShapeType.class, true, null), 6, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    return ((BuiltinShapeRecord) obj).getType();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    return ((BuiltinShapeRecord) obj).getRadius();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    return ((BuiltinShapeRecord) obj).getTopStart();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    return ((BuiltinShapeRecord) obj).getTopEnd();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    return ((BuiltinShapeRecord) obj).getBottomStart();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    return ((BuiltinShapeRecord) obj).getBottomEnd();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    return ((BuiltinShapeRecord) obj).getName();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeType");
                    ((BuiltinShapeRecord) obj).type = (BuiltinShapeType) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    ((BuiltinShapeRecord) obj).radius = (Float) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    ((BuiltinShapeRecord) obj).topStart = (Float) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    ((BuiltinShapeRecord) obj).topEnd = (Float) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    ((BuiltinShapeRecord) obj).bottomStart = (Float) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    ((BuiltinShapeRecord) obj).bottomEnd = (Float) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.BuiltinShapeRecord");
                    ((BuiltinShapeRecord) obj).name = (MaterialShapeType) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public BuiltinShapeRecord() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ BuiltinShapeRecord copy$default(BuiltinShapeRecord builtinShapeRecord, BuiltinShapeType builtinShapeType, Float f, Float f2, Float f3, Float f4, Float f5, MaterialShapeType materialShapeType, int i, Object obj) {
        if ((i & 1) != 0) {
            builtinShapeType = builtinShapeRecord.type;
        }
        if ((i & 2) != 0) {
            f = builtinShapeRecord.radius;
        }
        if ((i & 4) != 0) {
            f2 = builtinShapeRecord.topStart;
        }
        if ((i & 8) != 0) {
            f3 = builtinShapeRecord.topEnd;
        }
        if ((i & 16) != 0) {
            f4 = builtinShapeRecord.bottomStart;
        }
        if ((i & 32) != 0) {
            f5 = builtinShapeRecord.bottomEnd;
        }
        if ((i & 64) != 0) {
            materialShapeType = builtinShapeRecord.name;
        }
        Float f6 = f5;
        MaterialShapeType materialShapeType2 = materialShapeType;
        Float f7 = f4;
        Float f8 = f2;
        return builtinShapeRecord.copy(builtinShapeType, f, f8, f3, f7, f6, materialShapeType2);
    }

    @Field
    public static /* synthetic */ void getBottomEnd$annotations() {
    }

    @Field
    public static /* synthetic */ void getBottomStart$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void getRadius$annotations() {
    }

    @Field
    public static /* synthetic */ void getTopEnd$annotations() {
    }

    @Field
    public static /* synthetic */ void getTopStart$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BuiltinShapeType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getRadius() {
        return this.radius;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getTopStart() {
        return this.topStart;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getTopEnd() {
        return this.topEnd;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Float getBottomStart() {
        return this.bottomStart;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Float getBottomEnd() {
        return this.bottomEnd;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MaterialShapeType getName() {
        return this.name;
    }

    public final BuiltinShapeRecord copy(BuiltinShapeType type, Float radius, Float topStart, Float topEnd, Float bottomStart, Float bottomEnd, MaterialShapeType name) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new BuiltinShapeRecord(type, radius, topStart, topEnd, bottomStart, bottomEnd, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuiltinShapeRecord)) {
            return false;
        }
        BuiltinShapeRecord builtinShapeRecord = (BuiltinShapeRecord) other;
        return this.type == builtinShapeRecord.type && Intrinsics.areEqual((Object) this.radius, (Object) builtinShapeRecord.radius) && Intrinsics.areEqual((Object) this.topStart, (Object) builtinShapeRecord.topStart) && Intrinsics.areEqual((Object) this.topEnd, (Object) builtinShapeRecord.topEnd) && Intrinsics.areEqual((Object) this.bottomStart, (Object) builtinShapeRecord.bottomStart) && Intrinsics.areEqual((Object) this.bottomEnd, (Object) builtinShapeRecord.bottomEnd) && this.name == builtinShapeRecord.name;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Float f = this.radius;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.topStart;
        int iHashCode3 = (iHashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.topEnd;
        int iHashCode4 = (iHashCode3 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.bottomStart;
        int iHashCode5 = (iHashCode4 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Float f5 = this.bottomEnd;
        int iHashCode6 = (iHashCode5 + (f5 == null ? 0 : f5.hashCode())) * 31;
        MaterialShapeType materialShapeType = this.name;
        return iHashCode6 + (materialShapeType != null ? materialShapeType.hashCode() : 0);
    }

    public String toString() {
        return "BuiltinShapeRecord(type=" + this.type + ", radius=" + this.radius + ", topStart=" + this.topStart + ", topEnd=" + this.topEnd + ", bottomStart=" + this.bottomStart + ", bottomEnd=" + this.bottomEnd + ", name=" + this.name + ")";
    }

    public BuiltinShapeRecord(BuiltinShapeType type, Float f, Float f2, Float f3, Float f4, Float f5, MaterialShapeType materialShapeType) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.radius = f;
        this.topStart = f2;
        this.topEnd = f3;
        this.bottomStart = f4;
        this.bottomEnd = f5;
        this.name = materialShapeType;
    }

    public /* synthetic */ BuiltinShapeRecord(BuiltinShapeType builtinShapeType, Float f, Float f2, Float f3, Float f4, Float f5, MaterialShapeType materialShapeType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BuiltinShapeType.RECTANGLE : builtinShapeType, (i & 2) != 0 ? null : f, (i & 4) != 0 ? null : f2, (i & 8) != 0 ? null : f3, (i & 16) != 0 ? null : f4, (i & 32) != 0 ? null : f5, (i & 64) != 0 ? null : materialShapeType);
    }

    public final BuiltinShapeType getType() {
        return this.type;
    }

    public final Float getRadius() {
        return this.radius;
    }

    public final Float getTopStart() {
        return this.topStart;
    }

    public final Float getTopEnd() {
        return this.topEnd;
    }

    public final Float getBottomStart() {
        return this.bottomStart;
    }

    public final Float getBottomEnd() {
        return this.bottomEnd;
    }

    public final MaterialShapeType getName() {
        return this.name;
    }
}
