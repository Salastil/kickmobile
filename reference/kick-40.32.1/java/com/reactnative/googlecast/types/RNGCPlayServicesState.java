package com.reactnative.googlecast.types;

import com.facebook.hermes.intl.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes8.dex */
public class RNGCPlayServicesState {
    public static int fromJson(String str) {
        str.hashCode();
        switch (str) {
            case "success":
                return 0;
            case "disabled":
                return 3;
            case "updateRequired":
                return 2;
            case "missing":
                return 1;
            case "updating":
                return 18;
            case "invalid":
                return 9;
            default:
                return -1;
        }
    }

    public static String toJson(int i) {
        if (i == 0) {
            return FirebaseAnalytics.Param.SUCCESS;
        }
        if (i == 1) {
            return "missing";
        }
        if (i == 2) {
            return "updateRequired";
        }
        if (i == 3) {
            return "disabled";
        }
        if (i == 9) {
            return Constants.COLLATION_INVALID;
        }
        if (i != 18) {
            return null;
        }
        return "updating";
    }
}
