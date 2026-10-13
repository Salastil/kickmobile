package com.datadog.android.internal.attributes;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalAttribute.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a8\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u001a8\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003¨\u0006\u000b"}, d2 = {"enrichWithConstantAttribute", "", "", "", "attribute", "Lcom/datadog/android/internal/attributes/LocalAttribute$Constant;", "enrichWithLocalAttribute", "key", "Lcom/datadog/android/internal/attributes/LocalAttribute$Key;", "value", "enrichWithNonNullAttribute", "dd-sdk-android-internal_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LocalAttributeKt {
    public static final Map<String, Object> enrichWithConstantAttribute(Map<String, Object> map, LocalAttribute.Constant attribute) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        return enrichWithLocalAttribute(map, attribute.getKey(), attribute);
    }

    public static final Map<String, Object> enrichWithNonNullAttribute(Map<String, Object> map, LocalAttribute.Key key, Object obj) {
        Map<String, Object> mapEnrichWithLocalAttribute;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return (obj == null || (mapEnrichWithLocalAttribute = enrichWithLocalAttribute(map, key, obj)) == null) ? map : mapEnrichWithLocalAttribute;
    }

    public static final Map<String, Object> enrichWithLocalAttribute(Map<String, Object> map, LocalAttribute.Key key, Object obj) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        map.put(key.getString(), obj);
        return map;
    }
}
