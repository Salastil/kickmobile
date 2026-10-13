package expo.modules.application;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: ApplicationExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/application/ApplicationInstallReferrerException;", "Lexpo/modules/kotlin/exception/CodedException;", "responseCode", "", "<init>", "(I)V", "expo-application_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ApplicationInstallReferrerException extends CodedException {
    public ApplicationInstallReferrerException(int i) {
        super("General error retrieving the install referrer: response code " + i, null, 2, null);
    }
}
