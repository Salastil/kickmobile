package com.google.android.play.integrity.internal;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes5.dex */
final class x extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f172a;

    x(ae aeVar) {
        this.f172a = aeVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        synchronized (this.f172a.g) {
            if (this.f172a.m.get() > 0 && this.f172a.m.decrementAndGet() > 0) {
                this.f172a.c.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                return;
            }
            ae aeVar = this.f172a;
            if (aeVar.o != null) {
                aeVar.c.d("Unbind from service.", new Object[0]);
                ae aeVar2 = this.f172a;
                aeVar2.b.unbindService(aeVar2.n);
                this.f172a.h = false;
                this.f172a.o = null;
                this.f172a.n = null;
            }
            this.f172a.x();
        }
    }
}
