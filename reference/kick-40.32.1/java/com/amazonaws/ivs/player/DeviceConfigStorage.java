package com.amazonaws.ivs.player;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes5.dex */
class DeviceConfigStorage {
    private static final byte[] SIGNATURE = "ivs-gzip".getBytes(StandardCharsets.US_ASCII);
    private static final String TAG = "DeviceConfig";
    private final Context mContext;
    private final String mDirectoryName;
    private final long mHandle;

    DeviceConfigStorage(Context context, String str, long j) {
        this.mContext = context.getApplicationContext();
        this.mDirectoryName = str;
        this.mHandle = j;
    }

    byte[] readFile(String str) {
        File fileResolveFileName = resolveFileName(str, true);
        if (fileResolveFileName == null) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(fileResolveFileName);
            try {
                byte[] bArr = SIGNATURE;
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                if (fileInputStream.read(bArr2) != length || !Arrays.equals(bArr2, bArr)) {
                    throw new IOException("Invalid signature");
                }
                GZIPInputStream gZIPInputStream = new GZIPInputStream(fileInputStream);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr3 = new byte[16384];
                    while (true) {
                        int i = gZIPInputStream.read(bArr3);
                        if (i > 0) {
                            byteArrayOutputStream.write(bArr3, 0, i);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            gZIPInputStream.close();
                            fileInputStream.close();
                            return byteArray;
                        }
                        try {
                            fileInputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        gZIPInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                fileInputStream.close();
                throw th4;
            }
        } catch (IOException e) {
            Log.e(TAG, "Cannot read file " + fileResolveFileName, e);
            return null;
        }
        Log.e(TAG, "Cannot read file " + fileResolveFileName, e);
        return null;
    }

    boolean writeFile(String str, byte[] bArr) {
        File fileResolveFileName;
        File fileResolveFileName2 = resolveFileName(str + "-temp-save", false);
        if (fileResolveFileName2 == null || (fileResolveFileName = resolveFileName(str, false)) == null) {
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileResolveFileName2);
            try {
                fileOutputStream.write(SIGNATURE);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.close();
                    fileOutputStream.close();
                    return fileResolveFileName2.renameTo(fileResolveFileName);
                } catch (Throwable th) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException e) {
            Log.e(TAG, "Cannot read file " + fileResolveFileName2, e);
            return false;
        }
    }

    boolean deleteFile(String str) {
        return resolveFileName(str, true).delete();
    }

    private File resolveFileName(String str, boolean z) {
        File file = new File(this.mContext.getFilesDir(), this.mDirectoryName);
        if (!file.exists()) {
            if (z) {
                return null;
            }
            file.mkdirs();
        }
        return new File(file, str);
    }
}
