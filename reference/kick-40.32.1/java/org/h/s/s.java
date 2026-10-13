package org.h.s;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0017"}, d2 = {"Lorg/h/s/s;", "", "", "a", "Ljava/lang/String;", "getBrand", "()Ljava/lang/String;", "brand", "b", "getModel", "model", "c", "getSdkInt", "sdkInt", "d", "getDevice", "device", "e", "getProduct", "product", "f", "getWebViewVersion", "webViewVersion", "sdk_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @SerializedName("brand")
    private final String brand;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @SerializedName("model")
    private final String model;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @SerializedName("sdkInt")
    private final String sdkInt;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @SerializedName("device")
    private final String device;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @SerializedName("product")
    private final String product;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @SerializedName("webViewVersion")
    private final String webViewVersion;

    public s(String brand, String model, String sdkInt, String device, String product, String webViewVersion) {
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(sdkInt, "sdkInt");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(webViewVersion, "webViewVersion");
        this.brand = brand;
        this.model = model;
        this.sdkInt = sdkInt;
        this.device = device;
        this.product = product;
        this.webViewVersion = webViewVersion;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Intrinsics.areEqual(this.brand, sVar.brand) && Intrinsics.areEqual(this.model, sVar.model) && Intrinsics.areEqual(this.sdkInt, sVar.sdkInt) && Intrinsics.areEqual(this.device, sVar.device) && Intrinsics.areEqual(this.product, sVar.product) && Intrinsics.areEqual(this.webViewVersion, sVar.webViewVersion);
    }

    public final int hashCode() {
        return this.webViewVersion.hashCode() + ((this.product.hashCode() + ((this.device.hashCode() + ((this.sdkInt.hashCode() + ((this.model.hashCode() + (this.brand.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "DeviceInfo(brand=" + this.brand + ", model=" + this.model + ", sdkInt=" + this.sdkInt + ", device=" + this.device + ", product=" + this.product + ", webViewVersion=" + this.webViewVersion + ")";
    }
}
