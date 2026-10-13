package com.amazonaws.ivs.player;

import android.os.Handler;
import android.os.Looper;
import com.amazonaws.ivs.player.IVSFeature.IVSConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
abstract class IVSFeature<Config extends IVSConfig<Config>> implements Configurable {
    final IVSConfig<Config> config;
    boolean isEnabled;
    final String key;
    private final Handler reporterHandler;
    protected Platform platform = null;
    ErrorListener errorListener = null;
    EventListener eventListener = null;
    protected long nativeHandle = 0;

    interface ErrorListener {
        void onError(Exception exc);

        void onRecoverableError(Exception exc);
    }

    interface EventListener {
        void onEvent(Object obj);
    }

    private native String getJsonPayloadFromCriteria(String str, String str2);

    public static abstract class IVSConfig<Impl extends IVSConfig<Impl>> implements ConfigurationParser.Encodable {
        Impl asImpl() {
            return this;
        }

        @Override // com.amazonaws.ivs.player.ConfigurationParser.Encodable
        public void updateWithJson(JSONObject jSONObject) throws JSONException {
            ConfigurationParser.updateConfigurationFromJson(jSONObject, asImpl());
        }

        @Override // com.amazonaws.ivs.player.ConfigurationParser.Encodable
        public JSONObject toJson() throws JSONException {
            return ConfigurationParser.createJsonFromConfiguration(asImpl());
        }
    }

    IVSFeature(String str, IVSConfig<Config> iVSConfig) {
        this.isEnabled = false;
        this.isEnabled = !(this instanceof Experimental);
        if (Looper.myLooper() != null) {
            this.reporterHandler = new Handler(Looper.myLooper());
        } else {
            this.reporterHandler = new Handler(Looper.getMainLooper());
        }
        this.key = str;
        this.config = iVSConfig;
    }

    String getPropertyHolderKey() {
        return this.key;
    }

    JSONObject overrideWithPayload(DeviceConfigPropertyHolder deviceConfigPropertyHolder) throws JSONException {
        String propertyHolderKey = getPropertyHolderKey();
        if (propertyHolderKey.isEmpty()) {
            return null;
        }
        if (deviceConfigPropertyHolder == null) {
            this.isEnabled = false;
            return null;
        }
        JSONObject jsonObjectValue = deviceConfigPropertyHolder.getJsonObjectValue(propertyHolderKey);
        if (jsonObjectValue == null) {
            this.isEnabled = false;
            return null;
        }
        String jsonPayloadFromCriteria = getJsonPayloadFromCriteria(jsonObjectValue.toString(), getCriteriaForFeature().toString());
        if (jsonPayloadFromCriteria.isEmpty()) {
            this.isEnabled = false;
            return null;
        }
        JSONObject jSONObject = new JSONObject(jsonPayloadFromCriteria);
        overrideWith(jSONObject);
        return jSONObject;
    }

    void registerEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    void registerErrorListener(ErrorListener errorListener) {
        this.errorListener = errorListener;
    }

    void init(Platform platform) {
        this.platform = platform;
    }

    JSONObject getCriteriaForFeature() throws JSONException {
        return new JSONObject();
    }

    long getNativeHandle() {
        return this.nativeHandle;
    }

    protected void reportError(final RuntimeException runtimeException) {
        if (this.errorListener != null) {
            this.reporterHandler.post(new Runnable() { // from class: com.amazonaws.ivs.player.IVSFeature$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11061lambda$reportError$0$comamazonawsivsplayerIVSFeature(runtimeException);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$reportError$0$com-amazonaws-ivs-player-IVSFeature, reason: not valid java name */
    /* synthetic */ void m11061lambda$reportError$0$comamazonawsivsplayerIVSFeature(RuntimeException runtimeException) {
        this.errorListener.onError(runtimeException);
    }

    protected void reportAnalyticsEvent(final Object obj) {
        if (this.eventListener != null) {
            this.reporterHandler.post(new Runnable() { // from class: com.amazonaws.ivs.player.IVSFeature$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11060xadb73563(obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$reportAnalyticsEvent$1$com-amazonaws-ivs-player-IVSFeature, reason: not valid java name */
    /* synthetic */ void m11060xadb73563(Object obj) {
        this.eventListener.onEvent(obj);
    }
}
