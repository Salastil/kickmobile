package com.reactnative.googlecast.types;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.common.images.WebImage;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public class RNGCMediaMetadata {
    public static MediaMetadata fromJson(ReadableMap readableMap) {
        MediaMetadata mediaMetadata;
        if (readableMap == null) {
            return null;
        }
        if (readableMap.hasKey("type")) {
            mediaMetadata = new MediaMetadata(RNGCMediaMetadataType.fromJson(readableMap.getString("type")));
        } else {
            mediaMetadata = new MediaMetadata();
        }
        if (readableMap.hasKey("creationDate")) {
            mediaMetadata.putDate(MediaMetadata.KEY_CREATION_DATE, RNGCCalendar.fromJson(readableMap.getString("creationDate")));
        }
        if (readableMap.hasKey("releaseDate")) {
            mediaMetadata.putDate(MediaMetadata.KEY_RELEASE_DATE, RNGCCalendar.fromJson(readableMap.getString("releaseDate")));
        }
        if (readableMap.hasKey("broadcastDate")) {
            mediaMetadata.putDate(MediaMetadata.KEY_BROADCAST_DATE, RNGCCalendar.fromJson(readableMap.getString("broadcastDate")));
        }
        if (readableMap.hasKey("title")) {
            mediaMetadata.putString(MediaMetadata.KEY_TITLE, readableMap.getString("title"));
        }
        if (readableMap.hasKey(MediaTrack.ROLE_SUBTITLE)) {
            mediaMetadata.putString(MediaMetadata.KEY_SUBTITLE, readableMap.getString(MediaTrack.ROLE_SUBTITLE));
        }
        if (readableMap.hasKey("artist")) {
            mediaMetadata.putString(MediaMetadata.KEY_ARTIST, readableMap.getString("artist"));
        }
        if (readableMap.hasKey("albumArtist")) {
            mediaMetadata.putString(MediaMetadata.KEY_ALBUM_ARTIST, readableMap.getString("albumArtist"));
        }
        if (readableMap.hasKey("albumTitle")) {
            mediaMetadata.putString(MediaMetadata.KEY_ALBUM_TITLE, readableMap.getString("albumTitle"));
        }
        if (readableMap.hasKey("composer")) {
            mediaMetadata.putString(MediaMetadata.KEY_COMPOSER, readableMap.getString("composer"));
        }
        if (readableMap.hasKey("discNumber")) {
            mediaMetadata.putInt(MediaMetadata.KEY_DISC_NUMBER, readableMap.getInt("discNumber"));
        }
        if (readableMap.hasKey("trackNumber")) {
            mediaMetadata.putInt(MediaMetadata.KEY_TRACK_NUMBER, readableMap.getInt("trackNumber"));
        }
        if (readableMap.hasKey("seasonNumber")) {
            mediaMetadata.putInt(MediaMetadata.KEY_SEASON_NUMBER, readableMap.getInt("seasonNumber"));
        }
        if (readableMap.hasKey("episodeNumber")) {
            mediaMetadata.putInt(MediaMetadata.KEY_EPISODE_NUMBER, readableMap.getInt("episodeNumber"));
        }
        if (readableMap.hasKey("seriesTitle")) {
            mediaMetadata.putString(MediaMetadata.KEY_SERIES_TITLE, readableMap.getString("seriesTitle"));
        }
        if (readableMap.hasKey("studio")) {
            mediaMetadata.putString(MediaMetadata.KEY_STUDIO, readableMap.getString("studio"));
        }
        if (readableMap.hasKey(ViewProps.WIDTH)) {
            mediaMetadata.putInt(MediaMetadata.KEY_WIDTH, readableMap.getInt(ViewProps.WIDTH));
        }
        if (readableMap.hasKey(ViewProps.HEIGHT)) {
            mediaMetadata.putInt(MediaMetadata.KEY_HEIGHT, readableMap.getInt(ViewProps.HEIGHT));
        }
        if (readableMap.hasKey(FirebaseAnalytics.Param.LOCATION)) {
            mediaMetadata.putString(MediaMetadata.KEY_LOCATION_NAME, readableMap.getString(FirebaseAnalytics.Param.LOCATION));
        }
        if (readableMap.hasKey("latitude")) {
            mediaMetadata.putDouble(MediaMetadata.KEY_LOCATION_LATITUDE, readableMap.getDouble("latitude"));
        }
        if (readableMap.hasKey("longitude")) {
            mediaMetadata.putDouble(MediaMetadata.KEY_LOCATION_LONGITUDE, readableMap.getDouble("longitude"));
        }
        if (readableMap.hasKey("images")) {
            ReadableArray array = readableMap.getArray("images");
            for (int i = 0; i < array.size(); i++) {
                mediaMetadata.addImage(RNGCWebImage.fromJson(array.getMap(i)));
            }
        }
        return mediaMetadata;
    }

    public static WritableMap toJson(MediaMetadata mediaMetadata) {
        if (mediaMetadata == null) {
            return null;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", RNGCMediaMetadataType.toJson(mediaMetadata.getMediaType()));
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (mediaMetadata.getImages() != null) {
            Iterator<WebImage> it = mediaMetadata.getImages().iterator();
            while (it.hasNext()) {
                writableArrayCreateArray.pushMap(RNGCWebImage.toJson(it.next()));
            }
        }
        writableMapCreateMap.putArray("images", writableArrayCreateArray);
        int mediaType = mediaMetadata.getMediaType();
        if (mediaType == 0) {
            writableMapCreateMap.putString("artist", mediaMetadata.getString(MediaMetadata.KEY_ARTIST));
            writableMapCreateMap.putString("releaseDate", RNGCCalendar.toJson(mediaMetadata.getDate(MediaMetadata.KEY_RELEASE_DATE)));
            writableMapCreateMap.putString(MediaTrack.ROLE_SUBTITLE, mediaMetadata.getString(MediaMetadata.KEY_SUBTITLE));
            writableMapCreateMap.putString("title", mediaMetadata.getString(MediaMetadata.KEY_TITLE));
            return writableMapCreateMap;
        }
        if (mediaType == 1) {
            writableMapCreateMap.putString("releaseDate", RNGCCalendar.toJson(mediaMetadata.getDate(MediaMetadata.KEY_RELEASE_DATE)));
            writableMapCreateMap.putString("studio", mediaMetadata.getString(MediaMetadata.KEY_STUDIO));
            writableMapCreateMap.putString(MediaTrack.ROLE_SUBTITLE, mediaMetadata.getString(MediaMetadata.KEY_SUBTITLE));
            writableMapCreateMap.putString("title", mediaMetadata.getString(MediaMetadata.KEY_TITLE));
            return writableMapCreateMap;
        }
        if (mediaType == 2) {
            writableMapCreateMap.putString("broadcastDate", RNGCCalendar.toJson(mediaMetadata.getDate(MediaMetadata.KEY_BROADCAST_DATE)));
            writableMapCreateMap.putString("releaseDate", RNGCCalendar.toJson(mediaMetadata.getDate(MediaMetadata.KEY_RELEASE_DATE)));
            writableMapCreateMap.putInt("seasonNumber", mediaMetadata.getInt(MediaMetadata.KEY_SEASON_NUMBER));
            writableMapCreateMap.putString("seriesTitle", mediaMetadata.getString(MediaMetadata.KEY_SERIES_TITLE));
            writableMapCreateMap.putString("title", mediaMetadata.getString(MediaMetadata.KEY_TITLE));
            return writableMapCreateMap;
        }
        if (mediaType == 3) {
            writableMapCreateMap.putString("albumArtist", mediaMetadata.getString(MediaMetadata.KEY_ALBUM_ARTIST));
            writableMapCreateMap.putString("albumTitle", mediaMetadata.getString(MediaMetadata.KEY_ALBUM_TITLE));
            writableMapCreateMap.putString("artist", mediaMetadata.getString(MediaMetadata.KEY_ARTIST));
            writableMapCreateMap.putString("composer", mediaMetadata.getString(MediaMetadata.KEY_COMPOSER));
            writableMapCreateMap.putInt("discNumber", mediaMetadata.getInt(MediaMetadata.KEY_DISC_NUMBER));
            writableMapCreateMap.putString("releaseDate", RNGCCalendar.toJson(mediaMetadata.getDate(MediaMetadata.KEY_RELEASE_DATE)));
            writableMapCreateMap.putString("title", mediaMetadata.getString(MediaMetadata.KEY_TITLE));
            writableMapCreateMap.putInt("trackNumber", mediaMetadata.getInt(MediaMetadata.KEY_TRACK_NUMBER));
            return writableMapCreateMap;
        }
        if (mediaType != 4) {
            return writableMapCreateMap;
        }
        writableMapCreateMap.putString("artist", mediaMetadata.getString(MediaMetadata.KEY_ARTIST));
        writableMapCreateMap.putString("creationDate", RNGCCalendar.toJson(mediaMetadata.getDate(MediaMetadata.KEY_CREATION_DATE)));
        writableMapCreateMap.putInt(ViewProps.HEIGHT, mediaMetadata.getInt(MediaMetadata.KEY_HEIGHT));
        writableMapCreateMap.putDouble("latitude", mediaMetadata.getDouble(MediaMetadata.KEY_LOCATION_LATITUDE));
        writableMapCreateMap.putString(FirebaseAnalytics.Param.LOCATION, mediaMetadata.getString(MediaMetadata.KEY_LOCATION_NAME));
        writableMapCreateMap.putDouble("longitude", mediaMetadata.getDouble(MediaMetadata.KEY_LOCATION_LONGITUDE));
        writableMapCreateMap.putString("title", mediaMetadata.getString(MediaMetadata.KEY_TITLE));
        writableMapCreateMap.putInt(ViewProps.WIDTH, mediaMetadata.getInt(MediaMetadata.KEY_WIDTH));
        return writableMapCreateMap;
    }
}
