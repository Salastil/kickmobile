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

/* JADX INFO: compiled from: SliderView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\t¨\u0006\u0019"}, d2 = {"Lexpo/modules/ui/SliderColors;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", "thumbColor", "Landroid/graphics/Color;", "getThumbColor$annotations", "getThumbColor", "()Landroid/graphics/Color;", "activeTrackColor", "getActiveTrackColor$annotations", "getActiveTrackColor", "inactiveTrackColor", "getInactiveTrackColor$annotations", "getInactiveTrackColor", "activeTickColor", "getActiveTickColor$annotations", "getActiveTickColor", "inactiveTickColor", "getInactiveTickColor$annotations", "getInactiveTickColor", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SliderColors implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color activeTickColor;
    public Color activeTrackColor;
    public Color inactiveTickColor;
    public Color inactiveTrackColor;
    public Color thumbColor;

    /* JADX INFO: compiled from: SliderView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/SliderColors$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<SliderColors> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(SliderColors.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("thumbColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 0, __pika, false, true, false), new PProperty("activeTrackColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty("inactiveTrackColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("activeTickColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 3, __pika, false, true, false), new PProperty("inactiveTickColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 4, __pika, false, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SliderColors");
                return ((SliderColors) obj).getThumbColor();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SliderColors");
                return ((SliderColors) obj).getActiveTrackColor();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SliderColors");
                return ((SliderColors) obj).getInactiveTrackColor();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SliderColors");
                return ((SliderColors) obj).getActiveTickColor();
            }
            if (i != 4) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SliderColors");
            return ((SliderColors) obj).getInactiveTickColor();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SliderColors");
                ((SliderColors) obj).thumbColor = (Color) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SliderColors");
                ((SliderColors) obj).activeTrackColor = (Color) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SliderColors");
                ((SliderColors) obj).inactiveTrackColor = (Color) obj2;
            } else if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SliderColors");
                ((SliderColors) obj).activeTickColor = (Color) obj2;
            } else {
                if (i != 4) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SliderColors");
                ((SliderColors) obj).inactiveTickColor = (Color) obj2;
            }
        }
    }

    @Field
    public static /* synthetic */ void getActiveTickColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getActiveTrackColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getInactiveTickColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getInactiveTrackColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getThumbColor$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public final Color getThumbColor() {
        return this.thumbColor;
    }

    public final Color getActiveTrackColor() {
        return this.activeTrackColor;
    }

    public final Color getInactiveTrackColor() {
        return this.inactiveTrackColor;
    }

    public final Color getActiveTickColor() {
        return this.activeTickColor;
    }

    public final Color getInactiveTickColor() {
        return this.inactiveTickColor;
    }
}
