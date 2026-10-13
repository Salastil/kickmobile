package com.amazonaws.ivs.player;

/* JADX INFO: compiled from: EGLManager.java */
/* JADX INFO: loaded from: classes5.dex */
final class EGLException extends RuntimeException {
    final int errorCode;
    final String message;

    EGLException(String str, int i) {
        this.message = str;
        this.errorCode = i;
    }
}
