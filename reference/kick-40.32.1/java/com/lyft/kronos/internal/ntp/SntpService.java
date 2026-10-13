package com.lyft.kronos.internal.ntp;

import com.facebook.react.bridge.BaseJavaModule;
import com.lyft.kronos.KronosTime;
import kotlin.Metadata;

/* JADX INFO: compiled from: SntpService.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/lyft/kronos/internal/ntp/SntpService;", "", "currentTime", "Lcom/lyft/kronos/KronosTime;", "currentTimeMs", "", "shutdown", "", BaseJavaModule.METHOD_TYPE_SYNC, "", "syncInBackground", "kronos-java"}, k = 1, mv = {1, 4, 0})
public interface SntpService {
    KronosTime currentTime();

    long currentTimeMs();

    void shutdown();

    boolean sync();

    void syncInBackground();

    /* JADX INFO: compiled from: SntpService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static long currentTimeMs(SntpService sntpService) {
            KronosTime kronosTimeCurrentTime = sntpService.currentTime();
            if (kronosTimeCurrentTime != null) {
                return kronosTimeCurrentTime.getPosixTimeMs();
            }
            return 0L;
        }
    }
}
