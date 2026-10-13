package com.amazonaws.ivs.player;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class UnavailableQuality {
    private final List<String> authReasons;
    private final int bitrate;
    private final String codecs;
    private final List<String> filterReasons;
    private final float framerate;
    private final String group;
    private final int height;
    private final String name;
    private final String[] sourceGroups;
    private final String variantId;
    private final String variantSource;
    private final int width;

    UnavailableQuality(String str, String str2, String str3, String str4, String[] strArr, int i, int i2, String str5, int i3, float f, List<String> list, List<String> list2) {
        this.name = str;
        this.codecs = str2;
        this.variantSource = str3;
        this.variantId = str4;
        this.sourceGroups = strArr;
        this.width = i;
        this.height = i2;
        this.group = str5;
        this.bitrate = i3;
        this.framerate = f;
        this.filterReasons = new ArrayList(list);
        this.authReasons = new ArrayList(list2);
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

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getGroup() {
        return this.group;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public float getFramerate() {
        return this.framerate;
    }

    public List<String> getFilterReasons() {
        return new ArrayList(this.filterReasons);
    }

    public List<String> getAuthReasons() {
        return new ArrayList(this.authReasons);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            UnavailableQuality unavailableQuality = (UnavailableQuality) obj;
            if (this.name.equals(unavailableQuality.name) && this.group.equals(unavailableQuality.group) && this.width == unavailableQuality.width && this.height == unavailableQuality.height && this.codecs.equals(unavailableQuality.codecs) && this.bitrate == unavailableQuality.bitrate && this.framerate == unavailableQuality.framerate) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.name.hashCode() * 31) + this.group.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + this.codecs.hashCode()) * 31) + this.bitrate) * 31) + Float.floatToIntBits(this.framerate);
    }
}
