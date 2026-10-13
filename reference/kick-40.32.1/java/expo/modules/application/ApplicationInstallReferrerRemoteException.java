package expo.modules.application;

import android.os.RemoteException;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplicationExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/application/ApplicationInstallReferrerRemoteException;", "Lexpo/modules/kotlin/exception/CodedException;", "cause", "Landroid/os/RemoteException;", "<init>", "(Landroid/os/RemoteException;)V", "expo-application_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ApplicationInstallReferrerRemoteException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationInstallReferrerRemoteException(RemoteException cause) {
        super("ERR_APPLICATION_INSTALL_REFERRER_REMOTE_EXCEPTION", "RemoteException getting install referrer information. This may happen if the process hosting the remote object is no longer available.", cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
