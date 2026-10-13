package com.datadog.android.flags.model;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: UnparsedFlag.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0012\u0010\u0018\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/datadog/android/flags/model/UnparsedFlag;", "", "allocationKey", "", "getAllocationKey", "()Ljava/lang/String;", "doLog", "", "getDoLog", "()Z", "extraLogging", "Lorg/json/JSONObject;", "getExtraLogging", "()Lorg/json/JSONObject;", "reason", "getReason", "serialId", "", "getSerialId", "()Ljava/lang/Long;", "variationKey", "getVariationKey", "variationType", "getVariationType", "variationValue", "getVariationValue", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface UnparsedFlag {
    String getAllocationKey();

    boolean getDoLog();

    JSONObject getExtraLogging();

    String getReason();

    Long getSerialId();

    String getVariationKey();

    String getVariationType();

    String getVariationValue();
}
