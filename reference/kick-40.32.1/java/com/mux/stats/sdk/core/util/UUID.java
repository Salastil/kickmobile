package com.mux.stats.sdk.core.util;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes8.dex */
public class UUID {
    public static String generateUUID() {
        return maskUuid(java.util.UUID.randomUUID(), System.currentTimeMillis()).toString();
    }

    protected static java.util.UUID maskUuid(java.util.UUID uuid, long j) {
        long leastSignificantBits = uuid.getLeastSignificantBits();
        return new java.util.UUID(uuid.getMostSignificantBits(), (j & 4294967295L) | (leastSignificantBits & (-4294967296L)));
    }

    public static String shortUUID() {
        String str = "000000" + Integer.toString(new SecureRandom().nextInt(), 36);
        return str.substring(str.length() - 6);
    }
}
