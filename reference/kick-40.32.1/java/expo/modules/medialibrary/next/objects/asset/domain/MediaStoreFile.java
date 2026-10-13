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

/* JADX INFO: compiled from: MediaStoreFile.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00011Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0084\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\tHÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016R\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001f\u0010\u001aR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u000e\u0010\u001a¨\u00062"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreFile;", "", "id", "", "displayName", "", "dateTaken", "dateModified", ViewProps.WIDTH, "", ViewProps.HEIGHT, "orientation", "duration", "mediaType", "isFavorite", "<init>", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()J", "getDisplayName", "()Ljava/lang/String;", "getDateTaken", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDateModified", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getOrientation", "getDuration", "getMediaType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreFile;", "equals", "", "other", "hashCode", "toString", "Companion", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MediaStoreFile {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] projection;
    private final Long dateModified;
    private final Long dateTaken;
    private final String displayName;
    private final Long duration;
    private final Integer height;
    private final long id;
    private final Integer isFavorite;
    private final Integer mediaType;
    private final Integer orientation;
    private final Integer width;

    public static /* synthetic */ MediaStoreFile copy$default(MediaStoreFile mediaStoreFile, long j, String str, Long l, Long l2, Integer num, Integer num2, Integer num3, Long l3, Integer num4, Integer num5, int i, Object obj) {
        if ((i & 1) != 0) {
            j = mediaStoreFile.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = mediaStoreFile.displayName;
        }
        return mediaStoreFile.copy(j2, str, (i & 4) != 0 ? mediaStoreFile.dateTaken : l, (i & 8) != 0 ? mediaStoreFile.dateModified : l2, (i & 16) != 0 ? mediaStoreFile.width : num, (i & 32) != 0 ? mediaStoreFile.height : num2, (i & 64) != 0 ? mediaStoreFile.orientation : num3, (i & 128) != 0 ? mediaStoreFile.duration : l3, (i & 256) != 0 ? mediaStoreFile.mediaType : num4, (i & 512) != 0 ? mediaStoreFile.isFavorite : num5);
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
    public final Integer getMediaType() {
        return this.mediaType;
    }

    public final MediaStoreFile copy(long id, String displayName, Long dateTaken, Long dateModified, Integer width, Integer height, Integer orientation, Long duration, Integer mediaType, Integer isFavorite) {
        return new MediaStoreFile(id, displayName, dateTaken, dateModified, width, height, orientation, duration, mediaType, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaStoreFile)) {
            return false;
        }
        MediaStoreFile mediaStoreFile = (MediaStoreFile) other;
        return this.id == mediaStoreFile.id && Intrinsics.areEqual(this.displayName, mediaStoreFile.displayName) && Intrinsics.areEqual(this.dateTaken, mediaStoreFile.dateTaken) && Intrinsics.areEqual(this.dateModified, mediaStoreFile.dateModified) && Intrinsics.areEqual(this.width, mediaStoreFile.width) && Intrinsics.areEqual(this.height, mediaStoreFile.height) && Intrinsics.areEqual(this.orientation, mediaStoreFile.orientation) && Intrinsics.areEqual(this.duration, mediaStoreFile.duration) && Intrinsics.areEqual(this.mediaType, mediaStoreFile.mediaType) && Intrinsics.areEqual(this.isFavorite, mediaStoreFile.isFavorite);
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
        Integer num4 = this.mediaType;
        int iHashCode9 = (iHashCode8 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.isFavorite;
        return iHashCode9 + (num5 != null ? num5.hashCode() : 0);
    }

    public String toString() {
        return "MediaStoreFile(id=" + this.id + ", displayName=" + this.displayName + ", dateTaken=" + this.dateTaken + ", dateModified=" + this.dateModified + ", width=" + this.width + ", height=" + this.height + ", orientation=" + this.orientation + ", duration=" + this.duration + ", mediaType=" + this.mediaType + ", isFavorite=" + this.isFavorite + ")";
    }

    public MediaStoreFile(long j, String str, Long l, Long l2, Integer num, Integer num2, Integer num3, Long l3, Integer num4, Integer num5) {
        this.id = j;
        this.displayName = str;
        this.dateTaken = l;
        this.dateModified = l2;
        this.width = num;
        this.height = num2;
        this.orientation = num3;
        this.duration = l3;
        this.mediaType = num4;
        this.isFavorite = num5;
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

    public final Integer getMediaType() {
        return this.mediaType;
    }

    public final Integer isFavorite() {
        return this.isFavorite;
    }

    /* JADX INFO: compiled from: MediaStoreFile.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreFile$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreFile;", "cursor", "Landroid/database/Cursor;", "columnIndexes", "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreFileColumnIndexes;", "projection", "", "", "getProjection", "()[Ljava/lang/String;", "[Ljava/lang/String;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MediaStoreFile from$default(Companion companion, Cursor cursor, MediaStoreFileColumnIndexes mediaStoreFileColumnIndexes, int i, Object obj) {
            if ((i & 2) != 0) {
                mediaStoreFileColumnIndexes = MediaStoreFileColumnIndexes.INSTANCE.from(cursor);
            }
            return companion.from(cursor, mediaStoreFileColumnIndexes);
        }

        public final MediaStoreFile from(Cursor cursor, MediaStoreFileColumnIndexes columnIndexes) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            Intrinsics.checkNotNullParameter(columnIndexes, "columnIndexes");
            long j = cursor.getLong(columnIndexes.getId());
            String nullableString = CursorExtensionsKt.getNullableString(cursor, columnIndexes.getDisplayName());
            Long nullableLong = CursorExtensionsKt.getNullableLong(cursor, columnIndexes.getDateTaken());
            Long nullableLong2 = CursorExtensionsKt.getNullableLong(cursor, columnIndexes.getDateModified());
            Integer nullableInt = CursorExtensionsKt.getNullableInt(cursor, columnIndexes.getWidth());
            Integer nullableInt2 = CursorExtensionsKt.getNullableInt(cursor, columnIndexes.getHeight());
            Integer nullableInt3 = CursorExtensionsKt.getNullableInt(cursor, columnIndexes.getOrientation());
            Integer duration = columnIndexes.getDuration();
            Long nullableLong3 = duration != null ? CursorExtensionsKt.getNullableLong(cursor, duration.intValue()) : null;
            Integer nullableInt4 = CursorExtensionsKt.getNullableInt(cursor, columnIndexes.getMediaType());
            Integer numIsFavorite = columnIndexes.isFavorite();
            return new MediaStoreFile(j, nullableString, nullableLong, nullableLong2, nullableInt, nullableInt2, nullableInt3, nullableLong3, nullableInt4, numIsFavorite != null ? CursorExtensionsKt.getNullableInt(cursor, numIsFavorite.intValue()) : null);
        }

        public final String[] getProjection() {
            return MediaStoreFile.projection;
        }
    }

    static {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add("media_type");
        listCreateListBuilder.add("_id");
        listCreateListBuilder.add("_display_name");
        listCreateListBuilder.add("datetaken");
        listCreateListBuilder.add("date_modified");
        listCreateListBuilder.add(ViewProps.WIDTH);
        listCreateListBuilder.add(ViewProps.HEIGHT);
        listCreateListBuilder.add("orientation");
        if (Build.VERSION.SDK_INT >= 29) {
            listCreateListBuilder.add("duration");
        }
        if (Build.VERSION.SDK_INT >= 30) {
            listCreateListBuilder.add("is_favorite");
        }
        projection = (String[]) CollectionsKt.build(listCreateListBuilder).toArray(new String[0]);
    }
}
