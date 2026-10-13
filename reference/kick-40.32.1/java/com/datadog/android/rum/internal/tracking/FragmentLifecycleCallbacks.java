package com.datadog.android.rum.internal.tracking;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.SdkCore;
import kotlin.Metadata;

/* JADX INFO: compiled from: FragmentLifecycleCallbacks.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/datadog/android/rum/internal/tracking/FragmentLifecycleCallbacks;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/app/Activity;", "", "register", "", "activity", "sdkCore", "Lcom/datadog/android/api/SdkCore;", "(Landroid/app/Activity;Lcom/datadog/android/api/SdkCore;)V", "unregister", "(Landroid/app/Activity;)V", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FragmentLifecycleCallbacks<T extends Activity> {
    void register(T activity, SdkCore sdkCore);

    void unregister(T activity);
}
