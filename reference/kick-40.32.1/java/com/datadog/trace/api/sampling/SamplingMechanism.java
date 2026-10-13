package com.datadog.trace.api.sampling;

/* JADX INFO: loaded from: classes6.dex */
public class SamplingMechanism {
    public static final byte AGENT_RATE = 1;
    public static final byte APPSEC = 5;
    public static final byte DATA_JOBS = 10;
    public static final byte DEFAULT = 0;
    public static final byte EXTERNAL_OVERRIDE = -128;
    public static final byte MANUAL = 4;
    public static final byte REMOTE_AUTO_RATE = 2;
    public static final byte REMOTE_USER_RATE = 6;
    public static final byte RULE = 3;
    public static final byte SPAN_SAMPLING_RATE = 8;
    public static final byte UNKNOWN = -1;

    public static boolean validateWithSamplingPriority(int i, int i2) {
        if (i != -128) {
            if (i != 10) {
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                        return i2 == 0 || i2 == 1;
                    case 3:
                    case 4:
                    case 6:
                        return i2 == -1 || i2 == 2;
                    case 5:
                        break;
                    default:
                        return true;
                }
            }
            if (i2 == 2) {
                return true;
            }
        }
        return false;
    }

    private SamplingMechanism() {
    }
}
