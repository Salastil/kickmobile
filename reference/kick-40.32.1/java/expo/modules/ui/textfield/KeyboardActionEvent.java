package expo.modules.ui.textfield;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextFieldShared.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lexpo/modules/ui/textfield/KeyboardActionEvent;", "Lexpo/modules/kotlin/records/Record;", "action", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAction$annotations", "()V", "getAction", "()Ljava/lang/String;", "getValue$annotations", "getValue", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class KeyboardActionEvent implements Record {
    public static final int $stable = 0;
    private final String action;
    private final String value;

    public static /* synthetic */ KeyboardActionEvent copy$default(KeyboardActionEvent keyboardActionEvent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = keyboardActionEvent.action;
        }
        if ((i & 2) != 0) {
            str2 = keyboardActionEvent.value;
        }
        return keyboardActionEvent.copy(str, str2);
    }

    @Field
    public static /* synthetic */ void getAction$annotations() {
    }

    @Field
    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final KeyboardActionEvent copy(String action, String value) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(value, "value");
        return new KeyboardActionEvent(action, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyboardActionEvent)) {
            return false;
        }
        KeyboardActionEvent keyboardActionEvent = (KeyboardActionEvent) other;
        return Intrinsics.areEqual(this.action, keyboardActionEvent.action) && Intrinsics.areEqual(this.value, keyboardActionEvent.value);
    }

    public int hashCode() {
        return (this.action.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "KeyboardActionEvent(action=" + this.action + ", value=" + this.value + ")";
    }

    public KeyboardActionEvent(String action, String value) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(value, "value");
        this.action = action;
        this.value = value;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getValue() {
        return this.value;
    }
}
