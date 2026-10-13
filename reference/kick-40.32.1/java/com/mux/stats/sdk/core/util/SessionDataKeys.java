package com.mux.stats.sdk.core.util;

import com.google.common.collect.ImmutableMap;
import com.mux.stats.sdk.core.model.BaseQueryData;
import com.mux.stats.sdk.core.model.CustomData;
import com.mux.stats.sdk.core.model.CustomerPlayerData;
import com.mux.stats.sdk.core.model.CustomerVideoData;
import com.mux.stats.sdk.core.model.CustomerViewData;

/* JADX INFO: loaded from: classes8.dex */
public class SessionDataKeys {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ImmutableMap<String, a> f273a = new ImmutableMap.Builder().put("internal_view_session_id", new a(CustomerViewData.INTERNAL_VIEW_SESSION_ID, CustomerViewData.class)).put("internal_video_experiments", new a(CustomerViewData.INTERNAL_VIDEO_EXPERIMENTS, CustomerViewData.class)).put("video_experiments", new a(CustomerVideoData.VIDEO_EXPERIMENTS, CustomerVideoData.class)).put("video_id", new a(CustomerVideoData.VIDEO_ID, CustomerVideoData.class)).put("video_title", new a("vtt", CustomerVideoData.class)).put("video_cdn", new a("vdn", CustomerVideoData.class)).put("video_content_type", new a(CustomerVideoData.VIDEO_CONTENT_TYPE, CustomerVideoData.class)).put("video_duration", new a(CustomerVideoData.VIDEO_DURATION, CustomerVideoData.class)).put("video_encoding_variant", new a(CustomerVideoData.VIDEO_ENCODING_VARIANT, CustomerVideoData.class)).put("video_is_live", new a(CustomerVideoData.VIDEO_IS_LIVE, CustomerVideoData.class)).put("video_language_code", new a(CustomerVideoData.VIDEO_LANGUAGE_CODE, CustomerVideoData.class)).put("video_producer", new a(CustomerVideoData.VIDEO_PRODUCER, CustomerVideoData.class)).put("video_series", new a(CustomerVideoData.VIDEO_SERIES, CustomerVideoData.class)).put("video_stream_type", new a(CustomerVideoData.VIDEO_STREAM_TYPE, CustomerVideoData.class)).put("video_variant_id", new a(CustomerVideoData.VIDEO_VARIANT_ID, CustomerVideoData.class)).put("video_variant_name", new a(CustomerVideoData.VIDEO_VARIANT_NAME, CustomerVideoData.class)).put("video_source_url", new a("vsour", CustomerVideoData.class)).put("viewer_user_id", new a(CustomerPlayerData.VIEWER_USER_ID, CustomerPlayerData.class)).put("experiment_name", new a(CustomerPlayerData.EXPERIMENT_NAME, CustomerPlayerData.class)).put("view_session_id", new a(CustomerViewData.VIEW_SESSION_ID, CustomerViewData.class)).put("custom_1", new a(CustomData.CUSTOM_DATA_1, CustomData.class)).put("custom_2", new a(CustomData.CUSTOM_DATA_2, CustomData.class)).put("custom_3", new a(CustomData.CUSTOM_DATA_3, CustomData.class)).put("custom_4", new a(CustomData.CUSTOM_DATA_4, CustomData.class)).put("custom_5", new a(CustomData.CUSTOM_DATA_5, CustomData.class)).build();

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f274a;
        public final Class<? extends BaseQueryData> b;

        public a(String str, Class<? extends BaseQueryData> cls) {
            this.f274a = str;
            this.b = cls;
        }
    }

    private SessionDataKeys() {
        throw new RuntimeException("no instances");
    }

    public static String shortCode(String str) {
        ImmutableMap<String, a> immutableMap = f273a;
        if (immutableMap.containsKey(str)) {
            return immutableMap.get(str).f274a;
        }
        return null;
    }

    public static Class<? extends BaseQueryData> type(String str) {
        ImmutableMap<String, a> immutableMap = f273a;
        if (immutableMap.containsKey(str)) {
            return immutableMap.get(str).b;
        }
        return null;
    }
}
