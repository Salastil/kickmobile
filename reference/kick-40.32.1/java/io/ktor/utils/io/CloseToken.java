package io.ktor.utils.io;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

/* JADX INFO: compiled from: CloseToken.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/utils/io/CloseToken;", "", "", "origin", "<init>", "(Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "wrap", "wrapCause", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Throwable;", "", "throwOrNull", "(Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "Ljava/lang/Throwable;", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CloseToken {
    private final Throwable origin;

    public CloseToken(Throwable th) {
        this.origin = th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: io.ktor.utils.io.CloseToken$wrapCause$1, reason: invalid class name */
    /* JADX INFO: compiled from: CloseToken.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Throwable, ClosedByteChannelException> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, ClosedByteChannelException.class, "<init>", "<init>(Ljava/lang/Throwable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ClosedByteChannelException invoke(Throwable th) {
            return new ClosedByteChannelException(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Throwable wrapCause$default(CloseToken closeToken, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        return closeToken.wrapCause(function1);
    }

    public final Throwable wrapCause(Function1<? super Throwable, ? extends Throwable> wrap) {
        Intrinsics.checkNotNullParameter(wrap, "wrap");
        Object obj = this.origin;
        if (obj == null) {
            return null;
        }
        if (obj instanceof CopyableThrowable) {
            return ((CopyableThrowable) obj).createCopy();
        }
        return obj instanceof CancellationException ? kotlinx.coroutines.ExceptionsKt.CancellationException(((CancellationException) obj).getMessage(), this.origin) : wrap.invoke(obj);
    }

    public final Unit throwOrNull(Function1<? super Throwable, ? extends Throwable> wrap) throws Throwable {
        Intrinsics.checkNotNullParameter(wrap, "wrap");
        Throwable thWrapCause = wrapCause(wrap);
        if (thWrapCause == null) {
            return null;
        }
        throw thWrapCause;
    }
}
