package com.fingerprintjs.android.fpjs_pro;

import androidx.autofill.HintConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001:\u0004=>?@BU\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0007HÇ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0007HÇ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\nHÇ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\fHÇ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u000eHÇ\u0003¢\u0006\u0004\b!\u0010\"J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÇ\u0003¢\u0006\u0004\b#\u0010$Jp\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÇ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b+\u0010\u0016J\u0010\u0010,\u001a\u00020\u0007H×\u0001¢\u0006\u0004\b,\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b0\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u00101\u001a\u0004\b2\u0010\"R\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u00103\u001a\u0004\b4\u0010 R\u001a\u0010\u0005\u001a\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u00105\u001a\u0004\b6\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u00105\u001a\u0004\b7\u0010\u0018R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u00108\u001a\u0004\b9\u0010\u001bR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010:\u001a\u0004\b;\u0010$R\u001a\u0010\t\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u00108\u001a\u0004\b<\u0010\u001b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/IpLocation;", "", "", "accuracyRadius", "", "latitude", "longitude", "", HintConstants.AUTOFILL_HINT_POSTAL_CODE, "timezone", "Lcom/fingerprintjs/android/fpjs_pro/IpLocation$City;", "city", "Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Country;", "country", "Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Continent;", "continent", "", "Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Subdivisions;", "subdivisions", "<init>", "(IDDLjava/lang/String;Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro/IpLocation$City;Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Country;Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Continent;Ljava/util/List;)V", "component1", "()I", "component2", "()D", "component3", "component4", "()Ljava/lang/String;", "component5", "component6", "()Lcom/fingerprintjs/android/fpjs_pro/IpLocation$City;", "component7", "()Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Country;", "component8", "()Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Continent;", "component9", "()Ljava/util/List;", "copy", "(IDDLjava/lang/String;Ljava/lang/String;Lcom/fingerprintjs/android/fpjs_pro/IpLocation$City;Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Country;Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Continent;Ljava/util/List;)Lcom/fingerprintjs/android/fpjs_pro/IpLocation;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getAccuracyRadius", "Lcom/fingerprintjs/android/fpjs_pro/IpLocation$City;", "getCity", "Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Continent;", "getContinent", "Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Country;", "getCountry", "D", "getLatitude", "getLongitude", "Ljava/lang/String;", "getPostalCode", "Ljava/util/List;", "getSubdivisions", "getTimezone", "City", "Continent", "Country", "Subdivisions"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class IpLocation {
    private final int accuracyRadius;
    private final City city;
    private final Continent continent;
    private final Country country;
    private final double latitude;
    private final double longitude;
    private final String postalCode;
    private final List<Subdivisions> subdivisions;
    private final String timezone;

    public IpLocation(int i, double d, double d2, String str, String str2, City city, Country country, Continent continent, List<Subdivisions> list) {
        this.accuracyRadius = i;
        this.latitude = d;
        this.longitude = d2;
        this.postalCode = str;
        this.timezone = str2;
        this.city = city;
        this.country = country;
        this.continent = continent;
        this.subdivisions = list;
    }

    public final int getAccuracyRadius() {
        return this.accuracyRadius;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final City getCity() {
        return this.city;
    }

    public final Country getCountry() {
        return this.country;
    }

    public final Continent getContinent() {
        return this.continent;
    }

    public final List<Subdivisions> getSubdivisions() {
        return this.subdivisions;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/IpLocation$City;", "", "", "name", "<init>", "(Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Lcom/fingerprintjs/android/fpjs_pro/IpLocation$City;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getName"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class City {
        private final String name;

        public City(String str) {
            this.name = str;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof City) && Intrinsics.areEqual(this.name, ((City) other).name);
        }

        public final int hashCode() {
            return this.name.hashCode();
        }

        public final String toString() {
            return "City(name=" + this.name + ")";
        }

        public static /* synthetic */ City copy$default(City city, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = city.name;
            }
            return city.copy(str);
        }

        public final City copy(String name) {
            return new City(name);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0013\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Country;", "", "", "code", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Country;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCode", "getName"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Country {
        private final String code;
        private final String name;

        public Country(String str, String str2) {
            this.code = str;
            this.name = str2;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Country)) {
                return false;
            }
            Country country = (Country) other;
            return Intrinsics.areEqual(this.code, country.code) && Intrinsics.areEqual(this.name, country.name);
        }

        public final int hashCode() {
            return (this.code.hashCode() * 31) + this.name.hashCode();
        }

        public final String toString() {
            return "Country(code=" + this.code + ", name=" + this.name + ")";
        }

        public static /* synthetic */ Country copy$default(Country country, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = country.code;
            }
            if ((i & 2) != 0) {
                str2 = country.name;
            }
            return country.copy(str, str2);
        }

        public final Country copy(String code, String name) {
            return new Country(code, name);
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCode() {
            return this.code;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0013\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Continent;", "", "", "code", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Continent;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCode", "getName"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Continent {
        private final String code;
        private final String name;

        public Continent(String str, String str2) {
            this.code = str;
            this.name = str2;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Continent)) {
                return false;
            }
            Continent continent = (Continent) other;
            return Intrinsics.areEqual(this.code, continent.code) && Intrinsics.areEqual(this.name, continent.name);
        }

        public final int hashCode() {
            return (this.code.hashCode() * 31) + this.name.hashCode();
        }

        public final String toString() {
            return "Continent(code=" + this.code + ", name=" + this.name + ")";
        }

        public static /* synthetic */ Continent copy$default(Continent continent, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = continent.code;
            }
            if ((i & 2) != 0) {
                str2 = continent.name;
            }
            return continent.copy(str, str2);
        }

        public final Continent copy(String code, String name) {
            return new Continent(code, name);
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCode() {
            return this.code;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÇ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0013\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\b"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Subdivisions;", "", "", "isoCode", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/fingerprintjs/android/fpjs_pro/IpLocation$Subdivisions;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getIsoCode", "getName"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Subdivisions {
        private final String isoCode;
        private final String name;

        public Subdivisions(String str, String str2) {
            this.isoCode = str;
            this.name = str2;
        }

        public final String getIsoCode() {
            return this.isoCode;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subdivisions)) {
                return false;
            }
            Subdivisions subdivisions = (Subdivisions) other;
            return Intrinsics.areEqual(this.isoCode, subdivisions.isoCode) && Intrinsics.areEqual(this.name, subdivisions.name);
        }

        public final int hashCode() {
            return (this.isoCode.hashCode() * 31) + this.name.hashCode();
        }

        public final String toString() {
            return "Subdivisions(isoCode=" + this.isoCode + ", name=" + this.name + ")";
        }

        public static /* synthetic */ Subdivisions copy$default(Subdivisions subdivisions, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subdivisions.isoCode;
            }
            if ((i & 2) != 0) {
                str2 = subdivisions.name;
            }
            return subdivisions.copy(str, str2);
        }

        public final Subdivisions copy(String isoCode, String name) {
            return new Subdivisions(isoCode, name);
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getIsoCode() {
            return this.isoCode;
        }
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IpLocation)) {
            return false;
        }
        IpLocation ipLocation = (IpLocation) other;
        return this.accuracyRadius == ipLocation.accuracyRadius && Double.compare(this.latitude, ipLocation.latitude) == 0 && Double.compare(this.longitude, ipLocation.longitude) == 0 && Intrinsics.areEqual(this.postalCode, ipLocation.postalCode) && Intrinsics.areEqual(this.timezone, ipLocation.timezone) && Intrinsics.areEqual(this.city, ipLocation.city) && Intrinsics.areEqual(this.country, ipLocation.country) && Intrinsics.areEqual(this.continent, ipLocation.continent) && Intrinsics.areEqual(this.subdivisions, ipLocation.subdivisions);
    }

    public final int hashCode() {
        return (((((((((((((((Integer.hashCode(this.accuracyRadius) * 31) + Double.hashCode(this.latitude)) * 31) + Double.hashCode(this.longitude)) * 31) + this.postalCode.hashCode()) * 31) + this.timezone.hashCode()) * 31) + this.city.hashCode()) * 31) + this.country.hashCode()) * 31) + this.continent.hashCode()) * 31) + this.subdivisions.hashCode();
    }

    public final String toString() {
        return "IpLocation(accuracyRadius=" + this.accuracyRadius + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", postalCode=" + this.postalCode + ", timezone=" + this.timezone + ", city=" + this.city + ", country=" + this.country + ", continent=" + this.continent + ", subdivisions=" + this.subdivisions + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IpLocation copy$default(IpLocation ipLocation, int i, double d, double d2, String str, String str2, City city, Country country, Continent continent, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ipLocation.accuracyRadius;
        }
        if ((i2 & 2) != 0) {
            d = ipLocation.latitude;
        }
        if ((i2 & 4) != 0) {
            d2 = ipLocation.longitude;
        }
        if ((i2 & 8) != 0) {
            str = ipLocation.postalCode;
        }
        if ((i2 & 16) != 0) {
            str2 = ipLocation.timezone;
        }
        if ((i2 & 32) != 0) {
            city = ipLocation.city;
        }
        if ((i2 & 64) != 0) {
            country = ipLocation.country;
        }
        if ((i2 & 128) != 0) {
            continent = ipLocation.continent;
        }
        if ((i2 & 256) != 0) {
            list = ipLocation.subdivisions;
        }
        Continent continent2 = continent;
        List list2 = list;
        double d3 = d2;
        return ipLocation.copy(i, d, d3, str, str2, city, country, continent2, list2);
    }

    public final IpLocation copy(int accuracyRadius, double latitude, double longitude, String postalCode, String timezone, City city, Country country, Continent continent, List<Subdivisions> subdivisions) {
        return new IpLocation(accuracyRadius, latitude, longitude, postalCode, timezone, city, country, continent, subdivisions);
    }

    public final List<Subdivisions> component9() {
        return this.subdivisions;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Continent getContinent() {
        return this.continent;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Country getCountry() {
        return this.country;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final City getCity() {
        return this.city;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTimezone() {
        return this.timezone;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAccuracyRadius() {
        return this.accuracyRadius;
    }
}
