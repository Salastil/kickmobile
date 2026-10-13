package org.h.s;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;

/* JADX INFO: loaded from: classes11.dex */
@Serializable
public final class j3 {
    public static final i3 Companion = new i3();
    public static final KSerializer[] e = {null, EnumsKt.createAnnotatedEnumSerializer("org.h.s.x0", x0.values(), new String[]{"0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D}, new Annotation[][]{null, null, null, null}, null), null, null};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527a;
    public final x0 b;
    public final String c;
    public final long d;

    public /* synthetic */ j3(int i, String str, x0 x0Var, String str2, long j) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, h3.f518a.getDescriptor());
        }
        this.f527a = str;
        this.b = x0Var;
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str2;
        }
        if ((i & 8) == 0) {
            this.d = Clock.System.INSTANCE.now().toEpochMilliseconds();
        } else {
            this.d = j;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j3)) {
            return false;
        }
        j3 j3Var = (j3) obj;
        return Intrinsics.areEqual(this.f527a, j3Var.f527a) && this.b == j3Var.b && Intrinsics.areEqual(this.c, j3Var.c) && this.d == j3Var.d;
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.f527a.hashCode() * 31)) * 31;
        String str = this.c;
        return Long.hashCode(this.d) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "RemoteLog(logName=" + this.f527a + ", logLevel=" + this.b + ", message=" + this.c + ", timestamp=" + this.d + ")";
    }

    public j3(String logName, x0 logLevel, String str, long j) {
        Intrinsics.checkNotNullParameter(logName, "logName");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        this.f527a = logName;
        this.b = logLevel;
        this.c = str;
        this.d = j;
    }
}
