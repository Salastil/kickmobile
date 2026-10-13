package com.useinsider.insider;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap f401a = new ConcurrentHashMap();
    private final ArrayList b = new ArrayList();

    n3() {
    }

    private void b(int i, String str, InsiderProduct insiderProduct, String str2) {
        try {
            ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put("recommendation_id", Integer.valueOf(i));
            concurrentHashMap.put("action", str);
            if (insiderProduct != null) {
                concurrentHashMap.put("product", insiderProduct.getProductSummary());
                concurrentHashMap.put(FirebaseAnalytics.Param.PRODUCT_ID, insiderProduct.getProductID());
                concurrentHashMap.put("name", insiderProduct.getName());
                concurrentHashMap.put(FirebaseAnalytics.Param.PRICE, Double.valueOf(insiderProduct.getUnitPrice()));
                concurrentHashMap.put("taxonomy", insiderProduct.getTaxonomyString());
                concurrentHashMap.put(FirebaseAnalytics.Param.CURRENCY, insiderProduct.getCurrency());
                concurrentHashMap.put("image_url", insiderProduct.getImageURL());
                if (insiderProduct.getGroupCode() != null) {
                    concurrentHashMap.put("groupcode", insiderProduct.getGroupCode());
                }
            }
            a(i, str, insiderProduct, str2);
            Insider.Instance.putRecommendationLog(concurrentHashMap);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a(int i, String str) {
        try {
            b(i, "view", null, str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void c(InsiderProduct insiderProduct) {
        try {
            if (b(insiderProduct)) {
                Iterator it = a(insiderProduct).iterator();
                while (it.hasNext()) {
                    b(((Integer) it.next()).intValue(), FirebaseAnalytics.Event.ADD_TO_CART, insiderProduct, null);
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void d(InsiderProduct insiderProduct) {
        try {
            if (b(insiderProduct)) {
                Iterator it = a(insiderProduct).iterator();
                while (it.hasNext()) {
                    b(((Integer) it.next()).intValue(), FirebaseAnalytics.Event.PURCHASE, insiderProduct, null);
                }
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a(int i) {
        try {
            if (this.b.contains(Integer.valueOf(i))) {
                return;
            }
            this.b.add(Integer.valueOf(i));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    void a(int i, InsiderProduct insiderProduct) {
        try {
            if (this.b.contains(Integer.valueOf(i))) {
                a(insiderProduct, i);
                b(i, "click", insiderProduct, null);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private void a(InsiderProduct insiderProduct, int i) {
        try {
            String productID = insiderProduct.getProductID();
            Set setA = a(insiderProduct);
            if (setA == null) {
                setA = new HashSet();
            }
            setA.add(Integer.valueOf(i));
            this.f401a.put(productID, setA);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private boolean b(InsiderProduct insiderProduct) {
        try {
            return this.f401a.containsKey(insiderProduct.getProductID());
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return false;
        }
    }

    private Set a(InsiderProduct insiderProduct) {
        try {
            return (Set) this.f401a.get(insiderProduct.getProductID());
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    private void a(int i, String str, InsiderProduct insiderProduct, String str2) {
        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("recommendation_id", Integer.valueOf(i));
            concurrentHashMap.put("action", str);
            InsiderEvent insiderEventTagEvent = Insider.Instance.tagEvent("mobile_recommendation_log");
            insiderEventTagEvent.addParameters(concurrentHashMap);
            if (insiderProduct != null) {
                insiderEventTagEvent.addParameters(insiderProduct.getProductSummary());
            }
            if (str2 != null) {
                insiderEventTagEvent.addParameterWithString("request_url", str2);
            }
            insiderEventTagEvent.build();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
