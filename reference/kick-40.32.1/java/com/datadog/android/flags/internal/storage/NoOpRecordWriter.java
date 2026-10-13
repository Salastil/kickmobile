package com.datadog.android.flags.internal.storage;

import com.datadog.android.flags.model.ExposureEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpRecordWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/datadog/android/flags/internal/storage/NoOpRecordWriter;", "Lcom/datadog/android/flags/internal/storage/RecordWriter;", "()V", "write", "", "record", "Lcom/datadog/android/flags/model/ExposureEvent;", "dd-sdk-android-flags_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoOpRecordWriter implements RecordWriter {
    @Override // com.datadog.android.flags.internal.storage.RecordWriter
    public void write(ExposureEvent record) {
        Intrinsics.checkNotNullParameter(record, "record");
    }
}
