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

/* JADX INFO: compiled from: SnackbarView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001#B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\f\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0016J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e¨\u0006$"}, d2 = {"Lexpo/modules/ui/SnackbarShowOptions;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "message", "", "actionLabel", "withDismissAction", "", "duration", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getMessage$annotations", "()V", "getMessage", "()Ljava/lang/String;", "getActionLabel$annotations", "getActionLabel", "getWithDismissAction$annotations", "getWithDismissAction", "()Z", "getDuration$annotations", "getDuration", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SnackbarShowOptions implements Record, PIntrospectionProvider {
    public static final int $stable = 0;
    public String actionLabel;
    public String duration;
    public String message;
    public boolean withDismissAction;

    /* JADX INFO: compiled from: SnackbarView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/SnackbarShowOptions$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<SnackbarShowOptions> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(SnackbarShowOptions.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("message", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 0, __pika, false, true, false), new PProperty("actionLabel", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 1, __pika, false, true, false), new PProperty("withDismissAction", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 2, __pika, false, true, false), new PProperty("duration", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 3, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarShowOptions");
                return ((SnackbarShowOptions) obj).getMessage();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarShowOptions");
                return ((SnackbarShowOptions) obj).getActionLabel();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarShowOptions");
                return Boolean.valueOf(((SnackbarShowOptions) obj).getWithDismissAction());
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarShowOptions");
            return ((SnackbarShowOptions) obj).getDuration();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarShowOptions");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((SnackbarShowOptions) obj).message = (String) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarShowOptions");
                ((SnackbarShowOptions) obj).actionLabel = (String) obj2;
            } else {
                if (i == 2) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarShowOptions");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((SnackbarShowOptions) obj).withDismissAction = ((Boolean) obj2).booleanValue();
                    return;
                }
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.SnackbarShowOptions");
                ((SnackbarShowOptions) obj).duration = (String) obj2;
            }
        }
    }

    public SnackbarShowOptions() {
        this(null, null, false, null, 15, null);
    }

    public static /* synthetic */ SnackbarShowOptions copy$default(SnackbarShowOptions snackbarShowOptions, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = snackbarShowOptions.message;
        }
        if ((i & 2) != 0) {
            str2 = snackbarShowOptions.actionLabel;
        }
        if ((i & 4) != 0) {
            z = snackbarShowOptions.withDismissAction;
        }
        if ((i & 8) != 0) {
            str3 = snackbarShowOptions.duration;
        }
        return snackbarShowOptions.copy(str, str2, z, str3);
    }

    @Field
    public static /* synthetic */ void getActionLabel$annotations() {
    }

    @Field
    public static /* synthetic */ void getDuration$annotations() {
    }

    @Field
    public static /* synthetic */ void getMessage$annotations() {
    }

    @Field
    public static /* synthetic */ void getWithDismissAction$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActionLabel() {
        return this.actionLabel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getWithDismissAction() {
        return this.withDismissAction;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    public final SnackbarShowOptions copy(String message, String actionLabel, boolean withDismissAction, String duration) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new SnackbarShowOptions(message, actionLabel, withDismissAction, duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnackbarShowOptions)) {
            return false;
        }
        SnackbarShowOptions snackbarShowOptions = (SnackbarShowOptions) other;
        return Intrinsics.areEqual(this.message, snackbarShowOptions.message) && Intrinsics.areEqual(this.actionLabel, snackbarShowOptions.actionLabel) && this.withDismissAction == snackbarShowOptions.withDismissAction && Intrinsics.areEqual(this.duration, snackbarShowOptions.duration);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = this.message.hashCode() * 31;
        String str = this.actionLabel;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.withDismissAction)) * 31;
        String str2 = this.duration;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SnackbarShowOptions(message=" + this.message + ", actionLabel=" + this.actionLabel + ", withDismissAction=" + this.withDismissAction + ", duration=" + this.duration + ")";
    }

    public SnackbarShowOptions(String message, String str, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
        this.actionLabel = str;
        this.withDismissAction = z;
        this.duration = str2;
    }

    public /* synthetic */ SnackbarShowOptions(String str, String str2, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3);
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getActionLabel() {
        return this.actionLabel;
    }

    public final boolean getWithDismissAction() {
        return this.withDismissAction;
    }

    public final String getDuration() {
        return this.duration;
    }
}
