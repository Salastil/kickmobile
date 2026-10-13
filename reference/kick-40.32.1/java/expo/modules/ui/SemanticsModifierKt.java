package expo.modules.ui;

import androidx.autofill.HintConstants;
import androidx.compose.ui.autofill.ContentType;
import kotlin.Metadata;

/* JADX INFO: compiled from: SemanticsModifier.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000¨\u0006\u0003"}, d2 = {"toContentType", "Landroidx/compose/ui/autofill/ContentType;", "", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SemanticsModifierKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final ContentType toContentType(String str) {
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case -2099439185:
                if (str.equals("postal-code")) {
                    return ContentType.INSTANCE.getPostalCode();
                }
                return null;
            case -2083025737:
                if (!str.equals("sms-otp")) {
                    return null;
                }
                return ContentType.INSTANCE.getSmsOtpCode();
            case -1856205482:
                if (str.equals("cc-number")) {
                    return ContentType.INSTANCE.getCreditCardNumber();
                }
                return null;
            case -1848036933:
                if (!str.equals("name-given")) {
                    return null;
                }
                return ContentType.INSTANCE.getPersonFirstName();
            case -1835714652:
                if (!str.equals("address-line1")) {
                    return null;
                }
                return ContentType.INSTANCE.getAddressStreet();
            case -1835714651:
                if (str.equals("address-line2")) {
                    return ContentType.INSTANCE.getAddressAuxiliaryDetails();
                }
                return null;
            case -1734292773:
                if (!str.equals("given-name")) {
                    return null;
                }
                return ContentType.INSTANCE.getPersonFirstName();
            case -1647644706:
                if (str.equals("postal-address-locality")) {
                    return ContentType.INSTANCE.getAddressLocality();
                }
                return null;
            case -1502393158:
                if (str.equals("cc-exp-year")) {
                    return ContentType.INSTANCE.getCreditCardExpirationYear();
                }
                return null;
            case -1490851610:
                if (!str.equals("name-family")) {
                    return null;
                }
                return ContentType.INSTANCE.getPersonLastName();
            case -1367813370:
                if (str.equals("cc-csc")) {
                    return ContentType.INSTANCE.getCreditCardSecurityCode();
                }
                return null;
            case -1367811280:
                if (str.equals("cc-exp")) {
                    return ContentType.INSTANCE.getCreditCardExpirationDate();
                }
                return null;
            case -1349018346:
                if (str.equals("postal-address-extended-postal-code")) {
                    return ContentType.INSTANCE.getPostalCodeExtended();
                }
                return null;
            case -1283332329:
                if (!str.equals("name-middle")) {
                    return null;
                }
                return ContentType.INSTANCE.getPersonMiddleName();
            case -1249512767:
                if (str.equals(HintConstants.AUTOFILL_HINT_GENDER)) {
                    return ContentType.INSTANCE.getGender();
                }
                return null;
            case -1220051921:
                if (str.equals("postal-address-region")) {
                    return ContentType.INSTANCE.getAddressRegion();
                }
                return null;
            case -1189101548:
                if (!str.equals("name-prefix")) {
                    return null;
                }
                return ContentType.INSTANCE.getPersonNamePrefix();
            case -1100413741:
                if (!str.equals("name-suffix")) {
                    return null;
                }
                return ContentType.INSTANCE.getPersonNameSuffix();
            case -1044725932:
                if (!str.equals("family-name")) {
                    return null;
                }
                return ContentType.INSTANCE.getPersonLastName();
            case -1018315905:
                if (str.equals("cc-exp-day")) {
                    return ContentType.INSTANCE.getCreditCardExpirationDay();
                }
                return null;
            case -743942364:
                if (str.equals("tel-national")) {
                    return ContentType.INSTANCE.getPhoneNumberNational();
                }
                return null;
            case -265713450:
                if (str.equals(HintConstants.AUTOFILL_HINT_USERNAME)) {
                    return ContentType.INSTANCE.getUsername();
                }
                return null;
            case -213620696:
                if (!str.equals("new-password")) {
                    return null;
                }
                return ContentType.INSTANCE.getNewPassword();
            case -203378818:
                if (!str.equals("honorific-prefix")) {
                    return null;
                }
                return ContentType.INSTANCE.getPersonNamePrefix();
            case -164322191:
                if (!str.equals("additional-name")) {
                    return null;
                }
                return ContentType.INSTANCE.getPersonMiddleName();
            case -114691011:
                if (!str.equals("honorific-suffix")) {
                    return null;
                }
                return ContentType.INSTANCE.getPersonNameSuffix();
            case 114715:
                if (str.equals("tel")) {
                    return ContentType.INSTANCE.getPhoneNumber();
                }
                return null;
            case 2720840:
                if (str.equals("tel-device")) {
                    return ContentType.INSTANCE.getPhoneNumberDevice();
                }
                return null;
            case 3373707:
                if (str.equals("name")) {
                    return ContentType.INSTANCE.getPersonFullName();
                }
                return null;
            case 96619420:
                if (str.equals("email")) {
                    return ContentType.INSTANCE.getEmailAddress();
                }
                return null;
            case 405863840:
                if (str.equals("birthdate-month")) {
                    return ContentType.INSTANCE.getBirthDateMonth();
                }
                return null;
            case 465217212:
                if (str.equals("birthdate-day")) {
                    return ContentType.INSTANCE.getBirthDateDay();
                }
                return null;
            case 565908334:
                if (!str.equals("password-new")) {
                    return null;
                }
                return ContentType.INSTANCE.getNewPassword();
            case 620796015:
                if (!str.equals("current-password")) {
                    return null;
                }
                return ContentType.INSTANCE.getPassword();
            case 659680675:
                if (str.equals("cc-exp-month")) {
                    return ContentType.INSTANCE.getCreditCardExpirationMonth();
                }
                return null;
            case 704817595:
                if (!str.equals("postal-address-country")) {
                    return null;
                }
                return ContentType.INSTANCE.getAddressCountry();
            case 902393398:
                if (str.equals("tel-country-code")) {
                    return ContentType.INSTANCE.getPhoneCountryCode();
                }
                return null;
            case 957831062:
                if (!str.equals("country")) {
                    return null;
                }
                return ContentType.INSTANCE.getAddressCountry();
            case 1006849065:
                if (str.equals("username-new")) {
                    return ContentType.INSTANCE.getNewUsername();
                }
                return null;
            case 1132403754:
                if (!str.equals("street-address")) {
                    return null;
                }
                return ContentType.INSTANCE.getAddressStreet();
            case 1216985755:
                if (!str.equals("password")) {
                    return null;
                }
                return ContentType.INSTANCE.getPassword();
            case 1536910191:
                if (str.equals("birthdate-full")) {
                    return ContentType.INSTANCE.getBirthDateFull();
                }
                return null;
            case 1537460509:
                if (str.equals("birthdate-year")) {
                    return ContentType.INSTANCE.getBirthDateYear();
                }
                return null;
            case 1739554374:
                if (!str.equals("one-time-code")) {
                    return null;
                }
                return ContentType.INSTANCE.getSmsOtpCode();
            case 1804016270:
                if (str.equals("name-middle-initial")) {
                    return ContentType.INSTANCE.getPersonMiddleInitial();
                }
                return null;
            default:
                return null;
        }
    }
}
