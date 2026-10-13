package expo.modules.updates;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactHost;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.modules.core.interfaces.ReactActivityHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: UpdatesPackage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0083@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0083@¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"expo/modules/updates/UpdatesPackage$createReactActivityHandlers$handler$1", "Lexpo/modules/core/interfaces/ReactActivityHandler;", "getDelayLoadAppHandler", "Lexpo/modules/core/interfaces/ReactActivityHandler$DelayLoadAppHandler;", "activity", "Lcom/facebook/react/ReactActivity;", "reactHost", "Lcom/facebook/react/ReactHost;", "startUpdatesController", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "useDeveloperSupport", "", "(Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeReadyRunnable", "whenReadyRunnable", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdatesPackage$createReactActivityHandlers$handler$1 implements ReactActivityHandler {
    UpdatesPackage$createReactActivityHandlers$handler$1() {
    }

    @Override // expo.modules.core.interfaces.ReactActivityHandler
    public ReactActivityHandler.DelayLoadAppHandler getDelayLoadAppHandler(ReactActivity activity, ReactHost reactHost) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(reactHost, "reactHost");
        if (UpdatesPackage.INSTANCE.isUsingCustomInit$expo_updates_release()) {
            return null;
        }
        final Context applicationContext = activity.getApplicationContext();
        DevSupportManager devSupportManager = reactHost.getDevSupportManager();
        final boolean devSupportEnabled = devSupportManager != null ? devSupportManager.getDevSupportEnabled() : false;
        if (!devSupportEnabled || UpdatesPackage.INSTANCE.isUsingNativeDebug()) {
            return new ReactActivityHandler.DelayLoadAppHandler() { // from class: expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1$$ExternalSyntheticLambda0
                @Override // expo.modules.core.interfaces.ReactActivityHandler.DelayLoadAppHandler
                public final void whenReady(Runnable runnable) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1(this.f$0, applicationContext, devSupportEnabled, runnable, null), 3, null);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object startUpdatesController(Context context, boolean z, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new UpdatesPackage$createReactActivityHandlers$handler$1$startUpdatesController$2(context, z, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object invokeReadyRunnable(Runnable runnable, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new UpdatesPackage$createReactActivityHandlers$handler$1$invokeReadyRunnable$2(runnable, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
