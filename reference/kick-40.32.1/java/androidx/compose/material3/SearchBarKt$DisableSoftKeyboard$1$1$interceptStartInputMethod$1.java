package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SearchBarKt$DisableSoftKeyboard$1$1", f = "SearchBar.kt", i = {}, l = {3655}, m = "interceptStartInputMethod", n = {}, s = {}, v = 1)
final class SearchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SearchBarKt$DisableSoftKeyboard$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1(SearchBarKt$DisableSoftKeyboard$1$1 searchBarKt$DisableSoftKeyboard$1$1, Continuation<? super SearchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1> continuation) {
        super(continuation);
        this.this$0 = searchBarKt$DisableSoftKeyboard$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.interceptStartInputMethod(null, null, this);
    }
}
