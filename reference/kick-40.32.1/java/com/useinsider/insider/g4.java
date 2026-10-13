package com.useinsider.insider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class g4 {
    static void a() {
        a(null);
    }

    static void b(InsiderProduct[] insiderProductArr, Map map) {
        if (insiderProductArr != null) {
            try {
                if (insiderProductArr.length == 0) {
                    return;
                }
                for (InsiderProduct insiderProduct : insiderProductArr) {
                    if (insiderProduct.isProductValid()) {
                        InsiderEvent insiderEventAddParameters = Insider.Instance.tagEvent("wishlist_page_view").addParameters(insiderProduct.getProductSummary());
                        a(insiderEventAddParameters, map);
                        insiderEventAddParameters.build();
                        Debugger.a(DebuggingTag.visitWishlistPage, 4, insiderProduct.getProductSummary());
                    }
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    static void a(Map map) {
        try {
            InsiderEvent insiderEventTagEvent = Insider.Instance.tagEvent("homepage_view");
            a(insiderEventTagEvent, map);
            insiderEventTagEvent.build();
            Debugger.a(DebuggingTag.visitHomepage, 4);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static void a(String[] strArr, Map map) {
        if (strArr != null) {
            try {
                if (strArr.length == 0) {
                    return;
                }
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                concurrentHashMap.put("ta", strArr);
                InsiderEvent insiderEventAddParameters = Insider.Instance.tagEvent("listing_page_view").addParameters(concurrentHashMap);
                a(insiderEventAddParameters, map);
                insiderEventAddParameters.build();
                Debugger.a(DebuggingTag.visitListingPage, 4, concurrentHashMap);
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    static void a(InsiderProduct insiderProduct, Map map) {
        if (insiderProduct != null) {
            try {
                if (insiderProduct.isProductValid()) {
                    InsiderEvent insiderEventAddParameters = Insider.Instance.tagEvent("product_detail_page_view").addParameters(insiderProduct.getProductSummary());
                    a(insiderEventAddParameters, map);
                    insiderEventAddParameters.build();
                    Debugger.putLog(DebuggingTag.visitProductDetailPage, 4, insiderProduct.getProductID());
                    Debugger.a(DebuggingTag.visitProductDetailPageDetail, 4, insiderProduct.getProductSummary());
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    static void a(InsiderProduct[] insiderProductArr, Map map) {
        a(insiderProductArr, null, map);
    }

    static void a(InsiderProduct[] insiderProductArr, String str, Map map) {
        if (insiderProductArr != null) {
            try {
                if (insiderProductArr.length == 0) {
                    return;
                }
                for (InsiderProduct insiderProduct : insiderProductArr) {
                    if (insiderProduct.isProductValid()) {
                        if (str != null && str.length() > 0) {
                            insiderProduct.setSaleID(str);
                        }
                        InsiderEvent insiderEventAddParameters = Insider.Instance.tagEvent("cart_page_view").addParameters(insiderProduct.getProductSummary());
                        a(insiderEventAddParameters, map);
                        insiderEventAddParameters.build();
                        Debugger.a(DebuggingTag.visitCartPage, 4, insiderProduct.getProductSummary());
                    }
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    private static void a(InsiderEvent insiderEvent, Map map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        insiderEvent.addParameters(map);
    }
}
