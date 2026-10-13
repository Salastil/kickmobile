package io.datazoom.sdk;

import android.content.Context;
import android.os.Build;
import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCaseKt;
import io.datazoom.sdk.model.DeviceInfo;
import io.datazoom.sdk.model.Orientation;
import io.datazoom.sdk.utils.PrimitiveExtensionsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceInfo.android.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"getDeviceInfo", "Lio/datazoom/sdk/model/DeviceInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DeviceInfo_androidKt {
    public static final Object getDeviceInfo(Continuation<? super DeviceInfo> continuation) throws Exception {
        Context context = AppContext.INSTANCE.get();
        DeviceTypeDetector deviceTypeDetector = new DeviceTypeDetector(context);
        Orientation orientation = PrimitiveExtensionsKt.orFalse(Boxing.boxBoolean(ContextExtensionsKt.isPortrait(context))) ? Orientation.PORTRAIT : Orientation.LANDSCAPE;
        boolean zOrFalse = PrimitiveExtensionsKt.orFalse(Boxing.boxBoolean(ContextExtensionsKt.isFUllScreen(context)));
        String myDeviceId = ContextExtensionsKt.getMyDeviceId(context);
        String str = Build.MANUFACTURER + Build.MODEL;
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        String value = orientation.getValue();
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return new DeviceInfo(MANUFACTURER, value, str, myDeviceId, RELEASE, GetDeviceInfoUseCaseKt.PLATFORM, deviceTypeDetector.getDeviceType(), zOrFalse);
    }
}
