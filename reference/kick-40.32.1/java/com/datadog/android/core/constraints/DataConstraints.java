package com.datadog.android.core.constraints;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.RumFeature;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: DataConstraints.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JV\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00050\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH&J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH&J(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0007H&¨\u0006\u0012"}, d2 = {"Lcom/datadog/android/core/constraints/DataConstraints;", "", "validateAttributes", "", "", ExifInterface.GPS_DIRECTION_TRUE, RumFeature.EVENT_ATTRIBUTES_PROPERTY, "", "keyPrefix", "attributesGroupName", "reservedKeys", "", "validateTags", "", "tags", "validateTimings", "", "timings", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DataConstraints {
    <T> Map<String, T> validateAttributes(Map<String, ? extends T> attributes, String keyPrefix, String attributesGroupName, Set<String> reservedKeys);

    List<String> validateTags(List<String> tags);

    Map<String, Long> validateTimings(Map<String, Long> timings);

    /* JADX INFO: compiled from: DataConstraints.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Map validateAttributes$default(DataConstraints dataConstraints, Map map, String str, String str2, Set set, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateAttributes");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                set = SetsKt.emptySet();
            }
            return dataConstraints.validateAttributes(map, str, str2, set);
        }
    }
}
