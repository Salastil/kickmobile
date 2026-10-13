package cl.json.social;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.camera.video.VideoSpec;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import cl.json.ShareFile;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes5.dex */
public class InstagramShare extends SingleShareIntent {
    private static final String PACKAGE = "com.instagram.android";
    private static final String PLAY_STORE_LINK = "https://play.google.com/store/apps/details?id=com.instagram.android";

    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public InstagramShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        if (!ShareIntent.hasValidKey("type", readableMap)) {
            Log.e("RNShare", "No type provided");
            return;
        }
        String string = readableMap.getString("type");
        if (string.startsWith("text")) {
            openInstagramIntentChooserForText(this.chooserTitle);
            return;
        }
        if (!ShareIntent.hasValidKey(ImagesContract.URL, readableMap)) {
            Log.e("RNShare", "No url provided");
            return;
        }
        String string2 = readableMap.getString(ImagesContract.URL);
        boolean zStartsWith = string2.startsWith("instagram://");
        Boolean.valueOf(zStartsWith).getClass();
        if (zStartsWith) {
            openInstagramUrlScheme(string2);
            return;
        }
        String extension = getExtension(string);
        openInstagramIntentChooserForMedia(string2, this.chooserTitle, Boolean.valueOf(string.startsWith("image")), extension);
    }

    protected void openInstagramUrlScheme(String str) {
        Uri uri = Uri.parse(str);
        getIntent().setAction("android.intent.action.VIEW");
        getIntent().setData(uri);
        super.openIntentChooser();
    }

    private String getExtension(String str) {
        String[] strArrSplit = str.split(DomExceptionUtils.SEPARATOR);
        return strArrSplit[strArrSplit.length - 1];
    }

    protected void openInstagramIntentChooserForText(String str) {
        getIntent().setPackage(PACKAGE);
        getIntent().setType("text/plain");
        getIntent().setAction("android.intent.action.SEND");
        super.openIntentChooser();
    }

    protected void openInstagramIntentChooserForMedia(String str, String str2, Boolean bool, String str3) {
        ShareFile shareFile;
        Boolean boolValueOf = Boolean.valueOf(ShareIntent.hasValidKey("useInternalStorage", this.options) && this.options.getBoolean("useInternalStorage"));
        if (bool.booleanValue()) {
            shareFile = new ShareFile(str, "image/" + str3, "image", boolValueOf, this.reactContext);
        } else {
            shareFile = new ShareFile(str, "video/" + str3, "video", boolValueOf, this.reactContext);
        }
        Uri uri = shareFile.getURI();
        Intent intent = new Intent("android.intent.action.SEND");
        if (bool.booleanValue()) {
            intent.setType("image/*");
        } else {
            intent.setType(VideoSpec.MIME_TYPE_UNSPECIFIED);
        }
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setPackage(PACKAGE);
        Intent intent2 = new Intent("com.instagram.share.ADD_TO_STORY");
        intent2.setDataAndType(uri, str3);
        intent2.addFlags(1);
        intent2.setPackage(PACKAGE);
        Intent intentCreateChooser = Intent.createChooser(intent, str2);
        intentCreateChooser.addFlags(268435456);
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{intent2});
        this.reactContext.getCurrentActivity().grantUriPermission(PACKAGE, uri, 1);
        this.reactContext.startActivity(intentCreateChooser);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean(FirebaseAnalytics.Param.SUCCESS, true);
        writableMapCreateMap.putString("message", getIntent().getPackage());
        TargetChosenReceiver.callbackResolve(writableMapCreateMap);
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return PACKAGE;
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }
}
