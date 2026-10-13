package expo.modules.updates.reloadscreen;

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
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReloadScreenConfiguration.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001#B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0083\u0004J\f\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0016J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0006HÖ\u0081\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lexpo/modules/updates/reloadscreen/SpinnerOptions;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "enabled", "", "color", "", ContentDisposition.Parameters.Size, "Lexpo/modules/updates/reloadscreen/SpinnerSize;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Lexpo/modules/updates/reloadscreen/SpinnerSize;)V", "getEnabled$annotations", "()V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getColor$annotations", "getColor", "()Ljava/lang/String;", "getSize$annotations", "getSize", "()Lexpo/modules/updates/reloadscreen/SpinnerSize;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Lexpo/modules/updates/reloadscreen/SpinnerSize;)Lexpo/modules/updates/reloadscreen/SpinnerOptions;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SpinnerOptions implements Record, PIntrospectionProvider {
    public String color;
    public Boolean enabled;
    public SpinnerSize size;

    public SpinnerOptions() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SpinnerOptions copy$default(SpinnerOptions spinnerOptions, Boolean bool, String str, SpinnerSize spinnerSize, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = spinnerOptions.enabled;
        }
        if ((i & 2) != 0) {
            str = spinnerOptions.color;
        }
        if ((i & 4) != 0) {
            spinnerSize = spinnerOptions.size;
        }
        return spinnerOptions.copy(bool, str, spinnerSize);
    }

    @Field
    public static /* synthetic */ void getColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @Field
    public static /* synthetic */ void getSize$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SpinnerSize getSize() {
        return this.size;
    }

    public final SpinnerOptions copy(Boolean enabled, String color, SpinnerSize size) {
        return new SpinnerOptions(enabled, color, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpinnerOptions)) {
            return false;
        }
        SpinnerOptions spinnerOptions = (SpinnerOptions) other;
        return Intrinsics.areEqual(this.enabled, spinnerOptions.enabled) && Intrinsics.areEqual(this.color, spinnerOptions.color) && this.size == spinnerOptions.size;
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.color;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        SpinnerSize spinnerSize = this.size;
        return iHashCode2 + (spinnerSize != null ? spinnerSize.hashCode() : 0);
    }

    public String toString() {
        return "SpinnerOptions(enabled=" + this.enabled + ", color=" + this.color + ", size=" + this.size + ")";
    }

    /* JADX INFO: compiled from: ReloadScreenConfiguration.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/reloadscreen/SpinnerOptions$__Pika;", "", "<init>", "()V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<SpinnerOptions> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(SpinnerOptions.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("enabled", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN_NULLABLE, 0, __pika, false, true, false), new PProperty("color", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 1, __pika, false, true, false), new PProperty(ContentDisposition.Parameters.Size, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(SpinnerSize.class, true, null), 2, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.SpinnerOptions");
                return ((SpinnerOptions) obj).getEnabled();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.SpinnerOptions");
                return ((SpinnerOptions) obj).getColor();
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.SpinnerOptions");
            return ((SpinnerOptions) obj).getSize();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.SpinnerOptions");
                ((SpinnerOptions) obj).enabled = (Boolean) obj2;
            } else if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.SpinnerOptions");
                ((SpinnerOptions) obj).color = (String) obj2;
            } else {
                if (i != 2) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.reloadscreen.SpinnerOptions");
                ((SpinnerOptions) obj).size = (SpinnerSize) obj2;
            }
        }

        private __Pika() {
        }
    }

    public SpinnerOptions(Boolean bool, String str, SpinnerSize spinnerSize) {
        this.enabled = bool;
        this.color = str;
        this.size = spinnerSize;
    }

    public /* synthetic */ SpinnerOptions(Boolean bool, String str, SpinnerSize spinnerSize, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : spinnerSize);
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final String getColor() {
        return this.color;
    }

    public final SpinnerSize getSize() {
        return this.size;
    }
}
