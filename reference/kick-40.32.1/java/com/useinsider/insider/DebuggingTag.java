package com.useinsider.insider;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.GapComposerKt;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import com.google.android.gms.cast.MediaError;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;
import expo.modules.notifications.service.NotificationsService;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'tagEvent' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
public final class DebuggingTag {
    public static final DebuggingTag addAsNewContentVariable;
    public static final DebuggingTag addContentOptimizerLog;
    public static final DebuggingTag addGeofencesToClient;
    public static final DebuggingTag appCardsDelete;
    public static final DebuggingTag appCardsDeleteResponse;
    public static final DebuggingTag appCardsGetCampaigns;
    public static final DebuggingTag appCardsGetCampaignsResponse;
    public static final DebuggingTag appCardsLog;
    public static final DebuggingTag appCardsMarkAsRead;
    public static final DebuggingTag appCardsMarkAsReadResponse;
    public static final DebuggingTag appCardsMarkAsUnRead;
    public static final DebuggingTag appCardsMarkAsUnReadResponse;
    public static final DebuggingTag appCardsRunAction;
    public static final DebuggingTag assurance;
    public static final DebuggingTag buildGeofences;
    private static final /* synthetic */ DebuggingTag[] c;
    public static final DebuggingTag cartCleared;
    public static final DebuggingTag changeIcon;
    public static final DebuggingTag checkGDPRConsent;
    public static final DebuggingTag checkMobileAppAccess;
    public static final DebuggingTag cleanViewError;
    public static final DebuggingTag createNewProduct;
    public static final DebuggingTag customKeyValuePairHasBeenSetForPushIntent;
    public static final DebuggingTag deviceLocation;
    public static final DebuggingTag disableBlockedInapp;
    public static final DebuggingTag enableCarrierCollection;
    public static final DebuggingTag enableInAppMessages;
    public static final DebuggingTag enableIpCollection;
    public static final DebuggingTag enableLocationCollection;
    public static final DebuggingTag exception;
    public static final DebuggingTag finishedRetriedRequests;
    public static final DebuggingTag flushingData;
    public static final DebuggingTag flushingDataEncrypted;
    public static final DebuggingTag flushingFailed;
    public static final DebuggingTag flushingFailedAndAddedToSharedPref;
    public static final DebuggingTag flushingRequestNotSent;
    public static final DebuggingTag flushingSuccessfully;
    public static final DebuggingTag flushingTimerStarted;
    public static final DebuggingTag flushingTimerStopped;
    public static final DebuggingTag flushingTimerStoppedDueToZeroInterval;
    public static final DebuggingTag gdprBlockedSessionContinuation;
    public static final DebuggingTag geofenceRequest;
    public static final DebuggingTag geofencesRemoved;
    public static final DebuggingTag getBoolWithName;
    public static final DebuggingTag getBoolWithNameWithoutCache;
    public static final DebuggingTag getCurrentProvider;
    public static final DebuggingTag getDeepLinkData;
    public static final DebuggingTag getIntWithName;
    public static final DebuggingTag getIntWithNameWithoutCache;
    public static final DebuggingTag getMessageCenterData;
    public static final DebuggingTag getMessageCenterDataResponse;
    public static final DebuggingTag getPushToken;
    public static final DebuggingTag getSmartRecommendation;
    public static final DebuggingTag getSmartRecommendationRequestURL;
    public static final DebuggingTag getSmartRecommendationWarning;
    public static final DebuggingTag getSmartRecommendationWithProduct;
    public static final DebuggingTag getSmartRecommendationWithProductID;
    public static final DebuggingTag getSmartRecommendationWithProductIDWarning;
    public static final DebuggingTag getSmartRecommendationWithProductWarning;
    public static final DebuggingTag getStringWithName;
    public static final DebuggingTag getStringWithNameWithoutCache;
    public static final DebuggingTag identityRequestEncrypted;
    public static final DebuggingTag inappClickLog;
    public static final DebuggingTag init;
    public static final DebuggingTag initInvalidPartnerName;
    public static final DebuggingTag initializeGeofence;
    public static final DebuggingTag insiderAmplificationServiceCancel;
    public static final DebuggingTag insiderAmplificationServiceFail;
    public static final DebuggingTag insiderAmplificationServiceFrequencyDiff;
    public static final DebuggingTag insiderAmplificationServiceRemoveJobID;
    public static final DebuggingTag insiderAmplificationServiceRunAndReschedule;
    public static final DebuggingTag insiderAmplificationServiceRunning;
    public static final DebuggingTag insiderAmplificationServiceSetJobID;
    public static final DebuggingTag insiderAmplificationServiceStart;
    public static final DebuggingTag insiderAmplificationServiceStarting;
    public static final DebuggingTag insiderAmplificationServiceStatus;
    public static final DebuggingTag insiderCallbackNotDefined;
    public static final DebuggingTag insiderCallbackTriggered;
    public static final DebuggingTag insiderIdentifierRequestJSON;
    public static final DebuggingTag insiderLogService;
    public static final DebuggingTag insiderLogServicePutLog;
    public static final DebuggingTag invalidGeofenceReceived;
    public static final DebuggingTag invalidUserEmail;
    public static final DebuggingTag invalidUserPhoneNumber;
    public static final DebuggingTag isNameValid;
    public static final DebuggingTag isNameValidEmpty;
    public static final DebuggingTag itemAddedToCart;
    public static final DebuggingTag itemAddedToWishlist;
    public static final DebuggingTag itemPurchased;
    public static final DebuggingTag itemRemovedFromCart;
    public static final DebuggingTag itemRemovedFromWishlist;
    public static final DebuggingTag logSystemRequestEncrypted;
    public static final DebuggingTag login;
    public static final DebuggingTag logout;
    public static final DebuggingTag messageCenterRequestEncrypted;
    public static final DebuggingTag nativeLocationWarning;
    public static final DebuggingTag noActiveServiceProvider;
    public static final DebuggingTag openLogRequestReceived;
    public static final DebuggingTag processTemplateStoreURL;
    public static final DebuggingTag pushOptinWarning;
    public static final DebuggingTag pushReceived;
    public static final DebuggingTag pushTokenRenewal;
    public static final DebuggingTag refreshIdentity;
    public static final DebuggingTag registerInsiderCallback;
    public static final DebuggingTag reinitCalled;
    public static final DebuggingTag reinitCompletedWhenGDPRFalse;
    public static final DebuggingTag reinitFailedBecauseFirstInitialization;
    public static final DebuggingTag reinitFailedBecauseOfSDKFrozen;
    public static final DebuggingTag reinitFailedBecauseOfSamePartnerName;
    public static final DebuggingTag reinitSessionStopCompleted;
    public static final DebuggingTag removeBlockedInapp;
    public static final DebuggingTag removeCachedInsiderID;
    public static final DebuggingTag removeInapp;
    public static final DebuggingTag removeInappSilently;
    public static final DebuggingTag requestAddedToQueue;
    public static final DebuggingTag requestEncrypted;
    public static final DebuggingTag retriedQueuedRequests;
    public static final DebuggingTag saveAndRetrieveGdprStatus;
    public static final DebuggingTag sessionDataCleared;
    public static final DebuggingTag sessionDataStored;
    public static final DebuggingTag sessionPayloadServiceCanceled;
    public static final DebuggingTag sessionPayloadServiceIsAlreadyRunning;
    public static final DebuggingTag sessionPayloadServiceIsRunning;
    public static final DebuggingTag sessionPayloadServiceIsRunningButNotFoundStoredData;
    public static final DebuggingTag sessionPayloadServiceIsStopped;
    public static final DebuggingTag sessionPayloadServiceScheduled;
    public static final DebuggingTag sessionStartRequest;
    public static final DebuggingTag sessionStartResponse;
    public static final DebuggingTag sessionStartResponseError;
    public static final DebuggingTag sessionStopRequest;
    public static final DebuggingTag sessionStopRequestEncrypted;
    public static final DebuggingTag setAlarmForTTL;
    public static final DebuggingTag setCustomAttribute;
    public static final DebuggingTag setCustomBoldFont;
    public static final DebuggingTag setCustomItalicFont;
    public static final DebuggingTag setCustomRegularFont;
    public static final DebuggingTag setGDPRConsent;
    public static final DebuggingTag setInternalBrowserCloseButtonPosition;
    public static final DebuggingTag setLocationOptIn;
    public static final DebuggingTag setMobileAppAccess;
    public static final DebuggingTag setPushOptIn;
    public static final DebuggingTag setUserAttribute;
    public static final DebuggingTag setUserIdentifier;
    public static final DebuggingTag setUserIdentifierSuccess;
    public static final DebuggingTag showNativeRating;
    public static final DebuggingTag showNativeRatingFail;
    public static final DebuggingTag showNativeRatingFlowSuccess;
    public static final DebuggingTag showNativeRatingSuccess;
    public static final DebuggingTag signUpConfirmation;
    public static final DebuggingTag startTrackingGeofence;
    public static final DebuggingTag tagEvent;
    public static final DebuggingTag tagEventWithParameters;
    public static final DebuggingTag templateLog;
    public static final DebuggingTag terminatedConnection;
    public static final DebuggingTag testInAppReceived;
    public static final DebuggingTag universalLinkHasBeenSet;
    public static final DebuggingTag unsetCustomAttribute;
    public static final DebuggingTag unsetUserIdentifier;
    public static final DebuggingTag updatedInAppList;
    public static final DebuggingTag visitCartPage;
    public static final DebuggingTag visitHomepage;
    public static final DebuggingTag visitListingPage;
    public static final DebuggingTag visitProductDetailPage;
    public static final DebuggingTag visitProductDetailPageDetail;
    public static final DebuggingTag visitWishlistPage;
    public static final DebuggingTag warningMessageForEventValue;
    public static final DebuggingTag webViewSdk;
    public static final DebuggingTag wishlistCleared;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f282a;
    private final a b;

