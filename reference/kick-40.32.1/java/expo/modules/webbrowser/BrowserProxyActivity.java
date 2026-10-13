package expo.modules.webbrowser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowserProxyActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014J\b\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0014J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/webbrowser/BrowserProxyActivity;", "Landroid/app/Activity;", "<init>", "()V", "hasLaunchedCustomTab", "", "wasPaused", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "returnToMainApp", "onSaveInstanceState", "outState", "onRestoreInstanceState", "Companion", "expo-web-browser_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowserProxyActivity extends Activity {
    public static final String EXTRA_CUSTOM_TABS_INTENT_DATA = "expo.modules.webbrowser.EXTRA_CUSTOM_TABS_INTENT_DATA";
    public static final String EXTRA_URL = "expo.modules.webbrowser.EXTRA_URL";
    private boolean hasLaunchedCustomTab;
    private boolean wasPaused;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static WeakReference<BrowserProxyActivity> instance = new WeakReference<>(null);

    /* JADX INFO: compiled from: BrowserProxyActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lexpo/modules/webbrowser/BrowserProxyActivity$Companion;", "", "<init>", "()V", "EXTRA_URL", "", "EXTRA_CUSTOM_TABS_INTENT_DATA", "instance", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/webbrowser/BrowserProxyActivity;", "getInstance", "()Ljava/lang/ref/WeakReference;", "setInstance", "(Ljava/lang/ref/WeakReference;)V", "expo-web-browser_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WeakReference<BrowserProxyActivity> getInstance() {
            return BrowserProxyActivity.instance;
        }

        public final void setInstance(WeakReference<BrowserProxyActivity> weakReference) {
            Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
            BrowserProxyActivity.instance = weakReference;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra(EXTRA_URL);
        if (Build.VERSION.SDK_INT >= 33) {
            intent = (Intent) getIntent().getParcelableExtra(EXTRA_CUSTOM_TABS_INTENT_DATA, Intent.class);
        } else {
            intent = (Intent) getIntent().getParcelableExtra(EXTRA_CUSTOM_TABS_INTENT_DATA);
        }
        if (stringExtra == null || intent == null) {
            finish();
            return;
        }
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
        Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "build(...)");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            customTabsIntentBuild.intent.putExtras(extras);
        }
        String str = intent.getPackage();
        if (str != null) {
            customTabsIntentBuild.intent.setPackage(str);
        }
        customTabsIntentBuild.launchUrl(this, Uri.parse(stringExtra));
        instance = new WeakReference<>(this);
        this.hasLaunchedCustomTab = true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.hasLaunchedCustomTab && this.wasPaused) {
            returnToMainApp();
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.wasPaused = true;
    }

    private final void returnToMainApp() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(603979776);
            startActivity(launchIntentForPackage);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("hasLaunchedCustomTab", this.hasLaunchedCustomTab);
        outState.putBoolean("wasPaused", this.wasPaused);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        this.hasLaunchedCustomTab = savedInstanceState.getBoolean("hasLaunchedCustomTab", false);
        this.wasPaused = savedInstanceState.getBoolean("wasPaused", false);
    }
}
