package io.mobileshield.sdk.internal.lifecycle;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import org.h.s.a0;
import org.h.s.f1;
import org.h.s.j3;
import org.h.s.l1;
import org.h.s.q4;
import org.h.s.s3;
import org.h.s.t1;
import org.h.s.v3;
import org.h.s.w0;
import org.h.s.w3;
import org.h.s.y1;
import org.h.s.z0;
import org.h.s.z1;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/mobileshield/sdk/internal/lifecycle/ProcessObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "sdk_release"}, k = 1, mv = {1, 9, 0})
public final class ProcessObserver implements DefaultLifecycleObserver {
    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(LifecycleOwner owner) {
        z0 z0Var;
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (y1.i == null) {
            y1.i = new y1(Dispatchers.getIO(), new t1());
        }
        y1 y1Var = y1.i;
        Intrinsics.checkNotNull(y1Var);
        Collection collectionValues = y1Var.d.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            z1 z1Var = ((q4) it.next()).j;
            if (z1Var != null) {
                z1Var.d();
            }
        }
        s3 s3Var = f1.f506a;
        f1.a(w0.k0, null);
        s3 s3Var2 = f1.f506a;
        s3Var2.getClass();
        if (a0.i.c) {
            l1 l1Var = s3Var2.c;
            if (!l1Var.e.f494a.compareAndSet(true, false) || (z0Var = l1Var.d) == null) {
                return;
            }
            PersistentList loggingList = l1Var.b;
            Intrinsics.checkNotNullParameter(loggingList, "loggingList");
            String value = Json.INSTANCE.encodeToString(BuiltinSerializersKt.ListSerializer(j3.Companion.serializer()), loggingList);
            w3 w3Var = z0Var.f593a;
            w3Var.getClass();
            Intrinsics.checkNotNullParameter("LS-MS-K", "key");
            Intrinsics.checkNotNullParameter(value, "value");
            v3.a(w3Var.f586a, value, "LS-MS-K");
        }
    }
}
