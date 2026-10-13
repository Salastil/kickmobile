package com.datadog.trace.api.sampling;

/* JADX INFO: loaded from: classes6.dex */
public class PrioritySampling {
    public static final byte SAMPLER_DROP = 0;
    public static final byte SAMPLER_KEEP = 1;
    public static final byte UNSET = -128;
    public static final byte USER_DROP = -1;
    public static final byte USER_KEEP = 2;

    private PrioritySampling() {
    }
}
