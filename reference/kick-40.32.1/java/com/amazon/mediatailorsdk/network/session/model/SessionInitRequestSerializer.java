package com.amazon.mediatailorsdk.network.session.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: SessionInitRequest.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/amazon/mediatailorsdk/network/session/model/SessionInitRequestSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/amazon/mediatailorsdk/network/session/model/SessionInitRequest;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SessionInitRequestSerializer implements KSerializer<SessionInitRequest> {
    public static final SessionInitRequestSerializer INSTANCE = new SessionInitRequestSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor$default("SessionInitRequest", new SerialDescriptor[0], null, 4, null);

    private SessionInitRequestSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SessionInitRequest value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        Map mutableMap = MapsKt.toMutableMap(value.getRootParams());
        if (!value.getPlayerParams().isEmpty()) {
            HashMap<String, String> playerParams = value.getPlayerParams();
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(playerParams.size()));
            Iterator<T> it = playerParams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), JsonElementKt.JsonPrimitive((String) entry.getValue()));
            }
            mutableMap.put("playerParams", new JsonObject(linkedHashMap));
        }
        ((JsonEncoder) encoder).encodeJsonElement(new JsonObject(mutableMap));
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SessionInitRequest deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        JsonElement jsonElementDecodeJsonElement = ((JsonDecoder) decoder).decodeJsonElement();
        Intrinsics.checkNotNull(jsonElementDecodeJsonElement, "null cannot be cast to non-null type kotlinx.serialization.json.JsonObject");
        for (Map.Entry<String, JsonElement> entry : ((JsonObject) jsonElementDecodeJsonElement).entrySet()) {
            if (Intrinsics.areEqual(entry.getKey(), "playerParams") && (entry.getValue() instanceof JsonObject)) {
                JsonElement value = entry.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlinx.serialization.json.JsonObject");
                for (Map.Entry<String, JsonElement> entry2 : ((JsonObject) value).entrySet()) {
                    map2.put(entry2.getKey(), entry2.getValue().toString());
                }
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return new SessionInitRequest(map, map2);
    }
}
