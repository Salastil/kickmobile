package org.h.s;

import com.google.gson.Gson;
import io.mobileshield.sdk.MobileShield;
import io.mobileshield.sdk.Priority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class q4 extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562a;
    public final r4 b;
    public final String c;
    public final ArrayList d;
    public final long e;
    public long f;
    public long g;
    public long h;
    public String i;
    public final z1 j;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ q4(r4 r4Var, String str, int i) {
        String string;
        if ((i & 1) != 0) {
            string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        } else {
            string = null;
        }
        if ((i & 4) != 0) {
            str = r4Var.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        }
        this(string, r4Var, str);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00fd  */
    @Override // org.h.s.j
    public final String a() {
        String strA;
        String str = this.i;
        if (str != null) {
            return str;
        }
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(this.f562a, o4.TRACE_ID), TuplesKt.to(this.c, o4.LABEL), TuplesKt.to(this.b, o4.TYPE), TuplesKt.to(Long.valueOf(this.g), o4.DURATION_MS), TuplesKt.to(this.d, o4.SPANS), TuplesKt.to(this.j, o4.METADATA));
        ArrayList arrayList = new ArrayList(mapMapOf.size());
        for (Map.Entry entry : mapMapOf.entrySet()) {
            Object key = entry.getKey();
            o4 o4Var = (o4) entry.getValue();
            int iOrdinal = o4Var.ordinal();
            if (iOrdinal == 0) {
                strA = a2.a(String.valueOf(key), o4Var.ordinal());
            } else if (iOrdinal == 1) {
                int iOrdinal2 = o4Var.ordinal();
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type io.mobileshield.sdk.global.performance.TraceType");
                strA = a2.a(String.valueOf(((r4) key).ordinal()), iOrdinal2);
            } else if (iOrdinal == 2 || iOrdinal == 3) {
                strA = a2.a(String.valueOf(key), o4Var.ordinal());
            } else {
                strA = "";
                if (iOrdinal != 4) {
                    if (iOrdinal != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (key != null) {
                        int iOrdinal3 = o4Var.ordinal();
                        String json = new Gson().toJson((z1) key);
                        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                        String strA2 = a2.a(json, iOrdinal3);
                        if (strA2 != null) {
                            strA = strA2;
                        }
                    }
                } else if ((key instanceof List) && !((Collection) key).isEmpty()) {
                    strA = o4Var.ordinal() + CollectionsKt.joinToString$default((Iterable) key, "v", null, null, 0, null, p4.f556a, 30, null);
                }
            }
            arrayList.add(strA);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, "u", null, null, 0, null, null, 62, null);
        this.i = strJoinToString$default;
        return strJoinToString$default;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q4)) {
            return false;
        }
        q4 q4Var = (q4) obj;
        return Intrinsics.areEqual(this.f562a, q4Var.f562a) && this.b == q4Var.b && Intrinsics.areEqual(this.c, q4Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f562a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "Trace(traceId=" + this.f562a + ", type=" + this.b + ", label=" + this.c + ")";
    }

    public q4(String traceId, r4 type, String label) {
        Priority priorityA;
        String strName;
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(label, "label");
        this.f562a = traceId;
        this.b = type;
        this.c = label;
        this.d = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.e = jCurrentTimeMillis;
        this.h = jCurrentTimeMillis;
        r0 sdkMobileShield$sdk_release = MobileShield.INSTANCE.getSdkMobileShield$sdk_release();
        this.j = new z1((sdkMobileShield$sdk_release == null || (priorityA = sdkMobileShield$sdk_release.a()) == null || (strName = priorityA.name()) == null) ? "low" : strName);
    }
}
