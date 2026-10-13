package expo.modules.imagepicker;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.canhub.cropper.CropImage;
import com.canhub.cropper.CropImageOptions;
import com.canhub.cropper.CropImageView;
import com.canhub.cropper.databinding.CropImageActivityBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ExpoCropImageActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\f\u0010\u001f\u001a\u00020\u0011*\u00020 H\u0002J\b\u0010!\u001a\u00020\u0011H\u0002J\f\u0010\"\u001a\u00020\u0011*\u00020 H\u0002J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\b\u0010&\u001a\u00020\u0011H\u0014J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\f\u0010+\u001a\u00020\u0011*\u00020*H\u0002J\f\u0010,\u001a\u00020\u0011*\u00020*H\u0002J\u0010\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u000200H\u0016J(\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\t2\u000e\u00104\u001a\n\u0018\u000105j\u0004\u0018\u0001`6H\u0016J\u0018\u00107\u001a\u00020\u00112\u0006\u00102\u001a\u00020\r2\u0006\u00108\u001a\u000209H\u0016J \u0010:\u001a\u00020\u0011*\u00020*2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00110<H\u0002J\u0014\u0010=\u001a\u00020\u0011*\u0002002\u0006\u0010>\u001a\u00020\u0007H\u0002J\u0014\u0010?\u001a\u00020\u0011*\u0002002\u0006\u0010>\u001a\u00020\u0007H\u0002J\u0014\u0010@\u001a\u00020\u0011*\u0002002\u0006\u0010>\u001a\u00020\u0007H\u0002J\b\u0010A\u001a\u00020\u0011H\u0002J\b\u0010B\u001a\u00020\u0011H\u0002J\b\u0010C\u001a\u00020\u0011H\u0002J\b\u0010D\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lexpo/modules/imagepicker/ExpoCropImageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/canhub/cropper/CropImageView$OnSetImageUriCompleteListener;", "Lcom/canhub/cropper/CropImageView$OnCropImageCompleteListener;", "<init>", "()V", "currentIconColor", "", "cropImageUri", "Landroid/net/Uri;", "cropImageOptions", "Lcom/canhub/cropper/CropImageOptions;", "cropImageView", "Lcom/canhub/cropper/CropImageView;", "binding", "Lcom/canhub/cropper/databinding/CropImageActivityBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "readCropImageOptions", "resolveCustomizationColors", "Lexpo/modules/imagepicker/ExpoCropImageActivity$CustomizationColors;", "applyCustomizationToOptions", "options", "colors", "setupContentView", "setCropImageView", "applyWindowCustomization", "applyActivityBackground", "applyToolbarCustomization", "applyToolbarColor", "Landroidx/appcompat/app/ActionBar;", "applyToolbarTitleColor", "applyToolbarBackButtonColor", "setupBackHandling", "onStart", "onStop", "onDestroy", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "setCropIcon", "setItemsVisibility", "onPrepareOptionsMenu", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSetImageUriComplete", "view", "uri", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onCropImageComplete", "result", "Lcom/canhub/cropper/CropImageView$CropResult;", "forEachItem", "action", "Lkotlin/Function1;", "updateTextColor", "color", "setIconTintColor", "updateIconColor", "cropImage", "setResultCancel", "setResultError", "setResultOK", "CustomizationColors", "expo-image-picker_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpoCropImageActivity extends AppCompatActivity implements CropImageView.OnSetImageUriCompleteListener, CropImageView.OnCropImageCompleteListener {
    private CropImageActivityBinding binding;
    private CropImageOptions cropImageOptions;
    private Uri cropImageUri;
    private CropImageView cropImageView;
    private int currentIconColor = -16777216;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        CropImageView cropImageView;
        super.onCreate(savedInstanceState);
        readCropImageOptions();
        CustomizationColors customizationColorsResolveCustomizationColors = resolveCustomizationColors();
        CropImageOptions cropImageOptions = this.cropImageOptions;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        applyCustomizationToOptions(cropImageOptions, customizationColorsResolveCustomizationColors);
        setupContentView();
        applyWindowCustomization(customizationColorsResolveCustomizationColors);
        if (savedInstanceState == null && (cropImageView = this.cropImageView) != null) {
            cropImageView.setImageUriAsync(this.cropImageUri);
        }
        applyActivityBackground();
        applyToolbarCustomization();
        setupBackHandling();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    private final void readCropImageOptions() {
        Uri uri;
        CropImageOptions cropImageOptions;
        Bundle bundleExtra = getIntent().getBundleExtra(CropImage.CROP_IMAGE_EXTRA_BUNDLE);
        if (bundleExtra != null) {
            Parcelable parcelable = bundleExtra.getParcelable(CropImage.CROP_IMAGE_EXTRA_SOURCE);
            if (!(parcelable instanceof Uri)) {
                parcelable = null;
            }
            uri = (Uri) parcelable;
        } else {
            uri = null;
        }
        this.cropImageUri = uri;
        if (uri == null) {
            throw new IllegalArgumentException("Crop image source URI is required but was not provided.".toString());
        }
        if (bundleExtra == null) {
            cropImageOptions = new CropImageOptions(false, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1, -1, 63, null);
        } else {
            Parcelable parcelable2 = bundleExtra.getParcelable(CropImage.CROP_IMAGE_EXTRA_OPTIONS);
            cropImageOptions = (CropImageOptions) (parcelable2 instanceof CropImageOptions ? parcelable2 : null);
            if (cropImageOptions == null) {
                cropImageOptions = new CropImageOptions(false, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1, -1, 63, null);
            }
        }
        this.cropImageOptions = cropImageOptions;
    }

    private final CustomizationColors resolveCustomizationColors() {
        boolean z = (getResources().getConfiguration().uiMode & 48) == 32;
        int iIntValue = z ? -16777216 : -1;
        int iIntValue2 = z ? -1 : -16777216;
        ExpoCropImageUtils expoCropImageUtils = ExpoCropImageUtils.INSTANCE;
        Resources.Theme theme = getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "getTheme(...)");
        Integer themeColor = expoCropImageUtils.getThemeColor(theme, R.attr.expoCropBackButtonIconColor);
        if (themeColor == null) {
            ExpoCropImageUtils expoCropImageUtils2 = ExpoCropImageUtils.INSTANCE;
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            themeColor = expoCropImageUtils2.getColorResource(resources, R.color.expoCropBackButtonIconColor);
        }
        ExpoCropImageUtils expoCropImageUtils3 = ExpoCropImageUtils.INSTANCE;
        Resources.Theme theme2 = getTheme();
        Intrinsics.checkNotNullExpressionValue(theme2, "getTheme(...)");
        Integer themeColor2 = expoCropImageUtils3.getThemeColor(theme2, R.attr.expoCropBackgroundColor);
        if (themeColor2 == null) {
            ExpoCropImageUtils expoCropImageUtils4 = ExpoCropImageUtils.INSTANCE;
            Resources resources2 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
            themeColor2 = expoCropImageUtils4.getColorResource(resources2, R.color.expoCropBackgroundColor);
        }
        ExpoCropImageUtils expoCropImageUtils5 = ExpoCropImageUtils.INSTANCE;
        Resources.Theme theme3 = getTheme();
        Intrinsics.checkNotNullExpressionValue(theme3, "getTheme(...)");
        Integer themeColor3 = expoCropImageUtils5.getThemeColor(theme3, R.attr.expoCropToolbarActionTextColor);
        if (themeColor3 == null) {
            ExpoCropImageUtils expoCropImageUtils6 = ExpoCropImageUtils.INSTANCE;
            Resources resources3 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources3, "getResources(...)");
            themeColor3 = expoCropImageUtils6.getColorResource(resources3, R.color.expoCropToolbarActionTextColor);
        }
        ExpoCropImageUtils expoCropImageUtils7 = ExpoCropImageUtils.INSTANCE;
        Resources.Theme theme4 = getTheme();
        Intrinsics.checkNotNullExpressionValue(theme4, "getTheme(...)");
        Integer themeColor4 = expoCropImageUtils7.getThemeColor(theme4, R.attr.expoCropToolbarColor);
        if (themeColor4 == null) {
            ExpoCropImageUtils expoCropImageUtils8 = ExpoCropImageUtils.INSTANCE;
            Resources resources4 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources4, "getResources(...)");
            themeColor4 = expoCropImageUtils8.getColorResource(resources4, R.color.expoCropToolbarColor);
        }
        ExpoCropImageUtils expoCropImageUtils9 = ExpoCropImageUtils.INSTANCE;
        Resources.Theme theme5 = getTheme();
        Intrinsics.checkNotNullExpressionValue(theme5, "getTheme(...)");
        Integer themeColor5 = expoCropImageUtils9.getThemeColor(theme5, R.attr.expoCropToolbarIconColor);
        if (themeColor5 == null) {
            ExpoCropImageUtils expoCropImageUtils10 = ExpoCropImageUtils.INSTANCE;
            Resources resources5 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources5, "getResources(...)");
            themeColor5 = expoCropImageUtils10.getColorResource(resources5, R.color.expoCropToolbarIconColor);
        }
        int iIntValue3 = themeColor2 != null ? themeColor2.intValue() : iIntValue;
        if (themeColor4 != null) {
            iIntValue = themeColor4.intValue();
        }
        int i = iIntValue;
        int iIntValue4 = themeColor5 != null ? themeColor5.intValue() : iIntValue2;
        Integer num = themeColor;
        if (themeColor3 != null) {
            iIntValue2 = themeColor3.intValue();
        }
        return new CustomizationColors(z, iIntValue3, i, iIntValue4, iIntValue2, num != null ? num.intValue() : iIntValue4);
    }

    private final void applyCustomizationToOptions(CropImageOptions options, CustomizationColors colors) {
        this.currentIconColor = colors.getToolbarIconColor();
        options.activityBackgroundColor = colors.getActivityBackgroundColor();
        options.activityMenuIconColor = colors.getToolbarIconColor();
        options.activityMenuTextColor = Integer.valueOf(colors.getToolbarActionTextColor());
        options.toolbarBackButtonColor = Integer.valueOf(colors.getBackButtonIconColor());
        options.toolbarColor = Integer.valueOf(colors.getToolbarColor());
        options.toolbarTitleColor = Integer.valueOf(colors.getToolbarIconColor());
    }

    private final void setupContentView() {
        CropImageActivityBinding cropImageActivityBindingInflate = CropImageActivityBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(cropImageActivityBindingInflate, "inflate(...)");
        this.binding = cropImageActivityBindingInflate;
        CropImageActivityBinding cropImageActivityBinding = null;
        if (cropImageActivityBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cropImageActivityBindingInflate = null;
        }
        setContentView(cropImageActivityBindingInflate.getRoot());
        CropImageActivityBinding cropImageActivityBinding2 = this.binding;
        if (cropImageActivityBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cropImageActivityBinding = cropImageActivityBinding2;
        }
        CropImageView cropImageView = cropImageActivityBinding.cropImageView;
        Intrinsics.checkNotNullExpressionValue(cropImageView, "cropImageView");
        setCropImageView(cropImageView);
    }

    private final void setCropImageView(CropImageView cropImageView) {
        this.cropImageView = cropImageView;
        ViewCompat.setOnApplyWindowInsetsListener(cropImageView, new OnApplyWindowInsetsListener() { // from class: expo.modules.imagepicker.ExpoCropImageActivity$$ExternalSyntheticLambda7
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return ExpoCropImageActivity.setCropImageView$lambda$3(view, windowInsetsCompat);
            }
        });
    }

    static final WindowInsetsCompat setCropImageView$lambda$3(View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(insets2.left, insets2.top, insets2.right, insets2.bottom);
            view.setLayoutParams(marginLayoutParams);
            return insets;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void applyWindowCustomization(CustomizationColors colors) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setElevation(0.0f);
        }
        Window window = getWindow();
        final View view = new View(window.getContext());
        view.setBackgroundColor(colors.getToolbarColor());
        WindowCompat.enableEdgeToEdge(window);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        windowInsetsControllerCompat.setAppearanceLightStatusBars(!colors.isNight());
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(!colors.isNight());
        window.getDecorView().setBackgroundColor(colors.getActivityBackgroundColor());
        window.addContentView(view, new ViewGroup.LayoutParams(-1, 0));
        ViewCompat.setOnApplyWindowInsetsListener(window.getDecorView(), new OnApplyWindowInsetsListener() { // from class: expo.modules.imagepicker.ExpoCropImageActivity$$ExternalSyntheticLambda6
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return ExpoCropImageActivity.applyWindowCustomization$lambda$8$lambda$7(view, view2, windowInsetsCompat);
            }
        });
    }

    static final WindowInsetsCompat applyWindowCustomization$lambda$8$lambda$7(View view, View view2, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view2, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = insets2.top;
            view.setLayoutParams(layoutParams);
            return insets;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void applyActivityBackground() {
        CropImageOptions cropImageOptions = this.cropImageOptions;
        CropImageActivityBinding cropImageActivityBinding = null;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        int i = cropImageOptions.activityBackgroundColor;
        CropImageActivityBinding cropImageActivityBinding2 = this.binding;
        if (cropImageActivityBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cropImageActivityBinding = cropImageActivityBinding2;
        }
        cropImageActivityBinding.getRoot().setBackgroundColor(i);
    }

    private final void applyToolbarCustomization() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        CropImageOptions cropImageOptions = this.cropImageOptions;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        CharSequence charSequence = cropImageOptions.activityTitle;
        if (charSequence.length() == 0) {
        }
        setTitle(charSequence);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        applyToolbarColor(supportActionBar);
        applyToolbarTitleColor();
        applyToolbarBackButtonColor(supportActionBar);
    }

    private final void applyToolbarColor(ActionBar actionBar) {
        CropImageOptions cropImageOptions = this.cropImageOptions;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        Integer num = cropImageOptions.toolbarColor;
        actionBar.setBackgroundDrawable(num != null ? new ColorDrawable(num.intValue()) : null);
    }

    private final void applyToolbarTitleColor() {
        CropImageOptions cropImageOptions = this.cropImageOptions;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        Integer num = cropImageOptions.toolbarTitleColor;
        if (num != null) {
            int iIntValue = num.intValue();
            SpannableString spannableString = new SpannableString(getTitle());
            spannableString.setSpan(new ForegroundColorSpan(iIntValue), 0, spannableString.length(), 33);
            setTitle(spannableString);
        }
    }

    private final void applyToolbarBackButtonColor(ActionBar actionBar) {
        CropImageOptions cropImageOptions = this.cropImageOptions;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        Integer num = cropImageOptions.toolbarBackButtonColor;
        if (num != null) {
            int iIntValue = num.intValue();
            try {
                Drawable drawable = ContextCompat.getDrawable(this, com.canhub.cropper.R.drawable.ic_arrow_back_24);
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(iIntValue, PorterDuff.Mode.SRC_ATOP));
                }
                actionBar.setHomeAsUpIndicator(drawable);
            } catch (Exception e) {
                Log.w("ExpoCropImage", "Failed to set back button color", e);
            }
        }
    }

    private final void setupBackHandling() {
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), null, false, new Function1() { // from class: expo.modules.imagepicker.ExpoCropImageActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExpoCropImageActivity.setupBackHandling$lambda$11(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 3, null);
    }

    static final Unit setupBackHandling$lambda$11(ExpoCropImageActivity expoCropImageActivity, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        expoCropImageActivity.setResultCancel();
        return Unit.INSTANCE;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            cropImageView.setOnSetImageUriCompleteListener(this);
        }
        CropImageView cropImageView2 = this.cropImageView;
        if (cropImageView2 != null) {
            cropImageView2.setOnCropImageCompleteListener(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            cropImageView.setOnSetImageUriCompleteListener(null);
        }
        CropImageView cropImageView2 = this.cropImageView;
        if (cropImageView2 != null) {
            cropImageView2.setOnCropImageCompleteListener(null);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), null);
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(cropImageView, null);
        }
        this.cropImageView = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        CropImageOptions cropImageOptions = this.cropImageOptions;
        CropImageOptions cropImageOptions2 = null;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        if (cropImageOptions.skipEditing) {
            return true;
        }
        getMenuInflater().inflate(com.canhub.cropper.R.menu.crop_image_menu, menu);
        setItemsVisibility(menu);
        setCropIcon(menu);
        CropImageOptions cropImageOptions3 = this.cropImageOptions;
        if (cropImageOptions3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions3 = null;
        }
        if (cropImageOptions3.activityMenuIconColor != 0) {
            forEachItem(menu, new Function1() { // from class: expo.modules.imagepicker.ExpoCropImageActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ExpoCropImageActivity.onCreateOptionsMenu$lambda$13(this.f$0, (MenuItem) obj);
                }
            });
        }
        CropImageOptions cropImageOptions4 = this.cropImageOptions;
        if (cropImageOptions4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
        } else {
            cropImageOptions2 = cropImageOptions4;
        }
        Integer num = cropImageOptions2.activityMenuTextColor;
        if (num != null) {
            final int iIntValue = num.intValue();
            forEachItem(menu, new Function1() { // from class: expo.modules.imagepicker.ExpoCropImageActivity$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ExpoCropImageActivity.onCreateOptionsMenu$lambda$15$lambda$14(this.f$0, iIntValue, (MenuItem) obj);
                }
            });
        }
        forEachItem(menu, new Function1() { // from class: expo.modules.imagepicker.ExpoCropImageActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExpoCropImageActivity.onCreateOptionsMenu$lambda$16(this.f$0, (MenuItem) obj);
            }
        });
        return true;
    }

    static final Unit onCreateOptionsMenu$lambda$13(ExpoCropImageActivity expoCropImageActivity, MenuItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        CropImageOptions cropImageOptions = expoCropImageActivity.cropImageOptions;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        expoCropImageActivity.updateIconColor(it, cropImageOptions.activityMenuIconColor);
        return Unit.INSTANCE;
    }

    static final Unit onCreateOptionsMenu$lambda$15$lambda$14(ExpoCropImageActivity expoCropImageActivity, int i, MenuItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        expoCropImageActivity.updateTextColor(it, i);
        return Unit.INSTANCE;
    }

    static final Unit onCreateOptionsMenu$lambda$16(ExpoCropImageActivity expoCropImageActivity, MenuItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        expoCropImageActivity.setIconTintColor(it, expoCropImageActivity.currentIconColor);
        return Unit.INSTANCE;
    }

    private final void setCropIcon(Menu menu) {
        try {
            CropImageOptions cropImageOptions = this.cropImageOptions;
            CropImageOptions cropImageOptions2 = null;
            if (cropImageOptions == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions = null;
            }
            if (cropImageOptions.cropMenuCropButtonIcon != 0) {
                ExpoCropImageActivity expoCropImageActivity = this;
                CropImageOptions cropImageOptions3 = this.cropImageOptions;
                if (cropImageOptions3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                } else {
                    cropImageOptions2 = cropImageOptions3;
                }
                menu.findItem(com.canhub.cropper.R.id.crop_image_menu_crop).setIcon(ContextCompat.getDrawable(expoCropImageActivity, cropImageOptions2.cropMenuCropButtonIcon));
            }
        } catch (Exception e) {
            Log.w("ExpoCropImage", "Failed to read menu crop drawable", e);
        }
    }

    private final void setItemsVisibility(Menu menu) {
        CropImageOptions cropImageOptions = this.cropImageOptions;
        CropImageOptions cropImageOptions2 = null;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        if (!cropImageOptions.allowRotation) {
            menu.removeItem(com.canhub.cropper.R.id.ic_rotate_left_24);
            menu.removeItem(com.canhub.cropper.R.id.ic_rotate_right_24);
        } else {
            CropImageOptions cropImageOptions3 = this.cropImageOptions;
            if (cropImageOptions3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions3 = null;
            }
            if (cropImageOptions3.allowCounterRotation) {
                menu.findItem(com.canhub.cropper.R.id.ic_rotate_left_24).setVisible(true);
            }
        }
        CropImageOptions cropImageOptions4 = this.cropImageOptions;
        if (cropImageOptions4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions4 = null;
        }
        if (!cropImageOptions4.allowFlipping) {
            menu.removeItem(com.canhub.cropper.R.id.ic_flip_24);
        }
        CropImageOptions cropImageOptions5 = this.cropImageOptions;
        if (cropImageOptions5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions5 = null;
        }
        if (cropImageOptions5.cropMenuCropButtonTitle != null) {
            MenuItem menuItemFindItem = menu.findItem(com.canhub.cropper.R.id.crop_image_menu_crop);
            CropImageOptions cropImageOptions6 = this.cropImageOptions;
            if (cropImageOptions6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions2 = cropImageOptions6;
            }
            menuItemFindItem.setTitle(cropImageOptions2.cropMenuCropButtonTitle);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        boolean zOnPrepareOptionsMenu = super.onPrepareOptionsMenu(menu);
        forEachItem(menu, new Function1() { // from class: expo.modules.imagepicker.ExpoCropImageActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExpoCropImageActivity.onPrepareOptionsMenu$lambda$17(this.f$0, (MenuItem) obj);
            }
        });
        return zOnPrepareOptionsMenu;
    }

    static final Unit onPrepareOptionsMenu$lambda$17(ExpoCropImageActivity expoCropImageActivity, MenuItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        expoCropImageActivity.setIconTintColor(it, expoCropImageActivity.currentIconColor);
        return Unit.INSTANCE;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == com.canhub.cropper.R.id.crop_image_menu_crop) {
            cropImage();
            return true;
        }
        CropImageOptions cropImageOptions = null;
        if (itemId == com.canhub.cropper.R.id.ic_rotate_left_24) {
            CropImageView cropImageView = this.cropImageView;
            if (cropImageView == null) {
                return true;
            }
            CropImageOptions cropImageOptions2 = this.cropImageOptions;
            if (cropImageOptions2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions = cropImageOptions2;
            }
            cropImageView.rotateImage(-cropImageOptions.rotationDegrees);
            return true;
        }
        if (itemId == com.canhub.cropper.R.id.ic_rotate_right_24) {
            CropImageView cropImageView2 = this.cropImageView;
            if (cropImageView2 == null) {
                return true;
            }
            CropImageOptions cropImageOptions3 = this.cropImageOptions;
            if (cropImageOptions3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions = cropImageOptions3;
            }
            cropImageView2.rotateImage(cropImageOptions.rotationDegrees);
            return true;
        }
        if (itemId == com.canhub.cropper.R.id.ic_flip_24_horizontally) {
            CropImageView cropImageView3 = this.cropImageView;
            if (cropImageView3 == null) {
                return true;
            }
            cropImageView3.flipImageHorizontally();
            return true;
        }
        if (itemId != com.canhub.cropper.R.id.ic_flip_24_vertically) {
            if (itemId == 16908332) {
                setResultCancel();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
        CropImageView cropImageView4 = this.cropImageView;
        if (cropImageView4 == null) {
            return true;
        }
        cropImageView4.flipImageVertically();
        return true;
    }

    @Override // com.canhub.cropper.CropImageView.OnSetImageUriCompleteListener
    public void onSetImageUriComplete(CropImageView view, Uri uri, Exception error) {
        CropImageView cropImageView;
        CropImageView cropImageView2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (error != null) {
            setResultError();
            return;
        }
        CropImageOptions cropImageOptions = this.cropImageOptions;
        CropImageOptions cropImageOptions2 = null;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        if (cropImageOptions.initialCropWindowRectangle != null && (cropImageView2 = this.cropImageView) != null) {
            CropImageOptions cropImageOptions3 = this.cropImageOptions;
            if (cropImageOptions3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions3 = null;
            }
            cropImageView2.setCropRect(cropImageOptions3.initialCropWindowRectangle);
        }
        CropImageOptions cropImageOptions4 = this.cropImageOptions;
        if (cropImageOptions4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions4 = null;
        }
        if (cropImageOptions4.initialRotation > 0 && (cropImageView = this.cropImageView) != null) {
            CropImageOptions cropImageOptions5 = this.cropImageOptions;
            if (cropImageOptions5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions5 = null;
            }
            cropImageView.setRotatedDegrees(cropImageOptions5.initialRotation);
        }
        CropImageOptions cropImageOptions6 = this.cropImageOptions;
        if (cropImageOptions6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
        } else {
            cropImageOptions2 = cropImageOptions6;
        }
        if (cropImageOptions2.skipEditing) {
            cropImage();
        }
    }

    @Override // com.canhub.cropper.CropImageView.OnCropImageCompleteListener
    public void onCropImageComplete(CropImageView view, CropImageView.CropResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getError() != null) {
            setResultError();
        } else {
            setResultOK();
        }
    }

    private final void updateTextColor(MenuItem menuItem, int i) {
        CharSequence title = menuItem.getTitle();
        if (title == null || StringsKt.isBlank(title)) {
            Log.w("ExpoCropImage", "Menu item title is null or blank, cannot update text color");
            return;
        }
        try {
            String string = title.toString();
            SpannableString spannableString = new SpannableString(title);
            spannableString.setSpan(new ForegroundColorSpan(i), 0, spannableString.length(), 33);
            if (Build.VERSION.SDK_INT >= 33) {
                menuItem.setTooltipText(string);
                menuItem.setContentDescription(string);
            }
            menuItem.setTitle(spannableString);
        } catch (Exception e) {
            Log.w("ExpoCropImage", "Failed to update menu item color", e);
        }
    }

    private final void setIconTintColor(MenuItem menuItem, int i) {
        Drawable drawableMutate;
        Drawable icon = menuItem.getIcon();
        if (icon == null || (drawableMutate = icon.mutate()) == null) {
            return;
        }
        drawableMutate.setTint(i);
    }

    private final void updateIconColor(MenuItem menuItem, int i) {
        Drawable drawableMutate;
        Drawable icon = menuItem.getIcon();
        if (icon == null || (drawableMutate = icon.mutate()) == null) {
            return;
        }
        try {
            drawableMutate.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(i, BlendModeCompat.SRC_ATOP));
            menuItem.setIcon(drawableMutate);
        } catch (Exception e) {
            Log.w("ExpoCropImage", "Failed to update menu item icon color", e);
        }
    }

    private final void cropImage() {
        CropImageOptions cropImageOptions = this.cropImageOptions;
        CropImageOptions cropImageOptions2 = null;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        if (cropImageOptions.noOutputImage) {
            setResultOK();
            return;
        }
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            CropImageOptions cropImageOptions3 = this.cropImageOptions;
            if (cropImageOptions3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions3 = null;
            }
            Bitmap.CompressFormat compressFormat = cropImageOptions3.outputCompressFormat;
            CropImageOptions cropImageOptions4 = this.cropImageOptions;
            if (cropImageOptions4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions4 = null;
            }
            int i = cropImageOptions4.outputCompressQuality;
            CropImageOptions cropImageOptions5 = this.cropImageOptions;
            if (cropImageOptions5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions5 = null;
            }
            int i2 = cropImageOptions5.outputRequestWidth;
            CropImageOptions cropImageOptions6 = this.cropImageOptions;
            if (cropImageOptions6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions6 = null;
            }
            int i3 = cropImageOptions6.outputRequestHeight;
            CropImageOptions cropImageOptions7 = this.cropImageOptions;
            if (cropImageOptions7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions7 = null;
            }
            CropImageView.RequestSizeOptions requestSizeOptions = cropImageOptions7.outputRequestSizeOptions;
            CropImageOptions cropImageOptions8 = this.cropImageOptions;
            if (cropImageOptions8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions2 = cropImageOptions8;
            }
            cropImageView.croppedImageAsync(compressFormat, i, i2, i3, requestSizeOptions, cropImageOptions2.customOutputUri);
        }
    }

    private final void setResultCancel() {
        setResult(0);
        finish();
    }

    private final void setResultError() {
        setResult(204);
        finish();
    }

    private final void setResultOK() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: compiled from: ExpoCropImageActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Lexpo/modules/imagepicker/ExpoCropImageActivity$CustomizationColors;", "", "isNight", "", "activityBackgroundColor", "", "toolbarColor", "toolbarIconColor", "toolbarActionTextColor", "backButtonIconColor", "<init>", "(ZIIIII)V", "()Z", "getActivityBackgroundColor", "()I", "getToolbarColor", "getToolbarIconColor", "getToolbarActionTextColor", "getBackButtonIconColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "expo-image-picker_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class CustomizationColors {
        private final int activityBackgroundColor;
        private final int backButtonIconColor;
        private final boolean isNight;
        private final int toolbarActionTextColor;
        private final int toolbarColor;
        private final int toolbarIconColor;

        public static /* synthetic */ CustomizationColors copy$default(CustomizationColors customizationColors, boolean z, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                z = customizationColors.isNight;
            }
            if ((i6 & 2) != 0) {
                i = customizationColors.activityBackgroundColor;
            }
            if ((i6 & 4) != 0) {
                i2 = customizationColors.toolbarColor;
            }
            if ((i6 & 8) != 0) {
                i3 = customizationColors.toolbarIconColor;
            }
            if ((i6 & 16) != 0) {
                i4 = customizationColors.toolbarActionTextColor;
            }
            if ((i6 & 32) != 0) {
                i5 = customizationColors.backButtonIconColor;
            }
            int i7 = i4;
            int i8 = i5;
            return customizationColors.copy(z, i, i2, i3, i7, i8);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsNight() {
            return this.isNight;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getActivityBackgroundColor() {
            return this.activityBackgroundColor;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getToolbarColor() {
            return this.toolbarColor;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getToolbarIconColor() {
            return this.toolbarIconColor;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getToolbarActionTextColor() {
            return this.toolbarActionTextColor;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getBackButtonIconColor() {
            return this.backButtonIconColor;
        }

        public final CustomizationColors copy(boolean isNight, int activityBackgroundColor, int toolbarColor, int toolbarIconColor, int toolbarActionTextColor, int backButtonIconColor) {
            return new CustomizationColors(isNight, activityBackgroundColor, toolbarColor, toolbarIconColor, toolbarActionTextColor, backButtonIconColor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomizationColors)) {
                return false;
            }
            CustomizationColors customizationColors = (CustomizationColors) other;
            return this.isNight == customizationColors.isNight && this.activityBackgroundColor == customizationColors.activityBackgroundColor && this.toolbarColor == customizationColors.toolbarColor && this.toolbarIconColor == customizationColors.toolbarIconColor && this.toolbarActionTextColor == customizationColors.toolbarActionTextColor && this.backButtonIconColor == customizationColors.backButtonIconColor;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.isNight) * 31) + Integer.hashCode(this.activityBackgroundColor)) * 31) + Integer.hashCode(this.toolbarColor)) * 31) + Integer.hashCode(this.toolbarIconColor)) * 31) + Integer.hashCode(this.toolbarActionTextColor)) * 31) + Integer.hashCode(this.backButtonIconColor);
        }

        public String toString() {
            return "CustomizationColors(isNight=" + this.isNight + ", activityBackgroundColor=" + this.activityBackgroundColor + ", toolbarColor=" + this.toolbarColor + ", toolbarIconColor=" + this.toolbarIconColor + ", toolbarActionTextColor=" + this.toolbarActionTextColor + ", backButtonIconColor=" + this.backButtonIconColor + ")";
        }

        public CustomizationColors(boolean z, int i, int i2, int i3, int i4, int i5) {
            this.isNight = z;
            this.activityBackgroundColor = i;
            this.toolbarColor = i2;
            this.toolbarIconColor = i3;
            this.toolbarActionTextColor = i4;
            this.backButtonIconColor = i5;
        }

        public final boolean isNight() {
            return this.isNight;
        }

        public final int getActivityBackgroundColor() {
            return this.activityBackgroundColor;
        }

        public final int getToolbarColor() {
            return this.toolbarColor;
        }

        public final int getToolbarIconColor() {
            return this.toolbarIconColor;
        }

        public final int getToolbarActionTextColor() {
            return this.toolbarActionTextColor;
        }

        public final int getBackButtonIconColor() {
            return this.backButtonIconColor;
        }
    }

    private final void forEachItem(Menu menu, Function1<? super MenuItem, Unit> function1) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            function1.invoke(item);
            SubMenu subMenu = item.getSubMenu();
            if (subMenu != null) {
                forEachItem(subMenu, function1);
            }
        }
    }
}
