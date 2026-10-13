package expo.modules.medialibrary.next.objects.asset.factories;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException;
import expo.modules.medialibrary.next.extensions.WeakReferenceExtensionsKt;
import expo.modules.medialibrary.next.objects.asset.Asset;
import expo.modules.medialibrary.next.objects.asset.AssetDimensionsResolver;
import expo.modules.medialibrary.next.objects.asset.AssetMapper;
import expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate;
import expo.modules.medialibrary.next.objects.asset.delegates.AssetModernDelegate;
import expo.modules.medialibrary.next.objects.asset.deleters.AssetDeleter;
import expo.modules.medialibrary.next.objects.asset.movers.AssetMover;
import expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AssetModernFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$H\u0016J\"\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096@¢\u0006\u0004\b*\u0010+J*\u0010,\u001a\u00020&2\u0006\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010-\u001a\u00020.H\u0082@¢\u0006\u0004\b/\u00100R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\r0\r0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u00061"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/factories/AssetModernFactory;", "Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "assetDeleter", "Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "assetMover", "Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "assetMapper", "Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "assetDimensionsResolver", "Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;", "mediaStorePermissionsDelegate", "Lexpo/modules/medialibrary/next/permissions/MediaStorePermissionsDelegate;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "<init>", "(Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;Lexpo/modules/medialibrary/next/permissions/MediaStorePermissionsDelegate;Landroid/content/Context;)V", "getAssetDeleter", "()Lexpo/modules/medialibrary/next/objects/asset/deleters/AssetDeleter;", "getAssetMover", "()Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "getAssetMapper", "()Lexpo/modules/medialibrary/next/objects/asset/AssetMapper;", "getAssetDimensionsResolver", "()Lexpo/modules/medialibrary/next/objects/asset/AssetDimensionsResolver;", "getMediaStorePermissionsDelegate", "()Lexpo/modules/medialibrary/next/permissions/MediaStorePermissionsDelegate;", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "contentResolver", "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "createAssetDelegate", "Lexpo/modules/medialibrary/next/objects/asset/delegates/AssetDelegate;", "contentUri", "Landroid/net/Uri;", "create", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "filePath", "relativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "create-BuevYFM", "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAssetInternal", "forceUniqueName", "", "createAssetInternal-7lvfX64", "(Landroid/net/Uri;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssetModernFactory implements AssetFactory {
    private final AssetDeleter assetDeleter;
    private final AssetDimensionsResolver assetDimensionsResolver;
    private final AssetMapper assetMapper;
    private final AssetMover assetMover;
    private final WeakReference<Context> contextRef;
    private final MediaStorePermissionsDelegate mediaStorePermissionsDelegate;

    public AssetModernFactory(AssetDeleter assetDeleter, AssetMover assetMover, AssetMapper assetMapper, AssetDimensionsResolver assetDimensionsResolver, MediaStorePermissionsDelegate mediaStorePermissionsDelegate, Context context) {
        Intrinsics.checkNotNullParameter(assetDeleter, "assetDeleter");
        Intrinsics.checkNotNullParameter(assetMover, "assetMover");
        Intrinsics.checkNotNullParameter(assetMapper, "assetMapper");
        Intrinsics.checkNotNullParameter(assetDimensionsResolver, "assetDimensionsResolver");
        Intrinsics.checkNotNullParameter(mediaStorePermissionsDelegate, "mediaStorePermissionsDelegate");
        Intrinsics.checkNotNullParameter(context, "context");
        this.assetDeleter = assetDeleter;
        this.assetMover = assetMover;
        this.assetMapper = assetMapper;
        this.assetDimensionsResolver = assetDimensionsResolver;
        this.mediaStorePermissionsDelegate = mediaStorePermissionsDelegate;
        this.contextRef = new WeakReference<>(context);
    }

    public final AssetDeleter getAssetDeleter() {
        return this.assetDeleter;
    }

    public final AssetMover getAssetMover() {
        return this.assetMover;
    }

    public final AssetMapper getAssetMapper() {
        return this.assetMapper;
    }

    public final AssetDimensionsResolver getAssetDimensionsResolver() {
        return this.assetDimensionsResolver;
    }

    public final MediaStorePermissionsDelegate getMediaStorePermissionsDelegate() {
        return this.mediaStorePermissionsDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContentResolver getContentResolver() throws ContentResolverNotObtainedException {
        ContentResolver contentResolver = WeakReferenceExtensionsKt.getOrThrow(this.contextRef).getContentResolver();
        if (contentResolver != null) {
            return contentResolver;
        }
        throw new ContentResolverNotObtainedException(null, 1, null);
    }

    private final AssetDelegate createAssetDelegate(Uri contentUri) {
        return new AssetModernDelegate(contentUri, this.assetDeleter, this.assetMover, this.assetMapper, this.assetDimensionsResolver, this.mediaStorePermissionsDelegate, this, WeakReferenceExtensionsKt.getOrThrow(this.contextRef));
    }

    @Override // expo.modules.medialibrary.next.objects.asset.factories.AssetFactory
    public Asset create(Uri contentUri) {
        Intrinsics.checkNotNullParameter(contentUri, "contentUri");
        return new Asset(createAssetDelegate(contentUri));
    }

    @Override // expo.modules.medialibrary.next.objects.asset.factories.AssetFactory
    /* JADX INFO: renamed from: create-BuevYFM */
    public Object mo12019createBuevYFM(Uri uri, String str, Continuation<? super Asset> continuation) {
        return m12023createAssetInternal7lvfX64(uri, str, false, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createAssetInternal-7lvfX64, reason: not valid java name */
    public final Object m12023createAssetInternal7lvfX64(Uri uri, String str, boolean z, Continuation<? super Asset> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AssetModernFactory$createAssetInternal$2(this, uri, z, str, null), continuation);
    }
}
