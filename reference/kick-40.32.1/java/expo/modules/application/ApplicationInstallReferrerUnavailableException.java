package expo.modules.application;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: ApplicationExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/application/ApplicationInstallReferrerUnavailableException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo-application_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ApplicationInstallReferrerUnavailableException extends CodedException {
    public ApplicationInstallReferrerUnavailableException() {
        super("The current Play Store app doesn't provide the installation referrer API, or the Play Store may not be installed.", null, 2, null);
    }
}
