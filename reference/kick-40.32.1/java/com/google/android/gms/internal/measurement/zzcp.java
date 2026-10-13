package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzcp extends IInterface {
    void beginAdUnitExposure(String str, long j) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void clearMeasurementEnabled(long j) throws RemoteException;

    void endAdUnitExposure(String str, long j) throws RemoteException;

    void generateEventId(zzcs zzcsVar) throws RemoteException;

    void getAppInstanceId(zzcs zzcsVar) throws RemoteException;

    void getCachedAppInstanceId(zzcs zzcsVar) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, zzcs zzcsVar) throws RemoteException;

    void getCurrentScreenClass(zzcs zzcsVar) throws RemoteException;

    void getCurrentScreenName(zzcs zzcsVar) throws RemoteException;

    void getGmpAppId(zzcs zzcsVar) throws RemoteException;

    void getMaxUserProperties(String str, zzcs zzcsVar) throws RemoteException;

    void getSessionId(zzcs zzcsVar) throws RemoteException;

    void getTestFlag(zzcs zzcsVar, int i) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z, zzcs zzcsVar) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(IObjectWrapper iObjectWrapper, zzdb zzdbVar, long j) throws RemoteException;

    void initializeWithElapsedTime(IObjectWrapper iObjectWrapper, zzdb zzdbVar, long j, long j2) throws RemoteException;

    void isDataCollectionEnabled(zzcs zzcsVar) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, zzcs zzcsVar, long j) throws RemoteException;

    void logEventWithElapsedTime(String str, String str2, Bundle bundle, boolean z, boolean z2, long j, long j2) throws RemoteException;

    void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException;

    void onActivityCreatedByScionActivityInfo(zzdd zzddVar, Bundle bundle, long j) throws RemoteException;

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityDestroyedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException;

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityPausedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException;

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityResumedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException;

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcs zzcsVar, long j) throws RemoteException;

    void onActivitySaveInstanceStateByScionActivityInfo(zzdd zzddVar, zzcs zzcsVar, long j) throws RemoteException;

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityStartedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException;

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityStoppedByScionActivityInfo(zzdd zzddVar, long j) throws RemoteException;

    void performAction(Bundle bundle, zzcs zzcsVar, long j) throws RemoteException;

    void registerOnMeasurementEventListener(zzcy zzcyVar) throws RemoteException;

    void resetAnalyticsData(long j) throws RemoteException;

    void resetAnalyticsDataWithElapsedTime(long j, long j2) throws RemoteException;

    void retrieveAndUploadBatches(zzcv zzcvVar) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException;

    void setConsent(Bundle bundle, long j) throws RemoteException;

    void setConsentThirdParty(Bundle bundle, long j) throws RemoteException;

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException;

    void setCurrentScreenByScionActivityInfo(zzdd zzddVar, String str, String str2, long j) throws RemoteException;

    void setDataCollectionEnabled(boolean z) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(zzcy zzcyVar) throws RemoteException;

    void setInstanceIdProvider(zzda zzdaVar) throws RemoteException;

    void setMeasurementEnabled(boolean z, long j) throws RemoteException;

    void setMinimumSessionDuration(long j) throws RemoteException;

    void setSessionTimeoutDuration(long j) throws RemoteException;

    void setSgtmDebugInfo(Intent intent) throws RemoteException;

    void setUserId(String str, long j) throws RemoteException;

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException;

    void unregisterOnMeasurementEventListener(zzcy zzcyVar) throws RemoteException;
}
