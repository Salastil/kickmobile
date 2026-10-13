package expo.modules.medialibrary;

import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MediaLibraryEnums.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lexpo/modules/medialibrary/SortBy;", "", "keyName", "", "mediaColumnName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getKeyName", "()Ljava/lang/String;", "getMediaColumnName", "DEFAULT", "CREATION_TIME", "MODIFICATION_TIME", "MEDIA_TYPE", "WIDTH", "HEIGHT", "DURATION", "Companion", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum SortBy {
    DEFAULT(Constants.COLLATION_DEFAULT, "_id"),
    CREATION_TIME("creationTime", "datetaken"),
    MODIFICATION_TIME("modificationTime", "date_modified"),
    MEDIA_TYPE("mediaType", "media_type"),
    WIDTH(ViewProps.WIDTH, ViewProps.WIDTH),
    HEIGHT(ViewProps.HEIGHT, ViewProps.HEIGHT),
    DURATION("duration", "duration");

    private final String keyName;
    private final String mediaColumnName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<SortBy> getEntries() {
        return $ENTRIES;
    }

    SortBy(String str, String str2) {
        this.keyName = str;
        this.mediaColumnName = str2;
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public final String getMediaColumnName() {
        return this.mediaColumnName;
    }

    /* JADX INFO: compiled from: MediaLibraryEnums.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lexpo/modules/medialibrary/SortBy$Companion;", "", "<init>", "()V", "getConstants", "", "", "fromKeyName", "Lexpo/modules/medialibrary/SortBy;", "keyName", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, String> getConstants() {
            SortBy[] sortByArrValues = SortBy.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(sortByArrValues.length), 16));
            for (SortBy sortBy : sortByArrValues) {
                Pair pair = new Pair(sortBy.getKeyName(), sortBy.getKeyName());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }

        public final SortBy fromKeyName(String keyName) {
            Intrinsics.checkNotNullParameter(keyName, "keyName");
            for (SortBy sortBy : SortBy.values()) {
                if (Intrinsics.areEqual(sortBy.getKeyName(), keyName)) {
                    return sortBy;
                }
            }
            return null;
        }
    }
}
