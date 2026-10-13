package j$.time.chrono;

import j$.time.Month;

/* JADX INFO: loaded from: classes3.dex */
public enum ThaiBuddhistEra implements Era {
    BEFORE_BE,
    BE;

    public static ThaiBuddhistEra of(int i) {
        if (i == 0) {
            return BEFORE_BE;
        }
        if (i == 1) {
            return BE;
        }
        Month.AnonymousClass0.m("Invalid era: ", i);
        return null;
    }

    @Override // j$.time.chrono.Era
    public int getValue() {
        return ordinal();
    }
}
