package com.facebook.imagepipeline.nativecode;

import com.facebook.soloader.nativeloader.NativeLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: ImagePipelineNativeLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/imagepipeline/nativecode/ImagePipelineNativeLoader;", "", "<init>", "()V", "DSO_NAME", "", "DEPENDENCIES", "", "load", "", "imagepipeline-native_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImagePipelineNativeLoader {
    public static final String DSO_NAME = "imagepipeline";
    public static final ImagePipelineNativeLoader INSTANCE = new ImagePipelineNativeLoader();
    public static List<String> DEPENDENCIES = Collections.unmodifiableList(new ArrayList());

    private ImagePipelineNativeLoader() {
    }

    @JvmStatic
    public static final void load() {
        NativeLoader.loadLibrary(DSO_NAME);
    }
}
