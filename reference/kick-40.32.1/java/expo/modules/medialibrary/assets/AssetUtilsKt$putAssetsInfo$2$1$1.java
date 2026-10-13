package expo.modules.medialibrary.assets;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AssetUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.assets.AssetUtilsKt$putAssetsInfo$2$1$1", f = "AssetUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AssetUtilsKt$putAssetsInfo$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ContentResolver $contentResolver;
    final /* synthetic */ PendingAsset $pending;
    final /* synthetic */ boolean $resolveWithFullInfo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AssetUtilsKt$putAssetsInfo$2$1$1(PendingAsset pendingAsset, boolean z, ContentResolver contentResolver, Continuation<? super AssetUtilsKt$putAssetsInfo$2$1$1> continuation) {
        super(2, continuation);
        this.$pending = pendingAsset;
        this.$resolveWithFullInfo = z;
        this.$contentResolver = contentResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AssetUtilsKt$putAssetsInfo$2$1$1(this.$pending, this.$resolveWithFullInfo, this.$contentResolver, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AssetUtilsKt$putAssetsInfo$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        ExifInterface exifInterface;
        Bundle exifLocationLegacy;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str = "file://" + this.$pending.getPath();
        if (this.$resolveWithFullInfo && this.$pending.getMediaType() == 1) {
            try {
                exifInterface = new ExifInterface(this.$pending.getPath());
            } catch (IOException e) {
                Log.w("expo-media-library", "Could not parse EXIF tags for " + str);
                e.printStackTrace();
                exifInterface = null;
            }
        } else {
            exifInterface = null;
        }
        if (this.$pending.getMissingDimensions()) {
            Pair assetDimensionsSlow = AssetUtilsKt.getAssetDimensionsSlow(this.$contentResolver, exifInterface, this.$pending);
            int iIntValue = ((Number) assetDimensionsSlow.component1()).intValue();
            int iIntValue2 = ((Number) assetDimensionsSlow.component2()).intValue();
            this.$pending.getAsset().putLong(ViewProps.WIDTH, iIntValue);
            this.$pending.getAsset().putLong(ViewProps.HEIGHT, iIntValue2);
        }
        if (exifInterface != null) {
            if (!this.$pending.getMissingDimensions()) {
                Pair imageDimensionsFromExifFast = AssetUtilsKt.getImageDimensionsFromExifFast(exifInterface, this.$pending.getCursorWidth(), this.$pending.getCursorHeight(), this.$pending.getCursorOrientation());
                int iIntValue3 = ((Number) imageDimensionsFromExifFast.component1()).intValue();
                int iIntValue4 = ((Number) imageDimensionsFromExifFast.component2()).intValue();
                this.$pending.getAsset().putLong(ViewProps.WIDTH, iIntValue3);
                this.$pending.getAsset().putLong(ViewProps.HEIGHT, iIntValue4);
            }
            AssetUtilsKt.getExifFullInfo(exifInterface, this.$pending.getAsset());
            String string = this.$pending.getAsset().getString("id");
            if (string == null) {
                return Unit.INSTANCE;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Uri uriWithAppendedPath = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, string);
                ContentResolver contentResolver = this.$contentResolver;
                Intrinsics.checkNotNull(uriWithAppendedPath);
                exifLocationLegacy = AssetUtilsKt.getExifLocationForUri(contentResolver, uriWithAppendedPath);
            } else {
                exifLocationLegacy = AssetUtilsKt.getExifLocationLegacy(exifInterface);
            }
            this.$pending.getAsset().putParcelable(FirebaseAnalytics.Param.LOCATION, exifLocationLegacy);
            this.$pending.getAsset().putString("localUri", str);
        }
        return Unit.INSTANCE;
    }
}
