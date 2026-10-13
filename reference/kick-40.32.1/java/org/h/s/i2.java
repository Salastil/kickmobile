package org.h.s;

import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
public final class i2 extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f522a = new AtomicBoolean(true);

    public final void a(boolean z) {
        this.f522a.set(z);
        setChanged();
        notifyObservers(Boolean.valueOf(this.f522a.get()));
    }
}
