package expo.modules.medialibrary.albums.migration;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.medialibrary.AlbumException;
import expo.modules.medialibrary.MediaLibraryUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MigrateAlbum.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0087@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"migrateAlbum", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "assetFiles", "", "Lexpo/modules/medialibrary/MediaLibraryUtils$AssetFile;", "albumDirName", "", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MigrateAlbumKt {

    /* JADX INFO: renamed from: expo.modules.medialibrary.albums.migration.MigrateAlbumKt$migrateAlbum$2, reason: invalid class name */
    /* JADX INFO: compiled from: MigrateAlbum.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.albums.migration.MigrateAlbumKt$migrateAlbum$2", f = "MigrateAlbum.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $albumDirName;
        final /* synthetic */ List<MediaLibraryUtils.AssetFile> $assetFiles;
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<MediaLibraryUtils.AssetFile> list, String str, Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$assetFiles = list;
            this.$albumDirName = str;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$assetFiles, this.$albumDirName, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws AlbumException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<MediaLibraryUtils.AssetFile> list = this.$assetFiles;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(MediaLibraryUtils.INSTANCE.getRelativePathForAssetType(((MediaLibraryUtils.AssetFile) it.next()).getMimeType(), false));
            }
            Set set = CollectionsKt.toSet(arrayList);
            if (set.size() > 1) {
                throw new AlbumException("The album contains incompatible file types.");
            }
            String str = set.iterator().next() + File.separator + this.$albumDirName;
            ContentValues contentValues = new ContentValues();
            contentValues.put("relative_path", str);
            List<MediaLibraryUtils.AssetFile> list2 = this.$assetFiles;
            Context context = this.$context;
            for (MediaLibraryUtils.AssetFile assetFile : list2) {
                context.getContentResolver().update(ContentUris.withAppendedId(MediaLibraryUtils.INSTANCE.mimeTypeToExternalUri(assetFile.getMimeType()), Long.parseLong(assetFile.getAssetId())), contentValues, null);
            }
            return Unit.INSTANCE;
        }
    }

    public static final Object migrateAlbum(Context context, List<MediaLibraryUtils.AssetFile> list, String str, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(list, str, context, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
