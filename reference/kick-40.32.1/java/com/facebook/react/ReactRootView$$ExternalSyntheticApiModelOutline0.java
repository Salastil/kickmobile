package com.facebook.react;

import android.content.pm.ApkChecksum;
import android.content.res.loader.ResourcesLoader;
import android.crypto.hpke.Message;
import android.graphics.BlendMode;
import android.graphics.drawable.ColorStateListDrawable;
import android.os.VibratorManager;
import dalvik.system.DelegateLastClassLoader;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ReactRootView$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ ApkChecksum m(Object obj) {
        return (ApkChecksum) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ ResourcesLoader m11391m() {
        return new ResourcesLoader();
    }

    public static /* synthetic */ Message m(byte[] bArr, byte[] bArr2) {
        return new Message(bArr, bArr2);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ BlendMode m11393m(Object obj) {
        return (BlendMode) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ColorStateListDrawable m11394m(Object obj) {
        return (ColorStateListDrawable) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ VibratorManager m11395m(Object obj) {
        return (VibratorManager) obj;
    }

    public static /* synthetic */ DelegateLastClassLoader m(String str, ClassLoader classLoader) {
        return new DelegateLastClassLoader(str, classLoader);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m11398m() {
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m11402m(Object obj) {
        return obj instanceof BlendMode;
    }

    public static /* synthetic */ void m$1() {
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof ColorStateListDrawable;
    }
}
