package expo.modules.medialibrary.next.objects.album.factories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: AlbumModernFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.next.objects.album.factories.AlbumModernFactory", f = "AlbumModernFactory.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {66, EACTags.APPLICATION_IMAGE}, m = "processAssetsLocation-KTsBHyQ", n = {"assets", "relativePath", "deleteOriginalAssets", "assets", "relativePath", "deleteOriginalAssets", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-AlbumModernFactory$processAssetsLocation$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1"})
final class AlbumModernFactory$processAssetsLocation$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlbumModernFactory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AlbumModernFactory$processAssetsLocation$1(AlbumModernFactory albumModernFactory, Continuation<? super AlbumModernFactory$processAssetsLocation$1> continuation) {
        super(continuation);
        this.this$0 = albumModernFactory;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m12010processAssetsLocationKTsBHyQ(null, null, null, this);
    }
}
