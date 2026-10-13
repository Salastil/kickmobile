package io.datazoom.sdk;

import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: BaseContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lio/datazoom/sdk/BaseContextFactory;", "", "<init>", "()V", "create", "Lio/datazoom/sdk/BaseContext;", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BaseContextFactory {
    public static final BaseContextFactory INSTANCE = new BaseContextFactory();

    private BaseContextFactory() {
    }

    public final BaseContext create() {
        return new BaseContextImp();
    }
}
