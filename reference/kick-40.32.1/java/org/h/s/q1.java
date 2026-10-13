package org.h.s;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public abstract class q1 {
    public static final /* synthetic */ KProperty[] b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(q1.class, "domainData", "getDomainData()Lio/mobileshield/sdk/data/domain/DomainData;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f559a = i.a();

    public final u a() {
        h hVar = this.f559a;
        KProperty property = b[0];
        hVar.getClass();
        Intrinsics.checkNotNullParameter(property, "property");
        return (u) hVar.f515a.get();
    }

    public final void a(u uVar) {
        h hVar = this.f559a;
        KProperty property = b[0];
        hVar.getClass();
        Intrinsics.checkNotNullParameter(property, "property");
        hVar.f515a.set(uVar);
    }
}
