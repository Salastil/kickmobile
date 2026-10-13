package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeInfo;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzu extends ActionCodeInfo {
    public zzu(String str) {
        this.email = Preconditions.checkNotEmpty(str);
    }
}
