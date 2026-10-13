package com.pusher.client;

/* JADX INFO: loaded from: classes8.dex */
public class AuthenticationFailureException extends RuntimeException {
    private static final long serialVersionUID = -7208133561904200801L;

    public AuthenticationFailureException() {
    }

    public AuthenticationFailureException(String str) {
        super(str);
    }

    public AuthenticationFailureException(Exception exc) {
        super(exc);
    }

    public AuthenticationFailureException(String str, Exception exc) {
        super(str, exc);
    }
}
