package expo.modules.notifications.notifications.channels.serializers;

import android.app.NotificationChannel;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.facebook.hermes.intl.Constants;
import expo.modules.notifications.notifications.enums.AudioContentType;
import expo.modules.notifications.notifications.enums.AudioUsage;
import expo.modules.notifications.notifications.enums.NotificationImportance;
import expo.modules.notifications.notifications.enums.NotificationVisibility;

/* JADX INFO: loaded from: classes9.dex */
public class ExpoNotificationsChannelSerializer implements NotificationsChannelSerializer {
    @Override // expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer
    public Bundle toBundle(NotificationChannel notificationChannel) {
        Bundle bundle = new Bundle();
        bundle.putString("id", getChannelId(notificationChannel));
        bundle.putString("name", notificationChannel.getName().toString());
        bundle.putInt("importance", NotificationImportance.fromNativeValue(notificationChannel.getImportance()).getEnumValue());
        bundle.putBoolean("bypassDnd", notificationChannel.canBypassDnd());
        bundle.putString("description", notificationChannel.getDescription());
        bundle.putString("groupId", getGroupId(notificationChannel));
        bundle.putString("lightColor", String.format("#%08x", Integer.valueOf(Color.valueOf(notificationChannel.getLightColor()).toArgb())).toUpperCase());
        bundle.putInt("lockscreenVisibility", NotificationVisibility.fromNativeValue(notificationChannel.getLockscreenVisibility()).getEnumValue());
        bundle.putBoolean("showBadge", notificationChannel.canShowBadge());
        bundle.putString("sound", toString(notificationChannel.getSound()));
        bundle.putBundle("audioAttributes", toBundle(notificationChannel.getAudioAttributes()));
        bundle.putLongArray("vibrationPattern", notificationChannel.getVibrationPattern());
        bundle.putBoolean("enableLights", notificationChannel.shouldShowLights());
        bundle.putBoolean("enableVibrate", notificationChannel.shouldVibrate());
        return bundle;
    }

    protected String getChannelId(NotificationChannel notificationChannel) {
        return notificationChannel.getId();
    }

    protected String getGroupId(NotificationChannel notificationChannel) {
        return notificationChannel.getGroup();
    }

    private String toString(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (Settings.System.DEFAULT_NOTIFICATION_URI.equals(uri)) {
            return Constants.COLLATION_DEFAULT;
        }
        return "custom";
    }

    private Bundle toBundle(AudioAttributes audioAttributes) {
        if (audioAttributes == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("usage", AudioUsage.fromNativeValue(audioAttributes.getUsage()).getEnumValue());
        bundle.putInt("contentType", AudioContentType.fromNativeValue(audioAttributes.getContentType()).getEnumValue());
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("requestHardwareAudioVideoSynchronization", (audioAttributes.getFlags() & 16) > 0);
        bundle2.putBoolean("enforceAudibility", (audioAttributes.getFlags() & 1) > 0);
        bundle.putBundle("flags", bundle2);
        return bundle;
    }
}
