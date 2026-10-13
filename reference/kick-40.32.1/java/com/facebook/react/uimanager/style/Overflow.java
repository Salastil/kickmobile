package com.facebook.react.uimanager.style;

import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Overflow.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/facebook/react/uimanager/style/Overflow;", "", "<init>", "(Ljava/lang/String;I)V", "VISIBLE", "HIDDEN", "SCROLL", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum Overflow {
    VISIBLE,
    HIDDEN,
    SCROLL;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final Overflow fromString(String str) {
        return INSTANCE.fromString(str);
    }

    @JvmStatic
    public static final Overflow fromString(String str, Overflow overflow) {
        return INSTANCE.fromString(str, overflow);
    }

    public static EnumEntries<Overflow> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: compiled from: Overflow.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/react/uimanager/style/Overflow$Companion;", "", "<init>", "()V", "fromString", "Lcom/facebook/react/uimanager/style/Overflow;", ViewProps.OVERFLOW, "", Constants.COLLATION_DEFAULT, "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Overflow fromString(String str) {
            return fromString$default(this, str, null, 2, null);
        }

        private Companion() {
        }

        public static /* synthetic */ Overflow fromString$default(Companion companion, String str, Overflow overflow, int i, Object obj) {
            if ((i & 2) != 0) {
                overflow = Overflow.VISIBLE;
            }
            return companion.fromString(str, overflow);
        }

        @JvmStatic
        public final Overflow fromString(String overflow, Overflow overflow2) {
            String lowerCase;
            Intrinsics.checkNotNullParameter(overflow2, "default");
            if (overflow != null) {
                lowerCase = overflow.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                int iHashCode = lowerCase.hashCode();
                if (iHashCode != -1217487446) {
                    if (iHashCode != -907680051) {
                        if (iHashCode == 466743410 && lowerCase.equals(ViewProps.VISIBLE)) {
                            return Overflow.VISIBLE;
                        }
                    } else if (lowerCase.equals(ViewProps.SCROLL)) {
                        return Overflow.SCROLL;
                    }
                } else if (lowerCase.equals(ViewProps.HIDDEN)) {
                    return Overflow.HIDDEN;
                }
            }
            return overflow2;
        }
    }
}
