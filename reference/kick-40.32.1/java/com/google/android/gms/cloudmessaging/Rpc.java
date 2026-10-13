package com.google.android.gms.cloudmessaging;

import android.app.BroadcastOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.4.0 */
/* JADX INFO: loaded from: classes7.dex */
public class Rpc {
    private static int zza;
    private static PendingIntent zzb;
    private static final Executor zzc = zzaf.zza;
    private static final Pattern zzk = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");
    private final Context zze;
    private final zzw zzf;
    private final ScheduledExecutorService zzg;
    private Messenger zzi;
    private zzd zzj;
    private final SimpleArrayMap zzd = new SimpleArrayMap();
    private final Messenger zzh = new Messenger(new zzy(this, Looper.getMainLooper()));

    public Rpc(Context context) {
        this.zze = context;
        this.zzf = new zzw(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("fcm-rpc-timeout-executor"));
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzg = scheduledThreadPoolExecutor;
    }

    static /* synthetic */ Task zzc(Bundle bundle) {
        return zzg(bundle) ? Tasks.forResult(null) : Tasks.forResult(bundle);
    }

    private static synchronized void zze(Context context, Intent intent) {
        if (zzb == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            zzb = com.google.android.gms.internal.cloudmessaging.zzr.zza(context, 0, intent2, com.google.android.gms.internal.cloudmessaging.zzr.zza);
        }
        intent.putExtra(SessionEndedMetric.PROCESS_TYPE_VALUE, zzb);
    }

