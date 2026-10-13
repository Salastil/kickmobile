package expo.modules.clipboard;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: ClipboardOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/clipboard/SetImageOptions;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "isSensitive", "", "isSensitive$annotations", "()Z", "setSensitive", "(Z)V", "expo-clipboard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetImageOptions implements Record {
    private boolean isSensitive;

    @Field
    public static /* synthetic */ void isSensitive$annotations() {
    }

    /* JADX INFO: renamed from: isSensitive, reason: from getter */
    public final boolean getIsSensitive() {
        return this.isSensitive;
    }

    public final void setSensitive(boolean z) {
        this.isSensitive = z;
    }
}
