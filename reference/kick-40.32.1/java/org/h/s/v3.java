package org.h.s;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class v3 {
    public static final void a(SharedPreferences sharedPreferences, String valueToStore, String sharedPrefKey) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(valueToStore, "valueToStore");
        Intrinsics.checkNotNullParameter(sharedPrefKey, "sharedPrefKey");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(sharedPrefKey, valueToStore);
        editorEdit.apply();
    }
}
