package io.github.expo.modules.v2.modules;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModuleDefinition.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lio/github/expo/modules/v2/modules/ModuleSharedClassDefinition;", "", "jsName", "", "classId", "", "argTypes", "", "", "trampolineName", "<init>", "(Ljava/lang/String;I[[ILjava/lang/String;)V", "getJsName", "()Ljava/lang/String;", "getClassId", "()I", "getArgTypes", "()[[I", "[[I", "getTrampolineName", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ModuleSharedClassDefinition {
    private final int[][] argTypes;
    private final int classId;
    private final String jsName;
    private final String trampolineName;

    public ModuleSharedClassDefinition(String jsName, int i, int[][] argTypes, String trampolineName) {
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        Intrinsics.checkNotNullParameter(argTypes, "argTypes");
        Intrinsics.checkNotNullParameter(trampolineName, "trampolineName");
        this.jsName = jsName;
        this.classId = i;
        this.argTypes = argTypes;
        this.trampolineName = trampolineName;
    }

    public final String getJsName() {
        return this.jsName;
    }

    public final int getClassId() {
        return this.classId;
    }

    public final int[][] getArgTypes() {
        return this.argTypes;
    }

    public final String getTrampolineName() {
        return this.trampolineName;
    }
}
