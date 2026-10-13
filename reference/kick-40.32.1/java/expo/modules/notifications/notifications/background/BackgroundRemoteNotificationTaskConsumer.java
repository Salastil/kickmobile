package expo.modules.notifications.notifications.background;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.interfaces.taskManager.TaskConsumer;
import expo.modules.interfaces.taskManager.TaskConsumerInterface;
import expo.modules.interfaces.taskManager.TaskExecutionCallback;
import expo.modules.interfaces.taskManager.TaskInterface;
import expo.modules.interfaces.taskManager.TaskManagerUtilsInterface;
import expo.modules.notifications.notifications.NotificationSerializer;
import expo.modules.notifications.service.delegates.FirebaseMessagingDelegate;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BackgroundRemoteNotificationTaskConsumer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lexpo/modules/notifications/notifications/background/BackgroundRemoteNotificationTaskConsumer;", "Lexpo/modules/interfaces/taskManager/TaskConsumer;", "Lexpo/modules/interfaces/taskManager/TaskConsumerInterface;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "taskManagerUtils", "Lexpo/modules/interfaces/taskManager/TaskManagerUtilsInterface;", "<init>", "(Landroid/content/Context;Lexpo/modules/interfaces/taskManager/TaskManagerUtilsInterface;)V", "task", "Lexpo/modules/interfaces/taskManager/TaskInterface;", "taskType", "", "didRegister", "", "didUnregister", "didExecuteJob", "", "jobService", "Landroid/app/job/JobService;", "params", "Landroid/app/job/JobParameters;", "executeTask", "bundle", "Landroid/os/Bundle;", "Companion", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BackgroundRemoteNotificationTaskConsumer extends TaskConsumer implements TaskConsumerInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NOTIFICATION_KEY = "notification";
    private TaskInterface task;

    public BackgroundRemoteNotificationTaskConsumer(Context context, TaskManagerUtilsInterface taskManagerUtilsInterface) {
        super(context, taskManagerUtilsInterface);
        FirebaseMessagingDelegate.INSTANCE.addBackgroundTaskConsumer(this);
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public String taskType() {
        return "remote-notification";
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void didRegister(TaskInterface task) {
        this.task = task;
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void didUnregister() {
        FirebaseMessagingDelegate.INSTANCE.removeBackgroundTaskConsumer(this);
        this.task = null;
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumer, expo.modules.interfaces.taskManager.TaskConsumerInterface
    public boolean didExecuteJob(final JobService jobService, final JobParameters params) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        TaskInterface taskInterface = this.task;
        if (taskInterface == null) {
            return false;
        }
        Iterator<PersistableBundle> it = getTaskManagerUtils().extractDataFromJobParams(params).iterator();
        while (it.hasNext()) {
            String string = it.next().getString("notification");
            if (string == null) {
                throw new IllegalArgumentException("Job data missing 'notification' entry".toString());
            }
            Bundle bundle = new Bundle();
            bundle.putBundle("notification", INSTANCE.jsonStringToBundle(string));
            taskInterface.execute(bundle, null, new TaskExecutionCallback() { // from class: expo.modules.notifications.notifications.background.BackgroundRemoteNotificationTaskConsumer$$ExternalSyntheticLambda0
                @Override // expo.modules.interfaces.taskManager.TaskExecutionCallback
                public final void onFinished(Map map) {
                    jobService.jobFinished(params, false);
                }
            });
        }
        return true;
    }

    public final void executeTask(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        TaskInterface taskInterface = this.task;
        if (taskInterface == null) {
            throw new IllegalArgumentException("executeTask called but no task is registered".toString());
        }
        taskInterface.execute(bundle, null);
    }

    /* JADX INFO: compiled from: BackgroundRemoteNotificationTaskConsumer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/notifications/notifications/background/BackgroundRemoteNotificationTaskConsumer$Companion;", "", "<init>", "()V", "NOTIFICATION_KEY", "", "bundleToJson", "Lorg/json/JSONObject;", "bundle", "Landroid/os/Bundle;", "jsonStringToBundle", "jsonString", "expo-notifications_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final JSONObject bundleToJson(Bundle bundle) {
            JSONObject jSONObject = new JSONObject();
            for (String str : bundle.keySet()) {
                try {
                    Object obj = bundle.get(str);
                    if (obj instanceof Bundle) {
                        jSONObject.put(str, bundleToJson((Bundle) obj));
                    } else {
                        jSONObject.put(str, JSONObject.wrap(obj));
                    }
                } catch (JSONException e) {
                    Log.e("expo-notifications", "Could not create JSON object from notification bundle. " + e.getMessage());
                }
            }
            return jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle jsonStringToBundle(String jsonString) {
            try {
                return NotificationSerializer.toBundle(new JSONObject(jsonString));
            } catch (JSONException e) {
                Log.e("expo-notifications", "Could not parse notification from JSON string. " + e.getMessage());
                return null;
            }
        }
    }
}
