package io.datazoom.sdk;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import expo.modules.notifications.service.NotificationsService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkEvent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0004\t\n\u000b\fB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lio/datazoom/sdk/SdkEvent;", ExifInterface.GPS_DIRECTION_TRUE, "", "data", "<init>", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "SdkInit", "ContextCreated", "ContextDestroyed", "SdkError", "Lio/datazoom/sdk/SdkEvent$ContextCreated;", "Lio/datazoom/sdk/SdkEvent$ContextDestroyed;", "Lio/datazoom/sdk/SdkEvent$SdkError;", "Lio/datazoom/sdk/SdkEvent$SdkInit;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class SdkEvent<T> {
    private final T data;

    public /* synthetic */ SdkEvent(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj);
    }

    /* JADX INFO: compiled from: SdkEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0002HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/datazoom/sdk/SdkEvent$SdkInit;", "Lio/datazoom/sdk/SdkEvent;", "", "apiKey", "<init>", "(Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SdkInit extends SdkEvent<String> {
        private final String apiKey;

        public static /* synthetic */ SdkInit copy$default(SdkInit sdkInit, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sdkInit.apiKey;
            }
            return sdkInit.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getApiKey() {
            return this.apiKey;
        }

        public final SdkInit copy(String apiKey) {
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            return new SdkInit(apiKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SdkInit) && Intrinsics.areEqual(this.apiKey, ((SdkInit) other).apiKey);
        }

        public int hashCode() {
            return this.apiKey.hashCode();
        }

        public String toString() {
            return "SdkInit(apiKey=" + this.apiKey + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SdkInit(String apiKey) {
            super(apiKey, null);
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            this.apiKey = apiKey;
        }

        public final String getApiKey() {
            return this.apiKey;
        }
    }

    private SdkEvent(T t) {
        this.data = t;
    }

    public final T getData() {
        return this.data;
    }

    /* JADX INFO: compiled from: SdkEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0002HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/datazoom/sdk/SdkEvent$ContextCreated;", "Lio/datazoom/sdk/SdkEvent;", "", "contextId", "<init>", "(Ljava/lang/String;)V", "getContextId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ContextCreated extends SdkEvent<String> {
        private final String contextId;

        public static /* synthetic */ ContextCreated copy$default(ContextCreated contextCreated, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = contextCreated.contextId;
            }
            return contextCreated.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getContextId() {
            return this.contextId;
        }

        public final ContextCreated copy(String contextId) {
            Intrinsics.checkNotNullParameter(contextId, "contextId");
            return new ContextCreated(contextId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ContextCreated) && Intrinsics.areEqual(this.contextId, ((ContextCreated) other).contextId);
        }

        public int hashCode() {
            return this.contextId.hashCode();
        }

        public String toString() {
            return "ContextCreated(contextId=" + this.contextId + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContextCreated(String contextId) {
            super(contextId, null);
            Intrinsics.checkNotNullParameter(contextId, "contextId");
            this.contextId = contextId;
        }

        public final String getContextId() {
            return this.contextId;
        }
    }

    /* JADX INFO: compiled from: SdkEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0002HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/datazoom/sdk/SdkEvent$ContextDestroyed;", "Lio/datazoom/sdk/SdkEvent;", "", "contextId", "<init>", "(Ljava/lang/String;)V", "getContextId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ContextDestroyed extends SdkEvent<String> {
        private final String contextId;

        public static /* synthetic */ ContextDestroyed copy$default(ContextDestroyed contextDestroyed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = contextDestroyed.contextId;
            }
            return contextDestroyed.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getContextId() {
            return this.contextId;
        }

        public final ContextDestroyed copy(String contextId) {
            Intrinsics.checkNotNullParameter(contextId, "contextId");
            return new ContextDestroyed(contextId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ContextDestroyed) && Intrinsics.areEqual(this.contextId, ((ContextDestroyed) other).contextId);
        }

        public int hashCode() {
            return this.contextId.hashCode();
        }

        public String toString() {
            return "ContextDestroyed(contextId=" + this.contextId + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContextDestroyed(String contextId) {
            super(contextId, null);
            Intrinsics.checkNotNullParameter(contextId, "contextId");
            this.contextId = contextId;
        }

        public final String getContextId() {
            return this.contextId;
        }
    }

    /* JADX INFO: compiled from: SdkEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/datazoom/sdk/SdkEvent$SdkError;", "Lio/datazoom/sdk/SdkEvent;", "", NotificationsService.EXCEPTION_KEY, "<init>", "(Ljava/lang/Throwable;)V", "getException", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SdkError extends SdkEvent<Throwable> {
        private final Throwable exception;

        public static /* synthetic */ SdkError copy$default(SdkError sdkError, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = sdkError.exception;
            }
            return sdkError.copy(th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Throwable getException() {
            return this.exception;
        }

        public final SdkError copy(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return new SdkError(exception);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SdkError) && Intrinsics.areEqual(this.exception, ((SdkError) other).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "SdkError(exception=" + this.exception + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SdkError(Throwable exception) {
            super(exception, null);
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public final Throwable getException() {
            return this.exception;
        }
    }
}
