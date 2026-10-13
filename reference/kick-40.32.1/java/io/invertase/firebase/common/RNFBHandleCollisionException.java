package io.invertase.firebase.common;

/* JADX INFO: loaded from: classes9.dex */
public class RNFBHandleCollisionException extends Exception {
    public RNFBHandleCollisionException(Object obj) {
        super("Handle id already registered: " + obj);
    }
}
