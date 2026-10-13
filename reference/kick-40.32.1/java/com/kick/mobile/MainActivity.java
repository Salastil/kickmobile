package com.kick.mobile;

import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactActivityDelegate;
import com.google.android.gms.cast.MediaTrack;
import com.horcrux.svg.TSpanView$$ExternalSyntheticApiModelOutline0;
import com.kick.mobile.kickivsplayerv2.KickIvsPlayerV2Manager;
import com.kick.mobile.kickivsplayerv2.ScreenStateReceiver;
import com.reactnative.googlecast.api.RNGCCastContext;
import expo.modules.ReactActivityDelegateWrapper;
import expo.modules.splashscreen.SplashScreenManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0014J\b\u0010\u0012\u001a\u00020\tH\u0014J\b\u0010\u0013\u001a\u00020\tH\u0014J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/kick/mobile/MainActivity;", "Lcom/facebook/react/ReactActivity;", "<init>", "()V", "kickScreenStateReceiver", "Lcom/kick/mobile/kickivsplayerv2/ScreenStateReceiver;", "kickScreenStateIntentFilter", "Landroid/content/IntentFilter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getMainComponentName", "", "createReactActivityDelegate", "Lcom/facebook/react/ReactActivityDelegate;", "invokeDefaultOnBackPressed", "onDestroy", "onStop", "onResume", "onPictureInPictureModeChanged", "isInPictureInPictureMode", "", "newConfig", "Landroid/content/res/Configuration;", "onUserLeaveHint", "app_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MainActivity extends ReactActivity {
    private final IntentFilter kickScreenStateIntentFilter;
    private final ScreenStateReceiver kickScreenStateReceiver = new ScreenStateReceiver();

    public MainActivity() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.kickScreenStateIntentFilter = intentFilter;
    }

    @Override // com.facebook.react.ReactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        int i = Build.VERSION.SDK_INT;
        ScreenStateReceiver screenStateReceiver = this.kickScreenStateReceiver;
        if (i >= 33) {
            registerReceiver(screenStateReceiver, this.kickScreenStateIntentFilter, 4);
        } else {
            registerReceiver(screenStateReceiver, this.kickScreenStateIntentFilter);
        }
        SplashScreenManager.INSTANCE.registerOnActivity(this);
        super.onCreate(null);
        RNGCCastContext.getSharedInstance(this);
    }

    @Override // com.facebook.react.ReactActivity
    protected String getMainComponentName() {
        return MediaTrack.ROLE_MAIN;
    }

    @Override // com.facebook.react.ReactActivity
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegateWrapper(this, true, new DefaultReactActivityDelegate(this, getMainComponentName(), DefaultNewArchitectureEntryPoint.getFabricEnabled()) { // from class: com.kick.mobile.MainActivity.createReactActivityDelegate.1
            {
                MainActivity mainActivity = this;
            }
        });
    }

    @Override // com.facebook.react.ReactActivity, com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
    public void invokeDefaultOnBackPressed() {
        if (Build.VERSION.SDK_INT <= 30) {
            if (moveTaskToBack(false)) {
                return;
            }
            super.invokeDefaultOnBackPressed();
            return;
        }
        super.invokeDefaultOnBackPressed();
    }

    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        unregisterReceiver(this.kickScreenStateReceiver);
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        KickIvsPlayerV2Manager.INSTANCE.onActivityStop(this, isFinishing(), isChangingConfigurations(), isInPictureInPictureMode());
        super.onStop();
    }

    @Override // com.facebook.react.ReactActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        KickIvsPlayerV2Manager.INSTANCE.onActivityResume(this);
        super.onResume();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        KickIvsPlayerV2Manager.INSTANCE.setBackgroundPipState(this, isInPictureInPictureMode, isChangingConfigurations());
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    }

    @Override // com.facebook.react.ReactActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onUserLeaveHint() {
        if (getPackageManager().hasSystemFeature("android.software.picture_in_picture") && KickIvsPlayerV2Manager.INSTANCE.getPipEnabled() && !isInPictureInPictureMode()) {
            if (Build.VERSION.SDK_INT < 26) {
                enterPictureInPictureMode();
            } else {
                enterPictureInPictureMode(TSpanView$$ExternalSyntheticApiModelOutline0.m11704m().build());
            }
        }
        super.onUserLeaveHint();
    }
}
