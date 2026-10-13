package expo.modules.ui.textfield;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextFieldShared.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lexpo/modules/ui/textfield/TextFieldValuePayload;", "Lexpo/modules/kotlin/records/Record;", "text", "", "selection", "Lexpo/modules/ui/textfield/TextFieldSelectionPayload;", "<init>", "(Ljava/lang/String;Lexpo/modules/ui/textfield/TextFieldSelectionPayload;)V", "getText$annotations", "()V", "getText", "()Ljava/lang/String;", "getSelection$annotations", "getSelection", "()Lexpo/modules/ui/textfield/TextFieldSelectionPayload;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextFieldValuePayload implements Record {
    public static final int $stable = 0;
    private final TextFieldSelectionPayload selection;
    private final String text;

    public static /* synthetic */ TextFieldValuePayload copy$default(TextFieldValuePayload textFieldValuePayload, String str, TextFieldSelectionPayload textFieldSelectionPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textFieldValuePayload.text;
        }
        if ((i & 2) != 0) {
            textFieldSelectionPayload = textFieldValuePayload.selection;
        }
        return textFieldValuePayload.copy(str, textFieldSelectionPayload);
    }

    @Field
    public static /* synthetic */ void getSelection$annotations() {
    }

    @Field
    public static /* synthetic */ void getText$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TextFieldSelectionPayload getSelection() {
        return this.selection;
    }

    public final TextFieldValuePayload copy(String text, TextFieldSelectionPayload selection) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(selection, "selection");
        return new TextFieldValuePayload(text, selection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextFieldValuePayload)) {
            return false;
        }
        TextFieldValuePayload textFieldValuePayload = (TextFieldValuePayload) other;
        return Intrinsics.areEqual(this.text, textFieldValuePayload.text) && Intrinsics.areEqual(this.selection, textFieldValuePayload.selection);
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.selection.hashCode();
    }

    public String toString() {
        return "TextFieldValuePayload(text=" + this.text + ", selection=" + this.selection + ")";
    }

    public TextFieldValuePayload(String text, TextFieldSelectionPayload selection) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(selection, "selection");
        this.text = text;
        this.selection = selection;
    }

    public final String getText() {
        return this.text;
    }

    public final TextFieldSelectionPayload getSelection() {
        return this.selection;
    }
}
