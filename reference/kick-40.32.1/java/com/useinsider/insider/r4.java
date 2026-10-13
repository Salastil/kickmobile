package com.useinsider.insider;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
enum r4 {
    INSIDER_ATTRIBUTES("insider_attributes"),
    INSIDER_ID("insider_id"),
    PARTNER_NAME("partner_name"),
    UDID("udid"),
    STORED_LATEST_SESSION_DATA("stored_latest_session_data"),
    STORED_LATEST_CLICKED_PUSH_INTENT("stored_latest_clicked_push_intent"),
    DEBUG_MODE("debug_mode"),
    MOBILE_INSTALL_DATE("mobile_install_date");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f419a;

    r4(String str) {
        this.f419a = str;
    }

    public String b() {
        return this.f419a;
    }
}
