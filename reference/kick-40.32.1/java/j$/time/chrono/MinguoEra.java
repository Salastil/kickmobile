package j$.time.chrono;

import j$.time.Month;

/* JADX INFO: loaded from: classes3.dex */
public enum MinguoEra implements Era {
    BEFORE_ROC,
    ROC;

    public static MinguoEra of(int i) {
        if (i == 0) {
            return BEFORE_ROC;
        }
        if (i == 1) {
            return ROC;
        }
        Month.AnonymousClass0.m("Invalid era: ", i);
        return null;
    }

    @Override // j$.time.chrono.Era
    public int getValue() {
        return ordinal();
    }
}
