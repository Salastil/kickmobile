package com.google.mlkit.vision.documentscanner.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.mlkit_vision_document_scanner.zzsg;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-document-scanner@@16.0.0-beta1 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzh {
    private static final Executor zza = MLTaskExecutor.workerThreadExecutor();
    private final Context zzb;

    private zzh(Context context) {
        this.zzb = context;
    }

    public static zzh zzc(Context context) {
        return new zzh(context);
    }

    private static void zze(String str, Exception exc) {
        if (Log.isLoggable("ResultHelper", 6)) {
            Log.e("ResultHelper", str, exc);
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    final Uri zza(Uri uri, String str) {
        String scheme;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return null;
        }
        File file = new File(this.zzb.getCacheDir(), "mlkit_docscan_ui_client");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, SystemClock.elapsedRealtimeNanos() + str);
        try {
            Context context = this.zzb;
            InputStream inputStreamZza = com.google.android.gms.internal.mlkit_vision_document_scanner.zzl.zza(context, uri, (Objects.equals(context.getPackageName(), "com.google.android.gms") || !scheme.equals("content")) ? com.google.android.gms.internal.mlkit_vision_document_scanner.zzk.zzc : com.google.android.gms.internal.mlkit_vision_document_scanner.zzk.zza);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStreamZza.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                        if (inputStreamZza != null) {
                            try {
                                inputStreamZza.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                        throw th;
                    }
                    fileOutputStream.flush();
                    Uri uriFromFile = Uri.fromFile(file2);
                    fileOutputStream.close();
                    if (inputStreamZza != null) {
                        inputStreamZza.close();
                    }
                    return uriFromFile;
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                if (inputStreamZza != null) {
                    inputStreamZza.close();
                }
                throw th4;
            }
        } catch (IOException e) {
            zze("Failed to save file to local: ".concat(uri.toString()), e);
            return null;
        }
    }

    final Task zzb(final int i, final Intent intent) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zza.execute(new Runnable() { // from class: com.google.mlkit.vision.documentscanner.internal.zzg
            /* JADX WARN: Code duplicated, block: B:17:0x004e A[Catch: all -> 0x005d, TryCatch #0 {all -> 0x005d, blocks: (B:6:0x000f, B:8:0x002b, B:10:0x0031, B:12:0x0037, B:15:0x0046, B:17:0x004e, B:21:0x0058, B:27:0x0063, B:28:0x006e), top: B:36:0x000f }] */
            /* JADX WARN: Code duplicated, block: B:19:0x0056  */
            /* JADX WARN: Code duplicated, block: B:20:0x0057  */
            /* JADX WARN: Code duplicated, block: B:21:0x0058 A[Catch: all -> 0x005d, PHI: r5
              0x0058: PHI (r5v2 android.net.Uri) = (r5v6 android.net.Uri), (r5v4 android.net.Uri) binds: [B:16:0x004c, B:20:0x0057] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x005d, blocks: (B:6:0x000f, B:8:0x002b, B:10:0x0031, B:12:0x0037, B:15:0x0046, B:17:0x004e, B:21:0x0058, B:27:0x0063, B:28:0x006e), top: B:36:0x000f }] */
            @Override // java.lang.Runnable
            public final void run() {
                Uri uriZza;
                int i2 = i;
                zzh zzhVar = this.zza;
                Intent intent2 = intent;
                GmsDocumentScanningResult gmsDocumentScanningResultZza = null;
                gmsDocumentScanningResultZza = null;
                gmsDocumentScanningResultZza = null;
                Uri uri = null;
                gmsDocumentScanningResultZza = null;
                if (i2 == -1 && intent2 != null) {
                    try {
                        ArrayList parcelableArrayListExtra = intent2.getParcelableArrayListExtra("uri_array_extra_result_image_uris");
                        Uri uri2 = (Uri) intent2.getParcelableExtra("uri_extra_result_pdf_uri");
                        int i3 = 0;
                        int intExtra = intent2.getIntExtra("int_extra_result_page_count", 0);
                        ArrayList arrayList = new ArrayList();
                        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
                            int size = parcelableArrayListExtra.size();
                            while (true) {
                                if (i3 < size) {
                                    Uri uriZza2 = zzhVar.zza((Uri) parcelableArrayListExtra.get(i3), ".jpg");
                                    if (uriZza2 != null) {
                                        arrayList.add(uriZza2);
                                        i3++;
                                    }
                                } else if (uri2 == null) {
                                    gmsDocumentScanningResultZza = GmsDocumentScanningResult.zza(arrayList, uri, intExtra);
                                } else {
                                    uriZza = zzhVar.zza(uri2, ".pdf");
                                    if (uriZza == null) {
                                        uri = uriZza;
                                        gmsDocumentScanningResultZza = GmsDocumentScanningResult.zza(arrayList, uri, intExtra);
                                    }
                                }
                            }
                        } else if (uri2 == null) {
                            gmsDocumentScanningResultZza = GmsDocumentScanningResult.zza(arrayList, uri, intExtra);
                        } else {
                            uriZza = zzhVar.zza(uri2, ".pdf");
                            if (uriZza == null) {
                                uri = uriZza;
                                gmsDocumentScanningResultZza = GmsDocumentScanningResult.zza(arrayList, uri, intExtra);
                            }
                        }
                    } finally {
                        if (intent2 != null) {
                            zzhVar.zzd(intent2.getStringExtra("string_extra_session_id"));
                        }
                    }
                }
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                if (gmsDocumentScanningResultZza == null) {
                    taskCompletionSource2.setException(new IllegalStateException("Failed to handle result"));
                } else {
                    taskCompletionSource2.setResult(gmsDocumentScanningResultZza);
                }
                if (intent2 != null) {
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    final void zzd(final String str) {
        if (str == null) {
            return;
        }
        try {
            Tasks.await(new zzk(this.zzb).doRead(TaskApiCall.builder().setFeatures(OptionalModuleUtils.FEATURE_DOCSCAN_UI).run(new RemoteCall() { // from class: com.google.mlkit.vision.documentscanner.internal.zzi
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) throws RemoteException {
                    int i = zzk.zza;
                    ((zzsg) ((zzl) obj).getService()).zzc(str);
                    ((TaskCompletionSource) obj2).setResult(null);
                }
            }).setMethodKey(24337).build()));
        } catch (InterruptedException | ExecutionException e) {
            zze("Failed to cleanup GMS Core cache", e);
        }
    }
}
