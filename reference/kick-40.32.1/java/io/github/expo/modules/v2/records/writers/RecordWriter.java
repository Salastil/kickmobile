package io.github.expo.modules.v2.records.writers;

import io.github.expo.modules.v2.types.TypeDescriptor;
import kotlin.Metadata;

/* JADX INFO: compiled from: RecordWriter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH&J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH&J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH&J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lio/github/expo/modules/v2/records/writers/RecordWriter;", "", "write", "", "value", "", "(Ljava/lang/Boolean;)V", "", "(Ljava/lang/Integer;)V", "", "(Ljava/lang/Long;)V", "", "(Ljava/lang/Float;)V", "", "(Ljava/lang/Double;)V", "schema", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RecordWriter {
    void write(double value);

    void write(float value);

    void write(int value);

    void write(long value);

    void write(Boolean value);

    void write(Double value);

    void write(Float value);

    void write(Integer value);

    void write(Long value);

    void write(Object value, TypeDescriptor schema);

    void write(boolean value);
}
