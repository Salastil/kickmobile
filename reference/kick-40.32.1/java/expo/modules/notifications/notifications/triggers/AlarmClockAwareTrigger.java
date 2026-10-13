package expo.modules.notifications.notifications.triggers;

import kotlin.Metadata;

/* JADX INFO: compiled from: NotificationTriggers.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lexpo/modules/notifications/notifications/triggers/AlarmClockAwareTrigger;", "", "alarmClock", "", "getAlarmClock", "()Z", "delivery", "", "getDelivery", "()Ljava/lang/String;", "Companion", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AlarmClockAwareTrigger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String DELIVERY_ALARM_CLOCK = "alarmClock";
    public static final String DELIVERY_BEST_EFFORT = "bestEffort";

    boolean getAlarmClock();

    /* JADX INFO: compiled from: NotificationTriggers.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String getDelivery(AlarmClockAwareTrigger alarmClockAwareTrigger) {
            return AlarmClockAwareTrigger.super.getDelivery();
        }
    }

    default String getDelivery() {
        if (getAlarmClock()) {
            return "alarmClock";
        }
        return "bestEffort";
    }

    /* JADX INFO: compiled from: NotificationTriggers.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lexpo/modules/notifications/notifications/triggers/AlarmClockAwareTrigger$Companion;", "", "<init>", "()V", "DELIVERY_BEST_EFFORT", "", "DELIVERY_ALARM_CLOCK", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String DELIVERY_ALARM_CLOCK = "alarmClock";
        public static final String DELIVERY_BEST_EFFORT = "bestEffort";

        private Companion() {
        }
    }
}
