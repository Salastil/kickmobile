package io.datazoom.sdk.network;

import android.Manifest;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Resource.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001aH\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"ifSuccess", "Lio/datazoom/sdk/network/Resource;", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ResourceKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Resource<T> ifSuccess(Resource<? extends T> resource, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(resource, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (resource.isSuccess()) {
            Manifest.permission_group permission_groupVar = (Object) resource.getData();
            Intrinsics.checkNotNull(permission_groupVar);
            block.invoke(permission_groupVar);
        }
        return resource;
    }
}
