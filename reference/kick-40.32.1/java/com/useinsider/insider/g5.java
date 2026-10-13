package com.useinsider.insider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class g5 {
    static void a(g3 g3Var, InsiderProduct insiderProduct, n3 n3Var, Map map) {
        try {
            if (a(insiderProduct, "Wishlist-itemAddedToWishlist", "Item could not be added to the Wishlist.")) {
                InsiderEvent insiderEventAddParameters = Insider.Instance.tagEvent("item_added_to_wishlist").addParameters(insiderProduct.getProductSummary());
                a(insiderEventAddParameters, map);
                insiderEventAddParameters.build();
                Debugger.a(DebuggingTag.itemAddedToWishlist, 4, insiderProduct.getProductSummary());
                f3.b("wishlist", "Item added to wishlist.", "{ 'product_id': '" + insiderProduct.getProductID() + "' }", "Wishlist-itemAddedToWishlist");
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static void a(g3 g3Var, String str, Map map) {
        try {
            if (a(str, "Wishlist-itemRemovedFromWishlist", "Item could not be removed from the wishlist.")) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                concurrentHashMap.put("pid", str);
                InsiderEvent insiderEventAddParameters = Insider.Instance.tagEvent("item_removed_from_wishlist").addParameters(concurrentHashMap);
                a(insiderEventAddParameters, map);
                insiderEventAddParameters.build();
                Debugger.putLog(DebuggingTag.itemRemovedFromWishlist, 4, str);
                f3.b("wishlist", "Item removed from the wishlist.", "{ 'product_id': '" + str + "' }", "Wishlist-itemRemovedFromWishlist");
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    static void a(g3 g3Var, Map map) {
        try {
            InsiderEvent insiderEventTagEvent = Insider.Instance.tagEvent("wishlist_cleared");
            a(insiderEventTagEvent, map);
            insiderEventTagEvent.build();
            Debugger.a(DebuggingTag.wishlistCleared, 4);
            f3.b("wishlist", "Wishlist cleared.", "{}", "Wishlist-wishlistCleared");
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

    private static boolean a(InsiderProduct insiderProduct, String str, String str2) {
        boolean z = true;
        if (insiderProduct != null && insiderProduct.isProductValid()) {
            return true;
        }
        try {
            StringBuilder sb = new StringBuilder("{ 'is_null_product': '");
            sb.append(insiderProduct == null);
            sb.append("', 'is_invalid_product': '");
            if (insiderProduct == null || !insiderProduct.isProductValid()) {
                z = false;
            }
            sb.append(z);
            sb.append("'  }");
            f3.b("wishlist", str2, sb.toString(), str);
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean a(String str, String str2, String str3) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        try {
            f3.b("wishlist", str3, "{ 'product_id': '" + str + "'  }", str2);
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
