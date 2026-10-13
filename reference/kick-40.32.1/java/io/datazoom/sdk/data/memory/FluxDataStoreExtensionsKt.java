package io.datazoom.sdk.data.memory;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.FluxData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FluxDataStoreExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\u0004¨\u0006\u0006"}, d2 = {"to", "Lio/datazoom/sdk/model/FluxData;", "Lio/datazoom/sdk/model/FluxData$Type;", "Lio/datazoom/sdk/model/FD;", "that", "", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FluxDataStoreExtensionsKt {
    public static final FluxData to(FluxData.Type type, Object that) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        Intrinsics.checkNotNullParameter(that, "that");
        return new FluxData(type, that);
    }
}
