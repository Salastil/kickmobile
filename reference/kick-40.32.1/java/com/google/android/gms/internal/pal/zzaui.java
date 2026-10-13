package com.google.android.gms.internal.pal;

import com.google.android.gms.internal.pal.zzaui;
import com.google.android.gms.internal.pal.zzaun;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzaui<MessageType extends zzaun<MessageType, BuilderType>, BuilderType extends zzaui<MessageType, BuilderType>> extends zzasw<MessageType, BuilderType> {
    protected zzaun zza;
    private final zzaun zzb;

    protected zzaui(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzat()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzav();
    }

    private static void zza(Object obj, Object obj2) {
        zzawf.zza().zzb(obj.getClass()).zzd(obj, obj2);
    }

    @Override // com.google.android.gms.internal.pal.zzavx
    public final boolean zzaR() {
        return zzaun.zzb(this.zza, false);
    }

    protected final void zzag() {
        if (this.zza.zzat()) {
            return;
        }
        zzah();
    }

    protected void zzah() {
        zzaun zzaunVarZzav = this.zzb.zzav();
        zza(zzaunVarZzav, this.zza);
        this.zza = zzaunVarZzav;
    }

    @Override // com.google.android.gms.internal.pal.zzasw
    /* JADX INFO: renamed from: zzaj, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzaui zzaf() {
        zzaui zzauiVar = (zzaui) this.zzb.zzl(5, null, null);
        zzauiVar.zza = zzao();
        return zzauiVar;
    }

    @Override // com.google.android.gms.internal.pal.zzavv
    /* JADX INFO: renamed from: zzak, reason: merged with bridge method [inline-methods] */
    public MessageType zzao() {
        boolean zZzat = this.zza.zzat();
        MessageType messagetype = (MessageType) this.zza;
        if (!zZzat) {
            return messagetype;
        }
        messagetype.zzax();
        return (MessageType) this.zza;
    }

    public final MessageType zzal() {
        MessageType messagetype = (MessageType) zzao();
        if (messagetype.zzaR()) {
            return messagetype;
        }
        throw new zzawz(messagetype);
    }

    public final zzaui zzam(zzaun zzaunVar) {
        if (!this.zzb.equals(zzaunVar)) {
            if (!this.zza.zzat()) {
                zzah();
            }
            zza(this.zza, zzaunVar);
        }
        return this;
    }

    public final zzaui zzan(byte[] bArr, int i, int i2, zzaty zzatyVar) throws zzavb {
        if (!this.zza.zzat()) {
            zzah();
        }
        try {
            zzawf.zza().zzb(this.zza.getClass()).zzj(this.zza, bArr, 0, i2, new zzatb(zzatyVar));
            return this;
        } catch (zzavb e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzavb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    @Override // com.google.android.gms.internal.pal.zzavx
    public final /* synthetic */ zzavw zzap() {
        throw null;
    }
}
