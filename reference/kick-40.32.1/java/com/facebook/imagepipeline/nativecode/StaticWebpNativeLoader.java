package com.facebook.imagepipeline.nativecode;

import com.facebook.soloader.nativeloader.NativeLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: StaticWebpNativeLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/nativecode/StaticWebpNativeLoader;", "", "<init>", "()V", "initialized", "", "ensure", "", "static-webp_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StaticWebpNativeLoader {
    public static final StaticWebpNativeLoader INSTANCE = new StaticWebpNativeLoader();
    private static boolean initialized;

    private StaticWebpNativeLoader() {
    }

    @JvmStatic
    public static final synchronized void ensure() {
        if (!initialized) {
            NativeLoader.loadLibrary("static-webp");
            initialized = true;
        }
    }
}
