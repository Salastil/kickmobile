package com.amazonaws.ivs.player;

import java.util.ArrayList;

/* JADX INFO: compiled from: GLManager.java */
/* JADX INFO: loaded from: classes5.dex */
final class GLError {
    String description;
    ArrayList<Integer> errorCodes = new ArrayList<>();

    GLError(String str) {
        this.description = str;
    }

    void appendErrorCode(int i) {
        this.errorCodes.add(Integer.valueOf(i));
    }
}
