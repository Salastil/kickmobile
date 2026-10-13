package io.ktor.client.utils;

import com.datadog.android.rum.internal.RumFeature;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: HeadersUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a-\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\" \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/http/HeadersBuilder;", "Lio/ktor/http/HttpMethod;", FirebaseAnalytics.Param.METHOD, "Lio/ktor/util/Attributes;", RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "alwaysRemove", "", "dropCompressionHeaders", "(Lio/ktor/http/HeadersBuilder;Lio/ktor/http/HttpMethod;Lio/ktor/util/Attributes;Z)V", "Lio/ktor/util/AttributeKey;", "", "", "DecompressionListAttribute", "Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HeadersUtilsKt {
    private static final AttributeKey<List<String>> DecompressionListAttribute;

    public static /* synthetic */ void dropCompressionHeaders$default(HeadersBuilder headersBuilder, HttpMethod httpMethod, Attributes attributes, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        dropCompressionHeaders(headersBuilder, httpMethod, attributes, z);
    }

    public static final void dropCompressionHeaders(HeadersBuilder headersBuilder, HttpMethod method, Attributes attributes, boolean z) {
        Intrinsics.checkNotNullParameter(headersBuilder, "<this>");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        if (Intrinsics.areEqual(method, HttpMethod.Head) || Intrinsics.areEqual(method, HttpMethod.Options)) {
            return;
        }
        String str = headersBuilder.get("Content-Encoding");
        if (str != null) {
            ((List) attributes.computeIfAbsent(DecompressionListAttribute, new Function0() { // from class: io.ktor.client.utils.HeadersUtilsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HeadersUtilsKt.dropCompressionHeaders$lambda$0();
                }
            })).add(str);
        } else if (!z) {
            return;
        }
        headersBuilder.remove("Content-Encoding");
        headersBuilder.remove("Content-Length");
    }

    static final List dropCompressionHeaders$lambda$0() {
        return new ArrayList();
    }

    static {
        KType kTypeMutableCollectionType;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(List.class);
        try {
            kTypeMutableCollectionType = Reflection.mutableCollectionType(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
        } catch (Throwable unused) {
            kTypeMutableCollectionType = null;
        }
        DecompressionListAttribute = new AttributeKey<>("DecompressionListAttribute", new TypeInfo(orCreateKotlinClass, kTypeMutableCollectionType));
    }
}
