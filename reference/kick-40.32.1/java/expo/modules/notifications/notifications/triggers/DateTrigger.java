package expo.modules.notifications.notifications.triggers;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import expo.modules.notifications.notifications.interfaces.SchedulableNotificationTrigger;
import java.util.Date;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationTriggers.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001cB#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lexpo/modules/notifications/notifications/triggers/DateTrigger;", "Lexpo/modules/notifications/notifications/triggers/ChannelAwareTrigger;", "Lexpo/modules/notifications/notifications/interfaces/SchedulableNotificationTrigger;", "Lexpo/modules/notifications/notifications/triggers/AlarmClockAwareTrigger;", "channelId", "", "timestamp", "", "alarmClock", "", "<init>", "(Ljava/lang/String;JZ)V", "getChannelId", "()Ljava/lang/String;", "getTimestamp", "()J", "getAlarmClock", "()Z", "toBundle", "Landroid/os/Bundle;", "nextTriggerDate", "Ljava/util/Date;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "Companion", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DateTrigger extends ChannelAwareTrigger implements SchedulableNotificationTrigger, AlarmClockAwareTrigger {
    private static final long serialVersionUID = -4200735944844450465L;
    private final boolean alarmClock;
    private final String channelId;
    private final long timestamp;
    public static final Parcelable.Creator<DateTrigger> CREATOR = new Creator();

    /* JADX INFO: compiled from: NotificationTriggers.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DateTrigger> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DateTrigger createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DateTrigger(parcel.readString(), parcel.readLong(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DateTrigger[] newArray(int i) {
            return new DateTrigger[i];
        }
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger, android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.channelId);
        dest.writeLong(this.timestamp);
        dest.writeInt(this.alarmClock ? 1 : 0);
    }

    @Override // expo.modules.notifications.notifications.triggers.AlarmClockAwareTrigger
    public String getDelivery() {
        return super.getDelivery();
    }

    public /* synthetic */ DateTrigger(String str, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, (i & 4) != 0 ? false : z);
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger
    public String getChannelId() {
        return this.channelId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // expo.modules.notifications.notifications.triggers.AlarmClockAwareTrigger
    public boolean getAlarmClock() {
        return this.alarmClock;
    }

    public DateTrigger(String str, long j, boolean z) {
        super(str);
        this.channelId = str;
        this.timestamp = j;
        this.alarmClock = z;
    }

    @Override // expo.modules.notifications.notifications.triggers.ChannelAwareTrigger, expo.modules.notifications.notifications.interfaces.NotificationTrigger
    public Bundle toBundle() {
        return bundleWithChannelId(TuplesKt.to("type", "date"), TuplesKt.to("repeats", false), TuplesKt.to("value", Long.valueOf(this.timestamp)), TuplesKt.to("delivery", getDelivery()));
    }

    @Override // expo.modules.notifications.notifications.interfaces.SchedulableNotificationTrigger
    public Date nextTriggerDate() {
        Date date = new Date();
        Date date2 = new Date(this.timestamp);
        if (date2.before(date)) {
            return null;
        }
        return date2;
    }
}
