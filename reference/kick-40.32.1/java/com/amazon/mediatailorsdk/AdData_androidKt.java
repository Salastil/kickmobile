package com.amazon.mediatailorsdk;

import android.util.Xml;
import com.amazon.mediatailorsdk.logs.Logger_androidKt;
import com.facebook.react.uimanager.ViewProps;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: AdData.android.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a$\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00182\u0006\u0010\b\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"regexJunks", "Lkotlin/text/Regex;", "tag", "", "trimmedText", "text", "adVerificationFromExtension", "Lcom/amazon/mediatailorsdk/AdData$AdVerification;", "content", "PATH_ICON", "PATH_STATICRESOURCE", "PATH_ICONCLICKS", "PATH_ICONCLICKTHROUGH", "PATH_ICONCLICKFALLBACKIMAGES", "PATH_ICONCLICKFALLBACKIMAGE", "PATH_ICONCLICKFALLBACKIMAGE_ALTTEXT", "PATH_ICONCLICKFALLBACKIMAGE_STATICRESOURCE", "PATH_ICONCLICKFALLBACKIMAGES2", "PATH_ICONCLICKFALLBACKIMAGE2", "PATH_ICONCLICKFALLBACKIMAGE2_ALTTEXT", "PATH_ICONCLICKFALLBACKIMAGE2_STATICRESOURCE", "adChoicesFromExtension", "Ljava/util/ArrayList;", "Lcom/amazon/mediatailorsdk/AdData$Icon;", "Lkotlin/collections/ArrayList;", "MediaTailor_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AdData_androidKt {
    public static final String PATH_ICON = "$.Icon";
    public static final String PATH_ICONCLICKFALLBACKIMAGE = "$.Icon.IconClicks.IconClickFallbackImages.IconClickFallbackImage";
    public static final String PATH_ICONCLICKFALLBACKIMAGE2 = "$.IconClickFallbackImages.IconClickFallbackImage";
    public static final String PATH_ICONCLICKFALLBACKIMAGE2_ALTTEXT = "$.IconClickFallbackImages.IconClickFallbackImage.AltText";
    public static final String PATH_ICONCLICKFALLBACKIMAGE2_STATICRESOURCE = "$.IconClickFallbackImages.IconClickFallbackImage.StaticResource";
    public static final String PATH_ICONCLICKFALLBACKIMAGES = "$.Icon.IconClicks.IconClickFallbackImages";
    public static final String PATH_ICONCLICKFALLBACKIMAGES2 = "$.IconClickFallbackImages";
    public static final String PATH_ICONCLICKFALLBACKIMAGE_ALTTEXT = "$.Icon.IconClicks.IconClickFallbackImages.IconClickFallbackImage.AltText";
    public static final String PATH_ICONCLICKFALLBACKIMAGE_STATICRESOURCE = "$.Icon.IconClicks.IconClickFallbackImages.IconClickFallbackImage.StaticResource";
    public static final String PATH_ICONCLICKS = "$.Icon.IconClicks";
    public static final String PATH_ICONCLICKTHROUGH = "$.Icon.IconClicks.IconClickThrough";
    public static final String PATH_STATICRESOURCE = "$.Icon.StaticResource";
    private static final Regex regexJunks = new Regex("\\n|<!\\[CDATA\\[|]]>");
    private static final String tag = "adData: ";

    private static final String trimmedText(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = regexJunks.replace(str, "");
        if (strReplace != null) {
            return StringsKt.trim((CharSequence) strReplace).toString();
        }
        return null;
    }

    public static final AdData.AdVerification adVerificationFromExtension(String content) {
        String str;
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bytes), null);
            String strTrimmedText = null;
            String attributeValue = null;
            String strTrimmedText2 = null;
            String name = "";
            while (true) {
                int eventType = xmlPullParserNewPullParser.getEventType();
                if (eventType == 1) {
                    break;
                }
                if (eventType == 2) {
                    name = xmlPullParserNewPullParser.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (Intrinsics.areEqual(name, "Verification")) {
                        attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "vendor");
                    }
                } else if (eventType == 3) {
                    name = "";
                } else if (eventType == 4) {
                    if (Intrinsics.areEqual(name, "JavaScriptResource")) {
                        strTrimmedText = trimmedText(xmlPullParserNewPullParser.getText());
                    } else if (Intrinsics.areEqual(name, "VerificationParameters")) {
                        strTrimmedText2 = trimmedText(xmlPullParserNewPullParser.getText());
                    }
                }
                xmlPullParserNewPullParser.next();
            }
            String str2 = strTrimmedText;
            if (str2 != null && !StringsKt.isBlank(str2) && (str = attributeValue) != null && !StringsKt.isBlank(str)) {
                AdData.AdVerification adVerification = new AdData.AdVerification();
                AdData.AdVerification.JavaScriptResource javaScriptResource = new AdData.AdVerification.JavaScriptResource();
                javaScriptResource.setUri$MediaTailor_release(strTrimmedText);
                adVerification.setVendor$MediaTailor_release(attributeValue);
                adVerification.setVerificationParameters$MediaTailor_release(strTrimmedText2);
                adVerification.setJavaScriptResource$MediaTailor_release(new AdData.AdVerification.JavaScriptResource[]{javaScriptResource});
                return adVerification;
            }
            Logger_androidKt.getLogger().w("adData: Invalid AdVerifications extension content: " + content);
        } catch (Exception e) {
            Logger_androidKt.getLogger().w("adData: Exception (" + e.getMessage() + ") parsing AdVerifications extension: " + content);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008c A[Catch: Exception -> 0x021f, TryCatch #0 {Exception -> 0x021f, blocks: (B:3:0x0008, B:5:0x0037, B:15:0x004d, B:16:0x0051, B:18:0x0056, B:38:0x00c7, B:21:0x0060, B:30:0x008c, B:24:0x006a, B:26:0x0072, B:27:0x0082, B:31:0x009c, B:34:0x00a6, B:35:0x00bd, B:96:0x01f6, B:39:0x00d7, B:41:0x00dd, B:44:0x00fe, B:43:0x00e3, B:47:0x010c, B:51:0x0137, B:54:0x013f, B:56:0x014d, B:57:0x0150, B:58:0x015f, B:61:0x0169, B:63:0x0177, B:64:0x017a, B:66:0x0180, B:67:0x0183, B:69:0x0189, B:70:0x018c, B:72:0x0195, B:73:0x0198, B:75:0x01a1, B:76:0x01a5, B:90:0x01d9, B:92:0x01ea, B:93:0x01ed, B:95:0x01f3, B:79:0x01ae, B:82:0x01b5, B:83:0x01bb, B:86:0x01c4, B:87:0x01d0, B:97:0x01fc, B:100:0x0206), top: B:105:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c7 A[Catch: Exception -> 0x021f, TryCatch #0 {Exception -> 0x021f, blocks: (B:3:0x0008, B:5:0x0037, B:15:0x004d, B:16:0x0051, B:18:0x0056, B:38:0x00c7, B:21:0x0060, B:30:0x008c, B:24:0x006a, B:26:0x0072, B:27:0x0082, B:31:0x009c, B:34:0x00a6, B:35:0x00bd, B:96:0x01f6, B:39:0x00d7, B:41:0x00dd, B:44:0x00fe, B:43:0x00e3, B:47:0x010c, B:51:0x0137, B:54:0x013f, B:56:0x014d, B:57:0x0150, B:58:0x015f, B:61:0x0169, B:63:0x0177, B:64:0x017a, B:66:0x0180, B:67:0x0183, B:69:0x0189, B:70:0x018c, B:72:0x0195, B:73:0x0198, B:75:0x01a1, B:76:0x01a5, B:90:0x01d9, B:92:0x01ea, B:93:0x01ed, B:95:0x01f3, B:79:0x01ae, B:82:0x01b5, B:83:0x01bb, B:86:0x01c4, B:87:0x01d0, B:97:0x01fc, B:100:0x0206), top: B:105:0x0008 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final ArrayList<AdData.Icon> adChoicesFromExtension(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            ArrayList<AdData.Icon> arrayList = new ArrayList<>();
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bytes), null);
            AdData.Icon icon = null;
            AdData.Icon.IconClickFallbackImage iconClickFallbackImage = null;
            ArrayList arrayList3 = null;
            String str = "$";
            while (true) {
                int eventType = xmlPullParserNewPullParser.getEventType();
                if (eventType != 1) {
                    if (eventType == 2) {
                        arrayList2.add(str);
                        str = str + "." + xmlPullParserNewPullParser.getName();
                        switch (str.hashCode()) {
                            case -2098579474:
                                if (!str.equals(PATH_ICONCLICKFALLBACKIMAGE)) {
                                }
                                break;
                            case -1877193585:
                                if (!str.equals(PATH_ICONCLICKS)) {
                                    continue;
                                } else {
                                    Intrinsics.checkNotNull(icon);
                                    icon.setIconClicks$MediaTailor_release(new AdData.Icon.IconClicks());
                                }
                                break;
                            case -307078678:
                                if (!str.equals(PATH_ICONCLICKFALLBACKIMAGES)) {
                                    continue;
                                } else {
                                    arrayList3 = new ArrayList();
                                }
                                break;
                            case 247880633:
                                if (!str.equals(PATH_ICONCLICKFALLBACKIMAGE2)) {
                                }
                                break;
                            case 1075404835:
                                if (!str.equals(PATH_ICON)) {
                                    continue;
                                } else {
                                    icon = new AdData.Icon();
                                    arrayList.add(icon);
                                    String attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "program");
                                    if (attributeValue != null) {
                                        icon.setProgram$MediaTailor_release(attributeValue);
                                    }
                                    String attributeValue2 = xmlPullParserNewPullParser.getAttributeValue(null, ViewProps.WIDTH);
                                    if (attributeValue2 != null) {
                                        icon.setWidth$MediaTailor_release(attributeValue2);
                                    }
                                    String attributeValue3 = xmlPullParserNewPullParser.getAttributeValue(null, ViewProps.HEIGHT);
                                    if (attributeValue3 != null) {
                                        icon.setHeight$MediaTailor_release(attributeValue3);
                                    }
                                    String attributeValue4 = xmlPullParserNewPullParser.getAttributeValue(null, "xPosition");
                                    if (attributeValue4 != null) {
                                        icon.setXPosition$MediaTailor_release(attributeValue4);
                                    }
                                    String attributeValue5 = xmlPullParserNewPullParser.getAttributeValue(null, "yPosition");
                                    if (attributeValue5 != null) {
                                        icon.setYPosition$MediaTailor_release(attributeValue5);
                                    }
                                }
                                break;
                            case 1518984831:
                                if (!str.equals(PATH_ICONCLICKFALLBACKIMAGES2)) {
                                    continue;
                                } else {
                                    icon = new AdData.Icon();
                                    arrayList.add(icon);
                                    String attributeValue6 = xmlPullParserNewPullParser.getAttributeValue(null, "program");
                                    if (attributeValue6 != null) {
                                        icon.setProgram$MediaTailor_release(attributeValue6);
                                    }
                                    icon.setIconClicks$MediaTailor_release(new AdData.Icon.IconClicks());
                                    arrayList3 = new ArrayList();
                                }
                                break;
                            default:
                                continue;
                        }
                        iconClickFallbackImage = new AdData.Icon.IconClickFallbackImage();
                        Intrinsics.checkNotNull(arrayList3);
                        arrayList3.add(iconClickFallbackImage);
                        String attributeValue7 = xmlPullParserNewPullParser.getAttributeValue(null, ViewProps.WIDTH);
                        if (attributeValue7 != null) {
                            iconClickFallbackImage.setWidth$MediaTailor_release(attributeValue7);
                        }
                        String attributeValue8 = xmlPullParserNewPullParser.getAttributeValue(null, ViewProps.HEIGHT);
                        if (attributeValue8 != null) {
                            iconClickFallbackImage.setHeight$MediaTailor_release(attributeValue8);
                        }
                    } else if (eventType == 3) {
                        if (Intrinsics.areEqual(str, PATH_ICONCLICKFALLBACKIMAGES) || Intrinsics.areEqual(str, PATH_ICONCLICKFALLBACKIMAGES2)) {
                            Intrinsics.checkNotNull(icon);
                            AdData.Icon.IconClicks iconClicks = icon.getIconClicks();
                            Intrinsics.checkNotNull(iconClicks);
                            Intrinsics.checkNotNull(arrayList3);
                            iconClicks.setIconClickFallbackImages$MediaTailor_release((AdData.Icon.IconClickFallbackImage[]) arrayList3.toArray(new AdData.Icon.IconClickFallbackImage[i]));
                        }
                        str = (String) CollectionsKt.removeLastOrNull(arrayList2);
                        if (str == null) {
                            str = "$";
                        }
                    } else if (eventType == 4) {
                        switch (str.hashCode()) {
                            case -159176815:
                                if (str.equals(PATH_ICONCLICKFALLBACKIMAGE2_STATICRESOURCE)) {
                                    Intrinsics.checkNotNull(iconClickFallbackImage);
                                    iconClickFallbackImage.setStaticResource$MediaTailor_release(trimmedText(xmlPullParserNewPullParser.getText()));
                                }
                                break;
                            case 530440917:
                                if (str.equals(PATH_ICONCLICKTHROUGH)) {
                                    Intrinsics.checkNotNull(icon);
                                    AdData.Icon.IconClicks iconClicks2 = icon.getIconClicks();
                                    Intrinsics.checkNotNull(iconClicks2);
                                    iconClicks2.setIconClickThrough$MediaTailor_release(trimmedText(xmlPullParserNewPullParser.getText()));
                                }
                                break;
                            case 963670305:
                                if (str.equals(PATH_ICONCLICKFALLBACKIMAGE2_ALTTEXT)) {
                                    Intrinsics.checkNotNull(iconClickFallbackImage);
                                    iconClickFallbackImage.setAltText$MediaTailor_release(trimmedText(xmlPullParserNewPullParser.getText()));
                                }
                                break;
                            case 1118667239:
                                if (str.equals(PATH_STATICRESOURCE)) {
                                    Intrinsics.checkNotNull(icon);
                                    icon.setStaticResource$MediaTailor_release(trimmedText(xmlPullParserNewPullParser.getText()));
                                }
                                break;
                            case 1545816150:
                                if (str.equals(PATH_ICONCLICKFALLBACKIMAGE_ALTTEXT)) {
                                    Intrinsics.checkNotNull(iconClickFallbackImage);
                                    iconClickFallbackImage.setAltText$MediaTailor_release(trimmedText(xmlPullParserNewPullParser.getText()));
                                }
                                break;
                            case 1709095612:
                                if (str.equals(PATH_ICONCLICKFALLBACKIMAGE_STATICRESOURCE)) {
                                    Intrinsics.checkNotNull(iconClickFallbackImage);
                                    iconClickFallbackImage.setStaticResource$MediaTailor_release(trimmedText(xmlPullParserNewPullParser.getText()));
                                }
                                break;
                        }
                    }
                    xmlPullParserNewPullParser.next();
                    i = 0;
                } else {
                    if (!arrayList.isEmpty()) {
                        return arrayList;
                    }
                    Logger_androidKt.getLogger().w("adData: Invalid adChoices extension content: " + content);
                }
                return null;
            }
        } catch (Exception e) {
            Logger_androidKt.getLogger().w("adData: Exception (" + e.getMessage() + ") parsing adChoices extension: " + content);
        }
    }
}
