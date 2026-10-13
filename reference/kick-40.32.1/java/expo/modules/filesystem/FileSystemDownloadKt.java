package expo.modules.filesystem;

import android.webkit.URLUtil;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import expo.modules.notifications.serverregistration.InstallationId;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: FileSystemDownload.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0087\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2K\u0010\r\u001aG\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u000eH\u0086@¢\u0006\u0002\u0010\u0016\u001a(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u001b\u001a\u008b\u0001\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\n2K\u0010\r\u001aG\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u000e2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120$H\u0080@¢\u0006\u0002\u0010%\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"sharedHttpClient", "Lokhttp3/OkHttpClient;", "downloadFileWithStore", "Ljava/net/URI;", ImagesContract.URL, "to", "Lexpo/modules/filesystem/FileSystemPath;", "options", "Lexpo/modules/filesystem/DownloadOptions;", "downloadUUID", "", "downloadStore", "Lexpo/modules/filesystem/DownloadTaskStore;", "emitProgress", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", InstallationId.LEGACY_PREFERENCES_UUID_KEY, "", "bytesWritten", "totalBytes", "", "(Ljava/net/URI;Lexpo/modules/filesystem/FileSystemPath;Lexpo/modules/filesystem/DownloadOptions;Ljava/lang/String;Lexpo/modules/filesystem/DownloadTaskStore;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeRequest", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;Ljava/lang/String;Lexpo/modules/filesystem/DownloadTaskStore;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PROGRESS_THROTTLE_MS", "streamWithProgress", "input", "Ljava/io/InputStream;", "output", "Ljava/io/FileOutputStream;", "contentLength", "currentTimeProvider", "Lkotlin/Function0;", "(Ljava/io/InputStream;Ljava/io/FileOutputStream;JLjava/lang/String;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-file-system_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileSystemDownloadKt {
    private static final long PROGRESS_THROTTLE_MS = 100;
    private static final OkHttpClient sharedHttpClient = new OkHttpClient();

    /* JADX INFO: renamed from: expo.modules.filesystem.FileSystemDownloadKt$downloadFileWithStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileSystemDownload.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.filesystem.FileSystemDownloadKt", f = "FileSystemDownload.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {73, 99}, m = "downloadFileWithStore", n = {ImagesContract.URL, "to", "options", "downloadUUID", "downloadStore", "emitProgress", "requestBuilder", "request", ImagesContract.URL, "to", "options", "downloadUUID", "downloadStore", "emitProgress", "requestBuilder", "request", "response", "activeResponse", "contentDisposition", "contentType", "fileName", FirebaseAnalytics.Param.DESTINATION, ExpoNotificationBuilder.EXTRAS_BODY_KEY, "input", "output", "$i$a$-use-FileSystemDownloadKt$downloadFileWithStore$3", "$i$a$-use-FileSystemDownloadKt$downloadFileWithStore$3$1", "$i$a$-use-FileSystemDownloadKt$downloadFileWithStore$3$1$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$19", "I$0", "I$1", "I$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileSystemDownloadKt.downloadFileWithStore(null, null, null, null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:126:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:54:0x01a6 A[Catch: all -> 0x02e7, TRY_LEAVE, TryCatch #4 {all -> 0x02e7, blocks: (B:36:0x014f, B:38:0x0158, B:50:0x019a, B:52:0x01a0, B:54:0x01a6, B:43:0x0188), top: B:135:0x014f }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01c4 A[Catch: all -> 0x0293, TRY_LEAVE, TryCatch #12 {all -> 0x0293, blocks: (B:58:0x01bc, B:60:0x01c4), top: B:150:0x01bc }] */
    /* JADX WARN: Code duplicated, block: B:65:0x024a  */
    /* JADX WARN: Code duplicated, block: B:70:0x0259  */
    /* JADX WARN: Code duplicated, block: B:77:0x0282  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v30, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v42 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Object, java.net.URI] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.io.Closeable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [expo.modules.filesystem.DownloadTaskStore] */
    /* JADX WARN: Type inference failed for: r3v14, types: [expo.modules.filesystem.DownloadTaskStore] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static final Object downloadFileWithStore(URI uri, FileSystemPath fileSystemPath, DownloadOptions downloadOptions, String str, DownloadTaskStore downloadTaskStore, Function3<? super String, ? super Long, ? super Long, Unit> function3, Continuation<? super URI> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Request.Builder builderUrl;
        Request requestBuild;
        Object objExecuteRequest;
        FileSystemPath fileSystemPath2;
        Function3<? super String, ? super Long, ? super Long, Unit> function4;
        Map<String, String> headers;
        ?? r10;
        ?? r3;
        ?? r2;
        Response response;
        Response response2;
        ?? r11;
        Response response3;
        Throwable th;
        ?? r14;
        File file;
        Request.Builder builder;
        ResponseBody responseBodyBody;
        InputStream inputStreamByteStream;
        Request request;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        ?? r5;
        ?? r6;
        ?? r4;
        FileOutputStream fileOutputStream2;
        Throwable th2;
        Closeable closeable;
        File file2;
        long contentLength;
        File file3;
        ?? r12;
        Throwable th3;
        Throwable th4;
        ?? r15;
        ?? r13;
        ?? r7;
        DownloadOptions downloadOptions2 = downloadOptions;
        String str2 = str;
        DownloadTaskStore downloadTaskStore2 = downloadTaskStore;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        fileSystemPath.validatePermission(FilePermissionService.Permission.WRITE);
                        Request.Builder builder2 = new Request.Builder();
                        URL url = uri.toURL();
                        Intrinsics.checkNotNullExpressionValue(url, "toURL(...)");
                        builderUrl = builder2.url(url);
                        if (downloadOptions2 != null && (headers = downloadOptions2.getHeaders()) != null) {
                            for (Map.Entry<String, String> entry : headers.entrySet()) {
                                builderUrl.addHeader(entry.getKey(), entry.getValue());
                            }
                        }
                        requestBuild = builderUrl.build();
                        URI uri2 = uri;
                        anonymousClass2.L$0 = uri2;
                        anonymousClass2.L$1 = fileSystemPath;
                        anonymousClass2.L$2 = downloadOptions2;
                        anonymousClass2.L$3 = str2;
                        anonymousClass2.L$4 = downloadTaskStore2;
                        anonymousClass2.L$5 = function3;
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(builderUrl);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(requestBuild);
                        anonymousClass2.label = 1;
                        objExecuteRequest = executeRequest(requestBuild, str2, downloadTaskStore2, anonymousClass2);
                        if (objExecuteRequest != coroutine_suspended) {
                            fileSystemPath2 = fileSystemPath;
                            function4 = function3;
                            r2 = str2;
                            r3 = downloadTaskStore2;
                            r10 = uri2;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass2.I$2;
                        int i3 = anonymousClass2.I$1;
                        int i4 = anonymousClass2.I$0;
                        fileOutputStream = (Closeable) anonymousClass2.L$18;
                        Closeable closeable2 = (Closeable) anonymousClass2.L$15;
                        File file4 = (File) anonymousClass2.L$14;
                        Closeable closeable3 = (Closeable) anonymousClass2.L$9;
                        DownloadTaskStore downloadTaskStore3 = (DownloadTaskStore) anonymousClass2.L$4;
                        String str3 = (String) anonymousClass2.L$3;
                        try {
                            ResultKt.throwOnFailure(obj);
                            inputStreamByteStream = closeable2;
                            closeable = fileOutputStream;
                            file2 = file4;
                            th2 = null;
                            r4 = closeable3;
                            r5 = downloadTaskStore3;
                            r6 = str3;
                            try {
                                Unit unit = Unit.INSTANCE;
                                response2 = r4;
                                r3 = r5;
                                r11 = r6;
                                try {
                                    CloseableKt.closeFinally(closeable, th2);
                                    try {
                                        CloseableKt.closeFinally(inputStreamByteStream, th2);
                                        URI uri3 = file2.toURI();
                                        try {
                                            CloseableKt.closeFinally(response2, th2);
                                            Intrinsics.checkNotNullExpressionValue(uri3, "use(...)");
                                            if (r11 != 0) {
                                                r3.remove(r11);
                                            }
                                            return uri3;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            r2 = r11;
                                            if (r2 != 0) {
                                                r3.remove(r2);
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        th = th;
                                        r7 = r3;
                                        r13 = r11;
                                        r14 = response2;
                                        r2 = r13;
                                        r3 = r7;
                                        r15 = r14;
                                        throw th;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    th4 = th;
                                    r2 = r11;
                                    r3 = r3;
                                    response2 = response2;
                                    try {
                                        throw th4;
                                    } catch (Throwable th8) {
                                        CloseableKt.closeFinally(inputStreamByteStream, th4);
                                        throw th8;
                                    }
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                th3 = th;
                                try {
                                    throw th3;
                                } catch (Throwable th10) {
                                    try {
                                        CloseableKt.closeFinally(closeable, th3);
                                        throw th10;
                                    } catch (Throwable th11) {
                                        th4 = th11;
                                        response2 = r4;
                                        r3 = r5;
                                        r2 = r6;
                                        throw th4;
                                    }
                                }
                            }
                        } catch (Throwable th12) {
                            th = th12;
                            inputStreamByteStream = closeable2;
                            r4 = closeable3;
                            r5 = downloadTaskStore3;
                            r6 = str3;
                            closeable = fileOutputStream;
                            th3 = th;
                            throw th3;
                        }
                    }
                    Request request2 = (Request) anonymousClass2.L$7;
                    Request.Builder builder3 = (Request.Builder) anonymousClass2.L$6;
                    Function3<? super String, ? super Long, ? super Long, Unit> function5 = (Function3) anonymousClass2.L$5;
                    DownloadTaskStore downloadTaskStore4 = (DownloadTaskStore) anonymousClass2.L$4;
                    String str4 = (String) anonymousClass2.L$3;
                    DownloadOptions downloadOptions3 = (DownloadOptions) anonymousClass2.L$2;
                    fileSystemPath2 = (FileSystemPath) anonymousClass2.L$1;
                    URI uri4 = (URI) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj);
                    requestBuild = request2;
                    function4 = function5;
                    r2 = str4;
                    builderUrl = builder3;
                    downloadOptions2 = downloadOptions3;
                    r10 = uri4;
                    objExecuteRequest = obj;
                    r3 = downloadTaskStore4;
                    if (!response3.isSuccessful()) {
                        throw new UnableToDownloadException("response has status: " + response3.code());
                    }
                    String str5 = response3.headers().get("content-disposition");
                    String str6 = response3.headers().get("content-type");
                    String strGuessFileName = URLUtil.guessFileName(r10.toString(), str5, str6);
                    Function3<? super String, ? super Long, ? super Long, Unit> function6 = function4;
                    if (fileSystemPath2 instanceof FileSystemDirectory) {
                        try {
                            file = new File(fileSystemPath2.getJavaFile(), strGuessFileName);
                        } catch (Throwable th13) {
                            th = th13;
                            r2 = r2;
                            r3 = r3;
                            r15 = response2;
                        }
                    } else {
                        file = fileSystemPath2.getJavaFile();
                    }
                    if (downloadOptions2 != 0) {
                        builder = builderUrl;
                        if (!downloadOptions2.getIdempotent()) {
                        }
                        responseBodyBody = response3.body();
                        if (responseBodyBody != null) {
                            throw new UnableToDownloadException("response body is null");
                        }
                        inputStreamByteStream = responseBodyBody.byteStream();
                        request = requestBuild;
                        try {
                            inputStream = inputStreamByteStream;
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                fileOutputStream2 = fileOutputStream;
                                try {
                                    if (r2 != 0) {
                                        contentLength = responseBodyBody.getContentLength();
                                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(r10);
                                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(fileSystemPath2);
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(downloadOptions2);
                                        anonymousClass2.L$3 = r2;
                                        anonymousClass2.L$4 = r3;
                                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(function6);
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(builder);
                                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(request);
                                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(response);
                                        anonymousClass2.L$9 = response2;
                                        anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(response3);
                                        anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(str5);
                                        anonymousClass2.L$12 = SpillingKt.nullOutSpilledVariable(str6);
                                        anonymousClass2.L$13 = SpillingKt.nullOutSpilledVariable(strGuessFileName);
                                        anonymousClass2.L$14 = file;
                                        anonymousClass2.L$15 = inputStreamByteStream;
                                        anonymousClass2.L$16 = SpillingKt.nullOutSpilledVariable(responseBodyBody);
                                        anonymousClass2.L$17 = SpillingKt.nullOutSpilledVariable(inputStream);
                                        anonymousClass2.L$18 = fileOutputStream;
                                        anonymousClass2.L$19 = SpillingKt.nullOutSpilledVariable(fileOutputStream2);
                                        anonymousClass2.I$0 = 0;
                                        anonymousClass2.I$1 = 0;
                                        anonymousClass2.I$2 = 0;
                                        anonymousClass2.label = 2;
                                        file3 = file;
                                        r12 = r2;
                                        th2 = null;
                                        if (streamWithProgress$default(inputStream, fileOutputStream2, contentLength, r12, function6, null, anonymousClass2, 32, null) != coroutine_suspended) {
                                            r5 = r3;
                                            r6 = r12;
                                            r4 = response2;
                                            closeable = fileOutputStream;
                                            file2 = file3;
                                            Unit unit2 = Unit.INSTANCE;
                                            response2 = r4;
                                            r3 = r5;
                                            r11 = r6;
                                        }
                                        return coroutine_suspended;
                                    }
                                    File file5 = file;
                                    r11 = r2;
                                    th2 = null;
                                    Boxing.boxLong(ByteStreamsKt.copyTo$default(inputStream, fileOutputStream2, 0, 2, null));
                                    response2 = response2;
                                    closeable = fileOutputStream;
                                    file2 = file5;
                                    r3 = r3;
                                    CloseableKt.closeFinally(closeable, th2);
                                    CloseableKt.closeFinally(inputStreamByteStream, th2);
                                    URI uri5 = file2.toURI();
                                    CloseableKt.closeFinally(response2, th2);
                                    Intrinsics.checkNotNullExpressionValue(uri5, "use(...)");
                                    if (r11 != 0) {
                                        r3.remove(r11);
                                    }
                                    return uri5;
                                } catch (Throwable th14) {
                                    th = th14;
                                    r5 = r3;
                                    r6 = r10;
                                    r4 = r2;
                                    closeable = fileOutputStream;
                                    th3 = th;
                                    throw th3;
                                }
                            } catch (Throwable th15) {
                                th = th15;
                                r10 = r2;
                                r2 = response2;
                            }
                        } catch (Throwable th16) {
                            th = th16;
                            r11 = r2;
                            th4 = th;
                            r2 = r11;
                            r3 = r3;
                            response2 = response2;
                            throw th4;
                        }
                    } else {
                        builder = builderUrl;
                    }
                    if (file.exists()) {
                        throw new DestinationAlreadyExistsException();
                    }
                    responseBodyBody = response3.body();
                    if (responseBodyBody != null) {
                        throw new UnableToDownloadException("response body is null");
                    }
                    inputStreamByteStream = responseBodyBody.byteStream();
                    request = requestBuild;
                    inputStream = inputStreamByteStream;
                    fileOutputStream = new FileOutputStream(file);
                    fileOutputStream2 = fileOutputStream;
                    if (r2 != 0) {
                        contentLength = responseBodyBody.getContentLength();
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(r10);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(fileSystemPath2);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(downloadOptions2);
                        anonymousClass2.L$3 = r2;
                        anonymousClass2.L$4 = r3;
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(function6);
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(builder);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(request);
                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(response);
                        anonymousClass2.L$9 = response2;
                        anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(response3);
                        anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(str5);
                        anonymousClass2.L$12 = SpillingKt.nullOutSpilledVariable(str6);
                        anonymousClass2.L$13 = SpillingKt.nullOutSpilledVariable(strGuessFileName);
                        anonymousClass2.L$14 = file;
                        anonymousClass2.L$15 = inputStreamByteStream;
                        anonymousClass2.L$16 = SpillingKt.nullOutSpilledVariable(responseBodyBody);
                        anonymousClass2.L$17 = SpillingKt.nullOutSpilledVariable(inputStream);
                        anonymousClass2.L$18 = fileOutputStream;
                        anonymousClass2.L$19 = SpillingKt.nullOutSpilledVariable(fileOutputStream2);
                        anonymousClass2.I$0 = 0;
                        anonymousClass2.I$1 = 0;
                        anonymousClass2.I$2 = 0;
                        anonymousClass2.label = 2;
                        file3 = file;
                        r12 = r2;
                        th2 = null;
                        if (streamWithProgress$default(inputStream, fileOutputStream2, contentLength, r12, function6, null, anonymousClass2, 32, null) != coroutine_suspended) {
                            r5 = r3;
                            r6 = r12;
                            r4 = response2;
                            closeable = fileOutputStream;
                            file2 = file3;
                            Unit unit3 = Unit.INSTANCE;
                            response2 = r4;
                            r3 = r5;
                            r11 = r6;
                        }
                        return coroutine_suspended;
                    }
                    File file6 = file;
                    r11 = r2;
                    th2 = null;
                    Boxing.boxLong(ByteStreamsKt.copyTo$default(inputStream, fileOutputStream2, 0, 2, null));
                    response2 = response2;
                    closeable = fileOutputStream;
                    file2 = file6;
                    r3 = r3;
                    CloseableKt.closeFinally(closeable, th2);
                    CloseableKt.closeFinally(inputStreamByteStream, th2);
                    URI uri6 = file2.toURI();
                    CloseableKt.closeFinally(response2, th2);
                    Intrinsics.checkNotNullExpressionValue(uri6, "use(...)");
                    if (r11 != 0) {
                        r3.remove(r11);
                    }
                    return uri6;
                } catch (Throwable th17) {
                    th = th17;
                    r14 = r2;
                    r7 = r3;
                    r13 = r10;
                    r2 = r13;
                    r3 = r7;
                    r15 = r14;
                    throw th;
                }
                response3 = response2;
            } catch (Throwable th18) {
                th = th18;
                r11 = r2;
            }
            response2 = response;
        } catch (Throwable th19) {
            th = th19;
            if (r2 != 0) {
                r3.remove(r2);
            }
            throw th;
        }
        response = (Response) objExecuteRequest;
        th = th;
        r7 = r3;
        r13 = r11;
        r14 = response2;
        r2 = r13;
        r3 = r7;
        r15 = r14;
        try {
            throw th;
        } catch (Throwable th20) {
            try {
                CloseableKt.closeFinally(r15, th);
                throw th20;
            } catch (Throwable th21) {
                th = th21;
                if (r2 != 0) {
                    r3.remove(r2);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: expo.modules.filesystem.FileSystemDownloadKt$streamWithProgress$2, reason: invalid class name */
    /* JADX INFO: compiled from: FileSystemDownload.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Long> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    /* JADX INFO: renamed from: expo.modules.filesystem.FileSystemDownloadKt$streamWithProgress$3, reason: invalid class name */
    /* JADX INFO: compiled from: FileSystemDownload.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.filesystem.FileSystemDownloadKt$streamWithProgress$3", f = "FileSystemDownload.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $contentLength;
        final /* synthetic */ Function0<Long> $currentTimeProvider;
        final /* synthetic */ Function3<String, Long, Long, Unit> $emitProgress;
        final /* synthetic */ InputStream $input;
        final /* synthetic */ FileOutputStream $output;
        final /* synthetic */ String $uuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(InputStream inputStream, FileOutputStream fileOutputStream, Function0<Long> function0, Function3<? super String, ? super Long, ? super Long, Unit> function3, String str, long j, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$input = inputStream;
            this.$output = fileOutputStream;
            this.$currentTimeProvider = function0;
            this.$emitProgress = function3;
            this.$uuid = str;
            this.$contentLength = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$input, this.$output, this.$currentTimeProvider, this.$emitProgress, this.$uuid, this.$contentLength, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            byte[] bArr = new byte[8192];
            long j = 0;
            long j2 = 0;
            while (true) {
                int i = this.$input.read(bArr);
                if (i != -1) {
                    JobKt.ensureActive(get$context());
                    this.$output.write(bArr, 0, i);
                    j += (long) i;
                    long jLongValue = this.$currentTimeProvider.invoke().longValue();
                    if (jLongValue - j2 >= 100) {
                        this.$emitProgress.invoke(this.$uuid, Boxing.boxLong(j), Boxing.boxLong(this.$contentLength));
                        j2 = jLongValue;
                    }
                } else {
                    this.$emitProgress.invoke(this.$uuid, Boxing.boxLong(j), Boxing.boxLong(this.$contentLength));
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public static /* synthetic */ Object streamWithProgress$default(InputStream inputStream, FileOutputStream fileOutputStream, long j, String str, Function3 function3, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 32) != 0) {
            function0 = AnonymousClass2.INSTANCE;
        }
        return streamWithProgress(inputStream, fileOutputStream, j, str, function3, function0, continuation);
    }

    public static final Object streamWithProgress(InputStream inputStream, FileOutputStream fileOutputStream, long j, String str, Function3<? super String, ? super Long, ? super Long, Unit> function3, Function0<Long> function0, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass3(inputStream, fileOutputStream, function0, function3, str, j, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object executeRequest(Request request, final String str, final DownloadTaskStore downloadTaskStore, Continuation<? super Response> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final Call callNewCall = sharedHttpClient.newCall(request);
        if (str != null) {
            downloadTaskStore.store(callNewCall, str);
        }
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: expo.modules.filesystem.FileSystemDownloadKt$executeRequest$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                callNewCall.cancel();
                String str2 = str;
                if (str2 != null) {
                    downloadTaskStore.remove(str2);
                }
            }
        });
        callNewCall.enqueue(new Callback() { // from class: expo.modules.filesystem.FileSystemDownloadKt$executeRequest$2$2
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                CancellableContinuation<Response> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m12684constructorimpl(response));
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                if (cancellableContinuationImpl2.isCancelled()) {
                    return;
                }
                CancellableContinuation<Response> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(e)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
