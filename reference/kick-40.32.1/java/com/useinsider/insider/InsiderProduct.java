package com.useinsider.insider;

import com.datadog.android.rum.internal.instrumentation.gestures.GesturesListener;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.internal.ImagesContract;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public class InsiderProduct {
    private boolean isProductValid;
    private Map<String, Object> summary;

    InsiderProduct(String str, String str2, String[] strArr, String str3, double d, String str4, boolean z) {
        try {
            this.isProductValid = z;
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            this.summary = concurrentHashMap;
            concurrentHashMap.put("pid", str);
            this.summary.put("na", str2);
            this.summary.put("ta", strArr.clone());
            this.summary.put("piu", str3);
            this.summary.put("cu", str4);
            this.summary.put(GesturesListener.SCROLL_DIRECTION_UP, Double.valueOf(d));
            this.summary.put("qu", 1);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    public String getCurrency() {
        return String.valueOf(this.summary.get("cu"));
    }

    @Deprecated
    public String[] getCustomAttributeArray(String str) {
        return (String[]) this.summary.get(str);
    }

    public boolean getCustomAttributeBoolean(String str) {
        return ((Boolean) this.summary.get(str)).booleanValue();
    }

    public Date getCustomAttributeDate(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(String.valueOf(this.summary.get(str)));
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return new Date();
        }
    }

    public double getCustomAttributeDouble(String str) {
        return ((Double) this.summary.get(str)).doubleValue();
    }

    public int getCustomAttributeInt(String str) {
        return ((Integer) this.summary.get(str)).intValue();
    }

    public Number[] getCustomAttributeNumericArray(String str) {
        return (Number[]) this.summary.get(str);
    }

    public String getCustomAttributeString(String str) {
        return String.valueOf(this.summary.get(str));
    }

    public String[] getCustomAttributeStringArray(String str) {
        return (String[]) this.summary.get(str);
    }

    public String getGroupCode() {
        String strValueOf = String.valueOf(this.summary.get("groupcode"));
        if (strValueOf.equals("") || strValueOf.equals(AbstractJsonLexerKt.NULL)) {
            return null;
        }
        return String.valueOf(this.summary.get("groupcode"));
    }

    public String getImageURL() {
        return String.valueOf(this.summary.get("piu"));
    }

    public String getName() {
        return String.valueOf(this.summary.get("na"));
    }

    public String getProductID() {
        return String.valueOf(this.summary.get("pid"));
    }

    public Map<String, Object> getProductSummary() {
        return this.summary;
    }

    public int getQuantity() {
        return ((Integer) this.summary.get("qu")).intValue();
    }

    String getSaleID() {
        return (String) this.summary.get("e_guid");
    }

    public String[] getTags() {
        return (String[]) this.summary.get("tags");
    }

    public String[] getTaxonomy() {
        return (String[]) this.summary.get("ta");
    }

    String getTaxonomyString() {
        return Arrays.toString((String[]) this.summary.get("ta"));
    }

    public double getUnitPrice() {
        return ((Double) this.summary.get(GesturesListener.SCROLL_DIRECTION_UP)).doubleValue();
    }

    boolean isProductValid() {
        return this.isProductValid;
    }

    public InsiderProduct setBrand(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("brnd", str);
        }
        return this;
    }

    public InsiderProduct setColor(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put(Constants.COLLATION_EXTENSION_KEY_SHORT, str);
        }
        return this;
    }

    public InsiderProduct setCurrency(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("cu", str);
        }
        return this;
    }

    @Deprecated
    public InsiderProduct setCustomAttributeWithArray(String str, String[] strArr) {
        return setCustomAttributeWithStringArray(str, strArr);
    }

    public InsiderProduct setCustomAttributeWithBoolean(String str, boolean z) {
        if (this.isProductValid && w4.d(str)) {
            this.summary.put(str, Boolean.valueOf(z));
        }
        return this;
    }

    public InsiderProduct setCustomAttributeWithDate(String str, Date date) {
        String strA;
        if (this.isProductValid && w4.d(str) && date != null && (strA = w4.a(date)) != null) {
            this.summary.put(str, strA);
        }
        return this;
    }

    public InsiderProduct setCustomAttributeWithDouble(String str, double d) {
        if (this.isProductValid && w4.d(str)) {
            this.summary.put(str, Double.valueOf(d));
        }
        return this;
    }

    public InsiderProduct setCustomAttributeWithInt(String str, int i) {
        if (this.isProductValid && w4.d(str)) {
            this.summary.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public InsiderProduct setCustomAttributeWithNumericArray(String str, Number[] numberArr) {
        Number[] numberArrA;
        if (this.isProductValid && w4.d(str) && (numberArrA = w4.a((Object[]) numberArr)) != null) {
            this.summary.put(str, numberArrA);
        }
        return this;
    }

    public InsiderProduct setCustomAttributeWithString(String str, String str2) {
        if (this.isProductValid && w4.d(str) && str2 != null && str2.length() != 0) {
            this.summary.put(str, str2);
        }
        return this;
    }

    public InsiderProduct setCustomAttributeWithStringArray(String str, String[] strArr) {
        String[] strArrB;
        if (this.isProductValid && w4.d(str) && (strArrB = w4.b((Object[]) strArr)) != null) {
            this.summary.put(str, strArrB);
        }
        return this;
    }

    public InsiderProduct setDescription(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("desc", str);
        }
        return this;
    }

    public InsiderProduct setGender(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("ge", str);
        }
        return this;
    }

    public InsiderProduct setGroupCode(String str) {
        try {
            if (this.isProductValid && str != null) {
                this.summary.put("groupcode", str);
            }
            return this;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return this;
        }
    }

    public InsiderProduct setGtin(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("gt", str);
        }
        return this;
    }

    public InsiderProduct setInStock(boolean z) {
        this.summary.put("iis", Boolean.valueOf(z));
        return this;
    }

    public InsiderProduct setMultipack(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("mlt", str);
        }
        return this;
    }

    public InsiderProduct setName(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("na", str);
        }
        return this;
    }

    public InsiderProduct setProductID(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("pid", str);
        }
        return this;
    }

    public InsiderProduct setProductImageURL(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("piu", str);
        }
        return this;
    }

    public InsiderProduct setProductType(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("pt", str);
        }
        return this;
    }

    public InsiderProduct setProductURL(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put(ImagesContract.URL, str);
        }
        return this;
    }

    public InsiderProduct setPromotionDiscount(double d) {
        if (this.isProductValid && d >= 0.0d) {
            this.summary.put("pd", Double.valueOf(d));
        }
        return this;
    }

    public InsiderProduct setPromotionName(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("pn", str);
        }
        return this;
    }

    public InsiderProduct setQuantity(int i) {
        if (this.isProductValid && i > 0) {
            this.summary.put("qu", Integer.valueOf(i));
        }
        return this;
    }

    InsiderProduct setSaleID(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("e_guid", str);
        }
        return this;
    }

    public InsiderProduct setSalePrice(double d) {
        if (this.isProductValid && d >= 0.0d) {
            this.summary.put("usp", Double.valueOf(d));
        }
        return this;
    }

    public InsiderProduct setShippingCost(double d) {
        if (this.isProductValid && d >= 0.0d) {
            this.summary.put("sc", Double.valueOf(d));
        }
        return this;
    }

    public InsiderProduct setSize(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("si", str);
        }
        return this;
    }

    public InsiderProduct setSku(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("sku", str);
        }
        return this;
    }

    public InsiderProduct setStock(int i) {
        if (this.isProductValid && i >= 0) {
            this.summary.put("st", Integer.valueOf(i));
        }
        return this;
    }

    public InsiderProduct setTags(String[] strArr) {
        if (this.isProductValid && strArr != null && strArr.length != 0) {
            this.summary.put("tags", strArr);
        }
        return this;
    }

    public InsiderProduct setTaxonomy(String[] strArr) {
        if (this.isProductValid && strArr != null && strArr.length != 0) {
            this.summary.put("ta", strArr);
        }
        return this;
    }

    public InsiderProduct setUnitPrice(double d) {
        if (this.isProductValid && d >= 0.0d) {
            this.summary.put(GesturesListener.SCROLL_DIRECTION_UP, Double.valueOf(d));
        }
        return this;
    }

    public InsiderProduct setVoucherDiscount(double d) {
        if (this.isProductValid && d >= 0.0d) {
            this.summary.put("vd", Double.valueOf(d));
        }
        return this;
    }

    public InsiderProduct setVoucherName(String str) {
        if (this.isProductValid && str != null && str.length() != 0) {
            this.summary.put("vn", str);
        }
        return this;
    }
}
