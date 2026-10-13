package androidx.camera.camera2.impl;

import androidx.camera.core.impl.TagBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: Tags.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"CAMERAX_TAG_BUNDLE", "Landroidx/camera/camera2/pipe/Metadata$Key;", "Landroidx/camera/core/impl/TagBundle;", "getCAMERAX_TAG_BUNDLE", "()Landroidx/camera/camera2/pipe/Metadata$Key;", "USE_CASE_CAMERA_STATE_CUSTOM_TAG", "", "getUSE_CASE_CAMERA_STATE_CUSTOM_TAG", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TagsKt {
    private static final androidx.camera.camera2.pipe.Metadata.Key<TagBundle> CAMERAX_TAG_BUNDLE = androidx.camera.camera2.pipe.Metadata.Key.INSTANCE.create("camerax.tag_bundle", Reflection.getOrCreateKotlinClass(TagBundle.class));
    private static final androidx.camera.camera2.pipe.Metadata.Key<Integer> USE_CASE_CAMERA_STATE_CUSTOM_TAG = androidx.camera.camera2.pipe.Metadata.Key.INSTANCE.create("use_case_camera_state.tag", Reflection.getOrCreateKotlinClass(Integer.class));

    public static final androidx.camera.camera2.pipe.Metadata.Key<TagBundle> getCAMERAX_TAG_BUNDLE() {
        return CAMERAX_TAG_BUNDLE;
    }

    public static final androidx.camera.camera2.pipe.Metadata.Key<Integer> getUSE_CASE_CAMERA_STATE_CUSTOM_TAG() {
        return USE_CASE_CAMERA_STATE_CUSTOM_TAG;
    }
}
