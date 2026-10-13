package io.datazoom.sdk.ad;

import com.datadog.android.rum.internal.utils.ViewUtilsKt;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import io.ktor.http.HttpHeaders;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DzAd.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001CB£\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0011HÆ\u0003J\t\u0010:\u001a\u00020\u0013HÆ\u0003J\t\u0010;\u001a\u00020\u0013HÆ\u0003J\u0017\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016HÆ\u0003JÁ\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016HÆ\u0001J\u0014\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010A\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010B\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u001f\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006D"}, d2 = {"Lio/datazoom/sdk/ad/DzAd;", "", "id", "", "progress", "", "duration", "advertiserName", "adSystem", "creativeId", "skipTimeOffset", "wrapperIds", "", "wrapperCreativeId", "wrapperAdSystem", "adClickUrl", ViewProps.POSITION, "Lio/datazoom/sdk/ad/DzAd$Position;", "adPosition", "", "totalAds", "customData", "", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lio/datazoom/sdk/ad/DzAd$Position;IILjava/util/Map;)V", "getId", "()Ljava/lang/String;", "getProgress", "()J", "getDuration", "getAdvertiserName", "getAdSystem", "getCreativeId", "getSkipTimeOffset", "getWrapperIds", "()Ljava/util/List;", "getWrapperCreativeId", "getWrapperAdSystem", "getAdClickUrl", "getPosition", "()Lio/datazoom/sdk/ad/DzAd$Position;", "getAdPosition", "()I", "getTotalAds", "getCustomData", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "toString", HttpHeaders.Position, Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DzAd {
    private final String adClickUrl;
    private final int adPosition;
    private final String adSystem;
    private final String advertiserName;
    private final String creativeId;
    private final Map<String, Object> customData;
    private final long duration;
    private final String id;
    private final Position position;
    private final long progress;
    private final long skipTimeOffset;
    private final int totalAds;
    private final List<String> wrapperAdSystem;
    private final List<String> wrapperCreativeId;
    private final List<String> wrapperIds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DzAd copy$default(DzAd dzAd, String str, long j, long j2, String str2, String str3, String str4, long j3, List list, List list2, List list3, String str5, Position position, int i, int i2, Map map, int i3, Object obj) {
        String str6 = (i3 & 1) != 0 ? dzAd.id : str;
        return dzAd.copy(str6, (i3 & 2) != 0 ? dzAd.progress : j, (i3 & 4) != 0 ? dzAd.duration : j2, (i3 & 8) != 0 ? dzAd.advertiserName : str2, (i3 & 16) != 0 ? dzAd.adSystem : str3, (i3 & 32) != 0 ? dzAd.creativeId : str4, (i3 & 64) != 0 ? dzAd.skipTimeOffset : j3, (i3 & 128) != 0 ? dzAd.wrapperIds : list, (i3 & 256) != 0 ? dzAd.wrapperCreativeId : list2, (i3 & 512) != 0 ? dzAd.wrapperAdSystem : list3, (i3 & 1024) != 0 ? dzAd.adClickUrl : str5, (i3 & 2048) != 0 ? dzAd.position : position, (i3 & 4096) != 0 ? dzAd.adPosition : i, (i3 & 8192) != 0 ? dzAd.totalAds : i2, (i3 & 16384) != 0 ? dzAd.customData : map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<String> component10() {
        return this.wrapperAdSystem;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getAdClickUrl() {
        return this.adClickUrl;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Position getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getAdPosition() {
        return this.adPosition;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getTotalAds() {
        return this.totalAds;
    }

    public final Map<String, Object> component15() {
        return this.customData;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getProgress() {
        return this.progress;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAdvertiserName() {
        return this.advertiserName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAdSystem() {
        return this.adSystem;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCreativeId() {
        return this.creativeId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getSkipTimeOffset() {
        return this.skipTimeOffset;
    }

    public final List<String> component8() {
        return this.wrapperIds;
    }

    public final List<String> component9() {
        return this.wrapperCreativeId;
    }

    public final DzAd copy(String id, long progress, long duration, String advertiserName, String adSystem, String creativeId, long skipTimeOffset, List<String> wrapperIds, List<String> wrapperCreativeId, List<String> wrapperAdSystem, String adClickUrl, Position position, int adPosition, int totalAds, Map<String, ? extends Object> customData) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(advertiserName, "advertiserName");
        Intrinsics.checkNotNullParameter(adSystem, "adSystem");
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        Intrinsics.checkNotNullParameter(wrapperIds, "wrapperIds");
        Intrinsics.checkNotNullParameter(wrapperCreativeId, "wrapperCreativeId");
        Intrinsics.checkNotNullParameter(wrapperAdSystem, "wrapperAdSystem");
        Intrinsics.checkNotNullParameter(position, "position");
        return new DzAd(id, progress, duration, advertiserName, adSystem, creativeId, skipTimeOffset, wrapperIds, wrapperCreativeId, wrapperAdSystem, adClickUrl, position, adPosition, totalAds, customData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DzAd)) {
            return false;
        }
        DzAd dzAd = (DzAd) other;
        return Intrinsics.areEqual(this.id, dzAd.id) && this.progress == dzAd.progress && this.duration == dzAd.duration && Intrinsics.areEqual(this.advertiserName, dzAd.advertiserName) && Intrinsics.areEqual(this.adSystem, dzAd.adSystem) && Intrinsics.areEqual(this.creativeId, dzAd.creativeId) && this.skipTimeOffset == dzAd.skipTimeOffset && Intrinsics.areEqual(this.wrapperIds, dzAd.wrapperIds) && Intrinsics.areEqual(this.wrapperCreativeId, dzAd.wrapperCreativeId) && Intrinsics.areEqual(this.wrapperAdSystem, dzAd.wrapperAdSystem) && Intrinsics.areEqual(this.adClickUrl, dzAd.adClickUrl) && Intrinsics.areEqual(this.position, dzAd.position) && this.adPosition == dzAd.adPosition && this.totalAds == dzAd.totalAds && Intrinsics.areEqual(this.customData, dzAd.customData);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((this.id.hashCode() * 31) + Long.hashCode(this.progress)) * 31) + Long.hashCode(this.duration)) * 31) + this.advertiserName.hashCode()) * 31) + this.adSystem.hashCode()) * 31) + this.creativeId.hashCode()) * 31) + Long.hashCode(this.skipTimeOffset)) * 31) + this.wrapperIds.hashCode()) * 31) + this.wrapperCreativeId.hashCode()) * 31) + this.wrapperAdSystem.hashCode()) * 31;
        String str = this.adClickUrl;
        int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.position.hashCode()) * 31) + Integer.hashCode(this.adPosition)) * 31) + Integer.hashCode(this.totalAds)) * 31;
        Map<String, Object> map = this.customData;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "DzAd(id=" + this.id + ", progress=" + this.progress + ", duration=" + this.duration + ", advertiserName=" + this.advertiserName + ", adSystem=" + this.adSystem + ", creativeId=" + this.creativeId + ", skipTimeOffset=" + this.skipTimeOffset + ", wrapperIds=" + this.wrapperIds + ", wrapperCreativeId=" + this.wrapperCreativeId + ", wrapperAdSystem=" + this.wrapperAdSystem + ", adClickUrl=" + this.adClickUrl + ", position=" + this.position + ", adPosition=" + this.adPosition + ", totalAds=" + this.totalAds + ", customData=" + this.customData + ")";
    }

    public DzAd(String id, long j, long j2, String advertiserName, String adSystem, String creativeId, long j3, List<String> wrapperIds, List<String> wrapperCreativeId, List<String> wrapperAdSystem, String str, Position position, int i, int i2, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(advertiserName, "advertiserName");
        Intrinsics.checkNotNullParameter(adSystem, "adSystem");
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        Intrinsics.checkNotNullParameter(wrapperIds, "wrapperIds");
        Intrinsics.checkNotNullParameter(wrapperCreativeId, "wrapperCreativeId");
        Intrinsics.checkNotNullParameter(wrapperAdSystem, "wrapperAdSystem");
        Intrinsics.checkNotNullParameter(position, "position");
        this.id = id;
        this.progress = j;
        this.duration = j2;
        this.advertiserName = advertiserName;
        this.adSystem = adSystem;
        this.creativeId = creativeId;
        this.skipTimeOffset = j3;
        this.wrapperIds = wrapperIds;
        this.wrapperCreativeId = wrapperCreativeId;
        this.wrapperAdSystem = wrapperAdSystem;
        this.adClickUrl = str;
        this.position = position;
        this.adPosition = i;
        this.totalAds = i2;
        this.customData = map;
    }

    public /* synthetic */ DzAd(String str, long j, long j2, String str2, String str3, String str4, long j3, List list, List list2, List list3, String str5, Position position, int i, int i2, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, str2, str3, str4, j3, list, list2, list3, str5, position, i, i2, (i3 & 16384) != 0 ? null : map);
    }

    public final String getId() {
        return this.id;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getAdvertiserName() {
        return this.advertiserName;
    }

    public final String getAdSystem() {
        return this.adSystem;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final long getSkipTimeOffset() {
        return this.skipTimeOffset;
    }

    public final List<String> getWrapperIds() {
        return this.wrapperIds;
    }

    public final List<String> getWrapperCreativeId() {
        return this.wrapperCreativeId;
    }

    public final List<String> getWrapperAdSystem() {
        return this.wrapperAdSystem;
    }

    public final String getAdClickUrl() {
        return this.adClickUrl;
    }

    public final Position getPosition() {
        return this.position;
    }

    public final int getAdPosition() {
        return this.adPosition;
    }

    public final int getTotalAds() {
        return this.totalAds;
    }

    public final Map<String, Object> getCustomData() {
        return this.customData;
    }

    /* JADX INFO: compiled from: DzAd.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lio/datazoom/sdk/ad/DzAd$Position;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "PreRoll", "MidRoll", "PostRoll", ViewUtilsKt.UNKNOWN_DESTINATION_URL, "Lio/datazoom/sdk/ad/DzAd$Position$MidRoll;", "Lio/datazoom/sdk/ad/DzAd$Position$PostRoll;", "Lio/datazoom/sdk/ad/DzAd$Position$PreRoll;", "Lio/datazoom/sdk/ad/DzAd$Position$Unknown;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class Position {
        private final String name;

        public /* synthetic */ Position(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        /* JADX INFO: compiled from: DzAd.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/ad/DzAd$Position$PreRoll;", "Lio/datazoom/sdk/ad/DzAd$Position;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class PreRoll extends Position {
            public static final PreRoll INSTANCE = new PreRoll();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PreRoll)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2000888190;
            }

            public String toString() {
                return "PreRoll";
            }

            private PreRoll() {
                super("pre", null);
            }
        }

        private Position(String str) {
            this.name = str;
        }

        public final String getName() {
            return this.name;
        }

        /* JADX INFO: compiled from: DzAd.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/ad/DzAd$Position$MidRoll;", "Lio/datazoom/sdk/ad/DzAd$Position;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class MidRoll extends Position {
            public static final MidRoll INSTANCE = new MidRoll();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MidRoll)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -627017817;
            }

            public String toString() {
                return "MidRoll";
            }

            private MidRoll() {
                super("mid", null);
            }
        }

        /* JADX INFO: compiled from: DzAd.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/ad/DzAd$Position$PostRoll;", "Lio/datazoom/sdk/ad/DzAd$Position;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class PostRoll extends Position {
            public static final PostRoll INSTANCE = new PostRoll();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PostRoll)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 165811387;
            }

            public String toString() {
                return "PostRoll";
            }

            private PostRoll() {
                super("post", null);
            }
        }

        /* JADX INFO: compiled from: DzAd.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/ad/DzAd$Position$Unknown;", "Lio/datazoom/sdk/ad/DzAd$Position;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class Unknown extends Position {
            public static final Unknown INSTANCE = new Unknown();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Unknown)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1966478068;
            }

            public String toString() {
                return ViewUtilsKt.UNKNOWN_DESTINATION_URL;
            }

            private Unknown() {
                super("unknown", null);
            }
        }
    }
}
