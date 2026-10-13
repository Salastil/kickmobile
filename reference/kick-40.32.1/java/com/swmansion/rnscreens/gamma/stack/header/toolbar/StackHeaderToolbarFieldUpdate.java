package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderToolbarFieldUpdate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u0000 \u0005*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0003\u0004\u0005\u0082\u0001\u0002\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate;", ExifInterface.GPS_DIRECTION_TRUE, "", "Reset", "Set", "Companion", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate$Reset;", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate$Set;", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface StackHeaderToolbarFieldUpdate<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: StackHeaderToolbarFieldUpdate.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate$Reset;", "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate;", "", "<init>", "()V", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Reset implements StackHeaderToolbarFieldUpdate {
        public static final Reset INSTANCE = new Reset();

        private Reset() {
        }
    }

    /* JADX INFO: compiled from: StackHeaderToolbarFieldUpdate.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate$Set;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate;", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate$Set;", "equals", "", "other", "", "hashCode", "", "toString", "", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Set<T> implements StackHeaderToolbarFieldUpdate<T> {
        private final T value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Set copy$default(Set set, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = set.value;
            }
            return set.copy(obj);
        }

        public final T component1() {
            return this.value;
        }

        public final Set<T> copy(T value) {
            return new Set<>(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Set) && Intrinsics.areEqual(this.value, ((Set) other).value);
        }

        public int hashCode() {
            T t = this.value;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Set(value=" + this.value + ")";
        }

        public Set(T t) {
            this.value = t;
        }

        public final T getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: StackHeaderToolbarFieldUpdate.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u0001H\u0006¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate;", ExifInterface.GPS_DIRECTION_TRUE, "value", "(Ljava/lang/Object;)Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate;", "react-native-screens_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final <T> StackHeaderToolbarFieldUpdate<T> from(T value) {
            if (value != null) {
                return new Set(value);
            }
            return Reset.INSTANCE;
        }
    }
}
