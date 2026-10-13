package expo.modules.medialibrary.assets;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.medialibrary.AssetNotFound;
import expo.modules.medialibrary.AssetQueryException;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import expo.modules.medialibrary.UnableToLoadException;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: GetAssetContentUri.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"getAssetContentUri", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "assetId", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GetAssetContentUriKt {

    /* JADX INFO: renamed from: expo.modules.medialibrary.assets.GetAssetContentUriKt$getAssetContentUri$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetAssetContentUri.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.assets.GetAssetContentUriKt", f = "GetAssetContentUri.kt", i = {0, 0}, l = {16}, m = "getAssetContentUri", n = {RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "assetId"}, s = {"L$0", "L$1"})
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
            return GetAssetContentUriKt.getAssetContentUri(null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.assets.GetAssetContentUriKt$getAssetContentUri$2, reason: invalid class name */
    /* JADX INFO: compiled from: GetAssetContentUri.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.assets.GetAssetContentUriKt$getAssetContentUri$2", f = "GetAssetContentUri.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $assetId;
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$assetId = str;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$assetId, this.$context, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws UnableToLoadException {
            Uri external_content_uri;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                Cursor cursorQuery = this.$context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{"_id", "media_type"}, "_id=?", new String[]{this.$assetId}, null);
                String str = this.$assetId;
                try {
                    Cursor cursor = cursorQuery;
                    JobKt.ensureActive(coroutineScope.getCoroutineContext());
                    if (cursor == null) {
                        throw new AssetQueryException();
                    }
                    if (!cursor.moveToFirst()) {
                        throw new AssetNotFound(str);
                    }
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                    int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("media_type");
                    long j = cursor.getLong(columnIndexOrThrow);
                    Integer numBoxInt = cursor.isNull(columnIndexOrThrow2) ? null : Boxing.boxInt(cursor.getInt(columnIndexOrThrow2));
                    if (Build.VERSION.SDK_INT == 29) {
                        if (numBoxInt != null && numBoxInt.intValue() == 1) {
                            external_content_uri = MediaStore.Images.Media.getContentUri("external_primary");
                        } else if (numBoxInt != null && numBoxInt.intValue() == 3) {
                            external_content_uri = MediaStore.Video.Media.getContentUri("external_primary");
                        } else {
                            external_content_uri = (numBoxInt != null && numBoxInt.intValue() == 2) ? MediaStore.Audio.Media.getContentUri("external_primary") : MediaStore.Files.getContentUri("external_primary");
                        }
                    } else if (numBoxInt != null && numBoxInt.intValue() == 1) {
                        external_content_uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if (numBoxInt != null && numBoxInt.intValue() == 3) {
                        external_content_uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else {
                        external_content_uri = (numBoxInt != null && numBoxInt.intValue() == 2) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI();
                    }
                    String string = ContentUris.withAppendedId(external_content_uri, j).toString();
                    CloseableKt.closeFinally(cursorQuery, null);
                    return string;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            } catch (SecurityException e) {
                throw new UnableToLoadException("Could not get asset: need READ_EXTERNAL_STORAGE permission", e);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object getAssetContentUri(Context context, String str, Continuation<? super String> continuation) {
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
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, context, null);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(io2, anonymousClass2, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        Intrinsics.checkNotNullExpressionValue(objWithContext, "withContext(...)");
        return objWithContext;
    }
}
