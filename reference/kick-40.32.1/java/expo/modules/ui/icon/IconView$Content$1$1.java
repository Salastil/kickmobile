package expo.modules.ui.icon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.vector.ImageVector;
import expo.modules.ui.graphics.ImageLoader;
import expo.modules.ui.graphics.ImageSource;
import expo.modules.ui.graphics.ImageSourceKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IconView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.ui.icon.IconView$Content$1$1", f = "IconView.kt", i = {0}, l = {73}, m = "invokeSuspend", n = {"uriString"}, s = {"L$0"})
final class IconView$Content$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Drawable> $drawable$delegate;
    final /* synthetic */ MutableState<ImageVector> $imageVector$delegate;
    final /* synthetic */ ImageSource $source;
    Object L$0;
    int label;
    final /* synthetic */ IconView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IconView$Content$1$1(ImageSource imageSource, IconView iconView, MutableState<ImageVector> mutableState, MutableState<Drawable> mutableState2, Continuation<? super IconView$Content$1$1> continuation) {
        super(2, continuation);
        this.$source = imageSource;
        this.this$0 = iconView;
        this.$imageVector$delegate = mutableState;
        this.$drawable$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IconView$Content$1$1(this.$source, this.this$0, this.$imageVector$delegate, this.$drawable$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IconView$Content$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String strResolveUri = null;
            this.$imageVector$delegate.setValue(null);
            this.$drawable$delegate.setValue(null);
            ImageSource imageSource = this.$source;
            if (imageSource != null) {
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                strResolveUri = ImageSourceKt.resolveUri(imageSource, context);
            }
            if (strResolveUri != null) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(strResolveUri);
                this.label = 1;
                obj = this.this$0.getIconLoader().loadFromUri(strResolveUri, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ImageLoader.ImageResult imageResult = (ImageLoader.ImageResult) obj;
        this.$imageVector$delegate.setValue(imageResult.getImageVector());
        this.$drawable$delegate.setValue(imageResult.getDrawable());
        return Unit.INSTANCE;
    }
}
