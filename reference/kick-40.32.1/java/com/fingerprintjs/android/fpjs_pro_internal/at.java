package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.collection.SieveCacheKt;

/* JADX INFO: loaded from: classes6.dex */
public final class at {
    public static final Integer setPivotYN16904(long j) {
        if (SieveCacheKt.NodeMetaAndPreviousMask > j || j > SieveCacheKt.NodeLinkMask) {
            return null;
        }
        return Integer.valueOf((int) j);
    }
}
