package io.datazoom.sdk.model;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Preference.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lio/datazoom/sdk/model/Preference;", "", "key", "Lio/datazoom/sdk/model/Preference$Type;", "value", "<init>", "(Lio/datazoom/sdk/model/Preference$Type;Ljava/lang/Object;)V", "getKey", "()Lio/datazoom/sdk/model/Preference$Type;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Type", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Preference {
    private final Type key;
    private final Object value;

    public static /* synthetic */ Preference copy$default(Preference preference, Type type, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            type = preference.key;
        }
        if ((i & 2) != 0) {
            obj = preference.value;
        }
        return preference.copy(type, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Type getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    public final Preference copy(Type key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return new Preference(key, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) other;
        return this.key == preference.key && Intrinsics.areEqual(this.value, preference.value);
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "Preference(key=" + this.key + ", value=" + this.value + ")";
    }

    public Preference(Type key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.key = key;
        this.value = value;
    }

    public final Type getKey() {
        return this.key;
    }

    public final Object getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: Preference.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lio/datazoom/sdk/model/Preference$Type;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PlayHead", "IsStalling", "IsCtStarted", "IsCtPaused", "IsMuted", "ContentPlayed", "ContentRequested", "LastUpdateDuration", "LastContentUpdateDuration", "HeartbeatCount", "NextHeartBeatTime", "IsPlayingContent", "IsAdStarted", "IsPlayingAd", "IsAdPaused", "IsAdLoaded", "LastDurUpdateTime", "AdPosUpdateTime", "CurrentState", "TotalAdBreakTime", "TotalAdPlaybackTime", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum Type {
        PlayHead("playhead"),
        IsStalling("isStalling"),
        IsCtStarted("isContentStarted"),
        IsCtPaused("isContentPaused"),
        IsMuted("isMuted"),
        ContentPlayed("contentPlayed"),
        ContentRequested("contentRequested"),
        LastUpdateDuration("lastUpdateDuration"),
        LastContentUpdateDuration("lastContentDuration"),
        HeartbeatCount("heartbeatCount"),
        NextHeartBeatTime("nextHeartBeatTime"),
        IsPlayingContent("isPlayingContent"),
        IsAdStarted("isAdStarted"),
        IsPlayingAd("isPlayingAd"),
        IsAdPaused("isAdPaused"),
        IsAdLoaded("IsAdLoaded"),
        LastDurUpdateTime("lastDurUpdateTime"),
        AdPosUpdateTime("adPosUpdateTime"),
        CurrentState("currentState"),
        TotalAdBreakTime("totalAdBreakTime"),
        TotalAdPlaybackTime("totalAdPlaybackTime");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String value;

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        Type(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }
}
