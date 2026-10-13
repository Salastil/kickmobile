package expo.modules.updates.db.entity;

import android.net.Uri;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.updates.db.enums.HashType;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: AssetEntity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\\\u001a\u00020\u0003H\u0000¢\u0006\u0002\b]R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR \u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\b\"\u0004\b-\u0010\nR\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0002058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R \u0010:\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\b\"\u0004\b<\u0010\nR\u001e\u0010=\u001a\u00020>8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010C\u001a\u00020>8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010@\"\u0004\bD\u0010BR \u0010E\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\b\"\u0004\bG\u0010\nR \u0010H\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\b\"\u0004\bJ\u0010\nR \u0010K\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\b\"\u0004\bM\u0010\nR\"\u0010N\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010T\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR(\u0010U\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010V8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010[\u001a\u0004\bW\u0010X\"\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lexpo/modules/updates/db/entity/AssetEntity;", "", "key", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getType", "setType", "id", "", "getId", "()J", "setId", "(J)V", ImagesContract.URL, "Landroid/net/Uri;", "getUrl", "()Landroid/net/Uri;", "setUrl", "(Landroid/net/Uri;)V", "headers", "Lorg/json/JSONObject;", "getHeaders", "()Lorg/json/JSONObject;", "setHeaders", "(Lorg/json/JSONObject;)V", "extraRequestHeaders", "getExtraRequestHeaders", "setExtraRequestHeaders", "metadata", "getMetadata", "setMetadata", "downloadTime", "Ljava/util/Date;", "getDownloadTime", "()Ljava/util/Date;", "setDownloadTime", "(Ljava/util/Date;)V", "relativePath", "getRelativePath", "setRelativePath", "hash", "", "getHash", "()[B", "setHash", "([B)V", "hashType", "Lexpo/modules/updates/db/enums/HashType;", "getHashType", "()Lexpo/modules/updates/db/enums/HashType;", "setHashType", "(Lexpo/modules/updates/db/enums/HashType;)V", "expectedHash", "getExpectedHash", "setExpectedHash", "markedForDeletion", "", "getMarkedForDeletion", "()Z", "setMarkedForDeletion", "(Z)V", "isLaunchAsset", "setLaunchAsset", "embeddedAssetFilename", "getEmbeddedAssetFilename", "setEmbeddedAssetFilename", "resourcesFilename", "getResourcesFilename", "setResourcesFilename", "resourcesFolder", "getResourcesFolder", "setResourcesFolder", "scale", "", "getScale", "()Ljava/lang/Float;", "setScale", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "scales", "", "getScales", "()[Ljava/lang/Float;", "setScales", "([Ljava/lang/Float;)V", "[Ljava/lang/Float;", "getFileExtension", "getFileExtension$expo_updates_release", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AssetEntity {
    private Date downloadTime;
    private String embeddedAssetFilename;
    private String expectedHash;
    private JSONObject extraRequestHeaders;
    private byte[] hash;
    private HashType hashType = HashType.SHA256;
    private JSONObject headers;
    private long id;
    private boolean isLaunchAsset;
    private String key;
    private boolean markedForDeletion;
    private JSONObject metadata;
    private String relativePath;
    private String resourcesFilename;
    private String resourcesFolder;
    private Float scale;
    private Float[] scales;
    private String type;
    private Uri url;

    public AssetEntity(String str, String str2) {
        this.key = str;
        this.type = str2;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getType() {
        return this.type;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final void setUrl(Uri uri) {
        this.url = uri;
    }

    public final JSONObject getHeaders() {
        return this.headers;
    }

    public final void setHeaders(JSONObject jSONObject) {
        this.headers = jSONObject;
    }

    public final JSONObject getExtraRequestHeaders() {
        return this.extraRequestHeaders;
    }

    public final void setExtraRequestHeaders(JSONObject jSONObject) {
        this.extraRequestHeaders = jSONObject;
    }

    public final JSONObject getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(JSONObject jSONObject) {
        this.metadata = jSONObject;
    }

    public final Date getDownloadTime() {
        return this.downloadTime;
    }

    public final void setDownloadTime(Date date) {
        this.downloadTime = date;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public final void setRelativePath(String str) {
        this.relativePath = str;
    }

    public final byte[] getHash() {
        return this.hash;
    }

    public final void setHash(byte[] bArr) {
        this.hash = bArr;
    }

    public final HashType getHashType() {
        return this.hashType;
    }

    public final void setHashType(HashType hashType) {
        Intrinsics.checkNotNullParameter(hashType, "<set-?>");
        this.hashType = hashType;
    }

    public final String getExpectedHash() {
        return this.expectedHash;
    }

    public final void setExpectedHash(String str) {
        this.expectedHash = str;
    }

    public final boolean getMarkedForDeletion() {
        return this.markedForDeletion;
    }

    public final void setMarkedForDeletion(boolean z) {
        this.markedForDeletion = z;
    }

    /* JADX INFO: renamed from: isLaunchAsset, reason: from getter */
    public final boolean getIsLaunchAsset() {
        return this.isLaunchAsset;
    }

    public final void setLaunchAsset(boolean z) {
        this.isLaunchAsset = z;
    }

    public final String getEmbeddedAssetFilename() {
        return this.embeddedAssetFilename;
    }

    public final void setEmbeddedAssetFilename(String str) {
        this.embeddedAssetFilename = str;
    }

    public final String getResourcesFilename() {
        return this.resourcesFilename;
    }

    public final void setResourcesFilename(String str) {
        this.resourcesFilename = str;
    }

    public final String getResourcesFolder() {
        return this.resourcesFolder;
    }

    public final void setResourcesFolder(String str) {
        this.resourcesFolder = str;
    }

    public final Float getScale() {
        return this.scale;
    }

    public final void setScale(Float f) {
        this.scale = f;
    }

    public final Float[] getScales() {
        return this.scales;
    }

    public final void setScales(Float[] fArr) {
        this.scales = fArr;
    }

    public final String getFileExtension$expo_updates_release() {
        String str = this.type;
        if (str == null) {
            return "";
        }
        if (StringsKt.startsWith$default(str, ".", false, 2, (Object) null)) {
            return str;
        }
        return "." + str;
    }
}
