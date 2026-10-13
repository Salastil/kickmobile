package io.github.expo.modules.v2;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.modules.v2.logging.PlatformLoggerKt;
import io.github.expo.modules.v2.modules.ModuleRegistry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/github/expo/modules/v2/ExpoContext;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "<init>", "()V", "moduleRegistry", "Lio/github/expo/modules/v2/modules/ModuleRegistry;", "getModuleRegistry", "()Lio/github/expo/modules/v2/modules/ModuleRegistry;", "value", "", "isClosed", "()Z", "isClosing", "module", ExifInterface.GPS_DIRECTION_TRUE, "Lio/github/expo/modules/v2/Module;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lio/github/expo/modules/v2/Module;", "close", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ExpoContext implements AutoCloseable {
    private volatile boolean isClosed;
    private boolean isClosing;
    private final ModuleRegistry moduleRegistry = new ModuleRegistry(this);

    public final ModuleRegistry getModuleRegistry() {
        return this.moduleRegistry;
    }

    /* JADX INFO: renamed from: isClosed, reason: from getter */
    public final boolean getIsClosed() {
        return this.isClosed;
    }

    public final <T extends Module> T module(Class<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.isClosed) {
            return null;
        }
        return (T) this.moduleRegistry.module$react_release(type);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.isClosing) {
                return;
            }
            this.isClosing = true;
            Unit unit = Unit.INSTANCE;
            for (Module module : this.moduleRegistry.modules$react_release()) {
                try {
                    module.onDestroy();
                } catch (Throwable th) {
                    PlatformLoggerKt.getPlatformLogger().error("onDestroy of " + module.getClass().getName() + " failed", th);
                }
            }
            this.isClosed = true;
        }
    }
}
