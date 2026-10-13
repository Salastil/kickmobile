package com.useinsider.insider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List f327a = new ArrayList();

    static void a(InsiderIDListener insiderIDListener) {
        try {
            f327a.add(insiderIDListener);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static void b(InsiderIDListener insiderIDListener) {
        try {
            f327a.remove(insiderIDListener);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static void a(String str) {
        try {
            Iterator it = f327a.iterator();
            while (it.hasNext()) {
                ((InsiderIDListener) it.next()).onUpdated(str);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
