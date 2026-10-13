package io.datazoom.sdk.model;

import com.facebook.hermes.intl.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mux.stats.sdk.core.events.playback.PauseEvent;
import com.mux.stats.sdk.core.events.playback.PlayEvent;
import com.mux.stats.sdk.core.events.playback.PlayingEvent;
import io.datazoom.sdk.time.Time;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Event.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002<=Bí\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012'\b\u0002\u0010\u0004\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n\u0012'\b\u0002\u0010\u000b\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n\u0012'\b\u0002\u0010\f\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n\u0012'\b\u0002\u0010\r\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012'\b\u0002\u0010\u0010\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n\u0012'\b\u0002\u0010\u0011\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n\u0012'\b\u0002\u0010\u0012\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n\u0012'\b\u0002\u0010\u0013\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010*\u001a\u00020\u0003HÆ\u0003J(\u0010+\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\nHÆ\u0003J(\u0010,\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\nHÆ\u0003J(\u0010-\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\nHÆ\u0003J(\u0010.\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\nHÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J(\u00100\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\nHÆ\u0003J(\u00101\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\nHÆ\u0003J(\u00102\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\nHÆ\u0003J(\u00103\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\nHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0015HÆ\u0003Jñ\u0002\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\b\u0002\u0010\u0004\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n2'\b\u0002\u0010\u000b\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n2'\b\u0002\u0010\f\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n2'\b\u0002\u0010\r\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2'\b\u0002\u0010\u0010\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n2'\b\u0002\u0010\u0011\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n2'\b\u0002\u0010\u0012\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n2'\b\u0002\u0010\u0013\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0014\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00109\u001a\u00020:HÖ\u0081\u0004J\n\u0010;\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R0\u0010\u0004\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR0\u0010\u000b\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR0\u0010\f\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR0\u0010\r\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R0\u0010\u0010\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR0\u0010\u0011\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR0\u0010\u0012\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR0\u0010\u0013\u001a!\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\t0\t0\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006>"}, d2 = {"Lio/datazoom/sdk/model/Event;", "", "type", "Lio/datazoom/sdk/model/Event$Type;", "metadata", "Ljava/util/HashMap;", "", "Lkotlinx/serialization/Serializable;", "with", "Lio/datazoom/sdk/utils/AnySerializer;", "Lio/datazoom/sdk/utils/DataMap;", "fluxData", "opsMetadata", "custom", "time", "", "userDetails", "player", "ad", "video", "videoType", "Lio/datazoom/sdk/model/VideoType;", "<init>", "(Lio/datazoom/sdk/model/Event$Type;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;JLjava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Lio/datazoom/sdk/model/VideoType;)V", "getType", "()Lio/datazoom/sdk/model/Event$Type;", "getMetadata", "()Ljava/util/HashMap;", "getFluxData", "getOpsMetadata", "getCustom", "getTime", "()J", "getUserDetails", "getPlayer", "getAd", "getVideo", "getVideoType", "()Lio/datazoom/sdk/model/VideoType;", "name", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "Type", "Applicability", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Event {
    private final HashMap<String, Object> ad;
    private final HashMap<String, Object> custom;
    private final HashMap<String, Object> fluxData;
    private final HashMap<String, Object> metadata;
    private final HashMap<String, Object> opsMetadata;
    private final HashMap<String, Object> player;
    private final long time;
    private final Type type;
    private final HashMap<String, Object> userDetails;
    private final HashMap<String, Object> video;
    private final VideoType videoType;

    /* JADX INFO: compiled from: Event.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/datazoom/sdk/model/Event$Applicability;", "", "<init>", "(Ljava/lang/String;I)V", "AD", "CT", "CT_AD", "SS", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum Applicability {
        AD,
        CT,
        CT_AD,
        SS;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Applicability> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Event copy$default(Event event, Type type, HashMap map, HashMap map2, HashMap map3, HashMap map4, long j, HashMap map5, HashMap map6, HashMap map7, HashMap map8, VideoType videoType, int i, Object obj) {
        if ((i & 1) != 0) {
            type = event.type;
        }
        if ((i & 2) != 0) {
            map = event.metadata;
        }
        if ((i & 4) != 0) {
            map2 = event.fluxData;
        }
        if ((i & 8) != 0) {
            map3 = event.opsMetadata;
        }
        if ((i & 16) != 0) {
            map4 = event.custom;
        }
        if ((i & 32) != 0) {
            j = event.time;
        }
        if ((i & 64) != 0) {
            map5 = event.userDetails;
        }
        if ((i & 128) != 0) {
            map6 = event.player;
        }
        if ((i & 256) != 0) {
            map7 = event.ad;
        }
        if ((i & 512) != 0) {
            map8 = event.video;
        }
        if ((i & 1024) != 0) {
            videoType = event.videoType;
        }
        VideoType videoType2 = videoType;
        HashMap map9 = map7;
        HashMap map10 = map5;
        long j2 = j;
        HashMap map11 = map3;
        HashMap map12 = map4;
        HashMap map13 = map2;
        return event.copy(type, map, map13, map11, map12, j2, map10, map6, map9, map8, videoType2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public final HashMap<String, Object> component10() {
        return this.video;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final VideoType getVideoType() {
        return this.videoType;
    }

    public final HashMap<String, Object> component2() {
        return this.metadata;
    }

    public final HashMap<String, Object> component3() {
        return this.fluxData;
    }

    public final HashMap<String, Object> component4() {
        return this.opsMetadata;
    }

    public final HashMap<String, Object> component5() {
        return this.custom;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public final HashMap<String, Object> component7() {
        return this.userDetails;
    }

    public final HashMap<String, Object> component8() {
        return this.player;
    }

    public final HashMap<String, Object> component9() {
        return this.ad;
    }

    public final Event copy(Type type, HashMap<String, Object> metadata, HashMap<String, Object> fluxData, HashMap<String, Object> opsMetadata, HashMap<String, Object> custom, long time, HashMap<String, Object> userDetails, HashMap<String, Object> player, HashMap<String, Object> ad, HashMap<String, Object> video, VideoType videoType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(fluxData, "fluxData");
        Intrinsics.checkNotNullParameter(opsMetadata, "opsMetadata");
        Intrinsics.checkNotNullParameter(custom, "custom");
        Intrinsics.checkNotNullParameter(userDetails, "userDetails");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(video, "video");
        return new Event(type, metadata, fluxData, opsMetadata, custom, time, userDetails, player, ad, video, videoType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Event)) {
            return false;
        }
        Event event = (Event) other;
        return this.type == event.type && Intrinsics.areEqual(this.metadata, event.metadata) && Intrinsics.areEqual(this.fluxData, event.fluxData) && Intrinsics.areEqual(this.opsMetadata, event.opsMetadata) && Intrinsics.areEqual(this.custom, event.custom) && this.time == event.time && Intrinsics.areEqual(this.userDetails, event.userDetails) && Intrinsics.areEqual(this.player, event.player) && Intrinsics.areEqual(this.ad, event.ad) && Intrinsics.areEqual(this.video, event.video) && Intrinsics.areEqual(this.videoType, event.videoType);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((this.type.hashCode() * 31) + this.metadata.hashCode()) * 31) + this.fluxData.hashCode()) * 31) + this.opsMetadata.hashCode()) * 31) + this.custom.hashCode()) * 31) + Long.hashCode(this.time)) * 31) + this.userDetails.hashCode()) * 31) + this.player.hashCode()) * 31) + this.ad.hashCode()) * 31) + this.video.hashCode()) * 31;
        VideoType videoType = this.videoType;
        return iHashCode + (videoType == null ? 0 : videoType.hashCode());
    }

    public String toString() {
        return "Event(type=" + this.type + ", metadata=" + this.metadata + ", fluxData=" + this.fluxData + ", opsMetadata=" + this.opsMetadata + ", custom=" + this.custom + ", time=" + this.time + ", userDetails=" + this.userDetails + ", player=" + this.player + ", ad=" + this.ad + ", video=" + this.video + ", videoType=" + this.videoType + ")";
    }

    public Event(Type type, HashMap<String, Object> metadata, HashMap<String, Object> fluxData, HashMap<String, Object> opsMetadata, HashMap<String, Object> custom, long j, HashMap<String, Object> userDetails, HashMap<String, Object> player, HashMap<String, Object> ad, HashMap<String, Object> video, VideoType videoType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(fluxData, "fluxData");
        Intrinsics.checkNotNullParameter(opsMetadata, "opsMetadata");
        Intrinsics.checkNotNullParameter(custom, "custom");
        Intrinsics.checkNotNullParameter(userDetails, "userDetails");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(video, "video");
        this.type = type;
        this.metadata = metadata;
        this.fluxData = fluxData;
        this.opsMetadata = opsMetadata;
        this.custom = custom;
        this.time = j;
        this.userDetails = userDetails;
        this.player = player;
        this.ad = ad;
        this.video = video;
        this.videoType = videoType;
    }

    public final Type getType() {
        return this.type;
    }

    public /* synthetic */ Event(Type type, HashMap map, HashMap map2, HashMap map3, HashMap map4, long j, HashMap map5, HashMap map6, HashMap map7, HashMap map8, VideoType videoType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, (i & 2) != 0 ? new HashMap() : map, (i & 4) != 0 ? new HashMap() : map2, (i & 8) != 0 ? new HashMap() : map3, (i & 16) != 0 ? new HashMap() : map4, (i & 32) != 0 ? Time.INSTANCE.now() : j, (i & 64) != 0 ? new HashMap() : map5, (i & 128) != 0 ? new HashMap() : map6, (i & 256) != 0 ? new HashMap() : map7, (i & 512) != 0 ? new HashMap() : map8, (i & 1024) != 0 ? null : videoType);
    }

    public final HashMap<String, Object> getMetadata() {
        return this.metadata;
    }

    public final HashMap<String, Object> getFluxData() {
        return this.fluxData;
    }

    public final HashMap<String, Object> getOpsMetadata() {
        return this.opsMetadata;
    }

    public final HashMap<String, Object> getCustom() {
        return this.custom;
    }

    public final long getTime() {
        return this.time;
    }

    public final HashMap<String, Object> getUserDetails() {
        return this.userDetails;
    }

    public final HashMap<String, Object> getPlayer() {
        return this.player;
    }

    public final HashMap<String, Object> getAd() {
        return this.ad;
    }

    public final HashMap<String, Object> getVideo() {
        return this.video;
    }

    public final VideoType getVideoType() {
        return this.videoType;
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BufferEnd' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: Event.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b@\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bE¨\u0006F"}, d2 = {"Lio/datazoom/sdk/model/Event$Type;", "", "value", "", "applicability", "Lio/datazoom/sdk/model/Event$Applicability;", "Lio/datazoom/sdk/model/Ap;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lio/datazoom/sdk/model/Event$Applicability;)V", "getValue", "()Ljava/lang/String;", "getApplicability", "()Lio/datazoom/sdk/model/Event$Applicability;", "AdBreakEnd", "AdBreakStart", "AdClick", "AdSkip", "AdError", "AdFluxData", "AdImpression", "AdPause", "AdPlay", "AdRenditionChanged", "AdRequest", "AudioTrackChanged", "BitrateChanged", "BufferEnd", "BufferStart", "CustomEvent", "DatazoomLoaded", "Error", "ExitFullscreen", "FluxData", "Fullscreen", "Heartbeat", "Idle", "MediaLoaded", "MediaLoadedAd", "MediaRequest", "Milestone", "Mute", "Pause", "Play", "PlayButton", "PlayButtonAd", "PlayRequest", "PlaybackCompleted", "PlaybackCompletedAd", "PlaybackError", "PlaybackStart", "PlaybackStartAd", "PlayerReady", "Playing", "QualifiedView", "QualityChangeRequest", "RenditionChange", "Resize", "Resume", "SeekEnd", "SeekPosition", "SeekStart", "SessionEnd", "SessionStart", "StallEnded", "StallStarted", "Stop", "Unmute", "VolumeChange", "CastEnd", "CastStart", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type BufferEnd;
        public static final Type FluxData;
        public static final Type Mute;
        public static final Type PlaybackCompleted;
        public static final Type PlaybackStart;
        public static final Type QualifiedView;
        public static final Type QualityChangeRequest;
        public static final Type SessionStart;
        private final Applicability applicability;
        private final String value;
        public static final Type AdBreakEnd = new Type("AdBreakEnd", 0, "ad_break_end", Applicability.AD);
        public static final Type AdBreakStart = new Type("AdBreakStart", 1, "ad_break_start", Applicability.AD);
        public static final Type AdClick = new Type("AdClick", 2, "ad_click", Applicability.AD);
        public static final Type AdSkip = new Type("AdSkip", 3, "ad_skip", Applicability.AD);
        public static final Type AdError = new Type("AdError", 4, "ad_error", Applicability.AD);
        public static final Type AdFluxData = new Type("AdFluxData", 5, "ad_fluxData", Applicability.AD);
        public static final Type AdImpression = new Type("AdImpression", 6, FirebaseAnalytics.Event.AD_IMPRESSION, Applicability.AD);
        public static final Type AdPause = new Type("AdPause", 7, "ad_pause", Applicability.AD);
        public static final Type AdPlay = new Type("AdPlay", 8, "ad_play", Applicability.AD);
        public static final Type AdRenditionChanged = new Type("AdRenditionChanged", 9, "ad_rendition_changed", Applicability.AD);
        public static final Type AdRequest = new Type("AdRequest", 10, "ad_request", Applicability.AD);
        public static final Type AudioTrackChanged = new Type("AudioTrackChanged", 11, "audio_track_changed", null, 2, null);
        public static final Type BitrateChanged = new Type("BitrateChanged", 12, "bitrate_changed", null, 2, null);
        public static final Type BufferStart = new Type("BufferStart", 14, "buffer_start", null, 2, null);
        public static final Type CustomEvent = new Type("CustomEvent", 15, "custom", null, 2, null);
        public static final Type DatazoomLoaded = new Type("DatazoomLoaded", 16, "datazoom_loaded", Applicability.SS);
        public static final Type Error = new Type("Error", 17, "error", null, 2, 0 == true ? 1 : 0);
        public static final Type ExitFullscreen = new Type("ExitFullscreen", 18, "exit_fullscreen", null, 2, null);
        public static final Type Fullscreen = new Type("Fullscreen", 20, "fullscreen", null, 2, null);
        public static final Type Heartbeat = new Type("Heartbeat", 21, "heartbeat", null, 2, null);
        public static final Type Idle = new Type("Idle", 22, "idle", null, 2, null);
        public static final Type MediaLoaded = new Type("MediaLoaded", 23, "media_loaded", null, 2, null);
        public static final Type MediaLoadedAd = new Type("MediaLoadedAd", 24, "media_loaded", Applicability.AD);
        public static final Type MediaRequest = new Type("MediaRequest", 25, "media_request", 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
        public static final Type Milestone = new Type("Milestone", 26, "milestone", null, 2, null);
        public static final Type Pause = new Type("Pause", 28, PauseEvent.TYPE, null, 2, null);
        public static final Type Play = new Type("Play", 29, PlayEvent.TYPE, null, 2, null);
        public static final Type PlayButton = new Type("PlayButton", 30, "play_btn", null, 2, null);
        public static final Type PlayButtonAd = new Type("PlayButtonAd", 31, "play_btn", Applicability.AD);
        public static final Type PlayRequest = new Type("PlayRequest", 32, "play_request", null, 2, 0 == true ? 1 : 0);
        public static final Type PlaybackCompletedAd = new Type("PlaybackCompletedAd", 34, "playback_complete", Applicability.AD);
        public static final Type PlaybackError = new Type("PlaybackError", 35, "playback_error", null, 2, null);
        public static final Type PlaybackStartAd = new Type("PlaybackStartAd", 37, "playback_start", Applicability.AD);
        public static final Type PlayerReady = new Type("PlayerReady", 38, "player_ready", Applicability.CT);
        public static final Type Playing = new Type("Playing", 39, PlayingEvent.TYPE, null, 2, null);
        public static final Type RenditionChange = new Type("RenditionChange", 42, "rendition_change", null, 2, null);
        public static final Type Resize = new Type("Resize", 43, "resize", null, 2, null);
        public static final Type Resume = new Type("Resume", 44, "resume", null, 2, null);
        public static final Type SeekEnd = new Type("SeekEnd", 45, "seek_end", null, 2, null);
        public static final Type SeekPosition = new Type("SeekPosition", 46, "seek_position", null, 2, null);
        public static final Type SeekStart = new Type("SeekStart", 47, "seek_start", null, 2, 0 == true ? 1 : 0);
        public static final Type SessionEnd = new Type("SessionEnd", 48, "session_end", null, 2, null);
        public static final Type StallEnded = new Type("StallEnded", 50, "stall_end", null, 2, null);
        public static final Type StallStarted = new Type("StallStarted", 51, "stall_start", null, 2, null);
        public static final Type Stop = new Type("Stop", 52, "stop", null, 2, null);
        public static final Type Unmute = new Type("Unmute", 53, "unmute", null, 2, null);
        public static final Type VolumeChange = new Type("VolumeChange", 54, "volume_change", null, 2, null);
        public static final Type CastEnd = new Type("CastEnd", 55, "cast_end", null, 2, 0 == true ? 1 : 0);
        public static final Type CastStart = new Type("CastStart", 56, "cast_start", null, 2, null);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{AdBreakEnd, AdBreakStart, AdClick, AdSkip, AdError, AdFluxData, AdImpression, AdPause, AdPlay, AdRenditionChanged, AdRequest, AudioTrackChanged, BitrateChanged, BufferEnd, BufferStart, CustomEvent, DatazoomLoaded, Error, ExitFullscreen, FluxData, Fullscreen, Heartbeat, Idle, MediaLoaded, MediaLoadedAd, MediaRequest, Milestone, Mute, Pause, Play, PlayButton, PlayButtonAd, PlayRequest, PlaybackCompleted, PlaybackCompletedAd, PlaybackError, PlaybackStart, PlaybackStartAd, PlayerReady, Playing, QualifiedView, QualityChangeRequest, RenditionChange, Resize, Resume, SeekEnd, SeekPosition, SeekStart, SessionEnd, SessionStart, StallEnded, StallStarted, Stop, Unmute, VolumeChange, CastEnd, CastStart};
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String str, int i, String str2, Applicability applicability) {
            super(str, i);
            this.value = str2;
            this.applicability = applicability;
        }

        /* synthetic */ Type(String str, int i, String str2, Applicability applicability, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, (i2 & 2) != 0 ? Applicability.CT_AD : applicability);
        }

        public final Applicability getApplicability() {
            return this.applicability;
        }

        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: Multi-variable type inference failed */
        static {
            DefaultConstructorMarker defaultConstructorMarker = null;
            BufferEnd = new Type("BufferEnd", 13, "buffer_end", null, 2, defaultConstructorMarker);
            FluxData = new Type("FluxData", 19, "FluxData", null, 2, defaultConstructorMarker);
            Mute = new Type("Mute", 27, "mute", null, 2, defaultConstructorMarker);
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            PlaybackCompleted = new Type("PlaybackCompleted", 33, "playback_complete", null, 2, defaultConstructorMarker2);
            PlaybackStart = new Type("PlaybackStart", 36, "playback_start", null, 2, defaultConstructorMarker2);
            QualifiedView = new Type("QualifiedView", 40, "qualified_view", null, 2, defaultConstructorMarker2);
            QualityChangeRequest = new Type("QualityChangeRequest", 41, "quality_change_request", null, 2, defaultConstructorMarker);
            SessionStart = new Type("SessionStart", 49, "session_start", null, 2, defaultConstructorMarker);
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }
    }

    public final String getName() {
        if (this.type == Type.CustomEvent) {
            Object obj = this.metadata.get("CustomEvent.event");
            if (obj == null) {
                obj = "event";
            }
            this.metadata.remove("CustomEvent.event");
            return "custom_" + obj;
        }
        return this.type.getValue();
    }
}
