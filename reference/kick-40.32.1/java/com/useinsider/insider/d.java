package com.useinsider.insider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class d {
    static void a(g3 g3Var, InsiderProduct insiderProduct, n3 n3Var, Map map) {
        if (insiderProduct != null) {
            try {
                if (insiderProduct.isProductValid()) {
                    g3Var.b(insiderProduct);
                    InsiderEvent insiderEventAddParameters = Insider.Instance.tagEvent("item_added_to_cart").addParameters(insiderProduct.getProductSummary());
                    a(insiderEventAddParameters, map);
                    insiderEventAddParameters.build();
                    n3Var.c(insiderProduct);
                    Debugger.a(DebuggingTag.itemAddedToCart, 4, insiderProduct.getProductSummary());
                    f3.b("cart_reminder", "Item added to cart.", "{ 'product_id': '" + insiderProduct.getProductID() + "' }", "CartReminder-itemAddedToCart");
                    return;
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
                return;
            }
        }
        StringBuilder sb = new StringBuilder("{ 'is_null_product': '");
        boolean z = true;
        sb.append(String.valueOf(insiderProduct == null));
        sb.append("', 'is_invalid_product': '");
        if (insiderProduct == null || !insiderProduct.isProductValid()) {
            z = false;
        }
        sb.append(String.valueOf(z));
        sb.append("'  }");
        f3.b("cart_reminder", "Item could not be added to the cart.", sb.toString(), "CartReminder-itemAddedToCart");
    }

    static void a(g3 g3Var, String str, Map map) {
        a(g3Var, str, (String) null, map);
    }

    static void a(g3 g3Var, String str, String str2, Map map) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    g3Var.e(str);
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put("pid", str);
                    if (str2 != null && str2.length() > 0) {
                        concurrentHashMap.put("e_guid", str2);
                    }
                    InsiderEvent insiderEventAddParameters = Insider.Instance.tagEvent("item_removed_from_cart").addParameters(concurrentHashMap);
                    a(insiderEventAddParameters, map);
                    insiderEventAddParameters.build();
                    Debugger.putLog(DebuggingTag.itemRemovedFromCart, 4, str);
                    f3.b("cart_reminder", "Item removed from the cart.", "{ 'product_id': '" + str + "' }", "CartReminder-itemRemovedFromCart");
                    return;
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
                return;
            }
        }
        f3.b("cart_reminder", "Item could not be removed from the cart.", "{ 'product_id': '" + str + "'  }", "CartReminder-itemRemovedFromCart");
    }

    static void a(g3 g3Var, Map map) {
        try {
            g3Var.b();
            InsiderEvent insiderEventTagEvent = Insider.Instance.tagEvent("cart_cleared");
            a(insiderEventTagEvent, map);
            insiderEventTagEvent.build();
            Debugger.a(DebuggingTag.cartCleared, 4);
            f3.b("cart_reminder", "Cart cleared.", "{}", "CartReminder-cartCleared");
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private static void a(InsiderEvent insiderEvent, Map map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        insiderEvent.addParameters(map);
    }
}
