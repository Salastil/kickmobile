package expo.modules.filesystem;

import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.notifications.serverregistration.InstallationId;
import java.net.URI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$9"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.filesystem.FileSystemModule$definition$lambda$87$$inlined$Coroutine$5", f = "FileSystemModule.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {271}, m = "invokeSuspend", n = {"<destruct>", "p0", "p1", "p2", "p3", "$completion", "downloadUUID", "options", "to", ImagesContract.URL, "$i$a$-Coroutine-FileSystemModule$definition$1$6"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0"})
public final class FileSystemModule$definition$lambda$87$$inlined$Coroutine$5 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ FileSystemModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$87$$inlined$Coroutine$5(Continuation continuation, FileSystemModule fileSystemModule) {
        super(3, continuation);
        this.this$0 = fileSystemModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        FileSystemModule$definition$lambda$87$$inlined$Coroutine$5 fileSystemModule$definition$lambda$87$$inlined$Coroutine$5 = new FileSystemModule$definition$lambda$87$$inlined$Coroutine$5(continuation, this.this$0);
        fileSystemModule$definition$lambda$87$$inlined$Coroutine$5.L$0 = objArr;
        return fileSystemModule$definition$lambda$87$$inlined$Coroutine$5.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object[] objArr = (Object[]) this.L$0;
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
        Object obj2 = objArr[0];
        Object obj3 = objArr[1];
        Object obj4 = objArr[2];
        Object obj5 = objArr[3];
        String str = (String) obj5;
        DownloadOptions downloadOptions = (DownloadOptions) obj4;
        FileSystemPath fileSystemPath = (FileSystemPath) obj3;
        URI uri = (URI) obj2;
        DownloadTaskStore downloadTaskStore = this.this$0.downloadStore;
        final FileSystemModule fileSystemModule = this.this$0;
        Function3<String, Long, Long, Unit> function3 = new Function3<String, Long, Long, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$1$6$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(String str2, Long l, Long l2) {
                invoke(str2, l.longValue(), l2.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(String uuid, long j, long j2) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                fileSystemModule.sendEvent("downloadProgress", MapsKt.mapOf(TuplesKt.to(InstallationId.LEGACY_PREFERENCES_UUID_KEY, uuid), TuplesKt.to("data", MapsKt.mapOf(TuplesKt.to("bytesWritten", Long.valueOf(j)), TuplesKt.to("totalBytes", Long.valueOf(j2))))));
            }
        };
        this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
        this.L$2 = SpillingKt.nullOutSpilledVariable(obj3);
        this.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
        this.L$4 = SpillingKt.nullOutSpilledVariable(obj5);
        this.L$5 = SpillingKt.nullOutSpilledVariable(this);
        this.L$6 = SpillingKt.nullOutSpilledVariable(str);
        this.L$7 = SpillingKt.nullOutSpilledVariable(downloadOptions);
        this.L$8 = SpillingKt.nullOutSpilledVariable(fileSystemPath);
        this.L$9 = SpillingKt.nullOutSpilledVariable(uri);
        this.I$0 = 0;
        this.label = 1;
        Object objDownloadFileWithStore = FileSystemDownloadKt.downloadFileWithStore(uri, fileSystemPath, downloadOptions, str, downloadTaskStore, function3, this);
        return objDownloadFileWithStore == coroutine_suspended ? coroutine_suspended : objDownloadFileWithStore;
    }
}
