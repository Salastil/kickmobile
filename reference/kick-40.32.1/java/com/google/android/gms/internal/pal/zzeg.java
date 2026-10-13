package com.google.android.gms.internal.pal;

import expo.modules.crypto.aes.AesConfig;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeg {
    private static Cipher zza;
    private static final Object zzb = new Object();
    private static final Object zzc = new Object();

    public zzeg(SecureRandom secureRandom) {
    }

    private static final Cipher zzc() throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher;
        synchronized (zzc) {
            if (zza == null) {
                zza = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = zza;
        }
        return cipher;
    }

    public final String zza(byte[] bArr, byte[] bArr2) throws zzef {
        byte[] bArrDoFinal;
        byte[] iv;
        int length = bArr.length;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AesConfig.CRYPTO_KEY_ALGORITHM);
            synchronized (zzb) {
                zzc().init(1, secretKeySpec, (SecureRandom) null);
                bArrDoFinal = zzc().doFinal(bArr2);
                iv = zzc().getIV();
            }
            int length2 = bArrDoFinal.length + iv.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length2);
            byteBufferAllocate.put(iv).put(bArrDoFinal);
            byteBufferAllocate.flip();
            byte[] bArr3 = new byte[length2];
            byteBufferAllocate.get(bArr3);
            return zzcn.zza(bArr3, false);
        } catch (InvalidKeyException e) {
            throw new zzef(this, e);
        } catch (NoSuchAlgorithmException e2) {
            throw new zzef(this, e2);
        } catch (BadPaddingException e3) {
            throw new zzef(this, e3);
        } catch (IllegalBlockSizeException e4) {
            throw new zzef(this, e4);
        } catch (NoSuchPaddingException e5) {
            throw new zzef(this, e5);
        }
    }

    public final byte[] zzb(byte[] bArr, String str) throws zzef {
        byte[] bArrDoFinal;
        int length = bArr.length;
        try {
            byte[] bArrZzb = zzcn.zzb(str, false);
            int length2 = bArrZzb.length;
            if (length2 <= 16) {
                throw new zzef(this);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length2);
            byteBufferAllocate.put(bArrZzb);
            byteBufferAllocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[length2 - 16];
            byteBufferAllocate.get(bArr2);
            byteBufferAllocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AesConfig.CRYPTO_KEY_ALGORITHM);
            synchronized (zzb) {
                zzc().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                bArrDoFinal = zzc().doFinal(bArr3);
            }
            return bArrDoFinal;
        } catch (IllegalArgumentException e) {
            throw new zzef(this, e);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new zzef(this, e2);
        } catch (InvalidKeyException e3) {
            throw new zzef(this, e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new zzef(this, e4);
        } catch (BadPaddingException e5) {
            throw new zzef(this, e5);
        } catch (IllegalBlockSizeException e6) {
            throw new zzef(this, e6);
        } catch (NoSuchPaddingException e7) {
            throw new zzef(this, e7);
        }
    }
}
