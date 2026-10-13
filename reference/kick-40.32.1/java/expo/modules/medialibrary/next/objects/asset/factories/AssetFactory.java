package expo.modules.medialibrary.next.objects.asset.factories;

import android.net.Uri;
import expo.modules.medialibrary.next.objects.asset.Asset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: AssetFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/factories/AssetFactory;", "", "create", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "contentUri", "Landroid/net/Uri;", "filePath", "relativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "create-BuevYFM", "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AssetFactory {
    Asset create(Uri contentUri);

    /* JADX INFO: renamed from: create-BuevYFM, reason: not valid java name */
    Object mo12019createBuevYFM(Uri uri, String str, Continuation<? super Asset> continuation);
}
