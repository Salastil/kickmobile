package com.useinsider.insider;

import expo.modules.notifications.serverregistration.InstallationId;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class InsiderIdentifiers {
    private Map<String, String> identifiers = new ConcurrentHashMap();

    public InsiderIdentifiers addCustomIdentifier(String str, String str2) {
        if (str != null && str2 != null && str2.length() != 0 && w4.d(str)) {
            this.identifiers.put("c_" + str, str2);
        }
        return this;
    }

    public InsiderIdentifiers addEmail(String str) {
        if (str != null && str.length() != 0 && w4.c(str)) {
            this.identifiers.put("em", str);
        }
        return this;
    }

    public InsiderIdentifiers addPhoneNumber(String str) {
        if (str != null && str.length() != 0 && w4.f(str)) {
            this.identifiers.put("pn", str);
        }
        return this;
    }

    public InsiderIdentifiers addUserID(String str) {
        if (str != null && str.length() != 0) {
            this.identifiers.put(InstallationId.LEGACY_PREFERENCES_UUID_KEY, str);
        }
        return this;
    }

    Map<String, String> getIdentifiers() {
        return this.identifiers;
    }
}
