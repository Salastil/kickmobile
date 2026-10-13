package com.reactnative.googlecast;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.SessionProvider;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.cast.framework.media.NotificationAction;
import com.google.android.gms.cast.framework.media.NotificationActionsProvider;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.images.WebImage;
import com.reactnative.googlecast.api.RNGCCastContext;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class GoogleCastOptionsProvider implements OptionsProvider {
    @Override // com.google.android.gms.cast.framework.OptionsProvider
    public List<SessionProvider> getAdditionalSessionProviders(Context context) {
        return null;
    }

    protected String getReceiverApplicationId(Context context) {
        String string;
        try {
            string = context.getPackageManager().getPackageInfo(context.getPackageName(), 128).applicationInfo.metaData.getString("com.reactnative.googlecast.RECEIVER_APPLICATION_ID");
        } catch (PackageManager.NameNotFoundException unused) {
            string = null;
        }
        return string != null ? string : CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID;
    }

    @Override // com.google.android.gms.cast.framework.OptionsProvider
    public CastOptions getCastOptions(Context context) {
        return new CastOptions.Builder().setReceiverApplicationId(getReceiverApplicationId(context)).setCastMediaOptions(new CastMediaOptions.Builder().setImagePicker(new ImagePickerImpl()).setNotificationOptions(new NotificationOptions.Builder().setNotificationActionsProvider(new NotificationActionsProvider(context) { // from class: com.reactnative.googlecast.GoogleCastOptionsProvider.1
            @Override // com.google.android.gms.cast.framework.media.NotificationActionsProvider
            public List<NotificationAction> getNotificationActions() {
                if (hasQueue()) {
                    return Arrays.asList(new NotificationAction.Builder().setAction(MediaIntentReceiver.ACTION_SKIP_PREV).build(), new NotificationAction.Builder().setAction(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK).build(), new NotificationAction.Builder().setAction(MediaIntentReceiver.ACTION_SKIP_NEXT).build(), new NotificationAction.Builder().setAction(MediaIntentReceiver.ACTION_STOP_CASTING).build());
                }
                if (isPhoto()) {
                    return Arrays.asList(new NotificationAction.Builder().setAction(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK).build(), new NotificationAction.Builder().setAction(MediaIntentReceiver.ACTION_STOP_CASTING).build());
                }
                return Arrays.asList(new NotificationAction.Builder().setAction(MediaIntentReceiver.ACTION_REWIND).build(), new NotificationAction.Builder().setAction(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK).build(), new NotificationAction.Builder().setAction(MediaIntentReceiver.ACTION_FORWARD).build(), new NotificationAction.Builder().setAction(MediaIntentReceiver.ACTION_STOP_CASTING).build());
            }

            @Override // com.google.android.gms.cast.framework.media.NotificationActionsProvider
            public int[] getCompactViewActionIndices() {
                if (hasQueue()) {
                    return new int[]{1, 2};
                }
                return isPhoto() ? new int[]{0, 1} : new int[]{1, 3};
            }

            private boolean hasQueue() {
                MediaStatus mediaStatus = getMediaStatus();
                return mediaStatus != null && mediaStatus.getQueueItemCount() > 1;
            }

            private boolean isPhoto() {
                MediaInfo mediaInfo;
                MediaMetadata metadata;
                MediaStatus mediaStatus = getMediaStatus();
                return (mediaStatus == null || (mediaInfo = mediaStatus.getMediaInfo()) == null || (metadata = mediaInfo.getMetadata()) == null || metadata.getMediaType() != 4) ? false : true;
            }

            private MediaStatus getMediaStatus() {
                CastSession currentCastSession;
                RemoteMediaClient remoteMediaClient;
                CastContext sharedInstance = RNGCCastContext.getSharedInstance(getApplicationContext());
                if (sharedInstance == null || (currentCastSession = sharedInstance.getSessionManager().getCurrentCastSession()) == null || (remoteMediaClient = currentCastSession.getRemoteMediaClient()) == null) {
                    return null;
                }
                return remoteMediaClient.getMediaStatus();
            }
        }).build()).setExpandedControllerActivityClassName(RNGCExpandedControllerActivity.class.getName()).build()).build();
    }

    private static class ImagePickerImpl extends ImagePicker {
        private ImagePickerImpl() {
        }

        @Override // com.google.android.gms.cast.framework.media.ImagePicker
        public WebImage onPickImage(MediaMetadata mediaMetadata, int i) {
            if (mediaMetadata == null || !mediaMetadata.hasImages()) {
                return null;
            }
            List<WebImage> images = mediaMetadata.getImages();
            if (images.size() == 1) {
                return images.get(0);
            }
            if (i == 0) {
                return images.get(0);
            }
            return images.get(1);
        }
    }
}
