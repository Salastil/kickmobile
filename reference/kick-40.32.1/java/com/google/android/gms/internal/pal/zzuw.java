package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public enum zzuw implements zzaur {
    PURPOSE_RESTRICTION_NOT_ALLOWED(0),
    PURPOSE_RESTRICTION_REQUIRE_CONSENT(1),
    PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST(2),
    PURPOSE_RESTRICTION_UNDEFINED(3),
    UNRECOGNIZED(-1);

    private final int zzf;

    zzuw(int i) {
        this.zzf = i;
    }

    public static zzuw zzb(int i) {
        if (i == 0) {
            return PURPOSE_RESTRICTION_NOT_ALLOWED;
        }
        if (i == 1) {
            return PURPOSE_RESTRICTION_REQUIRE_CONSENT;
        }
        if (i == 2) {
            return PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
        }
        if (i != 3) {
            return null;
        }
        return PURPOSE_RESTRICTION_UNDEFINED;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzf);
    }

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzf;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
