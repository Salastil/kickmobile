package expo.modules.font;

import android.graphics.Typeface;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* JADX INFO: compiled from: FontLoaderModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "buildVariableWeightTypeface", "Landroid/graphics/Typeface;", "fontFamilyName", "source", "Lexpo/modules/font/FontSource;", "expo-font_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FontLoaderModuleKt {
    private static final String TAG = "ExpoFontLoader";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typeface buildVariableWeightTypeface(String str, FontSource fontSource) {
        ByteBuffer forInstancing = fontSource.readForInstancing();
        if (forInstancing == null) {
            return null;
        }
        try {
            return VariableTypefaces.INSTANCE.build(forInstancing);
        } catch (IOException e) {
            Log.w(TAG, "Couldn't build the weights of '" + str + "' from its `wght` axis, so `fontWeight` won't apply to it — it renders at the font's default weight throughout. Load a separate static font file for each weight you need.", e);
            return null;
        } catch (RuntimeException e2) {
            Log.e(TAG, "expo-font couldn't build the weights of '" + str + "' because of an internal error, so `fontWeight` won't apply to it. Please report this at https://github.com/expo/expo/issues.", e2);
            return null;
        }
    }
}
