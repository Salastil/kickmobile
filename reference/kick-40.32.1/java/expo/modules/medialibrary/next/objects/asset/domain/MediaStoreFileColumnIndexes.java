package expo.modules.medialibrary.next.objects.asset.domain;

import android.database.Cursor;
import android.os.Build;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaStoreFile.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019Jv\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\f\u0010\u0019¨\u0006."}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreFileColumnIndexes;", "", "mediaType", "", "id", "displayName", "dateTaken", "dateModified", ViewProps.WIDTH, ViewProps.HEIGHT, "orientation", "duration", "isFavorite", "<init>", "(IIIIIIIILjava/lang/Integer;Ljava/lang/Integer;)V", "getMediaType", "()I", "getId", "getDisplayName", "getDateTaken", "getDateModified", "getWidth", "getHeight", "getOrientation", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(IIIIIIIILjava/lang/Integer;Ljava/lang/Integer;)Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreFileColumnIndexes;", "equals", "", "other", "hashCode", "toString", "", "Companion", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MediaStoreFileColumnIndexes {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int dateModified;
    private final int dateTaken;
    private final int displayName;
    private final Integer duration;
    private final int height;
    private final int id;
    private final Integer isFavorite;
    private final int mediaType;
    private final int orientation;
    private final int width;

    public static /* synthetic */ MediaStoreFileColumnIndexes copy$default(MediaStoreFileColumnIndexes mediaStoreFileColumnIndexes, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Integer num, Integer num2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i = mediaStoreFileColumnIndexes.mediaType;
        }
        if ((i9 & 2) != 0) {
            i2 = mediaStoreFileColumnIndexes.id;
        }
        if ((i9 & 4) != 0) {
            i3 = mediaStoreFileColumnIndexes.displayName;
        }
        if ((i9 & 8) != 0) {
            i4 = mediaStoreFileColumnIndexes.dateTaken;
        }
        if ((i9 & 16) != 0) {
            i5 = mediaStoreFileColumnIndexes.dateModified;
        }
        if ((i9 & 32) != 0) {
            i6 = mediaStoreFileColumnIndexes.width;
        }
        if ((i9 & 64) != 0) {
            i7 = mediaStoreFileColumnIndexes.height;
        }
        if ((i9 & 128) != 0) {
            i8 = mediaStoreFileColumnIndexes.orientation;
        }
        if ((i9 & 256) != 0) {
            num = mediaStoreFileColumnIndexes.duration;
        }
        if ((i9 & 512) != 0) {
            num2 = mediaStoreFileColumnIndexes.isFavorite;
        }
        Integer num3 = num;
        Integer num4 = num2;
        int i10 = i7;
        int i11 = i8;
        int i12 = i5;
        int i13 = i6;
        return mediaStoreFileColumnIndexes.copy(i, i2, i3, i4, i12, i13, i10, i11, num3, num4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMediaType() {
        return this.mediaType;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getIsFavorite() {
        return this.isFavorite;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDateTaken() {
        return this.dateTaken;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDateModified() {
        return this.dateModified;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getOrientation() {
        return this.orientation;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getDuration() {
        return this.duration;
    }

    public final MediaStoreFileColumnIndexes copy(int mediaType, int id, int displayName, int dateTaken, int dateModified, int width, int height, int orientation, Integer duration, Integer isFavorite) {
        return new MediaStoreFileColumnIndexes(mediaType, id, displayName, dateTaken, dateModified, width, height, orientation, duration, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaStoreFileColumnIndexes)) {
            return false;
        }
        MediaStoreFileColumnIndexes mediaStoreFileColumnIndexes = (MediaStoreFileColumnIndexes) other;
        return this.mediaType == mediaStoreFileColumnIndexes.mediaType && this.id == mediaStoreFileColumnIndexes.id && this.displayName == mediaStoreFileColumnIndexes.displayName && this.dateTaken == mediaStoreFileColumnIndexes.dateTaken && this.dateModified == mediaStoreFileColumnIndexes.dateModified && this.width == mediaStoreFileColumnIndexes.width && this.height == mediaStoreFileColumnIndexes.height && this.orientation == mediaStoreFileColumnIndexes.orientation && Intrinsics.areEqual(this.duration, mediaStoreFileColumnIndexes.duration) && Intrinsics.areEqual(this.isFavorite, mediaStoreFileColumnIndexes.isFavorite);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((Integer.hashCode(this.mediaType) * 31) + Integer.hashCode(this.id)) * 31) + Integer.hashCode(this.displayName)) * 31) + Integer.hashCode(this.dateTaken)) * 31) + Integer.hashCode(this.dateModified)) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.orientation)) * 31;
        Integer num = this.duration;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.isFavorite;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "MediaStoreFileColumnIndexes(mediaType=" + this.mediaType + ", id=" + this.id + ", displayName=" + this.displayName + ", dateTaken=" + this.dateTaken + ", dateModified=" + this.dateModified + ", width=" + this.width + ", height=" + this.height + ", orientation=" + this.orientation + ", duration=" + this.duration + ", isFavorite=" + this.isFavorite + ")";
    }

    public MediaStoreFileColumnIndexes(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Integer num, Integer num2) {
        this.mediaType = i;
        this.id = i2;
        this.displayName = i3;
        this.dateTaken = i4;
        this.dateModified = i5;
        this.width = i6;
        this.height = i7;
        this.orientation = i8;
        this.duration = num;
        this.isFavorite = num2;
    }

    public final int getMediaType() {
        return this.mediaType;
    }

    public final int getId() {
        return this.id;
    }

    public final int getDisplayName() {
        return this.displayName;
    }

    public final int getDateTaken() {
        return this.dateTaken;
    }

    public final int getDateModified() {
        return this.dateModified;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Integer isFavorite() {
        return this.isFavorite;
    }

    /* JADX INFO: compiled from: MediaStoreFile.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreFileColumnIndexes$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreFileColumnIndexes;", "cursor", "Landroid/database/Cursor;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaStoreFileColumnIndexes from(Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            return new MediaStoreFileColumnIndexes(cursor.getColumnIndexOrThrow("media_type"), cursor.getColumnIndexOrThrow("_id"), cursor.getColumnIndexOrThrow("_display_name"), cursor.getColumnIndexOrThrow("datetaken"), cursor.getColumnIndexOrThrow("date_modified"), cursor.getColumnIndexOrThrow(ViewProps.WIDTH), cursor.getColumnIndexOrThrow(ViewProps.HEIGHT), cursor.getColumnIndexOrThrow("orientation"), Build.VERSION.SDK_INT >= 29 ? Integer.valueOf(cursor.getColumnIndexOrThrow("duration")) : null, Build.VERSION.SDK_INT >= 30 ? Integer.valueOf(cursor.getColumnIndexOrThrow("is_favorite")) : null);
        }
    }
}
