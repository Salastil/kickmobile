package io.github.centrifugal.centrifuge.internal.backoff;

/* JADX INFO: loaded from: classes9.dex */
public class Backoff {
    public long duration(int i, int i2, int i3) {
        double d = i;
        if (d > 31.0d) {
            d = 31.0d;
        }
        return Math.min(i3, i2 + ((int) (Math.random() * (Math.min(i3, ((double) i2) * Math.pow(2.0d, d)) + 1.0d))));
    }
}
