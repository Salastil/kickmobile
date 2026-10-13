package com.useinsider.insiderhybrid;

import android.app.Activity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.useinsider.insider.ContentOptimizerDataType;
import com.useinsider.insider.Insider;
import com.useinsider.insider.InsiderEvent;
import com.useinsider.insider.InsiderGender;
import com.useinsider.insider.InsiderProduct;
import com.useinsider.insider.MessageCenterData;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;
import io.ktor.http.ContentDisposition;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: r8-map-id-8a1c41283db52d6403eea27da9125d0c7af3cbca81829c3b5167d2377934d1b7 */
/* JADX INFO: loaded from: classes9.dex */
public class InsiderHybrid {
    private static DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public static InsiderProduct[] convertArrayToInsiderProductArray(ArrayList<Map<String, Object>> arrayList) {
        try {
            InsiderProduct[] insiderProductArr = new InsiderProduct[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                insiderProductArr[i] = createProduct((Map) arrayList.get(i).get(InsiderHybridMethods.PRODUCT_MUST_MAP), (Map) arrayList.get(i).get(InsiderHybridMethods.PRODUCT_OPT_MAP));
            }
            return insiderProductArr;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return new InsiderProduct[0];
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static InsiderProduct createProduct(Map<String, Object> map, Map<String, Object> map2) {
        try {
            if (!isProductValid(map)) {
                return null;
            }
            Object obj = map.get("taxonomy");
            InsiderProduct insiderProductCreateNewProduct = Insider.Instance.createNewProduct((String) map.get(FirebaseAnalytics.Param.PRODUCT_ID), (String) map.get("name"), obj.getClass().isArray() ? (String[]) obj : (String[]) ((ArrayList) obj).toArray(new String[0]), (String) map.get("image_url"), ((Double) map.get("unit_price")).doubleValue(), (String) map.get(FirebaseAnalytics.Param.CURRENCY));
            if (map2 != null && map2.size() != 0) {
                for (Map.Entry<String, Object> entry : InsiderHybridUtils.validateMap(map2).entrySet()) {
                    Object value = entry.getValue();
                    String key = entry.getKey();
                    switch (key.hashCode()) {
                        case -1482535700:
                            if (key.equals("groupcode")) {
                                insiderProductCreateNewProduct.setGroupCode((String) value);
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case -1285004149:
                            if (key.equals(FirebaseAnalytics.Param.QUANTITY)) {
                                insiderProductCreateNewProduct.setQuantity(((Integer) value).intValue());
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case -1024511651:
                            if (key.equals("promotion_discount")) {
                                insiderProductCreateNewProduct.setPromotionDiscount(((Double) value).doubleValue());
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case -245784196:
                            if (key.equals("voucher_name")) {
                                insiderProductCreateNewProduct.setVoucherName((String) value);
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 3294:
                            if (key.equals("ge")) {
                                insiderProductCreateNewProduct.setGender((String) value);
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 3309:
                            if (key.equals("gt")) {
                                insiderProductCreateNewProduct.setGtin((String) value);
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 3588:
                            if (key.equals("pt")) {
                                insiderProductCreateNewProduct.setProductType((String) value);
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 104275:
                            if (key.equals("iis")) {
                                insiderProductCreateNewProduct.setInStock(((Boolean) value).booleanValue());
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 108213:
                            if (key.equals("mlt")) {
                                insiderProductCreateNewProduct.setMultipack((String) value);
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 113949:
                            if (key.equals("sku")) {
                                insiderProductCreateNewProduct.setSku((String) value);
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 3032582:
                            if (key.equals("brnd")) {
                                insiderProductCreateNewProduct.setBrand((String) value);
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 3079825:
                            if (key.equals("desc")) {
                                insiderProductCreateNewProduct.setDescription((String) value);
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 3530753:
                            if (key.equals(ContentDisposition.Parameters.Size)) {
                                insiderProductCreateNewProduct.setSize((String) value);
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 3552281:
                            if (key.equals("tags")) {
                                insiderProductCreateNewProduct.setTags(value.getClass().isArray() ? (String[]) value : (String[]) ((ArrayList) value).toArray(new String[0]));
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 94842723:
                            if (key.equals("color")) {
                                insiderProductCreateNewProduct.setColor((String) value);
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 109770518:
                            if (key.equals("stock")) {
                                insiderProductCreateNewProduct.setStock(((Integer) value).intValue());
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 542894014:
                            if (key.equals("shipping_cost")) {
                                insiderProductCreateNewProduct.setShippingCost(((Double) value).doubleValue());
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 590330802:
                            if (key.equals("voucher_discount")) {
                                insiderProductCreateNewProduct.setVoucherDiscount(((Double) value).doubleValue());
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 703898791:
                            if (key.equals(FirebaseAnalytics.Param.PROMOTION_NAME)) {
                                insiderProductCreateNewProduct.setPromotionName((String) value);
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        case 1161577297:
                            if (key.equals("sale_price")) {
                                insiderProductCreateNewProduct.setSalePrice(((Double) value).doubleValue());
                            } else {
                                setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            }
                            break;
                        default:
                            setProductCustomAttribute(insiderProductCreateNewProduct, entry.getKey(), value);
                            break;
                    }
                }
            }
            return insiderProductCreateNewProduct;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    public static boolean getContentBoolWithName(String str, boolean z, int i) {
        try {
            ContentOptimizerDataType dataType = getDataType(i);
            return dataType == null ? z : Insider.Instance.getContentBoolWithName(str, z, dataType);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return z;
        }
    }

    public static boolean getContentBoolWithoutCache(String str, boolean z, int i) {
        try {
            ContentOptimizerDataType dataType = getDataType(i);
            return dataType == null ? z : Insider.Instance.getContentBoolWithoutCache(str, z, dataType);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return z;
        }
    }

    public static int getContentIntWithName(String str, int i, int i2) {
        try {
            ContentOptimizerDataType dataType = getDataType(i2);
            return dataType == null ? i : Insider.Instance.getContentIntWithName(str, i, dataType);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return i;
        }
    }

    public static int getContentIntWithoutCache(String str, int i, int i2) {
        try {
            ContentOptimizerDataType dataType = getDataType(i2);
            return dataType == null ? i : Insider.Instance.getContentIntWithoutCache(str, i, dataType);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return i;
        }
    }

    public static String getContentStringWithName(String str, String str2, int i) {
        try {
            ContentOptimizerDataType dataType = getDataType(i);
            return dataType == null ? str2 : Insider.Instance.getContentStringWithName(str, str2, dataType);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return str2;
        }
    }

    public static String getContentStringWithoutCache(String str, String str2, int i) {
        try {
            ContentOptimizerDataType dataType = getDataType(i);
            return dataType == null ? str2 : Insider.Instance.getContentStringWithoutCache(str, str2, dataType);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return str2;
        }
    }

    private static ContentOptimizerDataType getDataType(int i) {
        try {
            return ContentOptimizerDataType.values()[i];
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return null;
        }
    }

    private static InsiderGender getGender(int i) {
        if (i != 0) {
            return i != 1 ? InsiderGender.OTHER : InsiderGender.FEMALE;
        }
        return InsiderGender.MALE;
    }

    public static void getMessageCenterData(int i, long j, long j2, MessageCenterData messageCenterData) {
        try {
            Insider.Instance.getMessageCenterData(i, new Date(j), new Date(j2), messageCenterData);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    public static void initWithActivity(Activity activity, String str) {
        try {
            Insider.Instance.init(activity.getApplication(), str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private static boolean isProductValid(Map<String, Object> map) {
        return map.containsKey(FirebaseAnalytics.Param.PRODUCT_ID) && map.containsKey("name") && map.containsKey("taxonomy") && map.containsKey("image_url") && map.containsKey("unit_price") && map.containsKey(FirebaseAnalytics.Param.CURRENCY);
    }

    public static void setBirthday(String str) {
        try {
            Insider.Instance.getCurrentUser().setBirthday(dateFormatter.parse(str));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    public static void setCustomAttributeWithDate(String str, String str2) {
        try {
            Insider.Instance.getCurrentUser().setCustomAttributeWithDate(str, dateFormatter.parse(str2));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    public static void setGender(int i) {
        try {
            Insider.Instance.getCurrentUser().setGender(getGender(i));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void setProductCustomAttribute(InsiderProduct insiderProduct, String str, Object obj) {
        if (str != null) {
            try {
                if (str.length() != 0 && obj != null) {
                    String simpleName = obj.getClass().getSimpleName();
                    switch (simpleName.hashCode()) {
                        case -1821795189:
                            if (simpleName.equals("Number[]")) {
                                insiderProduct.setCustomAttributeWithNumericArray(str, (Number[]) obj);
                            }
                            break;
                        case -1808118735:
                            if (simpleName.equals("String")) {
                                insiderProduct.setCustomAttributeWithString(str, (String) obj);
                            }
                            break;
                        case -672261858:
                            if (simpleName.equals("Integer")) {
                                insiderProduct.setCustomAttributeWithInt(str, ((Integer) obj).intValue());
                            }
                            break;
                        case 2122702:
                            if (simpleName.equals("Date")) {
                                insiderProduct.setCustomAttributeWithDate(str, (Date) obj);
                            }
                            break;
                        case 1729365000:
                            if (simpleName.equals("Boolean")) {
                                insiderProduct.setCustomAttributeWithBoolean(str, ((Boolean) obj).booleanValue());
                            }
                            break;
                        case 1859653459:
                            if (simpleName.equals("String[]")) {
                                insiderProduct.setCustomAttributeWithStringArray(str, (String[]) obj);
                            }
                            break;
                        case 2052876273:
                            if (simpleName.equals("Double")) {
                                insiderProduct.setCustomAttributeWithDouble(str, ((Double) obj).doubleValue());
                            }
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void tagEvent(String str, Map<String, Object> map) {
        try {
            InsiderEvent insiderEventTagEvent = Insider.Instance.tagEvent(str);
            for (Map.Entry<String, Object> entry : InsiderHybridUtils.validateMap(map).entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    String simpleName = value.getClass().getSimpleName();
                    switch (simpleName.hashCode()) {
                        case -1821795189:
                            if (simpleName.equals("Number[]")) {
                                insiderEventTagEvent.addParameterWithNumericArray(key, (Number[]) value);
                            }
                            break;
                        case -1808118735:
                            if (simpleName.equals("String")) {
                                insiderEventTagEvent.addParameterWithString(key, (String) value);
                            }
                            break;
                        case -672261858:
                            if (simpleName.equals("Integer")) {
                                insiderEventTagEvent.addParameterWithInt(key, ((Integer) value).intValue());
                            }
                            break;
                        case 2122702:
                            if (simpleName.equals("Date")) {
                                insiderEventTagEvent.addParameterWithDate(key, (Date) value);
                            }
                            break;
                        case 155139841:
                            if (simpleName.equals("Object[]")) {
                                insiderEventTagEvent.addParameters(UByte$$ExternalSyntheticBackport0.m(new Map.Entry[]{new AbstractMap.SimpleEntry(key, value)}));
                            }
                            break;
                        case 1729365000:
                            if (simpleName.equals("Boolean")) {
                                insiderEventTagEvent.addParameterWithBoolean(key, ((Boolean) value).booleanValue());
                            }
                            break;
                        case 1859653459:
                            if (simpleName.equals("String[]")) {
                                insiderEventTagEvent.addParameterWithStringArray(key, (String[]) value);
                            }
                            break;
                        case 2052876273:
                            if (simpleName.equals("Double")) {
                                insiderEventTagEvent.addParameterWithDouble(key, ((Double) value).doubleValue());
                            }
                            break;
                    }
                }
            }
            insiderEventTagEvent.build();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    public static void visitCartPage(ArrayList<Map<String, Object>> arrayList) {
        try {
            InsiderProduct[] insiderProductArr = new InsiderProduct[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                insiderProductArr[i] = createProduct((Map) arrayList.get(i).get(InsiderHybridMethods.PRODUCT_MUST_MAP), (Map) arrayList.get(i).get(InsiderHybridMethods.PRODUCT_OPT_MAP));
            }
            Insider.Instance.visitCartPage(insiderProductArr);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
