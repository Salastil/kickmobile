package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzdq implements zzdp {
    protected static volatile zzfb zza;
    protected MotionEvent zzb;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected DisplayMetrics zzq;
    protected zzet zzr;
    private double zzs;
    private double zzt;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    private boolean zzu = false;
    protected boolean zzp = false;

    protected zzdq(Context context) {
        try {
            zzct.zza();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) zzhi.zzc().zzc(zzia.zzq)).booleanValue()) {
                this.zzr = new zzet();
            }
        } catch (Throwable unused) {
        }
    }

    private final void zzo() {
        this.zzh = 0L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzg = 0L;
        this.zzi = 0L;
        this.zzj = 0L;
        LinkedList linkedList = this.zzc;
        if (linkedList.isEmpty()) {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            linkedList.clear();
        }
        this.zzb = null;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x007c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0082  */
    /* JADX WARN: Code duplicated, block: B:40:0x0085  */
    private final String zzp(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        zzdo zzdoVarZzh;
        String str2;
        int i2;
        Exception exc;
        int i3;
        int i4;
        String strZzb;
        int i5;
        int i6;
        zzad zzadVarZza;
        int i7;
        int i8;
        int i9 = i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zBooleanValue = ((Boolean) zzhi.zzc().zzc(zzia.zzj)).booleanValue();
        zzad zzadVarZzb = null;
        if (zBooleanValue) {
            zzdoVarZzh = zza != null ? zza.zzh() : null;
            str2 = "be";
        } else {
            zzdoVarZzh = null;
            str2 = null;
        }
        try {
            if (i9 == 3) {
                zzadVarZzb = zzb(context, view, activity);
                try {
                    this.zzu = true;
                    i8 = 1002;
                } catch (Exception e) {
                    exc = e;
                    i2 = 3;
                    if (zBooleanValue) {
                        if (i9 == i2) {
                            i4 = 1003;
                        } else {
                            if (i9 == 2) {
                                i4 = 1009;
                            } else {
                                i3 = 1001;
                                i9 = 1;
                            }
                            zzdoVarZzh.zza(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, exc);
                        }
                        i3 = i4;
                        zzdoVarZzh.zza(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, exc);
                    }
                }
            } else {
                if (i9 == 2) {
                    zzadVarZza = zzc(context, view, activity);
                    i7 = 1008;
                } else {
                    zzadVarZza = zza(context, null);
                    i7 = 1000;
                }
                zzadVarZzb = zzadVarZza;
                i8 = i7;
            }
            if (!zBooleanValue || zzdoVarZzh == null) {
                i2 = 3;
            } else {
                i2 = 3;
                try {
                    zzdoVarZzh.zza(i8, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    if (zBooleanValue && zzdoVarZzh != null) {
                        if (i9 == i2) {
                            i4 = 1003;
                        } else {
                            if (i9 == 2) {
                                i4 = 1009;
                            } else {
                                i3 = 1001;
                                i9 = 1;
                            }
                            zzdoVarZzh.zza(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, exc);
                        }
                        i3 = i4;
                        zzdoVarZzh.zza(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, exc);
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            i2 = 3;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (zzadVarZzb != null) {
            try {
                if (((zzbd) zzadVarZzb.zzal()).zzaB() == 0) {
                    strZzb = Integer.toString(5);
                } else {
                    zzbd zzbdVar = (zzbd) zzadVarZzb.zzal();
                    int i10 = zzct.zzc;
                    strZzb = zzct.zzb(zzbdVar.zzaq(), str);
                    if (zBooleanValue && zzdoVarZzh != null) {
                        if (i9 == i2) {
                            i5 = 1006;
                        } else {
                            i5 = i9 == 2 ? 1010 : 1004;
                        }
                        zzdo zzdoVar = zzdoVarZzh;
                        String str3 = str2;
                        try {
                            zzdoVar.zza(i5, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str3, null);
                        } catch (Exception e4) {
                            e = e4;
                            zzdoVarZzh = zzdoVar;
                            str2 = str3;
                            String string = Integer.toString(7);
                            if (zBooleanValue && zzdoVarZzh != null) {
                                if (i9 == i2) {
                                    i6 = 1007;
                                } else {
                                    i6 = i9 == 2 ? 1011 : 1005;
                                }
                                zzdoVarZzh.zza(i6, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, e);
                            }
                            return string;
                        }
                    }
                }
            } catch (Exception e5) {
                e = e5;
            }
        } else {
            strZzb = Integer.toString(5);
        }
        return strZzb;
    }

    protected abstract zzad zza(Context context, zzt zztVar);

    protected abstract zzad zzb(Context context, View view, Activity activity);

    protected abstract zzad zzc(Context context, View view, Activity activity);

    protected abstract zzfd zzd(MotionEvent motionEvent) throws zzer;

    @Override // com.google.android.gms.internal.pal.zzdp
    public final boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final synchronized void zzg(MotionEvent motionEvent) {
        Long l;
        if (this.zzu) {
            zzo();
            this.zzu = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzk = 0.0d;
            this.zzs = motionEvent.getRawX();
            this.zzt = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d = rawX - this.zzs;
            double d2 = rawY - this.zzt;
            this.zzk += Math.sqrt((d * d) + (d2 * d2));
            this.zzs = rawX;
            this.zzt = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    this.zzb = motionEventObtain;
                    LinkedList linkedList = this.zzc;
                    linkedList.add(motionEventObtain);
                    if (linkedList.size() > 6) {
                        ((MotionEvent) linkedList.remove()).recycle();
                    }
                    this.zzf++;
                    this.zzh = zzn(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.zze += (long) (motionEvent.getHistorySize() + 1);
                    zzfd zzfdVarZzd = zzd(motionEvent);
                    Long l2 = zzfdVarZzd.zzd;
                    if (l2 != null && zzfdVarZzd.zzg != null) {
                        this.zzi += l2.longValue() + zzfdVarZzd.zzg.longValue();
                    }
                    if (this.zzq != null && (l = zzfdVarZzd.zze) != null && zzfdVarZzd.zzh != null) {
                        this.zzj += l.longValue() + zzfdVarZzd.zzh.longValue();
                    }
                } else if (action2 == 3) {
                    this.zzg++;
                }
            } catch (zzer unused) {
            }
        } else {
            this.zzl = motionEvent.getX();
            this.zzm = motionEvent.getY();
            this.zzn = motionEvent.getRawX();
            this.zzo = motionEvent.getRawY();
            this.zzd++;
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final synchronized void zzh(int i, int i2, int i3) {
        if (this.zzb != null) {
            if (((Boolean) zzhi.zzc().zzc(zzia.zzh)).booleanValue()) {
                zzo();
            } else {
                this.zzb.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzq;
        if (displayMetrics != null) {
            this.zzb = MotionEvent.obtain(0L, i3, 1, i * displayMetrics.density, i2 * this.zzq.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzb = null;
        }
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final String zzi(Context context, String str, View view, Activity activity) {
        return zzp(context, str, 3, view, activity, null);
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public void zzj(View view) {
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final String zzk(Context context, View view, Activity activity) {
        return zzp(context, null, 2, view, activity, null);
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final String zzl(Context context) {
        if (zzfe.zzd()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return zzp(context, null, 1, null, null, null);
    }

    @Override // com.google.android.gms.internal.pal.zzdp
    public final String zzm(Context context, byte[] bArr) {
        throw null;
    }

    protected abstract long zzn(StackTraceElement[] stackTraceElementArr) throws zzer;
}
