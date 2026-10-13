package io.datazoom.sdk;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: Dispatcher.android.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", Constants.SENSITIVITY_BASE}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class Dispatcher_androidKt {
    public static final CoroutineDispatcher dispatcher() {
        return Dispatchers.getMain();
    }
}
