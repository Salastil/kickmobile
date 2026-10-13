package com.horcrux.svg;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.NotificationChannel;
import android.app.PictureInPictureParams;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.icu.number.LocalizedNumberFormatter;
import android.icu.number.Notation;
import android.icu.number.UnlocalizedNumberFormatter;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class TSpanView$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ NotificationChannel m(String str, CharSequence charSequence, int i) {
        return new NotificationChannel(str, charSequence, i);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ PictureInPictureParams.Builder m11704m() {
        return new PictureInPictureParams.Builder();
    }

    public static /* synthetic */ Typeface.Builder m(AssetManager assetManager, String str) {
        return new Typeface.Builder(assetManager, str);
    }

    public static /* bridge */ /* synthetic */ LocalizedNumberFormatter m(Object obj) {
        return (LocalizedNumberFormatter) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Notation m11706m(Object obj) {
        return (Notation) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ UnlocalizedNumberFormatter m11709m(Object obj) {
        return (UnlocalizedNumberFormatter) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m11710m() {
        return BasicFileAttributes.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m11712m() {
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m11715m(Object obj) {
        return obj instanceof ForegroundServiceStartNotAllowedException;
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m11716m$1() {
        return Path.class;
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m11717m$1() {
    }
}
