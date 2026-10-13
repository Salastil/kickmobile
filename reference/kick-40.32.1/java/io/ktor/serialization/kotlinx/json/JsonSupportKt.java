package io.ktor.serialization.kotlinx.json;

import io.ktor.http.ContentType;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.kotlinx.KotlinxSerializationConverterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: compiled from: JsonSupport.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a%\u0010\u0002\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\u0006\"\u0017\u0010\b\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/serialization/Configuration;", "Lkotlinx/serialization/json/Json;", "json", "Lio/ktor/http/ContentType;", "contentType", "", "(Lio/ktor/serialization/Configuration;Lkotlinx/serialization/json/Json;Lio/ktor/http/ContentType;)V", "jsonIo", "DefaultJson", "Lkotlinx/serialization/json/Json;", "getDefaultJson", "()Lkotlinx/serialization/json/Json;", "ktor-serialization-kotlinx-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonSupportKt {
    private static final Json DefaultJson = JsonKt.Json$default(null, new Function1() { // from class: io.ktor.serialization.kotlinx.json.JsonSupportKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return JsonSupportKt.DefaultJson$lambda$0((JsonBuilder) obj);
        }
    }, 1, null);

    public static final Json getDefaultJson() {
        return DefaultJson;
    }

    static final Unit DefaultJson$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setEncodeDefaults(true);
        Json.setLenient(true);
        Json.setAllowSpecialFloatingPointValues(true);
        Json.setAllowStructuredMapKeys(true);
        Json.setPrettyPrint(false);
        Json.setUseArrayPolymorphism(false);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void json$default(Configuration configuration, Json json, ContentType contentType, int i, Object obj) {
        if ((i & 1) != 0) {
            json = DefaultJson;
        }
        if ((i & 2) != 0) {
            contentType = ContentType.Application.INSTANCE.getJson();
        }
        json(configuration, json, contentType);
    }

    public static final void json(Configuration configuration, Json json, ContentType contentType) {
        Intrinsics.checkNotNullParameter(configuration, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        KotlinxSerializationConverterKt.serialization(configuration, contentType, json);
    }

    public static /* synthetic */ void jsonIo$default(Configuration configuration, Json json, ContentType contentType, int i, Object obj) {
        if ((i & 1) != 0) {
            json = DefaultJson;
        }
        if ((i & 2) != 0) {
            contentType = ContentType.Application.INSTANCE.getJson();
        }
        jsonIo(configuration, json, contentType);
    }

    @ExperimentalSerializationApi
    public static final void jsonIo(Configuration configuration, Json json, ContentType contentType) {
        Intrinsics.checkNotNullParameter(configuration, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Configuration.register$default(configuration, contentType, new ExperimentalJsonConverter(json), null, 4, null);
    }
}
