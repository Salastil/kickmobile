package com.useinsider.insider;

import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import androidx.autofill.HintConstants;
import com.datadog.android.rum.internal.instrumentation.gestures.GesturesListener;
import com.facebook.hermes.intl.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class RecommendationEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SparseArray f306a = new SparseArray();
    private static final ExecutorService b = Executors.newFixedThreadPool(3);
    private static final Map c;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    public interface SmartRecommendation {
        void loadRecommendationData(JSONObject jSONObject);
    }

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f307a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ InsiderProduct d;
        final /* synthetic */ SmartRecommendation e;
        final /* synthetic */ Context f;
        final /* synthetic */ n3 g;

        a(int i, String str, String str2, InsiderProduct insiderProduct, SmartRecommendation smartRecommendation, Context context, n3 n3Var) {
            this.f307a = i;
            this.b = str;
            this.c = str2;
            this.d = insiderProduct;
            this.e = smartRecommendation;
            this.f = context;
            this.g = n3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                String strA = RecommendationEngine.a(this.f307a, this.b, this.c, this.d, RecommendationEngine.b());
                String str = "{ 'recommendationID': '" + this.f307a + "', 'url': '" + strA + "' }";
                Debugger.putLog(DebuggingTag.getSmartRecommendationRequestURL, 4, strA);
                f3.b("smart_recommender", "Get smart recommender triggered.", str, "RecommendationEngine-getSmartRecommendation");
                if (strA.length() == 0) {
                    this.e.loadRecommendationData(jSONObject);
                    return;
                }
                String strA2 = w4.a(strA, (JSONObject) null, this.f, false, l4.RECOMMENDATION).a();
                if (strA2 == null || strA2.length() <= 0) {
                    f3.b("smart_recommender", "Recommendations data is empty.", str, "RecommendationEngine-getSmartRecommendation");
                } else {
                    jSONObject = new JSONObject(strA2);
                    f3.b("smart_recommender", "Recommendations received.", str, "RecommendationEngine-getSmartRecommendation");
                }
                this.g.a(this.f307a, strA);
                if (RecommendationEngine.b(jSONObject)) {
                    this.g.a(this.f307a);
                }
                this.e.loadRecommendationData(jSONObject);
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    static {
        HashMap map = new HashMap();
        c = map;
        map.put("productID", "pid");
        map.put(FirebaseAnalytics.Param.ITEM_ID, "pid");
        map.put("name", "na");
        map.put("image_url", "piu");
        map.put(FirebaseAnalytics.Param.PRICE, "usp");
        map.put("original_price", GesturesListener.SCROLL_DIRECTION_UP);
        map.put("in_stock", "iis");
        map.put("group_code", "groupcode");
        map.put("brand", "brnd");
        map.put("color", Constants.COLLATION_EXTENSION_KEY_SHORT);
        map.put(ContentDisposition.Parameters.Size, "si");
        map.put("sku", "sku");
        map.put(HintConstants.AUTOFILL_HINT_GENDER, "ge");
        map.put("multipack", "mlt");
        map.put("product_type", "pt");
        map.put("gtin", "gt");
        map.put(FirebaseAnalytics.Param.CURRENCY, "cu");
        map.put("description", "desc");
        map.put("tags", "tags");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(JSONObject jSONObject) {
        try {
            return jSONObject.length() > 0 && jSONObject.has("data") && jSONObject.getJSONArray("data").length() > 0;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return false;
        }
    }

    static void c(JSONObject jSONObject) {
        try {
            Iterator<String> itKeys = jSONObject.keys();
            f306a.clear();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                f306a.put(Integer.valueOf(next).intValue(), jSONObject.getString(next));
            }
            f3.b("smart_recommender", "Recommender urls received.", jSONObject, "RecommendationEngine-storeEndpoints");
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static void a(Context context, int i, String str, String str2, InsiderProduct insiderProduct, n3 n3Var, SmartRecommendation smartRecommendation) {
        b.execute(new a(i, str, str2, insiderProduct, smartRecommendation, context, n3Var));
    }

    private static String a(String str, String str2, String str3) {
        try {
            return str.replace(str2, Uri.encode(str3));
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SparseArray b() {
        String smartRecommendationEndpointsFromCache;
        try {
            if (f306a.size() == 0 && (smartRecommendationEndpointsFromCache = Insider.Instance.getSmartRecommendationEndpointsFromCache()) != null) {
                c(new JSONObject(smartRecommendationEndpointsFromCache));
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
        return f306a;
    }

    static String a(int i, String str, String str2, InsiderProduct insiderProduct, SparseArray sparseArray) {
        String strA = "";
        try {
            String strA2 = a(a(a((String) sparseArray.get(i, ""), "{language}", str), "{currency}", str2), "{locale}", str);
            if (insiderProduct == null) {
                return strA2;
            }
            strA = a(a(strA2, insiderProduct.getTaxonomy()), "{category}", w4.b(insiderProduct.getTaxonomy()));
            return a(strA, insiderProduct);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return strA;
        }
    }

    private static String a(String str, InsiderProduct insiderProduct) {
        Object obj;
        String strEncode;
        if (str != null && insiderProduct != null) {
            try {
                if (insiderProduct.getProductSummary() != null) {
                    Matcher matcher = Pattern.compile("\\{([^}]+)\\}").matcher(str);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (matcher.find()) {
                        String strGroup = matcher.group(1);
                        String str2 = (String) c.get(strGroup);
                        if (str2 != null && (obj = insiderProduct.getProductSummary().get(str2)) != null) {
                            if (strGroup.equals("in_stock") && (obj instanceof Boolean)) {
                                strEncode = ((Boolean) obj).booleanValue() ? "1" : "0";
                            } else {
                                strEncode = Uri.encode(String.valueOf(obj));
                            }
                            matcher.appendReplacement(stringBuffer, strEncode);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    return stringBuffer.toString();
                }
            } catch (Exception unused) {
                f3.a("smart_recommender", "Error while replacing placeholders", "{}", "RecommendationEngine-replacePlaceholders");
                return str;
            }
        }
        f3.a("smart_recommender", "Invalid URL or Product.", "{}", "RecommendationEngine-replacePlaceholders");
        return str;
    }

    private static String a(String str, String[] strArr) {
        try {
            Matcher matcher = Pattern.compile("\\[category\\]\\[.{1,3}\\]\\[\\{category\\}\\]").matcher(str);
            while (matcher.find()) {
                StringBuilder sb = new StringBuilder();
                String strGroup = matcher.group();
                for (int i = 0; i < strArr.length; i++) {
                    sb.append(strGroup.replace("{category}", strArr[i]));
                    if (i != strArr.length - 1) {
                        sb.append("*");
                    }
                }
                str = a(str, strGroup, sb.toString());
            }
            return str;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return str;
        }
    }
}
