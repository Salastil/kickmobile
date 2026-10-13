package expo.modules.updates.loader;

import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import com.facebook.common.util.UriUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: FileDownloader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.updates.loader.FileDownloader", f = "FileDownloader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {119, 152, 168, 195}, m = "downloadAssetAndVerifyHashAndWriteToPath$expo_updates_release", n = {UriUtil.LOCAL_ASSET_SCHEME, "extraHeaders", "request", "expectedBase64URLEncodedSHA256Hash", FirebaseAnalytics.Param.DESTINATION, "updatesDirectory", "progressListener", "launchedUpdate", "requestedUpdate", "embeddedAssetExtractor", "allowPatch", UriUtil.LOCAL_ASSET_SCHEME, "extraHeaders", "request", "expectedBase64URLEncodedSHA256Hash", FirebaseAnalytics.Param.DESTINATION, "updatesDirectory", "progressListener", "launchedUpdate", "requestedUpdate", "embeddedAssetExtractor", "response", "resp", "responseBody", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "patchMetadata", "requestedUpdateId", "allowPatch", "$i$a$-use-FileDownloader$downloadAssetAndVerifyHashAndWriteToPath$hash$1", "$i$a$-use-FileDownloader$downloadAssetAndVerifyHashAndWriteToPath$hash$1$1", "idsAreDifferent", "shouldAttemptPatch", UriUtil.LOCAL_ASSET_SCHEME, "extraHeaders", "request", "expectedBase64URLEncodedSHA256Hash", FirebaseAnalytics.Param.DESTINATION, "updatesDirectory", "progressListener", "launchedUpdate", "requestedUpdate", "embeddedAssetExtractor", "response", "resp", "responseBody", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "patchMetadata", "requestedUpdateId", "allowPatch", "$i$a$-use-FileDownloader$downloadAssetAndVerifyHashAndWriteToPath$hash$1", "$i$a$-use-FileDownloader$downloadAssetAndVerifyHashAndWriteToPath$hash$1$1", "idsAreDifferent", "shouldAttemptPatch", UriUtil.LOCAL_ASSET_SCHEME, "extraHeaders", "request", "expectedBase64URLEncodedSHA256Hash", FirebaseAnalytics.Param.DESTINATION, "updatesDirectory", "progressListener", "launchedUpdate", "requestedUpdate", "embeddedAssetExtractor", "response", "resp", "responseBody", ExpoNotificationBuilder.EXTRAS_BODY_KEY, "patchMetadata", "requestedUpdateId", "it", "allowPatch", "$i$a$-use-FileDownloader$downloadAssetAndVerifyHashAndWriteToPath$hash$1", "$i$a$-use-FileDownloader$downloadAssetAndVerifyHashAndWriteToPath$hash$1$1", "idsAreDifferent", "shouldAttemptPatch", "$i$a$-getOrElse-FileDownloader$downloadAssetAndVerifyHashAndWriteToPath$hash$1$1$3"}, nl = {TimeseriesConfiguration.DEFAULT_BUFFER_SIZE, WebmConstants.MkvEbmlElement.BLOCK, 177, 201}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$16", "L$17", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$16", "L$17", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 2)
final class FileDownloader$downloadAssetAndVerifyHashAndWriteToPath$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$16;
    Object L$17;
    Object L$18;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileDownloader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileDownloader$downloadAssetAndVerifyHashAndWriteToPath$1(FileDownloader fileDownloader, Continuation<? super FileDownloader$downloadAssetAndVerifyHashAndWriteToPath$1> continuation) {
        super(continuation);
        this.this$0 = fileDownloader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.downloadAssetAndVerifyHashAndWriteToPath$expo_updates_release(null, null, null, null, null, null, null, false, null, null, null, this);
    }
}
