package expo.modules.ui.textfield;

import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextFieldShared.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lexpo/modules/ui/textfield/TextFieldSelectionPayload;", "Lexpo/modules/kotlin/records/Record;", ViewProps.START, "", ViewProps.END, "<init>", "(II)V", "getStart$annotations", "()V", "getStart", "()I", "getEnd$annotations", "getEnd", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextFieldSelectionPayload implements Record {
    public static final int $stable = 0;
    private final int end;
    private final int start;

    public static /* synthetic */ TextFieldSelectionPayload copy$default(TextFieldSelectionPayload textFieldSelectionPayload, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = textFieldSelectionPayload.start;
        }
        if ((i3 & 2) != 0) {
            i2 = textFieldSelectionPayload.end;
        }
        return textFieldSelectionPayload.copy(i, i2);
    }

    @Field
    public static /* synthetic */ void getEnd$annotations() {
    }

    @Field
    public static /* synthetic */ void getStart$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    public final TextFieldSelectionPayload copy(int start, int end) {
        return new TextFieldSelectionPayload(start, end);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextFieldSelectionPayload)) {
            return false;
        }
        TextFieldSelectionPayload textFieldSelectionPayload = (TextFieldSelectionPayload) other;
        return this.start == textFieldSelectionPayload.start && this.end == textFieldSelectionPayload.end;
    }

    public int hashCode() {
        return (Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end);
    }

    public String toString() {
        return "TextFieldSelectionPayload(start=" + this.start + ", end=" + this.end + ")";
    }

    public TextFieldSelectionPayload(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getEnd() {
        return this.end;
    }
}
