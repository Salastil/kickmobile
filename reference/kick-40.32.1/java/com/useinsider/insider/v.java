package com.useinsider.insider;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static x f434a;

    public static synchronized x a() {
        if (f434a == null) {
            f434a = y.b();
        }
        return f434a;
    }

    public static void a(InsiderAppCardAction insiderAppCardAction) {
        if (insiderAppCardAction == null) {
            a("[AppCard][ActionHandler] Cannot execute action: action is null", 6);
            return;
        }
        String type = insiderAppCardAction.getType();
        if (type != null && !type.isEmpty()) {
            type.hashCode();
            switch (type) {
                case "deep_link":
                    a((InsiderAppCardDeeplinkAction) insiderAppCardAction);
                    break;
                case "open_settings":
                    a((InsiderAppCardAppSettingsAction) insiderAppCardAction);
                    break;
                case "feedback":
                    a((InsiderAppCardAppReviewAction) insiderAppCardAction);
                    break;
                default:
                    a("[AppCard][ActionHandler] Unknown action type: " + type, 5);
                    break;
            }
            return;
        }
        a("[AppCard][ActionHandler] Cannot execute action: action type is null or empty", 6);
    }

    private static void a(InsiderAppCardDeeplinkAction insiderAppCardDeeplinkAction) {
        if (insiderAppCardDeeplinkAction == null) {
            a("[AppCard][ActionHandler] Cannot execute deeplink action: action is null", 6);
            return;
        }
        String url = insiderAppCardDeeplinkAction.getUrl();
        if (url != null && !url.isEmpty()) {
            String deeplinkURLType = insiderAppCardDeeplinkAction.getDeeplinkURLType();
            x xVarA = a();
            if ("external".equals(deeplinkURLType)) {
                a("[AppCard][ActionHandler] Executing deeplink action: Opening external URL in default browser: " + url, 4);
                xVarA.a(url);
                return;
            }
            if ("internal".equals(deeplinkURLType)) {
                a("[AppCard][ActionHandler] Executing deeplink action: Opening internal URL in internal browser: " + url, 4);
                xVarA.c(url);
                return;
            }
            if ("url_scheme".equals(deeplinkURLType)) {
                a("[AppCard][ActionHandler] Executing deeplink action: Opening URL scheme: " + url, 4);
                xVarA.b(url);
                return;
            }
            a("[AppCard][ActionHandler] Unknown url type: " + deeplinkURLType, 5);
            return;
        }
        a("[AppCard][ActionHandler] Cannot execute deeplink action: deeplinkURL is null or empty", 4);
    }

    private static void a(InsiderAppCardAppReviewAction insiderAppCardAppReviewAction) {
        if (insiderAppCardAppReviewAction == null) {
            a("[AppCard][ActionHandler] Cannot execute app review action: action is null", 6);
            return;
        }
        a("[AppCard][ActionHandler] Executing app review action: Triggering native rating dialog", 4);
        try {
            Insider.Instance.showNativeRating();
        } catch (Exception e) {
            Insider.Instance.putException(e);
            a("[AppCard][ActionHandler] Failed to show native rating: " + e.getMessage(), 6);
        }
    }

    private static void a(InsiderAppCardAppSettingsAction insiderAppCardAppSettingsAction) {
        if (insiderAppCardAppSettingsAction == null) {
            a("[AppCard][ActionHandler] Cannot execute app settings action: action is null", 6);
        } else {
            a("[AppCard][ActionHandler] Executing app settings action: Opening app settings", 4);
            a().a();
        }
    }

    private static void a(String str, int i) {
        try {
            if (i == 5) {
                f3.c("app_cards", str, new JSONObject(), "InsiderAppCardActionHandler-logMessage");
            } else if (i != 6) {
                f3.b("app_cards", str, new JSONObject(), "InsiderAppCardActionHandler-logMessage");
            } else {
                f3.a("app_cards", str, new JSONObject(), "InsiderAppCardActionHandler-logMessage");
            }
            Debugger.putLog(DebuggingTag.appCardsRunAction, i, str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
