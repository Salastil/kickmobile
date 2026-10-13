package io.github.expo.modules.v2.jni;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: ClassExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"%\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"jniDescriptor", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/Class;", "getJniDescriptor", "(Ljava/lang/Class;)Ljava/lang/String;", "react_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ClassExtensionsKt {
    public static final <T> String getJniDescriptor(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        String name = cls.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return "L" + StringsKt.replace$default(name, FilenameUtils.EXTENSION_SEPARATOR, '/', false, 4, (Object) null) + ";";
    }
}
