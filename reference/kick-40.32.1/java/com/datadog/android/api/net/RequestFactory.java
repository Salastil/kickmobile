package com.datadog.android.api.net;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: RequestFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \r2\u00020\u0001:\u0001\rJ2\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/api/net/RequestFactory;", "", "create", "Lcom/datadog/android/api/net/Request;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lcom/datadog/android/api/context/DatadogContext;", "executionContext", "Lcom/datadog/android/api/net/RequestExecutionContext;", "batchData", "", "Lcom/datadog/android/api/storage/RawBatchEvent;", "batchMetadata", "", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RequestFactory {
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_TEXT_UTF8 = "text/plain;charset=UTF-8";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String DD_IDEMPOTENCY_KEY = "DD-IDEMPOTENCY-KEY";
    public static final String HEADER_API_KEY = "DD-API-KEY";
    public static final String HEADER_EVP_ORIGIN = "DD-EVP-ORIGIN";
    public static final String HEADER_EVP_ORIGIN_VERSION = "DD-EVP-ORIGIN-VERSION";
    public static final String HEADER_REQUEST_ID = "DD-REQUEST-ID";
    public static final String QUERY_PARAM_SOURCE = "ddsource";
    public static final String QUERY_PARAM_TAGS = "ddtags";

    Request create(DatadogContext context, RequestExecutionContext executionContext, List<RawBatchEvent> batchData, byte[] batchMetadata);

    /* JADX INFO: compiled from: RequestFactory.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/datadog/android/api/net/RequestFactory$Companion;", "", "()V", "CONTENT_TYPE_JSON", "", "CONTENT_TYPE_TEXT_UTF8", "DD_IDEMPOTENCY_KEY", "HEADER_API_KEY", "HEADER_EVP_ORIGIN", "HEADER_EVP_ORIGIN_VERSION", "HEADER_REQUEST_ID", "QUERY_PARAM_SOURCE", "QUERY_PARAM_TAGS", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CONTENT_TYPE_JSON = "application/json";
        public static final String CONTENT_TYPE_TEXT_UTF8 = "text/plain;charset=UTF-8";
        public static final String DD_IDEMPOTENCY_KEY = "DD-IDEMPOTENCY-KEY";
        public static final String HEADER_API_KEY = "DD-API-KEY";
        public static final String HEADER_EVP_ORIGIN = "DD-EVP-ORIGIN";
        public static final String HEADER_EVP_ORIGIN_VERSION = "DD-EVP-ORIGIN-VERSION";
        public static final String HEADER_REQUEST_ID = "DD-REQUEST-ID";
        public static final String QUERY_PARAM_SOURCE = "ddsource";
        public static final String QUERY_PARAM_TAGS = "ddtags";

        private Companion() {
        }
    }
}
