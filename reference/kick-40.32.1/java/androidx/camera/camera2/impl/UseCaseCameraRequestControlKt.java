package androidx.camera.camera2.impl;

import androidx.camera.core.impl.TagBundle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UseCaseCameraRequestControl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"DEFAULT_REQUEST_TEMPLATE", "", "toMap", "", "", "", "Landroidx/camera/core/impl/TagBundle;", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UseCaseCameraRequestControlKt {
    public static final int DEFAULT_REQUEST_TEMPLATE = 1;

    public static final Map<String, Object> toMap(TagBundle tagBundle) {
        Intrinsics.checkNotNullParameter(tagBundle, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<String> setListKeys = tagBundle.listKeys();
        Intrinsics.checkNotNullExpressionValue(setListKeys, "listKeys(...)");
        for (String str : setListKeys) {
            Object tag = tagBundle.getTag(str);
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Any");
            linkedHashMap.put(str, tag);
        }
        return linkedHashMap;
    }
}
