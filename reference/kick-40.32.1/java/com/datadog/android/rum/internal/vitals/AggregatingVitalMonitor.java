package com.datadog.android.rum.internal.vitals;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AggregatingVitalMonitor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/rum/internal/vitals/AggregatingVitalMonitor;", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "()V", "lastKnownSample", "", "listeners", "", "Lcom/datadog/android/rum/internal/vitals/VitalListener;", "Lcom/datadog/android/rum/internal/vitals/VitalInfo;", "getLastSample", "notifyListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "value", "notifyListeners", "onNewSample", "register", "unregister", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AggregatingVitalMonitor implements VitalMonitor {
    private volatile double lastKnownSample = Double.NaN;
    private final Map<VitalListener, VitalInfo> listeners = new ConcurrentHashMap();

    @Override // com.datadog.android.rum.internal.vitals.VitalObserver
    public void onNewSample(double value) {
        this.lastKnownSample = value;
        notifyListeners(value);
    }

    @Override // com.datadog.android.rum.internal.vitals.VitalMonitor
    /* JADX INFO: renamed from: getLastSample, reason: from getter */
    public double getLastKnownSample() {
        return this.lastKnownSample;
    }

    @Override // com.datadog.android.rum.internal.vitals.VitalMonitor
    public void register(VitalListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        double d = this.lastKnownSample;
        synchronized (this.listeners) {
            this.listeners.put(listener, VitalInfo.INSTANCE.getEMPTY());
            Unit unit = Unit.INSTANCE;
        }
        if (Double.isNaN(d)) {
            return;
        }
        notifyListener(listener, d);
    }

    @Override // com.datadog.android.rum.internal.vitals.VitalMonitor
    public void unregister(VitalListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listeners) {
            this.listeners.remove(listener);
        }
    }

    private final void notifyListeners(double value) {
        synchronized (this.listeners) {
            Iterator<VitalListener> it = this.listeners.keySet().iterator();
            while (it.hasNext()) {
                notifyListener(it.next(), value);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void notifyListener(VitalListener listener, double value) {
        VitalInfo empty = this.listeners.get(listener);
        if (empty == null) {
            empty = VitalInfo.INSTANCE.getEMPTY();
        }
        int sampleCount = empty.getSampleCount() + 1;
        VitalInfo vitalInfo = new VitalInfo(sampleCount, Math.min(value, empty.getMinValue()), Math.max(value, empty.getMaxValue()), ((((double) empty.getSampleCount()) * empty.getMeanValue()) + value) / ((double) sampleCount));
        listener.onVitalUpdate(vitalInfo);
        synchronized (this.listeners) {
            this.listeners.put(listener, vitalInfo);
            Unit unit = Unit.INSTANCE;
        }
    }
}
