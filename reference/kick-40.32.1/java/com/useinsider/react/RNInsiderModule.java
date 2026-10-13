package com.useinsider.react;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.firebase.messaging.RemoteMessage;
import com.useinsider.insider.AppCardsCampaignsCallback;
import com.useinsider.insider.AppCardsDeleteCallback;
import com.useinsider.insider.AppCardsException;
import com.useinsider.insider.AppCardsMarkAsReadCallback;
import com.useinsider.insider.CloseButtonPosition;
import com.useinsider.insider.Insider;
import com.useinsider.insider.InsiderAppCard;
import com.useinsider.insider.InsiderAppCardButton;
import com.useinsider.insider.InsiderAppCardCampaignsResponse;
import com.useinsider.insider.InsiderCallback;
import com.useinsider.insider.InsiderCallbackType;
import com.useinsider.insider.InsiderIDListener;
import com.useinsider.insider.InsiderIdentifiers;
import com.useinsider.insider.InsiderProduct;
import com.useinsider.insider.InsiderUser;
import com.useinsider.insider.MessageCenterData;
import com.useinsider.insider.RecommendationEngine;
import com.useinsider.insiderhybrid.InsiderHybrid;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class RNInsiderModule extends ReactContextBaseJavaModule {
    private InsiderIDListener insiderIDListener;
    private boolean isCoreInited;
    private final ReactApplicationContext reactContext;

    @ReactMethod
    public void enableIDFACollection(boolean z) {
    }

    @ReactMethod
    public void setActiveForegroundPushView() {
    }

    @ReactMethod
    public void setAllowsBackgroundLocationUpdates(boolean z) {
    }

    @ReactMethod
    public void setForegroundPushCallback() {
    }

    public RNInsiderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.isCoreInited = false;
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNInsider";
    }

    @ReactMethod
    public void setName(String str) {
        try {
            Insider.Instance.getCurrentUser().setName(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void init(final String str, final String str2) {
        try {
            if (Insider.Instance.isSDKInitialized()) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.useinsider.react.RNInsiderModule.1
                @Override // java.lang.Runnable
                public void run() {
                    Insider.Instance.registerInsiderCallback(new InsiderCallback() { // from class: com.useinsider.react.RNInsiderModule.1.1
                        DeviceEventManagerModule.RCTDeviceEventEmitter emitter;

                        {
                            this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) RNInsiderModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
                        }

                        @Override // com.useinsider.insider.InsiderCallback
                        public void doAction(JSONObject jSONObject, InsiderCallbackType insiderCallbackType) {
                            try {
                                this.emitter.emit(insiderCallbackType.name(), RNUtils.convertJSONObjectToMap(jSONObject));
                            } catch (Exception e) {
                                Insider.Instance.putException(e);
                            }
                        }
                    });
                    Insider.Instance.init((Application) RNInsiderModule.this.reactContext.getApplicationContext(), str);
                    Insider.Instance.setSDKType("react-native");
                    Insider.Instance.setHybridSDKVersion(str2);
                    Insider.Instance.resumeSessionHybridConfig(RNInsiderModule.this.reactContext.getCurrentActivity());
                    if (RNInsiderModule.this.isCoreInited) {
                        Insider.Instance.resumeSessionHybridRequestConfig();
                    }
                    RNInsiderModule.this.isCoreInited = true;
                    Insider.Instance.storePartnerName(str);
                }
            });
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void reinitWithPartnerName(String str) {
        try {
            Insider.Instance.reinitWithPartnerName(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setCustomEndpoint(String str) {
        try {
            Insider.Instance.setCustomEndpoint(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void tagEvent(String str, ReadableArray readableArray) {
        try {
            RNUtils.parseEvent(str, readableArray).build();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setGender(int i) {
        try {
            InsiderHybrid.setGender(i);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setBirthday(String str) {
        try {
            Insider.Instance.getCurrentUser().setBirthday(new Date(Long.parseLong(str)));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setSurname(String str) {
        try {
            Insider.Instance.getCurrentUser().setSurname(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setAge(int i) {
        try {
            Insider.Instance.getCurrentUser().setAge(i);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setLanguage(String str) {
        try {
            Insider.Instance.getCurrentUser().setLanguage(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setLocale(String str) {
        try {
            Insider.Instance.getCurrentUser().setLocale(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setFacebookID(String str) {
        try {
            Insider.Instance.getCurrentUser().setFacebookID(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setTwitterID(String str) {
        try {
            Insider.Instance.getCurrentUser().setTwitterID(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setEmailOptin(boolean z) {
        try {
            Insider.Instance.getCurrentUser().setEmailOptin(z);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setEmail(String str) {
        try {
            Insider.Instance.getCurrentUser().setEmail(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setSMSOptin(boolean z) {
        try {
            Insider.Instance.getCurrentUser().setSMSOptin(z);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setPhoneNumber(String str) {
        try {
            Insider.Instance.getCurrentUser().setPhoneNumber(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setPushOptin(boolean z) {
        try {
            Insider.Instance.getCurrentUser().setPushOptin(z);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setLocationOptin(boolean z) {
        try {
            Insider.Instance.getCurrentUser().setLocationOptin(z);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setWhatsappOptin(boolean z) {
        try {
            Insider.Instance.getCurrentUser().setWhatsappOptin(z);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void login(ReadableMap readableMap) {
        try {
            Insider.Instance.getCurrentUser().login(setIdentifiers(readableMap));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void loginWithReturningID(ReadableMap readableMap, final Callback callback) {
        try {
            Insider.Instance.getCurrentUser().login(setIdentifiers(readableMap), new InsiderUser.InsiderIDResult() { // from class: com.useinsider.react.RNInsiderModule.2
                @Override // com.useinsider.insider.InsiderUser.InsiderIDResult
                public void insiderIDResult(String str) {
                    try {
                        callback.invoke(str);
                    } catch (Exception e) {
                        Insider.Instance.putException(e);
                    }
                }
            });
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private InsiderIdentifiers setIdentifiers(ReadableMap readableMap) {
        try {
            HashMap<String, Object> mapConvertReadableMapToMap = RNUtils.convertReadableMapToMap(readableMap);
            InsiderIdentifiers insiderIdentifiers = new InsiderIdentifiers();
            for (String str : mapConvertReadableMapToMap.keySet()) {
                int iHashCode = str.hashCode();
                if (iHashCode != -1260052613) {
                    if (iHashCode != -571806986) {
                        if (iHashCode == 56808999 && str.equals(InsiderHybridMethods.ADD_USER_ID)) {
                            insiderIdentifiers.addUserID(String.valueOf(mapConvertReadableMapToMap.get(str)));
                        } else {
                            insiderIdentifiers.addCustomIdentifier(str, String.valueOf(mapConvertReadableMapToMap.get(str)));
                        }
                    } else if (str.equals(InsiderHybridMethods.ADD_PHONE_NUMBER)) {
                        insiderIdentifiers.addPhoneNumber(String.valueOf(mapConvertReadableMapToMap.get(str)));
                    } else {
                        insiderIdentifiers.addCustomIdentifier(str, String.valueOf(mapConvertReadableMapToMap.get(str)));
                    }
                } else if (str.equals(InsiderHybridMethods.ADD_EMAIL)) {
                    insiderIdentifiers.addEmail(String.valueOf(mapConvertReadableMapToMap.get(str)));
                } else {
                    insiderIdentifiers.addCustomIdentifier(str, String.valueOf(mapConvertReadableMapToMap.get(str)));
                }
            }
            return insiderIdentifiers;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return new InsiderIdentifiers();
        }
    }

    @ReactMethod
    public void logout() {
        try {
            Insider.Instance.getCurrentUser().logout();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void logoutResettingInsiderID(ReadableArray readableArray, final Callback callback) {
        try {
            InsiderIdentifiers[] insiderIdentifiersArrConvertReadableArrayToInsiderIdentifiersArray = convertReadableArrayToInsiderIdentifiersArray(readableArray);
            if (callback != null) {
                Insider.Instance.getCurrentUser().logoutResettingInsiderID(insiderIdentifiersArrConvertReadableArrayToInsiderIdentifiersArray, new InsiderUser.InsiderIDResult() { // from class: com.useinsider.react.RNInsiderModule.3
                    @Override // com.useinsider.insider.InsiderUser.InsiderIDResult
                    public void insiderIDResult(String str) {
                        try {
                            callback.invoke(str);
                        } catch (Exception e) {
                            Insider.Instance.putException(e);
                        }
                    }
                });
            } else {
                Insider.Instance.getCurrentUser().logoutResettingInsiderID(insiderIdentifiersArrConvertReadableArrayToInsiderIdentifiersArray);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    private InsiderIdentifiers[] convertReadableArrayToInsiderIdentifiersArray(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        InsiderIdentifiers[] insiderIdentifiersArr = new InsiderIdentifiers[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            insiderIdentifiersArr[i] = setIdentifiers(readableArray.getMap(i));
        }
        return insiderIdentifiersArr;
    }

    @ReactMethod
    public void setCustomAttributeWithString(String str, String str2) {
        try {
            Insider.Instance.getCurrentUser().setCustomAttributeWithString(str, str2);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setCustomAttributeWithInt(String str, int i) {
        try {
            Insider.Instance.getCurrentUser().setCustomAttributeWithInt(str, i);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setCustomAttributeWithDouble(String str, double d) {
        try {
            Insider.Instance.getCurrentUser().setCustomAttributeWithDouble(str, d);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setCustomAttributeWithBoolean(String str, boolean z) {
        try {
            Insider.Instance.getCurrentUser().setCustomAttributeWithBoolean(str, z);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setCustomAttributeWithDate(String str, String str2) {
        try {
            Insider.Instance.getCurrentUser().setCustomAttributeWithDate(str, new Date(Long.parseLong(str2)));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setCustomAttributeWithArray(String str, ReadableArray readableArray) {
        try {
            Insider.Instance.getCurrentUser().setCustomAttributeWithArray(str, RNUtils.convertReadableArrayToStringArray(readableArray));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void unsetCustomAttribute(String str) {
        try {
            Insider.Instance.getCurrentUser().unsetCustomAttribute(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setGDPRConsent(final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.useinsider.react.RNInsiderModule.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Insider.Instance.setGDPRConsent(z);
                } catch (Exception e) {
                    Insider.Instance.putException(e);
                }
            }
        });
    }

    @ReactMethod
    public void setMobileAppAccess(boolean z) {
        try {
            Insider.Instance.setMobileAppAccess(z);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void itemPurchased(String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableArray readableArray, ReadableArray readableArray2) {
        try {
            InsiderProduct product = RNUtils.parseProduct(readableMap, readableMap2, readableArray);
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray2);
            if (!customParameters.isEmpty()) {
                Insider.Instance.itemPurchased(str, product, customParameters);
            } else {
                Insider.Instance.itemPurchased(str, product);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void itemAddedToCart(ReadableMap readableMap, ReadableMap readableMap2, ReadableArray readableArray, ReadableArray readableArray2) {
        try {
            InsiderProduct product = RNUtils.parseProduct(readableMap, readableMap2, readableArray);
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray2);
            if (!customParameters.isEmpty()) {
                Insider.Instance.itemAddedToCart(product, customParameters);
            } else {
                Insider.Instance.itemAddedToCart(product);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void itemRemovedFromCart(String str, String str2, ReadableArray readableArray) {
        try {
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray);
            if (str2 != null && str2.length() > 0) {
                Insider.Instance.itemRemovedFromCart(str, str2, customParameters);
            } else if (!customParameters.isEmpty()) {
                Insider.Instance.itemRemovedFromCart(str, customParameters);
            } else {
                Insider.Instance.itemRemovedFromCart(str);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void cartCleared(ReadableArray readableArray) {
        try {
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray);
            if (!customParameters.isEmpty()) {
                Insider.Instance.cartCleared(customParameters);
            } else {
                Insider.Instance.cartCleared();
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void itemAddedToWishlist(ReadableMap readableMap, ReadableMap readableMap2, ReadableArray readableArray, ReadableArray readableArray2) {
        try {
            InsiderProduct product = RNUtils.parseProduct(readableMap, readableMap2, readableArray);
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray2);
            if (!customParameters.isEmpty()) {
                Insider.Instance.itemAddedToWishlist(product, customParameters);
            } else {
                Insider.Instance.itemAddedToWishlist(product);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void itemRemovedFromWishlist(String str, ReadableArray readableArray) {
        try {
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray);
            if (!customParameters.isEmpty()) {
                Insider.Instance.itemRemovedFromWishlist(str, customParameters);
            } else {
                Insider.Instance.itemRemovedFromWishlist(str);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void wishlistCleared(ReadableArray readableArray) {
        try {
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray);
            if (!customParameters.isEmpty()) {
                Insider.Instance.wishlistCleared(customParameters);
            } else {
                Insider.Instance.wishlistCleared();
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getMessageCenterData(int i, String str, String str2, final Callback callback) {
        try {
            InsiderHybrid.getMessageCenterData(i, Long.parseLong(str), Long.parseLong(str2), new MessageCenterData() { // from class: com.useinsider.react.RNInsiderModule.5
                @Override // com.useinsider.insider.MessageCenterData
                public void loadMessageCenterData(JSONArray jSONArray) {
                    try {
                        callback.invoke(RNUtils.convertJSONArrayToArray(jSONArray).toString());
                    } catch (Exception e) {
                        Insider.Instance.putException(e);
                    }
                }
            });
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getMessageCenterDataWithIdentifiers(int i, String str, String str2, ReadableMap readableMap, final Callback callback) {
        try {
            Insider.Instance.getMessageCenterData(i, new Date(Long.parseLong(str)), new Date(Long.parseLong(str2)), setIdentifiers(readableMap), new MessageCenterData() { // from class: com.useinsider.react.RNInsiderModule.6
                @Override // com.useinsider.insider.MessageCenterData
                public void loadMessageCenterData(JSONArray jSONArray) {
                    try {
                        callback.invoke(RNUtils.convertJSONArrayToArray(jSONArray).toString());
                    } catch (Exception e) {
                        Insider.Instance.putException(e);
                    }
                }
            });
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getSmartRecommendation(int i, String str, String str2, final Callback callback) {
        try {
            Insider.Instance.getSmartRecommendation(i, str, str2, new RecommendationEngine.SmartRecommendation() { // from class: com.useinsider.react.RNInsiderModule.7
                @Override // com.useinsider.insider.RecommendationEngine.SmartRecommendation
                public void loadRecommendationData(JSONObject jSONObject) {
                    try {
                        callback.invoke(RNUtils.convertJSONObjectToMap(jSONObject));
                    } catch (Exception e) {
                        Insider.Instance.putException(e);
                    }
                }
            });
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getSmartRecommendationWithProduct(ReadableMap readableMap, ReadableMap readableMap2, ReadableArray readableArray, int i, String str, final Callback callback) {
        try {
            Insider.Instance.getSmartRecommendationWithProduct(RNUtils.parseProduct(readableMap, readableMap2, readableArray), i, str, new RecommendationEngine.SmartRecommendation() { // from class: com.useinsider.react.RNInsiderModule.8
                @Override // com.useinsider.insider.RecommendationEngine.SmartRecommendation
                public void loadRecommendationData(JSONObject jSONObject) {
                    try {
                        callback.invoke(RNUtils.convertJSONObjectToMap(jSONObject));
                    } catch (Exception e) {
                        Insider.Instance.putException(e);
                    }
                }
            });
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getSmartRecommendationWithProductIDs(ReadableArray readableArray, int i, String str, String str2, final Callback callback) {
        try {
            Insider.Instance.getSmartRecommendationWithProductIDs(RNUtils.convertReadableArrayToStringArray(readableArray), i, str, str2, new RecommendationEngine.SmartRecommendation() { // from class: com.useinsider.react.RNInsiderModule.9
                @Override // com.useinsider.insider.RecommendationEngine.SmartRecommendation
                public void loadRecommendationData(JSONObject jSONObject) {
                    try {
                        callback.invoke(RNUtils.convertJSONObjectToMap(jSONObject));
                    } catch (Exception e) {
                        Insider.Instance.putException(e);
                    }
                }
            });
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void clickSmartRecommendationProduct(int i, ReadableMap readableMap, ReadableMap readableMap2, ReadableArray readableArray) {
        try {
            Insider.Instance.clickSmartRecommendationProduct(i, RNUtils.parseProduct(readableMap, readableMap2, readableArray));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getContentStringWithName(String str, String str2, int i, Callback callback) {
        try {
            callback.invoke(InsiderHybrid.getContentStringWithName(str, str2, i));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getContentBoolWithName(String str, boolean z, int i, Callback callback) {
        try {
            callback.invoke(Boolean.valueOf(InsiderHybrid.getContentBoolWithName(str, z, i)));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getContentIntWithName(String str, int i, int i2, Callback callback) {
        try {
            callback.invoke(Integer.valueOf(InsiderHybrid.getContentIntWithName(str, i, i2)));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getContentStringWithoutCache(String str, String str2, int i, Callback callback) {
        try {
            callback.invoke(InsiderHybrid.getContentStringWithoutCache(str, str2, i));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getContentBoolWithoutCache(String str, boolean z, int i, Callback callback) {
        try {
            callback.invoke(Boolean.valueOf(InsiderHybrid.getContentBoolWithoutCache(str, z, i)));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getContentIntWithoutCache(String str, int i, int i2, Callback callback) {
        try {
            callback.invoke(Integer.valueOf(InsiderHybrid.getContentIntWithoutCache(str, i, i2)));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void visitHomePage(ReadableArray readableArray) {
        try {
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray);
            if (!customParameters.isEmpty()) {
                Insider.Instance.visitHomePage(customParameters);
            } else {
                Insider.Instance.visitHomePage();
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void visitListingPage(ReadableArray readableArray, ReadableArray readableArray2) {
        try {
            String[] strArrConvertReadableArrayToStringArray = RNUtils.convertReadableArrayToStringArray(readableArray);
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray2);
            if (!customParameters.isEmpty()) {
                Insider.Instance.visitListingPage(strArrConvertReadableArrayToStringArray, customParameters);
            } else {
                Insider.Instance.visitListingPage(strArrConvertReadableArrayToStringArray);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void visitProductDetailPage(ReadableMap readableMap, ReadableMap readableMap2, ReadableArray readableArray, ReadableArray readableArray2) {
        try {
            InsiderProduct product = RNUtils.parseProduct(readableMap, readableMap2, readableArray);
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray2);
            if (!customParameters.isEmpty()) {
                Insider.Instance.visitProductDetailPage(product, customParameters);
            } else {
                Insider.Instance.visitProductDetailPage(product);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void visitCartPage(ReadableArray readableArray, String str, ReadableArray readableArray2) {
        try {
            InsiderProduct[] insiderProductArr = new InsiderProduct[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap map = readableArray.getMap(i);
                insiderProductArr[i] = RNUtils.parseProduct(map.getMap("requiredFields"), map.getMap("optionalFields"), map.getArray("customParameters"));
            }
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray2);
            if (str != null && str.length() > 0) {
                Insider.Instance.visitCartPage(insiderProductArr, str, customParameters);
            } else if (!customParameters.isEmpty()) {
                Insider.Instance.visitCartPage(insiderProductArr, customParameters);
            } else {
                Insider.Instance.visitCartPage(insiderProductArr);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void visitWishlistPage(ReadableArray readableArray, ReadableArray readableArray2) {
        try {
            InsiderProduct[] insiderProductArr = new InsiderProduct[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap map = readableArray.getMap(i);
                insiderProductArr[i] = RNUtils.parseProduct(map.getMap("requiredFields"), map.getMap("optionalFields"), map.getArray("customParameters"));
            }
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray2);
            if (!customParameters.isEmpty()) {
                Insider.Instance.visitWishlistPage(insiderProductArr, customParameters);
            } else {
                Insider.Instance.visitWishlistPage(insiderProductArr);
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void startTrackingGeofence() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.useinsider.react.RNInsiderModule.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Insider.Instance.startTrackingGeofence();
                } catch (Exception e) {
                    Insider.Instance.putException(e);
                }
            }
        });
    }

    @ReactMethod
    public void removeInapp() {
        try {
            Insider.Instance.removeInapp(this.reactContext.getCurrentActivity());
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void handleNotification(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        try {
            HashMap map = new HashMap();
            for (String str : RNUtils.convertReadableMapToMap(readableMap).keySet()) {
                map.put(str, String.valueOf(RNUtils.convertReadableMapToMap(readableMap).get(str)));
            }
            String currentProvider = Insider.Instance.getCurrentProvider(this.reactContext);
            int iHashCode = currentProvider.hashCode();
            if (iHashCode != -1240244679) {
                if (iHashCode != 106069776 || !currentProvider.equals("other")) {
                    return;
                }
            } else if (!currentProvider.equals("google")) {
                return;
            }
            Insider.Instance.handleFCMNotification(this.reactContext, new RemoteMessage.Builder("insider").setData(map).build());
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void triggerPushProcessWithNotificationData(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        try {
            HashMap<String, Object> mapConvertReadableMapToMap = RNUtils.convertReadableMapToMap(readableMap);
            HashMap map = new HashMap();
            for (String str : mapConvertReadableMapToMap.keySet()) {
                map.put(str, String.valueOf(mapConvertReadableMapToMap.get(str)));
            }
            Insider.Instance.triggerPushProcessWithNotificationData(this.reactContext, map);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setHybridPushToken(String str) {
        try {
            Insider.Instance.setHybridPushToken(str);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void putErrorLog(String str) {
        try {
            Insider.Instance.putException(new Exception(str));
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    public void showNativeAppReview() {
        try {
            Insider.Instance.showNativeRating();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void enableLocationCollection(final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.useinsider.react.RNInsiderModule.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Insider.Instance.enableLocationCollection(z);
                } catch (Exception e) {
                    Insider.Instance.putException(e);
                }
            }
        });
    }

    @ReactMethod
    public void enableIpCollection(final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.useinsider.react.RNInsiderModule.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Insider.Instance.enableIpCollection(z);
                } catch (Exception e) {
                    Insider.Instance.putException(e);
                }
            }
        });
    }

    @ReactMethod
    public void enableCarrierCollection(final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.useinsider.react.RNInsiderModule.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Insider.Instance.enableCarrierCollection(z);
                } catch (Exception e) {
                    Insider.Instance.putException(e);
                }
            }
        });
    }

    @ReactMethod
    public void signUpConfirmation(ReadableArray readableArray) {
        try {
            Map<String, ?> customParameters = RNUtils.parseCustomParameters(readableArray);
            if (!customParameters.isEmpty()) {
                Insider.Instance.signUpConfirmation(customParameters);
            } else {
                Insider.Instance.signUpConfirmation();
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void setInternalBrowserCloseButtonPosition(String str) {
        if (str == null) {
            return;
        }
        try {
            Insider.Instance.setInternalBrowserCloseButtonPosition(CloseButtonPosition.valueOf(str));
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void handleUniversalLink(String str) {
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse(str));
            Insider.Instance.handleUniversalLink(intent);
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getInsiderID(Promise promise) {
        try {
            promise.resolve(Insider.Instance.getInsiderID());
        } catch (Exception e) {
            Insider.Instance.putException(e);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void registerInsiderIDListener() {
        try {
            if (this.insiderIDListener == null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.useinsider.react.RNInsiderModule.14
                    @Override // java.lang.Runnable
                    public void run() {
                        RNInsiderModule.this.insiderIDListener = new InsiderIDListener() { // from class: com.useinsider.react.RNInsiderModule.14.1
                            DeviceEventManagerModule.RCTDeviceEventEmitter emitter;

                            {
                                this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) RNInsiderModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
                            }

                            @Override // com.useinsider.insider.InsiderIDListener
                            public void onUpdated(String str) {
                                this.emitter.emit("INSIDER_ID_LISTENER", str);
                            }
                        };
                        Insider.Instance.registerInsiderIDListener(RNInsiderModule.this.insiderIDListener);
                    }
                });
            }
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void disableInAppMessages() {
        try {
            Insider.Instance.disableInAppMessages();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void enableInAppMessages() {
        try {
            Insider.Instance.enableInAppMessages();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void getAppCardsCampaigns(final Callback callback) {
        try {
            Insider.Instance.appCards().getCampaigns(new AppCardsCampaignsCallback() { // from class: com.useinsider.react.RNInsiderModule$$ExternalSyntheticLambda0
                @Override // com.useinsider.insider.AppCardsCampaignsCallback
                public final void onComplete(InsiderAppCardCampaignsResponse insiderAppCardCampaignsResponse, AppCardsException appCardsException) {
                    RNInsiderModule.lambda$getAppCardsCampaigns$0(callback, insiderAppCardCampaignsResponse, appCardsException);
                }
            });
        } catch (Exception e) {
            callback.invoke(RNUtils.appCardsErrorToMap(null));
            Insider.Instance.putException(e);
        }
    }

    static /* synthetic */ void lambda$getAppCardsCampaigns$0(Callback callback, InsiderAppCardCampaignsResponse insiderAppCardCampaignsResponse, AppCardsException appCardsException) {
        if (appCardsException != null || insiderAppCardCampaignsResponse == null) {
            callback.invoke(RNUtils.appCardsErrorToMap(appCardsException));
        } else {
            callback.invoke(null, RNUtils.convertJSONObjectToMap(insiderAppCardCampaignsResponse.toJSONObject()));
        }
    }

    @ReactMethod
    public void markAppCardsAsRead(ReadableArray readableArray, final Callback callback) {
        try {
            Insider.Instance.appCards().markAsRead(RNUtils.convertReadableArrayToStringArray(readableArray), new AppCardsMarkAsReadCallback() { // from class: com.useinsider.react.RNInsiderModule$$ExternalSyntheticLambda3
                @Override // com.useinsider.insider.AppCardsMarkAsReadCallback
                public final void onComplete(AppCardsException appCardsException) {
                    RNInsiderModule.lambda$markAppCardsAsRead$1(callback, appCardsException);
                }
            });
        } catch (Exception e) {
            callback.invoke(RNUtils.appCardsErrorToMap(null));
            Insider.Instance.putException(e);
        }
    }

    static /* synthetic */ void lambda$markAppCardsAsRead$1(Callback callback, AppCardsException appCardsException) {
        if (appCardsException != null) {
            callback.invoke(RNUtils.appCardsErrorToMap(appCardsException));
        } else {
            callback.invoke(new Object[0]);
        }
    }

    @ReactMethod
    public void markAppCardsAsUnread(ReadableArray readableArray, final Callback callback) {
        try {
            Insider.Instance.appCards().markAsUnread(RNUtils.convertReadableArrayToStringArray(readableArray), new AppCardsMarkAsReadCallback() { // from class: com.useinsider.react.RNInsiderModule$$ExternalSyntheticLambda1
                @Override // com.useinsider.insider.AppCardsMarkAsReadCallback
                public final void onComplete(AppCardsException appCardsException) {
                    RNInsiderModule.lambda$markAppCardsAsUnread$2(callback, appCardsException);
                }
            });
        } catch (Exception e) {
            callback.invoke(RNUtils.appCardsErrorToMap(null));
            Insider.Instance.putException(e);
        }
    }

    static /* synthetic */ void lambda$markAppCardsAsUnread$2(Callback callback, AppCardsException appCardsException) {
        if (appCardsException != null) {
            callback.invoke(RNUtils.appCardsErrorToMap(appCardsException));
        } else {
            callback.invoke(new Object[0]);
        }
    }

    @ReactMethod
    public void deleteAppCards(ReadableArray readableArray, final Callback callback) {
        try {
            Insider.Instance.appCards().delete(RNUtils.convertReadableArrayToStringArray(readableArray), new AppCardsDeleteCallback() { // from class: com.useinsider.react.RNInsiderModule$$ExternalSyntheticLambda2
                @Override // com.useinsider.insider.AppCardsDeleteCallback
                public final void onComplete(AppCardsException appCardsException) {
                    RNInsiderModule.lambda$deleteAppCards$3(callback, appCardsException);
                }
            });
        } catch (Exception e) {
            callback.invoke(RNUtils.appCardsErrorToMap(null));
            Insider.Instance.putException(e);
        }
    }

    static /* synthetic */ void lambda$deleteAppCards$3(Callback callback, AppCardsException appCardsException) {
        if (appCardsException != null) {
            callback.invoke(RNUtils.appCardsErrorToMap(appCardsException));
        } else {
            callback.invoke(new Object[0]);
        }
    }

    @ReactMethod
    public void clickAppCardButton(String str, ReadableMap readableMap) {
        try {
            new InsiderAppCardButton(str, new JSONObject(RNUtils.convertReadableMapToMap(readableMap))).click();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void viewAppCard(ReadableMap readableMap) {
        try {
            new InsiderAppCard(new JSONObject(RNUtils.convertReadableMapToMap(readableMap))).view();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }

    @ReactMethod
    public void clickAppCard(ReadableMap readableMap) {
        try {
            new InsiderAppCard(new JSONObject(RNUtils.convertReadableMapToMap(readableMap))).click();
        } catch (Exception e) {
            Insider.Instance.putException(e);
        }
    }
}
