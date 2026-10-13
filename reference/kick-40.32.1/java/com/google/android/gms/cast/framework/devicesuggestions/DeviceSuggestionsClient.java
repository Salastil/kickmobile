package com.google.android.gms.cast.framework.devicesuggestions;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface DeviceSuggestionsClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    Task<Void> clearClientData();

    Task<Void> registerCallback(DeviceSuggestionsCallback deviceSuggestionsCallback);

    Task<Void> requestDeviceSuggestions();

    Task<Boolean> unregisterCallback(DeviceSuggestionsCallback deviceSuggestionsCallback);
}
