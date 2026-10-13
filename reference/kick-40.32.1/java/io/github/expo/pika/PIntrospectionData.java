package io.github.expo.pika;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PIntrospectionData.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002BW\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0016\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\t0\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R#\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\t0\u0006¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/github/expo/pika/PIntrospectionData;", "OwnerType", "", "jClass", "Ljava/lang/Class;", "annotations", "", "Lio/github/expo/pika/PAnnotation;", "properties", "Lio/github/expo/pika/PProperty;", "functions", "Lio/github/expo/pika/PFunction;", "baseClass", "<init>", "(Ljava/lang/Class;[Lio/github/expo/pika/PAnnotation;[Lio/github/expo/pika/PProperty;[Lio/github/expo/pika/PFunction;Lio/github/expo/pika/PIntrospectionData;)V", "getJClass", "()Ljava/lang/Class;", "getAnnotations", "()[Lio/github/expo/pika/PAnnotation;", "[Lio/github/expo/pika/PAnnotation;", "getProperties", "()[Lio/github/expo/pika/PProperty;", "[Lio/github/expo/pika/PProperty;", "getFunctions", "()[Lio/github/expo/pika/PFunction;", "[Lio/github/expo/pika/PFunction;", "getBaseClass", "()Lio/github/expo/pika/PIntrospectionData;", "pika-api"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PIntrospectionData<OwnerType> {
    private final PAnnotation[] annotations;
    private final PIntrospectionData<?> baseClass;
    private final PFunction[] functions;
    private final Class<OwnerType> jClass;
    private final PProperty<OwnerType, ?>[] properties;

    public PIntrospectionData(Class<OwnerType> jClass, PAnnotation[] annotations, PProperty<OwnerType, ?>[] properties, PFunction[] functions, PIntrospectionData<?> pIntrospectionData) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(functions, "functions");
        this.jClass = jClass;
        this.annotations = annotations;
        this.properties = properties;
        this.functions = functions;
        this.baseClass = pIntrospectionData;
    }

    public final Class<OwnerType> getJClass() {
        return this.jClass;
    }

    public final PAnnotation[] getAnnotations() {
        return this.annotations;
    }

    public final PProperty<OwnerType, ?>[] getProperties() {
        return this.properties;
    }

    public final PFunction[] getFunctions() {
        return this.functions;
    }

    public final PIntrospectionData<?> getBaseClass() {
        return this.baseClass;
    }
}
