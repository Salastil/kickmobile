package com.datadog.trace.api;

import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public final class Platform {
    private static final Version JAVA_VERSION = parseJavaVersion(System.getProperty("java.version"));
    private static final JvmRuntime RUNTIME = new JvmRuntime();

    public enum GC {
        SERIAL("marksweep"),
        PARALLEL("ps"),
        CMS("concurrentmarksweep"),
        G1("g1"),
        SHENANDOAH("shenandoah"),
        Z(ViewDeviceOrientationData.DEVICE_ORIENTATION_Z),
        UNKNOWN("");

        private final String identifierPrefix;

        GC(String str) {
            this.identifierPrefix = str;
        }
    }

    private static List<Integer> splitDigits(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= '0' && cCharAt <= '9') {
                i = (i * 10) + (cCharAt - '0');
            } else if (cCharAt == '.' || cCharAt == '_' || cCharAt == '+') {
                arrayList.add(Integer.valueOf(i));
                i = 0;
            } else {
                throw new NumberFormatException();
            }
        }
        arrayList.add(Integer.valueOf(i));
        return arrayList;
    }

    private static Version parseJavaVersion(String str) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int iIndexOf = str.indexOf(45);
        int i = 0;
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        try {
            List<Integer> listSplitDigits = splitDigits(str);
            iIntValue = listSplitDigits.get(0).intValue();
            try {
                if (iIntValue == 1) {
                    iIntValue = listSplitDigits.get(1).intValue();
                    iIntValue2 = listSplitDigits.get(2).intValue();
                    try {
                        iIntValue3 = listSplitDigits.get(3).intValue();
                        i = iIntValue3;
                    } catch (IndexOutOfBoundsException | NumberFormatException unused) {
                    }
                } else {
                    int iIntValue4 = listSplitDigits.get(1).intValue();
                    try {
                        iIntValue3 = listSplitDigits.get(2).intValue();
                        iIntValue2 = iIntValue4;
                        i = iIntValue3;
                    } catch (IndexOutOfBoundsException | NumberFormatException unused2) {
                        iIntValue2 = iIntValue4;
                    }
                }
            } catch (IndexOutOfBoundsException | NumberFormatException unused3) {
                iIntValue2 = i;
            }
        } catch (IndexOutOfBoundsException | NumberFormatException unused4) {
            iIntValue = 0;
            iIntValue2 = 0;
        }
        return new Version(iIntValue, iIntValue2, i);
    }

    static final class Version {
        public final int major;
        public final int minor;
        public final int update;

        private static boolean isAtLeast(int i, int i2, int i3, int i4, int i5, int i6) {
            if (i > i4) {
                return true;
            }
            if (i != i4 || i2 <= i5) {
                return i == i4 && i2 == i5 && i3 >= i6;
            }
            return true;
        }

        public Version(int i, int i2, int i3) {
            this.major = i;
            this.minor = i2;
            this.update = i3;
        }

        public boolean is(int i) {
            return this.major == i;
        }

        public boolean is(int i, int i2) {
            return this.major == i && this.minor == i2;
        }

        public boolean is(int i, int i2, int i3) {
            return this.major == i && this.minor == i2 && this.update == i3;
        }

        public boolean isAtLeast(int i, int i2, int i3) {
            return isAtLeast(this.major, this.minor, this.update, i, i2, i3);
        }

        public boolean isBetween(int i, int i2, int i3, int i4, int i5, int i6) {
            return isAtLeast(i4, i5, i6, i, i2, i3) && isAtLeast(i, i2, i3) && !isAtLeast(i4, i5, i6);
        }
    }

    static final class JvmRuntime {
        public final String name;
        public final String patches;
        public final String vendor;
        public final String vendorVersion;
        public final String version;

        public JvmRuntime() {
            this(System.getProperty("java.version"), System.getProperty("java.runtime.version"), System.getProperty("java.runtime.name"), System.getProperty("java.vm.vendor"), System.getProperty("java.vendor.version"));
        }

        JvmRuntime(String str, String str2, String str3, String str4, String str5) {
            this.name = str3 == null ? "" : str3;
            this.vendor = str4 == null ? "" : str4;
            str = str == null ? "" : str;
            this.version = str;
            this.vendorVersion = str5 == null ? "" : str5;
            str2 = (str.isEmpty() || str2 == null) ? str : str2;
            this.patches = str.length() + 1 < str2.length() ? str2.substring(str.length() + 1) : "";
        }
    }

    public static boolean isJavaVersion(int i) {
        return JAVA_VERSION.is(i);
    }

    public static boolean isJavaVersion(int i, int i2) {
        return JAVA_VERSION.is(i, i2);
    }

    public static boolean isJavaVersion(int i, int i2, int i3) {
        return JAVA_VERSION.is(i, i2, i3);
    }

    public static boolean isJavaVersionAtLeast(int i) {
        return isJavaVersionAtLeast(i, 0, 0);
    }

    public static boolean isJavaVersionAtLeast(int i, int i2) {
        return isJavaVersionAtLeast(i, i2, 0);
    }

    public static boolean isJavaVersionAtLeast(int i, int i2, int i3) {
        return JAVA_VERSION.isAtLeast(i, i2, i3);
    }

    public static boolean isJavaVersionBetween(int i, int i2) {
        return isJavaVersionBetween(i, 0, i2, 0);
    }

    public static boolean isJavaVersionBetween(int i, int i2, int i3, int i4) {
        return isJavaVersionBetween(i, i2, 0, i3, i4, 0);
    }

    public static boolean isJavaVersionBetween(int i, int i2, int i3, int i4, int i5, int i6) {
        return JAVA_VERSION.isBetween(i, i2, i3, i4, i5, i6);
    }

    public static boolean isOracleJDK8() {
        if (!isJavaVersion(8)) {
            return false;
        }
        JvmRuntime jvmRuntime = RUNTIME;
        return jvmRuntime.vendor.contains("Oracle") && !jvmRuntime.name.contains("OpenJDK");
    }

    public static boolean isJ9() {
        return System.getProperty("java.vm.name").contains("J9");
    }

    public static boolean isIbm8() {
        return isJavaVersion(8) && RUNTIME.vendor.contains("IBM");
    }

    public static boolean isGraalVM() {
        return RUNTIME.vendorVersion.toLowerCase(Locale.US).contains("graalvm");
    }

    public static String getLangVersion() {
        return String.valueOf(JAVA_VERSION.major);
    }

    public static String getRuntimeVendor() {
        return RUNTIME.vendor;
    }

    public static String getRuntimeVersion() {
        return RUNTIME.version;
    }

    public static String getRuntimePatches() {
        return RUNTIME.patches;
    }
}
