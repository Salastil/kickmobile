package expo.modules.updates.statemachine;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: UpdatesStateEvent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000e\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u000e\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#¨\u0006$"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "", "type", "Lexpo/modules/updates/statemachine/UpdatesStateEventType;", "<init>", "(Lexpo/modules/updates/statemachine/UpdatesStateEventType;)V", "getType", "()Lexpo/modules/updates/statemachine/UpdatesStateEventType;", "StartStartup", "EndStartup", "Check", "CheckCompleteWithUpdate", "CheckCompleteWithRollback", "CheckCompleteUnavailable", "CheckError", "Download", "DownloadProgress", "DownloadCompleteUnavailable", "DownloadCompleteWithUpdate", "DownloadCompleteWithRollback", "DownloadError", "Restart", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$Check;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$CheckCompleteUnavailable;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$CheckCompleteWithRollback;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$CheckCompleteWithUpdate;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$CheckError;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$Download;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$DownloadCompleteUnavailable;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$DownloadCompleteWithRollback;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$DownloadCompleteWithUpdate;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$DownloadError;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$DownloadProgress;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$EndStartup;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$Restart;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent$StartStartup;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class UpdatesStateEvent {
    private final UpdatesStateEventType type;

    public /* synthetic */ UpdatesStateEvent(UpdatesStateEventType updatesStateEventType, DefaultConstructorMarker defaultConstructorMarker) {
        this(updatesStateEventType);
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$StartStartup;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "<init>", "()V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class StartStartup extends UpdatesStateEvent {
        public StartStartup() {
            super(UpdatesStateEventType.StartStartup, null);
        }
    }

    private UpdatesStateEvent(UpdatesStateEventType updatesStateEventType) {
        this.type = updatesStateEventType;
    }

    public final UpdatesStateEventType getType() {
        return this.type;
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$EndStartup;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "<init>", "()V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class EndStartup extends UpdatesStateEvent {
        public EndStartup() {
            super(UpdatesStateEventType.EndStartup, null);
        }
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$Check;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "<init>", "()V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Check extends UpdatesStateEvent {
        public Check() {
            super(UpdatesStateEventType.Check, null);
        }
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$CheckCompleteWithUpdate;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "manifest", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "getManifest", "()Lorg/json/JSONObject;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CheckCompleteWithUpdate extends UpdatesStateEvent {
        private final JSONObject manifest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckCompleteWithUpdate(JSONObject manifest) {
            super(UpdatesStateEventType.CheckCompleteAvailable, null);
            Intrinsics.checkNotNullParameter(manifest, "manifest");
            this.manifest = manifest;
        }

        public final JSONObject getManifest() {
            return this.manifest;
        }
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$CheckCompleteWithRollback;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "commitTime", "Ljava/util/Date;", "<init>", "(Ljava/util/Date;)V", "getCommitTime", "()Ljava/util/Date;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CheckCompleteWithRollback extends UpdatesStateEvent {
        private final Date commitTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckCompleteWithRollback(Date commitTime) {
            super(UpdatesStateEventType.CheckCompleteAvailable, null);
            Intrinsics.checkNotNullParameter(commitTime, "commitTime");
            this.commitTime = commitTime;
        }

        public final Date getCommitTime() {
            return this.commitTime;
        }
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$CheckCompleteUnavailable;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "<init>", "()V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CheckCompleteUnavailable extends UpdatesStateEvent {
        public CheckCompleteUnavailable() {
            super(UpdatesStateEventType.CheckCompleteUnavailable, null);
        }
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$CheckError;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "errorMessage", "", "<init>", "(Ljava/lang/String;)V", "error", "Lexpo/modules/updates/statemachine/UpdatesStateError;", "getError", "()Lexpo/modules/updates/statemachine/UpdatesStateError;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CheckError extends UpdatesStateEvent {
        private final String errorMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CheckError(String errorMessage) {
            super(UpdatesStateEventType.CheckError, null);
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
        }

        public final UpdatesStateError getError() {
            return new UpdatesStateError(this.errorMessage);
        }
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$Download;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "<init>", "()V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Download extends UpdatesStateEvent {
        public Download() {
            super(UpdatesStateEventType.Download, null);
        }
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$DownloadProgress;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "progress", "", "<init>", "(D)V", "getProgress", "()D", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DownloadProgress extends UpdatesStateEvent {
        private final double progress;

        public DownloadProgress(double d) {
            super(UpdatesStateEventType.DownloadProgress, null);
            this.progress = d;
        }

        public final double getProgress() {
            return this.progress;
        }
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$DownloadCompleteUnavailable;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "<init>", "()V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DownloadCompleteUnavailable extends UpdatesStateEvent {
        public DownloadCompleteUnavailable() {
            super(UpdatesStateEventType.DownloadCompleteUnavailable, null);
        }
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$DownloadCompleteWithUpdate;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "manifest", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "getManifest", "()Lorg/json/JSONObject;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DownloadCompleteWithUpdate extends UpdatesStateEvent {
        private final JSONObject manifest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadCompleteWithUpdate(JSONObject manifest) {
            super(UpdatesStateEventType.DownloadCompleteWithUpdate, null);
            Intrinsics.checkNotNullParameter(manifest, "manifest");
            this.manifest = manifest;
        }

        public final JSONObject getManifest() {
            return this.manifest;
        }
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$DownloadCompleteWithRollback;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "<init>", "()V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DownloadCompleteWithRollback extends UpdatesStateEvent {
        public DownloadCompleteWithRollback() {
            super(UpdatesStateEventType.DownloadCompleteWithRollback, null);
        }
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$DownloadError;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "errorMessage", "", "<init>", "(Ljava/lang/String;)V", "error", "Lexpo/modules/updates/statemachine/UpdatesStateError;", "getError", "()Lexpo/modules/updates/statemachine/UpdatesStateError;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DownloadError extends UpdatesStateEvent {
        private final String errorMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadError(String errorMessage) {
            super(UpdatesStateEventType.DownloadError, null);
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
        }

        public final UpdatesStateError getError() {
            return new UpdatesStateError(this.errorMessage);
        }
    }

    /* JADX INFO: compiled from: UpdatesStateEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/statemachine/UpdatesStateEvent$Restart;", "Lexpo/modules/updates/statemachine/UpdatesStateEvent;", "<init>", "()V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Restart extends UpdatesStateEvent {
        public Restart() {
            super(UpdatesStateEventType.Restart, null);
        }
    }
}
