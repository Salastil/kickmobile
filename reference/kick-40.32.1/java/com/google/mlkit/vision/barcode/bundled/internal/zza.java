package com.google.mlkit.vision.barcode.bundled.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.Image;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzam;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzao;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzap;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaq;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzar;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzas;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzat;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzau;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzav;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaw;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzax;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzay;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzba;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbe;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbm;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzci;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzck;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.libraries.barhopper.BarhopperV3;
import com.google.android.libraries.barhopper.MultiScaleDecodingOptions;
import com.google.android.libraries.barhopper.MultiScaleDetectionOptions;
import com.google.android.libraries.barhopper.RecognitionOptions;
import com.google.barhopper.deeplearning.BarhopperV3Options;
import com.google.barhopper.deeplearning.zzab;
import com.google.barhopper.deeplearning.zzac;
import com.google.barhopper.deeplearning.zze;
import com.google.barhopper.deeplearning.zzf;
import com.google.barhopper.deeplearning.zzh;
import com.google.barhopper.deeplearning.zzi;
import com.google.barhopper.deeplearning.zzk;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.photos.vision.barhopper.BarhopperProto$BarhopperResponse;
import com.google.photos.vision.barhopper.zzae;
import com.google.photos.vision.barhopper.zzaf;
import com.google.photos.vision.barhopper.zzah;
import com.google.photos.vision.barhopper.zzak;
import com.google.photos.vision.barhopper.zzb;
import com.google.photos.vision.barhopper.zzc;
import com.google.photos.vision.barhopper.zzl;
import com.google.photos.vision.barhopper.zzn;
import com.google.photos.vision.barhopper.zzp;
import com.google.photos.vision.barhopper.zzr;
import com.google.photos.vision.barhopper.zzv;
import com.google.photos.vision.barhopper.zzz;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zza extends zzbm {
    private static final int[] zza = {5, 7, 7, 7, 5, 5};
    private static final double[][] zzb = {new double[]{0.075d, 1.0d}, new double[]{0.1d, 1.0d}, new double[]{0.125d, 1.0d}, new double[]{0.2d, 2.0d}, new double[]{0.2d, 0.5d}, new double[]{0.15d, 1.0d}, new double[]{0.2d, 1.0d}, new double[]{0.25d, 1.0d}, new double[]{0.35d, 2.0d}, new double[]{0.35d, 0.5d}, new double[]{0.35d, 3.0d}, new double[]{0.35d, 0.3333d}, new double[]{0.3d, 1.0d}, new double[]{0.4d, 1.0d}, new double[]{0.5d, 1.0d}, new double[]{0.5d, 2.0d}, new double[]{0.5d, 0.5d}, new double[]{0.5d, 3.0d}, new double[]{0.5d, 0.3333d}, new double[]{0.6d, 1.0d}, new double[]{0.8d, 1.0d}, new double[]{1.0d, 1.0d}, new double[]{0.65d, 2.0d}, new double[]{0.65d, 0.5d}, new double[]{0.65d, 3.0d}, new double[]{0.65d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.8d, 2.0d}, new double[]{0.8d, 0.5d}, new double[]{0.8d, 3.0d}, new double[]{0.8d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.95d, 2.0d}, new double[]{0.95d, 0.5d}, new double[]{0.95d, 3.0d}, new double[]{0.95d, 0.3333d}};
    private final Context zzc;
    private final zzba zzd;
    private BarhopperV3 zze;

    zza(Context context, zzba zzbaVar) {
        this.zzc = context;
        this.zzd = zzbaVar;
    }

    private final RecognitionOptions zzg() {
        RecognitionOptions recognitionOptions = new RecognitionOptions();
        recognitionOptions.setBarcodeFormats(this.zzd.zza());
        recognitionOptions.setOutputUnrecognizedBarcodes(this.zzd.zzb());
        recognitionOptions.setEnableQrAlignmentGrid(true);
        recognitionOptions.setEnableUseKeypointAsFinderPattern(true);
        return recognitionOptions;
    }

    private static zzan zzh(zzl zzlVar, String str, String str2) {
        if (zzlVar == null || str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile(str2).matcher(str);
        return new zzan(zzlVar.zzf(), zzlVar.zzd(), zzlVar.zza(), zzlVar.zzb(), zzlVar.zzc(), zzlVar.zze(), zzlVar.zzj(), matcher.find() ? matcher.group(1) : null);
    }

    private final BarhopperProto$BarhopperResponse zzi(ByteBuffer byteBuffer, zzcc zzccVar, RecognitionOptions recognitionOptions) {
        BarhopperV3 barhopperV3 = (BarhopperV3) Preconditions.checkNotNull(this.zze);
        if (((ByteBuffer) Preconditions.checkNotNull(byteBuffer)).isDirect()) {
            return barhopperV3.recognize(zzccVar.zzd(), zzccVar.zza(), byteBuffer, recognitionOptions);
        }
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return barhopperV3.recognize(zzccVar.zzd(), zzccVar.zza(), byteBuffer.array(), recognitionOptions);
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return barhopperV3.recognize(zzccVar.zzd(), zzccVar.zza(), bArr, recognitionOptions);
    }

    private final List zzj(IObjectWrapper iObjectWrapper, zzcc zzccVar, RecognitionOptions recognitionOptions) {
        BarhopperProto$BarhopperResponse barhopperProto$BarhopperResponseRecognize;
        zzar zzarVar;
        zzau zzauVar;
        zzav zzavVar;
        zzax zzaxVar;
        zzaw zzawVar;
        zzas zzasVar;
        zzao zzaoVar;
        zzap zzapVar;
        zzaq zzaqVar;
        int i;
        int i2;
        Point[] pointArr;
        int i3;
        zzau[] zzauVarArr;
        zzar[] zzarVarArr;
        zzam[] zzamVarArr;
        int iZzb = zzccVar.zzb();
        int i4 = -1;
        if (iZzb == -1) {
            barhopperProto$BarhopperResponseRecognize = ((BarhopperV3) Preconditions.checkNotNull(this.zze)).recognize((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), recognitionOptions);
        } else if (iZzb == 17) {
            barhopperProto$BarhopperResponseRecognize = zzi((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzccVar, recognitionOptions);
        } else if (iZzb != 35) {
            if (iZzb != 842094169) {
                throw new IllegalArgumentException("Unsupported image format: " + zzccVar.zzb());
            }
            barhopperProto$BarhopperResponseRecognize = zzi((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzccVar, recognitionOptions);
        } else {
            barhopperProto$BarhopperResponseRecognize = zzi(((Image) Preconditions.checkNotNull((Image) ObjectWrapper.unwrap(iObjectWrapper))).getPlanes()[0].getBuffer(), zzccVar, recognitionOptions);
        }
        ArrayList arrayList = new ArrayList();
        Matrix uprightRotationMatrix = ImageUtils.getInstance().getUprightRotationMatrix(zzccVar.zzd(), zzccVar.zza(), zzccVar.zzc());
        for (zzc zzcVar : barhopperProto$BarhopperResponseRecognize.zzc()) {
            if (zzcVar.zza() > 0 && uprightRotationMatrix != null) {
                float[] fArr = new float[8];
                List listZzo = zzcVar.zzo();
                int iZza = zzcVar.zza();
                for (int i5 = 0; i5 < iZza; i5++) {
                    int i6 = i5 + i5;
                    fArr[i6] = ((zzaf) listZzo.get(i5)).zza();
                    fArr[i6 + 1] = ((zzaf) listZzo.get(i5)).zzb();
                }
                uprightRotationMatrix.mapPoints(fArr);
                int iZzc = zzccVar.zzc();
                int i7 = 0;
                while (i7 < iZza) {
                    zzb zzbVar = (zzb) zzcVar.zzH();
                    int i8 = i7 + i7;
                    zzae zzaeVarZzc = zzaf.zzc();
                    zzaeVarZzc.zza((int) fArr[i8]);
                    zzaeVarZzc.zzb((int) fArr[i8 + 1]);
                    zzbVar.zza((i7 + iZzc) % iZza, (zzaf) zzaeVarZzc.zzj());
                    zzcVar = (zzc) zzbVar.zzj();
                    i7++;
                    i4 = i4;
                }
            }
            int i9 = i4;
            if (zzcVar.zzt()) {
                zzv zzvVarZzh = zzcVar.zzh();
                zzarVar = new zzar(zzvVarZzh.zzf() - 1, zzvVarZzh.zzc(), zzvVarZzh.zze(), zzvVarZzh.zzd());
            } else {
                zzarVar = null;
            }
            if (zzcVar.zzv()) {
                zzco zzcoVarZzb = zzcVar.zzb();
                zzauVar = new zzau(zzcoVarZzb.zzd() - 1, zzcoVarZzb.zzc());
            } else {
                zzauVar = null;
            }
            if (zzcVar.zzw()) {
                zzah zzahVarZzj = zzcVar.zzj();
                zzavVar = new zzav(zzahVarZzj.zzc(), zzahVarZzj.zzd());
            } else {
                zzavVar = null;
            }
            if (zzcVar.zzy()) {
                com.google.photos.vision.barhopper.zzao zzaoVarZzl = zzcVar.zzl();
                zzaxVar = new zzax(zzaoVarZzl.zzd(), zzaoVarZzl.zzc(), zzaoVarZzl.zze() - 1);
            } else {
                zzaxVar = null;
            }
            if (zzcVar.zzx()) {
                zzak zzakVarZzk = zzcVar.zzk();
                zzawVar = new zzaw(zzakVarZzk.zzc(), zzakVarZzk.zzd());
            } else {
                zzawVar = null;
            }
            if (zzcVar.zzu()) {
                zzz zzzVarZzi = zzcVar.zzi();
                zzasVar = new zzas(zzzVarZzi.zza(), zzzVarZzi.zzb());
            } else {
                zzasVar = null;
            }
            if (zzcVar.zzq()) {
                zzn zznVarZzd = zzcVar.zzd();
                zzaoVar = new zzao(zznVarZzd.zzj(), zznVarZzd.zze(), zznVarZzd.zzf(), zznVarZzd.zzh(), zznVarZzd.zzi(), zzh(zznVarZzd.zzb(), zzcVar.zzm().zzn() ? zzcVar.zzm().zzt() : null, "DTSTART:([0-9TZ]*)"), zzh(zznVarZzd.zza(), zzcVar.zzm().zzn() ? zzcVar.zzm().zzt() : null, "DTEND:([0-9TZ]*)"));
            } else {
                zzaoVar = null;
            }
            if (zzcVar.zzr()) {
                zzp zzpVarZze = zzcVar.zze();
                zzck zzckVarZza = zzpVarZze.zza();
                zzat zzatVar = zzckVarZza != null ? new zzat(zzckVarZza.zzd(), zzckVarZza.zzi(), zzckVarZza.zzh(), zzckVarZza.zzc(), zzckVarZza.zzf(), zzckVarZza.zze(), zzckVarZza.zzj()) : null;
                String strZzd = zzpVarZze.zzd();
                String strZze = zzpVarZze.zze();
                List listZzi = zzpVarZze.zzi();
                if (listZzi.isEmpty()) {
                    zzauVarArr = null;
                } else {
                    zzau[] zzauVarArr2 = new zzau[listZzi.size()];
                    for (int i10 = 0; i10 < listZzi.size(); i10++) {
                        zzauVarArr2[i10] = new zzau(((zzco) listZzi.get(i10)).zzd() - 1, ((zzco) listZzi.get(i10)).zzc());
                    }
                    zzauVarArr = zzauVarArr2;
                }
                List listZzh = zzpVarZze.zzh();
                if (listZzh.isEmpty()) {
                    zzarVarArr = null;
                } else {
                    zzar[] zzarVarArr2 = new zzar[listZzh.size()];
                    for (int i11 = 0; i11 < listZzh.size(); i11++) {
                        zzarVarArr2[i11] = new zzar(((zzv) listZzh.get(i11)).zzf() - 1, ((zzv) listZzh.get(i11)).zzc(), ((zzv) listZzh.get(i11)).zze(), ((zzv) listZzh.get(i11)).zzd());
                    }
                    zzarVarArr = zzarVarArr2;
                }
                String[] strArr = (String[]) zzpVarZze.zzj().toArray(new String[0]);
                List listZzf = zzpVarZze.zzf();
                if (listZzf.isEmpty()) {
                    zzamVarArr = null;
                } else {
                    zzam[] zzamVarArr2 = new zzam[listZzf.size()];
                    for (int i12 = 0; i12 < listZzf.size(); i12++) {
                        zzamVarArr2[i12] = new zzam(((zzci) listZzf.get(i12)).zzc() - 1, (String[]) ((zzci) listZzf.get(i12)).zzb().toArray(new String[0]));
                    }
                    zzamVarArr = zzamVarArr2;
                }
                zzapVar = new zzap(zzatVar, strZzd, strZze, zzauVarArr, zzarVarArr, strArr, zzamVarArr);
            } else {
                zzapVar = null;
            }
            if (zzcVar.zzs()) {
                zzr zzrVarZzf = zzcVar.zzf();
                zzaqVar = new zzaq(zzrVarZzf.zzi(), zzrVarZzf.zzk(), zzrVarZzf.zzq(), zzrVarZzf.zzo(), zzrVarZzf.zzl(), zzrVarZzf.zze(), zzrVarZzf.zzc(), zzrVarZzf.zzd(), zzrVarZzf.zzf(), zzrVarZzf.zzp(), zzrVarZzf.zzm(), zzrVarZzf.zzj(), zzrVarZzf.zzh(), zzrVarZzf.zzn());
            } else {
                zzaqVar = null;
            }
            int i13 = 2;
            switch (zzcVar.zzz() - 1) {
                case 0:
                    i = 0;
                    break;
                case 1:
                    i = 1;
                    break;
                case 2:
                    i = 2;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                    i = 8;
                    break;
                case 5:
                    i2 = 16;
                    i = i2;
                    break;
                case 6:
                    i2 = 32;
                    i = i2;
                    break;
                case 7:
                    i2 = 64;
                    i = i2;
                    break;
                case 8:
                    i2 = 128;
                    i = i2;
                    break;
                case 9:
                    i2 = 256;
                    i = i2;
                    break;
                case 10:
                    i2 = 512;
                    i = i2;
                    break;
                case 11:
                    i2 = 1024;
                    i = i2;
                    break;
                case 12:
                    i2 = 2048;
                    i = i2;
                    break;
                case 13:
                    i2 = 4096;
                    i = i2;
                    break;
                default:
                    i = i9;
                    break;
            }
            String strZzn = zzcVar.zzn();
            String strZzt = zzcVar.zzm().zzn() ? zzcVar.zzm().zzt() : null;
            byte[] bArrZzw = zzcVar.zzm().zzw();
            List listZzo2 = zzcVar.zzo();
            if (listZzo2.isEmpty()) {
                pointArr = null;
            } else {
                Point[] pointArr2 = new Point[listZzo2.size()];
                for (int i14 = 0; i14 < listZzo2.size(); i14++) {
                    pointArr2[i14] = new Point(((zzaf) listZzo2.get(i14)).zza(), ((zzaf) listZzo2.get(i14)).zzb());
                }
                pointArr = pointArr2;
            }
            switch (zzcVar.zzA() - 1) {
                case 1:
                    i3 = 1;
                    continue;
                    arrayList.add(new zzay(i, strZzn, strZzt, bArrZzw, pointArr, i3, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    i4 = i9;
                    break;
                case 2:
                    break;
                case 3:
                    i13 = 3;
                    break;
                case 4:
                    i3 = 4;
                    continue;
                    arrayList.add(new zzay(i, strZzn, strZzt, bArrZzw, pointArr, i3, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    i4 = i9;
                    break;
                case 5:
                    i13 = 5;
                    break;
                case 6:
                    i13 = 6;
                    break;
                case 7:
                    i13 = 7;
                    break;
                case 8:
                    i3 = 8;
                    continue;
                    arrayList.add(new zzay(i, strZzn, strZzt, bArrZzw, pointArr, i3, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    i4 = i9;
                    break;
                case 9:
                    i13 = 9;
                    break;
                case 10:
                    i13 = 10;
                    break;
                case 11:
                    i13 = 11;
                    break;
                case 12:
                    i13 = 12;
                    break;
                default:
                    i3 = 0;
                    continue;
                    arrayList.add(new zzay(i, strZzn, strZzt, bArrZzw, pointArr, i3, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    i4 = i9;
                    break;
            }
            i3 = i13;
            arrayList.add(new zzay(i, strZzn, strZzt, bArrZzw, pointArr, i3, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
            i4 = i9;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final List zzb(IObjectWrapper iObjectWrapper, zzcc zzccVar) {
        return zzj(iObjectWrapper, zzccVar, zzg());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final List zzc(IObjectWrapper iObjectWrapper, zzcc zzccVar, zzbc zzbcVar) {
        RecognitionOptions recognitionOptionsZzg = zzg();
        MultiScaleDecodingOptions multiScaleDecodingOptions = new MultiScaleDecodingOptions();
        multiScaleDecodingOptions.setExtraScales(zzbcVar.zza().zzc());
        multiScaleDecodingOptions.setMinimumDetectedDimension(zzbcVar.zza().zza());
        multiScaleDecodingOptions.setSkipProcessingIfBarcodeFound(zzbcVar.zza().zzb());
        recognitionOptionsZzg.setMultiScaleDecodingOptions(multiScaleDecodingOptions);
        MultiScaleDetectionOptions multiScaleDetectionOptions = new MultiScaleDetectionOptions();
        multiScaleDetectionOptions.setExtraScales(zzbcVar.zza().zzc());
        recognitionOptionsZzg.setMultiScaleDetectionOptions(multiScaleDetectionOptions);
        recognitionOptionsZzg.setQrEnableFourthCornerApproximation(zzbcVar.zzb());
        return zzj(iObjectWrapper, zzccVar, recognitionOptionsZzg);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final void zzd() {
        if (this.zze != null) {
            return;
        }
        this.zze = new BarhopperV3();
        zzh zzhVarZza = zzi.zza();
        zze zzeVarZza = zzf.zza();
        int i = 16;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            com.google.barhopper.deeplearning.zzb zzbVarZza = com.google.barhopper.deeplearning.zzc.zza();
            zzbVarZza.zzc(i);
            zzbVarZza.zzd(i);
            for (int i4 = 0; i4 < zza[i3]; i4++) {
                double[] dArr = zzb[i2];
                double d = dArr[0] * 320.0d;
                float fSqrt = (float) Math.sqrt(dArr[1]);
                float f = (float) d;
                zzbVarZza.zza(f / fSqrt);
                zzbVarZza.zzb(f * fSqrt);
                i2++;
            }
            i += i;
            zzeVarZza.zza(zzbVarZza);
        }
        zzhVarZza.zza(zzeVarZza);
        try {
            InputStream inputStreamOpen = this.zzc.getAssets().open("mlkit_barcode_models/barcode_ssd_mobilenet_v1_dmp25_quant.tflite");
            try {
                InputStream inputStreamOpen2 = this.zzc.getAssets().open("mlkit_barcode_models/oned_auto_regressor_mobile.tflite");
                try {
                    InputStream inputStreamOpen3 = this.zzc.getAssets().open("mlkit_barcode_models/oned_feature_extractor_mobile.tflite");
                    try {
                        BarhopperV3 barhopperV3 = (BarhopperV3) Preconditions.checkNotNull(this.zze);
                        zzk zzkVarZza = BarhopperV3Options.zza();
                        zzhVarZza.zzb(zzdf.zzs(inputStreamOpen));
                        zzkVarZza.zza(zzhVarZza);
                        zzab zzabVarZza = zzac.zza();
                        zzabVarZza.zza(zzdf.zzs(inputStreamOpen2));
                        zzabVarZza.zzb(zzdf.zzs(inputStreamOpen3));
                        zzkVarZza.zzb(zzabVarZza);
                        barhopperV3.create(zzkVarZza.zzj());
                        if (inputStreamOpen3 != null) {
                            inputStreamOpen3.close();
                        }
                        if (inputStreamOpen2 != null) {
                            inputStreamOpen2.close();
                        }
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                    } catch (Throwable th) {
                        if (inputStreamOpen3 != null) {
                            try {
                                inputStreamOpen3.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (inputStreamOpen2 != null) {
                        try {
                            inputStreamOpen2.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to open Barcode models", e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final void zze(zzbe zzbeVar) {
        zzd();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final void zzf() {
        BarhopperV3 barhopperV3 = this.zze;
        if (barhopperV3 != null) {
            barhopperV3.close();
            this.zze = null;
        }
    }
}
