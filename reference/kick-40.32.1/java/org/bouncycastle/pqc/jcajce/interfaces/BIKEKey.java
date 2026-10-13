package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.pqc.jcajce.spec.BIKEParameterSpec;

/* JADX INFO: loaded from: classes11.dex */
public interface BIKEKey extends Key {
    BIKEParameterSpec getParameterSpec();
}
