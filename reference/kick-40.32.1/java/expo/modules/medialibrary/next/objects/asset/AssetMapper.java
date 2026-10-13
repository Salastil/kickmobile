package expo.modules.medialibrary.next.objects.asset;

import android.net.Uri;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.uimanager.ViewProps;
import com.google.common.net.HttpHeaders;
import expo.modules.medialibrary.next.exceptions.AssetPropertyNotFoundException;
import expo.modules.medialibrary.next.extensions.resolver.CursorExtensionsKt;
import expo.modules.medialibrary.next.objects.asset.domain.AssetMediaStoreItem;
import expo.modules.medialibrary.next.objects.asset.domain.MediaStoreAudio;
import expo.modules.medialibrary.next.objects.asset.domain.MediaStoreFile;
import expo.modules.medialibrary.next.objects.asset.domain.MediaStoreImage;
import expo.modules.medialibrary.next.objects.asset.domain.MediaStoreVideo;
import expo.modules.medialibrary.next.objects.wrappers.MediaType;
import expo.modules.medialibrary.next.records.AssetInfo;
import expo.modules.medialibrary.next.records.AssetMetadata;
import expo.modules.medialibrary.next.records.Shape;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: AssetMapper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u0007J-\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0018J+\u0010\u0019\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0018J'\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010 J\u0017\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010$J\u0017\u0010%\u001a\u0004\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010$J\u0017\u0010'\u001a\u0004\u0018\u00010\"2\b\u0010(\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010$J\u0012\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,J\u0015\u0010-\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010 ¨\u0006/"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "", "<init>", "()V", "toDto", "Lexpo/modules/medialibrary/next/records/AssetInfo;", "mediaStoreItem", "Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem;", "imageAsset", "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreImage;", "videoAsset", "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreVideo;", "audioAsset", "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudio;", "toMetadata", "Lexpo/modules/medialibrary/next/records/AssetMetadata;", "fileAsset", "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreFile;", "mapShape", "Lexpo/modules/medialibrary/next/records/Shape;", "mediaStoreWidth", "", "mediaStoreHeight", "mediaStoreOrientation", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lexpo/modules/medialibrary/next/records/Shape;", "mapDisplaySize", "orientToDisplay", ViewProps.WIDTH, ViewProps.HEIGHT, "(IILjava/lang/Integer;)Lexpo/modules/medialibrary/next/records/Shape;", "isQuarterTurn", "", "(Ljava/lang/Integer;)Z", "mapCreationTime", "", "mediaStoreDateTaken", "(Ljava/lang/Long;)Ljava/lang/Long;", "mapDuration", "mediaStoreDuration", "mapModificationTime", "mediaStoreDateModified", "mapUri", "Landroid/net/Uri;", "mediaStoreData", "", "mapIsFavorite", "mediaStoreIsFavorite", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssetMapper {
    public final AssetInfo toDto(AssetMediaStoreItem mediaStoreItem) {
        Intrinsics.checkNotNullParameter(mediaStoreItem, "mediaStoreItem");
        if (mediaStoreItem instanceof AssetMediaStoreItem.Image) {
            return toDto(((AssetMediaStoreItem.Image) mediaStoreItem).getAsset());
        }
        if (mediaStoreItem instanceof AssetMediaStoreItem.Video) {
            return toDto(((AssetMediaStoreItem.Video) mediaStoreItem).getAsset());
        }
        if (mediaStoreItem instanceof AssetMediaStoreItem.Audio) {
            return toDto(((AssetMediaStoreItem.Audio) mediaStoreItem).getAsset());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final AssetInfo toDto(MediaStoreImage imageAsset) throws AssetPropertyNotFoundException {
        Uri uriExtractAssetContentUri = CursorExtensionsKt.extractAssetContentUri(imageAsset.getId(), 1);
        Shape shapeMapDisplaySize = mapDisplaySize(imageAsset.getWidth(), imageAsset.getHeight(), imageAsset.getOrientation());
        int width = shapeMapDisplaySize.getWidth();
        int height = shapeMapDisplaySize.getHeight();
        Uri uriMapUri = mapUri(imageAsset.getData());
        if (uriMapUri == null) {
            throw new AssetPropertyNotFoundException("Uri", null, 2, null);
        }
        MediaType mediaType = MediaType.IMAGE;
        Long lMapCreationTime = mapCreationTime(imageAsset.getDateTaken());
        Long lMapModificationTime = mapModificationTime(imageAsset.getDateModified());
        String displayName = imageAsset.getDisplayName();
        if (displayName != null) {
            return new AssetInfo(uriExtractAssetContentUri, lMapCreationTime, null, displayName, height, width, mediaType, lMapModificationTime, uriMapUri, mapIsFavorite(imageAsset.isFavorite()));
        }
        throw new AssetPropertyNotFoundException("Filename", null, 2, null);
    }

    private final AssetInfo toDto(MediaStoreVideo videoAsset) throws AssetPropertyNotFoundException {
        Uri uriExtractAssetContentUri = CursorExtensionsKt.extractAssetContentUri(videoAsset.getId(), 3);
        Shape shapeMapDisplaySize = mapDisplaySize(videoAsset.getWidth(), videoAsset.getHeight(), videoAsset.getOrientation());
        int width = shapeMapDisplaySize.getWidth();
        int height = shapeMapDisplaySize.getHeight();
        Uri uriMapUri = mapUri(videoAsset.getData());
        if (uriMapUri == null) {
            throw new AssetPropertyNotFoundException("Uri", null, 2, null);
        }
        MediaType mediaType = MediaType.VIDEO;
        Long lMapCreationTime = mapCreationTime(videoAsset.getDateTaken());
        Long lMapModificationTime = mapModificationTime(videoAsset.getDateModified());
        Long lMapDuration = mapDuration(videoAsset.getDuration());
        String displayName = videoAsset.getDisplayName();
        if (displayName != null) {
            return new AssetInfo(uriExtractAssetContentUri, lMapCreationTime, lMapDuration, displayName, height, width, mediaType, lMapModificationTime, uriMapUri, mapIsFavorite(videoAsset.isFavorite()));
        }
        throw new AssetPropertyNotFoundException("Filename", null, 2, null);
    }

    private final AssetInfo toDto(MediaStoreAudio audioAsset) throws AssetPropertyNotFoundException {
        Uri uriExtractAssetContentUri = CursorExtensionsKt.extractAssetContentUri(audioAsset.getId(), 2);
        Uri uriMapUri = mapUri(audioAsset.getData());
        if (uriMapUri == null) {
            throw new AssetPropertyNotFoundException("Uri", null, 2, null);
        }
        MediaType mediaType = MediaType.AUDIO;
        Long lMapCreationTime = mapCreationTime(audioAsset.getDateTaken());
        Long lMapModificationTime = mapModificationTime(audioAsset.getDateModified());
        Long lMapDuration = mapDuration(audioAsset.getDuration());
        String displayName = audioAsset.getDisplayName();
        if (displayName != null) {
            return new AssetInfo(uriExtractAssetContentUri, lMapCreationTime, lMapDuration, displayName, 0, 0, mediaType, lMapModificationTime, uriMapUri, mapIsFavorite(audioAsset.isFavorite()));
        }
        throw new AssetPropertyNotFoundException("Filename", null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0035  */
    public final AssetMetadata toMetadata(MediaStoreFile fileAsset) {
        MediaType mediaTypeFromMediaStoreValue;
        Intrinsics.checkNotNullParameter(fileAsset, "fileAsset");
        Shape shapeMapShape = mapShape(fileAsset.getWidth(), fileAsset.getHeight(), fileAsset.getOrientation());
        Uri uriExtractAssetContentUri = CursorExtensionsKt.extractAssetContentUri(fileAsset.getId(), fileAsset.getMediaType());
        Integer mediaType = fileAsset.getMediaType();
        if (mediaType != null) {
            mediaTypeFromMediaStoreValue = MediaType.INSTANCE.fromMediaStoreValue(mediaType.intValue());
            if (mediaTypeFromMediaStoreValue == null) {
                mediaTypeFromMediaStoreValue = MediaType.UNKNOWN;
            }
        } else {
            mediaTypeFromMediaStoreValue = MediaType.UNKNOWN;
        }
        MediaType mediaType2 = mediaTypeFromMediaStoreValue;
        Integer numValueOf = shapeMapShape != null ? Integer.valueOf(shapeMapShape.getWidth()) : fileAsset.getWidth();
        return new AssetMetadata(uriExtractAssetContentUri, mapCreationTime(fileAsset.getDateTaken()), mapDuration(fileAsset.getDuration()), fileAsset.getDisplayName(), shapeMapShape != null ? Integer.valueOf(shapeMapShape.getHeight()) : fileAsset.getHeight(), numValueOf, mediaType2, mapModificationTime(fileAsset.getDateModified()), mapIsFavorite(fileAsset.isFavorite()));
    }

    public final Shape mapShape(AssetMediaStoreItem mediaStoreItem) {
        Intrinsics.checkNotNullParameter(mediaStoreItem, "mediaStoreItem");
        if (mediaStoreItem instanceof AssetMediaStoreItem.Image) {
            MediaStoreImage asset = ((AssetMediaStoreItem.Image) mediaStoreItem).getAsset();
            return mapShape(asset.getWidth(), asset.getHeight(), asset.getOrientation());
        }
        if (mediaStoreItem instanceof AssetMediaStoreItem.Video) {
            MediaStoreVideo asset2 = ((AssetMediaStoreItem.Video) mediaStoreItem).getAsset();
            return mapShape(asset2.getWidth(), asset2.getHeight(), asset2.getOrientation());
        }
        if (mediaStoreItem instanceof AssetMediaStoreItem.Audio) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Shape mapShape(Integer mediaStoreWidth, Integer mediaStoreHeight, Integer mediaStoreOrientation) {
        if (mediaStoreWidth != null) {
            if (mediaStoreWidth.intValue() <= 0) {
                mediaStoreWidth = null;
            }
            if (mediaStoreWidth != null) {
                int iIntValue = mediaStoreWidth.intValue();
                if (mediaStoreHeight != null) {
                    if (mediaStoreHeight.intValue() <= 0) {
                        mediaStoreHeight = null;
                    }
                    if (mediaStoreHeight != null) {
                        return orientToDisplay(iIntValue, mediaStoreHeight.intValue(), mediaStoreOrientation);
                    }
                }
            }
        }
        return null;
    }

    private final Shape mapDisplaySize(Integer mediaStoreWidth, Integer mediaStoreHeight, Integer mediaStoreOrientation) throws AssetPropertyNotFoundException {
        if (mediaStoreWidth != null) {
            if (mediaStoreWidth.intValue() <= 0) {
                mediaStoreWidth = null;
            }
            if (mediaStoreWidth != null) {
                int iIntValue = mediaStoreWidth.intValue();
                if (mediaStoreHeight != null) {
                    if (mediaStoreHeight.intValue() <= 0) {
                        mediaStoreHeight = null;
                    }
                    if (mediaStoreHeight != null) {
                        return orientToDisplay(iIntValue, mediaStoreHeight.intValue(), mediaStoreOrientation);
                    }
                }
                throw new AssetPropertyNotFoundException("Height", null, 2, null);
            }
        }
        throw new AssetPropertyNotFoundException(HttpHeaders.WIDTH, null, 2, null);
    }

    private final Shape orientToDisplay(int width, int height, Integer mediaStoreOrientation) {
        if (isQuarterTurn(mediaStoreOrientation)) {
            return new Shape(height, width);
        }
        return new Shape(width, height);
    }

    private final boolean isQuarterTurn(Integer mediaStoreOrientation) {
        return Math.abs(mediaStoreOrientation != null ? mediaStoreOrientation.intValue() : 0) % RotationOptions.ROTATE_180 == 90;
    }

    public final Long mapCreationTime(Long mediaStoreDateTaken) {
        if (mediaStoreDateTaken != null && mediaStoreDateTaken.longValue() == 0) {
            return null;
        }
        return mediaStoreDateTaken;
    }

    public final Long mapDuration(Long mediaStoreDuration) {
        if (mediaStoreDuration != null && mediaStoreDuration.longValue() == 0) {
            return null;
        }
        return mediaStoreDuration;
    }

    public final Long mapModificationTime(Long mediaStoreDateModified) {
        if (mediaStoreDateModified == null) {
            return null;
        }
        if (mediaStoreDateModified.longValue() == 0) {
            mediaStoreDateModified = null;
        }
        if (mediaStoreDateModified != null) {
            return Long.valueOf(Duration.m14075getInWholeMillisecondsimpl(DurationKt.toDuration(mediaStoreDateModified.longValue(), DurationUnit.SECONDS)));
        }
        return null;
    }

    public final Uri mapUri(String mediaStoreData) {
        if (mediaStoreData != null) {
            return Uri.fromFile(new File(mediaStoreData));
        }
        return null;
    }

    public final boolean mapIsFavorite(Integer mediaStoreIsFavorite) {
        return mediaStoreIsFavorite != null && mediaStoreIsFavorite.intValue() == 1;
    }
}
