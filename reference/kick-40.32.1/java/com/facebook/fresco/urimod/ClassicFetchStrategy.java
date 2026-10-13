package com.facebook.fresco.urimod;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: FetchStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Lcom/facebook/fresco/urimod/ClassicFetchStrategy;", "Lcom/facebook/fresco/urimod/FetchStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "APP_DISABLED", "PRODUCT_DISABLED", "APP_STARTING", "MAIN_THREAD", "DISK_CACHE_TIMEOUT", "DISK_CACHE_HIT", "URI_INELIGIBLE", "toString", "", "urimod_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ClassicFetchStrategy implements FetchStrategy {
    DEFAULT,
    APP_DISABLED,
    PRODUCT_DISABLED,
    APP_STARTING,
    MAIN_THREAD,
    DISK_CACHE_TIMEOUT,
    DISK_CACHE_HIT,
    URI_INELIGIBLE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<ClassicFetchStrategy> getEntries() {
        return $ENTRIES;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ClassicFetchStrategy: " + name();
    }
}
