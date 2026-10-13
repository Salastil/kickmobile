package expo.modules.medialibrary.next.extensions.resolver;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CursorExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"extractAssetContentUri", "Landroid/net/Uri;", "Landroid/database/Cursor;", "idColumn", "", "typeColumn", "id", "", "mediaType", "(JLjava/lang/Integer;)Landroid/net/Uri;", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CursorExtensionsKt {
    public static final Uri extractAssetContentUri(Cursor cursor, int i, int i2) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        return extractAssetContentUri(cursor.getLong(i), expo.modules.medialibrary.next.extensions.CursorExtensionsKt.getNullableInt(cursor, i2));
    }

    public static final Uri extractAssetContentUri(long j, Integer num) {
        Uri external_content_uri;
        if (Build.VERSION.SDK_INT == 29) {
            if (num != null && num.intValue() == 1) {
                external_content_uri = MediaStore.Images.Media.getContentUri("external_primary");
            } else if (num != null && num.intValue() == 3) {
                external_content_uri = MediaStore.Video.Media.getContentUri("external_primary");
            } else {
                external_content_uri = (num != null && num.intValue() == 2) ? MediaStore.Audio.Media.getContentUri("external_primary") : MediaStore.Files.getContentUri("external_primary");
            }
        } else if (num != null && num.intValue() == 1) {
            external_content_uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (num != null && num.intValue() == 3) {
            external_content_uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            external_content_uri = (num != null && num.intValue() == 2) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : AlbumExtensionsKt.getEXTERNAL_CONTENT_URI();
        }
        Uri uriWithAppendedId = ContentUris.withAppendedId(external_content_uri, j);
        Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
        return uriWithAppendedId;
    }
}
