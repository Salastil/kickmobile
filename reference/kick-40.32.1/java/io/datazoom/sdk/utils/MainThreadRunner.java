package io.datazoom.sdk.utils;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.threading.SdkDispatcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainThreadRunner.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u00052\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\nH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000bJ5\u0010\f\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0004\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\nH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"Lio/datazoom/sdk/utils/MainThreadRunner;", "", "<init>", "()V", "runOnMain", ExifInterface.GPS_DIRECTION_TRUE, "tag", "", Constants.COLLATION_DEFAULT, "block", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runOnMainOrNull", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MainThreadRunner {
    public static final MainThreadRunner INSTANCE = new MainThreadRunner();

    private MainThreadRunner() {
    }

    public static /* synthetic */ Object runOnMain$default(MainThreadRunner mainThreadRunner, String tag, Object obj, Function0 block, int i, Object obj2) {
        if ((i & 1) != 0) {
            tag = "MainThreadRunner";
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new AnonymousClass1(block, null));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e(tag + " error: " + e.getMessage());
            return obj;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: io.datazoom.sdk.utils.MainThreadRunner$runOnMain$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainThreadRunner.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "io.datazoom.sdk.utils.MainThreadRunner$runOnMain$1", f = "MainThreadRunner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class AnonymousClass1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function0<T> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function0<? extends T> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return this.$block.invoke();
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            return this.$block.invoke();
        }
    }

    public final <T> T runOnMain(String tag, T t, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return (T) BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new AnonymousClass1(block, null));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e(tag + " error: " + e.getMessage());
            return t;
        }
    }

    public static /* synthetic */ Object runOnMainOrNull$default(MainThreadRunner mainThreadRunner, String tag, Function0 block, int i, Object obj) {
        if ((i & 1) != 0) {
            tag = "MainThreadRunner";
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new C09491(block, null));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e(tag + " error: " + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: io.datazoom.sdk.utils.MainThreadRunner$runOnMainOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainThreadRunner.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "io.datazoom.sdk.utils.MainThreadRunner$runOnMainOrNull$1", f = "MainThreadRunner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class C09491<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function0<T> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C09491(Function0<? extends T> function0, Continuation<? super C09491> continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09491(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C09491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return this.$block.invoke();
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            return this.$block.invoke();
        }
    }

    public final <T> T runOnMainOrNull(String tag, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return (T) BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new C09491(block, null));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e(tag + " error: " + e.getMessage());
            return null;
        }
    }
}
