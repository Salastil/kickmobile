package expo.modules.medialibrary.next.objects.asset.domain;

import android.database.Cursor;
import android.os.Build;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import expo.modules.medialibrary.next.extensions.CursorExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaStoreVideo.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00011Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0084\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\tHÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u000e\u0010\u001a¨\u00062"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreVideo;", "", "id", "", "displayName", "", "dateTaken", "dateModified", ViewProps.WIDTH, "", ViewProps.HEIGHT, "orientation", "duration", "data", "isFavorite", "<init>", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()J", "getDisplayName", "()Ljava/lang/String;", "getDateTaken", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDateModified", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getOrientation", "getDuration", "getData", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreVideo;", "equals", "", "other", "hashCode", "toString", "Companion", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MediaStoreVideo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] projection;
    private final String data;
    private final Long dateModified;
    private final Long dateTaken;
    private final String displayName;
    private final Long duration;
    private final Integer height;
    private final long id;
    private final Integer isFavorite;
    private final Integer orientation;
    private final Integer width;

    public static /* synthetic */ MediaStoreVideo copy$default(MediaStoreVideo mediaStoreVideo, long j, String str, Long l, Long l2, Integer num, Integer num2, Integer num3, Long l3, String str2, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = mediaStoreVideo.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = mediaStoreVideo.displayName;
        }
        return mediaStoreVideo.copy(j2, str, (i & 4) != 0 ? mediaStoreVideo.dateTaken : l, (i & 8) != 0 ? mediaStoreVideo.dateModified : l2, (i & 16) != 0 ? mediaStoreVideo.width : num, (i & 32) != 0 ? mediaStoreVideo.height : num2, (i & 64) != 0 ? mediaStoreVideo.orientation : num3, (i & 128) != 0 ? mediaStoreVideo.duration : l3, (i & 256) != 0 ? mediaStoreVideo.data : str2, (i & 512) != 0 ? mediaStoreVideo.isFavorite : num4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getIsFavorite() {
        return this.isFavorite;
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
    public final Integer getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getOrientation() {
        return this.orientation;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getData() {
        return this.data;
    }

    public final MediaStoreVideo copy(long id, String displayName, Long dateTaken, Long dateModified, Integer width, Integer height, Integer orientation, Long duration, String data, Integer isFavorite) {
        return new MediaStoreVideo(id, displayName, dateTaken, dateModified, width, height, orientation, duration, data, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaStoreVideo)) {
            return false;
        }
        MediaStoreVideo mediaStoreVideo = (MediaStoreVideo) other;
        return this.id == mediaStoreVideo.id && Intrinsics.areEqual(this.displayName, mediaStoreVideo.displayName) && Intrinsics.areEqual(this.dateTaken, mediaStoreVideo.dateTaken) && Intrinsics.areEqual(this.dateModified, mediaStoreVideo.dateModified) && Intrinsics.areEqual(this.width, mediaStoreVideo.width) && Intrinsics.areEqual(this.height, mediaStoreVideo.height) && Intrinsics.areEqual(this.orientation, mediaStoreVideo.orientation) && Intrinsics.areEqual(this.duration, mediaStoreVideo.duration) && Intrinsics.areEqual(this.data, mediaStoreVideo.data) && Intrinsics.areEqual(this.isFavorite, mediaStoreVideo.isFavorite);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
        String str = this.displayName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.dateTaken;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.dateModified;
        int iHashCode4 = (iHashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num = this.width;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.height;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.orientation;
        int iHashCode7 = (iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Long l3 = this.duration;
        int iHashCode8 = (iHashCode7 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str2 = this.data;
        int iHashCode9 = (iHashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num4 = this.isFavorite;
        return iHashCode9 + (num4 != null ? num4.hashCode() : 0);
    }

    public String toString() {
        return "MediaStoreVideo(id=" + this.id + ", displayName=" + this.displayName + ", dateTaken=" + this.dateTaken + ", dateModified=" + this.dateModified + ", width=" + this.width + ", height=" + this.height + ", orientation=" + this.orientation + ", duration=" + this.duration + ", data=" + this.data + ", isFavorite=" + this.isFavorite + ")";
    }

    public MediaStoreVideo(long j, String str, Long l, Long l2, Integer num, Integer num2, Integer num3, Long l3, String str2, Integer num4) {
        this.id = j;
        this.displayName = str;
        this.dateTaken = l;
        this.dateModified = l2;
        this.width = num;
        this.height = num2;
        this.orientation = num3;
        this.duration = l3;
        this.data = str2;
        this.isFavorite = num4;
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

    public final Integer getWidth() {
        return this.width;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getOrientation() {
        return this.orientation;
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

    /* JADX INFO: compiled from: MediaStoreVideo.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreVideo$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreVideo;", "cursor", "Landroid/database/Cursor;", "columnIndexes", "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreVideoColumnIndexes;", "projection", "", "", "getProjection", "()[Ljava/lang/String;", "[Ljava/lang/String;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MediaStoreVideo from$default(Companion companion, Cursor cursor, MediaStoreVideoColumnIndexes mediaStoreVideoColumnIndexes, int i, Object obj) {
            if ((i & 2) != 0) {
                mediaStoreVideoColumnIndexes = MediaStoreVideoColumnIndexes.INSTANCE.from(cursor);
            }
            return companion.from(cursor, mediaStoreVideoColumnIndexes);
        }

        public final MediaStoreVideo from(Cursor cursor, MediaStoreVideoColumnIndexes columnIndexes) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            Intrinsics.checkNotNullParameter(columnIndexes, "columnIndexes");
            long j = cursor.getLong(columnIndexes.getId());
            String nullableString = CursorExtensionsKt.getNullableString(cursor, columnIndexes.getDisplayName());
            Long nullableLong = CursorExtensionsKt.getNullableLong(cursor, columnIndexes.getDateTaken());
            Long nullableLong2 = CursorExtensionsKt.getNullableLong(cursor, columnIndexes.getDateModified());
            Integer nullableInt = CursorExtensionsKt.getNullableInt(cursor, columnIndexes.getWidth());
            Integer nullableInt2 = CursorExtensionsKt.getNullableInt(cursor, columnIndexes.getHeight());
            Integer orientation = columnIndexes.getOrientation();
            Integer nullableInt3 = orientation != null ? CursorExtensionsKt.getNullableInt(cursor, orientation.intValue()) : null;
            Long nullableLong3 = CursorExtensionsKt.getNullableLong(cursor, columnIndexes.getDuration());
            String nullableString2 = CursorExtensionsKt.getNullableString(cursor, columnIndexes.getData());
            Integer numIsFavorite = columnIndexes.isFavorite();
            return new MediaStoreVideo(j, nullableString, nullableLong, nullableLong2, nullableInt, nullableInt2, nullableInt3, nullableLong3, nullableString2, numIsFavorite != null ? CursorExtensionsKt.getNullableInt(cursor, numIsFavorite.intValue()) : null);
        }

        public final String[] getProjection() {
            return MediaStoreVideo.projection;
        }
    }

    static {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add("_id");
        listCreateListBuilder.add("_display_name");
        listCreateListBuilder.add("datetaken");
        listCreateListBuilder.add("date_modified");
        listCreateListBuilder.add(ViewProps.WIDTH);
        listCreateListBuilder.add(ViewProps.HEIGHT);
        listCreateListBuilder.add("_data");
        listCreateListBuilder.add("duration");
        if (Build.VERSION.SDK_INT >= 29) {
            listCreateListBuilder.add("orientation");
        }
        if (Build.VERSION.SDK_INT >= 30) {
            listCreateListBuilder.add("is_favorite");
        }
        projection = (String[]) CollectionsKt.build(listCreateListBuilder).toArray(new String[0]);
    }
}
