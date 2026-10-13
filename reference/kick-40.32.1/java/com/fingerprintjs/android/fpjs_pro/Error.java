package com.fingerprintjs.android.fpjs_pro;

import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001B\u001f\b\u0004\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\n\u0010\t\u0082\u0001\u0017\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/Error;", "", "", "requestId", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "getRequestId", "Lcom/fingerprintjs/android/fpjs_pro/ApiKeyExpired;", "Lcom/fingerprintjs/android/fpjs_pro/ApiKeyNotFound;", "Lcom/fingerprintjs/android/fpjs_pro/ApiKeyRequired;", "Lcom/fingerprintjs/android/fpjs_pro/ClientTimeout;", "Lcom/fingerprintjs/android/fpjs_pro/Failed;", "Lcom/fingerprintjs/android/fpjs_pro/HeaderRestricted;", "Lcom/fingerprintjs/android/fpjs_pro/InstallationMethodRestricted;", "Lcom/fingerprintjs/android/fpjs_pro/InvalidProxyIntegrationHeaders;", "Lcom/fingerprintjs/android/fpjs_pro/InvalidProxyIntegrationSecret;", "Lcom/fingerprintjs/android/fpjs_pro/NetworkError;", "Lcom/fingerprintjs/android/fpjs_pro/NotAvailableForCrawlBots;", "Lcom/fingerprintjs/android/fpjs_pro/NotAvailableWithoutUA;", "Lcom/fingerprintjs/android/fpjs_pro/OriginNotAvailable;", "Lcom/fingerprintjs/android/fpjs_pro/PackageNotAuthorized;", "Lcom/fingerprintjs/android/fpjs_pro/ProxyIntegrationSecretEnvironmentMismatch;", "Lcom/fingerprintjs/android/fpjs_pro/RequestCannotBeParsed;", "Lcom/fingerprintjs/android/fpjs_pro/RequestTimeout;", "Lcom/fingerprintjs/android/fpjs_pro/ResponseCannotBeParsed;", "Lcom/fingerprintjs/android/fpjs_pro/SubscriptionNotActive;", "Lcom/fingerprintjs/android/fpjs_pro/TooManyRequest;", "Lcom/fingerprintjs/android/fpjs_pro/UnknownError;", "Lcom/fingerprintjs/android/fpjs_pro/UnsupportedVersion;", "Lcom/fingerprintjs/android/fpjs_pro/WrongRegion;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class Error {
    private final String description;
    private final String requestId;

    private Error(String str, String str2) {
        this.requestId = str;
        this.description = str2;
    }

    public /* synthetic */ Error(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ViewUtilsKt.UNKNOWN_DESTINATION_URL : str, (i & 2) != 0 ? ViewUtilsKt.UNKNOWN_DESTINATION_URL : str2, null);
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getDescription() {
        return this.description;
    }

    public /* synthetic */ Error(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }
}
