package expo.modules.ui.convertibles;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
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

/* JADX INFO: compiled from: AnimationSpecParams.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001$B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0011J.\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\f\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0016J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Lexpo/modules/ui/convertibles/SpringSpecParams;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "dampingRatio", "", "stiffness", "visibilityThreshold", "<init>", "(FFLjava/lang/Float;)V", "getDampingRatio$annotations", "()V", "getDampingRatio", "()F", "getStiffness$annotations", "getStiffness", "getVisibilityThreshold$annotations", "getVisibilityThreshold", "()Ljava/lang/Float;", "Ljava/lang/Float;", "toAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "component1", "component2", "component3", "copy", "(FFLjava/lang/Float;)Lexpo/modules/ui/convertibles/SpringSpecParams;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SpringSpecParams implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public float dampingRatio;
    public float stiffness;
    public Float visibilityThreshold;

    /* JADX INFO: compiled from: AnimationSpecParams.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/convertibles/SpringSpecParams$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<SpringSpecParams> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(SpringSpecParams.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("dampingRatio", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 0, __pika, false, true, false), new PProperty("stiffness", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 1, __pika, false, true, false), new PProperty("visibilityThreshold", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 2, __pika, false, true, false)}, new PFunction[]{new PFunction("toAnimationSpec", PVisibility.PUBLIC), new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.SpringSpecParams");
                return Float.valueOf(((SpringSpecParams) obj).getDampingRatio());
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.SpringSpecParams");
                return Float.valueOf(((SpringSpecParams) obj).getStiffness());
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.SpringSpecParams");
            return ((SpringSpecParams) obj).getVisibilityThreshold();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.SpringSpecParams");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                ((SpringSpecParams) obj).dampingRatio = ((Float) obj2).floatValue();
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.SpringSpecParams");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                ((SpringSpecParams) obj).stiffness = ((Float) obj2).floatValue();
                return;
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.SpringSpecParams");
            ((SpringSpecParams) obj).visibilityThreshold = (Float) obj2;
        }
    }

    public SpringSpecParams() {
        this(0.0f, 0.0f, null, 7, null);
    }

    public static /* synthetic */ SpringSpecParams copy$default(SpringSpecParams springSpecParams, float f, float f2, Float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = springSpecParams.dampingRatio;
        }
        if ((i & 2) != 0) {
            f2 = springSpecParams.stiffness;
        }
        if ((i & 4) != 0) {
            f3 = springSpecParams.visibilityThreshold;
        }
        return springSpecParams.copy(f, f2, f3);
    }

    @Field
    public static /* synthetic */ void getDampingRatio$annotations() {
    }

    @Field
    public static /* synthetic */ void getStiffness$annotations() {
    }

    @Field
    public static /* synthetic */ void getVisibilityThreshold$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getStiffness() {
        return this.stiffness;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getVisibilityThreshold() {
        return this.visibilityThreshold;
    }

    public final SpringSpecParams copy(float dampingRatio, float stiffness, Float visibilityThreshold) {
        return new SpringSpecParams(dampingRatio, stiffness, visibilityThreshold);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpringSpecParams)) {
            return false;
        }
        SpringSpecParams springSpecParams = (SpringSpecParams) other;
        return Float.compare(this.dampingRatio, springSpecParams.dampingRatio) == 0 && Float.compare(this.stiffness, springSpecParams.stiffness) == 0 && Intrinsics.areEqual((Object) this.visibilityThreshold, (Object) springSpecParams.visibilityThreshold);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((Float.hashCode(this.dampingRatio) * 31) + Float.hashCode(this.stiffness)) * 31;
        Float f = this.visibilityThreshold;
        return iHashCode + (f == null ? 0 : f.hashCode());
    }

    public String toString() {
        return "SpringSpecParams(dampingRatio=" + this.dampingRatio + ", stiffness=" + this.stiffness + ", visibilityThreshold=" + this.visibilityThreshold + ")";
    }

    public SpringSpecParams(float f, float f2, Float f3) {
        this.dampingRatio = f;
        this.stiffness = f2;
        this.visibilityThreshold = f3;
    }

    public /* synthetic */ SpringSpecParams(float f, float f2, Float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1500.0f : f2, (i & 4) != 0 ? null : f3);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    public final Float getVisibilityThreshold() {
        return this.visibilityThreshold;
    }

    public final AnimationSpec<Float> toAnimationSpec() {
        return AnimationSpecKt.spring(this.dampingRatio, this.stiffness, this.visibilityThreshold);
    }
}
