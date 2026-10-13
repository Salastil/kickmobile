package com.datadog.android.rum.tracking;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.trace.bootstrap.instrumentation.api.Tags;
import kotlin.Metadata;

/* JADX INFO: compiled from: ComponentPredicate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/datadog/android/rum/tracking/ComponentPredicate;", ExifInterface.GPS_DIRECTION_TRUE, "", "accept", "", Tags.COMPONENT, "(Ljava/lang/Object;)Z", "getViewName", "", "(Ljava/lang/Object;)Ljava/lang/String;", "dd-sdk-android-rum_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ComponentPredicate<T> {
    boolean accept(T component);

    String getViewName(T component);
}
