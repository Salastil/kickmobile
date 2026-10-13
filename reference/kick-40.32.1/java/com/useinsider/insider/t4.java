package com.useinsider.insider;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class t4 {
    static void a(Map map) {
        try {
            InsiderEvent insiderEventTagEvent = Insider.Instance.tagEvent("sign_up_confirmation");
            if (map != null && !map.isEmpty()) {
                insiderEventTagEvent.addParameters(map);
            }
            insiderEventTagEvent.build();
            Debugger.a(DebuggingTag.signUpConfirmation, 4);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
