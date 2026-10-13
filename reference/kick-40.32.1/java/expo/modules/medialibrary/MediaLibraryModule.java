package expo.modules.medialibrary;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
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
import expo.modules.medialibrary.contracts.DeleteContractInput;
import expo.modules.medialibrary.contracts.WriteContractInput;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: MediaLibraryModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0016J)\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u000e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0003¢\u0006\u0002\u0010$J)\u0010%\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010&\u001a\u00020\u000e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0003¢\u0006\u0002\u0010$J\u001e\u0010'\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0003J$\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0012\u0010*\u001a\u00020(2\b\b\u0002\u0010+\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u000eH\u0002J\u0016\u0010-\u001a\u00020(2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\b\u0010/\u001a\u00020\u000eH\u0002J&\u00100\u001a\u00020(2\f\u00101\u001a\b\u0012\u0004\u0012\u00020!0 2\b\b\u0002\u00102\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u000206H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0018\u00010\tR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0018\u00010\tR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0012R\u0014\u0010\u001e\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012¨\u00068"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "imagesObserver", "Lexpo/modules/medialibrary/MediaLibraryModule$MediaStoreContentObserver;", "videosObserver", "deleteLauncher", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "Lexpo/modules/medialibrary/contracts/DeleteContractInput;", "", "writeLauncher", "Lexpo/modules/medialibrary/contracts/WriteContractInput;", "isExpoGo", "()Z", "isExpoGo$delegate", "Lkotlin/Lazy;", "allowedPermissionsList", "", "Lexpo/modules/medialibrary/GranularPermission;", "getAllowedPermissionsList", "()Ljava/util/List;", "allowedPermissionsList$delegate", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "isMissingPermissions", "isMissingWritePermission", "getManifestPermissions", "", "", "writeOnly", "granularPermissions", "(ZLjava/util/List;)[Ljava/lang/String;", "getGranularPermissions", "shouldIncludeGranular", "assertGranularPermissionIntegrity", "", "getManifestDeclaredPermissions", "requireSystemPermissions", "isWritePermissionRequired", "hasReadPermissions", "maybeThrowIfExpoGo", "permissions", "hasWritePermissions", "requestMediaLibraryActionPermission", "assetIds", "needsDeletePermission", "([Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasWritePermissionForUri", "uri", "Landroid/net/Uri;", "MediaStoreContentObserver", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MediaLibraryModule extends Module {
    private AppContextActivityResultLauncher<DeleteContractInput, Boolean> deleteLauncher;
    private MediaStoreContentObserver imagesObserver;
    private MediaStoreContentObserver videosObserver;
    private AppContextActivityResultLauncher<WriteContractInput, Boolean> writeLauncher;

    /* JADX INFO: renamed from: isExpoGo$delegate, reason: from kotlin metadata */
    private final Lazy isExpoGo = LazyKt.lazy(new Function0() { // from class: expo.modules.medialibrary.MediaLibraryModule$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(Boolean.parseBoolean(this.f$0.getContext().getResources().getString(R.string.is_expo_go)));
        }
    });

    /* JADX INFO: renamed from: allowedPermissionsList$delegate, reason: from kotlin metadata */
    private final Lazy allowedPermissionsList = LazyKt.lazy(new Function0() { // from class: expo.modules.medialibrary.MediaLibraryModule$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MediaLibraryModule.allowedPermissionsList_delegate$lambda$1(this.f$0);
        }
    });

    /* JADX INFO: renamed from: expo.modules.medialibrary.MediaLibraryModule$requestMediaLibraryActionPermission$1, reason: invalid class name */
    /* JADX INFO: compiled from: MediaLibraryModule.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryModule", f = "MediaLibraryModule.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {435, 437}, m = "requestMediaLibraryActionPermission", n = {"assetIds", "uris", "urisWithoutPermission", "needsDeletePermission", "assetIds", "uris", "urisWithoutPermission", "needsDeletePermission"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaLibraryModule.this.requestMediaLibraryActionPermission(null, false, this);
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

    private final boolean isExpoGo() {
        return ((Boolean) this.isExpoGo.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<GranularPermission> getAllowedPermissionsList() {
        return (List) this.allowedPermissionsList.getValue();
    }

    static final List allowedPermissionsList_delegate$lambda$1(MediaLibraryModule mediaLibraryModule) {
        return mediaLibraryModule.isExpoGo() ? CollectionsKt.listOf(GranularPermission.AUDIO) : mediaLibraryModule.getManifestDeclaredPermissions(mediaLibraryModule.getContext(), CollectionsKt.listOf((Object[]) new GranularPermission[]{GranularPermission.PHOTO, GranularPermission.VIDEO, GranularPermission.AUDIO}));
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
        Object objM12684constructorimpl8;
        Object objM12684constructorimpl9;
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
        MediaLibraryModule mediaLibraryModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (mediaLibraryModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(mediaLibraryModule);
            moduleDefinitionBuilder.Name("ExpoMediaLibrary");
            ConstantComponentBuilder constantComponentBuilder = new ConstantComponentBuilder("MediaType");
            constantComponentBuilder.setGetter(new Function0<Map<String, ? extends String>>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Constant$1
                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends String> invoke() {
                    return MediaType.INSTANCE.getConstants();
                }
            });
            moduleDefinitionBuilder.getConstants().put("MediaType", constantComponentBuilder);
            ConstantComponentBuilder constantComponentBuilder2 = new ConstantComponentBuilder("SortBy");
            constantComponentBuilder2.setGetter(new Function0<Map<String, ? extends String>>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Constant$2
                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends String> invoke() {
                    return SortBy.INSTANCE.getConstants();
                }
            });
            moduleDefinitionBuilder.getConstants().put("SortBy", constantComponentBuilder2);
            ConstantComponentBuilder constantComponentBuilder3 = new ConstantComponentBuilder("CHANGE_LISTENER_NAME");
            constantComponentBuilder3.setGetter(new Function0<String>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Constant$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "mediaLibraryDidChange";
                }
            });
            moduleDefinitionBuilder.getConstants().put("CHANGE_LISTENER_NAME", constantComponentBuilder3);
            moduleDefinitionBuilder.Events("mediaLibraryDidChange");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
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
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), true));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(List.class, true, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(GranularPermission.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GranularPermission.class)));
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
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GranularPermission.class))));
                }
                anyType2 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[1] = anyType2;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionsException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    List allowedPermissionsList = (List) objArr[1];
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    if (allowedPermissionsList == null) {
                        allowedPermissionsList = this.this$0.getAllowedPermissionsList();
                    }
                    this.this$0.maybeThrowIfExpoGo(allowedPermissionsList);
                    Permissions permissions = this.this$0.getAppContext().getPermissions();
                    MediaLibraryPermissionPromiseWrapper mediaLibraryPermissionPromiseWrapper = new MediaLibraryPermissionPromiseWrapper(allowedPermissionsList, promise, new WeakReference(this.this$0.getContext()));
                    String[] manifestPermissions = this.this$0.getManifestPermissions(zBooleanValue, allowedPermissionsList);
                    Permissions.askForPermissionsWithPermissionsManager(permissions, mediaLibraryPermissionPromiseWrapper, (String[]) Arrays.copyOf(manifestPermissions, manifestPermissions.length));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionsException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("requestPermissionsAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
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
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType3 = new AnyType(typeDescriptor3, converters2);
            }
            anyTypeArr2[0] = anyType3;
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), true));
            if (anyType4 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(List.class, true, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(GranularPermission.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GranularPermission.class)));
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
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GranularPermission.class))));
                }
                anyType4 = new AnyType(typeDescriptor4, converters2);
            }
            anyTypeArr2[1] = anyType4;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("getPermissionsAsync", anyTypeArr2, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$AsyncFunctionWithPromise$6
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws PermissionsException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    List allowedPermissionsList = (List) objArr[1];
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    if (allowedPermissionsList == null) {
                        allowedPermissionsList = this.this$0.getAllowedPermissionsList();
                    }
                    this.this$0.maybeThrowIfExpoGo(allowedPermissionsList);
                    Permissions permissions = this.this$0.getAppContext().getPermissions();
                    MediaLibraryPermissionPromiseWrapper mediaLibraryPermissionPromiseWrapper = new MediaLibraryPermissionPromiseWrapper(allowedPermissionsList, promise, new WeakReference(this.this$0.getContext()));
                    String[] manifestPermissions = this.this$0.getManifestPermissions(zBooleanValue, allowedPermissionsList);
                    Permissions.getPermissionsWithPermissionsManager(permissions, mediaLibraryPermissionPromiseWrapper, (String[]) Arrays.copyOf(manifestPermissions, manifestPermissions.length));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws PermissionsException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder3.getAsyncFunctions().put("getPermissionsAsync", asyncFunctionWithPromiseComponent2);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("saveToLibraryAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters3 = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[1];
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$1
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
                anyType5 = new AnyType(typeDescriptor5, converters3);
            }
            anyTypeArr3[0] = anyType5;
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr3, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$2(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("createAssetAsync");
            String name2 = asyncFunctionBuilderAsyncFunction2.getName();
            TypeConverterProvider converters4 = asyncFunctionBuilderAsyncFunction2.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[2];
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType6 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$3
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
                anyType6 = new AnyType(typeDescriptor6, converters4);
            }
            anyTypeArr4[0] = anyType6;
            AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType7 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
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
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType7 = new AnyType(typeDescriptor7, converters4);
            }
            anyTypeArr4[1] = anyType7;
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, anyTypeArr4, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$5(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction3 = moduleDefinitionBuilder.AsyncFunction("addAssetsToAlbumAsync");
            String name3 = asyncFunctionBuilderAsyncFunction3.getName();
            TypeConverterProvider converters5 = asyncFunctionBuilderAsyncFunction3.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[3];
            AnyType anyType8 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String[].class), false));
            if (anyType8 == null) {
                try {
                    Result.Companion companion15 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Object[].class, false, Arrays.asList(PTypeDescriptorRegistry.STRING), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String[].class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
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
                    typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String[].class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                }
                anyType8 = new AnyType(typeDescriptor8, converters5);
            }
            anyTypeArr5[0] = anyType8;
            AnyType anyType9 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType9 == null) {
                try {
                    Result.Companion companion17 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$7
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
                anyType9 = new AnyType(typeDescriptor9, converters5);
            }
            anyTypeArr5[1] = anyType9;
            AnyType anyType10 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType10 == null) {
                try {
                    Result.Companion companion19 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
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
                    typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType10 = new AnyType(typeDescriptor10, converters5);
            }
            anyTypeArr5[2] = anyType10;
            asyncFunctionBuilderAsyncFunction3.setAsyncFunctionComponent(new SuspendFunctionComponent(name3, anyTypeArr5, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$9(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction4 = moduleDefinitionBuilder.AsyncFunction("removeAssetsFromAlbumAsync");
            String name4 = asyncFunctionBuilderAsyncFunction4.getName();
            TypeConverterProvider converters6 = asyncFunctionBuilderAsyncFunction4.getConverters();
            AnyType[] anyTypeArr6 = new AnyType[2];
            AnyType anyType11 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String[].class), false));
            if (anyType11 == null) {
                try {
                    Result.Companion companion21 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Object[].class, false, Arrays.asList(PTypeDescriptorRegistry.STRING), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$10
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String[].class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
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
                    typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String[].class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                }
                anyType11 = new AnyType(typeDescriptor11, converters6);
            }
            anyTypeArr6[0] = anyType11;
            AnyType anyType12 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType12 == null) {
                try {
                    Result.Companion companion23 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$11
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
            anyTypeArr6[1] = anyType12;
            asyncFunctionBuilderAsyncFunction4.setAsyncFunctionComponent(new SuspendFunctionComponent(name4, anyTypeArr6, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$12(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction5 = moduleDefinitionBuilder.AsyncFunction("deleteAssetsAsync");
            String name5 = asyncFunctionBuilderAsyncFunction5.getName();
            TypeConverterProvider converters7 = asyncFunctionBuilderAsyncFunction5.getConverters();
            AnyType[] anyTypeArr7 = new AnyType[1];
            AnyType anyType13 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String[].class), false));
            if (anyType13 == null) {
                try {
                    Result.Companion companion25 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Object[].class, false, Arrays.asList(PTypeDescriptorRegistry.STRING), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$13
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String[].class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
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
                    typeDescriptor13 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String[].class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                }
                anyType13 = new AnyType(typeDescriptor13, converters7);
            }
            anyTypeArr7[0] = anyType13;
            asyncFunctionBuilderAsyncFunction5.setAsyncFunctionComponent(new SuspendFunctionComponent(name5, anyTypeArr7, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$14(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction6 = moduleDefinitionBuilder.AsyncFunction("getAssetInfoAsync");
            String name6 = asyncFunctionBuilderAsyncFunction6.getName();
            TypeConverterProvider converters8 = asyncFunctionBuilderAsyncFunction6.getConverters();
            AnyType[] anyTypeArr8 = new AnyType[2];
            AnyType anyType14 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType14 == null) {
                try {
                    Result.Companion companion27 = Result.INSTANCE;
                    objM12684constructorimpl14 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$15
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
                anyType14 = new AnyType(typeDescriptor14, converters8);
            }
            anyTypeArr8[0] = anyType14;
            AnyType anyType15 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), true));
            if (anyType15 == null) {
                try {
                    Result.Companion companion29 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, true, Arrays.asList(PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Object.class, true, null)), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$16
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
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
                    typeDescriptor15 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class))));
                }
                anyType15 = new AnyType(typeDescriptor15, converters8);
            }
            anyTypeArr8[1] = anyType15;
            asyncFunctionBuilderAsyncFunction6.setAsyncFunctionComponent(new SuspendFunctionComponent(name6, anyTypeArr8, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$17(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction7 = moduleDefinitionBuilder.AsyncFunction("getAssetContentUriAsync");
            String name7 = asyncFunctionBuilderAsyncFunction7.getName();
            TypeConverterProvider converters9 = asyncFunctionBuilderAsyncFunction7.getConverters();
            AnyType[] anyTypeArr9 = new AnyType[1];
            AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType16 == null) {
                try {
                    Result.Companion companion31 = Result.INSTANCE;
                    objM12684constructorimpl16 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$18
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor16 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType16 = new AnyType(typeDescriptor16, converters9);
            }
            anyTypeArr9[0] = anyType16;
            asyncFunctionBuilderAsyncFunction7.setAsyncFunctionComponent(new SuspendFunctionComponent(name7, anyTypeArr9, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$19(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction8 = moduleDefinitionBuilder.AsyncFunction("getAlbumsAsync");
            String name8 = asyncFunctionBuilderAsyncFunction8.getName();
            TypeConverterProvider converters10 = asyncFunctionBuilderAsyncFunction8.getConverters();
            AnyType[] anyTypeArr10 = new AnyType[1];
            AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), true));
            if (anyType17 == null) {
                try {
                    Result.Companion companion33 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, true, Arrays.asList(PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Object.class, true, null)), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$20
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
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
                    typeDescriptor17 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class))));
                }
                anyType17 = new AnyType(typeDescriptor17, converters10);
            }
            anyTypeArr10[0] = anyType17;
            asyncFunctionBuilderAsyncFunction8.setAsyncFunctionComponent(new SuspendFunctionComponent(name8, anyTypeArr10, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$21(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction9 = moduleDefinitionBuilder.AsyncFunction("getAlbumAsync");
            String name9 = asyncFunctionBuilderAsyncFunction9.getName();
            TypeConverterProvider converters11 = asyncFunctionBuilderAsyncFunction9.getConverters();
            AnyType[] anyTypeArr11 = new AnyType[1];
            AnyType anyType18 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType18 == null) {
                try {
                    Result.Companion companion35 = Result.INSTANCE;
                    objM12684constructorimpl18 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$22
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor18 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType18 = new AnyType(typeDescriptor18, converters11);
            }
            anyTypeArr11[0] = anyType18;
            asyncFunctionBuilderAsyncFunction9.setAsyncFunctionComponent(new SuspendFunctionComponent(name9, anyTypeArr11, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$23(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction10 = moduleDefinitionBuilder.AsyncFunction("createAlbumAsync");
            String name10 = asyncFunctionBuilderAsyncFunction10.getName();
            TypeConverterProvider converters12 = asyncFunctionBuilderAsyncFunction10.getConverters();
            AnyType[] anyTypeArr12 = new AnyType[4];
            AnyType anyType19 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType19 == null) {
                try {
                    Result.Companion companion37 = Result.INSTANCE;
                    objM12684constructorimpl19 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$24
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor19 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType19 = new AnyType(typeDescriptor19, converters12);
            }
            anyTypeArr12[0] = anyType19;
            AnyType anyType20 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType20 == null) {
                try {
                    Result.Companion companion39 = Result.INSTANCE;
                    objM12684constructorimpl20 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$25
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
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
                    typeDescriptor20 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType20 = new AnyType(typeDescriptor20, converters12);
            }
            anyTypeArr12[1] = anyType20;
            AnyType anyType21 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType21 == null) {
                try {
                    Result.Companion companion41 = Result.INSTANCE;
                    objM12684constructorimpl21 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$26
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
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
                    typeDescriptor21 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType21 = new AnyType(typeDescriptor21, converters12);
            }
            anyTypeArr12[2] = anyType21;
            AnyType anyType22 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Uri.class), true));
            if (anyType22 == null) {
                try {
                    Result.Companion companion43 = Result.INSTANCE;
                    objM12684constructorimpl22 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, true, null)), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$27
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Uri.class);
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
                    typeDescriptor22 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Uri.class));
                }
                anyType22 = new AnyType(typeDescriptor22, converters12);
            }
            anyTypeArr12[3] = anyType22;
            asyncFunctionBuilderAsyncFunction10.setAsyncFunctionComponent(new SuspendFunctionComponent(name10, anyTypeArr12, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$28(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction11 = moduleDefinitionBuilder.AsyncFunction("deleteAlbumsAsync");
            String name11 = asyncFunctionBuilderAsyncFunction11.getName();
            TypeConverterProvider converters13 = asyncFunctionBuilderAsyncFunction11.getConverters();
            AnyType[] anyTypeArr13 = new AnyType[1];
            AnyType anyType23 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String[].class), false));
            if (anyType23 == null) {
                try {
                    Result.Companion companion45 = Result.INSTANCE;
                    objM12684constructorimpl23 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Object[].class, false, Arrays.asList(PTypeDescriptorRegistry.STRING), null)), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$29
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String[].class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
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
                    typeDescriptor23 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String[].class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                }
                anyType23 = new AnyType(typeDescriptor23, converters13);
            }
            anyTypeArr13[0] = anyType23;
            asyncFunctionBuilderAsyncFunction11.setAsyncFunctionComponent(new SuspendFunctionComponent(name11, anyTypeArr13, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$30(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction12 = moduleDefinitionBuilder.AsyncFunction("getAssetsAsync");
            String name12 = asyncFunctionBuilderAsyncFunction12.getName();
            TypeConverterProvider converters14 = asyncFunctionBuilderAsyncFunction12.getConverters();
            AnyType[] anyTypeArr14 = new AnyType[1];
            AnyType anyType24 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(AssetsOptions.class), false));
            if (anyType24 == null) {
                try {
                    Result.Companion companion47 = Result.INSTANCE;
                    objM12684constructorimpl24 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(AssetsOptions.class, false, AssetsOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$31
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(AssetsOptions.class);
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
                    typeDescriptor24 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(AssetsOptions.class));
                }
                anyType24 = new AnyType(typeDescriptor24, converters14);
            }
            anyTypeArr14[0] = anyType24;
            asyncFunctionBuilderAsyncFunction12.setAsyncFunctionComponent(new SuspendFunctionComponent(name12, anyTypeArr14, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$32(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction13 = moduleDefinitionBuilder.AsyncFunction("migrateAlbumIfNeededAsync");
            String name13 = asyncFunctionBuilderAsyncFunction13.getName();
            TypeConverterProvider converters15 = asyncFunctionBuilderAsyncFunction13.getConverters();
            AnyType[] anyTypeArr15 = new AnyType[1];
            AnyType anyType25 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType25 == null) {
                try {
                    Result.Companion companion49 = Result.INSTANCE;
                    objM12684constructorimpl25 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$33
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor25 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType25 = new AnyType(typeDescriptor25, converters15);
            }
            anyTypeArr15[0] = anyType25;
            asyncFunctionBuilderAsyncFunction13.setAsyncFunctionComponent(new SuspendFunctionComponent(name13, anyTypeArr15, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$34(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction14 = moduleDefinitionBuilder.AsyncFunction("albumNeedsMigrationAsync");
            String name14 = asyncFunctionBuilderAsyncFunction14.getName();
            TypeConverterProvider converters16 = asyncFunctionBuilderAsyncFunction14.getConverters();
            AnyType[] anyTypeArr16 = new AnyType[1];
            AnyType anyType26 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType26 == null) {
                try {
                    Result.Companion companion51 = Result.INSTANCE;
                    objM12684constructorimpl26 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$35
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor26 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType26 = new AnyType(typeDescriptor26, converters16);
            }
            anyTypeArr16[0] = anyType26;
            asyncFunctionBuilderAsyncFunction14.setAsyncFunctionComponent(new SuspendFunctionComponent(name14, anyTypeArr16, new MediaLibraryModule$definition$lambda$24$$inlined$Coroutine$36(null, this)));
            moduleDefinitionBuilder.OnStartObserving(new Function0<Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$1$20
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (this.this$0.imagesObserver != null) {
                        return;
                    }
                    Handler handler = new Handler(Looper.getMainLooper());
                    ContentResolver contentResolver = this.this$0.getContext().getContentResolver();
                    MediaLibraryModule mediaLibraryModule2 = this.this$0;
                    MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver = new MediaLibraryModule.MediaStoreContentObserver(this.this$0, handler, 1);
                    contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, mediaStoreContentObserver);
                    mediaLibraryModule2.imagesObserver = mediaStoreContentObserver;
                    MediaLibraryModule mediaLibraryModule3 = this.this$0;
                    MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver2 = new MediaLibraryModule.MediaStoreContentObserver(this.this$0, handler, 3);
                    contentResolver.registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, mediaStoreContentObserver2);
                    mediaLibraryModule3.videosObserver = mediaStoreContentObserver2;
                }
            });
            moduleDefinitionBuilder.OnStopObserving(new Function0<Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$1$21
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ContentResolver contentResolver = this.this$0.getContext().getContentResolver();
                    MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver = this.this$0.imagesObserver;
                    if (mediaStoreContentObserver != null) {
                        MediaLibraryModule mediaLibraryModule2 = this.this$0;
                        contentResolver.unregisterContentObserver(mediaStoreContentObserver);
                        mediaLibraryModule2.imagesObserver = null;
                    }
                    MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver2 = this.this$0.videosObserver;
                    if (mediaStoreContentObserver2 != null) {
                        MediaLibraryModule mediaLibraryModule3 = this.this$0;
                        contentResolver.unregisterContentObserver(mediaStoreContentObserver2);
                        mediaLibraryModule3.videosObserver = null;
                    }
                }
            });
            moduleDefinitionBuilder.RegisterActivityContracts(new MediaLibraryModule$definition$1$22(this, null));
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th27) {
            Trace.endSection();
            throw th27;
        }
    }

    private final boolean isMissingPermissions() {
        return hasReadPermissions();
    }

    private final boolean isMissingWritePermission() {
        return hasWritePermissions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String[] getManifestPermissions(boolean writeOnly, List<? extends GranularPermission> granularPermissions) {
        boolean z = Build.VERSION.SDK_INT >= 29 && MediaLibraryUtils.INSTANCE.hasManifestPermission(getContext(), "android.permission.ACCESS_MEDIA_LOCATION") && !(Build.VERSION.SDK_INT >= 33 && granularPermissions.size() == 1 && granularPermissions.contains(GranularPermission.AUDIO));
        boolean z2 = Build.VERSION.SDK_INT < 33 && MediaLibraryUtils.INSTANCE.hasManifestPermission(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
        boolean z3 = Build.VERSION.SDK_INT >= 33;
        boolean z4 = z3 && !writeOnly;
        SpreadBuilder spreadBuilder = new SpreadBuilder(4);
        spreadBuilder.add(z2 ? "android.permission.WRITE_EXTERNAL_STORAGE" : null);
        spreadBuilder.add((writeOnly || z3) ? null : "android.permission.READ_EXTERNAL_STORAGE");
        spreadBuilder.add(z ? "android.permission.ACCESS_MEDIA_LOCATION" : null);
        spreadBuilder.addSpread(getGranularPermissions(z4, granularPermissions));
        return (String[]) CollectionsKt.listOfNotNull(spreadBuilder.toArray(new String[spreadBuilder.size()])).toArray(new String[0]);
    }

    private final String[] getGranularPermissions(boolean shouldIncludeGranular, List<? extends GranularPermission> granularPermissions) throws PermissionsException {
        if (shouldIncludeGranular) {
            assertGranularPermissionIntegrity(getContext(), granularPermissions);
            return (String[]) CollectionsKt.listOfNotNull((Object[]) new String[]{granularPermissions.contains(GranularPermission.PHOTO) ? "android.permission.READ_MEDIA_IMAGES" : null, granularPermissions.contains(GranularPermission.VIDEO) ? "android.permission.READ_MEDIA_VIDEO" : null, granularPermissions.contains(GranularPermission.AUDIO) ? "android.permission.READ_MEDIA_AUDIO" : null}).toArray(new String[0]);
        }
        return new String[0];
    }

    private final void assertGranularPermissionIntegrity(Context context, List<? extends GranularPermission> granularPermissions) throws PermissionsException {
        for (GranularPermission granularPermission : granularPermissions) {
            if (!MediaLibraryUtils.INSTANCE.hasManifestPermission(context, granularPermission.toManifestPermission())) {
                throw new PermissionsException("You have requested the " + granularPermission + " permission, but it is not declared in AndroidManifest. Update expo-media-library config plugin to include the permission before requesting it.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<GranularPermission> getManifestDeclaredPermissions(Context context, List<? extends GranularPermission> granularPermissions) {
        if (Build.VERSION.SDK_INT < 33) {
            return granularPermissions;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : granularPermissions) {
            if (MediaLibraryUtils.INSTANCE.hasManifestPermission(context, ((GranularPermission) obj).toManifestPermission())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    static /* synthetic */ void requireSystemPermissions$default(MediaLibraryModule mediaLibraryModule, boolean z, int i, Object obj) throws PermissionsException {
        if ((i & 1) != 0) {
            z = true;
        }
        mediaLibraryModule.requireSystemPermissions(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requireSystemPermissions(boolean isWritePermissionRequired) throws PermissionsException {
        boolean zIsMissingPermissions;
        String str;
        if (isWritePermissionRequired) {
            zIsMissingPermissions = isMissingWritePermission();
        } else {
            zIsMissingPermissions = isMissingPermissions();
        }
        if (zIsMissingPermissions) {
            if (isWritePermissionRequired) {
                str = MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE;
            } else {
                str = MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE;
            }
            throw new PermissionsException(str);
        }
    }

    private final boolean hasReadPermissions() {
        if (Build.VERSION.SDK_INT >= 33) {
            List<GranularPermission> allowedPermissionsList = getAllowedPermissionsList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allowedPermissionsList, 10));
            Iterator<T> it = allowedPermissionsList.iterator();
            while (it.hasNext()) {
                arrayList.add(((GranularPermission) it.next()).toManifestPermission());
            }
            List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
            if (Build.VERSION.SDK_INT >= 34) {
                mutableList.add("android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
            }
            List<String> list = mutableList;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str : list) {
                Permissions permissions = getAppContext().getPermissions();
                arrayList2.add(Boolean.valueOf(permissions != null ? permissions.hasGrantedPermissions(str) : false));
            }
            ArrayList arrayList3 = arrayList2;
            if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    if (((Boolean) it2.next()).booleanValue()) {
                        return false;
                    }
                }
            }
            return true;
        }
        String[] strArr = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        Permissions permissions2 = getAppContext().getPermissions();
        if (permissions2 != null) {
            return !permissions2.hasGrantedPermissions((String[]) Arrays.copyOf(strArr, 2));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeThrowIfExpoGo(List<? extends GranularPermission> permissions) throws PermissionsException {
        if (isExpoGo()) {
            if (permissions.contains(GranularPermission.PHOTO) || permissions.contains(GranularPermission.VIDEO)) {
                throw new PermissionsException("Due to changes in Android's permission requirements, Expo Go can no longer provide full access to the media library. To test the full functionality of this module, you can create a development build");
            }
        }
    }

    private final boolean hasWritePermissions() {
        Permissions permissions;
        if (Build.VERSION.SDK_INT < 33 && (permissions = getAppContext().getPermissions()) != null) {
            return !permissions.hasGrantedPermissions("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cc, code lost:
    
        if (r11 == r1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0102, code lost:
    
        if (r11 == r1) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object requestMediaLibraryActionPermission(java.lang.String[] r9, boolean r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws expo.modules.medialibrary.PermissionsException {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.MediaLibraryModule.requestMediaLibraryActionPermission(java.lang.String[], boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object requestMediaLibraryActionPermission$default(MediaLibraryModule mediaLibraryModule, String[] strArr, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return mediaLibraryModule.requestMediaLibraryActionPermission(strArr, z, continuation);
    }

    private final boolean hasWritePermissionForUri(Uri uri) {
        return getContext().checkUriPermission(uri, Binder.getCallingPid(), Binder.getCallingUid(), 2) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MediaLibraryModule.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryModule$MediaStoreContentObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "mMediaType", "", "<init>", "(Lexpo/modules/medialibrary/MediaLibraryModule;Landroid/os/Handler;I)V", "mAssetsTotalCount", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "getAssetsTotalCount", "mediaType", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    final class MediaStoreContentObserver extends ContentObserver {
        private int mAssetsTotalCount;
        private final int mMediaType;
        final /* synthetic */ MediaLibraryModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaStoreContentObserver(MediaLibraryModule mediaLibraryModule, Handler handler, int i) {
            super(handler);
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.this$0 = mediaLibraryModule;
            this.mMediaType = i;
            this.mAssetsTotalCount = getAssetsTotalCount(i);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            onChange(selfChange, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            int assetsTotalCount = getAssetsTotalCount(this.mMediaType);
            if (this.mAssetsTotalCount != assetsTotalCount) {
                this.mAssetsTotalCount = assetsTotalCount;
                this.this$0.sendEvent("mediaLibraryDidChange", new Bundle());
            }
        }

        private final int getAssetsTotalCount(int mediaType) {
            Cursor cursorQuery = this.this$0.getContext().getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[0], "media_type == " + mediaType, null, null);
            try {
                Cursor cursor = cursorQuery;
                int count = cursor != null ? cursor.getCount() : 0;
                CloseableKt.closeFinally(cursorQuery, null);
                return count;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
    }
}
