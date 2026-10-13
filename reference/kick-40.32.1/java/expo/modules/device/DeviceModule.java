package expo.modules.device;

import android.app.ActivityManager;
import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.device.yearclass.YearClass;
import expo.modules.core.utilities.EmulatorUtilities;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ConstantComponentBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCaseKt;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lexpo/modules/device/DeviceModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "deviceYearClass", "", "getDeviceYearClass", "()I", "systemName", "", "getSystemName", "()Ljava/lang/String;", "DeviceType", "Companion", "expo-device_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeviceModule extends Module {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: DeviceModule.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lexpo/modules/device/DeviceModule$DeviceType;", "", "JSValue", "", "<init>", "(Ljava/lang/String;II)V", "getJSValue", "()I", "UNKNOWN", "PHONE", "TABLET", "DESKTOP", "TV", "expo-device_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum DeviceType {
        UNKNOWN(0),
        PHONE(1),
        TABLET(2),
        DESKTOP(3),
        TV(4);

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final int JSValue;

        public static EnumEntries<DeviceType> getEntries() {
            return $ENTRIES;
        }

        DeviceType(int i) {
            this.JSValue = i;
        }

        public final int getJSValue() {
            return this.JSValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent3;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent4;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent5;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent6;
        Object objM12684constructorimpl;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        DeviceModule deviceModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (deviceModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(deviceModule);
            moduleDefinitionBuilder.Name("ExpoDevice");
            ConstantComponentBuilder constantComponentBuilder = new ConstantComponentBuilder("isDevice");
            constantComponentBuilder.setGetter(new Function0<Boolean>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$1
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(!DeviceModule.INSTANCE.isRunningOnEmulator());
                }
            });
            moduleDefinitionBuilder.getConstants().put("isDevice", constantComponentBuilder);
            ConstantComponentBuilder constantComponentBuilder2 = new ConstantComponentBuilder("brand");
            constantComponentBuilder2.setGetter(new Function0<String>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Build.BRAND;
                }
            });
            moduleDefinitionBuilder.getConstants().put("brand", constantComponentBuilder2);
            ConstantComponentBuilder constantComponentBuilder3 = new ConstantComponentBuilder("manufacturer");
            constantComponentBuilder3.setGetter(new Function0<String>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Build.MANUFACTURER;
                }
            });
            moduleDefinitionBuilder.getConstants().put("manufacturer", constantComponentBuilder3);
            ConstantComponentBuilder constantComponentBuilder4 = new ConstantComponentBuilder("modelName");
            constantComponentBuilder4.setGetter(new Function0<String>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Build.MODEL;
                }
            });
            moduleDefinitionBuilder.getConstants().put("modelName", constantComponentBuilder4);
            ConstantComponentBuilder constantComponentBuilder5 = new ConstantComponentBuilder("designName");
            constantComponentBuilder5.setGetter(new Function0<String>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$5
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Build.DEVICE;
                }
            });
            moduleDefinitionBuilder.getConstants().put("designName", constantComponentBuilder5);
            ConstantComponentBuilder constantComponentBuilder6 = new ConstantComponentBuilder("productName");
            constantComponentBuilder6.setGetter(new Function0<String>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$6
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Build.PRODUCT;
                }
            });
            moduleDefinitionBuilder.getConstants().put("productName", constantComponentBuilder6);
            ConstantComponentBuilder constantComponentBuilder7 = new ConstantComponentBuilder("deviceYearClass");
            constantComponentBuilder7.setGetter(new Function0<Integer>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$7
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    return Integer.valueOf(this.this$0.getDeviceYearClass());
                }
            });
            moduleDefinitionBuilder.getConstants().put("deviceYearClass", constantComponentBuilder7);
            ConstantComponentBuilder constantComponentBuilder8 = new ConstantComponentBuilder("totalMemory");
            constantComponentBuilder8.setGetter(new Function0<Long>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$8
                @Override // kotlin.jvm.functions.Function0
                public final Long invoke() {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    Object systemService = this.this$0.getContext().getSystemService("activity");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                    ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
                    return Long.valueOf(memoryInfo.totalMem);
                }
            });
            moduleDefinitionBuilder.getConstants().put("totalMemory", constantComponentBuilder8);
            ConstantComponentBuilder constantComponentBuilder9 = new ConstantComponentBuilder("deviceType");
            constantComponentBuilder9.setGetter(new Function0<Integer>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$9
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    return Integer.valueOf(DeviceModule.INSTANCE.getDeviceType(this.this$0.getContext()).getJSValue());
                }
            });
            moduleDefinitionBuilder.getConstants().put("deviceType", constantComponentBuilder9);
            ConstantComponentBuilder constantComponentBuilder10 = new ConstantComponentBuilder("supportedCpuArchitectures");
            constantComponentBuilder10.setGetter((Function0) new Function0<String[]>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$10
                @Override // kotlin.jvm.functions.Function0
                public final String[] invoke() {
                    String[] strArr = Build.SUPPORTED_ABIS;
                    if (strArr != null) {
                        if (!(strArr.length == 0)) {
                            return strArr;
                        }
                    }
                    return null;
                }
            });
            moduleDefinitionBuilder.getConstants().put("supportedCpuArchitectures", constantComponentBuilder10);
            ConstantComponentBuilder constantComponentBuilder11 = new ConstantComponentBuilder("osName");
            constantComponentBuilder11.setGetter(new Function0<String>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$11
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return this.this$0.getSystemName();
                }
            });
            moduleDefinitionBuilder.getConstants().put("osName", constantComponentBuilder11);
            ConstantComponentBuilder constantComponentBuilder12 = new ConstantComponentBuilder("osVersion");
            constantComponentBuilder12.setGetter(new Function0<String>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$12
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Build.VERSION.RELEASE;
                }
            });
            moduleDefinitionBuilder.getConstants().put("osVersion", constantComponentBuilder12);
            ConstantComponentBuilder constantComponentBuilder13 = new ConstantComponentBuilder("osBuildId");
            constantComponentBuilder13.setGetter(new Function0<String>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$13
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Build.DISPLAY;
                }
            });
            moduleDefinitionBuilder.getConstants().put("osBuildId", constantComponentBuilder13);
            ConstantComponentBuilder constantComponentBuilder14 = new ConstantComponentBuilder("osInternalBuildId");
            constantComponentBuilder14.setGetter(new Function0<String>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$14
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Build.ID;
                }
            });
            moduleDefinitionBuilder.getConstants().put("osInternalBuildId", constantComponentBuilder14);
            ConstantComponentBuilder constantComponentBuilder15 = new ConstantComponentBuilder("osBuildFingerprint");
            constantComponentBuilder15.setGetter(new Function0<String>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$15
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Build.FINGERPRINT;
                }
            });
            moduleDefinitionBuilder.getConstants().put("osBuildFingerprint", constantComponentBuilder15);
            ConstantComponentBuilder constantComponentBuilder16 = new ConstantComponentBuilder("platformApiLevel");
            constantComponentBuilder16.setGetter(new Function0<Integer>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$16
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    return Integer.valueOf(Build.VERSION.SDK_INT);
                }
            });
            moduleDefinitionBuilder.getConstants().put("platformApiLevel", constantComponentBuilder16);
            ConstantComponentBuilder constantComponentBuilder17 = new ConstantComponentBuilder("deviceName");
            constantComponentBuilder17.setGetter(new Function0<String>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$Constant$17
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    int i = Build.VERSION.SDK_INT;
                    DeviceModule deviceModule2 = this.this$0;
                    return i <= 31 ? Settings.Secure.getString(deviceModule2.getContext().getContentResolver(), "bluetooth_name") : Settings.Global.getString(deviceModule2.getContext().getContentResolver(), "device_name");
                }
            });
            moduleDefinitionBuilder.getConstants().put("deviceName", constantComponentBuilder17);
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1<Object[], Integer> function1 = new Function1<Object[], Integer>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(DeviceModule.INSTANCE.getDeviceType(this.this$0.getContext()).getJSValue());
                }
            };
            if (!Intrinsics.areEqual(Integer.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Integer.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Integer.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Integer.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Integer.class, String.class)) {
                                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("getDeviceTypeAsync", anyTypeArr, function1);
                            } else {
                                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("getDeviceTypeAsync", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("getDeviceTypeAsync", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("getDeviceTypeAsync", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("getDeviceTypeAsync", anyTypeArr, function1);
                }
            } else {
                untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("getDeviceTypeAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("getDeviceTypeAsync", untypedAsyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[0];
            Function1<Object[], Double> function2 = new Function1<Object[], Double>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function1
                public final Double invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Double.valueOf(SystemClock.uptimeMillis());
                }
            };
            if (!Intrinsics.areEqual(Double.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Double.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Double.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Double.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Double.class, String.class)) {
                                untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("getUptimeAsync", anyTypeArr2, function2);
                            } else {
                                untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("getUptimeAsync", anyTypeArr2, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("getUptimeAsync", anyTypeArr2, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("getUptimeAsync", anyTypeArr2, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("getUptimeAsync", anyTypeArr2, function2);
                }
            } else {
                untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("getUptimeAsync", anyTypeArr2, function2);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("getUptimeAsync", untypedAsyncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1<Object[], Double> function3 = new Function1<Object[], Double>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Double invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    long jMaxMemory = Runtime.getRuntime().maxMemory();
                    return Double.valueOf(jMaxMemory != Long.MAX_VALUE ? jMaxMemory : -1.0d);
                }
            };
            if (!Intrinsics.areEqual(Double.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Double.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Double.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Double.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Double.class, String.class)) {
                                untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("getMaxMemoryAsync", anyTypeArr3, function3);
                            } else {
                                untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("getMaxMemoryAsync", anyTypeArr3, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("getMaxMemoryAsync", anyTypeArr3, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("getMaxMemoryAsync", anyTypeArr3, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("getMaxMemoryAsync", anyTypeArr3, function3);
                }
            } else {
                untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("getMaxMemoryAsync", anyTypeArr3, function3);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("getMaxMemoryAsync", untypedAsyncFunctionComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[0];
            Function1<Object[], Boolean> function4 = new Function1<Object[], Boolean>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    boolean zIsRunningOnEmulator = DeviceModule.INSTANCE.isRunningOnEmulator();
                    String str = Build.TAGS;
                    boolean z = false;
                    if ((!zIsRunningOnEmulator && str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "test-keys", false, 2, (Object) null)) || new File("/system/app/Superuser.apk").exists() || (!zIsRunningOnEmulator && new File("/system/xbin/su").exists())) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                untypedAsyncFunctionComponent4 = new StringAsyncFunctionComponent("isRootedExperimentalAsync", anyTypeArr4, function4);
                            } else {
                                untypedAsyncFunctionComponent4 = new UntypedAsyncFunctionComponent("isRootedExperimentalAsync", anyTypeArr4, function4);
                            }
                        } else {
                            untypedAsyncFunctionComponent4 = new FloatAsyncFunctionComponent("isRootedExperimentalAsync", anyTypeArr4, function4);
                        }
                    } else {
                        untypedAsyncFunctionComponent4 = new DoubleAsyncFunctionComponent("isRootedExperimentalAsync", anyTypeArr4, function4);
                    }
                } else {
                    untypedAsyncFunctionComponent4 = new BoolAsyncFunctionComponent("isRootedExperimentalAsync", anyTypeArr4, function4);
                }
            } else {
                untypedAsyncFunctionComponent4 = new IntAsyncFunctionComponent("isRootedExperimentalAsync", anyTypeArr4, function4);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("isRootedExperimentalAsync", untypedAsyncFunctionComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr5 = new AnyType[0];
            Function1<Object[], Boolean> function5 = new Function1<Object[], Boolean>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) throws MissingRequestInstallPackagesPermissionException {
                    boolean zCanRequestPackageInstalls;
                    Intrinsics.checkNotNullParameter(it, "it");
                    int i = Build.VERSION.SDK_INT;
                    DeviceModule deviceModule2 = this.this$0;
                    if (i >= 26) {
                        try {
                            zCanRequestPackageInstalls = deviceModule2.getContext().getApplicationContext().getPackageManager().canRequestPackageInstalls();
                        } catch (SecurityException e) {
                            throw new MissingRequestInstallPackagesPermissionException(e);
                        }
                    } else {
                        zCanRequestPackageInstalls = false;
                        if (Settings.Global.getInt(deviceModule2.getContext().getApplicationContext().getContentResolver(), "install_non_market_apps", 0) == 1) {
                            zCanRequestPackageInstalls = true;
                        }
                    }
                    return Boolean.valueOf(zCanRequestPackageInstalls);
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                untypedAsyncFunctionComponent5 = new StringAsyncFunctionComponent("isSideLoadingEnabledAsync", anyTypeArr5, function5);
                            } else {
                                untypedAsyncFunctionComponent5 = new UntypedAsyncFunctionComponent("isSideLoadingEnabledAsync", anyTypeArr5, function5);
                            }
                        } else {
                            untypedAsyncFunctionComponent5 = new FloatAsyncFunctionComponent("isSideLoadingEnabledAsync", anyTypeArr5, function5);
                        }
                    } else {
                        untypedAsyncFunctionComponent5 = new DoubleAsyncFunctionComponent("isSideLoadingEnabledAsync", anyTypeArr5, function5);
                    }
                } else {
                    untypedAsyncFunctionComponent5 = new BoolAsyncFunctionComponent("isSideLoadingEnabledAsync", anyTypeArr5, function5);
                }
            } else {
                untypedAsyncFunctionComponent5 = new IntAsyncFunctionComponent("isSideLoadingEnabledAsync", anyTypeArr5, function5);
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("isSideLoadingEnabledAsync", untypedAsyncFunctionComponent5);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr6 = new AnyType[0];
            Function1<Object[], List<? extends String>> function6 = new Function1<Object[], List<? extends String>>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final List<? extends String> invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    FeatureInfo[] systemAvailableFeatures = this.this$0.getContext().getApplicationContext().getPackageManager().getSystemAvailableFeatures();
                    Intrinsics.checkNotNullExpressionValue(systemAvailableFeatures, "getSystemAvailableFeatures(...)");
                    List listFilterNotNull = ArraysKt.filterNotNull(systemAvailableFeatures);
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterNotNull, 10));
                    Iterator it2 = listFilterNotNull.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(((FeatureInfo) it2.next()).name);
                    }
                    return arrayList;
                }
            };
            if (!Intrinsics.areEqual(List.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(List.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(List.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(List.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(List.class, String.class)) {
                                untypedAsyncFunctionComponent6 = new StringAsyncFunctionComponent("getPlatformFeaturesAsync", anyTypeArr6, function6);
                            } else {
                                untypedAsyncFunctionComponent6 = new UntypedAsyncFunctionComponent("getPlatformFeaturesAsync", anyTypeArr6, function6);
                            }
                        } else {
                            untypedAsyncFunctionComponent6 = new FloatAsyncFunctionComponent("getPlatformFeaturesAsync", anyTypeArr6, function6);
                        }
                    } else {
                        untypedAsyncFunctionComponent6 = new DoubleAsyncFunctionComponent("getPlatformFeaturesAsync", anyTypeArr6, function6);
                    }
                } else {
                    untypedAsyncFunctionComponent6 = new BoolAsyncFunctionComponent("getPlatformFeaturesAsync", anyTypeArr6, function6);
                }
            } else {
                untypedAsyncFunctionComponent6 = new IntAsyncFunctionComponent("getPlatformFeaturesAsync", anyTypeArr6, function6);
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("getPlatformFeaturesAsync", untypedAsyncFunctionComponent6);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("hasPlatformFeatureAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$AsyncFunction$7
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.getContext().getApplicationContext().getPackageManager().hasSystemFeature((String) promise);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder8.getConverters();
                AnyType[] anyTypeArr7 = new AnyType[1];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$AsyncFunction$8
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(String.class);
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
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                    }
                    anyType = new AnyType(typeDescriptor, converters);
                }
                anyTypeArr7[0] = anyType;
                Function1<Object[], Boolean> function7 = new Function1<Object[], Boolean>() { // from class: expo.modules.device.DeviceModule$definition$lambda$26$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        return Boolean.valueOf(this.this$0.getContext().getApplicationContext().getPackageManager().hasSystemFeature((String) objArr[0]));
                    }
                };
                if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                    untypedAsyncFunctionComponent7 = new StringAsyncFunctionComponent("hasPlatformFeatureAsync", anyTypeArr7, function7);
                                } else {
                                    untypedAsyncFunctionComponent7 = new UntypedAsyncFunctionComponent("hasPlatformFeatureAsync", anyTypeArr7, function7);
                                }
                            } else {
                                untypedAsyncFunctionComponent7 = new FloatAsyncFunctionComponent("hasPlatformFeatureAsync", anyTypeArr7, function7);
                            }
                        } else {
                            untypedAsyncFunctionComponent7 = new DoubleAsyncFunctionComponent("hasPlatformFeatureAsync", anyTypeArr7, function7);
                        }
                    } else {
                        untypedAsyncFunctionComponent7 = new BoolAsyncFunctionComponent("hasPlatformFeatureAsync", anyTypeArr7, function7);
                    }
                } else {
                    untypedAsyncFunctionComponent7 = new IntAsyncFunctionComponent("hasPlatformFeatureAsync", anyTypeArr7, function7);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent7;
            }
            moduleDefinitionBuilder8.getAsyncFunctions().put("hasPlatformFeatureAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getDeviceYearClass() {
        return YearClass.get(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSystemName() {
        String str = Build.VERSION.BASE_OS;
        Intrinsics.checkNotNull(str);
        if (str.length() <= 0) {
            str = null;
        }
        return str == null ? GetDeviceInfoUseCaseKt.PLATFORM : str;
    }

    /* JADX INFO: compiled from: DeviceModule.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006¨\u0006\r"}, d2 = {"Lexpo/modules/device/DeviceModule$Companion;", "", "<init>", "()V", "isRunningOnEmulator", "", "()Z", "getDeviceType", "Lexpo/modules/device/DeviceModule$DeviceType;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getDeviceTypeFromResourceConfiguration", "getDeviceTypeFromPhysicalSize", "expo-device_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isRunningOnEmulator() {
            return EmulatorUtilities.INSTANCE.isRunningOnEmulator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DeviceType getDeviceType(Context context) {
            if (context.getApplicationContext().getPackageManager().hasSystemFeature("amazon.hardware.fire_tv")) {
                return DeviceType.TV;
            }
            UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
            if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
                return DeviceType.TV;
            }
            DeviceType deviceTypeFromResourceConfiguration = getDeviceTypeFromResourceConfiguration(context);
            return deviceTypeFromResourceConfiguration != DeviceType.UNKNOWN ? deviceTypeFromResourceConfiguration : getDeviceTypeFromPhysicalSize(context);
        }

        private final DeviceType getDeviceTypeFromResourceConfiguration(Context context) {
            int i = context.getResources().getConfiguration().smallestScreenWidthDp;
            if (i == 0) {
                return DeviceType.UNKNOWN;
            }
            if (i >= 600) {
                return DeviceType.TABLET;
            }
            return DeviceType.PHONE;
        }

        private final DeviceType getDeviceTypeFromPhysicalSize(Context context) {
            double dWidth;
            double dHeight;
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return DeviceType.UNKNOWN;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
                double d = context.getResources().getConfiguration().densityDpi;
                dWidth = ((double) bounds.width()) / d;
                dHeight = ((double) bounds.height()) / d;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                dWidth = ((double) displayMetrics.widthPixels) / ((double) displayMetrics.xdpi);
                dHeight = ((double) displayMetrics.heightPixels) / ((double) displayMetrics.ydpi);
            }
            double dSqrt = Math.sqrt(Math.pow(dWidth, 2.0d) + Math.pow(dHeight, 2.0d));
            if (3.0d <= dSqrt && dSqrt <= 6.9d) {
                return DeviceType.PHONE;
            }
            if (dSqrt > 6.9d && dSqrt <= 18.0d) {
                return DeviceType.TABLET;
            }
            return DeviceType.UNKNOWN;
        }
    }
}
