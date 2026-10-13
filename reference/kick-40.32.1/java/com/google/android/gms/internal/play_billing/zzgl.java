package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzgl;
import com.google.android.gms.internal.play_billing.zzgp;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzgl<MessageType extends zzgp<MessageType, BuilderType>, BuilderType extends zzgl<MessageType, BuilderType>> extends zzez<MessageType, BuilderType> {
    protected zzgp zza;
    private final zzgp zzb;

    protected zzgl(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzF()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzs();
    }

    private static void zza(Object obj, Object obj2) {
        zzhy.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzez
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzgl clone() {
        zzgl zzglVar = (zzgl) this.zzb.zzd(5, null, null);
        zzglVar.zza = zzk();
        return zzglVar;
    }

    public final zzgl zzh(zzgp zzgpVar) {
        zzgp zzgpVar2 = this.zzb;
        if (!zzgpVar2.getClass().isInstance(zzgpVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        if (!zzgpVar2.equals(zzgpVar)) {
            if (!this.zza.zzF()) {
                zzn();
            }
            zza(this.zza, zzgpVar);
        }
        return this;
    }

    public final MessageType zzi() {
        MessageType messagetype = (MessageType) zzk();
        if (messagetype.zzo()) {
            return messagetype;
        }
        throw new zzip(messagetype);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhq
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public MessageType zzk() {
        boolean zZzF = this.zza.zzF();
        MessageType messagetype = (MessageType) this.zza;
        if (!zZzF) {
            return messagetype;
        }
        messagetype.zzz();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhs
    public final /* bridge */ /* synthetic */ zzhr zzl() {
        throw null;
    }

    protected final void zzm() {
        if (this.zza.zzF()) {
            return;
        }
        zzn();
    }

    protected void zzn() {
        zzgp zzgpVarZzs = this.zzb.zzs();
        zza(zzgpVarZzs, this.zza);
        this.zza = zzgpVarZzs;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhs
    public final boolean zzo() {
        return zzgp.zzc(this.zza, false);
    }
}
