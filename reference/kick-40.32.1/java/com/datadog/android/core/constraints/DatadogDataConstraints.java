package com.datadog.android.core.constraints;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.utils.MapUtilsKt;
import com.datadog.android.log.LogAttributes;
import com.datadog.android.rum.internal.RumFeature;
import io.ktor.util.date.GMTDateParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: DatadogDataConstraints.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002JP\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u001a0\u0019\"\u0004\b\u0000\u0010\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u001a0\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001fH\u0016J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0006H\u0016J(\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020#0\u00192\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020#0\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0002`\t0\u0006X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000b¨\u0006&"}, d2 = {"Lcom/datadog/android/core/constraints/DatadogDataConstraints;", "Lcom/datadog/android/core/constraints/DataConstraints;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "(Lcom/datadog/android/api/InternalLogger;)V", "tagTransforms", "", "Lkotlin/Function1;", "", "Lcom/datadog/android/core/internal/constraints/StringTransform;", "getTagTransforms$annotations", "()V", "convertAttributeKey", "rawKey", "prefixDotCount", "", "convertTag", "rawTag", "isKeyReserved", "", "tag", "resolveDiscardedAttrsWarning", "attributesGroupName", "discardedCount", "validateAttributes", "", ExifInterface.GPS_DIRECTION_TRUE, RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "keyPrefix", "reservedKeys", "", "validateTags", "tags", "validateTimings", "", "timings", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatadogDataConstraints implements DataConstraints {
    public static final String CUSTOM_TIMING_KEY_REPLACED_WARNING = "Invalid timing name: %s, sanitized to: %s";
    private static final int MAX_ATTR_COUNT = 128;
    private static final int MAX_DEPTH_LEVEL = 9;
    private static final int MAX_TAG_COUNT = 100;
    private static final int MAX_TAG_LENGTH = 200;
    private final InternalLogger internalLogger;
    private final List<Function1<String, String>> tagTransforms;
    private static final Set<String> reservedTagKeys = SetsKt.setOf((Object[]) new String[]{LogAttributes.HOST, "device", "source"});

    private static /* synthetic */ void getTagTransforms$annotations() {
    }

    public DatadogDataConstraints(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
        this.tagTransforms = CollectionsKt.listOf((Object[]) new Function1[]{new Function1<String, String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$tagTransforms$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = it.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
        }, new Function1<String, String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$tagTransforms$2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CharRange charRange = new CharRange('a', GMTDateParser.ZONE);
                Character orNull = StringsKt.getOrNull(it, 0);
                if (orNull == null || !charRange.contains(orNull.charValue())) {
                    return null;
                }
                return it;
            }
        }, new Function1<String, String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$tagTransforms$3
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new Regex("[^a-z0-9_:./-]").replace(it, "_");
            }
        }, new Function1<String, String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$tagTransforms$4
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String str = it;
                if (!StringsKt.endsWith$default((CharSequence) str, AbstractJsonLexerKt.COLON, false, 2, (Object) null)) {
                    return it;
                }
                String strSubstring = it.substring(0, StringsKt.getLastIndex(str));
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                return strSubstring;
            }
        }, new Function1<String, String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$tagTransforms$5
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.length() <= 200) {
                    return it;
                }
                String strSubstring = it.substring(0, 200);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                return strSubstring;
            }
        }, new Function1<String, String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$tagTransforms$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (this.this$0.isKeyReserved(it)) {
                    return null;
                }
                return it;
            }
        }});
    }

    @Override // com.datadog.android.core.constraints.DataConstraints
    public List<String> validateTags(List<String> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        ArrayList arrayList = new ArrayList();
        for (final String str : tags) {
            final String strConvertTag = convertTag(str);
            if (strConvertTag == null) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$validateTags$convertedTags$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "\"" + str + "\" is an invalid tag, and was ignored.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            } else if (!Intrinsics.areEqual(strConvertTag, str)) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$validateTags$convertedTags$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "tag \"" + str + "\" was modified to \"" + strConvertTag + "\" to match our constraints.";
                    }
                }, (Throwable) null, true, (Map) null, 40, (Object) null);
            }
            if (strConvertTag != null) {
                arrayList.add(strConvertTag);
            }
        }
        ArrayList arrayList2 = arrayList;
        final int size = arrayList2.size() - 100;
        if (size > 0) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints.validateTags.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "too many tags were added, " + size + " had to be discarded.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return CollectionsKt.take(arrayList2, 100);
    }

    @Override // com.datadog.android.core.constraints.DataConstraints
    public <T> Map<String, T> validateAttributes(Map<String, ? extends T> attributes, String keyPrefix, String attributesGroupName, Set<String> reservedKeys) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(reservedKeys, "reservedKeys");
        int i = 0;
        if (keyPrefix != null) {
            String str = keyPrefix;
            int i2 = 0;
            while (i < str.length()) {
                if (str.charAt(i) == '.') {
                    i2++;
                }
                i++;
            }
            i = i2 + 1;
        }
        ArrayList arrayList = new ArrayList();
        for (final Map.Entry<String, ? extends T> entry : attributes.entrySet()) {
            Pair pair = null;
            if (entry.getKey() == null) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$validateAttributes$convertedAttributes$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "\"" + entry + "\" is an invalid attribute, and was ignored.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            } else if (reservedKeys.contains(entry.getKey())) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$validateAttributes$convertedAttributes$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "\"" + entry + "\" key was in the reservedKeys set, and was dropped.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            } else {
                final String strConvertAttributeKey = convertAttributeKey(entry.getKey(), i);
                if (!Intrinsics.areEqual(strConvertAttributeKey, entry.getKey())) {
                    InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$validateAttributes$convertedAttributes$1$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String key = entry.getKey();
                            return "Key \"" + ((Object) key) + "\" was modified to \"" + strConvertAttributeKey + "\" to match our constraints.";
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                }
                pair = TuplesKt.to(strConvertAttributeKey, entry.getValue());
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size() - 128;
        if (size > 0) {
            final String strResolveDiscardedAttrsWarning = resolveDiscardedAttrsWarning(attributesGroupName, size);
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints.validateAttributes.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return strResolveDiscardedAttrsWarning;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return MapUtilsKt.toMutableMap(CollectionsKt.take(arrayList2, 128));
    }

    private final String resolveDiscardedAttrsWarning(String attributesGroupName, int discardedCount) {
        if (attributesGroupName != null) {
            return "Too many attributes were added for [" + attributesGroupName + "], " + discardedCount + " had to be discarded.";
        }
        return "Too many attributes were added, " + discardedCount + " had to be discarded.";
    }

    private final String convertTag(String rawTag) {
        Iterator<T> it = this.tagTransforms.iterator();
        while (it.hasNext()) {
            rawTag = rawTag == null ? null : (String) ((Function1) it.next()).invoke(rawTag);
        }
        return rawTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isKeyReserved(String tag) {
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) tag, AbstractJsonLexerKt.COLON, 0, false, 6, (Object) null);
        if (iIndexOf$default <= 0) {
            return false;
        }
        String strSubstring = tag.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return reservedTagKeys.contains(strSubstring);
    }

    private final String convertAttributeKey(String rawKey, int prefixDotCount) {
        String str = rawKey;
        ArrayList arrayList = new ArrayList(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '.' && (prefixDotCount = prefixDotCount + 1) > 9) {
                cCharAt = '_';
            }
            arrayList.add(Character.valueOf(cCharAt));
        }
        return new String(CollectionsKt.toCharArray(arrayList));
    }

    @Override // com.datadog.android.core.constraints.DataConstraints
    public Map<String, Long> validateTimings(Map<String, Long> timings) {
        Intrinsics.checkNotNullParameter(timings, "timings");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(timings.size()));
        Iterator<T> it = timings.entrySet().iterator();
        while (it.hasNext()) {
            final Map.Entry entry = (Map.Entry) it.next();
            final String strReplace = new Regex("[^a-zA-Z0-9\\-_.@$]").replace((CharSequence) entry.getKey(), "_");
            if (!Intrinsics.areEqual(strReplace, entry.getKey())) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.constraints.DatadogDataConstraints$validateTimings$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, DatadogDataConstraints.CUSTOM_TIMING_KEY_REPLACED_WARNING, Arrays.copyOf(new Object[]{entry.getKey(), strReplace}, 2));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
            linkedHashMap.put(strReplace, entry.getValue());
        }
        return MapsKt.toMutableMap(linkedHashMap);
    }
}
