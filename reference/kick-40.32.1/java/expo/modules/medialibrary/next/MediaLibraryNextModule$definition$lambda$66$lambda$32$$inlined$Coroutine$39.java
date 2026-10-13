package expo.modules.medialibrary.next;

import expo.modules.medialibrary.next.objects.asset.Asset;
import expo.modules.medialibrary.next.objects.asset.deleters.AssetDeleter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$3"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$39", f = "MediaLibraryNextModule.kt", i = {0, 0, 0, 0, 0}, l = {271}, m = "invokeSuspend", n = {"<destruct>", "p0", "$completion", "assets", "$i$a$-Coroutine-MediaLibraryNextModule$definition$1$3$20"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
public final class MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$39 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MediaLibraryNextModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$39(Continuation continuation, MediaLibraryNextModule mediaLibraryNextModule) {
        super(3, continuation);
        this.this$0 = mediaLibraryNextModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$39 mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$39 = new MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$39(continuation, this.this$0);
        mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$39.L$0 = objArr;
        return mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$39.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object[] objArr = (Object[]) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = objArr[0];
            MediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$39 mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$39 = this;
            List list = (List) obj2;
            AssetDeleter assetDeleter = this.this$0.getAssetDeleter();
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((Asset) it.next()).getContentUri());
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(objArr);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(mediaLibraryNextModule$definition$lambda$66$lambda$32$$inlined$Coroutine$39);
            this.L$3 = SpillingKt.nullOutSpilledVariable(list);
            this.I$0 = 0;
            this.label = 1;
            if (assetDeleter.delete(arrayList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
