package expo.modules.filesystem;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Base64;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.uimanager.ViewProps;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.classcomponent.ClassComponentBuilder;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.jni.NativeArrayBuffer;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ConstantComponentBuilder;
import expo.modules.kotlin.objects.PropertyComponentBuilder;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.net.URI;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: compiled from: FileSystemModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001dH\u0002J\u0018\u0010#\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020%H\u0017R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lexpo/modules/filesystem/FileSystemModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "filesDirectory", "Ljava/io/File;", "getFilesDirectory", "()Ljava/io/File;", "cacheDirectory", "getCacheDirectory", "downloadStore", "Lexpo/modules/filesystem/DownloadTaskStore;", "writeToFile", "", "file", "Lexpo/modules/filesystem/FileSystemFile;", "content", "Lexpo/modules/kotlin/types/Either;", "", "Lexpo/modules/kotlin/jni/NativeArrayBuffer;", "options", "Lexpo/modules/filesystem/WriteOptions;", "resolvePreviewMimeType", "mimeType", "createPreviewIntent", "Landroid/content/Intent;", "uri", "Landroid/net/Uri;", "canHandle", "", "intent", "grantReadPermissions", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileSystemModule extends Module {
    private final DownloadTaskStore downloadStore = new DownloadTaskStore();

    private final Context getContext() throws Exceptions.AppContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.AppContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getFilesDirectory() {
        return getAppContext().getPersistentFilesDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDirectory() {
        return getAppContext().getCacheDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeToFile(FileSystemFile file, Either<String, NativeArrayBuffer> content, WriteOptions options) throws InvalidTypeFileException, UnableToCreateException {
        boolean append = options != null ? options.getAppend() : false;
        if (content.isFirstType(Reflection.getOrCreateKotlinClass(String.class))) {
            String firstType = content.getFirstType(Reflection.getOrCreateKotlinClass(String.class));
            if ((options != null ? options.getEncoding() : null) == EncodingType.BASE64) {
                byte[] bArrDecode = Base64.decode(firstType, 0);
                Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
                file.write(bArrDecode, append);
                return;
            }
            file.write(firstType, append);
            return;
        }
        if (content.isSecondType(Reflection.getOrCreateKotlinClass(NativeArrayBuffer.class))) {
            file.write(content.getSecondType(Reflection.getOrCreateKotlinClass(NativeArrayBuffer.class)), append);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolvePreviewMimeType(FileSystemFile file, String mimeType) {
        return mimeType == null ? file.getType() : mimeType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent createPreviewIntent(Uri uri, String mimeType) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndTypeAndNormalize(uri, mimeType);
        intent.addFlags(1);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canHandle(Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = getContext().getPackageManager().queryIntentActivities(intent, 65536);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        return !listQueryIntentActivities.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void grantReadPermissions(Intent intent, Uri uri) {
        List<ResolveInfo> listQueryIntentActivities = getContext().getPackageManager().queryIntentActivities(intent, 65536);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        Iterator<T> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            getContext().grantUriPermission(((ResolveInfo) it.next()).activityInfo.packageName, uri, 1);
        }
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        ReturnType returnType;
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
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
        ClassComponentBuilder classComponentBuilder;
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
        Object objM12684constructorimpl32;
        Object objM12684constructorimpl33;
        Object objM12684constructorimpl34;
        Object objM12684constructorimpl35;
        Object objM12684constructorimpl36;
        Object objM12684constructorimpl37;
        Object objM12684constructorimpl38;
        Object objM12684constructorimpl39;
        Object objM12684constructorimpl40;
        Object objM12684constructorimpl41;
        Object objM12684constructorimpl42;
        Object objM12684constructorimpl43;
        Object objM12684constructorimpl44;
        Object objM12684constructorimpl45;
        Object objM12684constructorimpl46;
        Object objM12684constructorimpl47;
        Object objM12684constructorimpl48;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent;
        Object objM12684constructorimpl49;
        Object objM12684constructorimpl50;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent2;
        Object objM12684constructorimpl51;
        AnyType anyType2;
        Object objM12684constructorimpl52;
        Object objM12684constructorimpl53;
        Object objM12684constructorimpl54;
        Object objM12684constructorimpl55;
        Object objM12684constructorimpl56;
        Object objM12684constructorimpl57;
        Object objM12684constructorimpl58;
        Object objM12684constructorimpl59;
        Object objM12684constructorimpl60;
        Object objM12684constructorimpl61;
        Object objM12684constructorimpl62;
        Object objM12684constructorimpl63;
        Object objM12684constructorimpl64;
        AnyType anyType3;
        Object objM12684constructorimpl65;
        Object objM12684constructorimpl66;
        Object objM12684constructorimpl67;
        Object objM12684constructorimpl68;
        Object objM12684constructorimpl69;
        Object objM12684constructorimpl70;
        Object objM12684constructorimpl71;
        Object objM12684constructorimpl72;
        Object objM12684constructorimpl73;
        Object objM12684constructorimpl74;
        Object objM12684constructorimpl75;
        Object objM12684constructorimpl76;
        Object objM12684constructorimpl77;
        Object objM12684constructorimpl78;
        Object objM12684constructorimpl79;
        Object objM12684constructorimpl80;
        Object objM12684constructorimpl81;
        Object objM12684constructorimpl82;
        Object objM12684constructorimpl83;
        Object objM12684constructorimpl84;
        Object objM12684constructorimpl85;
        Object objM12684constructorimpl86;
        Object objM12684constructorimpl87;
        Object objM12684constructorimpl88;
        Object objM12684constructorimpl89;
        Object objM12684constructorimpl90;
        Object objM12684constructorimpl91;
        AnyType anyType4;
        Object objM12684constructorimpl92;
        Object objM12684constructorimpl93;
        Object objM12684constructorimpl94;
        Object objM12684constructorimpl95;
        Object objM12684constructorimpl96;
        Object objM12684constructorimpl97;
        AnyType anyType5;
        Object objM12684constructorimpl98;
        Object objM12684constructorimpl99;
        Object objM12684constructorimpl100;
        Object objM12684constructorimpl101;
        Object objM12684constructorimpl102;
        Object objM12684constructorimpl103;
        Object objM12684constructorimpl104;
        Object objM12684constructorimpl105;
        Object objM12684constructorimpl106;
        Object objM12684constructorimpl107;
        Object objM12684constructorimpl108;
        Object objM12684constructorimpl109;
        AnyType anyType6;
        Object objM12684constructorimpl110;
        Object objM12684constructorimpl111;
        Object objM12684constructorimpl112;
        Object objM12684constructorimpl113;
        FileSystemModule fileSystemModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (fileSystemModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(fileSystemModule);
            moduleDefinitionBuilder.Name("FileSystem");
            moduleDefinitionBuilder.Events("downloadProgress");
            ConstantComponentBuilder constantComponentBuilder = new ConstantComponentBuilder("documentDirectory");
            constantComponentBuilder.setGetter(new Function0<String>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Constant$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Uri.fromFile(this.this$0.getFilesDirectory()) + DomExceptionUtils.SEPARATOR;
                }
            });
            moduleDefinitionBuilder.getConstants().put("documentDirectory", constantComponentBuilder);
            ConstantComponentBuilder constantComponentBuilder2 = new ConstantComponentBuilder("cacheDirectory");
            constantComponentBuilder2.setGetter(new Function0<String>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Constant$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Uri.fromFile(this.this$0.getCacheDirectory()) + DomExceptionUtils.SEPARATOR;
                }
            });
            moduleDefinitionBuilder.getConstants().put("cacheDirectory", constantComponentBuilder2);
            ConstantComponentBuilder constantComponentBuilder3 = new ConstantComponentBuilder("bundleDirectory");
            constantComponentBuilder3.setGetter(new Function0<String>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Constant$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "asset://";
                }
            });
            moduleDefinitionBuilder.getConstants().put("bundleDirectory", constantComponentBuilder3);
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder("totalDiskSpace");
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType2 = returnTypeProvider.getTypes().get(Long.class);
            if (returnType2 != null) {
                returnType = returnType2;
            } else {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(Long.class);
                if (directConverter == null) {
                    directConverter = ReturnTypeKt.getIndirectConverter(Long.class, null);
                }
                returnType = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(Long.class, returnType);
            }
            propertyComponentBuilder.setGetter(new SyncFunctionComponent("get", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Long.valueOf(this.this$0.getFilesDirectory().getTotalSpace());
                }
            }));
            moduleDefinitionBuilder2.getProperties().put("totalDiskSpace", propertyComponentBuilder);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            PropertyComponentBuilder propertyComponentBuilder2 = new PropertyComponentBuilder("availableDiskSpace");
            AnyType[] anyTypeArr2 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider2.getTypes().get(Long.class);
            if (returnType3 == null) {
                JSTypeConverter<?> directConverter2 = ReturnTypeKt.getDirectConverter(Long.class);
                if (directConverter2 == null) {
                    directConverter2 = ReturnTypeKt.getIndirectConverter(Long.class, null);
                }
                ReturnType returnType4 = new ReturnType(directConverter2);
                returnTypeProvider2.getTypes().put(Long.class, returnType4);
                returnType3 = returnType4;
            }
            propertyComponentBuilder2.setGetter(new SyncFunctionComponent("get", anyTypeArr2, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Long.valueOf(this.this$0.getFilesDirectory().getFreeSpace());
                }
            }));
            moduleDefinitionBuilder3.getProperties().put("availableDiskSpace", propertyComponentBuilder2);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("downloadFileAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[4];
            AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(URI.class), false));
            if (anyType7 == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(URI.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Coroutine$1
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
                anyType7 = new AnyType(typeDescriptor, converters);
            }
            anyTypeArr3[0] = anyType7;
            AnyType anyType8 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType8 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemPath.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Coroutine$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemPath.class);
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
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemPath.class));
                }
                anyType8 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr3[1] = anyType8;
            AnyType anyType9 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DownloadOptions.class), true));
            if (anyType9 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DownloadOptions.class, true, DownloadOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Coroutine$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(DownloadOptions.class);
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
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(DownloadOptions.class));
                }
                anyType9 = new AnyType(typeDescriptor3, converters);
            }
            anyTypeArr3[2] = anyType9;
            AnyType anyType10 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType10 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Coroutine$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
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
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType10 = new AnyType(typeDescriptor4, converters);
            }
            anyTypeArr3[3] = anyType10;
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr3, new FileSystemModule$definition$lambda$87$$inlined$Coroutine$5(null, this)));
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder4.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[1];
            AnyType anyType11 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType11 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Function$1
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
                anyType11 = new AnyType(typeDescriptor5, converters2);
            }
            anyTypeArr4[0] = anyType11;
            ReturnTypeProvider returnTypeProvider3 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType5 = returnTypeProvider3.getTypes().get(Unit.class);
            if (returnType5 == null) {
                JSTypeConverter<?> directConverter3 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter3 == null) {
                    directConverter3 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType6 = new ReturnType(directConverter3);
                returnTypeProvider3.getTypes().put(Unit.class, returnType6);
                returnType5 = returnType6;
            }
            moduleDefinitionBuilder4.getSyncFunctions().put("cancelDownloadAsync", new SyncFunctionComponent("cancelDownloadAsync", anyTypeArr4, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    this.this$0.downloadStore.cancel((String) objArr[0]);
                    return Unit.INSTANCE;
                }
            }));
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            moduleDefinitionBuilder.RegisterActivityContracts(new FileSystemModule$definition$1$8(objectRef, this, null));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("pickDirectoryAsync");
            String name2 = asyncFunctionBuilderAsyncFunction2.getName();
            TypeConverterProvider converters3 = asyncFunctionBuilderAsyncFunction2.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[1];
            AnyType anyType12 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Uri.class), true));
            if (anyType12 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, true, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Coroutine$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Uri.class);
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
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(Uri.class));
                }
                anyType12 = new AnyType(typeDescriptor6, converters3);
            }
            anyTypeArr5[0] = anyType12;
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, anyTypeArr5, new FileSystemModule$definition$lambda$87$$inlined$Coroutine$7(null, objectRef)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction3 = moduleDefinitionBuilder.AsyncFunction("pickFileAsync");
            String name3 = asyncFunctionBuilderAsyncFunction3.getName();
            TypeConverterProvider converters4 = asyncFunctionBuilderAsyncFunction3.getConverters();
            AnyType[] anyTypeArr6 = new AnyType[1];
            AnyType anyType13 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PickFileOptions.class), true));
            if (anyType13 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(PickFileOptions.class, true, PickFileOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Coroutine$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(PickFileOptions.class);
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
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(PickFileOptions.class));
                }
                anyType13 = new AnyType(typeDescriptor7, converters4);
            }
            anyTypeArr6[0] = anyType13;
            asyncFunctionBuilderAsyncFunction3.setAsyncFunctionComponent(new SuspendFunctionComponent(name3, anyTypeArr6, new FileSystemModule$definition$lambda$87$$inlined$Coroutine$9(null, objectRef)));
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            TypeConverterProvider converters5 = moduleDefinitionBuilder5.getConverters();
            AnyType[] anyTypeArr7 = new AnyType[1];
            AnyType anyType14 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(URI.class), false));
            if (anyType14 == null) {
                try {
                    Result.Companion companion15 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(URI.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Function$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(URI.class);
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
                    typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(URI.class));
                }
                anyType14 = new AnyType(typeDescriptor8, converters5);
            }
            anyTypeArr7[0] = anyType14;
            ReturnTypeProvider returnTypeProvider4 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType7 = returnTypeProvider4.getTypes().get(PathInfo.class);
            if (returnType7 == null) {
                JSTypeConverter<?> directConverter4 = ReturnTypeKt.getDirectConverter(PathInfo.class);
                if (directConverter4 == null) {
                    directConverter4 = ReturnTypeKt.getIndirectConverter(PathInfo.class, PathInfo.__Pika.__pika$IntrospectionData);
                }
                ReturnType returnType8 = new ReturnType(directConverter4);
                returnTypeProvider4.getTypes().put(PathInfo.class, returnType8);
                returnType7 = returnType8;
            }
            moduleDefinitionBuilder5.getSyncFunctions().put("info", new SyncFunctionComponent("info", anyTypeArr7, returnType7, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws Exceptions.ReactContextLost {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    File file = new File((URI) objArr[0]);
                    FilePermissionService filePermission = this.this$0.getAppContext().getFilePermission();
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    if (reactContext == null) {
                        throw new Exceptions.ReactContextLost();
                    }
                    String path = file.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                    if (filePermission.getPathPermissions(reactContext, path).contains(FilePermissionService.Permission.READ) && file.exists()) {
                        return new PathInfo(file.exists(), Boolean.valueOf(file.isDirectory()));
                    }
                    return new PathInfo(false, null);
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FileSystemFile.class);
            Module module = moduleDefinitionBuilder6.getModule();
            if (module == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext = module.getAppContext();
            String simpleName = JvmClassMappingKt.getJavaClass(orCreateKotlinClass).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            AnyType anyType15 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType15 != null) {
                anyType = anyType15;
            } else {
                try {
                    Result.Companion companion17 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Class$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
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
                    typeDescriptor9 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType = new AnyType(typeDescriptor9, null);
            }
            ClassComponentBuilder classComponentBuilder2 = new ClassComponentBuilder(appContext, simpleName, orCreateKotlinClass, anyType, moduleDefinitionBuilder6.getConverters());
            TypeConverterProvider converters6 = classComponentBuilder2.getConverters();
            AnyType[] anyTypeArr8 = new AnyType[1];
            AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Uri.class), false));
            if (anyType16 == null) {
                try {
                    Result.Companion companion19 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Constructor$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Uri.class);
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
                    typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Uri.class));
                }
                anyType16 = new AnyType(typeDescriptor10, converters6);
            }
            anyTypeArr8[0] = anyType16;
            ReturnTypeProvider returnTypeProvider5 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType9 = returnTypeProvider5.getTypes().get(Object.class);
            if (returnType9 == null) {
                JSTypeConverter<?> directConverter5 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter5 == null) {
                    directConverter5 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType10 = new ReturnType(directConverter5);
                returnTypeProvider5.getTypes().put(Object.class, returnType10);
                returnType9 = returnType10;
            }
            classComponentBuilder2.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr8, returnType9, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return new FileSystemFile((Uri) objArr[0]);
                }
            }));
            ClassComponentBuilder classComponentBuilder3 = classComponentBuilder2;
            TypeConverterProvider converters7 = classComponentBuilder3.getConverters();
            AnyType[] anyTypeArr9 = new AnyType[1];
            AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType17 == null) {
                try {
                    Result.Companion companion21 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
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
                    typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType17 = new AnyType(typeDescriptor11, converters7);
            }
            anyTypeArr9[0] = anyType17;
            ReturnTypeProvider returnTypeProvider6 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType11 = returnTypeProvider6.getTypes().get(Unit.class);
            if (returnType11 == null) {
                JSTypeConverter<?> directConverter6 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter6 == null) {
                    directConverter6 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType12 = new ReturnType(directConverter6);
                returnTypeProvider6.getTypes().put(Unit.class, returnType12);
                returnType11 = returnType12;
            }
            classComponentBuilder3.getSyncFunctions().put("delete", new SyncFunctionComponent("delete", anyTypeArr9, returnType11, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemFile) objArr[0]).delete();
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder4 = classComponentBuilder2;
            TypeConverterProvider converters8 = classComponentBuilder4.getConverters();
            AnyType[] anyTypeArr10 = new AnyType[1];
            AnyType anyType18 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType18 == null) {
                try {
                    Result.Companion companion23 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
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
                    typeDescriptor12 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType18 = new AnyType(typeDescriptor12, converters8);
            }
            anyTypeArr10[0] = anyType18;
            ReturnTypeProvider returnTypeProvider7 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType13 = returnTypeProvider7.getTypes().get(Unit.class);
            if (returnType13 == null) {
                JSTypeConverter<?> directConverter7 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter7 == null) {
                    directConverter7 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType14 = new ReturnType(directConverter7);
                returnTypeProvider7.getTypes().put(Unit.class, returnType14);
                returnType13 = returnType14;
            }
            classComponentBuilder4.getSyncFunctions().put("validatePath", new SyncFunctionComponent("validatePath", anyTypeArr10, returnType13, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemFile) objArr[0]).validatePath();
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder5 = classComponentBuilder2;
            TypeConverterProvider converters9 = classComponentBuilder5.getConverters();
            AnyType[] anyTypeArr11 = new AnyType[2];
            AnyType anyType19 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType19 == null) {
                try {
                    Result.Companion companion25 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
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
                    typeDescriptor13 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType19 = new AnyType(typeDescriptor13, converters9);
            }
            anyTypeArr11[0] = anyType19;
            AnyType anyType20 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(CreateOptions.class), true));
            if (anyType20 == null) {
                try {
                    Result.Companion companion27 = Result.INSTANCE;
                    objM12684constructorimpl14 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(CreateOptions.class, true, CreateOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(CreateOptions.class);
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
                    typeDescriptor14 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(CreateOptions.class));
                }
                anyType20 = new AnyType(typeDescriptor14, converters9);
            }
            anyTypeArr11[1] = anyType20;
            ReturnTypeProvider returnTypeProvider8 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType15 = returnTypeProvider8.getTypes().get(Unit.class);
            if (returnType15 == null) {
                JSTypeConverter<?> directConverter8 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter8 == null) {
                    directConverter8 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType16 = new ReturnType(directConverter8);
                returnTypeProvider8.getTypes().put(Unit.class, returnType16);
                returnType15 = returnType16;
            }
            classComponentBuilder5.getSyncFunctions().put("create", new SyncFunctionComponent("create", anyTypeArr11, returnType15, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InvalidTypeFileException, UnableToCreateException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    CreateOptions createOptions = (CreateOptions) objArr[1];
                    FileSystemFile fileSystemFile = (FileSystemFile) obj;
                    if (createOptions == null) {
                        createOptions = new CreateOptions(false, false, false, 7, null);
                    }
                    fileSystemFile.create(createOptions);
                    return Unit.INSTANCE;
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction4 = classComponentBuilder2.AsyncFunction("write");
            String name4 = asyncFunctionBuilderAsyncFunction4.getName();
            TypeConverterProvider converters10 = asyncFunctionBuilderAsyncFunction4.getConverters();
            AnyType[] anyTypeArr12 = new AnyType[3];
            AnyType anyType21 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType21 == null) {
                try {
                    Result.Companion companion29 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
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
                    typeDescriptor15 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType21 = new AnyType(typeDescriptor15, converters10);
            }
            anyTypeArr12[0] = anyType21;
            AnyType anyType22 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), false));
            if (anyType22 == null) {
                try {
                    Result.Companion companion31 = Result.INSTANCE;
                    objM12684constructorimpl16 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, false, Arrays.asList(PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(NativeArrayBuffer.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(NativeArrayBuffer.class)));
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
                    typeDescriptor16 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(NativeArrayBuffer.class))));
                }
                anyType22 = new AnyType(typeDescriptor16, converters10);
            }
            anyTypeArr12[1] = anyType22;
            AnyType anyType23 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(WriteOptions.class), true));
            if (anyType23 == null) {
                try {
                    Result.Companion companion33 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(WriteOptions.class, true, WriteOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(WriteOptions.class);
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
                    typeDescriptor17 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(WriteOptions.class));
                }
                anyType23 = new AnyType(typeDescriptor17, converters10);
            }
            anyTypeArr12[2] = anyType23;
            asyncFunctionBuilderAsyncFunction4.setAsyncFunctionComponent(new SuspendFunctionComponent(name4, anyTypeArr12, new FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$4(null, this)));
            ClassComponentBuilder classComponentBuilder6 = classComponentBuilder2;
            TypeConverterProvider converters11 = classComponentBuilder6.getConverters();
            AnyType[] anyTypeArr13 = new AnyType[3];
            AnyType anyType24 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType24 == null) {
                try {
                    Result.Companion companion35 = Result.INSTANCE;
                    objM12684constructorimpl18 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
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
                    typeDescriptor18 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType24 = new AnyType(typeDescriptor18, converters11);
            }
            anyTypeArr13[0] = anyType24;
            AnyType anyType25 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), false));
            if (anyType25 != null) {
                classComponentBuilder = classComponentBuilder6;
            } else {
                try {
                    Result.Companion companion37 = Result.INSTANCE;
                    PTypeDescriptor[] pTypeDescriptorArr = new PTypeDescriptor[2];
                    pTypeDescriptorArr[0] = PTypeDescriptorRegistry.STRING;
                    classComponentBuilder = classComponentBuilder6;
                    try {
                        pTypeDescriptorArr[1] = PTypeDescriptorRegistry.getOrCreateConcrete(NativeArrayBuffer.class, false, null);
                        objM12684constructorimpl19 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, false, Arrays.asList(pTypeDescriptorArr), null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$9
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(NativeArrayBuffer.class)));
                            }
                        }));
                    } catch (Throwable th19) {
                        th = th19;
                        Result.Companion companion38 = Result.INSTANCE;
                        objM12684constructorimpl19 = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                } catch (Throwable th20) {
                    th = th20;
                    classComponentBuilder = classComponentBuilder6;
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl19)) {
                    objM12684constructorimpl19 = null;
                }
                TypeDescriptor typeDescriptor19 = (TypeDescriptor) objM12684constructorimpl19;
                if (typeDescriptor19 == null) {
                    typeDescriptor19 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(NativeArrayBuffer.class))));
                }
                anyType25 = new AnyType(typeDescriptor19, converters11);
            }
            anyTypeArr13[1] = anyType25;
            AnyType anyType26 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(WriteOptions.class), true));
            if (anyType26 == null) {
                try {
                    Result.Companion companion39 = Result.INSTANCE;
                    objM12684constructorimpl20 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(WriteOptions.class, true, WriteOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$10
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(WriteOptions.class);
                        }
                    }));
                } catch (Throwable th21) {
                    Result.Companion companion40 = Result.INSTANCE;
                    objM12684constructorimpl20 = Result.m12684constructorimpl(ResultKt.createFailure(th21));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl20)) {
                    objM12684constructorimpl20 = null;
                }
                TypeDescriptor typeDescriptor20 = (TypeDescriptor) objM12684constructorimpl20;
                if (typeDescriptor20 == null) {
                    typeDescriptor20 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(WriteOptions.class));
                }
                anyType26 = new AnyType(typeDescriptor20, converters11);
            }
            anyTypeArr13[2] = anyType26;
            ReturnTypeProvider returnTypeProvider9 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType17 = returnTypeProvider9.getTypes().get(Unit.class);
            if (returnType17 == null) {
                JSTypeConverter<?> directConverter9 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter9 == null) {
                    directConverter9 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType18 = new ReturnType(directConverter9);
                returnTypeProvider9.getTypes().put(Unit.class, returnType18);
                returnType17 = returnType18;
            }
            classComponentBuilder.getSyncFunctions().put("writeSync", new SyncFunctionComponent("writeSync", anyTypeArr13, returnType17, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InvalidTypeFileException, UnableToCreateException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    WriteOptions writeOptions = (WriteOptions) objArr[2];
                    FileSystemModule fileSystemModule2 = this.this$0;
                    fileSystemModule2.writeToFile((FileSystemFile) obj, (Either) obj2, writeOptions);
                    return Unit.INSTANCE;
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction5 = classComponentBuilder2.AsyncFunction("text");
            String name5 = asyncFunctionBuilderAsyncFunction5.getName();
            TypeConverterProvider converters12 = asyncFunctionBuilderAsyncFunction5.getConverters();
            AnyType[] anyTypeArr14 = new AnyType[1];
            AnyType anyType27 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType27 == null) {
                try {
                    Result.Companion companion41 = Result.INSTANCE;
                    objM12684constructorimpl21 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th22) {
                    Result.Companion companion42 = Result.INSTANCE;
                    objM12684constructorimpl21 = Result.m12684constructorimpl(ResultKt.createFailure(th22));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl21)) {
                    objM12684constructorimpl21 = null;
                }
                TypeDescriptor typeDescriptor21 = (TypeDescriptor) objM12684constructorimpl21;
                if (typeDescriptor21 == null) {
                    typeDescriptor21 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType27 = new AnyType(typeDescriptor21, converters12);
            }
            anyTypeArr14[0] = anyType27;
            asyncFunctionBuilderAsyncFunction5.setAsyncFunctionComponent(new SuspendFunctionComponent(name5, anyTypeArr14, new FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$6(null)));
            ClassComponentBuilder classComponentBuilder7 = classComponentBuilder2;
            TypeConverterProvider converters13 = classComponentBuilder7.getConverters();
            AnyType[] anyTypeArr15 = new AnyType[1];
            AnyType anyType28 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType28 == null) {
                try {
                    Result.Companion companion43 = Result.INSTANCE;
                    objM12684constructorimpl22 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$12
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th23) {
                    Result.Companion companion44 = Result.INSTANCE;
                    objM12684constructorimpl22 = Result.m12684constructorimpl(ResultKt.createFailure(th23));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl22)) {
                    objM12684constructorimpl22 = null;
                }
                TypeDescriptor typeDescriptor22 = (TypeDescriptor) objM12684constructorimpl22;
                if (typeDescriptor22 == null) {
                    typeDescriptor22 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType28 = new AnyType(typeDescriptor22, converters13);
            }
            anyTypeArr15[0] = anyType28;
            ReturnTypeProvider returnTypeProvider10 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType19 = returnTypeProvider10.getTypes().get(String.class);
            if (returnType19 == null) {
                JSTypeConverter<?> directConverter10 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter10 == null) {
                    directConverter10 = ReturnTypeKt.getIndirectConverter(String.class, null);
                }
                ReturnType returnType20 = new ReturnType(directConverter10);
                returnTypeProvider10.getTypes().put(String.class, returnType20);
                returnType19 = returnType20;
            }
            classComponentBuilder7.getSyncFunctions().put("textSync", new SyncFunctionComponent("textSync", anyTypeArr15, returnType19, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemFile) objArr[0]).text();
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction6 = classComponentBuilder2.AsyncFunction("base64");
            String name6 = asyncFunctionBuilderAsyncFunction6.getName();
            TypeConverterProvider converters14 = asyncFunctionBuilderAsyncFunction6.getConverters();
            AnyType[] anyTypeArr16 = new AnyType[1];
            AnyType anyType29 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType29 == null) {
                try {
                    Result.Companion companion45 = Result.INSTANCE;
                    objM12684constructorimpl23 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th24) {
                    Result.Companion companion46 = Result.INSTANCE;
                    objM12684constructorimpl23 = Result.m12684constructorimpl(ResultKt.createFailure(th24));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl23)) {
                    objM12684constructorimpl23 = null;
                }
                TypeDescriptor typeDescriptor23 = (TypeDescriptor) objM12684constructorimpl23;
                if (typeDescriptor23 == null) {
                    typeDescriptor23 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType29 = new AnyType(typeDescriptor23, converters14);
            }
            anyTypeArr16[0] = anyType29;
            asyncFunctionBuilderAsyncFunction6.setAsyncFunctionComponent(new SuspendFunctionComponent(name6, anyTypeArr16, new FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$8(null)));
            ClassComponentBuilder classComponentBuilder8 = classComponentBuilder2;
            TypeConverterProvider converters15 = classComponentBuilder8.getConverters();
            AnyType[] anyTypeArr17 = new AnyType[1];
            AnyType anyType30 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType30 == null) {
                try {
                    Result.Companion companion47 = Result.INSTANCE;
                    objM12684constructorimpl24 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$14
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th25) {
                    Result.Companion companion48 = Result.INSTANCE;
                    objM12684constructorimpl24 = Result.m12684constructorimpl(ResultKt.createFailure(th25));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl24)) {
                    objM12684constructorimpl24 = null;
                }
                TypeDescriptor typeDescriptor24 = (TypeDescriptor) objM12684constructorimpl24;
                if (typeDescriptor24 == null) {
                    typeDescriptor24 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType30 = new AnyType(typeDescriptor24, converters15);
            }
            anyTypeArr17[0] = anyType30;
            ReturnTypeProvider returnTypeProvider11 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType21 = returnTypeProvider11.getTypes().get(String.class);
            if (returnType21 == null) {
                JSTypeConverter<?> directConverter11 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter11 == null) {
                    directConverter11 = ReturnTypeKt.getIndirectConverter(String.class, null);
                }
                ReturnType returnType22 = new ReturnType(directConverter11);
                returnTypeProvider11.getTypes().put(String.class, returnType22);
                returnType21 = returnType22;
            }
            classComponentBuilder8.getSyncFunctions().put("base64Sync", new SyncFunctionComponent("base64Sync", anyTypeArr17, returnType21, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemFile) objArr[0]).base64();
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction7 = classComponentBuilder2.AsyncFunction("bytes");
            String name7 = asyncFunctionBuilderAsyncFunction7.getName();
            TypeConverterProvider converters16 = asyncFunctionBuilderAsyncFunction7.getConverters();
            AnyType[] anyTypeArr18 = new AnyType[1];
            AnyType anyType31 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType31 == null) {
                try {
                    Result.Companion companion49 = Result.INSTANCE;
                    objM12684constructorimpl25 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th26) {
                    Result.Companion companion50 = Result.INSTANCE;
                    objM12684constructorimpl25 = Result.m12684constructorimpl(ResultKt.createFailure(th26));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl25)) {
                    objM12684constructorimpl25 = null;
                }
                TypeDescriptor typeDescriptor25 = (TypeDescriptor) objM12684constructorimpl25;
                if (typeDescriptor25 == null) {
                    typeDescriptor25 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType31 = new AnyType(typeDescriptor25, converters16);
            }
            anyTypeArr18[0] = anyType31;
            asyncFunctionBuilderAsyncFunction7.setAsyncFunctionComponent(new SuspendFunctionComponent(name7, anyTypeArr18, new FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$10(null)));
            ClassComponentBuilder classComponentBuilder9 = classComponentBuilder2;
            TypeConverterProvider converters17 = classComponentBuilder9.getConverters();
            AnyType[] anyTypeArr19 = new AnyType[1];
            AnyType anyType32 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType32 == null) {
                try {
                    Result.Companion companion51 = Result.INSTANCE;
                    objM12684constructorimpl26 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$16
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th27) {
                    Result.Companion companion52 = Result.INSTANCE;
                    objM12684constructorimpl26 = Result.m12684constructorimpl(ResultKt.createFailure(th27));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl26)) {
                    objM12684constructorimpl26 = null;
                }
                TypeDescriptor typeDescriptor26 = (TypeDescriptor) objM12684constructorimpl26;
                if (typeDescriptor26 == null) {
                    typeDescriptor26 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType32 = new AnyType(typeDescriptor26, converters17);
            }
            anyTypeArr19[0] = anyType32;
            ReturnTypeProvider returnTypeProvider12 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType23 = returnTypeProvider12.getTypes().get(byte[].class);
            if (returnType23 == null) {
                JSTypeConverter<?> directConverter12 = ReturnTypeKt.getDirectConverter(byte[].class);
                if (directConverter12 == null) {
                    directConverter12 = ReturnTypeKt.getIndirectConverter(byte[].class, null);
                }
                ReturnType returnType24 = new ReturnType(directConverter12);
                returnTypeProvider12.getTypes().put(byte[].class, returnType24);
                returnType23 = returnType24;
            }
            classComponentBuilder9.getSyncFunctions().put("bytesSync", new SyncFunctionComponent("bytesSync", anyTypeArr19, returnType23, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$17
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemFile) objArr[0]).bytes();
                }
            }));
            ClassComponentBuilder classComponentBuilder10 = classComponentBuilder2;
            TypeConverterProvider converters18 = classComponentBuilder10.getConverters();
            AnyType[] anyTypeArr20 = new AnyType[2];
            AnyType anyType33 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType33 == null) {
                try {
                    Result.Companion companion53 = Result.INSTANCE;
                    objM12684constructorimpl27 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$18
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th28) {
                    Result.Companion companion54 = Result.INSTANCE;
                    objM12684constructorimpl27 = Result.m12684constructorimpl(ResultKt.createFailure(th28));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl27)) {
                    objM12684constructorimpl27 = null;
                }
                TypeDescriptor typeDescriptor27 = (TypeDescriptor) objM12684constructorimpl27;
                if (typeDescriptor27 == null) {
                    typeDescriptor27 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType33 = new AnyType(typeDescriptor27, converters18);
            }
            anyTypeArr20[0] = anyType33;
            AnyType anyType34 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(InfoOptions.class), true));
            if (anyType34 == null) {
                try {
                    Result.Companion companion55 = Result.INSTANCE;
                    objM12684constructorimpl28 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(InfoOptions.class, true, InfoOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$19
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(InfoOptions.class);
                        }
                    }));
                } catch (Throwable th29) {
                    Result.Companion companion56 = Result.INSTANCE;
                    objM12684constructorimpl28 = Result.m12684constructorimpl(ResultKt.createFailure(th29));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl28)) {
                    objM12684constructorimpl28 = null;
                }
                TypeDescriptor typeDescriptor28 = (TypeDescriptor) objM12684constructorimpl28;
                if (typeDescriptor28 == null) {
                    typeDescriptor28 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(InfoOptions.class));
                }
                anyType34 = new AnyType(typeDescriptor28, converters18);
            }
            anyTypeArr20[1] = anyType34;
            ReturnTypeProvider returnTypeProvider13 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType25 = returnTypeProvider13.getTypes().get(FileInfo.class);
            if (returnType25 == null) {
                JSTypeConverter<?> directConverter13 = ReturnTypeKt.getDirectConverter(FileInfo.class);
                if (directConverter13 == null) {
                    directConverter13 = ReturnTypeKt.getIndirectConverter(FileInfo.class, FileInfo.__Pika.__pika$IntrospectionData);
                }
                ReturnType returnType26 = new ReturnType(directConverter13);
                returnTypeProvider13.getTypes().put(FileInfo.class, returnType26);
                returnType25 = returnType26;
            }
            classComponentBuilder10.getSyncFunctions().put("info", new SyncFunctionComponent("info", anyTypeArr20, returnType25, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$20
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemFile) objArr[0]).info((InfoOptions) objArr[1]);
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction8 = classComponentBuilder2.AsyncFunction("digest");
            String name8 = asyncFunctionBuilderAsyncFunction8.getName();
            TypeConverterProvider converters19 = asyncFunctionBuilderAsyncFunction8.getConverters();
            AnyType[] anyTypeArr21 = new AnyType[2];
            AnyType anyType35 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType35 == null) {
                try {
                    Result.Companion companion57 = Result.INSTANCE;
                    objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th30) {
                    Result.Companion companion58 = Result.INSTANCE;
                    objM12684constructorimpl29 = Result.m12684constructorimpl(ResultKt.createFailure(th30));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl29)) {
                    objM12684constructorimpl29 = null;
                }
                TypeDescriptor typeDescriptor29 = (TypeDescriptor) objM12684constructorimpl29;
                if (typeDescriptor29 == null) {
                    typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType35 = new AnyType(typeDescriptor29, converters19);
            }
            anyTypeArr21[0] = anyType35;
            AnyType anyType36 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType36 == null) {
                try {
                    Result.Companion companion59 = Result.INSTANCE;
                    objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$12
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th31) {
                    Result.Companion companion60 = Result.INSTANCE;
                    objM12684constructorimpl30 = Result.m12684constructorimpl(ResultKt.createFailure(th31));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl30)) {
                    objM12684constructorimpl30 = null;
                }
                TypeDescriptor typeDescriptor30 = (TypeDescriptor) objM12684constructorimpl30;
                if (typeDescriptor30 == null) {
                    typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType36 = new AnyType(typeDescriptor30, converters19);
            }
            anyTypeArr21[1] = anyType36;
            asyncFunctionBuilderAsyncFunction8.setAsyncFunctionComponent(new SuspendFunctionComponent(name8, anyTypeArr21, new FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$13(null)));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis(classComponentBuilder2.getOwnerType().getTypeDescriptor(), "exists");
            AnyType[] anyTypeArr22 = {new AnyType(propertyComponentBuilderWithThis.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider14 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType27 = returnTypeProvider14.getTypes().get(Boolean.class);
            if (returnType27 == null) {
                JSTypeConverter<?> directConverter14 = ReturnTypeKt.getDirectConverter(Boolean.class);
                if (directConverter14 == null) {
                    directConverter14 = ReturnTypeKt.getIndirectConverter(Boolean.class, null);
                }
                ReturnType returnType28 = new ReturnType(directConverter14);
                returnTypeProvider14.getTypes().put(Boolean.class, returnType28);
                returnType27 = returnType28;
            }
            SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("get", anyTypeArr22, returnType27, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(((FileSystemFile) it[0]).getExists());
                }
            });
            syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
            syncFunctionComponent.setCanTakeOwner(true);
            propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
            classComponentBuilder2.getProperties().put("exists", propertyComponentBuilderWithThis);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis2 = new PropertyComponentBuilderWithThis(classComponentBuilder2.getOwnerType().getTypeDescriptor(), "modificationTime");
            AnyType[] anyTypeArr23 = {new AnyType(propertyComponentBuilderWithThis2.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider15 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType29 = returnTypeProvider15.getTypes().get(Long.class);
            if (returnType29 == null) {
                JSTypeConverter<?> directConverter15 = ReturnTypeKt.getDirectConverter(Long.class);
                if (directConverter15 == null) {
                    directConverter15 = ReturnTypeKt.getIndirectConverter(Long.class, null);
                }
                ReturnType returnType30 = new ReturnType(directConverter15);
                returnTypeProvider15.getTypes().put(Long.class, returnType30);
                returnType29 = returnType30;
            }
            SyncFunctionComponent syncFunctionComponent2 = new SyncFunctionComponent("get", anyTypeArr23, returnType29, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).getModificationTime();
                }
            });
            syncFunctionComponent2.setOwnerType(propertyComponentBuilderWithThis2.getThisType());
            syncFunctionComponent2.setCanTakeOwner(true);
            propertyComponentBuilderWithThis2.setGetter(syncFunctionComponent2);
            classComponentBuilder2.getProperties().put("modificationTime", propertyComponentBuilderWithThis2);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis3 = new PropertyComponentBuilderWithThis(classComponentBuilder2.getOwnerType().getTypeDescriptor(), "lastModified");
            AnyType[] anyTypeArr24 = {new AnyType(propertyComponentBuilderWithThis3.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider16 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType31 = returnTypeProvider16.getTypes().get(Long.class);
            if (returnType31 == null) {
                JSTypeConverter<?> directConverter16 = ReturnTypeKt.getDirectConverter(Long.class);
                if (directConverter16 == null) {
                    directConverter16 = ReturnTypeKt.getIndirectConverter(Long.class, null);
                }
                ReturnType returnType32 = new ReturnType(directConverter16);
                returnTypeProvider16.getTypes().put(Long.class, returnType32);
                returnType31 = returnType32;
            }
            SyncFunctionComponent syncFunctionComponent3 = new SyncFunctionComponent("get", anyTypeArr24, returnType31, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Property$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).getModificationTime();
                }
            });
            syncFunctionComponent3.setOwnerType(propertyComponentBuilderWithThis3.getThisType());
            syncFunctionComponent3.setCanTakeOwner(true);
            propertyComponentBuilderWithThis3.setGetter(syncFunctionComponent3);
            classComponentBuilder2.getProperties().put("lastModified", propertyComponentBuilderWithThis3);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis4 = new PropertyComponentBuilderWithThis(classComponentBuilder2.getOwnerType().getTypeDescriptor(), "creationTime");
            AnyType[] anyTypeArr25 = {new AnyType(propertyComponentBuilderWithThis4.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider17 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType33 = returnTypeProvider17.getTypes().get(Long.class);
            if (returnType33 == null) {
                JSTypeConverter<?> directConverter17 = ReturnTypeKt.getDirectConverter(Long.class);
                if (directConverter17 == null) {
                    directConverter17 = ReturnTypeKt.getIndirectConverter(Long.class, null);
                }
                ReturnType returnType34 = new ReturnType(directConverter17);
                returnTypeProvider17.getTypes().put(Long.class, returnType34);
                returnType33 = returnType34;
            }
            SyncFunctionComponent syncFunctionComponent4 = new SyncFunctionComponent("get", anyTypeArr25, returnType33, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Property$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).getCreationTime();
                }
            });
            syncFunctionComponent4.setOwnerType(propertyComponentBuilderWithThis4.getThisType());
            syncFunctionComponent4.setCanTakeOwner(true);
            propertyComponentBuilderWithThis4.setGetter(syncFunctionComponent4);
            classComponentBuilder2.getProperties().put("creationTime", propertyComponentBuilderWithThis4);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction9 = classComponentBuilder2.AsyncFunction("copy");
            String name9 = asyncFunctionBuilderAsyncFunction9.getName();
            TypeConverterProvider converters20 = asyncFunctionBuilderAsyncFunction9.getConverters();
            AnyType[] anyTypeArr26 = new AnyType[3];
            AnyType anyType37 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType37 == null) {
                try {
                    Result.Companion companion61 = Result.INSTANCE;
                    objM12684constructorimpl31 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$14
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th32) {
                    Result.Companion companion62 = Result.INSTANCE;
                    objM12684constructorimpl31 = Result.m12684constructorimpl(ResultKt.createFailure(th32));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl31)) {
                    objM12684constructorimpl31 = null;
                }
                TypeDescriptor typeDescriptor31 = (TypeDescriptor) objM12684constructorimpl31;
                if (typeDescriptor31 == null) {
                    typeDescriptor31 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType37 = new AnyType(typeDescriptor31, converters20);
            }
            anyTypeArr26[0] = anyType37;
            AnyType anyType38 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType38 == null) {
                try {
                    Result.Companion companion63 = Result.INSTANCE;
                    objM12684constructorimpl32 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemPath.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$15
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemPath.class);
                        }
                    }));
                } catch (Throwable th33) {
                    Result.Companion companion64 = Result.INSTANCE;
                    objM12684constructorimpl32 = Result.m12684constructorimpl(ResultKt.createFailure(th33));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl32)) {
                    objM12684constructorimpl32 = null;
                }
                TypeDescriptor typeDescriptor32 = (TypeDescriptor) objM12684constructorimpl32;
                if (typeDescriptor32 == null) {
                    typeDescriptor32 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemPath.class));
                }
                anyType38 = new AnyType(typeDescriptor32, converters20);
            }
            anyTypeArr26[1] = anyType38;
            AnyType anyType39 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RelocationOptions.class), true));
            if (anyType39 == null) {
                try {
                    Result.Companion companion65 = Result.INSTANCE;
                    objM12684constructorimpl33 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RelocationOptions.class, true, RelocationOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$16
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(RelocationOptions.class);
                        }
                    }));
                } catch (Throwable th34) {
                    Result.Companion companion66 = Result.INSTANCE;
                    objM12684constructorimpl33 = Result.m12684constructorimpl(ResultKt.createFailure(th34));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl33)) {
                    objM12684constructorimpl33 = null;
                }
                TypeDescriptor typeDescriptor33 = (TypeDescriptor) objM12684constructorimpl33;
                if (typeDescriptor33 == null) {
                    typeDescriptor33 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(RelocationOptions.class));
                }
                anyType39 = new AnyType(typeDescriptor33, converters20);
            }
            anyTypeArr26[2] = anyType39;
            asyncFunctionBuilderAsyncFunction9.setAsyncFunctionComponent(new SuspendFunctionComponent(name9, anyTypeArr26, new FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$17(null)));
            ClassComponentBuilder classComponentBuilder11 = classComponentBuilder2;
            TypeConverterProvider converters21 = classComponentBuilder11.getConverters();
            AnyType[] anyTypeArr27 = new AnyType[3];
            AnyType anyType40 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType40 == null) {
                try {
                    Result.Companion companion67 = Result.INSTANCE;
                    objM12684constructorimpl34 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$21
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th35) {
                    Result.Companion companion68 = Result.INSTANCE;
                    objM12684constructorimpl34 = Result.m12684constructorimpl(ResultKt.createFailure(th35));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl34)) {
                    objM12684constructorimpl34 = null;
                }
                TypeDescriptor typeDescriptor34 = (TypeDescriptor) objM12684constructorimpl34;
                if (typeDescriptor34 == null) {
                    typeDescriptor34 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType40 = new AnyType(typeDescriptor34, converters21);
            }
            anyTypeArr27[0] = anyType40;
            AnyType anyType41 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType41 == null) {
                try {
                    Result.Companion companion69 = Result.INSTANCE;
                    objM12684constructorimpl35 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemPath.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$22
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemPath.class);
                        }
                    }));
                } catch (Throwable th36) {
                    Result.Companion companion70 = Result.INSTANCE;
                    objM12684constructorimpl35 = Result.m12684constructorimpl(ResultKt.createFailure(th36));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl35)) {
                    objM12684constructorimpl35 = null;
                }
                TypeDescriptor typeDescriptor35 = (TypeDescriptor) objM12684constructorimpl35;
                if (typeDescriptor35 == null) {
                    typeDescriptor35 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemPath.class));
                }
                anyType41 = new AnyType(typeDescriptor35, converters21);
            }
            anyTypeArr27[1] = anyType41;
            AnyType anyType42 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RelocationOptions.class), true));
            if (anyType42 == null) {
                try {
                    Result.Companion companion71 = Result.INSTANCE;
                    objM12684constructorimpl36 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RelocationOptions.class, true, RelocationOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$23
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(RelocationOptions.class);
                        }
                    }));
                } catch (Throwable th37) {
                    Result.Companion companion72 = Result.INSTANCE;
                    objM12684constructorimpl36 = Result.m12684constructorimpl(ResultKt.createFailure(th37));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl36)) {
                    objM12684constructorimpl36 = null;
                }
                TypeDescriptor typeDescriptor36 = (TypeDescriptor) objM12684constructorimpl36;
                if (typeDescriptor36 == null) {
                    typeDescriptor36 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(RelocationOptions.class));
                }
                anyType42 = new AnyType(typeDescriptor36, converters21);
            }
            anyTypeArr27[2] = anyType42;
            ReturnTypeProvider returnTypeProvider18 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType35 = returnTypeProvider18.getTypes().get(Unit.class);
            if (returnType35 == null) {
                JSTypeConverter<?> directConverter18 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter18 == null) {
                    directConverter18 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType36 = new ReturnType(directConverter18);
                returnTypeProvider18.getTypes().put(Unit.class, returnType36);
                returnType35 = returnType36;
            }
            classComponentBuilder11.getSyncFunctions().put("copySync", new SyncFunctionComponent("copySync", anyTypeArr27, returnType35, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$24
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InterruptedException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    FileSystemFile fileSystemFile = (FileSystemFile) obj;
                    BuildersKt__BuildersKt.runBlocking$default(null, new FileSystemModule$definition$1$12$20$1(fileSystemFile, (FileSystemPath) objArr[1], (RelocationOptions) objArr[2], null), 1, null);
                    return Unit.INSTANCE;
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction10 = classComponentBuilder2.AsyncFunction("move");
            String name10 = asyncFunctionBuilderAsyncFunction10.getName();
            TypeConverterProvider converters22 = asyncFunctionBuilderAsyncFunction10.getConverters();
            AnyType[] anyTypeArr28 = new AnyType[3];
            AnyType anyType43 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType43 == null) {
                try {
                    Result.Companion companion73 = Result.INSTANCE;
                    objM12684constructorimpl37 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$18
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th38) {
                    Result.Companion companion74 = Result.INSTANCE;
                    objM12684constructorimpl37 = Result.m12684constructorimpl(ResultKt.createFailure(th38));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl37)) {
                    objM12684constructorimpl37 = null;
                }
                TypeDescriptor typeDescriptor37 = (TypeDescriptor) objM12684constructorimpl37;
                if (typeDescriptor37 == null) {
                    typeDescriptor37 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType43 = new AnyType(typeDescriptor37, converters22);
            }
            anyTypeArr28[0] = anyType43;
            AnyType anyType44 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType44 == null) {
                try {
                    Result.Companion companion75 = Result.INSTANCE;
                    objM12684constructorimpl38 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemPath.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$19
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemPath.class);
                        }
                    }));
                } catch (Throwable th39) {
                    Result.Companion companion76 = Result.INSTANCE;
                    objM12684constructorimpl38 = Result.m12684constructorimpl(ResultKt.createFailure(th39));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl38)) {
                    objM12684constructorimpl38 = null;
                }
                TypeDescriptor typeDescriptor38 = (TypeDescriptor) objM12684constructorimpl38;
                if (typeDescriptor38 == null) {
                    typeDescriptor38 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemPath.class));
                }
                anyType44 = new AnyType(typeDescriptor38, converters22);
            }
            anyTypeArr28[1] = anyType44;
            AnyType anyType45 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RelocationOptions.class), true));
            if (anyType45 == null) {
                try {
                    Result.Companion companion77 = Result.INSTANCE;
                    objM12684constructorimpl39 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RelocationOptions.class, true, RelocationOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$20
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(RelocationOptions.class);
                        }
                    }));
                } catch (Throwable th40) {
                    Result.Companion companion78 = Result.INSTANCE;
                    objM12684constructorimpl39 = Result.m12684constructorimpl(ResultKt.createFailure(th40));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl39)) {
                    objM12684constructorimpl39 = null;
                }
                TypeDescriptor typeDescriptor39 = (TypeDescriptor) objM12684constructorimpl39;
                if (typeDescriptor39 == null) {
                    typeDescriptor39 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(RelocationOptions.class));
                }
                anyType45 = new AnyType(typeDescriptor39, converters22);
            }
            anyTypeArr28[2] = anyType45;
            asyncFunctionBuilderAsyncFunction10.setAsyncFunctionComponent(new SuspendFunctionComponent(name10, anyTypeArr28, new FileSystemModule$definition$lambda$87$lambda$45$$inlined$Coroutine$21(null)));
            ClassComponentBuilder classComponentBuilder12 = classComponentBuilder2;
            TypeConverterProvider converters23 = classComponentBuilder12.getConverters();
            AnyType[] anyTypeArr29 = new AnyType[3];
            AnyType anyType46 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType46 == null) {
                try {
                    Result.Companion companion79 = Result.INSTANCE;
                    objM12684constructorimpl40 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$25
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th41) {
                    Result.Companion companion80 = Result.INSTANCE;
                    objM12684constructorimpl40 = Result.m12684constructorimpl(ResultKt.createFailure(th41));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl40)) {
                    objM12684constructorimpl40 = null;
                }
                TypeDescriptor typeDescriptor40 = (TypeDescriptor) objM12684constructorimpl40;
                if (typeDescriptor40 == null) {
                    typeDescriptor40 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType46 = new AnyType(typeDescriptor40, converters23);
            }
            anyTypeArr29[0] = anyType46;
            AnyType anyType47 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType47 == null) {
                try {
                    Result.Companion companion81 = Result.INSTANCE;
                    objM12684constructorimpl41 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemPath.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$26
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemPath.class);
                        }
                    }));
                } catch (Throwable th42) {
                    Result.Companion companion82 = Result.INSTANCE;
                    objM12684constructorimpl41 = Result.m12684constructorimpl(ResultKt.createFailure(th42));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl41)) {
                    objM12684constructorimpl41 = null;
                }
                TypeDescriptor typeDescriptor41 = (TypeDescriptor) objM12684constructorimpl41;
                if (typeDescriptor41 == null) {
                    typeDescriptor41 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemPath.class));
                }
                anyType47 = new AnyType(typeDescriptor41, converters23);
            }
            anyTypeArr29[1] = anyType47;
            AnyType anyType48 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RelocationOptions.class), true));
            if (anyType48 == null) {
                try {
                    Result.Companion companion83 = Result.INSTANCE;
                    objM12684constructorimpl42 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RelocationOptions.class, true, RelocationOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$27
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(RelocationOptions.class);
                        }
                    }));
                } catch (Throwable th43) {
                    Result.Companion companion84 = Result.INSTANCE;
                    objM12684constructorimpl42 = Result.m12684constructorimpl(ResultKt.createFailure(th43));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl42)) {
                    objM12684constructorimpl42 = null;
                }
                TypeDescriptor typeDescriptor42 = (TypeDescriptor) objM12684constructorimpl42;
                if (typeDescriptor42 == null) {
                    typeDescriptor42 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(RelocationOptions.class));
                }
                anyType48 = new AnyType(typeDescriptor42, converters23);
            }
            anyTypeArr29[2] = anyType48;
            ReturnTypeProvider returnTypeProvider19 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType37 = returnTypeProvider19.getTypes().get(Unit.class);
            if (returnType37 == null) {
                JSTypeConverter<?> directConverter19 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter19 == null) {
                    directConverter19 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType38 = new ReturnType(directConverter19);
                returnTypeProvider19.getTypes().put(Unit.class, returnType38);
                returnType37 = returnType38;
            }
            classComponentBuilder12.getSyncFunctions().put("moveSync", new SyncFunctionComponent("moveSync", anyTypeArr29, returnType37, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$28
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InterruptedException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    FileSystemFile fileSystemFile = (FileSystemFile) obj;
                    BuildersKt__BuildersKt.runBlocking$default(null, new FileSystemModule$definition$1$12$22$1(fileSystemFile, (FileSystemPath) objArr[1], (RelocationOptions) objArr[2], null), 1, null);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder13 = classComponentBuilder2;
            TypeConverterProvider converters24 = classComponentBuilder13.getConverters();
            AnyType[] anyTypeArr30 = new AnyType[2];
            AnyType anyType49 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType49 == null) {
                try {
                    Result.Companion companion85 = Result.INSTANCE;
                    objM12684constructorimpl43 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$29
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th44) {
                    Result.Companion companion86 = Result.INSTANCE;
                    objM12684constructorimpl43 = Result.m12684constructorimpl(ResultKt.createFailure(th44));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl43)) {
                    objM12684constructorimpl43 = null;
                }
                TypeDescriptor typeDescriptor43 = (TypeDescriptor) objM12684constructorimpl43;
                if (typeDescriptor43 == null) {
                    typeDescriptor43 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType49 = new AnyType(typeDescriptor43, converters24);
            }
            anyTypeArr30[0] = anyType49;
            AnyType anyType50 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType50 == null) {
                try {
                    Result.Companion companion87 = Result.INSTANCE;
                    objM12684constructorimpl44 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$30
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th45) {
                    Result.Companion companion88 = Result.INSTANCE;
                    objM12684constructorimpl44 = Result.m12684constructorimpl(ResultKt.createFailure(th45));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl44)) {
                    objM12684constructorimpl44 = null;
                }
                TypeDescriptor typeDescriptor44 = (TypeDescriptor) objM12684constructorimpl44;
                if (typeDescriptor44 == null) {
                    typeDescriptor44 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType50 = new AnyType(typeDescriptor44, converters24);
            }
            anyTypeArr30[1] = anyType50;
            ReturnTypeProvider returnTypeProvider20 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType39 = returnTypeProvider20.getTypes().get(Unit.class);
            if (returnType39 == null) {
                JSTypeConverter<?> directConverter20 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter20 == null) {
                    directConverter20 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType40 = new ReturnType(directConverter20);
                returnTypeProvider20.getTypes().put(Unit.class, returnType40);
                returnType39 = returnType40;
            }
            classComponentBuilder13.getSyncFunctions().put("rename", new SyncFunctionComponent("rename", anyTypeArr30, returnType39, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$31
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemFile) objArr[0]).rename((String) objArr[1]);
                    return Unit.INSTANCE;
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis5 = new PropertyComponentBuilderWithThis(classComponentBuilder2.getOwnerType().getTypeDescriptor(), "uri");
            AnyType[] anyTypeArr31 = {new AnyType(propertyComponentBuilderWithThis5.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider21 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType41 = returnTypeProvider21.getTypes().get(String.class);
            if (returnType41 == null) {
                JSTypeConverter<?> directConverter21 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter21 == null) {
                    directConverter21 = ReturnTypeKt.getIndirectConverter(String.class, null);
                }
                ReturnType returnType42 = new ReturnType(directConverter21);
                returnTypeProvider21.getTypes().put(String.class, returnType42);
                returnType41 = returnType42;
            }
            SyncFunctionComponent syncFunctionComponent5 = new SyncFunctionComponent("get", anyTypeArr31, returnType41, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Property$5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).asString();
                }
            });
            syncFunctionComponent5.setOwnerType(propertyComponentBuilderWithThis5.getThisType());
            syncFunctionComponent5.setCanTakeOwner(true);
            propertyComponentBuilderWithThis5.setGetter(syncFunctionComponent5);
            classComponentBuilder2.getProperties().put("uri", propertyComponentBuilderWithThis5);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis6 = new PropertyComponentBuilderWithThis(classComponentBuilder2.getOwnerType().getTypeDescriptor(), "contentUri");
            AnyType[] anyTypeArr32 = {new AnyType(propertyComponentBuilderWithThis6.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider22 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType43 = returnTypeProvider22.getTypes().get(Uri.class);
            if (returnType43 == null) {
                JSTypeConverter<?> directConverter22 = ReturnTypeKt.getDirectConverter(Uri.class);
                if (directConverter22 == null) {
                    directConverter22 = ReturnTypeKt.getIndirectConverter(Uri.class, null);
                }
                ReturnType returnType44 = new ReturnType(directConverter22);
                returnTypeProvider22.getTypes().put(Uri.class, returnType44);
                returnType43 = returnType44;
            }
            SyncFunctionComponent syncFunctionComponent6 = new SyncFunctionComponent("get", anyTypeArr32, returnType43, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Property$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).asContentUri();
                }
            });
            syncFunctionComponent6.setOwnerType(propertyComponentBuilderWithThis6.getThisType());
            syncFunctionComponent6.setCanTakeOwner(true);
            propertyComponentBuilderWithThis6.setGetter(syncFunctionComponent6);
            classComponentBuilder2.getProperties().put("contentUri", propertyComponentBuilderWithThis6);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis7 = new PropertyComponentBuilderWithThis(classComponentBuilder2.getOwnerType().getTypeDescriptor(), "md5");
            AnyType[] anyTypeArr33 = {new AnyType(propertyComponentBuilderWithThis7.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider23 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType45 = returnTypeProvider23.getTypes().get(String.class);
            if (returnType45 == null) {
                JSTypeConverter<?> directConverter23 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter23 == null) {
                    directConverter23 = ReturnTypeKt.getIndirectConverter(String.class, null);
                }
                ReturnType returnType46 = new ReturnType(directConverter23);
                returnTypeProvider23.getTypes().put(String.class, returnType46);
                returnType45 = returnType46;
            }
            SyncFunctionComponent syncFunctionComponent7 = new SyncFunctionComponent("get", anyTypeArr33, returnType45, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Property$7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        return ((FileSystemFile) it[0]).getMd5();
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
            syncFunctionComponent7.setOwnerType(propertyComponentBuilderWithThis7.getThisType());
            syncFunctionComponent7.setCanTakeOwner(true);
            propertyComponentBuilderWithThis7.setGetter(syncFunctionComponent7);
            classComponentBuilder2.getProperties().put("md5", propertyComponentBuilderWithThis7);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis8 = new PropertyComponentBuilderWithThis(classComponentBuilder2.getOwnerType().getTypeDescriptor(), ContentDisposition.Parameters.Size);
            AnyType[] anyTypeArr34 = {new AnyType(propertyComponentBuilderWithThis8.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider24 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType47 = returnTypeProvider24.getTypes().get(Long.class);
            if (returnType47 == null) {
                JSTypeConverter<?> directConverter24 = ReturnTypeKt.getDirectConverter(Long.class);
                if (directConverter24 == null) {
                    directConverter24 = ReturnTypeKt.getIndirectConverter(Long.class, null);
                }
                ReturnType returnType48 = new ReturnType(directConverter24);
                returnTypeProvider24.getTypes().put(Long.class, returnType48);
                returnType47 = returnType48;
            }
            SyncFunctionComponent syncFunctionComponent8 = new SyncFunctionComponent("get", anyTypeArr34, returnType47, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Property$8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    long jLongValue = 0;
                    try {
                        Long size = ((FileSystemFile) it[0]).getSize();
                        if (size != null) {
                            jLongValue = size.longValue();
                        }
                    } catch (Exception unused) {
                    }
                    return Long.valueOf(jLongValue);
                }
            });
            syncFunctionComponent8.setOwnerType(propertyComponentBuilderWithThis8.getThisType());
            syncFunctionComponent8.setCanTakeOwner(true);
            propertyComponentBuilderWithThis8.setGetter(syncFunctionComponent8);
            classComponentBuilder2.getProperties().put(ContentDisposition.Parameters.Size, propertyComponentBuilderWithThis8);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis9 = new PropertyComponentBuilderWithThis(classComponentBuilder2.getOwnerType().getTypeDescriptor(), "type");
            AnyType[] anyTypeArr35 = {new AnyType(propertyComponentBuilderWithThis9.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider25 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType49 = returnTypeProvider25.getTypes().get(String.class);
            if (returnType49 == null) {
                JSTypeConverter<?> directConverter25 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter25 == null) {
                    directConverter25 = ReturnTypeKt.getIndirectConverter(String.class, null);
                }
                ReturnType returnType50 = new ReturnType(directConverter25);
                returnTypeProvider25.getTypes().put(String.class, returnType50);
                returnType49 = returnType50;
            }
            SyncFunctionComponent syncFunctionComponent9 = new SyncFunctionComponent("get", anyTypeArr35, returnType49, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Property$9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).getType();
                }
            });
            syncFunctionComponent9.setOwnerType(propertyComponentBuilderWithThis9.getThisType());
            syncFunctionComponent9.setCanTakeOwner(true);
            propertyComponentBuilderWithThis9.setGetter(syncFunctionComponent9);
            classComponentBuilder2.getProperties().put("type", propertyComponentBuilderWithThis9);
            ClassComponentBuilder classComponentBuilder14 = classComponentBuilder2;
            TypeConverterProvider converters25 = classComponentBuilder14.getConverters();
            AnyType[] anyTypeArr36 = new AnyType[2];
            AnyType anyType51 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType51 == null) {
                try {
                    Result.Companion companion89 = Result.INSTANCE;
                    objM12684constructorimpl45 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$32
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th46) {
                    Result.Companion companion90 = Result.INSTANCE;
                    objM12684constructorimpl45 = Result.m12684constructorimpl(ResultKt.createFailure(th46));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl45)) {
                    objM12684constructorimpl45 = null;
                }
                TypeDescriptor typeDescriptor45 = (TypeDescriptor) objM12684constructorimpl45;
                if (typeDescriptor45 == null) {
                    typeDescriptor45 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType51 = new AnyType(typeDescriptor45, converters25);
            }
            anyTypeArr36[0] = anyType51;
            AnyType anyType52 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileMode.class), true));
            if (anyType52 == null) {
                try {
                    Result.Companion companion91 = Result.INSTANCE;
                    objM12684constructorimpl46 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileMode.class, true, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$33
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(FileMode.class);
                        }
                    }));
                } catch (Throwable th47) {
                    Result.Companion companion92 = Result.INSTANCE;
                    objM12684constructorimpl46 = Result.m12684constructorimpl(ResultKt.createFailure(th47));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl46)) {
                    objM12684constructorimpl46 = null;
                }
                TypeDescriptor typeDescriptor46 = (TypeDescriptor) objM12684constructorimpl46;
                if (typeDescriptor46 == null) {
                    typeDescriptor46 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(FileMode.class));
                }
                anyType52 = new AnyType(typeDescriptor46, converters25);
            }
            anyTypeArr36[1] = anyType52;
            ReturnTypeProvider returnTypeProvider26 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType51 = returnTypeProvider26.getTypes().get(FileSystemFileHandle.class);
            if (returnType51 == null) {
                JSTypeConverter<?> directConverter26 = ReturnTypeKt.getDirectConverter(FileSystemFileHandle.class);
                if (directConverter26 == null) {
                    directConverter26 = ReturnTypeKt.getIndirectConverter(FileSystemFileHandle.class, null);
                }
                ReturnType returnType52 = new ReturnType(directConverter26);
                returnTypeProvider26.getTypes().put(FileSystemFileHandle.class, returnType52);
                returnType51 = returnType52;
            }
            classComponentBuilder14.getSyncFunctions().put("open", new SyncFunctionComponent("open", anyTypeArr36, returnType51, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$Function$34
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemFile) objArr[0]).openHandle((FileMode) objArr[1]);
                }
            }));
            ClassComponentBuilder classComponentBuilder15 = classComponentBuilder2;
            TypeConverterProvider converters26 = classComponentBuilder15.getConverters();
            AnyType[] anyTypeArr37 = new AnyType[2];
            AnyType anyType53 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType53 == null) {
                try {
                    Result.Companion companion93 = Result.INSTANCE;
                    objM12684constructorimpl47 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$AsyncFunction$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th48) {
                    Result.Companion companion94 = Result.INSTANCE;
                    objM12684constructorimpl47 = Result.m12684constructorimpl(ResultKt.createFailure(th48));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl47)) {
                    objM12684constructorimpl47 = null;
                }
                TypeDescriptor typeDescriptor47 = (TypeDescriptor) objM12684constructorimpl47;
                if (typeDescriptor47 == null) {
                    typeDescriptor47 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType53 = new AnyType(typeDescriptor47, converters26);
            }
            anyTypeArr37[0] = anyType53;
            AnyType anyType54 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FilePreviewOptions.class), true));
            if (anyType54 == null) {
                try {
                    Result.Companion companion95 = Result.INSTANCE;
                    objM12684constructorimpl48 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FilePreviewOptions.class, true, FilePreviewOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(FilePreviewOptions.class);
                        }
                    }));
                } catch (Throwable th49) {
                    Result.Companion companion96 = Result.INSTANCE;
                    objM12684constructorimpl48 = Result.m12684constructorimpl(ResultKt.createFailure(th49));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl48)) {
                    objM12684constructorimpl48 = null;
                }
                TypeDescriptor typeDescriptor48 = (TypeDescriptor) objM12684constructorimpl48;
                if (typeDescriptor48 == null) {
                    typeDescriptor48 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(FilePreviewOptions.class));
                }
                anyType54 = new AnyType(typeDescriptor48, converters26);
            }
            anyTypeArr37[1] = anyType54;
            Function1<Object[], Boolean> function1 = new Function1<Object[], Boolean>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] objArr) throws InvalidTypeFileException, MissingAppContextException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    boolean zCanHandle = false;
                    Object obj = objArr[0];
                    FilePreviewOptions filePreviewOptions = (FilePreviewOptions) objArr[1];
                    FileSystemFile fileSystemFile = (FileSystemFile) obj;
                    fileSystemFile.validateType();
                    if (fileSystemFile.getExists()) {
                        Uri uriAsContentUri = fileSystemFile.asContentUri();
                        String strResolvePreviewMimeType = this.this$0.resolvePreviewMimeType(fileSystemFile, filePreviewOptions != null ? filePreviewOptions.getMimeType() : null);
                        if (strResolvePreviewMimeType != null) {
                            FileSystemModule fileSystemModule2 = this.this$0;
                            zCanHandle = fileSystemModule2.canHandle(fileSystemModule2.createPreviewIntent(uriAsContentUri, strResolvePreviewMimeType));
                        }
                    }
                    return Boolean.valueOf(zCanHandle);
                }
            };
            if (Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                stringAsyncFunctionComponent = new IntAsyncFunctionComponent("canPreview", anyTypeArr37, function1);
            } else if (Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent = new BoolAsyncFunctionComponent("canPreview", anyTypeArr37, function1);
            } else if (Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                stringAsyncFunctionComponent = new DoubleAsyncFunctionComponent("canPreview", anyTypeArr37, function1);
            } else if (Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                stringAsyncFunctionComponent = new FloatAsyncFunctionComponent("canPreview", anyTypeArr37, function1);
            } else {
                stringAsyncFunctionComponent = Intrinsics.areEqual(Boolean.class, String.class) ? new StringAsyncFunctionComponent("canPreview", anyTypeArr37, function1) : new UntypedAsyncFunctionComponent("canPreview", anyTypeArr37, function1);
            }
            classComponentBuilder15.getAsyncFunctions().put("canPreview", stringAsyncFunctionComponent);
            ClassComponentBuilder classComponentBuilder16 = classComponentBuilder2;
            TypeConverterProvider converters27 = classComponentBuilder16.getConverters();
            AnyType[] anyTypeArr38 = new AnyType[2];
            AnyType anyType55 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType55 == null) {
                try {
                    Result.Companion companion97 = Result.INSTANCE;
                    objM12684constructorimpl49 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$AsyncFunction$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th50) {
                    Result.Companion companion98 = Result.INSTANCE;
                    objM12684constructorimpl49 = Result.m12684constructorimpl(ResultKt.createFailure(th50));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl49)) {
                    objM12684constructorimpl49 = null;
                }
                TypeDescriptor typeDescriptor49 = (TypeDescriptor) objM12684constructorimpl49;
                if (typeDescriptor49 == null) {
                    typeDescriptor49 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType55 = new AnyType(typeDescriptor49, converters27);
            }
            anyTypeArr38[0] = anyType55;
            AnyType anyType56 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FilePreviewOptions.class), true));
            if (anyType56 == null) {
                try {
                    Result.Companion companion99 = Result.INSTANCE;
                    objM12684constructorimpl50 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FilePreviewOptions.class, true, FilePreviewOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(FilePreviewOptions.class);
                        }
                    }));
                } catch (Throwable th51) {
                    Result.Companion companion100 = Result.INSTANCE;
                    objM12684constructorimpl50 = Result.m12684constructorimpl(ResultKt.createFailure(th51));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl50)) {
                    objM12684constructorimpl50 = null;
                }
                TypeDescriptor typeDescriptor50 = (TypeDescriptor) objM12684constructorimpl50;
                if (typeDescriptor50 == null) {
                    typeDescriptor50 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(FilePreviewOptions.class));
                }
                anyType56 = new AnyType(typeDescriptor50, converters27);
            }
            anyTypeArr38[1] = anyType56;
            Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$45$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws InvalidTypeFileException, MissingAppContextException, FilePreviewUnsupportedException, FilePreviewFileNotFoundException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    FilePreviewOptions filePreviewOptions = (FilePreviewOptions) objArr[1];
                    FileSystemFile fileSystemFile = (FileSystemFile) obj;
                    fileSystemFile.validateType();
                    if (!fileSystemFile.getExists()) {
                        throw new FilePreviewFileNotFoundException(fileSystemFile.getUri());
                    }
                    Uri uriAsContentUri = fileSystemFile.asContentUri();
                    String strResolvePreviewMimeType = this.this$0.resolvePreviewMimeType(fileSystemFile, filePreviewOptions != null ? filePreviewOptions.getMimeType() : null);
                    if (strResolvePreviewMimeType != null) {
                        Intent intentCreatePreviewIntent = this.this$0.createPreviewIntent(uriAsContentUri, strResolvePreviewMimeType);
                        if (this.this$0.canHandle(intentCreatePreviewIntent)) {
                            this.this$0.grantReadPermissions(intentCreatePreviewIntent, uriAsContentUri);
                            try {
                                this.this$0.getAppContext().getThrowingActivity().startActivity(intentCreatePreviewIntent);
                                return Unit.INSTANCE;
                            } catch (ActivityNotFoundException e) {
                                throw new FilePreviewUnsupportedException(strResolvePreviewMimeType, e);
                            }
                        }
                        throw new FilePreviewUnsupportedException(strResolvePreviewMimeType, null, 2, null);
                    }
                    throw new FilePreviewUnsupportedException(null, null, 2, null);
                }
            };
            if (Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                stringAsyncFunctionComponent2 = new IntAsyncFunctionComponent("preview", anyTypeArr38, function2);
            } else if (Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("preview", anyTypeArr38, function2);
            } else if (Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                stringAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("preview", anyTypeArr38, function2);
            } else if (Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                stringAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("preview", anyTypeArr38, function2);
            } else {
                stringAsyncFunctionComponent2 = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("preview", anyTypeArr38, function2) : new UntypedAsyncFunctionComponent("preview", anyTypeArr38, function2);
            }
            classComponentBuilder16.getAsyncFunctions().put("preview", stringAsyncFunctionComponent2);
            moduleDefinitionBuilder6.getClassData().add(classComponentBuilder2.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class);
            Module module2 = moduleDefinitionBuilder7.getModule();
            if (module2 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext2 = module2.getAppContext();
            String simpleName2 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass2).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
            AnyType anyType57 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false));
            if (anyType57 != null) {
                anyType2 = anyType57;
            } else {
                try {
                    Result.Companion companion101 = Result.INSTANCE;
                    objM12684constructorimpl51 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFileHandle.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Class$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFileHandle.class);
                        }
                    }));
                } catch (Throwable th52) {
                    Result.Companion companion102 = Result.INSTANCE;
                    objM12684constructorimpl51 = Result.m12684constructorimpl(ResultKt.createFailure(th52));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl51)) {
                    objM12684constructorimpl51 = null;
                }
                TypeDescriptor typeDescriptor51 = (TypeDescriptor) objM12684constructorimpl51;
                if (typeDescriptor51 == null) {
                    typeDescriptor51 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFileHandle.class));
                }
                anyType2 = new AnyType(typeDescriptor51, null);
            }
            ClassComponentBuilder classComponentBuilder17 = new ClassComponentBuilder(appContext2, simpleName2, orCreateKotlinClass2, anyType2, moduleDefinitionBuilder7.getConverters());
            TypeConverterProvider converters28 = classComponentBuilder17.getConverters();
            AnyType[] anyTypeArr39 = new AnyType[2];
            AnyType anyType58 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType58 == null) {
                try {
                    Result.Companion companion103 = Result.INSTANCE;
                    objM12684constructorimpl52 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Constructor$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th53) {
                    Result.Companion companion104 = Result.INSTANCE;
                    objM12684constructorimpl52 = Result.m12684constructorimpl(ResultKt.createFailure(th53));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl52)) {
                    objM12684constructorimpl52 = null;
                }
                TypeDescriptor typeDescriptor52 = (TypeDescriptor) objM12684constructorimpl52;
                if (typeDescriptor52 == null) {
                    typeDescriptor52 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType58 = new AnyType(typeDescriptor52, converters28);
            }
            anyTypeArr39[0] = anyType58;
            AnyType anyType59 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileMode.class), true));
            if (anyType59 == null) {
                try {
                    Result.Companion companion105 = Result.INSTANCE;
                    objM12684constructorimpl53 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileMode.class, true, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Constructor$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(FileMode.class);
                        }
                    }));
                } catch (Throwable th54) {
                    Result.Companion companion106 = Result.INSTANCE;
                    objM12684constructorimpl53 = Result.m12684constructorimpl(ResultKt.createFailure(th54));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl53)) {
                    objM12684constructorimpl53 = null;
                }
                TypeDescriptor typeDescriptor53 = (TypeDescriptor) objM12684constructorimpl53;
                if (typeDescriptor53 == null) {
                    typeDescriptor53 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(FileMode.class));
                }
                anyType59 = new AnyType(typeDescriptor53, converters28);
            }
            anyTypeArr39[1] = anyType59;
            ReturnTypeProvider returnTypeProvider27 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType53 = returnTypeProvider27.getTypes().get(Object.class);
            if (returnType53 == null) {
                JSTypeConverter<?> directConverter27 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter27 == null) {
                    directConverter27 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType54 = new ReturnType(directConverter27);
                returnTypeProvider27.getTypes().put(Object.class, returnType54);
                returnType53 = returnType54;
            }
            classComponentBuilder17.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr39, returnType53, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Constructor$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemFile) objArr[0]).openHandle((FileMode) objArr[1]);
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction11 = classComponentBuilder17.AsyncFunction("readBytes");
            String name11 = asyncFunctionBuilderAsyncFunction11.getName();
            TypeConverterProvider converters29 = asyncFunctionBuilderAsyncFunction11.getConverters();
            AnyType[] anyTypeArr40 = new AnyType[2];
            AnyType anyType60 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false));
            if (anyType60 == null) {
                try {
                    Result.Companion companion107 = Result.INSTANCE;
                    objM12684constructorimpl54 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFileHandle.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFileHandle.class);
                        }
                    }));
                } catch (Throwable th55) {
                    Result.Companion companion108 = Result.INSTANCE;
                    objM12684constructorimpl54 = Result.m12684constructorimpl(ResultKt.createFailure(th55));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl54)) {
                    objM12684constructorimpl54 = null;
                }
                TypeDescriptor typeDescriptor54 = (TypeDescriptor) objM12684constructorimpl54;
                if (typeDescriptor54 == null) {
                    typeDescriptor54 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFileHandle.class));
                }
                anyType60 = new AnyType(typeDescriptor54, converters29);
            }
            anyTypeArr40[0] = anyType60;
            AnyType anyType61 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Long.class), false));
            if (anyType61 == null) {
                try {
                    Result.Companion companion109 = Result.INSTANCE;
                    objM12684constructorimpl55 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.LONG), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Coroutine$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Long.TYPE);
                        }
                    }));
                } catch (Throwable th56) {
                    Result.Companion companion110 = Result.INSTANCE;
                    objM12684constructorimpl55 = Result.m12684constructorimpl(ResultKt.createFailure(th56));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl55)) {
                    objM12684constructorimpl55 = null;
                }
                TypeDescriptor typeDescriptor55 = (TypeDescriptor) objM12684constructorimpl55;
                if (typeDescriptor55 == null) {
                    typeDescriptor55 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Long.TYPE));
                }
                anyType61 = new AnyType(typeDescriptor55, converters29);
            }
            anyTypeArr40[1] = anyType61;
            asyncFunctionBuilderAsyncFunction11.setAsyncFunctionComponent(new SuspendFunctionComponent(name11, anyTypeArr40, new FileSystemModule$definition$lambda$87$lambda$55$$inlined$Coroutine$3(null)));
            ClassComponentBuilder classComponentBuilder18 = classComponentBuilder17;
            TypeConverterProvider converters30 = classComponentBuilder18.getConverters();
            AnyType[] anyTypeArr41 = new AnyType[2];
            AnyType anyType62 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false));
            if (anyType62 == null) {
                try {
                    Result.Companion companion111 = Result.INSTANCE;
                    objM12684constructorimpl56 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFileHandle.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFileHandle.class);
                        }
                    }));
                } catch (Throwable th57) {
                    Result.Companion companion112 = Result.INSTANCE;
                    objM12684constructorimpl56 = Result.m12684constructorimpl(ResultKt.createFailure(th57));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl56)) {
                    objM12684constructorimpl56 = null;
                }
                TypeDescriptor typeDescriptor56 = (TypeDescriptor) objM12684constructorimpl56;
                if (typeDescriptor56 == null) {
                    typeDescriptor56 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFileHandle.class));
                }
                anyType62 = new AnyType(typeDescriptor56, converters30);
            }
            anyTypeArr41[0] = anyType62;
            AnyType anyType63 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Long.class), false));
            if (anyType63 == null) {
                try {
                    Result.Companion companion113 = Result.INSTANCE;
                    objM12684constructorimpl57 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.LONG), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Function$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Long.TYPE);
                        }
                    }));
                } catch (Throwable th58) {
                    Result.Companion companion114 = Result.INSTANCE;
                    objM12684constructorimpl57 = Result.m12684constructorimpl(ResultKt.createFailure(th58));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl57)) {
                    objM12684constructorimpl57 = null;
                }
                TypeDescriptor typeDescriptor57 = (TypeDescriptor) objM12684constructorimpl57;
                if (typeDescriptor57 == null) {
                    typeDescriptor57 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Long.TYPE));
                }
                anyType63 = new AnyType(typeDescriptor57, converters30);
            }
            anyTypeArr41[1] = anyType63;
            ReturnTypeProvider returnTypeProvider28 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType55 = returnTypeProvider28.getTypes().get(byte[].class);
            if (returnType55 == null) {
                JSTypeConverter<?> directConverter28 = ReturnTypeKt.getDirectConverter(byte[].class);
                if (directConverter28 == null) {
                    directConverter28 = ReturnTypeKt.getIndirectConverter(byte[].class, null);
                }
                ReturnType returnType56 = new ReturnType(directConverter28);
                returnTypeProvider28.getTypes().put(byte[].class, returnType56);
                returnType55 = returnType56;
            }
            classComponentBuilder18.getSyncFunctions().put("readBytesSync", new SyncFunctionComponent("readBytesSync", anyTypeArr41, returnType55, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemFileHandle) objArr[0]).read(((Number) objArr[1]).longValue());
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction12 = classComponentBuilder17.AsyncFunction("writeBytes");
            String name12 = asyncFunctionBuilderAsyncFunction12.getName();
            TypeConverterProvider converters31 = asyncFunctionBuilderAsyncFunction12.getConverters();
            AnyType[] anyTypeArr42 = new AnyType[2];
            AnyType anyType64 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false));
            if (anyType64 == null) {
                try {
                    Result.Companion companion115 = Result.INSTANCE;
                    objM12684constructorimpl58 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFileHandle.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Coroutine$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFileHandle.class);
                        }
                    }));
                } catch (Throwable th59) {
                    Result.Companion companion116 = Result.INSTANCE;
                    objM12684constructorimpl58 = Result.m12684constructorimpl(ResultKt.createFailure(th59));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl58)) {
                    objM12684constructorimpl58 = null;
                }
                TypeDescriptor typeDescriptor58 = (TypeDescriptor) objM12684constructorimpl58;
                if (typeDescriptor58 == null) {
                    typeDescriptor58 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFileHandle.class));
                }
                anyType64 = new AnyType(typeDescriptor58, converters31);
            }
            anyTypeArr42[0] = anyType64;
            AnyType anyType65 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(byte[].class), false));
            if (anyType65 == null) {
                try {
                    Result.Companion companion117 = Result.INSTANCE;
                    objM12684constructorimpl59 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Coroutine$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(byte[].class);
                        }
                    }));
                } catch (Throwable th60) {
                    Result.Companion companion118 = Result.INSTANCE;
                    objM12684constructorimpl59 = Result.m12684constructorimpl(ResultKt.createFailure(th60));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl59)) {
                    objM12684constructorimpl59 = null;
                }
                TypeDescriptor typeDescriptor59 = (TypeDescriptor) objM12684constructorimpl59;
                if (typeDescriptor59 == null) {
                    typeDescriptor59 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(byte[].class));
                }
                anyType65 = new AnyType(typeDescriptor59, converters31);
            }
            anyTypeArr42[1] = anyType65;
            asyncFunctionBuilderAsyncFunction12.setAsyncFunctionComponent(new SuspendFunctionComponent(name12, anyTypeArr42, new FileSystemModule$definition$lambda$87$lambda$55$$inlined$Coroutine$6(null)));
            ClassComponentBuilder classComponentBuilder19 = classComponentBuilder17;
            TypeConverterProvider converters32 = classComponentBuilder19.getConverters();
            AnyType[] anyTypeArr43 = new AnyType[2];
            AnyType anyType66 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false));
            if (anyType66 == null) {
                try {
                    Result.Companion companion119 = Result.INSTANCE;
                    objM12684constructorimpl60 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFileHandle.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Function$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFileHandle.class);
                        }
                    }));
                } catch (Throwable th61) {
                    Result.Companion companion120 = Result.INSTANCE;
                    objM12684constructorimpl60 = Result.m12684constructorimpl(ResultKt.createFailure(th61));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl60)) {
                    objM12684constructorimpl60 = null;
                }
                TypeDescriptor typeDescriptor60 = (TypeDescriptor) objM12684constructorimpl60;
                if (typeDescriptor60 == null) {
                    typeDescriptor60 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFileHandle.class));
                }
                anyType66 = new AnyType(typeDescriptor60, converters32);
            }
            anyTypeArr43[0] = anyType66;
            AnyType anyType67 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(byte[].class), false));
            if (anyType67 == null) {
                try {
                    Result.Companion companion121 = Result.INSTANCE;
                    objM12684constructorimpl61 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(byte[].class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Function$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(byte[].class);
                        }
                    }));
                } catch (Throwable th62) {
                    Result.Companion companion122 = Result.INSTANCE;
                    objM12684constructorimpl61 = Result.m12684constructorimpl(ResultKt.createFailure(th62));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl61)) {
                    objM12684constructorimpl61 = null;
                }
                TypeDescriptor typeDescriptor61 = (TypeDescriptor) objM12684constructorimpl61;
                if (typeDescriptor61 == null) {
                    typeDescriptor61 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(byte[].class));
                }
                anyType67 = new AnyType(typeDescriptor61, converters32);
            }
            anyTypeArr43[1] = anyType67;
            ReturnTypeProvider returnTypeProvider29 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType57 = returnTypeProvider29.getTypes().get(Unit.class);
            if (returnType57 == null) {
                JSTypeConverter<?> directConverter29 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter29 == null) {
                    directConverter29 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType58 = new ReturnType(directConverter29);
                returnTypeProvider29.getTypes().put(Unit.class, returnType58);
                returnType57 = returnType58;
            }
            classComponentBuilder19.getSyncFunctions().put("writeBytesSync", new SyncFunctionComponent("writeBytesSync", anyTypeArr43, returnType57, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Function$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemFileHandle) objArr[0]).write((byte[]) objArr[1]);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder20 = classComponentBuilder17;
            TypeConverterProvider converters33 = classComponentBuilder20.getConverters();
            AnyType[] anyTypeArr44 = new AnyType[1];
            AnyType anyType68 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false));
            if (anyType68 == null) {
                try {
                    Result.Companion companion123 = Result.INSTANCE;
                    objM12684constructorimpl62 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFileHandle.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Function$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFileHandle.class);
                        }
                    }));
                } catch (Throwable th63) {
                    Result.Companion companion124 = Result.INSTANCE;
                    objM12684constructorimpl62 = Result.m12684constructorimpl(ResultKt.createFailure(th63));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl62)) {
                    objM12684constructorimpl62 = null;
                }
                TypeDescriptor typeDescriptor62 = (TypeDescriptor) objM12684constructorimpl62;
                if (typeDescriptor62 == null) {
                    typeDescriptor62 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFileHandle.class));
                }
                anyType68 = new AnyType(typeDescriptor62, converters33);
            }
            anyTypeArr44[0] = anyType68;
            ReturnTypeProvider returnTypeProvider30 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType59 = returnTypeProvider30.getTypes().get(Unit.class);
            if (returnType59 == null) {
                JSTypeConverter<?> directConverter30 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter30 == null) {
                    directConverter30 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType60 = new ReturnType(directConverter30);
                returnTypeProvider30.getTypes().put(Unit.class, returnType60);
                returnType59 = returnType60;
            }
            classComponentBuilder20.getSyncFunctions().put("close", new SyncFunctionComponent("close", anyTypeArr44, returnType59, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Function$8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemFileHandle) objArr[0]).close();
                    return Unit.INSTANCE;
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis10 = new PropertyComponentBuilderWithThis(classComponentBuilder17.getOwnerType().getTypeDescriptor(), "offset");
            AnyType[] anyTypeArr45 = {new AnyType(propertyComponentBuilderWithThis10.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider31 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType61 = returnTypeProvider31.getTypes().get(Long.class);
            if (returnType61 == null) {
                JSTypeConverter<?> directConverter31 = ReturnTypeKt.getDirectConverter(Long.class);
                if (directConverter31 == null) {
                    directConverter31 = ReturnTypeKt.getIndirectConverter(Long.class, null);
                }
                ReturnType returnType62 = new ReturnType(directConverter31);
                returnTypeProvider31.getTypes().put(Long.class, returnType62);
                returnType61 = returnType62;
            }
            SyncFunctionComponent syncFunctionComponent10 = new SyncFunctionComponent("get", anyTypeArr45, returnType61, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFileHandle) it[0]).getOffset();
                }
            });
            syncFunctionComponent10.setOwnerType(propertyComponentBuilderWithThis10.getThisType());
            syncFunctionComponent10.setCanTakeOwner(true);
            propertyComponentBuilderWithThis10.setGetter(syncFunctionComponent10);
            classComponentBuilder17.getProperties().put("offset", propertyComponentBuilderWithThis10);
            AnyType[] anyTypeArr46 = new AnyType[2];
            anyTypeArr46[0] = new AnyType(propertyComponentBuilderWithThis10.getThisType(), null, 2, null);
            AnyType anyType69 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Long.class), false));
            if (anyType69 == null) {
                try {
                    Result.Companion companion125 = Result.INSTANCE;
                    objM12684constructorimpl63 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.LONG), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$set$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Long.TYPE);
                        }
                    }));
                } catch (Throwable th64) {
                    Result.Companion companion126 = Result.INSTANCE;
                    objM12684constructorimpl63 = Result.m12684constructorimpl(ResultKt.createFailure(th64));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl63)) {
                    objM12684constructorimpl63 = null;
                }
                TypeDescriptor typeDescriptor63 = (TypeDescriptor) objM12684constructorimpl63;
                if (typeDescriptor63 == null) {
                    typeDescriptor63 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Long.TYPE));
                }
                anyType69 = new AnyType(typeDescriptor63, null);
            }
            anyTypeArr46[1] = anyType69;
            ReturnTypeProvider returnTypeProvider32 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType63 = returnTypeProvider32.getTypes().get(Unit.class);
            if (returnType63 == null) {
                JSTypeConverter<?> directConverter32 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter32 == null) {
                    directConverter32 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType64 = new ReturnType(directConverter32);
                returnTypeProvider32.getTypes().put(Unit.class, returnType64);
                returnType63 = returnType64;
            }
            SyncFunctionComponent syncFunctionComponent11 = new SyncFunctionComponent("set", anyTypeArr46, returnType63, new Function1<Object[], Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$set$2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    ((FileSystemFileHandle) obj).setOffset(Long.valueOf(((Long) obj2).longValue()));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr) {
                    invoke2(objArr);
                    return Unit.INSTANCE;
                }
            });
            syncFunctionComponent11.setOwnerType(propertyComponentBuilderWithThis10.getThisType());
            syncFunctionComponent11.setCanTakeOwner(true);
            propertyComponentBuilderWithThis10.setSetter(syncFunctionComponent11);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis11 = new PropertyComponentBuilderWithThis(classComponentBuilder17.getOwnerType().getTypeDescriptor(), ContentDisposition.Parameters.Size);
            AnyType[] anyTypeArr47 = {new AnyType(propertyComponentBuilderWithThis11.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider33 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType65 = returnTypeProvider33.getTypes().get(Long.class);
            if (returnType65 == null) {
                JSTypeConverter<?> directConverter33 = ReturnTypeKt.getDirectConverter(Long.class);
                if (directConverter33 == null) {
                    directConverter33 = ReturnTypeKt.getIndirectConverter(Long.class, null);
                }
                ReturnType returnType66 = new ReturnType(directConverter33);
                returnTypeProvider33.getTypes().put(Long.class, returnType66);
                returnType65 = returnType66;
            }
            SyncFunctionComponent syncFunctionComponent12 = new SyncFunctionComponent("get", anyTypeArr47, returnType65, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$55$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFileHandle) it[0]).getSize();
                }
            });
            syncFunctionComponent12.setOwnerType(propertyComponentBuilderWithThis11.getThisType());
            syncFunctionComponent12.setCanTakeOwner(true);
            propertyComponentBuilderWithThis11.setGetter(syncFunctionComponent12);
            classComponentBuilder17.getProperties().put(ContentDisposition.Parameters.Size, propertyComponentBuilderWithThis11);
            moduleDefinitionBuilder7.getClassData().add(classComponentBuilder17.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(FileSystemDirectory.class);
            Module module3 = moduleDefinitionBuilder8.getModule();
            if (module3 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext3 = module3.getAppContext();
            String simpleName3 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass3).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName3, "getSimpleName(...)");
            AnyType anyType70 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType70 != null) {
                anyType3 = anyType70;
            } else {
                try {
                    Result.Companion companion127 = Result.INSTANCE;
                    objM12684constructorimpl64 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Class$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th65) {
                    Result.Companion companion128 = Result.INSTANCE;
                    objM12684constructorimpl64 = Result.m12684constructorimpl(ResultKt.createFailure(th65));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl64)) {
                    objM12684constructorimpl64 = null;
                }
                TypeDescriptor typeDescriptor64 = (TypeDescriptor) objM12684constructorimpl64;
                if (typeDescriptor64 == null) {
                    typeDescriptor64 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType3 = new AnyType(typeDescriptor64, null);
            }
            ClassComponentBuilder classComponentBuilder21 = new ClassComponentBuilder(appContext3, simpleName3, orCreateKotlinClass3, anyType3, moduleDefinitionBuilder8.getConverters());
            TypeConverterProvider converters34 = classComponentBuilder21.getConverters();
            AnyType[] anyTypeArr48 = new AnyType[1];
            AnyType anyType71 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Uri.class), false));
            if (anyType71 == null) {
                try {
                    Result.Companion companion129 = Result.INSTANCE;
                    objM12684constructorimpl65 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Constructor$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Uri.class);
                        }
                    }));
                } catch (Throwable th66) {
                    Result.Companion companion130 = Result.INSTANCE;
                    objM12684constructorimpl65 = Result.m12684constructorimpl(ResultKt.createFailure(th66));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl65)) {
                    objM12684constructorimpl65 = null;
                }
                TypeDescriptor typeDescriptor65 = (TypeDescriptor) objM12684constructorimpl65;
                if (typeDescriptor65 == null) {
                    typeDescriptor65 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Uri.class));
                }
                anyType71 = new AnyType(typeDescriptor65, converters34);
            }
            anyTypeArr48[0] = anyType71;
            ReturnTypeProvider returnTypeProvider34 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType67 = returnTypeProvider34.getTypes().get(Object.class);
            if (returnType67 == null) {
                JSTypeConverter<?> directConverter34 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter34 == null) {
                    directConverter34 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType68 = new ReturnType(directConverter34);
                returnTypeProvider34.getTypes().put(Object.class, returnType68);
                returnType67 = returnType68;
            }
            classComponentBuilder21.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr48, returnType67, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return new FileSystemDirectory((Uri) objArr[0]);
                }
            }));
            ClassComponentBuilder classComponentBuilder22 = classComponentBuilder21;
            TypeConverterProvider converters35 = classComponentBuilder22.getConverters();
            AnyType[] anyTypeArr49 = new AnyType[1];
            AnyType anyType72 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType72 == null) {
                try {
                    Result.Companion companion131 = Result.INSTANCE;
                    objM12684constructorimpl66 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th67) {
                    Result.Companion companion132 = Result.INSTANCE;
                    objM12684constructorimpl66 = Result.m12684constructorimpl(ResultKt.createFailure(th67));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl66)) {
                    objM12684constructorimpl66 = null;
                }
                TypeDescriptor typeDescriptor66 = (TypeDescriptor) objM12684constructorimpl66;
                if (typeDescriptor66 == null) {
                    typeDescriptor66 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType72 = new AnyType(typeDescriptor66, converters35);
            }
            anyTypeArr49[0] = anyType72;
            ReturnTypeProvider returnTypeProvider35 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType69 = returnTypeProvider35.getTypes().get(DirectoryInfo.class);
            if (returnType69 == null) {
                JSTypeConverter<?> directConverter35 = ReturnTypeKt.getDirectConverter(DirectoryInfo.class);
                if (directConverter35 == null) {
                    directConverter35 = ReturnTypeKt.getIndirectConverter(DirectoryInfo.class, DirectoryInfo.__Pika.__pika$IntrospectionData);
                }
                ReturnType returnType70 = new ReturnType(directConverter35);
                returnTypeProvider35.getTypes().put(DirectoryInfo.class, returnType70);
                returnType69 = returnType70;
            }
            classComponentBuilder22.getSyncFunctions().put("info", new SyncFunctionComponent("info", anyTypeArr49, returnType69, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemDirectory) objArr[0]).info();
                }
            }));
            ClassComponentBuilder classComponentBuilder23 = classComponentBuilder21;
            TypeConverterProvider converters36 = classComponentBuilder23.getConverters();
            AnyType[] anyTypeArr50 = new AnyType[1];
            AnyType anyType73 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType73 == null) {
                try {
                    Result.Companion companion133 = Result.INSTANCE;
                    objM12684constructorimpl67 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th68) {
                    Result.Companion companion134 = Result.INSTANCE;
                    objM12684constructorimpl67 = Result.m12684constructorimpl(ResultKt.createFailure(th68));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl67)) {
                    objM12684constructorimpl67 = null;
                }
                TypeDescriptor typeDescriptor67 = (TypeDescriptor) objM12684constructorimpl67;
                if (typeDescriptor67 == null) {
                    typeDescriptor67 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType73 = new AnyType(typeDescriptor67, converters36);
            }
            anyTypeArr50[0] = anyType73;
            ReturnTypeProvider returnTypeProvider36 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType71 = returnTypeProvider36.getTypes().get(Unit.class);
            if (returnType71 == null) {
                JSTypeConverter<?> directConverter36 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter36 == null) {
                    directConverter36 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType72 = new ReturnType(directConverter36);
                returnTypeProvider36.getTypes().put(Unit.class, returnType72);
                returnType71 = returnType72;
            }
            classComponentBuilder23.getSyncFunctions().put("delete", new SyncFunctionComponent("delete", anyTypeArr50, returnType71, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemDirectory) objArr[0]).delete();
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder24 = classComponentBuilder21;
            TypeConverterProvider converters37 = classComponentBuilder24.getConverters();
            AnyType[] anyTypeArr51 = new AnyType[2];
            AnyType anyType74 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType74 == null) {
                try {
                    Result.Companion companion135 = Result.INSTANCE;
                    objM12684constructorimpl68 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th69) {
                    Result.Companion companion136 = Result.INSTANCE;
                    objM12684constructorimpl68 = Result.m12684constructorimpl(ResultKt.createFailure(th69));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl68)) {
                    objM12684constructorimpl68 = null;
                }
                TypeDescriptor typeDescriptor68 = (TypeDescriptor) objM12684constructorimpl68;
                if (typeDescriptor68 == null) {
                    typeDescriptor68 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType74 = new AnyType(typeDescriptor68, converters37);
            }
            anyTypeArr51[0] = anyType74;
            AnyType anyType75 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(CreateOptions.class), true));
            if (anyType75 == null) {
                try {
                    Result.Companion companion137 = Result.INSTANCE;
                    objM12684constructorimpl69 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(CreateOptions.class, true, CreateOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(CreateOptions.class);
                        }
                    }));
                } catch (Throwable th70) {
                    Result.Companion companion138 = Result.INSTANCE;
                    objM12684constructorimpl69 = Result.m12684constructorimpl(ResultKt.createFailure(th70));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl69)) {
                    objM12684constructorimpl69 = null;
                }
                TypeDescriptor typeDescriptor69 = (TypeDescriptor) objM12684constructorimpl69;
                if (typeDescriptor69 == null) {
                    typeDescriptor69 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(CreateOptions.class));
                }
                anyType75 = new AnyType(typeDescriptor69, converters37);
            }
            anyTypeArr51[1] = anyType75;
            ReturnTypeProvider returnTypeProvider37 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType73 = returnTypeProvider37.getTypes().get(Unit.class);
            if (returnType73 == null) {
                JSTypeConverter<?> directConverter37 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter37 == null) {
                    directConverter37 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType74 = new ReturnType(directConverter37);
                returnTypeProvider37.getTypes().put(Unit.class, returnType74);
                returnType73 = returnType74;
            }
            classComponentBuilder24.getSyncFunctions().put("create", new SyncFunctionComponent("create", anyTypeArr51, returnType73, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InvalidTypeFolderException, UnableToCreateException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    CreateOptions createOptions = (CreateOptions) objArr[1];
                    FileSystemDirectory fileSystemDirectory = (FileSystemDirectory) obj;
                    if (createOptions == null) {
                        createOptions = new CreateOptions(false, false, false, 7, null);
                    }
                    fileSystemDirectory.create(createOptions);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder25 = classComponentBuilder21;
            TypeConverterProvider converters38 = classComponentBuilder25.getConverters();
            AnyType[] anyTypeArr52 = new AnyType[2];
            AnyType anyType76 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType76 == null) {
                try {
                    Result.Companion companion139 = Result.INSTANCE;
                    objM12684constructorimpl70 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th71) {
                    Result.Companion companion140 = Result.INSTANCE;
                    objM12684constructorimpl70 = Result.m12684constructorimpl(ResultKt.createFailure(th71));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl70)) {
                    objM12684constructorimpl70 = null;
                }
                TypeDescriptor typeDescriptor70 = (TypeDescriptor) objM12684constructorimpl70;
                if (typeDescriptor70 == null) {
                    typeDescriptor70 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType76 = new AnyType(typeDescriptor70, converters38);
            }
            anyTypeArr52[0] = anyType76;
            AnyType anyType77 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType77 == null) {
                try {
                    Result.Companion companion141 = Result.INSTANCE;
                    objM12684constructorimpl71 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th72) {
                    Result.Companion companion142 = Result.INSTANCE;
                    objM12684constructorimpl71 = Result.m12684constructorimpl(ResultKt.createFailure(th72));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl71)) {
                    objM12684constructorimpl71 = null;
                }
                TypeDescriptor typeDescriptor71 = (TypeDescriptor) objM12684constructorimpl71;
                if (typeDescriptor71 == null) {
                    typeDescriptor71 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType77 = new AnyType(typeDescriptor71, converters38);
            }
            anyTypeArr52[1] = anyType77;
            ReturnTypeProvider returnTypeProvider38 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType75 = returnTypeProvider38.getTypes().get(FileSystemDirectory.class);
            if (returnType75 == null) {
                JSTypeConverter<?> directConverter38 = ReturnTypeKt.getDirectConverter(FileSystemDirectory.class);
                if (directConverter38 == null) {
                    directConverter38 = ReturnTypeKt.getIndirectConverter(FileSystemDirectory.class, null);
                }
                ReturnType returnType76 = new ReturnType(directConverter38);
                returnTypeProvider38.getTypes().put(FileSystemDirectory.class, returnType76);
                returnType75 = returnType76;
            }
            classComponentBuilder25.getSyncFunctions().put("createDirectory", new SyncFunctionComponent("createDirectory", anyTypeArr52, returnType75, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemDirectory) objArr[0]).createDirectory((String) objArr[1]);
                }
            }));
            ClassComponentBuilder classComponentBuilder26 = classComponentBuilder21;
            TypeConverterProvider converters39 = classComponentBuilder26.getConverters();
            AnyType[] anyTypeArr53 = new AnyType[3];
            AnyType anyType78 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType78 == null) {
                try {
                    Result.Companion companion143 = Result.INSTANCE;
                    objM12684constructorimpl72 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th73) {
                    Result.Companion companion144 = Result.INSTANCE;
                    objM12684constructorimpl72 = Result.m12684constructorimpl(ResultKt.createFailure(th73));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl72)) {
                    objM12684constructorimpl72 = null;
                }
                TypeDescriptor typeDescriptor72 = (TypeDescriptor) objM12684constructorimpl72;
                if (typeDescriptor72 == null) {
                    typeDescriptor72 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType78 = new AnyType(typeDescriptor72, converters39);
            }
            anyTypeArr53[0] = anyType78;
            AnyType anyType79 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType79 == null) {
                try {
                    Result.Companion companion145 = Result.INSTANCE;
                    objM12684constructorimpl73 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$12
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th74) {
                    Result.Companion companion146 = Result.INSTANCE;
                    objM12684constructorimpl73 = Result.m12684constructorimpl(ResultKt.createFailure(th74));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl73)) {
                    objM12684constructorimpl73 = null;
                }
                TypeDescriptor typeDescriptor73 = (TypeDescriptor) objM12684constructorimpl73;
                if (typeDescriptor73 == null) {
                    typeDescriptor73 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType79 = new AnyType(typeDescriptor73, converters39);
            }
            anyTypeArr53[1] = anyType79;
            AnyType anyType80 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType80 == null) {
                try {
                    Result.Companion companion147 = Result.INSTANCE;
                    objM12684constructorimpl74 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$13
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                } catch (Throwable th75) {
                    Result.Companion companion148 = Result.INSTANCE;
                    objM12684constructorimpl74 = Result.m12684constructorimpl(ResultKt.createFailure(th75));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl74)) {
                    objM12684constructorimpl74 = null;
                }
                TypeDescriptor typeDescriptor74 = (TypeDescriptor) objM12684constructorimpl74;
                if (typeDescriptor74 == null) {
                    typeDescriptor74 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType80 = new AnyType(typeDescriptor74, converters39);
            }
            anyTypeArr53[2] = anyType80;
            ReturnTypeProvider returnTypeProvider39 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType77 = returnTypeProvider39.getTypes().get(FileSystemFile.class);
            if (returnType77 == null) {
                JSTypeConverter<?> directConverter39 = ReturnTypeKt.getDirectConverter(FileSystemFile.class);
                if (directConverter39 == null) {
                    directConverter39 = ReturnTypeKt.getIndirectConverter(FileSystemFile.class, null);
                }
                ReturnType returnType78 = new ReturnType(directConverter39);
                returnTypeProvider39.getTypes().put(FileSystemFile.class, returnType78);
                returnType77 = returnType78;
            }
            classComponentBuilder26.getSyncFunctions().put("createFile", new SyncFunctionComponent("createFile", anyTypeArr53, returnType77, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    return ((FileSystemDirectory) obj).createFile((String) objArr[2], (String) objArr[1]);
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis12 = new PropertyComponentBuilderWithThis(classComponentBuilder21.getOwnerType().getTypeDescriptor(), "exists");
            AnyType[] anyTypeArr54 = {new AnyType(propertyComponentBuilderWithThis12.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider40 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType79 = returnTypeProvider40.getTypes().get(Boolean.class);
            if (returnType79 == null) {
                JSTypeConverter<?> directConverter40 = ReturnTypeKt.getDirectConverter(Boolean.class);
                if (directConverter40 == null) {
                    directConverter40 = ReturnTypeKt.getIndirectConverter(Boolean.class, null);
                }
                ReturnType returnType80 = new ReturnType(directConverter40);
                returnTypeProvider40.getTypes().put(Boolean.class, returnType80);
                returnType79 = returnType80;
            }
            SyncFunctionComponent syncFunctionComponent13 = new SyncFunctionComponent("get", anyTypeArr54, returnType79, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(((FileSystemDirectory) it[0]).getExists());
                }
            });
            syncFunctionComponent13.setOwnerType(propertyComponentBuilderWithThis12.getThisType());
            syncFunctionComponent13.setCanTakeOwner(true);
            propertyComponentBuilderWithThis12.setGetter(syncFunctionComponent13);
            classComponentBuilder21.getProperties().put("exists", propertyComponentBuilderWithThis12);
            ClassComponentBuilder classComponentBuilder27 = classComponentBuilder21;
            TypeConverterProvider converters40 = classComponentBuilder27.getConverters();
            AnyType[] anyTypeArr55 = new AnyType[1];
            AnyType anyType81 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType81 == null) {
                try {
                    Result.Companion companion149 = Result.INSTANCE;
                    objM12684constructorimpl75 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$15
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th76) {
                    Result.Companion companion150 = Result.INSTANCE;
                    objM12684constructorimpl75 = Result.m12684constructorimpl(ResultKt.createFailure(th76));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl75)) {
                    objM12684constructorimpl75 = null;
                }
                TypeDescriptor typeDescriptor75 = (TypeDescriptor) objM12684constructorimpl75;
                if (typeDescriptor75 == null) {
                    typeDescriptor75 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType81 = new AnyType(typeDescriptor75, converters40);
            }
            anyTypeArr55[0] = anyType81;
            ReturnTypeProvider returnTypeProvider41 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType81 = returnTypeProvider41.getTypes().get(Unit.class);
            if (returnType81 == null) {
                JSTypeConverter<?> directConverter41 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter41 == null) {
                    directConverter41 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType82 = new ReturnType(directConverter41);
                returnTypeProvider41.getTypes().put(Unit.class, returnType82);
                returnType81 = returnType82;
            }
            classComponentBuilder27.getSyncFunctions().put("validatePath", new SyncFunctionComponent("validatePath", anyTypeArr55, returnType81, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemDirectory) objArr[0]).validatePath();
                    return Unit.INSTANCE;
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction13 = classComponentBuilder21.AsyncFunction("copy");
            String name13 = asyncFunctionBuilderAsyncFunction13.getName();
            TypeConverterProvider converters41 = asyncFunctionBuilderAsyncFunction13.getConverters();
            AnyType[] anyTypeArr56 = new AnyType[3];
            AnyType anyType82 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType82 == null) {
                try {
                    Result.Companion companion151 = Result.INSTANCE;
                    objM12684constructorimpl76 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th77) {
                    Result.Companion companion152 = Result.INSTANCE;
                    objM12684constructorimpl76 = Result.m12684constructorimpl(ResultKt.createFailure(th77));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl76)) {
                    objM12684constructorimpl76 = null;
                }
                TypeDescriptor typeDescriptor76 = (TypeDescriptor) objM12684constructorimpl76;
                if (typeDescriptor76 == null) {
                    typeDescriptor76 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType82 = new AnyType(typeDescriptor76, converters41);
            }
            anyTypeArr56[0] = anyType82;
            AnyType anyType83 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType83 == null) {
                try {
                    Result.Companion companion153 = Result.INSTANCE;
                    objM12684constructorimpl77 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemPath.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Coroutine$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemPath.class);
                        }
                    }));
                } catch (Throwable th78) {
                    Result.Companion companion154 = Result.INSTANCE;
                    objM12684constructorimpl77 = Result.m12684constructorimpl(ResultKt.createFailure(th78));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl77)) {
                    objM12684constructorimpl77 = null;
                }
                TypeDescriptor typeDescriptor77 = (TypeDescriptor) objM12684constructorimpl77;
                if (typeDescriptor77 == null) {
                    typeDescriptor77 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemPath.class));
                }
                anyType83 = new AnyType(typeDescriptor77, converters41);
            }
            anyTypeArr56[1] = anyType83;
            AnyType anyType84 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RelocationOptions.class), true));
            if (anyType84 == null) {
                try {
                    Result.Companion companion155 = Result.INSTANCE;
                    objM12684constructorimpl78 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RelocationOptions.class, true, RelocationOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Coroutine$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(RelocationOptions.class);
                        }
                    }));
                } catch (Throwable th79) {
                    Result.Companion companion156 = Result.INSTANCE;
                    objM12684constructorimpl78 = Result.m12684constructorimpl(ResultKt.createFailure(th79));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl78)) {
                    objM12684constructorimpl78 = null;
                }
                TypeDescriptor typeDescriptor78 = (TypeDescriptor) objM12684constructorimpl78;
                if (typeDescriptor78 == null) {
                    typeDescriptor78 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(RelocationOptions.class));
                }
                anyType84 = new AnyType(typeDescriptor78, converters41);
            }
            anyTypeArr56[2] = anyType84;
            asyncFunctionBuilderAsyncFunction13.setAsyncFunctionComponent(new SuspendFunctionComponent(name13, anyTypeArr56, new FileSystemModule$definition$lambda$87$lambda$72$$inlined$Coroutine$4(null)));
            ClassComponentBuilder classComponentBuilder28 = classComponentBuilder21;
            TypeConverterProvider converters42 = classComponentBuilder28.getConverters();
            AnyType[] anyTypeArr57 = new AnyType[3];
            AnyType anyType85 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType85 == null) {
                try {
                    Result.Companion companion157 = Result.INSTANCE;
                    objM12684constructorimpl79 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$17
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th80) {
                    Result.Companion companion158 = Result.INSTANCE;
                    objM12684constructorimpl79 = Result.m12684constructorimpl(ResultKt.createFailure(th80));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl79)) {
                    objM12684constructorimpl79 = null;
                }
                TypeDescriptor typeDescriptor79 = (TypeDescriptor) objM12684constructorimpl79;
                if (typeDescriptor79 == null) {
                    typeDescriptor79 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType85 = new AnyType(typeDescriptor79, converters42);
            }
            anyTypeArr57[0] = anyType85;
            AnyType anyType86 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType86 == null) {
                try {
                    Result.Companion companion159 = Result.INSTANCE;
                    objM12684constructorimpl80 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemPath.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$18
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemPath.class);
                        }
                    }));
                } catch (Throwable th81) {
                    Result.Companion companion160 = Result.INSTANCE;
                    objM12684constructorimpl80 = Result.m12684constructorimpl(ResultKt.createFailure(th81));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl80)) {
                    objM12684constructorimpl80 = null;
                }
                TypeDescriptor typeDescriptor80 = (TypeDescriptor) objM12684constructorimpl80;
                if (typeDescriptor80 == null) {
                    typeDescriptor80 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemPath.class));
                }
                anyType86 = new AnyType(typeDescriptor80, converters42);
            }
            anyTypeArr57[1] = anyType86;
            AnyType anyType87 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RelocationOptions.class), true));
            if (anyType87 == null) {
                try {
                    Result.Companion companion161 = Result.INSTANCE;
                    objM12684constructorimpl81 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RelocationOptions.class, true, RelocationOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$19
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(RelocationOptions.class);
                        }
                    }));
                } catch (Throwable th82) {
                    Result.Companion companion162 = Result.INSTANCE;
                    objM12684constructorimpl81 = Result.m12684constructorimpl(ResultKt.createFailure(th82));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl81)) {
                    objM12684constructorimpl81 = null;
                }
                TypeDescriptor typeDescriptor81 = (TypeDescriptor) objM12684constructorimpl81;
                if (typeDescriptor81 == null) {
                    typeDescriptor81 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(RelocationOptions.class));
                }
                anyType87 = new AnyType(typeDescriptor81, converters42);
            }
            anyTypeArr57[2] = anyType87;
            ReturnTypeProvider returnTypeProvider42 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType83 = returnTypeProvider42.getTypes().get(Unit.class);
            if (returnType83 == null) {
                JSTypeConverter<?> directConverter42 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter42 == null) {
                    directConverter42 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType84 = new ReturnType(directConverter42);
                returnTypeProvider42.getTypes().put(Unit.class, returnType84);
                returnType83 = returnType84;
            }
            classComponentBuilder28.getSyncFunctions().put("copySync", new SyncFunctionComponent("copySync", anyTypeArr57, returnType83, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$20
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InterruptedException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    FileSystemDirectory fileSystemDirectory = (FileSystemDirectory) obj;
                    BuildersKt__BuildersKt.runBlocking$default(null, new FileSystemModule$definition$1$14$10$1(fileSystemDirectory, (FileSystemPath) objArr[1], (RelocationOptions) objArr[2], null), 1, null);
                    return Unit.INSTANCE;
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction14 = classComponentBuilder21.AsyncFunction("move");
            String name14 = asyncFunctionBuilderAsyncFunction14.getName();
            TypeConverterProvider converters43 = asyncFunctionBuilderAsyncFunction14.getConverters();
            AnyType[] anyTypeArr58 = new AnyType[3];
            AnyType anyType88 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType88 == null) {
                try {
                    Result.Companion companion163 = Result.INSTANCE;
                    objM12684constructorimpl82 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Coroutine$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th83) {
                    Result.Companion companion164 = Result.INSTANCE;
                    objM12684constructorimpl82 = Result.m12684constructorimpl(ResultKt.createFailure(th83));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl82)) {
                    objM12684constructorimpl82 = null;
                }
                TypeDescriptor typeDescriptor82 = (TypeDescriptor) objM12684constructorimpl82;
                if (typeDescriptor82 == null) {
                    typeDescriptor82 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType88 = new AnyType(typeDescriptor82, converters43);
            }
            anyTypeArr58[0] = anyType88;
            AnyType anyType89 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType89 == null) {
                try {
                    Result.Companion companion165 = Result.INSTANCE;
                    objM12684constructorimpl83 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemPath.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Coroutine$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemPath.class);
                        }
                    }));
                } catch (Throwable th84) {
                    Result.Companion companion166 = Result.INSTANCE;
                    objM12684constructorimpl83 = Result.m12684constructorimpl(ResultKt.createFailure(th84));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl83)) {
                    objM12684constructorimpl83 = null;
                }
                TypeDescriptor typeDescriptor83 = (TypeDescriptor) objM12684constructorimpl83;
                if (typeDescriptor83 == null) {
                    typeDescriptor83 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemPath.class));
                }
                anyType89 = new AnyType(typeDescriptor83, converters43);
            }
            anyTypeArr58[1] = anyType89;
            AnyType anyType90 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RelocationOptions.class), true));
            if (anyType90 == null) {
                try {
                    Result.Companion companion167 = Result.INSTANCE;
                    objM12684constructorimpl84 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RelocationOptions.class, true, RelocationOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Coroutine$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(RelocationOptions.class);
                        }
                    }));
                } catch (Throwable th85) {
                    Result.Companion companion168 = Result.INSTANCE;
                    objM12684constructorimpl84 = Result.m12684constructorimpl(ResultKt.createFailure(th85));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl84)) {
                    objM12684constructorimpl84 = null;
                }
                TypeDescriptor typeDescriptor84 = (TypeDescriptor) objM12684constructorimpl84;
                if (typeDescriptor84 == null) {
                    typeDescriptor84 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(RelocationOptions.class));
                }
                anyType90 = new AnyType(typeDescriptor84, converters43);
            }
            anyTypeArr58[2] = anyType90;
            asyncFunctionBuilderAsyncFunction14.setAsyncFunctionComponent(new SuspendFunctionComponent(name14, anyTypeArr58, new FileSystemModule$definition$lambda$87$lambda$72$$inlined$Coroutine$8(null)));
            ClassComponentBuilder classComponentBuilder29 = classComponentBuilder21;
            TypeConverterProvider converters44 = classComponentBuilder29.getConverters();
            AnyType[] anyTypeArr59 = new AnyType[3];
            AnyType anyType91 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType91 == null) {
                try {
                    Result.Companion companion169 = Result.INSTANCE;
                    objM12684constructorimpl85 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$21
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th86) {
                    Result.Companion companion170 = Result.INSTANCE;
                    objM12684constructorimpl85 = Result.m12684constructorimpl(ResultKt.createFailure(th86));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl85)) {
                    objM12684constructorimpl85 = null;
                }
                TypeDescriptor typeDescriptor85 = (TypeDescriptor) objM12684constructorimpl85;
                if (typeDescriptor85 == null) {
                    typeDescriptor85 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType91 = new AnyType(typeDescriptor85, converters44);
            }
            anyTypeArr59[0] = anyType91;
            AnyType anyType92 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType92 == null) {
                try {
                    Result.Companion companion171 = Result.INSTANCE;
                    objM12684constructorimpl86 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemPath.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$22
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemPath.class);
                        }
                    }));
                } catch (Throwable th87) {
                    Result.Companion companion172 = Result.INSTANCE;
                    objM12684constructorimpl86 = Result.m12684constructorimpl(ResultKt.createFailure(th87));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl86)) {
                    objM12684constructorimpl86 = null;
                }
                TypeDescriptor typeDescriptor86 = (TypeDescriptor) objM12684constructorimpl86;
                if (typeDescriptor86 == null) {
                    typeDescriptor86 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemPath.class));
                }
                anyType92 = new AnyType(typeDescriptor86, converters44);
            }
            anyTypeArr59[1] = anyType92;
            AnyType anyType93 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RelocationOptions.class), true));
            if (anyType93 == null) {
                try {
                    Result.Companion companion173 = Result.INSTANCE;
                    objM12684constructorimpl87 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RelocationOptions.class, true, RelocationOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$23
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(RelocationOptions.class);
                        }
                    }));
                } catch (Throwable th88) {
                    Result.Companion companion174 = Result.INSTANCE;
                    objM12684constructorimpl87 = Result.m12684constructorimpl(ResultKt.createFailure(th88));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl87)) {
                    objM12684constructorimpl87 = null;
                }
                TypeDescriptor typeDescriptor87 = (TypeDescriptor) objM12684constructorimpl87;
                if (typeDescriptor87 == null) {
                    typeDescriptor87 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(RelocationOptions.class));
                }
                anyType93 = new AnyType(typeDescriptor87, converters44);
            }
            anyTypeArr59[2] = anyType93;
            ReturnTypeProvider returnTypeProvider43 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType85 = returnTypeProvider43.getTypes().get(Unit.class);
            if (returnType85 == null) {
                JSTypeConverter<?> directConverter43 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter43 == null) {
                    directConverter43 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType86 = new ReturnType(directConverter43);
                returnTypeProvider43.getTypes().put(Unit.class, returnType86);
                returnType85 = returnType86;
            }
            classComponentBuilder29.getSyncFunctions().put("moveSync", new SyncFunctionComponent("moveSync", anyTypeArr59, returnType85, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$24
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InterruptedException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    FileSystemDirectory fileSystemDirectory = (FileSystemDirectory) obj;
                    BuildersKt__BuildersKt.runBlocking$default(null, new FileSystemModule$definition$1$14$12$1(fileSystemDirectory, (FileSystemPath) objArr[1], (RelocationOptions) objArr[2], null), 1, null);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder30 = classComponentBuilder21;
            TypeConverterProvider converters45 = classComponentBuilder30.getConverters();
            AnyType[] anyTypeArr60 = new AnyType[2];
            AnyType anyType94 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType94 == null) {
                try {
                    Result.Companion companion175 = Result.INSTANCE;
                    objM12684constructorimpl88 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$25
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th89) {
                    Result.Companion companion176 = Result.INSTANCE;
                    objM12684constructorimpl88 = Result.m12684constructorimpl(ResultKt.createFailure(th89));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl88)) {
                    objM12684constructorimpl88 = null;
                }
                TypeDescriptor typeDescriptor88 = (TypeDescriptor) objM12684constructorimpl88;
                if (typeDescriptor88 == null) {
                    typeDescriptor88 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType94 = new AnyType(typeDescriptor88, converters45);
            }
            anyTypeArr60[0] = anyType94;
            AnyType anyType95 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType95 == null) {
                try {
                    Result.Companion companion177 = Result.INSTANCE;
                    objM12684constructorimpl89 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$26
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th90) {
                    Result.Companion companion178 = Result.INSTANCE;
                    objM12684constructorimpl89 = Result.m12684constructorimpl(ResultKt.createFailure(th90));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl89)) {
                    objM12684constructorimpl89 = null;
                }
                TypeDescriptor typeDescriptor89 = (TypeDescriptor) objM12684constructorimpl89;
                if (typeDescriptor89 == null) {
                    typeDescriptor89 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType95 = new AnyType(typeDescriptor89, converters45);
            }
            anyTypeArr60[1] = anyType95;
            ReturnTypeProvider returnTypeProvider44 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType87 = returnTypeProvider44.getTypes().get(Unit.class);
            if (returnType87 == null) {
                JSTypeConverter<?> directConverter44 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter44 == null) {
                    directConverter44 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType88 = new ReturnType(directConverter44);
                returnTypeProvider44.getTypes().put(Unit.class, returnType88);
                returnType87 = returnType88;
            }
            classComponentBuilder30.getSyncFunctions().put("rename", new SyncFunctionComponent("rename", anyTypeArr60, returnType87, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$27
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemDirectory) objArr[0]).rename((String) objArr[1]);
                    return Unit.INSTANCE;
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis13 = new PropertyComponentBuilderWithThis(classComponentBuilder21.getOwnerType().getTypeDescriptor(), "uri");
            AnyType[] anyTypeArr61 = {new AnyType(propertyComponentBuilderWithThis13.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider45 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType89 = returnTypeProvider45.getTypes().get(String.class);
            if (returnType89 == null) {
                JSTypeConverter<?> directConverter45 = ReturnTypeKt.getDirectConverter(String.class);
                if (directConverter45 == null) {
                    directConverter45 = ReturnTypeKt.getIndirectConverter(String.class, null);
                }
                ReturnType returnType90 = new ReturnType(directConverter45);
                returnTypeProvider45.getTypes().put(String.class, returnType90);
                returnType89 = returnType90;
            }
            SyncFunctionComponent syncFunctionComponent14 = new SyncFunctionComponent("get", anyTypeArr61, returnType89, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemDirectory) it[0]).asString();
                }
            });
            syncFunctionComponent14.setOwnerType(propertyComponentBuilderWithThis13.getThisType());
            syncFunctionComponent14.setCanTakeOwner(true);
            propertyComponentBuilderWithThis13.setGetter(syncFunctionComponent14);
            classComponentBuilder21.getProperties().put("uri", propertyComponentBuilderWithThis13);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis14 = new PropertyComponentBuilderWithThis(classComponentBuilder21.getOwnerType().getTypeDescriptor(), ContentDisposition.Parameters.Size);
            AnyType[] anyTypeArr62 = {new AnyType(propertyComponentBuilderWithThis14.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider46 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType91 = returnTypeProvider46.getTypes().get(Long.class);
            if (returnType91 == null) {
                JSTypeConverter<?> directConverter46 = ReturnTypeKt.getDirectConverter(Long.class);
                if (directConverter46 == null) {
                    directConverter46 = ReturnTypeKt.getIndirectConverter(Long.class, null);
                }
                ReturnType returnType92 = new ReturnType(directConverter46);
                returnTypeProvider46.getTypes().put(Long.class, returnType92);
                returnType91 = returnType92;
            }
            SyncFunctionComponent syncFunctionComponent15 = new SyncFunctionComponent("get", anyTypeArr62, returnType91, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Property$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Long.valueOf(((FileSystemDirectory) it[0]).getSize());
                }
            });
            syncFunctionComponent15.setOwnerType(propertyComponentBuilderWithThis14.getThisType());
            syncFunctionComponent15.setCanTakeOwner(true);
            propertyComponentBuilderWithThis14.setGetter(syncFunctionComponent15);
            classComponentBuilder21.getProperties().put(ContentDisposition.Parameters.Size, propertyComponentBuilderWithThis14);
            ClassComponentBuilder classComponentBuilder31 = classComponentBuilder21;
            TypeConverterProvider converters46 = classComponentBuilder31.getConverters();
            AnyType[] anyTypeArr63 = new AnyType[1];
            AnyType anyType96 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDirectory.class), false));
            if (anyType96 == null) {
                try {
                    Result.Companion companion179 = Result.INSTANCE;
                    objM12684constructorimpl90 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDirectory.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$28
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDirectory.class);
                        }
                    }));
                } catch (Throwable th91) {
                    Result.Companion companion180 = Result.INSTANCE;
                    objM12684constructorimpl90 = Result.m12684constructorimpl(ResultKt.createFailure(th91));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl90)) {
                    objM12684constructorimpl90 = null;
                }
                TypeDescriptor typeDescriptor90 = (TypeDescriptor) objM12684constructorimpl90;
                if (typeDescriptor90 == null) {
                    typeDescriptor90 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDirectory.class));
                }
                anyType96 = new AnyType(typeDescriptor90, converters46);
            }
            anyTypeArr63[0] = anyType96;
            ReturnTypeProvider returnTypeProvider47 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType93 = returnTypeProvider47.getTypes().get(List.class);
            if (returnType93 == null) {
                JSTypeConverter<?> directConverter47 = ReturnTypeKt.getDirectConverter(List.class);
                if (directConverter47 == null) {
                    directConverter47 = ReturnTypeKt.getIndirectConverter(List.class, null);
                }
                ReturnType returnType94 = new ReturnType(directConverter47);
                returnTypeProvider47.getTypes().put(List.class, returnType94);
                returnType93 = returnType94;
            }
            classComponentBuilder31.getSyncFunctions().put("listAsRecords", new SyncFunctionComponent("listAsRecords", anyTypeArr63, returnType93, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$72$$inlined$Function$29
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemDirectory) objArr[0]).listAsRecords();
                }
            }));
            moduleDefinitionBuilder8.getClassData().add(classComponentBuilder21.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder9 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(FileSystemUploadTask.class);
            Module module4 = moduleDefinitionBuilder9.getModule();
            if (module4 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext4 = module4.getAppContext();
            String simpleName4 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass4).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName4, "getSimpleName(...)");
            AnyType anyType97 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemUploadTask.class), false));
            if (anyType97 != null) {
                anyType4 = anyType97;
            } else {
                try {
                    Result.Companion companion181 = Result.INSTANCE;
                    objM12684constructorimpl91 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemUploadTask.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Class$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemUploadTask.class);
                        }
                    }));
                } catch (Throwable th92) {
                    Result.Companion companion182 = Result.INSTANCE;
                    objM12684constructorimpl91 = Result.m12684constructorimpl(ResultKt.createFailure(th92));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl91)) {
                    objM12684constructorimpl91 = null;
                }
                TypeDescriptor typeDescriptor91 = (TypeDescriptor) objM12684constructorimpl91;
                if (typeDescriptor91 == null) {
                    typeDescriptor91 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemUploadTask.class));
                }
                anyType4 = new AnyType(typeDescriptor91, null);
            }
            ClassComponentBuilder classComponentBuilder32 = new ClassComponentBuilder(appContext4, simpleName4, orCreateKotlinClass4, anyType4, moduleDefinitionBuilder9.getConverters());
            AnyType[] anyTypeArr64 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider48 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType95 = returnTypeProvider48.getTypes().get(Object.class);
            if (returnType95 == null) {
                JSTypeConverter<?> directConverter48 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter48 == null) {
                    directConverter48 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType96 = new ReturnType(directConverter48);
                returnTypeProvider48.getTypes().put(Object.class, returnType96);
                returnType95 = returnType96;
            }
            classComponentBuilder32.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr64, returnType95, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$76$$inlined$Constructor$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new FileSystemUploadTask();
                }
            }));
            classComponentBuilder32.Events("progress");
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction15 = classComponentBuilder32.AsyncFunction(ViewProps.START);
            String name15 = asyncFunctionBuilderAsyncFunction15.getName();
            TypeConverterProvider converters47 = asyncFunctionBuilderAsyncFunction15.getConverters();
            AnyType[] anyTypeArr65 = new AnyType[4];
            AnyType anyType98 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemUploadTask.class), false));
            if (anyType98 == null) {
                try {
                    Result.Companion companion183 = Result.INSTANCE;
                    objM12684constructorimpl92 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemUploadTask.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$76$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemUploadTask.class);
                        }
                    }));
                } catch (Throwable th93) {
                    Result.Companion companion184 = Result.INSTANCE;
                    objM12684constructorimpl92 = Result.m12684constructorimpl(ResultKt.createFailure(th93));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl92)) {
                    objM12684constructorimpl92 = null;
                }
                TypeDescriptor typeDescriptor92 = (TypeDescriptor) objM12684constructorimpl92;
                if (typeDescriptor92 == null) {
                    typeDescriptor92 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemUploadTask.class));
                }
                anyType98 = new AnyType(typeDescriptor92, converters47);
            }
            anyTypeArr65[0] = anyType98;
            AnyType anyType99 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType99 == null) {
                try {
                    Result.Companion companion185 = Result.INSTANCE;
                    objM12684constructorimpl93 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$76$$inlined$Coroutine$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th94) {
                    Result.Companion companion186 = Result.INSTANCE;
                    objM12684constructorimpl93 = Result.m12684constructorimpl(ResultKt.createFailure(th94));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl93)) {
                    objM12684constructorimpl93 = null;
                }
                TypeDescriptor typeDescriptor93 = (TypeDescriptor) objM12684constructorimpl93;
                if (typeDescriptor93 == null) {
                    typeDescriptor93 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType99 = new AnyType(typeDescriptor93, converters47);
            }
            anyTypeArr65[1] = anyType99;
            AnyType anyType100 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType100 == null) {
                try {
                    Result.Companion companion187 = Result.INSTANCE;
                    objM12684constructorimpl94 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemFile.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$76$$inlined$Coroutine$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }));
                } catch (Throwable th95) {
                    Result.Companion companion188 = Result.INSTANCE;
                    objM12684constructorimpl94 = Result.m12684constructorimpl(ResultKt.createFailure(th95));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl94)) {
                    objM12684constructorimpl94 = null;
                }
                TypeDescriptor typeDescriptor94 = (TypeDescriptor) objM12684constructorimpl94;
                if (typeDescriptor94 == null) {
                    typeDescriptor94 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemFile.class));
                }
                anyType100 = new AnyType(typeDescriptor94, converters47);
            }
            anyTypeArr65[2] = anyType100;
            AnyType anyType101 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(UploadTaskOptions.class), false));
            if (anyType101 == null) {
                try {
                    Result.Companion companion189 = Result.INSTANCE;
                    objM12684constructorimpl95 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(UploadTaskOptions.class, false, UploadTaskOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$76$$inlined$Coroutine$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(UploadTaskOptions.class);
                        }
                    }));
                } catch (Throwable th96) {
                    Result.Companion companion190 = Result.INSTANCE;
                    objM12684constructorimpl95 = Result.m12684constructorimpl(ResultKt.createFailure(th96));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl95)) {
                    objM12684constructorimpl95 = null;
                }
                TypeDescriptor typeDescriptor95 = (TypeDescriptor) objM12684constructorimpl95;
                if (typeDescriptor95 == null) {
                    typeDescriptor95 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(UploadTaskOptions.class));
                }
                anyType101 = new AnyType(typeDescriptor95, converters47);
            }
            anyTypeArr65[3] = anyType101;
            asyncFunctionBuilderAsyncFunction15.setAsyncFunctionComponent(new SuspendFunctionComponent(name15, anyTypeArr65, new FileSystemModule$definition$lambda$87$lambda$76$$inlined$Coroutine$5(null)));
            ClassComponentBuilder classComponentBuilder33 = classComponentBuilder32;
            TypeConverterProvider converters48 = classComponentBuilder33.getConverters();
            AnyType[] anyTypeArr66 = new AnyType[1];
            AnyType anyType102 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemUploadTask.class), false));
            if (anyType102 == null) {
                try {
                    Result.Companion companion191 = Result.INSTANCE;
                    objM12684constructorimpl96 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemUploadTask.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$76$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemUploadTask.class);
                        }
                    }));
                } catch (Throwable th97) {
                    Result.Companion companion192 = Result.INSTANCE;
                    objM12684constructorimpl96 = Result.m12684constructorimpl(ResultKt.createFailure(th97));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl96)) {
                    objM12684constructorimpl96 = null;
                }
                TypeDescriptor typeDescriptor96 = (TypeDescriptor) objM12684constructorimpl96;
                if (typeDescriptor96 == null) {
                    typeDescriptor96 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemUploadTask.class));
                }
                anyType102 = new AnyType(typeDescriptor96, converters48);
            }
            anyTypeArr66[0] = anyType102;
            ReturnTypeProvider returnTypeProvider49 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType97 = returnTypeProvider49.getTypes().get(Unit.class);
            if (returnType97 == null) {
                JSTypeConverter<?> directConverter49 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter49 == null) {
                    directConverter49 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType98 = new ReturnType(directConverter49);
                returnTypeProvider49.getTypes().put(Unit.class, returnType98);
                returnType97 = returnType98;
            }
            classComponentBuilder33.getSyncFunctions().put("cancel", new SyncFunctionComponent("cancel", anyTypeArr66, returnType97, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$76$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemUploadTask) objArr[0]).cancel();
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder9.getClassData().add(classComponentBuilder32.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder10 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(FileSystemDownloadTask.class);
            Module module5 = moduleDefinitionBuilder10.getModule();
            if (module5 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext5 = module5.getAppContext();
            String simpleName5 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass5).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName5, "getSimpleName(...)");
            AnyType anyType103 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDownloadTask.class), false));
            if (anyType103 != null) {
                anyType5 = anyType103;
            } else {
                try {
                    Result.Companion companion193 = Result.INSTANCE;
                    objM12684constructorimpl97 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDownloadTask.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Class$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDownloadTask.class);
                        }
                    }));
                } catch (Throwable th98) {
                    Result.Companion companion194 = Result.INSTANCE;
                    objM12684constructorimpl97 = Result.m12684constructorimpl(ResultKt.createFailure(th98));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl97)) {
                    objM12684constructorimpl97 = null;
                }
                TypeDescriptor typeDescriptor97 = (TypeDescriptor) objM12684constructorimpl97;
                if (typeDescriptor97 == null) {
                    typeDescriptor97 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDownloadTask.class));
                }
                anyType5 = new AnyType(typeDescriptor97, null);
            }
            ClassComponentBuilder classComponentBuilder34 = new ClassComponentBuilder(appContext5, simpleName5, orCreateKotlinClass5, anyType5, moduleDefinitionBuilder10.getConverters());
            AnyType[] anyTypeArr67 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider50 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType99 = returnTypeProvider50.getTypes().get(Object.class);
            if (returnType99 == null) {
                JSTypeConverter<?> directConverter50 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter50 == null) {
                    directConverter50 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType100 = new ReturnType(directConverter50);
                returnTypeProvider50.getTypes().put(Object.class, returnType100);
                returnType99 = returnType100;
            }
            classComponentBuilder34.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr67, returnType99, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Constructor$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new FileSystemDownloadTask();
                }
            }));
            classComponentBuilder34.Events("progress");
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction16 = classComponentBuilder34.AsyncFunction(ViewProps.START);
            String name16 = asyncFunctionBuilderAsyncFunction16.getName();
            TypeConverterProvider converters49 = asyncFunctionBuilderAsyncFunction16.getConverters();
            AnyType[] anyTypeArr68 = new AnyType[4];
            AnyType anyType104 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDownloadTask.class), false));
            if (anyType104 == null) {
                try {
                    Result.Companion companion195 = Result.INSTANCE;
                    objM12684constructorimpl98 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDownloadTask.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Coroutine$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDownloadTask.class);
                        }
                    }));
                } catch (Throwable th99) {
                    Result.Companion companion196 = Result.INSTANCE;
                    objM12684constructorimpl98 = Result.m12684constructorimpl(ResultKt.createFailure(th99));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl98)) {
                    objM12684constructorimpl98 = null;
                }
                TypeDescriptor typeDescriptor98 = (TypeDescriptor) objM12684constructorimpl98;
                if (typeDescriptor98 == null) {
                    typeDescriptor98 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDownloadTask.class));
                }
                anyType104 = new AnyType(typeDescriptor98, converters49);
            }
            anyTypeArr68[0] = anyType104;
            AnyType anyType105 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(URI.class), false));
            if (anyType105 == null) {
                try {
                    Result.Companion companion197 = Result.INSTANCE;
                    objM12684constructorimpl99 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(URI.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Coroutine$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(URI.class);
                        }
                    }));
                } catch (Throwable th100) {
                    Result.Companion companion198 = Result.INSTANCE;
                    objM12684constructorimpl99 = Result.m12684constructorimpl(ResultKt.createFailure(th100));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl99)) {
                    objM12684constructorimpl99 = null;
                }
                TypeDescriptor typeDescriptor99 = (TypeDescriptor) objM12684constructorimpl99;
                if (typeDescriptor99 == null) {
                    typeDescriptor99 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(URI.class));
                }
                anyType105 = new AnyType(typeDescriptor99, converters49);
            }
            anyTypeArr68[1] = anyType105;
            AnyType anyType106 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType106 == null) {
                try {
                    Result.Companion companion199 = Result.INSTANCE;
                    objM12684constructorimpl100 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemPath.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Coroutine$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemPath.class);
                        }
                    }));
                } catch (Throwable th101) {
                    Result.Companion companion200 = Result.INSTANCE;
                    objM12684constructorimpl100 = Result.m12684constructorimpl(ResultKt.createFailure(th101));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl100)) {
                    objM12684constructorimpl100 = null;
                }
                TypeDescriptor typeDescriptor100 = (TypeDescriptor) objM12684constructorimpl100;
                if (typeDescriptor100 == null) {
                    typeDescriptor100 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemPath.class));
                }
                anyType106 = new AnyType(typeDescriptor100, converters49);
            }
            anyTypeArr68[2] = anyType106;
            AnyType anyType107 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DownloadTaskOptions.class), true));
            if (anyType107 == null) {
                try {
                    Result.Companion companion201 = Result.INSTANCE;
                    objM12684constructorimpl101 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DownloadTaskOptions.class, true, DownloadTaskOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Coroutine$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(DownloadTaskOptions.class);
                        }
                    }));
                } catch (Throwable th102) {
                    Result.Companion companion202 = Result.INSTANCE;
                    objM12684constructorimpl101 = Result.m12684constructorimpl(ResultKt.createFailure(th102));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl101)) {
                    objM12684constructorimpl101 = null;
                }
                TypeDescriptor typeDescriptor101 = (TypeDescriptor) objM12684constructorimpl101;
                if (typeDescriptor101 == null) {
                    typeDescriptor101 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(DownloadTaskOptions.class));
                }
                anyType107 = new AnyType(typeDescriptor101, converters49);
            }
            anyTypeArr68[3] = anyType107;
            asyncFunctionBuilderAsyncFunction16.setAsyncFunctionComponent(new SuspendFunctionComponent(name16, anyTypeArr68, new FileSystemModule$definition$lambda$87$lambda$82$$inlined$Coroutine$5(null)));
            ClassComponentBuilder classComponentBuilder35 = classComponentBuilder34;
            TypeConverterProvider converters50 = classComponentBuilder35.getConverters();
            AnyType[] anyTypeArr69 = new AnyType[1];
            AnyType anyType108 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDownloadTask.class), false));
            if (anyType108 == null) {
                try {
                    Result.Companion companion203 = Result.INSTANCE;
                    objM12684constructorimpl102 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDownloadTask.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDownloadTask.class);
                        }
                    }));
                } catch (Throwable th103) {
                    Result.Companion companion204 = Result.INSTANCE;
                    objM12684constructorimpl102 = Result.m12684constructorimpl(ResultKt.createFailure(th103));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl102)) {
                    objM12684constructorimpl102 = null;
                }
                TypeDescriptor typeDescriptor102 = (TypeDescriptor) objM12684constructorimpl102;
                if (typeDescriptor102 == null) {
                    typeDescriptor102 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDownloadTask.class));
                }
                anyType108 = new AnyType(typeDescriptor102, converters50);
            }
            anyTypeArr69[0] = anyType108;
            ReturnTypeProvider returnTypeProvider51 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType101 = returnTypeProvider51.getTypes().get(Map.class);
            if (returnType101 == null) {
                JSTypeConverter<?> directConverter51 = ReturnTypeKt.getDirectConverter(Map.class);
                if (directConverter51 == null) {
                    directConverter51 = ReturnTypeKt.getIndirectConverter(Map.class, null);
                }
                ReturnType returnType102 = new ReturnType(directConverter51);
                returnTypeProvider51.getTypes().put(Map.class, returnType102);
                returnType101 = returnType102;
            }
            classComponentBuilder35.getSyncFunctions().put(PauseEvent.TYPE, new SyncFunctionComponent(PauseEvent.TYPE, anyTypeArr69, returnType101, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemDownloadTask) objArr[0]).pause();
                }
            }));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction17 = classComponentBuilder34.AsyncFunction("resume");
            String name17 = asyncFunctionBuilderAsyncFunction17.getName();
            TypeConverterProvider converters51 = asyncFunctionBuilderAsyncFunction17.getConverters();
            AnyType[] anyTypeArr70 = new AnyType[5];
            AnyType anyType109 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDownloadTask.class), false));
            if (anyType109 == null) {
                try {
                    Result.Companion companion205 = Result.INSTANCE;
                    objM12684constructorimpl103 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDownloadTask.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Coroutine$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDownloadTask.class);
                        }
                    }));
                } catch (Throwable th104) {
                    Result.Companion companion206 = Result.INSTANCE;
                    objM12684constructorimpl103 = Result.m12684constructorimpl(ResultKt.createFailure(th104));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl103)) {
                    objM12684constructorimpl103 = null;
                }
                TypeDescriptor typeDescriptor103 = (TypeDescriptor) objM12684constructorimpl103;
                if (typeDescriptor103 == null) {
                    typeDescriptor103 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDownloadTask.class));
                }
                anyType109 = new AnyType(typeDescriptor103, converters51);
            }
            anyTypeArr70[0] = anyType109;
            AnyType anyType110 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(URI.class), false));
            if (anyType110 == null) {
                try {
                    Result.Companion companion207 = Result.INSTANCE;
                    objM12684constructorimpl104 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(URI.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Coroutine$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(URI.class);
                        }
                    }));
                } catch (Throwable th105) {
                    Result.Companion companion208 = Result.INSTANCE;
                    objM12684constructorimpl104 = Result.m12684constructorimpl(ResultKt.createFailure(th105));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl104)) {
                    objM12684constructorimpl104 = null;
                }
                TypeDescriptor typeDescriptor104 = (TypeDescriptor) objM12684constructorimpl104;
                if (typeDescriptor104 == null) {
                    typeDescriptor104 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(URI.class));
                }
                anyType110 = new AnyType(typeDescriptor104, converters51);
            }
            anyTypeArr70[1] = anyType110;
            AnyType anyType111 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType111 == null) {
                try {
                    Result.Companion companion209 = Result.INSTANCE;
                    objM12684constructorimpl105 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemPath.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Coroutine$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemPath.class);
                        }
                    }));
                } catch (Throwable th106) {
                    Result.Companion companion210 = Result.INSTANCE;
                    objM12684constructorimpl105 = Result.m12684constructorimpl(ResultKt.createFailure(th106));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl105)) {
                    objM12684constructorimpl105 = null;
                }
                TypeDescriptor typeDescriptor105 = (TypeDescriptor) objM12684constructorimpl105;
                if (typeDescriptor105 == null) {
                    typeDescriptor105 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemPath.class));
                }
                anyType111 = new AnyType(typeDescriptor105, converters51);
            }
            anyTypeArr70[2] = anyType111;
            AnyType anyType112 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType112 == null) {
                try {
                    Result.Companion companion211 = Result.INSTANCE;
                    objM12684constructorimpl106 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Coroutine$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                } catch (Throwable th107) {
                    Result.Companion companion212 = Result.INSTANCE;
                    objM12684constructorimpl106 = Result.m12684constructorimpl(ResultKt.createFailure(th107));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl106)) {
                    objM12684constructorimpl106 = null;
                }
                TypeDescriptor typeDescriptor106 = (TypeDescriptor) objM12684constructorimpl106;
                if (typeDescriptor106 == null) {
                    typeDescriptor106 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType112 = new AnyType(typeDescriptor106, converters51);
            }
            anyTypeArr70[3] = anyType112;
            AnyType anyType113 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DownloadTaskOptions.class), true));
            if (anyType113 == null) {
                try {
                    Result.Companion companion213 = Result.INSTANCE;
                    objM12684constructorimpl107 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DownloadTaskOptions.class, true, DownloadTaskOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Coroutine$10
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(DownloadTaskOptions.class);
                        }
                    }));
                } catch (Throwable th108) {
                    Result.Companion companion214 = Result.INSTANCE;
                    objM12684constructorimpl107 = Result.m12684constructorimpl(ResultKt.createFailure(th108));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl107)) {
                    objM12684constructorimpl107 = null;
                }
                TypeDescriptor typeDescriptor107 = (TypeDescriptor) objM12684constructorimpl107;
                if (typeDescriptor107 == null) {
                    typeDescriptor107 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(DownloadTaskOptions.class));
                }
                anyType113 = new AnyType(typeDescriptor107, converters51);
            }
            anyTypeArr70[4] = anyType113;
            asyncFunctionBuilderAsyncFunction17.setAsyncFunctionComponent(new SuspendFunctionComponent(name17, anyTypeArr70, new FileSystemModule$definition$lambda$87$lambda$82$$inlined$Coroutine$11(null)));
            ClassComponentBuilder classComponentBuilder36 = classComponentBuilder34;
            TypeConverterProvider converters52 = classComponentBuilder36.getConverters();
            AnyType[] anyTypeArr71 = new AnyType[1];
            AnyType anyType114 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemDownloadTask.class), false));
            if (anyType114 == null) {
                try {
                    Result.Companion companion215 = Result.INSTANCE;
                    objM12684constructorimpl108 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemDownloadTask.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Function$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemDownloadTask.class);
                        }
                    }));
                } catch (Throwable th109) {
                    Result.Companion companion216 = Result.INSTANCE;
                    objM12684constructorimpl108 = Result.m12684constructorimpl(ResultKt.createFailure(th109));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl108)) {
                    objM12684constructorimpl108 = null;
                }
                TypeDescriptor typeDescriptor108 = (TypeDescriptor) objM12684constructorimpl108;
                if (typeDescriptor108 == null) {
                    typeDescriptor108 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemDownloadTask.class));
                }
                anyType114 = new AnyType(typeDescriptor108, converters52);
            }
            anyTypeArr71[0] = anyType114;
            ReturnTypeProvider returnTypeProvider52 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType103 = returnTypeProvider52.getTypes().get(Unit.class);
            if (returnType103 == null) {
                JSTypeConverter<?> directConverter52 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter52 == null) {
                    directConverter52 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType104 = new ReturnType(directConverter52);
                returnTypeProvider52.getTypes().put(Unit.class, returnType104);
                returnType103 = returnType104;
            }
            classComponentBuilder36.getSyncFunctions().put("cancel", new SyncFunctionComponent("cancel", anyTypeArr71, returnType103, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$82$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemDownloadTask) objArr[0]).cancel();
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder10.getClassData().add(classComponentBuilder34.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder11 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(FileSystemWatcher.class);
            Module module6 = moduleDefinitionBuilder11.getModule();
            if (module6 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext6 = module6.getAppContext();
            String simpleName6 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass6).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName6, "getSimpleName(...)");
            AnyType anyType115 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemWatcher.class), false));
            if (anyType115 != null) {
                anyType6 = anyType115;
            } else {
                try {
                    Result.Companion companion217 = Result.INSTANCE;
                    objM12684constructorimpl109 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemWatcher.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Class$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemWatcher.class);
                        }
                    }));
                } catch (Throwable th110) {
                    Result.Companion companion218 = Result.INSTANCE;
                    objM12684constructorimpl109 = Result.m12684constructorimpl(ResultKt.createFailure(th110));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl109)) {
                    objM12684constructorimpl109 = null;
                }
                TypeDescriptor typeDescriptor109 = (TypeDescriptor) objM12684constructorimpl109;
                if (typeDescriptor109 == null) {
                    typeDescriptor109 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemWatcher.class));
                }
                anyType6 = new AnyType(typeDescriptor109, null);
            }
            ClassComponentBuilder classComponentBuilder37 = new ClassComponentBuilder(appContext6, simpleName6, orCreateKotlinClass6, anyType6, moduleDefinitionBuilder11.getConverters());
            classComponentBuilder37.Events("change");
            TypeConverterProvider converters53 = classComponentBuilder37.getConverters();
            AnyType[] anyTypeArr72 = new AnyType[2];
            AnyType anyType116 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Uri.class), false));
            if (anyType116 == null) {
                try {
                    Result.Companion companion219 = Result.INSTANCE;
                    objM12684constructorimpl110 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Uri.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$86$$inlined$Constructor$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Uri.class);
                        }
                    }));
                } catch (Throwable th111) {
                    Result.Companion companion220 = Result.INSTANCE;
                    objM12684constructorimpl110 = Result.m12684constructorimpl(ResultKt.createFailure(th111));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl110)) {
                    objM12684constructorimpl110 = null;
                }
                TypeDescriptor typeDescriptor110 = (TypeDescriptor) objM12684constructorimpl110;
                if (typeDescriptor110 == null) {
                    typeDescriptor110 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Uri.class));
                }
                anyType116 = new AnyType(typeDescriptor110, converters53);
            }
            anyTypeArr72[0] = anyType116;
            AnyType anyType117 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(WatchOptions.class), true));
            if (anyType117 == null) {
                try {
                    Result.Companion companion221 = Result.INSTANCE;
                    objM12684constructorimpl111 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(WatchOptions.class, true, WatchOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$86$$inlined$Constructor$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(WatchOptions.class);
                        }
                    }));
                } catch (Throwable th112) {
                    Result.Companion companion222 = Result.INSTANCE;
                    objM12684constructorimpl111 = Result.m12684constructorimpl(ResultKt.createFailure(th112));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl111)) {
                    objM12684constructorimpl111 = null;
                }
                TypeDescriptor typeDescriptor111 = (TypeDescriptor) objM12684constructorimpl111;
                if (typeDescriptor111 == null) {
                    typeDescriptor111 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(WatchOptions.class));
                }
                anyType117 = new AnyType(typeDescriptor111, converters53);
            }
            anyTypeArr72[1] = anyType117;
            ReturnTypeProvider returnTypeProvider53 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType105 = returnTypeProvider53.getTypes().get(Object.class);
            if (returnType105 == null) {
                JSTypeConverter<?> directConverter53 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter53 == null) {
                    directConverter53 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType106 = new ReturnType(directConverter53);
                returnTypeProvider53.getTypes().put(Object.class, returnType106);
                returnType105 = returnType106;
            }
            classComponentBuilder37.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr72, returnType105, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$86$$inlined$Constructor$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    WatchOptions watchOptions = (WatchOptions) objArr[1];
                    return new FileSystemWatcher(this.this$0.getAppContext(), (Uri) obj, watchOptions);
                }
            }));
            ClassComponentBuilder classComponentBuilder38 = classComponentBuilder37;
            TypeConverterProvider converters54 = classComponentBuilder38.getConverters();
            AnyType[] anyTypeArr73 = new AnyType[1];
            AnyType anyType118 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemWatcher.class), false));
            if (anyType118 == null) {
                try {
                    Result.Companion companion223 = Result.INSTANCE;
                    objM12684constructorimpl112 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemWatcher.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$86$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemWatcher.class);
                        }
                    }));
                } catch (Throwable th113) {
                    Result.Companion companion224 = Result.INSTANCE;
                    objM12684constructorimpl112 = Result.m12684constructorimpl(ResultKt.createFailure(th113));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl112)) {
                    objM12684constructorimpl112 = null;
                }
                TypeDescriptor typeDescriptor112 = (TypeDescriptor) objM12684constructorimpl112;
                if (typeDescriptor112 == null) {
                    typeDescriptor112 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemWatcher.class));
                }
                anyType118 = new AnyType(typeDescriptor112, converters54);
            }
            anyTypeArr73[0] = anyType118;
            ReturnTypeProvider returnTypeProvider54 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType107 = returnTypeProvider54.getTypes().get(Unit.class);
            if (returnType107 == null) {
                JSTypeConverter<?> directConverter54 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter54 == null) {
                    directConverter54 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType108 = new ReturnType(directConverter54);
                returnTypeProvider54.getTypes().put(Unit.class, returnType108);
                returnType107 = returnType108;
            }
            classComponentBuilder38.getSyncFunctions().put(ViewProps.START, new SyncFunctionComponent(ViewProps.START, anyTypeArr73, returnType107, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$86$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemWatcher) objArr[0]).start();
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder39 = classComponentBuilder37;
            TypeConverterProvider converters55 = classComponentBuilder39.getConverters();
            AnyType[] anyTypeArr74 = new AnyType[1];
            AnyType anyType119 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemWatcher.class), false));
            if (anyType119 == null) {
                try {
                    Result.Companion companion225 = Result.INSTANCE;
                    objM12684constructorimpl113 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemWatcher.class, false, null)), new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$86$$inlined$Function$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemWatcher.class);
                        }
                    }));
                } catch (Throwable th114) {
                    Result.Companion companion226 = Result.INSTANCE;
                    objM12684constructorimpl113 = Result.m12684constructorimpl(ResultKt.createFailure(th114));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl113)) {
                    objM12684constructorimpl113 = null;
                }
                TypeDescriptor typeDescriptor113 = (TypeDescriptor) objM12684constructorimpl113;
                if (typeDescriptor113 == null) {
                    typeDescriptor113 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemWatcher.class));
                }
                anyType119 = new AnyType(typeDescriptor113, converters55);
            }
            anyTypeArr74[0] = anyType119;
            ReturnTypeProvider returnTypeProvider55 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType109 = returnTypeProvider55.getTypes().get(Unit.class);
            if (returnType109 == null) {
                JSTypeConverter<?> directConverter55 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter55 == null) {
                    directConverter55 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType110 = new ReturnType(directConverter55);
                returnTypeProvider55.getTypes().put(Unit.class, returnType110);
                returnType109 = returnType110;
            }
            classComponentBuilder39.getSyncFunctions().put("stop", new SyncFunctionComponent("stop", anyTypeArr74, returnType109, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$87$lambda$86$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemWatcher) objArr[0]).stop();
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder11.getClassData().add(classComponentBuilder37.buildClass());
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th115) {
            Trace.endSection();
            throw th115;
        }
    }
}
