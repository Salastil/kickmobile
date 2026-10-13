package com.facebook.fresco.vito.source;

import kotlin.Metadata;

/* JADX INFO: compiled from: ColorImageSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/facebook/fresco/vito/source/ColorImageSource;", "Lcom/facebook/fresco/vito/source/ImageSource;", "color", "", "<init>", "(I)V", "getColor", "()I", "getClassNameString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "source_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ColorImageSource implements ImageSource {
    private final int color;

    public static /* synthetic */ ColorImageSource copy$default(ColorImageSource colorImageSource, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = colorImageSource.color;
        }
        return colorImageSource.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    public final ColorImageSource copy(int color) {
        return new ColorImageSource(color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ColorImageSource) && this.color == ((ColorImageSource) other).color;
    }

    public int hashCode() {
        return Integer.hashCode(this.color);
    }

    public String toString() {
        return "ColorImageSource(color=" + this.color + ")";
    }

    public ColorImageSource(int i) {
        this.color = i;
    }

    public final int getColor() {
        return this.color;
    }

    @Override // com.facebook.fresco.vito.source.ImageSource
    public String getClassNameString() {
        return "ColorImageSource";
    }
}
