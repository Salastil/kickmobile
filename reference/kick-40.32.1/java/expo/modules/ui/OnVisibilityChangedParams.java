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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dB\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\f\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lexpo/modules/ui/OnVisibilityChangedParams;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "minDurationMs", "", "minFractionVisible", "", "<init>", "(JF)V", "getMinDurationMs$annotations", "()V", "getMinDurationMs", "()J", "getMinFractionVisible$annotations", "getMinFractionVisible", "()F", "component1", "component2", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OnVisibilityChangedParams implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public long minDurationMs;
    public float minFractionVisible;

    /* JADX INFO: compiled from: ModifierRegistry.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/OnVisibilityChangedParams$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<OnVisibilityChangedParams> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(OnVisibilityChangedParams.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("minDurationMs", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.LONG, 0, __pika, false, true, false), new PProperty("minFractionVisible", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT, 1, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.OnVisibilityChangedParams");
                return Long.valueOf(((OnVisibilityChangedParams) obj).getMinDurationMs());
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.OnVisibilityChangedParams");
            return Float.valueOf(((OnVisibilityChangedParams) obj).getMinFractionVisible());
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.OnVisibilityChangedParams");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
                ((OnVisibilityChangedParams) obj).minDurationMs = ((Long) obj2).longValue();
                return;
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.OnVisibilityChangedParams");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            ((OnVisibilityChangedParams) obj).minFractionVisible = ((Float) obj2).floatValue();
        }
    }

    public OnVisibilityChangedParams() {
        this(0L, 0.0f, 3, null);
    }

    public static /* synthetic */ OnVisibilityChangedParams copy$default(OnVisibilityChangedParams onVisibilityChangedParams, long j, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j = onVisibilityChangedParams.minDurationMs;
        }
        if ((i & 2) != 0) {
            f = onVisibilityChangedParams.minFractionVisible;
        }
        return onVisibilityChangedParams.copy(j, f);
    }

    @Field
    public static /* synthetic */ void getMinDurationMs$annotations() {
    }

    @Field
    public static /* synthetic */ void getMinFractionVisible$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMinDurationMs() {
        return this.minDurationMs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getMinFractionVisible() {
        return this.minFractionVisible;
    }

    public final OnVisibilityChangedParams copy(long minDurationMs, float minFractionVisible) {
        return new OnVisibilityChangedParams(minDurationMs, minFractionVisible);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnVisibilityChangedParams)) {
            return false;
        }
        OnVisibilityChangedParams onVisibilityChangedParams = (OnVisibilityChangedParams) other;
        return this.minDurationMs == onVisibilityChangedParams.minDurationMs && Float.compare(this.minFractionVisible, onVisibilityChangedParams.minFractionVisible) == 0;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (Long.hashCode(this.minDurationMs) * 31) + Float.hashCode(this.minFractionVisible);
    }

    public String toString() {
        return "OnVisibilityChangedParams(minDurationMs=" + this.minDurationMs + ", minFractionVisible=" + this.minFractionVisible + ")";
    }

    public OnVisibilityChangedParams(long j, float f) {
        this.minDurationMs = j;
        this.minFractionVisible = f;
    }

    public /* synthetic */ OnVisibilityChangedParams(long j, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 1.0f : f);
    }

    public final long getMinDurationMs() {
        return this.minDurationMs;
    }

    public final float getMinFractionVisible() {
        return this.minFractionVisible;
    }
}
