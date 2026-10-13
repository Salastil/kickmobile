package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes10.dex */
public interface CryptoServiceProperties {
    int bitsOfSecurity();

    Object getParams();

    CryptoServicePurpose getPurpose();

    String getServiceName();
}
