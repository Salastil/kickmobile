package com.useinsider.insider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class InsiderInappActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f302a = this;
    private boolean b = false;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f303a;
        final /* synthetic */ ViewGroup b;

        /* JADX INFO: renamed from: com.useinsider.insider.InsiderInappActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
        class C0153a extends WebViewClient {
            C0153a() {
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return (str.startsWith("http://") || str.startsWith("https://")) ? false : true;
            }
        }

        a(String str, ViewGroup viewGroup) {
            this.f303a = str;
            this.b = viewGroup;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            try {
                InsiderInappActivity.this.a();
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FrameLayout frameLayout = new FrameLayout(InsiderInappActivity.this.f302a);
                frameLayout.setTag("insider_terms_view");
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setBackgroundColor(-1);
                WebView webView = new WebView(InsiderInappActivity.this.f302a);
                webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                webView.setWebViewClient(new C0153a());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setDomStorageEnabled(true);
                webView.loadUrl(this.f303a);
                TextView textView = new TextView(InsiderInappActivity.this.f302a);
                textView.setTextSize(18.0f);
                textView.setTextColor(Color.parseColor("#333333"));
                textView.setText("\ue802");
                textView.setTypeface(w4.b(InsiderInappActivity.this.f302a, "insider.ttf"));
                CloseButtonPosition closeButtonPosition = e.q;
                if (closeButtonPosition == null) {
                    closeButtonPosition = CloseButtonPosition.RIGHT;
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                int iA = (int) f5.a(InsiderInappActivity.this.f302a, 10.0f);
                if (closeButtonPosition == CloseButtonPosition.NONE) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    if (closeButtonPosition == CloseButtonPosition.LEFT) {
                        layoutParams.gravity = 51;
                        layoutParams.setMargins(iA, iA, 0, 0);
                    } else {
                        layoutParams.gravity = 53;
                        layoutParams.setMargins(0, iA, iA, 0);
                    }
                }
                textView.setLayoutParams(layoutParams);
                frameLayout.addView(webView);
                frameLayout.addView(textView);
                textView.bringToFront();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.useinsider.insider.InsiderInappActivity$a$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.a(view);
                    }
                });
                this.b.addView(frameLayout);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams2.setMargins(0, w4.b((View) this.b), 0, 0);
                frameLayout.setLayoutParams(layoutParams2);
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        a();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (Build.VERSION.SDK_INT != 26) {
                setRequestedOrientation(1);
            }
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            Insider.Instance.start(this);
            a(getIntent());
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        try {
            if (e.r) {
                e.r = false;
            }
            if (e.u != null) {
                if (e.t) {
                    Map<String, ?> mapA = i3.a(e.u, i4.EVENT);
                    if (e.u.hasExtra(f.f329a) || e.u.hasExtra(f.b)) {
                        l0.B.add(f.c);
                    }
                    Insider.Instance.tagEvent("push_session").addParameters(mapA).build();
                }
                l0.W();
                e.u = null;
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private void a(Intent intent) {
        if (intent != null) {
            if (intent.hasExtra(ImagesContract.URL)) {
                a(intent.getStringExtra(ImagesContract.URL));
                intent.removeExtra(ImagesContract.URL);
            }
            this.b = intent.getBooleanExtra("keepActivity", false);
        }
    }

    private void a(String str) {
        try {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            viewGroup.post(new a(str, viewGroup));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            if (getCallingActivity() != null) {
                finish();
            }
            if (!f5.b(this)) {
                Insider.Instance.removeInapp(this);
            }
            if (!this.b) {
                super.onBackPressed();
                overridePendingTransition(0, 0);
            } else {
                finish();
                overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
