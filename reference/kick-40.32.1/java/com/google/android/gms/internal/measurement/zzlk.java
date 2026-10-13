package com.google.android.gms.internal.measurement;

import android.content.Context;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzlk {
    public static final /* synthetic */ int zza = 0;
    private static final Object zzb = new Object();
    private static final AtomicReference zzc = new AtomicReference();
    private static volatile zzlk zzd = null;
    private static volatile zzlk zze = null;
    private static final Supplier zzf = Suppliers.memoize(zzlp.zza);
    private final zzoh zzg = new zzol();
    private final Context zzh;
    private final Supplier zzi;
    private final Supplier zzj;
    private final Supplier zzk;
    private final Supplier zzl;
    private final zzrf zzm;
    private final Supplier zzn;
    private final zzqe zzo;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
    public interface zza {
        Optional zza();
    }

    /* synthetic */ zzlk(Context context, Supplier supplier, Supplier supplier2, final Supplier supplier3, Supplier supplier4, Supplier supplier5, byte[] bArr) {
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(supplier2);
        Preconditions.checkNotNull(supplier3);
        Preconditions.checkNotNull(supplier4);
        Preconditions.checkNotNull(supplier5);
        Supplier supplierMemoize = Suppliers.memoize(supplier);
        Supplier supplierMemoize2 = Suppliers.memoize(supplier2);
        Supplier supplierMemoize3 = Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzlq
            @Override // com.google.common.base.Supplier
            public final /* synthetic */ Object get() {
                int i = zzlk.zza;
                return (zzqm) ((Optional) supplier3.get()).orNull();
            }
        });
        Supplier supplierMemoize4 = Suppliers.memoize(supplier4);
        Supplier supplierMemoize5 = Suppliers.memoize(supplier5);
        this.zzh = applicationContext;
        this.zzi = supplierMemoize;
        this.zzj = supplierMemoize2;
        this.zzk = supplierMemoize3;
        this.zzl = supplierMemoize4;
        this.zzm = new zzrf(applicationContext, supplierMemoize, supplierMemoize4, supplierMemoize2);
        this.zzn = supplierMemoize5;
        this.zzo = new zzqe(applicationContext, supplierMemoize, supplierMemoize3, supplierMemoize2);
    }

    public static void zza(Context context) {
        Context applicationContext;
        if (zzc.get() != null) {
            return;
        }
        try {
            applicationContext = context.getApplicationContext();
        } catch (NullPointerException unused) {
            zzl();
            zzlz.zza(Level.WARNING, (Executor) zzf.get(), "context.getApplicationContext() yielded NullPointerException", new Object[0]);
            applicationContext = null;
        }
        if (applicationContext != null) {
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(zzc, null, applicationContext);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzlk zzb() {
        boolean z;
        zzlk zzlkVar;
        zzls.zza();
        zzls.zzc();
        Context context = (Context) zzc.get();
        if (context == null) {
            zzls.zzb();
            throw new IllegalStateException("Must call PhenotypeContext.setContext() first");
        }
        zzlk zzlkVar2 = zzd;
        if (zzlkVar2 != null) {
            return zzlkVar2;
        }
        final Context context2 = context.getApplicationContext();
        try {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(zza.class, "singletonEntryPoint");
            Object applicationContext = context2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            if (!(applicationContext instanceof zzagp)) {
                Class<?> cls = applicationContext.getClass();
                new StringBuilder(String.valueOf(cls).length() + 72);
                Objects.toString(cls);
                throw new IllegalStateException("Given application context does not implement GeneratedComponentManager: ".concat(String.valueOf(cls)));
            }
            try {
                Object objCast = zza.class.cast(((zzagp) applicationContext).zza());
                Intrinsics.checkNotNull(objCast);
                Optional optionalZza = ((zza) objCast).zza();
                z = true;
                try {
                    if (optionalZza.isPresent()) {
                        return (zzlk) optionalZza.get();
                    }
                } catch (IllegalStateException unused) {
                }
            } catch (ClassCastException e) {
                throw new IllegalStateException("Failed to get an entry point. Did you mark your interface with @SingletonEntryPoint?", e);
            }
        } catch (IllegalStateException unused2) {
            z = false;
        }
        synchronized (zzb) {
            if (zzd != null) {
                zzlkVar = zzd;
            } else {
                Optional optionalAbsent = Optional.absent();
                boolean z2 = context2 instanceof zza;
                if (z2) {
                    optionalAbsent = ((zza) context2).zza();
                }
                zzlkVar = (zzlk) optionalAbsent.or(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzll
                    @Override // com.google.common.base.Supplier
                    public final /* synthetic */ Object get() {
                        int i = zzlk.zza;
                        zzlj zzljVar = new zzlj(null);
                        zzljVar.zza(context2);
                        return zzljVar.zzb();
                    }
                });
                zzd = zzlkVar;
                if (!z && !z2) {
                    zzlz.zza(Level.CONFIG, zzlkVar.zzg(), "Application doesn't implement PhenotypeApplication interface, falling back to globally set context. See go/phenotype-flag#process-stable-init for more info.", new Object[0]);
                }
            }
        }
        return zzlkVar;
    }

    public static boolean zzl() {
        zzls.zzb();
        if (zzc.get() == null) {
            zzls.zzd();
        }
        return false;
    }

    public final Context zzc() {
        return this.zzh;
    }

    public final zzrf zzd() {
        return this.zzm;
    }

    public final Optional zze() {
        return (Optional) this.zzn.get();
    }

    public final zzqe zzf() {
        return this.zzo;
    }

    public final ListeningScheduledExecutorService zzg() {
        return (ListeningScheduledExecutorService) this.zzi.get();
    }

    public final zzmj zzh() {
        return (zzmj) this.zzj.get();
    }

    public final zzru zzi() {
        return (zzru) this.zzl.get();
    }

    public final zzqm zzj() {
        return (zzqm) this.zzk.get();
    }

    public final zzoh zzk() {
        return this.zzg;
    }
}
