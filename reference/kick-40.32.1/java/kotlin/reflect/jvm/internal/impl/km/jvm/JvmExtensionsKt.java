package kotlin.reflect.jvm.internal.impl.km.jvm;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt;

/* JADX INFO: compiled from: JvmExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
public final class JvmExtensionsKt {
    public static final List<KmAnnotation> getAnnotations(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<this>");
        return JvmExtensionNodesKt.getJvm(kmType).getAnnotations();
    }
}
