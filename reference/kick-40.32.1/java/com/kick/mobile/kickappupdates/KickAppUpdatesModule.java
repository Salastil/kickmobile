package com.kick.mobile.kickappupdates;

import android.content.Context;
import androidx.tracing.Trace;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
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
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.TypeDescriptorOfKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: KickAppUpdatesModule.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/kick/mobile/kickappupdates/KickAppUpdatesModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "hasPlayServicesSupport", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "kick-app-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KickAppUpdatesModule extends Module {
    private AppUpdateManager appUpdateManager;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasPlayServicesSupport() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext == null) {
            return false;
        }
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Intrinsics.checkNotNullExpressionValue(googleApiAvailability, "getInstance(...)");
        return googleApiAvailability.isGooglePlayServicesAvailable(reactContext) == 0;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        KickAppUpdatesModule kickAppUpdatesModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (kickAppUpdatesModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(kickAppUpdatesModule);
            moduleDefinitionBuilder.Name("KickAppUpdates");
            moduleDefinitionBuilder.Constants(new Function0<Map<String, ? extends Object>>() { // from class: com.kick.mobile.kickappupdates.KickAppUpdatesModule$definition$1$1
                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends Object> invoke() {
                    return MapsKt.mapOf(TuplesKt.to("STORE_URL", "https://play.google.com/store/apps/details?id=com.kick.mobile"), TuplesKt.to("FETCH_UPDATES_URL", null));
                }
            });
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: com.kick.mobile.kickappupdates.KickAppUpdatesModule$definition$lambda$0$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    if (reactContext != null) {
                        this.this$0.appUpdateManager = AppUpdateManagerFactory.create(reactContext);
                    }
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getLatestStoreVersion", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: com.kick.mobile.kickappupdates.KickAppUpdatesModule$definition$lambda$0$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        boolean zHasPlayServicesSupport = this.this$0.hasPlayServicesSupport();
                        AppUpdateManager appUpdateManager = this.this$0.appUpdateManager;
                        if (appUpdateManager == null) {
                            promise.reject("UNKNOWN", "UNKNOWN", new Error("UNKNOWN"));
                            return;
                        }
                        if (!zHasPlayServicesSupport) {
                            promise.reject("NO_PLAY_SERVICES", "NO_PLAY_SERVICES", new Error("NO_PLAY_SERVICES"));
                            return;
                        }
                        Task<AppUpdateInfo> appUpdateInfo = appUpdateManager.getAppUpdateInfo();
                        Intrinsics.checkNotNullExpressionValue(appUpdateInfo, "getAppUpdateInfo(...)");
                        appUpdateInfo.addOnSuccessListener(new KickAppUpdatesModule$sam$com_google_android_gms_tasks_OnSuccessListener$0(new KickAppUpdatesModule$definition$1$3$1(promise)));
                        appUpdateInfo.addOnFailureListener(new KickAppUpdatesModule$definition$1$3$2(promise));
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        PTypeDescriptor pTypeDescriptorThrowNonReifiedTypeDescriptorError = TypeDescriptorOfKt.throwNonReifiedTypeDescriptorError();
                        MagicApiIntrinsics.voidMagicApiCall("io.github.expo.pika.typeDescriptorOf");
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt.toRawTypeDescriptor(pTypeDescriptorThrowNonReifiedTypeDescriptorError), new Function0<KType>() { // from class: com.kick.mobile.kickappupdates.KickAppUpdatesModule$definition$lambda$0$$inlined$AsyncFunction$2
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
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: com.kick.mobile.kickappupdates.KickAppUpdatesModule$definition$lambda$0$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Promise promise = (Promise) objArr[0];
                        boolean zHasPlayServicesSupport = this.this$0.hasPlayServicesSupport();
                        AppUpdateManager appUpdateManager = this.this$0.appUpdateManager;
                        if (appUpdateManager == null) {
                            promise.reject("UNKNOWN", "UNKNOWN", new Error("UNKNOWN"));
                        } else if (!zHasPlayServicesSupport) {
                            promise.reject("NO_PLAY_SERVICES", "NO_PLAY_SERVICES", new Error("NO_PLAY_SERVICES"));
                        } else {
                            Task<AppUpdateInfo> appUpdateInfo = appUpdateManager.getAppUpdateInfo();
                            Intrinsics.checkNotNullExpressionValue(appUpdateInfo, "getAppUpdateInfo(...)");
                            appUpdateInfo.addOnSuccessListener(new KickAppUpdatesModule$sam$com_google_android_gms_tasks_OnSuccessListener$0(new KickAppUpdatesModule$definition$1$3$1(promise)));
                            appUpdateInfo.addOnFailureListener(new KickAppUpdatesModule$definition$1$3$2(promise));
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("getLatestStoreVersion", anyTypeArr, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("getLatestStoreVersion", anyTypeArr, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("getLatestStoreVersion", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("getLatestStoreVersion", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("getLatestStoreVersion", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("getLatestStoreVersion", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            AsyncFunctionComponent asyncFunctionComponent = asyncFunctionWithPromiseComponent;
            moduleDefinitionBuilder2.getAsyncFunctions().put("getLatestStoreVersion", asyncFunctionWithPromiseComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionWithPromiseComponent;
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }
}
