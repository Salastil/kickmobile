package eightbitlab.com.blurview;

import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes9.dex */
public class SizeScaler {
    private static final int ROUNDING_VALUE = 64;
    private final boolean noStrideAlignment;
    private final float scaleFactor;

    public SizeScaler(float f) {
        this(f, false);
    }

    public SizeScaler(float f, boolean z) {
        this.scaleFactor = f;
        this.noStrideAlignment = z;
    }

    Size scale(int i, int i2) {
        float f = i;
        int iRoundSize = roundSize(downscaleSize(f));
        return new Size(iRoundSize, (int) Math.ceil(i2 / (f / iRoundSize)));
    }

    Size scale(Size size) {
        return scale(size.width, size.height);
    }

    boolean isZeroSized(int i, int i2) {
        return downscaleSize((float) i2) == 0 || downscaleSize((float) i) == 0;
    }

    private int roundSize(int i) {
        int i2;
        return (this.noStrideAlignment || (i2 = i % 64) == 0) ? i : (i - i2) + 64;
    }

    private int downscaleSize(float f) {
        return (int) Math.ceil(f / this.scaleFactor);
    }

    static class Size {
        final int height;
        final int width;

        Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public boolean equals(Object obj) {
            if (obj != null && getClass() == obj.getClass()) {
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
            return "Size{width=" + this.width + ", height=" + this.height + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
