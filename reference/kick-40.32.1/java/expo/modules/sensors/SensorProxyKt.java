package expo.modules.sensors;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.lang.ref.WeakReference;
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

/* JADX INFO: compiled from: SensorProxy.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0007\u001a\u00020\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010H\u0000\u001aM\u0010\u0013\u001a\u00020\u0012*\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152#\b\u0004\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0001H\u0080\bø\u0001\u0000*B\b\u0000\u0010\u0000\"\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"OnNewEvent", "Lkotlin/Function1;", "Landroid/hardware/SensorEvent;", "Lkotlin/ParameterName;", "name", "event", "", "UseSensorProxy", "Lexpo/modules/kotlin/modules/ModuleDefinitionBuilder;", "module", "Lexpo/modules/kotlin/modules/Module;", "sensorType", "", "eventName", "", "listenerDecorator", "Lkotlin/Function0;", "sensorProxyGetter", "Lexpo/modules/sensors/SensorProxy;", "createSensorProxy", "appContext", "Lexpo/modules/kotlin/AppContext;", "eventMapper", "sensorEvent", "Landroid/os/Bundle;", "expo-sensors_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SensorProxyKt {
    public static /* synthetic */ void UseSensorProxy$default(ModuleDefinitionBuilder moduleDefinitionBuilder, Module module, int i, String str, Function0 function0, Function0 function1, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function0 = null;
        }
        UseSensorProxy(moduleDefinitionBuilder, module, i, str, function0, function1);
    }

    public static final void UseSensorProxy(ModuleDefinitionBuilder moduleDefinitionBuilder, final Module module, final int i, String eventName, final Function0<Unit> function0, final Function0<SensorProxy> sensorProxyGetter) {
        Object objM12684constructorimpl;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        Intrinsics.checkNotNullParameter(moduleDefinitionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(sensorProxyGetter, "sensorProxyGetter");
        moduleDefinitionBuilder.Events(eventName);
        moduleDefinitionBuilder.OnStartObserving(new Function0() { // from class: expo.modules.sensors.SensorProxyKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SensorProxyKt.UseSensorProxy$lambda$0(function0, sensorProxyGetter);
            }
        });
        moduleDefinitionBuilder.OnStopObserving(new Function0() { // from class: expo.modules.sensors.SensorProxyKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SensorProxyKt.UseSensorProxy$lambda$1(function0, sensorProxyGetter);
            }
        });
        ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
        moduleDefinitionBuilder2.getEventListeners().put(EventName.ACTIVITY_ENTERS_FOREGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_FOREGROUND, new Function0<Unit>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$OnActivityEntersForeground$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((SensorProxy) sensorProxyGetter.invoke()).onHostResume();
            }
        }));
        moduleDefinitionBuilder2.getEventListeners().put(EventName.ACTIVITY_ENTERS_BACKGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_BACKGROUND, new Function0<Unit>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$OnActivityEntersBackground$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((SensorProxy) sensorProxyGetter.invoke()).onHostPause();
            }
        }));
        moduleDefinitionBuilder2.getEventListeners().put(EventName.ACTIVITY_DESTROYS, new BasicEventListener(EventName.ACTIVITY_DESTROYS, new Function0<Unit>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$OnActivityDestroys$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((SensorProxy) sensorProxyGetter.invoke()).onHostDestroy();
            }
        }));
        moduleDefinitionBuilder2.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$OnDestroy$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((SensorProxy) sensorProxyGetter.invoke()).onHostDestroy();
            }
        }));
        ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
        if (Intrinsics.areEqual(Integer.class, Promise.class)) {
            asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("setUpdateInterval", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    ((SensorProxy) sensorProxyGetter.invoke()).setUpdateInterval(((Integer) promise).intValue());
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
        } else {
            TypeConverterProvider converters = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr = new AnyType[1];
            AnyTypeCache anyTypeCache = AnyTypeCache.INSTANCE;
            AnyType anyType = anyTypeCache.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Integer.TYPE);
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
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType;
            Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((SensorProxy) sensorProxyGetter.invoke()).setUpdateInterval(((Number) objArr[0]).intValue());
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("setUpdateInterval", anyTypeArr, function1);
                            } else {
                                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("setUpdateInterval", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("setUpdateInterval", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("setUpdateInterval", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("setUpdateInterval", anyTypeArr, function1);
                }
            } else {
                untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("setUpdateInterval", anyTypeArr, function1);
            }
            asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
        }
        moduleDefinitionBuilder3.getAsyncFunctions().put("setUpdateInterval", asyncFunctionWithPromiseComponent);
        AnyType[] anyTypeArr2 = new AnyType[0];
        Function1<Object[], Boolean> function2 = new Function1<Object[], Boolean>() { // from class: expo.modules.sensors.SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$4
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Context reactContext = module.getAppContext().getReactContext();
                Object systemService = reactContext != null ? reactContext.getSystemService("sensor") : null;
                SensorManager sensorManager = systemService instanceof SensorManager ? (SensorManager) systemService : null;
                return Boolean.valueOf((sensorManager != null ? sensorManager.getDefaultSensor(i) : null) != null);
            }
        };
        if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
            if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                        if (Intrinsics.areEqual(Boolean.class, String.class)) {
                            untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("isAvailableAsync", anyTypeArr2, function2);
                        } else {
                            untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("isAvailableAsync", anyTypeArr2, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("isAvailableAsync", anyTypeArr2, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("isAvailableAsync", anyTypeArr2, function2);
                }
            } else {
                untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("isAvailableAsync", anyTypeArr2, function2);
            }
        } else {
            untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("isAvailableAsync", anyTypeArr2, function2);
        }
        moduleDefinitionBuilder3.getAsyncFunctions().put("isAvailableAsync", untypedAsyncFunctionComponent2);
    }

    static final Unit UseSensorProxy$lambda$0(Function0 function0, Function0 function1) {
        if (function0 != null) {
            function0.invoke();
        }
        ((SensorProxy) function1.invoke()).startObserving();
        return Unit.INSTANCE;
    }

    static final Unit UseSensorProxy$lambda$1(Function0 function0, Function0 function1) {
        if (function0 != null) {
            function0.invoke();
        }
        ((SensorProxy) function1.invoke()).stopObserving();
        return Unit.INSTANCE;
    }

    public static final SensorProxy createSensorProxy(Module module, final String eventName, int i, AppContext appContext, final Function1<? super SensorEvent, Bundle> eventMapper) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        final WeakReference weakReference = new WeakReference(module);
        return new SensorProxy(i, appContext, new Function1<SensorEvent, Unit>() { // from class: expo.modules.sensors.SensorProxyKt$createSensorProxy$onNewEvent$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SensorEvent sensorEvent) {
                invoke2(sensorEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SensorEvent sensorEvent) {
                Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
                Module module2 = weakReference.get();
                if (module2 != null) {
                    module2.sendEvent(eventName, eventMapper.invoke(sensorEvent));
                }
            }
        });
    }
}
