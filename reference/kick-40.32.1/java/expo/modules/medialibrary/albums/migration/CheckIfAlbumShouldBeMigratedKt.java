package expo.modules.medialibrary.albums.migration;

import android.content.Context;
import android.database.Cursor;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.medialibrary.AlbumNotFound;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: CheckIfAlbumShouldBeMigrated.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0087@¢\u0006\u0002\u0010\u0006\u001a \u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0083@¢\u0006\u0002\u0010\u0006¨\u0006\t"}, d2 = {"checkIfAlbumShouldBeMigrated", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "albumId", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlbumDirectory", "Ljava/io/File;", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CheckIfAlbumShouldBeMigratedKt {

    /* JADX INFO: renamed from: expo.modules.medialibrary.albums.migration.CheckIfAlbumShouldBeMigratedKt$checkIfAlbumShouldBeMigrated$1, reason: invalid class name */
    /* JADX INFO: compiled from: CheckIfAlbumShouldBeMigrated.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.albums.migration.CheckIfAlbumShouldBeMigratedKt", f = "CheckIfAlbumShouldBeMigrated.kt", i = {0, 0}, l = {16}, m = "checkIfAlbumShouldBeMigrated", n = {RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "albumId"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CheckIfAlbumShouldBeMigratedKt.checkIfAlbumShouldBeMigrated(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object checkIfAlbumShouldBeMigrated(Context context, String str, Continuation<? super Boolean> continuation) throws AlbumNotFound {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object albumDirectory = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(albumDirectory);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.label = 1;
            albumDirectory = getAlbumDirectory(context, str, anonymousClass1);
            if (albumDirectory == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(albumDirectory);
        }
        File file = (File) albumDirectory;
        if (file == null) {
            throw new AlbumNotFound();
        }
        return Boxing.boxBoolean(!file.canWrite());
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.albums.migration.CheckIfAlbumShouldBeMigratedKt$getAlbumDirectory$2, reason: invalid class name */
    /* JADX INFO: compiled from: CheckIfAlbumShouldBeMigrated.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.albums.migration.CheckIfAlbumShouldBeMigratedKt$getAlbumDirectory$2", f = "CheckIfAlbumShouldBeMigrated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
        final /* synthetic */ String $albumId;
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$albumId = str;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$albumId, this.$context, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String[] strArr = {this.$albumId};
            Cursor cursorQuery = this.$context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{"_data"}, "media_type != 0 AND bucket_id=?", strArr, null);
            try {
                Cursor cursor = cursorQuery;
                JobKt.ensureActive(coroutineScope.getCoroutineContext());
                if (cursor != null && cursor.moveToNext()) {
                    File file = new File(cursor.getString(cursor.getColumnIndex("_data")));
                    if (file.isFile()) {
                        String parent = file.getParent();
                        if (parent == null) {
                            CloseableKt.closeFinally(cursorQuery, null);
                            return null;
                        }
                        File file2 = new File(parent);
                        CloseableKt.closeFinally(cursorQuery, null);
                        return file2;
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
                return null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getAlbumDirectory(Context context, String str, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, context, null), continuation);
    }
}
