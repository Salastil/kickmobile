package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes5.dex */
final class aa extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IBinder f158a;
    final /* synthetic */ ad b;

    aa(ad adVar, IBinder iBinder) {
        this.b = adVar;
        this.f158a = iBinder;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        this.b.f160a.o = (IInterface) this.b.f160a.j.a(this.f158a);
        ae.r(this.b.f160a);
        this.b.f160a.h = false;
        Iterator it = this.b.f160a.e.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.b.f160a.e.clear();
    }
}
