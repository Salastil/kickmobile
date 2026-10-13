package com.datadog.android.log.internal.domain.event;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.constraints.DataConstraints;
import com.datadog.android.core.constraints.DatadogDataConstraints;
import com.datadog.android.core.internal.utils.JsonSerializer;
import com.datadog.android.core.persistence.Serializer;
import com.datadog.android.log.model.LogEvent;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LogEventSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/datadog/android/log/internal/domain/event/LogEventSerializer;", "Lcom/datadog/android/core/persistence/Serializer;", "Lcom/datadog/android/log/model/LogEvent;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "dataConstraints", "Lcom/datadog/android/core/constraints/DataConstraints;", "(Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/core/constraints/DataConstraints;)V", "sanitizeTagsAndAttributes", "log", "serialize", "", "model", "Companion", "dd-sdk-android-logs_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LogEventSerializer implements Serializer<LogEvent> {
    public static final String ACCOUNT_EXTRA_GROUP_VERBOSE_NAME = "account extra information";
    public static final String USER_EXTRA_GROUP_VERBOSE_NAME = "user extra information";
    private final DataConstraints dataConstraints;
    private final InternalLogger internalLogger;

    public LogEventSerializer(InternalLogger internalLogger, DataConstraints dataConstraints) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(dataConstraints, "dataConstraints");
        this.internalLogger = internalLogger;
        this.dataConstraints = dataConstraints;
    }

    public /* synthetic */ LogEventSerializer(InternalLogger internalLogger, DatadogDataConstraints datadogDataConstraints, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalLogger, (i & 2) != 0 ? new DatadogDataConstraints(internalLogger) : datadogDataConstraints);
    }

    @Override // com.datadog.android.core.persistence.Serializer
    public String serialize(LogEvent model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String string = sanitizeTagsAndAttributes(model).toJson().toString();
        Intrinsics.checkNotNullExpressionValue(string, "sanitizeTagsAndAttribute…odel).toJson().toString()");
        return string;
    }

    private final LogEvent sanitizeTagsAndAttributes(LogEvent log) {
        String strJoinToString$default = CollectionsKt.joinToString$default(this.dataConstraints.validateTags(StringsKt.split$default((CharSequence) log.getDdtags(), new String[]{WebViewLogEventConsumer.DDTAGS_SEPARATOR}, false, 0, 6, (Object) null)), WebViewLogEventConsumer.DDTAGS_SEPARATOR, null, null, 0, null, null, 62, null);
        Map mapValidateAttributes$default = DataConstraints.DefaultImpls.validateAttributes$default(this.dataConstraints, log.getAdditionalProperties(), null, null, null, 14, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapValidateAttributes$default.entrySet()) {
            if (!StringsKt.isBlank((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LogEvent.Usr usr = log.getUsr();
        LogEvent.Usr usrCopy$default = usr != null ? LogEvent.Usr.copy$default(usr, null, null, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(DataConstraints.DefaultImpls.validateAttributes$default(this.dataConstraints, usr.getAdditionalProperties(), "usr", "user extra information", null, 8, null), this.internalLogger)), 15, null) : null;
        LogEvent.Account account = log.getAccount();
        return LogEvent.copy$default(log, null, null, null, null, null, null, null, null, usrCopy$default, account != null ? LogEvent.Account.copy$default(account, null, null, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(DataConstraints.DefaultImpls.validateAttributes$default(this.dataConstraints, account.getAdditionalProperties(), "account", "account extra information", null, 8, null), this.internalLogger)), 3, null) : null, null, null, null, null, strJoinToString$default, MapsKt.toMutableMap(JsonSerializer.INSTANCE.safeMapValuesToJson(linkedHashMap2, this.internalLogger)), 15615, null);
    }
}
