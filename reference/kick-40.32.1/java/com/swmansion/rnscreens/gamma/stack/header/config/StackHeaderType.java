package com.swmansion.rnscreens.gamma.stack.header.config;

import com.datadog.reactnative.DefaultConfiguration;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: StackHeaderType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;", "", "<init>", "(Ljava/lang/String;I)V", "SMALL", DefaultConfiguration.batchSize, "LARGE", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum StackHeaderType {
    SMALL,
    MEDIUM,
    LARGE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<StackHeaderType> getEntries() {
        return $ENTRIES;
    }
}
