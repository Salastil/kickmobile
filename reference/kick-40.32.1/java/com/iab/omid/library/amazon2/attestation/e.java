package com.iab.omid.library.amazon2.attestation;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d f178a = new d();

    public static void a(Context context, String str, a aVar) {
        StringBuilder sb;
        String str2;
        if (context == null) {
            str2 = "Attestation failed: Application Context cannot be null";
        } else if (str != null) {
            try {
                if (str.trim().isEmpty()) {
                    str2 = "Attestation failed: Mechanism name cannot be null or empty";
                } else {
                    if (aVar != null) {
                        if (c.a(context).a(str)) {
                            b bVarA = f178a.a(str, context);
                            if (bVarA != null) {
                                bVarA.a(aVar);
                                return;
                            } else {
                                sb = new StringBuilder("Failed to create mechanism: ");
                                sb.append(str);
                            }
                        } else {
                            sb = new StringBuilder("Mechanism not supported on this device: ");
                            sb.append(str);
                        }
                        com.iab.omid.library.amazon2.utils.d.d(sb.toString());
                        return;
                    }
                    str2 = "Attestation failed: Attestation arguments cannot be null";
                }
            } catch (Exception e) {
                com.iab.omid.library.amazon2.utils.d.a("Error during attestation with mechanism: " + str, e);
                return;
            }
        } else {
            str2 = "Attestation failed: Mechanism name cannot be null or empty";
        }
        com.iab.omid.library.amazon2.utils.d.b(str2);
    }
}
