package com.amazonaws.ivs.player;

import java.util.ArrayList;

/* JADX INFO: compiled from: GLManager.java */
/* JADX INFO: loaded from: classes5.dex */
final class GLException extends RuntimeException {
    ArrayList<GLError> errors;

    GLException() {
        this.errors = new ArrayList<>();
    }

    GLException(GLError gLError) {
        this();
        appendError(gLError);
    }

    void appendError(GLError gLError) {
        this.errors.add(gLError);
    }

    void appendErrors(GLException gLException) {
        this.errors.addAll(gLException.errors);
    }
}
