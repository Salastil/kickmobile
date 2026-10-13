package com.fingerprintjs.android.fpjs_pro_internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.GapComposerKt;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u0013\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0003¢\u0006\u0004\b\u0017\u0010\u0014J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0018\u0010\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u0018\u0010\u001aJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0004\b\u0010\u0010\u0014J\r\u0010\u0018\u001a\u00020\u001b¢\u0006\u0004\b\u0018\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001cR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001eR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010 "}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/K17305;", "", "Landroid/content/Context;", "p0", "Landroid/location/LocationManager;", "p1", "Landroid/location/Geocoder;", "p2", "<init>", "(Landroid/content/Context;Landroid/location/LocationManager;Landroid/location/Geocoder;)V", "", "", "D8871", "()Ljava/util/List;", "", "", "component5", "(DDI)Ljava/util/List;", "Landroid/location/Location;", "vD14832N6715", "()Landroid/location/Location;", "setPivotYN16904", "(Ljava/lang/String;)Landroid/location/Location;", "component13", "component9", "", "(J)Landroid/location/Location;", "", "()Z", "setTopP6481", "Landroid/content/Context;", "Landroid/location/LocationManager;", "Landroid/location/Geocoder;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class K17305 {
    private static int N14263A23323 = 0;
    private static int component13 = 0;
    private static int component8 = 1;
    private static int setTopP6481 = 1;

    /* JADX INFO: renamed from: component5, reason: from kotlin metadata */
    private final Context D8871;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    private final Geocoder vD14832N6715;

    /* JADX INFO: renamed from: vD14832N6715, reason: from kotlin metadata */
    private final LocationManager setPivotYN16904;
    private static final component9 component9 = new component9(null);
    private static final List<String> D8871 = CollectionsKt.listOf((Object[]) new String[]{"gps", "network", "passive"});

    public static /* synthetic */ Object setPivotYN16904(int i, Object[] objArr, int i2, int i3, int i4, int i5, int i6) {
        int i7 = ~i3;
        int i8 = ~i5;
        int i9 = ~(i7 | i8);
        int i10 = ~i2;
        int i11 = i9 | (~(i10 | i5));
        int i12 = (~(i5 | i7)) | (~(i8 | i10));
        int i13 = ~(i3 | i2);
        int i14 = i12 | i13;
        int i15 = i13 | i11;
        int i16 = i3 + i2 + i + ((-1585779005) * i6) + (640148872 * i4);
        int i17 = i16 * i16;
        int i18 = (i3 * 308833806) + 153878528 + (308833806 * i2) + ((-448846874) * i11) + ((-224423437) * i14) + (224423437 * i15) + (84410368 * i) + (1159200768 * i6) + ((-734003200) * i4) + (2089549824 * i17);
        int i19 = (i3 * (-1291220770)) + 263398195 + (i2 * (-1291220770)) + (i11 * (-1802)) + (i14 * (-901)) + (i15 * 901) + (i * (-1291221671)) + (i6 * (-1079815989)) + (i4 * 669414472) + (i17 * 145489920);
        int i20 = i18 + (i19 * i19 * (-1699479552));
        if (i20 == 1) {
            return setPivotYN16904(objArr);
        }
        if (i20 == 2) {
            return D8871(objArr);
        }
        if (i20 == 3) {
            return component5(objArr);
        }
        if (i20 != 4) {
            return i20 != 5 ? vD14832N6715(objArr) : component13(objArr);
        }
        return component9(objArr);
    }

    public K17305(Context context, LocationManager locationManager, Geocoder geocoder) {
        this.D8871 = context;
        this.setPivotYN16904 = locationManager;
        this.vD14832N6715 = geocoder;
    }

    public static final /* synthetic */ Context D8871(K17305 k17305) {
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = (i2 & 69) + (i2 | 69);
        N14263A23323 = i3 % 128;
        int i4 = i3 % 2;
        Context context = k17305.D8871;
        if (i4 == 0) {
            return context;
        }
        throw null;
    }

    private static /* synthetic */ Object D8871(Object[] objArr) {
        K17305 k17305 = (K17305) objArr[0];
        int i = 2 % 2;
        int i2 = N14263A23323 + 67;
        setTopP6481 = i2 % 128;
        int i3 = i2 % 2;
        LocationManager locationManager = k17305.setPivotYN16904;
        if (i3 == 0) {
            int i4 = 1 / 0;
        }
        return locationManager;
    }

    private static /* synthetic */ Object vD14832N6715(Object[] objArr) {
        int i = 2 % 2;
        int i2 = N14263A23323;
        int i3 = (i2 & 81) + (i2 | 81);
        setTopP6481 = i3 % 128;
        int i4 = i3 % 2;
        boolean zIsPresent = Geocoder.isPresent();
        int i5 = N14263A23323;
        int i6 = (i5 & 45) + (i5 | 45);
        setTopP6481 = i6 % 128;
        if (i6 % 2 != 0) {
            return Boolean.valueOf(zIsPresent);
        }
        int i7 = 45 / 0;
        return Boolean.valueOf(zIsPresent);
    }

    public final List<String> component5(double p0, double p1, int p2) throws IOException {
        String countryCode;
        int i = 2 % 2;
        Geocoder geocoder = this.vD14832N6715;
        Intrinsics.checkNotNull(geocoder);
        List<Address> fromLocation = geocoder.getFromLocation(p0, p1, p2);
        Intrinsics.checkNotNull(fromLocation);
        ArrayList arrayList = new ArrayList();
        int i2 = setTopP6481 + 65;
        N14263A23323 = i2 % 128;
        int i3 = i2 % 2;
        for (Address address : fromLocation) {
            int i4 = setTopP6481;
            int i5 = ((i4 | 37) << 1) - (i4 ^ 37);
            N14263A23323 = i5 % 128;
            int i6 = i5 % 2;
            if (address != null) {
                int i7 = setTopP6481;
                int i8 = (i7 ^ 101) + ((i7 & 101) << 1);
                N14263A23323 = i8 % 128;
                int i9 = i8 % 2;
                countryCode = address.getCountryCode();
                int i10 = N14263A23323 + 101;
                setTopP6481 = i10 % 128;
                int i11 = i10 % 2;
            } else {
                countryCode = null;
            }
            if (countryCode != null) {
                int i12 = setTopP6481;
                int i13 = (i12 & 49) + (i12 | 49);
                N14263A23323 = i13 % 128;
                if (i13 % 2 != 0) {
                    arrayList.add(countryCode);
                    int i14 = 14 / 0;
                } else {
                    arrayList.add(countryCode);
                }
            }
        }
        return arrayList;
    }

    private static /* synthetic */ Object component13(Object[] objArr) {
        K17305 k17305 = (K17305) objArr[0];
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = ((i2 | 87) << 1) - (i2 ^ 87);
        N14263A23323 = i3 % 128;
        int i4 = i3 % 2;
        LocationManager locationManager = k17305.setPivotYN16904;
        Intrinsics.checkNotNull(locationManager);
        List<String> allProviders = locationManager.getAllProviders();
        Intrinsics.checkNotNull(allProviders);
        List listFilterNotNull = CollectionsKt.filterNotNull(allProviders);
        if (i4 != 0) {
            int i5 = 60 / 0;
        }
        int i6 = setTopP6481;
        int i7 = (i6 ^ 115) + ((i6 & 115) << 1);
        N14263A23323 = i7 % 128;
        if (i7 % 2 != 0) {
            int i8 = 85 / 0;
        }
        return listFilterNotNull;
    }

    public final Location component9(String p0) {
        int i = 2 % 2;
        int i2 = N14263A23323 + 119;
        setTopP6481 = i2 % 128;
        int i3 = i2 % 2;
        LocationManager locationManager = this.setPivotYN16904;
        Intrinsics.checkNotNull(locationManager);
        if (i3 != 0) {
            return locationManager.getLastKnownLocation(p0);
        }
        locationManager.getLastKnownLocation(p0);
        throw null;
    }

    public final Location vD14832N6715() {
        int i = 2 % 2;
        int i2 = setTopP6481 + 121;
        N14263A23323 = i2 % 128;
        int i3 = i2 % 2;
        if (Build.VERSION.SDK_INT < 30) {
            int iComponent9 = u.Companion.component9();
            Location location = (Location) setPivotYN16904(u.Companion.component9(), new Object[]{this}, -1945567960, 1945567961, u.Companion.component9(), iComponent9, u.Companion.component9());
            int i4 = setTopP6481;
            int i5 = ((i4 | 23) << 1) - (i4 ^ 23);
            N14263A23323 = i5 % 128;
            int i6 = i5 % 2;
            return location;
        }
        int i7 = setTopP6481 + 119;
        N14263A23323 = i7 % 128;
        if (i7 % 2 == 0) {
            int iComponent10 = u.Companion.component9();
            return (Location) setPivotYN16904(u.Companion.component9(), new Object[]{this}, -1294440118, 1294440122, u.Companion.component9(), iComponent10, u.Companion.component9());
        }
        int iComponent11 = u.Companion.component9();
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static /* synthetic */ Object component9(Object[] objArr) {
        Object next;
        K17305 k17305 = (K17305) objArr[0];
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = ((i2 | 43) << 1) - (i2 ^ 43);
        N14263A23323 = i3 % 128;
        int i4 = i3 % 2;
        List list = (List) setPivotYN16904(u.Companion.component9(), new Object[]{k17305}, -92254710, 92254715, u.Companion.component9(), u.Companion.component9(), u.Companion.component9());
        Iterator<T> it = D8871.iterator();
        int i5 = setTopP6481;
        int i6 = ((i5 | 25) << 1) - (i5 ^ 25);
        N14263A23323 = i6 % 128;
        int i7 = i6 % 2;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (list.contains((String) next)) {
                int i8 = N14263A23323;
                int i9 = (i8 ^ 55) + ((i8 & 55) << 1);
                setTopP6481 = i9 % 128;
                if (i9 % 2 != 0) {
                    break;
                }
                int i10 = 60 / 0;
                break;
            }
        }
        String str = (String) next;
        if (str == null) {
            int i11 = setTopP6481;
            int i12 = (i11 & 71) + (i11 | 71);
            N14263A23323 = i12 % 128;
            int i13 = i12 % 2;
            return null;
        }
        int i14 = N14263A23323 + 89;
        setTopP6481 = i14 % 128;
        int i15 = i14 % 2;
        Location locationVD14832N6715 = k17305.vD14832N6715(str);
        int i16 = setTopP6481;
        int i17 = (i16 & 113) + (i16 | 113);
        N14263A23323 = i17 % 128;
        int i18 = i17 % 2;
        return locationVD14832N6715;
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.K17305$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/aq;", "Landroid/location/Location;", "", "setPivotYN16904", "(Lcom/fingerprintjs/android/fpjs_pro_internal/aq;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function1<aq<Location>, Unit> {
        private static int $component5 = 0;
        private static int $setPivotYN16904 = 1;
        private /* synthetic */ String $D8871;

        @Override // kotlin.jvm.functions.Function1
        public final /* synthetic */ Unit invoke(aq<Location> aqVar) {
            int i = 2 % 2;
            int i2 = $component5 + 17;
            $setPivotYN16904 = i2 % 128;
            int i3 = i2 % 2;
            Object obj = null;
            setPivotYN16904(aqVar);
            Unit unit = Unit.INSTANCE;
            if (i3 == 0) {
                obj.hashCode();
                throw null;
            }
            int i4 = $component5;
            int i5 = (i4 ^ 35) + ((i4 & 35) << 1);
            $setPivotYN16904 = i5 % 128;
            if (i5 % 2 != 0) {
                return unit;
            }
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void vD14832N6715(aq aqVar, CancellationSignal cancellationSignal, Location location) {
            int i = 2 % 2;
            int i2 = $component5 + 63;
            int i3 = i2 % 128;
            $setPivotYN16904 = i3;
            int i4 = i2 % 2;
            if (location != null) {
                int i5 = (i3 ^ 107) + ((i3 & 107) << 1);
                $component5 = i5 % 128;
                int i6 = i5 % 2;
                aqVar.vD14832N6715(location);
                cancellationSignal.cancel();
            }
            int i7 = $setPivotYN16904;
            int i8 = (i7 ^ 87) + ((i7 & 87) << 1);
            $component5 = i8 % 128;
            int i9 = i8 % 2;
        }

        public final void setPivotYN16904(final aq<Location> aqVar) {
            int i = 2 % 2;
            final CancellationSignal cancellationSignal = new CancellationSignal();
            Object[] objArr = {K17305.this};
            int iComponent9 = u.Companion.component9();
            LocationManager locationManager = (LocationManager) K17305.setPivotYN16904(u.Companion.component9(), objArr, -1803463134, 1803463136, u.Companion.component9(), iComponent9, u.Companion.component9());
            Intrinsics.checkNotNull(locationManager);
            String str = this.$D8871;
            Executor mainExecutor = ContextCompat.getMainExecutor(K17305.D8871(K17305.this));
            Intrinsics.checkNotNull(mainExecutor);
            locationManager.getCurrentLocation(str, cancellationSignal, mainExecutor, new Consumer() { // from class: com.fingerprintjs.android.fpjs_pro_internal.K17305$2$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    K17305.AnonymousClass2.vD14832N6715(aqVar, cancellationSignal, (Location) obj);
                }
            });
            int i2 = $component5 + 59;
            $setPivotYN16904 = i2 % 128;
            if (i2 % 2 != 0) {
                return;
            }
            Object obj = null;
            obj.hashCode();
            throw null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str) {
            super(1);
            this.$D8871 = str;
        }
    }

    private final Location vD14832N6715(String p0) {
        int i = 2 % 2;
        int i2 = setTopP6481 + 79;
        N14263A23323 = i2 % 128;
        int i3 = i2 % 2;
        LocationManager locationManager = this.setPivotYN16904;
        Intrinsics.checkNotNull(locationManager);
        Object obj = null;
        if (locationManager.isLocationEnabled()) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(p0);
            ar arVar = new ar();
            anonymousClass2.invoke(arVar);
            return (Location) arVar.component5(null);
        }
        int i4 = N14263A23323;
        int i5 = (i4 & 47) + (i4 | 47);
        int i6 = i5 % 128;
        setTopP6481 = i6;
        if (i5 % 2 == 0) {
            obj.hashCode();
            throw null;
        }
        int i7 = (i6 ^ 23) + ((i6 & 23) << 1);
        N14263A23323 = i7 % 128;
        if (i7 % 2 == 0) {
            return null;
        }
        obj.hashCode();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x006d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x006e, code lost:
    
        r0 = new com.fingerprintjs.android.fpjs_pro_internal.K17305.AnonymousClass1(r12);
        r12 = new com.fingerprintjs.android.fpjs_pro_internal.ar();
        r0.invoke(r12);
        r12 = (android.location.Location) r12.component5(null);
        r0 = com.fingerprintjs.android.fpjs_pro_internal.K17305.setTopP6481 + 65;
        com.fingerprintjs.android.fpjs_pro_internal.K17305.N14263A23323 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x008c, code lost:
    
        if ((r0 % 2) != 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x008e, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008f, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0092, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x003b, code lost:
    
        if (((java.lang.Boolean) setPivotYN16904(com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9(), new java.lang.Object[]{r12}, -840250983, 840250986, com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9(), r9, com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9())).booleanValue() == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0062, code lost:
    
        if (((java.lang.Boolean) setPivotYN16904(com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9(), new java.lang.Object[]{r12}, -840250983, 840250986, com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9(), r10, com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9())).booleanValue() == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0064, code lost:
    
        r12 = com.fingerprintjs.android.fpjs_pro_internal.K17305.setTopP6481 + 61;
        com.fingerprintjs.android.fpjs_pro_internal.K17305.N14263A23323 = r12 % 128;
        r12 = r12 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ java.lang.Object setPivotYN16904(java.lang.Object[] r12) {
        /*
            r0 = 0
            r12 = r12[r0]
            com.fingerprintjs.android.fpjs_pro_internal.K17305 r12 = (com.fingerprintjs.android.fpjs_pro_internal.K17305) r12
            r1 = 2
            int r2 = r1 % r1
            int r2 = com.fingerprintjs.android.fpjs_pro_internal.K17305.N14263A23323
            int r2 = r2 + 15
            int r3 = r2 % 128
            com.fingerprintjs.android.fpjs_pro_internal.K17305.setTopP6481 = r3
            int r2 = r2 % r1
            r3 = 0
            if (r2 != 0) goto L3e
            java.lang.Object[] r5 = new java.lang.Object[]{r12}
            int r9 = com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9()
            int r4 = com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9()
            int r10 = com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9()
            int r8 = com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9()
            r7 = 840250986(0x3215366a, float:8.685314E-9)
            r6 = -840250983(0xffffffffcdeac999, float:-4.9238506E8)
            java.lang.Object r2 = setPivotYN16904(r4, r5, r6, r7, r8, r9, r10)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r4 = 89
            int r4 = r4 / r0
            if (r2 != 0) goto L6e
            goto L64
        L3e:
            java.lang.Object[] r6 = new java.lang.Object[]{r12}
            int r10 = com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9()
            int r5 = com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9()
            int r11 = com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9()
            int r9 = com.fingerprintjs.android.fpjs_pro_internal.u.Companion.component9()
            r8 = 840250986(0x3215366a, float:8.685314E-9)
            r7 = -840250983(0xffffffffcdeac999, float:-4.9238506E8)
            java.lang.Object r0 = setPivotYN16904(r5, r6, r7, r8, r9, r10, r11)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L6e
        L64:
            int r12 = com.fingerprintjs.android.fpjs_pro_internal.K17305.setTopP6481
            int r12 = r12 + 61
            int r0 = r12 % 128
            com.fingerprintjs.android.fpjs_pro_internal.K17305.N14263A23323 = r0
            int r12 = r12 % r1
            return r3
        L6e:
            com.fingerprintjs.android.fpjs_pro_internal.K17305$1 r0 = new com.fingerprintjs.android.fpjs_pro_internal.K17305$1
            r0.<init>()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            com.fingerprintjs.android.fpjs_pro_internal.ar r12 = new com.fingerprintjs.android.fpjs_pro_internal.ar
            r12.<init>()
            r0.invoke(r12)
            java.lang.Object r12 = r12.component5(r3)
            android.location.Location r12 = (android.location.Location) r12
            int r0 = com.fingerprintjs.android.fpjs_pro_internal.K17305.setTopP6481
            int r0 = r0 + 65
            int r2 = r0 % 128
            com.fingerprintjs.android.fpjs_pro_internal.K17305.N14263A23323 = r2
            int r0 = r0 % r1
            if (r0 != 0) goto L8f
            return r12
        L8f:
            r3.hashCode()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.K17305.setPivotYN16904(java.lang.Object[]):java.lang.Object");
    }

    private static /* synthetic */ Object component5(Object[] objArr) {
        K17305 k17305 = (K17305) objArr[0];
        int i = 2 % 2;
        int i2 = setTopP6481;
        int i3 = (i2 ^ 63) + ((i2 & 63) << 1);
        N14263A23323 = i3 % 128;
        if (i3 % 2 != 0) {
            LocationManager locationManager = k17305.setPivotYN16904;
            Intrinsics.checkNotNull(locationManager);
            locationManager.isProviderEnabled("gps");
            Object obj = null;
            obj.hashCode();
            throw null;
        }
        LocationManager locationManager2 = k17305.setPivotYN16904;
        Intrinsics.checkNotNull(locationManager2);
        if (!locationManager2.isProviderEnabled("gps")) {
            LocationManager locationManager3 = k17305.setPivotYN16904;
            Intrinsics.checkNotNull(locationManager3);
            if (!locationManager3.isProviderEnabled("network")) {
                int i4 = N14263A23323 + 13;
                setTopP6481 = i4 % 128;
                if (i4 % 2 == 0) {
                    int i5 = 85 / 0;
                }
                return false;
            }
        }
        return true;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/K17305$component9;", "", "<init>", "()V", "", "", "D8871", "Ljava/util/List;", "component9"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class component9 {
        private static final byte[] $$a = null;
        private static final int $$b = 0;
        private static int $10;
        private static int $11;
        private static char[] component5;
        private static int component9;
        private static char vD14832N6715;

        /* JADX WARN: Code duplicated, block: B:10:0x0026  */
        /* JADX WARN: Code duplicated, block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private static java.lang.String $$c(byte r6, short r7, byte r8) {
            /*
                int r8 = r8 * 3
                int r0 = 1 - r8
                byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.K17305.component9.$$a
                int r7 = r7 + 67
                int r6 = r6 * 4
                int r6 = 3 - r6
                byte[] r0 = new byte[r0]
                r2 = 0
                int r8 = 0 - r8
                if (r1 != 0) goto L16
                r3 = r8
                r4 = r2
                goto L2b
            L16:
                r3 = r2
            L17:
                int r6 = r6 + 1
                byte r4 = (byte) r7
                r0[r3] = r4
                int r4 = r3 + 1
                if (r3 != r8) goto L26
                java.lang.String r6 = new java.lang.String
                r6.<init>(r0, r2)
                return r6
            L26:
                r3 = r1[r6]
                r5 = r3
                r3 = r7
                r7 = r5
            L2b:
                int r7 = -r7
                int r7 = r7 + r3
                r3 = r4
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.K17305.component9.$$c(byte, short, byte):java.lang.String");
        }

        static void init$0() {
            $$a = new byte[]{112, 83, 127, 40};
            $$b = 209;
        }

        private static void a(String str, int i, boolean z, int i2, int i3, Object[] objArr) throws Throwable {
            char[] charArray;
            int i4;
            int i5 = 2 % 2;
            if (str != null) {
                int i6 = $11 + 41;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                charArray = str.toCharArray();
            } else {
                charArray = str;
            }
            char[] cArr = charArray;
            cm cmVar = new cm();
            char[] cArr2 = new char[i2];
            cmVar.component9 = 0;
            while (cmVar.component9 < i2) {
                cmVar.setPivotYN16904 = cArr[cmVar.component9];
                cArr2[cmVar.component9] = (char) (i3 + cmVar.setPivotYN16904);
                int i8 = cmVar.component9;
                try {
                    Object[] objArr2 = {Integer.valueOf(cArr2[i8]), Integer.valueOf(component9)};
                    Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1226238903);
                    if (objComponent5 == null) {
                        i4 = -2009915307;
                        objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 49, (char) (35725 - (ViewConfiguration.getScrollBarSize() >> 8)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 2878, 463712212, false, $$c((byte) 0, (short) 53, (byte) 0), new Class[]{Integer.TYPE, Integer.TYPE});
                    } else {
                        i4 = -2009915307;
                    }
                    cArr2[i8] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                    Object[] objArr3 = {cmVar, cmVar};
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(i4);
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(69 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 19665), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)) + 1906, -628726730, false, "v", new Class[]{Object.class, Object.class});
                    }
                    ((Method) objComponent6).invoke(null, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if (i > 0) {
                cmVar.vD14832N6715 = i;
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                System.arraycopy(cArr3, 0, cArr2, i2 - cmVar.vD14832N6715, cmVar.vD14832N6715);
                System.arraycopy(cArr3, cmVar.vD14832N6715, cArr2, 0, i2 - cmVar.vD14832N6715);
            }
            if (z) {
                char[] cArr4 = new char[i2];
                cmVar.component9 = 0;
                while (cmVar.component9 < i2) {
                    int i9 = $11 + 99;
                    $10 = i9 % 128;
                    if (i9 % 2 != 0) {
                        cArr4[cmVar.component9] = cArr2[i2 - cmVar.component9];
                        Object[] objArr4 = {cmVar, cmVar};
                        Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-2009915307);
                        if (objComponent7 == null) {
                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(70 - KeyEvent.normalizeMetaState(0), (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 19666), 1906 - (ViewConfiguration.getJumpTapTimeout() >> 16), -628726730, false, "v", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objComponent7).invoke(null, objArr4);
                    } else {
                        cArr4[cmVar.component9] = cArr2[(i2 - cmVar.component9) - 1];
                        Object[] objArr5 = {cmVar, cmVar};
                        Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(-2009915307);
                        if (objComponent8 == null) {
                            objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 71, (char) (19666 - (ViewConfiguration.getPressedStateDuration() >> 16)), Color.blue(0) + 1906, -628726730, false, "v", new Class[]{Object.class, Object.class});
                        }
                        ((Method) objComponent8).invoke(null, objArr5);
                    }
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        }

        private component9() {
        }

        private static void b(byte b, int i, String str, Object[] objArr) throws Throwable {
            int i2;
            char c = 2;
            int i3 = 2 % 2;
            int i4 = $10 + 69;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            char[] charArray = str != null ? str.toCharArray() : str;
            ce ceVar = new ce();
            char[] cArr = component5;
            long j = 0;
            char c2 = '\b';
            if (cArr != null) {
                int length = cArr.length;
                char[] cArr2 = new char[length];
                int i6 = 0;
                while (i6 < length) {
                    try {
                        Object[] objArr2 = {Integer.valueOf(cArr[i6])};
                        Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1083735746);
                        if (objComponent5 == null) {
                            objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 52, (char) (8066 - (Process.getElapsedCpuTime() > j ? 1 : (Process.getElapsedCpuTime() == j ? 0 : -1))), (ViewConfiguration.getWindowTouchSlop() >> 8) + 3217, 304954017, false, $$c((byte) 0, (short) 50, (byte) 0), new Class[]{Integer.TYPE});
                        }
                        cArr2[i6] = ((Character) ((Method) objComponent5).invoke(null, objArr2)).charValue();
                        i6++;
                        c = c;
                        j = j;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                cArr = cArr2;
            }
            char c3 = c;
            long j2 = j;
            Object[] objArr3 = {Integer.valueOf(vD14832N6715)};
            Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1083735746);
            if (objComponent6 == null) {
                objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (char) ((Process.myPid() >> 22) + 8065), 3216 - ExpandableListView.getPackedPositionChild(j2), 304954017, false, $$c((byte) 0, (short) 50, (byte) 0), new Class[]{Integer.TYPE});
            }
            char cCharValue = ((Character) ((Method) objComponent6).invoke(null, objArr3)).charValue();
            char[] cArr3 = new char[i];
            if (i % 2 != 0) {
                i2 = i - 1;
                cArr3[i2] = (char) (charArray[i2] - b);
            } else {
                i2 = i;
            }
            int i7 = 1;
            if (i2 > 1) {
                ceVar.component5 = 0;
                while (ceVar.component5 < i2) {
                    ceVar.D8871 = charArray[ceVar.component5];
                    ceVar.setPivotYN16904 = charArray[ceVar.component5 + i7];
                    if (ceVar.D8871 == ceVar.setPivotYN16904) {
                        cArr3[ceVar.component5] = (char) (ceVar.D8871 - b);
                        cArr3[ceVar.component5 + i7] = (char) (ceVar.setPivotYN16904 - b);
                        i7 = i7;
                        c2 = c2;
                    } else {
                        Object[] objArr4 = new Object[13];
                        objArr4[12] = ceVar;
                        objArr4[11] = Integer.valueOf(cCharValue);
                        objArr4[10] = ceVar;
                        objArr4[9] = ceVar;
                        objArr4[c2] = Integer.valueOf(cCharValue);
                        objArr4[7] = ceVar;
                        objArr4[6] = ceVar;
                        objArr4[5] = Integer.valueOf(cCharValue);
                        objArr4[4] = ceVar;
                        objArr4[3] = ceVar;
                        objArr4[c3] = Integer.valueOf(cCharValue);
                        objArr4[i7] = ceVar;
                        objArr4[0] = ceVar;
                        Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(1087197054);
                        if (objComponent7 == null) {
                            objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (KeyEvent.getMaxKeyCode() >> 16), (char) (47645 - Color.blue(0)), 5214 - ((Process.getThreadPriority(0) + 20) >> 6), 309857053, false, $$c((byte) 0, (short) 54, (byte) 0), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                        }
                        if (((Integer) ((Method) objComponent7).invoke(null, objArr4)).intValue() == ceVar.component13) {
                            Object[] objArr5 = new Object[11];
                            objArr5[10] = ceVar;
                            objArr5[9] = Integer.valueOf(cCharValue);
                            objArr5[c2] = ceVar;
                            objArr5[7] = Integer.valueOf(cCharValue);
                            objArr5[6] = Integer.valueOf(cCharValue);
                            objArr5[5] = ceVar;
                            objArr5[4] = ceVar;
                            objArr5[3] = Integer.valueOf(cCharValue);
                            objArr5[c3] = Integer.valueOf(cCharValue);
                            objArr5[i7] = ceVar;
                            objArr5[0] = ceVar;
                            Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1764120300);
                            if (objComponent8 == null) {
                                objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) Color.blue(0), 5575 - ((byte) KeyEvent.getModifierMetaStateMask()), 999494287, false, $$c((byte) 0, (short) 0, (byte) 0), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                            }
                            int iIntValue = ((Integer) ((Method) objComponent8).invoke(null, objArr5)).intValue();
                            int i8 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                            cArr3[ceVar.component5] = cArr[iIntValue];
                            cArr3[ceVar.component5 + 1] = cArr[i8];
                        } else if (ceVar.component9 == ceVar.vD14832N6715) {
                            ceVar.N14263A23323 = ((ceVar.N14263A23323 + cCharValue) - 1) % cCharValue;
                            ceVar.component13 = ((ceVar.component13 + cCharValue) - 1) % cCharValue;
                            int i9 = (ceVar.component9 * cCharValue) + ceVar.N14263A23323;
                            int i10 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                            cArr3[ceVar.component5] = cArr[i9];
                            cArr3[ceVar.component5 + 1] = cArr[i10];
                        } else {
                            int i11 = (ceVar.component9 * cCharValue) + ceVar.component13;
                            int i12 = (ceVar.vD14832N6715 * cCharValue) + ceVar.N14263A23323;
                            cArr3[ceVar.component5] = cArr[i11];
                            cArr3[ceVar.component5 + 1] = cArr[i12];
                        }
                    }
                    ceVar.component5 += 2;
                    i7 = i7;
                    c2 = c2;
                }
            }
            int i13 = $11 + 99;
            $10 = i13 % 128;
            int i14 = i13 % 2;
            for (int i15 = 0; i15 < i; i15++) {
                cArr3[i15] = (char) (cArr3[i15] ^ 13722);
            }
            objArr[0] = new String(cArr3);
        }

        static {
            init$0();
            $10 = 0;
            $11 = 1;
            component9 = 1125199061;
            component5 = new char[]{15000, 14995, 15057, 15004, 15051, 14981, 15054, 15101, 15044, 15078, 14987, 15088, 15069, 14989, 15043, 15048, 15082, 14985, 15083, 14994, 15061, 14996, 15052, 15041, 15073, 14997, 14992, 14999, 15075, 14998, 15046, 15094, 15062, 14991, 15093, 15049, 14990, 15050, 15047, 14993, 15055, 15042, 15056, 15040, 15076, 15080, 15059, 15068, 15063};
            vD14832N6715 = (char) 3896;
        }

        /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
            java.util.NoSuchElementException
            	at java.base/java.util.TreeMap.key(TreeMap.java:1637)
            	at java.base/java.util.TreeMap.lastKey(TreeMap.java:309)
            	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
            	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
            	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
            */
        public static java.lang.Object[] D8871(android.content.Context r32, int r33, int r34) {
            /*
                Method dump skipped, instruction units count: 2973
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.K17305.component9.D8871(android.content.Context, int, int):java.lang.Object[]");
        }

        public /* synthetic */ component9(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.K17305$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/aq;", "Landroid/location/Location;", "", "vD14832N6715", "(Lcom/fingerprintjs/android/fpjs_pro_internal/aq;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass3 extends Lambda implements Function1<aq<Location>, Unit> {
        private static int $component5 = 1;
        private static int $component9;
        private /* synthetic */ FusedLocationProviderClient $D8871;

        public static /* synthetic */ Object setPivotYN16904(int i, int i2, int i3, int i4, Object[] objArr, int i5, int i6) {
            int i7 = ~i2;
            int i8 = ~(i7 | i6);
            int i9 = ~i3;
            int i10 = (~(i9 | i2)) | i8;
            int i11 = ~i6;
            int i12 = i11 | i2;
            int i13 = i10 | (~i12);
            int i14 = i7 | i3;
            int i15 = i8 | (~i14);
            int i16 = (~(i6 | i14)) | (~(i7 | i9 | i11)) | (~(i12 | i3));
            int i17 = i2 + i3 + i4 + ((-1254723898) * i5) + ((-1667789834) * i);
            int i18 = i17 * i17;
            int i19 = ((-534547663) * i2) + 1379663872 + ((-481802647) * i3) + ((-17581672) * i13) + (35163344 * i15) + (17581672 * i16) + ((-499384320) * i4) + ((-1033371648) * i5) + ((-106430464) * i) + (1552875520 * i18);
            int i20 = ((i2 * (-402395399)) - 1316031342) + (i3 * (-402392591)) + (i13 * (-936)) + (i15 * 1872) + (i16 * 936) + (i4 * (-402393527)) + (i5 * (-1219896714)) + (i * (-610841306)) + (i18 * (-825819136));
            return i19 + ((i20 * i20) * (-1063190528)) != 1 ? component9(objArr) : D8871(objArr);
        }

        private static /* synthetic */ Object D8871(Object[] objArr) {
            AnonymousClass3 anonymousClass3 = (AnonymousClass3) objArr[0];
            Object obj = objArr[1];
            int i = 2 % 2;
            int i2 = $component5;
            int i3 = (i2 & 53) + (i2 | 53);
            $component9 = i3 % 128;
            int i4 = i3 % 2;
            Object[] objArr2 = {anonymousClass3, (aq) obj};
            int iD8871 = bm.D8871();
            int iD8872 = bm.D8871();
            int iD8873 = bm.D8871();
            int iD8874 = bm.D8871();
            if (i4 == 0) {
                setPivotYN16904(iD8874, -2038390584, 2038390584, iD8872, objArr2, iD8873, iD8871);
                return Unit.INSTANCE;
            }
            setPivotYN16904(iD8874, -2038390584, 2038390584, iD8872, objArr2, iD8873, iD8871);
            int i5 = 86 / 0;
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void component5(Function1 function1, Object obj) {
            int i = 2 % 2;
            int i2 = $component9;
            int i3 = (i2 & 97) + (i2 | 97);
            $component5 = i3 % 128;
            int i4 = i3 % 2;
            function1.invoke(obj);
            if (i4 == 0) {
                int i5 = 71 / 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setPivotYN16904(aq aqVar, Exception exc) {
            int i = 2 % 2;
            int i2 = $component9 + 37;
            $component5 = i2 % 128;
            int i3 = i2 % 2;
            aqVar.vD14832N6715(null);
            if (i3 == 0) {
                int i4 = 31 / 0;
            }
            int i5 = $component5;
            int i6 = ((i5 | 15) << 1) - (i5 ^ 15);
            $component9 = i6 % 128;
            if (i6 % 2 != 0) {
                int i7 = 63 / 0;
            }
        }

        private static /* synthetic */ Object component9(Object[] objArr) {
            AnonymousClass3 anonymousClass3 = (AnonymousClass3) objArr[0];
            final aq aqVar = (aq) objArr[1];
            int i = 2 % 2;
            FusedLocationProviderClient fusedLocationProviderClient = anonymousClass3.$D8871;
            Intrinsics.checkNotNull(fusedLocationProviderClient);
            Task<Location> lastLocation = fusedLocationProviderClient.getLastLocation();
            Intrinsics.checkNotNull(lastLocation);
            final Function1<Location, Unit> function1 = new Function1<Location, Unit>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.K17305.3.5
                private static final byte[] $$a = null;
                private static final int $$b = 0;
                private static int $10;
                private static int $11;
                private static int $D8871;
                private static int $component5;
                private static char[] setPivotYN16904;
                private static char vD14832N6715;

                private static String $$c(int i2, short s, int i3) {
                    int i4 = 121 - (i3 * 2);
                    byte[] bArr = $$a;
                    int i5 = s * 4;
                    int i6 = 4 - (i2 * 4);
                    byte[] bArr2 = new byte[1 - i5];
                    int i7 = 0 - i5;
                    int i8 = -1;
                    if (bArr == null) {
                        i6++;
                        i4 += i7;
                    }
                    while (true) {
                        i8++;
                        bArr2[i8] = (byte) i4;
                        if (i8 == i7) {
                            return new String(bArr2, 0);
                        }
                        int i9 = bArr[i6];
                        i6++;
                        i4 += i9;
                    }
                }

                static void init$0() {
                    $$a = new byte[]{60, -23, -65, -5};
                    $$b = 138;
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Location location) {
                    int i2 = 2 % 2;
                    int i3 = $D8871 + 79;
                    $component5 = i3 % 128;
                    int i4 = i3 % 2;
                    vD14832N6715(location);
                    Unit unit = Unit.INSTANCE;
                    if (i4 != 0) {
                        int i5 = 5 / 0;
                    }
                    return unit;
                }

                public final void vD14832N6715(Location location) {
                    int i2 = 2 % 2;
                    int i3 = $D8871 + 79;
                    $component5 = i3 % 128;
                    int i4 = i3 % 2;
                    aqVar.vD14832N6715(location);
                    int i5 = $component5 + GapComposerKt.nodeKey;
                    $D8871 = i5 % 128;
                    if (i5 % 2 == 0) {
                        int i6 = 23 / 0;
                    }
                }

                private static void a(byte b, int i2, String str, Object[] objArr2) throws Throwable {
                    int i3;
                    long j;
                    int length;
                    char[] cArr;
                    char c = 2;
                    int i4 = 2 % 2;
                    int i5 = $10 + 55;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    char[] charArray = str != null ? str.toCharArray() : str;
                    ce ceVar = new ce();
                    char[] cArr2 = setPivotYN16904;
                    if (cArr2 != null) {
                        int i7 = $11 + 53;
                        $10 = i7 % 128;
                        if (i7 % 2 != 0) {
                            length = cArr2.length;
                            cArr = new char[length];
                        } else {
                            length = cArr2.length;
                            cArr = new char[length];
                        }
                        for (int i8 = 0; i8 < length; i8++) {
                            int i9 = $11 + 61;
                            $10 = i9 % 128;
                            int i10 = i9 % 2;
                            try {
                                Object[] objArr3 = {Integer.valueOf(cArr2[i8])};
                                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(1083735746);
                                if (objComponent5 == null) {
                                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(Color.red(0) + 52, (char) (8065 - Color.argb(0, 0, 0, 0)), 3217 - Color.red(0), 304954017, false, $$c(0, (short) 0, 2), new Class[]{Integer.TYPE});
                                }
                                cArr[i8] = ((Character) ((Method) objComponent5).invoke(null, objArr3)).charValue();
                            } catch (Throwable th) {
                                Throwable cause = th.getCause();
                                if (cause == null) {
                                    throw th;
                                }
                                throw cause;
                            }
                        }
                        cArr2 = cArr;
                    }
                    Object[] objArr4 = {Integer.valueOf(vD14832N6715)};
                    Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(1083735746);
                    long j2 = 0;
                    char c2 = '\b';
                    if (objComponent6 == null) {
                        objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(53 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (8065 - (ViewConfiguration.getWindowTouchSlop() >> 8)), Process.getGidForName("") + 3218, 304954017, false, $$c(0, (short) 0, 2), new Class[]{Integer.TYPE});
                    }
                    char cCharValue = ((Character) ((Method) objComponent6).invoke(null, objArr4)).charValue();
                    char[] cArr3 = new char[i2];
                    if (i2 % 2 != 0) {
                        i3 = i2 - 1;
                        cArr3[i3] = (char) (charArray[i3] - b);
                    } else {
                        i3 = i2;
                    }
                    if (i3 > 1) {
                        ceVar.component5 = 0;
                        while (ceVar.component5 < i3) {
                            ceVar.D8871 = charArray[ceVar.component5];
                            ceVar.setPivotYN16904 = charArray[ceVar.component5 + 1];
                            char c3 = c;
                            if (ceVar.D8871 == ceVar.setPivotYN16904) {
                                cArr3[ceVar.component5] = (char) (ceVar.D8871 - b);
                                cArr3[ceVar.component5 + 1] = (char) (ceVar.setPivotYN16904 - b);
                                int i11 = $10 + 83;
                                $11 = i11 % 128;
                                int i12 = i11 % 2;
                                j = j2;
                                c2 = c2;
                            } else {
                                Object[] objArr5 = new Object[13];
                                objArr5[12] = ceVar;
                                j = j2;
                                objArr5[11] = Integer.valueOf(cCharValue);
                                objArr5[10] = ceVar;
                                objArr5[9] = ceVar;
                                objArr5[c2] = Integer.valueOf(cCharValue);
                                objArr5[7] = ceVar;
                                objArr5[6] = ceVar;
                                objArr5[5] = Integer.valueOf(cCharValue);
                                objArr5[4] = ceVar;
                                objArr5[3] = ceVar;
                                objArr5[c3] = Integer.valueOf(cCharValue);
                                objArr5[1] = ceVar;
                                objArr5[0] = ceVar;
                                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(1087197054);
                                if (objComponent7 == null) {
                                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (View.resolveSize(0, 0) + 47645), 5214 - (Process.myTid() >> 22), 309857053, false, $$c(0, (short) 0, 0), new Class[]{Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Object.class});
                                }
                                if (((Integer) ((Method) objComponent7).invoke(null, objArr5)).intValue() == ceVar.component13) {
                                    int i13 = $11 + 15;
                                    $10 = i13 % 128;
                                    int i14 = i13 % 2;
                                    Object[] objArr6 = new Object[11];
                                    objArr6[10] = ceVar;
                                    objArr6[9] = Integer.valueOf(cCharValue);
                                    objArr6[c2] = ceVar;
                                    objArr6[7] = Integer.valueOf(cCharValue);
                                    objArr6[6] = Integer.valueOf(cCharValue);
                                    objArr6[5] = ceVar;
                                    objArr6[4] = ceVar;
                                    objArr6[3] = Integer.valueOf(cCharValue);
                                    objArr6[c3] = Integer.valueOf(cCharValue);
                                    objArr6[1] = ceVar;
                                    objArr6[0] = ceVar;
                                    Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1764120300);
                                    if (objComponent8 == null) {
                                        objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(52 - TextUtils.indexOf("", ""), (char) (MotionEvent.axisFromString("") + 1), (SystemClock.elapsedRealtimeNanos() > j ? 1 : (SystemClock.elapsedRealtimeNanos() == j ? 0 : -1)) + 5575, 999494287, false, $$c(0, (short) 0, 27), new Class[]{Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Object.class, Integer.TYPE, Integer.TYPE, Object.class, Integer.TYPE, Object.class});
                                    }
                                    int iIntValue = ((Integer) ((Method) objComponent8).invoke(null, objArr6)).intValue();
                                    int i15 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                                    cArr3[ceVar.component5] = cArr2[iIntValue];
                                    cArr3[ceVar.component5 + 1] = cArr2[i15];
                                } else if (ceVar.component9 == ceVar.vD14832N6715) {
                                    int i16 = $10 + 55;
                                    $11 = i16 % 128;
                                    int i17 = i16 % 2;
                                    ceVar.N14263A23323 = ((ceVar.N14263A23323 + cCharValue) - 1) % cCharValue;
                                    ceVar.component13 = ((ceVar.component13 + cCharValue) - 1) % cCharValue;
                                    int i18 = (ceVar.component9 * cCharValue) + ceVar.N14263A23323;
                                    int i19 = (ceVar.vD14832N6715 * cCharValue) + ceVar.component13;
                                    cArr3[ceVar.component5] = cArr2[i18];
                                    cArr3[ceVar.component5 + 1] = cArr2[i19];
                                } else {
                                    int i20 = (ceVar.component9 * cCharValue) + ceVar.component13;
                                    int i21 = (ceVar.vD14832N6715 * cCharValue) + ceVar.N14263A23323;
                                    cArr3[ceVar.component5] = cArr2[i20];
                                    cArr3[ceVar.component5 + 1] = cArr2[i21];
                                }
                            }
                            ceVar.component5 += 2;
                            c = c3;
                            j2 = j;
                            c2 = c2;
                        }
                    }
                    for (int i22 = 0; i22 < i2; i22++) {
                        cArr3[i22] = (char) (cArr3[i22] ^ 13722);
                    }
                    objArr2[0] = new String(cArr3);
                }

                public static void D8871(long j, long j2) throws Throwable {
                    int i2 = 2 % 2;
                    int i3 = $component5 + 3;
                    $D8871 = i3 % 128;
                    int i4 = i3 % 2;
                    long j3 = j ^ (j2 << 32);
                    u.class.getField("vD14832N6715").get(null);
                    int i5 = $component5 + 45;
                    int i6 = i5 % 128;
                    $D8871 = i6;
                    int i7 = i5 % 2;
                    int i8 = i6 + 93;
                    $component5 = i8 % 128;
                    int i9 = i8 % 2;
                    try {
                        Object[] objArr2 = {Long.valueOf(j3)};
                        Object[] objArr3 = new Object[1];
                        a((byte) (7 - Color.blue(0)), (ViewConfiguration.getEdgeSlop() >> 16) + 7, "\u0000\u0005\u000b\u000e\u0004\u0002㘃", objArr3);
                        Method method = Long.class.getMethod((String) objArr3[0], Long.TYPE);
                        method.setAccessible(true);
                        Object objInvoke = method.invoke(null, objArr2);
                        Object obj = w.class.getField("INSTANCE").get(null);
                        Method method2 = w.class.getMethod("D8871", null);
                        method2.setAccessible(true);
                        Object objInvoke2 = method2.invoke(obj, null);
                        Object[] objArr4 = new Object[1];
                        a((byte) (64 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), Color.red(0) + 3, "\u000f\u0005㗮", objArr4);
                        Object[] objArr5 = {(String) objArr4[0], objInvoke};
                        Object[] objArr6 = new Object[1];
                        a((byte) (Color.alpha(0) + 77), 3 - KeyEvent.normalizeMetaState(0), "\u000f\u0003㘻", objArr6);
                        Method method3 = Map.class.getMethod((String) objArr6[0], Object.class, Object.class);
                        method3.setAccessible(true);
                        method3.invoke(objInvoke2, objArr5);
                        int i10 = $component5 + 99;
                        $D8871 = i10 % 128;
                        int i11 = i10 % 2;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }

                static {
                    init$0();
                    $10 = 0;
                    $11 = 1;
                    $component5 = 0;
                    $D8871 = 1;
                    setPivotYN16904 = new char[]{15082, 15059, 15080, 15081, 15044, 15057, 15040, 14998, 15079, 14994, 15049, 15061, 15043, 14999, 15078, 15056};
                    vD14832N6715 = (char) 3899;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }
            };
            lastLocation.addOnSuccessListener(new OnSuccessListener() { // from class: com.fingerprintjs.android.fpjs_pro_internal.K17305$3$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    K17305.AnonymousClass3.component5(function1, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.fingerprintjs.android.fpjs_pro_internal.K17305$3$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    K17305.AnonymousClass3.setPivotYN16904(aqVar, exc);
                }
            });
            int i2 = $component5;
            int i3 = (i2 & 115) + (i2 | 115);
            $component9 = i3 % 128;
            Object obj = null;
            if (i3 % 2 == 0) {
                return null;
            }
            obj.hashCode();
            throw null;
        }

        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, kotlin.Unit] */
        @Override // kotlin.jvm.functions.Function1
        public final /* synthetic */ Unit invoke(aq<Location> aqVar) {
            int iD8871 = bm.D8871();
            int iD8872 = bm.D8871();
            int iD8873 = bm.D8871();
            ?? pivotYN16904 = setPivotYN16904(bm.D8871(), 913592434, -913592433, iD8872, new Object[]{this, aqVar}, iD8873, iD8871);
            return pivotYN16904;
        }

        public final void vD14832N6715(aq<Location> aqVar) {
            int iD8871 = bm.D8871();
            int iD8872 = bm.D8871();
            int iD8873 = bm.D8871();
            setPivotYN16904(bm.D8871(), -2038390584, 2038390584, iD8872, new Object[]{this, aqVar}, iD8873, iD8871);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(FusedLocationProviderClient fusedLocationProviderClient) {
            super(1);
            this.$D8871 = fusedLocationProviderClient;
        }
    }

    public final Location component5() {
        int i = 2 % 2;
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.D8871);
        Intrinsics.checkNotNull(fusedLocationProviderClient);
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(fusedLocationProviderClient);
        ar arVar = new ar();
        anonymousClass3.invoke(arVar);
        Object obj = null;
        Location location = (Location) arVar.component5(null);
        int i2 = N14263A23323 + 113;
        setTopP6481 = i2 % 128;
        if (i2 % 2 != 0) {
            return location;
        }
        obj.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: com.fingerprintjs.android.fpjs_pro_internal.K17305$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/aq;", "Landroid/location/Location;", "", "component5", "(Lcom/fingerprintjs/android/fpjs_pro_internal/aq;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass5 extends Lambda implements Function1<aq<Location>, Unit> {
        private static int $setPivotYN16904 = 1;
        private static int $vD14832N6715;
        private /* synthetic */ FusedLocationProviderClient $D8871;
        private /* synthetic */ CurrentLocationRequest $component5;

        public static /* synthetic */ Object component5(int i, int i2, int i3, int i4, Object[] objArr, int i5, int i6) {
            int i7 = ~(i5 | i);
            int i8 = ~i5;
            int i9 = ~i;
            int i10 = i8 | i9;
            int i11 = i7 | (~(i10 | i3));
            int i12 = i9 | i5;
            int i13 = (~i10) | i3;
            int i14 = i3 + i5 + i6 + ((-1587644119) * i4) + (1302866265 * i2);
            int i15 = i14 * i14;
            int i16 = (i3 * (-1579585154)) + 1163788288 + ((-1579585154) * i5) + ((-914001539) * i11) + (i12 * 914001539) + (914001539 * i13) + ((-665583616) * i6) + (1500774400 * i4) + ((-1456209920) * i2) + ((-2144468992) * i15);
            int i17 = ((i3 * (-855313886)) - 1253577507) + (i5 * (-855313886)) + (i11 * (-13)) + (i12 * 13) + (i13 * 13) + (i6 * (-855313873)) + (i4 * (-1467678585)) + (i2 * 593082711) + (i15 * 74579968);
            if (i16 + (i17 * i17 * (-1668153344)) == 1) {
                return D8871(objArr);
            }
            aq aqVar = (aq) objArr[0];
            int i18 = 2 % 2;
            int i19 = $vD14832N6715 + 65;
            $setPivotYN16904 = i19 % 128;
            int i20 = i19 % 2;
            aqVar.vD14832N6715(null);
            int i21 = $vD14832N6715;
            int i22 = ((i21 | 93) << 1) - (i21 ^ 93);
            $setPivotYN16904 = i22 % 128;
            int i23 = i22 % 2;
            return null;
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* synthetic */ Unit invoke(aq<Location> aqVar) {
            int i = 2 % 2;
            int i2 = $setPivotYN16904;
            int i3 = ((i2 | 49) << 1) - (i2 ^ 49);
            $vD14832N6715 = i3 % 128;
            int i4 = i3 % 2;
            component5(aqVar);
            Unit unit = Unit.INSTANCE;
            if (i4 != 0) {
                Object obj = null;
                obj.hashCode();
                throw null;
            }
            int i5 = $setPivotYN16904;
            int i6 = (i5 & 45) + (i5 | 45);
            $vD14832N6715 = i6 % 128;
            if (i6 % 2 != 0) {
                int i7 = 43 / 0;
            }
            return unit;
        }

        private static /* synthetic */ Object D8871(Object[] objArr) {
            Function1 function1 = (Function1) objArr[0];
            Object obj = objArr[1];
            int i = 2 % 2;
            int i2 = $setPivotYN16904 + 41;
            $vD14832N6715 = i2 % 128;
            int i3 = i2 % 2;
            function1.invoke(obj);
            if (i3 != 0) {
                throw null;
            }
            int i4 = $setPivotYN16904;
            int i5 = (i4 ^ AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) + ((i4 & AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY) << 1);
            $vD14832N6715 = i5 % 128;
            int i6 = i5 % 2;
            return null;
        }

        public final void component5(final aq<Location> aqVar) {
            int i = 2 % 2;
            FusedLocationProviderClient fusedLocationProviderClient = this.$D8871;
            Intrinsics.checkNotNull(fusedLocationProviderClient);
            Task<Location> currentLocation = fusedLocationProviderClient.getCurrentLocation(this.$component5, (CancellationToken) null);
            Intrinsics.checkNotNull(currentLocation);
            final Function1<Location, Unit> function1 = new Function1<Location, Unit>() { // from class: com.fingerprintjs.android.fpjs_pro_internal.K17305.5.1
                private static int $D8871 = 1;
                private static int $setPivotYN16904;

                public final void component9(Location location) {
                    int i2 = 2 % 2;
                    int i3 = $setPivotYN16904;
                    int i4 = (i3 ^ 47) + ((i3 & 47) << 1);
                    $D8871 = i4 % 128;
                    int i5 = i4 % 2;
                    aqVar.vD14832N6715(location);
                    if (i5 == 0) {
                        throw null;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Location location) {
                    int i2 = 2 % 2;
                    int i3 = $setPivotYN16904;
                    int i4 = (i3 & 69) + (i3 | 69);
                    $D8871 = i4 % 128;
                    int i5 = i4 % 2;
                    component9(location);
                    Unit unit = Unit.INSTANCE;
                    int i6 = $setPivotYN16904 + 117;
                    $D8871 = i6 % 128;
                    int i7 = i6 % 2;
                    return unit;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }
            };
            currentLocation.addOnSuccessListener(new OnSuccessListener() { // from class: com.fingerprintjs.android.fpjs_pro_internal.K17305$5$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    K17305.AnonymousClass5.component5(function1, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.fingerprintjs.android.fpjs_pro_internal.K17305$5$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    K17305.AnonymousClass5.setPivotYN16904(aqVar, exc);
                }
            });
            int i2 = $vD14832N6715;
            int i3 = ((i2 | 35) << 1) - (i2 ^ 35);
            $setPivotYN16904 = i3 % 128;
            int i4 = i3 % 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setPivotYN16904(aq aqVar, Exception exc) {
            int iVD14832N6715 = N10124.vD14832N6715();
            int iVD14832N6716 = N10124.vD14832N6715();
            int iVD14832N6717 = N10124.vD14832N6715();
            component5(iVD14832N6715, N10124.vD14832N6715(), 1097583947, iVD14832N6717, new Object[]{aqVar, exc}, -1097583947, iVD14832N6716);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void component5(Function1 function1, Object obj) {
            int iVD14832N6715 = N10124.vD14832N6715();
            int iVD14832N6716 = N10124.vD14832N6715();
            int iVD14832N6717 = N10124.vD14832N6715();
            component5(iVD14832N6715, N10124.vD14832N6715(), -887944494, iVD14832N6717, new Object[]{function1, obj}, 887944495, iVD14832N6716);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(FusedLocationProviderClient fusedLocationProviderClient, CurrentLocationRequest currentLocationRequest) {
            super(1);
            this.$D8871 = fusedLocationProviderClient;
            this.$component5 = currentLocationRequest;
        }
    }

    public final Location component9(long p0) {
        int i = 2 % 2;
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.D8871);
        Intrinsics.checkNotNull(fusedLocationProviderClient);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(fusedLocationProviderClient, new CurrentLocationRequest.Builder().setPriority(100).setDurationMillis(p0).build());
        ar arVar = new ar();
        anonymousClass5.invoke(arVar);
        Location location = (Location) arVar.component5(null);
        int i2 = setTopP6481 + 87;
        N14263A23323 = i2 % 128;
        int i3 = i2 % 2;
        return location;
    }

    static {
        int i = component8;
        int i2 = (i ^ 113) + ((i & 113) << 1);
        component13 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    public static final /* synthetic */ LocationManager vD14832N6715(K17305 k17305) {
        int iComponent9 = u.Companion.component9();
        return (LocationManager) setPivotYN16904(u.Companion.component9(), new Object[]{k17305}, -1803463134, 1803463136, u.Companion.component9(), iComponent9, u.Companion.component9());
    }

    private final boolean setTopP6481() {
        int iComponent9 = u.Companion.component9();
        return ((Boolean) setPivotYN16904(u.Companion.component9(), new Object[]{this}, -840250983, 840250986, u.Companion.component9(), iComponent9, u.Companion.component9())).booleanValue();
    }

    private final Location component13() {
        int iComponent9 = u.Companion.component9();
        return (Location) setPivotYN16904(u.Companion.component9(), new Object[]{this}, -1945567960, 1945567961, u.Companion.component9(), iComponent9, u.Companion.component9());
    }

    private final Location setPivotYN16904() {
        int iComponent9 = u.Companion.component9();
        return (Location) setPivotYN16904(u.Companion.component9(), new Object[]{this}, -1294440118, 1294440122, u.Companion.component9(), iComponent9, u.Companion.component9());
    }

    public final List<String> D8871() {
        int iComponent9 = u.Companion.component9();
        return (List) setPivotYN16904(u.Companion.component9(), new Object[]{this}, -92254710, 92254715, u.Companion.component9(), iComponent9, u.Companion.component9());
    }

    public static boolean component9() {
        int iComponent9 = u.Companion.component9();
        return ((Boolean) setPivotYN16904(u.Companion.component9(), new Object[0], 1033814136, -1033814136, u.Companion.component9(), iComponent9, u.Companion.component9())).booleanValue();
    }
}
