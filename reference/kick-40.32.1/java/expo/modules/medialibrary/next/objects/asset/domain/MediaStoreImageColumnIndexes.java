package expo.modules.medialibrary.next.objects.asset.domain;

import android.database.Cursor;
import android.os.Build;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaStoreImage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017Jj\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u000b\u0010\u0017¨\u0006+"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreImageColumnIndexes;", "", "id", "", "displayName", "dateTaken", "dateModified", ViewProps.WIDTH, ViewProps.HEIGHT, "orientation", "data", "isFavorite", "<init>", "(IIIIIIIILjava/lang/Integer;)V", "getId", "()I", "getDisplayName", "getDateTaken", "getDateModified", "getWidth", "getHeight", "getOrientation", "getData", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIIIIIIILjava/lang/Integer;)Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreImageColumnIndexes;", "equals", "", "other", "hashCode", "toString", "", "Companion", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MediaStoreImageColumnIndexes {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int data;
    private final int dateModified;
    private final int dateTaken;
    private final int displayName;
    private final int height;
    private final int id;
    private final Integer isFavorite;
    private final int orientation;
    private final int width;

    public static /* synthetic */ MediaStoreImageColumnIndexes copy$default(MediaStoreImageColumnIndexes mediaStoreImageColumnIndexes, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Integer num, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i = mediaStoreImageColumnIndexes.id;
        }
        if ((i9 & 2) != 0) {
            i2 = mediaStoreImageColumnIndexes.displayName;
        }
        if ((i9 & 4) != 0) {
            i3 = mediaStoreImageColumnIndexes.dateTaken;
        }
        if ((i9 & 8) != 0) {
            i4 = mediaStoreImageColumnIndexes.dateModified;
        }
        if ((i9 & 16) != 0) {
            i5 = mediaStoreImageColumnIndexes.width;
        }
        if ((i9 & 32) != 0) {
            i6 = mediaStoreImageColumnIndexes.height;
        }
        if ((i9 & 64) != 0) {
            i7 = mediaStoreImageColumnIndexes.orientation;
        }
        if ((i9 & 128) != 0) {
            i8 = mediaStoreImageColumnIndexes.data;
        }
        if ((i9 & 256) != 0) {
            num = mediaStoreImageColumnIndexes.isFavorite;
        }
        int i10 = i8;
        Integer num2 = num;
        int i11 = i6;
        int i12 = i7;
        int i13 = i5;
        int i14 = i3;
        return mediaStoreImageColumnIndexes.copy(i, i2, i14, i4, i13, i11, i12, i10, num2);
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
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getOrientation() {
        return this.orientation;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getIsFavorite() {
        return this.isFavorite;
    }

    public final MediaStoreImageColumnIndexes copy(int id, int displayName, int dateTaken, int dateModified, int width, int height, int orientation, int data, Integer isFavorite) {
        return new MediaStoreImageColumnIndexes(id, displayName, dateTaken, dateModified, width, height, orientation, data, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaStoreImageColumnIndexes)) {
            return false;
        }
        MediaStoreImageColumnIndexes mediaStoreImageColumnIndexes = (MediaStoreImageColumnIndexes) other;
        return this.id == mediaStoreImageColumnIndexes.id && this.displayName == mediaStoreImageColumnIndexes.displayName && this.dateTaken == mediaStoreImageColumnIndexes.dateTaken && this.dateModified == mediaStoreImageColumnIndexes.dateModified && this.width == mediaStoreImageColumnIndexes.width && this.height == mediaStoreImageColumnIndexes.height && this.orientation == mediaStoreImageColumnIndexes.orientation && this.data == mediaStoreImageColumnIndexes.data && Intrinsics.areEqual(this.isFavorite, mediaStoreImageColumnIndexes.isFavorite);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.displayName)) * 31) + Integer.hashCode(this.dateTaken)) * 31) + Integer.hashCode(this.dateModified)) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.orientation)) * 31) + Integer.hashCode(this.data)) * 31;
        Integer num = this.isFavorite;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "MediaStoreImageColumnIndexes(id=" + this.id + ", displayName=" + this.displayName + ", dateTaken=" + this.dateTaken + ", dateModified=" + this.dateModified + ", width=" + this.width + ", height=" + this.height + ", orientation=" + this.orientation + ", data=" + this.data + ", isFavorite=" + this.isFavorite + ")";
    }

    public MediaStoreImageColumnIndexes(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Integer num) {
        this.id = i;
        this.displayName = i2;
        this.dateTaken = i3;
        this.dateModified = i4;
        this.width = i5;
        this.height = i6;
        this.orientation = i7;
        this.data = i8;
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

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getData() {
        return this.data;
    }

    public final Integer isFavorite() {
        return this.isFavorite;
    }

    /* JADX INFO: compiled from: MediaStoreImage.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreImageColumnIndexes$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreImageColumnIndexes;", "cursor", "Landroid/database/Cursor;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaStoreImageColumnIndexes from(Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            return new MediaStoreImageColumnIndexes(cursor.getColumnIndexOrThrow("_id"), cursor.getColumnIndexOrThrow("_display_name"), cursor.getColumnIndexOrThrow("datetaken"), cursor.getColumnIndexOrThrow("date_modified"), cursor.getColumnIndexOrThrow(ViewProps.WIDTH), cursor.getColumnIndexOrThrow(ViewProps.HEIGHT), cursor.getColumnIndexOrThrow("orientation"), cursor.getColumnIndexOrThrow("_data"), Build.VERSION.SDK_INT >= 30 ? Integer.valueOf(cursor.getColumnIndexOrThrow("is_favorite")) : null);
        }
    }
}
