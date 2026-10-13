package io.github.expo.modules.v2.modules;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModuleDefinition.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/github/expo/modules/v2/modules/ModuleEventDefinition;", "", "jsName", "", "payloadType", "", "<init>", "(Ljava/lang/String;[I)V", "getJsName", "()Ljava/lang/String;", "getPayloadType", "()[I", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ModuleEventDefinition {
    private final String jsName;
    private final int[] payloadType;

    public ModuleEventDefinition(String jsName, int[] payloadType) {
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        Intrinsics.checkNotNullParameter(payloadType, "payloadType");
        this.jsName = jsName;
        this.payloadType = payloadType;
    }

    public final String getJsName() {
        return this.jsName;
    }

    public final int[] getPayloadType() {
        return this.payloadType;
    }
}
