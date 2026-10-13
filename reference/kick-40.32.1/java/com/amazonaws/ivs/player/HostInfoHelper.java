package com.amazonaws.ivs.player;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: loaded from: classes5.dex */
class HostInfoHelper {
    int compileSdkVersion;
    String gpu = "";
    boolean isLowMemoryDevice;
    int minSdkVersion;
    String packageName;
    String soc;
    int targetSdkVersion;
    int versionCode;
    String versionName;

    HostInfoHelper(final Context context) {
        this.minSdkVersion = -1;
        this.compileSdkVersion = -1;
        this.soc = "";
        this.packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.packageName, 0);
            this.versionCode = packageInfo.versionCode;
            this.versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            this.versionName = "?";
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        this.targetSdkVersion = applicationInfo.targetSdkVersion;
        this.minSdkVersion = applicationInfo.minSdkVersion;
        if (Build.VERSION.SDK_INT >= 31) {
            this.compileSdkVersion = applicationInfo.compileSdkVersion;
            this.soc = Build.SOC_MANUFACTURER + "_" + Build.SOC_MODEL;
        }
        EGLManager.create().ifOk(new Consumer() { // from class: com.amazonaws.ivs.player.HostInfoHelper$$ExternalSyntheticLambda1
            @Override // com.amazonaws.ivs.player.Consumer
            public final void accept(Object obj) {
                this.f$0.m11059lambda$new$1$comamazonawsivsplayerHostInfoHelper(context, (EGLManager) obj);
            }
        });
        this.isLowMemoryDevice = ((ActivityManager) context.getSystemService("activity")).isLowRamDevice();
    }

    /* JADX INFO: renamed from: lambda$new$1$com-amazonaws-ivs-player-HostInfoHelper, reason: not valid java name */
    /* synthetic */ void m11059lambda$new$1$comamazonawsivsplayerHostInfoHelper(Context context, EGLManager eGLManager) {
        HardwareInfo.create(context, eGLManager).ifOk(new Consumer() { // from class: com.amazonaws.ivs.player.HostInfoHelper$$ExternalSyntheticLambda2
            @Override // com.amazonaws.ivs.player.Consumer
            public final void accept(Object obj) {
                this.f$0.m11058lambda$new$0$comamazonawsivsplayerHostInfoHelper((HardwareInfo) obj);
            }
        });
        eGLManager.release();
    }

    /* JADX INFO: renamed from: lambda$new$0$com-amazonaws-ivs-player-HostInfoHelper, reason: not valid java name */
    /* synthetic */ void m11058lambda$new$0$comamazonawsivsplayerHostInfoHelper(HardwareInfo hardwareInfo) {
        this.gpu = hardwareInfo.getGPURenderer();
        hardwareInfo.release();
    }
}
