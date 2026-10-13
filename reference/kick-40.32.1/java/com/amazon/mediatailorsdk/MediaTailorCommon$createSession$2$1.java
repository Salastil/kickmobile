package com.amazon.mediatailorsdk;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: MediaTailor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.amazon.mediatailorsdk.MediaTailorCommon$createSession$2$1", f = "MediaTailor.kt", i = {}, l = {EACTags.DISPLAY_IMAGE}, m = "invokeSuspend", n = {}, nl = {70}, s = {}, v = 2)
final class MediaTailorCommon$createSession$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionConfiguration $config;
    final /* synthetic */ String $nonce;
    final /* synthetic */ PalNonceManagerWrapper $nonceManager;
    final /* synthetic */ Function2<Integer, String, Job> $reportError;
    final /* synthetic */ Function2<Session, String, Job> $reportSuccess;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MediaTailorCommon$createSession$2$1(SessionConfiguration sessionConfiguration, String str, PalNonceManagerWrapper palNonceManagerWrapper, Function2<? super Session, ? super String, ? extends Job> function2, Function2<? super Integer, ? super String, ? extends Job> function3, Continuation<? super MediaTailorCommon$createSession$2$1> continuation) {
        super(2, continuation);
        this.$config = sessionConfiguration;
        this.$nonce = str;
        this.$nonceManager = palNonceManagerWrapper;
        this.$reportSuccess = function2;
        this.$reportError = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaTailorCommon$createSession$2$1(this.$config, this.$nonce, this.$nonceManager, this.$reportSuccess, this.$reportError, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaTailorCommon$createSession$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (SessionKt.initSession(this.$config, this.$nonce, this.$nonceManager, this.$reportSuccess, this.$reportError, this) == coroutine_suspended) {
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
