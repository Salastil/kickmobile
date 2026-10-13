package com.useinsider.insider;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class a2 implements x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f311a;

    a2(List list) {
        this.f311a = list;
    }

    @Override // com.useinsider.insider.x1
    public boolean a(List list, int i) {
        Iterator it = this.f311a.iterator();
        while (it.hasNext()) {
            if (((x1) it.next()).a(list, i)) {
                return true;
            }
        }
        return false;
    }
}
