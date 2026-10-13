package expo.modules.medialibrary.next.objects.query;

import expo.modules.kotlin.types.EitherOfThree;
import expo.modules.medialibrary.next.objects.wrappers.MediaType;
import expo.modules.medialibrary.next.records.AssetField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: MediaStoreQueryFormatter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lexpo/modules/medialibrary/next/objects/query/MediaStoreQueryFormatter;", "", "<init>", "()V", "Companion", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MediaStoreQueryFormatter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: MediaStoreQueryFormatter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\tJ\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bJ\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\n¨\u0006\r"}, d2 = {"Lexpo/modules/medialibrary/next/objects/query/MediaStoreQueryFormatter$Companion;", "", "<init>", "()V", "parse", "", "field", "Lexpo/modules/medialibrary/next/records/AssetField;", "value", "Lexpo/modules/kotlin/types/EitherOfThree;", "Lexpo/modules/medialibrary/next/objects/wrappers/MediaType;", "", "", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String parse(AssetField field, EitherOfThree<MediaType, Long, Boolean> value) {
            Intrinsics.checkNotNullParameter(field, "field");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value.isFirstType(Reflection.getOrCreateKotlinClass(MediaType.class))) {
                return parse(value.getFirstType(Reflection.getOrCreateKotlinClass(MediaType.class)));
            }
            if (value.isThirdType(Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                if (value.getThirdType(Reflection.getOrCreateKotlinClass(Boolean.TYPE)).booleanValue()) {
                    return "1";
                }
                return "0";
            }
            return parse(field, value.getSecondType(Reflection.getOrCreateKotlinClass(Long.TYPE)).longValue());
        }

        public final String parse(AssetField field, long value) {
            Intrinsics.checkNotNullParameter(field, "field");
            if (field == AssetField.MODIFICATION_TIME) {
                return String.valueOf(Duration.m14078getInWholeSecondsimpl(DurationKt.toDuration(value, DurationUnit.MILLISECONDS)));
            }
            return String.valueOf(value);
        }

        public final String parse(MediaType value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return String.valueOf(value.toMediaStoreValue());
        }
    }
}
