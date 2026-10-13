package expo.modules.ui;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaddingValuesExtension.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\f\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\tR \u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\tR \u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\t¨\u0006\u0019"}, d2 = {"Lexpo/modules/ui/PaddingValuesRecord;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", ViewProps.START, "", "getStart$annotations", "getStart", "()Ljava/lang/Float;", "Ljava/lang/Float;", ViewProps.TOP, "getTop$annotations", "getTop", ViewProps.END, "getEnd$annotations", "getEnd", ViewProps.BOTTOM, "getBottom$annotations", "getBottom", "toPaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PaddingValuesRecord implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public Float bottom;
    public Float end;
    public Float start;
    public Float top;

    /* JADX INFO: compiled from: PaddingValuesExtension.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/PaddingValuesRecord$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<PaddingValuesRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(PaddingValuesRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty(ViewProps.START, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 0, __pika, false, true, false), new PProperty(ViewProps.TOP, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 1, __pika, false, true, false), new PProperty(ViewProps.END, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 2, __pika, false, true, false), new PProperty(ViewProps.BOTTOM, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.FLOAT_NULLABLE, 3, __pika, false, true, false)}, new PFunction[]{new PFunction("toPaddingValues", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PaddingValuesRecord");
                return ((PaddingValuesRecord) obj).getStart();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PaddingValuesRecord");
                return ((PaddingValuesRecord) obj).getTop();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PaddingValuesRecord");
                return ((PaddingValuesRecord) obj).getEnd();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PaddingValuesRecord");
            return ((PaddingValuesRecord) obj).getBottom();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PaddingValuesRecord");
                ((PaddingValuesRecord) obj).start = (Float) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PaddingValuesRecord");
                ((PaddingValuesRecord) obj).top = (Float) obj2;
            } else if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PaddingValuesRecord");
                ((PaddingValuesRecord) obj).end = (Float) obj2;
            } else {
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.PaddingValuesRecord");
                ((PaddingValuesRecord) obj).bottom = (Float) obj2;
            }
        }
    }

    @Field
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Field
    public static /* synthetic */ void getEnd$annotations() {
    }

    @Field
    public static /* synthetic */ void getStart$annotations() {
    }

    @Field
    public static /* synthetic */ void getTop$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public final Float getStart() {
        return this.start;
    }

    public final Float getTop() {
        return this.top;
    }

    public final Float getEnd() {
        return this.end;
    }

    public final Float getBottom() {
        return this.bottom;
    }

    public final PaddingValues toPaddingValues() {
        float fM10168constructorimpl;
        float fM10168constructorimpl2;
        float fM10168constructorimpl3;
        float fM10168constructorimpl4;
        Float f = this.start;
        if (f != null) {
            fM10168constructorimpl = Dp.m10168constructorimpl(f.floatValue());
        } else {
            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
        }
        Float f2 = this.top;
        if (f2 != null) {
            fM10168constructorimpl2 = Dp.m10168constructorimpl(f2.floatValue());
        } else {
            fM10168constructorimpl2 = Dp.m10168constructorimpl(0.0f);
        }
        Float f3 = this.end;
        if (f3 != null) {
            fM10168constructorimpl3 = Dp.m10168constructorimpl(f3.floatValue());
        } else {
            fM10168constructorimpl3 = Dp.m10168constructorimpl(0.0f);
        }
        Float f4 = this.bottom;
        if (f4 != null) {
            fM10168constructorimpl4 = Dp.m10168constructorimpl(f4.floatValue());
        } else {
            fM10168constructorimpl4 = Dp.m10168constructorimpl(0.0f);
        }
        return PaddingKt.m2346PaddingValuesa9UjIt4(fM10168constructorimpl, fM10168constructorimpl2, fM10168constructorimpl3, fM10168constructorimpl4);
    }
}
