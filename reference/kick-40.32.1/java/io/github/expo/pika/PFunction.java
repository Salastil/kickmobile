package io.github.expo.pika;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PFunction.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/github/expo/pika/PFunction;", "", "name", "", "visibility", "Lio/github/expo/pika/PVisibility;", "<init>", "(Ljava/lang/String;Lio/github/expo/pika/PVisibility;)V", "getName", "()Ljava/lang/String;", "getVisibility", "()Lio/github/expo/pika/PVisibility;", "pika-api"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PFunction {
    private final String name;
    private final PVisibility visibility;

    public PFunction(String name, PVisibility visibility) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        this.name = name;
        this.visibility = visibility;
    }

    public final String getName() {
        return this.name;
    }

    public final PVisibility getVisibility() {
        return this.visibility;
    }
}
