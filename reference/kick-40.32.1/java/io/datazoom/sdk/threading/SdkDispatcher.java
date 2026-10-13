package io.datazoom.sdk.threading;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.cast.MediaTrack;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SdkDispatcher.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lio/datazoom/sdk/threading/SdkDispatcher;", "", "<init>", "()V", MediaTrack.ROLE_MAIN, "Lkotlinx/coroutines/CoroutineDispatcher;", "getMain", "()Lkotlinx/coroutines/CoroutineDispatcher;", "io", "getIo", "dispatcher", "getDispatcher", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SdkDispatcher {
    public static final SdkDispatcher INSTANCE = new SdkDispatcher();

    private SdkDispatcher() {
    }

    public final CoroutineDispatcher getMain() {
        return Dispatchers.getMain().getImmediate();
    }

    public final CoroutineDispatcher getIo() {
        return Dispatchers.getIO();
    }

    public final CoroutineDispatcher getDispatcher() {
        return getIo();
    }
}
