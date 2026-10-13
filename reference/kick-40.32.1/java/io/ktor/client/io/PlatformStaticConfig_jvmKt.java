package io.ktor.client.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformStaticConfig.jvm.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005\"\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0005\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "configurePlatform", "()V", "", "VM_NAME_PROPERTY", "Ljava/lang/String;", "IO_POOL_SIZE_PROPERTY", "DEFAULT_POOL_SIZE_BYTES", "ANDROID_VM_NAME", "", "MIN_PROCESS_MEMORY", "I", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PlatformStaticConfig_jvmKt {
    private static final String ANDROID_VM_NAME = "Dalvik";
    private static final String DEFAULT_POOL_SIZE_BYTES = "2097152";
    private static final String IO_POOL_SIZE_PROPERTY = "kotlinx.io.pool.size.bytes";
    private static final int MIN_PROCESS_MEMORY = 10000000;
    private static final String VM_NAME_PROPERTY = "java.vm.name";

    public static final void configurePlatform() {
        if (System.getProperty(IO_POOL_SIZE_PROPERTY) == null && Intrinsics.areEqual(System.getProperty(VM_NAME_PROPERTY), ANDROID_VM_NAME) && Runtime.getRuntime().maxMemory() > 10000000) {
            System.setProperty(IO_POOL_SIZE_PROPERTY, DEFAULT_POOL_SIZE_BYTES);
        }
    }
}
