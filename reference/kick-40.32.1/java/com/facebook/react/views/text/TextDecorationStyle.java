package com.facebook.react.views.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TextDecorationStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/facebook/react/views/text/TextDecorationStyle;", "", "<init>", "(Ljava/lang/String;I)V", "SOLID", "DOUBLE", "DOTTED", "DASHED", "WAVY", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum TextDecorationStyle {
    SOLID,
    DOUBLE,
    DOTTED,
    DASHED,
    WAVY;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final TextDecorationStyle fromString(String str) {
        return INSTANCE.fromString(str);
    }

    public static EnumEntries<TextDecorationStyle> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: compiled from: TextDecorationStyle.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/views/text/TextDecorationStyle$Companion;", "", "<init>", "()V", "fromString", "Lcom/facebook/react/views/text/TextDecorationStyle;", "value", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JvmStatic
        public final TextDecorationStyle fromString(String value) {
            if (value != null) {
                switch (value.hashCode()) {
                    case -1338941519:
                        if (value.equals("dashed")) {
                            return TextDecorationStyle.DASHED;
                        }
                        break;
                    case -1325970902:
                        if (value.equals("dotted")) {
                            return TextDecorationStyle.DOTTED;
                        }
                        break;
                    case -1325958191:
                        if (value.equals("double")) {
                            return TextDecorationStyle.DOUBLE;
                        }
                        break;
                    case 3642125:
                        if (value.equals("wavy")) {
                            return TextDecorationStyle.WAVY;
                        }
                        break;
                }
            }
            return TextDecorationStyle.SOLID;
        }
    }
}
