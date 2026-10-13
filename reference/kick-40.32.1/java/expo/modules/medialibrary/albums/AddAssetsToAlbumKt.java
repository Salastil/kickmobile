package expo.modules.medialibrary.albums;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.medialibrary.AlbumException;
import expo.modules.medialibrary.MediaLibraryUtils;
import expo.modules.medialibrary.PermissionsException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: AddAssetsToAlbum.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"addAssetsToAlbum", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "assetIds", "", "", "albumId", "copyToAlbum", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AddAssetsToAlbumKt {

    /* JADX INFO: renamed from: expo.modules.medialibrary.albums.AddAssetsToAlbumKt$addAssetsToAlbum$2, reason: invalid class name */
    /* JADX INFO: compiled from: AddAssetsToAlbum.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.albums.AddAssetsToAlbumKt$addAssetsToAlbum$2", f = "AddAssetsToAlbum.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {26, 51}, m = "invokeSuspend", n = {"$this$withContext", "strategy", "$this$withContext", "strategy", "album", "assets", "paths", "result", "atomicInteger"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $albumId;
        final /* synthetic */ String[] $assetIds;
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $copyToAlbum;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z, Context context, String str, String[] strArr, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$copyToAlbum = z;
            this.$context = context;
            this.$albumId = str;
            this.$assetIds = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$copyToAlbum, this.$context, this.$albumId, this.$assetIds, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws AlbumException, PermissionsException {
            AssetFileStrategy moveStrategy;
            AssetFileStrategy assetFileStrategy;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$copyToAlbum) {
                    moveStrategy = AssetFileStrategy.INSTANCE.getCopyStrategy();
                } else {
                    moveStrategy = AssetFileStrategy.INSTANCE.getMoveStrategy();
                }
                assetFileStrategy = moveStrategy;
                this.L$0 = coroutineScope;
                this.L$1 = assetFileStrategy;
                this.label = 1;
                obj = AlbumUtilsKt.getAlbumFile(this.$context, this.$albumId, this);
                if (obj != coroutine_suspended) {
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            assetFileStrategy = (AssetFileStrategy) this.L$1;
            ResultKt.throwOnFailure(obj);
            File file = (File) obj;
            JobKt.ensureActive(coroutineScope.getCoroutineContext());
            if (Build.VERSION.SDK_INT >= 30 && !file.canWrite()) {
                throw new PermissionsException("The application doesn't have permission to write to the album's directory. For more information, check out https://expo.fyi/android-r.");
            }
            MediaLibraryUtils mediaLibraryUtils = MediaLibraryUtils.INSTANCE;
            Context context = this.$context;
            String[] strArr = this.$assetIds;
            List<MediaLibraryUtils.AssetFile> assetsById = mediaLibraryUtils.getAssetsById(context, (String[]) Arrays.copyOf(strArr, strArr.length));
            JobKt.ensureActive(coroutineScope.getCoroutineContext());
            List<MediaLibraryUtils.AssetFile> list = assetsById;
            Context context2 = this.$context;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(assetFileStrategy.apply((MediaLibraryUtils.AssetFile) it.next(), file, context2).getPath());
            }
            ArrayList arrayList2 = arrayList;
            JobKt.ensureActive(coroutineScope.getCoroutineContext());
            final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            final AtomicInteger atomicInteger = new AtomicInteger(arrayList2.size());
            MediaScannerConnection.scanFile(this.$context, (String[]) arrayList2.toArray(new String[0]), null, new MediaScannerConnection.OnScanCompletedListener() { // from class: expo.modules.medialibrary.albums.AddAssetsToAlbumKt$addAssetsToAlbum$2$$ExternalSyntheticLambda0
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str, Uri uri) {
                    AddAssetsToAlbumKt.AnonymousClass2.invokeSuspend$lambda$1(atomicInteger, completableDeferredCompletableDeferred$default, str, uri);
                }
            });
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(assetFileStrategy);
            this.L$2 = SpillingKt.nullOutSpilledVariable(file);
            this.L$3 = SpillingKt.nullOutSpilledVariable(assetsById);
            this.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
            this.L$5 = SpillingKt.nullOutSpilledVariable(completableDeferredCompletableDeferred$default);
            this.L$6 = SpillingKt.nullOutSpilledVariable(atomicInteger);
            this.label = 2;
            Object objAwait = completableDeferredCompletableDeferred$default.await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }

        static final void invokeSuspend$lambda$1(AtomicInteger atomicInteger, CompletableDeferred completableDeferred, String str, Uri uri) {
            if (atomicInteger.decrementAndGet() == 0) {
                completableDeferred.complete(true);
            }
        }
    }

    public static final Object addAssetsToAlbum(Context context, String[] strArr, String str, boolean z, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(z, context, str, strArr, null), continuation);
    }
}
