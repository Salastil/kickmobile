package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import expo.modules.imagemanipulator.transformers.ImageTransformer;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: ImageManipulatorContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lexpo/modules/imagemanipulator/ManipulatorTask;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "loader", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Landroid/graphics/Bitmap;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "task", "Lkotlinx/coroutines/Deferred;", "Lexpo/modules/imagemanipulator/ManipulatorResult;", "launchLoader", "addTransformer", "", "transformer", "Lexpo/modules/imagemanipulator/transformers/ImageTransformer;", "render", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "cancel", "expo-image-manipulator_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ManipulatorTask {
    private final CoroutineScope coroutineScope;
    private final Function1<Continuation<? super Bitmap>, Object> loader;
    private Deferred<ManipulatorResult> task;

    /* JADX INFO: renamed from: expo.modules.imagemanipulator.ManipulatorTask$render$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ImageManipulatorContext.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagemanipulator.ManipulatorTask", f = "ImageManipulatorContext.kt", i = {}, l = {65}, m = "render", n = {}, s = {})
    static final class C08211 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08211(Continuation<? super C08211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ManipulatorTask.this.render(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ManipulatorTask(CoroutineScope coroutineScope, Function1<? super Continuation<? super Bitmap>, ? extends Object> loader) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(loader, "loader");
        this.coroutineScope = coroutineScope;
        this.loader = loader;
        this.task = launchLoader();
    }

    /* JADX INFO: renamed from: expo.modules.imagemanipulator.ManipulatorTask$launchLoader$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ImageManipulatorContext.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lexpo/modules/imagemanipulator/ManipulatorResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagemanipulator.ManipulatorTask$launchLoader$1", f = "ImageManipulatorContext.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    static final class C08201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ManipulatorResult>, Object> {
        int label;

        C08201(Continuation<? super C08201> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ManipulatorTask.this.new C08201(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ManipulatorResult> continuation) {
            return ((C08201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UnexpectedException unexpectedException;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = ManipulatorTask.this.loader;
                    this.label = 1;
                    obj = function1.invoke(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return new ManipulatorResult((Bitmap) obj, null);
            } catch (Throwable th) {
                if (th instanceof CodedException) {
                    unexpectedException = (CodedException) th;
                } else if (th instanceof expo.modules.core.errors.CodedException) {
                    expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                    unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
                } else {
                    unexpectedException = new UnexpectedException(th);
                }
                return new ManipulatorResult(null, unexpectedException);
            }
        }
    }

    private final Deferred<ManipulatorResult> launchLoader() {
        return BuildersKt__Builders_commonKt.async$default(this.coroutineScope, null, null, new C08201(null), 3, null);
    }

    /* JADX INFO: renamed from: expo.modules.imagemanipulator.ManipulatorTask$addTransformer$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImageManipulatorContext.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lexpo/modules/imagemanipulator/ManipulatorResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagemanipulator.ManipulatorTask$addTransformer$1", f = "ImageManipulatorContext.kt", i = {}, l = {EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ManipulatorResult>, Object> {
        final /* synthetic */ Deferred<ManipulatorResult> $oldTask;
        final /* synthetic */ ImageTransformer $transformer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Deferred<ManipulatorResult> deferred, ImageTransformer imageTransformer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$oldTask = deferred;
            this.$transformer = imageTransformer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$oldTask, this.$transformer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ManipulatorResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.$oldTask.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((ManipulatorResult) obj).map(this.$transformer);
        }
    }

    public final void addTransformer(ImageTransformer transformer) {
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        this.task = BuildersKt__Builders_commonKt.async$default(this.coroutineScope, null, null, new AnonymousClass1(this.task, transformer, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object render(Continuation<? super Bitmap> continuation) {
        C08211 c08211;
        if (continuation instanceof C08211) {
            c08211 = (C08211) continuation;
            if ((c08211.label & Integer.MIN_VALUE) != 0) {
                c08211.label -= Integer.MIN_VALUE;
            } else {
                c08211 = new C08211(continuation);
            }
        } else {
            c08211 = new C08211(continuation);
        }
        Object objAwait = c08211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08211.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            Deferred<ManipulatorResult> deferred = this.task;
            c08211.label = 1;
            objAwait = deferred.await(c08211);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwait);
        }
        return ((ManipulatorResult) objAwait).get();
    }

    public final void reset() {
        Job.DefaultImpls.cancel$default((Job) this.task, (CancellationException) null, 1, (Object) null);
        this.task = launchLoader();
    }

    public final void cancel() {
        Job.DefaultImpls.cancel$default((Job) this.task, (CancellationException) null, 1, (Object) null);
    }
}
