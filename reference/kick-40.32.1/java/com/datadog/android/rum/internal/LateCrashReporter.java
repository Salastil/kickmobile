package com.datadog.android.rum.internal;

import android.app.ApplicationExitInfo;
import com.datadog.android.api.storage.DataWriter;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: LateCrashReporter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b`\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH'J&\u0010\n\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH&¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/internal/LateCrashReporter;", "", "handleAnrCrash", "", "anrExitInfo", "Landroid/app/ApplicationExitInfo;", "lastRumViewEventJson", "Lcom/google/gson/JsonObject;", "rumWriter", "Lcom/datadog/android/api/storage/DataWriter;", "handleNdkCrashEvent", "event", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LateCrashReporter {
    void handleAnrCrash(ApplicationExitInfo anrExitInfo, JsonObject lastRumViewEventJson, DataWriter<Object> rumWriter);

    void handleNdkCrashEvent(Map<?, ?> event, DataWriter<Object> rumWriter);
}
