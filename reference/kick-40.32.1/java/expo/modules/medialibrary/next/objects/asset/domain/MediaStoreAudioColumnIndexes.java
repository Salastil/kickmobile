package expo.modules.medialibrary.next.objects.asset.domain;

import android.database.Cursor;
import android.os.Build;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaStoreAudio.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013JV\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\t\u0010\u0013¨\u0006%"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudioColumnIndexes;", "", "id", "", "displayName", "dateTaken", "dateModified", "duration", "data", "isFavorite", "<init>", "(IIIIIILjava/lang/Integer;)V", "getId", "()I", "getDisplayName", "getDateTaken", "getDateModified", "getDuration", "getData", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(IIIIIILjava/lang/Integer;)Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudioColumnIndexes;", "equals", "", "other", "hashCode", "toString", "", "Companion", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MediaStoreAudioColumnIndexes {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int data;
    private final int dateModified;
    private final int dateTaken;
    private final int displayName;
    private final int duration;
    private final int id;
    private final Integer isFavorite;

    public static /* synthetic */ MediaStoreAudioColumnIndexes copy$default(MediaStoreAudioColumnIndexes mediaStoreAudioColumnIndexes, int i, int i2, int i3, int i4, int i5, int i6, Integer num, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = mediaStoreAudioColumnIndexes.id;
        }
        if ((i7 & 2) != 0) {
            i2 = mediaStoreAudioColumnIndexes.displayName;
        }
        if ((i7 & 4) != 0) {
            i3 = mediaStoreAudioColumnIndexes.dateTaken;
        }
        if ((i7 & 8) != 0) {
            i4 = mediaStoreAudioColumnIndexes.dateModified;
        }
        if ((i7 & 16) != 0) {
            i5 = mediaStoreAudioColumnIndexes.duration;
        }
        if ((i7 & 32) != 0) {
            i6 = mediaStoreAudioColumnIndexes.data;
        }
        if ((i7 & 64) != 0) {
            num = mediaStoreAudioColumnIndexes.isFavorite;
        }
        int i8 = i6;
        Integer num2 = num;
        int i9 = i5;
        int i10 = i3;
        return mediaStoreAudioColumnIndexes.copy(i, i2, i10, i4, i9, i8, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDateTaken() {
        return this.dateTaken;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDateModified() {
        return this.dateModified;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getIsFavorite() {
        return this.isFavorite;
    }

    public final MediaStoreAudioColumnIndexes copy(int id, int displayName, int dateTaken, int dateModified, int duration, int data, Integer isFavorite) {
        return new MediaStoreAudioColumnIndexes(id, displayName, dateTaken, dateModified, duration, data, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaStoreAudioColumnIndexes)) {
            return false;
        }
        MediaStoreAudioColumnIndexes mediaStoreAudioColumnIndexes = (MediaStoreAudioColumnIndexes) other;
        return this.id == mediaStoreAudioColumnIndexes.id && this.displayName == mediaStoreAudioColumnIndexes.displayName && this.dateTaken == mediaStoreAudioColumnIndexes.dateTaken && this.dateModified == mediaStoreAudioColumnIndexes.dateModified && this.duration == mediaStoreAudioColumnIndexes.duration && this.data == mediaStoreAudioColumnIndexes.data && Intrinsics.areEqual(this.isFavorite, mediaStoreAudioColumnIndexes.isFavorite);
    }

    public int hashCode() {
        int iHashCode = ((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.displayName)) * 31) + Integer.hashCode(this.dateTaken)) * 31) + Integer.hashCode(this.dateModified)) * 31) + Integer.hashCode(this.duration)) * 31) + Integer.hashCode(this.data)) * 31;
        Integer num = this.isFavorite;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "MediaStoreAudioColumnIndexes(id=" + this.id + ", displayName=" + this.displayName + ", dateTaken=" + this.dateTaken + ", dateModified=" + this.dateModified + ", duration=" + this.duration + ", data=" + this.data + ", isFavorite=" + this.isFavorite + ")";
    }

    public MediaStoreAudioColumnIndexes(int i, int i2, int i3, int i4, int i5, int i6, Integer num) {
        this.id = i;
        this.displayName = i2;
        this.dateTaken = i3;
        this.dateModified = i4;
        this.duration = i5;
        this.data = i6;
        this.isFavorite = num;
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

    public final int getDuration() {
        return this.duration;
    }

    public final int getData() {
        return this.data;
    }

    public final Integer isFavorite() {
        return this.isFavorite;
    }

    /* JADX INFO: compiled from: MediaStoreAudio.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudioColumnIndexes$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudioColumnIndexes;", "cursor", "Landroid/database/Cursor;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaStoreAudioColumnIndexes from(Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            return new MediaStoreAudioColumnIndexes(cursor.getColumnIndexOrThrow("_id"), cursor.getColumnIndexOrThrow("_display_name"), cursor.getColumnIndexOrThrow("datetaken"), cursor.getColumnIndexOrThrow("date_modified"), cursor.getColumnIndexOrThrow("duration"), cursor.getColumnIndexOrThrow("_data"), Build.VERSION.SDK_INT >= 30 ? Integer.valueOf(cursor.getColumnIndexOrThrow("is_favorite")) : null);
        }
    }
}
