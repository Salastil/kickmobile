package org.h.s;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends z0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SharedPreferences sharedPreferences) {
        super(new w3(sharedPreferences));
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
    }
}
