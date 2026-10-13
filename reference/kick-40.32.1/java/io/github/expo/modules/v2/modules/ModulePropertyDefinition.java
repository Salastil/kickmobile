package io.github.expo.modules.v2.modules;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModuleDefinition.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lio/github/expo/modules/v2/modules/ModulePropertyDefinition;", "", "jsName", "", "getterName", "setterName", "getterType", "", "setterType", "isConstant", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[I[IZ)V", "getJsName", "()Ljava/lang/String;", "getGetterName", "getSetterName", "getGetterType", "()[I", "getSetterType", "()Z", "flags", "", "getFlags", "()I", "Companion", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ModulePropertyDefinition {
    public static final int FLAG_CONSTANT = 1;
    private final String getterName;
    private final int[] getterType;
    private final boolean isConstant;
    private final String jsName;
    private final String setterName;
    private final int[] setterType;

    public ModulePropertyDefinition(String jsName, String getterName, String str, int[] getterType, int[] iArr, boolean z) {
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        Intrinsics.checkNotNullParameter(getterName, "getterName");
        Intrinsics.checkNotNullParameter(getterType, "getterType");
        this.jsName = jsName;
        this.getterName = getterName;
        this.setterName = str;
        this.getterType = getterType;
        this.setterType = iArr;
        this.isConstant = z;
    }

    public /* synthetic */ ModulePropertyDefinition(String str, String str2, String str3, int[] iArr, int[] iArr2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, iArr, iArr2, (i & 32) != 0 ? false : z);
    }

    public final String getJsName() {
        return this.jsName;
    }

    public final String getGetterName() {
        return this.getterName;
    }

    public final String getSetterName() {
        return this.setterName;
    }

    public final int[] getGetterType() {
        return this.getterType;
    }

    public final int[] getSetterType() {
        return this.setterType;
    }

    /* JADX INFO: renamed from: isConstant, reason: from getter */
    public final boolean getIsConstant() {
        return this.isConstant;
    }

    public final int getFlags() {
        return this.isConstant ? 1 : 0;
    }
}
