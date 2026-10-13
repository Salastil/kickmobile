package com.google.android.gms.internal.pal;

import androidx.collection.SieveCacheKt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzvy implements zzwg {
    private static final Charset zza = Charset.forName("UTF-8");
    private final InputStream zzb;

    private zzvy(InputStream inputStream) {
        this.zzb = inputStream;
    }

    public static zzvy zza(InputStream inputStream) throws IOException {
        return new zzvy(inputStream);
    }

    private static int zzc(zzarv zzarvVar) throws IOException {
        if (!(zzarvVar instanceof zzarz)) {
            throw new IOException("invalid key id: not a JSON primitive");
        }
        if (!zzarvVar.zzg().zzc()) {
            throw new IOException("invalid key id: not a JSON number");
        }
        try {
            long jZzc = zzahh.zzc(zzarvVar.zzg().zzh());
            if (jZzc > 4294967295L || jZzc < SieveCacheKt.NodeMetaAndPreviousMask) {
                throw new IOException("invalid key id");
            }
            return (int) jZzc;
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:131:0x01ec A[DONT_GENERATE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x01ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x01ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x01ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x01ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x01e4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x010c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0114 A[Catch: all -> 0x0244, IllegalStateException -> 0x0246, zzary | IllegalStateException -> 0x0248, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0244, blocks: (B:3:0x0014, B:4:0x0023, B:6:0x002d, B:7:0x0033, B:9:0x004a, B:11:0x0052, B:13:0x005c, B:15:0x0066, B:17:0x0072, B:19:0x0078, B:21:0x0086, B:23:0x008c, B:25:0x0092, B:27:0x0098, B:29:0x00a0, B:45:0x00eb, B:50:0x0114, B:63:0x0137, B:65:0x0144, B:67:0x014a, B:69:0x0150, B:84:0x01b5, B:85:0x01d3, B:86:0x01e3, B:87:0x01e4, B:88:0x01eb, B:54:0x011f, B:58:0x012a, B:62:0x0135, B:89:0x01ec, B:90:0x01fc, B:91:0x01fd, B:92:0x020d, B:93:0x020e, B:94:0x0215, B:95:0x0216, B:96:0x021d, B:97:0x021e, B:102:0x022c, B:103:0x0233, B:104:0x0234, B:105:0x023b, B:106:0x023c, B:107:0x0243, B:113:0x0249, B:114:0x024e), top: B:119:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0117  */
    /* JADX WARN: Code duplicated, block: B:54:0x011f A[Catch: all -> 0x0244, IllegalStateException -> 0x0246, zzary | IllegalStateException -> 0x0248, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0244, blocks: (B:3:0x0014, B:4:0x0023, B:6:0x002d, B:7:0x0033, B:9:0x004a, B:11:0x0052, B:13:0x005c, B:15:0x0066, B:17:0x0072, B:19:0x0078, B:21:0x0086, B:23:0x008c, B:25:0x0092, B:27:0x0098, B:29:0x00a0, B:45:0x00eb, B:50:0x0114, B:63:0x0137, B:65:0x0144, B:67:0x014a, B:69:0x0150, B:84:0x01b5, B:85:0x01d3, B:86:0x01e3, B:87:0x01e4, B:88:0x01eb, B:54:0x011f, B:58:0x012a, B:62:0x0135, B:89:0x01ec, B:90:0x01fc, B:91:0x01fd, B:92:0x020d, B:93:0x020e, B:94:0x0215, B:95:0x0216, B:96:0x021d, B:97:0x021e, B:102:0x022c, B:103:0x0233, B:104:0x0234, B:105:0x023b, B:106:0x023c, B:107:0x0243, B:113:0x0249, B:114:0x024e), top: B:119:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0122  */
    /* JADX WARN: Code duplicated, block: B:58:0x012a A[Catch: all -> 0x0244, IllegalStateException -> 0x0246, zzary | IllegalStateException -> 0x0248, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0244, blocks: (B:3:0x0014, B:4:0x0023, B:6:0x002d, B:7:0x0033, B:9:0x004a, B:11:0x0052, B:13:0x005c, B:15:0x0066, B:17:0x0072, B:19:0x0078, B:21:0x0086, B:23:0x008c, B:25:0x0092, B:27:0x0098, B:29:0x00a0, B:45:0x00eb, B:50:0x0114, B:63:0x0137, B:65:0x0144, B:67:0x014a, B:69:0x0150, B:84:0x01b5, B:85:0x01d3, B:86:0x01e3, B:87:0x01e4, B:88:0x01eb, B:54:0x011f, B:58:0x012a, B:62:0x0135, B:89:0x01ec, B:90:0x01fc, B:91:0x01fd, B:92:0x020d, B:93:0x020e, B:94:0x0215, B:95:0x0216, B:96:0x021d, B:97:0x021e, B:102:0x022c, B:103:0x0233, B:104:0x0234, B:105:0x023b, B:106:0x023c, B:107:0x0243, B:113:0x0249, B:114:0x024e), top: B:119:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x012d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0135 A[Catch: all -> 0x0244, IllegalStateException -> 0x0246, zzary | IllegalStateException -> 0x0248, TRY_ENTER, TryCatch #1 {all -> 0x0244, blocks: (B:3:0x0014, B:4:0x0023, B:6:0x002d, B:7:0x0033, B:9:0x004a, B:11:0x0052, B:13:0x005c, B:15:0x0066, B:17:0x0072, B:19:0x0078, B:21:0x0086, B:23:0x008c, B:25:0x0092, B:27:0x0098, B:29:0x00a0, B:45:0x00eb, B:50:0x0114, B:63:0x0137, B:65:0x0144, B:67:0x014a, B:69:0x0150, B:84:0x01b5, B:85:0x01d3, B:86:0x01e3, B:87:0x01e4, B:88:0x01eb, B:54:0x011f, B:58:0x012a, B:62:0x0135, B:89:0x01ec, B:90:0x01fc, B:91:0x01fd, B:92:0x020d, B:93:0x020e, B:94:0x0215, B:95:0x0216, B:96:0x021d, B:97:0x021e, B:102:0x022c, B:103:0x0233, B:104:0x0234, B:105:0x023b, B:106:0x023c, B:107:0x0243, B:113:0x0249, B:114:0x024e), top: B:119:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0144 A[Catch: all -> 0x0244, IllegalStateException -> 0x0246, zzary | IllegalStateException -> 0x0248, TryCatch #1 {all -> 0x0244, blocks: (B:3:0x0014, B:4:0x0023, B:6:0x002d, B:7:0x0033, B:9:0x004a, B:11:0x0052, B:13:0x005c, B:15:0x0066, B:17:0x0072, B:19:0x0078, B:21:0x0086, B:23:0x008c, B:25:0x0092, B:27:0x0098, B:29:0x00a0, B:45:0x00eb, B:50:0x0114, B:63:0x0137, B:65:0x0144, B:67:0x014a, B:69:0x0150, B:84:0x01b5, B:85:0x01d3, B:86:0x01e3, B:87:0x01e4, B:88:0x01eb, B:54:0x011f, B:58:0x012a, B:62:0x0135, B:89:0x01ec, B:90:0x01fc, B:91:0x01fd, B:92:0x020d, B:93:0x020e, B:94:0x0215, B:95:0x0216, B:96:0x021d, B:97:0x021e, B:102:0x022c, B:103:0x0233, B:104:0x0234, B:105:0x023b, B:106:0x023c, B:107:0x0243, B:113:0x0249, B:114:0x024e), top: B:119:0x0014 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.pal.zzwg
    public final zzaoz zzb() throws IOException {
        int i;
        String strZzd;
        zzapm zzapmVar;
        zzarx zzarxVarZze;
        int i2;
        String str = "status";
        String str2 = "keyData";
        try {
            try {
                InputStream inputStream = this.zzb;
                int i3 = zzwo.zza;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i4 = inputStream.read(bArr);
                    InputStream inputStream2 = inputStream;
                    if (i4 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i4);
                    inputStream = inputStream2;
                }
                zzarx zzarxVarZze2 = zzahh.zzb(new String(byteArrayOutputStream.toByteArray(), zza)).zze();
                if (!zzarxVarZze2.zzc("key")) {
                    throw new zzary("invalid keyset: no key");
                }
                zzarv zzarvVarZzh = zzarxVarZze2.zzh("key");
                if (!(zzarvVarZzh instanceof zzaru)) {
                    throw new zzary("invalid keyset: key must be an array");
                }
                zzaru zzaruVarZzf = zzarvVarZzh.zzf();
                if (zzaruVarZzf.zzb() == 0) {
                    throw new zzary("invalid keyset: key is empty");
                }
                zzaow zzaowVarZzf = zzaoz.zzf();
                if (zzarxVarZze2.zzc("primaryKeyId")) {
                    zzaowVarZzf.zza(zzc(zzarxVarZze2.zzh("primaryKeyId")));
                }
                int i5 = 0;
                while (i5 < zzaruVarZzf.zzb()) {
                    zzarx zzarxVarZze3 = zzaruVarZzf.zzc(i5).zze();
                    if (!zzarxVarZze3.zzc(str2) || !zzarxVarZze3.zzc(str) || !zzarxVarZze3.zzc("keyId") || !zzarxVarZze3.zzc("outputPrefixType")) {
                        throw new zzary("invalid key");
                    }
                    zzarv zzarvVarZzh2 = zzarxVarZze3.zzh(str2);
                    if (!(zzarvVarZzh2 instanceof zzarx)) {
                        throw new zzary("invalid key: keyData must be an object");
                    }
                    zzaox zzaoxVarZze = zzaoy.zze();
                    String strZzd2 = zzarxVarZze3.zzh(str).zzd();
                    String str3 = str;
                    int iHashCode = strZzd2.hashCode();
                    String str4 = str2;
                    int i6 = 4;
                    if (iHashCode == -891611359) {
                        if (!strZzd2.equals("ENABLED")) {
                            String.valueOf(strZzd2);
                            throw new zzary("unknown status: ".concat(String.valueOf(strZzd2)));
                        }
                        i = 3;
                        zzaoxVarZze.zze(i);
                        zzaoxVarZze.zzc(zzc(zzarxVarZze3.zzh("keyId")));
                        strZzd = zzarxVarZze3.zzh("outputPrefixType").zzd();
                        switch (strZzd.hashCode()) {
                            case -2053249079:
                                if (strZzd.equals("LEGACY")) {
                                    zzapmVar = zzapm.LEGACY;
                                    zzaoxVarZze.zzd(zzapmVar);
                                    zzarxVarZze = zzarvVarZzh2.zze();
                                    if (zzarxVarZze.zzc("typeUrl")) {
                                    }
                                    throw new zzary("invalid keyData");
                                }
                                break;
                            case 80904:
                                if (strZzd.equals("RAW")) {
                                    zzapmVar = zzapm.RAW;
                                    zzaoxVarZze.zzd(zzapmVar);
                                    zzarxVarZze = zzarvVarZzh2.zze();
                                    if (zzarxVarZze.zzc("typeUrl")) {
                                    }
                                    throw new zzary("invalid keyData");
                                }
                                break;
                            case 2575090:
                                if (strZzd.equals("TINK")) {
                                    zzapmVar = zzapm.TINK;
                                    zzaoxVarZze.zzd(zzapmVar);
                                    zzarxVarZze = zzarvVarZzh2.zze();
                                    if (zzarxVarZze.zzc("typeUrl")) {
                                    }
                                    throw new zzary("invalid keyData");
                                }
                                break;
                            case 1761684556:
                                if (strZzd.equals("CRUNCHY")) {
                                    zzapmVar = zzapm.CRUNCHY;
                                    zzaoxVarZze.zzd(zzapmVar);
                                    zzarxVarZze = zzarvVarZzh2.zze();
                                    if (zzarxVarZze.zzc("typeUrl")) {
                                    }
                                    throw new zzary("invalid keyData");
                                }
                                break;
                        }
                        String.valueOf(strZzd);
                        throw new zzary("unknown output prefix type: ".concat(String.valueOf(strZzd)));
                    }
                    if (iHashCode == 478389753) {
                        if (!strZzd2.equals("DESTROYED")) {
                            String.valueOf(strZzd2);
                            throw new zzary("unknown status: ".concat(String.valueOf(strZzd2)));
                        }
                        i = 5;
                        zzaoxVarZze.zze(i);
                        zzaoxVarZze.zzc(zzc(zzarxVarZze3.zzh("keyId")));
                        strZzd = zzarxVarZze3.zzh("outputPrefixType").zzd();
                        switch (strZzd.hashCode()) {
                            case -2053249079:
                                if (strZzd.equals("LEGACY")) {
                                    zzapmVar = zzapm.LEGACY;
                                    zzaoxVarZze.zzd(zzapmVar);
                                    zzarxVarZze = zzarvVarZzh2.zze();
                                    if (zzarxVarZze.zzc("typeUrl")) {
                                    }
                                    throw new zzary("invalid keyData");
                                }
                                break;
                            case 80904:
                                if (strZzd.equals("RAW")) {
                                    zzapmVar = zzapm.RAW;
                                    zzaoxVarZze.zzd(zzapmVar);
                                    zzarxVarZze = zzarvVarZzh2.zze();
                                    if (zzarxVarZze.zzc("typeUrl")) {
                                    }
                                    throw new zzary("invalid keyData");
                                }
                                break;
                            case 2575090:
                                if (strZzd.equals("TINK")) {
                                    zzapmVar = zzapm.TINK;
                                    zzaoxVarZze.zzd(zzapmVar);
                                    zzarxVarZze = zzarvVarZzh2.zze();
                                    if (zzarxVarZze.zzc("typeUrl")) {
                                    }
                                    throw new zzary("invalid keyData");
                                }
                                break;
                            case 1761684556:
                                if (strZzd.equals("CRUNCHY")) {
                                    zzapmVar = zzapm.CRUNCHY;
                                    zzaoxVarZze.zzd(zzapmVar);
                                    zzarxVarZze = zzarvVarZzh2.zze();
                                    if (zzarxVarZze.zzc("typeUrl")) {
                                    }
                                    throw new zzary("invalid keyData");
                                }
                                break;
                        }
                        String.valueOf(strZzd);
                        throw new zzary("unknown output prefix type: ".concat(String.valueOf(strZzd)));
                    }
                    if (iHashCode != 1053567612 || !strZzd2.equals("DISABLED")) {
                        String.valueOf(strZzd2);
                        throw new zzary("unknown status: ".concat(String.valueOf(strZzd2)));
                    }
                    i = 4;
                    zzaoxVarZze.zze(i);
                    zzaoxVarZze.zzc(zzc(zzarxVarZze3.zzh("keyId")));
                    strZzd = zzarxVarZze3.zzh("outputPrefixType").zzd();
                    switch (strZzd.hashCode()) {
                        case -2053249079:
                            if (strZzd.equals("LEGACY")) {
                                zzapmVar = zzapm.LEGACY;
                                zzaoxVarZze.zzd(zzapmVar);
                                zzarxVarZze = zzarvVarZzh2.zze();
                                if (zzarxVarZze.zzc("typeUrl") || !zzarxVarZze.zzc("value") || !zzarxVarZze.zzc("keyMaterialType")) {
                                    throw new zzary("invalid keyData");
                                }
                                byte[] bArrZza = zzaqi.zza(zzarxVarZze.zzh("value").zzd(), 2);
                                zzaop zzaopVarZzc = zzaoq.zzc();
                                zzaopVarZzc.zza(zzarxVarZze.zzh("typeUrl").zzd());
                                zzatl zzatlVar = zzatl.zza;
                                zzaopVarZzc.zzb(zzatl.zzr(bArrZza, 0, bArrZza.length));
                                String strZzd3 = zzarxVarZze.zzh("keyMaterialType").zzd();
                                switch (strZzd3.hashCode()) {
                                    case -1881281466:
                                        if (!strZzd3.equals("REMOTE")) {
                                            String.valueOf(strZzd3);
                                            throw new zzary("unknown key material type: ".concat(String.valueOf(strZzd3)));
                                        }
                                        i6 = 6;
                                        break;
                                        break;
                                    case -1609477353:
                                        if (!strZzd3.equals("SYMMETRIC")) {
                                            String.valueOf(strZzd3);
                                            throw new zzary("unknown key material type: ".concat(String.valueOf(strZzd3)));
                                        }
                                        i2 = 3;
                                        continue;
                                        zzaopVarZzc.zzc(i2);
                                        zzaoxVarZze.zza((zzaoq) zzaopVarZzc.zzal());
                                        zzaowVarZzf.zzb((zzaoy) zzaoxVarZze.zzal());
                                        i5++;
                                        str = str3;
                                        str2 = str4;
                                        break;
                                        break;
                                    case 249237018:
                                        if (!strZzd3.equals("ASYMMETRIC_PRIVATE")) {
                                            String.valueOf(strZzd3);
                                            throw new zzary("unknown key material type: ".concat(String.valueOf(strZzd3)));
                                        }
                                        break;
                                    case 1534613202:
                                        if (!strZzd3.equals("ASYMMETRIC_PUBLIC")) {
                                            String.valueOf(strZzd3);
                                            throw new zzary("unknown key material type: ".concat(String.valueOf(strZzd3)));
                                        }
                                        i2 = 5;
                                        continue;
                                        zzaopVarZzc.zzc(i2);
                                        zzaoxVarZze.zza((zzaoq) zzaopVarZzc.zzal());
                                        zzaowVarZzf.zzb((zzaoy) zzaoxVarZze.zzal());
                                        i5++;
                                        str = str3;
                                        str2 = str4;
                                        break;
                                        break;
                                    default:
                                        String.valueOf(strZzd3);
                                        throw new zzary("unknown key material type: ".concat(String.valueOf(strZzd3)));
                                }
                                i2 = i6;
                                zzaopVarZzc.zzc(i2);
                                zzaoxVarZze.zza((zzaoq) zzaopVarZzc.zzal());
                                zzaowVarZzf.zzb((zzaoy) zzaoxVarZze.zzal());
                                i5++;
                                str = str3;
                                str2 = str4;
                            }
                            break;
                        case 80904:
                            if (strZzd.equals("RAW")) {
                                zzapmVar = zzapm.RAW;
                                zzaoxVarZze.zzd(zzapmVar);
                                zzarxVarZze = zzarvVarZzh2.zze();
                                if (zzarxVarZze.zzc("typeUrl")) {
                                }
                                throw new zzary("invalid keyData");
                            }
                            break;
                        case 2575090:
                            if (strZzd.equals("TINK")) {
                                zzapmVar = zzapm.TINK;
                                zzaoxVarZze.zzd(zzapmVar);
                                zzarxVarZze = zzarvVarZzh2.zze();
                                if (zzarxVarZze.zzc("typeUrl")) {
                                }
                                throw new zzary("invalid keyData");
                            }
                            break;
                        case 1761684556:
                            if (strZzd.equals("CRUNCHY")) {
                                zzapmVar = zzapm.CRUNCHY;
                                zzaoxVarZze.zzd(zzapmVar);
                                zzarxVarZze = zzarvVarZzh2.zze();
                                if (zzarxVarZze.zzc("typeUrl")) {
                                }
                                throw new zzary("invalid keyData");
                            }
                            break;
                    }
                    String.valueOf(strZzd);
                    throw new zzary("unknown output prefix type: ".concat(String.valueOf(strZzd)));
                }
                zzaoz zzaozVar = (zzaoz) zzaowVarZzf.zzal();
                InputStream inputStream3 = this.zzb;
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                return zzaozVar;
            } catch (Throwable th) {
                InputStream inputStream4 = this.zzb;
                if (inputStream4 != null) {
                    inputStream4.close();
                }
                throw th;
            }
        } catch (zzary | IllegalStateException e) {
            throw new IOException(e);
        }
    }
}
