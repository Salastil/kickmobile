package androidx.camera.camera2.pipe.graph;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class GraphState3A_Factory implements Factory<GraphState3A> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GraphState3A get() {
        return newInstance();
    }

    public static GraphState3A_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static GraphState3A newInstance() {
        return new GraphState3A();
    }

    private static final class InstanceHolder {
        static final GraphState3A_Factory INSTANCE = new GraphState3A_Factory();

        private InstanceHolder() {
        }
    }
}
