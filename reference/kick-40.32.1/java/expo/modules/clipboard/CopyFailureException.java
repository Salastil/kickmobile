package expo.modules.clipboard;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClipboardExceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/clipboard/CopyFailureException;", "Lexpo/modules/kotlin/exception/CodedException;", "cause", "", "kind", "", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "expo-clipboard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CopyFailureException extends CodedException {
    public /* synthetic */ CopyFailureException(Throwable th, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? "item" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CopyFailureException(Throwable th, String kind) {
        super("Failed to save " + kind + " into clipboard", th);
        Intrinsics.checkNotNullParameter(kind, "kind");
    }
}
