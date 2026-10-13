package expo.modules.medialibrary.next.objects.asset.domain;

import android.database.Cursor;
import android.os.Build;
import com.google.firebase.messaging.Constants;
import expo.modules.medialibrary.next.extensions.CursorExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaStoreAudio.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018J`\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\n\u0010\u0018¨\u0006)"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudio;", "", "id", "", "displayName", "", "dateTaken", "dateModified", "duration", "data", "isFavorite", "", "<init>", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()J", "getDisplayName", "()Ljava/lang/String;", "getDateTaken", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDateModified", "getDuration", "getData", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudio;", "equals", "", "other", "hashCode", "toString", "Companion", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MediaStoreAudio {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] projection;
    private final String data;
    private final Long dateModified;
    private final Long dateTaken;
    private final String displayName;
    private final Long duration;
    private final long id;
    private final Integer isFavorite;

    public static /* synthetic */ MediaStoreAudio copy$default(MediaStoreAudio mediaStoreAudio, long j, String str, Long l, Long l2, Long l3, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            j = mediaStoreAudio.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = mediaStoreAudio.displayName;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            l = mediaStoreAudio.dateTaken;
        }
        Long l4 = l;
        if ((i & 8) != 0) {
            l2 = mediaStoreAudio.dateModified;
        }
        Long l5 = l2;
        if ((i & 16) != 0) {
            l3 = mediaStoreAudio.duration;
        }
        return mediaStoreAudio.copy(j2, str3, l4, l5, l3, (i & 32) != 0 ? mediaStoreAudio.data : str2, (i & 64) != 0 ? mediaStoreAudio.isFavorite : num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getDateTaken() {
        return this.dateTaken;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getDateModified() {
        return this.dateModified;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getIsFavorite() {
        return this.isFavorite;
    }

    public final MediaStoreAudio copy(long id, String displayName, Long dateTaken, Long dateModified, Long duration, String data, Integer isFavorite) {
        return new MediaStoreAudio(id, displayName, dateTaken, dateModified, duration, data, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaStoreAudio)) {
            return false;
        }
        MediaStoreAudio mediaStoreAudio = (MediaStoreAudio) other;
        return this.id == mediaStoreAudio.id && Intrinsics.areEqual(this.displayName, mediaStoreAudio.displayName) && Intrinsics.areEqual(this.dateTaken, mediaStoreAudio.dateTaken) && Intrinsics.areEqual(this.dateModified, mediaStoreAudio.dateModified) && Intrinsics.areEqual(this.duration, mediaStoreAudio.duration) && Intrinsics.areEqual(this.data, mediaStoreAudio.data) && Intrinsics.areEqual(this.isFavorite, mediaStoreAudio.isFavorite);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.displayName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.dateTaken;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.dateModified;
        int iHashCode4 = (iHashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.duration;
        int iHashCode5 = (iHashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str2 = this.data;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.isFavorite;
        return iHashCode6 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "MediaStoreAudio(id=" + this.id + ", displayName=" + this.displayName + ", dateTaken=" + this.dateTaken + ", dateModified=" + this.dateModified + ", duration=" + this.duration + ", data=" + this.data + ", isFavorite=" + this.isFavorite + ")";
    }

    public MediaStoreAudio(long j, String str, Long l, Long l2, Long l3, String str2, Integer num) {
        this.id = j;
        this.displayName = str;
        this.dateTaken = l;
        this.dateModified = l2;
        this.duration = l3;
        this.data = str2;
        this.isFavorite = num;
    }

    public final long getId() {
        return this.id;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Long getDateTaken() {
        return this.dateTaken;
    }

    public final Long getDateModified() {
        return this.dateModified;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getData() {
        return this.data;
    }

    public final Integer isFavorite() {
        return this.isFavorite;
    }

    /* JADX INFO: compiled from: MediaStoreAudio.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudio$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudio;", "cursor", "Landroid/database/Cursor;", "columnIndexes", "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudioColumnIndexes;", "projection", "", "", "getProjection", "()[Ljava/lang/String;", "[Ljava/lang/String;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MediaStoreAudio from$default(Companion companion, Cursor cursor, MediaStoreAudioColumnIndexes mediaStoreAudioColumnIndexes, int i, Object obj) {
            if ((i & 2) != 0) {
                mediaStoreAudioColumnIndexes = MediaStoreAudioColumnIndexes.INSTANCE.from(cursor);
            }
            return companion.from(cursor, mediaStoreAudioColumnIndexes);
        }

        public final MediaStoreAudio from(Cursor cursor, MediaStoreAudioColumnIndexes columnIndexes) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            Intrinsics.checkNotNullParameter(columnIndexes, "columnIndexes");
            long j = cursor.getLong(columnIndexes.getId());
            String nullableString = CursorExtensionsKt.getNullableString(cursor, columnIndexes.getDisplayName());
            Long nullableLong = CursorExtensionsKt.getNullableLong(cursor, columnIndexes.getDateTaken());
            Long nullableLong2 = CursorExtensionsKt.getNullableLong(cursor, columnIndexes.getDateModified());
            Long nullableLong3 = CursorExtensionsKt.getNullableLong(cursor, columnIndexes.getDuration());
            String nullableString2 = CursorExtensionsKt.getNullableString(cursor, columnIndexes.getData());
            Integer numIsFavorite = columnIndexes.isFavorite();
            return new MediaStoreAudio(j, nullableString, nullableLong, nullableLong2, nullableLong3, nullableString2, numIsFavorite != null ? CursorExtensionsKt.getNullableInt(cursor, numIsFavorite.intValue()) : null);
        }

        public final String[] getProjection() {
            return MediaStoreAudio.projection;
        }
    }

    static {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add("_id");
        listCreateListBuilder.add("_display_name");
        listCreateListBuilder.add("datetaken");
        listCreateListBuilder.add("date_modified");
        listCreateListBuilder.add("_data");
        listCreateListBuilder.add("duration");
        if (Build.VERSION.SDK_INT >= 30) {
            listCreateListBuilder.add("is_favorite");
        }
        projection = (String[]) CollectionsKt.build(listCreateListBuilder).toArray(new String[0]);
    }
}
