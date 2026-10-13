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

/* JADX INFO: compiled from: AnimatedVisibilityView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001+BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012JH\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\f\u0010%\u001a\u0006\u0012\u0002\b\u00030&H\u0016J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0012R \u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u0012¨\u0006,"}, d2 = {"Lexpo/modules/ui/ExitTransitionRecord;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "type", "Lexpo/modules/ui/ExitTransitionType;", "targetAlpha", "", "targetOffsetX", "targetOffsetY", "targetScale", "<init>", "(Lexpo/modules/ui/ExitTransitionType;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getType$annotations", "()V", "getType", "()Lexpo/modules/ui/ExitTransitionType;", "getTargetAlpha$annotations", "getTargetAlpha", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTargetOffsetX$annotations", "getTargetOffsetX", "getTargetOffsetY$annotations", "getTargetOffsetY", "getTargetScale$annotations", "getTargetScale", "component1", "component2", "component3", "component4", "component5", "copy", "(Lexpo/modules/ui/ExitTransitionType;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lexpo/modules/ui/ExitTransitionRecord;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ExitTransitionRecord implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public Float targetAlpha;
    public Float targetOffsetX;
    public Float targetOffsetY;
    public Float targetScale;
    public ExitTransitionType type;

    /* JADX INFO: compiled from: AnimatedVisibilityView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/ExitTransitionRecord$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ExitTransitionRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ExitTransitionRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("type", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(ExitTransitionType.class, false, null), 0, __pika, false, true, false), new PProperty("targetAlpha", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 1, __pika, false, true, false), new PProperty("targetOffsetX", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 2, __pika, false, true, false), new PProperty("targetOffsetY", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 3, __pika, false, true, false), new PProperty("targetScale", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 4, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ExitTransitionRecord");
                return ((ExitTransitionRecord) obj).getType();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ExitTransitionRecord");
                return ((ExitTransitionRecord) obj).getTargetAlpha();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ExitTransitionRecord");
                return ((ExitTransitionRecord) obj).getTargetOffsetX();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ExitTransitionRecord");
                return ((ExitTransitionRecord) obj).getTargetOffsetY();
            }
            if (i != 4) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ExitTransitionRecord");
            return ((ExitTransitionRecord) obj).getTargetScale();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ExitTransitionRecord");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.ExitTransitionType");
                ((ExitTransitionRecord) obj).type = (ExitTransitionType) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ExitTransitionRecord");
                ((ExitTransitionRecord) obj).targetAlpha = (Float) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ExitTransitionRecord");
                ((ExitTransitionRecord) obj).targetOffsetX = (Float) obj2;
            } else if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ExitTransitionRecord");
                ((ExitTransitionRecord) obj).targetOffsetY = (Float) obj2;
            } else {
                if (i != 4) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ExitTransitionRecord");
                ((ExitTransitionRecord) obj).targetScale = (Float) obj2;
            }
        }
    }

    public ExitTransitionRecord() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ExitTransitionRecord copy$default(ExitTransitionRecord exitTransitionRecord, ExitTransitionType exitTransitionType, Float f, Float f2, Float f3, Float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            exitTransitionType = exitTransitionRecord.type;
        }
        if ((i & 2) != 0) {
            f = exitTransitionRecord.targetAlpha;
        }
        if ((i & 4) != 0) {
            f2 = exitTransitionRecord.targetOffsetX;
        }
        if ((i & 8) != 0) {
            f3 = exitTransitionRecord.targetOffsetY;
        }
        if ((i & 16) != 0) {
            f4 = exitTransitionRecord.targetScale;
        }
        Float f5 = f4;
        Float f6 = f2;
        return exitTransitionRecord.copy(exitTransitionType, f, f6, f3, f5);
    }

    @Field
    public static /* synthetic */ void getTargetAlpha$annotations() {
    }

    @Field
    public static /* synthetic */ void getTargetOffsetX$annotations() {
    }

    @Field
    public static /* synthetic */ void getTargetOffsetY$annotations() {
    }

    @Field
    public static /* synthetic */ void getTargetScale$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ExitTransitionType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getTargetAlpha() {
        return this.targetAlpha;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getTargetOffsetX() {
        return this.targetOffsetX;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getTargetOffsetY() {
        return this.targetOffsetY;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Float getTargetScale() {
        return this.targetScale;
    }

    public final ExitTransitionRecord copy(ExitTransitionType type, Float targetAlpha, Float targetOffsetX, Float targetOffsetY, Float targetScale) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ExitTransitionRecord(type, targetAlpha, targetOffsetX, targetOffsetY, targetScale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExitTransitionRecord)) {
            return false;
        }
        ExitTransitionRecord exitTransitionRecord = (ExitTransitionRecord) other;
        return this.type == exitTransitionRecord.type && Intrinsics.areEqual((Object) this.targetAlpha, (Object) exitTransitionRecord.targetAlpha) && Intrinsics.areEqual((Object) this.targetOffsetX, (Object) exitTransitionRecord.targetOffsetX) && Intrinsics.areEqual((Object) this.targetOffsetY, (Object) exitTransitionRecord.targetOffsetY) && Intrinsics.areEqual((Object) this.targetScale, (Object) exitTransitionRecord.targetScale);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Float f = this.targetAlpha;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.targetOffsetX;
        int iHashCode3 = (iHashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.targetOffsetY;
        int iHashCode4 = (iHashCode3 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.targetScale;
        return iHashCode4 + (f4 != null ? f4.hashCode() : 0);
    }

    public String toString() {
        return "ExitTransitionRecord(type=" + this.type + ", targetAlpha=" + this.targetAlpha + ", targetOffsetX=" + this.targetOffsetX + ", targetOffsetY=" + this.targetOffsetY + ", targetScale=" + this.targetScale + ")";
    }

    public ExitTransitionRecord(ExitTransitionType type, Float f, Float f2, Float f3, Float f4) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.targetAlpha = f;
        this.targetOffsetX = f2;
        this.targetOffsetY = f3;
        this.targetScale = f4;
    }

    public /* synthetic */ ExitTransitionRecord(ExitTransitionType exitTransitionType, Float f, Float f2, Float f3, Float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ExitTransitionType.FADE_OUT : exitTransitionType, (i & 2) != 0 ? null : f, (i & 4) != 0 ? null : f2, (i & 8) != 0 ? null : f3, (i & 16) != 0 ? null : f4);
    }

    public final ExitTransitionType getType() {
        return this.type;
    }

    public final Float getTargetAlpha() {
        return this.targetAlpha;
    }

    public final Float getTargetOffsetX() {
        return this.targetOffsetX;
    }

    public final Float getTargetOffsetY() {
        return this.targetOffsetY;
    }

    public final Float getTargetScale() {
        return this.targetScale;
    }
}
