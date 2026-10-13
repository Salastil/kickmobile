package com.useinsider.insider;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import expo.modules.notifications.service.NotificationsService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class InsiderGeofence {
    private static n4 currentProvider = null;
    private static boolean isGeofenceInitialized = false;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a extends AsyncTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f298a;
        final /* synthetic */ Activity b;

        a(Context context, Activity activity) {
            this.f298a = context;
            this.b = activity;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(JSONObject... jSONObjectArr) {
            try {
                return w4.a(w3.GET_GEOFENCES.b(), jSONObjectArr[0], this.f298a, false, l4.GEOFENCE_GET).a();
            } catch (Exception e) {
                Insider.Instance.putException(e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            try {
                JSONObject jSONObjectO = w4.o(str);
                if (jSONObjectO != null && jSONObjectO.getJSONArray("geofences").length() != 0) {
                    ArrayList locationsFromJSON = InsiderGeofence.getLocationsFromJSON(jSONObjectO.getJSONArray("geofences"));
                    if (b.f299a[InsiderGeofence.currentProvider.ordinal()] != 1) {
                        Debugger.a(DebuggingTag.noActiveServiceProvider, 5);
                    } else {
                        boolean unused = InsiderGeofence.isGeofenceInitialized = m.a(this.f298a, this.b, locationsFromJSON);
                    }
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f299a;

        static {
            int[] iArr = new int[n4.values().length];
            f299a = iArr;
            try {
                iArr[n4.GOOGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    interface c {
        void a(Location location);
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    interface d {
        void a();
    }

    InsiderGeofence() {
    }

    private static JSONObject getGeofenceRequestPayload(Context context, Location location) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("latitude", String.valueOf(location.getLatitude()));
            jSONObject2.put("longitude", String.valueOf(location.getLongitude()));
            jSONObject.put("user_location", jSONObject2);
            jSONObject.put(f.n, e.b);
            h4.a().e(context, "Insider").edit().putString("device_location", String.valueOf(jSONObject2)).apply();
            return jSONObject;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return jSONObject;
        }
    }

    private static void getLastKnownLocation(Context context, Activity activity, final c cVar) {
        try {
            if (b.f299a[currentProvider.ordinal()] != 1) {
                Debugger.a(DebuggingTag.noActiveServiceProvider, 5);
                return;
            }
            Task<Location> lastLocation = LocationServices.getFusedLocationProviderClient(context).getLastLocation();
            Objects.requireNonNull(cVar);
            lastLocation.addOnSuccessListener(activity, new OnSuccessListener() { // from class: com.useinsider.insider.InsiderGeofence$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    cVar.a((Location) obj);
                }
            });
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<Location> getLocationsFromJSON(JSONArray jSONArray) {
        ArrayList<Location> arrayList = new ArrayList<>();
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        Bundle bundle = new Bundle();
                        Location location = new Location("");
                        bundle.putInt("radius", jSONObject.getInt("radius"));
                        bundle.putString(NotificationsService.IDENTIFIER_KEY, jSONObject.getString(NotificationsService.IDENTIFIER_KEY));
                        location.setLongitude(jSONObject.getDouble("longitude"));
                        location.setLatitude(jSONObject.getDouble("latitude"));
                        location.setExtras(bundle);
                        arrayList.add(location);
                    }
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
        return arrayList;
    }

    static void initialize(final Context context, final Activity activity) {
        if (context == null || activity == null) {
            return;
        }
        try {
            if (Insider.Instance.isSdkFrozen()) {
                return;
            }
            currentProvider = w4.e(context);
            getLastKnownLocation(context, activity, new c() { // from class: com.useinsider.insider.InsiderGeofence$$ExternalSyntheticLambda1
                @Override // com.useinsider.insider.InsiderGeofence.c
                public final void a(Location location) {
                    InsiderGeofence.lambda$initialize$0(context, activity, location);
                }
            });
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static boolean isGeofenceStarted() {
        return isGeofenceInitialized;
    }

    static /* synthetic */ void lambda$initialize$0(Context context, Activity activity, Location location) {
        if (location == null) {
            return;
        }
        Debugger.a(DebuggingTag.initializeGeofence, 4);
        f3.b("geofence", "Location retrieved successfully. Starting geofencing.", "{ 'latitude': '" + location.getLatitude() + "', 'longitude': '" + location.getLongitude() + "' }", "InsiderGeofence-initialize");
        startGeofencing(context, activity, location);
    }

    static void removeGeofences() {
        try {
            if (currentProvider == null) {
                return;
            }
            isGeofenceInitialized = false;
            if (b.f299a[currentProvider.ordinal()] != 1) {
                Debugger.a(DebuggingTag.noActiveServiceProvider, 5);
            } else {
                m.b();
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static List<String> retrieveGeofencesToBeRemoved(Context context) {
        Set<String> hashSet = new HashSet<>();
        try {
            hashSet = h4.a().e(context, "Insider").getStringSet("geofences_to_be_removed", new HashSet(new ArrayList()));
            if (hashSet.isEmpty()) {
                hashSet = h4.a().e(context, "Insider").getStringSet("geofence_to_be_removed_for_partner_change", new HashSet(new ArrayList()));
                h4.a().e(context, "Insider").edit().remove("geofence_to_be_removed_for_partner_change").apply();
            }
            h4.a().e(context, "Insider").edit().remove("geofences_to_be_removed").apply();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
        return new ArrayList(hashSet);
    }

    private static void startGeofencing(Context context, Activity activity, Location location) {
        try {
            new a(context, activity).execute(getGeofenceRequestPayload(context, location));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static void storeGeofencesToBeRemoved(Context context, ArrayList<String> arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.isEmpty()) {
                    return;
                }
                HashSet hashSet = new HashSet(arrayList);
                h4.a().e(context, "Insider").edit().putStringSet("geofences_to_be_removed", hashSet).apply();
                h4.a().e(context, "Insider").edit().putStringSet("geofence_to_be_removed_for_partner_change", hashSet).apply();
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }
}
