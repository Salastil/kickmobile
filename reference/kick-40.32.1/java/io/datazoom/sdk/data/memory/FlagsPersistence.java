package io.datazoom.sdk.data.memory;

import com.facebook.hermes.intl.Constants;
import io.datazoom.sdk.model.PendingFlag;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: FlagsPersistence.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\fH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lio/datazoom/sdk/data/memory/FlagsPersistence;", "", "addFlag", "", "flag", "Lio/datazoom/sdk/model/PendingFlag;", "(Lio/datazoom/sdk/model/PendingFlag;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFlag", "clearAllFlags", "getFlags", "", "isFlagApplied", "", "flagApplied", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface FlagsPersistence {
    Object addFlag(PendingFlag pendingFlag, Continuation<? super Unit> continuation);

    void clearAllFlags();

    boolean flagApplied();

    List<PendingFlag> getFlags();

    boolean isFlagApplied(PendingFlag flag);

    void removeFlag(PendingFlag flag);
}
