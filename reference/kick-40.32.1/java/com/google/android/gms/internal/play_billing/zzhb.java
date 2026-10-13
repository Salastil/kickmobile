package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzhb extends IOException {
    public zzhb(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public zzhb(String str) {
        super(str);
    }
}
