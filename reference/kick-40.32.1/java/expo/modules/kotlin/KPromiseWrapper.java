package expo.modules.kotlin;

import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.types.JSTypeConverterProvider;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KPromiseWrapper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/KPromiseWrapper;", "Lexpo/modules/kotlin/Promise;", "bridgePromise", "Lcom/facebook/react/bridge/Promise;", "<init>", "(Lcom/facebook/react/bridge/Promise;)V", "resolve", "", "value", "", "reject", "code", "", "message", "cause", "", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KPromiseWrapper implements Promise {
    public static final int $stable = 8;
    private final com.facebook.react.bridge.Promise bridgePromise;

    public KPromiseWrapper(com.facebook.react.bridge.Promise bridgePromise) {
        Intrinsics.checkNotNullParameter(bridgePromise, "bridgePromise");
        this.bridgePromise = bridgePromise;
    }

    @Override // expo.modules.kotlin.Promise
    public /* bridge */ void reject(CodedException codedException) {
        super.reject(codedException);
    }

    @Override // expo.modules.kotlin.Promise
    public /* bridge */ void resolve() {
        super.resolve();
    }

    @Override // expo.modules.kotlin.Promise
    public /* bridge */ void resolve(double d) {
        super.resolve(d);
    }

    @Override // expo.modules.kotlin.Promise
    public /* bridge */ void resolve(float f) {
        super.resolve(f);
    }

    @Override // expo.modules.kotlin.Promise
    public /* bridge */ void resolve(int i) {
        super.resolve(i);
    }

    @Override // expo.modules.kotlin.Promise
    public /* bridge */ void resolve(String str) {
        super.resolve(str);
    }

    @Override // expo.modules.kotlin.Promise
    public /* bridge */ void resolve(Collection<? extends Object> collection) {
        super.resolve(collection);
    }

    @Override // expo.modules.kotlin.Promise
    public /* bridge */ void resolve(Map<String, ? extends Object> map) {
        super.resolve(map);
    }

    @Override // expo.modules.kotlin.Promise
    public /* bridge */ void resolve(boolean z) {
        super.resolve(z);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Object value) {
        this.bridgePromise.resolve(JSTypeConverterProvider.convertToJSValue$default(JSTypeConverterProvider.INSTANCE, value, null, false, 6, null));
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(String code, String message, Throwable cause) {
        this.bridgePromise.reject(code, message, cause);
    }
}
