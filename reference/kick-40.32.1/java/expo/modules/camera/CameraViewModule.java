package expo.modules.camera;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner;
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions;
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning;
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions;
import com.google.mlkit.vision.documentscanner.GmsDocumentScanning;
import expo.modules.camera.analyzers.BarCodeScannerResultSerializer;
import expo.modules.camera.analyzers.MLKitBarCodeScanner;
import expo.modules.camera.documentscanner.DocumentScannerActivityResult;
import expo.modules.camera.documentscanner.DocumentScannerContractInput;
import expo.modules.camera.records.BarcodeSettings;
import expo.modules.camera.records.BarcodeType;
import expo.modules.camera.records.CameraMode;
import expo.modules.camera.records.CameraRatio;
import expo.modules.camera.records.CameraType;
import expo.modules.camera.records.DocumentScannerOptions;
import expo.modules.camera.records.FlashMode;
import expo.modules.camera.records.FocusMode;
import expo.modules.camera.records.VideoQuality;
import expo.modules.camera.records.VideoStabilizationMode;
import expo.modules.camera.tasks.ResolveTakenPictureKt;
import expo.modules.camera.utils.CameraUtils;
import expo.modules.camera.utils.CameraViewHelper;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.core.logging.Logger;
import expo.modules.core.utilities.EmulatorUtilities;
import expo.modules.core.utilities.VRUtilities;
import expo.modules.interfaces.imageloader.ImageLoaderInterface;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import expo.modules.kotlin.classcomponent.ClassComponentBuilder;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.PropertyComponentBuilder;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.services.Service;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CameraViewModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0012\u0010\u001f\u001a\u00020 2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lexpo/modules/camera/CameraViewModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "moduleScope", "Lkotlinx/coroutines/CoroutineScope;", "pendingDocumentScanIntentSender", "Landroid/content/IntentSender;", "documentScanPromise", "Lexpo/modules/kotlin/Promise;", "documentScannerLauncher", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "Lexpo/modules/camera/documentscanner/DocumentScannerContractInput;", "Lexpo/modules/camera/documentscanner/DocumentScannerActivityResult;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "permissionsManager", "Lexpo/modules/interfaces/permissions/Permissions;", "getPermissionsManager", "()Lexpo/modules/interfaces/permissions/Permissions;", "launchDocumentScanner", "", "activity", "Landroid/app/Activity;", "options", "Lexpo/modules/camera/records/DocumentScannerOptions;", BaseJavaModule.METHOD_TYPE_PROMISE, "buildDocumentScannerOptions", "Lcom/google/mlkit/vision/documentscanner/GmsDocumentScannerOptions;", "handleDocumentScanResult", "activityResult", "Companion", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CameraViewModule extends Module {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "CameraViewModule";
    private Promise documentScanPromise;
    private AppContextActivityResultLauncher<DocumentScannerContractInput, DocumentScannerActivityResult> documentScannerLauncher;
    private final CoroutineScope moduleScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private IntentSender pendingDocumentScanIntentSender;

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
        Object objM12684constructorimpl4;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent4;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        Object objM12684constructorimpl8;
        Object objM12684constructorimpl9;
        AnyType anyType;
        Object objM12684constructorimpl10;
        Object objM12684constructorimpl11;
        Object objM12684constructorimpl12;
        Object objM12684constructorimpl13;
        Object objM12684constructorimpl14;
        Object objM12684constructorimpl15;
        Object objM12684constructorimpl16;
        Object objM12684constructorimpl17;
        Object objM12684constructorimpl18;
        Object objM12684constructorimpl19;
        Object objM12684constructorimpl20;
        Object objM12684constructorimpl21;
        Object objM12684constructorimpl22;
        Object objM12684constructorimpl23;
        Object objM12684constructorimpl24;
        Object objM12684constructorimpl25;
        Object objM12684constructorimpl26;
        Object objM12684constructorimpl27;
        Object objM12684constructorimpl28;
        Object objM12684constructorimpl29;
        Object objM12684constructorimpl30;
        Object objM12684constructorimpl31;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5;
        Object objM12684constructorimpl32;
        Object objM12684constructorimpl33;
        Object objM12684constructorimpl34;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6;
        Object objM12684constructorimpl35;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent7;
        Object objM12684constructorimpl36;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent8;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent8;
        Object objM12684constructorimpl37;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent9;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent9;
        CameraViewModule cameraViewModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (cameraViewModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(cameraViewModule);
            moduleDefinitionBuilder.Name("ExpoCamera");
            moduleDefinitionBuilder.Events("onModernBarcodeScanned");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder("isModernBarcodeScannerAvailable");
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Boolean.class);
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(Boolean.class);
                if (directConverter == null) {
                    directConverter = ReturnTypeKt.getIndirectConverter(Boolean.class, null);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(Boolean.class, returnType2);
                returnType = returnType2;
            }
            propertyComponentBuilder.setGetter(new SyncFunctionComponent("get", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(!VRUtilities.INSTANCE.isQuest() && CameraUtils.INSTANCE.isMLKitAvailable(this.this$0.getAppContext().getReactContext()));
                }
            }));
            moduleDefinitionBuilder2.getProperties().put("isModernBarcodeScannerAvailable", propertyComponentBuilder);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            PropertyComponentBuilder propertyComponentBuilder2 = new PropertyComponentBuilder("toggleRecordingAsyncAvailable");
            AnyType[] anyTypeArr2 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider2.getTypes().get(Boolean.class);
            if (returnType3 == null) {
                JSTypeConverter<?> directConverter2 = ReturnTypeKt.getDirectConverter(Boolean.class);
                if (directConverter2 == null) {
                    directConverter2 = ReturnTypeKt.getIndirectConverter(Boolean.class, null);
                }
                ReturnType returnType4 = new ReturnType(directConverter2);
                returnTypeProvider2.getTypes().put(Boolean.class, returnType4);
                returnType3 = returnType4;
            }
            propertyComponentBuilder2.setGetter(new SyncFunctionComponent("get", anyTypeArr2, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            }));
            moduleDefinitionBuilder3.getProperties().put("toggleRecordingAsyncAvailable", propertyComponentBuilder2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("requestCameraPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exceptions.PermissionsModuleNotFound {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws Exceptions.PermissionsModuleNotFound {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions permissionsManager = this.this$0.getPermissionsManager();
                        String[] cameraPermissions = CameraViewModuleKt.getCameraPermissions();
                        Permissions.askForPermissionsWithPermissionsManager(permissionsManager, promise, (String[]) Arrays.copyOf(cameraPermissions, cameraPermissions.length));
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder4.getConverters();
                AnyType[] anyTypeArr3 = new AnyType[1];
                AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType2 == null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Promise.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunction$2
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
                    anyType2 = new AnyType(typeDescriptor, converters);
                }
                anyTypeArr3[0] = anyType2;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws Exceptions.PermissionsModuleNotFound {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Promise promise = (Promise) objArr[0];
                        Permissions permissionsManager = this.this$0.getPermissionsManager();
                        String[] cameraPermissions = CameraViewModuleKt.getCameraPermissions();
                        Permissions.askForPermissionsWithPermissionsManager(permissionsManager, promise, (String[]) Arrays.copyOf(cameraPermissions, cameraPermissions.length));
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr3, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr3, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr3, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr3, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr3, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr3, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("requestCameraPermissionsAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("requestMicrophonePermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunction$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.RECORD_AUDIO");
                    }
                });
            } else {
                TypeConverterProvider converters2 = moduleDefinitionBuilder5.getConverters();
                AnyType[] anyTypeArr4 = new AnyType[1];
                AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType3 == null) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Promise.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunction$5
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
                    anyType3 = new AnyType(typeDescriptor2, converters2);
                }
                anyTypeArr4[0] = anyType3;
                Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), (Promise) objArr[0], "android.permission.RECORD_AUDIO");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr4, function2);
                                } else {
                                    untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr4, function2);
                                }
                            } else {
                                untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr4, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr4, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr4, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr4, function2);
                }
                asyncFunctionWithPromiseComponent2 = untypedAsyncFunctionComponent2;
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("requestMicrophonePermissionsAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("getCameraPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunction$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exceptions.PermissionsModuleNotFound {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws Exceptions.PermissionsModuleNotFound {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions permissionsManager = this.this$0.getPermissionsManager();
                        String[] cameraPermissions = CameraViewModuleKt.getCameraPermissions();
                        Permissions.getPermissionsWithPermissionsManager(permissionsManager, promise, (String[]) Arrays.copyOf(cameraPermissions, cameraPermissions.length));
                    }
                });
            } else {
                TypeConverterProvider converters3 = moduleDefinitionBuilder6.getConverters();
                AnyType[] anyTypeArr5 = new AnyType[1];
                AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType4 == null) {
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Promise.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunction$8
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Promise.class);
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
                        typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Promise.class));
                    }
                    anyType4 = new AnyType(typeDescriptor3, converters3);
                }
                anyTypeArr5[0] = anyType4;
                Function1<Object[], Unit> function3 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws Exceptions.PermissionsModuleNotFound {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Promise promise = (Promise) objArr[0];
                        Permissions permissionsManager = this.this$0.getPermissionsManager();
                        String[] cameraPermissions = CameraViewModuleKt.getCameraPermissions();
                        Permissions.getPermissionsWithPermissionsManager(permissionsManager, promise, (String[]) Arrays.copyOf(cameraPermissions, cameraPermissions.length));
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr5, function3);
                                } else {
                                    untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr5, function3);
                                }
                            } else {
                                untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr5, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr5, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr5, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr5, function3);
                }
                asyncFunctionWithPromiseComponent3 = untypedAsyncFunctionComponent3;
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("getCameraPermissionsAsync", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("getMicrophonePermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunction$10
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.RECORD_AUDIO");
                    }
                });
            } else {
                TypeConverterProvider converters4 = moduleDefinitionBuilder7.getConverters();
                AnyType[] anyTypeArr6 = new AnyType[1];
                AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType5 == null) {
                    try {
                        Result.Companion companion7 = Result.INSTANCE;
                        objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Promise.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunction$11
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Promise.class);
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
                        typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Promise.class));
                    }
                    anyType5 = new AnyType(typeDescriptor4, converters4);
                }
                anyTypeArr6[0] = anyType5;
                Function1<Object[], Unit> function4 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunction$12
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), (Promise) objArr[0], "android.permission.RECORD_AUDIO");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent4 = new StringAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr6, function4);
                                } else {
                                    untypedAsyncFunctionComponent4 = new UntypedAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr6, function4);
                                }
                            } else {
                                untypedAsyncFunctionComponent4 = new FloatAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr6, function4);
                            }
                        } else {
                            untypedAsyncFunctionComponent4 = new DoubleAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr6, function4);
                        }
                    } else {
                        untypedAsyncFunctionComponent4 = new BoolAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr6, function4);
                    }
                } else {
                    untypedAsyncFunctionComponent4 = new IntAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr6, function4);
                }
                asyncFunctionWithPromiseComponent4 = untypedAsyncFunctionComponent4;
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("getMicrophonePermissionsAsync", asyncFunctionWithPromiseComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            TypeConverterProvider converters5 = moduleDefinitionBuilder8.getConverters();
            AnyType[] anyTypeArr7 = new AnyType[2];
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType6 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunctionWithPromise$1
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
                anyType6 = new AnyType(typeDescriptor5, converters5);
            }
            anyTypeArr7[0] = anyType6;
            AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType7 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(BarcodeType.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunctionWithPromise$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(BarcodeType.class)));
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
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(BarcodeType.class))));
                }
                anyType7 = new AnyType(typeDescriptor6, converters5);
            }
            anyTypeArr7[1] = anyType7;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent10 = new AsyncFunctionWithPromiseComponent("scanFromURLAsync", anyTypeArr7, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunctionWithPromise$3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    final List list = (List) objArr[1];
                    final String str = (String) obj;
                    if (!CameraUtils.INSTANCE.isMLKitAvailable(this.this$0.getAppContext().getReactContext())) {
                        promise.reject(new CameraExceptions.MLKitUnavailableException());
                        return;
                    }
                    Service service = this.this$0.getAppContext().getServices().getRegistry().get(ImageLoaderInterface.class);
                    if (!(service instanceof ImageLoaderInterface)) {
                        service = null;
                    }
                    ImageLoaderInterface imageLoaderInterface = (ImageLoaderInterface) service;
                    if (imageLoaderInterface != null) {
                        final CameraViewModule cameraViewModule2 = this.this$0;
                        imageLoaderInterface.loadImageForManipulationFromURL(str, new ImageLoaderInterface.ResultListener() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$1
                            @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
                            public void onSuccess(Bitmap bitmap) {
                                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                                try {
                                    MLKitBarCodeScanner mLKitBarCodeScanner = new MLKitBarCodeScanner();
                                    List<BarcodeType> list2 = list;
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                                    Iterator<T> it = list2.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(Integer.valueOf(((BarcodeType) it.next()).mapToBarcode()));
                                    }
                                    ArrayList arrayList2 = arrayList;
                                    mLKitBarCodeScanner.setSettings(arrayList2);
                                    BuildersKt__Builders_commonKt.launch$default(cameraViewModule2.moduleScope, null, null, new CameraViewModule$definition$1$7$1$onSuccess$1(mLKitBarCodeScanner, bitmap, promise, arrayList2, null), 3, null);
                                } catch (Exception unused) {
                                    promise.reject(new CameraExceptions.MLKitUnavailableException());
                                }
                            }

                            @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
                            public void onFailure(Throwable cause) {
                                promise.reject(new CameraExceptions.ImageRetrievalException(str));
                            }
                        });
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder8.getAsyncFunctions().put("scanFromURLAsync", asyncFunctionWithPromiseComponent10);
            ModuleDefinitionBuilder moduleDefinitionBuilder9 = moduleDefinitionBuilder;
            TypeConverterProvider converters6 = moduleDefinitionBuilder9.getConverters();
            AnyType[] anyTypeArr8 = new AnyType[1];
            AnyType anyType8 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(BarcodeSettings.class), false));
            if (anyType8 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(BarcodeSettings.class, false, BarcodeSettings.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunctionWithPromise$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(BarcodeSettings.class);
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
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(BarcodeSettings.class));
                }
                anyType8 = new AnyType(typeDescriptor7, converters6);
            }
            anyTypeArr8[0] = anyType8;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent11 = new AsyncFunctionWithPromiseComponent("launchScanner", anyTypeArr8, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunctionWithPromise$5
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    BarcodeSettings barcodeSettings = (BarcodeSettings) objArr[0];
                    if (!CameraUtils.INSTANCE.isMLKitBarcodeScannerAvailable()) {
                        promise.reject(new CameraExceptions.MLKitUnavailableException());
                        return;
                    }
                    if (!CameraUtils.INSTANCE.hasGooglePlayServices(this.this$0.getAppContext().getReactContext())) {
                        promise.reject(new CameraExceptions.GooglePlayServicesUnavailableException());
                        return;
                    }
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    if (reactContext == null) {
                        promise.reject(new Exceptions.ReactContextLost());
                        return;
                    }
                    try {
                        GmsBarcodeScannerOptions.Builder builder = new GmsBarcodeScannerOptions.Builder();
                        if (!barcodeSettings.getBarcodeTypes().isEmpty()) {
                            int iMapToBarcode = ((BarcodeType) CollectionsKt.first((List) barcodeSettings.getBarcodeTypes())).mapToBarcode();
                            List listDrop = CollectionsKt.drop(barcodeSettings.getBarcodeTypes(), 1);
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listDrop, 10));
                            Iterator it = listDrop.iterator();
                            while (it.hasNext()) {
                                arrayList.add(Integer.valueOf(((BarcodeType) it.next()).mapToBarcode()));
                            }
                            int[] intArray = CollectionsKt.toIntArray(arrayList);
                            builder.setBarcodeFormats(iMapToBarcode, Arrays.copyOf(intArray, intArray.length));
                        }
                        GmsBarcodeScannerOptions gmsBarcodeScannerOptionsBuild = builder.build();
                        Intrinsics.checkNotNullExpressionValue(gmsBarcodeScannerOptionsBuild, "build(...)");
                        GmsBarcodeScanner client = GmsBarcodeScanning.getClient(reactContext, gmsBarcodeScannerOptionsBuild);
                        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
                        Task<Barcode> taskStartScan = client.startScan();
                        final CameraViewModule cameraViewModule2 = this.this$0;
                        final Function1<Barcode, Unit> function5 = new Function1<Barcode, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$8$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Barcode barcode) {
                                invoke2(barcode);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Barcode barcode) {
                                BarCodeScannerResultSerializer barCodeScannerResultSerializer = BarCodeScannerResultSerializer.INSTANCE;
                                Intrinsics.checkNotNull(barcode);
                                cameraViewModule2.sendEvent("onModernBarcodeScanned", BarCodeScannerResultSerializer.INSTANCE.toBundle(BarCodeScannerResultSerializer.parseBarcodeScanningResult$default(barCodeScannerResultSerializer, barcode, null, 2, null), 1.0f));
                                promise.resolve();
                            }
                        };
                        Intrinsics.checkNotNull(taskStartScan.addOnSuccessListener(new OnSuccessListener(function5) { // from class: expo.modules.camera.CameraViewModuleKt$sam$com_google_android_gms_tasks_OnSuccessListener$0
                            private final /* synthetic */ Function1 function;

                            {
                                Intrinsics.checkNotNullParameter(function5, "function");
                                this.function = function5;
                            }

                            @Override // com.google.android.gms.tasks.OnSuccessListener
                            public final /* synthetic */ void onSuccess(Object obj) {
                                this.function.invoke(obj);
                            }
                        }).addOnCanceledListener(new OnCanceledListener() { // from class: expo.modules.camera.CameraViewModule$definition$1$8$2
                            @Override // com.google.android.gms.tasks.OnCanceledListener
                            public final void onCanceled() {
                                promise.reject(new CameraExceptions.BarcodeScanningCancelledException());
                            }
                        }).addOnFailureListener(new OnFailureListener() { // from class: expo.modules.camera.CameraViewModule$definition$1$8$3
                            @Override // com.google.android.gms.tasks.OnFailureListener
                            public final void onFailure(Exception it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                promise.reject(new CameraExceptions.BarcodeScanningFailedException());
                            }
                        }));
                    } catch (Exception unused) {
                        promise.reject(new CameraExceptions.GooglePlayServicesUnavailableException());
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder9.getAsyncFunctions().put("launchScanner", asyncFunctionWithPromiseComponent11);
            moduleDefinitionBuilder.getAsyncFunctions().put("dismissScanner", new UntypedAsyncFunctionComponent("dismissScanner", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Unit.INSTANCE;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder10 = moduleDefinitionBuilder;
            PropertyComponentBuilder propertyComponentBuilder3 = new PropertyComponentBuilder("isDocumentScannerAvailable");
            AnyType[] anyTypeArr9 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider3 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType5 = returnTypeProvider3.getTypes().get(Boolean.class);
            if (returnType5 == null) {
                JSTypeConverter<?> directConverter3 = ReturnTypeKt.getDirectConverter(Boolean.class);
                if (directConverter3 == null) {
                    directConverter3 = ReturnTypeKt.getIndirectConverter(Boolean.class, null);
                }
                ReturnType returnType6 = new ReturnType(directConverter3);
                returnTypeProvider3.getTypes().put(Boolean.class, returnType6);
                returnType5 = returnType6;
            }
            propertyComponentBuilder3.setGetter(new SyncFunctionComponent("get", anyTypeArr9, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$Property$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(CameraUtils.INSTANCE.isMLKitDocumentScannerAvailable() && CameraUtils.INSTANCE.hasGooglePlayServices(this.this$0.getAppContext().getReactContext()));
                }
            }));
            moduleDefinitionBuilder10.getProperties().put("isDocumentScannerAvailable", propertyComponentBuilder3);
            moduleDefinitionBuilder.RegisterActivityContracts(new CameraViewModule$definition$1$11(this, null));
            ModuleDefinitionBuilder moduleDefinitionBuilder11 = moduleDefinitionBuilder;
            TypeConverterProvider converters7 = moduleDefinitionBuilder11.getConverters();
            AnyType[] anyTypeArr10 = new AnyType[1];
            AnyType anyType9 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DocumentScannerOptions.class), true));
            if (anyType9 == null) {
                try {
                    Result.Companion companion15 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DocumentScannerOptions.class, true, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunctionWithPromise$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(DocumentScannerOptions.class);
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
                    typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(DocumentScannerOptions.class));
                }
                anyType9 = new AnyType(typeDescriptor8, converters7);
            }
            anyTypeArr10[0] = anyType9;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent12 = new AsyncFunctionWithPromiseComponent("scanDocumentAsync", anyTypeArr10, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$AsyncFunctionWithPromise$7
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    DocumentScannerOptions documentScannerOptions = (DocumentScannerOptions) objArr[0];
                    if (!CameraUtils.INSTANCE.isMLKitDocumentScannerAvailable()) {
                        promise.reject(new CameraExceptions.DocumentScannerUnavailableException());
                        return;
                    }
                    if (!CameraUtils.INSTANCE.hasGooglePlayServices(this.this$0.getAppContext().getReactContext())) {
                        promise.reject(new CameraExceptions.GooglePlayServicesUnavailableException());
                        return;
                    }
                    Activity currentActivity = this.this$0.getAppContext().getCurrentActivity();
                    if (currentActivity != null) {
                        if (this.this$0.documentScanPromise == null) {
                            this.this$0.launchDocumentScanner(currentActivity, documentScannerOptions, promise);
                            return;
                        } else {
                            promise.reject(new CameraExceptions.DocumentScanningFailedException("a document scan is already in progress"));
                            return;
                        }
                    }
                    promise.reject(new Exceptions.MissingActivity());
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder11.getAsyncFunctions().put("scanDocumentAsync", asyncFunctionWithPromiseComponent12);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    try {
                        CoroutineScopeKt.cancel(this.this$0.moduleScope, new ModuleDestroyedException(null, 1, null));
                    } catch (IllegalStateException unused) {
                        Log.e(CameraViewModule.TAG, "The scope does not have a job in it");
                    }
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder12 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PictureRef.class);
            Module module = moduleDefinitionBuilder12.getModule();
            if (module == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext = module.getAppContext();
            AnyType anyType10 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PictureRef.class), false));
            if (anyType10 != null) {
                anyType = anyType10;
            } else {
                try {
                    Result.Companion companion17 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(PictureRef.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$Class$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(PictureRef.class);
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
                    typeDescriptor9 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(PictureRef.class));
                }
                anyType = new AnyType(typeDescriptor9, null);
            }
            ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(appContext, "Picture", orCreateKotlinClass, anyType, moduleDefinitionBuilder12.getConverters());
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getTypeDescriptor(), ViewProps.WIDTH);
            AnyType[] anyTypeArr11 = {new AnyType(propertyComponentBuilderWithThis.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider4 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType7 = returnTypeProvider4.getTypes().get(Integer.class);
            if (returnType7 == null) {
                JSTypeConverter<?> directConverter4 = ReturnTypeKt.getDirectConverter(Integer.class);
                if (directConverter4 == null) {
                    directConverter4 = ReturnTypeKt.getIndirectConverter(Integer.class, null);
                }
                ReturnType returnType8 = new ReturnType(directConverter4);
                returnTypeProvider4.getTypes().put(Integer.class, returnType8);
                returnType7 = returnType8;
            }
            SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("get", anyTypeArr11, returnType7, new Function1<Object[], Object>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$20$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(((PictureRef) it[0]).getRef().getWidth());
                }
            });
            syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
            syncFunctionComponent.setCanTakeOwner(true);
            propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
            classComponentBuilder.getProperties().put(ViewProps.WIDTH, propertyComponentBuilderWithThis);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis2 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getTypeDescriptor(), ViewProps.HEIGHT);
            AnyType[] anyTypeArr12 = {new AnyType(propertyComponentBuilderWithThis2.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider5 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType9 = returnTypeProvider5.getTypes().get(Integer.class);
            if (returnType9 == null) {
                JSTypeConverter<?> directConverter5 = ReturnTypeKt.getDirectConverter(Integer.class);
                if (directConverter5 == null) {
                    directConverter5 = ReturnTypeKt.getIndirectConverter(Integer.class, null);
                }
                ReturnType returnType10 = new ReturnType(directConverter5);
                returnTypeProvider5.getTypes().put(Integer.class, returnType10);
                returnType9 = returnType10;
            }
            SyncFunctionComponent syncFunctionComponent2 = new SyncFunctionComponent("get", anyTypeArr12, returnType9, new Function1<Object[], Object>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$20$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(((PictureRef) it[0]).getRef().getHeight());
                }
            });
            syncFunctionComponent2.setOwnerType(propertyComponentBuilderWithThis2.getThisType());
            syncFunctionComponent2.setCanTakeOwner(true);
            propertyComponentBuilderWithThis2.setGetter(syncFunctionComponent2);
            classComponentBuilder.getProperties().put(ViewProps.HEIGHT, propertyComponentBuilderWithThis2);
            ClassComponentBuilder classComponentBuilder2 = classComponentBuilder;
            TypeConverterProvider converters8 = classComponentBuilder2.getConverters();
            AnyType[] anyTypeArr13 = new AnyType[2];
            AnyType anyType11 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PictureRef.class), false));
            if (anyType11 == null) {
                try {
                    Result.Companion companion19 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(PictureRef.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$20$$inlined$AsyncFunctionWithPromise$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(PictureRef.class);
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
                    typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(PictureRef.class));
                }
                anyType11 = new AnyType(typeDescriptor10, converters8);
            }
            anyTypeArr13[0] = anyType11;
            AnyType anyType12 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SavePictureOptions.class), true));
            if (anyType12 == null) {
                try {
                    Result.Companion companion21 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SavePictureOptions.class, true, SavePictureOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$20$$inlined$AsyncFunctionWithPromise$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(SavePictureOptions.class);
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
                    typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(SavePictureOptions.class));
                }
                anyType12 = new AnyType(typeDescriptor11, converters8);
            }
            anyTypeArr13[1] = anyType12;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent13 = new AsyncFunctionWithPromiseComponent("savePictureAsync", anyTypeArr13, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$20$$inlined$AsyncFunctionWithPromise$3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    SavePictureOptions savePictureOptions = (SavePictureOptions) objArr[1];
                    Bitmap ref = ((PictureRef) obj).getRef();
                    Bundle bundle = new Bundle();
                    File cacheDirectory = this.this$0.getCacheDirectory();
                    bundle.putInt(ViewProps.WIDTH, ref.getWidth());
                    bundle.putInt(ViewProps.HEIGHT, ref.getHeight());
                    Number numberValueOf = savePictureOptions != null ? Double.valueOf(savePictureOptions.getQuality()) : 1;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                        ref.compress(Bitmap.CompressFormat.JPEG, numberValueOf.intValue() * 100, byteArrayOutputStream2);
                        try {
                            String strWriteStreamToFile$default = ResolveTakenPictureKt.writeStreamToFile$default(cacheDirectory, byteArrayOutputStream2, null, 4, null);
                            ref.recycle();
                            String string = Uri.fromFile(new File(strWriteStreamToFile$default)).toString();
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            bundle.putString("uri", string);
                            if (savePictureOptions != null && savePictureOptions.getBase64()) {
                                bundle.putString("base64", Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 2));
                            }
                            promise.resolve(bundle);
                        } catch (CodedException e) {
                            promise.reject(e);
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(byteArrayOutputStream, null);
                    } catch (Throwable th12) {
                        try {
                            throw th12;
                        } catch (Throwable th13) {
                            CloseableKt.closeFinally(byteArrayOutputStream, th12);
                            throw th13;
                        }
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            classComponentBuilder2.getAsyncFunctions().put("savePictureAsync", asyncFunctionWithPromiseComponent13);
            moduleDefinitionBuilder12.getClassData().add(classComponentBuilder.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder13 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ExpoCameraView.class);
            try {
                Result.Companion companion23 = Result.INSTANCE;
                objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ExpoCameraView.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$$inlined$View$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ExpoCameraView.class);
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
                typeDescriptor12 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ExpoCameraView.class));
            }
            final ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass2, typeDescriptor12, moduleDefinitionBuilder13.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            viewDefinitionBuilder.EventsWithArray(CameraViewModuleKt.getCameraEvents());
            Function2<ExpoCameraView, CameraType, Unit> function5 = new Function2<ExpoCameraView, CameraType, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, CameraType cameraType) {
                    invoke2(expoCameraView, cameraType);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, CameraType cameraType) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (cameraType != null) {
                        if (view.getLensFacing() != cameraType) {
                            view.setLensFacing(cameraType);
                        }
                    } else if (view.getLensFacing() != CameraType.BACK) {
                        view.setLensFacing(CameraType.BACK);
                    }
                }
            };
            AnyType anyType13 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(CameraType.class), true));
            if (anyType13 == null) {
                try {
                    Result.Companion companion25 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(CameraType.class, true, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(CameraType.class);
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
                    typeDescriptor13 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(CameraType.class));
                }
                anyType13 = new AnyType(typeDescriptor13, null);
            }
            viewDefinitionBuilder.getProps().put("facing", new ConcreteViewProp("facing", anyType13, function5));
            Function2<ExpoCameraView, FlashMode, Unit> function6 = new Function2<ExpoCameraView, FlashMode, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, FlashMode flashMode) {
                    invoke2(expoCameraView, flashMode);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, FlashMode flashMode) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (flashMode != null) {
                        if (view.getFlashMode() != flashMode) {
                            view.setFlashMode(flashMode);
                        }
                    } else if (view.getFlashMode() != FlashMode.OFF) {
                        view.setFlashMode(FlashMode.OFF);
                    }
                }
            };
            AnyType anyType14 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FlashMode.class), true));
            if (anyType14 == null) {
                try {
                    Result.Companion companion27 = Result.INSTANCE;
                    objM12684constructorimpl14 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FlashMode.class, true, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(FlashMode.class);
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
                    typeDescriptor14 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(FlashMode.class));
                }
                anyType14 = new AnyType(typeDescriptor14, null);
            }
            viewDefinitionBuilder.getProps().put("flashMode", new ConcreteViewProp("flashMode", anyType14, function6));
            Function2<ExpoCameraView, Boolean, Unit> function7 = new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke2(expoCameraView, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (bool != null) {
                        boolean zBooleanValue = bool.booleanValue();
                        if (view.getEnableTorch() != zBooleanValue) {
                            view.setEnableTorch(zBooleanValue);
                            return;
                        }
                        return;
                    }
                    if (view.getEnableTorch()) {
                        view.setEnableTorch(false);
                    }
                }
            };
            AnyType anyType15 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType15 == null) {
                try {
                    Result.Companion companion29 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN_NULLABLE), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
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
                    typeDescriptor15 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType15 = new AnyType(typeDescriptor15, null);
            }
            viewDefinitionBuilder.getProps().put("enableTorch", new ConcreteViewProp("enableTorch", anyType15, function7));
            CameraViewModule$definition$1$15$4 cameraViewModule$definition$1$15$4 = new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke2(expoCameraView, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setAnimateShutter(bool != null ? bool.booleanValue() : true);
                }
            };
            AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType16 == null) {
                try {
                    Result.Companion companion31 = Result.INSTANCE;
                    objM12684constructorimpl16 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN_NULLABLE), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
                        }
                    }));
                } catch (Throwable th16) {
                    Result.Companion companion32 = Result.INSTANCE;
                    objM12684constructorimpl16 = Result.m12684constructorimpl(ResultKt.createFailure(th16));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl16)) {
                    objM12684constructorimpl16 = null;
                }
                TypeDescriptor typeDescriptor16 = (TypeDescriptor) objM12684constructorimpl16;
                if (typeDescriptor16 == null) {
                    typeDescriptor16 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType16 = new AnyType(typeDescriptor16, null);
            }
            viewDefinitionBuilder.getProps().put("animateShutter", new ConcreteViewProp("animateShutter", anyType16, cameraViewModule$definition$1$15$4));
            Function2<ExpoCameraView, Float, Unit> function8 = new Function2<ExpoCameraView, Float, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Float f) {
                    invoke2(expoCameraView, f);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Float f) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (f == null) {
                        if (view.getZoom() == 0.0f) {
                            return;
                        }
                        view.setZoom(0.0f);
                    } else {
                        float fFloatValue = f.floatValue();
                        if (view.getZoom() == fFloatValue) {
                            return;
                        }
                        view.setZoom(fFloatValue);
                    }
                }
            };
            AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), true));
            if (anyType17 == null) {
                try {
                    Result.Companion companion33 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.FLOAT_NULLABLE), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Float.class);
                        }
                    }));
                } catch (Throwable th17) {
                    Result.Companion companion34 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(ResultKt.createFailure(th17));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl17)) {
                    objM12684constructorimpl17 = null;
                }
                TypeDescriptor typeDescriptor17 = (TypeDescriptor) objM12684constructorimpl17;
                if (typeDescriptor17 == null) {
                    typeDescriptor17 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Float.class));
                }
                anyType17 = new AnyType(typeDescriptor17, null);
            }
            viewDefinitionBuilder.getProps().put("zoom", new ConcreteViewProp("zoom", anyType17, function8));
            Function2<ExpoCameraView, CameraMode, Unit> function9 = new Function2<ExpoCameraView, CameraMode, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, CameraMode cameraMode) {
                    invoke2(expoCameraView, cameraMode);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, CameraMode cameraMode) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (cameraMode != null) {
                        if (view.getCameraMode() != cameraMode) {
                            view.setCameraMode(cameraMode);
                        }
                    } else if (view.getCameraMode() != CameraMode.PICTURE) {
                        view.setCameraMode(CameraMode.PICTURE);
                    }
                }
            };
            AnyType anyType18 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(CameraMode.class), true));
            if (anyType18 == null) {
                try {
                    Result.Companion companion35 = Result.INSTANCE;
                    objM12684constructorimpl18 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(CameraMode.class, true, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(CameraMode.class);
                        }
                    }));
                } catch (Throwable th18) {
                    Result.Companion companion36 = Result.INSTANCE;
                    objM12684constructorimpl18 = Result.m12684constructorimpl(ResultKt.createFailure(th18));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl18)) {
                    objM12684constructorimpl18 = null;
                }
                TypeDescriptor typeDescriptor18 = (TypeDescriptor) objM12684constructorimpl18;
                if (typeDescriptor18 == null) {
                    typeDescriptor18 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(CameraMode.class));
                }
                anyType18 = new AnyType(typeDescriptor18, null);
            }
            viewDefinitionBuilder.getProps().put("mode", new ConcreteViewProp("mode", anyType18, function9));
            CameraViewModule$definition$1$15$7 cameraViewModule$definition$1$15$7 = new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke2(expoCameraView, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setMute(bool != null ? bool.booleanValue() : false);
                }
            };
            AnyType anyType19 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType19 == null) {
                try {
                    Result.Companion companion37 = Result.INSTANCE;
                    objM12684constructorimpl19 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN_NULLABLE), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
                        }
                    }));
                } catch (Throwable th19) {
                    Result.Companion companion38 = Result.INSTANCE;
                    objM12684constructorimpl19 = Result.m12684constructorimpl(ResultKt.createFailure(th19));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl19)) {
                    objM12684constructorimpl19 = null;
                }
                TypeDescriptor typeDescriptor19 = (TypeDescriptor) objM12684constructorimpl19;
                if (typeDescriptor19 == null) {
                    typeDescriptor19 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType19 = new AnyType(typeDescriptor19, null);
            }
            viewDefinitionBuilder.getProps().put("mute", new ConcreteViewProp("mute", anyType19, cameraViewModule$definition$1$15$7));
            Function2<ExpoCameraView, VideoQuality, Unit> function10 = new Function2<ExpoCameraView, VideoQuality, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, VideoQuality videoQuality) {
                    invoke2(expoCameraView, videoQuality);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, VideoQuality videoQuality) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (videoQuality != null) {
                        if (view.getVideoQuality() != videoQuality) {
                            view.setVideoQuality(videoQuality);
                        }
                    } else if (view.getVideoQuality() != VideoQuality.VIDEO1080P) {
                        view.setVideoQuality(VideoQuality.VIDEO1080P);
                    }
                }
            };
            AnyType anyType20 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(VideoQuality.class), true));
            if (anyType20 == null) {
                try {
                    Result.Companion companion39 = Result.INSTANCE;
                    objM12684constructorimpl20 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(VideoQuality.class, true, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(VideoQuality.class);
                        }
                    }));
                } catch (Throwable th20) {
                    Result.Companion companion40 = Result.INSTANCE;
                    objM12684constructorimpl20 = Result.m12684constructorimpl(ResultKt.createFailure(th20));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl20)) {
                    objM12684constructorimpl20 = null;
                }
                TypeDescriptor typeDescriptor20 = (TypeDescriptor) objM12684constructorimpl20;
                if (typeDescriptor20 == null) {
                    typeDescriptor20 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(VideoQuality.class));
                }
                anyType20 = new AnyType(typeDescriptor20, null);
            }
            viewDefinitionBuilder.getProps().put("videoQuality", new ConcreteViewProp("videoQuality", anyType20, function10));
            Function2<ExpoCameraView, VideoStabilizationMode, Unit> function11 = new Function2<ExpoCameraView, VideoStabilizationMode, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$9
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, VideoStabilizationMode videoStabilizationMode) {
                    invoke2(expoCameraView, videoStabilizationMode);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, VideoStabilizationMode videoStabilizationMode) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (videoStabilizationMode != null) {
                        if (view.getVideoStabilizationMode() != videoStabilizationMode) {
                            view.setVideoStabilizationMode(videoStabilizationMode);
                        }
                    } else if (view.getVideoStabilizationMode() != VideoStabilizationMode.AUTO) {
                        view.setVideoStabilizationMode(VideoStabilizationMode.AUTO);
                    }
                }
            };
            AnyType anyType21 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(VideoStabilizationMode.class), true));
            if (anyType21 == null) {
                try {
                    Result.Companion companion41 = Result.INSTANCE;
                    objM12684constructorimpl21 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(VideoStabilizationMode.class, true, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(VideoStabilizationMode.class);
                        }
                    }));
                } catch (Throwable th21) {
                    Result.Companion companion42 = Result.INSTANCE;
                    objM12684constructorimpl21 = Result.m12684constructorimpl(ResultKt.createFailure(th21));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl21)) {
                    objM12684constructorimpl21 = null;
                }
                TypeDescriptor typeDescriptor21 = (TypeDescriptor) objM12684constructorimpl21;
                if (typeDescriptor21 == null) {
                    typeDescriptor21 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(VideoStabilizationMode.class));
                }
                anyType21 = new AnyType(typeDescriptor21, null);
            }
            viewDefinitionBuilder.getProps().put("videoStabilizationMode", new ConcreteViewProp("videoStabilizationMode", anyType21, function11));
            Function2<ExpoCameraView, BarcodeSettings, Unit> function12 = new Function2<ExpoCameraView, BarcodeSettings, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$10
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, BarcodeSettings barcodeSettings) {
                    invoke2(expoCameraView, barcodeSettings);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, BarcodeSettings barcodeSettings) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (CameraUtils.INSTANCE.isMLKitBarcodeScannerAvailable()) {
                        if (barcodeSettings != null) {
                            view.setBarcodeScannerSettings(barcodeSettings);
                        }
                    } else {
                        Logger jsLogger = this.this$0.getAppContext().getJsLogger();
                        if (jsLogger != null) {
                            Logger.warn$default(jsLogger, "Barcode scanning has been disabled", null, 2, null);
                        }
                    }
                }
            };
            AnyType anyType22 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(BarcodeSettings.class), true));
            if (anyType22 == null) {
                try {
                    Result.Companion companion43 = Result.INSTANCE;
                    objM12684constructorimpl22 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(BarcodeSettings.class, true, BarcodeSettings.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$10
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(BarcodeSettings.class);
                        }
                    }));
                } catch (Throwable th22) {
                    Result.Companion companion44 = Result.INSTANCE;
                    objM12684constructorimpl22 = Result.m12684constructorimpl(ResultKt.createFailure(th22));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl22)) {
                    objM12684constructorimpl22 = null;
                }
                TypeDescriptor typeDescriptor22 = (TypeDescriptor) objM12684constructorimpl22;
                if (typeDescriptor22 == null) {
                    typeDescriptor22 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(BarcodeSettings.class));
                }
                anyType22 = new AnyType(typeDescriptor22, null);
            }
            viewDefinitionBuilder.getProps().put("barcodeScannerSettings", new ConcreteViewProp("barcodeScannerSettings", anyType22, function12));
            CameraViewModule$definition$1$15$11 cameraViewModule$definition$1$15$11 = new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$11
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke2(expoCameraView, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (!CameraUtils.INSTANCE.isMLKitBarcodeScannerAvailable()) {
                        view.setShouldScanBarcodes(false);
                    } else if (bool != null) {
                        bool.booleanValue();
                        view.setShouldScanBarcodes(bool.booleanValue());
                    }
                }
            };
            AnyType anyType23 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType23 == null) {
                try {
                    Result.Companion companion45 = Result.INSTANCE;
                    objM12684constructorimpl23 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN_NULLABLE), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
                        }
                    }));
                } catch (Throwable th23) {
                    Result.Companion companion46 = Result.INSTANCE;
                    objM12684constructorimpl23 = Result.m12684constructorimpl(ResultKt.createFailure(th23));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl23)) {
                    objM12684constructorimpl23 = null;
                }
                TypeDescriptor typeDescriptor23 = (TypeDescriptor) objM12684constructorimpl23;
                if (typeDescriptor23 == null) {
                    typeDescriptor23 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType23 = new AnyType(typeDescriptor23, null);
            }
            viewDefinitionBuilder.getProps().put("barcodeScannerEnabled", new ConcreteViewProp("barcodeScannerEnabled", anyType23, cameraViewModule$definition$1$15$11));
            Function2<ExpoCameraView, String, Unit> function13 = new Function2<ExpoCameraView, String, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$12
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, String str) {
                    invoke2(expoCameraView, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, String str) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (str != null) {
                        if (Intrinsics.areEqual(view.getPictureSize(), str)) {
                            return;
                        }
                        view.setPictureSize(str);
                    } else if (view.getPictureSize().length() > 0) {
                        view.setPictureSize("");
                    }
                }
            };
            AnyType anyType24 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType24 == null) {
                try {
                    Result.Companion companion47 = Result.INSTANCE;
                    objM12684constructorimpl24 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$12
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                } catch (Throwable th24) {
                    Result.Companion companion48 = Result.INSTANCE;
                    objM12684constructorimpl24 = Result.m12684constructorimpl(ResultKt.createFailure(th24));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl24)) {
                    objM12684constructorimpl24 = null;
                }
                TypeDescriptor typeDescriptor24 = (TypeDescriptor) objM12684constructorimpl24;
                if (typeDescriptor24 == null) {
                    typeDescriptor24 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType24 = new AnyType(typeDescriptor24, null);
            }
            viewDefinitionBuilder.getProps().put("pictureSize", new ConcreteViewProp("pictureSize", anyType24, function13));
            Function2<ExpoCameraView, FocusMode, Unit> function14 = new Function2<ExpoCameraView, FocusMode, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$13
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, FocusMode focusMode) {
                    invoke2(expoCameraView, focusMode);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, FocusMode focusMode) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (focusMode != null) {
                        if (view.getAutoFocus() != focusMode) {
                            view.setAutoFocus(focusMode);
                        }
                    } else if (view.getAutoFocus() != FocusMode.OFF) {
                        view.setAutoFocus(FocusMode.OFF);
                    }
                }
            };
            AnyType anyType25 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FocusMode.class), true));
            if (anyType25 == null) {
                try {
                    Result.Companion companion49 = Result.INSTANCE;
                    objM12684constructorimpl25 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FocusMode.class, true, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$13
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(FocusMode.class);
                        }
                    }));
                } catch (Throwable th25) {
                    Result.Companion companion50 = Result.INSTANCE;
                    objM12684constructorimpl25 = Result.m12684constructorimpl(ResultKt.createFailure(th25));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl25)) {
                    objM12684constructorimpl25 = null;
                }
                TypeDescriptor typeDescriptor25 = (TypeDescriptor) objM12684constructorimpl25;
                if (typeDescriptor25 == null) {
                    typeDescriptor25 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(FocusMode.class));
                }
                anyType25 = new AnyType(typeDescriptor25, null);
            }
            viewDefinitionBuilder.getProps().put("autoFocus", new ConcreteViewProp("autoFocus", anyType25, function14));
            Function2<ExpoCameraView, CameraRatio, Unit> function15 = new Function2<ExpoCameraView, CameraRatio, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$14
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, CameraRatio cameraRatio) {
                    invoke2(expoCameraView, cameraRatio);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, CameraRatio cameraRatio) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (cameraRatio != null) {
                        if (view.getRatio() != cameraRatio) {
                            view.setRatio(cameraRatio);
                        }
                    } else if (view.getRatio() != null) {
                        view.setRatio(null);
                    }
                }
            };
            AnyType anyType26 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(CameraRatio.class), true));
            if (anyType26 == null) {
                try {
                    Result.Companion companion51 = Result.INSTANCE;
                    objM12684constructorimpl26 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(CameraRatio.class, true, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$14
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(CameraRatio.class);
                        }
                    }));
                } catch (Throwable th26) {
                    Result.Companion companion52 = Result.INSTANCE;
                    objM12684constructorimpl26 = Result.m12684constructorimpl(ResultKt.createFailure(th26));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl26)) {
                    objM12684constructorimpl26 = null;
                }
                TypeDescriptor typeDescriptor26 = (TypeDescriptor) objM12684constructorimpl26;
                if (typeDescriptor26 == null) {
                    typeDescriptor26 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(CameraRatio.class));
                }
                anyType26 = new AnyType(typeDescriptor26, null);
            }
            viewDefinitionBuilder.getProps().put("ratio", new ConcreteViewProp("ratio", anyType26, function15));
            Function2<ExpoCameraView, Boolean, Unit> function16 = new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$15
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke2(expoCameraView, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (bool != null) {
                        boolean zBooleanValue = bool.booleanValue();
                        if (view.getMirror() != zBooleanValue) {
                            view.setMirror(zBooleanValue);
                            return;
                        }
                        return;
                    }
                    if (view.getMirror()) {
                        view.setMirror(false);
                    }
                }
            };
            AnyType anyType27 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType27 == null) {
                try {
                    Result.Companion companion53 = Result.INSTANCE;
                    objM12684constructorimpl27 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN_NULLABLE), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$15
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Boolean.class);
                        }
                    }));
                } catch (Throwable th27) {
                    Result.Companion companion54 = Result.INSTANCE;
                    objM12684constructorimpl27 = Result.m12684constructorimpl(ResultKt.createFailure(th27));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl27)) {
                    objM12684constructorimpl27 = null;
                }
                TypeDescriptor typeDescriptor27 = (TypeDescriptor) objM12684constructorimpl27;
                if (typeDescriptor27 == null) {
                    typeDescriptor27 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Boolean.class));
                }
                anyType27 = new AnyType(typeDescriptor27, null);
            }
            viewDefinitionBuilder.getProps().put("mirror", new ConcreteViewProp("mirror", anyType27, function16));
            Function2<ExpoCameraView, Integer, Unit> function17 = new Function2<ExpoCameraView, Integer, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$15$16
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Integer num) {
                    invoke2(expoCameraView, num);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Integer num) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (num != null) {
                        int iIntValue = num.intValue();
                        Integer videoEncodingBitrate = view.getVideoEncodingBitrate();
                        if (videoEncodingBitrate != null && videoEncodingBitrate.intValue() == iIntValue) {
                            return;
                        }
                        view.setVideoEncodingBitrate(Integer.valueOf(iIntValue));
                        return;
                    }
                    if (view.getVideoEncodingBitrate() != null) {
                        view.setVideoEncodingBitrate(null);
                    }
                }
            };
            AnyType anyType28 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
            if (anyType28 == null) {
                try {
                    Result.Companion companion55 = Result.INSTANCE;
                    objM12684constructorimpl28 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT_NULLABLE), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$Prop$16
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Integer.class);
                        }
                    }));
                } catch (Throwable th28) {
                    Result.Companion companion56 = Result.INSTANCE;
                    objM12684constructorimpl28 = Result.m12684constructorimpl(ResultKt.createFailure(th28));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl28)) {
                    objM12684constructorimpl28 = null;
                }
                TypeDescriptor typeDescriptor28 = (TypeDescriptor) objM12684constructorimpl28;
                if (typeDescriptor28 == null) {
                    typeDescriptor28 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Integer.class));
                }
                anyType28 = new AnyType(typeDescriptor28, null);
            }
            viewDefinitionBuilder.getProps().put("videoBitrate", new ConcreteViewProp("videoBitrate", anyType28, function17));
            viewDefinitionBuilder.setOnViewDidUpdateProps(new Function1<View, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$OnViewDidUpdateProps$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((ExpoCameraView) it).recreateCamera();
                }
            });
            viewDefinitionBuilder.setOnViewDestroys(new Function1<View, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$OnViewDestroys$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((ExpoCameraView) it).cleanupCamera();
                }
            });
            TypeConverterProvider converters9 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr14 = new AnyType[2];
            AnyType anyType29 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
            if (anyType29 == null) {
                try {
                    Result.Companion companion57 = Result.INSTANCE;
                    objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ExpoCameraView.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunctionWithPromise$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ExpoCameraView.class);
                        }
                    }));
                } catch (Throwable th29) {
                    Result.Companion companion58 = Result.INSTANCE;
                    objM12684constructorimpl29 = Result.m12684constructorimpl(ResultKt.createFailure(th29));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl29)) {
                    objM12684constructorimpl29 = null;
                }
                TypeDescriptor typeDescriptor29 = (TypeDescriptor) objM12684constructorimpl29;
                if (typeDescriptor29 == null) {
                    typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ExpoCameraView.class));
                }
                anyType29 = new AnyType(typeDescriptor29, converters9);
            }
            anyTypeArr14[0] = anyType29;
            AnyType anyType30 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PictureOptions.class), false));
            if (anyType30 == null) {
                try {
                    Result.Companion companion59 = Result.INSTANCE;
                    objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(PictureOptions.class, false, PictureOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunctionWithPromise$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(PictureOptions.class);
                        }
                    }));
                } catch (Throwable th30) {
                    Result.Companion companion60 = Result.INSTANCE;
                    objM12684constructorimpl30 = Result.m12684constructorimpl(ResultKt.createFailure(th30));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl30)) {
                    objM12684constructorimpl30 = null;
                }
                TypeDescriptor typeDescriptor30 = (TypeDescriptor) objM12684constructorimpl30;
                if (typeDescriptor30 == null) {
                    typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(PictureOptions.class));
                }
                anyType30 = new AnyType(typeDescriptor30, converters9);
            }
            anyTypeArr14[1] = anyType30;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent14 = new AsyncFunctionWithPromiseComponent("takePicture", anyTypeArr14, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunctionWithPromise$3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    PictureOptions pictureOptions = (PictureOptions) objArr[1];
                    ExpoCameraView expoCameraView = (ExpoCameraView) obj;
                    if (!EmulatorUtilities.INSTANCE.isRunningOnEmulator()) {
                        expoCameraView.takePicture(pictureOptions, promise, this.this$0.getCacheDirectory(), this.this$0.getRuntime());
                    } else {
                        BuildersKt__Builders_commonKt.launch$default(this.this$0.moduleScope, null, null, new CameraViewModule$definition$1$15$19$1(CameraViewHelper.INSTANCE.generateSimulatorPhoto(expoCameraView.getWidth(), expoCameraView.getHeight()), promise, pictureOptions, this.this$0, expoCameraView, null), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("takePicture", asyncFunctionWithPromiseComponent14);
            asyncFunctionWithPromiseComponent14.runOnQueue(Queues.MAIN);
            if (ExpoCameraView.class == Promise.class) {
                asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("getAvailablePictureSizes", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((ExpoCameraView) promise).getAvailablePictureSizes();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr15 = new AnyType[1];
                AnyType anyType31 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
                if (anyType31 == null) {
                    try {
                        Result.Companion companion61 = Result.INSTANCE;
                        objM12684constructorimpl31 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ExpoCameraView.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(ExpoCameraView.class);
                            }
                        }));
                    } catch (Throwable th31) {
                        Result.Companion companion62 = Result.INSTANCE;
                        objM12684constructorimpl31 = Result.m12684constructorimpl(ResultKt.createFailure(th31));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl31)) {
                        objM12684constructorimpl31 = null;
                    }
                    TypeDescriptor typeDescriptor31 = (TypeDescriptor) objM12684constructorimpl31;
                    if (typeDescriptor31 == null) {
                        typeDescriptor31 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ExpoCameraView.class));
                    }
                    anyType31 = new AnyType(typeDescriptor31, null);
                }
                anyTypeArr15[0] = anyType31;
                Function1<Object[], List<? extends String>> function18 = new Function1<Object[], List<? extends String>>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final List<? extends String> invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        return ((ExpoCameraView) objArr[0]).getAvailablePictureSizes();
                    }
                };
                if (!Intrinsics.areEqual(List.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(List.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(List.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(List.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(List.class, String.class)) {
                                    untypedAsyncFunctionComponent5 = new StringAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr15, function18);
                                } else {
                                    untypedAsyncFunctionComponent5 = new UntypedAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr15, function18);
                                }
                            } else {
                                untypedAsyncFunctionComponent5 = new FloatAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr15, function18);
                            }
                        } else {
                            untypedAsyncFunctionComponent5 = new DoubleAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr15, function18);
                        }
                    } else {
                        untypedAsyncFunctionComponent5 = new BoolAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr15, function18);
                    }
                } else {
                    untypedAsyncFunctionComponent5 = new IntAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr15, function18);
                }
                asyncFunctionWithPromiseComponent5 = untypedAsyncFunctionComponent5;
            }
            viewDefinitionBuilder.getAsyncFunctions().put("getAvailablePictureSizes", asyncFunctionWithPromiseComponent5);
            TypeConverterProvider converters10 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr16 = new AnyType[2];
            AnyType anyType32 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
            if (anyType32 == null) {
                try {
                    Result.Companion companion63 = Result.INSTANCE;
                    objM12684constructorimpl32 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ExpoCameraView.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunctionWithPromise$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ExpoCameraView.class);
                        }
                    }));
                } catch (Throwable th32) {
                    Result.Companion companion64 = Result.INSTANCE;
                    objM12684constructorimpl32 = Result.m12684constructorimpl(ResultKt.createFailure(th32));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl32)) {
                    objM12684constructorimpl32 = null;
                }
                TypeDescriptor typeDescriptor32 = (TypeDescriptor) objM12684constructorimpl32;
                if (typeDescriptor32 == null) {
                    typeDescriptor32 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ExpoCameraView.class));
                }
                anyType32 = new AnyType(typeDescriptor32, converters10);
            }
            anyTypeArr16[0] = anyType32;
            AnyType anyType33 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RecordingOptions.class), false));
            if (anyType33 == null) {
                try {
                    Result.Companion companion65 = Result.INSTANCE;
                    objM12684constructorimpl33 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RecordingOptions.class, false, RecordingOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunctionWithPromise$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(RecordingOptions.class);
                        }
                    }));
                } catch (Throwable th33) {
                    Result.Companion companion66 = Result.INSTANCE;
                    objM12684constructorimpl33 = Result.m12684constructorimpl(ResultKt.createFailure(th33));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl33)) {
                    objM12684constructorimpl33 = null;
                }
                TypeDescriptor typeDescriptor33 = (TypeDescriptor) objM12684constructorimpl33;
                if (typeDescriptor33 == null) {
                    typeDescriptor33 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(RecordingOptions.class));
                }
                anyType33 = new AnyType(typeDescriptor33, converters10);
            }
            anyTypeArr16[1] = anyType33;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent15 = new AsyncFunctionWithPromiseComponent("record", anyTypeArr16, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunctionWithPromise$6
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws Exceptions.MissingPermissions {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    RecordingOptions recordingOptions = (RecordingOptions) objArr[1];
                    ExpoCameraView expoCameraView = (ExpoCameraView) obj;
                    if (expoCameraView.getMute() || this.this$0.getPermissionsManager().hasGrantedPermissions("android.permission.RECORD_AUDIO")) {
                        expoCameraView.record(recordingOptions, promise, this.this$0.getCacheDirectory());
                        return;
                    }
                    throw new Exceptions.MissingPermissions("android.permission.RECORD_AUDIO");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exceptions.MissingPermissions {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("record", asyncFunctionWithPromiseComponent15);
            asyncFunctionWithPromiseComponent15.runOnQueue(Queues.MAIN);
            if (ExpoCameraView.class == Promise.class) {
                asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("toggleRecording", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$4
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((ExpoCameraView) promise).toggleRecording();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr17 = new AnyType[1];
                AnyType anyType34 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
                if (anyType34 == null) {
                    try {
                        Result.Companion companion67 = Result.INSTANCE;
                        objM12684constructorimpl34 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ExpoCameraView.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$5
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(ExpoCameraView.class);
                            }
                        }));
                    } catch (Throwable th34) {
                        Result.Companion companion68 = Result.INSTANCE;
                        objM12684constructorimpl34 = Result.m12684constructorimpl(ResultKt.createFailure(th34));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl34)) {
                        objM12684constructorimpl34 = null;
                    }
                    TypeDescriptor typeDescriptor34 = (TypeDescriptor) objM12684constructorimpl34;
                    if (typeDescriptor34 == null) {
                        typeDescriptor34 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ExpoCameraView.class));
                    }
                    anyType34 = new AnyType(typeDescriptor34, null);
                }
                anyTypeArr17[0] = anyType34;
                Function1<Object[], Unit> function19 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        ((ExpoCameraView) objArr[0]).toggleRecording();
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent6 = new StringAsyncFunctionComponent("toggleRecording", anyTypeArr17, function19);
                                } else {
                                    untypedAsyncFunctionComponent6 = new UntypedAsyncFunctionComponent("toggleRecording", anyTypeArr17, function19);
                                }
                            } else {
                                untypedAsyncFunctionComponent6 = new FloatAsyncFunctionComponent("toggleRecording", anyTypeArr17, function19);
                            }
                        } else {
                            untypedAsyncFunctionComponent6 = new DoubleAsyncFunctionComponent("toggleRecording", anyTypeArr17, function19);
                        }
                    } else {
                        untypedAsyncFunctionComponent6 = new BoolAsyncFunctionComponent("toggleRecording", anyTypeArr17, function19);
                    }
                } else {
                    untypedAsyncFunctionComponent6 = new IntAsyncFunctionComponent("toggleRecording", anyTypeArr17, function19);
                }
                asyncFunctionWithPromiseComponent6 = untypedAsyncFunctionComponent6;
            }
            viewDefinitionBuilder.getAsyncFunctions().put("toggleRecording", asyncFunctionWithPromiseComponent6);
            if (ExpoCameraView.class == Promise.class) {
                asyncFunctionWithPromiseComponent7 = new AsyncFunctionWithPromiseComponent("stopRecording", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$7
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((ExpoCameraView) promise).stopRecording();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr18 = new AnyType[1];
                AnyType anyType35 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
                if (anyType35 == null) {
                    try {
                        Result.Companion companion69 = Result.INSTANCE;
                        objM12684constructorimpl35 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ExpoCameraView.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$8
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(ExpoCameraView.class);
                            }
                        }));
                    } catch (Throwable th35) {
                        Result.Companion companion70 = Result.INSTANCE;
                        objM12684constructorimpl35 = Result.m12684constructorimpl(ResultKt.createFailure(th35));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl35)) {
                        objM12684constructorimpl35 = null;
                    }
                    TypeDescriptor typeDescriptor35 = (TypeDescriptor) objM12684constructorimpl35;
                    if (typeDescriptor35 == null) {
                        typeDescriptor35 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ExpoCameraView.class));
                    }
                    anyType35 = new AnyType(typeDescriptor35, null);
                }
                anyTypeArr18[0] = anyType35;
                Function1<Object[], Unit> function20 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        ((ExpoCameraView) objArr[0]).stopRecording();
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent7 = new StringAsyncFunctionComponent("stopRecording", anyTypeArr18, function20);
                                } else {
                                    untypedAsyncFunctionComponent7 = new UntypedAsyncFunctionComponent("stopRecording", anyTypeArr18, function20);
                                }
                            } else {
                                untypedAsyncFunctionComponent7 = new FloatAsyncFunctionComponent("stopRecording", anyTypeArr18, function20);
                            }
                        } else {
                            untypedAsyncFunctionComponent7 = new DoubleAsyncFunctionComponent("stopRecording", anyTypeArr18, function20);
                        }
                    } else {
                        untypedAsyncFunctionComponent7 = new BoolAsyncFunctionComponent("stopRecording", anyTypeArr18, function20);
                    }
                } else {
                    untypedAsyncFunctionComponent7 = new IntAsyncFunctionComponent("stopRecording", anyTypeArr18, function20);
                }
                asyncFunctionWithPromiseComponent7 = untypedAsyncFunctionComponent7;
            }
            viewDefinitionBuilder.getAsyncFunctions().put("stopRecording", asyncFunctionWithPromiseComponent7);
            asyncFunctionWithPromiseComponent7.runOnQueue(Queues.MAIN);
            if (ExpoCameraView.class == Promise.class) {
                asyncFunctionWithPromiseComponent8 = new AsyncFunctionWithPromiseComponent("resumePreview", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$10
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((ExpoCameraView) promise).resumePreview();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr19 = new AnyType[1];
                AnyType anyType36 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
                if (anyType36 == null) {
                    try {
                        Result.Companion companion71 = Result.INSTANCE;
                        objM12684constructorimpl36 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ExpoCameraView.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$11
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(ExpoCameraView.class);
                            }
                        }));
                    } catch (Throwable th36) {
                        Result.Companion companion72 = Result.INSTANCE;
                        objM12684constructorimpl36 = Result.m12684constructorimpl(ResultKt.createFailure(th36));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl36)) {
                        objM12684constructorimpl36 = null;
                    }
                    TypeDescriptor typeDescriptor36 = (TypeDescriptor) objM12684constructorimpl36;
                    if (typeDescriptor36 == null) {
                        typeDescriptor36 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ExpoCameraView.class));
                    }
                    anyType36 = new AnyType(typeDescriptor36, null);
                }
                anyTypeArr19[0] = anyType36;
                Function1<Object[], Unit> function21 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$12
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        ((ExpoCameraView) objArr[0]).resumePreview();
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent8 = new StringAsyncFunctionComponent("resumePreview", anyTypeArr19, function21);
                                } else {
                                    untypedAsyncFunctionComponent8 = new UntypedAsyncFunctionComponent("resumePreview", anyTypeArr19, function21);
                                }
                            } else {
                                untypedAsyncFunctionComponent8 = new FloatAsyncFunctionComponent("resumePreview", anyTypeArr19, function21);
                            }
                        } else {
                            untypedAsyncFunctionComponent8 = new DoubleAsyncFunctionComponent("resumePreview", anyTypeArr19, function21);
                        }
                    } else {
                        untypedAsyncFunctionComponent8 = new BoolAsyncFunctionComponent("resumePreview", anyTypeArr19, function21);
                    }
                } else {
                    untypedAsyncFunctionComponent8 = new IntAsyncFunctionComponent("resumePreview", anyTypeArr19, function21);
                }
                asyncFunctionWithPromiseComponent8 = untypedAsyncFunctionComponent8;
            }
            viewDefinitionBuilder.getAsyncFunctions().put("resumePreview", asyncFunctionWithPromiseComponent8);
            if (ExpoCameraView.class == Promise.class) {
                asyncFunctionWithPromiseComponent9 = new AsyncFunctionWithPromiseComponent("pausePreview", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$13
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((ExpoCameraView) promise).pausePreview();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr20 = new AnyType[1];
                AnyType anyType37 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
                if (anyType37 == null) {
                    try {
                        Result.Companion companion73 = Result.INSTANCE;
                        objM12684constructorimpl37 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ExpoCameraView.class, false, null)), new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$14
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(ExpoCameraView.class);
                            }
                        }));
                    } catch (Throwable th37) {
                        Result.Companion companion74 = Result.INSTANCE;
                        objM12684constructorimpl37 = Result.m12684constructorimpl(ResultKt.createFailure(th37));
                    }
                    if (Result.m12690isFailureimpl(objM12684constructorimpl37)) {
                        objM12684constructorimpl37 = null;
                    }
                    TypeDescriptor typeDescriptor37 = (TypeDescriptor) objM12684constructorimpl37;
                    if (typeDescriptor37 == null) {
                        typeDescriptor37 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ExpoCameraView.class));
                    }
                    anyType37 = new AnyType(typeDescriptor37, null);
                }
                anyTypeArr20[0] = anyType37;
                Function1<Object[], Unit> function22 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$31$lambda$30$$inlined$AsyncFunction$15
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        ((ExpoCameraView) objArr[0]).pausePreview();
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent9 = new StringAsyncFunctionComponent("pausePreview", anyTypeArr20, function22);
                                } else {
                                    untypedAsyncFunctionComponent9 = new UntypedAsyncFunctionComponent("pausePreview", anyTypeArr20, function22);
                                }
                            } else {
                                untypedAsyncFunctionComponent9 = new FloatAsyncFunctionComponent("pausePreview", anyTypeArr20, function22);
                            }
                        } else {
                            untypedAsyncFunctionComponent9 = new DoubleAsyncFunctionComponent("pausePreview", anyTypeArr20, function22);
                        }
                    } else {
                        untypedAsyncFunctionComponent9 = new BoolAsyncFunctionComponent("pausePreview", anyTypeArr20, function22);
                    }
                } else {
                    untypedAsyncFunctionComponent9 = new IntAsyncFunctionComponent("pausePreview", anyTypeArr20, function22);
                }
                asyncFunctionWithPromiseComponent9 = untypedAsyncFunctionComponent9;
            }
            viewDefinitionBuilder.getAsyncFunctions().put("pausePreview", asyncFunctionWithPromiseComponent9);
            moduleDefinitionBuilder13.registerViewDefinition(viewDefinitionBuilder.build());
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th38) {
            Trace.endSection();
            throw th38;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDirectory() {
        return getAppContext().getCacheDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Permissions getPermissionsManager() throws Exceptions.PermissionsModuleNotFound {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return permissions;
        }
        throw new Exceptions.PermissionsModuleNotFound();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchDocumentScanner(Activity activity, DocumentScannerOptions options, final Promise promise) {
        this.documentScanPromise = promise;
        try {
            Task<IntentSender> startScanIntent = GmsDocumentScanning.getClient(buildDocumentScannerOptions(options)).getStartScanIntent(activity);
            final Function1 function1 = new Function1() { // from class: expo.modules.camera.CameraViewModule$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CameraViewModule.launchDocumentScanner$lambda$33(this.f$0, (IntentSender) obj);
                }
            };
            Intrinsics.checkNotNull(startScanIntent.addOnSuccessListener(new OnSuccessListener() { // from class: expo.modules.camera.CameraViewModule$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: expo.modules.camera.CameraViewModule$$ExternalSyntheticLambda3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    CameraViewModule.launchDocumentScanner$lambda$35(this.f$0, promise, exc);
                }
            }));
        } catch (Exception e) {
            this.documentScanPromise = null;
            promise.reject(new CameraExceptions.DocumentScanningFailedException(e.getMessage()));
        }
    }

    static final Unit launchDocumentScanner$lambda$33(final CameraViewModule cameraViewModule, IntentSender intentSender) {
        cameraViewModule.pendingDocumentScanIntentSender = intentSender;
        AppContextActivityResultLauncher<DocumentScannerContractInput, DocumentScannerActivityResult> appContextActivityResultLauncher = cameraViewModule.documentScannerLauncher;
        if (appContextActivityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentScannerLauncher");
            appContextActivityResultLauncher = null;
        }
        appContextActivityResultLauncher.launch(new DocumentScannerContractInput(), new ActivityResultCallback() { // from class: expo.modules.camera.CameraViewModule$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CameraViewModule.launchDocumentScanner$lambda$33$lambda$32(this.f$0, (DocumentScannerActivityResult) obj);
            }
        });
        return Unit.INSTANCE;
    }

    static final void launchDocumentScanner$lambda$33$lambda$32(CameraViewModule cameraViewModule, DocumentScannerActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        cameraViewModule.handleDocumentScanResult(result);
    }

    static final void launchDocumentScanner$lambda$35(CameraViewModule cameraViewModule, Promise promise, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        cameraViewModule.documentScanPromise = null;
        promise.reject(new CameraExceptions.DocumentScanningFailedException(e.getMessage()));
    }

    private final GmsDocumentScannerOptions buildDocumentScannerOptions(DocumentScannerOptions options) {
        GmsDocumentScannerOptions.Builder scannerMode = new GmsDocumentScannerOptions.Builder().setScannerMode(1);
        Intrinsics.checkNotNullExpressionValue(scannerMode, "setScannerMode(...)");
        if (options != null && options.getRequestPdf()) {
            scannerMode.setResultFormats(101, 102);
        } else {
            scannerMode.setResultFormats(101, new int[0]);
        }
        GmsDocumentScannerOptions gmsDocumentScannerOptionsBuild = scannerMode.build();
        Intrinsics.checkNotNullExpressionValue(gmsDocumentScannerOptionsBuild, "build(...)");
        return gmsDocumentScannerOptionsBuild;
    }

    private final void handleDocumentScanResult(DocumentScannerActivityResult activityResult) {
        this.pendingDocumentScanIntentSender = null;
        Promise promise = this.documentScanPromise;
        if (promise == null) {
            return;
        }
        this.documentScanPromise = null;
        if (activityResult.getCancelled() || activityResult.getResult() == null) {
            promise.resolve((Object) null);
            return;
        }
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            BuildersKt__Builders_commonKt.launch$default(this.moduleScope, null, null, new AnonymousClass1(promise, reactContext, activityResult, this, null), 3, null);
        } else {
            promise.reject(new Exceptions.ReactContextLost());
        }
    }

    /* JADX INFO: renamed from: expo.modules.camera.CameraViewModule$handleDocumentScanResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.camera.CameraViewModule$handleDocumentScanResult$1", f = "CameraViewModule.kt", i = {}, l = {590}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DocumentScannerActivityResult $activityResult;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ Context $reactContext;
        int label;
        final /* synthetic */ CameraViewModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Promise promise, Context context, DocumentScannerActivityResult documentScannerActivityResult, CameraViewModule cameraViewModule, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$promise = promise;
            this.$reactContext = context;
            this.$activityResult = documentScannerActivityResult;
            this.this$0 = cameraViewModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$promise, this.$reactContext, this.$activityResult, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new CameraViewModule$handleDocumentScanResult$1$bundle$1(this.$reactContext, this.$activityResult, this.this$0, null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$promise.resolve((Bundle) obj);
            } catch (Exception e) {
                this.$promise.reject(new CameraExceptions.DocumentScanningFailedException(e.getMessage()));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/camera/CameraViewModule$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$expo_camera_release", "()Ljava/lang/String;", "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$expo_camera_release() {
            return CameraViewModule.TAG;
        }
    }
}
