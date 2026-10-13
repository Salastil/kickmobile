package com.datadog.android.api.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequestExecutionContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/api/net/RequestExecutionContext;", "", "attemptNumber", "", "previousResponseCode", "(ILjava/lang/Integer;)V", "getAttemptNumber", "()I", "getPreviousResponseCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Lcom/datadog/android/api/net/RequestExecutionContext;", "equals", "", "other", "hashCode", "toString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RequestExecutionContext {
    private final int attemptNumber;
    private final Integer previousResponseCode;

    /* JADX WARN: Multi-variable type inference failed */
    public RequestExecutionContext() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RequestExecutionContext copy$default(RequestExecutionContext requestExecutionContext, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = requestExecutionContext.attemptNumber;
        }
        if ((i2 & 2) != 0) {
            num = requestExecutionContext.previousResponseCode;
        }
        return requestExecutionContext.copy(i, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAttemptNumber() {
        return this.attemptNumber;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getPreviousResponseCode() {
        return this.previousResponseCode;
    }

    public final RequestExecutionContext copy(int attemptNumber, Integer previousResponseCode) {
        return new RequestExecutionContext(attemptNumber, previousResponseCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestExecutionContext)) {
            return false;
        }
        RequestExecutionContext requestExecutionContext = (RequestExecutionContext) other;
        return this.attemptNumber == requestExecutionContext.attemptNumber && Intrinsics.areEqual(this.previousResponseCode, requestExecutionContext.previousResponseCode);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.attemptNumber) * 31;
        Integer num = this.previousResponseCode;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "RequestExecutionContext(attemptNumber=" + this.attemptNumber + ", previousResponseCode=" + this.previousResponseCode + ")";
    }

    public RequestExecutionContext(int i, Integer num) {
        this.attemptNumber = i;
        this.previousResponseCode = num;
    }

    public /* synthetic */ RequestExecutionContext(int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : num);
    }

    public final int getAttemptNumber() {
        return this.attemptNumber;
    }

    public final Integer getPreviousResponseCode() {
        return this.previousResponseCode;
    }
}
