package com.datadog.android.rum.internal.vitals;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CPUVitalReader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/CPUVitalReader;", "Lcom/datadog/android/rum/internal/vitals/VitalReader;", "cpuStatReader", "Lcom/datadog/android/rum/internal/vitals/CpuStatReader;", "(Lcom/datadog/android/rum/internal/vitals/CpuStatReader;)V", "readVitalData", "", "()Ljava/lang/Double;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CPUVitalReader implements VitalReader {
    private final CpuStatReader cpuStatReader;

    public CPUVitalReader(CpuStatReader cpuStatReader) {
        Intrinsics.checkNotNullParameter(cpuStatReader, "cpuStatReader");
        this.cpuStatReader = cpuStatReader;
    }

    @Override // com.datadog.android.rum.internal.vitals.VitalReader
    public Double readVitalData() {
        return this.cpuStatReader.readUserTime();
    }
}
