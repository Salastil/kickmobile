package com.mux.stats.sdk.core.trackers;

import com.datadog.android.rum.internal.domain.battery.DefaultBatteryInfoProvider;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;

/* JADX INFO: loaded from: classes8.dex */
final class a {
    static final a c = new a(10000, 300);
    static final a d = new a(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT, 600);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f270a;
    final int b;

    private a(int i, int i2) {
        this.f270a = i;
        this.b = i2;
    }

    static a a(int i) {
        int i2 = 10000;
        if (i >= 10000) {
            i2 = DefaultBatteryInfoProvider.BATTERY_POLL_INTERVAL_MS;
            if (i <= 60000) {
                i2 = i;
            }
        }
        int i3 = 1000;
        int i4 = (i / 1000) * 30;
        if (i4 < 300) {
            i3 = 300;
        } else if (i4 <= 1000) {
            i3 = i4;
        }
        return new a(i2, i3);
    }
}
