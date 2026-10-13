package com.datadog.android.rum.internal.tracking;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.SdkCore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpFragmentLifecycleCallbacks.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/datadog/android/rum/internal/tracking/NoOpFragmentLifecycleCallbacks;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/app/Activity;", "Lcom/datadog/android/rum/internal/tracking/FragmentLifecycleCallbacks;", "()V", "register", "", "activity", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "(Landroid/app/Activity;Lcom/datadog/android/api/SdkCore;)V", "unregister", "(Landroid/app/Activity;)V", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpFragmentLifecycleCallbacks<T extends Activity> implements FragmentLifecycleCallbacks<T> {
    @Override // com.datadog.android.rum.internal.tracking.FragmentLifecycleCallbacks
    public void register(T activity, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
    }

    @Override // com.datadog.android.rum.internal.tracking.FragmentLifecycleCallbacks
    public void unregister(T activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
