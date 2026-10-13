package com.useinsider.insider;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import expo.modules.notifications.service.NotificationsService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f386a = null;
    private static Activity b = null;
    private static boolean c = false;

    static boolean a(Context context, Activity activity, ArrayList arrayList) {
        try {
            f386a = context;
            b = activity;
            ArrayList arrayListB = b(arrayList);
            if (arrayListB.isEmpty()) {
                return c;
            }
            GeofencingRequest geofencingRequestA = a(arrayListB);
            if (geofencingRequestA == null) {
                return c;
            }
            a(geofencingRequestA);
            return c;
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static void b() {
        try {
            GeofencingClient geofencingClient = LocationServices.getGeofencingClient(f386a);
            c = false;
            a(geofencingClient, new InsiderGeofence.d() { // from class: com.useinsider.insider.m$$ExternalSyntheticLambda2
                @Override // com.useinsider.insider.InsiderGeofence.d
                public final void a() {
                    m.a();
                }
            });
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private static ArrayList b(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        try {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Location location = (Location) obj;
                Bundle extras = location.getExtras();
                String strValueOf = String.valueOf(extras.getString(NotificationsService.IDENTIFIER_KEY));
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                int i2 = extras.getInt("radius");
                HashMap map = new HashMap();
                map.put("latitude", Double.valueOf(latitude));
                map.put("longitude", Double.valueOf(longitude));
                map.put(NotificationsService.IDENTIFIER_KEY, strValueOf);
                Debugger.a(DebuggingTag.buildGeofences, 4, map);
                arrayList2.add(new Geofence.Builder().setRequestId(strValueOf).setCircularRegion(latitude, longitude, i2).setExpirationDuration(-1L).setTransitionTypes(3).build());
                arrayList3.add(strValueOf);
            }
            InsiderGeofence.storeGeofencesToBeRemoved(f386a, arrayList3);
            return arrayList2;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return arrayList2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a() {
        Debugger.putLog(DebuggingTag.geofencesRemoved, 4, "Google");
    }

    private static GeofencingRequest a(ArrayList arrayList) {
        try {
            GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
            builder.setInitialTrigger(0);
            return builder.addGeofences(arrayList).build();
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    private static void a(final GeofencingRequest geofencingRequest) {
        try {
            final GeofencingClient geofencingClient = LocationServices.getGeofencingClient(f386a);
            a(geofencingClient, new InsiderGeofence.d() { // from class: com.useinsider.insider.m$$ExternalSyntheticLambda3
                @Override // com.useinsider.insider.InsiderGeofence.d
                public final void a() {
                    m.a(geofencingClient, geofencingRequest);
                }
            });
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(GeofencingClient geofencingClient, GeofencingRequest geofencingRequest) {
        try {
            Task<Void> taskAddOnSuccessListener = geofencingClient.addGeofences(geofencingRequest, InsiderGeofenceReceiver.a(f386a)).addOnSuccessListener(b, new OnSuccessListener() { // from class: com.useinsider.insider.m$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    m.a((Void) obj);
                }
            });
            Activity activity = b;
            Insider insider = Insider.Instance;
            Objects.requireNonNull(insider);
            taskAddOnSuccessListener.addOnFailureListener(activity, new m$$ExternalSyntheticLambda1(insider));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Void r1) {
        Debugger.a(DebuggingTag.addGeofencesToClient, 4);
        c = true;
    }

    private static void a(GeofencingClient geofencingClient, final InsiderGeofence.d dVar) {
        try {
            List<String> listRetrieveGeofencesToBeRemoved = InsiderGeofence.retrieveGeofencesToBeRemoved(f386a);
            if (listRetrieveGeofencesToBeRemoved.isEmpty()) {
                return;
            }
            Task<Void> taskAddOnSuccessListener = geofencingClient.removeGeofences(listRetrieveGeofencesToBeRemoved).addOnSuccessListener(b, new OnSuccessListener() { // from class: com.useinsider.insider.m$$ExternalSyntheticLambda4
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    dVar.a();
                }
            });
            Activity activity = b;
            Insider insider = Insider.Instance;
            Objects.requireNonNull(insider);
            taskAddOnSuccessListener.addOnFailureListener(activity, new m$$ExternalSyntheticLambda1(insider));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
