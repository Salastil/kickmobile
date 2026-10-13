package com.datadog.android.api.context;

import kotlin.Metadata;

/* JADX INFO: compiled from: ProcessInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/api/context/ProcessInfo;", "", "isMainProcess", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ProcessInfo {
    private final boolean isMainProcess;

    public static /* synthetic */ ProcessInfo copy$default(ProcessInfo processInfo, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = processInfo.isMainProcess;
        }
        return processInfo.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsMainProcess() {
        return this.isMainProcess;
    }

    public final ProcessInfo copy(boolean isMainProcess) {
        return new ProcessInfo(isMainProcess);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ProcessInfo) && this.isMainProcess == ((ProcessInfo) other).isMainProcess;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isMainProcess);
    }

    public String toString() {
        return "ProcessInfo(isMainProcess=" + this.isMainProcess + ")";
    }

    public ProcessInfo(boolean z) {
        this.isMainProcess = z;
    }

    public final boolean isMainProcess() {
        return this.isMainProcess;
    }
}
