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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dB1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0016R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lexpo/modules/notifications/permissions/NotificationPermissionResponse;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "status", "", PermissionsResponse.EXPIRES_KEY, PermissionsResponse.CAN_ASK_AGAIN_KEY, "", PermissionsResponse.GRANTED_KEY, "android", "Lexpo/modules/notifications/permissions/AndroidNotificationPermissionDetails;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLexpo/modules/notifications/permissions/AndroidNotificationPermissionDetails;)V", "getStatus$annotations", "()V", "getStatus", "()Ljava/lang/String;", "getExpires$annotations", "getExpires", "getCanAskAgain$annotations", "getCanAskAgain", "()Z", "getGranted$annotations", "getGranted", "getAndroid$annotations", "getAndroid", "()Lexpo/modules/notifications/permissions/AndroidNotificationPermissionDetails;", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationPermissionResponse implements Record, PIntrospectionProvider {
    public AndroidNotificationPermissionDetails android;
    public boolean canAskAgain;
    public String expires;
    public boolean granted;
    public String status;

    /* JADX INFO: compiled from: NotificationPermissionRecords.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/notifications/permissions/NotificationPermissionResponse$__Pika;", "", "<init>", "()V", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<NotificationPermissionResponse> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(NotificationPermissionResponse.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("status", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 0, __pika, false, true, false), new PProperty(PermissionsResponse.EXPIRES_KEY, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.STRING, 1, __pika, false, true, false), new PProperty(PermissionsResponse.CAN_ASK_AGAIN_KEY, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 2, __pika, false, true, false), new PProperty(PermissionsResponse.GRANTED_KEY, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.BOOLEAN, 3, __pika, false, true, false), new PProperty("android", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(AndroidNotificationPermissionDetails.class, false, AndroidNotificationPermissionDetails.__Pika.__pika$IntrospectionData), 4, __pika, false, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.NotificationPermissionResponse");
                return ((NotificationPermissionResponse) obj).getStatus();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.NotificationPermissionResponse");
                return ((NotificationPermissionResponse) obj).getExpires();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.NotificationPermissionResponse");
                return Boolean.valueOf(((NotificationPermissionResponse) obj).getCanAskAgain());
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.NotificationPermissionResponse");
                return Boolean.valueOf(((NotificationPermissionResponse) obj).getGranted());
            }
            if (i != 4) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.NotificationPermissionResponse");
            return ((NotificationPermissionResponse) obj).getAndroid();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.NotificationPermissionResponse");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((NotificationPermissionResponse) obj).status = (String) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.NotificationPermissionResponse");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                ((NotificationPermissionResponse) obj).expires = (String) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.NotificationPermissionResponse");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((NotificationPermissionResponse) obj).canAskAgain = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.NotificationPermissionResponse");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((NotificationPermissionResponse) obj).granted = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i != 4) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.notifications.permissions.NotificationPermissionResponse");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.notifications.permissions.AndroidNotificationPermissionDetails");
            ((NotificationPermissionResponse) obj).android = (AndroidNotificationPermissionDetails) obj2;
        }
    }

    @Field
    public static /* synthetic */ void getAndroid$annotations() {
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

    public NotificationPermissionResponse(String status, String expires, boolean z, boolean z2, AndroidNotificationPermissionDetails android2) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(expires, "expires");
        Intrinsics.checkNotNullParameter(android2, "android");
        this.status = status;
        this.expires = expires;
        this.canAskAgain = z;
        this.granted = z2;
        this.android = android2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getExpires() {
        return this.expires;
    }

    public /* synthetic */ NotificationPermissionResponse(String str, String str2, boolean z, boolean z2, AndroidNotificationPermissionDetails androidNotificationPermissionDetails, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "never" : str2, z, z2, androidNotificationPermissionDetails);
    }

    public final boolean getCanAskAgain() {
        return this.canAskAgain;
    }

    public final boolean getGranted() {
        return this.granted;
    }

    public final AndroidNotificationPermissionDetails getAndroid() {
        return this.android;
    }
}
