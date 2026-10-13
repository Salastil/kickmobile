package com.amazonaws.ivs.player;

import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class Quality {
    private final int bitrate;
    private final String codecs;
    private final float framerate;
    private final int height;
    private final boolean isDefault;
    private final String name;
    private final String[] sourceGroups;
    private final String variantId;
    private final String variantSource;
    private final int width;

    Quality(String str, String str2, String str3, String str4, String[] strArr, int i, int i2, int i3, float f, boolean z) {
        this.name = str;
        this.codecs = str2;
        this.variantSource = str3;
        this.variantId = str4;
        this.sourceGroups = strArr;
        this.bitrate = i;
        this.width = i2;
        this.height = i3;
        this.framerate = f;
        this.isDefault = z;
    }

    public String toString() {
        return String.format(Locale.ROOT, "name: %s, codecs %s, bitrate %d, resolution %d x %d framerate %.2f", this.name, this.codecs, Integer.valueOf(this.bitrate), Integer.valueOf(this.width), Integer.valueOf(this.height), Float.valueOf(this.framerate));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Quality)) {
            return false;
        }
        Quality quality = (Quality) obj;
        return this.bitrate == quality.bitrate && this.width == quality.width && this.height == quality.height && Float.compare(quality.framerate, this.framerate) == 0 && Objects.equals(this.name, quality.name) && Objects.equals(this.codecs, quality.codecs);
    }

    public int hashCode() {
        return Objects.hash(this.name, this.codecs, Integer.valueOf(this.bitrate), Integer.valueOf(this.width), Integer.valueOf(this.height), Float.valueOf(this.framerate));
    }

    public String getName() {
        return this.name;
    }

    public String getCodecs() {
        return this.codecs;
    }

    public String getVariantSource() {
        return this.variantSource;
    }

    public String getVariantId() {
        return this.variantId;
    }

    public String[] getSourceGroups() {
        return this.sourceGroups;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public float getFramerate() {
        return this.framerate;
    }
}
