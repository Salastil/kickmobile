package com.google.mlkit.vision.common.internal;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* JADX INFO: loaded from: classes7.dex */
public class ImageUtils {
    private static final GmsLogger zza = new GmsLogger("MLKitImageUtils", "");
    private static final ImageUtils zzb = new ImageUtils();

    private ImageUtils() {
    }

    public static ImageUtils getInstance() {
        return zzb;
    }

    public IObjectWrapper getImageDataWrapper(InputImage inputImage) throws MlKitException {
        int format = inputImage.getFormat();
        if (format == -1) {
            return ObjectWrapper.wrap((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal()));
        }
        if (format != 17) {
            if (format == 35) {
                return ObjectWrapper.wrap(inputImage.getMediaImage());
            }
            if (format != 842094169) {
                throw new MlKitException("Unsupported image format: " + inputImage.getFormat(), 3);
            }
        }
        return ObjectWrapper.wrap((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()));
    }

    public int getMobileVisionImageFormat(InputImage inputImage) {
        return inputImage.getFormat();
    }

    public int getMobileVisionImageSize(InputImage inputImage) {
        if (inputImage.getFormat() == -1) {
            return ((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal())).getAllocationByteCount();
        }
        if (inputImage.getFormat() == 17 || inputImage.getFormat() == 842094169) {
            return ((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer())).limit();
        }
        if (inputImage.getFormat() != 35) {
            return 0;
        }
        return (((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()))[0].getBuffer().limit() * 3) / 2;
    }

