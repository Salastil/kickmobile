package io.ktor.client.engine;

import androidx.media3.muxer.WebmConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
public final class UtilsKt$attachToUserJob$cleanupHandler$1 implements Function1<Throwable, Unit> {
    final /* synthetic */ Job $callJob;

    public UtilsKt$attachToUserJob$cleanupHandler$1(Job job) {
        this.$callJob = job;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        if (th == null) {
            return;
        }
        this.$callJob.cancel(new CancellationException(th.getMessage()));
    }
}
