package com.useinsider.insider;

import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
final class f4 implements e5 {
    f4() {
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BigDecimal a() {
        return null;
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public BigDecimal a(Object obj) {
        return null;
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BigDecimal a(String str) {
        return new BigDecimal(str);
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BigDecimal a(Number number) {
        return new BigDecimal(number.toString());
    }

    @Override // com.useinsider.insider.e5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BigDecimal a(Boolean bool) {
        return new BigDecimal(bool.booleanValue() ? 1 : 0);
    }
}
