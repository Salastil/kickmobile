package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzaoj {
    public static final zzaoj zza;
    public static final zzaoj zzb;
    public static final zzaoj zzc;
    public static final zzaoj zzd;
    public static final zzaoj zze;
    public static final zzaoj zzf;
    public static final zzaoj zzg;
    public static final zzaoj zzh;
    public static final zzaoj zzi;
    public static final zzaoj zzj;
    public static final zzaoj zzk;
    public static final zzaoj zzl;
    public static final zzaoj zzm;
    public static final zzaoj zzn;
    public static final zzaoj zzo;
    public static final zzaoj zzp;
    public static final zzaoj zzq;
    public static final zzaoj zzr;
    private static final /* synthetic */ zzaoj[] zzs;
    private final zzaoq zzt;
    private final int zzu;

    public final int zza() {
        return this.zzu;
    }

    public final zzaoq zzb() {
        return this.zzt;
    }

    static {
        zzaoj zzaojVar = new zzaoj("DOUBLE", 0, zzaoq.DOUBLE, 1);
        zza = zzaojVar;
        zzaoj zzaojVar2 = new zzaoj("FLOAT", 1, zzaoq.FLOAT, 5);
        zzb = zzaojVar2;
        zzaoj zzaojVar3 = new zzaoj("INT64", 2, zzaoq.LONG, 0);
        zzc = zzaojVar3;
        zzaoj zzaojVar4 = new zzaoj("UINT64", 3, zzaoq.LONG, 0);
        zzd = zzaojVar4;
        zzaoj zzaojVar5 = new zzaoj("INT32", 4, zzaoq.INT, 0);
        zze = zzaojVar5;
        zzaoj zzaojVar6 = new zzaoj("FIXED64", 5, zzaoq.LONG, 1);
        zzf = zzaojVar6;
        zzaoj zzaojVar7 = new zzaoj("FIXED32", 6, zzaoq.INT, 5);
        zzg = zzaojVar7;
        zzaoj zzaojVar8 = new zzaoj("BOOL", 7, zzaoq.BOOLEAN, 0);
        zzh = zzaojVar8;
        zzaom zzaomVar = new zzaom("STRING", zzaoq.STRING);
        zzi = zzaomVar;
        zzaol zzaolVar = new zzaol("GROUP", zzaoq.MESSAGE);
        zzj = zzaolVar;
        zzaoo zzaooVar = new zzaoo("MESSAGE", zzaoq.MESSAGE);
        zzk = zzaooVar;
        zzaon zzaonVar = new zzaon("BYTES", zzaoq.BYTE_STRING);
        zzl = zzaonVar;
        zzaoj zzaojVar9 = new zzaoj("UINT32", 12, zzaoq.INT, 0);
        zzm = zzaojVar9;
        zzaoj zzaojVar10 = new zzaoj("ENUM", 13, zzaoq.ENUM, 0);
        zzn = zzaojVar10;
        zzaoj zzaojVar11 = new zzaoj("SFIXED32", 14, zzaoq.INT, 5);
        zzo = zzaojVar11;
        zzaoj zzaojVar12 = new zzaoj("SFIXED64", 15, zzaoq.LONG, 1);
        zzp = zzaojVar12;
        zzaoj zzaojVar13 = new zzaoj("SINT32", 16, zzaoq.INT, 0);
        zzq = zzaojVar13;
        zzaoj zzaojVar14 = new zzaoj("SINT64", 17, zzaoq.LONG, 0);
        zzr = zzaojVar14;
        zzs = new zzaoj[]{zzaojVar, zzaojVar2, zzaojVar3, zzaojVar4, zzaojVar5, zzaojVar6, zzaojVar7, zzaojVar8, zzaomVar, zzaolVar, zzaooVar, zzaonVar, zzaojVar9, zzaojVar10, zzaojVar11, zzaojVar12, zzaojVar13, zzaojVar14};
    }

    private zzaoj(String str, int i, zzaoq zzaoqVar, int i2) {
        super(str, i);
        this.zzt = zzaoqVar;
        this.zzu = i2;
    }

    public static zzaoj[] values() {
        return (zzaoj[]) zzs.clone();
    }
}
