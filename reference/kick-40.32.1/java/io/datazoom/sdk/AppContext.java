package io.datazoom.sdk;

import android.app.Application;
import android.content.Context;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.hermes.intl.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/datazoom/sdk/AppContext;", "", "<init>", "()V", "application", "Landroid/app/Application;", "setUp", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "get", Constants.SENSITIVITY_BASE}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AppContext {
    public static final AppContext INSTANCE = new AppContext();
    private static Application application;

    private AppContext() {
    }

    public final void setUp(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        application = (Application) context;
    }

    public final Context get() throws Exception {
        Application application2 = application;
        if (application2 == null) {
            throw new Exception("Application context isn't initialized");
        }
        if (application2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("application");
            application2 = null;
        }
        Context applicationContext = application2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return applicationContext;
    }
}
