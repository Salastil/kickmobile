package com.useinsider.insider;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
enum u2 {
    STRING(TypedValues.Custom.S_STRING),
    NUMBER("number"),
    BOOLEAN(TypedValues.Custom.S_BOOLEAN),
    DATE("datetime"),
    STRINGS("strings"),
    NUMBERS("numbers"),
    UNDEFINED("undefined");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f431a;

    u2(String str) {
        this.f431a = str;
    }

    String b() {
        return this.f431a;
    }

    static u2 a(String str) {
        for (u2 u2Var : values()) {
            if (u2Var.f431a.equalsIgnoreCase(str)) {
                return u2Var;
            }
        }
        return UNDEFINED;
    }
}
