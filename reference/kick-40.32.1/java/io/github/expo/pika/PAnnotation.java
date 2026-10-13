package io.github.expo.pika;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PAnnotation.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/github/expo/pika/PAnnotation;", "", "jClass", "Ljava/lang/Class;", "arguments", "", "", "<init>", "(Ljava/lang/Class;Ljava/util/Map;)V", "getJClass", "()Ljava/lang/Class;", "getArguments", "()Ljava/util/Map;", "pika-api"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PAnnotation {
    private final Map<String, Object> arguments;
    private final Class<?> jClass;

    public PAnnotation(Class<?> jClass, Map<String, ? extends Object> arguments) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.jClass = jClass;
        this.arguments = arguments;
    }

    public final Class<?> getJClass() {
        return this.jClass;
    }

    public final Map<String, Object> getArguments() {
        return this.arguments;
    }
}
