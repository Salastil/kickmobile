package com.facebook.fresco.vito.core.impl.debug;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DebugDataProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B!\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/DebugDataProvider;", "", "shortName", "", "longName", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getShortName", "()Ljava/lang/String;", "getLongName", "getDescription", "Lcom/facebook/fresco/vito/core/impl/debug/StringAndColorDebugDataProvider;", "Lcom/facebook/fresco/vito/core/impl/debug/StringDebugDataProvider;", "core-common-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DebugDataProvider {
    private final String description;
    private final String longName;
    private final String shortName;

    public /* synthetic */ DebugDataProvider(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    private DebugDataProvider(String str, String str2, String str3) {
        this.shortName = str;
        this.longName = str2;
        this.description = str3;
    }

    public final String getShortName() {
        return this.shortName;
    }

    public final String getLongName() {
        return this.longName;
    }

    public final String getDescription() {
        return this.description;
    }
}
