package io.github.expo.modules.v2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"module", ExifInterface.GPS_DIRECTION_TRUE, "Lio/github/expo/modules/v2/Module;", "Lio/github/expo/modules/v2/ExpoContext;", "(Lio/github/expo/modules/v2/ExpoContext;)Lio/github/expo/modules/v2/Module;", "react_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ExpoContextKt {
    public static final /* synthetic */ <T extends Module> T module(ExpoContext expoContext) {
        Intrinsics.checkNotNullParameter(expoContext, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) expoContext.module(Module.class);
    }
}
