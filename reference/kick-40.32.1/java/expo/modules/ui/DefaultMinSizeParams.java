package expo.modules.ui;

import com.facebook.react.uimanager.ViewProps;
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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dB\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\f\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001e"}, d2 = {"Lexpo/modules/ui/DefaultMinSizeParams;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", ViewProps.MIN_WIDTH, "", ViewProps.MIN_HEIGHT, "<init>", "(Ljava/lang/Float;Ljava/lang/Float;)V", "getMinWidth$annotations", "()V", "getMinWidth", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getMinHeight$annotations", "getMinHeight", "component1", "component2", "copy", "(Ljava/lang/Float;Ljava/lang/Float;)Lexpo/modules/ui/DefaultMinSizeParams;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DefaultMinSizeParams implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public Float minHeight;
    public Float minWidth;

    /* JADX INFO: compiled from: ModifierRegistry.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/DefaultMinSizeParams$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<DefaultMinSizeParams> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(DefaultMinSizeParams.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty(ViewProps.MIN_WIDTH, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 0, __pika, false, true, false), new PProperty(ViewProps.MIN_HEIGHT, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 1, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DefaultMinSizeParams");
                return ((DefaultMinSizeParams) obj).getMinWidth();
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DefaultMinSizeParams");
            return ((DefaultMinSizeParams) obj).getMinHeight();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DefaultMinSizeParams");
                ((DefaultMinSizeParams) obj).minWidth = (Float) obj2;
            } else {
                if (i != 1) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DefaultMinSizeParams");
                ((DefaultMinSizeParams) obj).minHeight = (Float) obj2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultMinSizeParams() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DefaultMinSizeParams copy$default(DefaultMinSizeParams defaultMinSizeParams, Float f, Float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = defaultMinSizeParams.minWidth;
        }
        if ((i & 2) != 0) {
            f2 = defaultMinSizeParams.minHeight;
        }
        return defaultMinSizeParams.copy(f, f2);
    }

    @Field
    public static /* synthetic */ void getMinHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getMinWidth$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Float getMinWidth() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getMinHeight() {
        return this.minHeight;
    }

    public final DefaultMinSizeParams copy(Float minWidth, Float minHeight) {
        return new DefaultMinSizeParams(minWidth, minHeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DefaultMinSizeParams)) {
            return false;
        }
        DefaultMinSizeParams defaultMinSizeParams = (DefaultMinSizeParams) other;
        return Intrinsics.areEqual((Object) this.minWidth, (Object) defaultMinSizeParams.minWidth) && Intrinsics.areEqual((Object) this.minHeight, (Object) defaultMinSizeParams.minHeight);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Float f = this.minWidth;
        int iHashCode = (f == null ? 0 : f.hashCode()) * 31;
        Float f2 = this.minHeight;
        return iHashCode + (f2 != null ? f2.hashCode() : 0);
    }

    public String toString() {
        return "DefaultMinSizeParams(minWidth=" + this.minWidth + ", minHeight=" + this.minHeight + ")";
    }

    public DefaultMinSizeParams(Float f, Float f2) {
        this.minWidth = f;
        this.minHeight = f2;
    }

    public /* synthetic */ DefaultMinSizeParams(Float f, Float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : f, (i & 2) != 0 ? null : f2);
    }

    public final Float getMinWidth() {
        return this.minWidth;
    }

    public final Float getMinHeight() {
        return this.minHeight;
    }
}
