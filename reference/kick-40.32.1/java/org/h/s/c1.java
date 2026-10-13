package org.h.s;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;

/* JADX INFO: loaded from: classes11.dex */
@Serializable
public final class c1 {
    public static final b1 Companion = new b1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f492a;
    public final int b;
    public final String c;

    public /* synthetic */ c1(int i, String str, int i2, String str2) {
        if (5 != (i & 5)) {
            PluginExceptionsKt.throwMissingFieldException(i, 5, a1.f487a.getDescriptor());
        }
        this.f492a = str;
        if ((i & 2) == 0) {
            this.b = 1;
        } else {
            this.b = i2;
        }
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return Intrinsics.areEqual(this.f492a, c1Var.f492a) && this.b == c1Var.b && Intrinsics.areEqual(this.c, c1Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((Integer.hashCode(this.b) + (this.f492a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "LogPayload(key=" + this.f492a + ", schemaVersion=" + this.b + ", logs=" + this.c + ")";
    }

    public c1(String key, int i, String logs) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(logs, "logs");
        this.f492a = key;
        this.b = i;
        this.c = logs;
    }

    public /* synthetic */ c1(String str, String str2) {
        this(str, 1, str2);
    }
}
