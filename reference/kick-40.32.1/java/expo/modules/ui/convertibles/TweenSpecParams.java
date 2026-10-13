package expo.modules.ui.convertibles;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001#B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\f\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0016J\t\u0010 \u001a\u00020\u0004HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lexpo/modules/ui/convertibles/TweenSpecParams;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "durationMillis", "", "delayMillis", "easing", "Lexpo/modules/ui/convertibles/EasingType;", "<init>", "(IILexpo/modules/ui/convertibles/EasingType;)V", "getDurationMillis$annotations", "()V", "getDurationMillis", "()I", "getDelayMillis$annotations", "getDelayMillis", "getEasing$annotations", "getEasing", "()Lexpo/modules/ui/convertibles/EasingType;", "toAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TweenSpecParams implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public int delayMillis;
    public int durationMillis;
    public EasingType easing;

    /* JADX INFO: compiled from: AnimationSpecParams.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/convertibles/TweenSpecParams$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<TweenSpecParams> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(TweenSpecParams.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("durationMillis", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.INT, 0, __pika, false, true, false), new PProperty("delayMillis", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.INT, 1, __pika, false, true, false), new PProperty("easing", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(EasingType.class, true, null), 2, __pika, false, true, false)}, new PFunction[]{new PFunction("toAnimationSpec", PVisibility.PUBLIC), new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.TweenSpecParams");
                return Integer.valueOf(((TweenSpecParams) obj).getDurationMillis());
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.TweenSpecParams");
                return Integer.valueOf(((TweenSpecParams) obj).getDelayMillis());
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.TweenSpecParams");
            return ((TweenSpecParams) obj).getEasing();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.TweenSpecParams");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                ((TweenSpecParams) obj).durationMillis = ((Integer) obj2).intValue();
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.TweenSpecParams");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                ((TweenSpecParams) obj).delayMillis = ((Integer) obj2).intValue();
                return;
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.convertibles.TweenSpecParams");
            ((TweenSpecParams) obj).easing = (EasingType) obj2;
        }
    }

    public TweenSpecParams() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ TweenSpecParams copy$default(TweenSpecParams tweenSpecParams, int i, int i2, EasingType easingType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = tweenSpecParams.durationMillis;
        }
        if ((i3 & 2) != 0) {
            i2 = tweenSpecParams.delayMillis;
        }
        if ((i3 & 4) != 0) {
            easingType = tweenSpecParams.easing;
        }
        return tweenSpecParams.copy(i, i2, easingType);
    }

    @Field
    public static /* synthetic */ void getDelayMillis$annotations() {
    }

    @Field
    public static /* synthetic */ void getDurationMillis$annotations() {
    }

    @Field
    public static /* synthetic */ void getEasing$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDurationMillis() {
        return this.durationMillis;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDelayMillis() {
        return this.delayMillis;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final EasingType getEasing() {
        return this.easing;
    }

    public final TweenSpecParams copy(int durationMillis, int delayMillis, EasingType easing) {
        return new TweenSpecParams(durationMillis, delayMillis, easing);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TweenSpecParams)) {
            return false;
        }
        TweenSpecParams tweenSpecParams = (TweenSpecParams) other;
        return this.durationMillis == tweenSpecParams.durationMillis && this.delayMillis == tweenSpecParams.delayMillis && this.easing == tweenSpecParams.easing;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.durationMillis) * 31) + Integer.hashCode(this.delayMillis)) * 31;
        EasingType easingType = this.easing;
        return iHashCode + (easingType == null ? 0 : easingType.hashCode());
    }

    public String toString() {
        return "TweenSpecParams(durationMillis=" + this.durationMillis + ", delayMillis=" + this.delayMillis + ", easing=" + this.easing + ")";
    }

    public TweenSpecParams(int i, int i2, EasingType easingType) {
        this.durationMillis = i;
        this.delayMillis = i2;
        this.easing = easingType;
    }

    public /* synthetic */ TweenSpecParams(int i, int i2, EasingType easingType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 300 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : easingType);
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final int getDelayMillis() {
        return this.delayMillis;
    }

    public final EasingType getEasing() {
        return this.easing;
    }

    public final AnimationSpec<Float> toAnimationSpec() {
        Easing fastOutSlowInEasing;
        int i = this.durationMillis;
        int i2 = this.delayMillis;
        EasingType easingType = this.easing;
        if (easingType == null || (fastOutSlowInEasing = easingType.toEasing()) == null) {
            fastOutSlowInEasing = EasingKt.getFastOutSlowInEasing();
        }
        return AnimationSpecKt.tween(i, i2, fastOutSlowInEasing);
    }
}
