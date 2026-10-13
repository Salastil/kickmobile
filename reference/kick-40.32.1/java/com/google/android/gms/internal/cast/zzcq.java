package com.google.android.gms.internal.cast;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast-framework@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzcq {
    private final String zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final long zze;
    private long zzf;

    public zzcq(zzcp zzcpVar) {
        this.zza = zzcpVar.zze();
        this.zzb = zzcpVar.zzf();
        this.zzc = zzcpVar.zzg();
        this.zzd = zzcpVar.zzh();
        this.zze = zzcpVar.zzi();
    }

    public final void zza(long j) {
        this.zzf = j;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:71:0x0108  */
    public final zzqt zzb() {
        int i;
        String str = this.zza;
        zzqs zzqsVarZza = zzqt.zza();
        switch (str) {
            case "queueInsert":
                i = 13;
                break;
            case "launch":
                i = 22;
                break;
            case "queueRemove":
                i = 15;
                break;
            case "queueFetchItems":
                i = 19;
                break;
            case "setPlaybackDevices":
                i = 23;
                break;
            case "volume-mute":
                i = 9;
                break;
            case "skipAd":
                i = 21;
                break;
            case "status":
                i = 10;
                break;
            case "queueUpdate":
                i = 14;
                break;
            case "volume":
                i = 7;
                break;
            case "setPlaybackRate":
                i = 20;
                break;
            case "load":
                i = 2;
                break;
            case "mute":
                i = 8;
                break;
            case "play":
                i = 3;
                break;
            case "seek":
                i = 6;
                break;
            case "stop":
                i = 5;
                break;
            case "pause":
                i = 4;
                break;
            case "queueFetchItemRange":
                i = 18;
                break;
            case "queueReorder":
                i = 16;
                break;
            case "trackStyle":
                i = 12;
                break;
            case "activeTracks":
                i = 11;
                break;
            case "queueFetchItemIds":
                i = 17;
                break;
            default:
                i = 1;
                break;
        }
        zzqsVarZza.zze(i);
        zzqsVarZza.zza((int) this.zzb);
        zzqsVarZza.zzb(this.zzc);
        zzqsVarZza.zzc((int) (this.zzd - this.zzf));
        zzqsVarZza.zzd((int) (this.zze - this.zzf));
        return (zzqt) zzqsVarZza.zzu();
    }
}
