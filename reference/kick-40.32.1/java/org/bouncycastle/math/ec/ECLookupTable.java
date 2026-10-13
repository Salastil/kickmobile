package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes11.dex */
public interface ECLookupTable {
    int getSize();

    ECPoint lookup(int i);

    ECPoint lookupVar(int i);
}
