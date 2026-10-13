package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.SieveCacheKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzair;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzit implements Callable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjd zzc;

    zzit(zzjd zzjdVar, zzbh zzbhVar, String str) {
        this.zza = zzbhVar;
        this.zzb = str;
        Objects.requireNonNull(zzjdVar);
        this.zzc = zzjdVar;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0455 A[Catch: all -> 0x0539, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x046b A[Catch: all -> 0x0539, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0476 A[Catch: all -> 0x0539, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x047a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x047c A[Catch: all -> 0x0539, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0492 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:139:0x0265 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x0404 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x03ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x01cd A[Catch: all -> 0x0539, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0206 A[Catch: SecurityException -> 0x0518, all -> 0x0539, TryCatch #1 {SecurityException -> 0x0518, blocks: (B:64:0x01fe, B:66:0x0206, B:68:0x020c), top: B:134:0x01fe, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x022d A[Catch: all -> 0x0539, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0252 A[Catch: all -> 0x0539, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x026a A[Catch: all -> 0x0539, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x026e A[Catch: all -> 0x0539, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x029c A[Catch: all -> 0x0539, LOOP:1: B:86:0x0296->B:88:0x029c, LOOP_END, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0338 A[Catch: all -> 0x0539, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0358 A[Catch: all -> 0x0539, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0394 A[Catch: all -> 0x0539, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x03f0 A[Catch: all -> 0x0539, TryCatch #3 {all -> 0x0539, blocks: (B:9:0x0057, B:11:0x0062, B:14:0x007b, B:16:0x0081, B:17:0x0093, B:19:0x00aa, B:20:0x00b1, B:22:0x00bb, B:23:0x00c8, B:25:0x00d2, B:26:0x00df, B:28:0x00ea, B:29:0x00f2, B:31:0x010a, B:32:0x010d, B:34:0x0127, B:36:0x0137, B:38:0x013f, B:40:0x0145, B:41:0x0148, B:43:0x0157, B:45:0x015d, B:47:0x0167, B:50:0x016e, B:52:0x0182, B:54:0x0188, B:56:0x0192, B:57:0x01a3, B:59:0x01a7, B:61:0x01b4, B:51:0x0177, B:63:0x01cd, B:64:0x01fe, B:66:0x0206, B:68:0x020c, B:69:0x0223, B:71:0x022d, B:72:0x023a, B:73:0x024c, B:75:0x0252, B:82:0x026a, B:85:0x028f, B:86:0x0296, B:88:0x029c, B:89:0x02d0, B:91:0x0338, B:92:0x034c, B:94:0x0358, B:96:0x03ab, B:97:0x03ea, B:99:0x03f0, B:101:0x0404, B:102:0x040f, B:104:0x0455, B:105:0x0463, B:107:0x046b, B:108:0x046e, B:110:0x0476, B:113:0x047f, B:116:0x0494, B:117:0x0497, B:112:0x047c, B:95:0x0394, B:84:0x026e, B:125:0x051a), top: B:138:0x0057, inners: #0, #1 }] */
    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        byte[] bArr;
        zzpg zzpgVar;
        String strZzc;
        zzpg zzpgVar2;
        List listZzn;
        Iterator it;
        zzpn zzpnVar;
        com.google.android.gms.internal.measurement.zziu[] zziuVarArr;
        int i;
        zzic zzicVar;
        Bundle bundle;
        com.google.android.gms.internal.measurement.zzic zzicVar2;
        String str;
        String str2;
        zzbd zzbdVarZzf;
        com.google.android.gms.internal.measurement.zzhz zzhzVar;
        zzh zzhVar;
        String str3;
        Bundle bundle2;
        Object obj;
        long j;
        zzbd zzbdVarZza;
        com.google.android.gms.internal.measurement.zzic zzicVar3;
        com.google.android.gms.internal.measurement.zzhr zzhrVarZzp;
        zzbf zzbfVar;
        zzbe zzbeVar;
        long jZzp;
        long jZzn;
        String strZzh;
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn;
        Object objZza;
        byte[] bArr2;
        zzjd zzjdVar = this.zzc;
        zzjdVar.zzL().zzaa();
        zzlp zzlpVarZzn = zzjdVar.zzL().zzn();
        zzlpVarZzn.zzg();
        zzic zzicVar4 = zzlpVarZzn.zzu;
        zzic.zzL();
        zzbh zzbhVar = this.zza;
        Preconditions.checkNotNull(zzbhVar);
        String str4 = this.zzb;
        Preconditions.checkNotEmpty(str4);
        String str5 = zzbhVar.zza;
        if (!"_iap".equals(str5) && !"_iapx".equals(str5)) {
            zzlpVarZzn.zzu.zzaW().zzj().zzc("Generating a payload for this event is not available. package_name, event_name", str4, str5);
            return null;
        }
        zzpg zzpgVar3 = zzlpVarZzn.zzg;
        com.google.android.gms.internal.measurement.zzhz zzhzVarZzi = com.google.android.gms.internal.measurement.zzib.zzi();
        zzpgVar3.zzj().zzb();
        try {
            zzh zzhVarZzu = zzpgVar3.zzj().zzu(str4);
            if (zzhVarZzu == null) {
                zzlpVarZzn.zzu.zzaW().zzj().zzb("Log and bundle not available. package_name", str4);
                bArr2 = new byte[0];
            } else {
                if (zzhVarZzu.zzD()) {
                    com.google.android.gms.internal.measurement.zzic zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                    zzicVarZzaE.zza(1);
                    zzicVarZzaE.zzC("android");
                    if (!TextUtils.isEmpty(zzhVarZzu.zzc())) {
                        zzicVarZzaE.zzL(zzhVarZzu.zzc());
                    }
                    if (!TextUtils.isEmpty(zzhVarZzu.zzv())) {
                        zzicVarZzaE.zzJ((String) Preconditions.checkNotNull(zzhVarZzu.zzv()));
                    }
                    if (!TextUtils.isEmpty(zzhVarZzu.zzr())) {
                        zzicVarZzaE.zzM((String) Preconditions.checkNotNull(zzhVarZzu.zzr()));
                    }
                    if (zzhVarZzu.zzt() != SieveCacheKt.NodeMetaAndPreviousMask) {
                        zzicVarZzaE.zzaj((int) zzhVarZzu.zzt());
                    }
                    zzicVarZzaE.zzN(zzhVarZzu.zzx());
                    zzicVarZzaE.zzar(zzhVarZzu.zzB());
                    String strZzf = zzhVarZzu.zzf();
                    if (!TextUtils.isEmpty(strZzf)) {
                        zzicVarZzaE.zzad(strZzf);
                    }
                    zzicVarZzaE.zzay(zzhVarZzu.zzak());
                    zzjl zzjlVarZzB = zzlpVarZzn.zzg.zzB(str4);
                    zzicVarZzaE.zzY(zzhVarZzu.zzz());
                    if (zzicVar4.zzB() && zzlpVarZzn.zzu.zzc().zzC(zzicVarZzaE.zzK()) && zzjlVarZzB.zzo(zzjk.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                        zzicVarZzaE.zzam(null);
                    }
                    zzicVarZzaE.zzat(zzjlVarZzB.zzk());
                    zzjk zzjkVar = zzjk.AD_STORAGE;
                    if (zzjlVarZzB.zzo(zzjkVar) && zzhVarZzu.zzac()) {
                        Pair pairZzd = (zzjlVarZzB.zzo(zzjkVar) && zzhVarZzu.zzac()) ? zzpgVar3.zzq().zzd(zzhVarZzu.zzc()) : new Pair("", false);
                        if (!zzhVarZzu.zzac() || TextUtils.isEmpty((CharSequence) pairZzd.first)) {
                            zzic zzicVar5 = zzlpVarZzn.zzu;
                            zzicVar5.zzu().zzw();
                            zzicVarZzaE.zzF(Build.MODEL);
                            zzicVar5.zzu().zzw();
                            zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                            zzicVarZzaE.zzI((int) zzicVar5.zzu().zzb());
                            zzicVarZzaE.zzH(zzicVar5.zzu().zzc());
                            if (zzjlVarZzB.zzo(zzjk.ANALYTICS_STORAGE)) {
                                zzicVarZzaE.zzW(zzlp.zzc((String) Preconditions.checkNotNull(zzhVarZzu.zzd()), Long.toString(zzbhVar.zzd)));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                            }
                            strZzc = zzhVarZzu.zzc();
                            zzpgVar2 = zzlpVarZzn.zzg;
                            listZzn = zzpgVar2.zzj().zzn(strZzc);
                            it = listZzn.iterator();
                            do {
                                if (!it.hasNext()) {
                                    zzpnVar = null;
                                    break;
                                }
                                zzpnVar = (zzpn) it.next();
                            } while (!"_lte".equals(zzpnVar.zzc));
                            if (zzpnVar != null) {
                                zzpn zzpnVar2 = new zzpn(strZzc, "auto", "_lte", zzlpVarZzn.zzu.zzba().currentTimeMillis(), 0L);
                                listZzn.add(zzpnVar2);
                                zzpgVar2.zzj().zzl(zzpnVar2);
                            } else {
                                zzpn zzpnVar3 = new zzpn(strZzc, "auto", "_lte", zzlpVarZzn.zzu.zzba().currentTimeMillis(), 0L);
                                listZzn.add(zzpnVar3);
                                zzpgVar2.zzj().zzl(zzpnVar3);
                            }
                            zziuVarArr = new com.google.android.gms.internal.measurement.zziu[listZzn.size()];
                            for (i = 0; i < listZzn.size(); i++) {
                                com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
                                zzitVarZzm.zzb(((zzpn) listZzn.get(i)).zzc);
                                zzitVarZzm.zza(((zzpn) listZzn.get(i)).zzd);
                                zzpgVar2.zzp().zzc(zzitVarZzm, ((zzpn) listZzn.get(i)).zze);
                                zziuVarArr[i] = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbd();
                            }
                            zzicVarZzaE.zzq(Arrays.asList(zziuVarArr));
                            zzpg zzpgVar4 = zzlpVarZzn.zzg;
                            zzpgVar4.zzI(zzhVarZzu, zzicVarZzaE);
                            zzpgVar4.zzJ(zzhVarZzu, zzicVarZzaE);
                            zzgv zzgvVarZza = zzgv.zza(zzbhVar);
                            zzicVar = zzlpVarZzn.zzu;
                            zzpp zzppVarZzk = zzicVar.zzk();
                            bundle = zzgvVarZza.zze;
                            zzppVarZzk.zzK(bundle, zzpgVar2.zzj().zzV(str4));
                            zzicVar.zzk().zzI(zzgvVarZza, zzicVar.zzc().zzd(str4));
                            zzicVar2 = zzicVarZzaE;
                            bundle.putLong("_c", 1L);
                            zzicVar.zzaW().zzj().zza("Marking in-app purchase as real-time");
                            bundle.putLong("_r", 1L);
                            str = zzbhVar.zzc;
                            bundle.putString("_o", str);
                            if (zzicVar.zzk().zzad(zzicVar2.zzK(), zzhVarZzu.zzay())) {
                                zzicVar.zzk().zzO(bundle, "_dbg", 1L);
                                zzicVar.zzk().zzO(bundle, "_r", 1L);
                            }
                            zzaw zzawVarZzj = zzpgVar2.zzj();
                            str2 = zzbhVar.zza;
                            zzbdVarZzf = zzawVarZzj.zzf(str4, str2);
                            if (zzbdVarZzf == null) {
                                zzhzVar = zzhzVarZzi;
                                zzhVar = zzhVarZzu;
                                bundle2 = bundle;
                                str3 = str;
                                obj = null;
                                zzbdVarZza = new zzbd(str4, str2, 0L, 0L, 0L, zzbhVar.zzd, 0L, null, null, null, null);
                                zzicVar2 = zzicVar2;
                                j = 0;
                            } else {
                                zzhzVar = zzhzVarZzi;
                                zzhVar = zzhVarZzu;
                                str3 = str;
                                bundle2 = bundle;
                                obj = null;
                                j = zzbdVarZzf.zzf;
                                zzbdVarZza = zzbdVarZzf.zza(zzbhVar.zzd);
                            }
                            zzbd zzbdVar = zzbdVarZza;
                            zzpgVar2.zzj().zzh(zzbdVar);
                            zzicVar3 = zzicVar2;
                            zzic zzicVar6 = zzlpVarZzn.zzu;
                            long j2 = zzbhVar.zzd;
                            com.google.android.gms.internal.measurement.zzhz zzhzVar2 = zzhzVar;
                            zzh zzhVar2 = zzhVar;
                            zzbc zzbcVar = new zzbc(zzicVar6, str3, str4, str2, j2, 0L, j, bundle2);
                            zzhrVarZzp = com.google.android.gms.internal.measurement.zzhs.zzp();
                            zzhrVarZzp.zzo(zzbcVar.zzd);
                            zzhrVarZzp.zzl(zzbcVar.zzb);
                            zzhrVarZzp.zzq(zzbcVar.zzf);
                            zzbfVar = zzbcVar.zzg;
                            zzbeVar = new zzbe(zzbfVar);
                            while (zzbeVar.hasNext()) {
                                String next = zzbeVar.next();
                                String str6 = next;
                                zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn.zzb(next);
                                objZza = zzbfVar.zza(next);
                                if (objZza != null) {
                                    zzpgVar2.zzp().zzd(zzhvVarZzn, objZza);
                                    zzhrVarZzp.zzg(zzhvVarZzn);
                                }
                            }
                            zzicVar3.zzg(zzhrVarZzp);
                            com.google.android.gms.internal.measurement.zzie zzieVarZza = com.google.android.gms.internal.measurement.zzig.zza();
                            com.google.android.gms.internal.measurement.zzht zzhtVarZza = com.google.android.gms.internal.measurement.zzhu.zza();
                            zzhtVarZza.zzb(zzbdVar.zzc);
                            zzhtVarZza.zza(str2);
                            zzieVarZza.zza(zzhtVarZza);
                            zzicVar3.zzap(zzieVarZza);
                            zzicVar3.zzaf(zzpgVar2.zzm().zzb(zzhVar2.zzc(), Collections.EMPTY_LIST, zzicVar3.zzk(), Long.valueOf(zzhrVarZzp.zzn()), Long.valueOf(zzhrVarZzp.zzn()), false));
                            if (zzhrVarZzp.zzm()) {
                                zzicVar3.zzv(zzhrVarZzp.zzn());
                                zzicVar3.zzx(zzhrVarZzp.zzn());
                            }
                            jZzp = zzhVar2.zzp();
                            if (jZzp != 0) {
                                zzicVar3.zzA(jZzp);
                            }
                            jZzn = zzhVar2.zzn();
                            if (jZzn != 0) {
                                zzicVar3.zzy(jZzn);
                            } else if (jZzp != 0) {
                                zzicVar3.zzy(jZzp);
                            }
                            strZzh = zzhVar2.zzh();
                            zzair.zza();
                            if (zzicVar.zzc().zzp(str4, zzfy.zzaM)) {
                                zzicVar3.zzau(strZzh);
                            }
                            zzhVar2.zzL();
                            zzicVar3.zzZ((int) zzhVar2.zzG());
                            zzicVar.zzc().zzi();
                            zzicVar3.zzO(161000L);
                            zzicVar3.zzs(zzicVar.zzba().currentTimeMillis());
                            zzicVar3.zzae(true);
                            zzpgVar4.zzS(zzicVar3.zzK(), zzicVar3);
                            zzhzVar2.zze(zzicVar3);
                            zzhVar2.zzo(zzicVar3.zzu());
                            zzhVar2.zzq(zzicVar3.zzw());
                            zzpgVar2.zzj().zzv(zzhVar2, false, false);
                            zzpgVar2.zzj().zzc();
                            zzpgVar2.zzj().zzd();
                            return zzpgVar2.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVar2.zzbd()).zzcd());
                        }
                        try {
                            zzicVarZzaE.zzQ(zzlp.zzc((String) pairZzd.first, Long.toString(zzbhVar.zzd)));
                            if (pairZzd.second != null) {
                                zzicVarZzaE.zzT(((Boolean) pairZzd.second).booleanValue());
                            }
                            zzic zzicVar7 = zzlpVarZzn.zzu;
                            zzicVar7.zzu().zzw();
                            zzicVarZzaE.zzF(Build.MODEL);
                            zzicVar7.zzu().zzw();
                            zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                            zzicVarZzaE.zzI((int) zzicVar7.zzu().zzb());
                            zzicVarZzaE.zzH(zzicVar7.zzu().zzc());
                            if (zzjlVarZzB.zzo(zzjk.ANALYTICS_STORAGE)) {
                                zzicVarZzaE.zzW(zzlp.zzc((String) Preconditions.checkNotNull(zzhVarZzu.zzd()), Long.toString(zzbhVar.zzd)));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                            }
                            strZzc = zzhVarZzu.zzc();
                            zzpgVar2 = zzlpVarZzn.zzg;
                            listZzn = zzpgVar2.zzj().zzn(strZzc);
                            it = listZzn.iterator();
                            do {
                                if (!it.hasNext()) {
                                    zzpnVar = null;
                                    break;
                                }
                                zzpnVar = (zzpn) it.next();
                            } while (!"_lte".equals(zzpnVar.zzc));
                            if (zzpnVar != null) {
                                zzpn zzpnVar4 = new zzpn(strZzc, "auto", "_lte", zzlpVarZzn.zzu.zzba().currentTimeMillis(), 0L);
                                listZzn.add(zzpnVar4);
                                zzpgVar2.zzj().zzl(zzpnVar4);
                            } else {
                                zzpn zzpnVar5 = new zzpn(strZzc, "auto", "_lte", zzlpVarZzn.zzu.zzba().currentTimeMillis(), 0L);
                                listZzn.add(zzpnVar5);
                                zzpgVar2.zzj().zzl(zzpnVar5);
                            }
                            zziuVarArr = new com.google.android.gms.internal.measurement.zziu[listZzn.size()];
                            while (i < listZzn.size()) {
                                com.google.android.gms.internal.measurement.zzit zzitVarZzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
                                zzitVarZzm2.zzb(((zzpn) listZzn.get(i)).zzc);
                                zzitVarZzm2.zza(((zzpn) listZzn.get(i)).zzd);
                                zzpgVar2.zzp().zzc(zzitVarZzm2, ((zzpn) listZzn.get(i)).zze);
                                zziuVarArr[i] = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm2.zzbd();
                            }
                            zzicVarZzaE.zzq(Arrays.asList(zziuVarArr));
                            zzpg zzpgVar5 = zzlpVarZzn.zzg;
                            zzpgVar5.zzI(zzhVarZzu, zzicVarZzaE);
                            zzpgVar5.zzJ(zzhVarZzu, zzicVarZzaE);
                            zzgv zzgvVarZza2 = zzgv.zza(zzbhVar);
                            zzicVar = zzlpVarZzn.zzu;
                            zzpp zzppVarZzk2 = zzicVar.zzk();
                            bundle = zzgvVarZza2.zze;
                            zzppVarZzk2.zzK(bundle, zzpgVar2.zzj().zzV(str4));
                            zzicVar.zzk().zzI(zzgvVarZza2, zzicVar.zzc().zzd(str4));
                            zzicVar2 = zzicVarZzaE;
                            bundle.putLong("_c", 1L);
                            zzicVar.zzaW().zzj().zza("Marking in-app purchase as real-time");
                            bundle.putLong("_r", 1L);
                            str = zzbhVar.zzc;
                            bundle.putString("_o", str);
                            if (zzicVar.zzk().zzad(zzicVar2.zzK(), zzhVarZzu.zzay())) {
                                zzicVar.zzk().zzO(bundle, "_dbg", 1L);
                                zzicVar.zzk().zzO(bundle, "_r", 1L);
                            }
                            zzaw zzawVarZzj2 = zzpgVar2.zzj();
                            str2 = zzbhVar.zza;
                            zzbdVarZzf = zzawVarZzj2.zzf(str4, str2);
                            if (zzbdVarZzf == null) {
                                zzhzVar = zzhzVarZzi;
                                zzhVar = zzhVarZzu;
                                bundle2 = bundle;
                                str3 = str;
                                obj = null;
                                zzbdVarZza = new zzbd(str4, str2, 0L, 0L, 0L, zzbhVar.zzd, 0L, null, null, null, null);
                                zzicVar2 = zzicVar2;
                                j = 0;
                            } else {
                                zzhzVar = zzhzVarZzi;
                                zzhVar = zzhVarZzu;
                                str3 = str;
                                bundle2 = bundle;
                                obj = null;
                                j = zzbdVarZzf.zzf;
                                zzbdVarZza = zzbdVarZzf.zza(zzbhVar.zzd);
                            }
                            zzbd zzbdVar2 = zzbdVarZza;
                            zzpgVar2.zzj().zzh(zzbdVar2);
                            zzicVar3 = zzicVar2;
                            zzic zzicVar8 = zzlpVarZzn.zzu;
                            long j3 = zzbhVar.zzd;
                            com.google.android.gms.internal.measurement.zzhz zzhzVar3 = zzhzVar;
                            zzh zzhVar3 = zzhVar;
                            zzbc zzbcVar2 = new zzbc(zzicVar8, str3, str4, str2, j3, 0L, j, bundle2);
                            zzhrVarZzp = com.google.android.gms.internal.measurement.zzhs.zzp();
                            zzhrVarZzp.zzo(zzbcVar2.zzd);
                            zzhrVarZzp.zzl(zzbcVar2.zzb);
                            zzhrVarZzp.zzq(zzbcVar2.zzf);
                            zzbfVar = zzbcVar2.zzg;
                            zzbeVar = new zzbe(zzbfVar);
                            while (zzbeVar.hasNext()) {
                                String next2 = zzbeVar.next();
                                String str7 = next2;
                                zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn.zzb(next2);
                                objZza = zzbfVar.zza(next2);
                                if (objZza != null) {
                                    zzpgVar2.zzp().zzd(zzhvVarZzn, objZza);
                                    zzhrVarZzp.zzg(zzhvVarZzn);
                                }
                            }
                            zzicVar3.zzg(zzhrVarZzp);
                            com.google.android.gms.internal.measurement.zzie zzieVarZza2 = com.google.android.gms.internal.measurement.zzig.zza();
                            com.google.android.gms.internal.measurement.zzht zzhtVarZza2 = com.google.android.gms.internal.measurement.zzhu.zza();
                            zzhtVarZza2.zzb(zzbdVar2.zzc);
                            zzhtVarZza2.zza(str2);
                            zzieVarZza2.zza(zzhtVarZza2);
                            zzicVar3.zzap(zzieVarZza2);
                            zzicVar3.zzaf(zzpgVar2.zzm().zzb(zzhVar3.zzc(), Collections.EMPTY_LIST, zzicVar3.zzk(), Long.valueOf(zzhrVarZzp.zzn()), Long.valueOf(zzhrVarZzp.zzn()), false));
                            if (zzhrVarZzp.zzm()) {
                                zzicVar3.zzv(zzhrVarZzp.zzn());
                                zzicVar3.zzx(zzhrVarZzp.zzn());
                            }
                            jZzp = zzhVar3.zzp();
                            if (jZzp != 0) {
                                zzicVar3.zzA(jZzp);
                            }
                            jZzn = zzhVar3.zzn();
                            if (jZzn != 0) {
                                zzicVar3.zzy(jZzn);
                            } else if (jZzp != 0) {
                                zzicVar3.zzy(jZzp);
                            }
                            strZzh = zzhVar3.zzh();
                            zzair.zza();
                            if (zzicVar.zzc().zzp(str4, zzfy.zzaM)) {
                                zzicVar3.zzau(strZzh);
                            }
                            zzhVar3.zzL();
                            zzicVar3.zzZ((int) zzhVar3.zzG());
                            zzicVar.zzc().zzi();
                            zzicVar3.zzO(161000L);
                            zzicVar3.zzs(zzicVar.zzba().currentTimeMillis());
                            zzicVar3.zzae(true);
                            zzpgVar5.zzS(zzicVar3.zzK(), zzicVar3);
                            zzhzVar3.zze(zzicVar3);
                            zzhVar3.zzo(zzicVar3.zzu());
                            zzhVar3.zzq(zzicVar3.zzw());
                            zzpgVar2.zzj().zzv(zzhVar3, false, false);
                            zzpgVar2.zzj().zzc();
                            zzpgVar2.zzj().zzd();
                            return zzpgVar2.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVar3.zzbd()).zzcd());
                        } catch (SecurityException e) {
                            zzlpVarZzn.zzu.zzaW().zzj().zzb("Resettable device id encryption failed", e.getMessage());
                            bArr = new byte[0];
                            zzpgVar = zzlpVarZzn.zzg;
                        }
                    } else {
                        zzic zzicVar9 = zzlpVarZzn.zzu;
                        zzicVar9.zzu().zzw();
                        zzicVarZzaE.zzF(Build.MODEL);
                        zzicVar9.zzu().zzw();
                        zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                        zzicVarZzaE.zzI((int) zzicVar9.zzu().zzb());
                        zzicVarZzaE.zzH(zzicVar9.zzu().zzc());
                        try {
                            if (zzjlVarZzB.zzo(zzjk.ANALYTICS_STORAGE) && zzhVarZzu.zzd() != null) {
                                zzicVarZzaE.zzW(zzlp.zzc((String) Preconditions.checkNotNull(zzhVarZzu.zzd()), Long.toString(zzbhVar.zzd)));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                            }
                            strZzc = zzhVarZzu.zzc();
                            zzpgVar2 = zzlpVarZzn.zzg;
                            listZzn = zzpgVar2.zzj().zzn(strZzc);
                            it = listZzn.iterator();
                            do {
                                if (!it.hasNext()) {
                                    zzpnVar = null;
                                    break;
                                }
                                zzpnVar = (zzpn) it.next();
                            } while (!"_lte".equals(zzpnVar.zzc));
                            if (zzpnVar != null || zzpnVar.zze == null) {
                                zzpn zzpnVar6 = new zzpn(strZzc, "auto", "_lte", zzlpVarZzn.zzu.zzba().currentTimeMillis(), 0L);
                                listZzn.add(zzpnVar6);
                                zzpgVar2.zzj().zzl(zzpnVar6);
                            }
                            zziuVarArr = new com.google.android.gms.internal.measurement.zziu[listZzn.size()];
                            while (i < listZzn.size()) {
                                com.google.android.gms.internal.measurement.zzit zzitVarZzm3 = com.google.android.gms.internal.measurement.zziu.zzm();
                                zzitVarZzm3.zzb(((zzpn) listZzn.get(i)).zzc);
                                zzitVarZzm3.zza(((zzpn) listZzn.get(i)).zzd);
                                zzpgVar2.zzp().zzc(zzitVarZzm3, ((zzpn) listZzn.get(i)).zze);
                                zziuVarArr[i] = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm3.zzbd();
                            }
                            zzicVarZzaE.zzq(Arrays.asList(zziuVarArr));
                            zzpg zzpgVar6 = zzlpVarZzn.zzg;
                            zzpgVar6.zzI(zzhVarZzu, zzicVarZzaE);
                            zzpgVar6.zzJ(zzhVarZzu, zzicVarZzaE);
                            zzgv zzgvVarZza3 = zzgv.zza(zzbhVar);
                            zzicVar = zzlpVarZzn.zzu;
                            zzpp zzppVarZzk3 = zzicVar.zzk();
                            bundle = zzgvVarZza3.zze;
                            zzppVarZzk3.zzK(bundle, zzpgVar2.zzj().zzV(str4));
                            zzicVar.zzk().zzI(zzgvVarZza3, zzicVar.zzc().zzd(str4));
                            zzicVar2 = zzicVarZzaE;
                            bundle.putLong("_c", 1L);
                            zzicVar.zzaW().zzj().zza("Marking in-app purchase as real-time");
                            bundle.putLong("_r", 1L);
                            str = zzbhVar.zzc;
                            bundle.putString("_o", str);
                            if (zzicVar.zzk().zzad(zzicVar2.zzK(), zzhVarZzu.zzay())) {
                                zzicVar.zzk().zzO(bundle, "_dbg", 1L);
                                zzicVar.zzk().zzO(bundle, "_r", 1L);
                            }
                            zzaw zzawVarZzj3 = zzpgVar2.zzj();
                            str2 = zzbhVar.zza;
                            zzbdVarZzf = zzawVarZzj3.zzf(str4, str2);
                            if (zzbdVarZzf == null) {
                                zzhzVar = zzhzVarZzi;
                                zzhVar = zzhVarZzu;
                                bundle2 = bundle;
                                str3 = str;
                                obj = null;
                                zzbdVarZza = new zzbd(str4, str2, 0L, 0L, 0L, zzbhVar.zzd, 0L, null, null, null, null);
                                zzicVar2 = zzicVar2;
                                j = 0;
                            } else {
                                zzhzVar = zzhzVarZzi;
                                zzhVar = zzhVarZzu;
                                str3 = str;
                                bundle2 = bundle;
                                obj = null;
                                j = zzbdVarZzf.zzf;
                                zzbdVarZza = zzbdVarZzf.zza(zzbhVar.zzd);
                            }
                            zzbd zzbdVar3 = zzbdVarZza;
                            zzpgVar2.zzj().zzh(zzbdVar3);
                            zzicVar3 = zzicVar2;
                            zzic zzicVar10 = zzlpVarZzn.zzu;
                            long j4 = zzbhVar.zzd;
                            com.google.android.gms.internal.measurement.zzhz zzhzVar4 = zzhzVar;
                            zzh zzhVar4 = zzhVar;
                            zzbc zzbcVar3 = new zzbc(zzicVar10, str3, str4, str2, j4, 0L, j, bundle2);
                            zzhrVarZzp = com.google.android.gms.internal.measurement.zzhs.zzp();
                            zzhrVarZzp.zzo(zzbcVar3.zzd);
                            zzhrVarZzp.zzl(zzbcVar3.zzb);
                            zzhrVarZzp.zzq(zzbcVar3.zzf);
                            zzbfVar = zzbcVar3.zzg;
                            zzbeVar = new zzbe(zzbfVar);
                            while (zzbeVar.hasNext()) {
                                String next3 = zzbeVar.next();
                                String str8 = next3;
                                zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn.zzb(next3);
                                objZza = zzbfVar.zza(next3);
                                if (objZza != null) {
                                    zzpgVar2.zzp().zzd(zzhvVarZzn, objZza);
                                    zzhrVarZzp.zzg(zzhvVarZzn);
                                }
                            }
                            zzicVar3.zzg(zzhrVarZzp);
                            com.google.android.gms.internal.measurement.zzie zzieVarZza3 = com.google.android.gms.internal.measurement.zzig.zza();
                            com.google.android.gms.internal.measurement.zzht zzhtVarZza3 = com.google.android.gms.internal.measurement.zzhu.zza();
                            zzhtVarZza3.zzb(zzbdVar3.zzc);
                            zzhtVarZza3.zza(str2);
                            zzieVarZza3.zza(zzhtVarZza3);
                            zzicVar3.zzap(zzieVarZza3);
                            zzicVar3.zzaf(zzpgVar2.zzm().zzb(zzhVar4.zzc(), Collections.EMPTY_LIST, zzicVar3.zzk(), Long.valueOf(zzhrVarZzp.zzn()), Long.valueOf(zzhrVarZzp.zzn()), false));
                            if (zzhrVarZzp.zzm()) {
                                zzicVar3.zzv(zzhrVarZzp.zzn());
                                zzicVar3.zzx(zzhrVarZzp.zzn());
                            }
                            jZzp = zzhVar4.zzp();
                            if (jZzp != 0) {
                                zzicVar3.zzA(jZzp);
                            }
                            jZzn = zzhVar4.zzn();
                            if (jZzn != 0) {
                                zzicVar3.zzy(jZzn);
                            } else if (jZzp != 0) {
                                zzicVar3.zzy(jZzp);
                            }
                            strZzh = zzhVar4.zzh();
                            zzair.zza();
                            if (zzicVar.zzc().zzp(str4, zzfy.zzaM) && strZzh != null) {
                                zzicVar3.zzau(strZzh);
                            }
                            zzhVar4.zzL();
                            zzicVar3.zzZ((int) zzhVar4.zzG());
                            zzicVar.zzc().zzi();
                            zzicVar3.zzO(161000L);
                            zzicVar3.zzs(zzicVar.zzba().currentTimeMillis());
                            zzicVar3.zzae(true);
                            zzpgVar6.zzS(zzicVar3.zzK(), zzicVar3);
                            zzhzVar4.zze(zzicVar3);
                            zzhVar4.zzo(zzicVar3.zzu());
                            zzhVar4.zzq(zzicVar3.zzw());
                            zzpgVar2.zzj().zzv(zzhVar4, false, false);
                            zzpgVar2.zzj().zzc();
                            zzpgVar2.zzj().zzd();
                            try {
                                return zzpgVar2.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVar4.zzbd()).zzcd());
                            } catch (IOException e2) {
                                zzlpVarZzn.zzu.zzaW().zzb().zzc("Data loss. Failed to bundle and serialize. appId", zzgu.zzl(str4), e2);
                                return obj;
                            }
                        } catch (SecurityException e3) {
                            zzlpVarZzn.zzu.zzaW().zzj().zzb("app instance id encryption failed", e3.getMessage());
                            bArr = new byte[0];
                            zzpgVar = zzlpVarZzn.zzg;
                        }
                    }
                    zzpgVar.zzj().zzd();
                    return bArr;
                }
                zzlpVarZzn.zzu.zzaW().zzj().zzb("Log and bundle disabled. package_name", str4);
                bArr2 = new byte[0];
            }
            zzpgVar3.zzj().zzd();
            return bArr2;
        } catch (Throwable th) {
            zzlpVarZzn.zzg.zzj().zzd();
            throw th;
        }
    }
}
