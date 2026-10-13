package com.reactnative.googlecast.types;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCMediaSeekOptions {
    public static MediaSeekOptions fromJson(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        if (readableMap.hasKey("customData")) {
            builder.setCustomData(RNGCJSONObject.fromJson(readableMap.getMap("customData")));
        }
        if (readableMap.hasKey("infinite")) {
            builder.setIsSeekToInfinite(readableMap.getBoolean("infinite"));
        }
        if (readableMap.hasKey(ViewProps.POSITION)) {
            long jRound = Math.round(readableMap.getDouble(ViewProps.POSITION) * 1000.0d);
            if (readableMap.hasKey("relative") && readableMap.getBoolean("relative")) {
                builder.setPosition(getCurrentPosition() + jRound);
            } else {
                builder.setPosition(jRound);
            }
        }
        if (readableMap.hasKey("resumeState")) {
            builder.setResumeState(RNGCMediaResumeState.fromJson(readableMap.getString("resumeState")));
        }
        return builder.build();
    }

    private static long getCurrentPosition() {
        RemoteMediaClient remoteMediaClient;
        CastSession currentCastSession = CastContext.getSharedInstance().getSessionManager().getCurrentCastSession();
        if (currentCastSession == null || (remoteMediaClient = currentCastSession.getRemoteMediaClient()) == null) {
            return 0L;
        }
        return remoteMediaClient.getApproximateStreamPosition();
    }
}
