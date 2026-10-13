package io.datazoom.sdk.mediatailor;

import com.amazon.mediatailorsdk.network.tracking.model.AdTrackingResponse;
import io.datazoom.sdk.ad.DzAdSessionMetadata;
import io.datazoom.sdk.logs.Logger_androidKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: MediaTailor.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\tH\u0002J\u0014\u0010\u000b\u001a\u00020\f*\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0013\u001a\u00020\f*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0015H\u0002J\u0014\u0010\u0016\u001a\u00020\u0007*\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lio/datazoom/sdk/mediatailor/IvsAdTrackingInfoParser;", "", "<init>", "()V", "trackingDataJson", "Lkotlinx/serialization/json/Json;", "parse", "Lcom/amazon/mediatailorsdk/network/tracking/model/AdTrackingResponse;", "adSessionMetadata", "Lio/datazoom/sdk/ad/DzAdSessionMetadata;", "toAdTrackingResponse", "alignStartTimes", "Lkotlinx/serialization/json/JsonElement;", "element", "alignAvailStartTimes", "offset", "", "alignAdStartTimes", "alignTrackingEventStartTimes", "shiftBy", "decodeBase64Utf8", "", "applyFallbackAvailIds", "response", "mediatailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IvsAdTrackingInfoParser {
    public static final IvsAdTrackingInfoParser INSTANCE = new IvsAdTrackingInfoParser();
    private static final Json trackingDataJson = JsonKt.Json$default(null, new Function1() { // from class: io.datazoom.sdk.mediatailor.IvsAdTrackingInfoParser$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return IvsAdTrackingInfoParser.trackingDataJson$lambda$0((JsonBuilder) obj);
        }
    }, 1, null);

    private IvsAdTrackingInfoParser() {
    }

    static final Unit trackingDataJson$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setCoerceInputValues(true);
        Json.setExplicitNulls(false);
        return Unit.INSTANCE;
    }

    public final AdTrackingResponse parse(DzAdSessionMetadata adSessionMetadata) {
        Intrinsics.checkNotNullParameter(adSessionMetadata, "adSessionMetadata");
        return toAdTrackingResponse(adSessionMetadata);
    }

    private final AdTrackingResponse toAdTrackingResponse(DzAdSessionMetadata dzAdSessionMetadata) {
        Object objM12684constructorimpl;
        if (StringsKt.isBlank(dzAdSessionMetadata.getTrackingData()) || Intrinsics.areEqual(dzAdSessionMetadata.getTrackingData(), "no_tracking_info")) {
            Logger_androidKt.getLogger().w("MediaTailor IVS ad tracking info is missing for ad id " + dzAdSessionMetadata.getAdId());
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            IvsAdTrackingInfoParser ivsAdTrackingInfoParser = INSTANCE;
            Json json = trackingDataJson;
            JsonElement jsonElementAlignStartTimes = ivsAdTrackingInfoParser.alignStartTimes(dzAdSessionMetadata, json.parseToJsonElement(ivsAdTrackingInfoParser.decodeBase64Utf8(dzAdSessionMetadata.getTrackingData())));
            SerializersModule serializersModule = json.getSerializersModule();
            KType kTypeTypeOf = Reflection.typeOf(AdTrackingResponse.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            objM12684constructorimpl = Result.m12684constructorimpl(ivsAdTrackingInfoParser.applyFallbackAvailIds(dzAdSessionMetadata, (AdTrackingResponse) json.decodeFromJsonElement(SerializersKt.serializer(serializersModule, kTypeTypeOf), jsonElementAlignStartTimes)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("MediaTailor failed to parse IVS ad tracking info for ad id " + dzAdSessionMetadata.getAdId() + ": " + thM12687exceptionOrNullimpl.getMessage());
        }
        return (AdTrackingResponse) (Result.m12690isFailureimpl(objM12684constructorimpl) ? null : objM12684constructorimpl);
    }

    private final JsonElement alignStartTimes(DzAdSessionMetadata dzAdSessionMetadata, JsonElement jsonElement) {
        JsonElement jsonElement2;
        JsonObject jsonObject;
        JsonElement jsonElement3;
        JsonPrimitive jsonPrimitive;
        Double doubleOrNull;
        Double startTimeInSeconds = dzAdSessionMetadata.getStartTimeInSeconds();
        if (startTimeInSeconds != null) {
            double dDoubleValue = startTimeInSeconds.doubleValue();
            JsonObject jsonObject2 = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
            if (jsonObject2 != null) {
                Object obj = jsonObject2.get((Object) "avails");
                JsonArray jsonArray = obj instanceof JsonArray ? (JsonArray) obj : null;
                if (jsonArray != null && (jsonElement2 = (JsonElement) CollectionsKt.firstOrNull((List) jsonArray)) != null && (jsonObject = JsonElementKt.getJsonObject(jsonElement2)) != null && (jsonElement3 = (JsonElement) jsonObject.get((Object) "startTimeInSeconds")) != null && (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement3)) != null && (doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive)) != null) {
                    double dDoubleValue2 = dDoubleValue - doubleOrNull.doubleValue();
                    JsonObject jsonObject3 = jsonObject2;
                    LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(jsonObject3.size()));
                    Iterator<T> it = jsonObject3.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        Object key = entry.getKey();
                        String str = (String) entry.getKey();
                        JsonArray jsonArray2 = (JsonElement) entry.getValue();
                        if (Intrinsics.areEqual(str, "avails")) {
                            JsonArray jsonArray3 = jsonArray;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray3, 10));
                            Iterator<JsonElement> it2 = jsonArray3.iterator();
                            while (it2.hasNext()) {
                                arrayList.add(INSTANCE.alignAvailStartTimes(it2.next(), dDoubleValue2));
                            }
                            jsonArray2 = new JsonArray(arrayList);
                        }
                        linkedHashMap.put(key, jsonArray2);
                    }
                    return new JsonObject(linkedHashMap);
                }
            }
        }
        return jsonElement;
    }

    private final JsonElement alignAvailStartTimes(JsonElement element, double offset) {
        ArrayList arrayListEmptyList;
        JsonObject jsonObject = element instanceof JsonObject ? (JsonObject) element : null;
        if (jsonObject == null) {
            return element;
        }
        JsonObject jsonObject2 = jsonObject;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(jsonObject2.size()));
        Iterator<T> it = jsonObject2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            String str = (String) entry.getKey();
            JsonNull jsonNullShiftBy = (JsonElement) entry.getValue();
            int iHashCode = str.hashCode();
            if (iHashCode != -1558548469) {
                if (iHashCode != -444971696) {
                    if (iHashCode == 96432 && str.equals("ads")) {
                        JsonArray jsonArray = jsonNullShiftBy instanceof JsonArray ? (JsonArray) jsonNullShiftBy : null;
                        if (jsonArray == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        } else {
                            JsonArray jsonArray2 = jsonArray;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray2, 10));
                            Iterator<JsonElement> it2 = jsonArray2.iterator();
                            while (it2.hasNext()) {
                                arrayList.add(INSTANCE.alignAdStartTimes(it2.next(), offset));
                            }
                            arrayListEmptyList = arrayList;
                        }
                        jsonNullShiftBy = new JsonArray(arrayListEmptyList);
                    }
                } else if (str.equals("availProgramDateTime")) {
                    jsonNullShiftBy = JsonNull.INSTANCE;
                }
            } else if (str.equals("startTimeInSeconds")) {
                jsonNullShiftBy = INSTANCE.shiftBy(jsonNullShiftBy, offset);
            }
            linkedHashMap.put(key, jsonNullShiftBy);
        }
        return new JsonObject(linkedHashMap);
    }

    private final JsonElement alignAdStartTimes(JsonElement element, double offset) {
        ArrayList arrayListEmptyList;
        JsonObject jsonObject = element instanceof JsonObject ? (JsonObject) element : null;
        if (jsonObject == null) {
            return element;
        }
        JsonObject jsonObject2 = jsonObject;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(jsonObject2.size()));
        Iterator<T> it = jsonObject2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            String str = (String) entry.getKey();
            JsonNull jsonNullShiftBy = (JsonElement) entry.getValue();
            int iHashCode = str.hashCode();
            if (iHashCode != -1558548469) {
                if (iHashCode != 1199206300) {
                    if (iHashCode == 1613547184 && str.equals("trackingEvents")) {
                        JsonArray jsonArray = jsonNullShiftBy instanceof JsonArray ? (JsonArray) jsonNullShiftBy : null;
                        if (jsonArray == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        } else {
                            JsonArray jsonArray2 = jsonArray;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray2, 10));
                            Iterator<JsonElement> it2 = jsonArray2.iterator();
                            while (it2.hasNext()) {
                                arrayList.add(INSTANCE.alignTrackingEventStartTimes(it2.next(), offset));
                            }
                            arrayListEmptyList = arrayList;
                        }
                        jsonNullShiftBy = new JsonArray(arrayListEmptyList);
                    }
                } else if (str.equals("adProgramDateTime")) {
                    jsonNullShiftBy = JsonNull.INSTANCE;
                }
            } else if (str.equals("startTimeInSeconds")) {
                jsonNullShiftBy = INSTANCE.shiftBy(jsonNullShiftBy, offset);
            }
            linkedHashMap.put(key, jsonNullShiftBy);
        }
        return new JsonObject(linkedHashMap);
    }

    private final JsonElement alignTrackingEventStartTimes(JsonElement element, double offset) {
        JsonObject jsonObject = element instanceof JsonObject ? (JsonObject) element : null;
        if (jsonObject == null) {
            return element;
        }
        JsonObject jsonObject2 = jsonObject;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(jsonObject2.size()));
        Iterator<T> it = jsonObject2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            String str = (String) entry.getKey();
            JsonElement jsonElementShiftBy = (JsonElement) entry.getValue();
            if (Intrinsics.areEqual(str, "startTimeInSeconds")) {
                jsonElementShiftBy = INSTANCE.shiftBy(jsonElementShiftBy, offset);
            }
            linkedHashMap.put(key, jsonElementShiftBy);
        }
        return new JsonObject(linkedHashMap);
    }

    private final JsonElement shiftBy(JsonElement jsonElement, double d) {
        JsonPrimitive JsonPrimitive;
        Double doubleOrNull = JsonElementKt.getDoubleOrNull(JsonElementKt.getJsonPrimitive(jsonElement));
        return (doubleOrNull == null || (JsonPrimitive = JsonElementKt.JsonPrimitive(Double.valueOf(doubleOrNull.doubleValue() + d))) == null) ? jsonElement : JsonPrimitive;
    }

    private final String decodeBase64Utf8(String str) {
        Object objM12684constructorimpl;
        String string = StringsKt.trim((CharSequence) str).toString();
        try {
            Result.Companion companion = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(Base64.decode$default(Base64.INSTANCE, string, 0, 0, 6, (Object) null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12687exceptionOrNullimpl(objM12684constructorimpl) != null) {
            objM12684constructorimpl = Base64.decode$default(Base64.INSTANCE.getUrlSafe(), string, 0, 0, 6, (Object) null);
        }
        return new String((byte[]) objM12684constructorimpl, Charsets.UTF_8);
    }

    private final AdTrackingResponse applyFallbackAvailIds(DzAdSessionMetadata dzAdSessionMetadata, AdTrackingResponse adTrackingResponse) {
        AdTrackingResponse.Avail[] avails = adTrackingResponse.getAvails();
        int i = 0;
        if (avails != null) {
            int length = avails.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                AdTrackingResponse.Avail avail = avails[i2];
                int i4 = i3 + 1;
                String availId = avail.getAvailId();
                if (availId == null || StringsKt.isBlank(availId)) {
                    avail.setAvailId(dzAdSessionMetadata.getSessionId() + "_" + dzAdSessionMetadata.getAdId() + "_" + i3);
                }
                i2++;
                i3 = i4;
            }
        }
        AdTrackingResponse.NonLinearAvail[] nonLinearAvails = adTrackingResponse.getNonLinearAvails();
        if (nonLinearAvails != null) {
            int length2 = nonLinearAvails.length;
            int i5 = 0;
            while (i < length2) {
                AdTrackingResponse.NonLinearAvail nonLinearAvail = nonLinearAvails[i];
                int i6 = i5 + 1;
                String availId2 = nonLinearAvail.getAvailId();
                if (availId2 == null || StringsKt.isBlank(availId2)) {
                    nonLinearAvail.setAvailId(dzAdSessionMetadata.getSessionId() + "_" + dzAdSessionMetadata.getAdId() + "_nonlinear_" + i5);
                }
                i++;
                i5 = i6;
            }
        }
        return adTrackingResponse;
    }
}
