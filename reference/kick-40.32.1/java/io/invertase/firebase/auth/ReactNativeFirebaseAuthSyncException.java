package io.invertase.firebase.auth;

/* JADX INFO: loaded from: classes9.dex */
public class ReactNativeFirebaseAuthSyncException extends RuntimeException {
    private final String code;

    public ReactNativeFirebaseAuthSyncException(String str, String str2) {
        super(str2);
        this.code = str;
    }

    public String getCode() {
        return this.code;
    }
}
