package com.useinsider.insider;

import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
enum w3 {
    SESSION_START("/api/v4/session/start"),
    SESSION_STOP("/api/v3/session/stop"),
    ADD_TEST_DEVICE("/api/v1/test_device/add"),
    WIZARD_INIT("/api/gandalf/v2/start_connection"),
    WIZARD_FEED("/api/gandalf/v2/live_push"),
    WIZARD_TERMINATE("/api/gandalf/v2/stop_connection"),
    MESSAGE_CENTER("/api/message_center/v2/sdk/get"),
    AMPLIFICATION("/api/amplification/v1/poll"),
    GET_GEOFENCES("/api/v1/geofences"),
    GET_GEOFENCES_NOTIFY("/api/v1/geofences/notify"),
    GDPR_CONSENT_SET("/api/v1/privacy/gdpr/consent/set"),
    IDENTITY("/api/identity/v3/get");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f441a;

    w3(String str) {
        this.f441a = str;
    }

    String b() {
        return a(TextUtils.isEmpty(e.f325a) ? "https://mobile.useinsider.com" : e.f325a, this.f441a);
    }

    private static String a(String str, String str2) {
        return str.trim().replaceAll("/+$", "") + (DomExceptionUtils.SEPARATOR + str2.trim().replaceAll("^/+", ""));
    }
}
