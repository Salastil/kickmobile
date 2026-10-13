package expo.modules.filesystem.legacy;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.documentfile.provider.DocumentFile;
import androidx.tracing.Trace;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.OnActivityResultPayload;
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
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import expo.modules.notifications.serverregistration.InstallationId;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.ktor.http.ContentDisposition;
import io.ktor.sse.ServerSentEventKt;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Okio__JvmOkioKt;
import okio.Source;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: FileSystemLegacyModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0005Z[\\]^B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0017J\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0002J\f\u0010\u001d\u001a\u00020\u001b*\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u001a\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010$\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!2\u0006\u0010%\u001a\u00020\u001cH\u0002J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010%\u001a\u00020\u001cH\u0002J \u0010'\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u0014H\u0002J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\"H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020\u001cH\u0002J\u0012\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010\u0014H\u0003J \u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\tH\u0002J(\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002J \u0010>\u001a\u00020?2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u00105\u001a\u00020\tH\u0002J\u0018\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020CH\u0082@¢\u0006\u0002\u0010DJ\u0010\u0010H\u001a\u00020\u00142\u0006\u00105\u001a\u00020\tH\u0002J\u0010\u0010I\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\tH\u0002J\u0010\u0010J\u001a\u00020K2\u0006\u00105\u001a\u00020\tH\u0002J\u001c\u0010L\u001a\u00020+2\u0006\u0010%\u001a\u00020\u001c2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0014H\u0002J\u001a\u0010N\u001a\u00020O2\u0006\u0010%\u001a\u00020\u001c2\b\b\u0002\u0010P\u001a\u000203H\u0002J\u0012\u0010Q\u001a\u0004\u0018\u0001002\u0006\u0010%\u001a\u00020\u001cH\u0002J\f\u0010R\u001a\u00020\t*\u00020\u001cH\u0002J\u0010\u0010U\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u0014H\u0002J\u0010\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010E\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0018\u0010S\u001a\u000203*\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010T¨\u0006_"}, d2 = {"Lexpo/modules/filesystem/legacy/FileSystemLegacyModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "filesDirectory", "Ljava/io/File;", "getFilesDirectory", "()Ljava/io/File;", "cacheDirectory", "getCacheDirectory", "client", "Lokhttp3/OkHttpClient;", "dirPermissionsRequest", "Lexpo/modules/kotlin/Promise;", "taskHandlers", "", "", "Lexpo/modules/filesystem/legacy/FileSystemLegacyModule$TaskHandler;", "moduleCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "checkIfFileExists", "", "Landroid/net/Uri;", "checkIfFileDirExists", "ensureDirExists", "dir", "permissionsForPath", "Ljava/util/EnumSet;", "Lexpo/modules/kotlin/services/FilePermissionService$Permission;", "path", "permissionsForUri", "uri", "permissionsForSAFUri", "ensurePermission", "permission", "errorMsg", "openAssetInputStream", "Ljava/io/InputStream;", "openResourceInputStream", "resourceName", "transformFilesFromSAF", "documentFile", "Landroidx/documentfile/provider/DocumentFile;", "outputDir", "copy", "", "contentUriFromFile", "file", "createUploadRequest", "Lokhttp3/Request;", ImagesContract.URL, "fileUriString", "options", "Lexpo/modules/filesystem/legacy/FileSystemUploadOptions;", "decorator", "Lexpo/modules/filesystem/legacy/RequestBodyDecorator;", "createRequestBody", "Lokhttp3/RequestBody;", "downloadResumableTask", "", "params", "Lexpo/modules/filesystem/legacy/FileSystemLegacyModule$DownloadResumableTaskParams;", "(Lexpo/modules/filesystem/legacy/FileSystemLegacyModule$DownloadResumableTaskParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "okHttpClient", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "md5", "forceDelete", "getFileSize", "", "getInputStream", "uriStr", "getOutputStream", "Ljava/io/OutputStream;", "append", "getNearestSAFFile", "toFile", "isSAFUri", "(Landroid/net/Uri;)Z", "parseFileUri", "translateHeaders", "Landroid/os/Bundle;", "headers", "Lokhttp3/Headers;", "DownloadResumableTaskParams", "TaskHandler", "DownloadTaskHandler", "ProgressResponseBody", "ProgressListener", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class FileSystemLegacyModule extends Module {
    private OkHttpClient client;
    private Promise dirPermissionsRequest;
    private final Map<String, TaskHandler> taskHandlers = new HashMap();
    private final CoroutineScope moduleCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());

    /* JADX INFO: compiled from: FileSystemLegacyModule.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lexpo/modules/filesystem/legacy/FileSystemLegacyModule$ProgressListener;", "", "update", "", "bytesRead", "", "contentLength", "done", "", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ProgressListener {
        void update(long bytesRead, long contentLength, boolean done);
    }

    /* JADX INFO: compiled from: FileSystemLegacyModule.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileSystemUploadType.values().length];
            try {
                iArr[FileSystemUploadType.BINARY_CONTENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileSystemUploadType.MULTIPART.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions.AppContextLost {
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

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        Object objM12684constructorimpl2;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent2;
        Object objM12684constructorimpl5;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent3;
        Object objM12684constructorimpl8;
        Object objM12684constructorimpl9;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent4;
        Object objM12684constructorimpl10;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        Object objM12684constructorimpl11;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        Object objM12684constructorimpl12;
        Object objM12684constructorimpl13;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent7;
        Object objM12684constructorimpl14;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent8;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent9;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent10;
        Object objM12684constructorimpl15;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent11;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4;
        Object objM12684constructorimpl16;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent12;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5;
        Object objM12684constructorimpl17;
        Object objM12684constructorimpl18;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent13;
        Object objM12684constructorimpl19;
        Object objM12684constructorimpl20;
        Object objM12684constructorimpl21;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent14;
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
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Object objM12684constructorimpl34;
        Object objM12684constructorimpl35;
        Object objM12684constructorimpl36;
        Object objM12684constructorimpl37;
        Object objM12684constructorimpl38;
        Object objM12684constructorimpl39;
        UntypedAsyncFunctionComponent stringAsyncFunctionComponent15;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6;
        FileSystemLegacyModule fileSystemLegacyModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (fileSystemLegacyModule.getClass() + ".ModuleDefinition"));
        try {
            final ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(fileSystemLegacyModule);
            moduleDefinitionBuilder.Name("ExponentFileSystem");
            ConstantComponentBuilder constantComponentBuilder = new ConstantComponentBuilder("documentDirectory");
            constantComponentBuilder.setGetter(new Function0<String>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$Constant$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Uri.fromFile(this.this$0.getFilesDirectory()) + DomExceptionUtils.SEPARATOR;
                }
            });
            moduleDefinitionBuilder.getConstants().put("documentDirectory", constantComponentBuilder);
            ConstantComponentBuilder constantComponentBuilder2 = new ConstantComponentBuilder("cacheDirectory");
            constantComponentBuilder2.setGetter(new Function0<String>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$Constant$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Uri.fromFile(this.this$0.getCacheDirectory()) + DomExceptionUtils.SEPARATOR;
                }
            });
            moduleDefinitionBuilder.getConstants().put("cacheDirectory", constantComponentBuilder2);
            ConstantComponentBuilder constantComponentBuilder3 = new ConstantComponentBuilder("bundleDirectory");
            constantComponentBuilder3.setGetter(new Function0<String>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$Constant$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "asset:///";
                }
            });
            moduleDefinitionBuilder.getConstants().put("bundleDirectory", constantComponentBuilder3);
            moduleDefinitionBuilder.Events("expo-file-system.downloadProgress", "expo-file-system.uploadProgress");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    try {
                        FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                        fileSystemLegacyModule2.ensureDirExists(fileSystemLegacyModule2.getFilesDirectory());
                        FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                        fileSystemLegacyModule3.ensureDirExists(fileSystemLegacyModule3.getCacheDirectory());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            Object obj = null;
            if (anyType == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$1
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
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(InfoOptionsLegacy.class), false));
            if (anyType2 == null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(InfoOptionsLegacy.class, false, InfoOptionsLegacy.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(InfoOptionsLegacy.class);
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
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(InfoOptionsLegacy.class));
                }
                anyType2 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[1] = anyType2;
            Function1<Object[], Bundle> function1 = new Function1<Object[], Bundle>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$3
                /* JADX WARN: Code duplicated, block: B:42:0x0137 A[Catch: FileNotFoundException -> 0x0180, TryCatch #0 {FileNotFoundException -> 0x0180, blocks: (B:28:0x00fc, B:30:0x0102, B:35:0x0111, B:37:0x0117, B:44:0x013f, B:46:0x0164, B:48:0x017a, B:49:0x017f, B:38:0x0126, B:41:0x012d, B:42:0x0137), top: B:52:0x00fc }] */
                @Override // kotlin.jvm.functions.Function1
                public final Bundle invoke(Object[] objArr) throws IOException {
                    Uri uri;
                    InputStream inputStreamOpenResourceInputStream;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj2 = objArr[0];
                    InfoOptionsLegacy infoOptionsLegacy = (InfoOptionsLegacy) objArr[1];
                    String strSlashifyFilePath = FileSystemLegacyModuleKt.slashifyFilePath((String) obj2);
                    Uri uri2 = Uri.parse(strSlashifyFilePath);
                    if (Intrinsics.areEqual(uri2.getScheme(), "file")) {
                        FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                        Intrinsics.checkNotNull(strSlashifyFilePath, "null cannot be cast to non-null type kotlin.String");
                        strSlashifyFilePath = fileSystemLegacyModule2.parseFileUri(strSlashifyFilePath);
                        uri = Uri.parse(strSlashifyFilePath);
                    } else {
                        uri = uri2;
                    }
                    FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                    Intrinsics.checkNotNull(uri);
                    fileSystemLegacyModule3.ensurePermission(uri, FilePermissionService.Permission.READ);
                    if (Intrinsics.areEqual(uri2.getScheme(), "file")) {
                        FileSystemLegacyModule fileSystemLegacyModule4 = this.this$0;
                        Intrinsics.checkNotNull(uri);
                        File file = fileSystemLegacyModule4.toFile(uri);
                        if (!file.exists()) {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("exists", false);
                            bundle.putBoolean("isDirectory", false);
                            return bundle;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("exists", true);
                        bundle2.putBoolean("isDirectory", file.isDirectory());
                        bundle2.putString("uri", Uri.fromFile(file).toString());
                        bundle2.putDouble(ContentDisposition.Parameters.Size, this.this$0.getFileSize(file));
                        bundle2.putDouble("modificationTime", file.lastModified() * 0.001d);
                        Boolean md5 = infoOptionsLegacy.getMd5();
                        if (!Intrinsics.areEqual((Object) md5, (Object) true)) {
                            md5 = null;
                        }
                        if (md5 != null) {
                            md5.booleanValue();
                            bundle2.putString("md5", this.this$0.md5(file));
                        }
                        return bundle2;
                    }
                    if (!Intrinsics.areEqual(uri2.getScheme(), "content") && !Intrinsics.areEqual(uri2.getScheme(), UriUtil.LOCAL_ASSET_SCHEME) && uri2.getScheme() != null) {
                        throw new IOException("Unsupported scheme for location '" + uri2 + "'.");
                    }
                    try {
                        String scheme = uri2.getScheme();
                        if (scheme == null) {
                            inputStreamOpenResourceInputStream = this.this$0.openResourceInputStream(strSlashifyFilePath);
                        } else {
                            int iHashCode = scheme.hashCode();
                            if (iHashCode != 93121264) {
                                if (iHashCode == 951530617 && scheme.equals("content")) {
                                    inputStreamOpenResourceInputStream = this.this$0.getContext().getContentResolver().openInputStream(uri2);
                                } else {
                                    inputStreamOpenResourceInputStream = this.this$0.openResourceInputStream(strSlashifyFilePath);
                                }
                            } else if (scheme.equals(UriUtil.LOCAL_ASSET_SCHEME)) {
                                FileSystemLegacyModule fileSystemLegacyModule5 = this.this$0;
                                Intrinsics.checkNotNull(uri2);
                                inputStreamOpenResourceInputStream = fileSystemLegacyModule5.openAssetInputStream(uri2);
                            } else {
                                inputStreamOpenResourceInputStream = this.this$0.openResourceInputStream(strSlashifyFilePath);
                            }
                        }
                        if (inputStreamOpenResourceInputStream == null) {
                            throw new FileNotFoundException();
                        }
                        Bundle bundle3 = new Bundle();
                        bundle3.putBoolean("exists", true);
                        bundle3.putBoolean("isDirectory", false);
                        bundle3.putString("uri", uri2.toString());
                        bundle3.putDouble(ContentDisposition.Parameters.Size, inputStreamOpenResourceInputStream.available());
                        if (Intrinsics.areEqual((Object) infoOptionsLegacy.getMd5(), (Object) true)) {
                            char[] cArrEncodeHex = Hex.encodeHex(DigestUtils.md5(inputStreamOpenResourceInputStream));
                            Intrinsics.checkNotNullExpressionValue(cArrEncodeHex, "encodeHex(...)");
                            bundle3.putString("md5", new String(cArrEncodeHex));
                        }
                        return bundle3;
                    } catch (FileNotFoundException unused) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putBoolean("exists", false);
                        bundle4.putBoolean("isDirectory", false);
                        return bundle4;
                    }
                }
            };
            if (Intrinsics.areEqual(Bundle.class, Integer.TYPE)) {
                stringAsyncFunctionComponent = new IntAsyncFunctionComponent("getInfoAsync", anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Bundle.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent = new BoolAsyncFunctionComponent("getInfoAsync", anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Bundle.class, Double.TYPE)) {
                stringAsyncFunctionComponent = new DoubleAsyncFunctionComponent("getInfoAsync", anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Bundle.class, Float.TYPE)) {
                stringAsyncFunctionComponent = new FloatAsyncFunctionComponent("getInfoAsync", anyTypeArr, function1);
            } else {
                stringAsyncFunctionComponent = Intrinsics.areEqual(Bundle.class, String.class) ? new StringAsyncFunctionComponent("getInfoAsync", anyTypeArr, function1) : new UntypedAsyncFunctionComponent("getInfoAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("getInfoAsync", stringAsyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType3 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$4
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
                anyType3 = new AnyType(typeDescriptor3, converters2);
            }
            anyTypeArr2[0] = anyType3;
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ReadingOptions.class), false));
            if (anyType4 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ReadingOptions.class, false, ReadingOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ReadingOptions.class);
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
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ReadingOptions.class));
                }
                anyType4 = new AnyType(typeDescriptor4, converters2);
            }
            anyTypeArr2[1] = anyType4;
            Function1<Object[], String> function2 = new Function1<Object[], String>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Object[] objArr) throws IOException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj2 = objArr[0];
                    ReadingOptions readingOptions = (ReadingOptions) objArr[1];
                    String str = (String) obj2;
                    Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(str));
                    FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                    Intrinsics.checkNotNull(uri);
                    fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.READ);
                    EncodingType encoding = readingOptions.getEncoding();
                    InputStream inputStream = this.this$0.getInputStream(uri, str);
                    try {
                        String inputStreamAsString = FileSystemLegacyReaderKt.readInputStreamAsString(inputStream, encoding, readingOptions);
                        CloseableKt.closeFinally(inputStream, null);
                        return inputStreamAsString;
                    } catch (Throwable th5) {
                        try {
                            throw th5;
                        } catch (Throwable th6) {
                            CloseableKt.closeFinally(inputStream, th5);
                            throw th6;
                        }
                    }
                }
            };
            if (Intrinsics.areEqual(String.class, Integer.TYPE)) {
                stringAsyncFunctionComponent2 = new IntAsyncFunctionComponent("readAsStringAsync", anyTypeArr2, function2);
            } else if (Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("readAsStringAsync", anyTypeArr2, function2);
            } else if (Intrinsics.areEqual(String.class, Double.TYPE)) {
                stringAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("readAsStringAsync", anyTypeArr2, function2);
            } else if (Intrinsics.areEqual(String.class, Float.TYPE)) {
                stringAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("readAsStringAsync", anyTypeArr2, function2);
            } else {
                stringAsyncFunctionComponent2 = Intrinsics.areEqual(String.class, String.class) ? new StringAsyncFunctionComponent("readAsStringAsync", anyTypeArr2, function2) : new UntypedAsyncFunctionComponent("readAsStringAsync", anyTypeArr2, function2);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("readAsStringAsync", stringAsyncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            TypeConverterProvider converters3 = moduleDefinitionBuilder4.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[3];
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$7
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
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType6 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$8
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
                anyType6 = new AnyType(typeDescriptor6, converters3);
            }
            anyTypeArr3[1] = anyType6;
            AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(WritingOptions.class), false));
            if (anyType7 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(WritingOptions.class, false, WritingOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(WritingOptions.class);
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
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(WritingOptions.class));
                }
                anyType7 = new AnyType(typeDescriptor7, converters3);
            }
            anyTypeArr3[2] = anyType7;
            Function1<Object[], Unit> function3 = new Function1<Object[], Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws IOException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    WritingOptions writingOptions = (WritingOptions) objArr[2];
                    String str = (String) obj3;
                    Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath((String) obj2));
                    FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                    Intrinsics.checkNotNull(uri);
                    fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.WRITE);
                    EncodingType encoding = writingOptions.getEncoding();
                    OutputStream outputStream = this.this$0.getOutputStream(uri, writingOptions.getAppend());
                    try {
                        OutputStream outputStream2 = outputStream;
                        if (encoding == EncodingType.BASE64) {
                            outputStream2.write(Base64.decode(str, 0));
                        } else {
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream2);
                            try {
                                outputStreamWriter.write(str);
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(outputStreamWriter, null);
                            } catch (Throwable th8) {
                                try {
                                    throw th8;
                                } catch (Throwable th9) {
                                    CloseableKt.closeFinally(outputStreamWriter, th8);
                                    throw th9;
                                }
                            }
                        }
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(outputStream, null);
                        return Unit.INSTANCE;
                    } catch (Throwable th10) {
                        try {
                            throw th10;
                        } catch (Throwable th11) {
                            CloseableKt.closeFinally(outputStream, th10);
                            throw th11;
                        }
                    }
                }
            };
            if (Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                stringAsyncFunctionComponent3 = new IntAsyncFunctionComponent("writeAsStringAsync", anyTypeArr3, function3);
            } else if (Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("writeAsStringAsync", anyTypeArr3, function3);
            } else if (Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                stringAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("writeAsStringAsync", anyTypeArr3, function3);
            } else if (Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                stringAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("writeAsStringAsync", anyTypeArr3, function3);
            } else {
                stringAsyncFunctionComponent3 = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("writeAsStringAsync", anyTypeArr3, function3) : new UntypedAsyncFunctionComponent("writeAsStringAsync", anyTypeArr3, function3);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("writeAsStringAsync", stringAsyncFunctionComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            TypeConverterProvider converters4 = moduleDefinitionBuilder5.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[2];
            AnyType anyType8 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType8 == null) {
                try {
                    Result.Companion companion15 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType8 = new AnyType(typeDescriptor8, converters4);
            }
            anyTypeArr4[0] = anyType8;
            AnyType anyType9 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DeletingOptions.class), false));
            if (anyType9 == null) {
                try {
                    Result.Companion companion17 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DeletingOptions.class, false, DeletingOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$12
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(DeletingOptions.class);
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
                    typeDescriptor9 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(DeletingOptions.class));
                }
                anyType9 = new AnyType(typeDescriptor9, converters4);
            }
            anyTypeArr4[1] = anyType9;
            Function1<Object[], Unit> function4 = new Function1<Object[], Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$13
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws FileSystemFileNotFoundException, IOException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj2 = objArr[0];
                    DeletingOptions deletingOptions = (DeletingOptions) objArr[1];
                    Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath((String) obj2));
                    Uri uriWithAppendedPath = Uri.withAppendedPath(uri, "..");
                    FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                    Intrinsics.checkNotNull(uriWithAppendedPath);
                    fileSystemLegacyModule2.ensurePermission(uriWithAppendedPath, FilePermissionService.Permission.WRITE, "Location '" + uri + "' isn't deletable.");
                    boolean zAreEqual = Intrinsics.areEqual(uri.getScheme(), "file");
                    FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                    if (zAreEqual) {
                        Intrinsics.checkNotNull(uri);
                        File file = fileSystemLegacyModule3.toFile(uri);
                        if (file.exists()) {
                            if (Build.VERSION.SDK_INT < 26) {
                                this.this$0.forceDelete(file);
                            } else {
                                FileUtils.forceDelete(file);
                            }
                        } else if (!deletingOptions.getIdempotent()) {
                            throw new FileSystemFileNotFoundException(uri);
                        }
                    } else {
                        Intrinsics.checkNotNull(uri);
                        if (fileSystemLegacyModule3.isSAFUri(uri)) {
                            DocumentFile nearestSAFFile = this.this$0.getNearestSAFFile(uri);
                            if (nearestSAFFile != null && nearestSAFFile.exists()) {
                                nearestSAFFile.delete();
                            } else if (!deletingOptions.getIdempotent()) {
                                throw new FileSystemFileNotFoundException(uri);
                            }
                        } else {
                            throw new IOException("Unsupported scheme for location '" + uri + "'.");
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            if (Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                stringAsyncFunctionComponent4 = new IntAsyncFunctionComponent("deleteAsync", anyTypeArr4, function4);
            } else if (Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent4 = new BoolAsyncFunctionComponent("deleteAsync", anyTypeArr4, function4);
            } else if (Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                stringAsyncFunctionComponent4 = new DoubleAsyncFunctionComponent("deleteAsync", anyTypeArr4, function4);
            } else if (Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                stringAsyncFunctionComponent4 = new FloatAsyncFunctionComponent("deleteAsync", anyTypeArr4, function4);
            } else {
                stringAsyncFunctionComponent4 = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("deleteAsync", anyTypeArr4, function4) : new UntypedAsyncFunctionComponent("deleteAsync", anyTypeArr4, function4);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("deleteAsync", stringAsyncFunctionComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(RelocatingOptions.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("moveAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$14
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws FileSystemCannotMoveFileException, IOException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        RelocatingOptions relocatingOptions = (RelocatingOptions) promise;
                        Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(relocatingOptions.getFrom()));
                        FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                        Uri uriWithAppendedPath = Uri.withAppendedPath(uri, "..");
                        Intrinsics.checkNotNullExpressionValue(uriWithAppendedPath, "withAppendedPath(...)");
                        fileSystemLegacyModule2.ensurePermission(uriWithAppendedPath, FilePermissionService.Permission.WRITE, "Location '" + uri + "' isn't movable.");
                        Uri uri2 = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(relocatingOptions.getTo()));
                        FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                        Intrinsics.checkNotNull(uri2);
                        fileSystemLegacyModule3.ensurePermission(uri2, FilePermissionService.Permission.WRITE);
                        boolean zAreEqual = Intrinsics.areEqual(uri.getScheme(), "file");
                        FileSystemLegacyModule fileSystemLegacyModule4 = this.this$0;
                        if (zAreEqual) {
                            Intrinsics.checkNotNull(uri);
                            if (!fileSystemLegacyModule4.toFile(uri).renameTo(this.this$0.toFile(uri2))) {
                                throw new FileSystemCannotMoveFileException(uri, uri2);
                            }
                            return;
                        }
                        Intrinsics.checkNotNull(uri);
                        if (fileSystemLegacyModule4.isSAFUri(uri)) {
                            DocumentFile nearestSAFFile = this.this$0.getNearestSAFFile(uri);
                            if (nearestSAFFile != null && nearestSAFFile.exists()) {
                                this.this$0.transformFilesFromSAF(nearestSAFFile, this.this$0.toFile(uri2), false);
                                return;
                            }
                            throw new FileSystemCannotMoveFileException(uri, uri2);
                        }
                        throw new IOException("Unsupported scheme for location '" + uri + "'.");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws FileSystemCannotMoveFileException, IOException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters5 = moduleDefinitionBuilder6.getConverters();
                AnyType[] anyTypeArr5 = new AnyType[1];
                AnyType anyType10 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RelocatingOptions.class), false));
                if (anyType10 == null) {
                    try {
                        Result.Companion companion19 = Result.INSTANCE;
                        objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RelocatingOptions.class, false, RelocatingOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$15
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(RelocatingOptions.class);
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
                        typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(RelocatingOptions.class));
                    }
                    anyType10 = new AnyType(typeDescriptor10, converters5);
                }
                anyTypeArr5[0] = anyType10;
                Function1<Object[], Unit> function5 = new Function1<Object[], Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$16
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws FileSystemCannotMoveFileException, IOException {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        RelocatingOptions relocatingOptions = (RelocatingOptions) objArr[0];
                        Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(relocatingOptions.getFrom()));
                        FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                        Uri uriWithAppendedPath = Uri.withAppendedPath(uri, "..");
                        Intrinsics.checkNotNullExpressionValue(uriWithAppendedPath, "withAppendedPath(...)");
                        fileSystemLegacyModule2.ensurePermission(uriWithAppendedPath, FilePermissionService.Permission.WRITE, "Location '" + uri + "' isn't movable.");
                        Uri uri2 = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(relocatingOptions.getTo()));
                        FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                        Intrinsics.checkNotNull(uri2);
                        fileSystemLegacyModule3.ensurePermission(uri2, FilePermissionService.Permission.WRITE);
                        boolean zAreEqual = Intrinsics.areEqual(uri.getScheme(), "file");
                        FileSystemLegacyModule fileSystemLegacyModule4 = this.this$0;
                        if (zAreEqual) {
                            Intrinsics.checkNotNull(uri);
                            if (!fileSystemLegacyModule4.toFile(uri).renameTo(this.this$0.toFile(uri2))) {
                                throw new FileSystemCannotMoveFileException(uri, uri2);
                            }
                        } else {
                            Intrinsics.checkNotNull(uri);
                            if (fileSystemLegacyModule4.isSAFUri(uri)) {
                                DocumentFile nearestSAFFile = this.this$0.getNearestSAFFile(uri);
                                if (nearestSAFFile != null && nearestSAFFile.exists()) {
                                    this.this$0.transformFilesFromSAF(nearestSAFFile, this.this$0.toFile(uri2), false);
                                } else {
                                    throw new FileSystemCannotMoveFileException(uri, uri2);
                                }
                            } else {
                                throw new IOException("Unsupported scheme for location '" + uri + "'.");
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    stringAsyncFunctionComponent5 = new IntAsyncFunctionComponent("moveAsync", anyTypeArr5, function5);
                } else if (Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    stringAsyncFunctionComponent5 = new BoolAsyncFunctionComponent("moveAsync", anyTypeArr5, function5);
                } else if (Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                    stringAsyncFunctionComponent5 = new DoubleAsyncFunctionComponent("moveAsync", anyTypeArr5, function5);
                } else if (Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                    stringAsyncFunctionComponent5 = new FloatAsyncFunctionComponent("moveAsync", anyTypeArr5, function5);
                } else {
                    stringAsyncFunctionComponent5 = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("moveAsync", anyTypeArr5, function5) : new UntypedAsyncFunctionComponent("moveAsync", anyTypeArr5, function5);
                }
                asyncFunctionWithPromiseComponent = stringAsyncFunctionComponent5;
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("moveAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(RelocatingOptions.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("copyAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$17
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws IOException, FileSystemCopyFailedException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        RelocatingOptions relocatingOptions = (RelocatingOptions) promise;
                        Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(relocatingOptions.getFrom()));
                        FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                        Intrinsics.checkNotNull(uri);
                        fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.READ, "Location '" + uri + "' isn't readable.");
                        Uri uri2 = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(relocatingOptions.getTo()));
                        FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                        Intrinsics.checkNotNull(uri2);
                        fileSystemLegacyModule3.ensurePermission(uri2, FilePermissionService.Permission.WRITE);
                        boolean zAreEqual = Intrinsics.areEqual(uri.getScheme(), "file");
                        FileSystemLegacyModule fileSystemLegacyModule4 = this.this$0;
                        if (zAreEqual) {
                            File file = fileSystemLegacyModule4.toFile(uri);
                            File file2 = this.this$0.toFile(uri2);
                            if (file.isDirectory()) {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    FileUtils.copyDirectory(file, file2);
                                    return;
                                } else {
                                    FilesKt.copyRecursively$default(file, file2, true, null, 4, null);
                                    return;
                                }
                            }
                            if (Build.VERSION.SDK_INT >= 26) {
                                FileUtils.copyFile(file, file2);
                                return;
                            } else {
                                FilesKt.copyTo$default(file, file2, true, 0, 4, null);
                                return;
                            }
                        }
                        if (fileSystemLegacyModule4.isSAFUri(uri)) {
                            DocumentFile nearestSAFFile = this.this$0.getNearestSAFFile(uri);
                            if (nearestSAFFile != null && nearestSAFFile.exists()) {
                                this.this$0.transformFilesFromSAF(nearestSAFFile, this.this$0.toFile(uri2), true);
                                return;
                            }
                            throw new FileSystemCopyFailedException(uri);
                        }
                        if (Intrinsics.areEqual(uri.getScheme(), "content")) {
                            IOUtils.copy(this.this$0.getContext().getContentResolver().openInputStream(uri), new FileOutputStream(this.this$0.toFile(uri2)));
                            return;
                        }
                        if (Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_ASSET_SCHEME)) {
                            IOUtils.copy(this.this$0.openAssetInputStream(uri), new FileOutputStream(this.this$0.toFile(uri2)));
                        } else {
                            if (uri.getScheme() == null) {
                                IOUtils.copy(this.this$0.openResourceInputStream(relocatingOptions.getFrom()), new FileOutputStream(this.this$0.toFile(uri2)));
                                return;
                            }
                            throw new IOException("Unsupported scheme for location '" + uri + "'.");
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws IOException, FileSystemCopyFailedException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters6 = moduleDefinitionBuilder7.getConverters();
                AnyType[] anyTypeArr6 = new AnyType[1];
                AnyType anyType11 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RelocatingOptions.class), false));
                if (anyType11 == null) {
                    try {
                        Result.Companion companion21 = Result.INSTANCE;
                        objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RelocatingOptions.class, false, RelocatingOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$18
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(RelocatingOptions.class);
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
                        typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(RelocatingOptions.class));
                    }
                    anyType11 = new AnyType(typeDescriptor11, converters6);
                }
                anyTypeArr6[0] = anyType11;
                Function1<Object[], Object> function6 = new Function1<Object[], Object>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] objArr) throws IOException, FileSystemCopyFailedException {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        RelocatingOptions relocatingOptions = (RelocatingOptions) objArr[0];
                        Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(relocatingOptions.getFrom()));
                        FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                        Intrinsics.checkNotNull(uri);
                        fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.READ, "Location '" + uri + "' isn't readable.");
                        Uri uri2 = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(relocatingOptions.getTo()));
                        FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                        Intrinsics.checkNotNull(uri2);
                        fileSystemLegacyModule3.ensurePermission(uri2, FilePermissionService.Permission.WRITE);
                        boolean zAreEqual = Intrinsics.areEqual(uri.getScheme(), "file");
                        FileSystemLegacyModule fileSystemLegacyModule4 = this.this$0;
                        if (zAreEqual) {
                            File file = fileSystemLegacyModule4.toFile(uri);
                            File file2 = this.this$0.toFile(uri2);
                            if (file.isDirectory()) {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    FileUtils.copyDirectory(file, file2);
                                    return Unit.INSTANCE;
                                }
                                return Boolean.valueOf(FilesKt.copyRecursively$default(file, file2, true, null, 4, null));
                            }
                            if (Build.VERSION.SDK_INT >= 26) {
                                FileUtils.copyFile(file, file2);
                                return Unit.INSTANCE;
                            }
                            return FilesKt.copyTo$default(file, file2, true, 0, 4, null);
                        }
                        if (fileSystemLegacyModule4.isSAFUri(uri)) {
                            DocumentFile nearestSAFFile = this.this$0.getNearestSAFFile(uri);
                            if (nearestSAFFile != null && nearestSAFFile.exists()) {
                                this.this$0.transformFilesFromSAF(nearestSAFFile, this.this$0.toFile(uri2), true);
                                return Unit.INSTANCE;
                            }
                            throw new FileSystemCopyFailedException(uri);
                        }
                        if (Intrinsics.areEqual(uri.getScheme(), "content")) {
                            return Integer.valueOf(IOUtils.copy(this.this$0.getContext().getContentResolver().openInputStream(uri), new FileOutputStream(this.this$0.toFile(uri2))));
                        }
                        if (Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_ASSET_SCHEME)) {
                            return Integer.valueOf(IOUtils.copy(this.this$0.openAssetInputStream(uri), new FileOutputStream(this.this$0.toFile(uri2))));
                        }
                        if (uri.getScheme() == null) {
                            return Integer.valueOf(IOUtils.copy(this.this$0.openResourceInputStream(relocatingOptions.getFrom()), new FileOutputStream(this.this$0.toFile(uri2))));
                        }
                        throw new IOException("Unsupported scheme for location '" + uri + "'.");
                    }
                };
                if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
                    stringAsyncFunctionComponent6 = new IntAsyncFunctionComponent("copyAsync", anyTypeArr6, function6);
                } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
                    stringAsyncFunctionComponent6 = new BoolAsyncFunctionComponent("copyAsync", anyTypeArr6, function6);
                } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
                    stringAsyncFunctionComponent6 = new DoubleAsyncFunctionComponent("copyAsync", anyTypeArr6, function6);
                } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
                    stringAsyncFunctionComponent6 = new FloatAsyncFunctionComponent("copyAsync", anyTypeArr6, function6);
                } else {
                    stringAsyncFunctionComponent6 = Intrinsics.areEqual(Object.class, String.class) ? new StringAsyncFunctionComponent("copyAsync", anyTypeArr6, function6) : new UntypedAsyncFunctionComponent("copyAsync", anyTypeArr6, function6);
                }
                asyncFunctionWithPromiseComponent2 = stringAsyncFunctionComponent6;
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("copyAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            TypeConverterProvider converters7 = moduleDefinitionBuilder8.getConverters();
            AnyType[] anyTypeArr7 = new AnyType[2];
            AnyType anyType12 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType12 == null) {
                try {
                    Result.Companion companion23 = Result.INSTANCE;
                    objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$20
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
                anyType12 = new AnyType(typeDescriptor12, converters7);
            }
            anyTypeArr7[0] = anyType12;
            AnyType anyType13 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(MakeDirectoryOptions.class), false));
            if (anyType13 == null) {
                try {
                    Result.Companion companion25 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(MakeDirectoryOptions.class, false, MakeDirectoryOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$21
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(MakeDirectoryOptions.class);
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
                    typeDescriptor13 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(MakeDirectoryOptions.class));
                }
                anyType13 = new AnyType(typeDescriptor13, converters7);
            }
            anyTypeArr7[1] = anyType13;
            Function1<Object[], Unit> function7 = new Function1<Object[], Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$22
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws FileSystemCannotCreateDirectoryException, IOException {
                    boolean zMkdir;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj2 = objArr[0];
                    MakeDirectoryOptions makeDirectoryOptions = (MakeDirectoryOptions) objArr[1];
                    Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath((String) obj2));
                    FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                    Intrinsics.checkNotNull(uri);
                    fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.WRITE);
                    if (!Intrinsics.areEqual(uri.getScheme(), "file")) {
                        throw new IOException("Unsupported scheme for location '" + uri + "'.");
                    }
                    File file = this.this$0.toFile(uri);
                    boolean zIsDirectory = file.isDirectory();
                    boolean intermediates = makeDirectoryOptions.getIntermediates();
                    if (intermediates) {
                        zMkdir = file.mkdirs();
                    } else {
                        zMkdir = file.mkdir();
                    }
                    if (!zMkdir && (!intermediates || !zIsDirectory)) {
                        throw new FileSystemCannotCreateDirectoryException(uri);
                    }
                    return Unit.INSTANCE;
                }
            };
            if (Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                stringAsyncFunctionComponent7 = new IntAsyncFunctionComponent("makeDirectoryAsync", anyTypeArr7, function7);
            } else if (Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent7 = new BoolAsyncFunctionComponent("makeDirectoryAsync", anyTypeArr7, function7);
            } else if (Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                stringAsyncFunctionComponent7 = new DoubleAsyncFunctionComponent("makeDirectoryAsync", anyTypeArr7, function7);
            } else if (Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                stringAsyncFunctionComponent7 = new FloatAsyncFunctionComponent("makeDirectoryAsync", anyTypeArr7, function7);
            } else {
                stringAsyncFunctionComponent7 = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("makeDirectoryAsync", anyTypeArr7, function7) : new UntypedAsyncFunctionComponent("makeDirectoryAsync", anyTypeArr7, function7);
            }
            moduleDefinitionBuilder8.getAsyncFunctions().put("makeDirectoryAsync", stringAsyncFunctionComponent7);
            ModuleDefinitionBuilder moduleDefinitionBuilder9 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("readDirectoryAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$23
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws FileSystemCannotReadDirectoryException, IOException, FileSystemUnsupportedSchemeException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath((String) promise));
                        FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                        Intrinsics.checkNotNull(uri);
                        fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.READ);
                        boolean zAreEqual = Intrinsics.areEqual(uri.getScheme(), "file");
                        FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                        if (!zAreEqual) {
                            if (fileSystemLegacyModule3.isSAFUri(uri)) {
                                throw new FileSystemUnsupportedSchemeException();
                            }
                            throw new IOException("Unsupported scheme for location '" + uri + "'.");
                        }
                        File[] fileArrListFiles = fileSystemLegacyModule3.toFile(uri).listFiles();
                        if (fileArrListFiles == null) {
                            throw new FileSystemCannotReadDirectoryException(uri);
                        }
                        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
                        int length = fileArrListFiles.length;
                        for (int i = 0; i < length; i++) {
                            File file = fileArrListFiles[i];
                            arrayList.add(file != null ? file.getName() : null);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws FileSystemCannotReadDirectoryException, IOException, FileSystemUnsupportedSchemeException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters8 = moduleDefinitionBuilder9.getConverters();
                AnyType[] anyTypeArr8 = new AnyType[1];
                AnyType anyType14 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
                if (anyType14 == null) {
                    try {
                        Result.Companion companion27 = Result.INSTANCE;
                        objM12684constructorimpl14 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$24
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.nullableTypeOf(String.class);
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
                        typeDescriptor14 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                    }
                    anyType14 = new AnyType(typeDescriptor14, converters8);
                }
                anyTypeArr8[0] = anyType14;
                Function1<Object[], List<? extends String>> function8 = new Function1<Object[], List<? extends String>>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$25
                    @Override // kotlin.jvm.functions.Function1
                    public final List<? extends String> invoke(Object[] objArr) throws FileSystemCannotReadDirectoryException, IOException, FileSystemUnsupportedSchemeException {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath((String) objArr[0]));
                        FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                        Intrinsics.checkNotNull(uri);
                        fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.READ);
                        boolean zAreEqual = Intrinsics.areEqual(uri.getScheme(), "file");
                        FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                        if (!zAreEqual) {
                            if (fileSystemLegacyModule3.isSAFUri(uri)) {
                                throw new FileSystemUnsupportedSchemeException();
                            }
                            throw new IOException("Unsupported scheme for location '" + uri + "'.");
                        }
                        File[] fileArrListFiles = fileSystemLegacyModule3.toFile(uri).listFiles();
                        if (fileArrListFiles == null) {
                            throw new FileSystemCannotReadDirectoryException(uri);
                        }
                        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
                        int length = fileArrListFiles.length;
                        for (int i = 0; i < length; i++) {
                            File file = fileArrListFiles[i];
                            arrayList.add(file != null ? file.getName() : null);
                        }
                        return arrayList;
                    }
                };
                if (Intrinsics.areEqual(List.class, Integer.TYPE)) {
                    stringAsyncFunctionComponent8 = new IntAsyncFunctionComponent("readDirectoryAsync", anyTypeArr8, function8);
                } else if (Intrinsics.areEqual(List.class, Boolean.TYPE)) {
                    stringAsyncFunctionComponent8 = new BoolAsyncFunctionComponent("readDirectoryAsync", anyTypeArr8, function8);
                } else if (Intrinsics.areEqual(List.class, Double.TYPE)) {
                    stringAsyncFunctionComponent8 = new DoubleAsyncFunctionComponent("readDirectoryAsync", anyTypeArr8, function8);
                } else if (Intrinsics.areEqual(List.class, Float.TYPE)) {
                    stringAsyncFunctionComponent8 = new FloatAsyncFunctionComponent("readDirectoryAsync", anyTypeArr8, function8);
                } else {
                    stringAsyncFunctionComponent8 = Intrinsics.areEqual(List.class, String.class) ? new StringAsyncFunctionComponent("readDirectoryAsync", anyTypeArr8, function8) : new UntypedAsyncFunctionComponent("readDirectoryAsync", anyTypeArr8, function8);
                }
                asyncFunctionWithPromiseComponent3 = stringAsyncFunctionComponent8;
            }
            moduleDefinitionBuilder9.getAsyncFunctions().put("readDirectoryAsync", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder10 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr9 = new AnyType[0];
            Function1<Object[], Double> function9 = new Function1<Object[], Double>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$26
                @Override // kotlin.jvm.functions.Function1
                public final Double invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
                    return Double.valueOf(RangesKt.coerceAtMost(BigInteger.valueOf(statFs.getBlockCountLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).doubleValue(), Math.pow(2.0d, 53.0d) - 1.0d));
                }
            };
            if (Intrinsics.areEqual(Double.class, Integer.TYPE)) {
                stringAsyncFunctionComponent9 = new IntAsyncFunctionComponent("getTotalDiskCapacityAsync", anyTypeArr9, function9);
            } else if (Intrinsics.areEqual(Double.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent9 = new BoolAsyncFunctionComponent("getTotalDiskCapacityAsync", anyTypeArr9, function9);
            } else if (Intrinsics.areEqual(Double.class, Double.TYPE)) {
                stringAsyncFunctionComponent9 = new DoubleAsyncFunctionComponent("getTotalDiskCapacityAsync", anyTypeArr9, function9);
            } else if (Intrinsics.areEqual(Double.class, Float.TYPE)) {
                stringAsyncFunctionComponent9 = new FloatAsyncFunctionComponent("getTotalDiskCapacityAsync", anyTypeArr9, function9);
            } else {
                stringAsyncFunctionComponent9 = Intrinsics.areEqual(Double.class, String.class) ? new StringAsyncFunctionComponent("getTotalDiskCapacityAsync", anyTypeArr9, function9) : new UntypedAsyncFunctionComponent("getTotalDiskCapacityAsync", anyTypeArr9, function9);
            }
            moduleDefinitionBuilder10.getAsyncFunctions().put("getTotalDiskCapacityAsync", stringAsyncFunctionComponent9);
            ModuleDefinitionBuilder moduleDefinitionBuilder11 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr10 = new AnyType[0];
            Function1<Object[], Double> function10 = new Function1<Object[], Double>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$27
                @Override // kotlin.jvm.functions.Function1
                public final Double invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
                    return Double.valueOf(RangesKt.coerceAtMost(BigInteger.valueOf(statFs.getAvailableBlocksLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).doubleValue(), Math.pow(2.0d, 53.0d) - 1.0d));
                }
            };
            if (Intrinsics.areEqual(Double.class, Integer.TYPE)) {
                stringAsyncFunctionComponent10 = new IntAsyncFunctionComponent("getFreeDiskStorageAsync", anyTypeArr10, function10);
            } else if (Intrinsics.areEqual(Double.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent10 = new BoolAsyncFunctionComponent("getFreeDiskStorageAsync", anyTypeArr10, function10);
            } else if (Intrinsics.areEqual(Double.class, Double.TYPE)) {
                stringAsyncFunctionComponent10 = new DoubleAsyncFunctionComponent("getFreeDiskStorageAsync", anyTypeArr10, function10);
            } else if (Intrinsics.areEqual(Double.class, Float.TYPE)) {
                stringAsyncFunctionComponent10 = new FloatAsyncFunctionComponent("getFreeDiskStorageAsync", anyTypeArr10, function10);
            } else {
                stringAsyncFunctionComponent10 = Intrinsics.areEqual(Double.class, String.class) ? new StringAsyncFunctionComponent("getFreeDiskStorageAsync", anyTypeArr10, function10) : new UntypedAsyncFunctionComponent("getFreeDiskStorageAsync", anyTypeArr10, function10);
            }
            moduleDefinitionBuilder11.getAsyncFunctions().put("getFreeDiskStorageAsync", stringAsyncFunctionComponent10);
            ModuleDefinitionBuilder moduleDefinitionBuilder12 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("getContentUriAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$28
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws IOException, FileSystemUnreadableDirectoryException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String str = (String) promise;
                        Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(str));
                        FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                        Intrinsics.checkNotNull(uri);
                        fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.WRITE);
                        this.this$0.ensurePermission(uri, FilePermissionService.Permission.READ);
                        this.this$0.checkIfFileDirExists(uri);
                        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
                            this.this$0.contentUriFromFile(this.this$0.toFile(uri)).toString();
                            return;
                        }
                        throw new FileSystemUnreadableDirectoryException(str);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws IOException, FileSystemUnreadableDirectoryException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters9 = moduleDefinitionBuilder12.getConverters();
                AnyType[] anyTypeArr11 = new AnyType[1];
                AnyType anyType15 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType15 == null) {
                    try {
                        Result.Companion companion29 = Result.INSTANCE;
                        objM12684constructorimpl15 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$29
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(String.class);
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
                        typeDescriptor15 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                    }
                    anyType15 = new AnyType(typeDescriptor15, converters9);
                }
                anyTypeArr11[0] = anyType15;
                Function1<Object[], String> function11 = new Function1<Object[], String>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$30
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(Object[] objArr) throws IOException, FileSystemUnreadableDirectoryException {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        String str = (String) objArr[0];
                        Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(str));
                        FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                        Intrinsics.checkNotNull(uri);
                        fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.WRITE);
                        this.this$0.ensurePermission(uri, FilePermissionService.Permission.READ);
                        this.this$0.checkIfFileDirExists(uri);
                        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
                            return this.this$0.contentUriFromFile(this.this$0.toFile(uri)).toString();
                        }
                        throw new FileSystemUnreadableDirectoryException(str);
                    }
                };
                if (Intrinsics.areEqual(String.class, Integer.TYPE)) {
                    stringAsyncFunctionComponent11 = new IntAsyncFunctionComponent("getContentUriAsync", anyTypeArr11, function11);
                } else if (Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                    stringAsyncFunctionComponent11 = new BoolAsyncFunctionComponent("getContentUriAsync", anyTypeArr11, function11);
                } else if (Intrinsics.areEqual(String.class, Double.TYPE)) {
                    stringAsyncFunctionComponent11 = new DoubleAsyncFunctionComponent("getContentUriAsync", anyTypeArr11, function11);
                } else if (Intrinsics.areEqual(String.class, Float.TYPE)) {
                    stringAsyncFunctionComponent11 = new FloatAsyncFunctionComponent("getContentUriAsync", anyTypeArr11, function11);
                } else {
                    stringAsyncFunctionComponent11 = Intrinsics.areEqual(String.class, String.class) ? new StringAsyncFunctionComponent("getContentUriAsync", anyTypeArr11, function11) : new UntypedAsyncFunctionComponent("getContentUriAsync", anyTypeArr11, function11);
                }
                asyncFunctionWithPromiseComponent4 = stringAsyncFunctionComponent11;
            }
            moduleDefinitionBuilder12.getAsyncFunctions().put("getContentUriAsync", asyncFunctionWithPromiseComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder13 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("readSAFDirectoryAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$31
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws FileSystemCannotReadDirectoryException, IOException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath((String) promise));
                        FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                        Intrinsics.checkNotNull(uri);
                        fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.READ);
                        if (this.this$0.isSAFUri(uri)) {
                            DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this.this$0.getContext(), uri);
                            if (documentFileFromTreeUri == null || !documentFileFromTreeUri.exists() || !documentFileFromTreeUri.isDirectory()) {
                                throw new FileSystemCannotReadDirectoryException(uri);
                            }
                            DocumentFile[] documentFileArrListFiles = documentFileFromTreeUri.listFiles();
                            Intrinsics.checkNotNullExpressionValue(documentFileArrListFiles, "listFiles(...)");
                            ArrayList arrayList = new ArrayList(documentFileArrListFiles.length);
                            for (DocumentFile documentFile : documentFileArrListFiles) {
                                arrayList.add(documentFile.getUri().toString());
                            }
                            return;
                        }
                        throw new IOException("The URI '" + uri + "' is not a Storage Access Framework URI. Try using FileSystem.readDirectoryAsync instead.");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws FileSystemCannotReadDirectoryException, IOException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters10 = moduleDefinitionBuilder13.getConverters();
                AnyType[] anyTypeArr12 = new AnyType[1];
                AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType16 == null) {
                    try {
                        Result.Companion companion31 = Result.INSTANCE;
                        objM12684constructorimpl16 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$32
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
                    anyType16 = new AnyType(typeDescriptor16, converters10);
                }
                anyTypeArr12[0] = anyType16;
                Function1<Object[], List<? extends String>> function12 = new Function1<Object[], List<? extends String>>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$33
                    @Override // kotlin.jvm.functions.Function1
                    public final List<? extends String> invoke(Object[] objArr) throws FileSystemCannotReadDirectoryException, IOException {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath((String) objArr[0]));
                        FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                        Intrinsics.checkNotNull(uri);
                        fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.READ);
                        if (this.this$0.isSAFUri(uri)) {
                            DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this.this$0.getContext(), uri);
                            if (documentFileFromTreeUri == null || !documentFileFromTreeUri.exists() || !documentFileFromTreeUri.isDirectory()) {
                                throw new FileSystemCannotReadDirectoryException(uri);
                            }
                            DocumentFile[] documentFileArrListFiles = documentFileFromTreeUri.listFiles();
                            Intrinsics.checkNotNullExpressionValue(documentFileArrListFiles, "listFiles(...)");
                            ArrayList arrayList = new ArrayList(documentFileArrListFiles.length);
                            for (DocumentFile documentFile : documentFileArrListFiles) {
                                arrayList.add(documentFile.getUri().toString());
                            }
                            return arrayList;
                        }
                        throw new IOException("The URI '" + uri + "' is not a Storage Access Framework URI. Try using FileSystem.readDirectoryAsync instead.");
                    }
                };
                if (Intrinsics.areEqual(List.class, Integer.TYPE)) {
                    stringAsyncFunctionComponent12 = new IntAsyncFunctionComponent("readSAFDirectoryAsync", anyTypeArr12, function12);
                } else if (Intrinsics.areEqual(List.class, Boolean.TYPE)) {
                    stringAsyncFunctionComponent12 = new BoolAsyncFunctionComponent("readSAFDirectoryAsync", anyTypeArr12, function12);
                } else if (Intrinsics.areEqual(List.class, Double.TYPE)) {
                    stringAsyncFunctionComponent12 = new DoubleAsyncFunctionComponent("readSAFDirectoryAsync", anyTypeArr12, function12);
                } else if (Intrinsics.areEqual(List.class, Float.TYPE)) {
                    stringAsyncFunctionComponent12 = new FloatAsyncFunctionComponent("readSAFDirectoryAsync", anyTypeArr12, function12);
                } else {
                    stringAsyncFunctionComponent12 = Intrinsics.areEqual(List.class, String.class) ? new StringAsyncFunctionComponent("readSAFDirectoryAsync", anyTypeArr12, function12) : new UntypedAsyncFunctionComponent("readSAFDirectoryAsync", anyTypeArr12, function12);
                }
                asyncFunctionWithPromiseComponent5 = stringAsyncFunctionComponent12;
            }
            moduleDefinitionBuilder13.getAsyncFunctions().put("readSAFDirectoryAsync", asyncFunctionWithPromiseComponent5);
            ModuleDefinitionBuilder moduleDefinitionBuilder14 = moduleDefinitionBuilder;
            TypeConverterProvider converters11 = moduleDefinitionBuilder14.getConverters();
            AnyType[] anyTypeArr13 = new AnyType[2];
            AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType17 == null) {
                try {
                    Result.Companion companion33 = Result.INSTANCE;
                    objM12684constructorimpl17 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$34
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor17 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType17 = new AnyType(typeDescriptor17, converters11);
            }
            anyTypeArr13[0] = anyType17;
            AnyType anyType18 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType18 == null) {
                try {
                    Result.Companion companion35 = Result.INSTANCE;
                    objM12684constructorimpl18 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$35
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
            anyTypeArr13[1] = anyType18;
            Function1<Object[], String> function13 = new Function1<Object[], String>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$36
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Object[] objArr) throws FileSystemCannotCreateDirectoryException, IOException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj2 = objArr[0];
                    String str = (String) objArr[1];
                    Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath((String) obj2));
                    FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                    Intrinsics.checkNotNull(uri);
                    fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.WRITE);
                    if (this.this$0.isSAFUri(uri)) {
                        DocumentFile nearestSAFFile = this.this$0.getNearestSAFFile(uri);
                        if (nearestSAFFile != null && !nearestSAFFile.isDirectory()) {
                            throw new FileSystemCannotCreateDirectoryException(uri);
                        }
                        DocumentFile documentFileCreateDirectory = nearestSAFFile != null ? nearestSAFFile.createDirectory(str) : null;
                        if (documentFileCreateDirectory == null) {
                            throw new FileSystemCannotCreateDirectoryException(null);
                        }
                        return documentFileCreateDirectory.getUri().toString();
                    }
                    throw new IOException("The URI '" + uri + "' is not a Storage Access Framework URI. Try using FileSystem.makeDirectoryAsync instead.");
                }
            };
            if (Intrinsics.areEqual(String.class, Integer.TYPE)) {
                stringAsyncFunctionComponent13 = new IntAsyncFunctionComponent("makeSAFDirectoryAsync", anyTypeArr13, function13);
            } else if (Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent13 = new BoolAsyncFunctionComponent("makeSAFDirectoryAsync", anyTypeArr13, function13);
            } else if (Intrinsics.areEqual(String.class, Double.TYPE)) {
                stringAsyncFunctionComponent13 = new DoubleAsyncFunctionComponent("makeSAFDirectoryAsync", anyTypeArr13, function13);
            } else if (Intrinsics.areEqual(String.class, Float.TYPE)) {
                stringAsyncFunctionComponent13 = new FloatAsyncFunctionComponent("makeSAFDirectoryAsync", anyTypeArr13, function13);
            } else {
                stringAsyncFunctionComponent13 = Intrinsics.areEqual(String.class, String.class) ? new StringAsyncFunctionComponent("makeSAFDirectoryAsync", anyTypeArr13, function13) : new UntypedAsyncFunctionComponent("makeSAFDirectoryAsync", anyTypeArr13, function13);
            }
            moduleDefinitionBuilder14.getAsyncFunctions().put("makeSAFDirectoryAsync", stringAsyncFunctionComponent13);
            ModuleDefinitionBuilder moduleDefinitionBuilder15 = moduleDefinitionBuilder;
            TypeConverterProvider converters12 = moduleDefinitionBuilder15.getConverters();
            AnyType[] anyTypeArr14 = new AnyType[3];
            AnyType anyType19 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType19 == null) {
                try {
                    Result.Companion companion37 = Result.INSTANCE;
                    objM12684constructorimpl19 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$37
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
            anyTypeArr14[0] = anyType19;
            AnyType anyType20 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType20 == null) {
                try {
                    Result.Companion companion39 = Result.INSTANCE;
                    objM12684constructorimpl20 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$38
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor20 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType20 = new AnyType(typeDescriptor20, converters12);
            }
            anyTypeArr14[1] = anyType20;
            AnyType anyType21 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType21 == null) {
                try {
                    Result.Companion companion41 = Result.INSTANCE;
                    objM12684constructorimpl21 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$39
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor21 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType21 = new AnyType(typeDescriptor21, converters12);
            }
            anyTypeArr14[2] = anyType21;
            Function1<Object[], String> function14 = new Function1<Object[], String>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$40
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Object[] objArr) throws IOException, FileSystemCannotCreateFileException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    String str = (String) objArr[2];
                    String str2 = (String) obj3;
                    Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath((String) obj2));
                    FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                    Intrinsics.checkNotNull(uri);
                    fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.WRITE);
                    if (this.this$0.isSAFUri(uri)) {
                        DocumentFile nearestSAFFile = this.this$0.getNearestSAFFile(uri);
                        if (nearestSAFFile == null || !nearestSAFFile.isDirectory()) {
                            throw new FileSystemCannotCreateFileException(uri);
                        }
                        DocumentFile documentFileCreateFile = nearestSAFFile.createFile(str, str2);
                        if (documentFileCreateFile == null) {
                            throw new FileSystemCannotCreateFileException(null);
                        }
                        return documentFileCreateFile.getUri().toString();
                    }
                    throw new IOException("The URI '" + uri + "' is not a Storage Access Framework URI.");
                }
            };
            if (Intrinsics.areEqual(String.class, Integer.TYPE)) {
                stringAsyncFunctionComponent14 = new IntAsyncFunctionComponent("createSAFFileAsync", anyTypeArr14, function14);
            } else if (Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                stringAsyncFunctionComponent14 = new BoolAsyncFunctionComponent("createSAFFileAsync", anyTypeArr14, function14);
            } else if (Intrinsics.areEqual(String.class, Double.TYPE)) {
                stringAsyncFunctionComponent14 = new DoubleAsyncFunctionComponent("createSAFFileAsync", anyTypeArr14, function14);
            } else if (Intrinsics.areEqual(String.class, Float.TYPE)) {
                stringAsyncFunctionComponent14 = new FloatAsyncFunctionComponent("createSAFFileAsync", anyTypeArr14, function14);
            } else {
                stringAsyncFunctionComponent14 = Intrinsics.areEqual(String.class, String.class) ? new StringAsyncFunctionComponent("createSAFFileAsync", anyTypeArr14, function14) : new UntypedAsyncFunctionComponent("createSAFFileAsync", anyTypeArr14, function14);
            }
            moduleDefinitionBuilder15.getAsyncFunctions().put("createSAFFileAsync", stringAsyncFunctionComponent14);
            ModuleDefinitionBuilder moduleDefinitionBuilder16 = moduleDefinitionBuilder;
            TypeConverterProvider converters13 = moduleDefinitionBuilder16.getConverters();
            AnyType[] anyTypeArr15 = new AnyType[1];
            AnyType anyType22 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType22 == null) {
                try {
                    Result.Companion companion43 = Result.INSTANCE;
                    objM12684constructorimpl22 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
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
                    typeDescriptor22 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType22 = new AnyType(typeDescriptor22, converters13);
            }
            anyTypeArr15[0] = anyType22;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent7 = new AsyncFunctionWithPromiseComponent("requestDirectoryPermissionsAsync", anyTypeArr15, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws FileSystemPendingPermissionsRequestException {
                    Uri uri;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    if (this.this$0.dirPermissionsRequest != null) {
                        throw new FileSystemPendingPermissionsRequestException();
                    }
                    Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                    if (Build.VERSION.SDK_INT >= 26 && str != null && (uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(str))) != null) {
                        intent.putExtra("android.provider.extra.INITIAL_URI", uri);
                    }
                    this.this$0.dirPermissionsRequest = promise;
                    this.this$0.getAppContext().getThrowingActivity().startActivityForResult(intent, 5394);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws FileSystemPendingPermissionsRequestException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder16.getAsyncFunctions().put("requestDirectoryPermissionsAsync", asyncFunctionWithPromiseComponent7);
            ModuleDefinitionBuilder moduleDefinitionBuilder17 = moduleDefinitionBuilder;
            TypeConverterProvider converters14 = moduleDefinitionBuilder17.getConverters();
            AnyType[] anyTypeArr16 = new AnyType[3];
            AnyType anyType23 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType23 == null) {
                try {
                    Result.Companion companion45 = Result.INSTANCE;
                    objM12684constructorimpl23 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor23 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType23 = new AnyType(typeDescriptor23, converters14);
            }
            anyTypeArr16[0] = anyType23;
            AnyType anyType24 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType24 == null) {
                try {
                    Result.Companion companion47 = Result.INSTANCE;
                    objM12684constructorimpl24 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor24 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType24 = new AnyType(typeDescriptor24, converters14);
            }
            anyTypeArr16[1] = anyType24;
            AnyType anyType25 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemUploadOptions.class), false));
            if (anyType25 == null) {
                try {
                    Result.Companion companion49 = Result.INSTANCE;
                    objM12684constructorimpl25 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemUploadOptions.class, false, FileSystemUploadOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemUploadOptions.class);
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
                    typeDescriptor25 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemUploadOptions.class));
                }
                anyType25 = new AnyType(typeDescriptor25, converters14);
            }
            anyTypeArr16[2] = anyType25;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent8 = new AsyncFunctionWithPromiseComponent("uploadAsync", anyTypeArr16, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$6
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) throws IOException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    FileSystemUploadOptions fileSystemUploadOptions = (FileSystemUploadOptions) objArr[2];
                    FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                    Request requestCreateUploadRequest = fileSystemLegacyModule2.createUploadRequest((String) obj2, (String) obj3, fileSystemUploadOptions, new RequestBodyDecorator() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$1$20$request$1
                        @Override // expo.modules.filesystem.legacy.RequestBodyDecorator
                        public final RequestBody decorate(RequestBody requestBody) {
                            Intrinsics.checkNotNullParameter(requestBody, "requestBody");
                            return requestBody;
                        }
                    });
                    OkHttpClient okHttpClient = this.this$0.getOkHttpClient();
                    if (okHttpClient != null) {
                        Call callNewCall = okHttpClient.newCall(requestCreateUploadRequest);
                        final FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                        callNewCall.enqueue(new Callback() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$1$20$1$1
                            @Override // okhttp3.Callback
                            public void onFailure(Call call, IOException e) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(e, "e");
                                Log.e(FileSystemLegacyModuleKt.TAG, String.valueOf(e.getMessage()));
                                promise.reject(FileSystemLegacyModuleKt.TAG, e.getMessage(), e);
                            }

                            @Override // okhttp3.Callback
                            public void onResponse(Call call, Response response) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(response, "response");
                                Bundle bundle = new Bundle();
                                FileSystemLegacyModule fileSystemLegacyModule4 = fileSystemLegacyModule3;
                                ResponseBody responseBodyBody = response.body();
                                bundle.putString(ExpoNotificationBuilder.EXTRAS_BODY_KEY, responseBodyBody != null ? responseBodyBody.string() : null);
                                bundle.putInt("status", response.code());
                                bundle.putBundle("headers", fileSystemLegacyModule4.translateHeaders(response.headers()));
                                response.close();
                                promise.resolve(bundle);
                            }
                        });
                        return;
                    }
                    promise.reject(new FileSystemOkHttpNullException());
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws IOException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder17.getAsyncFunctions().put("uploadAsync", asyncFunctionWithPromiseComponent8);
            ModuleDefinitionBuilder moduleDefinitionBuilder18 = moduleDefinitionBuilder;
            TypeConverterProvider converters15 = moduleDefinitionBuilder18.getConverters();
            AnyType[] anyTypeArr17 = new AnyType[4];
            AnyType anyType26 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType26 == null) {
                try {
                    Result.Companion companion51 = Result.INSTANCE;
                    objM12684constructorimpl26 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$7
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
                anyType26 = new AnyType(typeDescriptor26, converters15);
            }
            anyTypeArr17[0] = anyType26;
            AnyType anyType27 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType27 == null) {
                try {
                    Result.Companion companion53 = Result.INSTANCE;
                    objM12684constructorimpl27 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor27 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType27 = new AnyType(typeDescriptor27, converters15);
            }
            anyTypeArr17[1] = anyType27;
            AnyType anyType28 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType28 == null) {
                try {
                    Result.Companion companion55 = Result.INSTANCE;
                    objM12684constructorimpl28 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor28 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType28 = new AnyType(typeDescriptor28, converters15);
            }
            anyTypeArr17[2] = anyType28;
            AnyType anyType29 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemUploadOptions.class), false));
            if (anyType29 == null) {
                try {
                    Result.Companion companion57 = Result.INSTANCE;
                    objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(FileSystemUploadOptions.class, false, FileSystemUploadOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$10
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemUploadOptions.class);
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
                    typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(FileSystemUploadOptions.class));
                }
                anyType29 = new AnyType(typeDescriptor29, converters15);
            }
            anyTypeArr17[3] = anyType29;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent9 = new AsyncFunctionWithPromiseComponent("uploadTaskStartAsync", anyTypeArr17, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$11
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) throws IOException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    FileSystemUploadOptions fileSystemUploadOptions = (FileSystemUploadOptions) objArr[3];
                    final String str = (String) obj4;
                    final FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                    final CountingRequestListener countingRequestListener = new CountingRequestListener() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$1$21$progressListener$1
                        private long mLastUpdate = -1;

                        @Override // expo.modules.filesystem.legacy.CountingRequestListener
                        public void onProgress(long bytesWritten, long contentLength) {
                            Bundle bundle = new Bundle();
                            Bundle bundle2 = new Bundle();
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (jCurrentTimeMillis > this.mLastUpdate + 100 || bytesWritten == contentLength) {
                                this.mLastUpdate = jCurrentTimeMillis;
                                bundle2.putDouble("totalBytesSent", bytesWritten);
                                bundle2.putDouble("totalBytesExpectedToSend", contentLength);
                                bundle.putString(InstallationId.LEGACY_PREFERENCES_UUID_KEY, str);
                                bundle.putBundle("data", bundle2);
                                fileSystemLegacyModule2.sendEvent("expo-file-system.uploadProgress", bundle);
                            }
                        }
                    };
                    FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                    Request requestCreateUploadRequest = fileSystemLegacyModule3.createUploadRequest((String) obj2, (String) obj3, fileSystemUploadOptions, new RequestBodyDecorator() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$1$21$request$1
                        @Override // expo.modules.filesystem.legacy.RequestBodyDecorator
                        public final RequestBody decorate(RequestBody requestBody) {
                            Intrinsics.checkNotNullParameter(requestBody, "requestBody");
                            return new CountingRequestBody(requestBody, countingRequestListener);
                        }
                    });
                    OkHttpClient okHttpClient = this.this$0.getOkHttpClient();
                    Intrinsics.checkNotNull(okHttpClient);
                    Call callNewCall = okHttpClient.newCall(requestCreateUploadRequest);
                    this.this$0.taskHandlers.put(str, new FileSystemLegacyModule.TaskHandler(callNewCall));
                    final FileSystemLegacyModule fileSystemLegacyModule4 = this.this$0;
                    callNewCall.enqueue(new Callback() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$1$21$1
                        @Override // okhttp3.Callback
                        public void onFailure(Call call, IOException e) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(e, "e");
                            if (!call.getCanceled()) {
                                Log.e(FileSystemLegacyModuleKt.TAG, String.valueOf(e.getMessage()));
                                promise.reject(FileSystemLegacyModuleKt.TAG, e.getMessage(), e);
                            } else {
                                promise.resolve((Object) null);
                            }
                        }

                        @Override // okhttp3.Callback
                        public void onResponse(Call call, Response response) {
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(response, "response");
                            Bundle bundle = new Bundle();
                            ResponseBody responseBodyBody = response.body();
                            FileSystemLegacyModule fileSystemLegacyModule5 = fileSystemLegacyModule4;
                            bundle.putString(ExpoNotificationBuilder.EXTRAS_BODY_KEY, responseBodyBody != null ? responseBodyBody.string() : null);
                            bundle.putInt("status", response.code());
                            bundle.putBundle("headers", fileSystemLegacyModule5.translateHeaders(response.headers()));
                            response.close();
                            promise.resolve(bundle);
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws IOException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder18.getAsyncFunctions().put("uploadTaskStartAsync", asyncFunctionWithPromiseComponent9);
            ModuleDefinitionBuilder moduleDefinitionBuilder19 = moduleDefinitionBuilder;
            TypeConverterProvider converters16 = moduleDefinitionBuilder19.getConverters();
            AnyType[] anyTypeArr18 = new AnyType[3];
            AnyType anyType30 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType30 == null) {
                try {
                    Result.Companion companion59 = Result.INSTANCE;
                    objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$12
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType30 = new AnyType(typeDescriptor30, converters16);
            }
            anyTypeArr18[0] = anyType30;
            AnyType anyType31 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType31 == null) {
                try {
                    Result.Companion companion61 = Result.INSTANCE;
                    objM12684constructorimpl31 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$13
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
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
                    typeDescriptor31 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType31 = new AnyType(typeDescriptor31, converters16);
            }
            anyTypeArr18[1] = anyType31;
            AnyType anyType32 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DownloadOptionsLegacy.class), false));
            if (anyType32 == null) {
                try {
                    Result.Companion companion63 = Result.INSTANCE;
                    objM12684constructorimpl32 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DownloadOptionsLegacy.class, false, DownloadOptionsLegacy.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$14
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(DownloadOptionsLegacy.class);
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
                    typeDescriptor32 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(DownloadOptionsLegacy.class));
                }
                anyType32 = new AnyType(typeDescriptor32, converters16);
            }
            anyTypeArr18[2] = anyType32;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent10 = new AsyncFunctionWithPromiseComponent("downloadAsync", anyTypeArr18, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$15
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) throws IOException, Exceptions.AppContextLost {
                    Call callNewCall;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    final DownloadOptionsLegacy downloadOptionsLegacy = (DownloadOptionsLegacy) objArr[2];
                    String str = (String) obj2;
                    final Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath((String) obj3));
                    FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                    Intrinsics.checkNotNull(uri);
                    fileSystemLegacyModule2.ensurePermission(uri, FilePermissionService.Permission.WRITE);
                    this.this$0.checkIfFileDirExists(uri);
                    if (!StringsKt.contains$default((CharSequence) str, (CharSequence) ServerSentEventKt.COLON, false, 2, (Object) null)) {
                        Context context = this.this$0.getContext();
                        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(context.getResources().getIdentifier(str, "raw", context.getPackageName()));
                        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
                        BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(inputStreamOpenRawResource));
                        File file = this.this$0.toFile(uri);
                        file.delete();
                        BufferedSink bufferedSinkBuffer = Okio.buffer(Okio__JvmOkioKt.sink$default(file, false, 1, null));
                        bufferedSinkBuffer.writeAll(bufferedSourceBuffer);
                        bufferedSinkBuffer.close();
                        Bundle bundle = new Bundle();
                        bundle.putString("uri", Uri.fromFile(file).toString());
                        boolean md5 = downloadOptionsLegacy.getMd5();
                        Boolean boolValueOf = Boolean.valueOf(md5);
                        boolValueOf.getClass();
                        Boolean bool = md5 ? boolValueOf : null;
                        if (bool != null) {
                            bool.booleanValue();
                            bundle.putString("md5", this.this$0.md5(file));
                        }
                        promise.resolve(bundle);
                        return;
                    }
                    if (Intrinsics.areEqual("file", uri.getScheme())) {
                        Request.Builder builderUrl = new Request.Builder().url(str);
                        if (downloadOptionsLegacy.getHeaders() != null) {
                            for (Map.Entry<String, String> entry : downloadOptionsLegacy.getHeaders().entrySet()) {
                                builderUrl.addHeader(entry.getKey(), entry.getValue());
                            }
                        }
                        OkHttpClient okHttpClient = this.this$0.getOkHttpClient();
                        if (okHttpClient == null || (callNewCall = okHttpClient.newCall(builderUrl.build())) == null) {
                            promise.reject(new FileSystemOkHttpNullException());
                            return;
                        } else {
                            final FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                            callNewCall.enqueue(new Callback() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$1$22$4
                                @Override // okhttp3.Callback
                                public void onFailure(Call call, IOException e) {
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(e, "e");
                                    Log.e(FileSystemLegacyModuleKt.TAG, String.valueOf(e.getMessage()));
                                    promise.reject(FileSystemLegacyModuleKt.TAG, e.getMessage(), e);
                                }

                                @Override // okhttp3.Callback
                                public void onResponse(Call call, Response response) throws IOException {
                                    Intrinsics.checkNotNullParameter(call, "call");
                                    Intrinsics.checkNotNullParameter(response, "response");
                                    FileSystemLegacyModule fileSystemLegacyModule4 = fileSystemLegacyModule3;
                                    Uri uri2 = uri;
                                    Intrinsics.checkNotNull(uri2);
                                    File file2 = fileSystemLegacyModule4.toFile(uri2);
                                    file2.delete();
                                    BufferedSink bufferedSinkBuffer2 = Okio.buffer(Okio__JvmOkioKt.sink$default(file2, false, 1, null));
                                    ResponseBody responseBodyBody = response.body();
                                    Intrinsics.checkNotNull(responseBodyBody);
                                    bufferedSinkBuffer2.writeAll(responseBodyBody.getBodySource());
                                    bufferedSinkBuffer2.close();
                                    Bundle bundle2 = new Bundle();
                                    FileSystemLegacyModule fileSystemLegacyModule5 = fileSystemLegacyModule3;
                                    DownloadOptionsLegacy downloadOptionsLegacy2 = downloadOptionsLegacy;
                                    bundle2.putString("uri", Uri.fromFile(file2).toString());
                                    bundle2.putInt("status", response.code());
                                    bundle2.putBundle("headers", fileSystemLegacyModule5.translateHeaders(response.headers()));
                                    if (downloadOptionsLegacy2.getMd5()) {
                                        bundle2.putString("md5", fileSystemLegacyModule5.md5(file2));
                                    }
                                    response.close();
                                    promise.resolve(bundle2);
                                }
                            });
                            return;
                        }
                    }
                    throw new IOException("Unsupported scheme for location '" + uri + "'.");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws IOException, Exceptions.AppContextLost {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder19.getAsyncFunctions().put("downloadAsync", asyncFunctionWithPromiseComponent10);
            ModuleDefinitionBuilder moduleDefinitionBuilder20 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                untypedAsyncFunctionComponent = new AsyncFunctionWithPromiseComponent("networkTaskCancelAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$41
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Call call;
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        FileSystemLegacyModule.TaskHandler taskHandler = (FileSystemLegacyModule.TaskHandler) this.this$0.taskHandlers.get((String) promise);
                        if (taskHandler == null || (call = taskHandler.getCall()) == null) {
                            return;
                        }
                        call.cancel();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters17 = moduleDefinitionBuilder20.getConverters();
                AnyType[] anyTypeArr19 = new AnyType[1];
                AnyType anyType33 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType33 == null) {
                    try {
                        Result.Companion companion65 = Result.INSTANCE;
                        objM12684constructorimpl33 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$42
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(String.class);
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
                        typeDescriptor33 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                    }
                    anyType33 = new AnyType(typeDescriptor33, converters17);
                }
                anyTypeArr19[0] = anyType33;
                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("networkTaskCancelAsync", anyTypeArr19, new Function1<Object[], Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$43
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Call call;
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        FileSystemLegacyModule.TaskHandler taskHandler = (FileSystemLegacyModule.TaskHandler) this.this$0.taskHandlers.get((String) objArr[0]);
                        if (taskHandler == null || (call = taskHandler.getCall()) == null) {
                            return null;
                        }
                        call.cancel();
                        return Unit.INSTANCE;
                    }
                });
            }
            moduleDefinitionBuilder20.getAsyncFunctions().put("networkTaskCancelAsync", untypedAsyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder21 = moduleDefinitionBuilder;
            TypeConverterProvider converters18 = moduleDefinitionBuilder21.getConverters();
            AnyType[] anyTypeArr20 = new AnyType[5];
            AnyType anyType34 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType34 == null) {
                try {
                    Result.Companion companion67 = Result.INSTANCE;
                    objM12684constructorimpl34 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$16
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor34 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType34 = new AnyType(typeDescriptor34, converters18);
            }
            anyTypeArr20[0] = anyType34;
            AnyType anyType35 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType35 == null) {
                try {
                    Result.Companion companion69 = Result.INSTANCE;
                    objM12684constructorimpl35 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$17
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor35 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType35 = new AnyType(typeDescriptor35, converters18);
            }
            anyTypeArr20[1] = anyType35;
            AnyType anyType36 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType36 == null) {
                try {
                    Result.Companion companion71 = Result.INSTANCE;
                    objM12684constructorimpl36 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$18
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
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
                    typeDescriptor36 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                }
                anyType36 = new AnyType(typeDescriptor36, converters18);
            }
            anyTypeArr20[2] = anyType36;
            AnyType anyType37 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DownloadOptionsLegacy.class), false));
            if (anyType37 == null) {
                try {
                    Result.Companion companion73 = Result.INSTANCE;
                    objM12684constructorimpl37 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(DownloadOptionsLegacy.class, false, DownloadOptionsLegacy.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$19
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(DownloadOptionsLegacy.class);
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
                    typeDescriptor37 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(DownloadOptionsLegacy.class));
                }
                anyType37 = new AnyType(typeDescriptor37, converters18);
            }
            anyTypeArr20[3] = anyType37;
            AnyType anyType38 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType38 == null) {
                try {
                    Result.Companion companion75 = Result.INSTANCE;
                    objM12684constructorimpl38 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING_NULLABLE), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$20
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                } catch (Throwable th38) {
                    Result.Companion companion76 = Result.INSTANCE;
                    objM12684constructorimpl38 = Result.m12684constructorimpl(ResultKt.createFailure(th38));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl38)) {
                    objM12684constructorimpl38 = null;
                }
                TypeDescriptor typeDescriptor38 = (TypeDescriptor) objM12684constructorimpl38;
                if (typeDescriptor38 == null) {
                    typeDescriptor38 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(String.class));
                }
                anyType38 = new AnyType(typeDescriptor38, converters18);
            }
            anyTypeArr20[4] = anyType38;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent11 = new AsyncFunctionWithPromiseComponent("downloadResumableStartAsync", anyTypeArr20, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunctionWithPromise$21
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws IOException {
                    OkHttpClient.Builder builderNewBuilder;
                    OkHttpClient.Builder builderAddInterceptor;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    Object obj5 = objArr[3];
                    final String str = (String) objArr[4];
                    DownloadOptionsLegacy downloadOptionsLegacy = (DownloadOptionsLegacy) obj5;
                    final String str2 = (String) obj4;
                    String str3 = (String) obj2;
                    Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath((String) obj3));
                    FileSystemLegacyModule fileSystemLegacyModule2 = this.this$0;
                    Intrinsics.checkNotNull(uri);
                    fileSystemLegacyModule2.checkIfFileDirExists(uri);
                    if (!Intrinsics.areEqual(uri.getScheme(), "file")) {
                        throw new IOException("Unsupported scheme for location '" + uri + "'.");
                    }
                    final FileSystemLegacyModule fileSystemLegacyModule3 = this.this$0;
                    final FileSystemLegacyModule.ProgressListener progressListener = new FileSystemLegacyModule.ProgressListener() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$1$24$progressListener$1
                        private long mLastUpdate = -1;

                        public final long getMLastUpdate() {
                            return this.mLastUpdate;
                        }

                        public final void setMLastUpdate(long j) {
                            this.mLastUpdate = j;
                        }

                        @Override // expo.modules.filesystem.legacy.FileSystemLegacyModule.ProgressListener
                        public void update(long bytesRead, long contentLength, boolean done) {
                            Bundle bundle = new Bundle();
                            Bundle bundle2 = new Bundle();
                            String str4 = str;
                            long j = bytesRead + (str4 != null ? Long.parseLong(str4) : 0L);
                            String str5 = str;
                            long j2 = contentLength + (str5 != null ? Long.parseLong(str5) : 0L);
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (jCurrentTimeMillis > this.mLastUpdate + 100 || j == j2) {
                                this.mLastUpdate = jCurrentTimeMillis;
                                bundle2.putDouble("totalBytesWritten", j);
                                bundle2.putDouble("totalBytesExpectedToWrite", j2);
                                bundle.putString(InstallationId.LEGACY_PREFERENCES_UUID_KEY, str2);
                                bundle.putBundle("data", bundle2);
                                fileSystemLegacyModule3.sendEvent("expo-file-system.downloadProgress", bundle);
                            }
                        }
                    };
                    OkHttpClient okHttpClient = this.this$0.getOkHttpClient();
                    OkHttpClient okHttpClientBuild = (okHttpClient == null || (builderNewBuilder = okHttpClient.newBuilder()) == null || (builderAddInterceptor = builderNewBuilder.addInterceptor(new Interceptor() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$lambda$45$$inlined$-addInterceptor$1
                        @Override // okhttp3.Interceptor
                        public final Response intercept(Interceptor.Chain chain) throws IOException {
                            Intrinsics.checkNotNullParameter(chain, "chain");
                            Response responseProceed = chain.proceed(chain.request());
                            return responseProceed.newBuilder().body(new FileSystemLegacyModule.ProgressResponseBody(responseProceed.body(), progressListener)).build();
                        }
                    })) == null) ? null : builderAddInterceptor.build();
                    if (okHttpClientBuild == null) {
                        promise.reject(new FileSystemOkHttpNullException());
                        return;
                    }
                    Request.Builder builder = new Request.Builder();
                    if (str != null) {
                        builder.addHeader("Range", "bytes=" + str + "-");
                    }
                    if (downloadOptionsLegacy.getHeaders() != null) {
                        for (Map.Entry<String, String> entry : downloadOptionsLegacy.getHeaders().entrySet()) {
                            builder.addHeader(entry.getKey(), entry.getValue());
                        }
                    }
                    Call callNewCall = okHttpClientBuild.newCall(builder.url(str3).build());
                    this.this$0.taskHandlers.put(str2, new FileSystemLegacyModule.DownloadTaskHandler(uri, callNewCall));
                    BuildersKt__Builders_commonKt.launch$default(this.this$0.moduleCoroutineScope, null, null, new FileSystemLegacyModule$definition$1$24$3(this.this$0, new FileSystemLegacyModule.DownloadResumableTaskParams(downloadOptionsLegacy, callNewCall, this.this$0.toFile(uri), str != null, promise), null), 3, null);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws IOException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder21.getAsyncFunctions().put("downloadResumableStartAsync", asyncFunctionWithPromiseComponent11);
            ModuleDefinitionBuilder moduleDefinitionBuilder22 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("downloadResumablePauseAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$44
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws FileSystemCannotFindTaskException, IOException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String str = (String) promise;
                        FileSystemLegacyModule.TaskHandler taskHandler = (FileSystemLegacyModule.TaskHandler) this.this$0.taskHandlers.get(str);
                        if (taskHandler == null) {
                            throw new IOException("No download object available");
                        }
                        if (!(taskHandler instanceof FileSystemLegacyModule.DownloadTaskHandler)) {
                            throw new FileSystemCannotFindTaskException();
                        }
                        taskHandler.getCall().cancel();
                        this.this$0.taskHandlers.remove(str);
                        new Bundle().putString("resumeData", String.valueOf(this.this$0.toFile(((FileSystemLegacyModule.DownloadTaskHandler) taskHandler).getFileUri()).length()));
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws FileSystemCannotFindTaskException, IOException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters19 = moduleDefinitionBuilder22.getConverters();
                AnyType[] anyTypeArr21 = new AnyType[1];
                AnyType anyType39 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType39 == null) {
                    try {
                        Result.Companion companion77 = Result.INSTANCE;
                        objM12684constructorimpl39 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$45
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(String.class);
                            }
                        }));
                    } catch (Throwable th39) {
                        Result.Companion companion78 = Result.INSTANCE;
                        objM12684constructorimpl39 = Result.m12684constructorimpl(ResultKt.createFailure(th39));
                    }
                    if (!Result.m12690isFailureimpl(objM12684constructorimpl39)) {
                        obj = objM12684constructorimpl39;
                    }
                    TypeDescriptor typeDescriptor39 = (TypeDescriptor) obj;
                    if (typeDescriptor39 == null) {
                        typeDescriptor39 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                    }
                    anyType39 = new AnyType(typeDescriptor39, converters19);
                }
                anyTypeArr21[0] = anyType39;
                Function1<Object[], Bundle> function15 = new Function1<Object[], Bundle>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$AsyncFunction$46
                    @Override // kotlin.jvm.functions.Function1
                    public final Bundle invoke(Object[] objArr) throws FileSystemCannotFindTaskException, IOException {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        String str = (String) objArr[0];
                        FileSystemLegacyModule.TaskHandler taskHandler = (FileSystemLegacyModule.TaskHandler) this.this$0.taskHandlers.get(str);
                        if (taskHandler == null) {
                            throw new IOException("No download object available");
                        }
                        if (!(taskHandler instanceof FileSystemLegacyModule.DownloadTaskHandler)) {
                            throw new FileSystemCannotFindTaskException();
                        }
                        taskHandler.getCall().cancel();
                        this.this$0.taskHandlers.remove(str);
                        File file = this.this$0.toFile(((FileSystemLegacyModule.DownloadTaskHandler) taskHandler).getFileUri());
                        Bundle bundle = new Bundle();
                        bundle.putString("resumeData", String.valueOf(file.length()));
                        return bundle;
                    }
                };
                if (Intrinsics.areEqual(Bundle.class, Integer.TYPE)) {
                    stringAsyncFunctionComponent15 = new IntAsyncFunctionComponent("downloadResumablePauseAsync", anyTypeArr21, function15);
                } else if (Intrinsics.areEqual(Bundle.class, Boolean.TYPE)) {
                    stringAsyncFunctionComponent15 = new BoolAsyncFunctionComponent("downloadResumablePauseAsync", anyTypeArr21, function15);
                } else if (Intrinsics.areEqual(Bundle.class, Double.TYPE)) {
                    stringAsyncFunctionComponent15 = new DoubleAsyncFunctionComponent("downloadResumablePauseAsync", anyTypeArr21, function15);
                } else if (Intrinsics.areEqual(Bundle.class, Float.TYPE)) {
                    stringAsyncFunctionComponent15 = new FloatAsyncFunctionComponent("downloadResumablePauseAsync", anyTypeArr21, function15);
                } else {
                    stringAsyncFunctionComponent15 = Intrinsics.areEqual(Bundle.class, String.class) ? new StringAsyncFunctionComponent("downloadResumablePauseAsync", anyTypeArr21, function15) : new UntypedAsyncFunctionComponent("downloadResumablePauseAsync", anyTypeArr21, function15);
                }
                asyncFunctionWithPromiseComponent6 = stringAsyncFunctionComponent15;
            }
            moduleDefinitionBuilder22.getAsyncFunctions().put("downloadResumablePauseAsync", asyncFunctionWithPromiseComponent6);
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$OnActivityResult$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Activity activity, OnActivityResultPayload onActivityResultPayload) {
                    invoke2(activity, onActivityResultPayload);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Activity sender, OnActivityResultPayload payload) {
                    Intrinsics.checkNotNullParameter(sender, "sender");
                    Intrinsics.checkNotNullParameter(payload, "payload");
                    int requestCode = payload.getRequestCode();
                    int resultCode = payload.getResultCode();
                    Intent data = payload.getData();
                    if (requestCode != 5394 || this.this$0.dirPermissionsRequest == null) {
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (resultCode == -1 && data != null) {
                        Uri data2 = data.getData();
                        int flags = data.getFlags() & 3;
                        if (data2 != null) {
                            this.this$0.getAppContext().getThrowingActivity().getContentResolver().takePersistableUriPermission(data2, flags);
                        }
                        bundle.putBoolean(PermissionsResponse.GRANTED_KEY, true);
                        bundle.putString("directoryUri", String.valueOf(data2));
                    } else {
                        bundle.putBoolean(PermissionsResponse.GRANTED_KEY, false);
                    }
                    Promise promise = this.this$0.dirPermissionsRequest;
                    if (promise != null) {
                        promise.resolve(bundle);
                    }
                    this.this$0.dirPermissionsRequest = null;
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$definition$lambda$51$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    try {
                        CoroutineScopeKt.cancel(this.this$0.moduleCoroutineScope, new ModuleDestroyedException(null, 1, null));
                    } catch (IllegalStateException unused) {
                        Log.e(FileSystemLegacyModuleKt.TAG, "The scope does not have a job in it");
                    }
                }
            }));
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th40) {
            Trace.endSection();
            throw th40;
        }
    }

    private final void checkIfFileExists(Uri uri) throws IOException {
        File file = toFile(uri);
        if (file.exists()) {
            return;
        }
        throw new IOException("Directory for '" + file.getPath() + "' doesn't exist.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkIfFileDirExists(Uri uri) throws IOException {
        File file = toFile(uri);
        File parentFile = file.getParentFile();
        if (parentFile == null || !parentFile.exists()) {
            throw new IOException("Directory for '" + file.getPath() + "' doesn't exist. Please make sure directory '" + file.getParent() + "' exists before calling downloadAsync.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureDirExists(File dir) throws IOException {
        if (dir.isDirectory() || dir.mkdirs()) {
            return;
        }
        throw new IOException("Couldn't create directory '" + dir + "'");
    }

    private final EnumSet<FilePermissionService.Permission> permissionsForPath(String path) {
        if (path == null) {
            return null;
        }
        return getAppContext().getFilePermission().getPathPermissions(getContext(), path);
    }

    private final EnumSet<FilePermissionService.Permission> permissionsForUri(Uri uri) {
        if (isSAFUri(uri)) {
            return permissionsForSAFUri(uri);
        }
        if (!Intrinsics.areEqual(uri.getScheme(), "content") && !Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_ASSET_SCHEME)) {
            if (Intrinsics.areEqual(uri.getScheme(), "file")) {
                return permissionsForPath(uri.getPath());
            }
            return uri.getScheme() == null ? EnumSet.of(FilePermissionService.Permission.READ) : EnumSet.noneOf(FilePermissionService.Permission.class);
        }
        return EnumSet.of(FilePermissionService.Permission.READ);
    }

    private final EnumSet<FilePermissionService.Permission> permissionsForSAFUri(Uri uri) {
        DocumentFile nearestSAFFile = getNearestSAFFile(uri);
        EnumSet<FilePermissionService.Permission> enumSetNoneOf = EnumSet.noneOf(FilePermissionService.Permission.class);
        if (nearestSAFFile != null) {
            if (nearestSAFFile.canRead()) {
                enumSetNoneOf.add(FilePermissionService.Permission.READ);
            }
            if (nearestSAFFile.canWrite()) {
                enumSetNoneOf.add(FilePermissionService.Permission.WRITE);
            }
        }
        Intrinsics.checkNotNullExpressionValue(enumSetNoneOf, "apply(...)");
        return enumSetNoneOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensurePermission(Uri uri, FilePermissionService.Permission permission, String errorMsg) throws IOException {
        EnumSet<FilePermissionService.Permission> enumSetPermissionsForUri = permissionsForUri(uri);
        if (enumSetPermissionsForUri == null || !enumSetPermissionsForUri.contains(permission)) {
            throw new IOException(errorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensurePermission(Uri uri, FilePermissionService.Permission permission) throws IOException {
        if (permission == FilePermissionService.Permission.READ) {
            ensurePermission(uri, permission, "Location '" + uri + "' isn't readable.");
        }
        if (permission == FilePermissionService.Permission.WRITE) {
            ensurePermission(uri, permission, "Location '" + uri + "' isn't writable.");
        }
        ensurePermission(uri, permission, "Location '" + uri + "' doesn't have permission '" + permission.name() + "'.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputStream openAssetInputStream(Uri uri) throws IOException {
        String path = uri.getPath();
        if (path == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        String strSubstring = path.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        InputStream inputStreamOpen = getContext().getAssets().open(strSubstring);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        return inputStreamOpen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputStream openResourceInputStream(String resourceName) throws IOException {
        int identifier = getContext().getResources().getIdentifier(resourceName, "raw", getContext().getPackageName());
        if (identifier == 0 && (identifier = getContext().getResources().getIdentifier(resourceName, "drawable", getContext().getPackageName())) == 0) {
            throw new FileNotFoundException("No resource found with the name '" + resourceName + "'");
        }
        InputStream inputStreamOpenRawResource = getContext().getResources().openRawResource(identifier);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        return inputStreamOpenRawResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void transformFilesFromSAF(DocumentFile documentFile, File outputDir, boolean copy) throws IOException {
        File file;
        if (documentFile.exists()) {
            if (!outputDir.isDirectory()) {
                File parentFile = outputDir.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    throw new IOException("Couldn't create folder in output dir.");
                }
            } else if (!outputDir.exists() && !outputDir.mkdirs()) {
                throw new IOException("Couldn't create folder in output dir.");
            }
            if (documentFile.isDirectory()) {
                for (DocumentFile documentFile2 : documentFile.listFiles()) {
                    Intrinsics.checkNotNull(documentFile2);
                    transformFilesFromSAF(documentFile2, outputDir, copy);
                }
                if (copy) {
                    return;
                }
                documentFile.delete();
                return;
            }
            String name = documentFile.getName();
            if (name != null) {
                if (outputDir.isDirectory()) {
                    file = new File(outputDir.getPath(), name);
                } else {
                    file = new File(outputDir.getPath());
                }
                InputStream inputStreamOpenInputStream = getContext().getContentResolver().openInputStream(documentFile.getUri());
                try {
                    InputStream inputStream = inputStreamOpenInputStream;
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        IOUtils.copy(inputStream, fileOutputStream);
                        CloseableKt.closeFinally(fileOutputStream, null);
                        CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                        if (copy) {
                            return;
                        }
                        documentFile.delete();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(fileOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(inputStreamOpenInputStream, th3);
                        throw th4;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Uri contentUriFromFile(File file) {
        Uri uriForFile = FileProvider.getUriForFile(getAppContext().getThrowingActivity().getApplication(), getAppContext().getThrowingActivity().getApplication().getPackageName() + ".FileSystemFileProvider", file);
        Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(...)");
        return uriForFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Request createUploadRequest(String url, String fileUriString, FileSystemUploadOptions options, RequestBodyDecorator decorator) throws IOException {
        Uri uri = Uri.parse(FileSystemLegacyModuleKt.slashifyFilePath(fileUriString));
        Intrinsics.checkNotNull(uri);
        ensurePermission(uri, FilePermissionService.Permission.READ);
        checkIfFileExists(uri);
        Request.Builder builderUrl = new Request.Builder().url(url);
        Map<String, String> headers = options.getHeaders();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builderUrl.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return builderUrl.method(options.getHttpMethod().getValue(), createRequestBody(options, decorator, toFile(uri))).build();
    }

    private final RequestBody createRequestBody(FileSystemUploadOptions options, RequestBodyDecorator decorator, File file) {
        int i = WhenMappings.$EnumSwitchMapping$0[options.getUploadType().ordinal()];
        if (i == 1) {
            return decorator.decorate(RequestBody.INSTANCE.create(file, (MediaType) null));
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        MultipartBody.Builder type = new MultipartBody.Builder(null, 1, null).setType(MultipartBody.FORM);
        Map<String, String> parameters = options.getParameters();
        if (parameters != null) {
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                type.addFormDataPart(entry.getKey(), entry.getValue().toString());
            }
        }
        String mimeType = options.getMimeType();
        if (mimeType == null) {
            mimeType = URLConnection.guessContentTypeFromName(file.getName());
            Intrinsics.checkNotNullExpressionValue(mimeType, "guessContentTypeFromName(...)");
        }
        String fieldName = options.getFieldName();
        if (fieldName == null) {
            fieldName = file.getName();
        }
        Intrinsics.checkNotNull(fieldName);
        type.addFormDataPart(fieldName, file.getName(), decorator.decorate(RequestBody.INSTANCE.create(file, MediaType.INSTANCE.parse(mimeType))));
        return type.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: FileSystemLegacyModule.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lexpo/modules/filesystem/legacy/FileSystemLegacyModule$DownloadResumableTaskParams;", "", "options", "Lexpo/modules/filesystem/legacy/DownloadOptionsLegacy;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "file", "Ljava/io/File;", "isResume", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "<init>", "(Lexpo/modules/filesystem/legacy/DownloadOptionsLegacy;Lokhttp3/Call;Ljava/io/File;ZLexpo/modules/kotlin/Promise;)V", "getOptions", "()Lexpo/modules/filesystem/legacy/DownloadOptionsLegacy;", "getCall", "()Lokhttp3/Call;", "getFile", "()Ljava/io/File;", "()Z", "getPromise", "()Lexpo/modules/kotlin/Promise;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class DownloadResumableTaskParams {
        private final Call call;
        private final File file;
        private final boolean isResume;
        private final DownloadOptionsLegacy options;
        private final Promise promise;

        public static /* synthetic */ DownloadResumableTaskParams copy$default(DownloadResumableTaskParams downloadResumableTaskParams, DownloadOptionsLegacy downloadOptionsLegacy, Call call, File file, boolean z, Promise promise, int i, Object obj) {
            if ((i & 1) != 0) {
                downloadOptionsLegacy = downloadResumableTaskParams.options;
            }
            if ((i & 2) != 0) {
                call = downloadResumableTaskParams.call;
            }
            if ((i & 4) != 0) {
                file = downloadResumableTaskParams.file;
            }
            if ((i & 8) != 0) {
                z = downloadResumableTaskParams.isResume;
            }
            if ((i & 16) != 0) {
                promise = downloadResumableTaskParams.promise;
            }
            Promise promise2 = promise;
            File file2 = file;
            return downloadResumableTaskParams.copy(downloadOptionsLegacy, call, file2, z, promise2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DownloadOptionsLegacy getOptions() {
            return this.options;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Call getCall() {
            return this.call;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final File getFile() {
            return this.file;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsResume() {
            return this.isResume;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Promise getPromise() {
            return this.promise;
        }

        public final DownloadResumableTaskParams copy(DownloadOptionsLegacy options, Call call, File file, boolean isResume, Promise promise) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(promise, "promise");
            return new DownloadResumableTaskParams(options, call, file, isResume, promise);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DownloadResumableTaskParams)) {
                return false;
            }
            DownloadResumableTaskParams downloadResumableTaskParams = (DownloadResumableTaskParams) other;
            return Intrinsics.areEqual(this.options, downloadResumableTaskParams.options) && Intrinsics.areEqual(this.call, downloadResumableTaskParams.call) && Intrinsics.areEqual(this.file, downloadResumableTaskParams.file) && this.isResume == downloadResumableTaskParams.isResume && Intrinsics.areEqual(this.promise, downloadResumableTaskParams.promise);
        }

        public int hashCode() {
            return (((((((this.options.hashCode() * 31) + this.call.hashCode()) * 31) + this.file.hashCode()) * 31) + Boolean.hashCode(this.isResume)) * 31) + this.promise.hashCode();
        }

        public String toString() {
            return "DownloadResumableTaskParams(options=" + this.options + ", call=" + this.call + ", file=" + this.file + ", isResume=" + this.isResume + ", promise=" + this.promise + ")";
        }

        public DownloadResumableTaskParams(DownloadOptionsLegacy options, Call call, File file, boolean z, Promise promise) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(promise, "promise");
            this.options = options;
            this.call = call;
            this.file = file;
            this.isResume = z;
            this.promise = promise;
        }

        public final DownloadOptionsLegacy getOptions() {
            return this.options;
        }

        public final Call getCall() {
            return this.call;
        }

        public final File getFile() {
            return this.file;
        }

        public final boolean isResume() {
            return this.isResume;
        }

        public final Promise getPromise() {
            return this.promise;
        }
    }

    /* JADX INFO: renamed from: expo.modules.filesystem.legacy.FileSystemLegacyModule$downloadResumableTask$2, reason: invalid class name */
    /* JADX INFO: compiled from: FileSystemLegacyModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.filesystem.legacy.FileSystemLegacyModule$downloadResumableTask$2", f = "FileSystemLegacyModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation, Object> {
        final /* synthetic */ DownloadResumableTaskParams $params;
        int label;
        final /* synthetic */ FileSystemLegacyModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DownloadResumableTaskParams downloadResumableTaskParams, FileSystemLegacyModule fileSystemLegacyModule, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$params = downloadResumableTaskParams;
            this.this$0 = fileSystemLegacyModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$params, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DownloadResumableTaskParams downloadResumableTaskParams = this.$params;
            DownloadOptionsLegacy options = downloadResumableTaskParams.getOptions();
            Call call = downloadResumableTaskParams.getCall();
            File file = downloadResumableTaskParams.getFile();
            boolean isResume = downloadResumableTaskParams.getIsResume();
            Promise promise = downloadResumableTaskParams.getPromise();
            try {
                Response responseExecute = call.execute();
                ResponseBody responseBodyBody = responseExecute.body();
                Intrinsics.checkNotNull(responseBodyBody);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(responseBodyBody.byteStream());
                FileOutputStream fileOutputStream = new FileOutputStream(file, isResume);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                Bundle bundle = new Bundle();
                FileSystemLegacyModule fileSystemLegacyModule = this.this$0;
                bundle.putString("uri", Uri.fromFile(file).toString());
                bundle.putInt("status", responseExecute.code());
                bundle.putBundle("headers", fileSystemLegacyModule.translateHeaders(responseExecute.headers()));
                Boolean boolBoxBoolean = Boxing.boxBoolean(options.getMd5());
                if (!boolBoxBoolean.booleanValue()) {
                    boolBoxBoolean = null;
                }
                if (boolBoxBoolean != null) {
                    boolBoxBoolean.booleanValue();
                    bundle.putString("md5", fileSystemLegacyModule.md5(file));
                }
                responseExecute.close();
                promise.resolve(bundle);
                return null;
            } catch (Exception e) {
                if (call.getCanceled()) {
                    promise.resolve((Object) null);
                    return null;
                }
                String message = e.getMessage();
                if (message != null) {
                    Boxing.boxInt(Log.e(FileSystemLegacyModuleKt.TAG, message));
                }
                promise.reject(FileSystemLegacyModuleKt.TAG, e.getMessage(), e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadResumableTask(DownloadResumableTaskParams downloadResumableTaskParams, Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(downloadResumableTaskParams, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: FileSystemLegacyModule.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/filesystem/legacy/FileSystemLegacyModule$TaskHandler;", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "<init>", "(Lokhttp3/Call;)V", "getCall", "()Lokhttp3/Call;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static class TaskHandler {
        private final Call call;

        public TaskHandler(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            this.call = call;
        }

        public final Call getCall() {
            return this.call;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: FileSystemLegacyModule.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/filesystem/legacy/FileSystemLegacyModule$DownloadTaskHandler;", "Lexpo/modules/filesystem/legacy/FileSystemLegacyModule$TaskHandler;", "fileUri", "Landroid/net/Uri;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "<init>", "(Landroid/net/Uri;Lokhttp3/Call;)V", "getFileUri", "()Landroid/net/Uri;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class DownloadTaskHandler extends TaskHandler {
        private final Uri fileUri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadTaskHandler(Uri fileUri, Call call) {
            super(call);
            Intrinsics.checkNotNullParameter(fileUri, "fileUri");
            Intrinsics.checkNotNullParameter(call, "call");
            this.fileUri = fileUri;
        }

        public final Uri getFileUri() {
            return this.fileUri;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: FileSystemLegacyModule.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/filesystem/legacy/FileSystemLegacyModule$ProgressResponseBody;", "Lokhttp3/ResponseBody;", "responseBody", "progressListener", "Lexpo/modules/filesystem/legacy/FileSystemLegacyModule$ProgressListener;", "<init>", "(Lokhttp3/ResponseBody;Lexpo/modules/filesystem/legacy/FileSystemLegacyModule$ProgressListener;)V", "bufferedSource", "Lokio/BufferedSource;", "contentType", "Lokhttp3/MediaType;", "contentLength", "", "source", "Lokio/Source;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class ProgressResponseBody extends ResponseBody {
        private BufferedSource bufferedSource;
        private final ProgressListener progressListener;
        private final ResponseBody responseBody;

        public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
            Intrinsics.checkNotNullParameter(progressListener, "progressListener");
            this.responseBody = responseBody;
            this.progressListener = progressListener;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: contentType */
        public MediaType get$contentType() {
            ResponseBody responseBody = this.responseBody;
            if (responseBody != null) {
                return responseBody.get$contentType();
            }
            return null;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: contentLength */
        public long getContentLength() {
            ResponseBody responseBody = this.responseBody;
            if (responseBody != null) {
                return responseBody.getContentLength();
            }
            return -1L;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: source */
        public BufferedSource getBodySource() {
            BufferedSource bufferedSource = this.bufferedSource;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            ResponseBody responseBody = this.responseBody;
            Intrinsics.checkNotNull(responseBody);
            return Okio.buffer(source(responseBody.getBodySource()));
        }

        private final Source source(final Source source) {
            return new ForwardingSource(source) { // from class: expo.modules.filesystem.legacy.FileSystemLegacyModule$ProgressResponseBody$source$1
                private long totalBytesRead;

                public final long getTotalBytesRead() {
                    return this.totalBytesRead;
                }

                public final void setTotalBytesRead(long j) {
                    this.totalBytesRead = j;
                }

                @Override // okio.ForwardingSource, okio.Source
                public long read(Buffer sink, long byteCount) throws IOException {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    long j = super.read(sink, byteCount);
                    this.totalBytesRead += j != -1 ? j : 0L;
                    FileSystemLegacyModule.ProgressListener progressListener = this.progressListener;
                    long j2 = this.totalBytesRead;
                    ResponseBody responseBody = this.responseBody;
                    progressListener.update(j2, responseBody != null ? responseBody.getContentLength() : -1L, j == -1);
                    return j;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized OkHttpClient getOkHttpClient() {
        if (this.client == null) {
            this.client = new OkHttpClient.Builder().connectTimeout(60L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).writeTimeout(60L, TimeUnit.SECONDS).build();
        }
        return this.client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String md5(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            char[] cArrEncodeHex = Hex.encodeHex(DigestUtils.md5(fileInputStream));
            Intrinsics.checkNotNullExpressionValue(cArrEncodeHex, "encodeHex(...)");
            String str = new String(cArrEncodeHex);
            CloseableKt.closeFinally(fileInputStream, null);
            return str;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("Failed to list contents of " + file);
            }
            IOException e = null;
            for (File file2 : fileArrListFiles) {
                try {
                    Intrinsics.checkNotNull(file2);
                    forceDelete(file2);
                } catch (IOException e2) {
                    e = e2;
                }
            }
            if (e != null) {
                throw e;
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
        if (file.delete()) {
            return;
        }
        throw new IOException("Unable to delete file: " + file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getFileSize(File file) {
        Object obj;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
        for (File file2 : fileArrListFiles) {
            Intrinsics.checkNotNull(file2);
            arrayList.add(Long.valueOf(getFileSize(file2)));
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                next = Long.valueOf(((Number) next).longValue() + ((Number) it.next()).longValue());
            }
            obj = next;
        } else {
            obj = null;
        }
        Long l = (Long) obj;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    static /* synthetic */ InputStream getInputStream$default(FileSystemLegacyModule fileSystemLegacyModule, Uri uri, String str, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInputStream");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return fileSystemLegacyModule.getInputStream(uri, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InputStream getInputStream(Uri uri, String uriStr) throws IOException {
        String str;
        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
            return new FileInputStream(toFile(uri));
        }
        if (Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_ASSET_SCHEME)) {
            return openAssetInputStream(uri);
        }
        if (uri.getScheme() == null && (str = uriStr) != null && str.length() != 0) {
            return openResourceInputStream(uriStr);
        }
        if (isSAFUri(uri)) {
            InputStream inputStreamOpenInputStream = getContext().getContentResolver().openInputStream(uri);
            Intrinsics.checkNotNull(inputStreamOpenInputStream);
            return inputStreamOpenInputStream;
        }
        throw new IOException("Unsupported scheme for location '" + uri + "'.");
    }

    static /* synthetic */ OutputStream getOutputStream$default(FileSystemLegacyModule fileSystemLegacyModule, Uri uri, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOutputStream");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return fileSystemLegacyModule.getOutputStream(uri, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OutputStream getOutputStream(Uri uri, boolean append) throws IOException {
        String str;
        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
            return new FileOutputStream(toFile(uri), append);
        }
        if (isSAFUri(uri)) {
            ContentResolver contentResolver = getContext().getContentResolver();
            if (append) {
                str = "wa";
            } else {
                str = "w";
            }
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uri, str);
            Intrinsics.checkNotNull(outputStreamOpenOutputStream);
            return outputStreamOpenOutputStream;
        }
        throw new IOException("Unsupported scheme for location '" + uri + "'.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DocumentFile getNearestSAFFile(Uri uri) {
        DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(getContext(), uri);
        return (documentFileFromSingleUri == null || !documentFileFromSingleUri.isFile()) ? DocumentFile.fromTreeUri(getContext(), uri) : documentFileFromSingleUri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File toFile(Uri uri) throws IOException {
        if (uri.getPath() != null) {
            String path = uri.getPath();
            Intrinsics.checkNotNull(path);
            return new File(path);
        }
        throw new IOException("Invalid Uri: " + uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSAFUri(Uri uri) {
        if (Intrinsics.areEqual(uri.getScheme(), "content")) {
            String host = uri.getHost();
            if (host != null ? StringsKt.startsWith$default(host, "com.android.externalstorage", false, 2, (Object) null) : false) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String parseFileUri(String uriStr) {
        String strSubstring = uriStr.substring(StringsKt.indexOf$default((CharSequence) uriStr, AbstractJsonLexerKt.COLON, 0, false, 6, (Object) null) + 3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle translateHeaders(Headers headers) {
        Bundle bundle = new Bundle();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String strName = headers.name(i);
            if (bundle.containsKey(strName)) {
                bundle.putString(strName, bundle.getString(strName) + ", " + headers.value(i));
            } else {
                bundle.putString(strName, headers.value(i));
            }
        }
        return bundle;
    }
}
