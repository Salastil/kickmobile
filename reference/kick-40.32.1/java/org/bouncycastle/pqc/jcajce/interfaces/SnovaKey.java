package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.pqc.jcajce.spec.SnovaParameterSpec;

/* JADX INFO: loaded from: classes11.dex */
public interface SnovaKey extends Key {
    SnovaParameterSpec getParameterSpec();
}