    /* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
    enum a {
        ENABLED,
        DISABLED
    }

    static {
        a aVar = a.ENABLED;
        tagEvent = new DebuggingTag(InsiderHybridMethods.TAG_EVENT, 0, "%s", aVar);
        tagEventWithParameters = new DebuggingTag("tagEventWithParameters", 1, "%s", aVar);
        setCustomAttribute = new DebuggingTag("setCustomAttribute", 2, "Custom Attribute Detail: %s", aVar);
        setUserAttribute = new DebuggingTag("setUserAttribute", 3, "User Attribute Detail: %s", aVar);
        setPushOptIn = new DebuggingTag("setPushOptIn", 4, "%s", aVar);
        setLocationOptIn = new DebuggingTag("setLocationOptIn", 5, "%s", aVar);
        itemAddedToCart = new DebuggingTag(InsiderHybridMethods.ITEM_ADDED_TO_CART, 6, "%s", aVar);
        itemPurchased = new DebuggingTag(InsiderHybridMethods.ITEM_PURCHASED, 7, "%s", aVar);
        itemRemovedFromCart = new DebuggingTag(InsiderHybridMethods.ITEM_REMOVED_FROM_CART, 8, "%s", aVar);
        cartCleared = new DebuggingTag(InsiderHybridMethods.CART_CLEARED, 9, "Cart cleared.", aVar);
        visitCartPage = new DebuggingTag(InsiderHybridMethods.VISIT_CART_PAGE, 10, "%s", aVar);
        createNewProduct = new DebuggingTag("createNewProduct", 11, "%s", aVar);
        visitProductDetailPage = new DebuggingTag(InsiderHybridMethods.VISIT_PRODUCT_DETAIL_PAGE, 12, "%s", aVar);
        a aVar2 = a.DISABLED;
        unsetCustomAttribute = new DebuggingTag(InsiderHybridMethods.UNSET_CUSTOM_ATTRIBUTE, 13, "%s", aVar2);
        setUserIdentifier = new DebuggingTag("setUserIdentifier", 14, "%s", aVar2);
        refreshIdentity = new DebuggingTag("refreshIdentity", 15, "%s", aVar2);
        unsetUserIdentifier = new DebuggingTag("unsetUserIdentifier", 16, "%s", aVar2);
        nativeLocationWarning = new DebuggingTag("nativeLocationWarning", 17, "The location_enabled value was not changed because the fine location and always allow were not selected for native location permission", aVar2);
        pushOptinWarning = new DebuggingTag("pushOptinWarning", 18, "The push_enabled value was not changed because allow were not selected for native push permission", aVar2);
        setGDPRConsent = new DebuggingTag(InsiderHybridMethods.SET_GDPR_CONSENT, 19, "%s", aVar2);
        setMobileAppAccess = new DebuggingTag("setMobileAppAccess", 20, "%s", aVar2);
        checkMobileAppAccess = new DebuggingTag("checkMobileAppAccess", 21, "%s", aVar2);
        setInternalBrowserCloseButtonPosition = new DebuggingTag("setInternalBrowserCloseButtonPosition", 22, "%s", aVar2);
        itemAddedToWishlist = new DebuggingTag("itemAddedToWishlist", 23, "%s", aVar2);
        itemRemovedFromWishlist = new DebuggingTag("itemRemovedFromWishlist", 24, "%s", aVar2);
        wishlistCleared = new DebuggingTag("wishlistCleared", 25, "Wishlist cleared.", aVar2);
        visitWishlistPage = new DebuggingTag("visitWishlistPage", 26, "%s", aVar2);
        visitProductDetailPageDetail = new DebuggingTag("visitProductDetailPageDetail", 27, "%s", aVar2);
        visitHomepage = new DebuggingTag("visitHomepage", 28, "", aVar2);
        visitListingPage = new DebuggingTag(InsiderHybridMethods.VISIT_LISTING_PAGE, 29, "%s", aVar2);
        removeInapp = new DebuggingTag(InsiderHybridMethods.REMOVE_INAPP, 30, "", aVar2);
        removeBlockedInapp = new DebuggingTag("removeBlockedInapp", 31, "In-app messages disabled and In-app removed.", aVar2);
        disableBlockedInapp = new DebuggingTag("disableBlockedInapp", 32, "In-app messages disabled for the current session.", aVar2);
        enableInAppMessages = new DebuggingTag("enableInAppMessages", 33, "Inapp messages enabled for the current session.", aVar2);
        registerInsiderCallback = new DebuggingTag("registerInsiderCallback", 34, "", aVar2);
        insiderCallbackNotDefined = new DebuggingTag("insiderCallbackNotDefined", 35, "", aVar2);
        insiderCallbackTriggered = new DebuggingTag("insiderCallbackTriggered", 36, "Callback Detail: %s", aVar2);
        startTrackingGeofence = new DebuggingTag(InsiderHybridMethods.START_TRACKING_GEOFENCE, 37, "Geofence is enabled.", aVar2);
        deviceLocation = new DebuggingTag("deviceLocation", 38, "", aVar2);
        getSmartRecommendationWithProduct = new DebuggingTag(InsiderHybridMethods.GET_SMART_RECOMMENDATION_WITH_PRODUCT, 39, "Recommendation Detail: %s", aVar2);
        getSmartRecommendationWithProductID = new DebuggingTag("getSmartRecommendationWithProductID", 40, "Recommendation Detail: %s", aVar2);
        getSmartRecommendation = new DebuggingTag(InsiderHybridMethods.GET_SMART_RECOMMENDATION, 41, "Recommendation Detail: %s", aVar2);
        getStringWithName = new DebuggingTag("getStringWithName", 42, "Content Optimizer Detail: %s", aVar2);
        terminatedConnection = new DebuggingTag("terminatedConnection", 43, "Terminated test lab or wizard connection.", aVar2);
        getIntWithName = new DebuggingTag("getIntWithName", 44, "Content Optimizer Detail: %s", aVar2);
        getBoolWithName = new DebuggingTag("getBoolWithName", 45, "Content Optimizer Detail: %s", aVar2);
        getStringWithNameWithoutCache = new DebuggingTag("getStringWithNameWithoutCache", 46, "Content Optimizer Detail: %s", aVar2);
        getIntWithNameWithoutCache = new DebuggingTag("getIntWithNameWithoutCache", 47, "Content Optimizer Detail: %s", aVar2);
        getBoolWithNameWithoutCache = new DebuggingTag("getBoolWithNameWithoutCache", 48, "Content Optimizer Detail: %s", aVar2);
        pushReceived = new DebuggingTag("pushReceived", 49, "%s", aVar2);
        testInAppReceived = new DebuggingTag("testInAppReceived", 50, "", aVar2);
        init = new DebuggingTag("init", 51, "Initialization Detail: %s", aVar2);
        checkGDPRConsent = new DebuggingTag("checkGDPRConsent", 52, "%s", aVar2);
        initInvalidPartnerName = new DebuggingTag("initInvalidPartnerName", 53, "partner name is not valid. partnerName: %s", aVar2);
        reinitCalled = new DebuggingTag("reinitCalled", 54, "Reinit called. newPartnerName: %s", aVar2);
        reinitSessionStopCompleted = new DebuggingTag("reinitSessionStopCompleted", 55, "Reinit session stop completed. newPartnerName: %s", aVar2);
        reinitFailedBecauseOfSDKFrozen = new DebuggingTag("reinitFailedBecauseOfSDKFrozen", 56, "Reinit failed. Because of sdk frozen. newPartnerName: %s", aVar2);
        reinitFailedBecauseOfSamePartnerName = new DebuggingTag("reinitFailedBecauseOfSamePartnerName", 57, "Reinit failed. Reinit with the same partner name. newPartnerName: %s", aVar2);
        reinitCompletedWhenGDPRFalse = new DebuggingTag("reinitCompletedWhenGDPRFalse", 58, "Reinit completed. However, session data is not sent because GDPR is false. newPartnerName: %s", aVar2);
        reinitFailedBecauseFirstInitialization = new DebuggingTag("reinitFailedBecauseFirstInitialization", 59, "Reinit failed. Make sure the Insider SDK is init. newPartnerName: %s", aVar2);
        initializeGeofence = new DebuggingTag("initializeGeofence", 60, "Insider geofence initialized.", aVar2);
        geofenceRequest = new DebuggingTag("geofenceRequest", 61, "%s", aVar2);
        buildGeofences = new DebuggingTag("buildGeofences", 62, "Location Detail: %s", aVar2);
        addGeofencesToClient = new DebuggingTag("addGeofencesToClient", 63, "Geofencing request successfully added.", aVar2);
        invalidGeofenceReceived = new DebuggingTag("invalidGeofenceReceived", 64, "Invalid geofence action received.", aVar2);
        sessionStartRequest = new DebuggingTag("sessionStartRequest", 65, "%s", aVar2);
        sessionStartResponseError = new DebuggingTag("sessionStartResponseError", 66, "Invalid JSON: %s", aVar2);
        sessionStartResponse = new DebuggingTag("sessionStartResponse", 67, "%s", aVar2);
        sessionStopRequest = new DebuggingTag("sessionStopRequest", 68, "%s", aVar2);
        flushingData = new DebuggingTag("flushingData", 69, "%s", aVar2);
        flushingSuccessfully = new DebuggingTag("flushingSuccessfully", 70, "Flushing data successfully sent.", aVar2);
        flushingFailed = new DebuggingTag("flushingFailed", 71, "Flushing data was not sent successfully and merged cloned data to current data.", aVar2);
        flushingFailedAndAddedToSharedPref = new DebuggingTag("flushingFailedAndAddedToSharedPref", 72, "Flushing data was not sent successfully and added to queue.", aVar2);
        flushingTimerStarted = new DebuggingTag("flushingTimerStarted", 73, "Flushing timer is started. Time Detail: %s", aVar2);
        flushingTimerStopped = new DebuggingTag("flushingTimerStopped", 74, "Flushing timer is stopped.", aVar2);
        flushingRequestNotSent = new DebuggingTag("flushingRequestNotSent", 75, "Flush request was not sent because the stop data did not contain new data. Stop Data: %s", aVar2);
        flushingTimerStoppedDueToZeroInterval = new DebuggingTag("flushingTimerStoppedDueToZeroInterval", 76, "Flushing timer is stopped due to zero interval.", aVar2);
        sessionPayloadServiceIsRunning = new DebuggingTag("sessionPayloadServiceIsRunning", 77, "Session payload service is running.", aVar2);
        sessionPayloadServiceIsRunningButNotFoundStoredData = new DebuggingTag("sessionPayloadServiceIsRunningButNotFoundStoredData", 78, "Session payload service is running but not found stored data.", aVar2);
        sessionPayloadServiceIsStopped = new DebuggingTag("sessionPayloadServiceIsStopped", 79, "Session payload service is stopped.", aVar2);
        sessionDataStored = new DebuggingTag("sessionDataStored", 80, "Session data stored.", aVar2);
        sessionDataCleared = new DebuggingTag("sessionDataCleared", 81, "Session data cleared.", aVar2);
        sessionPayloadServiceIsAlreadyRunning = new DebuggingTag("sessionPayloadServiceIsAlreadyRunning", 82, "Session payload service is already running.", aVar2);
        sessionPayloadServiceScheduled = new DebuggingTag("sessionPayloadServiceScheduled", 83, "Session payload service is scheduled.", aVar2);
        sessionPayloadServiceCanceled = new DebuggingTag("sessionPayloadServiceCanceled", 84, "Session payload service is canceled.", aVar2);
        requestEncrypted = new DebuggingTag("requestEncrypted", 85, "%s", aVar2);
        sessionStopRequestEncrypted = new DebuggingTag("sessionStopRequestEncrypted", 86, "%s", aVar2);
        flushingDataEncrypted = new DebuggingTag("flushingDataEncrypted", 87, "%s", aVar2);
        identityRequestEncrypted = new DebuggingTag("identityRequestEncrypted", 88, "%s", aVar2);
        messageCenterRequestEncrypted = new DebuggingTag("messageCenterRequestEncrypted", 89, "%s", aVar2);
        logSystemRequestEncrypted = new DebuggingTag("logSystemRequestEncrypted", 90, "%s", aVar2);
        getSmartRecommendationRequestURL = new DebuggingTag("getSmartRecommendationRequestURL", 91, "%s", aVar2);
        getSmartRecommendationWithProductWarning = new DebuggingTag("getSmartRecommendationWithProductWarning", 92, "All the parameters should have value and product should be valid. Detail: %s", aVar2);
        getSmartRecommendationWithProductIDWarning = new DebuggingTag("getSmartRecommendationWithProductIDWarning", 93, "All the parameters should have value and product Ids should be valid. Detail: %s", aVar2);
        getSmartRecommendationWarning = new DebuggingTag("getSmartRecommendationWarning", 94, "All the parameters should have value. Detail: %s", aVar2);
        getMessageCenterData = new DebuggingTag(InsiderHybridMethods.GET_MESSAGE_CENTER_DATA, 95, "%s", aVar2);
        getMessageCenterDataResponse = new DebuggingTag("getMessageCenterDataResponse", 96, "%s", aVar2);
        getPushToken = new DebuggingTag("getPushToken", 97, "Token Detail: %s", aVar2);
        pushTokenRenewal = new DebuggingTag("pushTokenRenewal", 98, "%s Push Token is changed.", aVar2);
        addAsNewContentVariable = new DebuggingTag("addAsNewContentVariable", 99, "Content Detail: %s", aVar2);
        addContentOptimizerLog = new DebuggingTag("addContentOptimizerLog", 100, "Value changed for variable %s", aVar2);
        isNameValidEmpty = new DebuggingTag("isNameValidEmpty", 101, "Your event or attribute name is empty.", aVar2);
        isNameValid = new DebuggingTag("isNameValid", 102, "%s is not valid name for event or attribute.", aVar2);
        warningMessageForEventValue = new DebuggingTag("warningMessageForEventValue", 103, "%s value could not be associated with a suitable data type.", aVar2);
        getDeepLinkData = new DebuggingTag("getDeepLinkData", 104, "Detail: %s", aVar2);
        assurance = new DebuggingTag("assurance", 105, "%s", aVar2);
        setAlarmForTTL = new DebuggingTag("setAlarmForTTL", 106, "Icon will revert back after TTL expires: %d", aVar2);
        changeIcon = new DebuggingTag("changeIcon", 107, "Icon changed from %s to %s", aVar2);
        cleanViewError = new DebuggingTag("cleanViewError", AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, "Activities are not matched, cleaning view will not be possible", aVar2);
        processTemplateStoreURL = new DebuggingTag("processTemplateStoreURL", AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, "%s", aVar2);
        exception = new DebuggingTag(NotificationsService.EXCEPTION_KEY, MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE, "%s", aVar2);
        noActiveServiceProvider = new DebuggingTag("noActiveServiceProvider", 111, "No Active Service Provider found", aVar2);
        login = new DebuggingTag("login", 112, "Login successful", aVar2);
        logout = new DebuggingTag(InsiderHybridMethods.LOGOUT, 113, "Logout successful", aVar2);
        removeInappSilently = new DebuggingTag("removeInappSilently", 114, "Inapp has been removed silently", aVar2);
        setCustomRegularFont = new DebuggingTag("setCustomRegularFont", 115, "%s", aVar2);
        setCustomBoldFont = new DebuggingTag("setCustomBoldFont", 116, "%s", aVar2);
        setCustomItalicFont = new DebuggingTag("setCustomItalicFont", 117, "%s", aVar2);
        enableIpCollection = new DebuggingTag(InsiderHybridMethods.ENABLE_IP_COLLECTION, 118, "%s", aVar2);
        enableLocationCollection = new DebuggingTag(InsiderHybridMethods.ENABLE_LOCATION_COLLECTION, 119, "%s", aVar2);
        enableCarrierCollection = new DebuggingTag(InsiderHybridMethods.ENABLE_CARRIER_COLLECTION, TimeseriesConfiguration.DEFAULT_BUFFER_SIZE, "%s", aVar2);
        getCurrentProvider = new DebuggingTag("getCurrentProvider", 121, "Current provider is: %s", aVar2);
        setUserIdentifierSuccess = new DebuggingTag("setUserIdentifierSuccess", 122, "insiderID: %s", aVar2);
        openLogRequestReceived = new DebuggingTag("openLogRequestReceived", 123, "%s", aVar2);
        insiderIdentifierRequestJSON = new DebuggingTag("insiderIdentifierRequestJSON", 124, "%s", aVar2);
        removeCachedInsiderID = new DebuggingTag("removeCachedInsiderID", GapComposerKt.nodeKey, "Cached InsiderID has been removed.", aVar2);
        showNativeRating = new DebuggingTag("showNativeRating", WebSocketProtocol.PAYLOAD_SHORT, "Native rating has been called.", aVar2);
        showNativeRatingSuccess = new DebuggingTag("showNativeRatingSuccess", 127, "Native rating has been succeed.", aVar2);
        showNativeRatingFlowSuccess = new DebuggingTag("showNativeRatingFlowSuccess", 128, "Native rating flow has been finished.", aVar2);
        showNativeRatingFail = new DebuggingTag("showNativeRatingFail", 129, "Native rating has been failed.", aVar2);
        insiderAmplificationServiceStatus = new DebuggingTag("insiderAmplificationServiceStatus", 130, "Insider amplification service has been set to cache. Status is %s", aVar2);
        insiderAmplificationServiceStarting = new DebuggingTag("insiderAmplificationServiceStarting", WebmConstants.MkvEbmlElement.TRACK_TYPE, "Insider amplification service is starting...", aVar2);
        insiderAmplificationServiceStart = new DebuggingTag("insiderAmplificationServiceStart", 132, "Insider amplification service has been started.", aVar2);
        insiderAmplificationServiceRunning = new DebuggingTag("insiderAmplificationServiceRunning", 133, "Insider amplification service is already running.", aVar2);
        insiderAmplificationServiceFrequencyDiff = new DebuggingTag("insiderAmplificationServiceFrequencyDiff", WebmConstants.MkvEbmlElement.CODEC_ID, "Insider amplification service had been already running but frequency is broken. Job needs to be canceled and recreated.", aVar2);
        insiderAmplificationServiceFail = new DebuggingTag("insiderAmplificationServiceFail", 135, "Insider amplification service has been failed. Job is not scheduled.", aVar2);
        insiderAmplificationServiceRunAndReschedule = new DebuggingTag("insiderAmplificationServiceRunAndReschedule", WebmConstants.MkvEbmlElement.FLAG_DEFAULT, "Insider amplification job has been run and rescheduled.", aVar2);
        insiderAmplificationServiceCancel = new DebuggingTag("insiderAmplificationServiceCancel", 137, "Insider amplification service is has been cancelled.", aVar2);
        insiderAmplificationServiceRemoveJobID = new DebuggingTag("insiderAmplificationServiceRemoveJobID", 138, "Insider amplification job has been removed from cache.", aVar2);
        insiderAmplificationServiceSetJobID = new DebuggingTag("insiderAmplificationServiceSetJobID", 139, "Insider amplification job has been set to cache.", aVar2);
        signUpConfirmation = new DebuggingTag("signUpConfirmation", 140, "User sign up event sent", aVar2);
        insiderLogService = new DebuggingTag("insiderLogService", 141, "%s", aVar2);
        insiderLogServicePutLog = new DebuggingTag("insiderLogServicePutLog", 142, "%s", aVar2);
        inappClickLog = new DebuggingTag("inappClickLog", 143, "%s", aVar2);
        geofencesRemoved = new DebuggingTag("geofencesRemoved", 144, "Removed geofence listener Provider: %s.", aVar2);
        invalidUserEmail = new DebuggingTag("invalidUserEmail", 145, "User email is invalid. Email: %s", aVar2);
        invalidUserPhoneNumber = new DebuggingTag("invalidUserPhoneNumber", 146, "User phone number is invalid. Phone Number: %s.", aVar2);
        universalLinkHasBeenSet = new DebuggingTag("universalLinkHasBeenSet", 147, "Universal link has been set. Universal Link: %s.", aVar2);
        customKeyValuePairHasBeenSetForPushIntent = new DebuggingTag("customKeyValuePairHasBeenSetForPushIntent", 148, "Custom key-value pair has been set for push intent. key: %s value: %s.", aVar2);
        templateLog = new DebuggingTag("templateLog", 149, "%s", aVar2);
        retriedQueuedRequests = new DebuggingTag("retriedQueuedRequests", 150, "Retry Step: %d.", aVar2);
        finishedRetriedRequests = new DebuggingTag("finishedRetriedRequests", 151, "Flushing operation finished for Queued requests.", aVar2);
        requestAddedToQueue = new DebuggingTag("requestAddedToQueue", 152, "Request is added to Queue. Request Type: %s.", aVar2);
        updatedInAppList = new DebuggingTag("updatedInAppList", 153, "App template list updated. %s", aVar2);
        webViewSdk = new DebuggingTag("webViewSdk", WebmConstants.MkvEbmlElement.FLAG_INTERLACED, "WebView SDK: %s", aVar2);
        saveAndRetrieveGdprStatus = new DebuggingTag("saveAndRetrieveGdprStatus", WebmConstants.MkvEbmlElement.BLOCK_DURATION, "GDPR Status from Session Start: %s", aVar2);
        gdprBlockedSessionContinuation = new DebuggingTag("gdprBlockedSessionContinuation", WebmConstants.MkvEbmlElement.FLAG_LACING, "Session could not be continued due to GDPR consent rejection or SDK being disabled. %s", aVar2);
        appCardsGetCampaigns = new DebuggingTag("appCardsGetCampaigns", 157, "Request Detail: %s", aVar2);
        appCardsMarkAsRead = new DebuggingTag("appCardsMarkAsRead", 158, "Request Detail: %s", aVar2);
        appCardsGetCampaignsResponse = new DebuggingTag("appCardsGetCampaignsResponse", WebmConstants.MkvEbmlElement.CHANNELS, "Response received successfully. Detail: %s", aVar2);
        appCardsMarkAsReadResponse = new DebuggingTag("appCardsMarkAsReadResponse", WebmConstants.MkvEbmlElement.BLOCK_GROUP, "Mark as read successfully. Detail: %s", aVar2);
        appCardsMarkAsUnRead = new DebuggingTag("appCardsMarkAsUnRead", WebmConstants.MkvEbmlElement.BLOCK, "Request Detail: %s", aVar2);
        appCardsMarkAsUnReadResponse = new DebuggingTag("appCardsMarkAsUnReadResponse", 162, "Mark as unread successfully. Detail: %s", aVar2);
        appCardsDelete = new DebuggingTag("appCardsDelete", WebmConstants.MkvEbmlElement.SIMPLE_BLOCK, "Request Detail: %s", aVar2);
        appCardsDeleteResponse = new DebuggingTag("appCardsDeleteResponse", 164, "Delete successfully. Detail: %s", aVar2);
        appCardsLog = new DebuggingTag("appCardsLog", WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL, "App Card log saved. Message ID: %s, Log Details: %s", aVar2);
        appCardsRunAction = new DebuggingTag("appCardsRunAction", WebmConstants.MkvEbmlElement.BLOCK_MORE, "App Card action running. Details -> %s", aVar2);
        c = a();
    }

    private DebuggingTag(String str, int i, Object obj, a aVar) {
        super(str, i);
        this.f282a = String.valueOf(obj);
        this.b = aVar;
    }

    private static /* synthetic */ DebuggingTag[] a() {
        return new DebuggingTag[]{tagEvent, tagEventWithParameters, setCustomAttribute, setUserAttribute, setPushOptIn, setLocationOptIn, itemAddedToCart, itemPurchased, itemRemovedFromCart, cartCleared, visitCartPage, createNewProduct, visitProductDetailPage, unsetCustomAttribute, setUserIdentifier, refreshIdentity, unsetUserIdentifier, nativeLocationWarning, pushOptinWarning, setGDPRConsent, setMobileAppAccess, checkMobileAppAccess, setInternalBrowserCloseButtonPosition, itemAddedToWishlist, itemRemovedFromWishlist, wishlistCleared, visitWishlistPage, visitProductDetailPageDetail, visitHomepage, visitListingPage, removeInapp, removeBlockedInapp, disableBlockedInapp, enableInAppMessages, registerInsiderCallback, insiderCallbackNotDefined, insiderCallbackTriggered, startTrackingGeofence, deviceLocation, getSmartRecommendationWithProduct, getSmartRecommendationWithProductID, getSmartRecommendation, getStringWithName, terminatedConnection, getIntWithName, getBoolWithName, getStringWithNameWithoutCache, getIntWithNameWithoutCache, getBoolWithNameWithoutCache, pushReceived, testInAppReceived, init, checkGDPRConsent, initInvalidPartnerName, reinitCalled, reinitSessionStopCompleted, reinitFailedBecauseOfSDKFrozen, reinitFailedBecauseOfSamePartnerName, reinitCompletedWhenGDPRFalse, reinitFailedBecauseFirstInitialization, initializeGeofence, geofenceRequest, buildGeofences, addGeofencesToClient, invalidGeofenceReceived, sessionStartRequest, sessionStartResponseError, sessionStartResponse, sessionStopRequest, flushingData, flushingSuccessfully, flushingFailed, flushingFailedAndAddedToSharedPref, flushingTimerStarted, flushingTimerStopped, flushingRequestNotSent, flushingTimerStoppedDueToZeroInterval, sessionPayloadServiceIsRunning, sessionPayloadServiceIsRunningButNotFoundStoredData, sessionPayloadServiceIsStopped, sessionDataStored, sessionDataCleared, sessionPayloadServiceIsAlreadyRunning, sessionPayloadServiceScheduled, sessionPayloadServiceCanceled, requestEncrypted, sessionStopRequestEncrypted, flushingDataEncrypted, identityRequestEncrypted, messageCenterRequestEncrypted, logSystemRequestEncrypted, getSmartRecommendationRequestURL, getSmartRecommendationWithProductWarning, getSmartRecommendationWithProductIDWarning, getSmartRecommendationWarning, getMessageCenterData, getMessageCenterDataResponse, getPushToken, pushTokenRenewal, addAsNewContentVariable, addContentOptimizerLog, isNameValidEmpty, isNameValid, warningMessageForEventValue, getDeepLinkData, assurance, setAlarmForTTL, changeIcon, cleanViewError, processTemplateStoreURL, exception, noActiveServiceProvider, login, logout, removeInappSilently, setCustomRegularFont, setCustomBoldFont, setCustomItalicFont, enableIpCollection, enableLocationCollection, enableCarrierCollection, getCurrentProvider, setUserIdentifierSuccess, openLogRequestReceived, insiderIdentifierRequestJSON, removeCachedInsiderID, showNativeRating, showNativeRatingSuccess, showNativeRatingFlowSuccess, showNativeRatingFail, insiderAmplificationServiceStatus, insiderAmplificationServiceStarting, insiderAmplificationServiceStart, insiderAmplificationServiceRunning, insiderAmplificationServiceFrequencyDiff, insiderAmplificationServiceFail, insiderAmplificationServiceRunAndReschedule, insiderAmplificationServiceCancel, insiderAmplificationServiceRemoveJobID, insiderAmplificationServiceSetJobID, signUpConfirmation, insiderLogService, insiderLogServicePutLog, inappClickLog, geofencesRemoved, invalidUserEmail, invalidUserPhoneNumber, universalLinkHasBeenSet, customKeyValuePairHasBeenSetForPushIntent, templateLog, retriedQueuedRequests, finishedRetriedRequests, requestAddedToQueue, updatedInAppList, webViewSdk, saveAndRetrieveGdprStatus, gdprBlockedSessionContinuation, appCardsGetCampaigns, appCardsMarkAsRead, appCardsGetCampaignsResponse, appCardsMarkAsReadResponse, appCardsMarkAsUnRead, appCardsMarkAsUnReadResponse, appCardsDelete, appCardsDeleteResponse, appCardsLog, appCardsRunAction};
    }

    public static DebuggingTag valueOf(String str) {
        return (DebuggingTag) Enum.valueOf(DebuggingTag.class, str);
    }

    public static DebuggingTag[] values() {
        return (DebuggingTag[]) c.clone();
    }

    String b() {
        return this.f282a;
    }

    a c() {
        return this.b;
    }
}
