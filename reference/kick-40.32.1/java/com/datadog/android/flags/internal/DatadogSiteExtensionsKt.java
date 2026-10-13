package com.datadog.android.flags.internal;

import com.datadog.android.DatadogSite;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatadogSiteExtensions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"FLAGS_PATH", "", "buildFlagsHostString", "customerDomain", "dc", "tld", "flagsHost", "Lcom/datadog/android/DatadogSite;", "getFlagsEndpoint", "dd-sdk-android-flags_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DatadogSiteExtensionsKt {
    private static final String FLAGS_PATH = "/precompute-assignments";

    /* JADX INFO: compiled from: DatadogSiteExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DatadogSite.values().length];
            try {
                iArr[DatadogSite.US1_FED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DatadogSite.US2_FED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DatadogSite.STAGING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DatadogSite.EU1.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DatadogSite.US1.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DatadogSite.US3.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DatadogSite.US5.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DatadogSite.AP1.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[DatadogSite.AP2.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[DatadogSite.UK1.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String getFlagsEndpoint(DatadogSite datadogSite, String customerDomain) {
        Intrinsics.checkNotNullParameter(datadogSite, "<this>");
        Intrinsics.checkNotNullParameter(customerDomain, "customerDomain");
        String strFlagsHost = flagsHost(datadogSite, customerDomain);
        if (strFlagsHost == null) {
            return null;
        }
        return "https://" + strFlagsHost + FLAGS_PATH;
    }

    private static final String flagsHost(DatadogSite datadogSite, String str) {
        switch (WhenMappings.$EnumSwitchMapping$0[datadogSite.ordinal()]) {
            case 1:
            case 2:
                return null;
            case 3:
                return str + ".ff-cdn.datad0g.com";
            case 4:
                return buildFlagsHostString$default(str, null, "eu", 2, null);
            case 5:
                return buildFlagsHostString$default(str, null, null, 6, null);
            case 6:
                return buildFlagsHostString(str, "us3", "com");
            case 7:
                return buildFlagsHostString(str, "us5", "com");
            case 8:
                return buildFlagsHostString(str, "ap1", "com");
            case 9:
                return buildFlagsHostString(str, "ap2", "com");
            case 10:
                return buildFlagsHostString(str, "uk1", "com");
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    static /* synthetic */ String buildFlagsHostString$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = "com";
        }
        return buildFlagsHostString(str, str2, str3);
    }

    private static final String buildFlagsHostString(String str, String str2, String str3) {
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str, "ff-cdn", str2, "datadoghq", str3}), ".", null, null, 0, null, null, 62, null);
    }
}
