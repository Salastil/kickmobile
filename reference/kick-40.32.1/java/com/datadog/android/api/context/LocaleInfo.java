package com.datadog.android.api.context;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocaleInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/datadog/android/api/context/LocaleInfo;", "", "locales", "", "", "currentLocale", "timeZone", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getCurrentLocale", "()Ljava/lang/String;", "getLocales", "()Ljava/util/List;", "getTimeZone", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LocaleInfo {
    private final String currentLocale;
    private final List<String> locales;
    private final String timeZone;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LocaleInfo copy$default(LocaleInfo localeInfo, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = localeInfo.locales;
        }
        if ((i & 2) != 0) {
            str = localeInfo.currentLocale;
        }
        if ((i & 4) != 0) {
            str2 = localeInfo.timeZone;
        }
        return localeInfo.copy(list, str, str2);
    }

    public final List<String> component1() {
        return this.locales;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCurrentLocale() {
        return this.currentLocale;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTimeZone() {
        return this.timeZone;
    }

    public final LocaleInfo copy(List<String> locales, String currentLocale, String timeZone) {
        Intrinsics.checkNotNullParameter(locales, "locales");
        Intrinsics.checkNotNullParameter(currentLocale, "currentLocale");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return new LocaleInfo(locales, currentLocale, timeZone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocaleInfo)) {
            return false;
        }
        LocaleInfo localeInfo = (LocaleInfo) other;
        return Intrinsics.areEqual(this.locales, localeInfo.locales) && Intrinsics.areEqual(this.currentLocale, localeInfo.currentLocale) && Intrinsics.areEqual(this.timeZone, localeInfo.timeZone);
    }

    public int hashCode() {
        return (((this.locales.hashCode() * 31) + this.currentLocale.hashCode()) * 31) + this.timeZone.hashCode();
    }

    public String toString() {
        return "LocaleInfo(locales=" + this.locales + ", currentLocale=" + this.currentLocale + ", timeZone=" + this.timeZone + ")";
    }

    public LocaleInfo(List<String> locales, String currentLocale, String timeZone) {
        Intrinsics.checkNotNullParameter(locales, "locales");
        Intrinsics.checkNotNullParameter(currentLocale, "currentLocale");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        this.locales = locales;
        this.currentLocale = currentLocale;
        this.timeZone = timeZone;
    }

    public final List<String> getLocales() {
        return this.locales;
    }

    public final String getCurrentLocale() {
        return this.currentLocale;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }
}
