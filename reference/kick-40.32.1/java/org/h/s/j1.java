package org.h.s;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
public final class j1 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f525a;
    public final /* synthetic */ Ref.ObjectRef b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(l1 l1Var, Ref.ObjectRef objectRef) {
        super(1);
        this.f525a = l1Var;
        this.b = objectRef;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object, java.lang.String] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ?? keyInStorage = (String) obj;
        Intrinsics.checkNotNullParameter(keyInStorage, "keyInStorage");
        if (keyInStorage.length() > 0 && this.f525a.f != keyInStorage) {
            this.b.element = keyInStorage;
        }
        return Unit.INSTANCE;
    }
}
