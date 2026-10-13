package com.google.firebase.auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class FirebaseAuthMissingActivityForRecaptchaException extends FirebaseAuthException {
    public FirebaseAuthMissingActivityForRecaptchaException() {
        super("ERROR_MISSING_ACTIVITY", "App verification failed - a valid Activity is required to complete the Recaptcha flow");
    }
}
