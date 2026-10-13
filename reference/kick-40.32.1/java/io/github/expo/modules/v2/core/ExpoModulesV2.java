package io.github.expo.modules.v2.core;

import io.github.expo.kolibri.Kolibri;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExpoModulesV2.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lio/github/expo/modules/v2/core/ExpoModulesV2;", "", "<init>", "()V", "load", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpoModulesV2 {
    public static final ExpoModulesV2 INSTANCE = new ExpoModulesV2();

    private ExpoModulesV2() {
    }

    public final void load() {
        Kolibri.INSTANCE.load();
    }
}
