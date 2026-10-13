package com.facebook.fresco.vito.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReleaseStrategy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/facebook/fresco/vito/core/ReleaseStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "IMMEDIATE", "DELAYED", "NEXT_FRAME", "Companion", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ReleaseStrategy {
    IMMEDIATE,
    DELAYED,
    NEXT_FRAME;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<ReleaseStrategy> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    public static final ReleaseStrategy parse(long j) {
        return INSTANCE.parse(j);
    }

    /* JADX INFO: compiled from: ReleaseStrategy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005¨\u0006\u000e"}, d2 = {"Lcom/facebook/fresco/vito/core/ReleaseStrategy$Companion;", "", "<init>", "()V", "parse", "Lcom/facebook/fresco/vito/core/ReleaseStrategy;", "value", "", "release", "", "Lcom/facebook/fresco/vito/core/FrescoController2;", "drawable", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "releaseStrategy", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: ReleaseStrategy.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReleaseStrategy.values().length];
                try {
                    iArr[ReleaseStrategy.IMMEDIATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReleaseStrategy.DELAYED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ReleaseStrategy.NEXT_FRAME.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ReleaseStrategy parse(long value) {
            if (value == 2) {
                return ReleaseStrategy.IMMEDIATE;
            }
            if (value == 1) {
                return ReleaseStrategy.DELAYED;
            }
            return ReleaseStrategy.NEXT_FRAME;
        }

        public final void release(FrescoController2 frescoController2, FrescoDrawableInterface drawable, ReleaseStrategy releaseStrategy) {
            Intrinsics.checkNotNullParameter(frescoController2, "<this>");
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            Intrinsics.checkNotNullParameter(releaseStrategy, "releaseStrategy");
            int i = WhenMappings.$EnumSwitchMapping$0[releaseStrategy.ordinal()];
            if (i == 1) {
                frescoController2.releaseImmediately(drawable);
            } else if (i == 2) {
                frescoController2.releaseDelayed(drawable);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                frescoController2.releaseNextFrame(drawable);
            }
        }
    }
}
