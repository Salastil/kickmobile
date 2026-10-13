package org.threeten.bp.temporal;

import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface TemporalAmount {
    Temporal addTo(Temporal temporal);

    long get(TemporalUnit temporalUnit);

    List<TemporalUnit> getUnits();

    Temporal subtractFrom(Temporal temporal);
}
