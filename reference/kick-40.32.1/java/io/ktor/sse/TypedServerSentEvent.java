package io.ktor.sse;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ServerSentEvent.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0013JR\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u00020\u001fHÖ\u0081\u0004¢\u0006\u0004\b \u0010!J\u0011\u0010\u000e\u001a\u00020\u0004HÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b&\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b)\u0010\u0013¨\u0006*"}, d2 = {"Lio/ktor/sse/TypedServerSentEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/sse/ServerSentEventMetadata;", "data", "", "event", "id", "", "retry", "comments", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "Lkotlin/Function1;", "serializer", "toString", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "component1", "()Ljava/lang/Object;", "component2", "()Ljava/lang/String;", "component3", "component4", "()Ljava/lang/Long;", "component5", "copy", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lio/ktor/sse/TypedServerSentEvent;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/Object;", "getData", "Ljava/lang/String;", "getEvent", "getId", "Ljava/lang/Long;", "getRetry", "getComments", "ktor-sse"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class TypedServerSentEvent<T> implements ServerSentEventMetadata<T> {
    private final String comments;
    private final T data;
    private final String event;
    private final String id;
    private final Long retry;

    public TypedServerSentEvent() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TypedServerSentEvent copy$default(TypedServerSentEvent typedServerSentEvent, Object obj, String str, String str2, Long l, String str3, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = typedServerSentEvent.data;
        }
        if ((i & 2) != 0) {
            str = typedServerSentEvent.event;
        }
        if ((i & 4) != 0) {
            str2 = typedServerSentEvent.id;
        }
        if ((i & 8) != 0) {
            l = typedServerSentEvent.retry;
        }
        if ((i & 16) != 0) {
            str3 = typedServerSentEvent.comments;
        }
        String str4 = str3;
        String str5 = str2;
        return typedServerSentEvent.copy(obj, str, str5, l, str4);
    }

    public final T component1() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getRetry() {
        return this.retry;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getComments() {
        return this.comments;
    }

    public final TypedServerSentEvent<T> copy(T data, String event, String id, Long retry, String comments) {
        return new TypedServerSentEvent<>(data, event, id, retry, comments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TypedServerSentEvent)) {
            return false;
        }
        TypedServerSentEvent typedServerSentEvent = (TypedServerSentEvent) other;
        return Intrinsics.areEqual(this.data, typedServerSentEvent.data) && Intrinsics.areEqual(this.event, typedServerSentEvent.event) && Intrinsics.areEqual(this.id, typedServerSentEvent.id) && Intrinsics.areEqual(this.retry, typedServerSentEvent.retry) && Intrinsics.areEqual(this.comments, typedServerSentEvent.comments);
    }

    public int hashCode() {
        T t = this.data;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        String str = this.event;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.id;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.retry;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.comments;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "TypedServerSentEvent(data=" + this.data + ", event=" + this.event + ", id=" + this.id + ", retry=" + this.retry + ", comments=" + this.comments + ')';
    }

    public TypedServerSentEvent(T t, String str, String str2, Long l, String str3) {
        this.data = t;
        this.event = str;
        this.id = str2;
        this.retry = l;
        this.comments = str3;
    }

    public /* synthetic */ TypedServerSentEvent(Object obj, String str, String str2, Long l, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str3);
    }

    @Override // io.ktor.sse.ServerSentEventMetadata
    public T getData() {
        return this.data;
    }

    @Override // io.ktor.sse.ServerSentEventMetadata
    public String getEvent() {
        return this.event;
    }

    @Override // io.ktor.sse.ServerSentEventMetadata
    public String getId() {
        return this.id;
    }

    @Override // io.ktor.sse.ServerSentEventMetadata
    public Long getRetry() {
        return this.retry;
    }

    @Override // io.ktor.sse.ServerSentEventMetadata
    public String getComments() {
        return this.comments;
    }

    public final String toString(Function1<? super T, String> serializer) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        T data = getData();
        return ServerSentEventKt.eventToString(data != null ? serializer.invoke(data) : null, getEvent(), getId(), getRetry(), getComments());
    }
}
