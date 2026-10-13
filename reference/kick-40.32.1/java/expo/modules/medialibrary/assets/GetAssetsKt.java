package expo.modules.medialibrary.assets;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.medialibrary.AssetQueryException;
import expo.modules.medialibrary.AssetsOptions;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import expo.modules.medialibrary.PermissionsException;
import expo.modules.medialibrary.UnableToLoadException;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: GetAssets.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"getAssets", "Landroid/os/Bundle;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "assetOptions", "Lexpo/modules/medialibrary/AssetsOptions;", "(Landroid/content/Context;Lexpo/modules/medialibrary/AssetsOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GetAssetsKt {

    /* JADX INFO: renamed from: expo.modules.medialibrary.assets.GetAssetsKt$getAssets$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetAssets.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.assets.GetAssetsKt", f = "GetAssets.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {31}, m = "getAssets", n = {RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "assetOptions", "contentResolver", "selection", "order", "assetsCursor", "assetsInfo", "limit", "offset", "$i$a$-use-GetAssetsKt$getAssets$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "D$0", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        double D$0;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetAssetsKt.getAssets(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object getAssets(Context context, AssetsOptions assetsOptions, Continuation<? super Bundle> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        Throwable th;
        Closeable closeable;
        Cursor cursor;
        ArrayList<? extends Parcelable> arrayList;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ContentResolver contentResolver = context.getContentResolver();
            try {
                GetAssetsQuery queryFromOptions = GetAssetsQueryKt.getQueryFromOptions(assetsOptions);
                String selection = queryFromOptions.getSelection();
                String order = queryFromOptions.getOrder();
                double limit = queryFromOptions.getLimit();
                int offset = queryFromOptions.getOffset();
                Cursor cursorQuery = contentResolver.query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), MediaLibraryConstantsKt.getASSET_PROJECTION(), selection, null, order);
                try {
                    Cursor cursor2 = cursorQuery;
                    JobKt.ensureActive(anonymousClass2.get$context());
                    if (cursor2 == null) {
                        throw new AssetQueryException();
                    }
                    ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                    Intrinsics.checkNotNull(contentResolver);
                    ArrayList<? extends Parcelable> arrayList3 = arrayList2;
                    int i2 = (int) limit;
                    Boolean resolveWithFullInfo = assetsOptions.getResolveWithFullInfo();
                    boolean zBooleanValue = resolveWithFullInfo != null ? resolveWithFullInfo.booleanValue() : false;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(context);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(assetsOptions);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(contentResolver);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(selection);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(order);
                    anonymousClass2.L$5 = cursorQuery;
                    anonymousClass2.L$6 = cursor2;
                    anonymousClass2.L$7 = arrayList2;
                    anonymousClass2.D$0 = limit;
                    anonymousClass2.I$0 = offset;
                    anonymousClass2.I$1 = 0;
                    anonymousClass2.label = 1;
                    if (AssetUtilsKt.putAssetsInfo(contentResolver, cursor2, arrayList3, i2, offset, zBooleanValue, anonymousClass2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cursor = cursor2;
                    closeable = cursorQuery;
                    arrayList = arrayList2;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = cursorQuery;
                    throw th;
                }
            } catch (Exception e) {
                if (!(e instanceof SecurityException)) {
                    if (!(e instanceof IOException)) {
                        if (!(e instanceof IllegalArgumentException)) {
                            if (e instanceof UnsupportedOperationException) {
                                String message = e.getMessage();
                                if (message == null) {
                                    message = "Permission denied: " + e.getMessage();
                                }
                                throw new PermissionsException(message);
                            }
                            throw e;
                        }
                        String message2 = e.getMessage();
                        if (message2 == null) {
                            message2 = "Invalid MediaType " + e.getMessage();
                        }
                        throw new UnableToLoadException(message2, e);
                    }
                    throw new UnableToLoadException("Could not read file: " + e.getMessage(), e);
                }
                throw new UnableToLoadException("Could not get asset: need read_external_storage permission", e);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = anonymousClass2.I$1;
            int i4 = anonymousClass2.I$0;
            double d = anonymousClass2.D$0;
            arrayList = (ArrayList) anonymousClass2.L$7;
            cursor = (Cursor) anonymousClass2.L$6;
            closeable = (Closeable) anonymousClass2.L$5;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(closeable, th);
                    throw th4;
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("assets", arrayList);
        bundle.putBoolean("hasNextPage", !cursor.isAfterLast());
        bundle.putString("endCursor", String.valueOf(cursor.getPosition()));
        bundle.putInt("totalCount", cursor.getCount());
        CloseableKt.closeFinally(closeable, null);
        return bundle;
    }
}
