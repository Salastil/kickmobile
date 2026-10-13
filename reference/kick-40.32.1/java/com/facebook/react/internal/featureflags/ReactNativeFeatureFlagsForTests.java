package com.facebook.react.internal.featureflags;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ReactNativeFeatureFlagsForTests.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsForTests;", "", "<init>", "()V", "setUp", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReactNativeFeatureFlagsForTests {
    public static final ReactNativeFeatureFlagsForTests INSTANCE = new ReactNativeFeatureFlagsForTests();

    private ReactNativeFeatureFlagsForTests() {
    }

    static final ReactNativeFeatureFlagsAccessor setUp$lambda$0() {
        return new ReactNativeFeatureFlagsLocalAccessor();
    }

    public final void setUp() {
        ReactNativeFeatureFlags.INSTANCE.setAccessorProvider$ReactAndroid(new Function0() { // from class: com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsForTests$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReactNativeFeatureFlagsForTests.setUp$lambda$0();
            }
        });
    }
}
