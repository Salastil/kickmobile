package expo.modules.medialibrary.next.objects.album;

import expo.modules.medialibrary.next.exceptions.AlbumPropertyNotFoundException;
import expo.modules.medialibrary.next.exceptions.ContentResolverNotObtainedException;
import expo.modules.medialibrary.next.objects.wrappers.RelativePath;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Album.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.objects.album.Album", f = "Album.kt", i = {}, l = {44, 47}, m = "getRelativePath-MwbCjzw", n = {}, s = {})
final class Album$getRelativePath$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Album this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Album$getRelativePath$1(Album album, Continuation<? super Album$getRelativePath$1> continuation) {
        super(continuation);
        this.this$0 = album;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws AlbumPropertyNotFoundException, ContentResolverNotObtainedException {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM12005getRelativePathMwbCjzw = this.this$0.m12005getRelativePathMwbCjzw(this);
        return objM12005getRelativePathMwbCjzw == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12005getRelativePathMwbCjzw : RelativePath.m12042boximpl((String) objM12005getRelativePathMwbCjzw);
    }
}
