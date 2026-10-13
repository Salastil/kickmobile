package com.useinsider.insider;

import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class j implements e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat[] f345a;

    static {
        ArrayList arrayList = new ArrayList();
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", locale));
        arrayList.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", locale));
        arrayList.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", locale));
        arrayList.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", locale));
        arrayList.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", locale));
        arrayList.add(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", locale));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((SimpleDateFormat) obj).setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }
        f345a = (SimpleDateFormat[]) arrayList.toArray(new SimpleDateFormat[0]);
    }

    j() {
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Long a() {
        return null;
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Long a(Boolean bool) {
        return null;
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long a(Object obj) {
        if (obj instanceof Date) {
            return Long.valueOf(((Date) obj).getTime() / 1000);
        }
        return null;
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Long a(String str) {
        if (str != null && !str.isEmpty()) {
            SimpleDateFormat[] simpleDateFormatArr = f345a;
            int length = simpleDateFormatArr.length;
            for (int i = 0; i < length; i++) {
                try {
                    Date date = ((SimpleDateFormat) simpleDateFormatArr[i].clone()).parse(str);
                    if (date != null) {
                        return Long.valueOf(date.getTime() / 1000);
                    }
                } catch (ParseException unused) {
                }
            }
            return null;
        }
        return a();
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Long a(Number number) {
        return Long.valueOf(number.longValue());
    }
}
