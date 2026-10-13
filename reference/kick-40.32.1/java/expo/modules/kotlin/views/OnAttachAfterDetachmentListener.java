package expo.modules.kotlin.views;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnAttachAfterDetachmentListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/views/OnAttachAfterDetachmentListener;", "Landroid/view/View$OnAttachStateChangeListener;", "onAttachAfterDetachment", "Lkotlin/Function0;", "", "post", "Lkotlin/Function1;", "Ljava/lang/Runnable;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "shouldRunOnAttach", "", "detachGeneration", "", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OnAttachAfterDetachmentListener implements View.OnAttachStateChangeListener {
    public static final int $stable = 8;
    private int detachGeneration;
    private final Function0<Unit> onAttachAfterDetachment;
    private final Function1<Runnable, Unit> post;
    private boolean shouldRunOnAttach;

    /* JADX WARN: Multi-variable type inference failed */
    public OnAttachAfterDetachmentListener(Function0<Unit> onAttachAfterDetachment, Function1<? super Runnable, Unit> post) {
        Intrinsics.checkNotNullParameter(onAttachAfterDetachment, "onAttachAfterDetachment");
        Intrinsics.checkNotNullParameter(post, "post");
        this.onAttachAfterDetachment = onAttachAfterDetachment;
        this.post = post;
    }

    public /* synthetic */ OnAttachAfterDetachmentListener(Function0 function0, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? new Function1() { // from class: expo.modules.kotlin.views.OnAttachAfterDetachmentListener$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OnAttachAfterDetachmentListener._init_$lambda$0((Runnable) obj);
            }
        } : function1);
    }

    static final Unit _init_$lambda$0(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        new Handler(Looper.getMainLooper()).post(runnable);
        return Unit.INSTANCE;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.detachGeneration++;
        if (this.shouldRunOnAttach) {
            this.shouldRunOnAttach = false;
            this.onAttachAfterDetachment.invoke();
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(final View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        final int i = this.detachGeneration + 1;
        this.detachGeneration = i;
        this.post.invoke(new Runnable() { // from class: expo.modules.kotlin.views.OnAttachAfterDetachmentListener$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                OnAttachAfterDetachmentListener.onViewDetachedFromWindow$lambda$0(this.f$0, i, v);
            }
        });
    }

    static final void onViewDetachedFromWindow$lambda$0(OnAttachAfterDetachmentListener onAttachAfterDetachmentListener, int i, View view) {
        if (onAttachAfterDetachmentListener.detachGeneration != i || view.isAttachedToWindow()) {
            return;
        }
        onAttachAfterDetachmentListener.shouldRunOnAttach = true;
    }
}
