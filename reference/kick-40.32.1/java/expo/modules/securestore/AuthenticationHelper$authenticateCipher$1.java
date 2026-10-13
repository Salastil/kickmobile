package expo.modules.securestore;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AuthenticationHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.securestore.AuthenticationHelper", f = "AuthenticationHelper.kt", i = {0, 0}, l = {24}, m = "authenticateCipher$expo_secure_store_release", n = {"cipher", "options"}, s = {"L$0", "L$1"})
final class AuthenticationHelper$authenticateCipher$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthenticationHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthenticationHelper$authenticateCipher$1(AuthenticationHelper authenticationHelper, Continuation<? super AuthenticationHelper$authenticateCipher$1> continuation) {
        super(continuation);
        this.this$0 = authenticationHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.authenticateCipher$expo_secure_store_release(null, null, this);
    }
}
