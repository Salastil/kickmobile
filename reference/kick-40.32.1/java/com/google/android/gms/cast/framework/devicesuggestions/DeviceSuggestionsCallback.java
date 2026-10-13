package com.google.android.gms.cast.framework.devicesuggestions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface DeviceSuggestionsCallback {
    void onDeviceSuggestionExpired(DeviceSuggestionResult deviceSuggestionResult);

    void onDeviceSuggestionReceived(DeviceSuggestionResult deviceSuggestionResult);
}
