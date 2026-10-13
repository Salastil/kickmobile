package com.amazonaws.ivs.player;

import android.net.Uri;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public interface Source extends Releasable {

    public interface Listener {
        void onError(LoadError loadError);

        void onLoad(Source source);
    }

    Set<SourceGroup> getGroups();

    String getId();

    Set<Quality> getQualities();

    String getSessionData(String str);

    long getTimeToLive();

    Uri getUri();

    @Override // com.amazonaws.ivs.player.Releasable
    void release();

    public static class LoadError {
        private final int code;
        private final String id;
        private final String message;
        private final ErrorType type;
        private final Uri uri;

        LoadError(String str, String str2, ErrorType errorType, int i, String str3) {
            this.id = str;
            this.uri = Uri.parse(str2);
            this.code = i;
            this.type = errorType;
            this.message = str3;
        }

        public String getId() {
            return this.id;
        }

        public Uri getUri() {
            return this.uri;
        }

        public ErrorType getErrorType() {
            return this.type;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }
}
