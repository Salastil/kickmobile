package com.datadog.android.core.internal.system;

import android.app.ActivityManager;
import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.TelephonyManager;
import android.view.Display;
import com.datadog.android.api.context.DeviceType;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCaseKt;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: DefaultAndroidInfoProvider.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\b\u0000\u0018\u0000 C2\u00020\u0001:\u0001CB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u001b\u0010\r\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u001b\u0010\u001c\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001d\u0010\u000fR\u001b\u0010\u001f\u001a\u00020 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b$\u0010&R!\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0011\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u00010.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0011\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0011\u001a\u0004\b7\u0010\u000fR\u0014\u00109\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u000fR\u0014\u0010;\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u000fR\u001b\u0010=\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0011\u001a\u0004\b>\u0010\u000fR\u001d\u0010@\u001a\u0004\u0018\u00010.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0011\u001a\u0004\bA\u00104¨\u0006D"}, d2 = {"Lcom/datadog/android/core/internal/system/DefaultAndroidInfoProvider;", "Lcom/datadog/android/core/internal/system/AndroidInfoProvider;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "rawDeviceBrand", "", "rawDeviceModel", "rawDeviceId", "rawOsVersion", "buildSdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;)V", "architecture", "getArchitecture", "()Ljava/lang/String;", "architecture$delegate", "Lkotlin/Lazy;", "currentLocale", "getCurrentLocale", "currentLocale$delegate", "deviceBrand", "getDeviceBrand", "deviceBrand$delegate", "deviceBuildId", "getDeviceBuildId", "deviceModel", "getDeviceModel", "deviceName", "getDeviceName", "deviceName$delegate", "deviceType", "Lcom/datadog/android/api/context/DeviceType;", "getDeviceType", "()Lcom/datadog/android/api/context/DeviceType;", "deviceType$delegate", "isLowRam", "", "()Ljava/lang/Boolean;", "isLowRam$delegate", "locales", "", "getLocales", "()Ljava/util/List;", "locales$delegate", "logicalCpuCount", "", "getLogicalCpuCount", "()I", "logicalCpuCount$delegate", "numberOfDisplays", "getNumberOfDisplays", "()Ljava/lang/Integer;", "numberOfDisplays$delegate", "osMajorVersion", "getOsMajorVersion", "osMajorVersion$delegate", "osName", "getOsName", "osVersion", "getOsVersion", "timeZone", "getTimeZone", "timeZone$delegate", "totalRam", "getTotalRam", "totalRam$delegate", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultAndroidInfoProvider implements AndroidInfoProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String FEATURE_GOOGLE_ANDROID_TV = "com.google.android.tv";
    public static final long MB_IN_BYTES = 1048576;
    public static final int MIN_TABLET_WIDTH_DP = 800;

    /* JADX INFO: renamed from: architecture$delegate, reason: from kotlin metadata */
    private final Lazy architecture;
    private final BuildSdkVersionProvider buildSdkVersionProvider;

    /* JADX INFO: renamed from: currentLocale$delegate, reason: from kotlin metadata */
    private final Lazy currentLocale;

    /* JADX INFO: renamed from: deviceBrand$delegate, reason: from kotlin metadata */
    private final Lazy deviceBrand;
    private final String deviceBuildId;
    private final String deviceModel;

    /* JADX INFO: renamed from: deviceName$delegate, reason: from kotlin metadata */
    private final Lazy deviceName;

    /* JADX INFO: renamed from: deviceType$delegate, reason: from kotlin metadata */
    private final Lazy deviceType;

    /* JADX INFO: renamed from: isLowRam$delegate, reason: from kotlin metadata */
    private final Lazy isLowRam;

    /* JADX INFO: renamed from: locales$delegate, reason: from kotlin metadata */
    private final Lazy locales;

    /* JADX INFO: renamed from: logicalCpuCount$delegate, reason: from kotlin metadata */
    private final Lazy logicalCpuCount;

    /* JADX INFO: renamed from: numberOfDisplays$delegate, reason: from kotlin metadata */
    private final Lazy numberOfDisplays;

    /* JADX INFO: renamed from: osMajorVersion$delegate, reason: from kotlin metadata */
    private final Lazy osMajorVersion;
    private final String osName;
    private final String osVersion;

    /* JADX INFO: renamed from: timeZone$delegate, reason: from kotlin metadata */
    private final Lazy timeZone;

    /* JADX INFO: renamed from: totalRam$delegate, reason: from kotlin metadata */
    private final Lazy totalRam;

    public DefaultAndroidInfoProvider(final Context appContext, final String rawDeviceBrand, final String rawDeviceModel, String rawDeviceId, String rawOsVersion, BuildSdkVersionProvider buildSdkVersionProvider) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(rawDeviceBrand, "rawDeviceBrand");
        Intrinsics.checkNotNullParameter(rawDeviceModel, "rawDeviceModel");
        Intrinsics.checkNotNullParameter(rawDeviceId, "rawDeviceId");
        Intrinsics.checkNotNullParameter(rawOsVersion, "rawOsVersion");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.deviceType = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<DeviceType>() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$deviceType$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DeviceType invoke() {
                return DefaultAndroidInfoProvider.INSTANCE.resolveDeviceType(rawDeviceModel, appContext);
            }
        });
        this.deviceName = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$deviceName$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                boolean zIsBlank = StringsKt.isBlank(this.this$0.getDeviceBrand());
                DefaultAndroidInfoProvider defaultAndroidInfoProvider = this.this$0;
                if (zIsBlank) {
                    return defaultAndroidInfoProvider.getDeviceModel();
                }
                boolean zContains$default = StringsKt.contains$default((CharSequence) defaultAndroidInfoProvider.getDeviceModel(), (CharSequence) this.this$0.getDeviceBrand(), false, 2, (Object) null);
                DefaultAndroidInfoProvider defaultAndroidInfoProvider2 = this.this$0;
                if (zContains$default) {
                    return defaultAndroidInfoProvider2.getDeviceModel();
                }
                return defaultAndroidInfoProvider2.getDeviceBrand() + ServerSentEventKt.SPACE + this.this$0.getDeviceModel();
            }
        });
        this.locales = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<List<String>>() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$locales$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<String> invoke() {
                String languageTag;
                String languageTag2;
                Resources resources = appContext.getResources();
                ArrayList arrayList = new ArrayList();
                if (this.buildSdkVersionProvider.getIsAtLeastN()) {
                    LocaleList locales = resources.getConfiguration().getLocales();
                    Intrinsics.checkNotNullExpressionValue(locales, "resources.configuration.locales");
                    int size = locales.size();
                    for (int i = 0; i < size; i++) {
                        Locale locale = locales.get(i);
                        if (locale != null && (languageTag2 = locale.toLanguageTag()) != null) {
                            arrayList.add(languageTag2);
                        }
                    }
                } else {
                    Locale locale2 = resources.getConfiguration().locale;
                    if (locale2 != null && (languageTag = locale2.toLanguageTag()) != null) {
                        arrayList.add(languageTag);
                    }
                }
                return arrayList;
            }
        });
        this.currentLocale = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$currentLocale$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Resources resources = appContext.getResources();
                String languageTag = null;
                if (this.buildSdkVersionProvider.getIsAtLeastN()) {
                    Locale locale = resources.getConfiguration().getLocales().get(0);
                    if (locale != null) {
                        languageTag = locale.toLanguageTag();
                    }
                } else {
                    Locale locale2 = resources.getConfiguration().locale;
                    if (locale2 != null) {
                        languageTag = locale2.toLanguageTag();
                    }
                }
                return languageTag == null ? Locale.getDefault().toLanguageTag() : languageTag;
            }
        });
        this.timeZone = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$timeZone$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return TimeZone.getDefault().getID();
            }
        });
        this.deviceBrand = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$deviceBrand$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String strValueOf;
                String str = rawDeviceBrand;
                if (str.length() <= 0) {
                    return str;
                }
                StringBuilder sb = new StringBuilder();
                char cCharAt = str.charAt(0);
                if (Character.isLowerCase(cCharAt)) {
                    Locale US = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    strValueOf = CharsKt.titlecase(cCharAt, US);
                } else {
                    strValueOf = String.valueOf(cCharAt);
                }
                sb.append((Object) strValueOf);
                String strSubstring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                sb.append(strSubstring);
                return sb.toString();
            }
        });
        this.deviceModel = rawDeviceModel;
        this.deviceBuildId = rawDeviceId;
        this.osName = GetDeviceInfoUseCaseKt.PLATFORM;
        this.osVersion = rawOsVersion;
        this.osMajorVersion = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$osMajorVersion$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return (String) CollectionsKt.first(StringsKt.split$default((CharSequence) this.this$0.getOsVersion(), new char[]{FilenameUtils.EXTENSION_SEPARATOR}, false, 0, 6, (Object) null));
            }
        });
        this.architecture = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$architecture$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String property = System.getProperty("os.arch");
                return property == null ? "unknown" : property;
            }
        });
        this.numberOfDisplays = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Integer>() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$numberOfDisplays$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Object systemService = appContext.getSystemService("display");
                if (!(systemService instanceof DisplayManager)) {
                    systemService = null;
                }
                DisplayManager displayManager = (DisplayManager) systemService;
                if (displayManager == null) {
                    return null;
                }
                Display[] displays = displayManager.getDisplays();
                Intrinsics.checkNotNullExpressionValue(displays, "displayManager.displays");
                int i = 0;
                for (Display display : displays) {
                    if (!SetsKt.setOf((Object[]) new Integer[]{1, 0}).contains(Integer.valueOf(display.getState()))) {
                        i++;
                    }
                }
                return Integer.valueOf(i);
            }
        });
        this.logicalCpuCount = LazyKt.lazy(new Function0<Integer>() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$logicalCpuCount$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(Runtime.getRuntime().availableProcessors());
            }
        });
        this.totalRam = LazyKt.lazy(new Function0<Integer>() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$totalRam$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                try {
                    ActivityManager activityManager = (ActivityManager) appContext.getSystemService(ActivityManager.class);
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    return Integer.valueOf((int) (memoryInfo.totalMem / 1048576));
                } catch (Exception unused) {
                    return null;
                }
            }
        });
        this.isLowRam = LazyKt.lazy(new Function0<Boolean>() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider.isLowRam.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                try {
                    return Boolean.valueOf(((ActivityManager) appContext.getSystemService(ActivityManager.class)).isLowRamDevice());
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    public /* synthetic */ DefaultAndroidInfoProvider(Context context, String str, String str2, String str3, String str4, BuildSdkVersionProvider buildSdkVersionProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, str3, str4, (i & 32) != 0 ? BuildSdkVersionProvider.INSTANCE.getDEFAULT() : buildSdkVersionProvider);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DefaultAndroidInfoProvider(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        String str = Build.BRAND;
        String str2 = str == null ? "" : str;
        String str3 = Build.MODEL;
        String str4 = str3 == null ? "" : str3;
        String str5 = Build.ID;
        String str6 = str5 == null ? "" : str5;
        String str7 = Build.VERSION.RELEASE;
        this(appContext, str2, str4, str6, str7 == null ? "" : str7, null, 32, null);
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public DeviceType getDeviceType() {
        return (DeviceType) this.deviceType.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceName() {
        return (String) this.deviceName.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public List<String> getLocales() {
        return (List) this.locales.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getCurrentLocale() {
        Object value = this.currentLocale.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-currentLocale>(...)");
        return (String) value;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getTimeZone() {
        Object value = this.timeZone.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-timeZone>(...)");
        return (String) value;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceBrand() {
        return (String) this.deviceBrand.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceModel() {
        return this.deviceModel;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceBuildId() {
        return this.deviceBuildId;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getOsName() {
        return this.osName;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getOsVersion() {
        return this.osVersion;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getOsMajorVersion() {
        return (String) this.osMajorVersion.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getArchitecture() {
        return (String) this.architecture.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public Integer getNumberOfDisplays() {
        return (Integer) this.numberOfDisplays.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public int getLogicalCpuCount() {
        return ((Number) this.logicalCpuCount.getValue()).intValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public Integer getTotalRam() {
        return (Integer) this.totalRam.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    /* JADX INFO: renamed from: isLowRam */
    public Boolean getIsLowRam() {
        return (Boolean) this.isLowRam.getValue();
    }

    /* JADX INFO: compiled from: DefaultAndroidInfoProvider.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/core/internal/system/DefaultAndroidInfoProvider$Companion;", "", "()V", "FEATURE_GOOGLE_ANDROID_TV", "", "MB_IN_BYTES", "", "MIN_TABLET_WIDTH_DP", "", "hasTvFeature", "", "packageManager", "Landroid/content/pm/PackageManager;", "isMobile", "model", "appContext", "Landroid/content/Context;", "isTablet", "isTv", "resolveDeviceType", "Lcom/datadog/android/api/context/DeviceType;", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DeviceType resolveDeviceType(String model, Context appContext) {
            if (isTv(appContext)) {
                return DeviceType.TV;
            }
            if (isTablet(model, appContext)) {
                return DeviceType.TABLET;
            }
            if (isMobile(model, appContext)) {
                return DeviceType.MOBILE;
            }
            return DeviceType.OTHER;
        }

        private final boolean isTv(Context appContext) {
            Object systemService = appContext.getSystemService("uimode");
            if (!(systemService instanceof UiModeManager)) {
                systemService = null;
            }
            UiModeManager uiModeManager = (UiModeManager) systemService;
            if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
                return true;
            }
            PackageManager packageManager = appContext.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "appContext.packageManager");
            return hasTvFeature(packageManager);
        }

        private final boolean hasTvFeature(PackageManager packageManager) {
            return packageManager.hasSystemFeature("android.software.leanback") || packageManager.hasSystemFeature(DefaultAndroidInfoProvider.FEATURE_GOOGLE_ANDROID_TV);
        }

        private final boolean isTablet(String model, Context appContext) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = model.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String str = lowerCase;
            return StringsKt.contains$default((CharSequence) str, (CharSequence) "tablet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "sm-t", false, 2, (Object) null) || appContext.getResources().getConfiguration().smallestScreenWidthDp >= 800;
        }

        private final boolean isMobile(String model, Context appContext) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = model.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            boolean z = false;
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "phone", false, 2, (Object) null)) {
                return true;
            }
            Object systemService = appContext.getSystemService("phone");
            TelephonyManager telephonyManager = (TelephonyManager) (systemService instanceof TelephonyManager ? systemService : null);
            if (telephonyManager != null && telephonyManager.getPhoneType() == 0) {
                z = true;
            }
            return !z;
        }
    }
}
