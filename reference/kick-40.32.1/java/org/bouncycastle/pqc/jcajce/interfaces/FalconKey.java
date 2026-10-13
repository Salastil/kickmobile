package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.pqc.jcajce.spec.FalconParameterSpec;

/* JADX INFO: loaded from: classes11.dex */
public interface FalconKey extends Key {
    FalconParameterSpec getParameterSpec();
}
