package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzjs;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcf extends com.google.android.gms.internal.play_billing.zzah {
    final WeakReference zza;
    final ResultReceiver zzb;
    final /* synthetic */ BillingClientImpl zzc;

    /* synthetic */ zzcf(BillingClientImpl billingClientImpl, WeakReference weakReference, LaunchExternalLinkResponseListener launchExternalLinkResponseListener, zzcm zzcmVar) {
        Objects.requireNonNull(billingClientImpl);
        this.zzc = billingClientImpl;
        this.zza = weakReference;
        this.zzb = BillingClientImpl.zzg(billingClientImpl, launchExternalLinkResponseListener);
    }

    @Override // com.google.android.gms.internal.play_billing.zzai
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Response bundle is null.");
            this.zzc.zzbE(zzjs.NULL_BUNDLE_RETURNED_BY_PHONESKY, 37, zzdh.zzh);
            this.zzb.send(6, null);
            return;
        }
        if (!bundle.containsKey("RESPONSE_CODE")) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Response bundle doesn't contain a response code.");
            this.zzc.zzbE(zzjs.MISSING_RESPONSE_CODE_IN_PHONESKY_BUNDLE, 37, zzdh.zzh);
            this.zzb.send(6, bundle);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", zza.zza(iZzb, "Unable to launch intent for launch external link dialog. Response code: "));
            this.zzb.send(iZzb, bundle);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("EXTERNAL_PAYMENT_DIALOG_INTENT");
        if (pendingIntent == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Pending intent not found in response bundle.");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("RESPONSE_CODE", 6);
            bundle2.putString("DEBUG_MESSAGE", "An internal error occurred.");
            this.zzb.send(6, bundle);
            return;
        }
        try {
            Activity activity = (Activity) this.zza.get();
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivityV2.class);
            intent.putExtra("launch_external_link_result_receiver", this.zzb);
            intent.putExtra("launch_external_link_flow_pending_intent", pendingIntent);
            activity.startActivity(intent);
        } catch (RuntimeException e) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Runtime error while launching intent for launch external link dialog.", e);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("RESPONSE_CODE", 6);
            bundle3.putString("DEBUG_MESSAGE", "An internal error occurred.");
            bundle3.putInt("INTERNAL_LOG_ERROR_REASON", zzjs.RUNTIME_EXCEPTION_ON_LAUNCH_EXTERNAL_LINK_INTENT.zza());
            bundle3.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", String.format("%s: %s", e.getClass().getName(), com.google.android.gms.internal.play_billing.zzbo.zzc(e.getMessage())));
            this.zzb.send(6, bundle3);
        }
    }
}
