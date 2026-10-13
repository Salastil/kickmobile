package com.datadog.android.rum.internal.domain.accessibility;

import com.datadog.android.rum.internal.domain.InfoProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultAccessibilitySnapshotManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\f\u0010\u000b\u001a\u00020\f*\u00020\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/internal/domain/accessibility/DefaultAccessibilitySnapshotManager;", "Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilitySnapshotManager;", "accessibilityReader", "Lcom/datadog/android/rum/internal/domain/InfoProvider;", "Lcom/datadog/android/rum/internal/domain/accessibility/AccessibilityInfo;", "(Lcom/datadog/android/rum/internal/domain/InfoProvider;)V", "lastSnapshot", "createDelta", "new", "old", "getIfChanged", "hasAnyNonNullValues", "", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultAccessibilitySnapshotManager implements AccessibilitySnapshotManager {
    private final InfoProvider<AccessibilityInfo> accessibilityReader;
    private volatile AccessibilityInfo lastSnapshot;

    public DefaultAccessibilitySnapshotManager(InfoProvider<AccessibilityInfo> accessibilityReader) {
        Intrinsics.checkNotNullParameter(accessibilityReader, "accessibilityReader");
        this.accessibilityReader = accessibilityReader;
    }

    @Override // com.datadog.android.rum.internal.domain.accessibility.AccessibilitySnapshotManager
    public synchronized AccessibilityInfo getIfChanged() {
        AccessibilityInfo accessibilityInfo = (AccessibilityInfo) this.accessibilityReader.getState();
        if (Intrinsics.areEqual(accessibilityInfo, this.lastSnapshot)) {
            return null;
        }
        AccessibilityInfo accessibilityInfoCreateDelta = createDelta(accessibilityInfo, this.lastSnapshot);
        this.lastSnapshot = accessibilityInfo;
        return hasAnyNonNullValues(accessibilityInfoCreateDelta) ? accessibilityInfoCreateDelta : null;
    }

    private final AccessibilityInfo createDelta(AccessibilityInfo accessibilityInfo, AccessibilityInfo old) {
        String textSize = accessibilityInfo.getTextSize();
        String str = !Intrinsics.areEqual(textSize, old != null ? old.getTextSize() : null) ? textSize : null;
        Boolean boolIsScreenReaderEnabled = accessibilityInfo.isScreenReaderEnabled();
        Boolean bool = !Intrinsics.areEqual(boolIsScreenReaderEnabled, old != null ? old.isScreenReaderEnabled() : null) ? boolIsScreenReaderEnabled : null;
        Boolean boolIsColorInversionEnabled = accessibilityInfo.isColorInversionEnabled();
        Boolean bool2 = !Intrinsics.areEqual(boolIsColorInversionEnabled, old != null ? old.isColorInversionEnabled() : null) ? boolIsColorInversionEnabled : null;
        Boolean boolIsClosedCaptioningEnabled = accessibilityInfo.isClosedCaptioningEnabled();
        Boolean bool3 = !Intrinsics.areEqual(boolIsClosedCaptioningEnabled, old != null ? old.isClosedCaptioningEnabled() : null) ? boolIsClosedCaptioningEnabled : null;
        Boolean boolIsReducedAnimationsEnabled = accessibilityInfo.isReducedAnimationsEnabled();
        Boolean bool4 = !Intrinsics.areEqual(boolIsReducedAnimationsEnabled, old != null ? old.isReducedAnimationsEnabled() : null) ? boolIsReducedAnimationsEnabled : null;
        Boolean boolIsScreenPinningEnabled = accessibilityInfo.isScreenPinningEnabled();
        Boolean bool5 = !Intrinsics.areEqual(boolIsScreenPinningEnabled, old != null ? old.isScreenPinningEnabled() : null) ? boolIsScreenPinningEnabled : null;
        Boolean boolIsRtlEnabled = accessibilityInfo.isRtlEnabled();
        return new AccessibilityInfo(str, bool, bool2, bool3, bool4, bool5, !Intrinsics.areEqual(boolIsRtlEnabled, old != null ? old.isRtlEnabled() : null) ? boolIsRtlEnabled : null);
    }

    private final boolean hasAnyNonNullValues(AccessibilityInfo accessibilityInfo) {
        Set of = SetsKt.setOf(accessibilityInfo.getTextSize(), accessibilityInfo.isScreenReaderEnabled(), accessibilityInfo.isRtlEnabled(), accessibilityInfo.isScreenPinningEnabled(), accessibilityInfo.isColorInversionEnabled(), accessibilityInfo.isClosedCaptioningEnabled(), accessibilityInfo.isReducedAnimationsEnabled());
        if ((of instanceof Collection) && of.isEmpty()) {
            return false;
        }
        Iterator it = of.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                return true;
            }
        }
        return false;
    }
}
