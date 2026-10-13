package com.datadog.android.trace.internal.domain.event;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.context.AccountInfo;
import com.datadog.android.api.context.DeviceInfo;
import com.datadog.android.api.context.DeviceType;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.trace.model.SpanEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseSpanEventMapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\fH\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0004¨\u0006\u001d"}, d2 = {"Lcom/datadog/android/trace/internal/domain/event/BaseSpanEventMapper;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/datadog/android/trace/internal/domain/event/ContextAwareMapper;", "Lcom/datadog/android/trace/model/SpanEvent;", "()V", "resolveAccountInfo", "Lcom/datadog/android/trace/model/SpanEvent$Account;", "accountInfo", "Lcom/datadog/android/api/context/AccountInfo;", "resolveDeviceInfo", "Lcom/datadog/android/trace/model/SpanEvent$Device;", "deviceInfo", "Lcom/datadog/android/api/context/DeviceInfo;", "resolveDeviceType", "Lcom/datadog/android/trace/model/SpanEvent$Type;", "deviceType", "Lcom/datadog/android/api/context/DeviceType;", "resolveNetworkInfo", "Lcom/datadog/android/trace/model/SpanEvent$Network;", "networkInfo", "Lcom/datadog/android/api/context/NetworkInfo;", "resolveOsInfo", "Lcom/datadog/android/trace/model/SpanEvent$Os;", "resolveSimCarrier", "Lcom/datadog/android/trace/model/SpanEvent$SimCarrier;", "resolveUserInfo", "Lcom/datadog/android/trace/model/SpanEvent$Usr;", "userInfo", "Lcom/datadog/android/api/context/UserInfo;", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseSpanEventMapper<T> implements ContextAwareMapper<T, SpanEvent> {

    /* JADX INFO: compiled from: BaseSpanEventMapper.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceType.TABLET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeviceType.TV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DeviceType.DESKTOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DeviceType.GAMING_CONSOLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DeviceType.BOT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DeviceType.OTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    protected final SpanEvent.Usr resolveUserInfo(UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        return new SpanEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), MapsKt.toMutableMap(userInfo.getAdditionalProperties()));
    }

    protected final SpanEvent.Account resolveAccountInfo(AccountInfo accountInfo) {
        Intrinsics.checkNotNullParameter(accountInfo, "accountInfo");
        return new SpanEvent.Account(accountInfo.getId(), accountInfo.getName(), MapsKt.toMutableMap(accountInfo.getExtraInfo()));
    }

    protected final SpanEvent.Device resolveDeviceInfo(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        return new SpanEvent.Device(resolveDeviceType(deviceInfo.getDeviceType()), deviceInfo.getDeviceName(), deviceInfo.getDeviceModel(), deviceInfo.getDeviceBrand(), deviceInfo.getArchitecture(), null, null, null, null, null, null, Integer.valueOf(deviceInfo.getLogicalCpuCount()), deviceInfo.getTotalRam(), deviceInfo.isLowRam(), 2016, null);
    }

    protected final SpanEvent.Os resolveOsInfo(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        return new SpanEvent.Os(deviceInfo.getOsName(), deviceInfo.getOsVersion(), null, deviceInfo.getOsMajorVersion(), 4, null);
    }

    protected final SpanEvent.Network resolveNetworkInfo(NetworkInfo networkInfo) {
        Intrinsics.checkNotNullParameter(networkInfo, "networkInfo");
        SpanEvent.SimCarrier simCarrierResolveSimCarrier = resolveSimCarrier(networkInfo);
        Long strength = networkInfo.getStrength();
        String string = strength != null ? strength.toString() : null;
        Long downKbps = networkInfo.getDownKbps();
        String string2 = downKbps != null ? downKbps.toString() : null;
        Long upKbps = networkInfo.getUpKbps();
        return new SpanEvent.Network(new SpanEvent.Client(simCarrierResolveSimCarrier, string, string2, upKbps != null ? upKbps.toString() : null, networkInfo.getConnectivity().toString()));
    }

    private final SpanEvent.SimCarrier resolveSimCarrier(NetworkInfo networkInfo) {
        if (networkInfo.getCarrierId() == null && networkInfo.getCarrierName() == null) {
            return null;
        }
        Long carrierId = networkInfo.getCarrierId();
        return new SpanEvent.SimCarrier(carrierId != null ? carrierId.toString() : null, networkInfo.getCarrierName());
    }

    private final SpanEvent.Type resolveDeviceType(DeviceType deviceType) {
        switch (WhenMappings.$EnumSwitchMapping$0[deviceType.ordinal()]) {
            case 1:
                return SpanEvent.Type.MOBILE;
            case 2:
                return SpanEvent.Type.TABLET;
            case 3:
                return SpanEvent.Type.TV;
            case 4:
                return SpanEvent.Type.DESKTOP;
            case 5:
                return SpanEvent.Type.GAMING_CONSOLE;
            case 6:
                return SpanEvent.Type.BOT;
            case 7:
                return SpanEvent.Type.OTHER;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
