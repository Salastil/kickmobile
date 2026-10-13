package cl.json.social;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import androidx.camera.video.VideoSpec;
import androidx.media3.common.MimeTypes;
import cl.json.ShareFile;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;

/* JADX INFO: loaded from: classes5.dex */
public class InstagramStoriesShare extends SingleShareIntent {
    private static final String PACKAGE = "com.instagram.android";
    private static final String PLAY_STORE_LINK = "https://play.google.com/store/apps/details?id=com.instagram.android";

    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public InstagramStoriesShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        setIntent(new Intent("com.instagram.share.ADD_TO_STORY"));
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        shareStory(readableMap);
        openIntentChooser(readableMap);
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return PACKAGE;
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }

    private void shareStory(ReadableMap readableMap) {
        String string;
        if (!hasValidKey(ViewProps.BACKGROUND_IMAGE, readableMap) && !hasValidKey("backgroundVideo", readableMap) && !hasValidKey("stickerImage", readableMap)) {
            throw new IllegalArgumentException("Invalid background or sticker assets provided.");
        }
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            TargetChosenReceiver.callbackReject("Something went wrong");
            return;
        }
        this.intent.putExtra("source_application", readableMap.getString("appId"));
        this.intent.putExtra("bottom_background_color", "#906df4");
        this.intent.putExtra("top_background_color", "#837DF4");
        if (hasValidKey("attributionURL", readableMap)) {
            this.intent.putExtra("content_url", readableMap.getString("attributionURL"));
        }
        if (hasValidKey("backgroundTopColor", readableMap)) {
            this.intent.putExtra("top_background_color", readableMap.getString("backgroundTopColor"));
        }
        if (hasValidKey("backgroundBottomColor", readableMap)) {
            this.intent.putExtra("bottom_background_color", readableMap.getString("backgroundBottomColor"));
        }
        boolean zValueOf = false;
        if (hasValidKey("useInternalStorage", readableMap)) {
            zValueOf = Boolean.valueOf(readableMap.getBoolean("useInternalStorage"));
        }
        Boolean bool = zValueOf;
        if (hasValidKey("linkUrl", readableMap)) {
            this.intent.putExtra("link_url", readableMap.getString("linkUrl"));
        }
        if (hasValidKey("linkText", readableMap)) {
            this.intent.putExtra("link_text", readableMap.getString("linkText"));
        }
        boolean z = hasValidKey(ViewProps.BACKGROUND_IMAGE, readableMap) || hasValidKey("backgroundVideo", readableMap);
        Boolean boolValueOf = Boolean.valueOf(z);
        boolValueOf.getClass();
        if (z) {
            boolean zHasValidKey = hasValidKey(ViewProps.BACKGROUND_IMAGE, readableMap);
            String str = MimeTypes.IMAGE_JPEG;
            if (zHasValidKey) {
                string = readableMap.getString(ViewProps.BACKGROUND_IMAGE);
            } else if (!hasValidKey("backgroundVideo", readableMap)) {
                string = "";
            } else {
                string = readableMap.getString("backgroundVideo");
                str = VideoSpec.MIME_TYPE_UNSPECIFIED;
            }
            ShareFile shareFile = new ShareFile(string, str, "background", bool, this.reactContext);
            this.intent.setDataAndType(shareFile.getURI(), shareFile.getType());
            this.intent.setFlags(1);
        }
        if (hasValidKey("stickerImage", readableMap)) {
            ShareFile shareFile2 = new ShareFile(readableMap.getString("stickerImage"), MimeTypes.IMAGE_PNG, "sticker", bool, this.reactContext);
            boolValueOf.getClass();
            if (!z) {
                this.intent.setType("image/*");
            }
            this.intent.putExtra("interactive_asset_uri", shareFile2.getURI());
            currentActivity.grantUriPermission(PACKAGE, shareFile2.getURI(), 1);
        }
    }
}
