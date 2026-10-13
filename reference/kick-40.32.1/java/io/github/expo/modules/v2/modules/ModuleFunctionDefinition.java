package io.github.expo.modules.v2.modules;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModuleDefinition.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lio/github/expo/modules/v2/modules/ModuleFunctionDefinition;", "", "jsName", "", "methodName", "argTypes", "", "", "returnType", "isAsync", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;[[I[IZ)V", "getJsName", "()Ljava/lang/String;", "getMethodName", "getArgTypes", "()[[I", "[[I", "getReturnType", "()[I", "()Z", "flags", "", "getFlags", "()I", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ModuleFunctionDefinition {
    public static final int FLAG_ASYNC = 1;
    private final int[][] argTypes;
    private final boolean isAsync;
    private final String jsName;
    private final String methodName;
    private final int[] returnType;

    public ModuleFunctionDefinition(String jsName, String methodName, int[][] argTypes, int[] returnType, boolean z) {
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(argTypes, "argTypes");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        this.jsName = jsName;
        this.methodName = methodName;
        this.argTypes = argTypes;
        this.returnType = returnType;
        this.isAsync = z;
    }

    public /* synthetic */ ModuleFunctionDefinition(String str, String str2, int[][] iArr, int[] iArr2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, iArr, iArr2, (i & 16) != 0 ? false : z);
    }

    public final String getJsName() {
        return this.jsName;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final int[][] getArgTypes() {
        return this.argTypes;
    }

    public final int[] getReturnType() {
        return this.returnType;
    }

    /* JADX INFO: renamed from: isAsync, reason: from getter */
    public final boolean getIsAsync() {
        return this.isAsync;
    }

    public final int getFlags() {
        return this.isAsync ? 1 : 0;
    }
}
