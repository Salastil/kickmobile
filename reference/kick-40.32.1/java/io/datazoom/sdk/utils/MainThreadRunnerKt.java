package io.datazoom.sdk.utils;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.facebook.hermes.intl.Constants;
import com.facebook.imagepipeline.common.RotationOptions;
import io.datazoom.sdk.logs.Logger_androidKt;
import io.datazoom.sdk.threading.SdkDispatcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainThreadRunner.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a7\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a3\u0010\b\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0010\b\u0004\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\t\u001a0\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086\bø\u0001\u0000\u001a4\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00012\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\r\u001a0\u0010\u000e\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0010\b\u0004\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006H\u0086H¢\u0006\u0002\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"safeOnMain", ExifInterface.GPS_DIRECTION_TRUE, "tag", "", Constants.COLLATION_DEFAULT, "block", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "safeOnMainOrNull", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runOnMainCatching", "Lio/datazoom/sdk/utils/MainThreadResult;", "withMainThread", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withMainThreadOrNull", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MainThreadRunnerKt {

    /* JADX INFO: renamed from: io.datazoom.sdk.utils.MainThreadRunnerKt$withMainThread$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainThreadRunner.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "io.datazoom.sdk.utils.MainThreadRunnerKt", f = "MainThreadRunner.kt", i = {0, 0, 0, 0}, l = {WebmConstants.MkvEbmlElement.SIMPLE_BLOCK}, m = "withMainThread", n = {"tag", Constants.COLLATION_DEFAULT, "block", "$i$f$withMainThread"}, nl = {WebmConstants.MkvEbmlElement.BLOCK_MORE}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class AnonymousClass1<T> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainThreadRunnerKt.withMainThread(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.datazoom.sdk.utils.MainThreadRunnerKt$withMainThreadOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainThreadRunner.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "io.datazoom.sdk.utils.MainThreadRunnerKt", f = "MainThreadRunner.kt", i = {0, 0, 0}, l = {RotationOptions.ROTATE_180}, m = "withMainThreadOrNull", n = {"tag", "block", "$i$f$withMainThreadOrNull"}, nl = {WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C09501<T> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09501(Continuation<? super C09501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainThreadRunnerKt.withMainThreadOrNull(null, null, this);
        }
    }

    public static final <T> T safeOnMain(String tag, T t, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            return (T) BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new MainThreadRunner.AnonymousClass1(block, null));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e(tag + " error: " + e.getMessage());
            return t;
        }
    }

    public static final <T> T safeOnMainOrNull(String tag, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        MainThreadRunner mainThreadRunner = MainThreadRunner.INSTANCE;
        try {
            return (T) BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new MainThreadRunner.C09491(block, null));
        } catch (Exception e) {
            Logger_androidKt.getLogger().e(tag + " error: " + e.getMessage());
            return null;
        }
    }

    public static final <T> MainThreadResult<T> runOnMainCatching(String tag, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return new MainThreadResult.Success(BuildersKt.runBlocking(SdkDispatcher.INSTANCE.getMain(), new MainThreadRunnerKt$runOnMainCatching$result$1(block, null)));
        } catch (Exception e) {
            return new MainThreadResult.Error(e, tag);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object withMainThread(String str, T t, Function0<? extends T> function0, Continuation<? super T> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$0;
                Object obj2 = anonymousClass1.L$1;
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher main = SdkDispatcher.INSTANCE.getMain();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(function0, null);
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = t;
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(function0);
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            Object objWithContext = BuildersKt.withContext(main, anonymousClass2, anonymousClass1);
            return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
        } catch (Exception e) {
            Logger_androidKt.getLogger().e(str + " error: " + e.getMessage());
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: io.datazoom.sdk.utils.MainThreadRunnerKt$withMainThread$2, reason: invalid class name */
    /* JADX INFO: compiled from: MainThreadRunner.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "io.datazoom.sdk.utils.MainThreadRunnerKt$withMainThread$2", f = "MainThreadRunner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function0<T> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function0<? extends T> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

    private static final <T> Object withMainThread$$forInline(String str, T t, Function0<? extends T> function0, Continuation<? super T> continuation) {
        try {
            return BuildersKt.withContext(SdkDispatcher.INSTANCE.getMain(), new AnonymousClass2(function0, null), continuation);
        } catch (Exception e) {
            Logger_androidKt.getLogger().e(str + " error: " + e.getMessage());
            return t;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T> Object withMainThreadOrNull(String str, Function0<? extends T> function0, Continuation<? super T> continuation) {
        C09501 c09501;
        if (continuation instanceof C09501) {
            c09501 = (C09501) continuation;
            if ((c09501.label & Integer.MIN_VALUE) != 0) {
                c09501.label -= Integer.MIN_VALUE;
            } else {
                c09501 = new C09501(continuation);
            }
        } else {
            c09501 = new C09501(continuation);
        }
        Object obj = c09501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09501.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c09501.I$0;
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher main = SdkDispatcher.INSTANCE.getMain();
            C09512 c09512 = new C09512(function0, null);
            c09501.L$0 = str;
            c09501.L$1 = SpillingKt.nullOutSpilledVariable(function0);
            c09501.I$0 = 0;
            c09501.label = 1;
            Object objWithContext = BuildersKt.withContext(main, c09512, c09501);
            return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
        } catch (Exception e) {
            Logger_androidKt.getLogger().e(str + " error: " + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: io.datazoom.sdk.utils.MainThreadRunnerKt$withMainThreadOrNull$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainThreadRunner.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    @DebugMetadata(c = "io.datazoom.sdk.utils.MainThreadRunnerKt$withMainThreadOrNull$2", f = "MainThreadRunner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class C09512<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function0<T> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C09512(Function0<? extends T> function0, Continuation<? super C09512> continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09512(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C09512) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

    private static final <T> Object withMainThreadOrNull$$forInline(String str, Function0<? extends T> function0, Continuation<? super T> continuation) {
        try {
            return BuildersKt.withContext(SdkDispatcher.INSTANCE.getMain(), new C09512(function0, null), continuation);
        } catch (Exception e) {
            Logger_androidKt.getLogger().e(str + " error: " + e.getMessage());
            return null;
        }
    }
}
