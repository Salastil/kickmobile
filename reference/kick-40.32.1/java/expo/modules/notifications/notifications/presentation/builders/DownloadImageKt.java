package expo.modules.notifications.notifications.presentation.builders;

import android.graphics.Bitmap;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: DownloadImage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"downloadImage", "Landroid/graphics/Bitmap;", "imageUrl", "Landroid/net/Uri;", "connectTimeout", "", "readTimeout", "(Landroid/net/Uri;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-notifications_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DownloadImageKt {

    /* JADX INFO: renamed from: expo.modules.notifications.notifications.presentation.builders.DownloadImageKt$downloadImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadImage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.notifications.notifications.presentation.builders.DownloadImageKt", f = "DownloadImage.kt", i = {0, 0, 0, 0}, l = {13}, m = "downloadImage", n = {"imageUrl", "connectTimeout", "readTimeout", "$i$a$-runCatching-DownloadImageKt$downloadImage$2"}, s = {"L$0", "J$0", "J$1", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadImageKt.downloadImage(null, 0L, 0L, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object downloadImage(Uri uri, long j, long j2, Continuation<? super Bitmap> continuation) {
        AnonymousClass1 anonymousClass1;
        Object objM12684constructorimpl;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objWithTimeout = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objWithTimeout);
                Result.Companion companion = Result.INSTANCE;
                DownloadImageKt$downloadImage$2$1 downloadImageKt$downloadImage$2$1 = new DownloadImageKt$downloadImage$2$1(uri, j, j2, null);
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(uri);
                anonymousClass2.J$0 = j;
                anonymousClass2.J$1 = j2;
                anonymousClass2.I$0 = 0;
                anonymousClass2.label = 1;
                objWithTimeout = TimeoutKt.withTimeout(j + j2, downloadImageKt$downloadImage$2$1, anonymousClass2);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass2.I$0;
                long j3 = anonymousClass2.J$1;
                long j4 = anonymousClass2.J$0;
                ResultKt.throwOnFailure(objWithTimeout);
            }
            objM12684constructorimpl = Result.m12684constructorimpl((Bitmap) objWithTimeout);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            return null;
        }
        return objM12684constructorimpl;
    }

    public static /* synthetic */ Object downloadImage$default(Uri uri, long j, long j2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 8000;
        }
        if ((i & 4) != 0) {
            j2 = 8000;
        }
        return downloadImage(uri, j, j2, continuation);
    }
}
