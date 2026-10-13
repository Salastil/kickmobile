package io.github.expo.modules.v2.types;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnyType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {"buffered", "Lio/github/expo/modules/v2/types/AnyType;", "react_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnyTypeKt {
    public static final AnyType buffered(AnyType anyType) {
        Intrinsics.checkNotNullParameter(anyType, "<this>");
        return new AnyType(anyType.getDescriptor(), true);
    }
}
