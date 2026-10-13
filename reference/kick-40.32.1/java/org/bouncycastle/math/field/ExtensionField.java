package org.bouncycastle.math.field;

/* JADX INFO: loaded from: classes11.dex */
public interface ExtensionField extends FiniteField {
    int getDegree();

    FiniteField getSubfield();
}
