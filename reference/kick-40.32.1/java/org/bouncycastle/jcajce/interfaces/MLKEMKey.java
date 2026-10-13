package org.bouncycastle.jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.jcajce.spec.MLKEMParameterSpec;

/* JADX INFO: loaded from: classes10.dex */
public interface MLKEMKey extends Key {
    MLKEMParameterSpec getParameterSpec();
}
