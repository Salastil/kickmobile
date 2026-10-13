package org.h.s;

import android.os.Build;
import com.facebook.common.callercontext.ContextChain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006¨\u0006 "}, d2 = {"Lorg/h/s/k;", "", "", "a", "Ljava/lang/String;", "getFingerprint", "()Ljava/lang/String;", "fingerprint", "b", "getModel", "model", "c", "getManufacturer", "manufacturer", "d", "getHardware", "hardware", "e", "getProduct", "product", "f", "getBrand", "brand", "g", "getDevice", "device", "h", "getBoard", "board", ContextChain.TAG_INFRA, "getBootLoader", "bootLoader", "sdk_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @SerializedName("fingerprint")
    private final String fingerprint;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @SerializedName("model")
    private final String model;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @SerializedName("manufacturer")
    private final String manufacturer;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @SerializedName("hardware")
    private final String hardware;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @SerializedName("product")
    private final String product;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @SerializedName("brand")
    private final String brand;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @SerializedName("device")
    private final String device;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @SerializedName("board")
    private final String board;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @SerializedName("bootLoader")
    private final String bootLoader;

    public k(String fingerprint, String model, String manufacturer, String hardware, String product, String brand, String device, String board, String bootLoader) {
        Intrinsics.checkNotNullParameter(fingerprint, "fingerprint");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(hardware, "hardware");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(board, "board");
        Intrinsics.checkNotNullParameter(bootLoader, "bootLoader");
        this.fingerprint = fingerprint;
        this.model = model;
        this.manufacturer = manufacturer;
        this.hardware = hardware;
        this.product = product;
        this.brand = brand;
        this.device = device;
        this.board = board;
        this.bootLoader = bootLoader;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Intrinsics.areEqual(this.fingerprint, kVar.fingerprint) && Intrinsics.areEqual(this.model, kVar.model) && Intrinsics.areEqual(this.manufacturer, kVar.manufacturer) && Intrinsics.areEqual(this.hardware, kVar.hardware) && Intrinsics.areEqual(this.product, kVar.product) && Intrinsics.areEqual(this.brand, kVar.brand) && Intrinsics.areEqual(this.device, kVar.device) && Intrinsics.areEqual(this.board, kVar.board) && Intrinsics.areEqual(this.bootLoader, kVar.bootLoader);
    }

    public final int hashCode() {
        return this.bootLoader.hashCode() + ((this.board.hashCode() + ((this.device.hashCode() + ((this.brand.hashCode() + ((this.product.hashCode() + ((this.hardware.hashCode() + ((this.manufacturer.hashCode() + ((this.model.hashCode() + (this.fingerprint.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "BuildInfo(fingerprint=" + this.fingerprint + ", model=" + this.model + ", manufacturer=" + this.manufacturer + ", hardware=" + this.hardware + ", product=" + this.product + ", brand=" + this.brand + ", device=" + this.device + ", board=" + this.board + ", bootLoader=" + this.bootLoader + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ k() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        String HARDWARE = Build.HARDWARE;
        Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
        String PRODUCT = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        String DEVICE = Build.DEVICE;
        Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
        String BOARD = Build.BOARD;
        Intrinsics.checkNotNullExpressionValue(BOARD, "BOARD");
        String BOOTLOADER = Build.BOOTLOADER;
        Intrinsics.checkNotNullExpressionValue(BOOTLOADER, "BOOTLOADER");
        this(FINGERPRINT, MODEL, MANUFACTURER, HARDWARE, PRODUCT, BRAND, DEVICE, BOARD, BOOTLOADER);
    }
}
