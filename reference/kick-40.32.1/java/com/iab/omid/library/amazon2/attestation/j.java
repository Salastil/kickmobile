package com.iab.omid.library.amazon2.attestation;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: loaded from: classes8.dex */
public class j implements k {
    private static volatile j d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Boolean f182a;
    private volatile Boolean b;
    private final Context c;

    private j(Context context) {
        this.c = context;
        c();
    }

    public static j a(Context context) {
        if (d == null) {
            synchronized (j.class) {
                if (d == null) {
                    d = new j(context);
                }
            }
        }
        return d;
    }

    @Override // com.iab.omid.library.amazon2.attestation.k
    public boolean a() {
        return c();
    }

    public boolean b() {
        boolean zHasSystemFeature;
        if (this.b != null) {
            return this.b.booleanValue();
        }
        synchronized (this) {
            if (this.b == null) {
                if (c()) {
                    try {
                        PackageManager packageManager = this.c.getPackageManager();
                        if (packageManager == null) {
                            com.iab.omid.library.amazon2.utils.d.b("PackageManager is null when checking attestation capability");
                            this.b = Boolean.FALSE;
                        } else {
                            zHasSystemFeature = packageManager.hasSystemFeature("com.amazon.privacypass");
                            Boolean boolValueOf = Boolean.valueOf(zHasSystemFeature);
                            this.b = boolValueOf;
                            boolValueOf.getClass();
                        }
                    } catch (SecurityException e) {
                        com.iab.omid.library.amazon2.utils.d.a("Security exception when checking attestation capability", e);
                        this.b = Boolean.FALSE;
                        return false;
                    } catch (Exception e2) {
                        com.iab.omid.library.amazon2.utils.d.a("Unexpected error when checking attestation capability", e2);
                        this.b = Boolean.FALSE;
                        return false;
                    }
                } else {
                    this.b = Boolean.FALSE;
                }
                return false;
            }
            zHasSystemFeature = this.b.booleanValue();
            return zHasSystemFeature;
        }
    }

    public boolean c() {
        boolean zBooleanValue;
        int i;
        if (this.f182a != null) {
            return this.f182a.booleanValue();
        }
        synchronized (this) {
            if (this.f182a != null) {
                zBooleanValue = this.f182a.booleanValue();
            } else {
                zBooleanValue = this.c != null && Build.MANUFACTURER.equalsIgnoreCase("Amazon") && Build.MODEL.toLowerCase().startsWith("aft") && (i = Build.VERSION.SDK_INT) >= 25 && i <= 30;
                Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
                this.f182a = boolValueOf;
                boolValueOf.getClass();
            }
        }
        return zBooleanValue;
    }
}
