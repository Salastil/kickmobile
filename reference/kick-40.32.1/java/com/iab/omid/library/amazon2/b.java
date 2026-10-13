package com.iab.omid.library.amazon2;

import android.content.Context;
import android.webkit.WebSettings;
import com.iab.omid.library.amazon2.internal.i;
import com.iab.omid.library.amazon2.internal.k;
import com.iab.omid.library.amazon2.utils.d;
import com.iab.omid.library.amazon2.utils.e;
import com.iab.omid.library.amazon2.utils.g;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f183a;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f184a;

        a(b bVar, Context context) {
            this.f184a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                WebSettings.getDefaultUserAgent(this.f184a);
            } catch (Throwable unused) {
                d.a("Ignoring failure while retrieving default WebView user agent");
            }
        }
    }

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    private void c(Context context) {
        Executors.newSingleThreadExecutor().execute(new a(this, context));
    }

    String a() {
        return "1.6.4-Amazon2";
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        i.c().a(context);
        com.iab.omid.library.amazon2.internal.b.g().a(context);
        com.iab.omid.library.amazon2.utils.a.a(context);
        com.iab.omid.library.amazon2.utils.c.a(context);
        e.a(context);
        com.iab.omid.library.amazon2.internal.g.b().a(context);
        com.iab.omid.library.amazon2.internal.a.a().a(context);
        k.b().a(context);
        c(context);
    }

    void a(boolean z) {
        this.f183a = z;
    }

    boolean b() {
        return this.f183a;
    }

    void c() {
        g.a();
        com.iab.omid.library.amazon2.internal.a.a().d();
    }
}
