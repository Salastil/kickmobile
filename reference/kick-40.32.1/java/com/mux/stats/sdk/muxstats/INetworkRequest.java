package com.mux.stats.sdk.muxstats;

import java.net.URL;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public interface INetworkRequest {

    @Deprecated
    public interface IMuxNetworkRequestsCompletion {
        void onComplete(boolean z);
    }

    public interface IMuxNetworkRequestsCompletion2 {
        void onComplete(boolean z, Map<String, List<String>> map);
    }

    void get(URL url);

    void post(URL url, JSONObject jSONObject, Hashtable<String, String> hashtable);

    default void postWithCompletion(String str, String str2, String str3, Hashtable<String, String> hashtable, final IMuxNetworkRequestsCompletion2 iMuxNetworkRequestsCompletion2) {
        postWithCompletion(str, str2, str3, hashtable, new IMuxNetworkRequestsCompletion() { // from class: com.mux.stats.sdk.muxstats.INetworkRequest$$ExternalSyntheticLambda0
            @Override // com.mux.stats.sdk.muxstats.INetworkRequest.IMuxNetworkRequestsCompletion
            public final void onComplete(boolean z) {
                iMuxNetworkRequestsCompletion2.onComplete(z, null);
            }
        });
    }

    void postWithCompletion(String str, String str2, String str3, Hashtable<String, String> hashtable, IMuxNetworkRequestsCompletion iMuxNetworkRequestsCompletion);
}
