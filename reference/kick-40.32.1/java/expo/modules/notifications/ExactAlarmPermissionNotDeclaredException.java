package expo.modules.notifications;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/notifications/ExactAlarmPermissionNotDeclaredException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExactAlarmPermissionNotDeclaredException extends CodedException {
    public ExactAlarmPermissionNotDeclaredException() {
        super("Cannot request the exact alarm permission because the app does not declare android.permission.SCHEDULE_EXACT_ALARM. Add it to `android.permissions` in your app config and rebuild the app.", null, 2, null);
    }
}
