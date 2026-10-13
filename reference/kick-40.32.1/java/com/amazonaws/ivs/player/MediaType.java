package com.amazonaws.ivs.player;

/* JADX INFO: loaded from: classes5.dex */
public class MediaType {
    public static final String APPLICATION_MPEG_URL = "application/x-mpegURL";
    public static final String AUDIO_AAC = "audio/aac";
    public static final String AUDIO_MP4 = "audio/mp4a";
    public static final String TEXT_JSON = "text/json";
    public static final String TEXT_PLAIN = "text/plain";
    public static final String TEXT_VTT = "text/vtt";
    public static final String TYPE_AUDIO = "audio";
    public static final String TYPE_TEXT = "text";
    public static final String TYPE_VIDEO = "video";
    public static final String VIDEO_AV1 = "video/av01";
    public static final String VIDEO_AVC = "video/avc";
    public static final String VIDEO_HEVC = "video/hevc";
    public static final String VIDEO_MP4 = "video/mp4";
    public static final String VIDEO_VP9 = "video/x-vnd.on2.vp9";

    private MediaType() {
    }

    static String removeParameters(String str) {
        return (str == null || !str.contains(";")) ? str : str.substring(0, str.indexOf(59));
    }
}
