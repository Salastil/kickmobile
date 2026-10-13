package com.amazon.mediatailorsdk;

import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: compiled from: Platform.android.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/amazon/mediatailorsdk/AndroidPlatform;", "Lcom/amazon/mediatailorsdk/Platform;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "MediaTailor_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AndroidPlatform implements Platform {
    private final String name = "Android " + Build.VERSION.SDK_INT;

    @Override // com.amazon.mediatailorsdk.Platform
    public String getName() {
        return this.name;
    }
}
