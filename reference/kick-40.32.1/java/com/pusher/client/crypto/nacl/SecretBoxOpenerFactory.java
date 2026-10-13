package com.pusher.client.crypto.nacl;

/* JADX INFO: loaded from: classes8.dex */
public class SecretBoxOpenerFactory {
    public SecretBoxOpener create(byte[] bArr) {
        return new SecretBoxOpener(bArr);
    }
}
