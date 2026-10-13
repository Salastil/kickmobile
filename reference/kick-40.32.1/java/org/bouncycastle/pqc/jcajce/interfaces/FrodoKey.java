package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.pqc.jcajce.spec.FrodoParameterSpec;

/* JADX INFO: loaded from: classes11.dex */
public interface FrodoKey extends Key {
    FrodoParameterSpec getParameterSpec();
}
