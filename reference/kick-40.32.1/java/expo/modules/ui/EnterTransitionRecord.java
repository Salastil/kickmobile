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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001+BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012JH\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\f\u0010%\u001a\u0006\u0012\u0002\b\u00030&H\u0016J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0012R \u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u0012¨\u0006,"}, d2 = {"Lexpo/modules/ui/EnterTransitionRecord;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "type", "Lexpo/modules/ui/EnterTransitionType;", "initialAlpha", "", "initialOffsetX", "initialOffsetY", "initialScale", "<init>", "(Lexpo/modules/ui/EnterTransitionType;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getType$annotations", "()V", "getType", "()Lexpo/modules/ui/EnterTransitionType;", "getInitialAlpha$annotations", "getInitialAlpha", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getInitialOffsetX$annotations", "getInitialOffsetX", "getInitialOffsetY$annotations", "getInitialOffsetY", "getInitialScale$annotations", "getInitialScale", "component1", "component2", "component3", "component4", "component5", "copy", "(Lexpo/modules/ui/EnterTransitionType;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lexpo/modules/ui/EnterTransitionRecord;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class EnterTransitionRecord implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public Float initialAlpha;
    public Float initialOffsetX;
    public Float initialOffsetY;
    public Float initialScale;
    public EnterTransitionType type;

    /* JADX INFO: compiled from: AnimatedVisibilityView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/EnterTransitionRecord$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<EnterTransitionRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(EnterTransitionRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("type", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(EnterTransitionType.class, false, null), 0, __pika, false, true, false), new PProperty("initialAlpha", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 1, __pika, false, true, false), new PProperty("initialOffsetX", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 2, __pika, false, true, false), new PProperty("initialOffsetY", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 3, __pika, false, true, false), new PProperty("initialScale", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 4, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.EnterTransitionRecord");
                return ((EnterTransitionRecord) obj).getType();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.EnterTransitionRecord");
                return ((EnterTransitionRecord) obj).getInitialAlpha();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.EnterTransitionRecord");
                return ((EnterTransitionRecord) obj).getInitialOffsetX();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.EnterTransitionRecord");
                return ((EnterTransitionRecord) obj).getInitialOffsetY();
            }
            if (i != 4) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.EnterTransitionRecord");
            return ((EnterTransitionRecord) obj).getInitialScale();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.EnterTransitionRecord");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.EnterTransitionType");
                ((EnterTransitionRecord) obj).type = (EnterTransitionType) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.EnterTransitionRecord");
                ((EnterTransitionRecord) obj).initialAlpha = (Float) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.EnterTransitionRecord");
                ((EnterTransitionRecord) obj).initialOffsetX = (Float) obj2;
            } else if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.EnterTransitionRecord");
                ((EnterTransitionRecord) obj).initialOffsetY = (Float) obj2;
            } else {
                if (i != 4) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.EnterTransitionRecord");
                ((EnterTransitionRecord) obj).initialScale = (Float) obj2;
            }
        }
    }

    public EnterTransitionRecord() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ EnterTransitionRecord copy$default(EnterTransitionRecord enterTransitionRecord, EnterTransitionType enterTransitionType, Float f, Float f2, Float f3, Float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            enterTransitionType = enterTransitionRecord.type;
        }
        if ((i & 2) != 0) {
            f = enterTransitionRecord.initialAlpha;
        }
        if ((i & 4) != 0) {
            f2 = enterTransitionRecord.initialOffsetX;
        }
        if ((i & 8) != 0) {
            f3 = enterTransitionRecord.initialOffsetY;
        }
        if ((i & 16) != 0) {
            f4 = enterTransitionRecord.initialScale;
        }
        Float f5 = f4;
        Float f6 = f2;
        return enterTransitionRecord.copy(enterTransitionType, f, f6, f3, f5);
    }

    @Field
    public static /* synthetic */ void getInitialAlpha$annotations() {
    }

    @Field
    public static /* synthetic */ void getInitialOffsetX$annotations() {
    }

    @Field
    public static /* synthetic */ void getInitialOffsetY$annotations() {
    }

    @Field
    public static /* synthetic */ void getInitialScale$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EnterTransitionType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getInitialAlpha() {
        return this.initialAlpha;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getInitialOffsetX() {
        return this.initialOffsetX;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getInitialOffsetY() {
        return this.initialOffsetY;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Float getInitialScale() {
        return this.initialScale;
    }

    public final EnterTransitionRecord copy(EnterTransitionType type, Float initialAlpha, Float initialOffsetX, Float initialOffsetY, Float initialScale) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new EnterTransitionRecord(type, initialAlpha, initialOffsetX, initialOffsetY, initialScale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterTransitionRecord)) {
            return false;
        }
        EnterTransitionRecord enterTransitionRecord = (EnterTransitionRecord) other;
        return this.type == enterTransitionRecord.type && Intrinsics.areEqual((Object) this.initialAlpha, (Object) enterTransitionRecord.initialAlpha) && Intrinsics.areEqual((Object) this.initialOffsetX, (Object) enterTransitionRecord.initialOffsetX) && Intrinsics.areEqual((Object) this.initialOffsetY, (Object) enterTransitionRecord.initialOffsetY) && Intrinsics.areEqual((Object) this.initialScale, (Object) enterTransitionRecord.initialScale);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Float f = this.initialAlpha;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.initialOffsetX;
        int iHashCode3 = (iHashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.initialOffsetY;
        int iHashCode4 = (iHashCode3 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.initialScale;
        return iHashCode4 + (f4 != null ? f4.hashCode() : 0);
    }

    public String toString() {
        return "EnterTransitionRecord(type=" + this.type + ", initialAlpha=" + this.initialAlpha + ", initialOffsetX=" + this.initialOffsetX + ", initialOffsetY=" + this.initialOffsetY + ", initialScale=" + this.initialScale + ")";
    }

    public EnterTransitionRecord(EnterTransitionType type, Float f, Float f2, Float f3, Float f4) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.initialAlpha = f;
        this.initialOffsetX = f2;
        this.initialOffsetY = f3;
        this.initialScale = f4;
    }

    public /* synthetic */ EnterTransitionRecord(EnterTransitionType enterTransitionType, Float f, Float f2, Float f3, Float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? EnterTransitionType.FADE_IN : enterTransitionType, (i & 2) != 0 ? null : f, (i & 4) != 0 ? null : f2, (i & 8) != 0 ? null : f3, (i & 16) != 0 ? null : f4);
    }

    public final EnterTransitionType getType() {
        return this.type;
    }

    public final Float getInitialAlpha() {
        return this.initialAlpha;
    }

    public final Float getInitialOffsetX() {
        return this.initialOffsetX;
    }

    public final Float getInitialOffsetY() {
        return this.initialOffsetY;
    }

    public final Float getInitialScale() {
        return this.initialScale;
    }
}
