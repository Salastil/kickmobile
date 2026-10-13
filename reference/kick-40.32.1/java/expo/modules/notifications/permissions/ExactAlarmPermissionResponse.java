package expo.modules.notifications.permissions;

import expo.modules.interfaces.permissions.PermissionsResponse;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationPermissionRecords.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0019"}, d2 = {"Lexpo/modules/notifications/permissions/ExactAlarmPermissionResponse;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "status", "", PermissionsResponse.EXPIRES_KEY, PermissionsResponse.CAN_ASK_AGAIN_KEY, "", PermissionsResponse.GRANTED_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getStatus$annotations", "()V", "getStatus", "()Ljava/lang/String;", "getExpires$annotations", "getExpires", "getCanAskAgain$annotations", "getCanAskAgain", "()Z", "getGranted$annotations", "getGranted", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExactAlarmPermissionResponse implements Record, PIntrospectionProvider {
    public boolean canAskAgain;
    public String expires;
    public boolean granted;
    public String status;

    /* JADX INFO: compiled from: NotificationPermissionRecords.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/notifications/permissions/ExactAlarmPermissionResponse$__Pika;", "", "<init>", "()V", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ExactAlarmPermissionResponse> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ExactAlarmPermissionResponse.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("status", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 0, __pika, false, true, false), new PProperty(PermissionsResponse.EXPIRES_KEY, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 1, __pika, false, true, false), new PProperty(PermissionsResponse.CAN_ASK_AGAIN_KEY, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 2, __pika, false, true, false), new PProperty(PermissionsResponse.GRANTED_KEY, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 3, __pika, false, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.ExactAlarmPermissionResponse");
                return ((ExactAlarmPermissionResponse) obj).getStatus();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.ExactAlarmPermissionResponse");
                return ((ExactAlarmPermissionResponse) obj).getExpires();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.ExactAlarmPermissionResponse");
                return Boolean.valueOf(((ExactAlarmPermissionResponse) obj).getCanAskAgain());
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.ExactAlarmPermissionResponse");
            return Boolean.valueOf(((ExactAlarmPermissionResponse) obj).getGranted());
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.ExactAlarmPermissionResponse");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((ExactAlarmPermissionResponse) obj).status = (String) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.ExactAlarmPermissionResponse");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((ExactAlarmPermissionResponse) obj).expires = (String) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.ExactAlarmPermissionResponse");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((ExactAlarmPermissionResponse) obj).canAskAgain = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.ExactAlarmPermissionResponse");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            ((ExactAlarmPermissionResponse) obj).granted = ((Boolean) obj2).booleanValue();
        }
    }

    @Field
    public static /* synthetic */ void getCanAskAgain$annotations() {
    }

    @Field
    public static /* synthetic */ void getExpires$annotations() {
    }

    @Field
    public static /* synthetic */ void getGranted$annotations() {
    }

    @Field
    public static /* synthetic */ void getStatus$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public ExactAlarmPermissionResponse(String status, String expires, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(expires, "expires");
        this.status = status;
        this.expires = expires;
        this.canAskAgain = z;
        this.granted = z2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getExpires() {
        return this.expires;
    }

    public /* synthetic */ ExactAlarmPermissionResponse(String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "never" : str2, z, z2);
    }

    public final boolean getCanAskAgain() {
        return this.canAskAgain;
    }

    public final boolean getGranted() {
        return this.granted;
    }
}
