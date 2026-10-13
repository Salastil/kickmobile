package org.h.s;

import io.mobileshield.sdk.InitializeException;
import io.mobileshield.sdk.config.Config;
import io.mobileshield.sdk.config.Method;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public final class r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Config[] f565a;
    public final CountDownLatch b = new CountDownLatch(1);

    public final void a(Config[] config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f565a = config;
        String str = g0.f510a;
        if (config == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localConfigs");
            config = null;
        }
        g0.b = config[0];
        if (y1.i == null) {
            y1.i = new y1(Dispatchers.getIO(), new t1());
        }
        y1 y1Var = y1.i;
        Intrinsics.checkNotNull(y1Var);
        Config[] configArr = this.f565a;
        if (configArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localConfigs");
            configArr = null;
        }
        y1Var.g = configArr[0];
        Config[] configArr2 = this.f565a;
        if (configArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localConfigs");
            configArr2 = null;
        }
        s3.h = configArr2[0];
        ArrayList arrayList = new ArrayList();
        Config[] configArr3 = this.f565a;
        if (configArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localConfigs");
            configArr3 = null;
        }
        CollectionsKt.addAll(arrayList, configArr3);
        for (s0 s0Var : t0.f572a) {
            Config.Companion companion = Config.INSTANCE;
            Config[] configArr4 = this.f565a;
            if (configArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("localConfigs");
                configArr4 = null;
            }
            arrayList.add(companion.createConfigForInternalEndpoints$sdk_release(configArr4[0], s0Var));
        }
        this.f565a = (Config[]) arrayList.toArray(new Config[0]);
        this.b.countDown();
    }

    public final boolean a(String method, String hostName, String path) throws InitializeException {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(hostName, "hostName");
        Intrinsics.checkNotNullParameter(path, "path");
        if (this.f565a == null && !this.b.await(1000L, t4.f575a)) {
            throw new InitializeException("Mobile Shield Not Initialized. Local Config not created.");
        }
        Config[] configArr = this.f565a;
        if (configArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localConfigs");
            configArr = null;
        }
        for (Config config : configArr) {
            if (StringsKt.equals(config.getDomain(), hostName, true)) {
                Method type = config.getType();
                Intrinsics.checkNotNullParameter(type, "<this>");
                Intrinsics.checkNotNullParameter(method, "method");
                if (type == Method.ANY || StringsKt.equals(type.name(), method, true)) {
                    for (String str : config.getEndpoints()) {
                        Intrinsics.checkNotNull(str);
                        if (config.isMatch(path, str)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