    private final void zzf(String str, Bundle bundle) {
        SimpleArrayMap simpleArrayMap = this.zzd;
        synchronized (simpleArrayMap) {
            TaskCompletionSource taskCompletionSource = (TaskCompletionSource) simpleArrayMap.remove(str);
            if (taskCompletionSource != null) {
                taskCompletionSource.setResult(bundle);
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append("Missing callback for ");
            sb.append(str);
            Log.w("Rpc", sb.toString());
        }
    }

    private static boolean zzg(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    private static synchronized String zzh() {
        int i;
        i = zza;
        zza = i + 1;
        return Integer.toString(i);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:30:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d8  */
    private final Task zzi(Bundle bundle) {
        int iZza;
        Context context;
        final String strZzh = zzh();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        SimpleArrayMap simpleArrayMap = this.zzd;
        synchronized (simpleArrayMap) {
            simpleArrayMap.put(strZzh, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.zzf.zza() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        zze(this.zze, intent);
        StringBuilder sb = new StringBuilder(String.valueOf(strZzh).length() + 5);
        sb.append("|ID|");
        sb.append(strZzh);
        sb.append("|");
        intent.putExtra("kid", sb.toString());
        if (Log.isLoggable("Rpc", 3)) {
            String strValueOf = String.valueOf(intent.getExtras());
            String.valueOf(strValueOf);
            Log.d("Rpc", "Sending ".concat(String.valueOf(strValueOf)));
        }
        intent.putExtra("google.messenger", this.zzh);
        if (this.zzi == null && this.zzj == null) {
            iZza = this.zzf.zza();
            context = this.zze;
            if (iZza == 2) {
                context.startService(intent);
            } else if (Build.VERSION.SDK_INT < 34) {
                context.sendBroadcast(intent);
            } else {
                context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
            }
        } else {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                Messenger messenger = this.zzi;
                if (messenger != null) {
                    messenger.send(messageObtain);
                } else {
                    this.zzj.zza.send(messageObtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
                iZza = this.zzf.zza();
                context = this.zze;
                if (iZza == 2) {
                    context.startService(intent);
                } else if (Build.VERSION.SDK_INT < 34) {
                    context.sendBroadcast(intent);
                } else {
                    context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
                }
            }
        }
        final ScheduledFuture<?> scheduledFutureSchedule = this.zzg.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzaa
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                if (taskCompletionSource.trySetException(new IOException("TIMEOUT"))) {
                    Log.w("Rpc", "No response");
                }
            }
        }, 30L, TimeUnit.SECONDS);
        taskCompletionSource.getTask().addOnCompleteListener(zzc, new OnCompleteListener() { // from class: com.google.android.gms.cloudmessaging.zzab
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                this.zza.zzb(strZzh, scheduledFutureSchedule, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    public Task<CloudMessage> getProxiedNotificationData() {
        return this.zzf.zzb() >= 241100000 ? zzv.zza(this.zze).zzc(5, Bundle.EMPTY).continueWith(zzc, zzac.zza) : Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
    }

    public Task<Void> messageHandled(CloudMessage cloudMessage) {
        if (this.zzf.zzb() < 233700000) {
            return Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putString("google.message_id", cloudMessage.getMessageId());
        Integer numZza = cloudMessage.zza();
        if (numZza != null) {
            bundle.putInt(Constants.MessagePayloadKeys.PRODUCT_ID, numZza.intValue());
        }
        return zzv.zza(this.zze).zzb(3, bundle);
    }

    public Task<Bundle> send(final Bundle bundle) {
        zzw zzwVar = this.zzf;
        if (zzwVar.zzb() < 12000000) {
            return zzwVar.zza() != 0 ? zzi(bundle).continueWithTask(zzc, new Continuation() { // from class: com.google.android.gms.cloudmessaging.zzz
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return this.zza.zza(bundle, task);
                }
            }) : Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
        }
        return zzv.zza(this.zze).zzc(1, bundle).continueWith(zzc, zzae.zza);
    }

    public Task<Void> setRetainProxiedNotifications(boolean z) {
        if (this.zzf.zzb() < 241100000) {
            return Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("proxy_retention", z);
        return zzv.zza(this.zze).zzb(4, bundle);
    }

    final /* synthetic */ Task zza(Bundle bundle, Task task) {
        return (task.isSuccessful() && zzg((Bundle) task.getResult())) ? zzi(bundle).onSuccessTask(zzc, zzad.zza) : task;
    }

    final /* synthetic */ void zzb(String str, ScheduledFuture scheduledFuture, Task task) {
        SimpleArrayMap simpleArrayMap = this.zzd;
        synchronized (simpleArrayMap) {
            simpleArrayMap.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    final /* synthetic */ void zzd(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("Rpc", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(new zzc());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof zzd) {
                this.zzj = (zzd) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.zzi = (Messenger) parcelableExtra;
            }
        }
        Intent intent2 = (Intent) message.obj;
        String action = intent2.getAction();
        if (!Objects.equals(action, "com.google.android.c2dm.intent.REGISTRATION")) {
            if (Log.isLoggable("Rpc", 3)) {
                String.valueOf(action);
                Log.d("Rpc", "Unexpected response action: ".concat(String.valueOf(action)));
                return;
            }
            return;
        }
        String stringExtra = intent2.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent2.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            Matcher matcher = zzk.matcher(stringExtra);
            if (!matcher.matches()) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Unexpected response string: ".concat(stringExtra));
                    return;
                }
                return;
            }
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                Bundle extras = intent2.getExtras();
                extras.putString("registration_id", strGroup2);
                zzf(strGroup, extras);
                return;
            }
            return;
        }
        String stringExtra2 = intent2.getStringExtra("error");
        if (stringExtra2 == null) {
            String strValueOf = String.valueOf(intent2.getExtras());
            String.valueOf(strValueOf);
            Log.w("Rpc", "Unexpected response, no error or registration id ".concat(String.valueOf(strValueOf)));
            return;
        }
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Received InstanceID error ".concat(stringExtra2));
        }
        if (!stringExtra2.startsWith("|")) {
            SimpleArrayMap simpleArrayMap = this.zzd;
            synchronized (simpleArrayMap) {
                for (int i = 0; i < simpleArrayMap.getSize(); i++) {
                    zzf((String) simpleArrayMap.keyAt(i), intent2.getExtras());
                }
            }
            return;
        }
        String[] strArrSplit = stringExtra2.split("\\|");
        if (strArrSplit.length <= 2 || !Objects.equals(strArrSplit[1], "ID")) {
            Log.w("Rpc", "Unexpected structured response ".concat(stringExtra2));
            return;
        }
        String str = strArrSplit[2];
        String strSubstring = strArrSplit[3];
        if (strSubstring.startsWith(ServerSentEventKt.COLON)) {
            strSubstring = strSubstring.substring(1);
        }
        zzf(str, intent2.putExtra("error", strSubstring).getExtras());
    }
}
