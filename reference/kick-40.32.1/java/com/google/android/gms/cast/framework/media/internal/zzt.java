package com.google.android.gms.cast.framework.media.internal;

import android.os.RemoteException;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.internal.Logger;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzt {
    private static final Logger zza = new Logger("MediaSessionUtils");

    /* JADX WARN: Code duplicated, block: B:13:0x001b  */
    /* JADX WARN: Code duplicated, block: B:19:0x002c A[PHI: r1
      0x002c: PHI (r1v5 java.lang.String) = (r1v3 java.lang.String), (r1v4 java.lang.String) binds: [B:18:0x002a, B:21:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    public static String zza(MediaMetadata mediaMetadata) {
        String str = MediaMetadata.KEY_SUBTITLE;
        if (!mediaMetadata.containsKey(MediaMetadata.KEY_SUBTITLE)) {
            int mediaType = mediaMetadata.getMediaType();
            if (mediaType == 1) {
                str = MediaMetadata.KEY_STUDIO;
            } else if (mediaType == 2) {
                str = MediaMetadata.KEY_SERIES_TITLE;
            } else if (mediaType != 3) {
                if (mediaType == 4) {
                    str = MediaMetadata.KEY_ARTIST;
                }
            } else if (mediaMetadata.containsKey(MediaMetadata.KEY_ARTIST)) {
                str = MediaMetadata.KEY_ARTIST;
            } else {
                String str2 = MediaMetadata.KEY_ALBUM_ARTIST;
                if (mediaMetadata.containsKey(MediaMetadata.KEY_ALBUM_ARTIST)) {
                    str = str2;
                } else {
                    str2 = MediaMetadata.KEY_COMPOSER;
                    if (mediaMetadata.containsKey(MediaMetadata.KEY_COMPOSER)) {
                        str = str2;
                    }
                }
            }
        }
        return mediaMetadata.getString(str);
    }

    public static List zzb(com.google.android.gms.cast.framework.media.zzg zzgVar) {
        try {
            return zzgVar.zzf();
        } catch (RemoteException e) {
            zza.e(e, "Unable to call %s on %s.", "getNotificationActions", "zzg");
            return null;
        }
    }

    public static int[] zzc(com.google.android.gms.cast.framework.media.zzg zzgVar) {
        try {
            return zzgVar.zzg();
        } catch (RemoteException e) {
            zza.e(e, "Unable to call %s on %s.", "getCompactViewActionIndices", "zzg");
            return null;
        }
    }

    public static int zzd(NotificationOptions notificationOptions, long j) {
        int forwardDrawableResId = notificationOptions.getForwardDrawableResId();
        if (j == 10000) {
            return notificationOptions.getForward10DrawableResId();
        }
        return j != 30000 ? forwardDrawableResId : notificationOptions.getForward30DrawableResId();
    }

    public static int zze(NotificationOptions notificationOptions, long j) {
        int iZzf = notificationOptions.zzf();
        if (j == 10000) {
            return notificationOptions.zzg();
        }
        return j != 30000 ? iZzf : notificationOptions.zzh();
    }

    public static int zzf(NotificationOptions notificationOptions, long j) {
        int rewindDrawableResId = notificationOptions.getRewindDrawableResId();
        if (j == 10000) {
            return notificationOptions.getRewind10DrawableResId();
        }
        return j != 30000 ? rewindDrawableResId : notificationOptions.getRewind30DrawableResId();
    }

    public static int zzg(NotificationOptions notificationOptions, long j) {
        int iZzi = notificationOptions.zzi();
        if (j == 10000) {
            return notificationOptions.zzj();
        }
        return j != 30000 ? iZzi : notificationOptions.zzk();
    }
}
