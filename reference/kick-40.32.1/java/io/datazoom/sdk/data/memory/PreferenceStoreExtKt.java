package io.datazoom.sdk.data.memory;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.Preference;
import io.datazoom.sdk.model.PreferenceKt;
import io.datazoom.sdk.stateMachine.timeSync.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreferenceStoreExt.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u001b\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\t\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\"(\u0010\u000e\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r\"(\u0010\u0012\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\"(\u0010\u0016\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015\"(\u0010\u0018\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015\"(\u0010\u001a\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015\"(\u0010\u001c\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015\",\u0010\u001e\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0000\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\"(\u0010#\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007\"(\u0010&\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007\",\u0010*\u001a\u0004\u0018\u00010)*\u00020\u00032\b\u0010\u0000\u001a\u0004\u0018\u00010)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\"(\u0010/\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010\r\"(\u00102\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0005\"\u0004\b4\u0010\u0007\"(\u00105\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u0010\u0015\"(\u00107\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u0010\u0005\"\u0004\b9\u0010\u0007\"(\u0010:\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0005\"\u0004\b<\u0010\u0007\"(\u0010=\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010\u0013\"\u0004\b?\u0010\u0015\"(\u0010@\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0013\"\u0004\bA\u0010\u0015\"(\u0010B\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010\u0013\"\u0004\bC\u0010\u0015¨\u0006D"}, d2 = {"value", "", "ctPosUpdateTime", "Lio/datazoom/sdk/data/memory/PreferenceStore;", "getCtPosUpdateTime", "(Lio/datazoom/sdk/data/memory/PreferenceStore;)J", "setCtPosUpdateTime", "(Lio/datazoom/sdk/data/memory/PreferenceStore;J)V", "", "ctPlayedCount", "getCtPlayedCount", "(Lio/datazoom/sdk/data/memory/PreferenceStore;)I", "setCtPlayedCount", "(Lio/datazoom/sdk/data/memory/PreferenceStore;I)V", "ctRequestedCount", "getCtRequestedCount", "setCtRequestedCount", "", "isStalling", "(Lio/datazoom/sdk/data/memory/PreferenceStore;)Z", "setStalling", "(Lio/datazoom/sdk/data/memory/PreferenceStore;Z)V", "isAdStarted", "setAdStarted", "isAdPaused", "setAdPaused", "isContentStarted", "setContentStarted", "isContentPaused", "setContentPaused", "ctPlayingPos", "getCtPlayingPos", "(Lio/datazoom/sdk/data/memory/PreferenceStore;)Ljava/lang/Long;", "setCtPlayingPos", "(Lio/datazoom/sdk/data/memory/PreferenceStore;Ljava/lang/Long;)V", "lastDurUpdateTime", "getLastDurUpdateTime", "setLastDurUpdateTime", "adPosUpdateTime", "getAdPosUpdateTime", "setAdPosUpdateTime", "Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "currState", "getCurrState", "(Lio/datazoom/sdk/data/memory/PreferenceStore;)Lio/datazoom/sdk/stateMachine/timeSync/model/State;", "setCurrState", "(Lio/datazoom/sdk/data/memory/PreferenceStore;Lio/datazoom/sdk/stateMachine/timeSync/model/State;)V", "heartbeatCount", "getHeartbeatCount", "setHeartbeatCount", "nextHeartbeatTime", "getNextHeartbeatTime", "setNextHeartbeatTime", "isMuted", "setMuted", "totalAdBreakTime", "getTotalAdBreakTime", "setTotalAdBreakTime", "totalAdPlaybackTime", "getTotalAdPlaybackTime", "setTotalAdPlaybackTime", "activeSinceLastHeartbeat", "getActiveSinceLastHeartbeat", "setActiveSinceLastHeartbeat", "isPlayingAd", "setPlayingAd", "isAdLoaded", "setAdLoaded", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PreferenceStoreExtKt {
    public static final long getCtPosUpdateTime(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Long l = (Long) preferenceStore.get(Preference.Type.LastContentUpdateDuration);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public static final void setCtPosUpdateTime(PreferenceStore preferenceStore, long j) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.LastContentUpdateDuration, Long.valueOf(j)));
    }

    public static final int getCtPlayedCount(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Integer num = (Integer) preferenceStore.get(Preference.Type.ContentPlayed);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final void setCtPlayedCount(PreferenceStore preferenceStore, int i) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.ContentPlayed, Integer.valueOf(i)));
    }

    public static final int getCtRequestedCount(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Integer num = (Integer) preferenceStore.get(Preference.Type.ContentRequested);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final void setCtRequestedCount(PreferenceStore preferenceStore, int i) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.ContentRequested, Integer.valueOf(i)));
    }

    public static final boolean isStalling(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Boolean bool = (Boolean) preferenceStore.get(Preference.Type.IsStalling);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final void setStalling(PreferenceStore preferenceStore, boolean z) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.IsStalling, Boolean.valueOf(z)));
    }

    public static final boolean isAdStarted(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Boolean bool = (Boolean) preferenceStore.get(Preference.Type.IsAdStarted);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final void setAdStarted(PreferenceStore preferenceStore, boolean z) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.IsAdStarted, Boolean.valueOf(z)));
    }

    public static final boolean isAdPaused(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Boolean bool = (Boolean) preferenceStore.get(Preference.Type.IsAdPaused);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final void setAdPaused(PreferenceStore preferenceStore, boolean z) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.IsAdPaused, Boolean.valueOf(z)));
    }

    public static final boolean isContentStarted(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Boolean bool = (Boolean) preferenceStore.get(Preference.Type.IsCtStarted);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final void setContentStarted(PreferenceStore preferenceStore, boolean z) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.IsCtStarted, Boolean.valueOf(z)));
    }

    public static final boolean isContentPaused(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Boolean bool = (Boolean) preferenceStore.get(Preference.Type.IsCtPaused);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final void setContentPaused(PreferenceStore preferenceStore, boolean z) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.IsCtPaused, Boolean.valueOf(z)));
    }

    public static final Long getCtPlayingPos(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        return (Long) preferenceStore.get(Preference.Type.PlayHead);
    }

    public static final void setCtPlayingPos(PreferenceStore preferenceStore, Long l) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        if (l != null) {
            preferenceStore.put(PreferenceKt.to(Preference.Type.PlayHead, Long.valueOf(l.longValue())));
        }
    }

    public static final long getLastDurUpdateTime(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Long l = (Long) preferenceStore.get(Preference.Type.LastDurUpdateTime);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public static final void setLastDurUpdateTime(PreferenceStore preferenceStore, long j) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.LastDurUpdateTime, Long.valueOf(j)));
    }

    public static final long getAdPosUpdateTime(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Long l = (Long) preferenceStore.get(Preference.Type.AdPosUpdateTime);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public static final void setAdPosUpdateTime(PreferenceStore preferenceStore, long j) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.AdPosUpdateTime, Long.valueOf(j)));
    }

    public static final State getCurrState(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        return (State) preferenceStore.get(Preference.Type.CurrentState);
    }

    public static final void setCurrState(PreferenceStore preferenceStore, State state) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        if (state != null) {
            preferenceStore.put(PreferenceKt.to(Preference.Type.CurrentState, state));
        }
    }

    public static final int getHeartbeatCount(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Integer num = (Integer) preferenceStore.get(Preference.Type.HeartbeatCount);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final void setHeartbeatCount(PreferenceStore preferenceStore, int i) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.HeartbeatCount, Integer.valueOf(i)));
    }

    public static final long getNextHeartbeatTime(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Long l = (Long) preferenceStore.get(Preference.Type.NextHeartBeatTime);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public static final void setNextHeartbeatTime(PreferenceStore preferenceStore, long j) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.NextHeartBeatTime, Long.valueOf(j)));
    }

    public static final boolean isMuted(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Boolean bool = (Boolean) preferenceStore.get(Preference.Type.IsMuted);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final void setMuted(PreferenceStore preferenceStore, boolean z) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.IsMuted, Boolean.valueOf(z)));
    }

    public static final long getTotalAdBreakTime(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Long l = (Long) preferenceStore.get(Preference.Type.TotalAdBreakTime);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public static final void setTotalAdBreakTime(PreferenceStore preferenceStore, long j) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.TotalAdBreakTime, Long.valueOf(j)));
    }

    public static final long getTotalAdPlaybackTime(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Long l = (Long) preferenceStore.get(Preference.Type.TotalAdPlaybackTime);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public static final void setTotalAdPlaybackTime(PreferenceStore preferenceStore, long j) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.TotalAdPlaybackTime, Long.valueOf(j)));
    }

    public static final boolean getActiveSinceLastHeartbeat(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Boolean bool = (Boolean) preferenceStore.get(Preference.Type.LastUpdateDuration);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final void setActiveSinceLastHeartbeat(PreferenceStore preferenceStore, boolean z) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.LastUpdateDuration, Boolean.valueOf(z)));
    }

    public static final boolean isPlayingAd(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Boolean bool = (Boolean) preferenceStore.get(Preference.Type.IsPlayingAd);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final void setPlayingAd(PreferenceStore preferenceStore, boolean z) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.IsPlayingAd, Boolean.valueOf(z)));
    }

    public static final boolean isAdLoaded(PreferenceStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        Boolean bool = (Boolean) preferenceStore.get(Preference.Type.IsAdLoaded);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final void setAdLoaded(PreferenceStore preferenceStore, boolean z) {
        Intrinsics.checkNotNullParameter(preferenceStore, "<this>");
        preferenceStore.put(PreferenceKt.to(Preference.Type.IsAdLoaded, Boolean.valueOf(z)));
    }
}
