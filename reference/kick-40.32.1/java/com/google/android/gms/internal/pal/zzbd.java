package com.google.android.gms.internal.pal;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzbd extends zzaun implements zzavx {
    private static final zzbd zzbl;
    private long zzA;
    private long zzB;
    private long zzF;
    private long zzG;
    private long zzH;
    private long zzJ;
    private zzbf zzM;
    private int zza;
    private zzay zzaD;
    private zzaw zzaE;
    private long zzaK;
    private long zzaL;
    private long zzaO;
    private zzan zzaP;
    private zzap zzaQ;
    private int zzaT;
    private int zzaY;
    private zzal zzaZ;
    private zzba zzae;
    private zzbc zzag;
    private int zzar;
    private int zzas;
    private int zzat;
    private int zzau;
    private zzbu zzav;
    private boolean zzba;
    private long zzbb;
    private boolean zzbe;
    private long zzbg;
    private zzbs zzbh;
    private int zzd;
    private int zze;
    private int zzf;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private long zzr;
    private long zzt;
    private long zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;
    private String zzg = "";
    private String zzh = "";
    private String zzs = "";
    private String zzC = "";
    private String zzD = "D";
    private String zzE = "";
    private String zzI = "";
    private long zzK = -1;
    private long zzL = -1;
    private long zzN = -1;
    private long zzO = -1;
    private long zzP = -1;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private String zzT = "D";
    private String zzU = "D";
    private long zzV = -1;
    private int zzW = 1000;
    private int zzX = 1000;
    private long zzY = -1;
    private long zzZ = -1;
    private long zzaa = -1;
    private long zzab = -1;
    private long zzac = -1;
    private int zzad = 1000;
    private zzauy zzaf = zzaJ();
    private long zzah = -1;
    private long zzai = -1;
    private long zzaj = -1;
    private long zzak = -1;
    private long zzal = -1;
    private long zzam = -1;
    private long zzan = -1;
    private long zzao = -1;
    private String zzap = "D";
    private long zzaq = -1;
    private long zzaw = -1;
    private int zzax = 1000;
    private int zzay = 1000;
    private String zzaz = "D";
    private zzauy zzaA = zzaJ();
    private int zzaB = 1000;
    private zzauy zzaC = zzaJ();
    private String zzaF = "";
    private long zzaG = -1;
    private long zzaH = -1;
    private long zzaI = -1;
    private long zzaJ = -1;
    private long zzaM = -1;
    private String zzaN = "";
    private long zzaR = -1;
    private long zzaS = -1;
    private String zzaU = "";
    private String zzaV = "";
    private long zzaW = -1;
    private long zzaX = -1;
    private String zzbc = "";
    private int zzbd = 2;
    private String zzbf = "";
    private long zzbi = -1;
    private String zzbj = "";
    private zzauu zzbk = zzaG();

    static {
        zzbd zzbdVar = new zzbd();
        zzbl = zzbdVar;
        zzaun.zzaD(zzbd.class, zzbdVar);
    }

    private zzbd() {
    }

    public static zzbd zzf(byte[] bArr, zzaty zzatyVar) throws zzavb {
        return (zzbd) zzaun.zzaN(zzbl, bArr, zzatyVar);
    }

    public static zzad zzg() {
        return (zzad) zzbl.zzay();
    }

    public static zzbd zzh() {
        return zzbl;
    }

    final /* synthetic */ void zzA(long j) {
        this.zza |= 67108864;
        this.zzG = j;
    }

    final /* synthetic */ void zzB(long j) {
        this.zza |= 134217728;
        this.zzH = j;
    }

    final /* synthetic */ void zzC(String str) {
        str.getClass();
        this.zza |= 268435456;
        this.zzI = str;
    }

    final /* synthetic */ void zzD(long j) {
        this.zza |= 536870912;
        this.zzJ = j;
    }

    final /* synthetic */ void zzE(long j) {
        this.zza |= 1073741824;
        this.zzK = j;
    }

    final /* synthetic */ void zzF(long j) {
        this.zza |= Integer.MIN_VALUE;
        this.zzL = j;
    }

    final /* synthetic */ void zzG(long j) {
        this.zzd |= 2;
        this.zzN = j;
    }

    final /* synthetic */ void zzH(long j) {
        this.zzd |= 4;
        this.zzO = j;
    }

    final /* synthetic */ void zzI(long j) {
        this.zzd |= 8;
        this.zzP = j;
    }

    final /* synthetic */ void zzJ(long j) {
        this.zzd |= 16;
        this.zzQ = j;
    }

    final /* synthetic */ void zzK(long j) {
        this.zzd |= 32;
        this.zzR = j;
    }

    final /* synthetic */ void zzL(long j) {
        this.zzd |= 64;
        this.zzS = j;
    }

    final /* synthetic */ void zzM(String str) {
        str.getClass();
        this.zzd |= 128;
        this.zzT = str;
    }

    final /* synthetic */ void zzN(String str) {
        str.getClass();
        this.zzd |= 256;
        this.zzU = str;
    }

    final /* synthetic */ void zzO(long j) {
        this.zzd |= 4096;
        this.zzY = j;
    }

    final /* synthetic */ void zzP(long j) {
        this.zzd |= 8192;
        this.zzZ = j;
    }

    final /* synthetic */ void zzQ(long j) {
        this.zzd |= 16384;
        this.zzaa = j;
    }

    final /* synthetic */ void zzR(zzba zzbaVar) {
        zzbaVar.getClass();
        this.zzae = zzbaVar;
        this.zzd |= 262144;
    }

    final /* synthetic */ void zzS(zzba zzbaVar) {
        zzbaVar.getClass();
        zzauy zzauyVar = this.zzaf;
        if (!zzauyVar.zza()) {
            this.zzaf = zzaun.zzaK(zzauyVar);
        }
        this.zzaf.add(zzbaVar);
    }

    final /* synthetic */ void zzT() {
        this.zzaf = zzaJ();
    }

    final /* synthetic */ void zzU(zzbc zzbcVar) {
        zzbcVar.getClass();
        this.zzag = zzbcVar;
        this.zzd |= 524288;
    }

    final /* synthetic */ void zzV(long j) {
        this.zzd |= 2097152;
        this.zzai = j;
    }

    final /* synthetic */ void zzW(long j) {
        this.zzd |= 4194304;
        this.zzaj = j;
    }

    final /* synthetic */ void zzX(long j) {
        this.zzd |= 8388608;
        this.zzak = j;
    }

    final /* synthetic */ void zzY(long j) {
        this.zzd |= 67108864;
        this.zzan = j;
    }

    final /* synthetic */ void zzZ(long j) {
        this.zzd |= 134217728;
        this.zzao = j;
    }

    public final boolean zza() {
        return (this.zza & 4194304) != 0;
    }

    final /* synthetic */ void zzaa(String str) {
        str.getClass();
        this.zzd |= 268435456;
        this.zzap = str;
    }

    final /* synthetic */ void zzab(String str) {
        str.getClass();
        this.zze |= 1024;
        this.zzaF = str;
    }

    final /* synthetic */ void zzac(long j) {
        this.zze |= 2048;
        this.zzaG = j;
    }

    final /* synthetic */ void zzad(long j) {
        this.zze |= 4096;
        this.zzaH = j;
    }

    final /* synthetic */ void zzae(long j) {
        this.zze |= 8192;
        this.zzaI = j;
    }

    final /* synthetic */ void zzaf(long j) {
        this.zze |= 16384;
        this.zzaJ = j;
    }

    final /* synthetic */ void zzag(String str) {
        str.getClass();
        this.zze |= 262144;
        this.zzaN = str;
    }

    final /* synthetic */ void zzah(long j) {
        this.zzf |= 32;
        this.zzbg = j;
    }

    final /* synthetic */ void zzaj(int i) {
        this.zzW = i - 1;
        this.zzd |= 1024;
    }

    final /* synthetic */ void zzak(int i) {
        this.zzX = i - 1;
        this.zzd |= 2048;
    }

    final /* synthetic */ void zzal(int i) {
        this.zzad = i - 1;
        this.zzd |= 131072;
    }

    final /* synthetic */ void zzam(int i) {
        this.zzax = i - 1;
        this.zze |= 16;
    }

    final /* synthetic */ void zzan(int i) {
        this.zzay = i - 1;
        this.zze |= 32;
    }

    final /* synthetic */ void zzao(int i) {
        this.zzaT = i - 1;
        this.zze |= 16777216;
    }

    public final String zzb() {
        return this.zzC;
    }

    public final long zzc() {
        return this.zzah;
    }

    public final boolean zzd() {
        return (this.zzf & 64) != 0;
    }

    public final zzbs zze() {
        zzbs zzbsVar = this.zzbh;
        return zzbsVar == null ? zzbs.zze() : zzbsVar;
    }

    final /* synthetic */ void zzi(String str) {
        str.getClass();
        this.zza |= 1;
        this.zzg = str;
    }

    final /* synthetic */ void zzj(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzh = str;
    }

    final /* synthetic */ void zzk(long j) {
        this.zza |= 4;
        this.zzi = j;
    }

    @Override // com.google.android.gms.internal.pal.zzaun
    protected final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzaus zzausVar = zzah.zza;
            zzaus zzausVar2 = zzbn.zza;
            return zzaE(zzbl, "\u0001m\u0000\u0004\u0001Įm\u0000\u0004\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ`\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈa\u0019ဂe\u001a᠌b\u001bဈ\u0016\u001cဇc\u001dဈ\u0018\u001eဈd\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌AEဉBFဂCGဂ8Hဂ9I᠌DJဂ)Kဈ\u0017L᠌EMဈFN\u001bO᠌GP\u001bQဉHRဈJSဂKTဂLUဂMVဂNWဂOXဂQYဈRZဉT[ဉU\\ဂV]ဂW^᠌X_᠌@`ဉIaဂPbဈYcဈZdဂ[eဂ\\f᠌]gဂShဉ^iဇ_j'ÉဉfĭဂgĮဈh", new Object[]{"zza", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzbb", "zzA", "zzB", "zzbc", "zzbg", "zzbd", zzausVar, "zzC", "zzbe", "zzE", "zzbf", "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzaf", zzba.class, "zzR", "zzS", "zzT", "zzU", "zzW", zzausVar2, "zzX", zzausVar2, "zzae", "zzY", "zzZ", "zzaa", "zzab", "zzac", "zzad", zzausVar2, "zzag", "zzah", "zzai", "zzaj", "zzak", "zzan", "zzao", "zzaq", "zzar", zzbm.zza, "zzas", zzbq.zza, "zzap", "zzau", zzae.zza, "zzav", "zzaw", "zzal", "zzam", "zzax", zzausVar2, "zzV", "zzD", "zzay", zzausVar2, "zzaz", "zzaA", zzau.class, "zzaB", zzausVar2, "zzaC", zzag.class, "zzaD", "zzaF", "zzaG", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaM", "zzaN", "zzaP", "zzaQ", "zzaR", "zzaS", "zzaT", zzaq.zza, "zzat", zzai.zza, "zzaE", "zzaL", "zzaU", "zzaV", "zzaW", "zzaX", "zzaY", zzas.zza, "zzaO", "zzaZ", "zzba", "zzbk", "zzbh", "zzbi", "zzbj"});
        }
        if (i2 == 3) {
            return new zzbd();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzad(bArr);
        }
        if (i2 == 5) {
            return zzbl;
        }
        throw null;
    }

    final /* synthetic */ void zzm(long j) {
        this.zza |= 16;
        this.zzk = j;
    }

    final /* synthetic */ void zzn(long j) {
        this.zza |= 32;
        this.zzl = j;
    }

    final /* synthetic */ void zzo(long j) {
        this.zza |= 1024;
        this.zzq = j;
    }

    final /* synthetic */ void zzp(long j) {
        this.zza |= 2048;
        this.zzr = j;
    }

    final /* synthetic */ void zzq(long j) {
        this.zza |= 8192;
        this.zzt = j;
    }

    final /* synthetic */ void zzr(long j) {
        this.zza |= 16384;
        this.zzu = j;
    }

    final /* synthetic */ void zzs(long j) {
        this.zza |= 32768;
        this.zzv = j;
    }

    final /* synthetic */ void zzt(long j) {
        this.zza |= 65536;
        this.zzw = j;
    }

    final /* synthetic */ void zzu(long j) {
        this.zza |= 524288;
        this.zzz = j;
    }

    final /* synthetic */ void zzv(long j) {
        this.zza |= 1048576;
        this.zzA = j;
    }

    final /* synthetic */ void zzw(long j) {
        this.zza |= 2097152;
        this.zzB = j;
    }

    final /* synthetic */ void zzx(String str) {
        str.getClass();
        this.zza |= 4194304;
        this.zzC = str;
    }

    final /* synthetic */ void zzy(String str) {
        str.getClass();
        this.zza |= 16777216;
        this.zzE = str;
    }

    final /* synthetic */ void zzz(long j) {
        this.zza |= GroupFlagsKt.HasAuxSlotFlag;
        this.zzF = j;
    }
}
