package expo.modules.sensors.modules;

import android.hardware.SensorEvent;
import android.os.Build;
import android.os.Bundle;
import androidx.tracing.Trace;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
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
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.sensors.SensorProxy;
import expo.modules.sensors.SensorProxyKt;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: PedometerModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lexpo/modules/sensors/modules/PedometerModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "stepsAtTheBeginning", "", "Ljava/lang/Integer;", "sensorProxy", "Lexpo/modules/sensors/SensorProxy;", "getSensorProxy", "()Lexpo/modules/sensors/SensorProxy;", "sensorProxy$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-sensors_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PedometerModule extends Module {

    /* JADX INFO: renamed from: sensorProxy$delegate, reason: from kotlin metadata */
    private final Lazy sensorProxy = LazyKt.lazy(new Function0() { // from class: expo.modules.sensors.modules.PedometerModule$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PedometerModule.sensorProxy_delegate$lambda$2(this.f$0);
        }
    });
    private Integer stepsAtTheBeginning;

    /* JADX INFO: Access modifiers changed from: private */
    public final SensorProxy getSensorProxy() {
        return (SensorProxy) this.sensorProxy.getValue();
    }

    static final SensorProxy sensorProxy_delegate$lambda$2(final PedometerModule pedometerModule) {
        AppContext appContext = pedometerModule.getAppContext();
        final WeakReference weakReference = new WeakReference(pedometerModule);
        final String str = "Exponent.pedometerUpdate";
        return new SensorProxy(19, appContext, new Function1<SensorEvent, Unit>() { // from class: expo.modules.sensors.modules.PedometerModule$sensorProxy_delegate$lambda$2$$inlined$createSensorProxy$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SensorEvent sensorEvent) {
                invoke2(sensorEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SensorEvent sensorEvent) {
                Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
                Module module = (Module) weakReference.get();
                if (module != null) {
                    String str2 = str;
                    if (pedometerModule.stepsAtTheBeginning == null) {
                        pedometerModule.stepsAtTheBeginning = Integer.valueOf(((int) sensorEvent.values[0]) - 1);
                    }
                    Bundle bundle = new Bundle();
                    float f = sensorEvent.values[0];
                    Integer num = pedometerModule.stepsAtTheBeginning;
                    bundle.putDouble("steps", f - (num != null ? num.intValue() : ((int) sensorEvent.values[0]) - 1));
                    module.sendEvent(str2, bundle);
                }
            }
        });
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        Object objM12684constructorimpl2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent3;
        PedometerModule pedometerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (pedometerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(pedometerModule);
            moduleDefinitionBuilder.Name("ExponentPedometer");
            SensorProxyKt.UseSensorProxy(moduleDefinitionBuilder, this, 19, "Exponent.pedometerUpdate", new Function0<Unit>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.stepsAtTheBeginning = null;
                }
            }, new Function0<SensorProxy>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$1$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SensorProxy invoke() {
                    return this.this$0.getSensorProxy();
                }
            });
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            Object obj = null;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$6$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        int i = Build.VERSION.SDK_INT;
                        PedometerModule pedometerModule2 = this.this$0;
                        if (i >= 29) {
                            Permissions.getPermissionsWithPermissionsManager(pedometerModule2.getAppContext().getPermissions(), promise, "android.permission.ACTIVITY_RECOGNITION");
                        } else {
                            Permissions.getPermissionsWithPermissionsManager(pedometerModule2.getAppContext().getPermissions(), promise, new String[0]);
                        }
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Promise.class, false, null)), new Function0<KType>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$6$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Promise.class);
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
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Promise.class));
                    }
                    anyType = new AnyType(typeDescriptor, converters);
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$6$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Promise promise = (Promise) objArr[0];
                        int i = Build.VERSION.SDK_INT;
                        PedometerModule pedometerModule2 = this.this$0;
                        if (i >= 29) {
                            Permissions.getPermissionsWithPermissionsManager(pedometerModule2.getAppContext().getPermissions(), promise, "android.permission.ACTIVITY_RECOGNITION");
                        } else {
                            Permissions.getPermissionsWithPermissionsManager(pedometerModule2.getAppContext().getPermissions(), promise, new String[0]);
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("getPermissionsAsync", anyTypeArr, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("getPermissionsAsync", anyTypeArr, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("getPermissionsAsync", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("getPermissionsAsync", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("getPermissionsAsync", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("getPermissionsAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("getPermissionsAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$6$$inlined$AsyncFunction$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        int i = Build.VERSION.SDK_INT;
                        PedometerModule pedometerModule2 = this.this$0;
                        if (i >= 29) {
                            Permissions.askForPermissionsWithPermissionsManager(pedometerModule2.getAppContext().getPermissions(), promise, "android.permission.ACTIVITY_RECOGNITION");
                        } else {
                            Permissions.askForPermissionsWithPermissionsManager(pedometerModule2.getAppContext().getPermissions(), promise, new String[0]);
                        }
                    }
                });
            } else {
                TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType2 == null) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Promise.class, false, null)), new Function0<KType>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$6$$inlined$AsyncFunction$5
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Promise.class);
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
                        typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Promise.class));
                    }
                    anyType2 = new AnyType(typeDescriptor2, converters2);
                }
                anyTypeArr2[0] = anyType2;
                Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$6$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Promise promise = (Promise) objArr[0];
                        int i = Build.VERSION.SDK_INT;
                        PedometerModule pedometerModule2 = this.this$0;
                        if (i >= 29) {
                            Permissions.askForPermissionsWithPermissionsManager(pedometerModule2.getAppContext().getPermissions(), promise, "android.permission.ACTIVITY_RECOGNITION");
                        } else {
                            Permissions.askForPermissionsWithPermissionsManager(pedometerModule2.getAppContext().getPermissions(), promise, new String[0]);
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr2, function2);
                                } else {
                                    untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr2, function2);
                                }
                            } else {
                                untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr2, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr2, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr2, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr2, function2);
                }
                asyncFunctionWithPromiseComponent2 = untypedAsyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("requestPermissionsAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            TypeConverterProvider converters3 = moduleDefinitionBuilder4.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[2];
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$6$$inlined$AsyncFunction$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Integer.TYPE);
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
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                }
                anyType3 = new AnyType(typeDescriptor3, converters3);
            }
            anyTypeArr3[0] = anyType3;
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$6$$inlined$AsyncFunction$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Integer.TYPE);
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (!Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    obj = objM12684constructorimpl4;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) obj;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                }
                anyType4 = new AnyType(typeDescriptor4, converters3);
            }
            anyTypeArr3[1] = anyType4;
            Function1<Object[], Unit> function3 = new Function1<Object[], Unit>() { // from class: expo.modules.sensors.modules.PedometerModule$definition$lambda$6$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws NotSupportedException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj2 = objArr[0];
                    ((Number) objArr[1]).intValue();
                    ((Number) obj2).intValue();
                    throw new NotSupportedException("Getting step count for date range is not supported on Android yet");
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("getStepCountAsync", anyTypeArr3, function3);
                            } else {
                                untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("getStepCountAsync", anyTypeArr3, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("getStepCountAsync", anyTypeArr3, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("getStepCountAsync", anyTypeArr3, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("getStepCountAsync", anyTypeArr3, function3);
                }
            } else {
                untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("getStepCountAsync", anyTypeArr3, function3);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("getStepCountAsync", untypedAsyncFunctionComponent3);
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th5) {
            Trace.endSection();
            throw th5;
        }
    }
}
