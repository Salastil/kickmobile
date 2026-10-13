package expo.modules.webview;

import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
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

/* JADX INFO: compiled from: DomWebViewRecords.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001 B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0083\u0004J\f\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0016J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lexpo/modules/webview/ScrollToParam;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, "", ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "animated", "", "<init>", "(DDZ)V", "getX$annotations", "()V", "getX", "()D", "getY$annotations", "getY", "getAnimated$annotations", "getAnimated", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-dom-webview_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ScrollToParam implements Record, PIntrospectionProvider {
    public boolean animated;
    public double x;
    public double y;

    public ScrollToParam() {
        this(0.0d, 0.0d, false, 7, null);
    }

    public static /* synthetic */ ScrollToParam copy$default(ScrollToParam scrollToParam, double d, double d2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            d = scrollToParam.x;
        }
        double d3 = d;
        if ((i & 2) != 0) {
            d2 = scrollToParam.y;
        }
        double d4 = d2;
        if ((i & 4) != 0) {
            z = scrollToParam.animated;
        }
        return scrollToParam.copy(d3, d4, z);
    }

    @Field
    public static /* synthetic */ void getAnimated$annotations() {
    }

    @Field
    public static /* synthetic */ void getX$annotations() {
    }

    @Field
    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getY() {
        return this.y;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    public final ScrollToParam copy(double x, double y, boolean animated) {
        return new ScrollToParam(x, y, animated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollToParam)) {
            return false;
        }
        ScrollToParam scrollToParam = (ScrollToParam) other;
        return Double.compare(this.x, scrollToParam.x) == 0 && Double.compare(this.y, scrollToParam.y) == 0 && this.animated == scrollToParam.animated;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (((Double.hashCode(this.x) * 31) + Double.hashCode(this.y)) * 31) + Boolean.hashCode(this.animated);
    }

    public String toString() {
        return "ScrollToParam(x=" + this.x + ", y=" + this.y + ", animated=" + this.animated + ")";
    }

    /* JADX INFO: compiled from: DomWebViewRecords.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/webview/ScrollToParam$__Pika;", "", "<init>", "()V", "expo-dom-webview_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ScrollToParam> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ScrollToParam.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.DOUBLE, 0, __pika, false, true, false), new PProperty(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.DOUBLE, 1, __pika, false, true, false), new PProperty("animated", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 2, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.webview.ScrollToParam");
                return Double.valueOf(((ScrollToParam) obj).getX());
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.webview.ScrollToParam");
                return Double.valueOf(((ScrollToParam) obj).getY());
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.webview.ScrollToParam");
            return Boolean.valueOf(((ScrollToParam) obj).getAnimated());
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.webview.ScrollToParam");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Double");
                ((ScrollToParam) obj).x = ((Double) obj2).doubleValue();
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.webview.ScrollToParam");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Double");
                ((ScrollToParam) obj).y = ((Double) obj2).doubleValue();
                return;
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.webview.ScrollToParam");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            ((ScrollToParam) obj).animated = ((Boolean) obj2).booleanValue();
        }

        private __Pika() {
        }
    }

    public ScrollToParam(double d, double d2, boolean z) {
        this.x = d;
        this.y = d2;
        this.animated = z;
    }

    public /* synthetic */ ScrollToParam(double d, double d2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? true : z);
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final boolean getAnimated() {
        return this.animated;
    }
}
