package expo.modules.medialibrary.next.objects.asset;

import android.net.Uri;
import android.os.Bundle;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.medialibrary.next.objects.album.Album;
import expo.modules.medialibrary.next.objects.asset.delegates.AssetDelegate;
import expo.modules.medialibrary.next.objects.wrappers.MediaType;
import expo.modules.medialibrary.next.objects.wrappers.MimeType;
import expo.modules.medialibrary.next.records.AssetInfo;
import expo.modules.medialibrary.next.records.Location;
import expo.modules.medialibrary.next.records.Shape;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: compiled from: Asset.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0086@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001a\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0086@¢\u0006\u0002\u0010\u000eJ\u0010\u0010 \u001a\u00020!H\u0086@¢\u0006\u0004\b\"\u0010\u000eJ\u0010\u0010#\u001a\u0004\u0018\u00010$H\u0086@¢\u0006\u0002\u0010\u000eJ\u000e\u0010%\u001a\u00020&H\u0086@¢\u0006\u0002\u0010\u000eJ\u000e\u0010'\u001a\u00020(H\u0086@¢\u0006\u0002\u0010\u000eJ\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020(H\u0086@¢\u0006\u0002\u0010,J\u0018\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0086@¢\u0006\u0004\b0\u00101J\u0018\u00102\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/H\u0086@¢\u0006\u0004\b3\u00101J\u000e\u00104\u001a\u00020*H\u0086@¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u00065"}, d2 = {"Lexpo/modules/medialibrary/next/objects/asset/Asset;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "assetDelegate", "Lexpo/modules/medialibrary/next/objects/asset/delegates/AssetDelegate;", "<init>", "(Lexpo/modules/medialibrary/next/objects/asset/delegates/AssetDelegate;)V", "getAssetDelegate", "()Lexpo/modules/medialibrary/next/objects/asset/delegates/AssetDelegate;", "contentUri", "Landroid/net/Uri;", "getContentUri", "()Landroid/net/Uri;", "getCreationTime", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDuration", "getFilename", "", "getHeight", "", "getWidth", "getShape", "Lexpo/modules/medialibrary/next/records/Shape;", "getMediaType", "Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;", "getModificationTime", "getUri", "getInfo", "Lexpo/modules/medialibrary/next/records/AssetInfo;", "getAlbums", "", "Lexpo/modules/medialibrary/next/objects/album/Album;", "getMimeType", "Lexpo/modules/medialibrary/next/objects/wrappers/MimeType;", "getMimeType-dctPOJs", "getLocation", "Lexpo/modules/medialibrary/next/records/Location;", "getExif", "Landroid/os/Bundle;", "getFavorite", "", "setFavorite", "", "isFavorite", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "move", "relativePath", "Lexpo/modules/medialibrary/next/objects/wrappers/RelativePath;", "move-dXLngQ8", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copy", "copy-dXLngQ8", "delete", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Asset extends SharedObject {
    private final AssetDelegate assetDelegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Asset(AssetDelegate assetDelegate) {
        super(null, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(assetDelegate, "assetDelegate");
        this.assetDelegate = assetDelegate;
    }

    public final AssetDelegate getAssetDelegate() {
        return this.assetDelegate;
    }

    public final Uri getContentUri() {
        return this.assetDelegate.getContentUri();
    }

    public final Object getCreationTime(Continuation<? super Long> continuation) {
        return this.assetDelegate.getCreationTime(continuation);
    }

    public final Object getDuration(Continuation<? super Long> continuation) {
        return this.assetDelegate.getDuration(continuation);
    }

    public final Object getFilename(Continuation<? super String> continuation) {
        return this.assetDelegate.getFilename(continuation);
    }

    public final Object getHeight(Continuation<? super Integer> continuation) {
        return this.assetDelegate.getHeight(continuation);
    }

    public final Object getWidth(Continuation<? super Integer> continuation) {
        return this.assetDelegate.getWidth(continuation);
    }

    public final Object getShape(Continuation<? super Shape> continuation) {
        return this.assetDelegate.getShape(continuation);
    }

    public final Object getMediaType(Continuation<? super MediaType> continuation) {
        return this.assetDelegate.getMediaType(continuation);
    }

    public final Object getModificationTime(Continuation<? super Long> continuation) {
        return this.assetDelegate.getModificationTime(continuation);
    }

    public final Object getUri(Continuation<? super Uri> continuation) {
        return this.assetDelegate.getUri(continuation);
    }

    public final Object getInfo(Continuation<? super AssetInfo> continuation) {
        return this.assetDelegate.getInfo(continuation);
    }

    public final Object getAlbums(Continuation<? super List<Album>> continuation) {
        return this.assetDelegate.getAlbums(continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getMimeType-dctPOJs, reason: not valid java name */
    public final Object m12012getMimeTypedctPOJs(Continuation<? super MimeType> continuation) {
        Asset$getMimeType$1 asset$getMimeType$1;
        Object objMo12015getMimeTypedctPOJs;
        if (continuation instanceof Asset$getMimeType$1) {
            asset$getMimeType$1 = (Asset$getMimeType$1) continuation;
            if ((asset$getMimeType$1.label & Integer.MIN_VALUE) != 0) {
                asset$getMimeType$1.label -= Integer.MIN_VALUE;
            } else {
                asset$getMimeType$1 = new Asset$getMimeType$1(this, continuation);
            }
        } else {
            asset$getMimeType$1 = new Asset$getMimeType$1(this, continuation);
        }
        Object obj = asset$getMimeType$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = asset$getMimeType$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AssetDelegate assetDelegate = this.assetDelegate;
            asset$getMimeType$1.label = 1;
            objMo12015getMimeTypedctPOJs = assetDelegate.mo12015getMimeTypedctPOJs(asset$getMimeType$1);
            if (objMo12015getMimeTypedctPOJs == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objMo12015getMimeTypedctPOJs = ((MimeType) obj).m12040unboximpl();
        }
        return (String) objMo12015getMimeTypedctPOJs;
    }

    public final Object getLocation(Continuation<? super Location> continuation) {
        return this.assetDelegate.getLocation(continuation);
    }

    public final Object getExif(Continuation<? super Bundle> continuation) {
        return this.assetDelegate.getExif(continuation);
    }

    public final Object getFavorite(Continuation<? super Boolean> continuation) {
        return this.assetDelegate.getFavorite(continuation);
    }

    public final Object setFavorite(boolean z, Continuation<? super Unit> continuation) {
        Object favorite = this.assetDelegate.setFavorite(z, continuation);
        return favorite == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? favorite : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: move-dXLngQ8, reason: not valid java name */
    public final Object m12013movedXLngQ8(String str, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new Asset$move$2(this, str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: copy-dXLngQ8, reason: not valid java name */
    public final Object m12011copydXLngQ8(String str, Continuation<? super Asset> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new Asset$copy$2(this, str, null), continuation);
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.objects.asset.Asset$delete$2, reason: invalid class name */
    /* JADX INFO: compiled from: Asset.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.objects.asset.Asset$delete$2", f = "Asset.kt", i = {}, l = {EACTags.INTEGRATED_CIRCUIT_MANUFACTURER_ID}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Asset.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Asset.this.getAssetDelegate().delete(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object delete(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
