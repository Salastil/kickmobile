package expo.modules.kickiap;

import android.content.Context;
import android.util.Log;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BillingClientManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lexpo/modules/kickiap/BillingClientManager;", "", "<init>", "()V", "value", "Lcom/android/billingclient/api/BillingClient;", "billingClient", "getBillingClient", "()Lcom/android/billingclient/api/BillingClient;", "initBillingClient", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "kick-iap_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BillingClientManager {
    public static final BillingClientManager INSTANCE = new BillingClientManager();
    private static BillingClient billingClient;

    private BillingClientManager() {
    }

    public final BillingClient getBillingClient() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 != null) {
            return billingClient2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("billingClient");
        return null;
    }

    public final void initBillingClient(final Context context, final PurchasesUpdatedListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        PendingPurchasesParams pendingPurchasesParamsBuild = PendingPurchasesParams.newBuilder().enableOneTimeProducts().build();
        Intrinsics.checkNotNullExpressionValue(pendingPurchasesParamsBuild, "build(...)");
        BillingClient billingClientBuild = BillingClient.newBuilder(context).enablePendingPurchases(pendingPurchasesParamsBuild).setListener(listener).build();
        Intrinsics.checkNotNullExpressionValue(billingClientBuild, "build(...)");
        billingClient = billingClientBuild;
        try {
            if (getBillingClient().isReady()) {
                Log.d("KickIAP", "Billing Client is already initialized");
            } else {
                getBillingClient().startConnection(new BillingClientStateListener() { // from class: expo.modules.kickiap.BillingClientManager.initBillingClient.1
                    @Override // com.android.billingclient.api.BillingClientStateListener
                    public void onBillingSetupFinished(BillingResult billingResult) {
                        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                        if (billingResult.getResponseCode() == 0) {
                            Log.d("KickIAP", "Billing Client is ready");
                            return;
                        }
                        Log.e("KickIAP", "Billing Client setup failed: " + billingResult.getDebugMessage());
                    }

                    @Override // com.android.billingclient.api.BillingClientStateListener
                    public void onBillingServiceDisconnected() {
                        Log.e("KickIAP", "Billing Service Disconnected");
                        BillingClientManager.INSTANCE.initBillingClient(context, listener);
                    }
                });
            }
        } catch (IllegalStateException e) {
            Log.e("KickIAP", "Error initializing Billing Client: " + e.getMessage());
        }
    }
}
