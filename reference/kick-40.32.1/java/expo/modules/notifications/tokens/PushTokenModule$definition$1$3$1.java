package expo.modules.notifications.tokens;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushTokenModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class PushTokenModule$definition$1$3$1<TResult> implements OnCompleteListener {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ ModuleDefinitionBuilder $this_ModuleDefinition;
    final /* synthetic */ PushTokenModule this$0;

    PushTokenModule$definition$1$3$1(Promise promise, ModuleDefinitionBuilder moduleDefinitionBuilder, PushTokenModule pushTokenModule) {
        this.$promise = promise;
        this.$this_ModuleDefinition = moduleDefinitionBuilder;
        this.this$0 = pushTokenModule;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<String> task) {
        String message;
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            Promise promise = this.$promise;
            if (exception == null || (message = exception.getMessage()) == null) {
                message = "unknown";
            }
            promise.reject("E_REGISTRATION_FAILED", "Fetching the token failed: " + message, exception);
            return;
        }
        String result = task.getResult();
        if (result == null) {
            this.$promise.reject("E_REGISTRATION_FAILED", "Fetching the token failed. Invalid token.", null);
        } else {
            this.$promise.resolve(result);
            this.this$0.onNewToken(result);
        }
    }
}
