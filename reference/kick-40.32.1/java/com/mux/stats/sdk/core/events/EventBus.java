package com.mux.stats.sdk.core.events;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class EventBus implements IEventDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f235a = 0;
    private ConcurrentHashMap<Integer, IEventListener> b = new ConcurrentHashMap<>();
    private HashSet<Integer> c = new HashSet<>();

    public void addListener(IEventListener iEventListener) {
        iEventListener.setId(this.f235a);
        ConcurrentHashMap<Integer, IEventListener> concurrentHashMap = this.b;
        int i = this.f235a;
        this.f235a = i + 1;
        concurrentHashMap.put(Integer.valueOf(i), iEventListener);
    }

    public void addListenerOnce(IEventListener iEventListener) {
        this.c.add(Integer.valueOf(this.f235a));
        addListener(iEventListener);
    }

    @Override // com.mux.stats.sdk.core.events.IEventDispatcher
    public void dispatch(IEvent iEvent) {
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < this.f235a; i++) {
            IEventListener iEventListener = this.b.get(Integer.valueOf(i));
            if (iEventListener != null) {
                iEventListener.handle(iEvent);
                int id = iEventListener.getId();
                if (this.c.contains(Integer.valueOf(id))) {
                    arrayList.add(Integer.valueOf(id));
                }
            }
        }
        for (Integer num : arrayList) {
            num.intValue();
            this.b.remove(num);
        }
    }

    public void flush() {
        for (int i = 0; i < this.f235a; i++) {
            IEventListener iEventListener = this.b.get(Integer.valueOf(i));
            if (iEventListener != null) {
                iEventListener.flush();
            }
        }
    }

    public void removeAllListeners() {
        this.b = new ConcurrentHashMap<>();
        this.c = new HashSet<>();
    }

    public void removeListener(IEventListener iEventListener) {
        this.b.remove(Integer.valueOf(iEventListener.getId()));
    }
}
