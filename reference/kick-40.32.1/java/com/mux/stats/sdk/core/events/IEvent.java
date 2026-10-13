package com.mux.stats.sdk.core.events;

import java.util.Set;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes8.dex */
public interface IEvent {
    String getDebugString();

    @Nonnull
    Set<String> getRequiredProperties();

    String getType();

    boolean isData();

    boolean isDebug();

    boolean isError();

    boolean isPlayback();

    boolean isSessionData();

    boolean isTrackable();

    boolean isViewMetric();
}
