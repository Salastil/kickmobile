package j$.time.chrono;

import j$.time.Month;

/* JADX INFO: loaded from: classes3.dex */
public enum IsoEra implements Era {
    BCE,
    CE;

    public static IsoEra of(int i) {
        if (i == 0) {
            return BCE;
        }
        if (i == 1) {
            return CE;
        }
        Month.AnonymousClass0.m("Invalid era: ", i);
        return null;
    }

    @Override // j$.time.chrono.Era
    public int getValue() {
        return ordinal();
    }
}
