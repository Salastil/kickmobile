package com.facebook.fresco.urimod;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: FetchStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/facebook/fresco/urimod/SmartFetchStrategy;", "Lcom/facebook/fresco/urimod/FetchStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "FALLBACK_DISABLED", "MAIN_THREAD", "DISK_CACHE_TIMEOUT", "VARIATION", "toString", "", "urimod_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum SmartFetchStrategy implements FetchStrategy {
    DEFAULT,
    FALLBACK_DISABLED,
    MAIN_THREAD,
    DISK_CACHE_TIMEOUT,
    VARIATION;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<SmartFetchStrategy> getEntries() {
        return $ENTRIES;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "SmartFetchStrategy: " + name();
    }
}
