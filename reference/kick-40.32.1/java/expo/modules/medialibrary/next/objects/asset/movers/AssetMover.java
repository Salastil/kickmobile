package expo.modules.medialibrary.next.objects.asset.movers;

import expo.modules.medialibrary.next.objects.asset.Asset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: AssetMover.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "", "moveAssets", "", "assets", "", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "relativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "moveAssets-qTZuolk", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AssetMover {
    /* JADX INFO: renamed from: moveAssets-qTZuolk */
    Object mo12024moveAssetsqTZuolk(List<Asset> list, String str, Continuation<? super Unit> continuation);
}
