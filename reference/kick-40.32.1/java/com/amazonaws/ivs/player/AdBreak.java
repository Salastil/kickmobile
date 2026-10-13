package com.amazonaws.ivs.player;

/* JADX INFO: loaded from: classes5.dex */
public final class AdBreak {
    private final String adBreakId;
    private final long duration;
    private final AdBreakMetadata metadata;
    private final int podLength;
    private final RollType rollType;

    public enum RollType {
        PREROLL,
        MIDROLL,
        POSTROLL,
        UNKNOWN;

        static RollType fromInt(int i) {
            if (i == 0) {
                return PREROLL;
            }
            if (i == 1) {
                return MIDROLL;
            }
            if (i == 2) {
                return POSTROLL;
            }
            return UNKNOWN;
        }
    }

    AdBreak(String str, int i, long j, int i2, AdBreakMetadata adBreakMetadata) {
        this.adBreakId = str;
        this.rollType = RollType.fromInt(i);
        this.duration = j;
        this.podLength = i2;
        this.metadata = adBreakMetadata;
    }

    public String getAdBreakId() {
        return this.adBreakId;
    }

    public RollType getRollType() {
        return this.rollType;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getPodLength() {
        return this.podLength;
    }

    public AdBreakMetadata getMetadata() {
        return this.metadata;
    }
}
