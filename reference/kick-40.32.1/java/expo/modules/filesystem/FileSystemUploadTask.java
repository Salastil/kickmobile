package expo.modules.filesystem;

import androidx.core.app.NotificationCompat;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: FileSystemUploadTask.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006%"}, d2 = {"Lexpo/modules/filesystem/FileSystemUploadTask;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "<init>", "()V", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "cancelled", "", "lastProgressTime", "", "progressThrottleInterval", "Lkotlin/time/Duration;", "J", ViewProps.START, "Lexpo/modules/filesystem/UploadTaskResult;", ImagesContract.URL, "", "file", "Lexpo/modules/filesystem/FileSystemFile;", "options", "Lexpo/modules/filesystem/UploadTaskOptions;", "(Ljava/lang/String;Lexpo/modules/filesystem/FileSystemFile;Lexpo/modules/filesystem/UploadTaskOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildUploadRequest", "Lokhttp3/Request;", "executeUploadRequest", "request", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "sharedObjectDidRelease", "createBinaryBody", "Lokhttp3/RequestBody;", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "emitProgress", "bytesWritten", "totalBytes", "Companion", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileSystemUploadTask extends SharedObject {
    private static final OkHttpClient client = OkHttpClientProvider.createClientBuilder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
    private Call call;
    private volatile boolean cancelled;
    private long lastProgressTime;
    private final long progressThrottleInterval;

    /* JADX INFO: compiled from: FileSystemUploadTask.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UploadType.values().length];
            try {
                iArr[UploadType.MULTIPART.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UploadType.BINARY_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FileSystemUploadTask() {
        super(null, 1, null);
        Duration.Companion companion = Duration.INSTANCE;
        this.progressThrottleInterval = DurationKt.toDuration(100, DurationUnit.MILLISECONDS);
    }

    public final Object start(String str, FileSystemFile fileSystemFile, UploadTaskOptions uploadTaskOptions, Continuation<? super UploadTaskResult> continuation) {
        fileSystemFile.validatePermission(FilePermissionService.Permission.READ);
        this.cancelled = false;
        return executeUploadRequest(buildUploadRequest(str, fileSystemFile, uploadTaskOptions), continuation);
    }

    private final Request buildUploadRequest(String url, FileSystemFile file, UploadTaskOptions options) throws UnableToUploadException {
        CountingRequestBody countingRequestBody;
        UnifiedFileInterface file2 = file.getFile();
        if (!file2.exists()) {
            throw new UnableToUploadException("File does not exist");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[options.getUploadType().ordinal()];
        if (i == 1) {
            countingRequestBody = new CountingRequestBody(FileSystemUploadTaskKt.createMultipartRequestBody(file2, options), new Function2() { // from class: expo.modules.filesystem.FileSystemUploadTask$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileSystemUploadTask.buildUploadRequest$lambda$0(this.f$0, ((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            });
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            countingRequestBody = createBinaryBody(file2);
        }
        Request.Builder builderUrl = new Request.Builder().url(url);
        Map<String, String> headers = options.getHeaders();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builderUrl.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return builderUrl.method(options.getHttpMethod(), countingRequestBody).build();
    }

    static final Unit buildUploadRequest$lambda$0(FileSystemUploadTask fileSystemUploadTask, long j, long j2) {
        fileSystemUploadTask.emitProgress(j, j2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeUploadRequest$lambda$2$safeResume(AtomicBoolean atomicBoolean, CancellableContinuation<? super UploadTaskResult> cancellableContinuation, UploadTaskResult uploadTaskResult) {
        if (atomicBoolean.compareAndSet(false, true)) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m12684constructorimpl(uploadTaskResult));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeUploadRequest$lambda$2$safeResumeWithException(AtomicBoolean atomicBoolean, CancellableContinuation<? super UploadTaskResult> cancellableContinuation, Exception exc) {
        if (atomicBoolean.compareAndSet(false, true)) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m12684constructorimpl(ResultKt.createFailure(exc)));
        }
    }

    public final void cancel() {
        this.cancelled = true;
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void sharedObjectDidRelease() {
        cancel();
    }

    private final RequestBody createBinaryBody(UnifiedFileInterface file) {
        return new CountingRequestBody(FileSystemUploadTaskKt.asRequestBody(file, null), new Function2() { // from class: expo.modules.filesystem.FileSystemUploadTask$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FileSystemUploadTask.createBinaryBody$lambda$3(this.f$0, ((Long) obj).longValue(), ((Long) obj2).longValue());
            }
        });
    }

    static final Unit createBinaryBody$lambda$3(FileSystemUploadTask fileSystemUploadTask, long j, long j2) {
        fileSystemUploadTask.emitProgress(j, j2);
        return Unit.INSTANCE;
    }

    private final void emitProgress(long bytesWritten, long totalBytes) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastProgressTime >= Duration.m14075getInWholeMillisecondsimpl(this.progressThrottleInterval) || bytesWritten == totalBytes) {
            this.lastProgressTime = jCurrentTimeMillis;
            emit("progress", MapsKt.mapOf(TuplesKt.to("bytesSent", Long.valueOf(bytesWritten)), TuplesKt.to("totalBytes", Long.valueOf(totalBytes))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeUploadRequest(Request request, Continuation<? super UploadTaskResult> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.call = client.newCall(request);
        Call call = this.call;
        if (call != null) {
            call.enqueue(new Callback() { // from class: expo.modules.filesystem.FileSystemUploadTask$executeUploadRequest$2$1
                @Override // okhttp3.Callback
                public void onFailure(Call call2, IOException e) {
                    Intrinsics.checkNotNullParameter(call2, "call");
                    Intrinsics.checkNotNullParameter(e, "e");
                    boolean z = this.this$0.cancelled;
                    AtomicBoolean atomicBoolean2 = atomicBoolean;
                    if (z) {
                        FileSystemUploadTask.executeUploadRequest$lambda$2$safeResumeWithException(atomicBoolean2, cancellableContinuationImpl2, new UploadCancelledException());
                        return;
                    }
                    CancellableContinuation<UploadTaskResult> cancellableContinuation = cancellableContinuationImpl2;
                    String message = e.getMessage();
                    if (message == null) {
                        message = "Upload failed";
                    }
                    FileSystemUploadTask.executeUploadRequest$lambda$2$safeResumeWithException(atomicBoolean2, cancellableContinuation, new UnableToUploadException(message));
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call2, Response response) {
                    String strString;
                    Intrinsics.checkNotNullParameter(call2, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        ResponseBody responseBodyBody = response.body();
                        if (responseBodyBody == null || (strString = responseBodyBody.string()) == null) {
                            strString = "";
                        }
                        Map<String, List<String>> multimap = response.headers().toMultimap();
                        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(multimap.size()));
                        for (Object obj : multimap.entrySet()) {
                            Object key = ((Map.Entry) obj).getKey();
                            String str = (String) CollectionsKt.firstOrNull((List) ((Map.Entry) obj).getValue());
                            if (str == null) {
                                str = "";
                            }
                            linkedHashMap.put(key, str);
                        }
                        UploadTaskResult uploadTaskResult = new UploadTaskResult();
                        uploadTaskResult.setBody(strString);
                        uploadTaskResult.setStatus(response.code());
                        uploadTaskResult.setHeaders(linkedHashMap);
                        FileSystemUploadTask.executeUploadRequest$lambda$2$safeResume(atomicBoolean, cancellableContinuationImpl2, uploadTaskResult);
                    } catch (Exception e) {
                        AtomicBoolean atomicBoolean2 = atomicBoolean;
                        CancellableContinuation<UploadTaskResult> cancellableContinuation = cancellableContinuationImpl2;
                        String message = e.getMessage();
                        if (message == null) {
                            message = "Failed to read response";
                        }
                        FileSystemUploadTask.executeUploadRequest$lambda$2$safeResumeWithException(atomicBoolean2, cancellableContinuation, new UnableToUploadException(message));
                    }
                }
            });
        }
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: expo.modules.filesystem.FileSystemUploadTask$executeUploadRequest$2$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                this.this$0.cancel();
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
