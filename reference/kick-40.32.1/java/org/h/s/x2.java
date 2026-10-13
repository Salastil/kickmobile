package org.h.s;

/* JADX INFO: loaded from: classes11.dex */
public abstract class x2 extends e3 {
    public final String e;
    public int f;
    public final int g;
    public final int h;
    public final int i;

    public /* synthetic */ x2(String str, int i, int i2, int i3, int i4, Object obj) {
        this(str, i, i2, i3, i4);
    }

    public final String a() {
        return this.e;
    }

    public final Integer b() {
        return Integer.valueOf(this.f);
    }

    public final int c() {
        if (this.g == -1) {
            int i = this.f;
            Integer.valueOf(i).getClass();
            if (i <= this.h) {
                int i2 = this.f;
                Integer.valueOf(i2).getClass();
                return i2;
            }
        }
        int i3 = this.g;
        int i4 = this.f;
        Integer.valueOf(i4).getClass();
        if (i3 <= i4 && this.h == -1) {
            int i5 = this.f;
            Integer.valueOf(i5).getClass();
            return i5;
        }
        int i6 = this.g;
        int i7 = this.h;
        int i8 = this.f;
        Integer.valueOf(i8).getClass();
        if (i6 > i8 || i8 > i7) {
            return this.i;
        }
        int i9 = this.f;
        Integer.valueOf(i9).getClass();
        return i9;
    }

    public final int d() {
        int i = this.f;
        Integer.valueOf(i).getClass();
        int i2 = this.f;
        if (i == 0) {
            Integer.valueOf(i2).getClass();
            return i2;
        }
        Integer.valueOf(i2).getClass();
        int i3 = this.g;
        if (i2 < i3) {
            return i3;
        }
        int i4 = this.h;
        int i5 = this.f;
        if (i4 == -1) {
            Integer.valueOf(i5).getClass();
            return i5;
        }
        Integer.valueOf(i5).getClass();
        if (i3 > i5 || i5 > i4) {
            return this.i;
        }
        int i6 = this.f;
        Integer.valueOf(i6).getClass();
        return i6;
    }

    public /* synthetic */ x2(String str, int i, int i2, int i3, int i4, int i5) {
        this(str, i, (i4 & 4) != 0 ? -1 : i2, (i4 & 8) != 0 ? -1 : i3, (i4 & 16) != 0 ? i : 0, (Object) null);
    }

    public final void a(int i) {
        this.f = i;
    }

    public x2(String str, int i, int i2, int i3, int i4) {
        super(Integer.valueOf(i), 0);
        this.e = str;
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }
}
