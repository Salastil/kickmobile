package com.google.android.gms.internal.pal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzass implements Closeable {
    private final Reader zzb;
    private long zzi;
    private int zzj;
    private int[] zzk;
    private String[] zzm;
    private int[] zzn;
    private zzasa zzc = zzasa.LEGACY_STRICT;
    private final char[] zzd = new char[1024];
    private int zze = 0;
    private int zzf = 0;
    private int zzg = 0;
    private int zzh = 0;
    int zza = 0;
    private int zzl = 1;

    static {
        zzasc.zza = new zzasr();
    }

    public zzass(Reader reader) {
        int[] iArr = new int[32];
        this.zzk = iArr;
        iArr[0] = 6;
        this.zzm = new String[32];
        this.zzn = new int[32];
        this.zzb = (Reader) Objects.requireNonNull(reader, "in == null");
    }

    private final boolean zzn(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        zzt();
        return false;
    }

    private final String zzo(char c) throws IOException {
        char[] cArr;
        int i;
        StringBuilder sb = null;
        do {
            int i2 = this.zze;
            int i3 = this.zzf;
            int i4 = i2;
            while (true) {
                cArr = this.zzd;
                if (i2 < i3) {
                    int i5 = i2 + 1;
                    char c2 = cArr[i2];
                    zzasa zzasaVar = this.zzc;
                    zzasa zzasaVar2 = zzasa.STRICT;
                    if (zzasaVar == zzasaVar2 && c2 < ' ') {
                        throw zzv("Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode");
                    }
                    if (c2 == c) {
                        int i6 = (i5 - i4) - 1;
                        this.zze = i5;
                        if (sb == null) {
                            return new String(cArr, i4, i6);
                        }
                        sb.append(cArr, i4, i6);
                        return sb.toString();
                    }
                    char c3 = '\n';
                    if (c2 == '\\') {
                        int i7 = i5 - i4;
                        int i8 = i7 - 1;
                        this.zze = i5;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max(i7 + i7, 16));
                        }
                        sb.append(cArr, i4, i8);
                        if (this.zze == this.zzf && !zzr(1)) {
                            throw zzv("Unterminated escape sequence");
                        }
                        int i9 = this.zze;
                        int i10 = i9 + 1;
                        this.zze = i10;
                        char c4 = cArr[i9];
                        if (c4 != '\n') {
                            if (c4 == '\"') {
                                c3 = c4;
                            } else {
                                if (c4 != '\'') {
                                    if (c4 != '/' && c4 != '\\') {
                                        if (c4 == 'b') {
                                            c3 = '\b';
                                        } else if (c4 == 'f') {
                                            c3 = '\f';
                                        } else if (c4 != 'n') {
                                            if (c4 == 'r') {
                                                c3 = '\r';
                                            } else if (c4 == 't') {
                                                c3 = '\t';
                                            } else {
                                                if (c4 != 'u') {
                                                    throw zzv("Invalid escape sequence");
                                                }
                                                if (i9 + 5 > this.zzf && !zzr(4)) {
                                                    throw zzv("Unterminated escape sequence");
                                                }
                                                int i11 = this.zze;
                                                int i12 = i11 + 4;
                                                int i13 = 0;
                                                while (i11 < i12) {
                                                    int i14 = i13 << 4;
                                                    char c5 = cArr[i11];
                                                    if (c5 >= '0' && c5 <= '9') {
                                                        i = c5 - '0';
                                                    } else if (c5 >= 'a' && c5 <= 'f') {
                                                        i = c5 - 'W';
                                                    } else {
                                                        if (c5 < 'A' || c5 > 'F') {
                                                            throw zzv("Malformed Unicode escape \\u".concat(new String(cArr, this.zze, 4)));
                                                        }
                                                        i = c5 - '7';
                                                    }
                                                    i13 = i14 + i;
                                                    i11++;
                                                }
                                                this.zze += 4;
                                                c3 = (char) i13;
                                            }
                                        }
                                    }
                                }
                                c3 = c4;
                            }
                            sb.append(c3);
                            i4 = this.zze;
                            i3 = this.zzf;
                            i2 = i4;
                        } else {
                            if (this.zzc == zzasaVar2) {
                                throw zzv("Cannot escape a newline character in strict mode");
                            }
                            this.zzg++;
                            this.zzh = i10;
                        }
                        if (this.zzc == zzasaVar2) {
                            throw zzv("Invalid escaped character \"'\" in strict mode");
                        }
                        c3 = c4;
                        sb.append(c3);
                        i4 = this.zze;
                        i3 = this.zzf;
                        i2 = i4;
                    } else {
                        if (c2 == '\n') {
                            this.zzg++;
                            this.zzh = i5;
                        }
                        i2 = i5;
                    }
                }
            }
            int i15 = i2 - i4;
            if (sb == null) {
                sb = new StringBuilder(Math.max(i15 + i15, 16));
            }
            sb.append(cArr, i4, i15);
            this.zze = i2;
        } while (zzr(1));
        throw zzv("Unterminated string");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0042. Please report as an issue. */
    private final String zzp() throws IOException {
        String string;
        int i = 0;
        StringBuilder sb = null;
        while (true) {
            int i2 = 0;
            while (true) {
                int i3 = this.zze + i2;
                if (i3 < this.zzf) {
                    char c = this.zzd[i3];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        zzt();
                    }
                    i = i2;
                } else if (i2 >= 1024) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.zzd, this.zze, i2);
                    this.zze += i2;
                    if (!zzr(1)) {
                    }
                } else if (!zzr(i2 + 1)) {
                    i = i2;
                }
                char[] cArr = this.zzd;
                if (sb == null) {
                    string = new String(cArr, this.zze, i);
                } else {
                    sb.append(cArr, this.zze, i);
                    string = sb.toString();
                }
                this.zze += i;
                return string;
            }
        }
    }

    private final void zzq(int i) throws zzasv {
        int i2 = this.zzl;
        if (i2 - 1 >= 1280) {
            String strZzl = zzl();
            StringBuilder sb = new StringBuilder(strZzl.length() + 26);
            sb.append("Nesting limit 1280 reached");
            sb.append(strZzl);
            throw new zzasv(sb.toString());
        }
        int[] iArr = this.zzk;
        if (i2 == iArr.length) {
            int i3 = i2 + i2;
            this.zzk = Arrays.copyOf(iArr, i3);
            this.zzn = Arrays.copyOf(this.zzn, i3);
            this.zzm = (String[]) Arrays.copyOf(this.zzm, i3);
        }
        int[] iArr2 = this.zzk;
        int i4 = this.zzl;
        this.zzl = i4 + 1;
        iArr2[i4] = i;
    }

    private final boolean zzr(int i) throws IOException {
        int i2;
        int i3 = this.zzh;
        int i4 = this.zze;
        this.zzh = i3 - i4;
        char[] cArr = this.zzd;
        int i5 = this.zzf;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.zzf = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.zzf = 0;
        }
        this.zze = 0;
        do {
            Reader reader = this.zzb;
            int i7 = this.zzf;
            int i8 = reader.read(cArr, i7, 1024 - i7);
            if (i8 == -1) {
                return false;
            }
            i2 = this.zzf + i8;
            this.zzf = i2;
            if (this.zzg == 0 && this.zzh == 0 && i2 > 0 && cArr[0] == 65279) {
                this.zze++;
                this.zzh = 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    private final int zzs(boolean z) throws IOException {
        int i = this.zze;
        int i2 = this.zzf;
        while (true) {
            if (i == i2) {
                this.zze = i;
                if (!zzr(1)) {
                    if (z) {
                        throw new EOFException("End of input".concat(zzl()));
                    }
                    return -1;
                }
                i = this.zze;
                i2 = this.zzf;
            }
            char[] cArr = this.zzd;
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.zzg++;
                this.zzh = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.zze = i3;
                    if (i3 == i2) {
                        this.zze = i;
                        boolean zZzr = zzr(2);
                        this.zze++;
                        if (!zZzr) {
                            return 47;
                        }
                    }
                    zzt();
                    int i4 = this.zze;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.zze = i4 + 1;
                        while (true) {
                            if (this.zze + 2 > this.zzf && !zzr(2)) {
                                throw zzv("Unterminated comment");
                            }
                            int i5 = this.zze;
                            if (cArr[i5] != '\n') {
                                int i6 = 0;
                                while (true) {
                                    int i7 = this.zze;
                                    if (i6 >= 2) {
                                        i = i7 + 2;
                                        i2 = this.zzf;
                                        break;
                                    }
                                    if (cArr[i7 + i6] != "*/".charAt(i6)) {
                                        break;
                                    }
                                    i6++;
                                }
                            } else {
                                this.zzg++;
                                this.zzh = i5 + 1;
                            }
                            this.zze++;
                        }
                    } else {
                        if (c2 != '/') {
                            return 47;
                        }
                        this.zze = i4 + 1;
                        zzu();
                        i = this.zze;
                        i2 = this.zzf;
                    }
                } else {
                    if (c != '#') {
                        this.zze = i3;
                        return c;
                    }
                    this.zze = i3;
                    zzt();
                    zzu();
                    i = this.zze;
                    i2 = this.zzf;
                }
            }
            i = i3;
        }
    }

    private final void zzt() throws zzasv {
        if (this.zzc != zzasa.LENIENT) {
            throw zzv("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    private final void zzu() throws IOException {
        char c;
        do {
            if (this.zze >= this.zzf && !zzr(1)) {
                return;
            }
            char[] cArr = this.zzd;
            int i = this.zze;
            int i2 = i + 1;
            this.zze = i2;
            c = cArr[i];
            if (c == '\n') {
                this.zzg++;
                this.zzh = i2;
                return;
            }
        } while (c != '\r');
    }

    private final zzasv zzv(String str) throws zzasv {
        String strZzl = zzl();
        StringBuilder sb = new StringBuilder(str.length() + strZzl.length() + 79);
        sb.append(str);
        sb.append(strZzl);
        sb.append("\nSee https://github.com/google/gson/blob/main/Troubleshooting.md#malformed-json");
        throw new zzasv(sb.toString());
    }

    private final IllegalStateException zzw(String str) throws IOException {
        int iZzm = zzm();
        String strZza = zzast.zza(zzm());
        String strZzl = zzl();
        int length = str.length() + 18 + strZza.length() + strZzl.length();
        String strConcat = "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(iZzm == 9 ? "adapter-not-null-safe" : "unexpected-json-structure");
        StringBuilder sb = new StringBuilder(length + 5 + strConcat.length());
        sb.append("Expected ");
        sb.append(str);
        sb.append(" but was ");
        sb.append(strZza);
        sb.append(strZzl);
        sb.append("\nSee ");
        sb.append(strConcat);
        return new IllegalStateException(sb.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza = 0;
        this.zzk[0] = 8;
        this.zzl = 1;
        this.zzb.close();
    }

    public final String toString() {
        String simpleName = getClass().getSimpleName();
        String strZzl = zzl();
        String.valueOf(simpleName);
        return String.valueOf(simpleName).concat(strZzl);
    }

    public final void zza(zzasa zzasaVar) {
        Objects.requireNonNull(zzasaVar);
        this.zzc = zzasaVar;
    }

    public final void zzb() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 3) {
            throw zzw("BEGIN_ARRAY");
        }
        zzq(1);
        this.zzn[this.zzl - 1] = 0;
        this.zza = 0;
    }

    public final void zzc() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 4) {
            throw zzw("END_ARRAY");
        }
        int i = this.zzl;
        this.zzl = i - 1;
        int[] iArr = this.zzn;
        int i2 = i - 2;
        iArr[i2] = iArr[i2] + 1;
        this.zza = 0;
    }

    public final void zzd() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 1) {
            throw zzw("BEGIN_OBJECT");
        }
        zzq(3);
        this.zza = 0;
    }

    public final void zze() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 2) {
            throw zzw("END_OBJECT");
        }
        int i = this.zzl;
        int i2 = i - 1;
        this.zzl = i2;
        this.zzm[i2] = null;
        int[] iArr = this.zzn;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        this.zza = 0;
    }

    public final boolean zzf() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        return (iZzg == 2 || iZzg == 4 || iZzg == 17) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0189  */
    /* JADX WARN: Code duplicated, block: B:113:0x0199  */
    /* JADX WARN: Code duplicated, block: B:117:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:121:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:122:0x01b7 A[PHI: r2 r7
      0x01b7: PHI (r2v39 int) = (r2v38 int), (r2v41 int) binds: [B:112:0x0197, B:121:0x01b1] A[DONT_GENERATE, DONT_INLINE]
      0x01b7: PHI (r7v14 int) = (r7v13 int), (r7v15 int) binds: [B:112:0x0197, B:121:0x01b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:124:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:126:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:165:0x022e  */
    /* JADX WARN: Code duplicated, block: B:166:0x0230  */
    /* JADX WARN: Code duplicated, block: B:168:0x0236 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:169:0x0238  */
    /* JADX WARN: Code duplicated, block: B:170:0x023a  */
    /* JADX WARN: Code duplicated, block: B:173:0x0240 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:175:0x0243 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:180:0x0257 A[DONT_INVERT, PHI: r8 r15
      0x0257: PHI (r8v20 int) = (r8v19 int), (r8v21 int) binds: [B:164:0x022c, B:179:0x0255] A[DONT_GENERATE, DONT_INLINE]
      0x0257: PHI (r15v17 int) = (r15v8 int), (r15v18 int) binds: [B:164:0x022c, B:179:0x0255] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:181:0x0259  */
    /* JADX WARN: Code duplicated, block: B:193:0x027a  */
    /* JADX WARN: Code duplicated, block: B:195:0x0280  */
    /* JADX WARN: Code duplicated, block: B:198:0x0285  */
    /* JADX WARN: Code duplicated, block: B:203:0x0294 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:204:0x0295  */
    /* JADX WARN: Code duplicated, block: B:206:0x029f  */
    /* JADX WARN: Code duplicated, block: B:208:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:210:0x02ac A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:215:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:224:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:226:0x02da  */
    /* JADX WARN: Code duplicated, block: B:242:0x030c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:243:0x030e  */
    /* JADX WARN: Code duplicated, block: B:245:0x0312  */
    /* JADX WARN: Code duplicated, block: B:247:0x0324  */
    /* JADX WARN: Code duplicated, block: B:248:0x0327  */
    /* JADX WARN: Code duplicated, block: B:250:0x032c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:252:0x032f  */
    /* JADX WARN: Code duplicated, block: B:254:0x0334  */
    /* JADX WARN: Code duplicated, block: B:256:0x033c  */
    /* JADX WARN: Code duplicated, block: B:265:0x019f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:266:0x019d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:267:0x01aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00f0  */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0240, code lost:
    
        if (r3 == 0) goto L177;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzg() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 833
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzass.zzg():int");
    }

    public final String zzh() throws IOException {
        String strZzo;
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg == 14) {
            strZzo = zzp();
        } else if (iZzg == 12) {
            strZzo = zzo('\'');
        } else {
            if (iZzg != 13) {
                throw zzw("a name");
            }
            strZzo = zzo('\"');
        }
        this.zza = 0;
        this.zzm[this.zzl - 1] = strZzo;
        return strZzo;
    }

    public final String zzi() throws IOException {
        String string;
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg == 10) {
            string = zzp();
        } else if (iZzg == 8) {
            string = zzo('\'');
        } else if (iZzg == 9) {
            string = zzo('\"');
        } else if (iZzg == 11) {
            string = null;
        } else if (iZzg == 15) {
            string = Long.toString(this.zzi);
        } else {
            if (iZzg != 16) {
                throw zzw("a string");
            }
            String str = new String(this.zzd, this.zze, this.zzj);
            this.zze += this.zzj;
            string = str;
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i = this.zzl - 1;
        iArr[i] = iArr[i] + 1;
        return string;
    }

    public final boolean zzj() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg == 5) {
            this.zza = 0;
            int[] iArr = this.zzn;
            int i = this.zzl - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iZzg != 6) {
            throw zzw("a boolean");
        }
        this.zza = 0;
        int[] iArr2 = this.zzn;
        int i2 = this.zzl - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return false;
    }

    public final void zzk() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 7) {
            throw zzw(AbstractJsonLexerKt.NULL);
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i = this.zzl - 1;
        iArr[i] = iArr[i] + 1;
    }

    final String zzl() {
        int i = this.zzg + 1;
        int i2 = this.zze - this.zzh;
        StringBuilder sb = new StringBuilder("$");
        for (int i3 = 0; i3 < this.zzl; i3++) {
            int i4 = this.zzk[i3];
            switch (i4) {
                case 1:
                case 2:
                    int i5 = this.zzn[i3];
                    sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                    sb.append(i5);
                    sb.append(AbstractJsonLexerKt.END_LIST);
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                    String str = this.zzm[i3];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 21);
                    sb2.append("Unknown scope value: ");
                    sb2.append(i4);
                    throw new AssertionError(sb2.toString());
            }
        }
        int i6 = i2 + 1;
        String string = sb.toString();
        StringBuilder sb3 = new StringBuilder(String.valueOf(i).length() + 17 + String.valueOf(i6).length() + 6 + string.length());
        sb3.append(" at line ");
        sb3.append(i);
        sb3.append(" column ");
        sb3.append(i6);
        sb3.append(" path ");
        sb3.append(string);
        return sb3.toString();
    }

    public final int zzm() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        switch (iZzg) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }
}
