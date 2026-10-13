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

/* JADX INFO: compiled from: HorizontalPagerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\f\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\t¨\u0006\u0016"}, d2 = {"Lexpo/modules/ui/HorizontalPagerScrollInProgressChangeEvent;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "isScrollInProgress", "", "<init>", "(Z)V", "isScrollInProgress$annotations", "()V", "()Z", "component1", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HorizontalPagerScrollInProgressChangeEvent implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public boolean isScrollInProgress;

    /* JADX INFO: compiled from: HorizontalPagerView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/HorizontalPagerScrollInProgressChangeEvent$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<HorizontalPagerScrollInProgressChangeEvent> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(HorizontalPagerScrollInProgressChangeEvent.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("isScrollInProgress", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i != 0) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerScrollInProgressChangeEvent");
            return Boolean.valueOf(((HorizontalPagerScrollInProgressChangeEvent) obj).isScrollInProgress());
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i != 0) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalPagerScrollInProgressChangeEvent");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            ((HorizontalPagerScrollInProgressChangeEvent) obj).isScrollInProgress = ((Boolean) obj2).booleanValue();
        }
    }

    public HorizontalPagerScrollInProgressChangeEvent() {
        this(false, 1, null);
    }

    public static /* synthetic */ HorizontalPagerScrollInProgressChangeEvent copy$default(HorizontalPagerScrollInProgressChangeEvent horizontalPagerScrollInProgressChangeEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = horizontalPagerScrollInProgressChangeEvent.isScrollInProgress;
        }
        return horizontalPagerScrollInProgressChangeEvent.copy(z);
    }

    @Field
    public static /* synthetic */ void isScrollInProgress$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsScrollInProgress() {
        return this.isScrollInProgress;
    }

    public final HorizontalPagerScrollInProgressChangeEvent copy(boolean isScrollInProgress) {
        return new HorizontalPagerScrollInProgressChangeEvent(isScrollInProgress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HorizontalPagerScrollInProgressChangeEvent) && this.isScrollInProgress == ((HorizontalPagerScrollInProgressChangeEvent) other).isScrollInProgress;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isScrollInProgress);
    }

    public String toString() {
        return "HorizontalPagerScrollInProgressChangeEvent(isScrollInProgress=" + this.isScrollInProgress + ")";
    }

    public HorizontalPagerScrollInProgressChangeEvent(boolean z) {
        this.isScrollInProgress = z;
    }

    public /* synthetic */ HorizontalPagerScrollInProgressChangeEvent(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean isScrollInProgress() {
        return this.isScrollInProgress;
    }
}
