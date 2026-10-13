package expo.modules.medialibrary.assets;

import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import expo.modules.medialibrary.AssetsOptions;
import expo.modules.medialibrary.MediaType;
import expo.modules.medialibrary.SortBy;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GetAssetsQuery.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005\u001a\u0014\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r¨\u0006\u000e"}, d2 = {"getQueryFromOptions", "Lexpo/modules/medialibrary/assets/GetAssetsQuery;", "input", "Lexpo/modules/medialibrary/AssetsOptions;", "createSelectionString", "", "parseMediaType", "", "mediaTypeName", "parseSortByKey", "key", "convertOrderDescriptors", "orderDescriptor", "", "expo-media-library_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GetAssetsQueryKt {
    /* JADX WARN: Code duplicated, block: B:14:0x0039  */
    public static final GetAssetsQuery getQueryFromOptions(AssetsOptions input) throws IllegalArgumentException {
        Object objM12684constructorimpl;
        int iIntValue;
        String strConvertOrderDescriptors;
        Intrinsics.checkNotNullParameter(input, "input");
        double first = input.getFirst();
        String after = input.getAfter();
        if (after != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(Integer.valueOf(Integer.parseInt(after)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                objM12684constructorimpl = null;
            }
            Integer num = (Integer) objM12684constructorimpl;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                iIntValue = 0;
            }
        } else {
            iIntValue = 0;
        }
        int i = iIntValue;
        String strCreateSelectionString = createSelectionString(input);
        if (!input.getSortBy().isEmpty()) {
            strConvertOrderDescriptors = convertOrderDescriptors(input.getSortBy());
        } else {
            strConvertOrderDescriptors = "bucket_display_name";
        }
        return new GetAssetsQuery(strCreateSelectionString, strConvertOrderDescriptors, first, i);
    }

    private static final String createSelectionString(AssetsOptions assetsOptions) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        if (assetsOptions.getAlbum() != null) {
            sb.append("bucket_id = " + assetsOptions.getAlbum());
            sb.append(" AND ");
        }
        List<String> mediaType = assetsOptions.getMediaType();
        if (!mediaType.isEmpty() && !mediaType.contains(MediaType.ALL.getApiName())) {
            List<String> list = mediaType;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(parseMediaType((String) it.next())));
            }
            sb.append("media_type IN (" + CollectionsKt.joinToString$default(arrayList, WebViewLogEventConsumer.DDTAGS_SEPARATOR, null, null, 0, null, null, 62, null) + ")");
        } else {
            sb.append("media_type != 0");
        }
        Double createdAfter = assetsOptions.getCreatedAfter();
        if (createdAfter != null) {
            sb.append(" AND datetaken > " + ((long) createdAfter.doubleValue()));
        }
        Double createdBefore = assetsOptions.getCreatedBefore();
        if (createdBefore != null) {
            sb.append(" AND datetaken < " + ((long) createdBefore.doubleValue()));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String parseSortByKey(String key) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(key, "key");
        SortBy sortByFromKeyName = SortBy.INSTANCE.fromKeyName(key);
        String mediaColumnName = sortByFromKeyName != null ? sortByFromKeyName.getMediaColumnName() : null;
        if (mediaColumnName != null) {
            return mediaColumnName;
        }
        throw new IllegalArgumentException("SortBy key " + key + " is not supported!");
    }

    public static final String convertOrderDescriptors(List<String> orderDescriptor) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(orderDescriptor, "orderDescriptor");
        ArrayList arrayList = new ArrayList(20);
        Iterator<String> it = orderDescriptor.iterator();
        while (it.hasNext()) {
            List listSplit$default = StringsKt.split$default((CharSequence) it.next(), new String[]{ServerSentEventKt.SPACE}, false, 0, 6, (Object) null);
            if (listSplit$default.size() != 2) {
                throw new IllegalArgumentException("Array sortBy in assetsOptions has invalid layout.".toString());
            }
            arrayList.add(parseSortByKey((String) listSplit$default.get(0)) + ServerSentEventKt.SPACE + ((String) listSplit$default.get(1)));
        }
        return CollectionsKt.joinToString$default(arrayList, WebViewLogEventConsumer.DDTAGS_SEPARATOR, null, null, 0, null, null, 62, null);
    }

    private static final int parseMediaType(String str) throws IllegalArgumentException {
        MediaType mediaTypeFromApiName = MediaType.INSTANCE.fromApiName(str);
        Integer mediaColumn = mediaTypeFromApiName != null ? mediaTypeFromApiName.getMediaColumn() : null;
        if (mediaColumn == null) {
            throw new IllegalArgumentException("MediaType " + str + " is not supported!");
        }
        return mediaColumn.intValue();
    }
}
