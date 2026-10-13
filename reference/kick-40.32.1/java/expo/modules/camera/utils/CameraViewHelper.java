package expo.modules.camera.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: CameraViewHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\fJ\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017¨\u0006\u0019"}, d2 = {"Lexpo/modules/camera/utils/CameraViewHelper;", "", "<init>", "()V", "getExifData", "Landroid/os/Bundle;", "exifInterface", "Landroidx/exifinterface/media/ExifInterface;", "setExifData", "", "baseExif", "exifMap", "", "", "addExifData", "additionalExif", "toValidExifRational", "value", "", "type", "generateSimulatorPhoto", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CameraViewHelper {
    public static final CameraViewHelper INSTANCE = new CameraViewHelper();

    private CameraViewHelper() {
    }

    public final Bundle getExifData(ExifInterface exifInterface) {
        Intrinsics.checkNotNullParameter(exifInterface, "exifInterface");
        Bundle bundle = new Bundle();
        for (String[] strArr : ExifTagsKt.getExifTags()) {
            String str = strArr[0];
            String str2 = strArr[1];
            if (exifInterface.getAttribute(str2) != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != -1325958191) {
                    if (iHashCode != -891985903) {
                        if (iHashCode == 104431 && str.equals("int")) {
                            bundle.putInt(str2, exifInterface.getAttributeInt(str2, 0));
                        }
                    } else if (str.equals(TypedValues.Custom.S_STRING)) {
                        bundle.putString(str2, exifInterface.getAttribute(str2));
                    }
                } else if (str.equals("double")) {
                    bundle.putDouble(str2, exifInterface.getAttributeDouble(str2, 0.0d));
                }
            }
        }
        double[] latLong = exifInterface.getLatLong();
        if (latLong != null) {
            bundle.putDouble(ExifInterface.TAG_GPS_LATITUDE, latLong[0]);
            bundle.putDouble(ExifInterface.TAG_GPS_LONGITUDE, latLong[1]);
            bundle.putDouble(ExifInterface.TAG_GPS_ALTITUDE, exifInterface.getAltitude(0.0d));
        }
        return bundle;
    }

    public final void setExifData(ExifInterface baseExif, Map<String, ? extends Object> exifMap) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(baseExif, "baseExif");
        Intrinsics.checkNotNullParameter(exifMap, "exifMap");
        for (String[] strArr : ExifTagsKt.getExifTags()) {
            String str = strArr[0];
            String str2 = strArr[1];
            Object obj = exifMap.get(str2);
            if (obj != null) {
                if (obj instanceof String) {
                    baseExif.setAttribute(str2, (String) obj);
                } else if (obj instanceof Number) {
                    baseExif.setAttribute(str2, INSTANCE.toValidExifRational((Number) obj, str));
                } else if (obj instanceof Boolean) {
                    baseExif.setAttribute(str2, String.valueOf(((Boolean) obj).booleanValue()));
                }
            }
        }
        Object obj2 = exifMap.get(ExifInterface.TAG_GPS_LATITUDE);
        Object obj3 = exifMap.get(ExifInterface.TAG_GPS_LONGITUDE);
        if ((obj2 instanceof Number) && (obj3 instanceof Number)) {
            baseExif.setLatLong(((Number) obj2).doubleValue(), ((Number) obj3).doubleValue());
        }
        Object obj4 = exifMap.get(ExifInterface.TAG_GPS_ALTITUDE);
        if (obj4 instanceof Number) {
            baseExif.setAltitude(((Number) obj4).doubleValue());
        }
    }

    public final void addExifData(ExifInterface baseExif, ExifInterface additionalExif) throws Throwable {
        Intrinsics.checkNotNullParameter(baseExif, "baseExif");
        Intrinsics.checkNotNullParameter(additionalExif, "additionalExif");
        for (String[] strArr : ExifTagsKt.getExifTags()) {
            String str = strArr[1];
            String attribute = additionalExif.getAttribute(str);
            if (attribute != null) {
                baseExif.setAttribute(str, attribute);
            }
        }
        baseExif.saveAttributes();
    }

    private final String toValidExifRational(Number value, String type) {
        if (Intrinsics.areEqual(type, "double")) {
            return MathKt.roundToLong(value.doubleValue() * 1000000.0d) + "/1000000";
        }
        String plainString = new BigDecimal(String.valueOf(value.doubleValue())).toPlainString();
        Intrinsics.checkNotNullExpressionValue(plainString, "toPlainString(...)");
        return plainString;
    }

    public final byte[] generateSimulatorPhoto(int width, int height) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(-16777216);
        float f = width;
        float f2 = height;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint);
        Paint paint2 = new Paint();
        paint2.setColor(-256);
        paint2.setTextSize(35.0f);
        canvas.drawText(new SimpleDateFormat("dd.MM.yy HH:mm:ss", Locale.US).format(Calendar.getInstance().getTime()), f * 0.1f, f2 * 0.9f, paint2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
