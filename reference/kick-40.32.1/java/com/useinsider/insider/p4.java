package com.useinsider.insider;

import com.facebook.hermes.intl.Constants;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
enum p4 {
    SESSION_STOP_REQUEST_REASON_SESSION_STOP(Constants.COLLATION_DEFAULT),
    SESSION_STOP_REQUEST_REASON_INSIDER_ID_CHANGE("login"),
    SESSION_STOP_REQUEST_REASON_PARTNER_NAME_CHANGE("reinit"),
    SESSION_STOP_REQUEST_REASON_FLUSH("flush"),
    SESSION_STOP_REQUEST_REASON_LOGOUT(InsiderHybridMethods.LOGOUT);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f413a;

    p4(String str) {
        this.f413a = str;
    }

    public String b() {
        return this.f413a;
    }
}
