package expo.modules.medialibrary.assets;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.medialibrary.AssetQueryException;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import expo.modules.medialibrary.MediaType;
import expo.modules.medialibrary.UnableToLoadException;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: AssetUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aL\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\f\u001aD\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0018\u001a\u0016\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0007\u001a\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u001b\u001a$\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0016\u001a.\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160!2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010$\u001a\u00020%H\u0002\u001a6\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016H\u0002\u001a\u000e\u0010*\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0016\u001a*\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160!2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016\"\u0014\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b/\u00100¨\u00061"}, d2 = {"queryAssetInfo", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "selection", "", "selectionArgs", "", "resolveWithFullInfo", "", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putAssetsInfo", "", "contentResolver", "Landroid/content/ContentResolver;", "cursor", "Landroid/database/Cursor;", "response", "", "limit", "", "offset", "(Landroid/content/ContentResolver;Landroid/database/Cursor;Ljava/util/List;IIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExifFullInfo", "exifInterface", "Landroidx/exifinterface/media/ExifInterface;", "getExifLocationForUri", "photoUri", "Landroid/net/Uri;", "getExifLocationLegacy", "getAssetDimensionsFromCursorFast", "Lkotlin/Pair;", "mediaType", "getAssetDimensionsSlow", "pending", "Lexpo/modules/medialibrary/assets/PendingAsset;", "getImageDimensionsFromExifFast", ViewProps.WIDTH, ViewProps.HEIGHT, "cursorOrientation", "exportMediaType", "maybeRotateAssetSize", "orientation", "exifReadDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getExifReadDispatcher$annotations", "()V", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AssetUtilsKt {
    private static final CoroutineDispatcher exifReadDispatcher = CoroutineDispatcher.limitedParallelism$default(Dispatchers.getIO(), 32, null, 2, null);

    private static /* synthetic */ void getExifReadDispatcher$annotations() {
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.assets.AssetUtilsKt$queryAssetInfo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AssetUtils.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.assets.AssetUtilsKt$queryAssetInfo$2", f = "AssetUtils.kt", i = {0, 0, 0, 0, 0}, l = {61}, m = "invokeSuspend", n = {"$this$withContext", "contentResolver", "assetCursor", "array", "$i$a$-use-AssetUtilsKt$queryAssetInfo$2$1"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0"})
    static final class C08722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Bundle>>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $resolveWithFullInfo;
        final /* synthetic */ String $selection;
        final /* synthetic */ String[] $selectionArgs;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08722(Context context, String str, String[] strArr, boolean z, Continuation<? super C08722> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$selection = str;
            this.$selectionArgs = strArr;
            this.$resolveWithFullInfo = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08722 c08722 = new C08722(this.$context, this.$selection, this.$selectionArgs, this.$resolveWithFullInfo, continuation);
            c08722.L$0 = obj;
            return c08722;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArrayList<Bundle>> continuation) {
            return ((C08722) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            Throwable th;
            Closeable closeable;
            ArrayList arrayList;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    arrayList = (ArrayList) this.L$4;
                    closeable = (Closeable) this.L$2;
                    try {
                        ResultKt.throwOnFailure(obj);
                        CloseableKt.closeFinally(closeable, null);
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            CloseableKt.closeFinally(closeable, th);
                            throw th3;
                        }
                    }
                }
                ResultKt.throwOnFailure(obj);
                ContentResolver contentResolver = this.$context.getContentResolver();
                Cursor cursorQuery = contentResolver.query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), MediaLibraryConstantsKt.getASSET_PROJECTION(), this.$selection, this.$selectionArgs, null);
                boolean z = this.$resolveWithFullInfo;
                try {
                    Cursor cursor = cursorQuery;
                    JobKt.ensureActive(coroutineScope.getCoroutineContext());
                    if (cursor == null) {
                        throw new AssetQueryException();
                    }
                    if (cursor.getCount() == 1) {
                        cursor.moveToFirst();
                        ArrayList arrayList2 = new ArrayList();
                        Intrinsics.checkNotNull(contentResolver);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(contentResolver);
                        this.L$2 = cursorQuery;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(cursor);
                        this.L$4 = arrayList2;
                        this.I$0 = 0;
                        this.label = 1;
                        if (AssetUtilsKt.putAssetsInfo(contentResolver, cursor, arrayList2, 1, 0, z, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        closeable = cursorQuery;
                        arrayList = arrayList2;
                        CloseableKt.closeFinally(closeable, null);
                        return arrayList;
                    }
                    CloseableKt.closeFinally(cursorQuery, null);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    closeable = cursorQuery;
                    throw th;
                }
            } catch (Exception e) {
                if (!(e instanceof SecurityException)) {
                    if (!(e instanceof IOException)) {
                        if (e instanceof UnsupportedOperationException) {
                            String message = e.getMessage();
                            if (message == null) {
                                message = "Invalid MediaType";
                            }
                            throw new UnableToLoadException(message, e);
                        }
                        throw e;
                    }
                    throw new UnableToLoadException("Could not read file " + e.getMessage(), e);
                }
                throw new UnableToLoadException("Could not get asset: need READ_EXTERNAL_STORAGE permission", e);
            }
        }
    }

    public static final Object queryAssetInfo(Context context, String str, String[] strArr, boolean z, Continuation<? super ArrayList<Bundle>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C08722(context, str, strArr, z, null), continuation);
    }

    public static final Object putAssetsInfo(ContentResolver contentResolver, Cursor cursor, List<Bundle> list, int i, int i2, boolean z, Continuation<? super Unit> continuation) throws UnsupportedOperationException, IOException {
        ArrayList arrayList;
        Bundle bundle;
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("_display_name");
        int columnIndex3 = cursor.getColumnIndex("media_type");
        int columnIndex4 = cursor.getColumnIndex("datetaken");
        int columnIndex5 = cursor.getColumnIndex("date_modified");
        int columnIndex6 = cursor.getColumnIndex("duration");
        int columnIndex7 = cursor.getColumnIndex("_data");
        int columnIndex8 = cursor.getColumnIndex("bucket_id");
        int columnIndex9 = cursor.getColumnIndex(ViewProps.WIDTH);
        int columnIndex10 = cursor.getColumnIndex(ViewProps.HEIGHT);
        int columnIndex11 = cursor.getColumnIndex("orientation");
        if (!cursor.moveToPosition(i2)) {
            return Unit.INSTANCE;
        }
        ArrayList arrayList2 = new ArrayList();
        int i3 = columnIndex8;
        int i4 = 0;
        while (true) {
            arrayList = arrayList2;
            if (i4 >= i || cursor.isAfterLast()) {
                break;
            }
            String string = cursor.getString(columnIndex);
            int i5 = columnIndex;
            String string2 = cursor.getString(columnIndex7);
            int i6 = columnIndex7;
            int i7 = i4;
            String str = "file://" + string2;
            int i8 = cursor.getInt(columnIndex3);
            int i9 = cursor.getInt(columnIndex9);
            int i10 = cursor.getInt(columnIndex10);
            int i11 = cursor.getInt(columnIndex11);
            Pair<Integer, Integer> assetDimensionsFromCursorFast = getAssetDimensionsFromCursorFast(cursor, i8);
            int iIntValue = assetDimensionsFromCursorFast != null ? assetDimensionsFromCursorFast.getFirst().intValue() : 0;
            int iIntValue2 = assetDimensionsFromCursorFast != null ? assetDimensionsFromCursorFast.getSecond().intValue() : 0;
            int i12 = columnIndex9;
            Bundle bundle2 = new Bundle();
            int i13 = columnIndex10;
            bundle2.putString("id", string);
            bundle2.putString("filename", cursor.getString(columnIndex2));
            bundle2.putString("uri", str);
            bundle2.putString("mediaType", exportMediaType(i8));
            bundle2.putLong(ViewProps.WIDTH, iIntValue);
            bundle2.putLong(ViewProps.HEIGHT, iIntValue2);
            int i14 = columnIndex2;
            bundle2.putLong("creationTime", cursor.getLong(columnIndex4));
            bundle2.putDouble("modificationTime", cursor.getLong(columnIndex5) * 1000.0d);
            bundle2.putDouble("duration", ((double) cursor.getInt(columnIndex6)) / 1000.0d);
            int i15 = i3;
            bundle2.putString("albumId", cursor.getString(i15));
            boolean z2 = assetDimensionsFromCursorFast == null;
            if (z2 || (z && i8 == 1)) {
                Intrinsics.checkNotNull(string2);
                arrayList2 = arrayList;
                bundle = bundle2;
                arrayList2.add(new PendingAsset(bundle2, string2, i8, i9, i10, i11, z2));
            } else {
                arrayList2 = arrayList;
                bundle = bundle2;
            }
            cursor.moveToNext();
            list.add(bundle);
            i4 = i7 + 1;
            i3 = i15;
            columnIndex2 = i14;
            columnIndex = i5;
            columnIndex7 = i6;
            columnIndex3 = columnIndex3;
            columnIndex9 = i12;
            columnIndex10 = i13;
        }
        if (!arrayList.isEmpty()) {
            Object objWithContext = BuildersKt.withContext(exifReadDispatcher, new AnonymousClass2(arrayList, z, contentResolver, null), continuation);
            return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.assets.AssetUtilsKt$putAssetsInfo$2, reason: invalid class name */
    /* JADX INFO: compiled from: AssetUtils.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.assets.AssetUtilsKt$putAssetsInfo$2", f = "AssetUtils.kt", i = {0}, l = {JfifUtil.MARKER_SOS}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        final /* synthetic */ List<PendingAsset> $pendingAdditionalInfoAssets;
        final /* synthetic */ boolean $resolveWithFullInfo;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<PendingAsset> list, boolean z, ContentResolver contentResolver, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$pendingAdditionalInfoAssets = list;
            this.$resolveWithFullInfo = z;
            this.$contentResolver = contentResolver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$pendingAdditionalInfoAssets, this.$resolveWithFullInfo, this.$contentResolver, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Unit>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            List<PendingAsset> list = this.$pendingAdditionalInfoAssets;
            boolean z = this.$resolveWithFullInfo;
            ContentResolver contentResolver = this.$contentResolver;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AssetUtilsKt$putAssetsInfo$2$1$1((PendingAsset) it.next(), z, contentResolver, null), 3, null));
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.label = 1;
            Object objAwaitAll = AwaitKt.awaitAll(arrayList, this);
            return objAwaitAll == coroutine_suspended ? coroutine_suspended : objAwaitAll;
        }
    }

    public static final void getExifFullInfo(ExifInterface exifInterface, Bundle response) {
        Intrinsics.checkNotNullParameter(exifInterface, "exifInterface");
        Intrinsics.checkNotNullParameter(response, "response");
        Bundle bundle = new Bundle();
        for (String[] strArr : MediaLibraryConstantsKt.getEXIF_TAGS()) {
            String str = strArr[0];
            String str2 = strArr[1];
            if (exifInterface.getAttribute(str2) != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != -1325958191) {
                    if (iHashCode != -891985903) {
                        if (iHashCode == 104431 && str.equals("int")) {
                            bundle.putInt(str2, exifInterface.getAttributeInt(str2, 0));
                        }
                    } else if (str.equals(TypedValues.Custom.S_STRING)) {
                        bundle.putString(str2, exifInterface.getAttribute(str2));
                    }
                } else if (str.equals("double")) {
                    bundle.putDouble(str2, exifInterface.getAttributeDouble(str2, 0.0d));
                }
            }
        }
        response.putParcelable("exif", bundle);
    }

    public static final Bundle getExifLocationForUri(ContentResolver contentResolver, Uri photoUri) throws UnsupportedOperationException, IOException {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(photoUri, "photoUri");
        try {
            Uri requireOriginal = MediaStore.setRequireOriginal(photoUri);
            Intrinsics.checkNotNullExpressionValue(requireOriginal, "setRequireOriginal(...)");
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(requireOriginal);
            if (inputStreamOpenInputStream == null) {
                return null;
            }
            InputStream inputStream = inputStreamOpenInputStream;
            try {
                double[] latLong = new ExifInterface(inputStream).getLatLong();
                if (latLong != null) {
                    double d = latLong[0];
                    double d2 = latLong[1];
                    bundle = new Bundle();
                    bundle.putDouble("latitude", d);
                    bundle.putDouble("longitude", d2);
                } else {
                    bundle = null;
                }
                CloseableKt.closeFinally(inputStream, null);
                return bundle;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            Log.w("expo-media-library", "Could not parse EXIF tags for " + photoUri);
            e.printStackTrace();
            return null;
        } catch (UnsupportedOperationException unused) {
            throw new UnsupportedOperationException("Cannot access ExifInterface because of missing ACCESS_MEDIA_LOCATION permission");
        }
    }

    public static final Bundle getExifLocationLegacy(ExifInterface exifInterface) {
        Intrinsics.checkNotNullParameter(exifInterface, "exifInterface");
        double[] latLong = exifInterface.getLatLong();
        if (latLong == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("latitude", latLong[0]);
        bundle.putDouble("longitude", latLong[1]);
        return bundle;
    }

    public static final Pair<Integer, Integer> getAssetDimensionsFromCursorFast(Cursor cursor, int i) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        if (i == 3) {
            int columnIndex = cursor.getColumnIndex(ViewProps.WIDTH);
            int columnIndex2 = cursor.getColumnIndex(ViewProps.HEIGHT);
            int i2 = cursor.getInt(columnIndex);
            int i3 = cursor.getInt(columnIndex2);
            if (i2 <= 0 || i3 <= 0) {
                return null;
            }
            return maybeRotateAssetSize(i2, i3, cursor.getInt(cursor.getColumnIndex("orientation")));
        }
        int columnIndex3 = cursor.getColumnIndex(ViewProps.WIDTH);
        int columnIndex4 = cursor.getColumnIndex(ViewProps.HEIGHT);
        int columnIndex5 = cursor.getColumnIndex("orientation");
        int i4 = cursor.getInt(columnIndex3);
        int i5 = cursor.getInt(columnIndex4);
        int i6 = cursor.getInt(columnIndex5);
        if (i != 1 || (i4 > 0 && i5 > 0)) {
            return maybeRotateAssetSize(i4, i5, i6);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, Integer> getAssetDimensionsSlow(ContentResolver contentResolver, ExifInterface exifInterface, PendingAsset pendingAsset) throws IOException {
        if (pendingAsset.getMediaType() == 3) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(Uri.parse("file://" + pendingAsset.getPath()), "r");
                try {
                    AssetFileDescriptor assetFileDescriptor = assetFileDescriptorOpenAssetFileDescriptor;
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        MediaMetadataRetriever mediaMetadataRetriever2 = mediaMetadataRetriever;
                        Intrinsics.checkNotNull(assetFileDescriptor);
                        mediaMetadataRetriever2.setDataSource(assetFileDescriptor.getFileDescriptor());
                        String strExtractMetadata = mediaMetadataRetriever2.extractMetadata(18);
                        Intrinsics.checkNotNull(strExtractMetadata);
                        int i = Integer.parseInt(strExtractMetadata);
                        String strExtractMetadata2 = mediaMetadataRetriever2.extractMetadata(19);
                        Intrinsics.checkNotNull(strExtractMetadata2);
                        int i2 = Integer.parseInt(strExtractMetadata2);
                        String strExtractMetadata3 = mediaMetadataRetriever2.extractMetadata(24);
                        Intrinsics.checkNotNull(strExtractMetadata3);
                        Pair<Integer, Integer> pairMaybeRotateAssetSize = maybeRotateAssetSize(i, i2, Integer.parseInt(strExtractMetadata3));
                        AutoCloseableKt.closeFinally(mediaMetadataRetriever, null);
                        CloseableKt.closeFinally(assetFileDescriptorOpenAssetFileDescriptor, null);
                        return pairMaybeRotateAssetSize;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            AutoCloseableKt.closeFinally(mediaMetadataRetriever, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(assetFileDescriptorOpenAssetFileDescriptor, th3);
                        throw th4;
                    }
                }
            } catch (FileNotFoundException e) {
                Log.e("expo-media-library", "ContentResolver failed to read " + pendingAsset.getPath() + ": " + e.getMessage());
                return new Pair<>(0, 0);
            } catch (NumberFormatException e2) {
                Log.e("expo-media-library", "MediaMetadataRetriever unexpectedly returned non-integer: " + e2.getMessage());
                return new Pair<>(0, 0);
            } catch (RuntimeException e3) {
                Log.e("expo-media-library", "MediaMetadataRetriever finished with unexpected error: " + e3.getMessage());
                return new Pair<>(0, 0);
            }
        }
        int cursorWidth = pendingAsset.getCursorWidth();
        int cursorHeight = pendingAsset.getCursorHeight();
        int cursorOrientation = pendingAsset.getCursorOrientation();
        if (pendingAsset.getMediaType() == 1 && (cursorWidth <= 0 || cursorHeight <= 0)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(pendingAsset.getPath(), options);
            int i3 = options.outWidth;
            cursorHeight = options.outHeight;
            cursorWidth = i3;
        }
        return getImageDimensionsFromExifFast(exifInterface, cursorWidth, cursorHeight, cursorOrientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, Integer> getImageDimensionsFromExifFast(ExifInterface exifInterface, int i, int i2, int i3) {
        int attributeInt;
        if (exifInterface != null && ((attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)) == 5 || attributeInt == 6 || attributeInt == 7 || attributeInt == 8)) {
            i3 = 90;
        }
        return maybeRotateAssetSize(i, i2, i3);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0012  */
    public static final String exportMediaType(int i) {
        MediaType mediaType;
        if (i == 1) {
            mediaType = MediaType.PHOTO;
        } else if (i == 2) {
            mediaType = MediaType.AUDIO;
        } else if (i == 3) {
            mediaType = MediaType.VIDEO;
        } else if (i == 4) {
            mediaType = MediaType.AUDIO;
        } else {
            mediaType = MediaType.UNKNOWN;
        }
        return mediaType.getApiName();
    }

    public static final Pair<Integer, Integer> maybeRotateAssetSize(int i, int i2, int i3) {
        if (Math.abs(i3) % RotationOptions.ROTATE_180 == 90) {
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
