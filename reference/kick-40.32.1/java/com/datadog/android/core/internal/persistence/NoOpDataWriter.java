package com.datadog.android.core.internal.persistence;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpDataWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/core/internal/persistence/NoOpDataWriter;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "()V", "write", "", "element", "(Ljava/lang/Object;)V", "data", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpDataWriter<T> implements DataWriter<T> {
    @Override // com.datadog.android.core.internal.persistence.DataWriter
    public void write(T element) {
        Intrinsics.checkNotNullParameter(element, "element");
    }

    @Override // com.datadog.android.core.internal.persistence.DataWriter
    public void write(List<? extends T> data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }
}
