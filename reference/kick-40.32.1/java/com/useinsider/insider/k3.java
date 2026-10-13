package com.useinsider.insider;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class k3 implements j3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f349a = new CopyOnWriteArraySet();

    k3() {
    }

    @Override // com.useinsider.insider.j3
    public synchronized void a(Object obj) {
        this.f349a.add(obj);
    }

    void a(Consumer consumer) {
        Set setM12759m;
        synchronized (this) {
            setM12759m = UByte$$ExternalSyntheticBackport0.m12759m((Collection) this.f349a);
        }
        for (Object obj : setM12759m) {
            if (obj != null) {
                consumer.accept(obj);
            }
        }
    }
}
