package com.google.android.gms.internal.pal;

import com.google.android.gms.internal.pal.zzasw;
import com.google.android.gms.internal.pal.zzasx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzasx<MessageType extends zzasx<MessageType, BuilderType>, BuilderType extends zzasw<MessageType, BuilderType>> implements zzavw {
    protected transient int zzb = 0;

    protected static void zzas(Iterable iterable, List list) {
        byte[] bArr = zzauz.zzb;
        iterable.getClass();
        if (iterable instanceof zzavi) {
            List listZza = ((zzavi) iterable).zza();
            zzavi zzaviVar = (zzavi) list;
            int size = list.size();
            for (Object obj : listZza) {
                if (obj == null) {
                    int size2 = zzaviVar.size() - size;
                    StringBuilder sb = new StringBuilder(String.valueOf(size2).length() + 26);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String string = sb.toString();
                    int size3 = zzaviVar.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            throw new NullPointerException(string);
                        }
                        zzaviVar.remove(size3);
                    }
                } else if (obj instanceof zzatl) {
                    zzaviVar.zzb();
                } else if (obj instanceof byte[]) {
                    byte[] bArr2 = (byte[]) obj;
                    zzatl.zzr(bArr2, 0, bArr2.length);
                    zzaviVar.zzb();
                } else {
                    zzaviVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzawe) {
            list.addAll((Collection) iterable);
            return;
        }
        int size4 = ((Collection) iterable).size();
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + size4);
        } else if (list instanceof zzawg) {
            ((zzawg) list).zze(list.size() + size4);
        }
        int size5 = list.size();
        List list2 = (List) iterable;
        int size6 = list2.size();
        for (int i = 0; i < size6; i++) {
            Object obj2 = list2.get(i);
            if (obj2 == null) {
                int size7 = list.size() - size5;
                StringBuilder sb2 = new StringBuilder(String.valueOf(size7).length() + 26);
                sb2.append("Element at index ");
                sb2.append(size7);
                sb2.append(" is null.");
                String string2 = sb2.toString();
                int size8 = list.size();
                while (true) {
                    size8--;
                    if (size8 < size5) {
                        throw new NullPointerException(string2);
                    }
                    list.remove(size8);
                }
            } else {
                list.add(obj2);
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zzavw
    public final zzatl zzaQ() {
        try {
            int iZzaB = zzaB();
            zzatl zzatlVar = zzatl.zza;
            byte[] bArr = new byte[iZzaB];
            int i = zzatt.zzb;
            zzatr zzatrVar = new zzatr(bArr, 0, iZzaB);
            zzaA(zzatrVar);
            zzatrVar.zzw();
            return new zzatk(bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] zzaq() {
        try {
            int iZzaB = zzaB();
            byte[] bArr = new byte[iZzaB];
            int i = zzatt.zzb;
            zzatr zzatrVar = new zzatr(bArr, 0, iZzaB);
            zzaA(zzatrVar);
            zzatrVar.zzw();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    int zzar(zzawn zzawnVar) {
        throw null;
    }
}
