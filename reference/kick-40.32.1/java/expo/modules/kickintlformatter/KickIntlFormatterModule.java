package expo.modules.kickintlformatter;

import android.content.Context;
import android.content.res.Configuration;
import android.icu.number.Notation;
import android.icu.number.NumberFormatter;
import android.icu.text.CompactDecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Build;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.trace.api.DDTags;
import com.facebook.hermes.intl.Constants;
import com.horcrux.svg.TSpanView$$ExternalSyntheticApiModelOutline0;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import io.github.expo.pika.IntrospectionOfKt;
import io.github.expo.pika.IsIntrospectableKt;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import j$.util.DesugarTimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: KickIntlFormatterModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u001eH\u0002J \u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0018\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010&\u001a\u00020'H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lexpo/modules/kickintlformatter/KickIntlFormatterModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "numberFormatterCache", "Ljava/util/HashMap;", "", "", "dateFormatterCache", "Ljava/text/DateFormat;", "isoParserCache", "Ljava/text/SimpleDateFormat;", "localizedContextCache", "Landroid/content/Context;", "fractionalSecondsRegex", "Lkotlin/text/Regex;", "formatNumber", "number", "", Constants.LOCALE, "compact", "", "(DLjava/lang/String;Ljava/lang/Boolean;)Ljava/lang/String;", "getTranslatedLanguageName", DDTags.LANGUAGE_TAG_KEY, "getDateFromString", "Ljava/util/Date;", "dateString", "getLocalizedContext", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Ljava/util/Locale;", "getRelativeTime", "getCachedDateFormatter", "style", "getShortTime", "getLongDate", "getLongDateTime", "getLongDateTimeWithWeekday", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "kick-intl-formatter_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickIntlFormatterModule extends Module {
    private final HashMap<String, Object> numberFormatterCache = new HashMap<>();
    private final HashMap<String, DateFormat> dateFormatterCache = new HashMap<>();
    private final HashMap<String, SimpleDateFormat> isoParserCache = new HashMap<>();
    private final HashMap<String, Context> localizedContextCache = new HashMap<>();
    private final Regex fractionalSecondsRegex = new Regex("\\.(\\d+)(Z|[+-]\\d{2}:\\d{2})$");

    public static /* synthetic */ String formatNumber$default(KickIntlFormatterModule kickIntlFormatterModule, double d, String str, Boolean bool, int i, Object obj) {
        if ((i & 4) != 0) {
            bool = false;
        }
        return kickIntlFormatterModule.formatNumber(d, str, bool);
    }

    public final String formatNumber(double number, String locale, Boolean compact) {
        Object numberFormat;
        Intrinsics.checkNotNullParameter(locale, "locale");
        HashMap<String, Object> map = this.numberFormatterCache;
        String str = locale + "|" + (!Intrinsics.areEqual((Object) compact, (Object) false));
        Object obj = map.get(str);
        Object obj2 = obj;
        if (obj == null) {
            Locale localeForLanguageTag = Locale.forLanguageTag(locale);
            if (!Intrinsics.areEqual((Object) compact, (Object) false)) {
                CompactDecimalFormat compactDecimalFormat = CompactDecimalFormat.getInstance(localeForLanguageTag, CompactDecimalFormat.CompactStyle.SHORT);
                compactDecimalFormat.setMaximumFractionDigits(1);
                numberFormat = compactDecimalFormat;
            } else if (Build.VERSION.SDK_INT >= 30) {
                numberFormat = TSpanView$$ExternalSyntheticApiModelOutline0.m11709m((Object) NumberFormatter.with().notation(TSpanView$$ExternalSyntheticApiModelOutline0.m11706m((Object) Notation.simple()))).locale(localeForLanguageTag);
            } else {
                numberFormat = NumberFormat.getInstance(localeForLanguageTag);
            }
            Object obj3 = numberFormat;
            Intrinsics.checkNotNull(obj3);
            map.put(str, obj3);
            obj2 = obj3;
        }
        if (obj2 instanceof NumberFormat) {
            String str2 = ((NumberFormat) obj2).format(number);
            Intrinsics.checkNotNull(str2);
            return str2;
        }
        String string = TSpanView$$ExternalSyntheticApiModelOutline0.m(obj2).format(number).toString();
        Intrinsics.checkNotNull(string);
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTranslatedLanguageName(String language, String locale) {
        try {
            Locale localeForLanguageTag = Locale.forLanguageTag(language);
            String displayName = localeForLanguageTag.getDisplayName(Locale.forLanguageTag(locale));
            Intrinsics.checkNotNull(displayName);
            if (displayName.length() <= 0) {
                return displayName;
            }
            StringBuilder sb = new StringBuilder();
            char cCharAt = displayName.charAt(0);
            Intrinsics.checkNotNull(localeForLanguageTag);
            sb.append((Object) CharsKt.uppercase(cCharAt, localeForLanguageTag));
            String strSubstring = displayName.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            sb.append(strSubstring);
            return sb.toString();
        } catch (Exception unused) {
            String upperCase = language.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }
    }

    private final Date getDateFromString(String dateString) {
        String str;
        try {
            String strReplace = this.fractionalSecondsRegex.replace(dateString, new Function1() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return KickIntlFormatterModule.getDateFromString$lambda$0((MatchResult) obj);
                }
            });
            if (StringsKt.endsWith$default(strReplace, "Z", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) strReplace, (CharSequence) ".", false, 2, (Object) null)) {
                str = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
            } else if (StringsKt.endsWith$default(strReplace, "Z", false, 2, (Object) null)) {
                str = "yyyy-MM-dd'T'HH:mm:ssX";
            } else {
                str = StringsKt.contains$default((CharSequence) strReplace, (CharSequence) ".", false, 2, (Object) null) ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : "yyyy-MM-dd'T'HH:mm:ssXXX";
            }
            HashMap<String, SimpleDateFormat> map = this.isoParserCache;
            String str2 = str + "|" + Locale.getDefault().toLanguageTag();
            SimpleDateFormat simpleDateFormat = map.get(str2);
            if (simpleDateFormat == null) {
                simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
                map.put(str2, simpleDateFormat);
            }
            return simpleDateFormat.parse(strReplace);
        } catch (Exception unused) {
            return null;
        }
    }

    static final CharSequence getDateFromString$lambda$0(MatchResult match) {
        Intrinsics.checkNotNullParameter(match, "match");
        return "." + StringsKt.take(StringsKt.padEnd(match.getGroupValues().get(1), 3, '0'), 3) + ((Object) match.getGroupValues().get(2));
    }

    private final Context getLocalizedContext(Context context, Locale locale) {
        HashMap<String, Context> map = this.localizedContextCache;
        String languageTag = locale.toLanguageTag();
        Context contextCreateConfigurationContext = map.get(languageTag);
        if (contextCreateConfigurationContext == null) {
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            configuration.setLocale(locale);
            contextCreateConfigurationContext = context.createConfigurationContext(configuration);
            Intrinsics.checkNotNullExpressionValue(contextCreateConfigurationContext, "createConfigurationContext(...)");
            map.put(languageTag, contextCreateConfigurationContext);
        }
        return contextCreateConfigurationContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getRelativeTime(Context context, String dateString, String locale) {
        Date dateFromString = getDateFromString(dateString);
        if (dateFromString == null) {
            return "Invalid date";
        }
        long time = new Date().getTime() - dateFromString.getTime();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long j = time / 1000;
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        long j2 = time / DurationKt.MILLIS_IN_MINUTE;
        TimeUnit timeUnit3 = TimeUnit.MILLISECONDS;
        long j3 = time / DurationKt.MILLIS_IN_HOUR;
        TimeUnit timeUnit4 = TimeUnit.MILLISECONDS;
        long j4 = time / 86400000;
        long j5 = j4 / 7;
        long j6 = j4 / 30;
        long j7 = j4 / 365;
        Locale localeForLanguageTag = Locale.forLanguageTag(locale);
        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
        Context localizedContext = getLocalizedContext(context, localeForLanguageTag);
        if (j < 60) {
            String string = localizedContext.getString(R.string.time_just_now);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (j2 < 60) {
            return getRelativeTime$pluralize(localizedContext, j2, R.string.time_minute_singular, R.string.time_minute_plural);
        }
        if (j3 < 24) {
            return getRelativeTime$pluralize(localizedContext, j3, R.string.time_hour_singular, R.string.time_hour_plural);
        }
        if (j4 < 7) {
            return getRelativeTime$pluralize(localizedContext, j4, R.string.time_day_singular, R.string.time_day_plural);
        }
        if (j4 < 30) {
            return getRelativeTime$pluralize(localizedContext, j5, R.string.time_week_singular, R.string.time_week_plural);
        }
        if (j6 < 12) {
            return getRelativeTime$pluralize(localizedContext, j6, R.string.time_month_singular, R.string.time_month_plural);
        }
        return getRelativeTime$pluralize(localizedContext, j7, R.string.time_year_singular, R.string.time_year_plural);
    }

    private static final String getRelativeTime$pluralize(Context context, long j, int i, int i2) {
        if (j != 1) {
            i = i2;
        }
        String string = context.getString(i, Long.valueOf(j));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final DateFormat getCachedDateFormatter(String style, String locale) {
        DateFormat dateInstance;
        HashMap<String, DateFormat> map = this.dateFormatterCache;
        String str = style + "|" + locale;
        DateFormat dateFormat = map.get(str);
        if (dateFormat == null) {
            Locale localeForLanguageTag = Locale.forLanguageTag(locale);
            if (Intrinsics.areEqual(style, "short-time")) {
                dateInstance = SimpleDateFormat.getTimeInstance(3, localeForLanguageTag);
            } else {
                dateInstance = Intrinsics.areEqual(style, "long-date") ? SimpleDateFormat.getDateInstance(1, localeForLanguageTag) : SimpleDateFormat.getDateTimeInstance(1, 3, localeForLanguageTag);
            }
            dateFormat = dateInstance;
            Intrinsics.checkNotNull(dateFormat);
            map.put(str, dateFormat);
        }
        return dateFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getShortTime(String dateString, String locale) {
        Date dateFromString = getDateFromString(dateString);
        if (dateFromString == null) {
            return "Invalid date";
        }
        String str = getCachedDateFormatter("short-time", locale).format(dateFromString);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLongDate(String dateString, String locale) {
        Date dateFromString = getDateFromString(dateString);
        if (dateFromString == null) {
            return "Invalid date";
        }
        String str = getCachedDateFormatter("long-date", locale).format(dateFromString);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLongDateTime(String dateString, String locale) {
        Date dateFromString = getDateFromString(dateString);
        if (dateFromString == null) {
            return "Invalid date";
        }
        String str = getCachedDateFormatter("long-date-time", locale).format(dateFromString);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLongDateTimeWithWeekday(String dateString, String locale) {
        Date dateFromString = getDateFromString(dateString);
        if (dateFromString == null) {
            return "Invalid date";
        }
        String str = getCachedDateFormatter("long-date-time", locale).format(dateFromString);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError2;
        Object objM12684constructorimpl8;
        Object objM12684constructorimpl9;
        PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError3;
        Object objM12684constructorimpl10;
        Object objM12684constructorimpl11;
        PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError4;
        Object objM12684constructorimpl12;
        Object objM12684constructorimpl13;
        PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError5;
        Object objM12684constructorimpl14;
        Object objM12684constructorimpl15;
        PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError6;
        PIntrospectionData<Object> pIntrospectionDataThrowNonReifiedIntrospectionOfError7;
        KickIntlFormatterModule kickIntlFormatterModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (kickIntlFormatterModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(kickIntlFormatterModule);
            moduleDefinitionBuilder.Name("KickIntlFormatter");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[3];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Double.class), false));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Double.TYPE);
                        }
                    }));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Double.TYPE));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError2 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError2), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                    objM12684constructorimpl2 = null;
                }
                TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                if (typeDescriptor2 == null) {
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType2 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[1] = anyType2;
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError3 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError3), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
                        }
                    }));
                } catch (Throwable th3) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                    objM12684constructorimpl3 = null;
                }
                TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                if (typeDescriptor3 == null) {
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType3 = new AnyType(typeDescriptor3, converters);
            }
            anyTypeArr[2] = anyType3;
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(String.class);
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter == null) {
                    Intrinsics.reifiedOperationMarker(6, "R");
                    boolean zThrowNonReifiedIsIntrospectableError = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
                    if (zThrowNonReifiedIsIntrospectableError) {
                        Intrinsics.reifiedOperationMarker(6, "R");
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError7 = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
                        PIntrospectionData<Object> pIntrospectionData = pIntrospectionDataThrowNonReifiedIntrospectionOfError7;
                    } else {
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError7 = null;
                    }
                    directConverter = ReturnTypeKt.getIndirectConverter(String.class, pIntrospectionDataThrowNonReifiedIntrospectionOfError7);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(String.class, returnType2);
                returnType = returnType2;
            }
            SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("formatNumber", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    Boolean bool = (Boolean) objArr[2];
                    double dDoubleValue = ((Number) obj).doubleValue();
                    return this.this$0.formatNumber(dDoubleValue, (String) obj2, bool);
                }
            });
            moduleDefinitionBuilder2.getSyncFunctions().put("formatNumber", syncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError4 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError4), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    objM12684constructorimpl4 = null;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType4 = new AnyType(typeDescriptor4, converters2);
            }
            anyTypeArr2[0] = anyType4;
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError5 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError5), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th5) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                    objM12684constructorimpl5 = null;
                }
                TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                if (typeDescriptor5 == null) {
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType5 = new AnyType(typeDescriptor5, converters2);
            }
            anyTypeArr2[1] = anyType5;
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider2.getTypes().get(String.class);
            if (returnType3 == null) {
                JSTypeConverter<?> directConverter2 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter2 == null) {
                    Intrinsics.reifiedOperationMarker(6, "R");
                    boolean zThrowNonReifiedIsIntrospectableError2 = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
                    if (zThrowNonReifiedIsIntrospectableError2) {
                        Intrinsics.reifiedOperationMarker(6, "R");
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
                        PIntrospectionData<Object> pIntrospectionData2 = pIntrospectionDataThrowNonReifiedIntrospectionOfError;
                    } else {
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError = null;
                    }
                    directConverter2 = ReturnTypeKt.getIndirectConverter(String.class, pIntrospectionDataThrowNonReifiedIntrospectionOfError);
                }
                ReturnType returnType4 = new ReturnType(directConverter2);
                returnTypeProvider2.getTypes().put(String.class, returnType4);
                returnType3 = returnType4;
            }
            SyncFunctionComponent syncFunctionComponent2 = new SyncFunctionComponent("getLocalizedLanguageName", anyTypeArr2, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    return this.this$0.getTranslatedLanguageName((String) obj, str);
                }
            });
            moduleDefinitionBuilder3.getSyncFunctions().put("getLocalizedLanguageName", syncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            TypeConverterProvider converters3 = moduleDefinitionBuilder4.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[2];
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType6 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError6 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError6), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th6) {
                    Result.Companion companion12 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                    objM12684constructorimpl6 = null;
                }
                TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
                if (typeDescriptor6 == null) {
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType6 = new AnyType(typeDescriptor6, converters3);
            }
            anyTypeArr3[0] = anyType6;
            AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType7 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError7 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError7), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th7) {
                    Result.Companion companion14 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                    objM12684constructorimpl7 = null;
                }
                TypeDescriptor typeDescriptor7 = (TypeDescriptor) objM12684constructorimpl7;
                if (typeDescriptor7 == null) {
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType7 = new AnyType(typeDescriptor7, converters3);
            }
            anyTypeArr3[1] = anyType7;
            ReturnTypeProvider returnTypeProvider3 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType5 = returnTypeProvider3.getTypes().get(String.class);
            if (returnType5 == null) {
                JSTypeConverter<?> directConverter3 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter3 == null) {
                    Intrinsics.reifiedOperationMarker(6, "R");
                    boolean zThrowNonReifiedIsIntrospectableError3 = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
                    if (zThrowNonReifiedIsIntrospectableError3) {
                        Intrinsics.reifiedOperationMarker(6, "R");
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError2 = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
                        PIntrospectionData<Object> pIntrospectionData3 = pIntrospectionDataThrowNonReifiedIntrospectionOfError2;
                    } else {
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError2 = null;
                    }
                    directConverter3 = ReturnTypeKt.getIndirectConverter(String.class, pIntrospectionDataThrowNonReifiedIntrospectionOfError2);
                }
                ReturnType returnType6 = new ReturnType(directConverter3);
                returnTypeProvider3.getTypes().put(String.class, returnType6);
                returnType5 = returnType6;
            }
            SyncFunctionComponent syncFunctionComponent3 = new SyncFunctionComponent("getRelativeTime", anyTypeArr3, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    String str2 = (String) obj;
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    if (reactContext != null) {
                        return this.this$0.getRelativeTime(reactContext, str2, str);
                    }
                    throw new IllegalArgumentException("React context is null".toString());
                }
            });
            moduleDefinitionBuilder4.getSyncFunctions().put("getRelativeTime", syncFunctionComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            TypeConverterProvider converters4 = moduleDefinitionBuilder5.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[2];
            AnyType anyType8 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType8 == null) {
                try {
                    Result.Companion companion15 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError8 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError8), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th8) {
                    Result.Companion companion16 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl8)) {
                    objM12684constructorimpl8 = null;
                }
                TypeDescriptor typeDescriptor8 = (TypeDescriptor) objM12684constructorimpl8;
                if (typeDescriptor8 == null) {
                    typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType8 = new AnyType(typeDescriptor8, converters4);
            }
            anyTypeArr4[0] = anyType8;
            AnyType anyType9 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType9 == null) {
                try {
                    Result.Companion companion17 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError9 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError9), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$12
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th9) {
                    Result.Companion companion18 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(ResultKt.createFailure(th9));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl9)) {
                    objM12684constructorimpl9 = null;
                }
                TypeDescriptor typeDescriptor9 = (TypeDescriptor) objM12684constructorimpl9;
                if (typeDescriptor9 == null) {
                    typeDescriptor9 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType9 = new AnyType(typeDescriptor9, converters4);
            }
            anyTypeArr4[1] = anyType9;
            ReturnTypeProvider returnTypeProvider4 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType7 = returnTypeProvider4.getTypes().get(String.class);
            if (returnType7 == null) {
                JSTypeConverter<?> directConverter4 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter4 == null) {
                    Intrinsics.reifiedOperationMarker(6, "R");
                    boolean zThrowNonReifiedIsIntrospectableError4 = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
                    if (zThrowNonReifiedIsIntrospectableError4) {
                        Intrinsics.reifiedOperationMarker(6, "R");
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError3 = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
                        PIntrospectionData<Object> pIntrospectionData4 = pIntrospectionDataThrowNonReifiedIntrospectionOfError3;
                    } else {
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError3 = null;
                    }
                    directConverter4 = ReturnTypeKt.getIndirectConverter(String.class, pIntrospectionDataThrowNonReifiedIntrospectionOfError3);
                }
                ReturnType returnType8 = new ReturnType(directConverter4);
                returnTypeProvider4.getTypes().put(String.class, returnType8);
                returnType7 = returnType8;
            }
            SyncFunctionComponent syncFunctionComponent4 = new SyncFunctionComponent("getShortTime", anyTypeArr4, returnType7, new Function1<Object[], Object>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    return this.this$0.getShortTime((String) obj, str);
                }
            });
            moduleDefinitionBuilder5.getSyncFunctions().put("getShortTime", syncFunctionComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            TypeConverterProvider converters5 = moduleDefinitionBuilder6.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[2];
            AnyType anyType10 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType10 == null) {
                try {
                    Result.Companion companion19 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError10 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError10), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$14
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th10) {
                    Result.Companion companion20 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(ResultKt.createFailure(th10));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl10)) {
                    objM12684constructorimpl10 = null;
                }
                TypeDescriptor typeDescriptor10 = (TypeDescriptor) objM12684constructorimpl10;
                if (typeDescriptor10 == null) {
                    typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType10 = new AnyType(typeDescriptor10, converters5);
            }
            anyTypeArr5[0] = anyType10;
            AnyType anyType11 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType11 == null) {
                try {
                    Result.Companion companion21 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError11 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError11), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$15
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th11) {
                    Result.Companion companion22 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(ResultKt.createFailure(th11));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl11)) {
                    objM12684constructorimpl11 = null;
                }
                TypeDescriptor typeDescriptor11 = (TypeDescriptor) objM12684constructorimpl11;
                if (typeDescriptor11 == null) {
                    typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType11 = new AnyType(typeDescriptor11, converters5);
            }
            anyTypeArr5[1] = anyType11;
            ReturnTypeProvider returnTypeProvider5 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType9 = returnTypeProvider5.getTypes().get(String.class);
            if (returnType9 == null) {
                JSTypeConverter<?> directConverter5 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter5 == null) {
                    Intrinsics.reifiedOperationMarker(6, "R");
                    boolean zThrowNonReifiedIsIntrospectableError5 = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
                    if (zThrowNonReifiedIsIntrospectableError5) {
                        Intrinsics.reifiedOperationMarker(6, "R");
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError4 = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
                        PIntrospectionData<Object> pIntrospectionData5 = pIntrospectionDataThrowNonReifiedIntrospectionOfError4;
                    } else {
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError4 = null;
                    }
                    directConverter5 = ReturnTypeKt.getIndirectConverter(String.class, pIntrospectionDataThrowNonReifiedIntrospectionOfError4);
                }
                ReturnType returnType10 = new ReturnType(directConverter5);
                returnTypeProvider5.getTypes().put(String.class, returnType10);
                returnType9 = returnType10;
            }
            SyncFunctionComponent syncFunctionComponent5 = new SyncFunctionComponent("getLongDate", anyTypeArr5, returnType9, new Function1<Object[], Object>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    return this.this$0.getLongDate((String) obj, str);
                }
            });
            moduleDefinitionBuilder6.getSyncFunctions().put("getLongDate", syncFunctionComponent5);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            TypeConverterProvider converters6 = moduleDefinitionBuilder7.getConverters();
            AnyType[] anyTypeArr6 = new AnyType[2];
            AnyType anyType12 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType12 == null) {
                try {
                    Result.Companion companion23 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError12 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError12), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$17
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th12) {
                    Result.Companion companion24 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(ResultKt.createFailure(th12));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl12)) {
                    objM12684constructorimpl12 = null;
                }
                TypeDescriptor typeDescriptor12 = (TypeDescriptor) objM12684constructorimpl12;
                if (typeDescriptor12 == null) {
                    typeDescriptor12 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType12 = new AnyType(typeDescriptor12, converters6);
            }
            anyTypeArr6[0] = anyType12;
            AnyType anyType13 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType13 == null) {
                try {
                    Result.Companion companion25 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError13 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl13 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError13), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$18
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th13) {
                    Result.Companion companion26 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(ResultKt.createFailure(th13));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl13)) {
                    objM12684constructorimpl13 = null;
                }
                TypeDescriptor typeDescriptor13 = (TypeDescriptor) objM12684constructorimpl13;
                if (typeDescriptor13 == null) {
                    typeDescriptor13 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType13 = new AnyType(typeDescriptor13, converters6);
            }
            anyTypeArr6[1] = anyType13;
            ReturnTypeProvider returnTypeProvider6 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType11 = returnTypeProvider6.getTypes().get(String.class);
            if (returnType11 == null) {
                JSTypeConverter<?> directConverter6 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter6 == null) {
                    Intrinsics.reifiedOperationMarker(6, "R");
                    boolean zThrowNonReifiedIsIntrospectableError6 = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
                    if (zThrowNonReifiedIsIntrospectableError6) {
                        Intrinsics.reifiedOperationMarker(6, "R");
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError5 = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
                        PIntrospectionData<Object> pIntrospectionData6 = pIntrospectionDataThrowNonReifiedIntrospectionOfError5;
                    } else {
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError5 = null;
                    }
                    directConverter6 = ReturnTypeKt.getIndirectConverter(String.class, pIntrospectionDataThrowNonReifiedIntrospectionOfError5);
                }
                ReturnType returnType12 = new ReturnType(directConverter6);
                returnTypeProvider6.getTypes().put(String.class, returnType12);
                returnType11 = returnType12;
            }
            SyncFunctionComponent syncFunctionComponent6 = new SyncFunctionComponent("getLongDateTime", anyTypeArr6, returnType11, new Function1<Object[], Object>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$19
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    return this.this$0.getLongDateTime((String) obj, str);
                }
            });
            moduleDefinitionBuilder7.getSyncFunctions().put("getLongDateTime", syncFunctionComponent6);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            TypeConverterProvider converters7 = moduleDefinitionBuilder8.getConverters();
            AnyType[] anyTypeArr7 = new AnyType[2];
            AnyType anyType14 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType14 == null) {
                try {
                    Result.Companion companion27 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError14 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl14 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError14), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$20
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th14) {
                    Result.Companion companion28 = Result.INSTANCE;
                    objM12684constructorimpl14 = Result.m12684constructorimpl(ResultKt.createFailure(th14));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl14)) {
                    objM12684constructorimpl14 = null;
                }
                TypeDescriptor typeDescriptor14 = (TypeDescriptor) objM12684constructorimpl14;
                if (typeDescriptor14 == null) {
                    typeDescriptor14 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType14 = new AnyType(typeDescriptor14, converters7);
            }
            anyTypeArr7[0] = anyType14;
            AnyType anyType15 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType15 == null) {
                try {
                    Result.Companion companion29 = Result.INSTANCE;
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError15 = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                    objM12684constructorimpl15 = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError15), new Function0<KType>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$21
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th15) {
                    Result.Companion companion30 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(ResultKt.createFailure(th15));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl15)) {
                    objM12684constructorimpl15 = null;
                }
                TypeDescriptor typeDescriptor15 = (TypeDescriptor) objM12684constructorimpl15;
                if (typeDescriptor15 == null) {
                    typeDescriptor15 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType15 = new AnyType(typeDescriptor15, converters7);
            }
            anyTypeArr7[1] = anyType15;
            ReturnTypeProvider returnTypeProvider7 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType13 = returnTypeProvider7.getTypes().get(String.class);
            if (returnType13 == null) {
                JSTypeConverter<?> directConverter7 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter7 == null) {
                    Intrinsics.reifiedOperationMarker(6, "R");
                    boolean zThrowNonReifiedIsIntrospectableError7 = IsIntrospectableKt.throwNonReifiedIsIntrospectableError();
                    MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.isIntrospectable");
                    if (zThrowNonReifiedIsIntrospectableError7) {
                        Intrinsics.reifiedOperationMarker(6, "R");
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError6 = IntrospectionOfKt.throwNonReifiedIntrospectionOfError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.introspectionOf");
                        PIntrospectionData<Object> pIntrospectionData7 = pIntrospectionDataThrowNonReifiedIntrospectionOfError6;
                    } else {
                        pIntrospectionDataThrowNonReifiedIntrospectionOfError6 = null;
                    }
                    directConverter7 = ReturnTypeKt.getIndirectConverter(String.class, pIntrospectionDataThrowNonReifiedIntrospectionOfError6);
                }
                ReturnType returnType14 = new ReturnType(directConverter7);
                returnTypeProvider7.getTypes().put(String.class, returnType14);
                returnType13 = returnType14;
            }
            SyncFunctionComponent syncFunctionComponent7 = new SyncFunctionComponent("getLongDateTimeWithWeekday", anyTypeArr7, returnType13, new Function1<Object[], Object>() { // from class: expo.modules.kickintlformatter.KickIntlFormatterModule$definition$lambda$0$$inlined$Function$22
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    return this.this$0.getLongDateTimeWithWeekday((String) obj, str);
                }
            });
            moduleDefinitionBuilder8.getSyncFunctions().put("getLongDateTimeWithWeekday", syncFunctionComponent7);
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th16) {
            Trace.endSection();
            throw th16;
        }
    }
}
