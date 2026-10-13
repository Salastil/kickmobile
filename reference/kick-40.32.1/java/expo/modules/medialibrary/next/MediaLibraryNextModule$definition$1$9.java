package expo.modules.medialibrary.next;

import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MediaLibraryNextModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.MediaLibraryNextModule$definition$1$9", f = "MediaLibraryNextModule.kt", i = {0, 0, 0}, l = {336}, m = "invokeSuspend", n = {"$this$RegisterActivityContracts", "$this$invokeSuspend_u24lambda_u240", "$i$a$-with-MediaLibraryNextModule$definition$1$9$1"}, s = {"L$0", "L$1", "I$0"})
final class MediaLibraryNextModule$definition$1$9 extends SuspendLambda implements Function2<AppContextActivityResultCaller, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MediaLibraryNextModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaLibraryNextModule$definition$1$9(MediaLibraryNextModule mediaLibraryNextModule, Continuation<? super MediaLibraryNextModule$definition$1$9> continuation) {
        super(2, continuation);
        this.this$0 = mediaLibraryNextModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MediaLibraryNextModule$definition$1$9 mediaLibraryNextModule$definition$1$9 = new MediaLibraryNextModule$definition$1$9(this.this$0, continuation);
        mediaLibraryNextModule$definition$1$9.L$0 = obj;
        return mediaLibraryNextModule$definition$1$9;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AppContextActivityResultCaller appContextActivityResultCaller, Continuation<? super Unit> continuation) {
        return ((MediaLibraryNextModule$definition$1$9) create(appContextActivityResultCaller, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AppContextActivityResultCaller appContextActivityResultCaller = (AppContextActivityResultCaller) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MediaStorePermissionsDelegate mediaStorePermissionsDelegate = this.this$0.getMediaStorePermissionsDelegate();
            MediaLibraryNextModule mediaLibraryNextModule = this.this$0;
            this.L$0 = SpillingKt.nullOutSpilledVariable(appContextActivityResultCaller);
            this.L$1 = SpillingKt.nullOutSpilledVariable(mediaStorePermissionsDelegate);
            this.I$0 = 0;
            this.label = 1;
            if (mediaStorePermissionsDelegate.registerMediaStoreContracts(appContextActivityResultCaller, mediaLibraryNextModule, this) == coroutine_suspended) {
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
