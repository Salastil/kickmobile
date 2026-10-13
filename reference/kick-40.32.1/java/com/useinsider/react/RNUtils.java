package com.useinsider.react;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.useinsider.insider.AppCardsException;
import com.useinsider.insider.Insider;
import com.useinsider.insider.InsiderEvent;
import com.useinsider.insider.InsiderProduct;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class RNUtils {
    public static WritableMap convertMapToWritableMap(HashMap<String, String> map) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        try {
            for (String str : map.keySet()) {
                writableNativeMap.putString(str, map.get(str));
            }
            return writableNativeMap;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return writableNativeMap;
        }
    }

    public static WritableArray convertJSONArrayToArray(JSONArray jSONArray) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONObject) {
                    writableNativeArray.pushMap(convertJSONObjectToMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableNativeArray.pushArray(convertJSONArrayToArray((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeArray.pushInt(((Integer) obj).intValue());
                } else if (obj instanceof Double) {
                    writableNativeArray.pushDouble(((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    writableNativeArray.pushString((String) obj);
                } else {
                    writableNativeArray.pushString(obj.toString());
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
                return writableNativeArray;
            }
        }
        return writableNativeArray;
    }

    public static WritableMap convertJSONObjectToMap(JSONObject jSONObject) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    writableNativeMap.putMap(next, convertJSONObjectToMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableNativeMap.putArray(next, convertJSONArrayToArray((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    writableNativeMap.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeMap.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Double) {
                    writableNativeMap.putDouble(next, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    writableNativeMap.putString(next, (String) obj);
                } else {
                    writableNativeMap.putString(next, obj.toString());
                }
            }
            return writableNativeMap;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return writableNativeMap;
        }
    }

    public static HashMap<String, Object> convertReadableMapToMap(ReadableMap readableMap) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(strNextKey).ordinal()];
                if (i == 1) {
                    map.put(strNextKey, Boolean.valueOf(readableMap.getBoolean(strNextKey)));
                } else if (i == 2) {
                    map.put(strNextKey, Double.valueOf(readableMap.getDouble(strNextKey)));
                } else if (i == 3) {
                    map.put(strNextKey, readableMap.getString(strNextKey));
                } else if (i == 4) {
                    map.put(strNextKey, convertReadableMapToMap(readableMap.getMap(strNextKey)));
                } else if (i == 5) {
                    ReadableArray array = readableMap.getArray(strNextKey);
                    if (isConvertibleToNumericArray(array)) {
                        map.put(strNextKey, convertReadableArrayToNumericArray(array));
                    } else {
                        map.put(strNextKey, convertReadableArrayToStringArray(array));
                    }
                }
            }
            return map;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return map;
        }
    }

    public static String[] convertReadableArrayToStringArray(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            try {
                if (readableArray.getType(i) == ReadableType.String) {
                    arrayList.add(readableArray.getString(i));
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static Number[] convertReadableArrayToNumericArray(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            try {
                if (readableArray.getType(i) == ReadableType.Number) {
                    arrayList.add(Double.valueOf(readableArray.getDouble(i)));
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
            }
        }
        return (Number[]) arrayList.toArray(new Number[0]);
    }

    public static HashMap<String, Object> fixIntegerAttributesInMap(HashMap<String, Object> map) {
        try {
            if (map.containsKey("stock")) {
                map.put("stock", Integer.valueOf(((Double) map.get("stock")).intValue()));
            }
            if (map.containsKey(FirebaseAnalytics.Param.QUANTITY)) {
                map.put(FirebaseAnalytics.Param.QUANTITY, Integer.valueOf(((Double) map.get(FirebaseAnalytics.Param.QUANTITY)).intValue()));
            }
            return map;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return map;
        }
    }

    private static boolean isConvertibleToNumericArray(ReadableArray readableArray) {
        for (int i = 0; i < readableArray.size(); i++) {
            try {
                if (readableArray.getType(i) != ReadableType.Number) {
                    return false;
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
                return false;
            }
        }
        return true;
    }

    static InsiderEvent parseEvent(String str, ReadableArray readableArray) {
        InsiderEvent insiderEventTagEvent = Insider.Instance.tagEvent(str);
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            if (map != null) {
                String string = map.getString("type");
                String string2 = map.getString("key");
                if (string != null && string2 != null) {
                    string.hashCode();
                    switch (string) {
                        case "numbers":
                            insiderEventTagEvent.addParameterWithNumericArray(string2, convertReadableArrayToNumericArray(map.getArray("value")));
                            break;
                        case "strings":
                            insiderEventTagEvent.addParameterWithStringArray(string2, convertReadableArrayToStringArray(map.getArray("value")));
                            break;
                        case "double":
                            insiderEventTagEvent.addParameterWithDouble(string2, map.getDouble("value"));
                            break;
                        case "string":
                            insiderEventTagEvent.addParameterWithString(string2, map.getString("value"));
                            break;
                        case "date":
                            insiderEventTagEvent.addParameterWithDate(string2, new Date(Long.parseLong(map.getString("value"))));
                            break;
                        case "boolean":
                            insiderEventTagEvent.addParameterWithBoolean(string2, map.getBoolean("value"));
                            break;
                        case "integer":
                            insiderEventTagEvent.addParameterWithInt(string2, map.getInt("value"));
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown parameter type received.");
                    }
                }
            }
        }
        return insiderEventTagEvent;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static InsiderProduct parseProduct(ReadableMap readableMap, ReadableMap readableMap2, ReadableArray readableArray) {
        InsiderProduct insiderProductCreateNewProduct = Insider.Instance.createNewProduct(readableMap.getString(FirebaseAnalytics.Param.PRODUCT_ID), readableMap.getString("name"), convertReadableArrayToStringArray(readableMap.getArray("taxonomy")), readableMap.getString("image_url"), readableMap.getDouble(FirebaseAnalytics.Param.PRICE), readableMap.getString(FirebaseAnalytics.Param.CURRENCY));
        Iterator<Map.Entry<String, Object>> entryIterator = readableMap2.getEntryIterator();
        while (true) {
            byte b = 6;
            if (entryIterator.hasNext()) {
                Map.Entry<String, Object> next = entryIterator.next();
                String key = next.getKey();
                Object value = next.getValue();
                key.hashCode();
                switch (key.hashCode()) {
                    case -1724546052:
                        b = key.equals("description") ? (byte) 0 : (byte) -1;
                        break;
                    case -1491291617:
                        b = key.equals("product_url") ? (byte) 1 : (byte) -1;
                        break;
                    case -1285004149:
                        b = key.equals(FirebaseAnalytics.Param.QUANTITY) ? (byte) 2 : (byte) -1;
                        break;
                    case -1249512767:
                        b = key.equals(HintConstants.AUTOFILL_HINT_GENDER) ? (byte) 3 : (byte) -1;
                        break;
                    case -1206127918:
                        b = key.equals("multipack") ? (byte) 4 : (byte) -1;
                        break;
                    case -1024511651:
                        b = key.equals("promotion_discount") ? (byte) 5 : (byte) -1;
                        break;
                    case -245784196:
                        if (!key.equals("voucher_name")) {
                            b = -1;
                        }
                        break;
                    case -17811588:
                        b = key.equals("in_stock") ? (byte) 7 : (byte) -1;
                        break;
                    case 113949:
                        b = key.equals("sku") ? (byte) 8 : (byte) -1;
                        break;
                    case 3183314:
                        b = key.equals("gtin") ? (byte) 9 : (byte) -1;
                        break;
                    case 3530753:
                        b = key.equals(ContentDisposition.Parameters.Size) ? (byte) 10 : (byte) -1;
                        break;
                    case 3552281:
                        b = key.equals("tags") ? Ascii.VT : (byte) -1;
                        break;
                    case 93997959:
                        b = key.equals("brand") ? Ascii.FF : (byte) -1;
                        break;
                    case 94842723:
                        b = key.equals("color") ? Ascii.CR : (byte) -1;
                        break;
                    case 109770518:
                        b = key.equals("stock") ? Ascii.SO : (byte) -1;
                        break;
                    case 542894014:
                        b = key.equals("shipping_cost") ? Ascii.SI : (byte) -1;
                        break;
                    case 590330802:
                        b = key.equals("voucher_discount") ? Ascii.DLE : (byte) -1;
                        break;
                    case 703898791:
                        b = key.equals(FirebaseAnalytics.Param.PROMOTION_NAME) ? (byte) 17 : (byte) -1;
                        break;
                    case 1014577290:
                        b = key.equals("product_type") ? Ascii.DC2 : (byte) -1;
                        break;
                    case 1161577297:
                        b = key.equals("sale_price") ? (byte) 19 : (byte) -1;
                        break;
                    case 1281992621:
                        b = key.equals("group_code") ? Ascii.DC4 : (byte) -1;
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        insiderProductCreateNewProduct.setDescription((String) value);
                        break;
                    case 1:
                        insiderProductCreateNewProduct.setProductURL((String) value);
                        break;
                    case 2:
                        insiderProductCreateNewProduct.setQuantity(((Double) value).intValue());
                        break;
                    case 3:
                        insiderProductCreateNewProduct.setGender((String) value);
                        break;
                    case 4:
                        insiderProductCreateNewProduct.setMultipack((String) value);
                        break;
                    case 5:
                        insiderProductCreateNewProduct.setPromotionDiscount(((Double) value).doubleValue());
                        break;
                    case 6:
                        insiderProductCreateNewProduct.setVoucherName((String) value);
                        break;
                    case 7:
                        insiderProductCreateNewProduct.setInStock(((Boolean) value).booleanValue());
                        break;
                    case 8:
                        insiderProductCreateNewProduct.setSku((String) value);
                        break;
                    case 9:
                        insiderProductCreateNewProduct.setGtin((String) value);
                        break;
                    case 10:
                        insiderProductCreateNewProduct.setSize((String) value);
                        break;
                    case 11:
                        insiderProductCreateNewProduct.setTags(convertReadableArrayToStringArray((ReadableArray) value));
                        break;
                    case 12:
                        insiderProductCreateNewProduct.setBrand((String) value);
                        break;
                    case 13:
                        insiderProductCreateNewProduct.setColor((String) value);
                        break;
                    case 14:
                        insiderProductCreateNewProduct.setStock(((Double) value).intValue());
                        break;
                    case 15:
                        insiderProductCreateNewProduct.setShippingCost(((Double) value).doubleValue());
                        break;
                    case 16:
                        insiderProductCreateNewProduct.setVoucherDiscount(((Double) value).doubleValue());
                        break;
                    case 17:
                        insiderProductCreateNewProduct.setPromotionName((String) value);
                        break;
                    case 18:
                        insiderProductCreateNewProduct.setProductType((String) value);
                        break;
                    case 19:
                        insiderProductCreateNewProduct.setSalePrice(((Double) value).doubleValue());
                        break;
                    case 20:
                        insiderProductCreateNewProduct.setGroupCode((String) value);
                        break;
                }
            } else {
                for (int i = 0; i < readableArray.size(); i++) {
                    ReadableMap map = readableArray.getMap(i);
                    if (map != null) {
                        String string = map.getString("type");
                        String string2 = map.getString("key");
                        if (string != null && string2 != null) {
                            string.hashCode();
                            switch (string) {
                                case "numbers":
                                    insiderProductCreateNewProduct.setCustomAttributeWithNumericArray(string2, convertReadableArrayToNumericArray(map.getArray("value")));
                                    break;
                                case "strings":
                                    insiderProductCreateNewProduct.setCustomAttributeWithStringArray(string2, convertReadableArrayToStringArray(map.getArray("value")));
                                    break;
                                case "double":
                                    insiderProductCreateNewProduct.setCustomAttributeWithDouble(string2, map.getDouble("value"));
                                    break;
                                case "string":
                                    insiderProductCreateNewProduct.setCustomAttributeWithString(string2, map.getString("value"));
                                    break;
                                case "date":
                                    insiderProductCreateNewProduct.setCustomAttributeWithDate(string2, new Date(Long.parseLong(map.getString("value"))));
                                    break;
                                case "boolean":
                                    insiderProductCreateNewProduct.setCustomAttributeWithBoolean(string2, map.getBoolean("value"));
                                    break;
                                case "integer":
                                    insiderProductCreateNewProduct.setCustomAttributeWithInt(string2, map.getInt("value"));
                                    break;
                                default:
                                    throw new IllegalArgumentException("Unknown parameter type received.");
                            }
                        }
                    }
                }
                return insiderProductCreateNewProduct;
            }
        }
    }

    /* JADX INFO: renamed from: com.useinsider.react.RNUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;
        static final /* synthetic */ int[] $SwitchMap$com$useinsider$insider$AppCardsException$AppCardsExceptionCode;

        static {
            int[] iArr = new int[AppCardsException.AppCardsExceptionCode.values().length];
            $SwitchMap$com$useinsider$insider$AppCardsException$AppCardsExceptionCode = iArr;
            try {
                iArr[AppCardsException.AppCardsExceptionCode.SDK_NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$useinsider$insider$AppCardsException$AppCardsExceptionCode[AppCardsException.AppCardsExceptionCode.INVALID_PARAMETER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$useinsider$insider$AppCardsException$AppCardsExceptionCode[AppCardsException.AppCardsExceptionCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$useinsider$insider$AppCardsException$AppCardsExceptionCode[AppCardsException.AppCardsExceptionCode.SERVER_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$useinsider$insider$AppCardsException$AppCardsExceptionCode[AppCardsException.AppCardsExceptionCode.PARSE_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr2;
            try {
                iArr2[ReadableType.Boolean.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.String.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static String mapAppCardsExceptionCode(AppCardsException appCardsException) {
        int i = AnonymousClass1.$SwitchMap$com$useinsider$insider$AppCardsException$AppCardsExceptionCode[appCardsException.getCode().ordinal()];
        if (i == 1) {
            return "sdkNotInitialized";
        }
        if (i == 2) {
            return "invalidParameter";
        }
        if (i == 3) {
            return "networkError";
        }
        if (i == 4) {
            return "serverError";
        }
        if (i == 5) {
            return "parseError";
        }
        return "unknown";
    }

    public static WritableMap appCardsErrorToMap(AppCardsException appCardsException) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("code", appCardsException != null ? mapAppCardsExceptionCode(appCardsException) : "unknown");
        writableNativeMap.putString("message", (appCardsException == null || appCardsException.getMessage() == null) ? "An unexpected error occurred." : appCardsException.getMessage());
        return writableNativeMap;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Map<String, Object> parseCustomParameters(ReadableArray readableArray) {
        Number[] numberArrConvertReadableArrayToNumericArray;
        String[] strArrConvertReadableArrayToStringArray;
        HashMap map = new HashMap();
        if (readableArray != null) {
            for (int i = 0; i < readableArray.size(); i++) {
                try {
                    ReadableMap map2 = readableArray.getMap(i);
                    if (map2 != null) {
                        String string = map2.hasKey("type") ? map2.getString("type") : null;
                        String string2 = map2.hasKey("key") ? map2.getString("key") : null;
                        if (string != null && string2 != null) {
                            switch (string.hashCode()) {
                                case -2057456985:
                                    if (string.equals("numeric_array") && map2.hasKey("value") && !map2.isNull("value") && (numberArrConvertReadableArrayToNumericArray = convertReadableArrayToNumericArray(map2.getArray("value"))) != null) {
                                        map.put(string2, numberArrConvertReadableArrayToNumericArray);
                                    }
                                    break;
                                case -1325958191:
                                    if (string.equals("double") && map2.hasKey("value") && !map2.isNull("value")) {
                                        map.put(string2, Double.valueOf(map2.getDouble("value")));
                                    }
                                    break;
                                case -891985903:
                                    if (string.equals(TypedValues.Custom.S_STRING) && map2.hasKey("value") && !map2.isNull("value")) {
                                        map.put(string2, map2.getString("value"));
                                    }
                                    break;
                                case 3076014:
                                    if (string.equals("date") && map2.hasKey("value") && !map2.isNull("value")) {
                                        map.put(string2, new Date((long) map2.getDouble("value")));
                                    }
                                    break;
                                case 64711720:
                                    if (string.equals(TypedValues.Custom.S_BOOLEAN) && map2.hasKey("value") && !map2.isNull("value")) {
                                        map.put(string2, Boolean.valueOf(map2.getBoolean("value")));
                                    }
                                    break;
                                case 406856875:
                                    if (string.equals("string_array") && map2.hasKey("value") && !map2.isNull("value") && (strArrConvertReadableArrayToStringArray = convertReadableArrayToStringArray(map2.getArray("value"))) != null) {
                                        map.put(string2, strArrConvertReadableArrayToStringArray);
                                    }
                                    break;
                                case 1958052158:
                                    if (string.equals(TypedValues.Custom.S_INT) && map2.hasKey("value") && !map2.isNull("value")) {
                                        map.put(string2, Integer.valueOf(map2.getInt("value")));
                                    }
                                    break;
                            }
                        }
                    }
                } catch (Exception e) {
                    Insider.Instance.putException(e);
                    return map;
                }
            }
        }
        return map;
    }
}
