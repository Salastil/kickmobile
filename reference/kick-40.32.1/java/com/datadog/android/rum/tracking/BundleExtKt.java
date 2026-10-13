package com.datadog.android.rum.tracking;

import android.os.BadParcelableException;
import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BundleExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003*\u0004\u0018\u00010\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"ARGUMENT_TAG", "", "convertToRumViewAttributes", "", "", "Landroid/os/Bundle;", "dd-sdk-android-rum_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BundleExtKt {
    public static final String ARGUMENT_TAG = "view.arguments";

    public static final Map<String, Object> convertToRumViewAttributes(Bundle bundle) {
        if (bundle == null) {
            return MapsKt.emptyMap();
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Set<String> setKeySet = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet()");
            for (String str : setKeySet) {
                linkedHashMap.put("view.arguments." + str, bundle.get(str));
            }
            return linkedHashMap;
        } catch (BadParcelableException unused) {
            return MapsKt.emptyMap();
        } catch (LinkageError unused2) {
            return MapsKt.emptyMap();
        }
    }
}
