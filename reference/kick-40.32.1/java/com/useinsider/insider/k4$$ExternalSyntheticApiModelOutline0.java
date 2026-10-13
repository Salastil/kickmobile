package com.useinsider.insider;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.content.res.AssetManager;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.fonts.Font;
import android.os.ProfilingTrigger;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class k4$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ NotificationChannelGroup m(String str, CharSequence charSequence) {
        return new NotificationChannelGroup(str, charSequence);
    }

    public static /* synthetic */ Font.Builder m(AssetManager assetManager, String str) {
        return new Font.Builder(assetManager, str);
    }

    public static /* synthetic */ Font.Builder m(File file) {
        return new Font.Builder(file);
    }

    public static /* synthetic */ Font.Builder m(ByteBuffer byteBuffer) {
        return new Font.Builder(byteBuffer);
    }

    public static /* bridge */ /* synthetic */ Font m(Object obj) {
        return (Font) obj;
    }

    public static /* synthetic */ ProfilingTrigger.Builder m(int i) {
        return new ProfilingTrigger.Builder(i);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m11853m() {
        return AclEntryPermission.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m11867m(Object obj) {
        return obj instanceof AdaptiveIconDrawable;
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m11870m$1() {
        return BasicFileAttributes.class;
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof NotificationChannelGroup;
    }

    public static /* bridge */ /* synthetic */ boolean m$2(Object obj) {
        return obj instanceof NotificationChannel;
    }
}
