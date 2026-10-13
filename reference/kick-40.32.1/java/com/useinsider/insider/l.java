package com.useinsider.insider;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
enum l {
    STRING((byte) 1),
    INT((byte) 2),
    LONG((byte) 3),
    FLOAT((byte) 4),
    BOOLEAN((byte) 5);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f350a;

    l(byte b) {
        this.f350a = b;
    }

    public byte[] b() {
        return new byte[]{this.f350a};
    }

    public static l a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            for (l lVar : values()) {
                if (Arrays.equals(lVar.b(), bArr)) {
                    return lVar;
                }
            }
        }
        return null;
    }
}
