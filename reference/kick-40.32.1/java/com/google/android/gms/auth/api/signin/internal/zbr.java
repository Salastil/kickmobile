package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.5.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zbr extends IInterface {
    void zbb(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException;

    void zbc(Status status) throws RemoteException;

    void zbd(Status status) throws RemoteException;
}
