package expo.modules.camera.analyzers;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Pair;
import androidx.autofill.HintConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.mux.stats.sdk.core.model.ViewDeviceOrientationData;
import expo.modules.camera.utils.BarCodeScannerResult;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.bouncycastle.i18n.ErrorBundle;

/* JADX INFO: compiled from: BarcodeScannerResultSerializer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJB\u0010\u000f\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0011j\b\u0012\u0004\u0012\u00020\u0005`\u0012\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002¨\u0006\u001f"}, d2 = {"Lexpo/modules/camera/analyzers/BarCodeScannerResultSerializer;", "", "<init>", "()V", "toBundle", "Landroid/os/Bundle;", "result", "Lexpo/modules/camera/utils/BarCodeScannerResult;", "density", "", "parseBarcodeScanningResult", OptionalModuleUtils.BARCODE, "Lcom/google/mlkit/vision/barcode/common/Barcode;", "inputImage", "Lcom/google/mlkit/vision/common/InputImage;", "getCornerPointsAndBoundingBox", "Landroid/util/Pair;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "cornerPoints", "", "", "boundingBox", "Lexpo/modules/camera/utils/BarCodeScannerResult$BoundingBox;", "parseExtraDate", "getSize", ViewProps.WIDTH, ViewProps.HEIGHT, "getPoint", ViewDeviceOrientationData.DEVICE_ORIENTATION_X, ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, "expo-camera_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BarCodeScannerResultSerializer {
    public static final BarCodeScannerResultSerializer INSTANCE = new BarCodeScannerResultSerializer();

    private BarCodeScannerResultSerializer() {
    }

    public final Bundle toBundle(BarCodeScannerResult result, float density) {
        Intrinsics.checkNotNullParameter(result, "result");
        Bundle bundle = new Bundle();
        bundle.putString("data", result.getValue());
        bundle.putString("raw", result.getRaw());
        bundle.putInt("type", result.getType());
        bundle.putBundle("extra", result.getExtra());
        Pair<ArrayList<Bundle>, Bundle> cornerPointsAndBoundingBox = INSTANCE.getCornerPointsAndBoundingBox(result.getCornerPoints(), result.getBoundingBox(), density);
        bundle.putParcelableArrayList("cornerPoints", (ArrayList) cornerPointsAndBoundingBox.first);
        bundle.putBundle("bounds", (Bundle) cornerPointsAndBoundingBox.second);
        return bundle;
    }

    public static /* synthetic */ BarCodeScannerResult parseBarcodeScanningResult$default(BarCodeScannerResultSerializer barCodeScannerResultSerializer, Barcode barcode, InputImage inputImage, int i, Object obj) {
        if ((i & 2) != 0) {
            inputImage = null;
        }
        return barCodeScannerResultSerializer.parseBarcodeScanningResult(barcode, inputImage);
    }

    public final BarCodeScannerResult parseBarcodeScanningResult(Barcode barcode, InputImage inputImage) {
        String str;
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        String rawValue = barcode.getRawValue();
        if (rawValue != null) {
            str = rawValue;
        } else {
            byte[] rawBytes = barcode.getRawBytes();
            if (rawBytes != null) {
                str = new String(rawBytes, Charsets.UTF_8);
            } else {
                rawValue = null;
                str = rawValue;
            }
        }
        String displayValue = barcode.getValueType() == 1 ? str : barcode.getDisplayValue();
        ArrayList arrayList = new ArrayList();
        Point[] cornerPoints = barcode.getCornerPoints();
        if (cornerPoints != null) {
            for (Point point : cornerPoints) {
                arrayList.addAll(CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(point.x), Integer.valueOf(point.y)}));
            }
        }
        Bundle extraDate = parseExtraDate(barcode);
        return new BarCodeScannerResult(barcode.getFormat(), displayValue, str, extraDate, arrayList, inputImage != null ? inputImage.getHeight() : 0, inputImage != null ? inputImage.getWidth() : 0);
    }

    private final Pair<ArrayList<Bundle>, Bundle> getCornerPointsAndBoundingBox(List<Integer> cornerPoints, BarCodeScannerResult.BoundingBox boundingBox, float density) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, cornerPoints.size() - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                arrayList.add(getPoint(cornerPoints.get(i).intValue() / density, cornerPoints.get(i + 1).intValue() / density));
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        Bundle bundle = new Bundle();
        BarCodeScannerResultSerializer barCodeScannerResultSerializer = INSTANCE;
        bundle.putParcelable("origin", barCodeScannerResultSerializer.getPoint(boundingBox.getX() / density, boundingBox.getY() / density));
        bundle.putParcelable(ContentDisposition.Parameters.Size, barCodeScannerResultSerializer.getSize(boundingBox.getWidth() / density, boundingBox.getHeight() / density));
        return new Pair<>(arrayList, bundle);
    }

    public final Bundle parseExtraDate(Barcode barcode) {
        List<Barcode.Address> addresses;
        Barcode.Address address;
        String[] addressLines;
        List<String> urls;
        List<Barcode.Phone> phones;
        Barcode.Phone phone;
        List<Barcode.Email> emails;
        Barcode.Email email;
        Barcode.PersonName name;
        Barcode.PersonName name2;
        Barcode.PersonName name3;
        Barcode.CalendarDateTime end;
        Barcode.CalendarDateTime start;
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Bundle bundle = new Bundle();
        int valueType = barcode.getValueType();
        String str = null;
        string = null;
        String string = null;
        str = null;
        str = null;
        str = null;
        if (valueType == 1) {
            Barcode.ContactInfo contactInfo = barcode.getContactInfo();
            bundle.putString("type", "contactInfo");
            bundle.putString("firstName", (contactInfo == null || (name3 = contactInfo.getName()) == null) ? null : name3.getFirst());
            bundle.putString("middleName", (contactInfo == null || (name2 = contactInfo.getName()) == null) ? null : name2.getMiddle());
            bundle.putString("lastName", (contactInfo == null || (name = contactInfo.getName()) == null) ? null : name.getLast());
            bundle.putString("title", contactInfo != null ? contactInfo.getTitle() : null);
            bundle.putString("organization", contactInfo != null ? contactInfo.getOrganization() : null);
            bundle.putString("email", (contactInfo == null || (emails = contactInfo.getEmails()) == null || (email = (Barcode.Email) CollectionsKt.firstOrNull((List) emails)) == null) ? null : email.getAddress());
            bundle.putString("phone", (contactInfo == null || (phones = contactInfo.getPhones()) == null || (phone = (Barcode.Phone) CollectionsKt.firstOrNull((List) phones)) == null) ? null : phone.getNumber());
            bundle.putString(ImagesContract.URL, (contactInfo == null || (urls = contactInfo.getUrls()) == null) ? null : (String) CollectionsKt.firstOrNull((List) urls));
            if (contactInfo != null && (addresses = contactInfo.getAddresses()) != null && (address = (Barcode.Address) CollectionsKt.firstOrNull((List) addresses)) != null && (addressLines = address.getAddressLines()) != null) {
                str = (String) ArraysKt.firstOrNull(addressLines);
            }
            bundle.putString("address", str);
            return bundle;
        }
        if (valueType == 2) {
            Barcode.Email email2 = barcode.getEmail();
            bundle.putString("type", "email");
            bundle.putString("address", email2 != null ? email2.getAddress() : null);
            bundle.putString("subject", email2 != null ? email2.getSubject() : null);
            bundle.putString(ExpoNotificationBuilder.EXTRAS_BODY_KEY, email2 != null ? email2.getBody() : null);
            return bundle;
        }
        if (valueType == 4) {
            Barcode.Phone phone2 = barcode.getPhone();
            bundle.putString("type", "phone");
            bundle.putString("number", phone2 != null ? phone2.getNumber() : null);
            bundle.putString("phoneNumberType", String.valueOf(phone2 != null ? Integer.valueOf(phone2.getType()) : null));
            return bundle;
        }
        if (valueType == 6) {
            Barcode.Sms sms = barcode.getSms();
            bundle.putString("type", "sms");
            bundle.putString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, sms != null ? sms.getPhoneNumber() : null);
            bundle.putString("message", sms != null ? sms.getMessage() : null);
            return bundle;
        }
        switch (valueType) {
            case 8:
                Barcode.UrlBookmark url = barcode.getUrl();
                bundle.putString("type", ImagesContract.URL);
                bundle.putString(ImagesContract.URL, url != null ? url.getUrl() : null);
                break;
            case 9:
                Barcode.WiFi wifi = barcode.getWifi();
                bundle.putString("type", "wifi");
                bundle.putString("ssid", wifi != null ? wifi.getSsid() : null);
                bundle.putString("password", wifi != null ? wifi.getPassword() : null);
                bundle.putString("type", String.valueOf(wifi != null ? Integer.valueOf(wifi.getEncryptionType()) : null));
                break;
            case 10:
                Barcode.GeoPoint geoPoint = barcode.getGeoPoint();
                bundle.putString("type", "geoPoint");
                bundle.putString("lat", String.valueOf(geoPoint != null ? Double.valueOf(geoPoint.getLat()) : null));
                bundle.putString("lng", String.valueOf(geoPoint != null ? Double.valueOf(geoPoint.getLng()) : null));
                break;
            case 11:
                Barcode.CalendarEvent calendarEvent = barcode.getCalendarEvent();
                bundle.putString("type", "calendarEvent");
                bundle.putString(ErrorBundle.SUMMARY_ENTRY, calendarEvent != null ? calendarEvent.getSummary() : null);
                bundle.putString("description", calendarEvent != null ? calendarEvent.getDescription() : null);
                bundle.putString(FirebaseAnalytics.Param.LOCATION, calendarEvent != null ? calendarEvent.getLocation() : null);
                bundle.putString(ViewProps.START, (calendarEvent == null || (start = calendarEvent.getStart()) == null) ? null : start.toString());
                if (calendarEvent != null && (end = calendarEvent.getEnd()) != null) {
                    string = end.toString();
                }
                bundle.putString(ViewProps.END, string);
                break;
            case 12:
                Barcode.DriverLicense driverLicense = barcode.getDriverLicense();
                bundle.putString("type", "driverLicense");
                bundle.putString("firstName", driverLicense != null ? driverLicense.getFirstName() : null);
                bundle.putString("middleName", driverLicense != null ? driverLicense.getMiddleName() : null);
                bundle.putString("lastName", driverLicense != null ? driverLicense.getLastName() : null);
                bundle.putString("licenseNumber", driverLicense != null ? driverLicense.getLicenseNumber() : null);
                bundle.putString("expiryDate", driverLicense != null ? driverLicense.getExpiryDate() : null);
                bundle.putString("issueDate", driverLicense != null ? driverLicense.getIssueDate() : null);
                bundle.putString("addressStreet", driverLicense != null ? driverLicense.getAddressStreet() : null);
                bundle.putString("addressCity", driverLicense != null ? driverLicense.getAddressCity() : null);
                bundle.putString("addressState", driverLicense != null ? driverLicense.getAddressState() : null);
                break;
        }
        return bundle;
    }

    private final Bundle getSize(float width, float height) {
        Bundle bundle = new Bundle();
        bundle.putFloat(ViewProps.WIDTH, width);
        bundle.putFloat(ViewProps.HEIGHT, height);
        return bundle;
    }

    private final Bundle getPoint(float x, float y) {
        Bundle bundle = new Bundle();
        bundle.putFloat(ViewDeviceOrientationData.DEVICE_ORIENTATION_X, x);
        bundle.putFloat(ViewDeviceOrientationData.DEVICE_ORIENTATION_Y, y);
        return bundle;
    }
}
