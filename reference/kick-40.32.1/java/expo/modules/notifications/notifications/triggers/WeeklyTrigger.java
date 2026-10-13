package expo.modules.notifications.notifications.triggers;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import expo.modules.notifications.notifications.interfaces.SchedulableNotificationTrigger;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationTriggers.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB3\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lexpo/modules/notifications/notifications/triggers/WeeklyTrigger;", "Lexpo/modules/notifications/notifications/triggers/ChannelAwareTrigger;", "Lexpo/modules/notifications/notifications/interfaces/SchedulableNotificationTrigger;", "Lexpo/modules/notifications/notifications/triggers/AlarmClockAwareTrigger;", "channelId", "", "weekday", "", "hour", "minute", "alarmClock", "", "<init>", "(Ljava/lang/String;IIIZ)V", "getChannelId", "()Ljava/lang/String;", "getWeekday", "()I", "getHour", "getMinute", "getAlarmClock", "()Z", "toBundle", "Landroid/os/Bundle;", "nextTriggerDate", "Ljava/util/Date;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WeeklyTrigger extends ChannelAwareTrigger implements SchedulableNotificationTrigger, AlarmClockAwareTrigger {
    private static final long serialVersionUID = 924870175512348775L;
    private final boolean alarmClock;
    private final String channelId;
    private final int hour;
    private final int minute;
    private final int weekday;
    public static final Parcelable.Creator<WeeklyTrigger> CREATOR = new Creator();

    /* JADX INFO: compiled from: NotificationTriggers.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WeeklyTrigger> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WeeklyTrigger createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WeeklyTrigger(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WeeklyTrigger[] newArray(int i) {
            return new WeeklyTrigger[i];
        }
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger, android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.channelId);
        dest.writeInt(this.weekday);
        dest.writeInt(this.hour);
        dest.writeInt(this.minute);
        dest.writeInt(this.alarmClock ? 1 : 0);
    }

    @Override // expo.modules.notifications.notifications.triggers.AlarmClockAwareTrigger
    public String getDelivery() {
        return super.getDelivery();
    }

    public WeeklyTrigger(String str, int i, int i2, int i3, boolean z) {
        super(str);
        this.channelId = str;
        this.weekday = i;
        this.hour = i2;
        this.minute = i3;
        this.alarmClock = z;
    }

    public /* synthetic */ WeeklyTrigger(String str, int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i3, (i4 & 16) != 0 ? false : z);
    }

    @Override // expo.modules.notifications.notifications.triggers.AlarmClockAwareTrigger
    public boolean getAlarmClock() {
        return this.alarmClock;
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger
    public String getChannelId() {
        return this.channelId;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getWeekday() {
        return this.weekday;
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger, expo.modules.notifications.notifications.interfaces.NotificationTrigger
    public Bundle toBundle() {
        return bundleWithChannelId(TuplesKt.to("type", "weekly"), TuplesKt.to("weekday", Integer.valueOf(this.weekday)), TuplesKt.to("hour", Integer.valueOf(this.hour)), TuplesKt.to("minute", Integer.valueOf(this.minute)), TuplesKt.to("delivery", getDelivery()));
    }

    @Override // expo.modules.notifications.notifications.interfaces.SchedulableNotificationTrigger
    public Date nextTriggerDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(7, this.weekday);
        calendar.set(11, this.hour);
        calendar.set(12, this.minute);
        calendar.set(13, 0);
        calendar.set(14, 0);
        if (calendar.before(Calendar.getInstance())) {
            calendar.add(8, 1);
        }
        return calendar.getTime();
    }
}
