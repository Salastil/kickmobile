package com.useinsider.insider;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.util.Util$$ExternalSyntheticApiModelOutline0;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class k4 {
    static String a(Context context, NotificationCompat.Builder builder, NotificationManager notificationManager, String str) {
        boolean z;
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("channel_name")) {
                return "";
            }
            String string = jSONObject.getString("channel_name");
            try {
                Util$$ExternalSyntheticApiModelOutline0.m10732m();
                NotificationChannel notificationChannelM = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(string, string, jSONObject.getInt("importance"));
                if (builder != null) {
                    builder.setChannelId(string);
                }
                if (!jSONObject.has("led_color") || jSONObject.getInt("led_color") <= 0) {
                    z = false;
                } else {
                    notificationChannelM.enableLights(true);
                    z = true;
                }
                if (jSONObject.has("led_color_hex") && !jSONObject.getString("led_color_hex").equals("") && !jSONObject.isNull("led_color_hex") && z) {
                    notificationChannelM.setLightColor(Color.parseColor(jSONObject.getString("led_color_hex")));
                }
                if (jSONObject.has("is_badge_enabled")) {
                    notificationChannelM.setShowBadge(jSONObject.getInt("is_badge_enabled") == 1);
                }
                if (jSONObject.has("sound")) {
                    int i = jSONObject.getInt("sound");
                    AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
                    if (i == 0) {
                        notificationChannelM.setSound(null, null);
                    } else if (i == 1 || i == 2) {
                        if (!jSONObject.has("sound_name") || jSONObject.isNull("sound_name") || jSONObject.getString("sound_name").isEmpty()) {
                            notificationChannelM.setSound(RingtoneManager.getDefaultUri(2), audioAttributesBuild);
                        } else {
                            Uri uriA = a(context, jSONObject.getString("sound_name"));
                            if (uriA != null) {
                                notificationChannelM.setSound(uriA, audioAttributesBuild);
                            }
                        }
                    }
                }
                if (jSONObject.has("is_vibration_enabled")) {
                    notificationChannelM.enableVibration(jSONObject.getInt("is_vibration_enabled") == 1);
                }
                if (jSONObject.has("is_visible_on_lock_screen")) {
                    if (jSONObject.getInt("is_visible_on_lock_screen") == 1) {
                        notificationChannelM.setLockscreenVisibility(1);
                    } else {
                        notificationChannelM.setLockscreenVisibility(0);
                    }
                }
                notificationManager.createNotificationChannel(notificationChannelM);
                return string;
            } catch (Exception e) {
                e = e;
                str2 = string;
            }
        } catch (Exception e2) {
            e = e2;
        }
        Insider.Instance.putException(e);
        return str2;
    }

    static Bitmap b(Context context) {
        try {
            int iE = w4.e(context, "insider_notification_large_icon");
            if (iE != 0) {
                return BitmapFactory.decodeResource(context.getResources(), iE);
            }
            return null;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    static int c(Context context) {
        try {
            int iG = w4.g(context, "insider_notification_push_priority");
            if (iG > 0) {
                return iG;
            }
            return 0;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return 0;
        }
    }

    static Uri a(Context context, String str) {
        try {
            if (str != null) {
                if (w4.i(context, str)) {
                    return Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + str);
                }
                return w4.a(context, str);
            }
            return RingtoneManager.getDefaultUri(2);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    static int a(Context context) {
        int iC = 0;
        try {
            iC = w4.c(context, "insider_notification_circle_color");
            return iC != 0 ? w4.a(context, iC) : iC;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return iC;
        }
    }
}
