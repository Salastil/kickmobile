package androidx.compose.foundation.text.selection;

import android.os.Build;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import androidx.compose.material3.internal.Listener$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.media3.muxer.WebmConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: PlatformSelectionBehaviors.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextRange;", "Landroid/view/textclassifier/TextClassifier;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2", f = "PlatformSelectionBehaviors.android.kt", i = {0, 0, 0, 1}, l = {369, WebmConstants.MkvEbmlElement.CHANNELS}, m = "invokeSuspend", n = {"suggestedSelection", "$this$withLock_u24default$iv", "newSelection", "newSelection"}, s = {"L$0", "L$1", "J$0", "J$0"}, v = 1)
final class PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 extends SuspendLambda implements Function2<TextClassifier, Continuation<? super TextRange>, Object> {
    final /* synthetic */ long $selection;
    final /* synthetic */ CharSequence $text;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(CharSequence charSequence, long j, PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, Continuation<? super PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2> continuation) {
        super(2, continuation);
        this.$text = charSequence;
        this.$selection = j;
        this.this$0 = platformSelectionBehaviorsImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 = new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(this.$text, this.$selection, this.this$0, continuation);
        platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2.L$0 = obj;
        return platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(TextClassifier textClassifier, Continuation<? super TextRange> continuation) {
        return ((PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2) create(textClassifier, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(TextClassifier textClassifier, Continuation<? super TextRange> continuation) {
        return invoke2(Listener$$ExternalSyntheticApiModelOutline0.m5398m((Object) textClassifier), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl;
        CharSequence charSequence;
        TextSelection textSelectionM5400m;
        Mutex mutex;
        long j2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TextClassifier textClassifierM5398m = Listener$$ExternalSyntheticApiModelOutline0.m5398m(this.L$0);
            Listener$$ExternalSyntheticApiModelOutline0.m5409m$1();
            TextSelection.Request.Builder defaultLocales = Listener$$ExternalSyntheticApiModelOutline0.m5399m(this.$text, TextRange.m9596getMinimpl(this.$selection), TextRange.m9595getMaximpl(this.$selection)).setDefaultLocales(this.this$0.getAndroidLocalList());
            if (Build.VERSION.SDK_INT >= 31) {
                defaultLocales.setIncludeTextClassification(true);
            }
            TextSelection textSelectionSuggestSelection = textClassifierM5398m.suggestSelection(defaultLocales.build());
            long jTextRange = TextRangeKt.TextRange(textSelectionSuggestSelection.getSelectionStartIndex(), textSelectionSuggestSelection.getSelectionEndIndex());
            if (Build.VERSION.SDK_INT < 31 || textSelectionSuggestSelection.getTextClassification() == null) {
                this.J$0 = jTextRange;
                this.label = 2;
                if (this.this$0.m3339classifyTextM8tDOmk(this.$text, jTextRange, textClassifierM5398m, this) != coroutine_suspended) {
                    j = jTextRange;
                    j2 = j;
                }
            } else {
                Mutex mutex2 = this.this$0.mutex;
                platformSelectionBehaviorsImpl = this.this$0;
                charSequence = this.$text;
                this.L$0 = textSelectionSuggestSelection;
                this.L$1 = mutex2;
                this.L$2 = platformSelectionBehaviorsImpl;
                this.L$3 = charSequence;
                this.J$0 = jTextRange;
                this.label = 1;
                if (mutex2.lock(null, this) != coroutine_suspended) {
                    textSelectionM5400m = textSelectionSuggestSelection;
                    mutex = mutex2;
                    j2 = jTextRange;
                    CharSequence charSequence2 = charSequence;
                    TextClassification textClassification = textSelectionM5400m.getTextClassification();
                    Intrinsics.checkNotNull(textClassification);
                    platformSelectionBehaviorsImpl.setTextClassificationResult(new TextClassificationResult(charSequence2, j2, textClassification, null));
                    Unit unit = Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            long j3 = this.J$0;
            charSequence = (CharSequence) this.L$3;
            PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl2 = (PlatformSelectionBehaviorsImpl) this.L$2;
            Mutex mutex3 = (Mutex) this.L$1;
            textSelectionM5400m = Listener$$ExternalSyntheticApiModelOutline0.m5400m(this.L$0);
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            j2 = j3;
            platformSelectionBehaviorsImpl = platformSelectionBehaviorsImpl2;
            CharSequence charSequence3 = charSequence;
            try {
                TextClassification textClassification2 = textSelectionM5400m.getTextClassification();
                Intrinsics.checkNotNull(textClassification2);
                platformSelectionBehaviorsImpl.setTextClassificationResult(new TextClassificationResult(charSequence3, j2, textClassification2, null));
                Unit unit2 = Unit.INSTANCE;
            } finally {
                mutex.unlock(null);
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            j2 = j;
        }
        return TextRange.m9586boximpl(j2);
    }
}
