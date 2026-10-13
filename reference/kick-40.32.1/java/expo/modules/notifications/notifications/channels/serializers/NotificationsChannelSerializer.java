package expo.modules.notifications.notifications.channels.serializers;

import android.app.NotificationChannel;
import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: compiled from: NotificationsChannelSerializer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lexpo/modules/notifications/notifications/channels/serializers/NotificationsChannelSerializer;", "", "toBundle", "Landroid/os/Bundle;", "channel", "Landroid/app/NotificationChannel;", "Companion", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationsChannelSerializer {
    public static final String AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY = "contentType";
    public static final String AUDIO_ATTRIBUTES_FLAGS_ENFORCE_AUDIBILITY_KEY = "enforceAudibility";
    public static final String AUDIO_ATTRIBUTES_FLAGS_HW_AV_SYNC_KEY = "requestHardwareAudioVideoSynchronization";
    public static final String AUDIO_ATTRIBUTES_FLAGS_KEY = "flags";
    public static final String AUDIO_ATTRIBUTES_USAGE_KEY = "usage";
    public static final String BYPASS_DND_KEY = "bypassDnd";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String DESCRIPTION_KEY = "description";
    public static final String ENABLE_LIGHTS_KEY = "enableLights";
    public static final String ENABLE_VIBRATE_KEY = "enableVibrate";
    public static final String GROUP_ID_KEY = "groupId";
    public static final String ID_KEY = "id";
    public static final String IMPORTANCE_KEY = "importance";
    public static final String LIGHT_COLOR_KEY = "lightColor";
    public static final String LOCKSCREEN_VISIBILITY_KEY = "lockscreenVisibility";
    public static final String NAME_KEY = "name";
    public static final String SHOW_BADGE_KEY = "showBadge";
    public static final String SOUND_AUDIO_ATTRIBUTES_KEY = "audioAttributes";
    public static final String SOUND_KEY = "sound";
    public static final String VIBRATION_PATTERN_KEY = "vibrationPattern";

    Bundle toBundle(NotificationChannel channel);

    /* JADX INFO: compiled from: NotificationsChannelSerializer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/notifications/notifications/channels/serializers/NotificationsChannelSerializer$Companion;", "", "<init>", "()V", "ID_KEY", "", "NAME_KEY", "IMPORTANCE_KEY", "BYPASS_DND_KEY", "DESCRIPTION_KEY", "GROUP_ID_KEY", "LIGHT_COLOR_KEY", "LOCKSCREEN_VISIBILITY_KEY", "SHOW_BADGE_KEY", "SOUND_KEY", "SOUND_AUDIO_ATTRIBUTES_KEY", "VIBRATION_PATTERN_KEY", "ENABLE_LIGHTS_KEY", "ENABLE_VIBRATE_KEY", "AUDIO_ATTRIBUTES_USAGE_KEY", "AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY", "AUDIO_ATTRIBUTES_FLAGS_KEY", "AUDIO_ATTRIBUTES_FLAGS_ENFORCE_AUDIBILITY_KEY", "AUDIO_ATTRIBUTES_FLAGS_HW_AV_SYNC_KEY", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY = "contentType";
        public static final String AUDIO_ATTRIBUTES_FLAGS_ENFORCE_AUDIBILITY_KEY = "enforceAudibility";
        public static final String AUDIO_ATTRIBUTES_FLAGS_HW_AV_SYNC_KEY = "requestHardwareAudioVideoSynchronization";
        public static final String AUDIO_ATTRIBUTES_FLAGS_KEY = "flags";
        public static final String AUDIO_ATTRIBUTES_USAGE_KEY = "usage";
        public static final String BYPASS_DND_KEY = "bypassDnd";
        public static final String DESCRIPTION_KEY = "description";
        public static final String ENABLE_LIGHTS_KEY = "enableLights";
        public static final String ENABLE_VIBRATE_KEY = "enableVibrate";
        public static final String GROUP_ID_KEY = "groupId";
        public static final String ID_KEY = "id";
        public static final String IMPORTANCE_KEY = "importance";
        public static final String LIGHT_COLOR_KEY = "lightColor";
        public static final String LOCKSCREEN_VISIBILITY_KEY = "lockscreenVisibility";
        public static final String NAME_KEY = "name";
        public static final String SHOW_BADGE_KEY = "showBadge";
        public static final String SOUND_AUDIO_ATTRIBUTES_KEY = "audioAttributes";
        public static final String SOUND_KEY = "sound";
        public static final String VIBRATION_PATTERN_KEY = "vibrationPattern";

        private Companion() {
        }
    }
}
