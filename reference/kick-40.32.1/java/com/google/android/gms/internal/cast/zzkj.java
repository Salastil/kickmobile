package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
enum zzkj {
    BOOLEAN,
    STRING,
    LONG,
    DOUBLE;

    static /* synthetic */ zzkj zza(Object obj) {
        if (obj instanceof String) {
            return STRING;
        }
        if (obj instanceof Boolean) {
            return BOOLEAN;
        }
        if (obj instanceof Long) {
            return LONG;
        }
        if (obj instanceof Double) {
            return DOUBLE;
        }
        String strValueOf = String.valueOf(obj.getClass());
        String.valueOf(strValueOf);
        throw new AssertionError("invalid tag type: ".concat(String.valueOf(strValueOf)));
    }
}
