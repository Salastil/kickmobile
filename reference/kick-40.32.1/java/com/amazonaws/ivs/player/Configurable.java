package com.amazonaws.ivs.player;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
interface Configurable {
    void overrideWith(Experiments experiments) throws JSONException;

    void overrideWith(JSONObject jSONObject) throws JSONException;
}
