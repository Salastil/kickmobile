package expo.modules.medialibrary.next.objects.asset.movers;

import expo.modules.medialibrary.next.objects.asset.Asset;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: AssetLegacyMover.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/movers/AssetLegacyMover;", "Lexpo/modules/medialibrary/next/objects/asset/movers/AssetMover;", "<init>", "()V", "moveAssets", "", "assets", "", "Lexpo/modules/medialibrary/next/objects/asset/Asset;", "relativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "moveAssets-qTZuolk", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssetLegacyMover implements AssetMover {
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // expo.modules.medialibrary.next.objects.asset.movers.AssetMover
    /* JADX INFO: renamed from: moveAssets-qTZuolk, reason: not valid java name */
    public Object mo12024moveAssetsqTZuolk(List<Asset> list, String str, Continuation<? super Unit> continuation) {
        AssetLegacyMover$moveAssets$1 assetLegacyMover$moveAssets$1;
        String str2;
        Iterator it;
        AssetLegacyMover$moveAssets$1 assetLegacyMover$moveAssets$2;
        Iterable iterable;
        int i;
        if (continuation instanceof AssetLegacyMover$moveAssets$1) {
            assetLegacyMover$moveAssets$1 = (AssetLegacyMover$moveAssets$1) continuation;
            if ((assetLegacyMover$moveAssets$1.label & Integer.MIN_VALUE) != 0) {
                assetLegacyMover$moveAssets$1.label -= Integer.MIN_VALUE;
            } else {
                assetLegacyMover$moveAssets$1 = new AssetLegacyMover$moveAssets$1(this, continuation);
            }
        } else {
            assetLegacyMover$moveAssets$1 = new AssetLegacyMover$moveAssets$1(this, continuation);
        }
        Object obj = assetLegacyMover$moveAssets$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = assetLegacyMover$moveAssets$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            List<Asset> list2 = list;
            AssetLegacyMover$moveAssets$1 assetLegacyMover$moveAssets$3 = assetLegacyMover$moveAssets$1;
            str2 = str;
            it = list2.iterator();
            assetLegacyMover$moveAssets$2 = assetLegacyMover$moveAssets$3;
            iterable = list2;
            i = 0;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = assetLegacyMover$moveAssets$1.I$1;
            int i4 = assetLegacyMover$moveAssets$1.I$0;
            Object obj2 = assetLegacyMover$moveAssets$1.L$4;
            it = (Iterator) assetLegacyMover$moveAssets$1.L$3;
            Iterable iterable2 = (Iterable) assetLegacyMover$moveAssets$1.L$2;
            String str3 = (String) assetLegacyMover$moveAssets$1.L$1;
            List<Asset> list3 = (List) assetLegacyMover$moveAssets$1.L$0;
            ResultKt.throwOnFailure(obj);
            assetLegacyMover$moveAssets$2 = assetLegacyMover$moveAssets$1;
            str2 = str3;
            iterable = iterable2;
            i = i4;
            list = list3;
        }
        while (it.hasNext()) {
            Object next = it.next();
            Asset asset = (Asset) next;
            assetLegacyMover$moveAssets$2.L$0 = SpillingKt.nullOutSpilledVariable(list);
            assetLegacyMover$moveAssets$2.L$1 = str2;
            assetLegacyMover$moveAssets$2.L$2 = SpillingKt.nullOutSpilledVariable(iterable);
            assetLegacyMover$moveAssets$2.L$3 = it;
            assetLegacyMover$moveAssets$2.L$4 = SpillingKt.nullOutSpilledVariable(next);
            assetLegacyMover$moveAssets$2.L$5 = SpillingKt.nullOutSpilledVariable(asset);
            assetLegacyMover$moveAssets$2.I$0 = i;
            assetLegacyMover$moveAssets$2.I$1 = 0;
            assetLegacyMover$moveAssets$2.label = 1;
            if (asset.m12013movedXLngQ8(str2, assetLegacyMover$moveAssets$2) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
