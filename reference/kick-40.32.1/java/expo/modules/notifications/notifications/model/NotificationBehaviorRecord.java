package expo.modules.notifications.notifications.model;

import android.os.Parcel;
import android.os.Parcelable;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import expo.modules.notifications.notifications.enums.NotificationPriority;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PEmptyArrays;
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
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: NotificationBehaviorRecord.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u000289BE\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003JG\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0006\u0010*\u001a\u00020+J\u0013\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\f\u0010/\u001a\u0006\u0012\u0002\b\u000300H\u0016J\t\u00101\u001a\u00020+HÖ\u0001J\t\u00102\u001a\u00020\u000bHÖ\u0001J\u0016\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020+R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0011¨\u0006:"}, d2 = {"Lexpo/modules/notifications/notifications/model/NotificationBehaviorRecord;", "Lexpo/modules/kotlin/records/Record;", "Landroid/os/Parcelable;", "Lio/github/expo/pika/PIntrospectionProvider;", "shouldShowAlert", "", "shouldShowBanner", "shouldShowList", "shouldPlaySound", "shouldSetBadge", "priority", "", "<init>", "(ZZZZZLjava/lang/String;)V", "getShouldShowAlert$annotations", "()V", "getShouldShowAlert", "()Z", "getShouldShowBanner$annotations", "getShouldShowBanner", "getShouldShowList$annotations", "getShouldShowList", "getShouldPlaySound$annotations", "getShouldPlaySound", "getShouldSetBadge$annotations", "getShouldSetBadge", "getPriority$annotations", "getPriority", "()Ljava/lang/String;", "priorityOverride", "Lexpo/modules/notifications/notifications/enums/NotificationPriority;", "getPriorityOverride", "()Lexpo/modules/notifications/notifications/enums/NotificationPriority;", "shouldPresentAlert", "getShouldPresentAlert", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "__Pika", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NotificationBehaviorRecord implements Record, Parcelable, PIntrospectionProvider {
    public String priority;
    public boolean shouldPlaySound;
    public boolean shouldSetBadge;
    public boolean shouldShowAlert;
    public boolean shouldShowBanner;
    public boolean shouldShowList;
    public static final Parcelable.Creator<NotificationBehaviorRecord> CREATOR = new Creator();
    public static final NotificationBehaviorRecord ALLOW_ALL = new NotificationBehaviorRecord(false, true, true, true, true, null, 33, null);

    /* JADX INFO: compiled from: NotificationBehaviorRecord.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NotificationBehaviorRecord> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotificationBehaviorRecord createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z = true;
            boolean z2 = false;
            if (parcel.readInt() == 0) {
                z = false;
            }
            if (parcel.readInt() != 0) {
                z2 = true;
            }
            if (parcel.readInt() != 0) {
                z2 = z;
            }
            if (parcel.readInt() != 0) {
                z2 = z;
            }
            return new NotificationBehaviorRecord(z, z2, z2, z2, parcel.readInt() != 0 ? z : false, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotificationBehaviorRecord[] newArray(int i) {
            return new NotificationBehaviorRecord[i];
        }
    }

    /* JADX INFO: compiled from: NotificationBehaviorRecord.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/notifications/notifications/model/NotificationBehaviorRecord$__Pika;", "", "<init>", "()V", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<NotificationBehaviorRecord> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(NotificationBehaviorRecord.class, new PAnnotation[]{new PAnnotation(Parcelize.class, MapsKt.emptyMap()), new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("shouldShowAlert", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, false, true, false), new PProperty("shouldShowBanner", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 1, __pika, false, true, false), new PProperty("shouldShowList", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 2, __pika, false, true, false), new PProperty("shouldPlaySound", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 3, __pika, false, true, false), new PProperty("shouldSetBadge", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 4, __pika, false, true, false), new PProperty("priority", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING_NULLABLE, 5, __pika, false, true, false), new PProperty("priorityOverride", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(NotificationPriority.class, true, null), 6, __pika, false, false, false), new PProperty("shouldPresentAlert", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 7, __pika, false, false, false)}, new PFunction[]{new PFunction("describeContents", PVisibility.PUBLIC), new PFunction("writeToParcel", PVisibility.PUBLIC), new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    return Boolean.valueOf(((NotificationBehaviorRecord) obj).getShouldShowAlert());
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    return Boolean.valueOf(((NotificationBehaviorRecord) obj).getShouldShowBanner());
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    return Boolean.valueOf(((NotificationBehaviorRecord) obj).getShouldShowList());
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    return Boolean.valueOf(((NotificationBehaviorRecord) obj).getShouldPlaySound());
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    return Boolean.valueOf(((NotificationBehaviorRecord) obj).getShouldSetBadge());
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    return ((NotificationBehaviorRecord) obj).getPriority();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    return ((NotificationBehaviorRecord) obj).getPriorityOverride();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    return Boolean.valueOf(((NotificationBehaviorRecord) obj).getShouldPresentAlert());
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((NotificationBehaviorRecord) obj).shouldShowAlert = ((Boolean) obj2).booleanValue();
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((NotificationBehaviorRecord) obj).shouldShowBanner = ((Boolean) obj2).booleanValue();
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((NotificationBehaviorRecord) obj).shouldShowList = ((Boolean) obj2).booleanValue();
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((NotificationBehaviorRecord) obj).shouldPlaySound = ((Boolean) obj2).booleanValue();
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((NotificationBehaviorRecord) obj).shouldSetBadge = ((Boolean) obj2).booleanValue();
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.notifications.model.NotificationBehaviorRecord");
                    ((NotificationBehaviorRecord) obj).priority = (String) obj2;
                    return;
                case 6:
                    throw new UnsupportedOperationException("Property 'priorityOverride' does not have a backing field and cannot be set.");
                case 7:
                    throw new UnsupportedOperationException("Property 'shouldPresentAlert' does not have a backing field and cannot be set.");
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public NotificationBehaviorRecord() {
        this(false, false, false, false, false, null, 63, null);
    }

    public static /* synthetic */ NotificationBehaviorRecord copy$default(NotificationBehaviorRecord notificationBehaviorRecord, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = notificationBehaviorRecord.shouldShowAlert;
        }
        if ((i & 2) != 0) {
            z2 = notificationBehaviorRecord.shouldShowBanner;
        }
        if ((i & 4) != 0) {
            z3 = notificationBehaviorRecord.shouldShowList;
        }
        if ((i & 8) != 0) {
            z4 = notificationBehaviorRecord.shouldPlaySound;
        }
        if ((i & 16) != 0) {
            z5 = notificationBehaviorRecord.shouldSetBadge;
        }
        if ((i & 32) != 0) {
            str = notificationBehaviorRecord.priority;
        }
        boolean z6 = z5;
        String str2 = str;
        return notificationBehaviorRecord.copy(z, z2, z3, z4, z6, str2);
    }

    @Field
    public static /* synthetic */ void getPriority$annotations() {
    }

    @Field
    public static /* synthetic */ void getShouldPlaySound$annotations() {
    }

    @Field
    public static /* synthetic */ void getShouldSetBadge$annotations() {
    }

    @Field
    public static /* synthetic */ void getShouldShowAlert$annotations() {
    }

    @Field
    public static /* synthetic */ void getShouldShowBanner$annotations() {
    }

    @Field
    public static /* synthetic */ void getShouldShowList$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShouldShowAlert() {
        return this.shouldShowAlert;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShouldShowBanner() {
        return this.shouldShowBanner;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShouldShowList() {
        return this.shouldShowList;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShouldPlaySound() {
        return this.shouldPlaySound;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShouldSetBadge() {
        return this.shouldSetBadge;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPriority() {
        return this.priority;
    }

    public final NotificationBehaviorRecord copy(boolean shouldShowAlert, boolean shouldShowBanner, boolean shouldShowList, boolean shouldPlaySound, boolean shouldSetBadge, String priority) {
        return new NotificationBehaviorRecord(shouldShowAlert, shouldShowBanner, shouldShowList, shouldPlaySound, shouldSetBadge, priority);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationBehaviorRecord)) {
            return false;
        }
        NotificationBehaviorRecord notificationBehaviorRecord = (NotificationBehaviorRecord) other;
        return this.shouldShowAlert == notificationBehaviorRecord.shouldShowAlert && this.shouldShowBanner == notificationBehaviorRecord.shouldShowBanner && this.shouldShowList == notificationBehaviorRecord.shouldShowList && this.shouldPlaySound == notificationBehaviorRecord.shouldPlaySound && this.shouldSetBadge == notificationBehaviorRecord.shouldSetBadge && Intrinsics.areEqual(this.priority, notificationBehaviorRecord.priority);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((((((((Boolean.hashCode(this.shouldShowAlert) * 31) + Boolean.hashCode(this.shouldShowBanner)) * 31) + Boolean.hashCode(this.shouldShowList)) * 31) + Boolean.hashCode(this.shouldPlaySound)) * 31) + Boolean.hashCode(this.shouldSetBadge)) * 31;
        String str = this.priority;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "NotificationBehaviorRecord(shouldShowAlert=" + this.shouldShowAlert + ", shouldShowBanner=" + this.shouldShowBanner + ", shouldShowList=" + this.shouldShowList + ", shouldPlaySound=" + this.shouldPlaySound + ", shouldSetBadge=" + this.shouldSetBadge + ", priority=" + this.priority + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.shouldShowAlert ? 1 : 0);
        dest.writeInt(this.shouldShowBanner ? 1 : 0);
        dest.writeInt(this.shouldShowList ? 1 : 0);
        dest.writeInt(this.shouldPlaySound ? 1 : 0);
        dest.writeInt(this.shouldSetBadge ? 1 : 0);
        dest.writeString(this.priority);
    }

    public NotificationBehaviorRecord(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str) {
        this.shouldShowAlert = z;
        this.shouldShowBanner = z2;
        this.shouldShowList = z3;
        this.shouldPlaySound = z4;
        this.shouldSetBadge = z5;
        this.priority = str;
    }

    public /* synthetic */ NotificationBehaviorRecord(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? null : str);
    }

    public final boolean getShouldShowAlert() {
        return this.shouldShowAlert;
    }

    public final boolean getShouldShowBanner() {
        return this.shouldShowBanner;
    }

    public final boolean getShouldShowList() {
        return this.shouldShowList;
    }

    public final boolean getShouldPlaySound() {
        return this.shouldPlaySound;
    }

    public final boolean getShouldSetBadge() {
        return this.shouldSetBadge;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final NotificationPriority getPriorityOverride() {
        String str = this.priority;
        if (str != null) {
            return NotificationPriority.fromEnumValue(str);
        }
        return null;
    }

    public final boolean getShouldPresentAlert() {
        return this.shouldShowBanner || this.shouldShowList || this.shouldShowAlert;
    }
}
