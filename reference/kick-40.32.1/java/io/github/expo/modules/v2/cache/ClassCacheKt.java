package io.github.expo.modules.v2.cache;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClassCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"classCacheOf", "Lio/github/expo/modules/v2/cache/ClassCache;", "builder", "Lkotlin/Function1;", "Lio/github/expo/modules/v2/cache/ClassCache$ClassCacheBuilder;", "", "Lkotlin/ExtensionFunctionType;", "react_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ClassCacheKt {
    public static final ClassCache classCacheOf(Function1<? super ClassCache.ClassCacheBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        ClassCache.ClassCacheBuilder classCacheBuilder = new ClassCache.ClassCacheBuilder();
        builder.invoke(classCacheBuilder);
        return classCacheBuilder.build();
    }
}
