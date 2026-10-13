package com.useinsider.insider;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingEvent;
import expo.modules.notifications.service.NotificationsService;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class InsiderGeofenceReceiver extends BroadcastReceiver {

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a extends AsyncTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f300a;

        a(Context context) {
            this.f300a = context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(JSONObject... jSONObjectArr) {
            String strB = w3.GET_GEOFENCES_NOTIFY.b();
            Debugger.putLog(DebuggingTag.geofenceRequest, 4, String.valueOf(jSONObjectArr[0]));
            return w4.a(strB, jSONObjectArr[0], this.f300a, false, l4.GEOFENCE_NOTIFY).a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f301a;

        static {
            int[] iArr = new int[n4.values().length];
            f301a = iArr;
            try {
                iArr[n4.GOOGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static PendingIntent a(Context context) {
        Intent intent = new Intent(context, (Class<?>) InsiderGeofenceReceiver.class);
        intent.setAction("com.useinsider.insider.ACTION_GEOFENCE_EVENT");
        return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(context, 0, intent, 167772160) : PendingIntent.getBroadcast(context, 0, intent, 134217728);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"com.useinsider.insider.ACTION_GEOFENCE_EVENT".equals(intent.getAction())) {
            Debugger.a(DebuggingTag.invalidGeofenceReceived, 5);
            return;
        }
        try {
            Insider insider = Insider.Instance;
            if (insider.isSdkFrozen()) {
                return;
            }
            if (b.f301a[w4.e(context).ordinal()] != 1) {
                Debugger.a(DebuggingTag.noActiveServiceProvider, 5);
                return;
            }
            GeofencingEvent geofencingEventFromIntent = GeofencingEvent.fromIntent(intent);
            if (geofencingEventFromIntent.hasError()) {
                insider.putException(new Exception(GeofenceStatusCodes.getStatusCodeString(geofencingEventFromIntent.getErrorCode())));
            } else {
                a(context, geofencingEventFromIntent);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private void a(Context context, GeofencingEvent geofencingEvent) {
        try {
            List<Geofence> triggeringGeofences = geofencingEvent.getTriggeringGeofences();
            if (triggeringGeofences != null && !triggeringGeofences.isEmpty()) {
                int geofenceTransition = geofencingEvent.getGeofenceTransition();
                Iterator<Geofence> it = triggeringGeofences.iterator();
                while (it.hasNext()) {
                    a(context, it.next().getRequestId(), geofenceTransition);
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private void a(Context context, String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f.n, w4.i(context));
            jSONObject.put("udid", w4.k(context));
            jSONObject.put(NotificationsService.IDENTIFIER_KEY, str);
            jSONObject.put("status", a(i));
            jSONObject.put("insider_id", w4.f(context));
            new a(context).execute(jSONObject);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private String a(int i) {
        if (i == 1) {
            return "enter";
        }
        if (i == 2) {
            return "exit";
        }
        if (i != 4) {
            return "";
        }
        return "dwell";
    }
}
