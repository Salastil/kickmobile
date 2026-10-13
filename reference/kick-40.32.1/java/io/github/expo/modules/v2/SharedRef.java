package io.github.expo.modules.v2;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedRef.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\tR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/github/expo/modules/v2/SharedRef;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lio/github/expo/modules/v2/SharedObject;", "ref", "<init>", "(Ljava/lang/Object;)V", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lio/github/expo/modules/v2/ExpoContext;", "(Lio/github/expo/modules/v2/ExpoContext;Ljava/lang/Object;)V", "getRef", "()Ljava/lang/Object;", "Ljava/lang/Object;", "nativeRefType", "", "getNativeRefType", "()Ljava/lang/String;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class SharedRef<T> extends SharedObject {
    private final T ref;

    public final T getRef() {
        return this.ref;
    }

    public SharedRef(T ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        this.ref = ref;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedRef(ExpoContext context, T ref) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ref, "ref");
        this.ref = ref;
    }

    public String getNativeRefType() {
        String simpleName = this.ref.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return simpleName;
    }
}
