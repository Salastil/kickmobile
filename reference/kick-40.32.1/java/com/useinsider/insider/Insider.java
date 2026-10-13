package com.useinsider.insider;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import com.android.billingclient.api.BillingClient;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.RemoteMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class Insider {
    public static final Insider Instance = new Insider();
    private static final List<InsiderEvent> deferredCustomEvents = new ArrayList();
    private InsiderCallback insiderCallback;
    private l0 insiderCore;
    private boolean lifecycleRegistered;
    private boolean isSDKInitialized = false;
    private boolean isCoreInited = false;
    private final List<Runnable> deferredActions = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements OnCompleteListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReviewManager f285a;

        /* JADX INFO: renamed from: com.useinsider.insider.Insider$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
        class C0152a implements OnCompleteListener {
            C0152a() {
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task task) {
                Debugger.a(DebuggingTag.showNativeRatingFlowSuccess, 4);
            }
        }

        a(ReviewManager reviewManager) {
            this.f285a = reviewManager;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(Task task) {
            l0 l0Var = Insider.this.insiderCore;
            if (l0Var == null) {
                return;
            }
            try {
                if (!task.isSuccessful()) {
                    Debugger.a(DebuggingTag.showNativeRatingFail, 4);
                    return;
                }
                Activity activityN = l0Var.n();
                if (activityN != null && !activityN.isFinishing() && !activityN.isDestroyed()) {
                    Debugger.a(DebuggingTag.showNativeRatingSuccess, 4);
                    this.f285a.launchReviewFlow(activityN, (ReviewInfo) task.getResult()).addOnCompleteListener(new C0152a());
                    return;
                }
                l0Var.a(new Exception("No usable activity available for showNativeRating callback"));
            } catch (Exception e) {
                l0Var.a(e);
            }
        }
    }

    private Insider() {
    }

    private void initMethod(Application application, String str) {
        try {
            if (!w4.i(str)) {
                Debugger.putLog(DebuggingTag.initInvalidPartnerName, 5, str);
                f3.c("common", "Partner name is not valid.", "{ 'status': 'failed', 'reason': 'invalid_partner_name', 'partner_name': '" + str + "' }", "InsiderCore-initMethod");
                return;
            }
            if (this.insiderCore == null) {
                e.b = str;
                e.f = application.getPackageName();
                initialize(application);
                this.isSDKInitialized = true;
            }
            HashMap map = new HashMap();
            map.put("application", application != null ? application.getClass().getSimpleName() : null);
            map.put("partner_name", str);
            Debugger.a(DebuggingTag.init, 4, map);
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    private void initialize(Application application) {
        try {
            this.lifecycleRegistered = false;
            this.insiderCore = new l0(application.getApplicationContext());
            if (!e.d.equals("cordova")) {
                c0 c0Var = new c0(this.insiderCore);
                application.registerComponentCallbacks(c0Var);
                application.registerActivityLifecycleCallbacks(c0Var);
                this.lifecycleRegistered = true;
            }
            f3.e = application.getApplicationContext();
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    private String productNamesJoin(String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    for (String str : strArr) {
                        if (!String.valueOf(str).equals("")) {
                            sb.append(str);
                            sb.append(WebViewLogEventConsumer.DDTAGS_SEPARATOR);
                            i++;
                        }
                        if (i == 3) {
                            break;
                        }
                    }
                    if (sb.length() > 0) {
                        return sb.deleteCharAt(sb.length() - 1).toString();
                    }
                }
            } catch (Exception e) {
                putException(e);
            }
        }
        return "";
    }

    private void replayDeferredActions() {
        Iterator<Runnable> it = this.deferredActions.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.deferredActions.clear();
    }

    private void replayDeferredCustomEvents() {
        Iterator<InsiderEvent> it = deferredCustomEvents.iterator();
        while (it.hasNext()) {
            this.insiderCore.a(it.next());
        }
        deferredCustomEvents.clear();
    }

    public InsiderAppCards appCards() {
        try {
            return !shouldProceed() ? new InsiderAppCards() : this.insiderCore.a();
        } catch (Exception e) {
            this.insiderCore.a(e);
            return new InsiderAppCards();
        }
    }

    void buildEvent(InsiderEvent insiderEvent) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(insiderEvent);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void cartCleared() {
        cartCleared(null);
    }

    public void clearCustomWebView() {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(true, (q) null);
            }
        } catch (Exception e) {
            Instance.putException(e);
        }
    }

    public void clickSmartRecommendationProduct(int i, InsiderProduct insiderProduct) {
        try {
            if (shouldProceed() && insiderProduct != null && insiderProduct.isProductValid() && i != 0) {
                this.insiderCore.a(i, insiderProduct);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void completeDeferredInit(Activity activity) {
        l0 l0Var;
        try {
            if (shouldProceed() && (l0Var = this.insiderCore) != null && !this.isCoreInited) {
                l0Var.r = true;
                l0Var.d(activity);
                this.insiderCore.I();
                this.isCoreInited = true;
                replayDeferredCustomEvents();
                replayDeferredActions();
                this.insiderCore.r = false;
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public InsiderProduct createNewProduct(String str, String str2, String[] strArr, String str3, double d, String str4) {
        if (shouldProceed()) {
            return this.insiderCore.a(str, str2, strArr, str3, d, str4);
        }
        return !isSDKInitialized() ? new InsiderProduct(str, str2, strArr, str3, d, str4, true) : new InsiderProduct("", "", new String[0], "", 0.0d, "", false);
    }

    public void disableInAppMessages() {
        try {
            e.z = false;
            f3.b(BillingClient.ProductType.INAPP, "Inapp display disabled for the current session.", new JSONObject().put("isDisplayInapp", e.z), "Inapp-disableInappDisplay");
            this.insiderCore.D();
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void enableCarrierCollection(boolean z) {
        if (shouldProceed()) {
            try {
                this.insiderCore.b(z);
            } catch (Exception e) {
                this.insiderCore.a(e);
            }
        }
    }

    public void enableInAppMessages() {
        try {
            e.z = true;
            f3.b(BillingClient.ProductType.INAPP, "Inapp display enabled for the current session.", new JSONObject().put("isDisplayInapp", e.z), "Inapp-enableInappDisplay");
            Debugger.a(DebuggingTag.enableInAppMessages, 4);
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void enableIpCollection(boolean z) {
        if (shouldProceed()) {
            try {
                this.insiderCore.c(z);
            } catch (Exception e) {
                this.insiderCore.a(e);
            }
        }
    }

    public void enableLocationCollection(boolean z) {
        if (shouldProceed()) {
            try {
                this.insiderCore.d(z);
            } catch (Exception e) {
                this.insiderCore.a(e);
            }
        }
    }

    void flushData() {
        try {
            if (shouldProceed()) {
                this.insiderCore.b(p4.SESSION_STOP_REQUEST_REASON_FLUSH, (x4) null);
            }
        } catch (Exception e) {
            putException(e);
        }
    }

    public boolean getCarrierStatus() {
        return e.m;
    }

    public boolean getContentBoolWithName(String str, boolean z, ContentOptimizerDataType contentOptimizerDataType) {
        if (str != null && contentOptimizerDataType != null) {
            try {
                if (shouldProceed()) {
                    return m0.f().c().a(str, z, contentOptimizerDataType);
                }
            } catch (Exception e) {
                this.insiderCore.a(e);
            }
        }
        return z;
    }

    public boolean getContentBoolWithoutCache(String str, boolean z, ContentOptimizerDataType contentOptimizerDataType) {
        if (str != null && contentOptimizerDataType != null) {
            try {
                if (shouldProceed()) {
                    return m0.f().c().b(str, z, contentOptimizerDataType);
                }
            } catch (Exception e) {
                this.insiderCore.a(e);
            }
        }
        return z;
    }

    public int getContentIntWithName(String str, int i, ContentOptimizerDataType contentOptimizerDataType) {
        if (str != null && contentOptimizerDataType != null) {
            try {
                if (shouldProceed()) {
                    return m0.f().c().a(str, i, contentOptimizerDataType);
                }
            } catch (Exception e) {
                this.insiderCore.a(e);
            }
        }
        return i;
    }

    public int getContentIntWithoutCache(String str, int i, ContentOptimizerDataType contentOptimizerDataType) {
        if (str != null && contentOptimizerDataType != null) {
            try {
                if (shouldProceed()) {
                    return m0.f().c().b(str, i, contentOptimizerDataType);
                }
            } catch (Exception e) {
                this.insiderCore.a(e);
            }
        }
        return i;
    }

    public String getContentStringWithName(String str, String str2, ContentOptimizerDataType contentOptimizerDataType) {
        if ((str != null && contentOptimizerDataType != null) || str2 == null) {
            if ((str == null || contentOptimizerDataType == null) && str2 == null) {
                return "";
            }
            try {
                if (shouldProceed()) {
                    return m0.f().c().a(str, str2, contentOptimizerDataType);
                }
            } catch (Exception e) {
                this.insiderCore.a(e);
                return str2;
            }
        }
        return str2;
    }

    public String getContentStringWithoutCache(String str, String str2, ContentOptimizerDataType contentOptimizerDataType) {
        if ((str != null && contentOptimizerDataType != null) || str2 == null) {
            if ((str == null || contentOptimizerDataType == null) && str2 == null) {
                return "";
            }
            try {
                if (shouldProceed()) {
                    return m0.f().c().b(str, str2, contentOptimizerDataType);
                }
            } catch (Exception e) {
                this.insiderCore.a(e);
                return str2;
            }
        }
        return str2;
    }

    Activity getCurrentActivity() {
        l0 l0Var = this.insiderCore;
        if (l0Var == null) {
            return null;
        }
        return l0Var.n();
    }

    public String getCurrentProvider(Context context) {
        String strB = "";
        try {
            strB = w4.e(context).b();
            Debugger.putLog(DebuggingTag.getCurrentProvider, 4, strB);
            return strB;
        } catch (Exception e) {
            this.insiderCore.a(e);
            return strB;
        }
    }

    public InsiderUser getCurrentUser() {
        l0 l0Var = this.insiderCore;
        return (l0Var == null || l0Var.z()) ? new InsiderUser() : this.insiderCore.o();
    }

    public String getInsiderID() {
        try {
            if (shouldProceed()) {
                return this.insiderCore.q();
            }
            return null;
        } catch (Exception e) {
            this.insiderCore.a(e);
            return null;
        }
    }

    public void getMessageCenterData(int i, Date date, Date date2, MessageCenterData messageCenterData) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(date, date2, i, (InsiderIdentifiers) null, messageCenterData);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void getSmartRecommendation(int i, String str, String str2, RecommendationEngine.SmartRecommendation smartRecommendation) {
        try {
            if (shouldProceed()) {
                HashMap map = new HashMap();
                map.put("recommendation_id", Integer.valueOf(i));
                map.put(Constants.LOCALE, str != null ? str : "");
                map.put(FirebaseAnalytics.Param.CURRENCY, str2 != null ? str2 : "");
                if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
                    Debugger.a(DebuggingTag.getSmartRecommendation, 4, map);
                    this.insiderCore.a(i, str, (InsiderProduct) null, str2, smartRecommendation);
                    return;
                }
                Debugger.a(DebuggingTag.getSmartRecommendationWarning, 4, map);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    String getSmartRecommendationEndpointsFromCache() {
        try {
            return this.insiderCore.t();
        } catch (Exception e) {
            this.insiderCore.a(e);
            return null;
        }
    }

    public void getSmartRecommendationWithProduct(InsiderProduct insiderProduct, int i, String str, RecommendationEngine.SmartRecommendation smartRecommendation) {
        try {
            if (shouldProceed()) {
                HashMap map = new HashMap();
                map.put("recommendation_id", Integer.valueOf(i));
                map.put(Constants.LOCALE, str != null ? str : "");
                map.put("product", insiderProduct != null ? insiderProduct : AbstractJsonLexerKt.NULL);
                if (insiderProduct != null && str != null && !str.isEmpty() && insiderProduct.isProductValid()) {
                    Debugger.a(DebuggingTag.getSmartRecommendationWithProduct, 4, map);
                    this.insiderCore.a(i, str, insiderProduct, insiderProduct.getCurrency(), smartRecommendation);
                    return;
                }
                Debugger.a(DebuggingTag.getSmartRecommendationWithProductWarning, 4, map);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void getSmartRecommendationWithProductIDs(String[] strArr, int i, String str, String str2, RecommendationEngine.SmartRecommendation smartRecommendation) {
        try {
            if (shouldProceed()) {
                String[] strArr2 = new String[0];
                String strProductNamesJoin = productNamesJoin(strArr);
                HashMap map = new HashMap();
                map.put("recommendation_id", Integer.valueOf(i));
                map.put(Constants.LOCALE, str);
                map.put("joined_product_ids", strProductNamesJoin);
                if (str != null && str.length() != 0 && strArr != null && strArr.length != 0 && strProductNamesJoin.length() != 0) {
                    InsiderProduct insiderProduct = new InsiderProduct(strProductNamesJoin, "", strArr2, "", 0.0d, "", true);
                    Debugger.a(DebuggingTag.getSmartRecommendationWithProductID, 4, map);
                    insiderProduct.setCurrency(str2);
                    this.insiderCore.a(i, str, insiderProduct, str2, smartRecommendation);
                    return;
                }
                Debugger.a(DebuggingTag.getSmartRecommendationWithProductIDWarning, 4, map);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void handleFCMNotification(Context context, RemoteMessage remoteMessage) {
        try {
            Map<String, String> data = remoteMessage.getData();
            if (shouldProceed()) {
                m0.f().k().a((Map) data);
            }
            w4.a(context, remoteMessage, false);
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void handleOpenLog(RemoteMessage remoteMessage) {
        try {
            if (shouldProceed() && remoteMessage != null) {
                w4.d(remoteMessage.getData());
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void handleUniversalLink(Intent intent) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(intent);
            } else {
                l0.C = intent;
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void init(Application application, String str) {
        try {
            initMethod(application, str);
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public boolean isSDKInitialized() {
        return this.isSDKInitialized;
    }

    public boolean isSdkFrozen() {
        l0 l0Var = this.insiderCore;
        return l0Var != null && l0Var.z();
    }

    public void itemAddedToCart(InsiderProduct insiderProduct) {
        itemAddedToCart(insiderProduct, null);
    }

    public void itemAddedToWishlist(InsiderProduct insiderProduct) {
        itemAddedToWishlist(insiderProduct, null);
    }

    public void itemPurchased(String str, InsiderProduct insiderProduct) {
        itemPurchased(str, insiderProduct, null);
    }

    public void itemRemovedFromCart(String str) {
        itemRemovedFromCart(str, (Map<String, ?>) null);
    }

    public void itemRemovedFromWishlist(String str) {
        itemRemovedFromWishlist(str, null);
    }

    /* JADX INFO: renamed from: lambda$cartCleared$4$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11813lambda$cartCleared$4$comuseinsiderinsiderInsider(Map map) {
        this.insiderCore.a(map);
    }

    /* JADX INFO: renamed from: lambda$itemAddedToCart$1$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11814lambda$itemAddedToCart$1$comuseinsiderinsiderInsider(InsiderProduct insiderProduct, Map map) {
        this.insiderCore.a(insiderProduct, map);
    }

    /* JADX INFO: renamed from: lambda$itemAddedToWishlist$5$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11815lambda$itemAddedToWishlist$5$comuseinsiderinsiderInsider(InsiderProduct insiderProduct, Map map) {
        this.insiderCore.b(insiderProduct, map);
    }

    /* JADX INFO: renamed from: lambda$itemPurchased$0$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11816lambda$itemPurchased$0$comuseinsiderinsiderInsider(String str, InsiderProduct insiderProduct, Map map) {
        this.insiderCore.a(str, insiderProduct, map);
    }

    /* JADX INFO: renamed from: lambda$itemRemovedFromCart$2$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11817lambda$itemRemovedFromCart$2$comuseinsiderinsiderInsider(String str, Map map) {
        this.insiderCore.a(str, map);
    }

    /* JADX INFO: renamed from: lambda$itemRemovedFromCart$3$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11818lambda$itemRemovedFromCart$3$comuseinsiderinsiderInsider(String str, String str2, Map map) {
        this.insiderCore.a(str, str2, map);
    }

    /* JADX INFO: renamed from: lambda$itemRemovedFromWishlist$6$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11819lambda$itemRemovedFromWishlist$6$comuseinsiderinsiderInsider(String str, Map map) {
        this.insiderCore.b(str, map);
    }

    /* JADX INFO: renamed from: lambda$signUpConfirmation$14$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11820lambda$signUpConfirmation$14$comuseinsiderinsiderInsider(Map map) {
        this.insiderCore.c(map);
    }

    /* JADX INFO: renamed from: lambda$visitCartPage$11$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11821lambda$visitCartPage$11$comuseinsiderinsiderInsider(InsiderProduct[] insiderProductArr, Map map) {
        this.insiderCore.a(insiderProductArr, map);
    }

    /* JADX INFO: renamed from: lambda$visitCartPage$12$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11822lambda$visitCartPage$12$comuseinsiderinsiderInsider(InsiderProduct[] insiderProductArr, String str, Map map) {
        this.insiderCore.a(insiderProductArr, str, map);
    }

    /* JADX INFO: renamed from: lambda$visitHomePage$8$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11823lambda$visitHomePage$8$comuseinsiderinsiderInsider() {
        this.insiderCore.X();
    }

    /* JADX INFO: renamed from: lambda$visitListingPage$9$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11824lambda$visitListingPage$9$comuseinsiderinsiderInsider(String[] strArr, Map map) {
        this.insiderCore.a(strArr, map);
    }

    /* JADX INFO: renamed from: lambda$visitProductDetailPage$10$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11825lambda$visitProductDetailPage$10$comuseinsiderinsiderInsider(InsiderProduct insiderProduct, Map map) {
        this.insiderCore.c(insiderProduct, map);
    }

    /* JADX INFO: renamed from: lambda$visitWishlistPage$13$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11826lambda$visitWishlistPage$13$comuseinsiderinsiderInsider(InsiderProduct[] insiderProductArr, Map map) {
        this.insiderCore.b(insiderProductArr, map);
    }

    /* JADX INFO: renamed from: lambda$wishlistCleared$7$com-useinsider-insider-Insider, reason: not valid java name */
    /* synthetic */ void m11827lambda$wishlistCleared$7$comuseinsiderinsiderInsider(Map map) {
        this.insiderCore.e(map);
    }

    void logAppCard(String str, w wVar) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(str, wVar);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    void logBlockedInapp(int i, int i2) {
        try {
            this.insiderCore.a(i, i2);
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    void logInapp(o oVar) {
        try {
            if (shouldProceed()) {
                this.insiderCore.b(oVar);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    void performInsiderCallback(JSONObject jSONObject, InsiderCallbackType insiderCallbackType) {
        InsiderCallback insiderCallback;
        try {
            if (!shouldProceed() || (insiderCallback = this.insiderCallback) == null) {
                Debugger.a(DebuggingTag.insiderCallbackNotDefined, 4);
                return;
            }
            insiderCallback.doAction(jSONObject, insiderCallbackType);
            HashMap map = new HashMap();
            map.put("name", insiderCallbackType.name());
            map.put("data", jSONObject);
            Debugger.a(DebuggingTag.insiderCallbackTriggered, 4, map);
        } catch (Exception e) {
            putException(e);
        }
    }

    void postStartRequest(o4 o4Var) {
        try {
            if (shouldProceed()) {
                this.insiderCore.c(o4Var);
            }
        } catch (Exception e) {
            putException(e);
        }
    }

    public synchronized void putException(Exception exc) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(exc);
            } else {
                Log.v("[INSIDER]", exc.getMessage());
            }
        } catch (Throwable unused) {
        }
    }

    void putInteractiveLog(Intent intent, String... strArr) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(intent, strArr);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    void putPushLog(Map<String, Integer> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.b(map);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    void putRecommendationLog(ConcurrentHashMap<String, Object> concurrentHashMap) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a((ConcurrentHashMap) concurrentHashMap);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void registerInsiderCallback(InsiderCallback insiderCallback) {
        try {
            this.insiderCallback = insiderCallback;
            Debugger.a(DebuggingTag.registerInsiderCallback, 4);
        } catch (Exception e) {
            putException(e);
        }
    }

    public void registerInsiderIDListener(InsiderIDListener insiderIDListener) {
        try {
            if (shouldProceed()) {
                e3.a(insiderIDListener);
            }
        } catch (Exception e) {
            Instance.putException(e);
        }
    }

    public void reinitWithPartnerName(String str) {
        try {
            l0 l0Var = this.insiderCore;
            if (l0Var != null && !l0Var.z()) {
                if (!this.isSDKInitialized) {
                    Debugger.putLog(DebuggingTag.reinitFailedBecauseFirstInitialization, 5, str);
                    f3.c("common", "Reinit failed. Make sure the Insider SDK is init.", "{ 'status': 'failed_first_initialization', 'partner_name': '" + str + "' }", "InsiderCore-reinitWithPartnerName");
                    return;
                }
                if (!this.insiderCore.y()) {
                    this.insiderCore.g(str);
                    Debugger.putLog(DebuggingTag.reinitCompletedWhenGDPRFalse, 5, str);
                    f3.c("common", "Reinit completed. However, session data is not sent because GDPR is false", "{ 'status': 'completed_gdpr_false', 'partner_name': '" + str + "' }", "InsiderCore-reinitWithPartnerName");
                    return;
                }
                if (!w4.i(str)) {
                    Debugger.putLog(DebuggingTag.initInvalidPartnerName, 5, str);
                    f3.c("common", "Partner name is not valid.", "{ 'status': 'failed_invalid_partner', 'partner_name': '" + str + "' }", "InsiderCore-reinitWithPartnerName");
                    return;
                }
                if (!e.b.equals(str)) {
                    Debugger.putLog(DebuggingTag.reinitCalled, 4, str);
                    this.insiderCore.f(str);
                    return;
                }
                Debugger.putLog(DebuggingTag.reinitFailedBecauseOfSamePartnerName, 5, str);
                f3.c("common", "Reinit failed. Reinit with the same partner name.", "{ 'status': 'failed_same_partner', 'partner_name': '" + str + "' }", "InsiderCore-reinitWithPartnerName");
                return;
            }
            Debugger.putLog(DebuggingTag.reinitFailedBecauseOfSDKFrozen, 5, str);
            f3.c("common", "Reinit failed. Because of sdk frozen.", "{ 'status': 'failed_sdk_frozen', 'partner_name': '" + str + "' }", "InsiderCore-reinitWithPartnerName");
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void removeInapp(Activity activity) {
        boolean z;
        try {
            if (shouldProceed()) {
                if (this.insiderCore.n() != activity) {
                    Debugger.a(DebuggingTag.cleanViewError, 5);
                    f3.c(BillingClient.ProductType.INAPP, "View cleaning skipped due to activity mismatch.", String.format("{ 'status': 'failed', 'reason': 'activity_mismatch', 'expected_activity': '%s', 'provided_activity': '%s' }", this.insiderCore.n(), activity), "InsiderCore-removeInapp");
                    z = false;
                } else {
                    z = true;
                }
                this.insiderCore.a(z, (q) null);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    void removeInappSilently(Activity activity) {
        try {
            if (this.insiderCore.n() == activity) {
                this.insiderCore.F();
            } else {
                Debugger.a(DebuggingTag.cleanViewError, 5);
                f3.c(BillingClient.ProductType.INAPP, "Silent view cleaning skipped due to activity mismatch.", String.format("{ 'status': 'failed', 'reason': 'activity_mismatch', 'expected_activity': '%s', 'provided_activity': '%s' }", this.insiderCore.n(), activity), "InsiderCore-removeInappSilently");
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void resumeSessionHybridConfig(Activity activity) {
        try {
            l0 l0Var = this.insiderCore;
            if (l0Var == null) {
                return;
            }
            l0Var.d(activity);
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void resumeSessionHybridRequestConfig() {
        try {
            if (shouldProceed()) {
                this.insiderCore.I();
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    void sendSessionData(p4 p4Var, x4 x4Var) {
        try {
            if (shouldProceed()) {
                this.insiderCore.b(p4Var, x4Var);
            }
        } catch (Exception e) {
            putException(e);
        }
    }

    public void setCustomBoldFont(Typeface typeface) {
        try {
            if (shouldProceed() && typeface != null) {
                this.insiderCore.a(typeface);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void setCustomEndpoint(String str) {
        try {
            if (shouldProceed() && str == null) {
                return;
            }
            e.f325a = str;
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void setCustomItalicFont(Typeface typeface) {
        try {
            if (shouldProceed() && typeface != null) {
                this.insiderCore.b(typeface);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void setCustomRegularFont(Typeface typeface) {
        try {
            if (shouldProceed() && typeface != null) {
                this.insiderCore.c(typeface);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void setGDPRConsent(boolean z) {
        try {
            l0 l0Var = this.insiderCore;
            if (l0Var == null || l0Var.z()) {
                return;
            }
            this.insiderCore.f(z);
            this.insiderCore.J();
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    @Deprecated
    public void setHybridPushToken(String str) {
        setPushToken(str);
    }

    public void setHybridSDKVersion(String str) {
        if (str != null) {
            try {
                if (str.length() == 0) {
                    return;
                }
                e.e = str;
            } catch (Exception e) {
                this.insiderCore.a(e);
            }
        }
    }

    public void setInternalBrowserCloseButtonPosition(CloseButtonPosition closeButtonPosition) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(closeButtonPosition);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    void setLocationOptin(boolean z) {
        try {
            if (shouldProceed()) {
                this.insiderCore.g(z);
            }
        } catch (Exception e) {
            putException(e);
        }
    }

    public void setMobileAppAccess(boolean z) {
        try {
            l0 l0Var = this.insiderCore;
            if (l0Var == null || l0Var.z()) {
                return;
            }
            this.insiderCore.h(z);
            this.insiderCore.K();
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    void setPushOptin(boolean z) {
        try {
            if (shouldProceed()) {
                this.insiderCore.i(z);
            }
        } catch (Exception e) {
            putException(e);
        }
    }

    public void setPushToken(String str) {
        try {
            if (shouldProceed()) {
                this.insiderCore.d(str);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void setSDKType(String str) {
        try {
            if (shouldProceed()) {
                e.d = str;
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void setSplashActivity(Class cls) {
        e.c = cls;
    }

    boolean shouldProceed() {
        l0 l0Var = this.insiderCore;
        return (l0Var == null || l0Var.z() || !this.insiderCore.y()) ? false : true;
    }

    boolean shouldRetryIdentification() {
        try {
            if (shouldProceed()) {
                return this.insiderCore.Q();
            }
            return false;
        } catch (Exception e) {
            this.insiderCore.a(e);
            return false;
        }
    }

    public void showNativeRating() {
        l0 l0Var = this.insiderCore;
        if (l0Var == null) {
            return;
        }
        try {
            if (shouldProceed()) {
                Debugger.a(DebuggingTag.showNativeRating, 4);
                Activity activityN = l0Var.n();
                if (activityN != null && !activityN.isFinishing() && !activityN.isDestroyed()) {
                    ReviewManager reviewManagerCreate = ReviewManagerFactory.create(activityN.getApplicationContext());
                    reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new a(reviewManagerCreate));
                    return;
                }
                l0Var.a(new Exception("No usable activity available for showNativeRating"));
            }
        } catch (Exception e) {
            l0Var.a(e);
        }
    }

    public void signUpConfirmation() {
        try {
            signUpConfirmation(null);
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    void start(Activity activity) {
        try {
            if (shouldProceed() && !this.lifecycleRegistered) {
                this.insiderCore.g(activity);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    void startSeparationProcess(InsiderIdentifiers[] insiderIdentifiersArr, InsiderUser.InsiderIDResult insiderIDResult) {
        try {
            l0 l0Var = this.insiderCore;
            if (l0Var != null && !l0Var.z()) {
                this.insiderCore.a(insiderIdentifiersArr, insiderIDResult);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void startTrackingGeofence() {
        if (shouldProceed()) {
            try {
                e.j = true;
                if (e.i) {
                    this.insiderCore.w();
                }
            } catch (Exception e) {
                this.insiderCore.a(e);
            }
        }
    }

    void startUnificationProcessWithSessionProcess(InsiderIdentifiers insiderIdentifiers, InsiderUser.InsiderIDResult insiderIDResult) {
        try {
            l0 l0Var = this.insiderCore;
            if (l0Var != null && !l0Var.z()) {
                this.insiderCore.b(insiderIdentifiers, insiderIDResult);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    void stop(Activity activity) {
        try {
            if (shouldProceed() && !this.lifecycleRegistered) {
                this.insiderCore.a(activity, (q) null);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void storePartnerName(String str) {
        try {
            if (shouldProceed()) {
                this.insiderCore.e(str);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public InsiderEvent tagEvent(String str) {
        if (shouldProceed()) {
            return this.insiderCore.h(str);
        }
        if (this.isSDKInitialized) {
            return new InsiderEvent("");
        }
        InsiderEvent insiderEvent = new InsiderEvent(str);
        deferredCustomEvents.add(insiderEvent);
        return insiderEvent;
    }

    public void triggerPushProcessWithNotificationData(Context context, Map<String, String> map) {
        if (map != null) {
            try {
                if (w4.f(map)) {
                    HashMap map2 = new HashMap(map);
                    map2.put("received_at", String.valueOf(w4.b()));
                    if (this.insiderCore == null || m0.f().b().a()) {
                        w4.a(w4.a(context, map2), context, (InsiderActivity.a) null);
                        return;
                    }
                    if (this.insiderCore.y() && !this.insiderCore.z()) {
                        m0.f().k().a((Map) map2);
                        i3.b(w4.a(context, map2), this.insiderCore.n());
                        return;
                    }
                    f3.c("push", "Push trigger skipped.", "{ 'isGDPRCompliant': " + this.insiderCore.y() + ", 'isSdkFrozen': " + this.insiderCore.z() + " }", "Insider-triggerPushProcessWithNotificationData");
                }
            } catch (Exception e) {
                putException(e);
            }
        }
    }

    public void unregisterInsiderIDListener(InsiderIDListener insiderIDListener) {
        try {
            if (shouldProceed()) {
                e3.b(insiderIDListener);
            }
        } catch (Exception e) {
            Instance.putException(e);
        }
    }

    public void visitCartPage(InsiderProduct[] insiderProductArr) {
        visitCartPage(insiderProductArr, (Map<String, ?>) null);
    }

    public void visitHomePage() {
        visitHomePage(null);
    }

    public void visitListingPage(String[] strArr) {
        visitListingPage(strArr, null);
    }

    public void visitProductDetailPage(InsiderProduct insiderProduct) {
        visitProductDetailPage(insiderProduct, null);
    }

    public void visitWishlistPage(InsiderProduct[] insiderProductArr) {
        visitWishlistPage(insiderProductArr, null);
    }

    public void wishlistCleared() {
        wishlistCleared(null);
    }

    public void cartCleared(final Map<String, ?> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(map);
            } else {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11813lambda$cartCleared$4$comuseinsiderinsiderInsider(map);
                    }
                });
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void itemAddedToCart(final InsiderProduct insiderProduct, final Map<String, ?> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(insiderProduct, map);
            } else {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11814lambda$itemAddedToCart$1$comuseinsiderinsiderInsider(insiderProduct, map);
                    }
                });
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void itemAddedToWishlist(final InsiderProduct insiderProduct, final Map<String, ?> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.b(insiderProduct, map);
            } else {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11815lambda$itemAddedToWishlist$5$comuseinsiderinsiderInsider(insiderProduct, map);
                    }
                });
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void itemPurchased(final String str, final InsiderProduct insiderProduct, final Map<String, ?> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(str, insiderProduct, map);
            } else {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11816lambda$itemPurchased$0$comuseinsiderinsiderInsider(str, insiderProduct, map);
                    }
                });
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void itemRemovedFromCart(final String str, final Map<String, ?> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(str, map);
            } else {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11817lambda$itemRemovedFromCart$2$comuseinsiderinsiderInsider(str, map);
                    }
                });
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void itemRemovedFromWishlist(final String str, final Map<String, ?> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.b(str, map);
            } else {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11819lambda$itemRemovedFromWishlist$6$comuseinsiderinsiderInsider(str, map);
                    }
                });
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void visitCartPage(final InsiderProduct[] insiderProductArr, final Map<String, ?> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(insiderProductArr, map);
            } else {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11821lambda$visitCartPage$11$comuseinsiderinsiderInsider(insiderProductArr, map);
                    }
                });
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void visitHomePage(Map<String, ?> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.d(map);
            } else {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda14
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11823lambda$visitHomePage$8$comuseinsiderinsiderInsider();
                    }
                });
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void visitListingPage(final String[] strArr, final Map<String, ?> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.a(strArr, map);
            } else {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11824lambda$visitListingPage$9$comuseinsiderinsiderInsider(strArr, map);
                    }
                });
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void visitProductDetailPage(final InsiderProduct insiderProduct, final Map<String, ?> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.c(insiderProduct, map);
            } else {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11825lambda$visitProductDetailPage$10$comuseinsiderinsiderInsider(insiderProduct, map);
                    }
                });
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void visitWishlistPage(final InsiderProduct[] insiderProductArr, final Map<String, ?> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.b(insiderProductArr, map);
            } else {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11826lambda$visitWishlistPage$13$comuseinsiderinsiderInsider(insiderProductArr, map);
                    }
                });
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void wishlistCleared(final Map<String, ?> map) {
        try {
            if (shouldProceed()) {
                this.insiderCore.e(map);
            } else {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11827lambda$wishlistCleared$7$comuseinsiderinsiderInsider(map);
                    }
                });
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void signUpConfirmation(final Map<String, ?> map) {
        try {
            if (!shouldProceed()) {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11820lambda$signUpConfirmation$14$comuseinsiderinsiderInsider(map);
                    }
                });
                return;
            }
            this.insiderCore.c(map);
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void getMessageCenterData(int i, Date date, Date date2, InsiderIdentifiers insiderIdentifiers, MessageCenterData messageCenterData) {
        try {
            if (shouldProceed() && insiderIdentifiers != null && !insiderIdentifiers.getIdentifiers().isEmpty()) {
                this.insiderCore.a(date, date2, i, insiderIdentifiers, messageCenterData);
            }
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void itemRemovedFromCart(String str, String str2) {
        itemRemovedFromCart(str, str2, null);
    }

    public void visitCartPage(InsiderProduct[] insiderProductArr, String str) {
        visitCartPage(insiderProductArr, str, null);
    }

    public void itemRemovedFromCart(final String str, final String str2, final Map<String, ?> map) {
        try {
            if (!shouldProceed()) {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11818lambda$itemRemovedFromCart$3$comuseinsiderinsiderInsider(str, str2, map);
                    }
                });
                return;
            }
            this.insiderCore.a(str, str2, map);
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }

    public void visitCartPage(final InsiderProduct[] insiderProductArr, final String str, final Map<String, ?> map) {
        try {
            if (!shouldProceed()) {
                if (this.isSDKInitialized) {
                    return;
                }
                this.deferredActions.add(new Runnable() { // from class: com.useinsider.insider.Insider$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m11822lambda$visitCartPage$12$comuseinsiderinsiderInsider(insiderProductArr, str, map);
                    }
                });
                return;
            }
            this.insiderCore.a(insiderProductArr, str, map);
        } catch (Exception e) {
            this.insiderCore.a(e);
        }
    }
}
