package expo.modules.medialibrary.next.objects.wrappers;

import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import expo.modules.kotlin.types.Enumerable;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AUDIO", "IMAGE", "VIDEO", "UNKNOWN", "toMediaStoreValue", "", "Companion", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum MediaType implements Enumerable {
    AUDIO("audio"),
    IMAGE("image"),
    VIDEO("video"),
    UNKNOWN("unknown");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: MediaType.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.AUDIO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaType.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<MediaType> getEntries() {
        return $ENTRIES;
    }

    MediaType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final int toMediaStoreValue() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 3;
        }
        if (i == 4) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: MediaType.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lexpo/modules/medialibrary/next/objects/wrappers/MediaType$Companion;", "", "<init>", "()V", "fromString", "Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;", TypedValues.Custom.S_STRING, "", "fromMediaStoreValue", "mediaStoreValue", "", "fromContentUri", "contentUri", "Landroid/net/Uri;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaType fromString(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            String lowerCase = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != 93166550) {
                if (iHashCode != 100313435) {
                    if (iHashCode == 112202875 && lowerCase.equals("video")) {
                        return MediaType.VIDEO;
                    }
                } else if (lowerCase.equals("image")) {
                    return MediaType.IMAGE;
                }
            } else if (lowerCase.equals("audio")) {
                return MediaType.AUDIO;
            }
            return MediaType.UNKNOWN;
        }

        public final MediaType fromMediaStoreValue(int mediaStoreValue) {
            if (mediaStoreValue == 1) {
                return MediaType.IMAGE;
            }
            if (mediaStoreValue == 2) {
                return MediaType.AUDIO;
            }
            if (mediaStoreValue == 3) {
                return MediaType.VIDEO;
            }
            return MediaType.UNKNOWN;
        }

        public final MediaType fromContentUri(Uri contentUri) {
            Intrinsics.checkNotNullParameter(contentUri, "contentUri");
            List<String> pathSegments = contentUri.getPathSegments();
            if (pathSegments.contains("images")) {
                return MediaType.IMAGE;
            }
            if (pathSegments.contains("video")) {
                return MediaType.VIDEO;
            }
            if (pathSegments.contains("audio")) {
                return MediaType.AUDIO;
            }
            return MediaType.UNKNOWN;
        }
    }
}
