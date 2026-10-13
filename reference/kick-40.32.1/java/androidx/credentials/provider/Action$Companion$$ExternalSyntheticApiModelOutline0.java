package androidx.credentials.provider;

import android.credentials.ClearCredentialStateException;
import android.credentials.ClearCredentialStateRequest;
import android.credentials.CreateCredentialException;
import android.credentials.CreateCredentialRequest;
import android.credentials.CreateCredentialResponse;
import android.credentials.Credential;
import android.credentials.CredentialManager;
import android.credentials.CredentialOption;
import android.credentials.GetCredentialException;
import android.credentials.GetCredentialRequest;
import android.credentials.GetCredentialResponse;
import android.credentials.PrepareGetCredentialResponse;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputContentInfo;
import java.util.Map;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Action$Companion$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ ClearCredentialStateException m(Object obj) {
        return (ClearCredentialStateException) obj;
    }

    public static /* synthetic */ ClearCredentialStateException m(String str, String str2) {
        return new ClearCredentialStateException(str, str2);
    }

    public static /* synthetic */ ClearCredentialStateRequest m(Bundle bundle) {
        return new ClearCredentialStateRequest(bundle);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CreateCredentialException m10562m(Object obj) {
        return (CreateCredentialException) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ CreateCredentialException m10563m(String str, String str2) {
        return new CreateCredentialException(str, str2);
    }

    public static /* synthetic */ CreateCredentialRequest.Builder m(String str, Bundle bundle, Bundle bundle2) {
        return new CreateCredentialRequest.Builder(str, bundle, bundle2);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CreateCredentialResponse m10564m(Object obj) {
        return (CreateCredentialResponse) obj;
    }

    public static /* synthetic */ Credential m(String str, Bundle bundle) {
        return new Credential(str, bundle);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CredentialManager m10565m(Object obj) {
        return (CredentialManager) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ CredentialOption.Builder m10566m(String str, Bundle bundle, Bundle bundle2) {
        return new CredentialOption.Builder(str, bundle, bundle2);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ GetCredentialException m10567m(Object obj) {
        return (GetCredentialException) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ GetCredentialException m10568m(String str, String str2) {
        return new GetCredentialException(str, str2);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ GetCredentialRequest.Builder m10569m(Bundle bundle) {
        return new GetCredentialRequest.Builder(bundle);
    }

    public static /* synthetic */ GetCredentialResponse m(Credential credential) {
        return new GetCredentialResponse(credential);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ GetCredentialResponse m10570m(Object obj) {
        return (GetCredentialResponse) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ PrepareGetCredentialResponse m10571m(Object obj) {
        return (PrepareGetCredentialResponse) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ android.service.credentials.BeginGetCredentialResponse m10573m(Object obj) {
        return (android.service.credentials.BeginGetCredentialResponse) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ android.service.credentials.CreateCredentialRequest m10575m(Object obj) {
        return (android.service.credentials.CreateCredentialRequest) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ android.service.credentials.GetCredentialRequest m10576m(Object obj) {
        return (android.service.credentials.GetCredentialRequest) obj;
    }

    public static /* synthetic */ AccessibilityNodeInfo.Selection m(AccessibilityNodeInfo.SelectionPosition selectionPosition, AccessibilityNodeInfo.SelectionPosition selectionPosition2) {
        return new AccessibilityNodeInfo.Selection(selectionPosition, selectionPosition2);
    }

    public static /* synthetic */ AccessibilityNodeInfo.SelectionPosition m(View view, int i) {
        return new AccessibilityNodeInfo.SelectionPosition(view, i);
    }

    public static /* synthetic */ AccessibilityNodeInfo.SelectionPosition m(View view, int i, int i2) {
        return new AccessibilityNodeInfo.SelectionPosition(view, i, i2);
    }

    public static /* synthetic */ AccessibilityNodeInfo.SelectionPosition m(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        return new AccessibilityNodeInfo.SelectionPosition(accessibilityNodeInfo, i);
    }

    public static /* synthetic */ AccessibilityNodeInfo.TouchDelegateInfo m(Map map) {
        return new AccessibilityNodeInfo.TouchDelegateInfo(map);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ InputContentInfo m10579m(Object obj) {
        return (InputContentInfo) obj;
    }

    public static /* bridge */ /* synthetic */ Class m() {
        return GetCredentialResponse.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m10584m() {
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return android.service.credentials.BeginGetCredentialResponse.class;
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m10587m$1() {
    }

    public static /* bridge */ /* synthetic */ Class m$2() {
        return CreateCredentialException.class;
    }

    /* JADX INFO: renamed from: m$2, reason: collision with other method in class */
    public static /* synthetic */ void m10588m$2() {
    }

    public static /* bridge */ /* synthetic */ Class m$3() {
        return GetCredentialException.class;
    }

    /* JADX INFO: renamed from: m$3, reason: collision with other method in class */
    public static /* synthetic */ void m10589m$3() {
    }

    public static /* bridge */ /* synthetic */ Class m$4() {
        return CreateCredentialResponse.class;
    }

    /* JADX INFO: renamed from: m$4, reason: collision with other method in class */
    public static /* synthetic */ void m10590m$4() {
    }

    public static /* bridge */ /* synthetic */ Class m$5() {
        return android.service.credentials.GetCredentialRequest.class;
    }

    /* JADX INFO: renamed from: m$5, reason: collision with other method in class */
    public static /* synthetic */ void m10591m$5() {
    }

    public static /* bridge */ /* synthetic */ Class m$6() {
        return android.service.credentials.CreateCredentialRequest.class;
    }

    /* JADX INFO: renamed from: m$6, reason: collision with other method in class */
    public static /* synthetic */ void m10592m$6() {
    }

    public static /* synthetic */ void m$7() {
    }

    public static /* synthetic */ void m$8() {
    }

    public static /* synthetic */ void m$9() {
    }
}
