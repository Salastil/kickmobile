package org.bouncycastle.pqc.crypto.ntru;

import org.bouncycastle.pqc.math.ntru.Polynomial;

/* JADX INFO: loaded from: classes11.dex */
class PolynomialPair {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Polynomial f479a;
    private final Polynomial b;

    public PolynomialPair(Polynomial polynomial, Polynomial polynomial2) {
        this.f479a = polynomial;
        this.b = polynomial2;
    }

    public Polynomial f() {
        return this.f479a;
    }

    public Polynomial g() {
        return this.b;
    }

    public Polynomial m() {
        return this.b;
    }

    public Polynomial r() {
        return this.f479a;
    }
}
