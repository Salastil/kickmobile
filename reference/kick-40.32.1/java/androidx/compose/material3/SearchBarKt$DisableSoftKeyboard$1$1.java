package androidx.compose.material3;

import androidx.compose.ui.platform.PlatformTextInputInterceptor;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.PlatformTextInputSession;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class SearchBarKt$DisableSoftKeyboard$1$1 implements PlatformTextInputInterceptor {
    public static final SearchBarKt$DisableSoftKeyboard$1$1 INSTANCE = new SearchBarKt$DisableSoftKeyboard$1$1();

    SearchBarKt$DisableSoftKeyboard$1$1() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.ui.platform.PlatformTextInputInterceptor
    public final Object interceptStartInputMethod(PlatformTextInputMethodRequest platformTextInputMethodRequest, PlatformTextInputSession platformTextInputSession, Continuation<?> continuation) {
        SearchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1 searchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1;
        if (continuation instanceof SearchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1) {
            searchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1 = (SearchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1) continuation;
            if ((searchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1.label & Integer.MIN_VALUE) != 0) {
                searchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1.label -= Integer.MIN_VALUE;
            } else {
                searchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1 = new SearchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1(this, continuation);
            }
        } else {
            searchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1 = new SearchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1(this, continuation);
        }
        Object obj = searchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = searchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            searchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1.label = 1;
            if (DelayKt.awaitCancellation(searchBarKt$DisableSoftKeyboard$1$1$interceptStartInputMethod$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
