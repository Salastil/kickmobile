package com.useinsider.insider;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.android.billingclient.api.BillingClient;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.URLDecoder;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class o implements Animation.AnimationListener, k, View.OnClickListener {
    private boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private q f403a;
    private final ArrayList b;
    private final ArrayList c;
    private FrameLayout d;
    private FrameLayout e;
    private TextView f;
    private x3 g;
    private t h;
    private Activity i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private ViewGroup p;
    private boolean q;
    private Runnable r;
    private int[] s;
    private e t;
    private JSONArray u;
    private boolean v;
    private boolean w;
    private boolean x;
    private ViewTreeObserver.OnGlobalLayoutListener y;
    private View z;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class b implements x3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f405a;

        b(g gVar) {
            this.f405a = gVar;
        }

        @Override // com.useinsider.insider.x3.a
        public void a() {
            this.f405a.a();
        }

        @Override // com.useinsider.insider.x3.a
        public void b() {
            this.f405a.a(o.this.d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f406a;

        c(Object obj) {
            this.f406a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.a("event", this.f406a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f407a;

        static {
            int[] iArr = new int[f.values().length];
            f407a = iArr;
            try {
                iArr[f.Product.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f407a[f.DeviceAttributes.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f407a[f.ShakeDetect.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f408a;
        private JSONObject b;
        private final int c = 400;
        private int d = 0;
        private int e = 0;
        private int f = 0;
        private int g = 0;
        private boolean h = false;
        private o i;
        private String j;

        e a(JSONObject jSONObject) {
            this.b = jSONObject;
            return this;
        }

        e b(JSONObject jSONObject) {
            this.f408a = jSONObject;
            return this;
        }

        e c(int i) {
            this.e = i;
            return this;
        }

        e d(int i) {
            this.d = i;
            return this;
        }

        e a(int i) {
            this.g = i;
            return this;
        }

        e b(int i) {
            this.f = i;
            return this;
        }

        e a(String str) {
            this.j = str;
            return this;
        }

        o a() {
            o oVar = new o(this, null);
            this.i = oVar;
            return oVar;
        }

        e a(boolean z) {
            this.h = z;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    private enum f {
        Product(0),
        DeviceAttributes(1),
        KeyboardListener(2),
        ShakeDetect(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f409a;

        f(int i) {
            this.f409a = i;
        }

        public int b() {
            return this.f409a;
        }
    }

    /* synthetic */ o(e eVar, a aVar) {
        this(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        try {
            f3.b("web_view", "Shake detected", "{'inapp_id': '" + this.t.f + "', 'variant_id': '" + this.t.e + "'}", "Inapp-onShakeDetected");
            a(f.ShakeDetect);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void B() {
        try {
            if (!this.x && this.t.f > 0 && !com.useinsider.insider.e.v) {
                HashMap map = new HashMap();
                map.put("inapp_id", Integer.valueOf(this.t.f));
                map.put("variant_id", Integer.valueOf(this.t.e));
                map.put("dismiss_type", Integer.valueOf(this.m));
                Insider insider = Insider.Instance;
                insider.tagEvent("inapp_seen").addParameters(map).build();
                this.x = true;
                if (this.u.length() > 0) {
                    map.put("click_logs", this.u);
                    this.u = new JSONArray();
                }
                this.c.add(map);
                insider.logInapp(this);
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private JSONArray C() {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectA = w4.a("int", FirebaseAnalytics.Param.CAMPAIGN_ID, Integer.valueOf(this.t.f));
        JSONObject jSONObjectA2 = w4.a("int", "variant_id", Integer.valueOf(this.t.e));
        if (jSONObjectA.has("value")) {
            arrayList.add(jSONObjectA);
        }
        if (jSONObjectA2.has("value")) {
            arrayList.add(jSONObjectA2);
        }
        return new JSONArray((Collection) arrayList);
    }

    private void D() {
        try {
            FrameLayout frameLayout = new FrameLayout(this.i);
            this.d = frameLayout;
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            FrameLayout frameLayout2 = new FrameLayout(this.i);
            this.e = frameLayout2;
            frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f = new TextView(this.i);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388661;
            this.f.setLayoutParams(layoutParams);
            this.f.setIncludeFontPadding(false);
            int i = (int) (this.i.getResources().getDisplayMetrics().density * 5.0f);
            this.f.setPadding(i, i, i, i);
            this.e.addView(this.f);
            this.d.addView(this.e);
            StringBuilder sb = new StringBuilder("{'inapp_id': '");
            sb.append(this.t.f);
            sb.append("', 'variant_id': '");
            sb.append(this.t.e);
            sb.append("', 'is_null_inflated_layout': '");
            sb.append(String.valueOf(this.d == null));
            sb.append("' }");
            f3.b("web_view", "Inflated layout created.", sb.toString(), "Inapp-setInflatedLayout");
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        try {
            if (this.d == null) {
                f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.INFLATED_LAYOUT_NOT_SUITABLE.b(), new JSONObject().put("inapp_id", this.t.f).put("variant_id", this.t.e).put(ViewProps.WIDTH, this.d.getWidth()).put(ViewProps.HEIGHT, this.d.getHeight()), "Inapp-startInapp");
                return;
            }
            if (!com.useinsider.insider.e.z) {
                f3.b(BillingClient.ProductType.INAPP, "Inapp blocked in startInapp", new JSONObject().put("ignore_inapp_blocking", this.A).put("inapp_id", this.t.f).put("variant_id", this.t.e).toString(), "Inapp-startInapp");
                if (!this.A) {
                    Insider.Instance.logBlockedInapp(this.t.f, this.t.e);
                    return;
                }
            }
            this.q = true;
            a(R.anim.ins_anim_xcv_fadein, 0);
            f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.TEMPLATE_ADDED_TO_DECORVIEW_SUCCESSFULLY.b(), new JSONObject().put("inapp_id", this.t.f).put("variant_id", this.t.e).put(ViewProps.WIDTH, this.d.getWidth()).put(ViewProps.HEIGHT, this.d.getHeight()), "Inapp-startInapp");
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void j() {
        ViewGroup viewGroup;
        Runnable runnable;
        try {
            ViewGroup viewGroup2 = this.p;
            if (viewGroup2 != null && (runnable = this.r) != null) {
                viewGroup2.removeCallbacks(runnable);
                this.r = null;
            }
            FrameLayout frameLayout = this.d;
            if (frameLayout != null && (viewGroup = this.p) != null) {
                viewGroup.removeView(frameLayout);
                x3 x3Var = this.g;
                if (x3Var != null) {
                    x3Var.destroy();
                }
                f3.b("web_view", "Webview has been removed from superview.", "{'inapp_id': '" + this.t.f + "', 'variant_id': '" + this.t.e + "' }", "Inapp-destroyObjects");
            }
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.p = null;
            Activity activity = this.i;
            if (activity != null && activity.getLocalClassName().contains(com.useinsider.insider.f.g)) {
                this.i.finish();
                this.i.overridePendingTransition(0, 0);
            }
            this.i = null;
            View view = this.z;
            if (view != null && this.y != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.y);
                this.y = null;
                f3.b("web_view", "Keyboard layout listener is de-initialized.", "{}", "Inapp-destroyObjects");
            }
            f3.b("web_view", "Webview has been de-initialized.", "{'inapp_id': '" + this.t.f + "', 'variant_id': '" + this.t.e + "' }", "Inapp-destroyObjects");
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void k() {
        try {
            if (this.i != null) {
                q4.a().b(this.i);
                f3.b("web_view", "Shake detector destroyed", "{'inapp_id': '" + this.t.f + "', 'variant_id': '" + this.t.e + "'}", "Inapp-destroyShakeDetector");
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private FrameLayout.LayoutParams p() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        try {
            t.a aVarA = this.h.a();
            if (this.v) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                return layoutParams;
            }
            this.s = b(aVarA);
            a(layoutParams, aVarA);
            b(layoutParams, aVarA);
            int[] iArr = this.s;
            layoutParams.width = iArr[0];
            layoutParams.height = iArr[1];
            return layoutParams;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return layoutParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() {
        x3 x3Var;
        try {
            if (this.d != null && (x3Var = this.g) != null) {
                x3Var.evaluateJavascript("(function() {  if (typeof getActiveInputPosition !== 'function') return -1;  return getActiveInputPosition();})()", new ValueCallback() { // from class: com.useinsider.insider.o$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        this.f$0.a((String) obj);
                    }
                });
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        try {
            j();
            q qVar = this.f403a;
            if (qVar != null) {
                qVar.a();
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    void E() {
        try {
            this.q = false;
            p.f411a = false;
            j();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    void l() {
        try {
            d();
            this.q = false;
            B();
            p.f411a = false;
            j();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    public Activity m() {
        return this.i;
    }

    int n() {
        return this.t.g;
    }

    boolean o() {
        return this.A;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        try {
            if (this.q) {
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.useinsider.insider.o$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.z();
                }
            }, 100L);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (this.q) {
                this.m = 5;
                Insider.Instance.removeInapp(this.i);
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    int q() {
        return this.t.f;
    }

    public ArrayList r() {
        return this.c;
    }

    int s() {
        return this.o;
    }

    public ArrayList t() {
        ArrayList arrayList = new ArrayList();
        if (this.l > 0 && this.t.f != 0) {
            try {
                ArrayList arrayList2 = this.b;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    Map.Entry entry = (Map.Entry) obj;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("inapp_id", this.t.f);
                    jSONObject.put("variant_id", this.t.e);
                    jSONObject.put("question", entry.getKey());
                    jSONObject.put("answer", entry.getValue());
                    arrayList.add(jSONObject);
                }
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
            }
        }
        return arrayList;
    }

    int u() {
        return this.t.e;
    }

    boolean v() {
        return this.q;
    }

    boolean w() {
        return q() <= 0;
    }

    boolean x() {
        JSONObject jSONObject;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        try {
            e eVar = this.t;
            if (eVar == null || (jSONObject = eVar.b) == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("events")) == null || jSONArrayOptJSONArray.length() > 1 || !q2.EQUAL.b().equals(jSONObject.optString("relationship")) || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null) {
                return false;
            }
            return jSONObjectOptJSONObject.optString("name").equals("product_detail_page_view");
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    private o(e eVar) {
        this.b = new ArrayList();
        this.c = new ArrayList();
        boolean z = false;
        this.l = 0;
        this.m = 5;
        this.n = 0;
        this.o = 0;
        this.r = null;
        this.s = new int[]{0, 0, 0, 0};
        this.u = new JSONArray();
        this.v = false;
        this.w = false;
        this.x = false;
        this.A = false;
        try {
            this.t = eVar;
            this.A = eVar.h;
            this.h = new t(eVar.f408a);
            this.o = this.t.d * 1000;
            this.k = this.h.d("type");
            if (this.h.a("ignoreSafeZone") && this.h.b("ignoreSafeZone")) {
                z = true;
            }
            this.v = z;
            this.j = 400;
            this.u = new JSONArray();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void c(Activity activity) {
        try {
            q4 q4VarA = q4.a();
            q4VarA.a(new q4.a() { // from class: com.useinsider.insider.o$$ExternalSyntheticLambda4
                @Override // com.useinsider.insider.q4.a
                public final void a() {
                    this.f$0.A();
                }
            });
            q4VarA.a(activity);
            f3.b("web_view", "Shake detector initialized", "{'inapp_id': '" + this.t.f + "', 'variant_id': '" + this.t.e + "'}", "Inapp-initShakeDetector");
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(Activity activity) {
        Rect rect = new Rect();
        View viewFindViewById = activity.findViewById(android.R.id.content);
        viewFindViewById.getWindowVisibleDisplayFrame(rect);
        int bottom = viewFindViewById.getRootView().getBottom();
        return ((double) (bottom - rect.bottom)) > ((double) bottom) * 0.15d;
    }

    private void f() {
        String str;
        try {
            this.f.setOnClickListener(this);
            Typeface typefaceB = w4.b(this.i, "insider.ttf");
            float fC = (((this.s[2] * this.h.c("closeSize")) / 100.0f) * 5.0f) / 6.0f;
            if (typefaceB == null || fC == 0.0f) {
                return;
            }
            this.f.setTextSize(0, fC);
            this.f.setTypeface(typefaceB);
            if (this.h.a("closeColor")) {
                this.f.setTextColor(Color.parseColor(this.h.e("closeColor")));
            }
            if (this.h.a("closeStyle")) {
                String str2 = "\ue802";
                String strE = this.h.e("closeStyle");
                int iHashCode = strE.hashCode();
                if (iHashCode != 94070025) {
                    if (iHashCode == 206982315 && strE.equals("fa-times-circle-o")) {
                        str = "\ue800";
                        str2 = str;
                    }
                } else if (strE.equals("fa-times-circle")) {
                    str = "\ue801";
                    str2 = str;
                }
                this.f.setText(str2);
            }
            this.f.bringToFront();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void g() {
        try {
            if (d(this.h.a())) {
                a();
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    boolean b() {
        return !this.t.j.equals("event") && this.l > 0;
    }

    void e() {
        try {
            this.c.clear();
            this.b.clear();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    void h() {
        try {
            j();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    void i() {
        try {
            this.q = false;
            p.f411a = false;
            j();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    public void b(int i) {
        this.l = i;
    }

    private int b(View view) {
        try {
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
            if (rootWindowInsets != null) {
                return rootWindowInsets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
        ViewGroup viewGroup = this.p;
        if (viewGroup != null) {
            return w4.a((View) viewGroup);
        }
        return 0;
    }

    public void a(Activity activity, final boolean z) {
        try {
            final String str = "{'inapp_id': '" + this.t.f + "', 'variant_id': '" + this.t.e + "'}";
            f3.b("web_view", "Webview has been initialized.", str, "Inapp-show");
            this.x = false;
            if (this.k == -1) {
                this.m = 8;
                b(this.l + 1);
                l();
                f3.b("web_view", "Control group displayed.", str, "Inapp-show");
                return;
            }
            if (activity == null) {
                f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.CURRENT_ACTIVITY_NOT_SUITABLE.b(), new JSONObject().put("inapp_id", this.t.f).put("variant_id", this.t.e), "InsiderCore-show");
                return;
            }
            this.p = (ViewGroup) activity.getWindow().getDecorView();
            this.w = (activity.getWindow().getAttributes().flags & 1024) != 0;
            if (!c()) {
                f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.DECORVIEW_OR_INSIDER_LAYOUT_NOT_SUITABLE.b(), new JSONObject().put("inapp_id", this.t.f).put("variant_id", this.t.e), "InsiderCore-show");
                return;
            }
            if (b() && z) {
                f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.IMPRESSION_OR_INCREMENT_COUNT_IS_INCORRECT.b(), new JSONObject().put("inapp_id", this.t.f).put("variant_id", this.t.e), "InsiderCore-show");
                return;
            }
            this.i = activity;
            Runnable runnable = new Runnable() { // from class: com.useinsider.insider.o$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(z, str);
                }
            };
            this.r = runnable;
            this.p.postDelayed(runnable, 200L);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private boolean e(t.a aVar) {
        try {
            return aVar.h() == 100.0f && aVar.a() == 100.0f && aVar.b() == 0.0f && aVar.i() == 0.0f;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    private void d() {
        Activity activity;
        if (!this.v || this.w || (activity = this.i) == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(1024);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                insetsController.show(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
            }
        } else {
            window.getDecorView().setSystemUiVisibility(0);
        }
        if (i >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 0;
            window.setAttributes(attributes);
        }
        View viewFindViewById = window.getDecorView().findViewById(android.R.id.content);
        if (viewFindViewById != null) {
            viewFindViewById.requestLayout();
        }
    }

    private void b(FrameLayout.LayoutParams layoutParams, t.a aVar) {
        if (e(aVar)) {
            layoutParams.gravity = 48;
        }
        switch (aVar.e()) {
            case 0:
                layoutParams.gravity = 8388659;
                break;
            case 1:
                layoutParams.gravity = 49;
                break;
            case 2:
                layoutParams.gravity = 8388661;
                break;
            case 3:
                layoutParams.gravity = NavigationBarView.ITEM_GRAVITY_START_CENTER;
                break;
            case 4:
                layoutParams.gravity = 17;
                break;
            case 5:
                layoutParams.gravity = 8388629;
                break;
            case 6:
                layoutParams.gravity = 8388691;
                break;
            case 7:
                layoutParams.gravity = 81;
                break;
            case 8:
                layoutParams.gravity = 8388693;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        FrameLayout frameLayout;
        try {
            return this.p != null && ((frameLayout = this.d) == null || frameLayout.getParent() == null);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    private int c(t.a aVar) {
        try {
            if (aVar.g() != 0.0f) {
                return (int) a(aVar.g());
            }
            ViewGroup viewGroup = this.p;
            if (viewGroup != null) {
                return (int) (viewGroup.getHeight() * aVar.f());
            }
            return 0;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return 0;
        }
    }

    private boolean c(View view) {
        try {
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
            return rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime());
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f404a;
        final /* synthetic */ String b;

        a(boolean z, String str) {
            this.f404a = z;
            this.b = str;
        }

        @Override // com.useinsider.insider.g
        public void a(View view) {
            try {
                if (!o.this.c()) {
                    f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.DECORVIEW_OR_INSIDER_LAYOUT_NOT_SUITABLE_IN_CONTENT.b(), new JSONObject().put("inapp_id", o.this.t.f).put("variant_id", o.this.t.e), "Inapp-show");
                    return;
                }
                if (this.f404a) {
                    o oVar = o.this;
                    oVar.b(oVar.l + 1);
                }
                o.this.d.setVisibility(4);
                o.this.p.addView(view);
                f3.b("web_view", "Webview has been added to the superview.", this.b, "Inapp-show");
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }

        @Override // com.useinsider.insider.g
        public void a() {
            try {
                o oVar = o.this;
                if (oVar.d(oVar.i)) {
                    f3.b(BillingClient.ProductType.INAPP, com.useinsider.insider.b.KEYBOARD_IS_OPEN.b(), new JSONObject().put("inapp_id", o.this.t.f).put("variant_id", o.this.t.e).put("dismiss_type", 7), "Inapp-show");
                    o.this.m = 7;
                    o.this.l();
                    return;
                }
                if (!com.useinsider.insider.e.z) {
                    try {
                        f3.b(BillingClient.ProductType.INAPP, "Inapp blocked in invalidate", new JSONObject().put("ignore_inapp_blocking", o.this.A).put("inapp_id", o.this.t.f).put("variant_id", o.this.t.e).toString(), "Inapp-invalidate");
                    } catch (Exception unused) {
                        f3.b(BillingClient.ProductType.INAPP, "Inapp blocked in invalidate", "{}", "Inapp-invalidate");
                    }
                    if (!o.this.A) {
                        Insider.Instance.logBlockedInapp(o.this.t.f, o.this.t.e);
                        return;
                    }
                }
                if (o.this.v) {
                    Window window = o.this.i.getWindow();
                    window.setFlags(1024, 1024);
                    if (Build.VERSION.SDK_INT >= 28) {
                        WindowManager.LayoutParams attributes = window.getAttributes();
                        attributes.layoutInDisplayCutoutMode = 1;
                        window.setAttributes(attributes);
                    }
                }
                o.this.F();
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    private void c(int i) {
        int i2;
        try {
            Vibrator vibrator = (Vibrator) a5.a().getSystemService("vibrator");
            if (i == 0) {
                i2 = 15;
            } else if (i != 1) {
                i2 = i != 2 ? 0 : 45;
            } else {
                i2 = 30;
            }
            vibrator.vibrate(i2);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private boolean d(t.a aVar) {
        if (aVar == null) {
            return false;
        }
        try {
            int iE = aVar.e();
            return iE == 6 || iE == 7 || iE == 8 || iE == 3 || iE == 5 || iE == 4;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return false;
        }
    }

    private float b(String str) {
        try {
            return Float.parseFloat(str.replace("\"", ""));
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return -1.0f;
        }
    }

    public static int b(Activity activity) {
        try {
            if (activity == null) {
                return Resources.getSystem().getDisplayMetrics().heightPixels;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                return activity.getWindowManager().getCurrentWindowMetrics().getBounds().height();
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return Resources.getSystem().getDisplayMetrics().heightPixels;
        }
    }

    private int[] b(t.a aVar) {
        float fH;
        float fA;
        try {
            int width = this.p.getWidth();
            int height = this.p.getHeight();
            int iB = w4.b((View) this.p);
            int iA = w4.a((View) this.p);
            if (aVar.i() > 0.0f) {
                fH = a(aVar.i());
            } else {
                fH = (width * aVar.h()) / 100.0f;
            }
            int i = (int) fH;
            if (aVar.b() > 0.0f) {
                fA = a(aVar.b());
            } else {
                fA = ((height - (iB + iA)) * aVar.a()) / 100.0f;
            }
            int i2 = (int) fA;
            f3.b("web_view", "Webview screen calculations.", "{'screen_width': " + width + ",'screen_height': " + height + ",'web_view_width': " + i + ",'web_view_height': " + i2 + ",'status_bar_height': " + iB + ",'navigation_bar_height': " + iA + "}", "StaticUtils-getNavigationBarHeight");
            return new int[]{i, i2, width, height};
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return new int[]{0, 0, 0, 0};
        }
    }

    private void b(JSONObject jSONObject) {
        try {
            if (this.t.f == 0) {
                return;
            }
            jSONObject.put("timestamp", w4.b());
            this.u.put(jSONObject);
            Debugger.b(DebuggingTag.inappClickLog, 4, jSONObject);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, String str) {
        try {
            if (c()) {
                this.n = w4.a((View) this.p);
                D();
                FrameLayout.LayoutParams layoutParamsP = p();
                f();
                g();
                a(layoutParamsP, new a(z, str));
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void a(final int i, final int i2) {
        try {
            ((Executor) b5.b.a()).execute(new Runnable() { // from class: com.useinsider.insider.o$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(i2, i, this);
                }
            });
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, int i2, Animation.AnimationListener animationListener) {
        try {
            FrameLayout frameLayout = this.d;
            if (frameLayout != null) {
                frameLayout.setVisibility(i);
                Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.i, i2);
                animationLoadAnimation.setAnimationListener(animationListener);
                animationLoadAnimation.setDuration(this.j);
                this.d.setAnimation(animationLoadAnimation);
                animationLoadAnimation.start();
                f3.b("web_view", "Webview animation worked.", "{'inapp_id': '" + this.t.f + "', 'variant_id': '" + this.t.e + "' }", "Inapp-animCreator");
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void a(FrameLayout.LayoutParams layoutParams, g gVar) {
        try {
            this.d.setLayoutParams(layoutParams);
            if (this.v) {
                boolean zD = d(this.h.a());
                FrameLayout frameLayout = this.d;
                if (zD) {
                    this.d.setPadding(0, 0, 0, b(frameLayout));
                } else {
                    frameLayout.setPadding(0, 0, 0, 0);
                }
            }
            float fA = f5.a(this.s[2], this.e, this.h.e(ViewProps.BACKGROUND_COLOR), this.h.a(ViewProps.BORDER_RADIUS) ? this.h.c(ViewProps.BORDER_RADIUS) : 0.0f);
            this.g = new x3(this.i);
            this.e.addView(this.g, 0, new FrameLayout.LayoutParams(-1, -1));
            this.g.a(new b(gVar));
            float[] fArr = {fA, fA, fA, fA, fA, fA, fA, fA};
            JSONObject jSONObjectA = w4.a(Insider.Instance.getCurrentUser().getInsiderID(), w4.k(a5.a()), w4.d());
            String strE = this.h.e("template_url");
            this.g.a(fArr);
            this.g.getSettings().setTextZoom(100);
            this.g.a(strE, this, "{'inapp_id': '" + this.t.f + "' , 'variant_id': '" + this.t.e + "' , 'template_url': '" + strE + "' }", jSONObjectA);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    void a(int i) {
        try {
            this.m = i;
            a((q) null);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    void a(q qVar) {
        try {
            if (v()) {
                B();
            }
            d();
            k();
            this.q = false;
            this.f403a = qVar;
            a(R.anim.ins_anim_xcv_fadeout, 4);
            p.f411a = false;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void a(FrameLayout.LayoutParams layoutParams, t.a aVar) {
        try {
            if (this.v) {
                layoutParams.topMargin = 0;
                return;
            }
            ViewGroup viewGroup = this.p;
            if (viewGroup == null) {
                f3.b("web_view", "Decorview is null.", new JSONObject(), "Inapp-arrangeCustomScreenMargins");
                return;
            }
            int iB = w4.b((View) viewGroup);
            int iE = aVar.e();
            boolean z = true;
            boolean z2 = iE == 6 || iE == 7 || iE == 8;
            if (iE != 2 && iE != 5 && iE != 8) {
                z = false;
            }
            if (e(aVar)) {
                layoutParams.topMargin = iB;
                layoutParams.bottomMargin = 0;
                return;
            }
            if (z2) {
                layoutParams.bottomMargin = this.n + (-c(aVar));
            } else {
                layoutParams.topMargin = iB + c(aVar);
            }
            if (z) {
                layoutParams.rightMargin = -a(aVar);
            } else {
                layoutParams.leftMargin = a(aVar);
            }
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private int a(t.a aVar) {
        try {
            if (aVar.d() != 0.0f) {
                return (int) a(aVar.d());
            }
            ViewGroup viewGroup = this.p;
            if (viewGroup != null) {
                return (int) (viewGroup.getWidth() * aVar.c());
            }
            return 0;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return 0;
        }
    }

    private void a() {
        Activity activity = this.i;
        if (activity == null) {
            return;
        }
        View viewFindViewById = activity.findViewById(android.R.id.content);
        this.z = viewFindViewById;
        if (viewFindViewById == null) {
            return;
        }
        this.y = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.useinsider.insider.o$$ExternalSyntheticLambda3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.y();
            }
        };
        this.z.getViewTreeObserver().addOnGlobalLayoutListener(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        try {
            float fA = a(str, (View) this.g);
            int[] iArr = new int[2];
            this.g.getLocationOnScreen(iArr);
            int i = iArr[1];
            int height = i + this.g.getHeight();
            int i2 = (int) (i + fA);
            int iA = a(this.z);
            if (!a(this.z, this.g).booleanValue()) {
                this.d.setTranslationY(0.0f);
            } else if (i2 > iA) {
                this.d.setTranslationY(-(height - iA));
            }
            a(this.g, i, height, fA, i2, iA);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private float a(String str, View view) {
        if (view == null) {
            return -1.0f;
        }
        try {
            float fB = b(str);
            if (fB == -1.0f) {
                return view.getBottom() - this.n;
            }
            return a(fB);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return -1.0f;
        }
    }

    private int a(View view) {
        if (view == null) {
            return 0;
        }
        try {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
            if (rootWindowInsets != null) {
                Insets insetsIgnoringVisibility = rootWindowInsets.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars());
                int iB = (b(m()) - insetsIgnoringVisibility.top) - insetsIgnoringVisibility.bottom;
                int i = rect.bottom;
                if (i < iB) {
                    return i;
                }
                Insets insetsIgnoringVisibility2 = rootWindowInsets.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars());
                return iB - ((rootWindowInsets.getInsets(WindowInsetsCompat.Type.ime()).bottom - insetsIgnoringVisibility2.bottom) - insetsIgnoringVisibility2.top);
            }
            return rect.bottom;
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return 0;
        }
    }

    private Boolean a(View view, x3 x3Var) {
        try {
            return Boolean.valueOf(c(view) && !(u4.ADJUST_PAN.b().equals(a(m())) && !e(this.h.a()) && x3Var.hasFocus()));
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return Boolean.FALSE;
        }
    }

    private String a(Activity activity) {
        try {
            int i = activity.getWindow().getAttributes().softInputMode & 240;
            if (i == 16) {
                return u4.ADJUST_RESIZE.b();
            }
            if (i == 32) {
                return u4.ADJUST_PAN.b();
            }
            if (i != 48) {
                return u4.ADJUST_UNSPECIFIED.b();
            }
            return u4.ADJUST_NOTHING.b();
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
            return "";
        }
    }

    private void a(WebView webView, int i, int i2, float f2, int i3, int i4) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("web_view_width", webView.getWidth()).put("web_view_height", webView.getHeight()).put("input_y", f2).put("web_view_top_y", i).put("web_view_bottom_y", i2).put("absolute_input_y", i3).put("visible_screen_bottom", i4);
            Activity activity = this.i;
            if (activity != null && this.p != null) {
                DisplayMetrics displayMetrics = activity.getApplicationContext().getResources().getDisplayMetrics();
                jSONObjectPut.put("screen_width", displayMetrics.widthPixels).put("screen_height", displayMetrics.heightPixels).put("status_bar_height", w4.b((View) this.p)).put("navigation_bar_height", w4.a((View) this.p));
            }
            f3.b("web_view", "Webview screen calculations.", jSONObjectPut.toString(), "Inapp-logWebViewPosition");
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private float a(float f2) {
        Activity activity = this.i;
        if (activity != null && activity.getResources() != null) {
            try {
                return f2 * this.i.getResources().getDisplayMetrics().density;
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
            }
        }
        return 0.0f;
    }

    private void a(Map map) {
        try {
            JSONObject jSONObject = new JSONObject();
            InsiderCallbackType insiderCallbackType = InsiderCallbackType.INAPP_BUTTON_CLICK;
            jSONObject.put("type", insiderCallbackType.ordinal());
            jSONObject.put("data", new JSONObject(map));
            Insider.Instance.performInsiderCallback(jSONObject, insiderCallbackType);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    @Override // com.useinsider.insider.k
    public void a(int i, int i2, String str) {
        String string = "";
        try {
            if (v()) {
                f5.a(this.i);
            }
            if (com.useinsider.insider.e.z || this.A || v()) {
                f3.b("web_view", "Received data from WebView.", "{'dismiss_type': '" + i + "', 'action': '" + i2 + "', 'action_helper': '" + str + "', 'inapp_id': '" + this.t.f + "' , 'variant_id': '" + this.t.e + "'}", "Inapp-dismiss");
                this.m = i;
                boolean z = false;
                if (i2 == 9) {
                    JSONObject jSONObject = new JSONObject(URLDecoder.decode(str.replaceFirst("insiderurl://", ""), "UTF-8"));
                    Debugger.b(DebuggingTag.processTemplateStoreURL, 4, jSONObject);
                    Object obj = null;
                    while (jSONObject.keys().hasNext()) {
                        String next = jSONObject.keys().next();
                        if (next.equals("silent_dismiss")) {
                            Insider.Instance.removeInappSilently(this.i);
                            jSONObject.remove(next);
                        } else if (next.equals("redirection")) {
                            string = jSONObject.getString(next);
                            jSONObject.remove(next);
                        } else if (next.equals("dismiss")) {
                            this.m = jSONObject.getInt(next);
                            jSONObject.remove(next);
                            z = true;
                        } else if (next.equals("event")) {
                            obj = jSONObject.get(next);
                            jSONObject.remove(next);
                        } else if (next.equals("send_click_data")) {
                            b(jSONObject.getJSONObject(next));
                            jSONObject.remove(next);
                        } else {
                            a(next, jSONObject.get(next));
                            jSONObject.remove(next);
                        }
                    }
                    if (z) {
                        Insider.Instance.removeInapp(this.i);
                    }
                    if (obj != null) {
                        new Handler().postDelayed(new c(obj), 500L);
                    }
                    if (!string.isEmpty()) {
                        m0.f().n().a(this.i, string);
                    }
                } else {
                    if (i2 == 10) {
                        w4.a(this.i, ImagesContract.URL, Insider.Instance.tagEvent(str), false);
                        return;
                    }
                    if (i2 == 0) {
                        w4.l(this.i, str);
                    } else if (i2 == 1 || i2 == 2) {
                        m0.f().n().a(this.i);
                    } else if (i2 == 3) {
                        try {
                            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                            JSONObject jSONObject2 = new JSONObject(str);
                            Iterator<String> itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                String next2 = itKeys.next();
                                concurrentHashMap.put(next2, jSONObject2.getString(next2));
                            }
                            a(concurrentHashMap);
                        } catch (Exception unused) {
                            m0.f().n().a(this.i, str);
                        }
                    }
                }
                if (i2 != 9) {
                    Insider.Instance.removeInapp(this.i);
                }
            }
        } catch (Exception e2) {
            Insider insider = Insider.Instance;
            insider.removeInapp(this.i);
            insider.putException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:68:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:96:0x0234  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(String str, Object obj) {
        JSONArray jSONArray;
        String str2;
        int i;
        if (obj == null) {
            return;
        }
        try {
            String str3 = "key";
            switch (str.hashCode()) {
                case -2141672244:
                    if (str.equals("item_cart")) {
                        JSONArray jSONArray2 = (JSONArray) obj;
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            JSONObject jSONObject = (JSONObject) jSONArray2.get(i2);
                            String string = jSONObject.getString(FirebaseAnalytics.Param.PRODUCT_ID);
                            String string2 = jSONObject.getString(FirebaseAnalytics.Param.PRODUCT_NAME);
                            String[] strArrA = w4.a(jSONObject.getJSONArray("product_taxonomy"));
                            double d2 = jSONObject.getDouble("product_price");
                            String string3 = jSONObject.getString("product_currency");
                            String string4 = jSONObject.getString("product_image_url");
                            Insider insider = Insider.Instance;
                            insider.itemAddedToCart(insider.createNewProduct(string, string2, strArrA, string4, d2, string3));
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("cart_items", jSONArray2);
                        InsiderCallbackType insiderCallbackType = InsiderCallbackType.TEMP_STORE_ADDED_TO_CART;
                        jSONObject2.put("type", insiderCallbackType.ordinal());
                        jSONObject2.put("data", jSONObject3);
                        Insider.Instance.performInsiderCallback(jSONObject2, insiderCallbackType);
                        return;
                    }
                    return;
                case -2080788110:
                    if (str.equals("internalUrl")) {
                        m0.f().n().b(this.i, (String) obj);
                        return;
                    }
                    return;
                case -1671510034:
                    if (str.equals("init_shake_detector")) {
                        c(this.i);
                        return;
                    }
                    return;
                case -1349088399:
                    if (str.equals("custom")) {
                        JSONObject jSONObject4 = new JSONObject();
                        InsiderCallbackType insiderCallbackType2 = InsiderCallbackType.TEMP_STORE_CUSTOM_ACTION;
                        jSONObject4.put("type", insiderCallbackType2.ordinal());
                        jSONObject4.put("data", obj);
                        Insider.Instance.performInsiderCallback(jSONObject4, insiderCallbackType2);
                        return;
                    }
                    return;
                case -1153085020:
                    if (str.equals("externalUrl")) {
                        String str4 = (String) obj;
                        if (URLUtil.isValidUrl(str4)) {
                            m0.f().n().a(this.i, str4);
                            return;
                        }
                        Insider.Instance.putException(new Exception("Invalid URL: " + str4));
                        return;
                    }
                    return;
                case -1052618729:
                    if (!str.equals("native")) {
                        return;
                    }
                    break;
                case -891050150:
                    if (str.equals("survey")) {
                        JSONObject jSONObject5 = (JSONObject) obj;
                        while (jSONObject5.keys().hasNext()) {
                            String next = jSONObject5.keys().next();
                            this.b.add(new AbstractMap.SimpleEntry(next, jSONObject5.getString(next)));
                            jSONObject5.remove(next);
                        }
                        return;
                    }
                    return;
                case -673523926:
                    if (str.equals("adjust_template")) {
                        a((JSONObject) obj);
                        return;
                    }
                    return;
                case -499653645:
                    if (str.equals("native_reviews")) {
                        Insider.Instance.showNativeRating();
                        return;
                    }
                    return;
                case -244918252:
                    if (!str.equals("push_permission")) {
                        return;
                    }
                    break;
                case 3059573:
                    if (str.equals("copy")) {
                        w4.l(this.i, (String) obj);
                        return;
                    }
                    return;
                case 96891546:
                    if (str.equals("event")) {
                        JSONArray jSONArray3 = (JSONArray) obj;
                        int i3 = 0;
                        while (i3 < jSONArray3.length()) {
                            JSONObject jSONObject6 = jSONArray3.getJSONObject(i3);
                            if (jSONObject6 == null || jSONObject6.length() == 0) {
                                jSONArray = jSONArray3;
                                str2 = str3;
                                i = i3;
                            } else {
                                String string5 = jSONObject6.getString("name");
                                JSONArray jSONArrayC = C();
                                jSONArray = jSONArray3;
                                if (string5.equals("lead_collected") && jSONArrayC.length() > 0) {
                                    jSONObject6.put("params", jSONArrayC);
                                }
                                JSONArray jSONArray4 = jSONObject6.getJSONArray("params");
                                InsiderEvent insiderEventTagEvent = Insider.Instance.tagEvent(string5);
                                if (jSONArray4 != null && jSONArray4.length() != 0) {
                                    int i4 = 0;
                                    while (i4 < jSONArray4.length()) {
                                        JSONObject jSONObject7 = jSONArray4.getJSONObject(i4);
                                        JSONArray jSONArray5 = jSONArray4;
                                        String string6 = jSONObject7.getString(str3);
                                        String str5 = str3;
                                        String string7 = jSONObject7.getString("type");
                                        switch (string7.hashCode()) {
                                            case -1325958191:
                                                if (string7.equals("double")) {
                                                    insiderEventTagEvent.addParameterWithDouble(string6, jSONObject7.getDouble("value"));
                                                }
                                                break;
                                            case -891985903:
                                                if (string7.equals(TypedValues.Custom.S_STRING)) {
                                                    insiderEventTagEvent.addParameterWithString(string6, jSONObject7.getString("value"));
                                                }
                                                break;
                                            case 104431:
                                                if (string7.equals("int")) {
                                                    insiderEventTagEvent.addParameterWithInt(string6, jSONObject7.getInt("value"));
                                                }
                                                break;
                                            case 3076014:
                                                if (string7.equals("date")) {
                                                    insiderEventTagEvent.addParameterWithDate(str, (Date) jSONObject7.get("value"));
                                                }
                                                break;
                                            case 64711720:
                                                if (string7.equals(TypedValues.Custom.S_BOOLEAN)) {
                                                    insiderEventTagEvent.addParameterWithBoolean(string6, jSONObject7.getBoolean("value"));
                                                }
                                                break;
                                            case 93090393:
                                                if (string7.equals("array")) {
                                                    insiderEventTagEvent.addParameterWithArray(string6, a(jSONObject7.getJSONArray("value")));
                                                }
                                                break;
                                            default:
                                                break;
                                        }
                                        i4++;
                                        jSONArray4 = jSONArray5;
                                        i3 = i3;
                                        str3 = str5;
                                    }
                                    str2 = str3;
                                    i = i3;
                                    insiderEventTagEvent.build();
                                } else {
                                    str2 = str3;
                                    i = i3;
                                    insiderEventTagEvent.build();
                                }
                            }
                            i3 = i + 1;
                            jSONArray3 = jSONArray;
                            str3 = str2;
                        }
                        return;
                    }
                    return;
                case 405645655:
                    if (str.equals(RumFeature.EVENT_ATTRIBUTES_PROPERTY)) {
                        int i5 = 0;
                        for (JSONArray jSONArray6 = (JSONArray) obj; i5 < jSONArray6.length(); jSONArray6 = jSONArray6) {
                            JSONObject jSONObject8 = jSONArray6.getJSONObject(i5);
                            if (jSONObject8 != null && jSONObject8.length() != 0) {
                                String string8 = jSONObject8.getString("type");
                                String string9 = jSONObject8.getString("key");
                                switch (string8.hashCode()) {
                                    case -1325958191:
                                        if (string8.equals("double")) {
                                            Insider.Instance.getCurrentUser().setCustomAttributeWithDouble(string9, jSONObject8.getDouble("value"));
                                        }
                                        break;
                                    case -891985903:
                                        if (string8.equals(TypedValues.Custom.S_STRING)) {
                                            Insider.Instance.getCurrentUser().setCustomAttributeWithString(string9, jSONObject8.getString("value"));
                                        }
                                        break;
                                    case 104431:
                                        if (string8.equals("int")) {
                                            Insider.Instance.getCurrentUser().setCustomAttributeWithInt(string9, jSONObject8.getInt("value"));
                                        }
                                        break;
                                    case 3076014:
                                        if (string8.equals("date")) {
                                            Insider.Instance.getCurrentUser().setCustomAttributeWithDate(string9, (Date) jSONObject8.get("value"));
                                        }
                                        break;
                                    case 64711720:
                                        if (string8.equals(TypedValues.Custom.S_BOOLEAN)) {
                                            Insider.Instance.getCurrentUser().setCustomAttributeWithBoolean(string9, jSONObject8.getBoolean("value"));
                                        }
                                        break;
                                    case 93090393:
                                        if (string8.equals("array")) {
                                            Insider.Instance.getCurrentUser().setCustomAttributeWithArray(string9, a(jSONObject8.getJSONArray("value")));
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            }
                            i5++;
                        }
                        return;
                    }
                    return;
                case 930178581:
                    if (str.equals("default_attributes")) {
                        JSONArray jSONArray7 = (JSONArray) obj;
                        for (int i6 = 0; i6 < jSONArray7.length(); i6++) {
                            JSONObject jSONObject9 = jSONArray7.getJSONObject(i6);
                            if (jSONObject9 != null && jSONObject9.length() != 0) {
                                Insider.Instance.getCurrentUser().setUserAttribute(jSONObject9.getString("key"), jSONObject9.getString("value"), jSONObject9.getString("type"));
                            }
                        }
                        return;
                    }
                    return;
                case 1089453990:
                    if (str.equals("trigger_haptic_feedback")) {
                        c(((JSONObject) obj).getInt("severity"));
                        return;
                    }
                    return;
                case 1670824349:
                    if (str.equals("retrieve_device_attributes")) {
                        a(f.DeviceAttributes);
                        return;
                    }
                    return;
                case 2131394733:
                    if (str.equals("item_purchase")) {
                        JSONArray jSONArray8 = (JSONArray) obj;
                        for (int i7 = 0; i7 < jSONArray8.length(); i7++) {
                            JSONObject jSONObject10 = (JSONObject) jSONArray8.get(i7);
                            String string10 = jSONObject10.getString("unique_sale_id");
                            String string11 = jSONObject10.getString(FirebaseAnalytics.Param.PRODUCT_ID);
                            String string12 = jSONObject10.getString(FirebaseAnalytics.Param.PRODUCT_NAME);
                            String[] strArrA2 = w4.a(jSONObject10.getJSONArray("product_taxonomy"));
                            String string13 = jSONObject10.getString("product_image_url");
                            double d3 = jSONObject10.getDouble(FirebaseAnalytics.Param.PRICE);
                            String string14 = jSONObject10.getString(FirebaseAnalytics.Param.CURRENCY);
                            Insider insider2 = Insider.Instance;
                            insider2.itemPurchased(string10, insider2.createNewProduct(string11, string12, strArrA2, string13, d3, string14));
                        }
                        JSONObject jSONObject11 = new JSONObject();
                        InsiderCallbackType insiderCallbackType3 = InsiderCallbackType.TEMP_STORE_PURCHASE;
                        jSONObject11.put("type", insiderCallbackType3.ordinal());
                        JSONObject jSONObject12 = new JSONObject();
                        jSONObject12.put("purchased_items", jSONArray8);
                        jSONObject11.put("data", jSONObject12);
                        Insider.Instance.performInsiderCallback(jSONObject11, insiderCallbackType3);
                        return;
                    }
                    return;
                default:
                    return;
            }
            m0.f().n().a(this.i);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void a(JSONObject jSONObject) {
        FrameLayout.LayoutParams layoutParams;
        try {
            this.h.a(jSONObject);
            t.a aVarA = this.h.a();
            if (this.v) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            this.s = b(aVarA);
            a(layoutParams, aVarA);
            b(layoutParams, aVarA);
            if (!this.v) {
                int[] iArr = this.s;
                layoutParams.width = iArr[0];
                layoutParams.height = iArr[1];
            }
            this.d.setLayoutParams(layoutParams);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void a(f fVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = d.f407a[fVar.ordinal()];
            if (i == 1) {
                InsiderProduct insiderProductD = a5.d();
                if (insiderProductD == null) {
                    return;
                } else {
                    jSONObject = w4.g(insiderProductD.getProductSummary());
                }
            } else if (i == 2) {
                jSONObject = a5.b();
                if (jSONObject == null) {
                    return;
                }
                if (jSONObject.has("device_attributes")) {
                    jSONObject.getJSONObject("device_attributes").put("screen_height", this.p.getHeight()).put("screen_width", this.p.getWidth()).put("density", this.i.getResources().getDisplayMetrics().density).put("status_bar_height", w4.b((View) this.p)).put("navigation_bar_height", w4.a((View) this.p));
                } else {
                    jSONObject.put("device_attributes", a5.c().put("screen_height", this.p.getHeight()).put("screen_width", this.p.getWidth()).put("density", this.i.getResources().getDisplayMetrics().density).put("status_bar_height", w4.b((View) this.p)).put("navigation_bar_height", w4.a((View) this.p)));
                }
            } else if (i == 3) {
                jSONObject.put("shake_detected", true);
            }
            a(fVar.b(), jSONObject);
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private void a(int i, JSONObject jSONObject) {
        try {
            if (this.g == null) {
                return;
            }
            String str = String.format("javascript : sdkCallbackMethod(%d, %s)", Integer.valueOf(i), jSONObject);
            this.g.evaluateJavascript(str, null);
            f3.b("web_view", "Sent data to WebView.", new JSONObject().put("java_script_string", str).put("inapp_id", this.t.f).put("variant_id", this.t.e), "Inapp-evaluateJavascript");
        } catch (Exception e2) {
            Insider.Instance.putException(e2);
        }
    }

    private String[] a(JSONArray jSONArray) {
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                strArr[i] = jSONArray.getString(i);
            } catch (Exception e2) {
                Insider.Instance.putException(e2);
                return null;
            }
        }
        return strArr;
    }
}
