package io.datazoom.sdk.network.events.model;

import com.facebook.hermes.intl.Constants;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: EventResponse.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 82\u00020\u0001:\u0003678BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bBS\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003JK\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020\rHÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R&\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R&\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016¨\u00069"}, d2 = {"Lio/datazoom/sdk/network/events/model/EventResponse;", "", "hasErrors", "", "itemCount", "statusCode", "items", "", "Lio/datazoom/sdk/network/events/model/EventResponse$EventReply;", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHasErrors$annotations", "()V", "getHasErrors", "()Ljava/lang/String;", "setHasErrors", "(Ljava/lang/String;)V", "getItemCount$annotations", "getItemCount", "setItemCount", "getStatusCode$annotations", "getStatusCode", "setStatusCode", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getStatus", "setStatus", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$base", "EventReply", "$serializer", "Companion", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class EventResponse {
    private String hasErrors;
    private String itemCount;
    private List<EventReply> items;
    private String status;
    private String statusCode;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.datazoom.sdk.network.events.model.EventResponse$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventResponse._childSerializers$_anonymous_();
        }
    }), null};

    public EventResponse() {
        this((String) null, (String) null, (String) null, (List) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(EventResponse$EventReply$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventResponse copy$default(EventResponse eventResponse, String str, String str2, String str3, List list, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventResponse.hasErrors;
        }
        if ((i & 2) != 0) {
            str2 = eventResponse.itemCount;
        }
        if ((i & 4) != 0) {
            str3 = eventResponse.statusCode;
        }
        if ((i & 8) != 0) {
            list = eventResponse.items;
        }
        if ((i & 16) != 0) {
            str4 = eventResponse.status;
        }
        String str5 = str4;
        String str6 = str3;
        return eventResponse.copy(str, str2, str6, list, str5);
    }

    @SerialName("has_errors")
    public static /* synthetic */ void getHasErrors$annotations() {
    }

    @SerialName("item_count")
    public static /* synthetic */ void getItemCount$annotations() {
    }

    @SerialName("status_code")
    public static /* synthetic */ void getStatusCode$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHasErrors() {
        return this.hasErrors;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getItemCount() {
        return this.itemCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStatusCode() {
        return this.statusCode;
    }

    public final List<EventReply> component4() {
        return this.items;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final EventResponse copy(String hasErrors, String itemCount, String statusCode, List<EventReply> items, String status) {
        return new EventResponse(hasErrors, itemCount, statusCode, items, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventResponse)) {
            return false;
        }
        EventResponse eventResponse = (EventResponse) other;
        return Intrinsics.areEqual(this.hasErrors, eventResponse.hasErrors) && Intrinsics.areEqual(this.itemCount, eventResponse.itemCount) && Intrinsics.areEqual(this.statusCode, eventResponse.statusCode) && Intrinsics.areEqual(this.items, eventResponse.items) && Intrinsics.areEqual(this.status, eventResponse.status);
    }

    public int hashCode() {
        String str = this.hasErrors;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.itemCount;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.statusCode;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<EventReply> list = this.items;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.status;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "EventResponse(hasErrors=" + this.hasErrors + ", itemCount=" + this.itemCount + ", statusCode=" + this.statusCode + ", items=" + this.items + ", status=" + this.status + ")";
    }

    /* JADX INFO: compiled from: EventResponse.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/network/events/model/EventResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/datazoom/sdk/network/events/model/EventResponse;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<EventResponse> serializer() {
            return EventResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ EventResponse(int i, String str, String str2, String str3, List list, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.hasErrors = null;
        } else {
            this.hasErrors = str;
        }
        if ((i & 2) == 0) {
            this.itemCount = null;
        } else {
            this.itemCount = str2;
        }
        if ((i & 4) == 0) {
            this.statusCode = null;
        } else {
            this.statusCode = str3;
        }
        if ((i & 8) == 0) {
            this.items = null;
        } else {
            this.items = list;
        }
        if ((i & 16) == 0) {
            this.status = null;
        } else {
            this.status = str4;
        }
    }

    public EventResponse(String str, String str2, String str3, List<EventReply> list, String str4) {
        this.hasErrors = str;
        this.itemCount = str2;
        this.statusCode = str3;
        this.items = list;
        this.status = str4;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$base(EventResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.hasErrors != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.hasErrors);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.itemCount != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.itemCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.statusCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.statusCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.items != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.items);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.status == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.status);
    }

    public /* synthetic */ EventResponse(String str, String str2, String str3, List list, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : str4);
    }

    public final String getHasErrors() {
        return this.hasErrors;
    }

    public final void setHasErrors(String str) {
        this.hasErrors = str;
    }

    public final String getItemCount() {
        return this.itemCount;
    }

    public final void setItemCount(String str) {
        this.itemCount = str;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(String str) {
        this.statusCode = str;
    }

    public final List<EventReply> getItems() {
        return this.items;
    }

    public final void setItems(List<EventReply> list) {
        this.items = list;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    /* JADX INFO: compiled from: EventResponse.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\nHÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R&\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u0006/"}, d2 = {"Lio/datazoom/sdk/network/events/model/EventResponse$EventReply;", "", "eventId", "", "statusCode", "error", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEventId$annotations", "()V", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "getStatusCode$annotations", "getStatusCode", "setStatusCode", "getError", "setError", "getStatus", "setStatus", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$base", "$serializer", "Companion", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final /* data */ class EventReply {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String error;
        private String eventId;
        private String status;
        private String statusCode;

        public EventReply() {
            this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ EventReply copy$default(EventReply eventReply, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = eventReply.eventId;
            }
            if ((i & 2) != 0) {
                str2 = eventReply.statusCode;
            }
            if ((i & 4) != 0) {
                str3 = eventReply.error;
            }
            if ((i & 8) != 0) {
                str4 = eventReply.status;
            }
            return eventReply.copy(str, str2, str3, str4);
        }

        @SerialName("event_id")
        public static /* synthetic */ void getEventId$annotations() {
        }

        @SerialName("status_code")
        public static /* synthetic */ void getStatusCode$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEventId() {
            return this.eventId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getStatusCode() {
            return this.statusCode;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        public final EventReply copy(String eventId, String statusCode, String error, String status) {
            return new EventReply(eventId, statusCode, error, status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EventReply)) {
                return false;
            }
            EventReply eventReply = (EventReply) other;
            return Intrinsics.areEqual(this.eventId, eventReply.eventId) && Intrinsics.areEqual(this.statusCode, eventReply.statusCode) && Intrinsics.areEqual(this.error, eventReply.error) && Intrinsics.areEqual(this.status, eventReply.status);
        }

        public int hashCode() {
            String str = this.eventId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.statusCode;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.error;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.status;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "EventReply(eventId=" + this.eventId + ", statusCode=" + this.statusCode + ", error=" + this.error + ", status=" + this.status + ")";
        }

        /* JADX INFO: compiled from: EventResponse.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/datazoom/sdk/network/events/model/EventResponse$EventReply$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/datazoom/sdk/network/events/model/EventResponse$EventReply;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<EventReply> serializer() {
                return EventResponse$EventReply$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ EventReply(int i, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.eventId = null;
            } else {
                this.eventId = str;
            }
            if ((i & 2) == 0) {
                this.statusCode = null;
            } else {
                this.statusCode = str2;
            }
            if ((i & 4) == 0) {
                this.error = null;
            } else {
                this.error = str3;
            }
            if ((i & 8) == 0) {
                this.status = null;
            } else {
                this.status = str4;
            }
        }

        public EventReply(String str, String str2, String str3, String str4) {
            this.eventId = str;
            this.statusCode = str2;
            this.error = str3;
            this.status = str4;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$base(EventReply self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.eventId != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.eventId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.statusCode != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.statusCode);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.error != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.error);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.status == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.status);
        }

        public /* synthetic */ EventReply(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
        }

        public final String getEventId() {
            return this.eventId;
        }

        public final void setEventId(String str) {
            this.eventId = str;
        }

        public final String getStatusCode() {
            return this.statusCode;
        }

        public final void setStatusCode(String str) {
            this.statusCode = str;
        }

        public final String getError() {
            return this.error;
        }

        public final void setError(String str) {
            this.error = str;
        }

        public final String getStatus() {
            return this.status;
        }

        public final void setStatus(String str) {
            this.status = str;
        }
    }
}
