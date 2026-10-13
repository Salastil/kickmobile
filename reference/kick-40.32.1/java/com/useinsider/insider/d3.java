package com.useinsider.insider;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Supplier f323a;
    private Object b;
    private boolean c = false;

    public d3(Supplier supplier) {
        this.f323a = supplier;
    }

    synchronized Object a() {
        if (!this.c) {
            this.b = this.f323a.get();
            this.f323a = null;
            this.c = true;
        }
        return this.b;
    }
}
