package expo.modules.updates.errorrecovery;

import expo.modules.notifications.service.NotificationsService;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.launcher.Launcher;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ErrorRecoveryDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0014\u0010\u0007\u001a\u00020\u00032\n\u0010\b\u001a\u00060\tj\u0002`\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lexpo/modules/updates/errorrecovery/ErrorRecoveryDelegate;", "", "loadRemoteUpdate", "", "relaunch", "callback", "Lexpo/modules/updates/launcher/Launcher$LauncherCallback;", "throwException", NotificationsService.EXCEPTION_KEY, "Ljava/lang/Exception;", "Lkotlin/Exception;", "markFailedLaunchForLaunchedUpdate", "markSuccessfulLaunchForLaunchedUpdate", "getRemoteLoadStatus", "Lexpo/modules/updates/errorrecovery/ErrorRecoveryDelegate$RemoteLoadStatus;", "getCheckAutomaticallyConfiguration", "Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "getLaunchedUpdateSuccessfulLaunchCount", "", "RemoteLoadStatus", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ErrorRecoveryDelegate {

    /* JADX INFO: compiled from: ErrorRecoveryDelegate.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/errorrecovery/ErrorRecoveryDelegate$RemoteLoadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "NEW_UPDATE_LOADING", "NEW_UPDATE_LOADED", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum RemoteLoadStatus {
        IDLE,
        NEW_UPDATE_LOADING,
        NEW_UPDATE_LOADED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<RemoteLoadStatus> getEntries() {
            return $ENTRIES;
        }
    }

    UpdatesConfiguration.CheckAutomaticallyConfiguration getCheckAutomaticallyConfiguration();

    int getLaunchedUpdateSuccessfulLaunchCount();

    RemoteLoadStatus getRemoteLoadStatus();

    void loadRemoteUpdate();

    void markFailedLaunchForLaunchedUpdate();

    void markSuccessfulLaunchForLaunchedUpdate();

    void relaunch(Launcher.LauncherCallback callback);

    void throwException(Exception exception);
}
