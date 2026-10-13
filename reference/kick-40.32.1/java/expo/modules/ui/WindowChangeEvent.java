package expo.modules.ui;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: LazyItemsView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lexpo/modules/ui/WindowChangeEvent;", "Lexpo/modules/kotlin/records/Record;", "first", "", "last", "revision", "<init>", "(III)V", "getFirst$annotations", "()V", "getFirst", "()I", "getLast$annotations", "getLast", "getRevision$annotations", "getRevision", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WindowChangeEvent implements Record {
    public static final int $stable = 0;
    private final int first;
    private final int last;
    private final int revision;

    public static /* synthetic */ WindowChangeEvent copy$default(WindowChangeEvent windowChangeEvent, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = windowChangeEvent.first;
        }
        if ((i4 & 2) != 0) {
            i2 = windowChangeEvent.last;
        }
        if ((i4 & 4) != 0) {
            i3 = windowChangeEvent.revision;
        }
        return windowChangeEvent.copy(i, i2, i3);
    }

    @Field
    public static /* synthetic */ void getFirst$annotations() {
    }

    @Field
    public static /* synthetic */ void getLast$annotations() {
    }

    @Field
    public static /* synthetic */ void getRevision$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFirst() {
        return this.first;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLast() {
        return this.last;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    public final WindowChangeEvent copy(int first, int last, int revision) {
        return new WindowChangeEvent(first, last, revision);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WindowChangeEvent)) {
            return false;
        }
        WindowChangeEvent windowChangeEvent = (WindowChangeEvent) other;
        return this.first == windowChangeEvent.first && this.last == windowChangeEvent.last && this.revision == windowChangeEvent.revision;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.first) * 31) + Integer.hashCode(this.last)) * 31) + Integer.hashCode(this.revision);
    }

    public String toString() {
        return "WindowChangeEvent(first=" + this.first + ", last=" + this.last + ", revision=" + this.revision + ")";
    }

    public WindowChangeEvent(int i, int i2, int i3) {
        this.first = i;
        this.last = i2;
        this.revision = i3;
    }

    public final int getFirst() {
        return this.first;
    }

    public final int getLast() {
        return this.last;
    }

    public final int getRevision() {
        return this.revision;
    }
}
