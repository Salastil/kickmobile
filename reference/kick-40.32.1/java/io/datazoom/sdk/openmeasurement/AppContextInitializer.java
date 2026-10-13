package io.datazoom.sdk.openmeasurement;

import android.content.Context;
import androidx.startup.Initializer;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppContextInitializer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\t0\bH\u0016¨\u0006\n"}, d2 = {"Lio/datazoom/sdk/openmeasurement/AppContextInitializer;", "Landroidx/startup/Initializer;", "Landroid/content/Context;", "<init>", "()V", "create", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "dependencies", "", "Ljava/lang/Class;", "openmeasurement_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AppContextInitializer implements Initializer<Context> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public Context create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OMManager.INSTANCE.init(context);
        return context;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.emptyList();
    }
}
