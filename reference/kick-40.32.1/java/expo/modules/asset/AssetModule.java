package expo.modules.asset;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.ktor.sse.ServerSentEventKt;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: AssetModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u0014*\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lexpo/modules/asset/AssetModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "getMD5HashOfFilePath", "", "uri", "Ljava/net/URI;", "downloadAsset", "Landroid/net/Uri;", "appContext", "Lexpo/modules/kotlin/AppContext;", "localUrl", "Ljava/io/File;", "(Lexpo/modules/kotlin/AppContext;Ljava/net/URI;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toInputStream", "Ljava/io/InputStream;", "(Ljava/net/URI;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyTo", "", "file", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-asset_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssetModule extends Module {

    /* JADX INFO: renamed from: expo.modules.asset.AssetModule$downloadAsset$1, reason: invalid class name */
    /* JADX INFO: compiled from: AssetModule.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.asset.AssetModule", f = "AssetModule.kt", i = {0, 0, 0}, l = {EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION}, m = "downloadAsset", n = {"appContext", "uri", "localUrl"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModule.this.downloadAsset(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.asset.AssetModule$toInputStream$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetModule.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.asset.AssetModule", f = "AssetModule.kt", i = {0, 0}, l = {72}, m = "toInputStream", n = {"$this$toInputStream", "uriString"}, s = {"L$0", "L$1"})
    static final class C08071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08071(Continuation<? super C08071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AssetModule.this.toInputStream(null, this);
        }
    }

    private final Context getContext() throws Exceptions.AppContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.AppContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getMD5HashOfFilePath(URI uri) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.asset.AssetModule$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AssetModule.getMD5HashOfFilePath$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence getMD5HashOfFilePath$lambda$0(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadAsset(AppContext appContext, URI uri, File file, Continuation<? super Uri> continuation) throws UnableToDownloadAssetException, Exceptions.AppContextLost {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            File parentFile = file.getParentFile();
            if (parentFile == null || !parentFile.exists()) {
                file.mkdirs();
            }
            FilePermissionService filePermission = appContext.getFilePermission();
            Context context = getContext();
            String parent = file.getParent();
            if (parent == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            if (filePermission.getPathPermissions(context, parent).contains(FilePermissionService.Permission.WRITE)) {
                Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(appContext.getBackgroundCoroutineScope(), null, null, new AnonymousClass2(uri, file, null), 3, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(appContext);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(uri);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(file);
                anonymousClass1.label = 1;
                objAwait = deferredAsync$default.await(anonymousClass1);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                String string = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                throw new UnableToDownloadAssetException(string, null, 2, null);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwait);
        }
        Intrinsics.checkNotNullExpressionValue(objAwait, "await(...)");
        return objAwait;
    }

    /* JADX INFO: renamed from: expo.modules.asset.AssetModule$downloadAsset$2, reason: invalid class name */
    /* JADX INFO: compiled from: AssetModule.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.asset.AssetModule$downloadAsset$2", f = "AssetModule.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
        final /* synthetic */ File $localUrl;
        final /* synthetic */ URI $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(URI uri, File file, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$uri = uri;
            this.$localUrl = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AssetModule.this.new AnonymousClass2(this.$uri, this.$localUrl, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Uri> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws UnableToDownloadAssetException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = AssetModule.this.toInputStream(this.$uri, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Closeable closeable = (Closeable) obj;
                try {
                    long jCopyTo = AssetModule.this.copyTo((InputStream) closeable, this.$localUrl);
                    CloseableKt.closeFinally(closeable, null);
                    if (jCopyTo == 0) {
                        Log.w("ExpoAsset", "Asset downloaded to " + this.$localUrl + " is empty. It might be conflicting with another asset, or corrupted.");
                    }
                    return Uri.fromFile(this.$localUrl);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(closeable, th);
                        throw th2;
                    }
                }
            } catch (Exception e) {
                String string = this.$uri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                throw new UnableToDownloadAssetException(string, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object toInputStream(URI uri, Continuation<? super InputStream> continuation) throws FailedToDownloadAssetException {
        C08071 c08071;
        String str;
        if (continuation instanceof C08071) {
            c08071 = (C08071) continuation;
            if ((c08071.label & Integer.MIN_VALUE) != 0) {
                c08071.label -= Integer.MIN_VALUE;
            } else {
                c08071 = new C08071(continuation);
            }
        } else {
            c08071 = new C08071(continuation);
        }
        Object obj = c08071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08071.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (!StringsKt.contains$default((CharSequence) string, (CharSequence) ServerSentEventKt.COLON, false, 2, (Object) null)) {
                return ResourceAssetKt.openAssetResourceStream(getContext(), string);
            }
            if (StringsKt.startsWith$default(string, ResourceAssetKt.ANDROID_EMBEDDED_URL_BASE_RESOURCE, false, 2, (Object) null)) {
                return ResourceAssetKt.openAndroidResStream(getContext(), string);
            }
            c08071.L$0 = SpillingKt.nullOutSpilledVariable(uri);
            c08071.L$1 = string;
            c08071.label = 1;
            Object objOpenRemoteStream = ResourceAssetKt.openRemoteStream(string, c08071);
            if (objOpenRemoteStream == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objOpenRemoteStream;
            str = string;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c08071.L$1;
            ResultKt.throwOnFailure(obj);
        }
        InputStream inputStream = (InputStream) obj;
        if (inputStream != null) {
            return inputStream;
        }
        throw new FailedToDownloadAssetException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long copyTo(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            long jCopyTo$default = ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
            CloseableKt.closeFinally(fileOutputStream, null);
            return jCopyTo$default;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        AssetModule assetModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (assetModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(assetModule);
            moduleDefinitionBuilder.Name("ExpoAsset");
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("downloadAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyType[] anyTypeArr = new AnyType[3];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(URI.class), false));
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(URI.class, false, null)), new Function0<KType>() { // from class: expo.modules.asset.AssetModule$definition$lambda$3$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(URI.class);
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
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(URI.class));
                }
                anyType = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.asset.AssetModule$definition$lambda$3$$inlined$Coroutine$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
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
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType2 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[1] = anyType2;
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.asset.AssetModule$definition$lambda$3$$inlined$Coroutine$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType3 = new AnyType(typeDescriptor3, converters);
            }
            anyTypeArr[2] = anyType3;
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr, new AssetModule$definition$lambda$3$$inlined$Coroutine$4(null, this)));
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th4) {
            Trace.endSection();
            throw th4;
        }
    }
}
