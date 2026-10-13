package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzky {
    public static final /* synthetic */ int zza = 0;
    private static UserManager zzb;
    private static volatile boolean zzc = !zza();

    private zzky() {
    }

    public static boolean zza() {
        return true;
    }

    public static boolean zzb(Context context) {
        return zza() && !zzi(context);
    }

    public static boolean zzc(Context context) {
        return !zza() || zzi(context);
    }

    public static ListenableFuture zzd(Context context, final Callable callable, Executor executor) {
        return zze(context, new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzkx
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final /* synthetic */ ListenableFuture call() {
                int i = zzky.zza;
                return Futures.submit(callable, MoreExecutors.directExecutor());
            }
        }, executor);
    }

    public static ListenableFuture zze(final Context context, AsyncCallable asyncCallable, Executor executor) {
        if (zzc(context)) {
            return Futures.submitAsync(asyncCallable, executor);
        }
        final SettableFuture settableFutureCreate = SettableFuture.create();
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        final zzkv zzkvVar = new zzkv(atomicBoolean, context, settableFutureCreate, asyncCallable, executor);
        context.registerReceiver(zzkvVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
        if (!zzc(context) || !atomicBoolean.compareAndSet(false, true)) {
            settableFutureCreate.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzkw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzky.zzj(settableFutureCreate, atomicBoolean, context, zzkvVar);
                }
            }, MoreExecutors.directExecutor());
            return settableFutureCreate;
        }
        zzh(context, zzkvVar);
        settableFutureCreate.setFuture(Futures.submitAsync(asyncCallable, executor));
        return settableFutureCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzh(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e) {
            Log.w("DirectBootUtils", "Failed to unregister receiver", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void zzj(SettableFuture settableFuture, AtomicBoolean atomicBoolean, Context context, BroadcastReceiver broadcastReceiver) {
        if (settableFuture.isCancelled() && atomicBoolean.compareAndSet(false, true)) {
            zzh(context, broadcastReceiver);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x004e A[Catch: all -> 0x0052, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x000d, B:14:0x0015, B:16:0x0019, B:17:0x0023, B:30:0x004e, B:31:0x0050, B:20:0x0029, B:22:0x002f, B:26:0x003c, B:28:0x004a), top: B:36:0x0009, inners: #1 }] */
    private static boolean zzi(Context context) {
        if (zzc) {
            return true;
        }
        synchronized (zzky.class) {
            if (zzc) {
                return true;
            }
            int i = 1;
            while (true) {
                boolean z = false;
                if (i <= 2) {
                    if (zzb == null) {
                        zzb = (UserManager) context.getSystemService(UserManager.class);
                    }
                    UserManager userManager = zzb;
                    if (userManager == null) {
                        z = true;
                    } else {
                        try {
                            if (userManager.isUserUnlocked() || !userManager.isUserRunning(Process.myUserHandle())) {
                                z = true;
                            }
                        } catch (NullPointerException e) {
                            Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e);
                            zzb = null;
                            i++;
                        }
                    }
                    if (z) {
                        zzc = true;
                    }
                    return z;
                }
                if (z) {
                    zzb = null;
                }
                if (z) {
                    zzc = true;
                }
                return z;
            }
        }
    }
}
