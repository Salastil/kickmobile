package expo.modules.medialibrary.next.objects.asset.movers;

import expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssetModernMover.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/movers/AssetModernMover;", "Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "mediaStorePermissionsDelegate", "Lexpo/modules/medialibrary/next/permissions/MediaStorePermissionsDelegate;", "<init>", "(Lexpo/modules/medialibrary/next/permissions/MediaStorePermissionsDelegate;)V", "moveAssets", "", "assets", "", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "relativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "moveAssets-qTZuolk", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssetModernMover implements AssetMover {
    private final MediaStorePermissionsDelegate mediaStorePermissionsDelegate;

    public AssetModernMover(MediaStorePermissionsDelegate mediaStorePermissionsDelegate) {
        Intrinsics.checkNotNullParameter(mediaStorePermissionsDelegate, "mediaStorePermissionsDelegate");
        this.mediaStorePermissionsDelegate = mediaStorePermissionsDelegate;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:32:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:? A[LOOP:0: B:24:0x00a8->B:34:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0099, code lost:
    
        if (r8.requestMediaLibraryWritePermission(r2, r0) == r1) goto L28;
     */
    @Override // expo.modules.medialibrary.next.objects.asset.movers.AssetMover
    /* JADX INFO: renamed from: moveAssets-qTZuolk */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo12024moveAssetsqTZuolk(java.util.List<expo.modules.medialibrary.next.objects.asset.Asset> r9, java.lang.String r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.objects.asset.movers.AssetModernMover.mo12024moveAssetsqTZuolk(java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
