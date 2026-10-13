package expo.modules.ui;

import android.graphics.Color;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PEmptyArrays;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lexpo/modules/ui/DrawStopIndicatorConfig;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", "color", "Landroid/graphics/Color;", "getColor$annotations", "getColor", "()Landroid/graphics/Color;", "strokeCap", "", "getStrokeCap$annotations", "getStrokeCap", "()Ljava/lang/String;", "stopSize", "", "getStopSize$annotations", "getStopSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DrawStopIndicatorConfig implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color color;
    public Float stopSize;
    public String strokeCap;

    /* JADX INFO: compiled from: ProgressView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/DrawStopIndicatorConfig$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<DrawStopIndicatorConfig> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(DrawStopIndicatorConfig.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("color", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 0, __pika, false, true, false), new PProperty("strokeCap", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 1, __pika, false, true, false), new PProperty("stopSize", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 2, __pika, false, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DrawStopIndicatorConfig");
                return ((DrawStopIndicatorConfig) obj).getColor();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DrawStopIndicatorConfig");
                return ((DrawStopIndicatorConfig) obj).getStrokeCap();
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DrawStopIndicatorConfig");
            return ((DrawStopIndicatorConfig) obj).getStopSize();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DrawStopIndicatorConfig");
                ((DrawStopIndicatorConfig) obj).color = (Color) obj2;
            } else if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DrawStopIndicatorConfig");
                ((DrawStopIndicatorConfig) obj).strokeCap = (String) obj2;
            } else {
                if (i != 2) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DrawStopIndicatorConfig");
                ((DrawStopIndicatorConfig) obj).stopSize = (Float) obj2;
            }
        }
    }

    @Field
    public static /* synthetic */ void getColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getStopSize$annotations() {
    }

    @Field
    public static /* synthetic */ void getStrokeCap$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public final Color getColor() {
        return this.color;
    }

    public final String getStrokeCap() {
        return this.strokeCap;
    }

    public final Float getStopSize() {
        return this.stopSize;
    }
}
