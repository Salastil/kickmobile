package io.github.expo.modules.v2.records.readers;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.modules.v2.types.TypeDescriptor;
import kotlin.Metadata;

/* JADX INFO: compiled from: RecordReader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH&J\u000f\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH&J\u000f\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H&J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H&J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&¢\u0006\u0002\u0010\u001b¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lio/github/expo/modules/v2/records/readers/RecordReader;", "", "readIsPresent", "", "readBoolean", "readBooleanOrNull", "()Ljava/lang/Boolean;", "readInt", "", "readIntOrNull", "()Ljava/lang/Integer;", "readLong", "", "readLongOrNull", "()Ljava/lang/Long;", "readFloat", "", "readFloatOrNull", "()Ljava/lang/Float;", "readDouble", "", "readDoubleOrNull", "()Ljava/lang/Double;", "read", ExifInterface.GPS_DIRECTION_TRUE, "schema", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "(Lio/github/expo/modules/v2/types/TypeDescriptor;)Ljava/lang/Object;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RecordReader {
    <T> T read(TypeDescriptor schema);

    boolean readBoolean();

    Boolean readBooleanOrNull();

    double readDouble();

    Double readDoubleOrNull();

    float readFloat();

    Float readFloatOrNull();

    int readInt();

    Integer readIntOrNull();

    boolean readIsPresent();

    long readLong();

    Long readLongOrNull();
}
