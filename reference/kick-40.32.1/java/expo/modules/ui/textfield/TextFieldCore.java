package expo.modules.ui.textfield;

import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextFieldShared.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lexpo/modules/ui/textfield/TextFieldCore;", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "modifier", "Landroidx/compose/ui/Modifier;", "<init>", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/ui/Modifier;)V", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getOnValueChange", "()Lkotlin/jvm/functions/Function1;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "getModifier", "()Landroidx/compose/ui/Modifier;", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TextFieldCore {
    public static final int $stable = 0;
    private final KeyboardActions keyboardActions;
    private final KeyboardOptions keyboardOptions;
    private final Modifier modifier;
    private final Function1<TextFieldValue, Unit> onValueChange;
    private final TextFieldValue value;

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldCore(TextFieldValue value, Function1<? super TextFieldValue, Unit> onValueChange, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, Modifier modifier) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Intrinsics.checkNotNullParameter(keyboardOptions, "keyboardOptions");
        Intrinsics.checkNotNullParameter(keyboardActions, "keyboardActions");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        this.value = value;
        this.onValueChange = onValueChange;
        this.keyboardOptions = keyboardOptions;
        this.keyboardActions = keyboardActions;
        this.modifier = modifier;
    }

    public final TextFieldValue getValue() {
        return this.value;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange() {
        return this.onValueChange;
    }

    public final KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    public final KeyboardActions getKeyboardActions() {
        return this.keyboardActions;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }
}
