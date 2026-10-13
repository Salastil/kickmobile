package io.datazoom.sdk.network;

import com.facebook.hermes.intl.Constants;
import io.ktor.http.Headers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResponseHeaders.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001j\u0002`\u0005*\u00020\u0006*.\u0010\u0000\"\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u00012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001¨\u0006\u0007"}, d2 = {"ResponseHeaders", "", "", "", "asResponseHeaders", "Lio/datazoom/sdk/network/ResponseHeaders;", "Lio/ktor/http/Headers;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ResponseHeadersKt {
    public static final Map<String, List<String>> asResponseHeaders(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Iterator<T> it = headers.entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            mapCreateMapBuilder.put((String) entry.getKey(), CollectionsKt.toList((List) entry.getValue()));
        }
        return MapsKt.build(mapCreateMapBuilder);
    }
}
