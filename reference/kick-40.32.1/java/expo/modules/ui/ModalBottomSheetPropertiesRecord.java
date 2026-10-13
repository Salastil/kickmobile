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

/* JADX INFO: compiled from: ModalBottomSheetView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001aB\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\f\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u001b"}, d2 = {"Lexpo/modules/ui/ModalBottomSheetPropertiesRecord;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "shouldDismissOnBackPress", "", "shouldDismissOnClickOutside", "<init>", "(ZZ)V", "getShouldDismissOnBackPress$annotations", "()V", "getShouldDismissOnBackPress", "()Z", "getShouldDismissOnClickOutside$annotations", "getShouldDismissOnClickOutside", "component1", "component2", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ModalBottomSheetPropertiesRecord implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public boolean shouldDismissOnBackPress;
    public boolean shouldDismissOnClickOutside;

    /* JADX INFO: compiled from: ModalBottomSheetView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/ModalBottomSheetPropertiesRecord$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ModalBottomSheetPropertiesRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ModalBottomSheetPropertiesRecord.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("shouldDismissOnBackPress", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, false, true, false), new PProperty("shouldDismissOnClickOutside", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 1, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            boolean shouldDismissOnBackPress;
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetPropertiesRecord");
                shouldDismissOnBackPress = ((ModalBottomSheetPropertiesRecord) obj).getShouldDismissOnBackPress();
            } else {
                if (i != 1) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetPropertiesRecord");
                shouldDismissOnBackPress = ((ModalBottomSheetPropertiesRecord) obj).getShouldDismissOnClickOutside();
            }
            return Boolean.valueOf(shouldDismissOnBackPress);
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetPropertiesRecord");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((ModalBottomSheetPropertiesRecord) obj).shouldDismissOnBackPress = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i != 1) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ModalBottomSheetPropertiesRecord");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            ((ModalBottomSheetPropertiesRecord) obj).shouldDismissOnClickOutside = ((Boolean) obj2).booleanValue();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ModalBottomSheetPropertiesRecord() {
        boolean z = false;
        this(z, z, 3, null);
    }

    public static /* synthetic */ ModalBottomSheetPropertiesRecord copy$default(ModalBottomSheetPropertiesRecord modalBottomSheetPropertiesRecord, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = modalBottomSheetPropertiesRecord.shouldDismissOnBackPress;
        }
        if ((i & 2) != 0) {
            z2 = modalBottomSheetPropertiesRecord.shouldDismissOnClickOutside;
        }
        return modalBottomSheetPropertiesRecord.copy(z, z2);
    }

    @Field
    public static /* synthetic */ void getShouldDismissOnBackPress$annotations() {
    }

    @Field
    public static /* synthetic */ void getShouldDismissOnClickOutside$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShouldDismissOnClickOutside() {
        return this.shouldDismissOnClickOutside;
    }

    public final ModalBottomSheetPropertiesRecord copy(boolean shouldDismissOnBackPress, boolean shouldDismissOnClickOutside) {
        return new ModalBottomSheetPropertiesRecord(shouldDismissOnBackPress, shouldDismissOnClickOutside);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModalBottomSheetPropertiesRecord)) {
            return false;
        }
        ModalBottomSheetPropertiesRecord modalBottomSheetPropertiesRecord = (ModalBottomSheetPropertiesRecord) other;
        return this.shouldDismissOnBackPress == modalBottomSheetPropertiesRecord.shouldDismissOnBackPress && this.shouldDismissOnClickOutside == modalBottomSheetPropertiesRecord.shouldDismissOnClickOutside;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.shouldDismissOnBackPress) * 31) + Boolean.hashCode(this.shouldDismissOnClickOutside);
    }

    public String toString() {
        return "ModalBottomSheetPropertiesRecord(shouldDismissOnBackPress=" + this.shouldDismissOnBackPress + ", shouldDismissOnClickOutside=" + this.shouldDismissOnClickOutside + ")";
    }

    public ModalBottomSheetPropertiesRecord(boolean z, boolean z2) {
        this.shouldDismissOnBackPress = z;
        this.shouldDismissOnClickOutside = z2;
    }

    public /* synthetic */ ModalBottomSheetPropertiesRecord(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2);
    }

    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    public final boolean getShouldDismissOnClickOutside() {
        return this.shouldDismissOnClickOutside;
    }
}
