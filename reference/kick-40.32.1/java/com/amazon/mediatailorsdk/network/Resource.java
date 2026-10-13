package com.amazon.mediatailorsdk.network;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.cast.MediaError;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Resource.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 +*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002*+BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003JV\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010'\u001a\u00020(HÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006,"}, d2 = {"Lcom/amazon/mediatailorsdk/network/Resource;", ExifInterface.GPS_DIRECTION_TRUE, "", "status", "Lcom/amazon/mediatailorsdk/network/Resource$Status;", "data", "message", "", "error", "", "requestTime", "", "responseTime", "<init>", "(Lcom/amazon/mediatailorsdk/network/Resource$Status;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;JJ)V", "getStatus", "()Lcom/amazon/mediatailorsdk/network/Resource$Status;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "getError", "()Ljava/lang/Throwable;", "getRequestTime", "()J", "getResponseTime", "isSuccess", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/amazon/mediatailorsdk/network/Resource$Status;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;JJ)Lcom/amazon/mediatailorsdk/network/Resource;", "equals", "other", "hashCode", "", "toString", "Status", "Companion", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Resource<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final T data;
    private final Throwable error;
    private final String message;
    private final long requestTime;
    private final long responseTime;
    private final Status status;

    /* JADX INFO: compiled from: Resource.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/amazon/mediatailorsdk/network/Resource$Status;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", MediaError.ERROR_TYPE_ERROR, "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum Status {
        SUCCESS,
        ERROR;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Resource copy$default(Resource resource, Status status, Object obj, String str, Throwable th, long j, long j2, int i, Object obj2) {
        if ((i & 1) != 0) {
            status = resource.status;
        }
        if ((i & 2) != 0) {
            obj = resource.data;
        }
        if ((i & 4) != 0) {
            str = resource.message;
        }
        if ((i & 8) != 0) {
            th = resource.error;
        }
        if ((i & 16) != 0) {
            j = resource.requestTime;
        }
        if ((i & 32) != 0) {
            j2 = resource.responseTime;
        }
        long j3 = j2;
        long j4 = j;
        return resource.copy(status, obj, str, th, j4, j3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    public final T component2() {
        return this.data;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Throwable getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getRequestTime() {
        return this.requestTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getResponseTime() {
        return this.responseTime;
    }

    public final Resource<T> copy(Status status, T data, String message, Throwable error, long requestTime, long responseTime) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new Resource<>(status, data, message, error, requestTime, responseTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Resource)) {
            return false;
        }
        Resource resource = (Resource) other;
        return this.status == resource.status && Intrinsics.areEqual(this.data, resource.data) && Intrinsics.areEqual(this.message, resource.message) && Intrinsics.areEqual(this.error, resource.error) && this.requestTime == resource.requestTime && this.responseTime == resource.responseTime;
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        T t = this.data;
        int iHashCode2 = (iHashCode + (t == null ? 0 : t.hashCode())) * 31;
        String str = this.message;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Throwable th = this.error;
        return ((((iHashCode3 + (th != null ? th.hashCode() : 0)) * 31) + Long.hashCode(this.requestTime)) * 31) + Long.hashCode(this.responseTime);
    }

    public String toString() {
        return "Resource(status=" + this.status + ", data=" + this.data + ", message=" + this.message + ", error=" + this.error + ", requestTime=" + this.requestTime + ", responseTime=" + this.responseTime + ")";
    }

    public Resource(Status status, T t, String str, Throwable th, long j, long j2) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
        this.data = t;
        this.message = str;
        this.error = th;
        this.requestTime = j;
        this.responseTime = j2;
    }

    public /* synthetic */ Resource(Status status, Object obj, String str, Throwable th, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(status, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : th, (i & 16) != 0 ? 0L : j, (i & 32) != 0 ? 0L : j2);
    }

    public final Status getStatus() {
        return this.status;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Throwable getError() {
        return this.error;
    }

    public final long getRequestTime() {
        return this.requestTime;
    }

    public final long getResponseTime() {
        return this.responseTime;
    }

    /* JADX INFO: compiled from: Resource.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\b\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\r\u001a\u00020\u000e\u0082\u0002\u0004\n\u0002\b9¨\u0006\u000f"}, d2 = {"Lcom/amazon/mediatailorsdk/network/Resource$Companion;", "", "<init>", "()V", FirebaseAnalytics.Param.SUCCESS, "Lcom/amazon/mediatailorsdk/network/Resource;", ExifInterface.GPS_DIRECTION_TRUE, "data", "requestTime", "", "responseTime", "(Ljava/lang/Object;JJ)Lcom/amazon/mediatailorsdk/network/Resource;", "error", "failure", "", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Resource<T> success(T data, long requestTime, long responseTime) {
            return new Resource<>(Status.SUCCESS, data, null, null, requestTime, responseTime, 12, null);
        }

        public final <T> Resource<T> error(Throwable failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            Status status = Status.ERROR;
            String message = failure.getMessage();
            if (message == null) {
                message = "Something went wrong";
            }
            return new Resource<>(status, null, message, failure, 0L, 0L, 50, null);
        }
    }

    public final boolean isSuccess() {
        return this.status == Status.SUCCESS && this.data != null;
    }
}
