package expo.modules.core.logging;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PersistentFileLogSerialDispatchQueue.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00050\u0007j\u0002`\b¨\u0006\n"}, d2 = {"Lexpo/modules/core/logging/PersistentFileLogSerialDispatchQueue;", "", "<init>", "()V", "add", "", "block", "Lkotlin/Function0;", "Lexpo/modules/core/logging/PersistentFileLogSerialDispatchQueueBlock;", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersistentFileLogSerialDispatchQueue {
    public static final int $stable = 0;
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public final void add(final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        executor.execute(new Runnable() { // from class: expo.modules.core.logging.PersistentFileLogSerialDispatchQueue$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                block.invoke();
            }
        });
    }
}
