package expo.modules.medialibrary;

import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import expo.modules.medialibrary.contracts.DeleteContract;
import expo.modules.medialibrary.contracts.WriteContract;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MediaLibraryModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryModule$definition$1$22", f = "MediaLibraryModule.kt", i = {0, 1}, l = {287, 289}, m = "invokeSuspend", n = {"$this$RegisterActivityContracts", "$this$RegisterActivityContracts"}, s = {"L$0", "L$0"})
final class MediaLibraryModule$definition$1$22 extends SuspendLambda implements Function2<AppContextActivityResultCaller, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MediaLibraryModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaLibraryModule$definition$1$22(MediaLibraryModule mediaLibraryModule, Continuation<? super MediaLibraryModule$definition$1$22> continuation) {
        super(2, continuation);
        this.this$0 = mediaLibraryModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MediaLibraryModule$definition$1$22 mediaLibraryModule$definition$1$22 = new MediaLibraryModule$definition$1$22(this.this$0, continuation);
        mediaLibraryModule$definition$1$22.L$0 = obj;
        return mediaLibraryModule$definition$1$22;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AppContextActivityResultCaller appContextActivityResultCaller, Continuation<? super Unit> continuation) {
        return ((MediaLibraryModule$definition$1$22) create(appContextActivityResultCaller, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MediaLibraryModule mediaLibraryModule;
        MediaLibraryModule mediaLibraryModule2;
        AppContextActivityResultCaller appContextActivityResultCaller = (AppContextActivityResultCaller) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                mediaLibraryModule = (MediaLibraryModule) this.L$1;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mediaLibraryModule2 = (MediaLibraryModule) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            mediaLibraryModule2.writeLauncher = (AppContextActivityResultLauncher) obj;
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        MediaLibraryModule mediaLibraryModule3 = this.this$0;
        this.L$0 = appContextActivityResultCaller;
        this.L$1 = mediaLibraryModule3;
        this.label = 1;
        Object objRegisterForActivityResult$default = AppContextActivityResultCaller.registerForActivityResult$default(appContextActivityResultCaller, new DeleteContract(this.this$0), null, this, 2, null);
        if (objRegisterForActivityResult$default != coroutine_suspended) {
            mediaLibraryModule = mediaLibraryModule3;
            obj = objRegisterForActivityResult$default;
        }
        return coroutine_suspended;
        mediaLibraryModule.deleteLauncher = (AppContextActivityResultLauncher) obj;
        MediaLibraryModule mediaLibraryModule4 = this.this$0;
        this.L$0 = SpillingKt.nullOutSpilledVariable(appContextActivityResultCaller);
        this.L$1 = mediaLibraryModule4;
        this.label = 2;
        Object objRegisterForActivityResult$default2 = AppContextActivityResultCaller.registerForActivityResult$default(appContextActivityResultCaller, new WriteContract(this.this$0), null, this, 2, null);
        if (objRegisterForActivityResult$default2 != coroutine_suspended) {
            obj = objRegisterForActivityResult$default2;
            mediaLibraryModule2 = mediaLibraryModule4;
            mediaLibraryModule2.writeLauncher = (AppContextActivityResultLauncher) obj;
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
