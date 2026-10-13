package expo.modules.ui.image;

import androidx.compose.ui.layout.ContentScale;
import com.datadog.trace.api.config.ProfilingConfig;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ImageView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0012"}, d2 = {"Lexpo/modules/ui/image/ImageContentScale;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FIT", "CROP", "FILL_BOUNDS", "FILL_WIDTH", "FILL_HEIGHT", "INSIDE", ProfilingConfig.PROFILING_DATADOG_PROFILER_LOG_LEVEL_DEFAULT, "toComposeContentScale", "Landroidx/compose/ui/layout/ContentScale;", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ImageContentScale implements Enumerable {
    FIT("fit"),
    CROP("crop"),
    FILL_BOUNDS("fillBounds"),
    FILL_WIDTH("fillWidth"),
    FILL_HEIGHT("fillHeight"),
    INSIDE("inside"),
    NONE("none");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: ImageView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageContentScale.values().length];
            try {
                iArr[ImageContentScale.FIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageContentScale.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageContentScale.FILL_BOUNDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageContentScale.FILL_WIDTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ImageContentScale.FILL_HEIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ImageContentScale.INSIDE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ImageContentScale.NONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<ImageContentScale> getEntries() {
        return $ENTRIES;
    }

    ImageContentScale(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final ContentScale toComposeContentScale() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return ContentScale.INSTANCE.getFit();
            case 2:
                return ContentScale.INSTANCE.getCrop();
            case 3:
                return ContentScale.INSTANCE.getFillBounds();
            case 4:
                return ContentScale.INSTANCE.getFillWidth();
            case 5:
                return ContentScale.INSTANCE.getFillHeight();
            case 6:
                return ContentScale.INSTANCE.getInside();
            case 7:
                return ContentScale.INSTANCE.getNone();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
