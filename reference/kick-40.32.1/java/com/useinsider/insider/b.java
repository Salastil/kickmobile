package com.useinsider.insider;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
enum b {
    APP_TEMPLATE_NOT_FOUND("App template not found"),
    APP_TEMPLATE_NOT_FOUND_IN_STORED_DATA("App template not found in stored data"),
    APP_TEMPLATE_EVENT_TRIGGER_COUNT_NOT_MATCH("App template event trigger count not match"),
    FREQUENCY_IS_CAPPED("Frequency is capped"),
    CURRENT_ACTIVITY_NOT_SUITABLE("Current activity not suitable"),
    APP_TEMPLATE_LIST_IS_EMPTY("App template list is empty"),
    NO_APP_TEMPLATE_FOUND_MATCHING_EVENT("No app template found matching event"),
    KEYBOARD_IS_OPEN("Keyboard is visible. In-app message will not be shown."),
    NO_AVAILABLE_APP_TEMPLATE_FOUND("No available app template found"),
    DECORVIEW_OR_INSIDER_LAYOUT_NOT_SUITABLE("Decorview or Insider layout not suitable"),
    INFLATED_LAYOUT_NOT_SUITABLE("Inflated layout not suitable"),
    DECORVIEW_OR_INSIDER_LAYOUT_NOT_SUITABLE_IN_CONTENT("Decorview or Insider layout not suitable in content"),
    IMPRESSION_OR_INCREMENT_COUNT_IS_INCORRECT("Impression or increment count is incorrect"),
    OTHER_APP_TEMPLATE_ON_SCREEN("Other app template on screen"),
    TEMPLATE_REQUEST_FAILED("Template request failed"),
    TEMPLATE_REQUEST_SUCCESSFULLY_COMPLETED("Template request successfully completed"),
    TEMPLATE_ADDED_TO_DECORVIEW_SUCCESSFULLY("Template added to decorview successfully"),
    IN_APP_MESSAGES_DISABLED("In-app messages disabled");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f313a;

    b(String str) {
        this.f313a = str;
    }

    public String b() {
        return this.f313a;
    }
}
