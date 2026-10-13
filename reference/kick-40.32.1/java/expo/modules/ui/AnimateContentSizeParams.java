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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001bB\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\f\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u001c"}, d2 = {"Lexpo/modules/ui/AnimateContentSizeParams;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "dampingRatio", "", "stiffness", "<init>", "(FF)V", "getDampingRatio$annotations", "()V", "getDampingRatio", "()F", "getStiffness$annotations", "getStiffness", "component1", "component2", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnimateContentSizeParams implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public float dampingRatio;
    public float stiffness;

    /* JADX INFO: compiled from: ModifierRegistry.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/AnimateContentSizeParams$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<AnimateContentSizeParams> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(AnimateContentSizeParams.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("dampingRatio", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 0, __pika, false, true, false), new PProperty("stiffness", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 1, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            float dampingRatio;
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AnimateContentSizeParams");
                dampingRatio = ((AnimateContentSizeParams) obj).getDampingRatio();
            } else {
                if (i != 1) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AnimateContentSizeParams");
                dampingRatio = ((AnimateContentSizeParams) obj).getStiffness();
            }
            return Float.valueOf(dampingRatio);
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AnimateContentSizeParams");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                ((AnimateContentSizeParams) obj).dampingRatio = ((Float) obj2).floatValue();
                return;
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AnimateContentSizeParams");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            ((AnimateContentSizeParams) obj).stiffness = ((Float) obj2).floatValue();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AnimateContentSizeParams() {
        float f = 0.0f;
        this(f, f, 3, null);
    }

    public static /* synthetic */ AnimateContentSizeParams copy$default(AnimateContentSizeParams animateContentSizeParams, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = animateContentSizeParams.dampingRatio;
        }
        if ((i & 2) != 0) {
            f2 = animateContentSizeParams.stiffness;
        }
        return animateContentSizeParams.copy(f, f2);
    }

    @Field
    public static /* synthetic */ void getDampingRatio$annotations() {
    }

    @Field
    public static /* synthetic */ void getStiffness$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getStiffness() {
        return this.stiffness;
    }

    public final AnimateContentSizeParams copy(float dampingRatio, float stiffness) {
        return new AnimateContentSizeParams(dampingRatio, stiffness);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimateContentSizeParams)) {
            return false;
        }
        AnimateContentSizeParams animateContentSizeParams = (AnimateContentSizeParams) other;
        return Float.compare(this.dampingRatio, animateContentSizeParams.dampingRatio) == 0 && Float.compare(this.stiffness, animateContentSizeParams.stiffness) == 0;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (Float.hashCode(this.dampingRatio) * 31) + Float.hashCode(this.stiffness);
    }

    public String toString() {
        return "AnimateContentSizeParams(dampingRatio=" + this.dampingRatio + ", stiffness=" + this.stiffness + ")";
    }

    public AnimateContentSizeParams(float f, float f2) {
        this.dampingRatio = f;
        this.stiffness = f2;
    }

    public /* synthetic */ AnimateContentSizeParams(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1500.0f : f2);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }
}
