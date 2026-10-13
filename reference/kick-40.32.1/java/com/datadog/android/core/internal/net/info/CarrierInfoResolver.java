package com.datadog.android.core.internal.net.info;

import android.telephony.TelephonyManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.internal.system.BuildSdkVersionProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CarrierInfoResolver.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n*\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0002R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/datadog/android/core/internal/net/info/CarrierInfoResolver;", "", "telephonyManager", "Landroid/telephony/TelephonyManager;", "internalLogger", "Lcom/datadog/android/api/InternalLogger;", "sdkVersionProvider", "Lcom/datadog/android/internal/system/BuildSdkVersionProvider;", "(Landroid/telephony/TelephonyManager;Lcom/datadog/android/api/InternalLogger;Lcom/datadog/android/internal/system/BuildSdkVersionProvider;)V", "carrierId", "", "getCarrierId", "()Ljava/lang/Long;", "carrierName", "", "getCarrierName", "()Ljava/lang/String;", "resolveCarrierId", "(Landroid/telephony/TelephonyManager;)Ljava/lang/Long;", "resolveCarrierName", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CarrierInfoResolver {
    public static final String ERROR_CARRIER_ID = "Failed to resolve carrier ID information from TelephonyManager.";
    public static final String ERROR_CARRIER_NAME = "Failed to resolve carrier name information from TelephonyManager.";
    private final InternalLogger internalLogger;
    private final BuildSdkVersionProvider sdkVersionProvider;
    private final TelephonyManager telephonyManager;

    public CarrierInfoResolver(TelephonyManager telephonyManager, InternalLogger internalLogger, BuildSdkVersionProvider sdkVersionProvider) {
        Intrinsics.checkNotNullParameter(telephonyManager, "telephonyManager");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(sdkVersionProvider, "sdkVersionProvider");
        this.telephonyManager = telephonyManager;
        this.internalLogger = internalLogger;
        this.sdkVersionProvider = sdkVersionProvider;
    }

    public /* synthetic */ CarrierInfoResolver(TelephonyManager telephonyManager, InternalLogger internalLogger, BuildSdkVersionProvider buildSdkVersionProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(telephonyManager, internalLogger, (i & 4) != 0 ? BuildSdkVersionProvider.INSTANCE.getDEFAULT() : buildSdkVersionProvider);
    }

    public final Long getCarrierId() {
        return resolveCarrierId(this.telephonyManager);
    }

    public final String getCarrierName() {
        return resolveCarrierName(this.telephonyManager);
    }

    private final String resolveCarrierName(TelephonyManager telephonyManager) {
        try {
            if (this.sdkVersionProvider.getIsAtLeastP()) {
                CharSequence simCarrierIdName = telephonyManager.getSimCarrierIdName();
                if (simCarrierIdName != null) {
                    return simCarrierIdName.toString();
                }
                return null;
            }
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (networkOperatorName == null || networkOperatorName.length() <= 0) {
                return null;
            }
            return networkOperatorName;
        } catch (RuntimeException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.net.info.CarrierInfoResolver.resolveCarrierName.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CarrierInfoResolver.ERROR_CARRIER_NAME;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    private final Long resolveCarrierId(TelephonyManager telephonyManager) {
        try {
            if (this.sdkVersionProvider.getIsAtLeastP()) {
                Integer numValueOf = Integer.valueOf(telephonyManager.getSimCarrierId());
                if (numValueOf.intValue() == -1) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    return Long.valueOf(numValueOf.intValue());
                }
                return null;
            }
            String networkOperator = telephonyManager.getNetworkOperator();
            if (networkOperator != null) {
                if (networkOperator.length() <= 0) {
                    networkOperator = null;
                }
                if (networkOperator != null) {
                    return StringsKt.toLongOrNull(networkOperator);
                }
            }
            return null;
        } catch (RuntimeException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0<String>() { // from class: com.datadog.android.core.internal.net.info.CarrierInfoResolver.resolveCarrierId.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CarrierInfoResolver.ERROR_CARRIER_ID;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }
}
