package expo.modules.filesystem;

import androidx.core.app.NotificationCompat;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import expo.modules.filesystem.unifiedfile.JavaFile;
import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: FileSystemDownloadTask.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001bJ2\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0086@¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020 H\u0016J0\u0010\"\u001a\u0004\u0018\u00010\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010(J?\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\f2\u0014\u0010,\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020 0-H\u0082\bJ \u0010.\u001a\u00020 2\u0006\u0010%\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\fH\u0002J\u0018\u00100\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u00063"}, d2 = {"Lexpo/modules/filesystem/FileSystemDownloadTask;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "<init>", "()V", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "isPausing", "", "isCancelling", "destinationFile", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "bytesWritten", "", "lastProgressTime", "progressThrottleInterval", "Lkotlin/time/Duration;", "J", ViewProps.START, "", ImagesContract.URL, "Ljava/net/URI;", "to", "Lexpo/modules/filesystem/FileSystemPath;", "options", "Lexpo/modules/filesystem/DownloadTaskOptions;", "(Ljava/net/URI;Lexpo/modules/filesystem/FileSystemPath;Lexpo/modules/filesystem/DownloadTaskOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", PauseEvent.TYPE, "", "resume", "resumeData", "(Ljava/net/URI;Lexpo/modules/filesystem/FileSystemPath;Ljava/lang/String;Lexpo/modules/filesystem/DownloadTaskOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "sharedObjectDidRelease", "downloadToFile", "request", "Lokhttp3/Request;", FirebaseAnalytics.Param.DESTINATION, "isResume", "offset", "(Lokhttp3/Request;Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDownloadResponse", "resp", "Lokhttp3/Response;", "onComplete", "Lkotlin/Function1;", "prepareDestinationForWrite", "append", "emitProgress", "totalBytes", "Companion", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileSystemDownloadTask extends SharedObject {
    private static final OkHttpClient client = OkHttpClientProvider.createClientBuilder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
    private volatile long bytesWritten;
    private Call call;
    private UnifiedFileInterface destinationFile;
    private volatile boolean isCancelling;
    private volatile boolean isPausing;
    private long lastProgressTime;
    private final long progressThrottleInterval;

    public FileSystemDownloadTask() {
        super(null, 1, null);
        Duration.Companion companion = Duration.INSTANCE;
        this.progressThrottleInterval = DurationKt.toDuration(100, DurationUnit.MILLISECONDS);
    }

    public final Object start(URI uri, FileSystemPath fileSystemPath, DownloadTaskOptions downloadTaskOptions, Continuation<? super String> continuation) throws UnableToDownloadException, InvalidPermissionException, Exceptions.ReactContextLost {
        Map<String, String> headers;
        this.isPausing = false;
        this.isCancelling = false;
        this.bytesWritten = 0L;
        UnifiedFileInterface unifiedFileInterfaceResolveDownloadDestination = FileSystemDownloadTaskKt.resolveDownloadDestination(fileSystemPath, uri);
        this.destinationFile = unifiedFileInterfaceResolveDownloadDestination;
        Request.Builder builder = new Request.Builder();
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Request.Builder builderUrl = builder.url(string);
        if (downloadTaskOptions != null && (headers = downloadTaskOptions.getHeaders()) != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builderUrl.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return downloadToFile(builderUrl.build(), unifiedFileInterfaceResolveDownloadDestination, false, 0L, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    public final Map<String, String> pause() {
        long jLongValue;
        this.isPausing = true;
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
        UnifiedFileInterface unifiedFileInterface = this.destinationFile;
        if (unifiedFileInterface != null) {
            Long lValueOf = Long.valueOf(unifiedFileInterface.length());
            if (lValueOf.longValue() <= 0) {
                lValueOf = null;
            }
            if (lValueOf != null) {
                jLongValue = lValueOf.longValue();
            } else {
                jLongValue = this.bytesWritten;
            }
        } else {
            jLongValue = this.bytesWritten;
        }
        return MapsKt.mapOf(TuplesKt.to("resumeData", String.valueOf(jLongValue)));
    }

    public final Object resume(URI uri, FileSystemPath fileSystemPath, String str, DownloadTaskOptions downloadTaskOptions, Continuation<? super String> continuation) throws InvalidResumeDataException, UnableToDownloadException, InvalidPermissionException, Exceptions.ReactContextLost {
        Map<String, String> headers;
        this.isPausing = false;
        this.isCancelling = false;
        try {
            long j = Long.parseLong(str);
            this.bytesWritten = j;
            UnifiedFileInterface unifiedFileInterfaceResolveDownloadDestination = FileSystemDownloadTaskKt.resolveDownloadDestination(fileSystemPath, uri);
            this.destinationFile = unifiedFileInterfaceResolveDownloadDestination;
            Request.Builder builder = new Request.Builder();
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Request.Builder builderUrl = builder.url(string);
            builderUrl.addHeader("Range", "bytes=" + j + "-");
            if (downloadTaskOptions != null && (headers = downloadTaskOptions.getHeaders()) != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    builderUrl.addHeader(entry.getKey(), entry.getValue());
                }
            }
            return downloadToFile(builderUrl.build(), unifiedFileInterfaceResolveDownloadDestination, true, j, continuation);
        } catch (NumberFormatException unused) {
            throw new InvalidResumeDataException();
        }
    }

    public final void cancel() {
        this.isPausing = false;
        this.isCancelling = true;
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void sharedObjectDidRelease() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    /* JADX INFO: renamed from: expo.modules.filesystem.FileSystemDownloadTask$downloadToFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: FileSystemDownloadTask.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.filesystem.FileSystemDownloadTask$downloadToFile$2", f = "FileSystemDownloadTask.kt", i = {0}, l = {350}, m = "invokeSuspend", n = {"$i$f$suspendCancellableCoroutine"}, s = {"I$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ UnifiedFileInterface $destination;
        final /* synthetic */ boolean $isResume;
        final /* synthetic */ long $offset;
        final /* synthetic */ Request $request;
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Request request, UnifiedFileInterface unifiedFileInterface, boolean z, long j, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$request = request;
            this.$destination = unifiedFileInterface;
            this.$isResume = z;
            this.$offset = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileSystemDownloadTask.this.new AnonymousClass2(this.$request, this.$destination, this.$isResume, this.$offset, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            final FileSystemDownloadTask fileSystemDownloadTask = FileSystemDownloadTask.this;
            Request request = this.$request;
            final UnifiedFileInterface unifiedFileInterface = this.$destination;
            final boolean z = this.$isResume;
            final long j = this.$offset;
            this.L$0 = fileSystemDownloadTask;
            this.L$1 = request;
            this.L$2 = unifiedFileInterface;
            this.Z$0 = z;
            this.J$0 = j;
            this.I$0 = 0;
            this.label = 1;
            AnonymousClass2 anonymousClass2 = this;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(anonymousClass2), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            fileSystemDownloadTask.call = FileSystemDownloadTask.client.newCall(request);
            Call call = fileSystemDownloadTask.call;
            if (call != null) {
                call.enqueue(new Callback() { // from class: expo.modules.filesystem.FileSystemDownloadTask$downloadToFile$2$1$1
                    @Override // okhttp3.Callback
                    public void onFailure(Call call2, IOException e) {
                        Intrinsics.checkNotNullParameter(call2, "call");
                        Intrinsics.checkNotNullParameter(e, "e");
                        if (!fileSystemDownloadTask.isPausing) {
                            boolean z2 = fileSystemDownloadTask.isCancelling;
                            AtomicBoolean atomicBoolean2 = atomicBoolean;
                            if (z2) {
                                FileSystemDownloadTask.AnonymousClass2.invokeSuspend$lambda$0$safeResumeWithException(atomicBoolean2, cancellableContinuationImpl2, new DownloadCancelledException());
                                return;
                            }
                            CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                            String message = e.getMessage();
                            if (message == null) {
                                message = "Download failed";
                            }
                            FileSystemDownloadTask.AnonymousClass2.invokeSuspend$lambda$0$safeResumeWithException(atomicBoolean2, cancellableContinuation, new UnableToDownloadException(message));
                            return;
                        }
                        FileSystemDownloadTask.AnonymousClass2.invokeSuspend$lambda$0$safeResume(atomicBoolean, cancellableContinuationImpl2, null);
                    }

                    /* JADX WARN: Code duplicated, block: B:100:0x0170 A[Catch: all -> 0x0194, TryCatch #7 {all -> 0x0194, blocks: (B:3:0x0022, B:4:0x0025, B:6:0x002b, B:8:0x0031, B:16:0x0043, B:21:0x0056, B:37:0x009b, B:105:0x018d, B:89:0x0149, B:92:0x0153, B:95:0x015f, B:97:0x0165, B:98:0x016a, B:100:0x0170, B:101:0x017b, B:104:0x0185, B:77:0x011c, B:78:0x011f, B:44:0x00ad, B:55:0x00d9, B:79:0x0120, B:80:0x0129, B:81:0x012a, B:82:0x0141), top: B:127:0x0022 }] */
                    /* JADX WARN: Code duplicated, block: B:101:0x017b A[Catch: all -> 0x0194, TryCatch #7 {all -> 0x0194, blocks: (B:3:0x0022, B:4:0x0025, B:6:0x002b, B:8:0x0031, B:16:0x0043, B:21:0x0056, B:37:0x009b, B:105:0x018d, B:89:0x0149, B:92:0x0153, B:95:0x015f, B:97:0x0165, B:98:0x016a, B:100:0x0170, B:101:0x017b, B:104:0x0185, B:77:0x011c, B:78:0x011f, B:44:0x00ad, B:55:0x00d9, B:79:0x0120, B:80:0x0129, B:81:0x012a, B:82:0x0141), top: B:127:0x0022 }] */
                    /* JADX WARN: Code duplicated, block: B:103:0x0183  */
                    /* JADX WARN: Code duplicated, block: B:97:0x0165 A[Catch: all -> 0x0194, TryCatch #7 {all -> 0x0194, blocks: (B:3:0x0022, B:4:0x0025, B:6:0x002b, B:8:0x0031, B:16:0x0043, B:21:0x0056, B:37:0x009b, B:105:0x018d, B:89:0x0149, B:92:0x0153, B:95:0x015f, B:97:0x0165, B:98:0x016a, B:100:0x0170, B:101:0x017b, B:104:0x0185, B:77:0x011c, B:78:0x011f, B:44:0x00ad, B:55:0x00d9, B:79:0x0120, B:80:0x0129, B:81:0x012a, B:82:0x0141), top: B:127:0x0022 }] */
                    /* JADX WARN: Code duplicated, block: B:98:0x016a A[Catch: all -> 0x0194, TryCatch #7 {all -> 0x0194, blocks: (B:3:0x0022, B:4:0x0025, B:6:0x002b, B:8:0x0031, B:16:0x0043, B:21:0x0056, B:37:0x009b, B:105:0x018d, B:89:0x0149, B:92:0x0153, B:95:0x015f, B:97:0x0165, B:98:0x016a, B:100:0x0170, B:101:0x017b, B:104:0x0185, B:77:0x011c, B:78:0x011f, B:44:0x00ad, B:55:0x00d9, B:79:0x0120, B:80:0x0129, B:81:0x012a, B:82:0x0141), top: B:127:0x0022 }] */
                    @Override // okhttp3.Callback
                    public void onResponse(Call call2, Response response) {
                        String message;
                        Throwable th;
                        BufferedInputStream bufferedInputStream;
                        Intrinsics.checkNotNullParameter(call2, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        Response response2 = response;
                        FileSystemDownloadTask fileSystemDownloadTask2 = fileSystemDownloadTask;
                        UnifiedFileInterface unifiedFileInterface2 = unifiedFileInterface;
                        boolean z2 = z;
                        long j2 = j;
                        AtomicBoolean atomicBoolean2 = atomicBoolean;
                        CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                        try {
                            Response response3 = response2;
                            try {
                                try {
                                    if (!response3.isSuccessful()) {
                                        throw new UnableToDownloadException("HTTP " + response3.code());
                                    }
                                    ResponseBody responseBodyBody = response3.body();
                                    if (responseBodyBody == null) {
                                        throw new UnableToDownloadException("Empty response body");
                                    }
                                    boolean z3 = response3.code() == 206;
                                    if (!z2 || !z3) {
                                        j2 = 0;
                                    }
                                    long jCalculateDownloadTotalBytes = FileSystemDownloadTaskKt.calculateDownloadTotalBytes(response3.code(), responseBodyBody.getContentLength(), j2);
                                    fileSystemDownloadTask2.prepareDestinationForWrite(unifiedFileInterface2, z2 && z3, j2);
                                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(responseBodyBody.byteStream());
                                    try {
                                        BufferedInputStream bufferedInputStream3 = bufferedInputStream2;
                                        try {
                                            OutputStream outputStream = unifiedFileInterface2.outputStream(z2 && z3);
                                            try {
                                                OutputStream outputStream2 = outputStream;
                                                byte[] bArr = new byte[8192];
                                                Ref.IntRef intRef = new Ref.IntRef();
                                                fileSystemDownloadTask2.bytesWritten = j2;
                                                while (true) {
                                                    try {
                                                        int i2 = bufferedInputStream3.read(bArr);
                                                        intRef.element = i2;
                                                        BufferedInputStream bufferedInputStream4 = bufferedInputStream3;
                                                        if (i2 != -1) {
                                                            try {
                                                                if (!fileSystemDownloadTask2.isCancelling) {
                                                                    if (fileSystemDownloadTask2.isPausing) {
                                                                        FileSystemDownloadTask.AnonymousClass2.invokeSuspend$lambda$0$safeResume(atomicBoolean2, cancellableContinuation, null);
                                                                        CloseableKt.closeFinally(outputStream, null);
                                                                        CloseableKt.closeFinally(bufferedInputStream2, null);
                                                                        break;
                                                                    }
                                                                    outputStream2.write(bArr, 0, intRef.element);
                                                                    bufferedInputStream = bufferedInputStream2;
                                                                    j2 += (long) intRef.element;
                                                                    try {
                                                                        fileSystemDownloadTask2.bytesWritten = j2;
                                                                        fileSystemDownloadTask2.emitProgress(j2, jCalculateDownloadTotalBytes);
                                                                        bufferedInputStream2 = bufferedInputStream;
                                                                        bufferedInputStream3 = bufferedInputStream4;
                                                                    } catch (Throwable th2) {
                                                                        th = th2;
                                                                        bufferedInputStream2 = bufferedInputStream;
                                                                    }
                                                                    Throwable th3 = th;
                                                                    try {
                                                                        throw th3;
                                                                    } catch (Throwable th4) {
                                                                        CloseableKt.closeFinally(outputStream, th3);
                                                                        throw th4;
                                                                    }
                                                                }
                                                                CloseableKt.closeFinally(outputStream, null);
                                                                CloseableKt.closeFinally(bufferedInputStream2, null);
                                                                break;
                                                            } catch (Throwable th5) {
                                                                th = th5;
                                                            }
                                                        } else {
                                                            bufferedInputStream = bufferedInputStream2;
                                                            Unit unit = Unit.INSTANCE;
                                                            try {
                                                                CloseableKt.closeFinally(outputStream, null);
                                                                Unit unit2 = Unit.INSTANCE;
                                                                CloseableKt.closeFinally(bufferedInputStream, null);
                                                                fileSystemDownloadTask2.lastProgressTime = 0L;
                                                                fileSystemDownloadTask2.bytesWritten = unifiedFileInterface2.length();
                                                                fileSystemDownloadTask2.emitProgress(fileSystemDownloadTask2.bytesWritten, fileSystemDownloadTask2.bytesWritten);
                                                                FileSystemDownloadTask.AnonymousClass2.invokeSuspend$lambda$0$safeResume(atomicBoolean2, cancellableContinuation, unifiedFileInterface2.getUri().toString());
                                                                break;
                                                            } catch (Throwable th6) {
                                                                th = th6;
                                                                bufferedInputStream2 = bufferedInputStream;
                                                                th = th;
                                                                try {
                                                                    throw th;
                                                                } catch (Throwable th7) {
                                                                    CloseableKt.closeFinally(bufferedInputStream2, th);
                                                                    throw th7;
                                                                }
                                                            }
                                                        }
                                                    } catch (Throwable th8) {
                                                        th = th8;
                                                    }
                                                }
                                                Unit unit3 = Unit.INSTANCE;
                                                CloseableKt.closeFinally(response2, null);
                                            } catch (Throwable th9) {
                                                th = th9;
                                            }
                                        } catch (Throwable th10) {
                                            th = th10;
                                            th = th;
                                            throw th;
                                        }
                                    } catch (Throwable th11) {
                                        th = th11;
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    if (fileSystemDownloadTask2.isPausing) {
                                        if (fileSystemDownloadTask2.isCancelling) {
                                            FileSystemDownloadTask.AnonymousClass2.invokeSuspend$lambda$0$safeResumeWithException(atomicBoolean2, cancellableContinuation, new DownloadCancelledException());
                                        } else {
                                            message = e.getMessage();
                                            if (message == null) {
                                                message = "Download failed";
                                            }
                                            FileSystemDownloadTask.AnonymousClass2.invokeSuspend$lambda$0$safeResumeWithException(atomicBoolean2, cancellableContinuation, new UnableToDownloadException(message));
                                        }
                                    } else {
                                        FileSystemDownloadTask.AnonymousClass2.invokeSuspend$lambda$0$safeResume(atomicBoolean2, cancellableContinuation, null);
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    String message2 = e.getMessage();
                                    if (message2 == null) {
                                        message2 = "Download failed";
                                    }
                                    FileSystemDownloadTask.AnonymousClass2.invokeSuspend$lambda$0$safeResumeWithException(atomicBoolean2, cancellableContinuation, new UnableToDownloadException(message2));
                                }
                            } catch (IOException e3) {
                                e = e3;
                            } catch (Exception e4) {
                                e = e4;
                            }
                            if (fileSystemDownloadTask2.isPausing) {
                                if (fileSystemDownloadTask2.isCancelling) {
                                    FileSystemDownloadTask.AnonymousClass2.invokeSuspend$lambda$0$safeResumeWithException(atomicBoolean2, cancellableContinuation, new DownloadCancelledException());
                                } else {
                                    message = e.getMessage();
                                    if (message == null) {
                                        message = "Download failed";
                                    }
                                    FileSystemDownloadTask.AnonymousClass2.invokeSuspend$lambda$0$safeResumeWithException(atomicBoolean2, cancellableContinuation, new UnableToDownloadException(message));
                                }
                            } else {
                                FileSystemDownloadTask.AnonymousClass2.invokeSuspend$lambda$0$safeResume(atomicBoolean2, cancellableContinuation, null);
                            }
                            Unit unit4 = Unit.INSTANCE;
                            CloseableKt.closeFinally(response2, null);
                        } catch (Throwable th12) {
                            try {
                                throw th12;
                            } catch (Throwable th13) {
                                CloseableKt.closeFinally(response2, th12);
                                throw th13;
                            }
                        }
                    }
                });
            }
            cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: expo.modules.filesystem.FileSystemDownloadTask$downloadToFile$2$1$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    if (fileSystemDownloadTask.isPausing) {
                        return;
                    }
                    fileSystemDownloadTask.cancel();
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(anonymousClass2);
            }
            return result == coroutine_suspended ? coroutine_suspended : result;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0$safeResume(AtomicBoolean atomicBoolean, CancellableContinuation<? super String> cancellableContinuation, String str) {
            if (atomicBoolean.compareAndSet(false, true)) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m12684constructorimpl(str));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0$safeResumeWithException(AtomicBoolean atomicBoolean, CancellableContinuation<? super String> cancellableContinuation, Exception exc) {
            if (atomicBoolean.compareAndSet(false, true)) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(exc)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadToFile(Request request, UnifiedFileInterface unifiedFileInterface, boolean z, long j, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(request, unifiedFileInterface, z, j, null), continuation);
    }

    private final void processDownloadResponse(Response resp, UnifiedFileInterface destination, boolean isResume, long offset, Function1<? super String, Unit> onComplete) throws UnableToDownloadException {
        if (!resp.isSuccessful()) {
            throw new UnableToDownloadException("HTTP " + resp.code());
        }
        ResponseBody responseBodyBody = resp.body();
        if (responseBodyBody == null) {
            throw new UnableToDownloadException("Empty response body");
        }
        boolean z = true;
        boolean z2 = resp.code() == 206;
        long j = (isResume && z2) ? offset : 0L;
        long jCalculateDownloadTotalBytes = FileSystemDownloadTaskKt.calculateDownloadTotalBytes(resp.code(), responseBodyBody.getContentLength(), j);
        prepareDestinationForWrite(destination, isResume && z2, j);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(responseBodyBody.byteStream());
        try {
            BufferedInputStream bufferedInputStream2 = bufferedInputStream;
            if (!isResume || !z2) {
                z = false;
            }
            OutputStream outputStream = destination.outputStream(z);
            try {
                OutputStream outputStream2 = outputStream;
                byte[] bArr = new byte[8192];
                Ref.IntRef intRef = new Ref.IntRef();
                this.bytesWritten = j;
                while (true) {
                    int i = bufferedInputStream2.read(bArr);
                    intRef.element = i;
                    if (i != -1) {
                        if (!this.isCancelling) {
                            if (this.isPausing) {
                                onComplete.invoke(null);
                                CloseableKt.closeFinally(outputStream, null);
                                CloseableKt.closeFinally(bufferedInputStream, null);
                                return;
                            } else {
                                outputStream2.write(bArr, 0, intRef.element);
                                j += (long) intRef.element;
                                this.bytesWritten = j;
                                emitProgress(j, jCalculateDownloadTotalBytes);
                            }
                        } else {
                            CloseableKt.closeFinally(outputStream, null);
                            CloseableKt.closeFinally(bufferedInputStream, null);
                            return;
                        }
                    } else {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(outputStream, null);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedInputStream, null);
                        this.lastProgressTime = 0L;
                        this.bytesWritten = destination.length();
                        emitProgress(this.bytesWritten, this.bytesWritten);
                        onComplete.invoke(destination.getUri().toString());
                        return;
                    }
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(outputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(bufferedInputStream, th3);
                throw th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void prepareDestinationForWrite(UnifiedFileInterface destination, boolean append, long offset) throws UnableToDownloadException {
        if (!(destination instanceof JavaFile)) {
            if (append && destination.length() != offset) {
                throw new UnableToDownloadException("Cannot resume download: destination length does not match resume data");
            }
            if (append) {
                return;
            }
            OutputStream outputStream = destination.outputStream(false);
            try {
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream, null);
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(outputStream, th);
                    throw th2;
                }
            }
        }
        UnifiedFileInterface parentFile = ((JavaFile) destination).getParentFile();
        if (parentFile != null && (parentFile instanceof JavaFile)) {
            ((JavaFile) parentFile).mkdirs();
        }
        if (append) {
            RandomAccessFile randomAccessFile = new RandomAccessFile((File) destination, "rw");
            try {
                randomAccessFile.setLength(offset);
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(randomAccessFile, null);
                return;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(randomAccessFile, th3);
                    throw th4;
                }
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream((File) destination, false);
        try {
            Unit unit3 = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(fileOutputStream, th5);
                throw th6;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitProgress(long bytesWritten, long totalBytes) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastProgressTime >= Duration.m14075getInWholeMillisecondsimpl(this.progressThrottleInterval) || bytesWritten == totalBytes) {
            this.lastProgressTime = jCurrentTimeMillis;
            emit("progress", MapsKt.mapOf(TuplesKt.to("bytesWritten", Long.valueOf(bytesWritten)), TuplesKt.to("totalBytes", Long.valueOf(totalBytes))));
        }
    }
}
