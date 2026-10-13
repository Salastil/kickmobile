package com.datadog.trace.core.taginterceptor;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.trace.internal.ApmNetworkInstrumentation;
import com.datadog.trace.api.Config;
import com.datadog.trace.api.ConfigDefaults;
import com.datadog.trace.api.DDTags;
import com.datadog.trace.api.Pair;
import com.datadog.trace.api.env.CapturedEnvironment;
import com.datadog.trace.api.normalize.HttpResourceNames;
import com.datadog.trace.bootstrap.instrumentation.api.InstrumentationTags;
import com.datadog.trace.bootstrap.instrumentation.api.Tags;
import com.datadog.trace.bootstrap.instrumentation.api.URIUtils;
import com.datadog.trace.bootstrap.instrumentation.api.UTF8BytesString;
import com.datadog.trace.core.DDSpanContext;
import com.google.common.base.Ascii;
import java.net.URI;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class TagInterceptor {
    private static final UTF8BytesString NOT_FOUND_RESOURCE_NAME = UTF8BytesString.create(ApmNetworkInstrumentation.RESOURCE_NAME_404);
    private final String inferredServiceName;
    private final boolean isServiceNameSetByUser;
    private final RuleFlags ruleFlags;
    private final boolean shouldSet404ResourceName;
    private final boolean shouldSetUrlResourceAsName;
    private final boolean splitByServletContext;
    private final Set<String> splitServiceTags;

    public TagInterceptor(RuleFlags ruleFlags) {
        this(Config.get().isServiceNameSetByUser(), CapturedEnvironment.get().getProperties().get("service.name"), Config.get().getSplitByTags(), ruleFlags);
    }

    public TagInterceptor(boolean z, String str, Set<String> set, RuleFlags ruleFlags) {
        this.isServiceNameSetByUser = z;
        this.inferredServiceName = str;
        this.splitServiceTags = set;
        this.ruleFlags = ruleFlags;
        this.splitByServletContext = set.contains(InstrumentationTags.SERVLET_CONTEXT);
        this.shouldSet404ResourceName = ruleFlags.isEnabled(RuleFlags.Feature.URL_AS_RESOURCE_NAME) && ruleFlags.isEnabled(RuleFlags.Feature.STATUS_404) && ruleFlags.isEnabled(RuleFlags.Feature.STATUS_404_DECORATOR);
        this.shouldSetUrlResourceAsName = ruleFlags.isEnabled(RuleFlags.Feature.URL_AS_RESOURCE_NAME);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public boolean interceptTag(DDSpanContext dDSpanContext, String str, Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1600255323:
                if (str.equals("_dd1.sr.eausr")) {
                    b = 0;
                }
                break;
            case -1541421527:
                if (str.equals(Tags.PEER_SERVICE)) {
                    b = 1;
                }
                break;
            case -688795810:
                if (str.equals(DDTags.SPAN_TYPE)) {
                    b = 2;
                }
                break;
            case -620406091:
                if (str.equals(DDTags.MEASURED)) {
                    b = 3;
                }
                break;
            case -356226025:
                if (str.equals(DDTags.MANUAL_DROP)) {
                    b = 4;
                }
                break;
            case -356030291:
                if (str.equals(DDTags.MANUAL_KEEP)) {
                    b = 5;
                }
                break;
            case -134204663:
                if (str.equals("http.url")) {
                    b = 6;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    b = 7;
                }
                break;
            case 282739975:
                if (str.equals("http.method")) {
                    b = 8;
                }
                break;
            case 314627620:
                if (str.equals("service.name")) {
                    b = 9;
                }
                break;
            case 934168683:
                if (str.equals("resource.name")) {
                    b = 10;
                }
                break;
            case 960885172:
                if (str.equals("http.status_code")) {
                    b = Ascii.VT;
                }
                break;
            case 1775928319:
                if (str.equals("db.statement")) {
                    b = Ascii.FF;
                }
                break;
            case 1798451925:
                if (str.equals(DDTags.ORIGIN_KEY)) {
                    b = Ascii.CR;
                }
                break;
            case 1984153269:
                if (str.equals("service")) {
                    b = Ascii.SO;
                }
                break;
            case 2146501382:
                if (str.equals(InstrumentationTags.SERVLET_CONTEXT)) {
                    b = Ascii.SI;
                }
                break;
        }
        switch (b) {
            case 0:
                return interceptAnalyticsSampleRate(dDSpanContext, obj);
            case 1:
                dDSpanContext.setTag(DDTags.PEER_SERVICE_SOURCE, Tags.PEER_SERVICE);
                return interceptServiceName(RuleFlags.Feature.PEER_SERVICE, dDSpanContext, obj);
            case 2:
                return interceptSpanType(dDSpanContext, obj);
            case 3:
                return interceptMeasured(dDSpanContext, obj);
            case 4:
                return interceptSamplingPriority(RuleFlags.Feature.FORCE_MANUAL_DROP, -1, 4, dDSpanContext, obj);
            case 5:
                if (!asBoolean(obj)) {
                    return false;
                }
                dDSpanContext.forceKeep();
                return true;
            case 6:
            case 8:
                return interceptUrlResourceAsNameRule(dDSpanContext, str, obj);
            case 7:
                return interceptError(dDSpanContext, obj);
            case 9:
            case 14:
                return interceptServiceName(RuleFlags.Feature.SERVICE_NAME, dDSpanContext, obj);
            case 10:
                return interceptResourceName(dDSpanContext, obj);
            case 11:
                return interceptHttpStatusCode(dDSpanContext, obj);
            case 12:
                return interceptDbStatement(dDSpanContext, obj);
            case 13:
                return interceptOrigin(dDSpanContext, obj);
            case 15:
                return interceptServletContext(dDSpanContext, obj);
            default:
                return intercept(dDSpanContext, str, obj);
        }
    }

    private boolean interceptUrlResourceAsNameRule(DDSpanContext dDSpanContext, String str, Object obj) {
        if (!this.shouldSetUrlResourceAsName) {
            return false;
        }
        if ("http.method".equals(str)) {
            Object objUnsafeGetTag = dDSpanContext.unsafeGetTag("http.url");
            if (objUnsafeGetTag == null) {
                return false;
            }
            setResourceFromUrl(dDSpanContext, obj.toString(), objUnsafeGetTag);
            return false;
        }
        if (!"http.url".equals(str)) {
            return false;
        }
        Object objUnsafeGetTag2 = dDSpanContext.unsafeGetTag("http.method");
        setResourceFromUrl(dDSpanContext, objUnsafeGetTag2 != null ? objUnsafeGetTag2.toString() : null, obj);
        return false;
    }

    private static void setResourceFromUrl(DDSpanContext dDSpanContext, String str, Object obj) {
        String path;
        Pair<CharSequence, Byte> pairComputeForServer;
        if (obj instanceof URIUtils.LazyUrl) {
            path = ((URIUtils.LazyUrl) obj).path();
        } else {
            URI uriSafeParse = URIUtils.safeParse(obj.toString());
            path = uriSafeParse == null ? null : uriSafeParse.getPath();
        }
        if (path != null) {
            if ("client".equals(dDSpanContext.unsafeGetTag("span.kind"))) {
                pairComputeForServer = HttpResourceNames.computeForClient(str, path, false);
            } else {
                pairComputeForServer = HttpResourceNames.computeForServer(str, path, false);
            }
            if (pairComputeForServer.hasLeft()) {
                dDSpanContext.setResourceName(pairComputeForServer.getLeft(), pairComputeForServer.getRight().byteValue());
                return;
            }
            return;
        }
        dDSpanContext.setResourceName(HttpResourceNames.DEFAULT_RESOURCE_NAME, (byte) 1);
    }

    private boolean intercept(DDSpanContext dDSpanContext, String str, Object obj) {
        if (!this.splitServiceTags.contains(str)) {
            return false;
        }
        dDSpanContext.setServiceName(String.valueOf(obj));
        return true;
    }

    private boolean interceptResourceName(DDSpanContext dDSpanContext, Object obj) {
        if (!this.ruleFlags.isEnabled(RuleFlags.Feature.RESOURCE_NAME) || obj == null) {
            return false;
        }
        if (obj instanceof CharSequence) {
            dDSpanContext.setResourceName((CharSequence) obj, (byte) 5);
            return true;
        }
        dDSpanContext.setResourceName(String.valueOf(obj), (byte) 5);
        return true;
    }

    private boolean interceptDbStatement(DDSpanContext dDSpanContext, Object obj) {
        if (!(obj instanceof CharSequence)) {
            return true;
        }
        CharSequence charSequence = (CharSequence) obj;
        if (charSequence.length() <= 0) {
            return true;
        }
        dDSpanContext.setResourceName(charSequence, (byte) 5);
        return true;
    }

    private boolean interceptError(DDSpanContext dDSpanContext, Object obj) {
        dDSpanContext.setErrorFlag(asBoolean(obj), (byte) 0);
        return true;
    }

    private boolean interceptAnalyticsSampleRate(DDSpanContext dDSpanContext, Object obj) {
        Number orTryParse = getOrTryParse(obj);
        if (orTryParse == null) {
            return true;
        }
        dDSpanContext.setMetric("_dd1.sr.eausr", orTryParse);
        return true;
    }

    private boolean interceptSpanType(DDSpanContext dDSpanContext, Object obj) {
        if (obj instanceof CharSequence) {
            dDSpanContext.setSpanType((CharSequence) obj);
            return true;
        }
        dDSpanContext.setSpanType(String.valueOf(obj));
        return true;
    }

    private boolean interceptServiceName(RuleFlags.Feature feature, DDSpanContext dDSpanContext, Object obj) {
        if (!this.ruleFlags.isEnabled(feature)) {
            return false;
        }
        dDSpanContext.setServiceName(String.valueOf(obj));
        return true;
    }

    private boolean interceptSamplingPriority(RuleFlags.Feature feature, int i, int i2, DDSpanContext dDSpanContext, Object obj) {
        if (!this.ruleFlags.isEnabled(feature)) {
            return false;
        }
        if (!asBoolean(obj)) {
            return true;
        }
        dDSpanContext.setSamplingPriority(i, i2);
        return true;
    }

    private boolean interceptServletContext(DDSpanContext dDSpanContext, Object obj) {
        if (!this.splitByServletContext && (this.isServiceNameSetByUser || !this.ruleFlags.isEnabled(RuleFlags.Feature.SERVLET_CONTEXT) || (!dDSpanContext.getServiceName().isEmpty() && !dDSpanContext.getServiceName().equals(this.inferredServiceName) && !dDSpanContext.getServiceName().equals(ConfigDefaults.DEFAULT_SERVICE_NAME)))) {
            return false;
        }
        String strTrim = String.valueOf(obj).trim();
        if (!strTrim.isEmpty()) {
            if (strTrim.equals(DomExceptionUtils.SEPARATOR)) {
                dDSpanContext.setServiceName(Config.get().getRootContextServiceName());
            } else if (strTrim.charAt(0) == '/') {
                if (strTrim.length() > 1) {
                    dDSpanContext.setServiceName(strTrim.substring(1));
                }
            } else {
                dDSpanContext.setServiceName(strTrim);
            }
        }
        return false;
    }

    private boolean interceptHttpStatusCode(DDSpanContext dDSpanContext, Object obj) {
        if (obj instanceof Number) {
            dDSpanContext.setHttpStatusCode(((Number) obj).shortValue());
            if (this.shouldSet404ResourceName && dDSpanContext.getHttpStatusCode() == 404) {
                dDSpanContext.setResourceName(NOT_FOUND_RESOURCE_NAME, (byte) 2);
            }
            return true;
        }
        try {
            dDSpanContext.setHttpStatusCode(Short.parseShort(String.valueOf(obj)));
            if (this.shouldSet404ResourceName && dDSpanContext.getHttpStatusCode() == 404) {
                dDSpanContext.setResourceName(NOT_FOUND_RESOURCE_NAME, (byte) 2);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean interceptOrigin(DDSpanContext dDSpanContext, Object obj) {
        if (obj instanceof CharSequence) {
            dDSpanContext.setOrigin((CharSequence) obj);
            return true;
        }
        dDSpanContext.setOrigin(String.valueOf(obj));
        return true;
    }

    private static boolean interceptMeasured(DDSpanContext dDSpanContext, Object obj) {
        if ((!(obj instanceof Number) || ((Number) obj).intValue() <= 0) && !asBoolean(obj)) {
            return false;
        }
        dDSpanContext.setMeasured(true);
        return true;
    }

    private static boolean asBoolean(Object obj) {
        if (Boolean.TRUE.equals(obj) || "1".equals(obj)) {
            return true;
        }
        return !Boolean.FALSE.equals(obj) && Boolean.parseBoolean(String.valueOf(obj));
    }

    private static Number getOrTryParse(Object obj) {
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
