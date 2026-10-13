package expo.modules.fetch;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: FetchExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/fetch/FetchBlobModuleUnavailableException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FetchBlobModuleUnavailableException extends CodedException {
    public FetchBlobModuleUnavailableException() {
        super("Unable to store the response body as a blob because React Native's BlobModule is not available. Make sure your app includes the React Native blob support or read the body with arrayBuffer() instead", null, 2, null);
    }
}
