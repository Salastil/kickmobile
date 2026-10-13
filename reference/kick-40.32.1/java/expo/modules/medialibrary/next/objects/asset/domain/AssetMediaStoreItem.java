package expo.modules.medialibrary.next.objects.asset.domain;

import com.facebook.common.util.UriUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssetMediaStoreItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem;", "", "Image", "Video", "Audio", "Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem$Audio;", "Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem$Image;", "Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem$Video;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AssetMediaStoreItem {

    /* JADX INFO: compiled from: AssetMediaStoreItem.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem$Image;", "Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem;", UriUtil.LOCAL_ASSET_SCHEME, "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreImage;", "<init>", "(Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreImage;)V", "getAsset", "()Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreImage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Image implements AssetMediaStoreItem {
        private final MediaStoreImage asset;

        public static /* synthetic */ Image copy$default(Image image, MediaStoreImage mediaStoreImage, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaStoreImage = image.asset;
            }
            return image.copy(mediaStoreImage);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MediaStoreImage getAsset() {
            return this.asset;
        }

        public final Image copy(MediaStoreImage asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            return new Image(asset);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Image) && Intrinsics.areEqual(this.asset, ((Image) other).asset);
        }

        public int hashCode() {
            return this.asset.hashCode();
        }

        public String toString() {
            return "Image(asset=" + this.asset + ")";
        }

        public Image(MediaStoreImage asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            this.asset = asset;
        }

        public final MediaStoreImage getAsset() {
            return this.asset;
        }
    }

    /* JADX INFO: compiled from: AssetMediaStoreItem.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem$Video;", "Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem;", UriUtil.LOCAL_ASSET_SCHEME, "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreVideo;", "<init>", "(Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreVideo;)V", "getAsset", "()Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreVideo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Video implements AssetMediaStoreItem {
        private final MediaStoreVideo asset;

        public static /* synthetic */ Video copy$default(Video video, MediaStoreVideo mediaStoreVideo, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaStoreVideo = video.asset;
            }
            return video.copy(mediaStoreVideo);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MediaStoreVideo getAsset() {
            return this.asset;
        }

        public final Video copy(MediaStoreVideo asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            return new Video(asset);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Video) && Intrinsics.areEqual(this.asset, ((Video) other).asset);
        }

        public int hashCode() {
            return this.asset.hashCode();
        }

        public String toString() {
            return "Video(asset=" + this.asset + ")";
        }

        public Video(MediaStoreVideo asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            this.asset = asset;
        }

        public final MediaStoreVideo getAsset() {
            return this.asset;
        }
    }

    /* JADX INFO: compiled from: AssetMediaStoreItem.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem$Audio;", "Lexpo/modules/medialibrary/next/objects/asset/domain/AssetMediaStoreItem;", UriUtil.LOCAL_ASSET_SCHEME, "Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudio;", "<init>", "(Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudio;)V", "getAsset", "()Lexpo/modules/medialibrary/next/objects/asset/domain/MediaStoreAudio;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Audio implements AssetMediaStoreItem {
        private final MediaStoreAudio asset;

        public static /* synthetic */ Audio copy$default(Audio audio, MediaStoreAudio mediaStoreAudio, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaStoreAudio = audio.asset;
            }
            return audio.copy(mediaStoreAudio);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MediaStoreAudio getAsset() {
            return this.asset;
        }

        public final Audio copy(MediaStoreAudio asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            return new Audio(asset);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Audio) && Intrinsics.areEqual(this.asset, ((Audio) other).asset);
        }

        public int hashCode() {
            return this.asset.hashCode();
        }

        public String toString() {
            return "Audio(asset=" + this.asset + ")";
        }

        public Audio(MediaStoreAudio asset) {
            Intrinsics.checkNotNullParameter(asset, "asset");
            this.asset = asset;
        }

        public final MediaStoreAudio getAsset() {
            return this.asset;
        }
    }
}
