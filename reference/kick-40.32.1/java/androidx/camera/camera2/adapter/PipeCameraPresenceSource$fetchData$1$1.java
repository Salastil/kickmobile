package androidx.camera.camera2.adapter;

import android.util.Log;
import androidx.camera.core.CameraIdentifier;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PipeCameraPresenceSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.adapter.PipeCameraPresenceSource$fetchData$1$1", f = "PipeCameraPresenceSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PipeCameraPresenceSource$fetchData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CallbackToFutureAdapter.Completer<List<CameraIdentifier>> $completer;
    int label;
    final /* synthetic */ PipeCameraPresenceSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PipeCameraPresenceSource$fetchData$1$1(PipeCameraPresenceSource pipeCameraPresenceSource, CallbackToFutureAdapter.Completer<List<CameraIdentifier>> completer, Continuation<? super PipeCameraPresenceSource$fetchData$1$1> continuation) {
        super(2, continuation);
        this.this$0 = pipeCameraPresenceSource;
        this.$completer = completer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PipeCameraPresenceSource$fetchData$1$1(this.this$0, this.$completer, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PipeCameraPresenceSource$fetchData$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                String[] cameraIdList = this.this$0.cameraManager.getCameraIdList();
                Intrinsics.checkNotNullExpressionValue(cameraIdList, "getCameraIdList(...)");
                ArrayList arrayList = new ArrayList();
                for (String str : cameraIdList) {
                    CameraIdentifier cameraIdentifierCreate$default = null;
                    try {
                        Intrinsics.checkNotNull(str);
                        cameraIdentifierCreate$default = CameraIdentifier.Factory.create$default(str, null, null, 6, null);
                    } catch (IllegalArgumentException e) {
                        Log.w("PipePresenceSrc", "Could not create CameraIdentifier for system ID: " + str, e);
                    }
                    if (cameraIdentifierCreate$default != null) {
                        arrayList.add(cameraIdentifierCreate$default);
                    }
                }
                ArrayList arrayList2 = arrayList;
                Log.d("PipePresenceSrc", "[FetchData] Refreshed camera list from hardware: " + arrayList2);
                this.this$0.updateData(arrayList2);
                this.$completer.set(arrayList2);
            } catch (Exception e2) {
                Exception exc = e2;
                Log.e("PipePresenceSrc", "[FetchData] Failed to refresh camera list from hardware.", exc);
                this.this$0.updateError(exc);
                this.$completer.setException(exc);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
