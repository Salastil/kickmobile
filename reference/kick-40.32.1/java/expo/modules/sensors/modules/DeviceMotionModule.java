package expo.modules.sensors.modules;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import androidx.tracing.Trace;
import com.android.billingclient.api.BillingClient;
import com.facebook.imagepipeline.common.RotationOptions;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
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
import expo.modules.sensors.SensorSubscription;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: DeviceMotionModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u00012\u00020\u0002:\u0003/01B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\rH\u0016J\u0018\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020*H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u00062"}, d2 = {"Lexpo/modules/sensors/modules/DeviceMotionModule;", "Lexpo/modules/kotlin/modules/Module;", "Landroid/hardware/SensorEventListener2;", "<init>", "()V", "lastUpdate", "", "updateInterval", "", "rotationMatrix", "", "rotationResult", "accelerationEvent", "Landroid/hardware/SensorEvent;", "accelerationIncludingGravityEvent", "rotationEvent", "rotationRateEvent", "gravityEvent", "uiManager", "Lexpo/modules/core/interfaces/services/UIManager;", "currentFrameCallback", "Lexpo/modules/sensors/modules/DeviceMotionModule$ScheduleDispatchFrameCallback;", "dispatchEventRunnable", "Lexpo/modules/sensors/modules/DeviceMotionModule$DispatchEventRunnable;", "isObserving", "", BillingClient.FeatureType.SUBSCRIPTIONS, "", "Lexpo/modules/sensors/SensorSubscription;", "getSubscriptions", "()Ljava/util/List;", "subscriptions$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "onSensorChanged", "", "sensorEvent", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "onFlushCompleted", "eventsToMap", "Landroid/os/Bundle;", "getOrientation", "ScheduleDispatchFrameCallback", "DispatchEventRunnable", "Companion", "expo-sensors_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeviceMotionModule extends Module implements SensorEventListener2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(DeviceMotionModule.class).getSimpleName();
    private SensorEvent accelerationEvent;
    private SensorEvent accelerationIncludingGravityEvent;
    private SensorEvent gravityEvent;
    private boolean isObserving;
    private long lastUpdate;
    private SensorEvent rotationEvent;
    private SensorEvent rotationRateEvent;
    private UIManager uiManager;
    private float updateInterval = 0.016666668f;
    private final float[] rotationMatrix = new float[9];
    private final float[] rotationResult = new float[3];
    private final ScheduleDispatchFrameCallback currentFrameCallback = new ScheduleDispatchFrameCallback();
    private final DispatchEventRunnable dispatchEventRunnable = new DispatchEventRunnable(this, new WeakReference(this));

    /* JADX INFO: renamed from: subscriptions$delegate, reason: from kotlin metadata */
    private final Lazy subscriptions = LazyKt.lazy(new Function0() { // from class: expo.modules.sensors.modules.DeviceMotionModule$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DeviceMotionModule.subscriptions_delegate$lambda$1(this.f$0);
        }
    });

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener2
    public void onFlushCompleted(Sensor sensor) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SensorSubscription> getSubscriptions() {
        return (List) this.subscriptions.getValue();
    }

    static final List subscriptions_delegate$lambda$1(DeviceMotionModule deviceMotionModule) throws Exceptions.ReactContextLost {
        Context reactContext = deviceMotionModule.getAppContext().getReactContext();
        if (reactContext != null) {
            ArrayList arrayList = DeviceMotionModuleKt.sensorTypes;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new SensorSubscription(reactContext, ((Number) it.next()).intValue(), deviceMotionModule, 0L));
            }
            return arrayList2;
        }
        throw new Exceptions.ReactContextLost();
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
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent4;
        DeviceMotionModule deviceMotionModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (deviceMotionModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(deviceMotionModule);
            moduleDefinitionBuilder.Name("ExponentDeviceMotion");
            moduleDefinitionBuilder.Events("deviceMotionDidUpdate");
            ConstantComponentBuilder constantComponentBuilder = new ConstantComponentBuilder("Gravity");
            constantComponentBuilder.setGetter(new Function0<Float>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$Constant$1
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(9.80665f);
                }
            });
            moduleDefinitionBuilder.getConstants().put("Gravity", constantComponentBuilder);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Object module;
                    DeviceMotionModule deviceMotionModule2 = this.this$0;
                    try {
                        module = deviceMotionModule2.getAppContext().getLegacyModuleRegistry().getModule(UIManager.class);
                    } catch (Exception unused) {
                        module = null;
                    }
                    Intrinsics.checkNotNull(module);
                    deviceMotionModule2.uiManager = (UIManager) module;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            Object obj = null;
            if (Intrinsics.areEqual(Float.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("setUpdateInterval", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.updateInterval = ((Float) promise).floatValue();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), false));
                if (anyType == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.FLOAT), new Function0<KType>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Float.TYPE);
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
                        typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Float.TYPE));
                    }
                    anyType = new AnyType(typeDescriptor, converters);
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        this.this$0.updateInterval = ((Number) objArr[0]).floatValue();
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
            moduleDefinitionBuilder2.getAsyncFunctions().put("setUpdateInterval", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$AsyncFunction$4
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
                        DeviceMotionModule deviceMotionModule2 = this.this$0;
                        if (i >= 29) {
                            Permissions.getPermissionsWithPermissionsManager(deviceMotionModule2.getAppContext().getPermissions(), promise, "android.permission.ACTIVITY_RECOGNITION");
                        } else {
                            Permissions.getPermissionsWithPermissionsManager(deviceMotionModule2.getAppContext().getPermissions(), promise, new String[0]);
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
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Promise.class, false, null)), new Function0<KType>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$AsyncFunction$5
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
                Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Promise promise = (Promise) objArr[0];
                        int i = Build.VERSION.SDK_INT;
                        DeviceMotionModule deviceMotionModule2 = this.this$0;
                        if (i >= 29) {
                            Permissions.getPermissionsWithPermissionsManager(deviceMotionModule2.getAppContext().getPermissions(), promise, "android.permission.ACTIVITY_RECOGNITION");
                        } else {
                            Permissions.getPermissionsWithPermissionsManager(deviceMotionModule2.getAppContext().getPermissions(), promise, new String[0]);
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function2);
                                } else {
                                    untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function2);
                                }
                            } else {
                                untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function2);
                }
                asyncFunctionWithPromiseComponent2 = untypedAsyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("getPermissionsAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$AsyncFunction$7
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
                        DeviceMotionModule deviceMotionModule2 = this.this$0;
                        if (i >= 29) {
                            Permissions.askForPermissionsWithPermissionsManager(deviceMotionModule2.getAppContext().getPermissions(), promise, "android.permission.ACTIVITY_RECOGNITION");
                        } else {
                            Permissions.askForPermissionsWithPermissionsManager(deviceMotionModule2.getAppContext().getPermissions(), promise, new String[0]);
                        }
                    }
                });
            } else {
                TypeConverterProvider converters3 = moduleDefinitionBuilder4.getConverters();
                AnyType[] anyTypeArr3 = new AnyType[1];
                AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType3 == null) {
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Promise.class, false, null)), new Function0<KType>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$AsyncFunction$8
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Promise.class);
                            }
                        }));
                    } catch (Throwable th3) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th3));
                    }
                    if (!Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                        obj = objM12684constructorimpl3;
                    }
                    TypeDescriptor typeDescriptor3 = (TypeDescriptor) obj;
                    if (typeDescriptor3 == null) {
                        typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Promise.class));
                    }
                    anyType3 = new AnyType(typeDescriptor3, converters3);
                }
                anyTypeArr3[0] = anyType3;
                Function1<Object[], Unit> function3 = new Function1<Object[], Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Promise promise = (Promise) objArr[0];
                        int i = Build.VERSION.SDK_INT;
                        DeviceMotionModule deviceMotionModule2 = this.this$0;
                        if (i >= 29) {
                            Permissions.askForPermissionsWithPermissionsManager(deviceMotionModule2.getAppContext().getPermissions(), promise, "android.permission.ACTIVITY_RECOGNITION");
                        } else {
                            Permissions.askForPermissionsWithPermissionsManager(deviceMotionModule2.getAppContext().getPermissions(), promise, new String[0]);
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr3, function3);
                                } else {
                                    untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr3, function3);
                                }
                            } else {
                                untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr3, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr3, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr3, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr3, function3);
                }
                asyncFunctionWithPromiseComponent3 = untypedAsyncFunctionComponent3;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("requestPermissionsAsync", asyncFunctionWithPromiseComponent3);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (this.this$0.isObserving) {
                        Iterator it = this.this$0.getSubscriptions().iterator();
                        while (it.hasNext()) {
                            ((SensorSubscription) it.next()).stopObserving();
                        }
                    }
                }
            }));
            moduleDefinitionBuilder.OnStartObserving(new Function0<Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$1$7
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Iterator it = this.this$0.getSubscriptions().iterator();
                    while (it.hasNext()) {
                        ((SensorSubscription) it.next()).startObserving();
                    }
                    this.this$0.isObserving = true;
                    this.this$0.currentFrameCallback.maybePostFromNonUI();
                }
            });
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_FOREGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_FOREGROUND, new Function0<Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$OnActivityEntersForeground$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (this.this$0.isObserving) {
                        Iterator it = this.this$0.getSubscriptions().iterator();
                        while (it.hasNext()) {
                            ((SensorSubscription) it.next()).startObserving();
                        }
                    }
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_BACKGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_BACKGROUND, new Function0<Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$OnActivityEntersBackground$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (this.this$0.isObserving) {
                        Iterator it = this.this$0.getSubscriptions().iterator();
                        while (it.hasNext()) {
                            ((SensorSubscription) it.next()).stopObserving();
                        }
                    }
                }
            }));
            moduleDefinitionBuilder.OnStopObserving(new Function0<Unit>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$1$10
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (this.this$0.isObserving) {
                        Iterator it = this.this$0.getSubscriptions().iterator();
                        while (it.hasNext()) {
                            ((SensorSubscription) it.next()).stopObserving();
                        }
                    }
                    this.this$0.currentFrameCallback.stop();
                }
            });
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[0];
            Function1<Object[], Boolean> function4 = new Function1<Object[], Boolean>() { // from class: expo.modules.sensors.modules.DeviceMotionModule$definition$lambda$14$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    Object systemService = reactContext != null ? reactContext.getSystemService("sensor") : null;
                    SensorManager sensorManager = systemService instanceof SensorManager ? (SensorManager) systemService : null;
                    boolean z = false;
                    if (sensorManager != null) {
                        Iterator it2 = DeviceMotionModuleKt.sensorTypes.iterator();
                        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            Object next = it2.next();
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            if (sensorManager.getDefaultSensor(((Number) next).intValue()) == null) {
                            }
                        }
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
                                untypedAsyncFunctionComponent4 = new StringAsyncFunctionComponent("isAvailableAsync", anyTypeArr4, function4);
                            } else {
                                untypedAsyncFunctionComponent4 = new UntypedAsyncFunctionComponent("isAvailableAsync", anyTypeArr4, function4);
                            }
                        } else {
                            untypedAsyncFunctionComponent4 = new FloatAsyncFunctionComponent("isAvailableAsync", anyTypeArr4, function4);
                        }
                    } else {
                        untypedAsyncFunctionComponent4 = new DoubleAsyncFunctionComponent("isAvailableAsync", anyTypeArr4, function4);
                    }
                } else {
                    untypedAsyncFunctionComponent4 = new BoolAsyncFunctionComponent("isAvailableAsync", anyTypeArr4, function4);
                }
            } else {
                untypedAsyncFunctionComponent4 = new IntAsyncFunctionComponent("isAvailableAsync", anyTypeArr4, function4);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("isAvailableAsync", untypedAsyncFunctionComponent4);
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th4) {
            Trace.endSection();
            throw th4;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.accelerationIncludingGravityEvent = sensorEvent;
        } else if (type == 4) {
            this.rotationRateEvent = sensorEvent;
        } else {
            switch (type) {
                case 9:
                    this.gravityEvent = sensorEvent;
                    break;
                case 10:
                    this.accelerationEvent = sensorEvent;
                    break;
                case 11:
                    this.rotationEvent = sensorEvent;
                    break;
            }
        }
        this.currentFrameCallback.maybePostFromNonUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DeviceMotionModule.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\bH\u0002J\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/sensors/modules/DeviceMotionModule$ScheduleDispatchFrameCallback;", "Landroid/view/Choreographer$FrameCallback;", "<init>", "(Lexpo/modules/sensors/modules/DeviceMotionModule;)V", "mIsPosted", "", "mShouldStop", "doFrame", "", "frameTimeNanos", "", "stop", "maybePost", "post", "maybePostFromNonUI", "expo-sensors_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    final class ScheduleDispatchFrameCallback implements Choreographer.FrameCallback {
        private volatile boolean mIsPosted;
        private volatile boolean mShouldStop;

        public ScheduleDispatchFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            synchronized (this) {
                if (this.mShouldStop) {
                    this.mIsPosted = false;
                } else {
                    post();
                }
                Unit unit = Unit.INSTANCE;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - DeviceMotionModule.this.lastUpdate > DeviceMotionModule.this.updateInterval) {
                UIManager uIManager = DeviceMotionModule.this.uiManager;
                if (uIManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiManager");
                    uIManager = null;
                }
                uIManager.runOnClientCodeQueueThread(DeviceMotionModule.this.dispatchEventRunnable);
                DeviceMotionModule.this.lastUpdate = jCurrentTimeMillis;
            }
        }

        public final void stop() {
            synchronized (this) {
                this.mShouldStop = true;
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void maybePost() {
            synchronized (this) {
                this.mShouldStop = false;
                if (!this.mIsPosted) {
                    this.mIsPosted = true;
                    post();
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        private final void post() {
            Choreographer.getInstance().postFrameCallback(DeviceMotionModule.this.currentFrameCallback);
        }

        public final void maybePostFromNonUI() {
            if (this.mIsPosted) {
                return;
            }
            UIManager uIManager = DeviceMotionModule.this.uiManager;
            if (uIManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiManager");
                uIManager = null;
            }
            uIManager.runOnUiQueueThread(new Runnable() { // from class: expo.modules.sensors.modules.DeviceMotionModule$ScheduleDispatchFrameCallback$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.maybePost();
                }
            });
        }
    }

    /* JADX INFO: compiled from: DeviceMotionModule.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lexpo/modules/sensors/modules/DeviceMotionModule$DispatchEventRunnable;", "Ljava/lang/Runnable;", "weakReference", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/sensors/modules/DeviceMotionModule;", "<init>", "(Lexpo/modules/sensors/modules/DeviceMotionModule;Ljava/lang/ref/WeakReference;)V", "run", "", "expo-sensors_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class DispatchEventRunnable implements Runnable {
        final /* synthetic */ DeviceMotionModule this$0;
        private final WeakReference<DeviceMotionModule> weakReference;

        public DispatchEventRunnable(DeviceMotionModule deviceMotionModule, WeakReference<DeviceMotionModule> weakReference) {
            Intrinsics.checkNotNullParameter(weakReference, "weakReference");
            this.this$0 = deviceMotionModule;
            this.weakReference = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            DeviceMotionModule deviceMotionModule = this.weakReference.get();
            if (deviceMotionModule != null) {
                deviceMotionModule.sendEvent("deviceMotionDidUpdate", this.this$0.eventsToMap());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle eventsToMap() {
        Bundle bundle = new Bundle();
        if (this.accelerationEvent != null) {
            Bundle bundle2 = new Bundle();
            SensorEvent sensorEvent = this.accelerationEvent;
            Intrinsics.checkNotNull(sensorEvent);
            bundle2.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, sensorEvent.values[0]);
            SensorEvent sensorEvent2 = this.accelerationEvent;
            Intrinsics.checkNotNull(sensorEvent2);
            bundle2.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, sensorEvent2.values[1]);
            SensorEvent sensorEvent3 = this.accelerationEvent;
            Intrinsics.checkNotNull(sensorEvent3);
            bundle2.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Z, sensorEvent3.values[2]);
            SensorEvent sensorEvent4 = this.accelerationEvent;
            Intrinsics.checkNotNull(sensorEvent4);
            bundle2.putDouble("timestamp", sensorEvent4.timestamp / 1.0E9d);
            Unit unit = Unit.INSTANCE;
            bundle.putBundle("acceleration", bundle2);
        }
        if (this.accelerationIncludingGravityEvent != null && this.gravityEvent != null) {
            Bundle bundle3 = new Bundle();
            SensorEvent sensorEvent5 = this.accelerationIncludingGravityEvent;
            Intrinsics.checkNotNull(sensorEvent5);
            float f = sensorEvent5.values[0];
            SensorEvent sensorEvent6 = this.gravityEvent;
            Intrinsics.checkNotNull(sensorEvent6);
            bundle3.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, f - (sensorEvent6.values[0] * 2.0f));
            SensorEvent sensorEvent7 = this.accelerationIncludingGravityEvent;
            Intrinsics.checkNotNull(sensorEvent7);
            float f2 = sensorEvent7.values[1];
            SensorEvent sensorEvent8 = this.gravityEvent;
            Intrinsics.checkNotNull(sensorEvent8);
            bundle3.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, f2 - (sensorEvent8.values[1] * 2.0f));
            SensorEvent sensorEvent9 = this.accelerationIncludingGravityEvent;
            Intrinsics.checkNotNull(sensorEvent9);
            float f3 = sensorEvent9.values[2];
            SensorEvent sensorEvent10 = this.gravityEvent;
            Intrinsics.checkNotNull(sensorEvent10);
            bundle3.putDouble(ViewDeviceOrientationData.DEVICE_ORIENTATION_Z, f3 - (2.0f * sensorEvent10.values[2]));
            SensorEvent sensorEvent11 = this.accelerationIncludingGravityEvent;
            Intrinsics.checkNotNull(sensorEvent11);
            bundle3.putDouble("timestamp", sensorEvent11.timestamp / 1.0E9d);
            Unit unit2 = Unit.INSTANCE;
            bundle.putBundle("accelerationIncludingGravity", bundle3);
        }
        if (this.rotationRateEvent != null) {
            Bundle bundle4 = new Bundle();
            SensorEvent sensorEvent12 = this.rotationRateEvent;
            Intrinsics.checkNotNull(sensorEvent12);
            bundle4.putDouble("alpha", Math.toDegrees(sensorEvent12.values[0]));
            SensorEvent sensorEvent13 = this.rotationRateEvent;
            Intrinsics.checkNotNull(sensorEvent13);
            bundle4.putDouble("beta", Math.toDegrees(sensorEvent13.values[1]));
            SensorEvent sensorEvent14 = this.rotationRateEvent;
            Intrinsics.checkNotNull(sensorEvent14);
            bundle4.putDouble("gamma", Math.toDegrees(sensorEvent14.values[2]));
            SensorEvent sensorEvent15 = this.rotationRateEvent;
            Intrinsics.checkNotNull(sensorEvent15);
            bundle4.putDouble("timestamp", sensorEvent15.timestamp / 1.0E9d);
            Unit unit3 = Unit.INSTANCE;
            bundle.putBundle("rotationRate", bundle4);
        }
        SensorEvent sensorEvent16 = this.rotationEvent;
        if (sensorEvent16 != null) {
            float[] fArr = this.rotationMatrix;
            Intrinsics.checkNotNull(sensorEvent16);
            SensorManager.getRotationMatrixFromVector(fArr, sensorEvent16.values);
            SensorManager.getOrientation(this.rotationMatrix, this.rotationResult);
            Bundle bundle5 = new Bundle();
            bundle5.putDouble("alpha", -this.rotationResult[0]);
            bundle5.putDouble("beta", -this.rotationResult[1]);
            bundle5.putDouble("gamma", this.rotationResult[2]);
            SensorEvent sensorEvent17 = this.rotationEvent;
            Intrinsics.checkNotNull(sensorEvent17);
            bundle5.putDouble("timestamp", sensorEvent17.timestamp / 1.0E9d);
            Unit unit4 = Unit.INSTANCE;
            bundle.putBundle("rotation", bundle5);
        }
        bundle.putDouble("interval", this.updateInterval);
        bundle.putInt("orientation", getOrientation());
        return bundle;
    }

    private final int getOrientation() {
        Display defaultDisplay;
        Context reactContext = getAppContext().getReactContext();
        Integer numValueOf = null;
        Object systemService = reactContext != null ? reactContext.getSystemService("window") : null;
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (Build.VERSION.SDK_INT >= 30) {
            Activity currentActivity = getAppContext().getCurrentActivity();
            if (currentActivity == null) {
                Log.e(TAG, "[expo-sensors]: The currentActivity is no longer available");
                numValueOf = 0;
            } else {
                Display display = currentActivity.getDisplay();
                if (display != null) {
                    numValueOf = Integer.valueOf(display.getRotation());
                }
            }
        } else if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            numValueOf = Integer.valueOf(defaultDisplay.getRotation());
        }
        if (numValueOf == null || numValueOf.intValue() == 0) {
            return 0;
        }
        if (numValueOf.intValue() == 1) {
            return 90;
        }
        if (numValueOf.intValue() == 2) {
            return RotationOptions.ROTATE_180;
        }
        return numValueOf.intValue() == 3 ? -90 : 0;
    }

    /* JADX INFO: compiled from: DeviceMotionModule.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/sensors/modules/DeviceMotionModule$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "expo-sensors_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return DeviceMotionModule.TAG;
        }
    }
}
