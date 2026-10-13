package com.amazonaws.ivs.player;

import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class Size {
    public final int height;
    public final int width;

    public Size(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.width == size.width && this.height == size.height) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.width), Integer.valueOf(this.height));
    }

    public String toString() {
        return this.width + ViewDeviceOrientationData.DEVICE_ORIENTATION_X + this.height;
    }

    public Size flip() {
        return new Size(this.height, this.width);
    }
}
