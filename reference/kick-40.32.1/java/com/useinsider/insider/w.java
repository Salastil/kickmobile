package com.useinsider.insider;

import com.datadog.android.rum.internal.metric.SessionEndedMetric;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f436a = new ArrayList();
    private final List b = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f437a;
        private final long b;

        a(String str, long j) {
            this.f437a = str;
            this.b = j;
        }

        Map a() {
            return UByte$$ExternalSyntheticBackport0.m(new Map.Entry[]{new AbstractMap.SimpleEntry("id", this.f437a), new AbstractMap.SimpleEntry("timestamp", Long.valueOf(this.b))});
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f438a;
        private final long b;

        /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
        enum a {
            VIEW,
            CLICK
        }

        b(a aVar, long j) {
            this.f438a = aVar.toString().toLowerCase(Locale.ENGLISH);
            this.b = j;
        }

        Map a() {
            return UByte$$ExternalSyntheticBackport0.m(new Map.Entry[]{new AbstractMap.SimpleEntry("type", this.f438a), new AbstractMap.SimpleEntry("timestamp", Long.valueOf(this.b))});
        }
    }

    w() {
    }

    w a(a aVar) {
        this.f436a.add(aVar);
        return this;
    }

    w a(b bVar) {
        this.b.add(bVar);
        return this;
    }

    w a(w wVar) {
        this.f436a.addAll(wVar.f436a);
        this.b.addAll(wVar.b);
        return this;
    }

    Map a() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f436a.iterator();
        while (it.hasNext()) {
            arrayList.add(((a) it.next()).a());
        }
        map.put(SessionEndedMetric.NO_VIEW_EVENTS_COUNT_ACTIONS_KEY, arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((b) it2.next()).a());
        }
        map.put("conversions", arrayList2);
        return map;
    }
}
