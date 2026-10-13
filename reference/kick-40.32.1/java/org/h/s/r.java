package org.h.s;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f563a;
    public final String b;
    public final String c;
    public final int d;

    public r(String str, String str2, String str3, int i) {
        this.f563a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Intrinsics.areEqual(this.f563a, rVar.f563a) && Intrinsics.areEqual(this.b, rVar.b) && Intrinsics.areEqual(this.c, rVar.c) && this.d == rVar.d;
    }

    public final int hashCode() {
        String str = this.f563a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        return Integer.hashCode(this.d) + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "DataFromResponse(newTokenString=" + this.f563a + ", newReinterrogationTimeoutString=" + this.b + ", newServerOffsetEncrypted=" + this.c + ", statusCode=" + this.d + ")";
    }
}
