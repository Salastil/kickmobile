package expo.modules.clipboard;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ClipboardModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/clipboard/ContentType;", "", "jsName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsName", "()Ljava/lang/String;", "PLAIN_TEXT", "HTML", "IMAGE", "expo-clipboard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
enum ContentType {
    PLAIN_TEXT("plain-text"),
    HTML("html"),
    IMAGE("image");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String jsName;

    public static EnumEntries<ContentType> getEntries() {
        return $ENTRIES;
    }

    ContentType(String str) {
        this.jsName = str;
    }

    public final String getJsName() {
        return this.jsName;
    }
}