    public Matrix getUprightRotationMatrix(int i, int i2, int i3) {
        if (i3 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-i) / 2.0f, (-i2) / 2.0f);
        matrix.postRotate(i3 * 90);
        int i4 = i3 % 2;
        int i5 = i4 != 0 ? i2 : i;
        if (i4 == 0) {
            i = i2;
        }
        matrix.postTranslate(i5 / 2.0f, i / 2.0f);
        return matrix;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:0x0070  */
    /* JADX WARN: Code duplicated, block: B:33:0x0071 A[Catch: FileNotFoundException -> 0x00d4, TryCatch #4 {FileNotFoundException -> 0x00d4, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:34:0x0078, B:35:0x008d, B:46:0x00be, B:48:0x00c7, B:37:0x0092, B:38:0x0096, B:39:0x009d, B:40:0x00a1, B:41:0x00a8, B:42:0x00ac, B:44:0x00b3, B:33:0x0071, B:30:0x005b, B:50:0x00cc, B:51:0x00d3), top: B:64:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0090 A[PHI: r3
      0x0090: PHI (r3v3 android.graphics.Matrix) = (r3v0 android.graphics.Matrix), (r3v1 android.graphics.Matrix) binds: [B:35:0x008d, B:44:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x0092 A[Catch: FileNotFoundException -> 0x00d4, TryCatch #4 {FileNotFoundException -> 0x00d4, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:34:0x0078, B:35:0x008d, B:46:0x00be, B:48:0x00c7, B:37:0x0092, B:38:0x0096, B:39:0x009d, B:40:0x00a1, B:41:0x00a8, B:42:0x00ac, B:44:0x00b3, B:33:0x0071, B:30:0x005b, B:50:0x00cc, B:51:0x00d3), top: B:64:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0096 A[Catch: FileNotFoundException -> 0x00d4, TryCatch #4 {FileNotFoundException -> 0x00d4, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:34:0x0078, B:35:0x008d, B:46:0x00be, B:48:0x00c7, B:37:0x0092, B:38:0x0096, B:39:0x009d, B:40:0x00a1, B:41:0x00a8, B:42:0x00ac, B:44:0x00b3, B:33:0x0071, B:30:0x005b, B:50:0x00cc, B:51:0x00d3), top: B:64:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x009d A[Catch: FileNotFoundException -> 0x00d4, TryCatch #4 {FileNotFoundException -> 0x00d4, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:34:0x0078, B:35:0x008d, B:46:0x00be, B:48:0x00c7, B:37:0x0092, B:38:0x0096, B:39:0x009d, B:40:0x00a1, B:41:0x00a8, B:42:0x00ac, B:44:0x00b3, B:33:0x0071, B:30:0x005b, B:50:0x00cc, B:51:0x00d3), top: B:64:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a1 A[Catch: FileNotFoundException -> 0x00d4, TryCatch #4 {FileNotFoundException -> 0x00d4, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:34:0x0078, B:35:0x008d, B:46:0x00be, B:48:0x00c7, B:37:0x0092, B:38:0x0096, B:39:0x009d, B:40:0x00a1, B:41:0x00a8, B:42:0x00ac, B:44:0x00b3, B:33:0x0071, B:30:0x005b, B:50:0x00cc, B:51:0x00d3), top: B:64:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a8 A[Catch: FileNotFoundException -> 0x00d4, TryCatch #4 {FileNotFoundException -> 0x00d4, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:34:0x0078, B:35:0x008d, B:46:0x00be, B:48:0x00c7, B:37:0x0092, B:38:0x0096, B:39:0x009d, B:40:0x00a1, B:41:0x00a8, B:42:0x00ac, B:44:0x00b3, B:33:0x0071, B:30:0x005b, B:50:0x00cc, B:51:0x00d3), top: B:64:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ac A[Catch: FileNotFoundException -> 0x00d4, TryCatch #4 {FileNotFoundException -> 0x00d4, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:34:0x0078, B:35:0x008d, B:46:0x00be, B:48:0x00c7, B:37:0x0092, B:38:0x0096, B:39:0x009d, B:40:0x00a1, B:41:0x00a8, B:42:0x00ac, B:44:0x00b3, B:33:0x0071, B:30:0x005b, B:50:0x00cc, B:51:0x00d3), top: B:64:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b3 A[Catch: FileNotFoundException -> 0x00d4, TryCatch #4 {FileNotFoundException -> 0x00d4, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0016, B:34:0x0078, B:35:0x008d, B:46:0x00be, B:48:0x00c7, B:37:0x0092, B:38:0x0096, B:39:0x009d, B:40:0x00a1, B:41:0x00a8, B:42:0x00ac, B:44:0x00b3, B:33:0x0071, B:30:0x005b, B:50:0x00cc, B:51:0x00d3), top: B:64:0x0002 }] */
    public final Bitmap zza(ContentResolver contentResolver, Uri uri) throws IOException {
        IOException iOException;
        ExifInterface exifInterface;
        Matrix matrix;
        Matrix matrix2;
        Bitmap bitmapCreateBitmap;
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);
            if (bitmap == null) {
                throw new IOException("The image Uri could not be resolved.");
            }
            int attributeInt = 0;
            Matrix matrix3 = null;
            if ("content".equals(uri.getScheme()) || "file".equals(uri.getScheme())) {
                try {
                    InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            exifInterface = new ExifInterface(inputStreamOpenInputStream);
                        } catch (Throwable th) {
                            try {
                                inputStreamOpenInputStream.close();
                                throw th;
                            } catch (Throwable th2) {
                                try {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                    throw th;
                                } catch (Exception unused) {
                                    throw th;
                                }
                            }
                        }
                    } else {
                        exifInterface = null;
                    }
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e) {
                            iOException = e;
                            zza.e("MLKitImageUtils", "failed to open file to read rotation meta data: ".concat(String.valueOf(String.valueOf(uri))), iOException);
                        }
                    }
                } catch (IOException e2) {
                    iOException = e2;
                    exifInterface = null;
                    zza.e("MLKitImageUtils", "failed to open file to read rotation meta data: ".concat(String.valueOf(String.valueOf(uri))), iOException);
                    if (exifInterface == null) {
                        attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                    }
                    matrix = new Matrix();
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    switch (attributeInt) {
                        case 2:
                            matrix3 = new Matrix();
                            matrix3.postScale(-1.0f, 1.0f);
                            matrix2 = matrix3;
                            break;
                        case 3:
                            matrix.postRotate(180.0f);
                            matrix2 = matrix;
                            break;
                        case 4:
                            matrix.postScale(1.0f, -1.0f);
                            matrix2 = matrix;
                            break;
                        case 5:
                            matrix.postRotate(90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            matrix2 = matrix;
                            break;
                        case 6:
                            matrix.postRotate(90.0f);
                            matrix2 = matrix;
                            break;
                        case 7:
                            matrix.postRotate(-90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            matrix2 = matrix;
                            break;
                        case 8:
                            matrix.postRotate(-90.0f);
                            matrix2 = matrix;
                            break;
                        default:
                            matrix2 = matrix3;
                            break;
                    }
                    return matrix2 == null ? bitmap : bitmap;
                }
                if (exifInterface == null) {
                    attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                }
            }
            matrix = new Matrix();
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            switch (attributeInt) {
                case 2:
                    matrix3 = new Matrix();
                    matrix3.postScale(-1.0f, 1.0f);
                    matrix2 = matrix3;
                    break;
                case 3:
                    matrix.postRotate(180.0f);
                    matrix2 = matrix;
                    break;
                case 4:
                    matrix.postScale(1.0f, -1.0f);
                    matrix2 = matrix;
                    break;
                case 5:
                    matrix.postRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    matrix2 = matrix;
                    break;
                case 6:
                    matrix.postRotate(90.0f);
                    matrix2 = matrix;
                    break;
                case 7:
                    matrix.postRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    matrix2 = matrix;
                    break;
                case 8:
                    matrix.postRotate(-90.0f);
                    matrix2 = matrix;
                    break;
                default:
                    matrix2 = matrix3;
                    break;
            }
            if (matrix2 == null && bitmap != (bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width2, height2, matrix2, true))) {
                bitmap.recycle();
                return bitmapCreateBitmap;
            }
        } catch (FileNotFoundException e3) {
            zza.e("MLKitImageUtils", "Could not open file: ".concat(String.valueOf(String.valueOf(uri))), e3);
            throw e3;
        }
    }
}
