package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzcn extends zzbl implements zzcp {
    zzcn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeLong(j);
        zzc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzc(parcelZza, bundle);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void clearMeasurementEnabled(long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeLong(j);
        zzc(24, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void generateEventId(zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcsVar);
        zzc(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getAppInstanceId(zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcsVar);
        zzc(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getCachedAppInstanceId(zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcsVar);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getConditionalUserProperties(String str, String str2, zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzd(parcelZza, zzcsVar);
        zzc(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getCurrentScreenClass(zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcsVar);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getCurrentScreenName(zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcsVar);
        zzc(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getGmpAppId(zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcsVar);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getMaxUserProperties(String str, zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzbn.zzd(parcelZza, zzcsVar);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getSessionId(zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcsVar);
        zzc(46, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getTestFlag(zzcs zzcsVar, int i) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcsVar);
        parcelZza.writeInt(i);
        zzc(38, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void getUserProperties(String str, String str2, boolean z, zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        int i = zzbn.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzbn.zzd(parcelZza, zzcsVar);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void initForTests(Map map) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void initialize(IObjectWrapper iObjectWrapper, zzdb zzdbVar, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, iObjectWrapper);
        zzbn.zzc(parcelZza, zzdbVar);
        parcelZza.writeLong(j);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void initializeWithElapsedTime(IObjectWrapper iObjectWrapper, zzdb zzdbVar, long j, long j2) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, iObjectWrapper);
        zzbn.zzc(parcelZza, zzdbVar);
        parcelZza.writeLong(j);
        parcelZza.writeLong(j2);
        zzc(60, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void isDataCollectionEnabled(zzcs zzcsVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzcs zzcsVar, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void logEventWithElapsedTime(String str, String str2, Bundle bundle, boolean z, boolean z2, long j, long j2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeInt(z ? 1 : 0);
        parcelZza.writeInt(z2 ? 1 : 0);
        parcelZza.writeLong(j);
        parcelZza.writeLong(j2);
        zzc(59, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(5);
        parcelZza.writeString(str);
        zzbn.zzd(parcelZza, iObjectWrapper);
        zzbn.zzd(parcelZza, iObjectWrapper2);
        zzbn.zzd(parcelZza, iObjectWrapper3);
        zzc(33, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityCreatedByScionActivityInfo(zzdd zzddVar, Bundle bundle, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzddVar);
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeLong(j);
        zzc(53, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityDestroyedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzddVar);
        parcelZza.writeLong(j);
        zzc(54, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityPausedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzddVar);
        parcelZza.writeLong(j);
        zzc(55, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityResumedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzddVar);
        parcelZza.writeLong(j);
        zzc(56, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcs zzcsVar, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivitySaveInstanceStateByScionActivityInfo(zzdd zzddVar, zzcs zzcsVar, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzddVar);
        zzbn.zzd(parcelZza, zzcsVar);
        parcelZza.writeLong(j);
        zzc(57, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityStartedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzddVar);
        parcelZza.writeLong(j);
        zzc(51, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void onActivityStoppedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzddVar);
        parcelZza.writeLong(j);
        zzc(52, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void performAction(Bundle bundle, zzcs zzcsVar, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        zzbn.zzd(parcelZza, zzcsVar);
        parcelZza.writeLong(j);
        zzc(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void registerOnMeasurementEventListener(zzcy zzcyVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcyVar);
        zzc(35, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j);
        zzc(12, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void resetAnalyticsDataWithElapsedTime(long j, long j2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j);
        parcelZza.writeLong(j2);
        zzc(61, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void retrieveAndUploadBatches(zzcv zzcvVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcvVar);
        zzc(58, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeLong(j);
        zzc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setConsent(Bundle bundle, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeLong(j);
        zzc(45, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setCurrentScreenByScionActivityInfo(zzdd zzddVar, String str, String str2, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzddVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeLong(j);
        zzc(50, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        int i = zzbn.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzc(39, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        zzc(42, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setEventInterceptor(zzcy zzcyVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcyVar);
        zzc(34, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setInstanceIdProvider(zzda zzdaVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel parcelZza = zza();
        int i = zzbn.zza;
        parcelZza.writeInt(z ? 1 : 0);
        parcelZza.writeLong(j);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setMinimumSessionDuration(long j) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j);
        zzc(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setSgtmDebugInfo(Intent intent) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, intent);
        zzc(48, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeLong(j);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzd(parcelZza, iObjectWrapper);
        parcelZza.writeInt(z ? 1 : 0);
        parcelZza.writeLong(j);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public final void unregisterOnMeasurementEventListener(zzcy zzcyVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcyVar);
        zzc(36, parcelZza);
    }
}
