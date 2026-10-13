package com.amazonaws.ivs.player;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes5.dex */
public interface MediaPlayer extends Player, PlayerInternal {

    public static final class Builder {
        private final Configuration configuration = new Configuration();
        private final Context context;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        public Builder sessionConfig(SessionConfig sessionConfig) {
            this.configuration.overrideWith(sessionConfig);
            return this;
        }

        public MediaPlayer build() {
            Logging.d("Creating player with config: " + this.configuration);
            return new CorePlayerImpl(this.context, this.configuration);
        }
    }

    public static class LoadOptions {
        private String mediaType = "";
        private SessionConfig sessionConfig = new SessionConfig();
        private final Uri uri;

        public LoadOptions(Uri uri) {
            this.uri = uri;
        }

        public LoadOptions setMediaType(String str) {
            this.mediaType = str;
            return this;
        }

        public LoadOptions setSessionConfig(SessionConfig sessionConfig) {
            this.sessionConfig = sessionConfig;
            return this;
        }

        Uri getUri() {
            return this.uri;
        }

        String getMediaType() {
            return this.mediaType;
        }

        SessionConfig getSessionConfig() {
            return this.sessionConfig;
        }
    }
}
