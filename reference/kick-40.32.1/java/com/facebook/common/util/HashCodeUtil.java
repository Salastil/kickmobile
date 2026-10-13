package com.facebook.common.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: HashCodeUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0007J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0007J&\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0007J0\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0007J:\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007JD\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007JN\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J(\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J0\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0007J8\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0007J@\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/common/util/HashCodeUtil;", "", "<init>", "()V", "X", "", "hashCode", "o1", "o2", "o3", "o4", "o5", "o6", "o7", "i1", "i2", "i3", "i4", "i5", "i6", "i7", "fbcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HashCodeUtil {
    public static final HashCodeUtil INSTANCE = new HashCodeUtil();
    private static final int X = 31;

    @JvmStatic
    public static final int hashCode(int i1) {
        return i1 + 31;
    }

    @JvmStatic
    public static final int hashCode(int i1, int i2) {
        return ((i1 + 31) * 31) + i2;
    }

    @JvmStatic
    public static final int hashCode(int i1, int i2, int i3) {
        return ((((i1 + 31) * 31) + i2) * 31) + i3;
    }

    @JvmStatic
    public static final int hashCode(int i1, int i2, int i3, int i4) {
        return ((((((i1 + 31) * 31) + i2) * 31) + i3) * 31) + i4;
    }

    @JvmStatic
    public static final int hashCode(int i1, int i2, int i3, int i4, int i5) {
        return ((((((((i1 + 31) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5;
    }

    @JvmStatic
    public static final int hashCode(int i1, int i2, int i3, int i4, int i5, int i6) {
        return ((((((((((i1 + 31) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6;
    }

    @JvmStatic
    public static final int hashCode(int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
        return ((((((((((((i1 + 31) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6) * 31) + i7;
    }

    private HashCodeUtil() {
    }

    @JvmStatic
    public static final int hashCode(Object o1) {
        return hashCode(o1 != null ? o1.hashCode() : 0);
    }

    @JvmStatic
    public static final int hashCode(Object o1, Object o2) {
        return hashCode(o1 != null ? o1.hashCode() : 0, o2 != null ? o2.hashCode() : 0);
    }

    @JvmStatic
    public static final int hashCode(Object o1, Object o2, Object o3) {
        return hashCode(o1 != null ? o1.hashCode() : 0, o2 != null ? o2.hashCode() : 0, o3 != null ? o3.hashCode() : 0);
    }

    @JvmStatic
    public static final int hashCode(Object o1, Object o2, Object o3, Object o4) {
        return hashCode(o1 != null ? o1.hashCode() : 0, o2 != null ? o2.hashCode() : 0, o3 != null ? o3.hashCode() : 0, o4 != null ? o4.hashCode() : 0);
    }

    @JvmStatic
    public static final int hashCode(Object o1, Object o2, Object o3, Object o4, Object o5) {
        return hashCode(o1 != null ? o1.hashCode() : 0, o2 != null ? o2.hashCode() : 0, o3 != null ? o3.hashCode() : 0, o4 != null ? o4.hashCode() : 0, o5 != null ? o5.hashCode() : 0);
    }

    @JvmStatic
    public static final int hashCode(Object o1, Object o2, Object o3, Object o4, Object o5, Object o6) {
        return hashCode(o1 != null ? o1.hashCode() : 0, o2 != null ? o2.hashCode() : 0, o3 != null ? o3.hashCode() : 0, o4 != null ? o4.hashCode() : 0, o5 != null ? o5.hashCode() : 0, o6 != null ? o6.hashCode() : 0);
    }

    @JvmStatic
    public static final int hashCode(Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) {
        return hashCode(o1 != null ? o1.hashCode() : 0, o2 != null ? o2.hashCode() : 0, o3 != null ? o3.hashCode() : 0, o4 != null ? o4.hashCode() : 0, o5 != null ? o5.hashCode() : 0, o6 != null ? o6.hashCode() : 0, o7 != null ? o7.hashCode() : 0);
    }
}
