package expo.modules.kotlin.views;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.ConverterContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnyViewProp.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0015X \u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lexpo/modules/kotlin/views/AnyViewProp;", "", "name", "", "type", "Lexpo/modules/kotlin/types/AnyType;", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/types/AnyType;)V", "getName", "()Ljava/lang/String;", "getType$expo_modules_core_release", "()Lexpo/modules/kotlin/types/AnyType;", "set", "", "prop", "Lcom/facebook/react/bridge/Dynamic;", "onView", "Landroid/view/View;", "converterContext", "Lexpo/modules/kotlin/types/ConverterContext;", "isNullable", "", "()Z", "isStateProp", "isStateProp$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AnyViewProp {
    public static final int $stable = 8;
    private final String name;
    private final AnyType type;

    public abstract boolean isNullable();

    public abstract boolean isStateProp$expo_modules_core_release();

    public abstract void set(Dynamic prop, View onView, ConverterContext converterContext);

    public abstract void set(Object prop, View onView, ConverterContext converterContext);

    public AnyViewProp(String name, AnyType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.type = type;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: getType$expo_modules_core_release, reason: from getter */
    public final AnyType getType() {
        return this.type;
    }
}
