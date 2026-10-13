package io.datazoom.sdk.network.config;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.data.memory.MetaDataStore;
import io.datazoom.sdk.data.memory.MetaDataStoreExtensionsKt;
import io.datazoom.sdk.data.memory.ServerTimeOffsetPersistence;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.model.MetaData;
import io.datazoom.sdk.network.Resource;
import io.datazoom.sdk.network.config.model.ConfigDto;
import io.datazoom.sdk.network.config.model.ConfigExtraDto;
import io.datazoom.sdk.network.geo.model.GeoResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: compiled from: ConfigResponseExtras.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0000\u001a,\u0010\n\u001a\u0004\u0018\u00010\u0001*\u0018\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f0\u000bj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DZ_EXTRA_HEADER_NAME", "", "dzExtraJson", "Lkotlinx/serialization/json/Json;", "applyDzExtra", "", "Lio/datazoom/sdk/network/Resource;", "Lio/datazoom/sdk/network/config/model/ConfigDto;", "metaDataStore", "Lio/datazoom/sdk/data/memory/MetaDataStore;", "firstHeaderValue", "", "", "Lio/datazoom/sdk/network/ResponseHeaders;", "name", "decodeDzExtra", "Lio/datazoom/sdk/network/config/model/ConfigExtraDto;", "encodedValue", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ConfigResponseExtrasKt {
    private static final String DZ_EXTRA_HEADER_NAME = "dz-extra";
    private static final Json dzExtraJson = JsonKt.Json$default(null, new Function1() { // from class: io.datazoom.sdk.network.config.ConfigResponseExtrasKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return ConfigResponseExtrasKt.dzExtraJson$lambda$0((JsonBuilder) obj);
        }
    }, 1, null);

    static final Unit dzExtraJson$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    public static final boolean applyDzExtra(Resource<ConfigDto> resource, MetaDataStore metaDataStore) {
        ConfigExtraDto configExtraDtoDecodeDzExtra;
        Intrinsics.checkNotNullParameter(resource, "<this>");
        Intrinsics.checkNotNullParameter(metaDataStore, "metaDataStore");
        String strFirstHeaderValue = firstHeaderValue(resource.getResponseHeaders(), DZ_EXTRA_HEADER_NAME);
        if (strFirstHeaderValue == null || (configExtraDtoDecodeDzExtra = decodeDzExtra(strFirstHeaderValue)) == null) {
            return false;
        }
        GeoResponse geoResponse = configExtraDtoDecodeDzExtra.toGeoResponse();
        String query = geoResponse.getQuery();
        if (query != null) {
            metaDataStore.put(MetaData.Type.CLIENT_IP, query);
        }
        MetaDataStoreExtensionsKt.network(metaDataStore, geoResponse);
        MetaDataStoreExtensionsKt.geo(metaDataStore, geoResponse);
        Long lServerTimeMillis = configExtraDtoDecodeDzExtra.serverTimeMillis();
        if (lServerTimeMillis == null) {
            return true;
        }
        ServerTimeOffsetPersistence.INSTANCE.setServerTimeOffset(resource.getRequestTime(), resource.getResponseTime(), lServerTimeMillis.longValue());
        return true;
    }

    private static final String firstHeaderValue(Map<String, ? extends List<String>> map, String str) {
        Object next;
        List list;
        Iterator<T> it = map.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!StringsKt.equals((String) ((Map.Entry) next).getKey(), str, true));
        Map.Entry entry = (Map.Entry) next;
        if (entry == null || (list = (List) entry.getValue()) == null) {
            return null;
        }
        return (String) CollectionsKt.firstOrNull(list);
    }

    public static final ConfigExtraDto decodeDzExtra(String encodedValue) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(encodedValue, "encodedValue");
        try {
            Result.Companion companion = Result.INSTANCE;
            String strDecodeToString = StringsKt.decodeToString(Base64.decode$default(Base64.INSTANCE, encodedValue, 0, 0, 6, (Object) null));
            Json json = dzExtraJson;
            json.getSerializersModule();
            objM12684constructorimpl = Result.m12684constructorimpl((ConfigExtraDto) json.decodeFromString(ConfigExtraDto.INSTANCE.serializer(), strDecodeToString));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            Logger_androidKt.getLogger().e("Failed to decode dz-extra header: " + thM12687exceptionOrNullimpl.getMessage());
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        return (ConfigExtraDto) objM12684constructorimpl;
    }
}
