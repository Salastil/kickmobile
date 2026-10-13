package org.linusu;

import android.util.Base64;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
@ReactModule(name = "RNGetRandomValues")
public class RNGetRandomValuesModule extends NativeRNGetRandomValuesSpec {
    protected static final String NAME = "RNGetRandomValues";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public RNGetRandomValuesModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // org.linusu.NativeRNGetRandomValuesSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNGetRandomValues";
    }

    @Override // org.linusu.NativeRNGetRandomValuesSpec
    public String getRandomBase64(double d) {
        byte[] bArr = new byte[(int) d];
        SECURE_RANDOM.nextBytes(bArr);
        return Base64.encodeToString(bArr, 2);
    }
}
