package com.amazonaws.ivs.player;

import android.net.Uri;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
public interface PlayerInternal {

    public interface PlaybackListener {
        void onLoad(Uri uri);

        void onPause();

        void onPlay();

        void onRelease();

        void onSeek();

        void onSetAutoQualityMode(boolean z, boolean z2);

        void onSetQuality(Quality quality, Quality quality2, boolean z);
    }

    void addPlaybackListener(PlaybackListener playbackListener);

    Configuration getConfiguration();

    float getMaxPlaybackRateForQuality(Quality quality);

    String getProtocol();

    SourceGroup getSourceGroup();

    Set<SourceGroup> getSourceGroups();

    TextTrack getTextTrack();

    List<TextTrack> getTextTracks();

    void load(MediaPlayer.LoadOptions loadOptions);

    void loadClipManifest(String str);

    void loadSource(Source source);

    void loadSource(Source source, SessionConfig sessionConfig);

    void preload(Uri uri, Source.Listener listener);

    void removePlaybackListener(PlaybackListener playbackListener);

    void setAuthToken(String str);

    void setAutoQualityMode(boolean z, boolean z2);

    void setClientId(String str);

    void setConfiguration(String str);

    void setDeviceId(String str);

    void setDrmEnabled(boolean z);

    void setSourceGroup(String str);

    void setSourceGroup(String str, boolean z);

    void setSurfaceSize(int i, int i2);

    void setTextTrack(TextTrack textTrack);

    void skipAd();
}
