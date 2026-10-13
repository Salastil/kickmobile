package io.github.expo.modules.v2;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import io.github.expo.modules.v2.jsi.CurrentRuntime;
import io.github.expo.modules.v2.jsi.JavaScriptRuntime;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedObject.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lio/github/expo/modules/v2/SharedObject;", "Lio/github/expo/modules/v2/ExpoObject;", "<init>", "()V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lio/github/expo/modules/v2/ExpoContext;", "(Lio/github/expo/modules/v2/ExpoContext;)V", "sharedObjectDidRelease", "", "getAdditionalMemoryPressure", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class SharedObject extends ExpoObject {
    public int getAdditionalMemoryPressure() {
        return 0;
    }

    public void sharedObjectDidRelease() {
    }

    public SharedObject() {
        ExpoContext context;
        JavaScriptRuntime javaScriptRuntime = CurrentRuntime.INSTANCE.get();
        if (javaScriptRuntime == null || (context = javaScriptRuntime.getContext()) == null) {
            return;
        }
        this.contextRef = new WeakReference<>(context);
    }

    public SharedObject(ExpoContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.contextRef = new WeakReference<>(context);
    }
}
