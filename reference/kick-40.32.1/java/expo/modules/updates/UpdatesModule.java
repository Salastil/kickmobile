package expo.modules.updates;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.OptimizedRecord;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.updates.events.IUpdatesEventManagerObserver;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogReader;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.reloadscreen.ReloadScreenOptions;
import expo.modules.updates.statemachine.UpdatesStateContext;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PFunction;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: UpdatesModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0011H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lexpo/modules/updates/UpdatesModule;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/updates/events/IUpdatesEventManagerObserver;", "<init>", "()V", "logger", "Lexpo/modules/updates/logging/UpdatesLogger;", "getLogger", "()Lexpo/modules/updates/logging/UpdatesLogger;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "onStateMachineContextEvent", "", "Lexpo/modules/updates/statemachine/UpdatesStateContext;", "Companion", "UpdatesConfigurationOverrideParam", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UpdatesModule extends Module implements IUpdatesEventManagerObserver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "UpdatesModule";

    /* JADX INFO: Access modifiers changed from: private */
    public final UpdatesLogger getLogger() {
        File filesDir = getContext().getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        return new UpdatesLogger(filesDir);
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
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        UpdatesModule updatesModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (updatesModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(updatesModule);
            moduleDefinitionBuilder.Name("ExpoUpdates");
            moduleDefinitionBuilder.Events("Expo.nativeUpdatesStateChangeEvent");
            moduleDefinitionBuilder.Constants(new Function0<Map<String, ? extends Object>>() { // from class: expo.modules.updates.UpdatesModule$definition$1$1
                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends Object> invoke() {
                    File filesDir = this.this$0.getContext().getFilesDir();
                    Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
                    new UpdatesLogger(filesDir).info("UpdatesModule: getConstants called", UpdatesErrorCode.None);
                    return UpdatesController.getInstance().getConstantsForModule().toModuleConstantsMap();
                }
            });
            moduleDefinitionBuilder.OnStartObserving("Expo.nativeUpdatesStateChangeEvent", new Function0<Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$1$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    UpdatesController.INSTANCE.setUpdatesEventManagerObserver$expo_updates_release(new WeakReference<>(this.this$0));
                }
            });
            moduleDefinitionBuilder.OnStopObserving("Expo.nativeUpdatesStateChangeEvent", new Function0<Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$1$3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    UpdatesController.INSTANCE.removeUpdatesEventManagerObserver$expo_updates_release();
                }
            });
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    UpdatesController.INSTANCE.removeUpdatesEventManagerObserver$expo_updates_release();
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("reload");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyType[] anyTypeArr = new AnyType[1];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ReloadScreenOptions.class), true));
            Object obj = null;
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ReloadScreenOptions.class, true, ReloadScreenOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(ReloadScreenOptions.class);
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
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(ReloadScreenOptions.class));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType;
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr, new UpdatesModule$definition$lambda$0$$inlined$Coroutine$2(null)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("checkForUpdateAsync");
            SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction2.getName(), new AnyType[0], new UpdatesModule$definition$lambda$0$$inlined$Coroutine$3(null));
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(suspendFunctionComponent);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction3 = moduleDefinitionBuilder.AsyncFunction("fetchUpdateAsync");
            SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction3.getName(), new AnyType[0], new UpdatesModule$definition$lambda$0$$inlined$Coroutine$4(null));
            asyncFunctionBuilderAsyncFunction3.setAsyncFunctionComponent(suspendFunctionComponent2);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction4 = moduleDefinitionBuilder.AsyncFunction("getExtraParamsAsync");
            SuspendFunctionComponent suspendFunctionComponent3 = new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction4.getName(), new AnyType[0], new UpdatesModule$definition$lambda$0$$inlined$Coroutine$5(null, this));
            asyncFunctionBuilderAsyncFunction4.setAsyncFunctionComponent(suspendFunctionComponent3);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction5 = moduleDefinitionBuilder.AsyncFunction("setExtraParamAsync");
            String name2 = asyncFunctionBuilderAsyncFunction5.getName();
            TypeConverterProvider converters2 = asyncFunctionBuilderAsyncFunction5.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$Coroutine$6
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
                anyType2 = new AnyType(typeDescriptor2, converters2);
            }
            anyTypeArr2[0] = anyType2;
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$Coroutine$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
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
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType3 = new AnyType(typeDescriptor3, converters2);
            }
            anyTypeArr2[1] = anyType3;
            asyncFunctionBuilderAsyncFunction5.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, anyTypeArr2, new UpdatesModule$definition$lambda$0$$inlined$Coroutine$8(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction6 = moduleDefinitionBuilder.AsyncFunction("readLogEntriesAsync");
            String name3 = asyncFunctionBuilderAsyncFunction6.getName();
            TypeConverterProvider converters3 = asyncFunctionBuilderAsyncFunction6.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[1];
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Long.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.LONG), new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$Coroutine$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Long.TYPE);
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
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Long.TYPE));
                }
                anyType4 = new AnyType(typeDescriptor4, converters3);
            }
            anyTypeArr3[0] = anyType4;
            asyncFunctionBuilderAsyncFunction6.setAsyncFunctionComponent(new SuspendFunctionComponent(name3, anyTypeArr3, new UpdatesModule$definition$lambda$0$$inlined$Coroutine$10(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction7 = moduleDefinitionBuilder.AsyncFunction("clearLogEntriesAsync");
            SuspendFunctionComponent suspendFunctionComponent4 = new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction7.getName(), new AnyType[0], new UpdatesModule$definition$lambda$0$$inlined$Coroutine$11(null, this));
            asyncFunctionBuilderAsyncFunction7.setAsyncFunctionComponent(suspendFunctionComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters4 = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[1];
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(UpdatesConfigurationOverrideParam.class), true));
            if (anyType5 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(UpdatesConfigurationOverrideParam.class, true, UpdatesConfigurationOverrideParam.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(UpdatesModule.UpdatesConfigurationOverrideParam.class);
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
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(UpdatesConfigurationOverrideParam.class));
                }
                anyType5 = new AnyType(typeDescriptor5, converters4);
            }
            anyTypeArr4[0] = anyType5;
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Unit.class);
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter == null) {
                    directConverter = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(Unit.class, returnType2);
                returnType = returnType2;
            }
            moduleDefinitionBuilder2.getSyncFunctions().put("setUpdateURLAndRequestHeadersOverride", new SyncFunctionComponent("setUpdateURLAndRequestHeadersOverride", anyTypeArr4, returnType, new Function1<Object[], Object>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    UpdatesModule.UpdatesConfigurationOverrideParam updatesConfigurationOverrideParam = (UpdatesModule.UpdatesConfigurationOverrideParam) objArr[0];
                    UpdatesController.getInstance().setUpdateURLAndRequestHeadersOverride(updatesConfigurationOverrideParam != null ? updatesConfigurationOverrideParam.toUpdatesConfigurationOverride() : null);
                    return Unit.INSTANCE;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters5 = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[1];
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), true));
            if (anyType6 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, true, Arrays.asList(PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.STRING), null)), new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$Function$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
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
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                }
                anyType6 = new AnyType(typeDescriptor6, converters5);
            }
            anyTypeArr5[0] = anyType6;
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider2.getTypes().get(Unit.class);
            if (returnType3 == null) {
                JSTypeConverter<?> directConverter2 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter2 == null) {
                    directConverter2 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType4 = new ReturnType(directConverter2);
                returnTypeProvider2.getTypes().put(Unit.class, returnType4);
                returnType3 = returnType4;
            }
            moduleDefinitionBuilder3.getSyncFunctions().put("setUpdateRequestHeadersOverride", new SyncFunctionComponent("setUpdateRequestHeadersOverride", anyTypeArr5, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    UpdatesController.getInstance().setUpdateRequestHeadersOverride((Map) objArr[0]);
                    return Unit.INSTANCE;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(ReloadScreenOptions.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("showReloadScreen", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters6 = moduleDefinitionBuilder4.getConverters();
                AnyType[] anyTypeArr6 = new AnyType[1];
                AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ReloadScreenOptions.class), true));
                if (anyType7 == null) {
                    try {
                        Result.Companion companion13 = Result.INSTANCE;
                        objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ReloadScreenOptions.class, true, ReloadScreenOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.nullableTypeOf(ReloadScreenOptions.class);
                            }
                        }));
                    } catch (Throwable th7) {
                        Result.Companion companion14 = Result.INSTANCE;
                        objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
                    }
                    if (!Result.m12690isFailureimpl(objM12684constructorimpl7)) {
                        obj = objM12684constructorimpl7;
                    }
                    TypeDescriptor typeDescriptor7 = (TypeDescriptor) obj;
                    if (typeDescriptor7 == null) {
                        typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(ReloadScreenOptions.class));
                    }
                    anyType7 = new AnyType(typeDescriptor7, converters6);
                }
                anyTypeArr6[0] = anyType7;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("showReloadScreen", anyTypeArr6, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("showReloadScreen", anyTypeArr6, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("showReloadScreen", anyTypeArr6, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("showReloadScreen", anyTypeArr6, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("showReloadScreen", anyTypeArr6, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("showReloadScreen", anyTypeArr6, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("showReloadScreen", asyncFunctionWithPromiseComponent);
            asyncFunctionWithPromiseComponent.runOnQueue(Queues.MAIN);
            UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("hideReloadScreen", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$0$$inlined$AsyncFunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("hideReloadScreen", untypedAsyncFunctionComponent2);
            untypedAsyncFunctionComponent2.runOnQueue(Queues.MAIN);
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th8) {
            Trace.endSection();
            throw th8;
        }
    }

    /* JADX INFO: compiled from: UpdatesModule.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0080@¢\u0006\u0004\b\u000e\u0010\u000fJC\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2)\u0010\u0012\u001a%\u0012\u001b\u0012\u0019\u0018\u00010\u0014j\u0004\u0018\u0001`\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0013H\u0080@¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lexpo/modules/updates/UpdatesModule$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "readLogEntries", "", "Landroid/os/Bundle;", "filesDirectory", "Ljava/io/File;", "maxAge", "", "readLogEntries$expo_updates_release", "(Ljava/io/File;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearLogEntries", "", "completionHandler", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/ParameterName;", "name", "_", "Lkotlin/Exception;", "clearLogEntries$expo_updates_release", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object readLogEntries$expo_updates_release(File file, long j, Continuation<? super List<Bundle>> continuation) {
            return BuildersKt.withContext(Dispatchers.getIO(), new UpdatesModule$Companion$readLogEntries$2(file, j, null), continuation);
        }

        public final Object clearLogEntries$expo_updates_release(File file, Function1<? super Exception, Unit> function1, Continuation<? super Unit> continuation) {
            new UpdatesLogReader(file).purgeLogEntries(new Date(), function1);
            return Unit.INSTANCE;
        }
    }

    @Override // expo.modules.updates.events.IUpdatesEventManagerObserver
    public void onStateMachineContextEvent(UpdatesStateContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        bundle.putBundle(RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, context.getBundle());
        Unit unit = Unit.INSTANCE;
        sendEvent("Expo.nativeUpdatesStateChangeEvent", bundle);
    }

    /* JADX INFO: compiled from: UpdatesModule.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0083\u0004J\f\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0016J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0007HÖ\u0081\u0004R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lexpo/modules/updates/UpdatesModule$UpdatesConfigurationOverrideParam;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY, "Landroid/net/Uri;", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "", "", "<init>", "(Landroid/net/Uri;Ljava/util/Map;)V", "getUpdateUrl$annotations", "()V", "getUpdateUrl", "()Landroid/net/Uri;", "getRequestHeaders$annotations", "getRequestHeaders", "()Ljava/util/Map;", "toUpdatesConfigurationOverride", "Lexpo/modules/updates/UpdatesConfigurationOverride;", "component1", "component2", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class UpdatesConfigurationOverrideParam implements Record, PIntrospectionProvider {
        public Map<String, String> requestHeaders;
        public Uri updateUrl;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpdatesConfigurationOverrideParam copy$default(UpdatesConfigurationOverrideParam updatesConfigurationOverrideParam, Uri uri, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = updatesConfigurationOverrideParam.updateUrl;
            }
            if ((i & 2) != 0) {
                map = updatesConfigurationOverrideParam.requestHeaders;
            }
            return updatesConfigurationOverrideParam.copy(uri, map);
        }

        @Field
        public static /* synthetic */ void getRequestHeaders$annotations() {
        }

        @Field
        public static /* synthetic */ void getUpdateUrl$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Uri getUpdateUrl() {
            return this.updateUrl;
        }

        public final Map<String, String> component2() {
            return this.requestHeaders;
        }

        public final UpdatesConfigurationOverrideParam copy(Uri updateUrl, Map<String, String> requestHeaders) {
            Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            return new UpdatesConfigurationOverrideParam(updateUrl, requestHeaders);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatesConfigurationOverrideParam)) {
                return false;
            }
            UpdatesConfigurationOverrideParam updatesConfigurationOverrideParam = (UpdatesConfigurationOverrideParam) other;
            return Intrinsics.areEqual(this.updateUrl, updatesConfigurationOverrideParam.updateUrl) && Intrinsics.areEqual(this.requestHeaders, updatesConfigurationOverrideParam.requestHeaders);
        }

        @Override // io.github.expo.pika.PIntrospectionProvider
        public PIntrospectionData<?> getIntrospectionData() {
            return __Pika.__pika$IntrospectionData;
        }

        public int hashCode() {
            return (this.updateUrl.hashCode() * 31) + this.requestHeaders.hashCode();
        }

        public String toString() {
            return "UpdatesConfigurationOverrideParam(updateUrl=" + this.updateUrl + ", requestHeaders=" + this.requestHeaders + ")";
        }

        /* JADX INFO: compiled from: UpdatesModule.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/UpdatesModule$UpdatesConfigurationOverrideParam$__Pika;", "", "<init>", "()V", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class __Pika implements PPropertyAccessor {
            public static final __Pika INSTANCE;
            public static final PIntrospectionData<UpdatesConfigurationOverrideParam> __pika$IntrospectionData;

            static {
                __Pika __pika = new __Pika();
                INSTANCE = __pika;
                __pika$IntrospectionData = new PIntrospectionData<>(UpdatesConfigurationOverrideParam.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, false, null), 0, __pika, false, true, false), new PProperty(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.STRING}), null), 1, __pika, false, true, false)}, new PFunction[]{new PFunction("toUpdatesConfigurationOverride", PVisibility.PUBLIC), new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            }

            @Override // io.github.expo.pika.PPropertyAccessor
            public Object __pika$PropertyGet(Object obj, int i) {
                if (i == 0) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.UpdatesModule.UpdatesConfigurationOverrideParam");
                    return ((UpdatesConfigurationOverrideParam) obj).getUpdateUrl();
                }
                if (i != 1) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.UpdatesModule.UpdatesConfigurationOverrideParam");
                return ((UpdatesConfigurationOverrideParam) obj).getRequestHeaders();
            }

            @Override // io.github.expo.pika.PPropertyAccessor
            public void __pika$PropertySet(Object obj, int i, Object obj2) {
                if (i == 0) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.UpdatesModule.UpdatesConfigurationOverrideParam");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.net.Uri");
                    ((UpdatesConfigurationOverrideParam) obj).updateUrl = (Uri) obj2;
                    return;
                }
                if (i != 1) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.updates.UpdatesModule.UpdatesConfigurationOverrideParam");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                ((UpdatesConfigurationOverrideParam) obj).requestHeaders = (Map) obj2;
            }

            private __Pika() {
            }
        }

        public UpdatesConfigurationOverrideParam(Uri updateUrl, Map<String, String> requestHeaders) {
            Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            this.updateUrl = updateUrl;
            this.requestHeaders = requestHeaders;
        }

        public final Uri getUpdateUrl() {
            return this.updateUrl;
        }

        public final Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }

        public final UpdatesConfigurationOverride toUpdatesConfigurationOverride() {
            return new UpdatesConfigurationOverride(this.updateUrl, this.requestHeaders);
        }
    }
}
