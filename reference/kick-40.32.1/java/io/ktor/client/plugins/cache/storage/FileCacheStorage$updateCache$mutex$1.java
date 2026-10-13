package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: FileCacheStorage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class FileCacheStorage$updateCache$mutex$1 implements Function0<Mutex> {
    public static final FileCacheStorage$updateCache$mutex$1 INSTANCE = new FileCacheStorage$updateCache$mutex$1();

    @Override // kotlin.jvm.functions.Function0
    public final Mutex invoke() {
        return MutexKt.Mutex$default(false, 1, null);
    }
}
