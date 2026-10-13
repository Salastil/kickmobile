package expo.modules.medialibrary.albums;

import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import expo.modules.medialibrary.MediaLibraryUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RemoveAssetsFromAlbum.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"removeAssetsFromAlbum", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "assetIds", "", "", "albumId", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RemoveAssetsFromAlbumKt {
    public static final Object removeAssetsFromAlbum(Context context, String[] strArr, String str, Continuation<? super Unit> continuation) {
        Object objDeleteAssets = MediaLibraryUtils.INSTANCE.deleteAssets(context, "bucket_id=? AND _id IN (" + ArraysKt.joinToString$default(strArr, WebViewLogEventConsumer.DDTAGS_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + " )", new String[]{str}, continuation);
        return objDeleteAssets == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteAssets : Unit.INSTANCE;
    }
}
