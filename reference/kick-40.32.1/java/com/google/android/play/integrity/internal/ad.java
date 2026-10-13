package com.google.android.play.integrity.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes5.dex */
final class ad implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f160a;

    /* synthetic */ ad(ae aeVar, ac acVar) {
        this.f160a = aeVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f160a.c.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f160a.c().post(new aa(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f160a.c.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f160a.c().post(new ab(this));
    }
}
