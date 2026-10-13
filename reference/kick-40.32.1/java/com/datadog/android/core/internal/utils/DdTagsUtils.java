package com.datadog.android.core.internal.utils;

import com.datadog.android.api.context.DatadogContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DdTagsUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J \u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001c\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/core/internal/utils/DdTagsUtils;", "", "()V", "KEY_VALUE_SEPARATOR", "", "TAGS_SEPARATOR", "TAG_ENV", "TAG_SDK_VERSION", "TAG_SERVICE", "TAG_VARIANT", "TAG_VERSION", "toDdTagsMap", "", "ddContext", "Lcom/datadog/android/api/context/DatadogContext;", "tagsString", "toDdTagsString", "tags", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DdTagsUtils {
    public static final DdTagsUtils INSTANCE = new DdTagsUtils();
    private static final String KEY_VALUE_SEPARATOR = ":";
    private static final String TAGS_SEPARATOR = ",";
    public static final String TAG_ENV = "env";
    public static final String TAG_SDK_VERSION = "sdk_version";
    public static final String TAG_SERVICE = "service";
    public static final String TAG_VARIANT = "variant";
    public static final String TAG_VERSION = "version";

    private DdTagsUtils() {
    }

    public final String toDdTagsString(DatadogContext ddContext) {
        Intrinsics.checkNotNullParameter(ddContext, "ddContext");
        StringBuilder sb = new StringBuilder("service:");
        sb.append(ddContext.getService());
        sb.append(",version:");
        sb.append(ddContext.getVersion());
        sb.append(",sdk_version:");
        sb.append(ddContext.getSdkVersion());
        sb.append(",env:");
        sb.append(ddContext.getEnv());
        if (ddContext.getVariant().length() > 0) {
            sb.append(",variant:");
            sb.append(ddContext.getVariant());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final String toDdTagsString(Map<String, String> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        return CollectionsKt.joinToString$default(tags.entrySet(), ",", null, null, 0, null, new Function1<Map.Entry<? extends String, ? extends String>, CharSequence>() { // from class: com.datadog.android.core.internal.utils.DdTagsUtils.toDdTagsString.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends String> entry) {
                return invoke2((Map.Entry<String, String>) entry);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Map.Entry<String, String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ((Object) it.getKey()) + ":" + ((Object) it.getValue());
            }
        }, 30, null);
    }

    public final Map<String, String> toDdTagsMap(DatadogContext ddContext) {
        Intrinsics.checkNotNullParameter(ddContext, "ddContext");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("service", ddContext.getService());
        linkedHashMap.put("version", ddContext.getVersion());
        linkedHashMap.put("sdk_version", ddContext.getSdkVersion());
        linkedHashMap.put("env", ddContext.getEnv());
        if (ddContext.getVariant().length() > 0) {
            linkedHashMap.put("variant", ddContext.getVariant());
        }
        return linkedHashMap;
    }

    public final Map<String, String> toDdTagsMap(String tagsString) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listSplit$default = tagsString != null ? StringsKt.split$default((CharSequence) tagsString, new String[]{","}, false, 0, 6, (Object) null) : null;
        List list = listSplit$default;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            List listSplit$default2 = StringsKt.split$default((CharSequence) it.next(), new String[]{":"}, false, 2, 2, (Object) null);
            if (listSplit$default2.size() != 2 || ((CharSequence) listSplit$default2.get(0)).length() <= 0 || ((CharSequence) listSplit$default2.get(1)).length() <= 0) {
                listSplit$default2 = null;
            }
            if (listSplit$default2 != null) {
                linkedHashMap.put(listSplit$default2.get(0), listSplit$default2.get(1));
            }
        }
        if (linkedHashMap.isEmpty()) {
            return null;
        }
        return linkedHashMap;
    }
}
