package expo.modules.updates.utils;

import android.content.Context;
import android.net.Uri;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.common.util.UriUtil;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.updates.db.entity.AssetEntity;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: AndroidResourceAssetUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0007J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0005J\u0017\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lexpo/modules/updates/utils/AndroidResourceAssetUtils;", "", "<init>", "()V", "ANDROID_EMBEDDED_URL_BASE_ASSET", "", "ANDROID_EMBEDDED_URL_BASE_RESOURCE", "createEmbeddedFilenameForAsset", UriUtil.LOCAL_ASSET_SCHEME, "Lexpo/modules/updates/db/entity/AssetEntity;", "isAndroidResourceAsset", "", "filePath", "isAndroidAssetExisted", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "name", "isAndroidResourceExisted", "resourceFolder", "resourceFilename", "isAndroidAssetOrResourceExisted", "parseAndroidResponseAssetFromPath", "Lexpo/modules/updates/utils/AndroidResourceAssetUtils$AndroidResourceAsset;", "getDrawableSuffix", "scale", "", "(Ljava/lang/Float;)Ljava/lang/String;", "AndroidResourceAsset", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AndroidResourceAssetUtils {
    private static final String ANDROID_EMBEDDED_URL_BASE_ASSET = "file:///android_asset/";
    private static final String ANDROID_EMBEDDED_URL_BASE_RESOURCE = "file:///android_res/";
    public static final AndroidResourceAssetUtils INSTANCE = new AndroidResourceAssetUtils();

    private AndroidResourceAssetUtils() {
    }

    public final String createEmbeddedFilenameForAsset(AssetEntity asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        String fileExtension$expo_updates_release = asset.getFileExtension$expo_updates_release();
        if (asset.getEmbeddedAssetFilename() != null) {
            return ANDROID_EMBEDDED_URL_BASE_ASSET + asset.getEmbeddedAssetFilename() + fileExtension$expo_updates_release;
        }
        if (asset.getResourcesFolder() == null || asset.getResourcesFilename() == null) {
            return null;
        }
        return "file:///android_res/" + asset.getResourcesFolder() + getDrawableSuffix(asset.getScale()) + DomExceptionUtils.SEPARATOR + asset.getResourcesFilename() + fileExtension$expo_updates_release;
    }

    public final boolean isAndroidResourceAsset(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return StringsKt.startsWith$default(filePath, "file:///android_res/", false, 2, (Object) null) || StringsKt.startsWith$default(filePath, ANDROID_EMBEDDED_URL_BASE_ASSET, false, 2, (Object) null);
    }

    public final boolean isAndroidAssetExisted(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            context.getAssets().open(name).close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public final boolean isAndroidResourceExisted(Context context, String resourceFolder, String resourceFilename) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resourceFolder, "resourceFolder");
        Intrinsics.checkNotNullParameter(resourceFilename, "resourceFilename");
        return context.getResources().getIdentifier(resourceFilename, resourceFolder, context.getPackageName()) != 0;
    }

    public final boolean isAndroidAssetOrResourceExisted(Context context, String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        AndroidResourceAsset androidResponseAssetFromPath = parseAndroidResponseAssetFromPath(filePath);
        String embeddedAssetFilename = androidResponseAssetFromPath.getEmbeddedAssetFilename();
        String resourcesFolder = androidResponseAssetFromPath.getResourcesFolder();
        String resourceFilename = androidResponseAssetFromPath.getResourceFilename();
        if (embeddedAssetFilename != null) {
            return isAndroidAssetExisted(context, embeddedAssetFilename);
        }
        if (resourcesFolder == null || resourceFilename == null) {
            return false;
        }
        return isAndroidResourceExisted(context, resourcesFolder, resourceFilename);
    }

    /* JADX INFO: compiled from: AndroidResourceAssetUtils.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lexpo/modules/updates/utils/AndroidResourceAssetUtils$AndroidResourceAsset;", "", "embeddedAssetFilename", "", "resourcesFolder", "resourceFilename", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmbeddedAssetFilename", "()Ljava/lang/String;", "getResourcesFolder", "getResourceFilename", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class AndroidResourceAsset {
        private final String embeddedAssetFilename;
        private final String resourceFilename;
        private final String resourcesFolder;

        public static /* synthetic */ AndroidResourceAsset copy$default(AndroidResourceAsset androidResourceAsset, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = androidResourceAsset.embeddedAssetFilename;
            }
            if ((i & 2) != 0) {
                str2 = androidResourceAsset.resourcesFolder;
            }
            if ((i & 4) != 0) {
                str3 = androidResourceAsset.resourceFilename;
            }
            return androidResourceAsset.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEmbeddedAssetFilename() {
            return this.embeddedAssetFilename;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getResourcesFolder() {
            return this.resourcesFolder;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getResourceFilename() {
            return this.resourceFilename;
        }

        public final AndroidResourceAsset copy(String embeddedAssetFilename, String resourcesFolder, String resourceFilename) {
            return new AndroidResourceAsset(embeddedAssetFilename, resourcesFolder, resourceFilename);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AndroidResourceAsset)) {
                return false;
            }
            AndroidResourceAsset androidResourceAsset = (AndroidResourceAsset) other;
            return Intrinsics.areEqual(this.embeddedAssetFilename, androidResourceAsset.embeddedAssetFilename) && Intrinsics.areEqual(this.resourcesFolder, androidResourceAsset.resourcesFolder) && Intrinsics.areEqual(this.resourceFilename, androidResourceAsset.resourceFilename);
        }

        public int hashCode() {
            String str = this.embeddedAssetFilename;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.resourcesFolder;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.resourceFilename;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "AndroidResourceAsset(embeddedAssetFilename=" + this.embeddedAssetFilename + ", resourcesFolder=" + this.resourcesFolder + ", resourceFilename=" + this.resourceFilename + ")";
        }

        public AndroidResourceAsset(String str, String str2, String str3) {
            this.embeddedAssetFilename = str;
            this.resourcesFolder = str2;
            this.resourceFilename = str3;
        }

        public final String getEmbeddedAssetFilename() {
            return this.embeddedAssetFilename;
        }

        public final String getResourcesFolder() {
            return this.resourcesFolder;
        }

        public final String getResourceFilename() {
            return this.resourceFilename;
        }
    }

    public final AndroidResourceAsset parseAndroidResponseAssetFromPath(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (StringsKt.startsWith$default(filePath, "file:///android_res/", false, 2, (Object) null)) {
            List<String> pathSegments = Uri.parse(filePath).getPathSegments();
            if (pathSegments.size() < 3) {
                throw new InvalidArgumentException("Invalid resource file path: " + filePath);
            }
            String str = pathSegments.get(1);
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            String strSubstringBefore$default = StringsKt.substringBefore$default(str, '-', (String) null, 2, (Object) null);
            String str2 = pathSegments.get(2);
            Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
            String str3 = pathSegments.get(2);
            Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
            return new AndroidResourceAsset(null, strSubstringBefore$default, StringsKt.substringBeforeLast(str2, FilenameUtils.EXTENSION_SEPARATOR, str3));
        }
        if (StringsKt.startsWith$default(filePath, ANDROID_EMBEDDED_URL_BASE_ASSET, false, 2, (Object) null)) {
            return new AndroidResourceAsset(StringsKt.substringAfterLast$default(filePath, '/', (String) null, 2, (Object) null), null, null);
        }
        return new AndroidResourceAsset(null, null, null);
    }

    private final String getDrawableSuffix(Float scale) {
        if (Intrinsics.areEqual(scale, 0.75f)) {
            return "-ldpi";
        }
        if (Intrinsics.areEqual(scale, 1.0f)) {
            return "-mdpi";
        }
        if (Intrinsics.areEqual(scale, 1.5f)) {
            return "-hdpi";
        }
        if (Intrinsics.areEqual(scale, 2.0f)) {
            return "-xhdpi";
        }
        if (Intrinsics.areEqual(scale, 3.0f)) {
            return "-xxhdpi";
        }
        return Intrinsics.areEqual(scale, 4.0f) ? "-xxxhdpi" : "";
    }
}
