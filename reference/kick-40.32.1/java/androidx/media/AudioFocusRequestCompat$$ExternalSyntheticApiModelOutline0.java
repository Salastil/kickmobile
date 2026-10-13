package androidx.media;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.slice.Slice;
import android.content.pm.SigningInfo;
import android.credentials.CreateCredentialResponse;
import android.credentials.CredentialOption;
import android.media.AudioFocusRequest;
import android.os.Bundle;
import android.service.credentials.Action;
import android.service.credentials.BeginCreateCredentialRequest;
import android.service.credentials.BeginCreateCredentialResponse;
import android.service.credentials.BeginGetCredentialOption;
import android.service.credentials.BeginGetCredentialRequest;
import android.service.credentials.BeginGetCredentialResponse;
import android.service.credentials.CallingAppInfo;
import android.service.credentials.CreateEntry;
import android.service.credentials.CredentialEntry;
import android.service.credentials.RemoteEntry;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ ForegroundServiceStartNotAllowedException m(Object obj) {
        return (ForegroundServiceStartNotAllowedException) obj;
    }

    public static /* synthetic */ CreateCredentialResponse m(Bundle bundle) {
        return new CreateCredentialResponse(bundle);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CredentialOption m10666m(Object obj) {
        return (CredentialOption) obj;
    }

    public static /* synthetic */ AudioFocusRequest.Builder m(int i) {
        return new AudioFocusRequest.Builder(i);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AudioFocusRequest m10667m(Object obj) {
        return (AudioFocusRequest) obj;
    }

    public static /* synthetic */ android.media.session.MediaSessionManager.RemoteUserInfo m(String str, int i, int i2) {
        return new android.media.session.MediaSessionManager.RemoteUserInfo(str, i, i2);
    }

    public static /* synthetic */ Action m(Slice slice) {
        return new Action(slice);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Action m10668m(Object obj) {
        return (Action) obj;
    }

    public static /* synthetic */ BeginCreateCredentialRequest m(String str, Bundle bundle, CallingAppInfo callingAppInfo) {
        return new BeginCreateCredentialRequest(str, bundle, callingAppInfo);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ BeginCreateCredentialResponse.Builder m10669m() {
        return new BeginCreateCredentialResponse.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ BeginGetCredentialOption m10670m(Object obj) {
        return (BeginGetCredentialOption) obj;
    }

    public static /* synthetic */ BeginGetCredentialOption m(String str, String str2, Bundle bundle) {
        return new BeginGetCredentialOption(str, str2, bundle);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ BeginGetCredentialRequest.Builder m10671m() {
        return new BeginGetCredentialRequest.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ BeginGetCredentialRequest m10672m(Object obj) {
        return (BeginGetCredentialRequest) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ BeginGetCredentialResponse.Builder m10673m() {
        return new BeginGetCredentialResponse.Builder();
    }

    public static /* synthetic */ CallingAppInfo m(String str, SigningInfo signingInfo, String str2) {
        return new CallingAppInfo(str, signingInfo, str2);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ CreateEntry m10675m(Slice slice) {
        return new CreateEntry(slice);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CreateEntry m10676m(Object obj) {
        return (CreateEntry) obj;
    }

    public static /* synthetic */ CredentialEntry m(BeginGetCredentialOption beginGetCredentialOption, Slice slice) {
        return new CredentialEntry(beginGetCredentialOption, slice);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CredentialEntry m10677m(Object obj) {
        return (CredentialEntry) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ RemoteEntry m10678m(Slice slice) {
        return new RemoteEntry(slice);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m10679m() {
        return BeginGetCredentialRequest.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m10688m() {
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m10691m(Object obj) {
        return obj instanceof ForegroundServiceStartNotAllowedException;
    }

    public static /* synthetic */ void m$1() {
    }

    public static /* synthetic */ void m$2() {
    }

    public static /* synthetic */ void m$3() {
    }

    public static /* synthetic */ void m$4() {
    }

    public static /* synthetic */ void m$5() {
    }

    public static /* synthetic */ void m$6() {
    }

    public static /* synthetic */ void m$7() {
    }

    public static /* synthetic */ void m$8() {
    }
}
