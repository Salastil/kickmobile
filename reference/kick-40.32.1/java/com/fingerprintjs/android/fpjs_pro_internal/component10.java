package com.fingerprintjs.android.fpjs_pro_internal;

import android.os.Process;
import com.fingerprintjs.android.fpjs_pro.ApiKeyExpired;
import com.fingerprintjs.android.fpjs_pro.ApiKeyNotFound;
import com.fingerprintjs.android.fpjs_pro.ApiKeyRequired;
import com.fingerprintjs.android.fpjs_pro.Error;
import com.fingerprintjs.android.fpjs_pro.Failed;
import com.fingerprintjs.android.fpjs_pro.HeaderRestricted;
import com.fingerprintjs.android.fpjs_pro.InstallationMethodRestricted;
import com.fingerprintjs.android.fpjs_pro.InvalidProxyIntegrationHeaders;
import com.fingerprintjs.android.fpjs_pro.InvalidProxyIntegrationSecret;
import com.fingerprintjs.android.fpjs_pro.NotAvailableForCrawlBots;
import com.fingerprintjs.android.fpjs_pro.NotAvailableWithoutUA;
import com.fingerprintjs.android.fpjs_pro.OriginNotAvailable;
import com.fingerprintjs.android.fpjs_pro.PackageNotAuthorized;
import com.fingerprintjs.android.fpjs_pro.ProxyIntegrationSecretEnvironmentMismatch;
import com.fingerprintjs.android.fpjs_pro.RequestCannotBeParsed;
import com.fingerprintjs.android.fpjs_pro.RequestTimeout;
import com.fingerprintjs.android.fpjs_pro.SubscriptionNotActive;
import com.fingerprintjs.android.fpjs_pro.TooManyRequest;
import com.fingerprintjs.android.fpjs_pro.UnknownError;
import com.fingerprintjs.android.fpjs_pro.UnsupportedVersion;
import com.fingerprintjs.android.fpjs_pro.WrongRegion;

/* JADX INFO: loaded from: classes6.dex */
public final class component10 implements Y16199 {
    public static int component9;
    public static int vD14832N6715;

    @Override // com.fingerprintjs.android.fpjs_pro_internal.Y16199
    public final Error component5(String str, String str2, String str3) {
        switch (str.hashCode()) {
            case -1990169961:
                if (str.equals("TooManyRequests")) {
                    if (str2 == null) {
                        str2 = "Too many requests, rate limit exceeded";
                    }
                    return new TooManyRequest(str3, str2);
                }
                break;
            case -1303088388:
                if (str.equals("SubscriptionNotActive")) {
                    if (str2 == null) {
                        str2 = "Subscription is not active";
                    }
                    return new SubscriptionNotActive(str3, str2);
                }
                break;
            case -1156046805:
                if (str.equals("ProxyIntegrationSecretEnvironmentMismatch")) {
                    if (str2 == null) {
                        str2 = "Proxy integration secret environment mismatch";
                    }
                    return new ProxyIntegrationSecretEnvironmentMismatch(str3, str2);
                }
                break;
            case -1101868394:
                if (str.equals("InstallationMethodRestricted")) {
                    if (str2 == null) {
                        str2 = "The installation method of the agent is not allowed for the customer";
                    }
                    return new InstallationMethodRestricted(str3, str2);
                }
                break;
            case -681021288:
                if (str.equals("TokenRequired")) {
                    if (str2 == null) {
                        str2 = "API key required";
                    }
                    return new ApiKeyRequired(str3, str2);
                }
                break;
            case -93106615:
                if (str.equals("InvalidProxyIntegrationHeaders")) {
                    if (str2 == null) {
                        str2 = "Invalid proxy integration headers";
                    }
                    return new InvalidProxyIntegrationHeaders(str3, str2);
                }
                break;
            case -20338522:
                if (str.equals("RequestCannotBeParsed")) {
                    if (str2 == null) {
                        str2 = "Request cannot be parsed";
                    }
                    return new RequestCannotBeParsed(str3, str2);
                }
                break;
            case 122916850:
                if (str.equals("RequestTimeout")) {
                    if (str2 == null) {
                        str2 = "Server-side timeout";
                    }
                    return new RequestTimeout(str3, str2);
                }
                break;
            case 362177024:
                if (str.equals("NotAvailableForCrawlBots")) {
                    if (str2 == null) {
                        str2 = "Not available for crawl bots";
                    }
                    return new NotAvailableForCrawlBots(str3, str2);
                }
                break;
            case 624688872:
                if (str.equals("HeaderRestricted")) {
                    if (str2 == null) {
                        str2 = "Not available with restricted header";
                    }
                    return new HeaderRestricted(str3, str2);
                }
                break;
            case 690582241:
                if (str.equals("WrongRegion")) {
                    return new WrongRegion(str3, "Wrong region");
                }
                break;
            case 1162785692:
                if (str.equals("OriginNotAvailable")) {
                    if (str2 == null) {
                        str2 = "Not available for this origin";
                    }
                    return new OriginNotAvailable(str3, str2);
                }
                break;
            case 1265438056:
                if (str.equals("TokenNotFound")) {
                    if (str2 == null) {
                        str2 = "API key not found";
                    }
                    return new ApiKeyNotFound(str3, str2);
                }
                break;
            case 1281821581:
                if (str.equals("InvalidProxyIntegrationSecret")) {
                    if (str2 == null) {
                        str2 = "Invalid proxy integration secret";
                    }
                    return new InvalidProxyIntegrationSecret(str3, str2);
                }
                break;
            case 1560111262:
                if (str.equals("NotAvailableWithoutUA")) {
                    if (str2 == null) {
                        str2 = "Not available when User-Agent is unspecified";
                    }
                    return new NotAvailableWithoutUA(str3, str2);
                }
                break;
            case 1574918403:
                if (str.equals("UnsupportedVersion")) {
                    if (str2 == null) {
                        str2 = "Android agent version not supported";
                    }
                    return new UnsupportedVersion(str3, str2);
                }
                break;
            case 1586242120:
                if (str.equals("PackageNotAuthorized")) {
                    if (str2 == null) {
                        str2 = "Not available for this package";
                    }
                    return new PackageNotAuthorized(str3, str2);
                }
                break;
            case 1729519372:
                if (str.equals("TokenExpired")) {
                    return new ApiKeyExpired(str3, "API key expired");
                }
                break;
            case 2096857181:
                if (str.equals("Failed")) {
                    return new Failed(str3, "Request failed");
                }
                break;
        }
        return new UnknownError(str3, "Unknown error.");
    }

    public static int component5() {
        int i = component9;
        int i2 = i % 6669888;
        component9 = i + 1;
        if (i2 != 0) {
            return vD14832N6715;
        }
        int iMyPid = Process.myPid();
        vD14832N6715 = iMyPid;
        return iMyPid;
    }
}
