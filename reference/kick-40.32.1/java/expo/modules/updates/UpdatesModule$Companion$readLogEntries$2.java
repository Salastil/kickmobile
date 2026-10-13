package expo.modules.updates;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.updates.logging.UpdatesLogEntry;
import expo.modules.updates.logging.UpdatesLogReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UpdatesModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.updates.UpdatesModule$Companion$readLogEntries$2", f = "UpdatesModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class UpdatesModule$Companion$readLogEntries$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Bundle>>, Object> {
    final /* synthetic */ File $filesDirectory;
    final /* synthetic */ long $maxAge;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UpdatesModule$Companion$readLogEntries$2(File file, long j, Continuation<? super UpdatesModule$Companion$readLogEntries$2> continuation) {
        super(2, continuation);
        this.$filesDirectory = file;
        this.$maxAge = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdatesModule$Companion$readLogEntries$2(this.$filesDirectory, this.$maxAge, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Bundle>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<Bundle>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Bundle>> continuation) {
        return ((UpdatesModule$Companion$readLogEntries$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<String> logEntries = new UpdatesLogReader(this.$filesDirectory).getLogEntries(new Date(new Date().getTime() - this.$maxAge));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = logEntries.iterator();
        while (it.hasNext()) {
            UpdatesLogEntry updatesLogEntryCreate = UpdatesLogEntry.INSTANCE.create((String) it.next());
            if (updatesLogEntryCreate != null) {
                arrayList.add(updatesLogEntryCreate);
            }
        }
        ArrayList<UpdatesLogEntry> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (UpdatesLogEntry updatesLogEntry : arrayList2) {
            Bundle bundle = new Bundle();
            bundle.putLong("timestamp", updatesLogEntry.getTimestamp());
            bundle.putString("message", updatesLogEntry.getMessage());
            bundle.putString("code", updatesLogEntry.getCode());
            bundle.putString(FirebaseAnalytics.Param.LEVEL, updatesLogEntry.getLevel());
            if (updatesLogEntry.getUpdateId() != null) {
                bundle.putString("updateId", updatesLogEntry.getUpdateId());
            }
            if (updatesLogEntry.getAssetId() != null) {
                bundle.putString("assetId", updatesLogEntry.getAssetId());
            }
            if (updatesLogEntry.getStacktrace() != null) {
                bundle.putStringArray("stacktrace", (String[]) updatesLogEntry.getStacktrace().toArray(new String[0]));
            }
            arrayList3.add(bundle);
        }
        return arrayList3;
    }
}
