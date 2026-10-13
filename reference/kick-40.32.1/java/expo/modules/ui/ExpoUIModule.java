package expo.modules.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.view.View;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.ToggleButtonDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.tracing.Trace;
import com.datadog.android.webview.WebViewTracking;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.classcomponent.ClassComponentBuilder;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.jni.fabric.NativeStatePropsGetter;
import expo.modules.kotlin.jni.worklets.Worklet;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ConstantComponentBuilder;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeCache;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeKt;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import expo.modules.kotlin.types.descriptors.TypeDescriptorKt;
import expo.modules.kotlin.types.descriptors.TypeDescriptorOfKt;
import expo.modules.kotlin.views.AsyncFunctionHandle;
import expo.modules.kotlin.views.AsyncFunctionHandle2;
import expo.modules.kotlin.views.ComposeFunctionHolder;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.ComposeViewBuilderScope;
import expo.modules.kotlin.views.ComposeViewProp;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.EventHandle;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.kotlin.views.PropsParsingStrategy;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import expo.modules.ui.button.ButtonKt;
import expo.modules.ui.button.ButtonPressedEvent;
import expo.modules.ui.button.ButtonProps;
import expo.modules.ui.button.FloatingActionButtonKt;
import expo.modules.ui.button.FloatingActionButtonProps;
import expo.modules.ui.button.IconButtonKt;
import expo.modules.ui.colors.MaterialColorsKt;
import expo.modules.ui.colors.MaterialColorsOptions;
import expo.modules.ui.graphics.ImageLoader;
import expo.modules.ui.icon.IconProps;
import expo.modules.ui.icon.IconView;
import expo.modules.ui.image.ImageProps;
import expo.modules.ui.image.ImageView;
import expo.modules.ui.menu.DropdownMenuItemKt;
import expo.modules.ui.menu.DropdownMenuItemProps;
import expo.modules.ui.menu.DropdownMenuKt;
import expo.modules.ui.menu.DropdownMenuProps;
import expo.modules.ui.menu.ExposedDropdownMenuBoxProps;
import expo.modules.ui.menu.ExposedDropdownMenuBoxViewKt;
import expo.modules.ui.menu.ExposedDropdownMenuProps;
import expo.modules.ui.menu.ExposedDropdownMenuViewKt;
import expo.modules.ui.state.ObservableState;
import expo.modules.ui.state.WorkletCallback;
import expo.modules.ui.textfield.BasicTextFieldKt;
import expo.modules.ui.textfield.BasicTextFieldProps;
import expo.modules.ui.textfield.InnerTextFieldProps;
import expo.modules.ui.textfield.InnerTextFieldView;
import expo.modules.ui.textfield.KeyboardActionEvent;
import expo.modules.ui.textfield.PlaceholderProps;
import expo.modules.ui.textfield.PlaceholderView;
import expo.modules.ui.textfield.TextFieldKt;
import expo.modules.ui.textfield.TextFieldProps;
import expo.modules.ui.textfield.TextFieldSelectionPayload;
import expo.modules.ui.textfield.TextFieldValuePayload;
import io.github.expo.pika.PTypeDescriptorRegistry;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.PropertyDelegateProvider;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: ExpoUIModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f²\u0006\u0010\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0016\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0016\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00190\u0016X\u008a\u0084\u0002²\u0006\u0016\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00190\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0016X\u008a\u0084\u0002²\u0006\u0010\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0016X\u008a\u0084\u0002²\u0006\u0010\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002040\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002040\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002040\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002040\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002050\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002050\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002050\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002050\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0010\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0016\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0016X\u008a\u0084\u0002²\u0006\u0010\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0011X\u008a\u0084\u0002²\u0006\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010;\u001a\b\u0012\u0004\u0012\u00020$0\u0011X\u008a\u0084\u0002²\u0006\u0016\u0010<\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(0=X\u008a\u0084\u0002²\u0006\u0010\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u0016X\u008a\u0084\u0002²\u0006\u0016\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010;\u001a\b\u0012\u0004\u0012\u00020$0\u0011X\u008a\u0084\u0002²\u0006\u0016\u0010<\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(0=X\u008a\u0084\u0002²\u0006\u0010\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u0016X\u008a\u0084\u0002²\u0006\u0016\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002²\u0006\u0016\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0016X\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016X\u008a\u0084\u0002"}, d2 = {"Lexpo/modules/ui/ExpoUIModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "value", "Lokhttp3/OkHttpClient;", "okHttpClient", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "Lexpo/modules/ui/graphics/ImageLoader;", "imageLoader", "getImageLoader", "()Lexpo/modules/ui/graphics/ImageLoader;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-ui_release", WebViewTracking.SESSION_REPLAY_MASK_ALL_TOUCH_PRIVACY, "Lexpo/modules/kotlin/views/AsyncFunctionHandle;", "", "expand", "partialExpand", "onDismissRequest", "Lexpo/modules/kotlin/views/EventHandle;", "onButtonPressed", "onCheckedChange", "Lexpo/modules/ui/GenericEventPayload1;", "", "Lexpo/modules/ui/CheckedChangeEvent;", "onNativeClick", "Lexpo/modules/ui/button/ButtonPressedEvent;", "onDateSelected", "Lexpo/modules/ui/DatePickerResult;", "onDateRangeSelected", "Lexpo/modules/ui/DateRangePickerResult;", "onItemPressed", "onSearch", "", "onQueryChange", "onRefresh", "animateScrollToPage", "", "scrollToPage", "onCurrentPageChange", "Lexpo/modules/ui/HorizontalPagerCurrentPageChangeEvent;", "onSettledPageChange", "Lexpo/modules/ui/HorizontalPagerSettledPageChangeEvent;", "onPageScroll", "Lexpo/modules/ui/HorizontalPagerPageScrollEvent;", "onScrollInProgressChange", "Lexpo/modules/ui/HorizontalPagerScrollInProgressChangeEvent;", "onDragInteraction", "Lexpo/modules/ui/HorizontalPagerDragInteractionEvent;", "Lexpo/modules/ui/ChipPressedEvent;", "Lexpo/modules/ui/ToggleButtonValueChangeEvent;", "onSurfaceClick", "showSnackbar", "Lexpo/modules/ui/SnackbarShowOptions;", WebViewTracking.SESSION_REPLAY_MASK_NONE_TOUCH_PRIVACY, "dismiss", "setText", "setSelection", "Lexpo/modules/kotlin/views/AsyncFunctionHandle2;", "clear", "focus", "blur", "onValueChange", "Lexpo/modules/ui/textfield/TextFieldValuePayload;", "onFocusChanged", "onKeyboardAction", "Lexpo/modules/ui/textfield/KeyboardActionEvent;", "onSelectionChange", "Lexpo/modules/ui/textfield/TextFieldSelectionPayload;", "onExpandedChange"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpoUIModule extends Module {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, WebViewTracking.SESSION_REPLAY_MASK_ALL_TOUCH_PRIVACY, "<v#0>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "expand", "<v#1>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "partialExpand", "<v#2>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDismissRequest", "<v#3>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#4>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onCheckedChange", "<v#5>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onCheckedChange", "<v#6>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onCheckedChange", "<v#7>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onNativeClick", "<v#8>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#9>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#10>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#11>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#12>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#13>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#14>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#15>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#16>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#17>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDateSelected", "<v#18>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDateRangeSelected", "<v#19>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDateSelected", "<v#20>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDismissRequest", "<v#21>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDateRangeSelected", "<v#22>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDismissRequest", "<v#23>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDateSelected", "<v#24>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDismissRequest", "<v#25>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDismissRequest", "<v#26>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onItemPressed", "<v#27>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onSearch", "<v#28>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onQueryChange", "<v#29>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onRefresh", "<v#30>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "animateScrollToPage", "<v#31>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "scrollToPage", "<v#32>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onCurrentPageChange", "<v#33>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onSettledPageChange", "<v#34>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onPageScroll", "<v#35>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onScrollInProgressChange", "<v#36>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDragInteraction", "<v#37>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDismissRequest", "<v#38>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onNativeClick", "<v#39>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onNativeClick", "<v#40>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onNativeClick", "<v#41>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onNativeClick", "<v#42>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onCheckedChange", "<v#43>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onCheckedChange", "<v#44>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onCheckedChange", "<v#45>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onCheckedChange", "<v#46>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#47>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDismissRequest", "<v#48>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onSurfaceClick", "<v#49>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onCheckedChange", "<v#50>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "showSnackbar", "<v#51>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, WebViewTracking.SESSION_REPLAY_MASK_NONE_TOUCH_PRIVACY, "<v#52>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "dismiss", "<v#53>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "setText", "<v#54>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "setSelection", "<v#55>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "clear", "<v#56>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "focus", "<v#57>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "blur", "<v#58>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onValueChange", "<v#59>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onFocusChanged", "<v#60>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onKeyboardAction", "<v#61>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onSelectionChange", "<v#62>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "setText", "<v#63>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "setSelection", "<v#64>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "clear", "<v#65>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "focus", "<v#66>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "blur", "<v#67>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onValueChange", "<v#68>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onFocusChanged", "<v#69>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onKeyboardAction", "<v#70>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onSelectionChange", "<v#71>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#72>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onButtonPressed", "<v#73>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onExpandedChange", "<v#74>", 0)), Reflection.property0(new PropertyReference0Impl(ExpoUIModule.class, "onDismissRequest", "<v#75>", 0))};
    public static final int $stable = 8;
    private ImageLoader imageLoader;
    private OkHttpClient okHttpClient;

    public final OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    public final ImageLoader getImageLoader() {
        return this.imageLoader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r22v23 */
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Object objM12684constructorimpl;
        AnyType anyType;
        char c;
        Object objM12684constructorimpl2;
        Object objM12684constructorimpl3;
        Object objM12684constructorimpl4;
        Object objM12684constructorimpl5;
        AnyType anyType2;
        Object objM12684constructorimpl6;
        Object objM12684constructorimpl7;
        Object objM12684constructorimpl8;
        Object objM12684constructorimpl9;
        Object objM12684constructorimpl10;
        Object objM12684constructorimpl11;
        Object objM12684constructorimpl12;
        Object objM12684constructorimpl13;
        Object objM12684constructorimpl14;
        Object objM12684constructorimpl15;
        Object objM12684constructorimpl16;
        Object objM12684constructorimpl17;
        Object objM12684constructorimpl18;
        Object objM12684constructorimpl19;
        Object objM12684constructorimpl20;
        Object objM12684constructorimpl21;
        Object objM12684constructorimpl22;
        Object objM12684constructorimpl23;
        Object objM12684constructorimpl24;
        Object objM12684constructorimpl25;
        Object objM12684constructorimpl26;
        Object objM12684constructorimpl27;
        Object objM12684constructorimpl28;
        ExpoUIModule expoUIModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (expoUIModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(expoUIModule);
            moduleDefinitionBuilder.Name("ExpoUI");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    if (reactContext == null) {
                        throw new IllegalArgumentException("ExpoUIModule requires an active React context".toString());
                    }
                    ExpoUIModule expoUIModule2 = this.this$0;
                    expoUIModule2.okHttpClient = expoUIModule2.getAppContext().createOkHttpClientBuilder().build();
                    ExpoUIModule expoUIModule3 = this.this$0;
                    OkHttpClient okHttpClient = this.this$0.getOkHttpClient();
                    if (okHttpClient == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    expoUIModule3.imageLoader = new ImageLoader(reactContext, okHttpClient);
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() throws IOException {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() throws IOException {
                    Cache cache;
                    ConnectionPool connectionPool;
                    Dispatcher dispatcher;
                    ExecutorService executorService;
                    new NativeStatePropsGetter().clearAllContentOrigins();
                    ImageLoader imageLoader = this.this$0.getImageLoader();
                    if (imageLoader != null) {
                        imageLoader.close();
                    }
                    this.this$0.imageLoader = null;
                    OkHttpClient okHttpClient = this.this$0.getOkHttpClient();
                    if (okHttpClient != null && (dispatcher = okHttpClient.dispatcher()) != null && (executorService = dispatcher.executorService()) != null) {
                        executorService.shutdown();
                    }
                    OkHttpClient okHttpClient2 = this.this$0.getOkHttpClient();
                    if (okHttpClient2 != null && (connectionPool = okHttpClient2.connectionPool()) != null) {
                        connectionPool.evictAll();
                    }
                    OkHttpClient okHttpClient3 = this.this$0.getOkHttpClient();
                    if (okHttpClient3 != null && (cache = okHttpClient3.cache()) != null) {
                        cache.close();
                    }
                    this.this$0.okHttpClient = null;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(WorkletCallback.class);
            Module module = moduleDefinitionBuilder2.getModule();
            if (module == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext = module.getAppContext();
            String simpleName = JvmClassMappingKt.getJavaClass(orCreateKotlinClass).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            AnyType anyType3 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(WorkletCallback.class), false));
            if (anyType3 != null) {
                anyType = anyType3;
            } else {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(WorkletCallback.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$Class$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(WorkletCallback.class);
                        }
                    }));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
                    objM12684constructorimpl = null;
                }
                TypeDescriptor typeDescriptor = (TypeDescriptor) objM12684constructorimpl;
                if (typeDescriptor == null) {
                    typeDescriptor = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(WorkletCallback.class));
                }
                anyType = new AnyType(typeDescriptor, null);
            }
            ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(appContext, simpleName, orCreateKotlinClass, anyType, moduleDefinitionBuilder2.getConverters());
            TypeConverterProvider converters = classComponentBuilder.getConverters();
            AnyType[] anyTypeArr = new AnyType[1];
            AnyType anyType4 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Worklet.class), false));
            if (anyType4 != null) {
                c = 0;
            } else {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    c = 0;
                    try {
                        objM12684constructorimpl2 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Worklet.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$6$$inlined$Constructor$1
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(Worklet.class);
                            }
                        }));
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion4 = Result.INSTANCE;
                        objM12684constructorimpl2 = Result.m12684constructorimpl(ResultKt.createFailure(th));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    c = 0;
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl2)) {
                    objM12684constructorimpl2 = null;
                }
                TypeDescriptor typeDescriptor2 = (TypeDescriptor) objM12684constructorimpl2;
                if (typeDescriptor2 == null) {
                    typeDescriptor2 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Worklet.class));
                }
                anyType4 = new AnyType(typeDescriptor2, converters);
            }
            anyTypeArr[c] = anyType4;
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Object.class);
            if (returnType == null) {
                JSTypeConverter<?> directConverter = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter == null) {
                    directConverter = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType2 = new ReturnType(directConverter);
                returnTypeProvider.getTypes().put(Object.class, returnType2);
                returnType = returnType2;
            }
            classComponentBuilder.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$6$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Worklet worklet = (Worklet) objArr[0];
                    WorkletCallback workletCallback = new WorkletCallback();
                    workletCallback.setWorklet(worklet);
                    return workletCallback;
                }
            }));
            ClassComponentBuilder classComponentBuilder2 = classComponentBuilder;
            TypeConverterProvider converters2 = classComponentBuilder2.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[2];
            boolean z = c;
            AnyType anyType5 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(WorkletCallback.class), Boolean.valueOf(z)));
            ?? r22 = z;
            if (anyType5 == null) {
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(WorkletCallback.class, z, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$6$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(WorkletCallback.class);
                        }
                    }));
                } catch (Throwable th4) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM12684constructorimpl3 = Result.m12684constructorimpl(ResultKt.createFailure(th4));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl3)) {
                    objM12684constructorimpl3 = null;
                }
                TypeDescriptor typeDescriptor3 = (TypeDescriptor) objM12684constructorimpl3;
                if (typeDescriptor3 == null) {
                    typeDescriptor3 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(WorkletCallback.class));
                }
                anyType5 = new AnyType(typeDescriptor3, converters2);
                r22 = 0;
            }
            anyTypeArr2[r22] = anyType5;
            AnyType anyType6 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Worklet.class), Boolean.valueOf((boolean) r22)));
            if (anyType6 == null) {
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(Worklet.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$6$$inlined$Function$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Worklet.class);
                        }
                    }));
                } catch (Throwable th5) {
                    Result.Companion companion8 = Result.INSTANCE;
                    objM12684constructorimpl4 = Result.m12684constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl4)) {
                    objM12684constructorimpl4 = null;
                }
                TypeDescriptor typeDescriptor4 = (TypeDescriptor) objM12684constructorimpl4;
                if (typeDescriptor4 == null) {
                    typeDescriptor4 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Worklet.class));
                }
                anyType6 = new AnyType(typeDescriptor4, converters2);
            }
            anyTypeArr2[1] = anyType6;
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider2.getTypes().get(Job.class);
            if (returnType3 == null) {
                JSTypeConverter<?> directConverter2 = ReturnTypeKt.getDirectConverter(Job.class);
                if (directConverter2 == null) {
                    directConverter2 = ReturnTypeKt.getIndirectConverter(Job.class, null);
                }
                ReturnType returnType4 = new ReturnType(directConverter2);
                returnTypeProvider2.getTypes().put(Job.class, returnType4);
                returnType3 = returnType4;
            }
            classComponentBuilder2.getSyncFunctions().put("setWorklet", new SyncFunctionComponent("setWorklet", anyTypeArr2, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$6$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    return BuildersKt__Builders_commonKt.launch$default(this.this$0.getAppContext().getMainQueue(), null, null, new ExpoUIModule$definition$1$3$2$1((WorkletCallback) obj, (Worklet) objArr[1], null), 3, null);
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getTypeDescriptor(), "__expo_ui_shared_object__");
            AnyType[] anyTypeArr3 = {new AnyType(propertyComponentBuilderWithThis.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider3 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType5 = returnTypeProvider3.getTypes().get(Boolean.class);
            if (returnType5 == null) {
                JSTypeConverter<?> directConverter3 = ReturnTypeKt.getDirectConverter(Boolean.class);
                if (directConverter3 == null) {
                    directConverter3 = ReturnTypeKt.getIndirectConverter(Boolean.class, null);
                }
                ReturnType returnType6 = new ReturnType(directConverter3);
                returnTypeProvider3.getTypes().put(Boolean.class, returnType6);
                returnType5 = returnType6;
            }
            SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("get", anyTypeArr3, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$6$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            });
            syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
            syncFunctionComponent.setCanTakeOwner(true);
            propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
            classComponentBuilder.getProperties().put("__expo_ui_shared_object__", propertyComponentBuilderWithThis);
            moduleDefinitionBuilder2.getClassData().add(classComponentBuilder.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ObservableState.class);
            Module module2 = moduleDefinitionBuilder3.getModule();
            if (module2 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext2 = module2.getAppContext();
            String simpleName2 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass2).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
            AnyType anyType7 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ObservableState.class), false));
            if (anyType7 != null) {
                anyType2 = anyType7;
            } else {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ObservableState.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$Class$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ObservableState.class);
                        }
                    }));
                } catch (Throwable th6) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objM12684constructorimpl5 = Result.m12684constructorimpl(ResultKt.createFailure(th6));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl5)) {
                    objM12684constructorimpl5 = null;
                }
                TypeDescriptor typeDescriptor5 = (TypeDescriptor) objM12684constructorimpl5;
                if (typeDescriptor5 == null) {
                    typeDescriptor5 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ObservableState.class));
                }
                anyType2 = new AnyType(typeDescriptor5, null);
            }
            ClassComponentBuilder classComponentBuilder3 = new ClassComponentBuilder(appContext2, simpleName2, orCreateKotlinClass2, anyType2, moduleDefinitionBuilder3.getConverters());
            TypeConverterProvider converters3 = classComponentBuilder3.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[1];
            AnyType anyType8 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), false));
            if (anyType8 == null) {
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, Arrays.asList(PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Object.class, true, null)), null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$12$$inlined$Constructor$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                        }
                    }));
                } catch (Throwable th7) {
                    Result.Companion companion12 = Result.INSTANCE;
                    objM12684constructorimpl6 = Result.m12684constructorimpl(ResultKt.createFailure(th7));
                }
                if (Result.m12690isFailureimpl(objM12684constructorimpl6)) {
                    objM12684constructorimpl6 = null;
                }
                TypeDescriptor typeDescriptor6 = (TypeDescriptor) objM12684constructorimpl6;
                if (typeDescriptor6 == null) {
                    typeDescriptor6 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class))));
                }
                anyType8 = new AnyType(typeDescriptor6, converters3);
            }
            anyTypeArr4[0] = anyType8;
            ReturnTypeProvider returnTypeProvider4 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType7 = returnTypeProvider4.getTypes().get(Object.class);
            if (returnType7 == null) {
                JSTypeConverter<?> directConverter4 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter4 == null) {
                    directConverter4 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType8 = new ReturnType(directConverter4);
                returnTypeProvider4.getTypes().put(Object.class, returnType8);
                returnType7 = returnType8;
            }
            classComponentBuilder3.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr4, returnType7, new Function1<Object[], Object>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$12$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return new ObservableState(((Map) objArr[0]).get("value"));
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis2 = new PropertyComponentBuilderWithThis(classComponentBuilder3.getOwnerType().getTypeDescriptor(), "__expo_ui_shared_object__");
            AnyType[] anyTypeArr5 = {new AnyType(propertyComponentBuilderWithThis2.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider5 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType9 = returnTypeProvider5.getTypes().get(Boolean.class);
            if (returnType9 == null) {
                JSTypeConverter<?> directConverter5 = ReturnTypeKt.getDirectConverter(Boolean.class);
                if (directConverter5 == null) {
                    directConverter5 = ReturnTypeKt.getIndirectConverter(Boolean.class, null);
                }
                ReturnType returnType10 = new ReturnType(directConverter5);
                returnTypeProvider5.getTypes().put(Boolean.class, returnType10);
                returnType9 = returnType10;
            }
            SyncFunctionComponent syncFunctionComponent2 = new SyncFunctionComponent("get", anyTypeArr5, returnType9, new Function1<Object[], Object>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$12$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            });
            syncFunctionComponent2.setOwnerType(propertyComponentBuilderWithThis2.getThisType());
            syncFunctionComponent2.setCanTakeOwner(true);
            propertyComponentBuilderWithThis2.setGetter(syncFunctionComponent2);
            classComponentBuilder3.getProperties().put("__expo_ui_shared_object__", propertyComponentBuilderWithThis2);
            ClassComponentBuilder classComponentBuilder4 = classComponentBuilder3;
            TypeConverterProvider converters4 = classComponentBuilder4.getConverters();
            AnyType[] anyTypeArr6 = new AnyType[1];
            AnyType anyType9 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ObservableState.class), false));
            if (anyType9 == null) {
                try {
                    Result.Companion companion13 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ObservableState.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$12$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ObservableState.class);
                        }
                    }));
                } catch (Throwable th8) {
                    Result.Companion companion14 = Result.INSTANCE;
                    objM12684constructorimpl7 = Result.m12684constructorimpl(ResultKt.createFailure(th8));
                }
                Object obj = objM12684constructorimpl7;
                if (Result.m12690isFailureimpl(obj)) {
                    obj = null;
                }
                TypeDescriptor typeDescriptor7 = (TypeDescriptor) obj;
                if (typeDescriptor7 == null) {
                    typeDescriptor7 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ObservableState.class));
                }
                anyType9 = new AnyType(typeDescriptor7, converters4);
            }
            anyTypeArr6[0] = anyType9;
            ReturnTypeProvider returnTypeProvider6 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType11 = returnTypeProvider6.getTypes().get(Object.class);
            if (returnType11 == null) {
                JSTypeConverter<?> directConverter6 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter6 == null) {
                    directConverter6 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType12 = new ReturnType(directConverter6);
                returnTypeProvider6.getTypes().put(Object.class, returnType12);
                returnType11 = returnType12;
            }
            classComponentBuilder4.getSyncFunctions().put("getValue", new SyncFunctionComponent("getValue", anyTypeArr6, returnType11, new Function1<Object[], Object>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$12$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((ObservableState) objArr[0]).getValue();
                }
            }));
            ClassComponentBuilder classComponentBuilder5 = classComponentBuilder3;
            TypeConverterProvider converters5 = classComponentBuilder5.getConverters();
            AnyType[] anyTypeArr7 = new AnyType[2];
            AnyType anyType10 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ObservableState.class), false));
            if (anyType10 == null) {
                try {
                    Result.Companion companion15 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ObservableState.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$12$$inlined$Function$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ObservableState.class);
                        }
                    }));
                } catch (Throwable th9) {
                    Result.Companion companion16 = Result.INSTANCE;
                    objM12684constructorimpl8 = Result.m12684constructorimpl(ResultKt.createFailure(th9));
                }
                Object obj2 = objM12684constructorimpl8;
                if (Result.m12690isFailureimpl(obj2)) {
                    obj2 = null;
                }
                TypeDescriptor typeDescriptor8 = (TypeDescriptor) obj2;
                if (typeDescriptor8 == null) {
                    typeDescriptor8 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ObservableState.class));
                }
                anyType10 = new AnyType(typeDescriptor8, converters5);
            }
            anyTypeArr7[0] = anyType10;
            AnyType anyType11 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), false));
            if (anyType11 == null) {
                try {
                    Result.Companion companion17 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, Arrays.asList(PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Object.class, true, null)), null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$12$$inlined$Function$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                        }
                    }));
                } catch (Throwable th10) {
                    Result.Companion companion18 = Result.INSTANCE;
                    objM12684constructorimpl9 = Result.m12684constructorimpl(ResultKt.createFailure(th10));
                }
                Object obj3 = objM12684constructorimpl9;
                if (Result.m12690isFailureimpl(obj3)) {
                    obj3 = null;
                }
                TypeDescriptor typeDescriptor9 = (TypeDescriptor) obj3;
                if (typeDescriptor9 == null) {
                    typeDescriptor9 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class))));
                }
                anyType11 = new AnyType(typeDescriptor9, converters5);
            }
            anyTypeArr7[1] = anyType11;
            ReturnTypeProvider returnTypeProvider7 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType13 = returnTypeProvider7.getTypes().get(Object.class);
            if (returnType13 == null) {
                JSTypeConverter<?> directConverter7 = ReturnTypeKt.getDirectConverter(Object.class);
                if (directConverter7 == null) {
                    directConverter7 = ReturnTypeKt.getIndirectConverter(Object.class, null);
                }
                ReturnType returnType14 = new ReturnType(directConverter7);
                returnTypeProvider7.getTypes().put(Object.class, returnType14);
                returnType13 = returnType14;
            }
            classComponentBuilder5.getSyncFunctions().put("setValue", new SyncFunctionComponent("setValue", anyTypeArr7, returnType13, new Function1<Object[], Object>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$12$$inlined$Function$5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ObservableState observableState = (ObservableState) objArr[0];
                    Object obj4 = ((Map) objArr[1]).get("value");
                    if (!Looper.getMainLooper().isCurrentThread()) {
                        return BuildersKt__Builders_commonKt.launch$default(this.this$0.getAppContext().getMainQueue(), null, null, new ExpoUIModule$definition$1$4$4$1(observableState, obj4, null), 3, null);
                    }
                    observableState.setValue(obj4);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder6 = classComponentBuilder3;
            TypeConverterProvider converters6 = classComponentBuilder6.getConverters();
            AnyType[] anyTypeArr8 = new AnyType[2];
            AnyType anyType12 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ObservableState.class), false));
            if (anyType12 == null) {
                try {
                    Result.Companion companion19 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ObservableState.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$12$$inlined$Function$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ObservableState.class);
                        }
                    }));
                } catch (Throwable th11) {
                    Result.Companion companion20 = Result.INSTANCE;
                    objM12684constructorimpl10 = Result.m12684constructorimpl(ResultKt.createFailure(th11));
                }
                Object obj4 = objM12684constructorimpl10;
                if (Result.m12690isFailureimpl(obj4)) {
                    obj4 = null;
                }
                TypeDescriptor typeDescriptor10 = (TypeDescriptor) obj4;
                if (typeDescriptor10 == null) {
                    typeDescriptor10 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ObservableState.class));
                }
                anyType12 = new AnyType(typeDescriptor10, converters6);
            }
            anyTypeArr8[0] = anyType12;
            AnyType anyType13 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(WorkletCallback.class), true));
            if (anyType13 == null) {
                try {
                    Result.Companion companion21 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(WorkletCallback.class, true, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$12$$inlined$Function$7
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(WorkletCallback.class);
                        }
                    }));
                } catch (Throwable th12) {
                    Result.Companion companion22 = Result.INSTANCE;
                    objM12684constructorimpl11 = Result.m12684constructorimpl(ResultKt.createFailure(th12));
                }
                Object obj5 = objM12684constructorimpl11;
                if (Result.m12690isFailureimpl(obj5)) {
                    obj5 = null;
                }
                TypeDescriptor typeDescriptor11 = (TypeDescriptor) obj5;
                if (typeDescriptor11 == null) {
                    typeDescriptor11 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(WorkletCallback.class));
                }
                anyType13 = new AnyType(typeDescriptor11, converters6);
            }
            anyTypeArr8[1] = anyType13;
            ReturnTypeProvider returnTypeProvider8 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType15 = returnTypeProvider8.getTypes().get(Unit.class);
            if (returnType15 == null) {
                JSTypeConverter<?> directConverter8 = ReturnTypeKt.getDirectConverter(Unit.class);
                if (directConverter8 == null) {
                    directConverter8 = ReturnTypeKt.getIndirectConverter(Unit.class, null);
                }
                ReturnType returnType16 = new ReturnType(directConverter8);
                returnTypeProvider8.getTypes().put(Unit.class, returnType16);
                returnType15 = returnType16;
            }
            classComponentBuilder6.getSyncFunctions().put("setOnChange", new SyncFunctionComponent("setOnChange", anyTypeArr8, returnType15, new Function1<Object[], Object>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$12$$inlined$Function$8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((ObservableState) objArr[0]).setOnChange$expo_ui_release((WorkletCallback) objArr[1]);
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder3.getClassData().add(classComponentBuilder3.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(HostView.class);
            try {
                Result.Companion companion23 = Result.INSTANCE;
                objM12684constructorimpl12 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(HostView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(HostView.class);
                    }
                }));
            } catch (Throwable th13) {
                Result.Companion companion24 = Result.INSTANCE;
                objM12684constructorimpl12 = Result.m12684constructorimpl(ResultKt.createFailure(th13));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl12)) {
                objM12684constructorimpl12 = null;
            }
            TypeDescriptor typeDescriptor12 = (TypeDescriptor) objM12684constructorimpl12;
            if (typeDescriptor12 == null) {
                typeDescriptor12 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(HostView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass3, typeDescriptor12, null, 4, null);
            for (ComposeViewProp composeViewProp : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(HostProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder.getProps().put(composeViewProp.getName(), composeViewProp);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            viewDefinitionBuilder.Events("onLayoutContent");
            viewDefinitionBuilder.setOnViewDidUpdateProps(new Function1<View, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$14$$inlined$OnViewDidUpdateProps$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((HostView) it).onViewDidUpdateProps$expo_ui_release();
                }
            });
            moduleDefinitionBuilder4.registerViewDefinition(viewDefinitionBuilder.build());
            ConstantComponentBuilder constantComponentBuilder = new ConstantComponentBuilder("SwitchDefaultIconSize");
            constantComponentBuilder.setGetter(new Function0<Float>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$Constant$1
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(SwitchDefaults.INSTANCE.m4814getIconSizeD9Ej5fM());
                }
            });
            moduleDefinitionBuilder.getConstants().put("SwitchDefaultIconSize", constantComponentBuilder);
            ConstantComponentBuilder constantComponentBuilder2 = new ConstantComponentBuilder("ToggleButtonIconSpacing");
            constantComponentBuilder2.setGetter(new Function0<Float>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$Constant$2
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(ToggleButtonDefaults.INSTANCE.m5031getIconSpacingD9Ej5fM());
                }
            });
            moduleDefinitionBuilder.getConstants().put("ToggleButtonIconSpacing", constantComponentBuilder2);
            ConstantComponentBuilder constantComponentBuilder3 = new ConstantComponentBuilder("ToggleButtonIconSize");
            constantComponentBuilder3.setGetter(new Function0<Float>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$Constant$3
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(ToggleButtonDefaults.INSTANCE.m5030getIconSizeD9Ej5fM());
                }
            });
            moduleDefinitionBuilder.getConstants().put("ToggleButtonIconSize", constantComponentBuilder3);
            ConstantComponentBuilder constantComponentBuilder4 = new ConstantComponentBuilder("isDynamicColorAvailable");
            constantComponentBuilder4.setGetter(new Function0<Boolean>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$Constant$4
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(MaterialColorsKt.isDynamicColorSupported());
                }
            });
            moduleDefinitionBuilder.getConstants().put("isDynamicColorAvailable", constantComponentBuilder4);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            TypeConverterProvider converters7 = moduleDefinitionBuilder5.getConverters();
            AnyType[] anyTypeArr9 = new AnyType[1];
            AnyType anyType14 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(MaterialColorsOptions.class), true));
            if (anyType14 == null) {
                try {
                    Result.Companion companion25 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(MaterialColorsOptions.class, true, MaterialColorsOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$Function$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(MaterialColorsOptions.class);
                        }
                    }));
                } catch (Throwable th14) {
                    Result.Companion companion26 = Result.INSTANCE;
                    objM12684constructorimpl13 = Result.m12684constructorimpl(ResultKt.createFailure(th14));
                }
                Object obj6 = objM12684constructorimpl13;
                if (Result.m12690isFailureimpl(obj6)) {
                    obj6 = null;
                }
                TypeDescriptor typeDescriptor13 = (TypeDescriptor) obj6;
                if (typeDescriptor13 == null) {
                    typeDescriptor13 = TypeDescriptorKt.toTypeDescriptor(Reflection.nullableTypeOf(MaterialColorsOptions.class));
                }
                anyType14 = new AnyType(typeDescriptor13, converters7);
            }
            anyTypeArr9[0] = anyType14;
            ReturnTypeProvider returnTypeProvider9 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType17 = returnTypeProvider9.getTypes().get(Map.class);
            if (returnType17 == null) {
                JSTypeConverter<?> directConverter9 = ReturnTypeKt.getDirectConverter(Map.class);
                if (directConverter9 == null) {
                    directConverter9 = ReturnTypeKt.getIndirectConverter(Map.class, null);
                }
                ReturnType returnType18 = new ReturnType(directConverter9);
                returnTypeProvider9.getTypes().put(Map.class, returnType18);
                returnType17 = returnType18;
            }
            moduleDefinitionBuilder5.getSyncFunctions().put("getMaterialColors", new SyncFunctionComponent("getMaterialColors", anyTypeArr9, returnType17, new Function1<Object[], Object>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws Exceptions.ReactContextLost {
                    Activity reactContext;
                    ExpoColorScheme scheme;
                    ColorScheme colorScheme;
                    Color seedColor;
                    androidx.compose.ui.graphics.Color composeOrNull;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    MaterialColorsOptions materialColorsOptions = (MaterialColorsOptions) objArr[0];
                    Activity currentActivity = this.this$0.getAppContext().getCurrentActivity();
                    if (currentActivity != null) {
                        reactContext = currentActivity;
                    } else {
                        reactContext = this.this$0.getAppContext().getReactContext();
                        if (reactContext == null) {
                            throw new Exceptions.ReactContextLost();
                        }
                    }
                    if (materialColorsOptions == null || (scheme = materialColorsOptions.getScheme()) == null) {
                        if (MaterialColorsKt.isSystemInDarkTheme(reactContext)) {
                            scheme = ExpoColorScheme.DARK;
                        } else {
                            scheme = ExpoColorScheme.LIGHT;
                        }
                    }
                    boolean z2 = scheme == ExpoColorScheme.DARK;
                    Integer numValueOf = (materialColorsOptions == null || (seedColor = materialColorsOptions.getSeedColor()) == null || (composeOrNull = UtilsKt.getComposeOrNull(seedColor)) == null) ? null : Integer.valueOf(ColorKt.m7392toArgb8_81llA(composeOrNull.m7348unboximpl()));
                    if (numValueOf != null) {
                        colorScheme = MaterialColorsKt.seedColorScheme(numValueOf.intValue(), z2);
                    } else {
                        colorScheme = scheme.toColorScheme(reactContext);
                    }
                    return MaterialColorsKt.toTokenMap(colorScheme);
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(RNHostView.class);
            try {
                Result.Companion companion27 = Result.INSTANCE;
                objM12684constructorimpl14 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RNHostView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(RNHostView.class);
                    }
                }));
            } catch (Throwable th15) {
                Result.Companion companion28 = Result.INSTANCE;
                objM12684constructorimpl14 = Result.m12684constructorimpl(ResultKt.createFailure(th15));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl14)) {
                objM12684constructorimpl14 = null;
            }
            TypeDescriptor typeDescriptor14 = (TypeDescriptor) objM12684constructorimpl14;
            if (typeDescriptor14 == null) {
                typeDescriptor14 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(RNHostView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder2 = new ViewDefinitionBuilder(orCreateKotlinClass4, typeDescriptor14, null, 4, null);
            for (ComposeViewProp composeViewProp2 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(RNHostViewProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder2.getProps().put(composeViewProp2.getName(), composeViewProp2);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder2);
            ExpoUIModule$definition$1$11$1 expoUIModule$definition$1$11$1 = new Function2<RNHostView, Boolean, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$11$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(RNHostView rNHostView, Boolean bool) {
                    invoke(rNHostView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RNHostView view, boolean z2) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setLayoutRoot$expo_ui_release(z2);
                }
            };
            AnyType anyType15 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType15 == null) {
                try {
                    Result.Companion companion29 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.BOOLEAN), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$21$$inlined$Prop$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Boolean.TYPE);
                        }
                    }));
                } catch (Throwable th16) {
                    Result.Companion companion30 = Result.INSTANCE;
                    objM12684constructorimpl15 = Result.m12684constructorimpl(ResultKt.createFailure(th16));
                }
                Object obj7 = objM12684constructorimpl15;
                if (Result.m12690isFailureimpl(obj7)) {
                    obj7 = null;
                }
                TypeDescriptor typeDescriptor15 = (TypeDescriptor) obj7;
                if (typeDescriptor15 == null) {
                    typeDescriptor15 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Boolean.TYPE));
                }
                anyType15 = new AnyType(typeDescriptor15, null);
            }
            viewDefinitionBuilder2.getProps().put("layoutRoot", new ConcreteViewProp("layoutRoot", anyType15, expoUIModule$definition$1$11$1));
            viewDefinitionBuilder2.setOnViewDestroys(new Function1<View, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$21$$inlined$OnViewDestroys$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((RNHostView) it).clearPublishedContentOrigin$expo_ui_release();
                }
            });
            moduleDefinitionBuilder6.registerViewDefinition(viewDefinitionBuilder2.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(SlotView.class);
            try {
                Result.Companion companion31 = Result.INSTANCE;
                objM12684constructorimpl16 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SlotView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(SlotView.class);
                    }
                }));
            } catch (Throwable th17) {
                Result.Companion companion32 = Result.INSTANCE;
                objM12684constructorimpl16 = Result.m12684constructorimpl(ResultKt.createFailure(th17));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl16)) {
                objM12684constructorimpl16 = null;
            }
            TypeDescriptor typeDescriptor16 = (TypeDescriptor) objM12684constructorimpl16;
            if (typeDescriptor16 == null) {
                typeDescriptor16 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SlotView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder3 = new ViewDefinitionBuilder(orCreateKotlinClass5, typeDescriptor16, null, 4, null);
            for (ComposeViewProp composeViewProp3 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(SlotProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder3.getProps().put(composeViewProp3.getName(), composeViewProp3);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder3);
            viewDefinitionBuilder3.Events("onSlotEvent");
            moduleDefinitionBuilder7.registerViewDefinition(viewDefinitionBuilder3.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(InnerTextFieldView.class);
            try {
                Result.Companion companion33 = Result.INSTANCE;
                objM12684constructorimpl17 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(InnerTextFieldView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$default$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(InnerTextFieldView.class);
                    }
                }));
            } catch (Throwable th18) {
                Result.Companion companion34 = Result.INSTANCE;
                objM12684constructorimpl17 = Result.m12684constructorimpl(ResultKt.createFailure(th18));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl17)) {
                objM12684constructorimpl17 = null;
            }
            TypeDescriptor typeDescriptor17 = (TypeDescriptor) objM12684constructorimpl17;
            if (typeDescriptor17 == null) {
                typeDescriptor17 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(InnerTextFieldView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder4 = new ViewDefinitionBuilder(orCreateKotlinClass6, typeDescriptor17, null, 4, null);
            for (ComposeViewProp composeViewProp4 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(InnerTextFieldProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder4.getProps().put(composeViewProp4.getName(), composeViewProp4);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder4);
            Unit unit = Unit.INSTANCE;
            moduleDefinitionBuilder8.registerViewDefinition(viewDefinitionBuilder4.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder9 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(PlaceholderView.class);
            try {
                Result.Companion companion35 = Result.INSTANCE;
                objM12684constructorimpl18 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(PlaceholderView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$default$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(PlaceholderView.class);
                    }
                }));
            } catch (Throwable th19) {
                Result.Companion companion36 = Result.INSTANCE;
                objM12684constructorimpl18 = Result.m12684constructorimpl(ResultKt.createFailure(th19));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl18)) {
                objM12684constructorimpl18 = null;
            }
            TypeDescriptor typeDescriptor18 = (TypeDescriptor) objM12684constructorimpl18;
            if (typeDescriptor18 == null) {
                typeDescriptor18 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(PlaceholderView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder5 = new ViewDefinitionBuilder(orCreateKotlinClass7, typeDescriptor18, null, 4, null);
            for (ComposeViewProp composeViewProp5 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(PlaceholderProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder5.getProps().put(composeViewProp5.getName(), composeViewProp5);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder5);
            Unit unit2 = Unit.INSTANCE;
            moduleDefinitionBuilder9.registerViewDefinition(viewDefinitionBuilder5.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder10 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(IconView.class);
            try {
                Result.Companion companion37 = Result.INSTANCE;
                objM12684constructorimpl19 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(IconView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$default$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(IconView.class);
                    }
                }));
            } catch (Throwable th20) {
                Result.Companion companion38 = Result.INSTANCE;
                objM12684constructorimpl19 = Result.m12684constructorimpl(ResultKt.createFailure(th20));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl19)) {
                objM12684constructorimpl19 = null;
            }
            TypeDescriptor typeDescriptor19 = (TypeDescriptor) objM12684constructorimpl19;
            if (typeDescriptor19 == null) {
                typeDescriptor19 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(IconView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder6 = new ViewDefinitionBuilder(orCreateKotlinClass8, typeDescriptor19, null, 4, null);
            for (ComposeViewProp composeViewProp6 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(IconProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder6.getProps().put(composeViewProp6.getName(), composeViewProp6);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder6);
            Unit unit3 = Unit.INSTANCE;
            moduleDefinitionBuilder10.registerViewDefinition(viewDefinitionBuilder6.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder11 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(ImageView.class);
            try {
                Result.Companion companion39 = Result.INSTANCE;
                objM12684constructorimpl20 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(ImageView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ImageView.class);
                    }
                }));
            } catch (Throwable th21) {
                Result.Companion companion40 = Result.INSTANCE;
                objM12684constructorimpl20 = Result.m12684constructorimpl(ResultKt.createFailure(th21));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl20)) {
                objM12684constructorimpl20 = null;
            }
            TypeDescriptor typeDescriptor20 = (TypeDescriptor) objM12684constructorimpl20;
            if (typeDescriptor20 == null) {
                typeDescriptor20 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ImageView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder7 = new ViewDefinitionBuilder(orCreateKotlinClass9, typeDescriptor20, null, 4, null);
            for (ComposeViewProp composeViewProp7 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ImageProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder7.getProps().put(composeViewProp7.getName(), composeViewProp7);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder7);
            viewDefinitionBuilder7.Events("onLoad", "onError");
            moduleDefinitionBuilder11.registerViewDefinition(viewDefinitionBuilder7.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder12 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(LazyColumnView.class);
            try {
                Result.Companion companion41 = Result.INSTANCE;
                objM12684constructorimpl21 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(LazyColumnView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$default$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(LazyColumnView.class);
                    }
                }));
            } catch (Throwable th22) {
                Result.Companion companion42 = Result.INSTANCE;
                objM12684constructorimpl21 = Result.m12684constructorimpl(ResultKt.createFailure(th22));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl21)) {
                objM12684constructorimpl21 = null;
            }
            TypeDescriptor typeDescriptor21 = (TypeDescriptor) objM12684constructorimpl21;
            if (typeDescriptor21 == null) {
                typeDescriptor21 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(LazyColumnView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder8 = new ViewDefinitionBuilder(orCreateKotlinClass10, typeDescriptor21, null, 4, null);
            for (ComposeViewProp composeViewProp8 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(LazyColumnProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder8.getProps().put(composeViewProp8.getName(), composeViewProp8);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder8);
            Unit unit4 = Unit.INSTANCE;
            moduleDefinitionBuilder12.registerViewDefinition(viewDefinitionBuilder8.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder13 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(LazyRowView.class);
            try {
                Result.Companion companion43 = Result.INSTANCE;
                objM12684constructorimpl22 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(LazyRowView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$default$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(LazyRowView.class);
                    }
                }));
            } catch (Throwable th23) {
                Result.Companion companion44 = Result.INSTANCE;
                objM12684constructorimpl22 = Result.m12684constructorimpl(ResultKt.createFailure(th23));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl22)) {
                objM12684constructorimpl22 = null;
            }
            TypeDescriptor typeDescriptor22 = (TypeDescriptor) objM12684constructorimpl22;
            if (typeDescriptor22 == null) {
                typeDescriptor22 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(LazyRowView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder9 = new ViewDefinitionBuilder(orCreateKotlinClass11, typeDescriptor22, null, 4, null);
            for (ComposeViewProp composeViewProp9 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(LazyRowProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder9.getProps().put(composeViewProp9.getName(), composeViewProp9);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder9);
            Unit unit5 = Unit.INSTANCE;
            moduleDefinitionBuilder13.registerViewDefinition(viewDefinitionBuilder9.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder14 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(LazyItemsView.class);
            try {
                Result.Companion companion45 = Result.INSTANCE;
                objM12684constructorimpl23 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(LazyItemsView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(LazyItemsView.class);
                    }
                }));
            } catch (Throwable th24) {
                Result.Companion companion46 = Result.INSTANCE;
                objM12684constructorimpl23 = Result.m12684constructorimpl(ResultKt.createFailure(th24));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl23)) {
                objM12684constructorimpl23 = null;
            }
            TypeDescriptor typeDescriptor23 = (TypeDescriptor) objM12684constructorimpl23;
            if (typeDescriptor23 == null) {
                typeDescriptor23 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(LazyItemsView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder10 = new ViewDefinitionBuilder(orCreateKotlinClass12, typeDescriptor23, null, 4, null);
            for (ComposeViewProp composeViewProp10 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(LazyItemsProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder10.getProps().put(composeViewProp10.getName(), composeViewProp10);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder10);
            viewDefinitionBuilder10.Events("onWindowChange");
            viewDefinitionBuilder10.setOnViewDestroys(new Function1<View, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$25$$inlined$OnViewDestroys$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((LazyItemsView) it).cancelPendingWindowChange$expo_ui_release();
                }
            });
            moduleDefinitionBuilder14.registerViewDefinition(viewDefinitionBuilder10.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder15 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(LazyItemsPoolView.class);
            try {
                Result.Companion companion47 = Result.INSTANCE;
                objM12684constructorimpl24 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(LazyItemsPoolView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$default$6
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(LazyItemsPoolView.class);
                    }
                }));
            } catch (Throwable th25) {
                Result.Companion companion48 = Result.INSTANCE;
                objM12684constructorimpl24 = Result.m12684constructorimpl(ResultKt.createFailure(th25));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl24)) {
                objM12684constructorimpl24 = null;
            }
            TypeDescriptor typeDescriptor24 = (TypeDescriptor) objM12684constructorimpl24;
            if (typeDescriptor24 == null) {
                typeDescriptor24 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(LazyItemsPoolView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder11 = new ViewDefinitionBuilder(orCreateKotlinClass13, typeDescriptor24, null, 4, null);
            for (ComposeViewProp composeViewProp11 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(LazyItemsPoolProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder11.getProps().put(composeViewProp11.getName(), composeViewProp11);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder11);
            Unit unit6 = Unit.INSTANCE;
            moduleDefinitionBuilder15.registerViewDefinition(viewDefinitionBuilder11.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder16 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(LazyItemsSlotView.class);
            try {
                Result.Companion companion49 = Result.INSTANCE;
                objM12684constructorimpl25 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(LazyItemsSlotView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$default$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(LazyItemsSlotView.class);
                    }
                }));
            } catch (Throwable th26) {
                Result.Companion companion50 = Result.INSTANCE;
                objM12684constructorimpl25 = Result.m12684constructorimpl(ResultKt.createFailure(th26));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl25)) {
                objM12684constructorimpl25 = null;
            }
            TypeDescriptor typeDescriptor25 = (TypeDescriptor) objM12684constructorimpl25;
            if (typeDescriptor25 == null) {
                typeDescriptor25 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(LazyItemsSlotView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder12 = new ViewDefinitionBuilder(orCreateKotlinClass14, typeDescriptor25, null, 4, null);
            for (ComposeViewProp composeViewProp12 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(LazyItemsSlotProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder12.getProps().put(composeViewProp12.getName(), composeViewProp12);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder12);
            Unit unit7 = Unit.INSTANCE;
            moduleDefinitionBuilder16.registerViewDefinition(viewDefinitionBuilder12.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder17 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(PlainTooltipView.class);
            try {
                Result.Companion companion51 = Result.INSTANCE;
                objM12684constructorimpl26 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(PlainTooltipView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$default$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(PlainTooltipView.class);
                    }
                }));
            } catch (Throwable th27) {
                Result.Companion companion52 = Result.INSTANCE;
                objM12684constructorimpl26 = Result.m12684constructorimpl(ResultKt.createFailure(th27));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl26)) {
                objM12684constructorimpl26 = null;
            }
            TypeDescriptor typeDescriptor26 = (TypeDescriptor) objM12684constructorimpl26;
            if (typeDescriptor26 == null) {
                typeDescriptor26 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(PlainTooltipView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder13 = new ViewDefinitionBuilder(orCreateKotlinClass15, typeDescriptor26, null, 4, null);
            for (ComposeViewProp composeViewProp13 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(PlainTooltipViewProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder13.getProps().put(composeViewProp13.getName(), composeViewProp13);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder13);
            Unit unit8 = Unit.INSTANCE;
            moduleDefinitionBuilder17.registerViewDefinition(viewDefinitionBuilder13.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder18 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(RichTooltipView.class);
            try {
                Result.Companion companion53 = Result.INSTANCE;
                objM12684constructorimpl27 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(RichTooltipView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$default$9
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(RichTooltipView.class);
                    }
                }));
            } catch (Throwable th28) {
                Result.Companion companion54 = Result.INSTANCE;
                objM12684constructorimpl27 = Result.m12684constructorimpl(ResultKt.createFailure(th28));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl27)) {
                objM12684constructorimpl27 = null;
            }
            TypeDescriptor typeDescriptor27 = (TypeDescriptor) objM12684constructorimpl27;
            if (typeDescriptor27 == null) {
                typeDescriptor27 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(RichTooltipView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder14 = new ViewDefinitionBuilder(orCreateKotlinClass16, typeDescriptor27, null, 4, null);
            for (ComposeViewProp composeViewProp14 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(RichTooltipViewProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder14.getProps().put(composeViewProp14.getName(), composeViewProp14);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder14);
            Unit unit9 = Unit.INSTANCE;
            moduleDefinitionBuilder18.registerViewDefinition(viewDefinitionBuilder14.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder19 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass17 = Reflection.getOrCreateKotlinClass(SnackbarView.class);
            try {
                Result.Companion companion55 = Result.INSTANCE;
                objM12684constructorimpl28 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SnackbarView.class, false, null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$$inlined$ComposeView$default$10
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(SnackbarView.class);
                    }
                }));
            } catch (Throwable th29) {
                Result.Companion companion56 = Result.INSTANCE;
                objM12684constructorimpl28 = Result.m12684constructorimpl(ResultKt.createFailure(th29));
            }
            if (Result.m12690isFailureimpl(objM12684constructorimpl28)) {
                objM12684constructorimpl28 = null;
            }
            TypeDescriptor typeDescriptor28 = (TypeDescriptor) objM12684constructorimpl28;
            if (typeDescriptor28 == null) {
                typeDescriptor28 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SnackbarView.class));
            }
            ViewDefinitionBuilder viewDefinitionBuilder15 = new ViewDefinitionBuilder(orCreateKotlinClass17, typeDescriptor28, null, 4, null);
            for (ComposeViewProp composeViewProp15 : PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(SnackbarViewProps.__Pika.__pika$IntrospectionData)).unwrappedProps().values()) {
                viewDefinitionBuilder15.getProps().put(composeViewProp15.getName(), composeViewProp15);
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder15);
            Unit unit10 = Unit.INSTANCE;
            moduleDefinitionBuilder19.registerViewDefinition(viewDefinitionBuilder15.build());
            final ComposeViewBuilderScope composeViewBuilderScope = new ComposeViewBuilderScope("ModalBottomSheetView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ModalBottomSheetViewProps.__Pika.__pika$IntrospectionData)));
            PropertyDelegateProvider<Object, AsyncFunctionHandle<Unit>> propertyDelegateProviderAsyncFunction = composeViewBuilderScope.AsyncFunction();
            KProperty<?>[] kPropertyArr = $$delegatedProperties;
            final Function1 function1 = null;
            final AsyncFunctionHandle<Unit> asyncFunctionHandleProvideDelegate = propertyDelegateProviderAsyncFunction.provideDelegate(null, kPropertyArr[0]);
            final AsyncFunctionHandle<Unit> asyncFunctionHandleProvideDelegate2 = composeViewBuilderScope.AsyncFunction().provideDelegate(null, kPropertyArr[1]);
            final AsyncFunctionHandle<Unit> asyncFunctionHandleProvideDelegate3 = composeViewBuilderScope.AsyncFunction().provideDelegate(null, kPropertyArr[2]);
            final EventHandle eventHandle = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$30$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function1);
                }
            }.provideDelegate(null, kPropertyArr[3]);
            composeViewBuilderScope.Content(ComposableLambdaKt.composableLambdaInstance(-1042687446, true, new Function4<FunctionalComposableScope, ModalBottomSheetViewProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$15$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ModalBottomSheetViewProps modalBottomSheetViewProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, modalBottomSheetViewProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ModalBottomSheetViewProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)236@8252L26,236@8192L86:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1042687446, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:236)");
                    }
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$30$lambda$26 = ExpoUIModule.definition$lambda$180$lambda$30$lambda$26(asyncFunctionHandleProvideDelegate);
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$30$lambda$27 = ExpoUIModule.definition$lambda$180$lambda$30$lambda$27(asyncFunctionHandleProvideDelegate2);
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$30$lambda$28 = ExpoUIModule.definition$lambda$180$lambda$30$lambda$28(asyncFunctionHandleProvideDelegate3);
                    ComposerKt.sourceInformationMarkerStart(composer, -1295253084, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle);
                    final EventHandle<Unit> eventHandle2 = eventHandle;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$15$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$30$lambda$29(eventHandle2), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ModalBottomSheetViewKt.ModalBottomSheetContent(Content, props, asyncFunctionHandleDefinition$lambda$180$lambda$30$lambda$26, asyncFunctionHandleDefinition$lambda$180$lambda$30$lambda$27, asyncFunctionHandleDefinition$lambda$180$lambda$30$lambda$28, (Function0) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112) | (AsyncFunctionHandle.$stable << 6) | (AsyncFunctionHandle.$stable << 9) | (AsyncFunctionHandle.$stable << 12));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope.build());
            ComposeViewBuilderScope composeViewBuilderScope2 = new ComposeViewBuilderScope("SingleChoiceSegmentedButtonRowView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(SingleChoiceSegmentedButtonRowProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope2.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12097getLambda$1241911290$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope2.build());
            ComposeViewBuilderScope composeViewBuilderScope3 = new ComposeViewBuilderScope("MultiChoiceSegmentedButtonRowView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(MultiChoiceSegmentedButtonRowProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope3.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12098getLambda$1435981972$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope3.build());
            final ComposeViewBuilderScope composeViewBuilderScope4 = new ComposeViewBuilderScope("SegmentedButtonView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(SegmentedButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function2 = null;
            final EventHandle eventHandle2 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$35$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope4.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function2);
                }
            }.provideDelegate(null, kPropertyArr[4]);
            final EventHandle eventHandle3 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$35$$inlined$Event$default$2
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope4.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function2);
                }
            }.provideDelegate(null, kPropertyArr[5]);
            composeViewBuilderScope4.Content(ComposableLambdaKt.composableLambdaInstance(1890396607, true, new Function4<FunctionalComposableScope, SegmentedButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$18$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, SegmentedButtonProps segmentedButtonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, segmentedButtonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, SegmentedButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)257@8898L25,257@8925L23,257@8868L81:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1890396607, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:257)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -100025288, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    int i3 = i2 ^ 6;
                    boolean zChangedInstance = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle2);
                    final EventHandle<Unit> eventHandle4 = eventHandle2;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$18$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$35$lambda$33(eventHandle4), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -100024426, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance2 = composer.changedInstance(eventHandle3) | ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4);
                    final EventHandle<GenericEventPayload1<Boolean>> eventHandle5 = eventHandle3;
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function1) new Function1<GenericEventPayload1<Boolean>, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$18$1$2$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(GenericEventPayload1<Boolean> genericEventPayload1) {
                                invoke2(genericEventPayload1);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GenericEventPayload1<Boolean> it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$35$lambda$34(eventHandle5), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    SegmentedButtonViewKt.SegmentedButtonContent(Content, props, function0, (Function1) objRememberedValue2, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope4.build());
            final ComposeViewBuilderScope composeViewBuilderScope5 = new ComposeViewBuilderScope("SwitchView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(SwitchProps.__Pika.__pika$IntrospectionData)));
            final Function1 function3 = null;
            final EventHandle eventHandle4 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$37$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope5.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function3);
                }
            }.provideDelegate(null, kPropertyArr[6]);
            composeViewBuilderScope5.Content(ComposableLambdaKt.composableLambdaInstance(-332136616, true, new Function4<FunctionalComposableScope, SwitchProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$19$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, SwitchProps switchProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, switchProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, SwitchProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)265@9121L55,265@9100L76:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-332136616, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:265)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1355706737, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle4);
                    final EventHandle<CheckedChangeEvent> eventHandle5 = eventHandle4;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<Boolean, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$19$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z2) {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$37$lambda$36(eventHandle5), new CheckedChangeEvent(z2));
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    SwitchViewKt.SwitchContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope5.build());
            final ComposeViewBuilderScope composeViewBuilderScope6 = new ComposeViewBuilderScope("CheckboxView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(CheckboxProps.__Pika.__pika$IntrospectionData)));
            final Function1 function4 = null;
            final EventHandle eventHandle5 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$39$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope6.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function4);
                }
            }.provideDelegate(null, kPropertyArr[7]);
            composeViewBuilderScope6.Content(ComposableLambdaKt.composableLambdaInstance(-857572922, true, new Function4<FunctionalComposableScope, CheckboxProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$20$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, CheckboxProps checkboxProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, checkboxProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, CheckboxProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)273@9354L55,273@9331L78:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-857572922, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:273)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 506144189, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle5);
                    final EventHandle<CheckedChangeEvent> eventHandle6 = eventHandle5;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<Boolean, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$20$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z2) {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$39$lambda$38(eventHandle6), new CheckedChangeEvent(z2));
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    CheckboxViewKt.CheckboxContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope6.build());
            final ComposeViewBuilderScope composeViewBuilderScope7 = new ComposeViewBuilderScope("TriStateCheckboxView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(TriStateCheckboxProps.__Pika.__pika$IntrospectionData)));
            final Function1 function5 = null;
            final EventHandle eventHandle6 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$41$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope7.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function5);
                }
            }.provideDelegate(null, kPropertyArr[8]);
            composeViewBuilderScope7.Content(ComposableLambdaKt.composableLambdaInstance(890802027, true, new Function4<FunctionalComposableScope, TriStateCheckboxProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$21$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, TriStateCheckboxProps triStateCheckboxProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, triStateCheckboxProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, TriStateCheckboxProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)281@9595L23,281@9564L54:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(890802027, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:281)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 1362257666, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle6);
                    final EventHandle<Unit> eventHandle7 = eventHandle6;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$21$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$41$lambda$40(eventHandle7), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    CheckboxViewKt.TriStateCheckboxContent(Content, props, (Function0) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope7.build());
            final ComposeViewBuilderScope composeViewBuilderScope8 = new ComposeViewBuilderScope("Button", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function6 = null;
            final EventHandle eventHandle7 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$43$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope8.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function6);
                }
            }.provideDelegate(null, kPropertyArr[9]);
            composeViewBuilderScope8.Content(ComposableLambdaKt.composableLambdaInstance(-644200717, true, new Function4<FunctionalComposableScope, ButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$22$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, buttonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)289@9786L23,289@9765L44:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-644200717, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:289)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -601597110, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle7);
                    final EventHandle<ButtonPressedEvent> eventHandle8 = eventHandle7;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ButtonPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$22$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ButtonPressedEvent buttonPressedEvent) {
                                invoke2(buttonPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ButtonPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$43$lambda$42(eventHandle8), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ButtonKt.ButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope8.build());
            final ComposeViewBuilderScope composeViewBuilderScope9 = new ComposeViewBuilderScope("FilledTonalButton", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function7 = null;
            final EventHandle eventHandle8 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$45$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope9.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function7);
                }
            }.provideDelegate(null, kPropertyArr[10]);
            composeViewBuilderScope9.Content(ComposableLambdaKt.composableLambdaInstance(-1328431022, true, new Function4<FunctionalComposableScope, ButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$23$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, buttonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)297@9999L23,297@9967L55:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1328431022, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:297)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1016923575, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle8);
                    final EventHandle<ButtonPressedEvent> eventHandle9 = eventHandle8;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ButtonPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$23$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ButtonPressedEvent buttonPressedEvent) {
                                invoke2(buttonPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ButtonPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$45$lambda$44(eventHandle9), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ButtonKt.FilledTonalButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope9.build());
            final ComposeViewBuilderScope composeViewBuilderScope10 = new ComposeViewBuilderScope("OutlinedButton", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function8 = null;
            final EventHandle eventHandle9 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$47$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope10.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function8);
                }
            }.provideDelegate(null, kPropertyArr[11]);
            composeViewBuilderScope10.Content(ComposableLambdaKt.composableLambdaInstance(-2012661327, true, new Function4<FunctionalComposableScope, ButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$24$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, buttonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)305@10206L23,305@10177L52:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2012661327, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:305)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1432250488, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle9);
                    final EventHandle<ButtonPressedEvent> eventHandle10 = eventHandle9;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ButtonPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$24$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ButtonPressedEvent buttonPressedEvent) {
                                invoke2(buttonPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ButtonPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$47$lambda$46(eventHandle10), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ButtonKt.OutlinedButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope10.build());
            final ComposeViewBuilderScope composeViewBuilderScope11 = new ComposeViewBuilderScope("ElevatedButton", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function9 = null;
            final EventHandle eventHandle10 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$49$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope11.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function9);
                }
            }.provideDelegate(null, kPropertyArr[12]);
            composeViewBuilderScope11.Content(ComposableLambdaKt.composableLambdaInstance(-340083325, true, new Function4<FunctionalComposableScope, ButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$25$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, buttonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)313@10413L23,313@10384L52:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-340083325, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:313)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -402559270, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle10);
                    final EventHandle<ButtonPressedEvent> eventHandle11 = eventHandle10;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ButtonPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$25$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ButtonPressedEvent buttonPressedEvent) {
                                invoke2(buttonPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ButtonPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$49$lambda$48(eventHandle11), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ButtonKt.ElevatedButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope11.build());
            final ComposeViewBuilderScope composeViewBuilderScope12 = new ComposeViewBuilderScope("TextButton", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function10 = null;
            final EventHandle eventHandle11 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$51$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope12.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function10);
                }
            }.provideDelegate(null, kPropertyArr[13]);
            composeViewBuilderScope12.Content(ComposableLambdaKt.composableLambdaInstance(-1024313630, true, new Function4<FunctionalComposableScope, ButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$26$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, buttonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)321@10612L23,321@10587L48:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1024313630, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:321)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -817886215, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle11);
                    final EventHandle<ButtonPressedEvent> eventHandle12 = eventHandle11;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ButtonPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$26$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ButtonPressedEvent buttonPressedEvent) {
                                invoke2(buttonPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ButtonPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$51$lambda$50(eventHandle12), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ButtonKt.TextButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope12.build());
            final ComposeViewBuilderScope composeViewBuilderScope13 = new ComposeViewBuilderScope("IconButton", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function11 = null;
            final EventHandle eventHandle12 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$53$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope13.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function11);
                }
            }.provideDelegate(null, kPropertyArr[14]);
            composeViewBuilderScope13.Content(ComposableLambdaKt.composableLambdaInstance(-1708543935, true, new Function4<FunctionalComposableScope, ButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$27$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, buttonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)329@10811L23,329@10786L48:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1708543935, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:329)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1233213032, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle12);
                    final EventHandle<ButtonPressedEvent> eventHandle13 = eventHandle12;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ButtonPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$27$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ButtonPressedEvent buttonPressedEvent) {
                                invoke2(buttonPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ButtonPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$53$lambda$52(eventHandle13), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    IconButtonKt.IconButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope13.build());
            final ComposeViewBuilderScope composeViewBuilderScope14 = new ComposeViewBuilderScope("FilledIconButton", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function12 = null;
            final EventHandle eventHandle13 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$55$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope14.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function12);
                }
            }.provideDelegate(null, kPropertyArr[15]);
            composeViewBuilderScope14.Content(ComposableLambdaKt.composableLambdaInstance(1902193056, true, new Function4<FunctionalComposableScope, ButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$28$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, buttonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)337@11022L23,337@10991L54:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1902193056, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:337)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1648539657, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle13);
                    final EventHandle<ButtonPressedEvent> eventHandle14 = eventHandle13;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ButtonPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$28$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ButtonPressedEvent buttonPressedEvent) {
                                invoke2(buttonPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ButtonPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$55$lambda$54(eventHandle14), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    IconButtonKt.FilledIconButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope14.build());
            final ComposeViewBuilderScope composeViewBuilderScope15 = new ComposeViewBuilderScope("FilledTonalIconButton", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function13 = null;
            final EventHandle eventHandle14 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$57$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope15.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function13);
                }
            }.provideDelegate(null, kPropertyArr[16]);
            composeViewBuilderScope15.Content(ComposableLambdaKt.composableLambdaInstance(1217962751, true, new Function4<FunctionalComposableScope, ButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$29$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, buttonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)345@11243L23,345@11207L59:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1217962751, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:345)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -2063866314, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle14);
                    final EventHandle<ButtonPressedEvent> eventHandle15 = eventHandle14;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ButtonPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$29$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ButtonPressedEvent buttonPressedEvent) {
                                invoke2(buttonPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ButtonPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$57$lambda$56(eventHandle15), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    IconButtonKt.FilledTonalIconButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope15.build());
            final ComposeViewBuilderScope composeViewBuilderScope16 = new ComposeViewBuilderScope("OutlinedIconButton", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function14 = null;
            final EventHandle eventHandle15 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$59$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope16.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function14);
                }
            }.provideDelegate(null, kPropertyArr[17]);
            composeViewBuilderScope16.Content(ComposableLambdaKt.composableLambdaInstance(533732446, true, new Function4<FunctionalComposableScope, ButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$30$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, buttonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)353@11458L23,353@11425L56:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(533732446, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:353)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 1815774069, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle15);
                    final EventHandle<ButtonPressedEvent> eventHandle16 = eventHandle15;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ButtonPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$30$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ButtonPressedEvent buttonPressedEvent) {
                                invoke2(buttonPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ButtonPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$59$lambda$58(eventHandle16), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    IconButtonKt.OutlinedIconButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope16.build());
            ComposeViewBuilderScope composeViewBuilderScope17 = new ComposeViewBuilderScope("SliderView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(SliderProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope17.Events("onValueChange", "onValueChangeFinished");
            composeViewBuilderScope17.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12103getLambda$1929138130$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope17.build());
            ComposeViewBuilderScope composeViewBuilderScope18 = new ComposeViewBuilderScope("VerticalSliderView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(VerticalSliderProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope18.Events("onValueChange", "onValueChangeFinished");
            composeViewBuilderScope18.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1490562231$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope18.build());
            ComposeViewBuilderScope composeViewBuilderScope19 = new ComposeViewBuilderScope("ShapeView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ShapeProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope19.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12105getLambda$2017590506$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope19.build());
            ComposeViewBuilderScope composeViewBuilderScope20 = new ComposeViewBuilderScope("HorizontalDividerView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(DividerProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope20.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$998079677$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope20.build());
            ComposeViewBuilderScope composeViewBuilderScope21 = new ComposeViewBuilderScope("VerticalDividerView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(DividerProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope21.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12096getLambda$1170085145$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope21.build());
            final ComposeViewBuilderScope composeViewBuilderScope22 = new ComposeViewBuilderScope("DateTimePickerView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(DateTimePickerProps.__Pika.__pika$IntrospectionData)));
            final Function1 function15 = null;
            final EventHandle eventHandle16 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$66$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope22.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function15);
                }
            }.provideDelegate(null, kPropertyArr[18]);
            composeViewBuilderScope22.Content(ComposableLambdaKt.composableLambdaInstance(-1530791764, true, new Function4<FunctionalComposableScope, DateTimePickerProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$36$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, DateTimePickerProps dateTimePickerProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, dateTimePickerProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, DateTimePickerProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)395@12414L22,395@12385L51:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1530791764, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:395)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 2082898882, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle16);
                    final EventHandle<DatePickerResult> eventHandle17 = eventHandle16;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<DatePickerResult, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$36$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DatePickerResult datePickerResult) {
                                invoke2(datePickerResult);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DatePickerResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$66$lambda$65(eventHandle17), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    DatePickerViewKt.DateTimePickerContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope22.build());
            final ComposeViewBuilderScope composeViewBuilderScope23 = new ComposeViewBuilderScope("DateRangePickerView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(DateRangePickerProps.__Pika.__pika$IntrospectionData)));
            final Function1 function16 = null;
            final EventHandle eventHandle17 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$68$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope23.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function16);
                }
            }.provideDelegate(null, kPropertyArr[19]);
            composeViewBuilderScope23.Content(ComposableLambdaKt.composableLambdaInstance(-441239647, true, new Function4<FunctionalComposableScope, DateRangePickerProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$37$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, DateRangePickerProps dateRangePickerProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, dateRangePickerProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, DateRangePickerProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)403@12642L27,403@12612L57:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-441239647, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:403)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 1170463132, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle17);
                    final EventHandle<DateRangePickerResult> eventHandle18 = eventHandle17;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<DateRangePickerResult, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$37$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DateRangePickerResult dateRangePickerResult) {
                                invoke2(dateRangePickerResult);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DateRangePickerResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$68$lambda$67(eventHandle18), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    DateRangePickerViewKt.DateRangePickerContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope23.build());
            final ComposeViewBuilderScope composeViewBuilderScope24 = new ComposeViewBuilderScope("DatePickerDialogView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(DatePickerDialogProps.__Pika.__pika$IntrospectionData)));
            final Function1 function17 = null;
            final EventHandle eventHandle18 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$71$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope24.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function17);
                }
            }.provideDelegate(null, kPropertyArr[20]);
            final EventHandle eventHandle19 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$71$$inlined$Event$default$2
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope24.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function17);
                }
            }.provideDelegate(null, kPropertyArr[21]);
            composeViewBuilderScope24.Content(ComposableLambdaKt.composableLambdaInstance(1089005839, true, new Function4<FunctionalComposableScope, DatePickerDialogProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$38$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, DatePickerDialogProps datePickerDialogProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, datePickerDialogProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, DatePickerDialogProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)412@12916L22,412@12940L26,412@12881L86:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1089005839, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:412)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1437407195, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = (i & 14) ^ 6;
                    boolean zChangedInstance = ((i2 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle18);
                    final EventHandle<DatePickerResult> eventHandle20 = eventHandle18;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<DatePickerResult, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$38$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DatePickerResult datePickerResult) {
                                invoke2(datePickerResult);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DatePickerResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$71$lambda$69(eventHandle20), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function18 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -1437406423, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance2 = composer.changedInstance(eventHandle19) | ((i2 > 4 && composer.changedInstance(Content)) || (i & 6) == 4);
                    final EventHandle<Unit> eventHandle21 = eventHandle19;
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$38$1$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$71$lambda$70(eventHandle21), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    DatePickerViewKt.ExpoDatePickerDialogContent(props, function18, (Function0) objRememberedValue2, composer, (i >> 3) & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope24.build());
            final ComposeViewBuilderScope composeViewBuilderScope25 = new ComposeViewBuilderScope("DateRangePickerDialogView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(DateRangePickerDialogProps.__Pika.__pika$IntrospectionData)));
            final Function1 function18 = null;
            final EventHandle eventHandle20 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$74$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope25.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function18);
                }
            }.provideDelegate(null, kPropertyArr[22]);
            final EventHandle eventHandle21 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$74$$inlined$Event$default$2
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope25.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function18);
                }
            }.provideDelegate(null, kPropertyArr[23]);
            composeViewBuilderScope25.Content(ComposableLambdaKt.composableLambdaInstance(-984486409, true, new Function4<FunctionalComposableScope, DateRangePickerDialogProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$39$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, DateRangePickerDialogProps dateRangePickerDialogProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, dateRangePickerDialogProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, DateRangePickerDialogProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)421@13239L27,421@13268L26,421@13199L96:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-984486409, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:421)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1198632014, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = (i & 14) ^ 6;
                    boolean zChangedInstance = ((i2 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle20);
                    final EventHandle<DateRangePickerResult> eventHandle22 = eventHandle20;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<DateRangePickerResult, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$39$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DateRangePickerResult dateRangePickerResult) {
                                invoke2(dateRangePickerResult);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DateRangePickerResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$74$lambda$72(eventHandle22), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function19 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -1198631087, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance2 = composer.changedInstance(eventHandle21) | ((i2 > 4 && composer.changedInstance(Content)) || (i & 6) == 4);
                    final EventHandle<Unit> eventHandle23 = eventHandle21;
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$39$1$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$74$lambda$73(eventHandle23), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    DateRangePickerViewKt.ExpoDateRangePickerDialogContent(props, function19, (Function0) objRememberedValue2, composer, (i >> 3) & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope25.build());
            final ComposeViewBuilderScope composeViewBuilderScope26 = new ComposeViewBuilderScope("TimePickerDialogView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(TimePickerDialogProps.__Pika.__pika$IntrospectionData)));
            final Function1 function19 = null;
            final EventHandle eventHandle22 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$77$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope26.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function19);
                }
            }.provideDelegate(null, kPropertyArr[24]);
            final EventHandle eventHandle23 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$77$$inlined$Event$default$2
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope26.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function19);
                }
            }.provideDelegate(null, kPropertyArr[25]);
            composeViewBuilderScope26.Content(ComposableLambdaKt.composableLambdaInstance(862477646, true, new Function4<FunctionalComposableScope, TimePickerDialogProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$40$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, TimePickerDialogProps timePickerDialogProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, timePickerDialogProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, TimePickerDialogProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)430@13542L22,430@13566L26,430@13507L86:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(862477646, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:430)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -87668572, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = (i & 14) ^ 6;
                    boolean zChangedInstance = ((i2 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle22);
                    final EventHandle<DatePickerResult> eventHandle24 = eventHandle22;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<DatePickerResult, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$40$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DatePickerResult datePickerResult) {
                                invoke2(datePickerResult);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DatePickerResult it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$77$lambda$75(eventHandle24), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function20 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -87667800, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance2 = composer.changedInstance(eventHandle23) | ((i2 > 4 && composer.changedInstance(Content)) || (i & 6) == 4);
                    final EventHandle<Unit> eventHandle25 = eventHandle23;
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$40$1$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$77$lambda$76(eventHandle25), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    DatePickerViewKt.ExpoTimePickerDialogContent(props, function20, (Function0) objRememberedValue2, composer, (i >> 3) & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope26.build());
            final ComposeViewBuilderScope composeViewBuilderScope27 = new ComposeViewBuilderScope("DropdownMenuView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(DropdownMenuProps.__Pika.__pika$IntrospectionData)));
            final Function1 function20 = null;
            final EventHandle eventHandle24 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$79$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope27.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function20);
                }
            }.provideDelegate(null, kPropertyArr[26]);
            composeViewBuilderScope27.Content(ComposableLambdaKt.composableLambdaInstance(-1321514400, true, new Function4<FunctionalComposableScope, DropdownMenuProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$41$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, DropdownMenuProps dropdownMenuProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, dropdownMenuProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, DropdownMenuProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)438@13770L26,438@13743L53:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1321514400, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:438)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 1334982714, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle24);
                    final EventHandle<Unit> eventHandle25 = eventHandle24;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$41$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$79$lambda$78(eventHandle25), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    DropdownMenuKt.DropdownMenuContent(Content, props, (Function0) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope27.build());
            final ComposeViewBuilderScope composeViewBuilderScope28 = new ComposeViewBuilderScope("DropdownMenuItemView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(DropdownMenuItemProps.__Pika.__pika$IntrospectionData)));
            final Function1 function21 = null;
            final EventHandle eventHandle25 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$81$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope28.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function21);
                }
            }.provideDelegate(null, kPropertyArr[27]);
            composeViewBuilderScope28.Content(ComposableLambdaKt.composableLambdaInstance(3656364, true, new Function4<FunctionalComposableScope, DropdownMenuItemProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$42$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, DropdownMenuItemProps dropdownMenuItemProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, dropdownMenuItemProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, DropdownMenuItemProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)446@13982L23,446@13951L54:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(3656364, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:446)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -781199869, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle25);
                    final EventHandle<Unit> eventHandle26 = eventHandle25;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$42$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$81$lambda$80(eventHandle26), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    DropdownMenuItemKt.DropdownMenuItemContent(Content, props, (Function0) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope28.build());
            ComposeViewBuilderScope composeViewBuilderScope29 = new ComposeViewBuilderScope("LoadingIndicatorView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(LoadingIndicatorProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope29.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12104getLambda$1995011557$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope29.build());
            ComposeViewBuilderScope composeViewBuilderScope30 = new ComposeViewBuilderScope("ContainedLoadingIndicatorView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ContainedLoadingIndicatorProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope30.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12110getLambda$960147279$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope30.build());
            ComposeViewBuilderScope composeViewBuilderScope31 = new ComposeViewBuilderScope("LinearProgressIndicatorView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(LinearProgressIndicatorProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope31.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1646521412$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope31.build());
            ComposeViewBuilderScope composeViewBuilderScope32 = new ComposeViewBuilderScope("CircularProgressIndicatorView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(CircularProgressIndicatorProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope32.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1095575517$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope32.build());
            ComposeViewBuilderScope composeViewBuilderScope33 = new ComposeViewBuilderScope("LinearWavyProgressIndicatorView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(LinearWavyProgressIndicatorProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope33.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12099getLambda$1534825169$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope33.build());
            ComposeViewBuilderScope composeViewBuilderScope34 = new ComposeViewBuilderScope("CircularWavyProgressIndicatorView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(CircularWavyProgressIndicatorProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope34.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12107getLambda$735183928$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope34.build());
            ComposeViewBuilderScope composeViewBuilderScope35 = new ComposeViewBuilderScope("BoxView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(LayoutProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope35.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12095getLambda$1165179639$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope35.build());
            ComposeViewBuilderScope composeViewBuilderScope36 = new ComposeViewBuilderScope("RowView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(LayoutProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope36.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12102getLambda$1849409944$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope36.build());
            ComposeViewBuilderScope composeViewBuilderScope37 = new ComposeViewBuilderScope("FlowRowView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(LayoutProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope37.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1761327047$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope37.build());
            ComposeViewBuilderScope composeViewBuilderScope38 = new ComposeViewBuilderScope("ColumnView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(LayoutProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope38.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1077096742$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope38.build());
            ComposeViewBuilderScope composeViewBuilderScope39 = new ComposeViewBuilderScope("TextView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(TextProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope39.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12101getLambda$1804102430$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope39.build());
            final ComposeViewBuilderScope composeViewBuilderScope40 = new ComposeViewBuilderScope("SearchBarView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(SearchBarProps.__Pika.__pika$IntrospectionData)));
            final Function1 function22 = null;
            final EventHandle eventHandle26 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$94$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope40.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function22);
                }
            }.provideDelegate(null, kPropertyArr[28]);
            composeViewBuilderScope40.Content(ComposableLambdaKt.composableLambdaInstance(850321421, true, new Function4<FunctionalComposableScope, SearchBarProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$54$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, SearchBarProps searchBarProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, searchBarProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, SearchBarProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)520@15743L16,520@15719L40:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(850321421, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:520)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 1115100733, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle26);
                    final EventHandle<GenericEventPayload1<String>> eventHandle27 = eventHandle26;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<GenericEventPayload1<String>, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$54$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(GenericEventPayload1<String> genericEventPayload1) {
                                invoke2(genericEventPayload1);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GenericEventPayload1<String> it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$94$lambda$93(eventHandle27), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    SearchBarViewKt.SearchBarContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope40.build());
            final ComposeViewBuilderScope composeViewBuilderScope41 = new ComposeViewBuilderScope("DockedSearchBarView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(DockedSearchBarProps.__Pika.__pika$IntrospectionData)));
            final Function1 function23 = null;
            final EventHandle eventHandle27 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$96$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope41.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function23);
                }
            }.provideDelegate(null, kPropertyArr[29]);
            composeViewBuilderScope41.Content(ComposableLambdaKt.composableLambdaInstance(-229031255, true, new Function4<FunctionalComposableScope, DockedSearchBarProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$55$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, DockedSearchBarProps dockedSearchBarProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, dockedSearchBarProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, DockedSearchBarProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)528@15966L21,528@15936L51:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-229031255, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:528)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1055702370, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle27);
                    final EventHandle<GenericEventPayload1<String>> eventHandle28 = eventHandle27;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<GenericEventPayload1<String>, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$55$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(GenericEventPayload1<String> genericEventPayload1) {
                                invoke2(genericEventPayload1);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GenericEventPayload1<String> it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$96$lambda$95(eventHandle28), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    DockedSearchBarViewKt.DockedSearchBarContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope41.build());
            ComposeViewBuilderScope composeViewBuilderScope42 = new ComposeViewBuilderScope("HorizontalFloatingToolbarView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(HorizontalFloatingToolbarProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope42.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$563811920$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope42.build());
            final ComposeViewBuilderScope composeViewBuilderScope43 = new ComposeViewBuilderScope("PullToRefreshBoxView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(PullToRefreshBoxProps.__Pika.__pika$IntrospectionData)));
            final Function1 function24 = null;
            final EventHandle eventHandle28 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$99$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope43.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function24);
                }
            }.provideDelegate(null, kPropertyArr[30]);
            composeViewBuilderScope43.Content(ComposableLambdaKt.composableLambdaInstance(1465375942, true, new Function4<FunctionalComposableScope, PullToRefreshBoxProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$57$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, PullToRefreshBoxProps pullToRefreshBoxProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, pullToRefreshBoxProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, PullToRefreshBoxProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)542@16339L19,542@16308L50:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1465375942, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:542)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -522991207, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle28);
                    final EventHandle<Unit> eventHandle29 = eventHandle28;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$57$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$99$lambda$98(eventHandle29), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    PullToRefreshBoxViewKt.PullToRefreshBoxContent(Content, props, (Function0) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope43.build());
            final ComposeViewBuilderScope composeViewBuilderScope44 = new ComposeViewBuilderScope("HorizontalPagerView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(HorizontalPagerProps.__Pika.__pika$IntrospectionData)));
            final AsyncFunctionHandle asyncFunctionHandle = (AsyncFunctionHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$107$$inlined$AsyncFunctionWith1Arg$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final AsyncFunctionHandle<Integer> provideDelegate(Object obj8, KProperty<?> property) {
                    Object objM12684constructorimpl29;
                    Object objM12684constructorimpl30;
                    Intrinsics.checkNotNullParameter(property, "property");
                    ComposeViewBuilderScope composeViewBuilderScope45 = composeViewBuilderScope44;
                    String name = property.getName();
                    AnyType[] anyTypeArr10 = new AnyType[2];
                    AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                    if (anyType16 == null) {
                        try {
                            Result.Companion companion57 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$107$$inlined$AsyncFunctionWith1Arg$1.1
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                                }
                            }));
                        } catch (Throwable th30) {
                            Result.Companion companion58 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(ResultKt.createFailure(th30));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl29)) {
                            objM12684constructorimpl29 = null;
                        }
                        TypeDescriptor typeDescriptor29 = (TypeDescriptor) objM12684constructorimpl29;
                        if (typeDescriptor29 == null) {
                            typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                        }
                        anyType16 = new AnyType(typeDescriptor29, null);
                    }
                    anyTypeArr10[0] = anyType16;
                    AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
                    if (anyType17 == null) {
                        try {
                            Result.Companion companion59 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$107$$inlined$AsyncFunctionWith1Arg$1.2
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(Integer.TYPE);
                                }
                            }));
                        } catch (Throwable th31) {
                            Result.Companion companion60 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(ResultKt.createFailure(th31));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl30)) {
                            objM12684constructorimpl30 = null;
                        }
                        TypeDescriptor typeDescriptor30 = (TypeDescriptor) objM12684constructorimpl30;
                        if (typeDescriptor30 == null) {
                            typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                        }
                        anyType17 = new AnyType(typeDescriptor30, null);
                    }
                    anyTypeArr10[1] = anyType17;
                    composeViewBuilderScope45.registerAsyncFunctionWithArgs(name, anyTypeArr10);
                    return new AsyncFunctionHandle<>(property.getName());
                }
            }.provideDelegate(null, kPropertyArr[31]);
            final Function1 function25 = null;
            final AsyncFunctionHandle asyncFunctionHandle2 = (AsyncFunctionHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$107$$inlined$AsyncFunctionWith1Arg$2
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final AsyncFunctionHandle<Integer> provideDelegate(Object obj8, KProperty<?> property) {
                    Object objM12684constructorimpl29;
                    Object objM12684constructorimpl30;
                    Intrinsics.checkNotNullParameter(property, "property");
                    ComposeViewBuilderScope composeViewBuilderScope45 = composeViewBuilderScope44;
                    String name = property.getName();
                    AnyType[] anyTypeArr10 = new AnyType[2];
                    AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                    if (anyType16 == null) {
                        try {
                            Result.Companion companion57 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$107$$inlined$AsyncFunctionWith1Arg$2.1
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                                }
                            }));
                        } catch (Throwable th30) {
                            Result.Companion companion58 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(ResultKt.createFailure(th30));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl29)) {
                            objM12684constructorimpl29 = null;
                        }
                        TypeDescriptor typeDescriptor29 = (TypeDescriptor) objM12684constructorimpl29;
                        if (typeDescriptor29 == null) {
                            typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                        }
                        anyType16 = new AnyType(typeDescriptor29, null);
                    }
                    anyTypeArr10[0] = anyType16;
                    AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
                    if (anyType17 == null) {
                        try {
                            Result.Companion companion59 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$107$$inlined$AsyncFunctionWith1Arg$2.2
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(Integer.TYPE);
                                }
                            }));
                        } catch (Throwable th31) {
                            Result.Companion companion60 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(ResultKt.createFailure(th31));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl30)) {
                            objM12684constructorimpl30 = null;
                        }
                        TypeDescriptor typeDescriptor30 = (TypeDescriptor) objM12684constructorimpl30;
                        if (typeDescriptor30 == null) {
                            typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                        }
                        anyType17 = new AnyType(typeDescriptor30, null);
                    }
                    anyTypeArr10[1] = anyType17;
                    composeViewBuilderScope45.registerAsyncFunctionWithArgs(name, anyTypeArr10);
                    return new AsyncFunctionHandle<>(property.getName());
                }
            }.provideDelegate(null, kPropertyArr[32]);
            final EventHandle eventHandle29 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$107$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope44.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function25);
                }
            }.provideDelegate(null, kPropertyArr[33]);
            final EventHandle eventHandle30 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$107$$inlined$Event$default$2
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope44.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function25);
                }
            }.provideDelegate(null, kPropertyArr[34]);
            final EventHandle eventHandle31 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$107$$inlined$Event$default$3
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope44.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function25);
                }
            }.provideDelegate(null, kPropertyArr[35]);
            final EventHandle eventHandle32 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$107$$inlined$Event$default$4
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope44.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function25);
                }
            }.provideDelegate(null, kPropertyArr[36]);
            final EventHandle eventHandle33 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$107$$inlined$Event$default$5
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope44.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function25);
                }
            }.provideDelegate(null, kPropertyArr[37]);
            composeViewBuilderScope44.Content(ComposableLambdaKt.composableLambdaInstance(-1031968928, true, new Function4<FunctionalComposableScope, HorizontalPagerProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$58$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, HorizontalPagerProps horizontalPagerProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, horizontalPagerProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, HorizontalPagerProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)560@17136L27,561@17197L27,562@17251L20,563@17310L32,564@17374L25,556@16963L446:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1031968928, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:556)");
                    }
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$107$lambda$100 = ExpoUIModule.definition$lambda$180$lambda$107$lambda$100(asyncFunctionHandle);
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$107$lambda$101 = ExpoUIModule.definition$lambda$180$lambda$107$lambda$101(asyncFunctionHandle2);
                    ComposerKt.sourceInformationMarkerStart(composer, 415311739, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    int i3 = i2 ^ 6;
                    boolean zChangedInstance = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle29);
                    final EventHandle<HorizontalPagerCurrentPageChangeEvent> eventHandle34 = eventHandle29;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<HorizontalPagerCurrentPageChangeEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$58$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(HorizontalPagerCurrentPageChangeEvent horizontalPagerCurrentPageChangeEvent) {
                                invoke2(horizontalPagerCurrentPageChangeEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(HorizontalPagerCurrentPageChangeEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$107$lambda$102(eventHandle34), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function26 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 415313691, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance2 = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle30);
                    final EventHandle<HorizontalPagerSettledPageChangeEvent> eventHandle35 = eventHandle30;
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function1) new Function1<HorizontalPagerSettledPageChangeEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$58$1$2$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(HorizontalPagerSettledPageChangeEvent horizontalPagerSettledPageChangeEvent) {
                                invoke2(horizontalPagerSettledPageChangeEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(HorizontalPagerSettledPageChangeEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$107$lambda$103(eventHandle35), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function27 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 415315412, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance3 = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle31);
                    final EventHandle<HorizontalPagerPageScrollEvent> eventHandle36 = eventHandle31;
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = (Function1) new Function1<HorizontalPagerPageScrollEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$58$1$3$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(HorizontalPagerPageScrollEvent horizontalPagerPageScrollEvent) {
                                invoke2(horizontalPagerPageScrollEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(HorizontalPagerPageScrollEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$107$lambda$104(eventHandle36), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    Function1 function28 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 415317312, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance4 = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle32);
                    final EventHandle<HorizontalPagerScrollInProgressChangeEvent> eventHandle37 = eventHandle32;
                    Object objRememberedValue4 = composer.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = (Function1) new Function1<HorizontalPagerScrollInProgressChangeEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$58$1$4$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(HorizontalPagerScrollInProgressChangeEvent horizontalPagerScrollInProgressChangeEvent) {
                                invoke2(horizontalPagerScrollInProgressChangeEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(HorizontalPagerScrollInProgressChangeEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$107$lambda$105(eventHandle37), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function29 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 415319353, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance5 = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle33);
                    final EventHandle<HorizontalPagerDragInteractionEvent> eventHandle38 = eventHandle33;
                    Object objRememberedValue5 = composer.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<HorizontalPagerDragInteractionEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$58$1$5$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(HorizontalPagerDragInteractionEvent horizontalPagerDragInteractionEvent) {
                                invoke2(horizontalPagerDragInteractionEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(HorizontalPagerDragInteractionEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$107$lambda$106(eventHandle38), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    HorizontalPagerViewKt.HorizontalPagerContent(Content, props, asyncFunctionHandleDefinition$lambda$180$lambda$107$lambda$100, asyncFunctionHandleDefinition$lambda$180$lambda$107$lambda$101, function26, function27, function28, function29, (Function1) objRememberedValue5, composer, FunctionalComposableScope.$stable | i2 | (i & 112) | (AsyncFunctionHandle.$stable << 6) | (AsyncFunctionHandle.$stable << 9));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope44.build());
            ComposeViewBuilderScope composeViewBuilderScope45 = new ComposeViewBuilderScope("HorizontalCenteredHeroCarouselView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(HorizontalCenteredHeroCarouselProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope45.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$903165218$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope45.build());
            ComposeViewBuilderScope composeViewBuilderScope46 = new ComposeViewBuilderScope("HorizontalMultiBrowseCarouselView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(HorizontalMultiBrowseCarouselProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope46.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1904832126$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope46.build());
            ComposeViewBuilderScope composeViewBuilderScope47 = new ComposeViewBuilderScope("HorizontalUncontainedCarouselView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(HorizontalUncontainedCarouselProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope47.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$281543974$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope47.build());
            final ComposeViewBuilderScope composeViewBuilderScope48 = new ComposeViewBuilderScope("AlertDialogView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(AlertDialogProps.__Pika.__pika$IntrospectionData)));
            final Function1 function26 = null;
            final EventHandle eventHandle34 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$112$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope48.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function26);
                }
            }.provideDelegate(null, kPropertyArr[38]);
            composeViewBuilderScope48.Content(ComposableLambdaKt.composableLambdaInstance(-919912201, true, new Function4<FunctionalComposableScope, AlertDialogProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$62$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, AlertDialogProps alertDialogProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, alertDialogProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, AlertDialogProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)591@18132L26,591@18106L52:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-919912201, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:591)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 727639281, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle34);
                    final EventHandle<Unit> eventHandle35 = eventHandle34;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$62$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$112$lambda$111(eventHandle35), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    AlertDialogViewKt.AlertDialogContent(Content, props, (Function0) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope48.build());
            final ComposeViewBuilderScope composeViewBuilderScope49 = new ComposeViewBuilderScope("AssistChipView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(AssistChipProps.__Pika.__pika$IntrospectionData)));
            final Function1 function27 = null;
            final EventHandle eventHandle35 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$114$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope49.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function27);
                }
            }.provideDelegate(null, kPropertyArr[39]);
            composeViewBuilderScope49.Content(ComposableLambdaKt.composableLambdaInstance(1655015675, true, new Function4<FunctionalComposableScope, AssistChipProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$63$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, AssistChipProps assistChipProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, assistChipProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, AssistChipProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)599@18338L21,599@18313L46:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1655015675, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:599)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 1332165584, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle35);
                    final EventHandle<ChipPressedEvent> eventHandle36 = eventHandle35;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ChipPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$63$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ChipPressedEvent chipPressedEvent) {
                                invoke2(chipPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ChipPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$114$lambda$113(eventHandle36), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ChipViewKt.AssistChipContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope49.build());
            final ComposeViewBuilderScope composeViewBuilderScope50 = new ComposeViewBuilderScope("InputChipView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(InputChipProps.__Pika.__pika$IntrospectionData)));
            final Function1 function28 = null;
            final EventHandle eventHandle36 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$116$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope50.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function28);
                }
            }.provideDelegate(null, kPropertyArr[40]);
            composeViewBuilderScope50.Content(ComposableLambdaKt.composableLambdaInstance(-622366397, true, new Function4<FunctionalComposableScope, InputChipProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$64$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, InputChipProps inputChipProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, inputChipProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, InputChipProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)607@18536L21,607@18512L45:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-622366397, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:607)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1093651976, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle36);
                    final EventHandle<ChipPressedEvent> eventHandle37 = eventHandle36;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ChipPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$64$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ChipPressedEvent chipPressedEvent) {
                                invoke2(chipPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ChipPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$116$lambda$115(eventHandle37), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ChipViewKt.InputChipContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope50.build());
            final ComposeViewBuilderScope composeViewBuilderScope51 = new ComposeViewBuilderScope("SuggestionChipView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(SuggestionChipProps.__Pika.__pika$IntrospectionData)));
            final Function1 function29 = null;
            final EventHandle eventHandle37 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$118$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope51.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function29);
                }
            }.provideDelegate(null, kPropertyArr[41]);
            composeViewBuilderScope51.Content(ComposableLambdaKt.composableLambdaInstance(86495113, true, new Function4<FunctionalComposableScope, SuggestionChipProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$65$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, SuggestionChipProps suggestionChipProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, suggestionChipProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, SuggestionChipProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)615@18749L21,615@18720L50:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(86495113, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:615)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 1517426526, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle37);
                    final EventHandle<ChipPressedEvent> eventHandle38 = eventHandle37;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ChipPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$65$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ChipPressedEvent chipPressedEvent) {
                                invoke2(chipPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ChipPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$118$lambda$117(eventHandle38), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ChipViewKt.SuggestionChipContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope51.build());
            final ComposeViewBuilderScope composeViewBuilderScope52 = new ComposeViewBuilderScope("FilterChipView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(FilterChipProps.__Pika.__pika$IntrospectionData)));
            final Function1 function30 = null;
            final EventHandle eventHandle38 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$120$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope52.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function30);
                }
            }.provideDelegate(null, kPropertyArr[42]);
            composeViewBuilderScope52.Content(ComposableLambdaKt.composableLambdaInstance(1544122484, true, new Function4<FunctionalComposableScope, FilterChipProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$66$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, FilterChipProps filterChipProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, filterChipProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, FilterChipProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)623@18950L21,623@18925L46:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1544122484, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:623)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 2137991433, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle38);
                    final EventHandle<ChipPressedEvent> eventHandle39 = eventHandle38;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ChipPressedEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$66$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ChipPressedEvent chipPressedEvent) {
                                invoke2(chipPressedEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ChipPressedEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$120$lambda$119(eventHandle39), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ChipViewKt.FilterChipContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope52.build());
            final ComposeViewBuilderScope composeViewBuilderScope53 = new ComposeViewBuilderScope("ToggleButton", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ToggleButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function31 = null;
            final EventHandle eventHandle39 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$122$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope53.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function31);
                }
            }.provideDelegate(null, kPropertyArr[43]);
            composeViewBuilderScope53.Content(ComposableLambdaKt.composableLambdaInstance(43211537, true, new Function4<FunctionalComposableScope, ToggleButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$67$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ToggleButtonProps toggleButtonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, toggleButtonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ToggleButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)631@19167L23,631@19140L50:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(43211537, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:631)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1423384408, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle39);
                    final EventHandle<ToggleButtonValueChangeEvent> eventHandle40 = eventHandle39;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ToggleButtonValueChangeEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$67$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ToggleButtonValueChangeEvent toggleButtonValueChangeEvent) {
                                invoke2(toggleButtonValueChangeEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ToggleButtonValueChangeEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$122$lambda$121(eventHandle40), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ToggleButtonViewKt.ToggleButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope53.build());
            final ComposeViewBuilderScope composeViewBuilderScope54 = new ComposeViewBuilderScope("IconToggleButton", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ToggleButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function32 = null;
            final EventHandle eventHandle40 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$124$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope54.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function32);
                }
            }.provideDelegate(null, kPropertyArr[44]);
            composeViewBuilderScope54.Content(ComposableLambdaKt.composableLambdaInstance(-641018768, true, new Function4<FunctionalComposableScope, ToggleButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$68$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ToggleButtonProps toggleButtonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, toggleButtonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ToggleButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)639@19394L23,639@19363L54:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-641018768, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:639)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1838711097, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle40);
                    final EventHandle<ToggleButtonValueChangeEvent> eventHandle41 = eventHandle40;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ToggleButtonValueChangeEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$68$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ToggleButtonValueChangeEvent toggleButtonValueChangeEvent) {
                                invoke2(toggleButtonValueChangeEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ToggleButtonValueChangeEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$124$lambda$123(eventHandle41), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ToggleButtonViewKt.IconToggleButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope54.build());
            final ComposeViewBuilderScope composeViewBuilderScope55 = new ComposeViewBuilderScope("FilledIconToggleButton", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ToggleButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function33 = null;
            final EventHandle eventHandle41 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$126$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope55.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function33);
                }
            }.provideDelegate(null, kPropertyArr[45]);
            composeViewBuilderScope55.Content(ComposableLambdaKt.composableLambdaInstance(-1325249073, true, new Function4<FunctionalComposableScope, ToggleButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$69$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ToggleButtonProps toggleButtonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, toggleButtonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ToggleButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)647@19633L23,647@19596L60:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1325249073, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:647)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 2040929574, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle41);
                    final EventHandle<ToggleButtonValueChangeEvent> eventHandle42 = eventHandle41;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ToggleButtonValueChangeEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$69$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ToggleButtonValueChangeEvent toggleButtonValueChangeEvent) {
                                invoke2(toggleButtonValueChangeEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ToggleButtonValueChangeEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$126$lambda$125(eventHandle42), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ToggleButtonViewKt.FilledIconToggleButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope55.build());
            final ComposeViewBuilderScope composeViewBuilderScope56 = new ComposeViewBuilderScope("OutlinedIconToggleButton", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ToggleButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function34 = null;
            final EventHandle eventHandle42 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$128$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope56.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function34);
                }
            }.provideDelegate(null, kPropertyArr[46]);
            composeViewBuilderScope56.Content(ComposableLambdaKt.composableLambdaInstance(-2009479378, true, new Function4<FunctionalComposableScope, ToggleButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$70$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ToggleButtonProps toggleButtonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, toggleButtonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ToggleButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)655@19876L23,655@19837L62:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2009479378, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:655)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 1625602821, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle42);
                    final EventHandle<ToggleButtonValueChangeEvent> eventHandle43 = eventHandle42;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<ToggleButtonValueChangeEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$70$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ToggleButtonValueChangeEvent toggleButtonValueChangeEvent) {
                                invoke2(toggleButtonValueChangeEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ToggleButtonValueChangeEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$128$lambda$127(eventHandle43), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ToggleButtonViewKt.OutlinedIconToggleButtonContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope56.build());
            ComposeViewBuilderScope composeViewBuilderScope57 = new ComposeViewBuilderScope("CardView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(CardProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope57.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12109getLambda$942321949$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope57.build());
            ComposeViewBuilderScope composeViewBuilderScope58 = new ComposeViewBuilderScope("ElevatedCardView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ElevatedCardProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope58.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12106getLambda$246732488$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope58.build());
            ComposeViewBuilderScope composeViewBuilderScope59 = new ComposeViewBuilderScope("OutlinedCardView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(OutlinedCardProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope59.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12100getLambda$177762593$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope59.build());
            ComposeViewBuilderScope composeViewBuilderScope60 = new ComposeViewBuilderScope("ListItemView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ListItemProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope60.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.m12108getLambda$842361441$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope60.build());
            ComposeViewBuilderScope composeViewBuilderScope61 = new ComposeViewBuilderScope("BadgeView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(BadgeProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope61.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$611968097$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope61.build());
            ComposeViewBuilderScope composeViewBuilderScope62 = new ComposeViewBuilderScope("BadgedBoxView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(BadgedBoxProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope62.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$456477465$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope62.build());
            ComposeViewBuilderScope composeViewBuilderScope63 = new ComposeViewBuilderScope("NavigationBarView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(NavigationBarProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope63.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1135598819$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope63.build());
            final ComposeViewBuilderScope composeViewBuilderScope64 = new ComposeViewBuilderScope("NavigationBarItemView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(NavigationBarItemProps.__Pika.__pika$IntrospectionData)));
            final Function1 function35 = null;
            final EventHandle eventHandle43 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$137$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope64.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function35);
                }
            }.provideDelegate(null, kPropertyArr[47]);
            composeViewBuilderScope64.Content(ComposableLambdaKt.composableLambdaInstance(-1260460113, true, new Function4<FunctionalComposableScope, NavigationBarItemProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$78$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, NavigationBarItemProps navigationBarItemProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, navigationBarItemProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, NavigationBarItemProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)705@20944L25,705@20912L57:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1260460113, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:705)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -121389464, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle43);
                    final EventHandle<Unit> eventHandle44 = eventHandle43;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$78$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$137$lambda$136(eventHandle44), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    NavigationBarViewKt.NavigationBarItemContent(Content, props, (Function0) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope64.build());
            ComposeViewBuilderScope composeViewBuilderScope65 = new ComposeViewBuilderScope("SpacerView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(SpacerProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope65.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$746128202$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope65.build());
            final ComposeViewBuilderScope composeViewBuilderScope66 = new ComposeViewBuilderScope("BasicAlertDialogView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(BasicAlertDialogProps.__Pika.__pika$IntrospectionData)));
            final Function1 function36 = null;
            final EventHandle eventHandle44 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$140$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope66.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function36);
                }
            }.provideDelegate(null, kPropertyArr[48]);
            composeViewBuilderScope66.Content(ComposableLambdaKt.composableLambdaInstance(77359391, true, new Function4<FunctionalComposableScope, BasicAlertDialogProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$80$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, BasicAlertDialogProps basicAlertDialogProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, basicAlertDialogProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, BasicAlertDialogProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)719@21271L26,719@21240L57:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(77359391, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:719)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, 1327932345, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle44);
                    final EventHandle<Unit> eventHandle45 = eventHandle44;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$80$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$140$lambda$139(eventHandle45), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    BasicAlertDialogViewKt.BasicAlertDialogContent(Content, props, (Function0) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope66.build());
            final ComposeViewBuilderScope composeViewBuilderScope67 = new ComposeViewBuilderScope("SurfaceView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(SurfaceProps.__Pika.__pika$IntrospectionData)));
            final Function1 function37 = null;
            final EventHandle eventHandle45 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$143$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope67.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function37);
                }
            }.provideDelegate(null, kPropertyArr[49]);
            final EventHandle eventHandle46 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$143$$inlined$Event$default$2
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope67.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function37);
                }
            }.provideDelegate(null, kPropertyArr[50]);
            composeViewBuilderScope67.Content(ComposableLambdaKt.composableLambdaInstance(656496913, true, new Function4<FunctionalComposableScope, SurfaceProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$81$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, SurfaceProps surfaceProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, surfaceProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, SurfaceProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)728@21535L24,728@21579L45,728@21503L122:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(656496913, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:728)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -466657463, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    int i3 = i2 ^ 6;
                    boolean zChangedInstance = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle45);
                    final EventHandle<Unit> eventHandle47 = eventHandle45;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$81$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$143$lambda$141(eventHandle47), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -466656034, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance2 = composer.changedInstance(eventHandle46) | ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4);
                    final EventHandle<GenericEventPayload1<Boolean>> eventHandle48 = eventHandle46;
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function1) new Function1<Boolean, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$81$1$2$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z2) {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$143$lambda$142(eventHandle48), new GenericEventPayload1(Boolean.valueOf(z2)));
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    SurfaceViewKt.SurfaceContent(Content, props, function0, (Function1) objRememberedValue2, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope67.build());
            ComposeViewBuilderScope composeViewBuilderScope68 = new ComposeViewBuilderScope("AnimatedVisibilityView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(AnimatedVisibilityProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope68.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1911113438$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope68.build());
            final ComposeViewBuilderScope composeViewBuilderScope69 = new ComposeViewBuilderScope("SnackbarHostView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(SnackbarHostProps.__Pika.__pika$IntrospectionData)));
            final AsyncFunctionHandle asyncFunctionHandle3 = (AsyncFunctionHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$146$$inlined$AsyncFunctionWith1Arg$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final AsyncFunctionHandle<SnackbarShowOptions> provideDelegate(Object obj8, KProperty<?> property) {
                    Object objM12684constructorimpl29;
                    Object objM12684constructorimpl30;
                    Intrinsics.checkNotNullParameter(property, "property");
                    ComposeViewBuilderScope composeViewBuilderScope70 = composeViewBuilderScope69;
                    String name = property.getName();
                    AnyType[] anyTypeArr10 = new AnyType[2];
                    AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                    if (anyType16 == null) {
                        try {
                            Result.Companion companion57 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$146$$inlined$AsyncFunctionWith1Arg$1.1
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                                }
                            }));
                        } catch (Throwable th30) {
                            Result.Companion companion58 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(ResultKt.createFailure(th30));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl29)) {
                            objM12684constructorimpl29 = null;
                        }
                        TypeDescriptor typeDescriptor29 = (TypeDescriptor) objM12684constructorimpl29;
                        if (typeDescriptor29 == null) {
                            typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                        }
                        anyType16 = new AnyType(typeDescriptor29, null);
                    }
                    anyTypeArr10[0] = anyType16;
                    AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SnackbarShowOptions.class), false));
                    if (anyType17 == null) {
                        try {
                            Result.Companion companion59 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateConcrete(SnackbarShowOptions.class, false, SnackbarShowOptions.__Pika.__pika$IntrospectionData)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$146$$inlined$AsyncFunctionWith1Arg$1.2
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(SnackbarShowOptions.class);
                                }
                            }));
                        } catch (Throwable th31) {
                            Result.Companion companion60 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(ResultKt.createFailure(th31));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl30)) {
                            objM12684constructorimpl30 = null;
                        }
                        TypeDescriptor typeDescriptor30 = (TypeDescriptor) objM12684constructorimpl30;
                        if (typeDescriptor30 == null) {
                            typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(SnackbarShowOptions.class));
                        }
                        anyType17 = new AnyType(typeDescriptor30, null);
                    }
                    anyTypeArr10[1] = anyType17;
                    composeViewBuilderScope70.registerAsyncFunctionWithArgs(name, anyTypeArr10);
                    return new AsyncFunctionHandle<>(property.getName());
                }
            }.provideDelegate(null, kPropertyArr[51]);
            composeViewBuilderScope69.Content(ComposableLambdaKt.composableLambdaInstance(-1273873851, true, new Function4<FunctionalComposableScope, SnackbarHostProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$83$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, SnackbarHostProps snackbarHostProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, snackbarHostProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(FunctionalComposableScope Content, SnackbarHostProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)742@21943L40:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1273873851, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:742)");
                    }
                    SnackbarViewKt.SnackbarHostContent(Content, props, ExpoUIModule.definition$lambda$180$lambda$146$lambda$145(asyncFunctionHandle3), composer, (i & 112) | FunctionalComposableScope.$stable | (i & 14) | (AsyncFunctionHandle.$stable << 6));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope69.build());
            ComposeViewBuilderScope composeViewBuilderScope70 = new ComposeViewBuilderScope("TooltipBoxView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(TooltipBoxViewProps.__Pika.__pika$IntrospectionData)));
            final AsyncFunctionHandle<Unit> asyncFunctionHandleProvideDelegate4 = composeViewBuilderScope70.AsyncFunction().provideDelegate(null, kPropertyArr[52]);
            final AsyncFunctionHandle<Unit> asyncFunctionHandleProvideDelegate5 = composeViewBuilderScope70.AsyncFunction().provideDelegate(null, kPropertyArr[53]);
            composeViewBuilderScope70.Content(ComposableLambdaKt.composableLambdaInstance(-2032960604, true, new Function4<FunctionalComposableScope, TooltipBoxViewProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$84$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, TooltipBoxViewProps tooltipBoxViewProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, tooltipBoxViewProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(FunctionalComposableScope Content, TooltipBoxViewProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)751@22160L39:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2032960604, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:751)");
                    }
                    TooltipViewKt.TooltipBoxContent(Content, props, ExpoUIModule.definition$lambda$180$lambda$149$lambda$147(asyncFunctionHandleProvideDelegate4), ExpoUIModule.definition$lambda$180$lambda$149$lambda$148(asyncFunctionHandleProvideDelegate5), composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112) | (AsyncFunctionHandle.$stable << 6) | (AsyncFunctionHandle.$stable << 9));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope70.build());
            final ComposeViewBuilderScope composeViewBuilderScope71 = new ComposeViewBuilderScope("TextFieldView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(TextFieldProps.__Pika.__pika$IntrospectionData)));
            final AsyncFunctionHandle asyncFunctionHandle4 = (AsyncFunctionHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$159$$inlined$AsyncFunctionWith1Arg$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final AsyncFunctionHandle<String> provideDelegate(Object obj8, KProperty<?> property) {
                    Object objM12684constructorimpl29;
                    Object objM12684constructorimpl30;
                    Intrinsics.checkNotNullParameter(property, "property");
                    ComposeViewBuilderScope composeViewBuilderScope72 = composeViewBuilderScope71;
                    String name = property.getName();
                    AnyType[] anyTypeArr10 = new AnyType[2];
                    AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                    if (anyType16 == null) {
                        try {
                            Result.Companion companion57 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$159$$inlined$AsyncFunctionWith1Arg$1.1
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                                }
                            }));
                        } catch (Throwable th30) {
                            Result.Companion companion58 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(ResultKt.createFailure(th30));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl29)) {
                            objM12684constructorimpl29 = null;
                        }
                        TypeDescriptor typeDescriptor29 = (TypeDescriptor) objM12684constructorimpl29;
                        if (typeDescriptor29 == null) {
                            typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                        }
                        anyType16 = new AnyType(typeDescriptor29, null);
                    }
                    anyTypeArr10[0] = anyType16;
                    AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                    if (anyType17 == null) {
                        try {
                            Result.Companion companion59 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$159$$inlined$AsyncFunctionWith1Arg$1.2
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(String.class);
                                }
                            }));
                        } catch (Throwable th31) {
                            Result.Companion companion60 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(ResultKt.createFailure(th31));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl30)) {
                            objM12684constructorimpl30 = null;
                        }
                        TypeDescriptor typeDescriptor30 = (TypeDescriptor) objM12684constructorimpl30;
                        if (typeDescriptor30 == null) {
                            typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                        }
                        anyType17 = new AnyType(typeDescriptor30, null);
                    }
                    anyTypeArr10[1] = anyType17;
                    composeViewBuilderScope72.registerAsyncFunctionWithArgs(name, anyTypeArr10);
                    return new AsyncFunctionHandle<>(property.getName());
                }
            }.provideDelegate(null, kPropertyArr[54]);
            final Function1 function38 = null;
            final AsyncFunctionHandle2 asyncFunctionHandle5 = (AsyncFunctionHandle2) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$159$$inlined$AsyncFunctionWith2Args$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final AsyncFunctionHandle2<Integer, Integer> provideDelegate(Object obj8, KProperty<?> property) {
                    Object objM12684constructorimpl29;
                    Object objM12684constructorimpl30;
                    Object objM12684constructorimpl31;
                    Intrinsics.checkNotNullParameter(property, "property");
                    ComposeViewBuilderScope composeViewBuilderScope72 = composeViewBuilderScope71;
                    String name = property.getName();
                    AnyType[] anyTypeArr10 = new AnyType[3];
                    AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                    if (anyType16 == null) {
                        try {
                            Result.Companion companion57 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$159$$inlined$AsyncFunctionWith2Args$1.1
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                                }
                            }));
                        } catch (Throwable th30) {
                            Result.Companion companion58 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(ResultKt.createFailure(th30));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl29)) {
                            objM12684constructorimpl29 = null;
                        }
                        TypeDescriptor typeDescriptor29 = (TypeDescriptor) objM12684constructorimpl29;
                        if (typeDescriptor29 == null) {
                            typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                        }
                        anyType16 = new AnyType(typeDescriptor29, null);
                    }
                    anyTypeArr10[0] = anyType16;
                    AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
                    if (anyType17 == null) {
                        try {
                            Result.Companion companion59 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$159$$inlined$AsyncFunctionWith2Args$1.2
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(Integer.TYPE);
                                }
                            }));
                        } catch (Throwable th31) {
                            Result.Companion companion60 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(ResultKt.createFailure(th31));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl30)) {
                            objM12684constructorimpl30 = null;
                        }
                        TypeDescriptor typeDescriptor30 = (TypeDescriptor) objM12684constructorimpl30;
                        if (typeDescriptor30 == null) {
                            typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                        }
                        anyType17 = new AnyType(typeDescriptor30, null);
                    }
                    anyTypeArr10[1] = anyType17;
                    AnyType anyType18 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
                    if (anyType18 == null) {
                        try {
                            Result.Companion companion61 = Result.INSTANCE;
                            objM12684constructorimpl31 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$159$$inlined$AsyncFunctionWith2Args$1.3
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(Integer.TYPE);
                                }
                            }));
                        } catch (Throwable th32) {
                            Result.Companion companion62 = Result.INSTANCE;
                            objM12684constructorimpl31 = Result.m12684constructorimpl(ResultKt.createFailure(th32));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl31)) {
                            objM12684constructorimpl31 = null;
                        }
                        TypeDescriptor typeDescriptor31 = (TypeDescriptor) objM12684constructorimpl31;
                        if (typeDescriptor31 == null) {
                            typeDescriptor31 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                        }
                        anyType18 = new AnyType(typeDescriptor31, null);
                    }
                    anyTypeArr10[2] = anyType18;
                    composeViewBuilderScope72.registerAsyncFunctionWithArgs(name, anyTypeArr10);
                    return new AsyncFunctionHandle2<>(property.getName());
                }
            }.provideDelegate(null, kPropertyArr[55]);
            final AsyncFunctionHandle<Unit> asyncFunctionHandleProvideDelegate6 = composeViewBuilderScope71.AsyncFunction().provideDelegate(null, kPropertyArr[56]);
            final AsyncFunctionHandle<Unit> asyncFunctionHandleProvideDelegate7 = composeViewBuilderScope71.AsyncFunction().provideDelegate(null, kPropertyArr[57]);
            final AsyncFunctionHandle<Unit> asyncFunctionHandleProvideDelegate8 = composeViewBuilderScope71.AsyncFunction().provideDelegate(null, kPropertyArr[58]);
            final EventHandle eventHandle47 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$159$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope71.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function38);
                }
            }.provideDelegate(null, kPropertyArr[59]);
            final EventHandle eventHandle48 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$159$$inlined$Event$default$2
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope71.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function38);
                }
            }.provideDelegate(null, kPropertyArr[60]);
            final EventHandle eventHandle49 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$159$$inlined$Event$default$3
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope71.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function38);
                }
            }.provideDelegate(null, kPropertyArr[61]);
            final EventHandle eventHandle50 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$159$$inlined$Event$default$4
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope71.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function38);
                }
            }.provideDelegate(null, kPropertyArr[62]);
            composeViewBuilderScope71.Content(ComposableLambdaKt.composableLambdaInstance(80170744, true, new Function4<FunctionalComposableScope, TextFieldProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$85$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, TextFieldProps textFieldProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, textFieldProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, TextFieldProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)774@22905L21,775@22954L22,776@23016L24,777@23073L25,767@22750L358:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(80170744, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:767)");
                    }
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$159$lambda$150 = ExpoUIModule.definition$lambda$180$lambda$159$lambda$150(asyncFunctionHandle4);
                    AsyncFunctionHandle2 asyncFunctionHandle2Definition$lambda$180$lambda$159$lambda$151 = ExpoUIModule.definition$lambda$180$lambda$159$lambda$151(asyncFunctionHandle5);
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$159$lambda$152 = ExpoUIModule.definition$lambda$180$lambda$159$lambda$152(asyncFunctionHandleProvideDelegate6);
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$159$lambda$153 = ExpoUIModule.definition$lambda$180$lambda$159$lambda$153(asyncFunctionHandleProvideDelegate7);
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$159$lambda$154 = ExpoUIModule.definition$lambda$180$lambda$159$lambda$154(asyncFunctionHandleProvideDelegate8);
                    ComposerKt.sourceInformationMarkerStart(composer, -265320755, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    int i3 = i2 ^ 6;
                    boolean zChangedInstance = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle47);
                    final EventHandle<TextFieldValuePayload> eventHandle51 = eventHandle47;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<TextFieldValuePayload, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$85$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValuePayload textFieldValuePayload) {
                                invoke2(textFieldValuePayload);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValuePayload it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$159$lambda$155(eventHandle51), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function39 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -265319186, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance2 = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle48);
                    final EventHandle<GenericEventPayload1<Boolean>> eventHandle52 = eventHandle48;
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function1) new Function1<GenericEventPayload1<Boolean>, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$85$1$2$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(GenericEventPayload1<Boolean> genericEventPayload1) {
                                invoke2(genericEventPayload1);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GenericEventPayload1<Boolean> it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$159$lambda$156(eventHandle52), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function40 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -265317200, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance3 = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle49);
                    final EventHandle<KeyboardActionEvent> eventHandle53 = eventHandle49;
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = (Function1) new Function1<KeyboardActionEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$85$1$3$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionEvent keyboardActionEvent) {
                                invoke2(keyboardActionEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(KeyboardActionEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$159$lambda$157(eventHandle53), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    Function1 function41 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -265315375, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance4 = composer.changedInstance(eventHandle50) | ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4);
                    final EventHandle<TextFieldSelectionPayload> eventHandle54 = eventHandle50;
                    Object objRememberedValue4 = composer.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = (Function1) new Function1<TextFieldSelectionPayload, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$85$1$4$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldSelectionPayload textFieldSelectionPayload) {
                                invoke2(textFieldSelectionPayload);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldSelectionPayload it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$159$lambda$158(eventHandle54), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TextFieldKt.TextFieldContent(Content, props, asyncFunctionHandleDefinition$lambda$180$lambda$159$lambda$150, asyncFunctionHandle2Definition$lambda$180$lambda$159$lambda$151, asyncFunctionHandleDefinition$lambda$180$lambda$159$lambda$152, asyncFunctionHandleDefinition$lambda$180$lambda$159$lambda$153, asyncFunctionHandleDefinition$lambda$180$lambda$159$lambda$154, function39, function40, function41, (Function1) objRememberedValue4, composer, FunctionalComposableScope.$stable | i2 | (i & 112) | (AsyncFunctionHandle.$stable << 6) | (AsyncFunctionHandle2.$stable << 9) | (AsyncFunctionHandle.$stable << 12) | (AsyncFunctionHandle.$stable << 15) | (AsyncFunctionHandle.$stable << 18), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope71.build());
            final ComposeViewBuilderScope composeViewBuilderScope72 = new ComposeViewBuilderScope("BasicTextFieldView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(BasicTextFieldProps.__Pika.__pika$IntrospectionData)));
            final AsyncFunctionHandle asyncFunctionHandle6 = (AsyncFunctionHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$169$$inlined$AsyncFunctionWith1Arg$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final AsyncFunctionHandle<String> provideDelegate(Object obj8, KProperty<?> property) {
                    Object objM12684constructorimpl29;
                    Object objM12684constructorimpl30;
                    Intrinsics.checkNotNullParameter(property, "property");
                    ComposeViewBuilderScope composeViewBuilderScope73 = composeViewBuilderScope72;
                    String name = property.getName();
                    AnyType[] anyTypeArr10 = new AnyType[2];
                    AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                    if (anyType16 == null) {
                        try {
                            Result.Companion companion57 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$169$$inlined$AsyncFunctionWith1Arg$1.1
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                                }
                            }));
                        } catch (Throwable th30) {
                            Result.Companion companion58 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(ResultKt.createFailure(th30));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl29)) {
                            objM12684constructorimpl29 = null;
                        }
                        TypeDescriptor typeDescriptor29 = (TypeDescriptor) objM12684constructorimpl29;
                        if (typeDescriptor29 == null) {
                            typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                        }
                        anyType16 = new AnyType(typeDescriptor29, null);
                    }
                    anyTypeArr10[0] = anyType16;
                    AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                    if (anyType17 == null) {
                        try {
                            Result.Companion companion59 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.STRING), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$169$$inlined$AsyncFunctionWith1Arg$1.2
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(String.class);
                                }
                            }));
                        } catch (Throwable th31) {
                            Result.Companion companion60 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(ResultKt.createFailure(th31));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl30)) {
                            objM12684constructorimpl30 = null;
                        }
                        TypeDescriptor typeDescriptor30 = (TypeDescriptor) objM12684constructorimpl30;
                        if (typeDescriptor30 == null) {
                            typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(String.class));
                        }
                        anyType17 = new AnyType(typeDescriptor30, null);
                    }
                    anyTypeArr10[1] = anyType17;
                    composeViewBuilderScope73.registerAsyncFunctionWithArgs(name, anyTypeArr10);
                    return new AsyncFunctionHandle<>(property.getName());
                }
            }.provideDelegate(null, kPropertyArr[63]);
            final Function1 function39 = null;
            final AsyncFunctionHandle2 asyncFunctionHandle7 = (AsyncFunctionHandle2) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$169$$inlined$AsyncFunctionWith2Args$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final AsyncFunctionHandle2<Integer, Integer> provideDelegate(Object obj8, KProperty<?> property) {
                    Object objM12684constructorimpl29;
                    Object objM12684constructorimpl30;
                    Object objM12684constructorimpl31;
                    Intrinsics.checkNotNullParameter(property, "property");
                    ComposeViewBuilderScope composeViewBuilderScope73 = composeViewBuilderScope72;
                    String name = property.getName();
                    AnyType[] anyTypeArr10 = new AnyType[3];
                    AnyType anyType16 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ComposeFunctionHolder.class), false));
                    if (anyType16 == null) {
                        try {
                            Result.Companion companion57 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.getOrCreateParameterized(ComposeFunctionHolder.class, false, Arrays.asList(PTypeDescriptorRegistry.getOrCreateConcrete(ComposeProps.class, false, null)), null)), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$169$$inlined$AsyncFunctionWith2Args$1.1
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class)));
                                }
                            }));
                        } catch (Throwable th30) {
                            Result.Companion companion58 = Result.INSTANCE;
                            objM12684constructorimpl29 = Result.m12684constructorimpl(ResultKt.createFailure(th30));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl29)) {
                            objM12684constructorimpl29 = null;
                        }
                        TypeDescriptor typeDescriptor29 = (TypeDescriptor) objM12684constructorimpl29;
                        if (typeDescriptor29 == null) {
                            typeDescriptor29 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(ComposeFunctionHolder.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(ComposeProps.class))));
                        }
                        anyType16 = new AnyType(typeDescriptor29, null);
                    }
                    anyTypeArr10[0] = anyType16;
                    AnyType anyType17 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
                    if (anyType17 == null) {
                        try {
                            Result.Companion companion59 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$169$$inlined$AsyncFunctionWith2Args$1.2
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(Integer.TYPE);
                                }
                            }));
                        } catch (Throwable th31) {
                            Result.Companion companion60 = Result.INSTANCE;
                            objM12684constructorimpl30 = Result.m12684constructorimpl(ResultKt.createFailure(th31));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl30)) {
                            objM12684constructorimpl30 = null;
                        }
                        TypeDescriptor typeDescriptor30 = (TypeDescriptor) objM12684constructorimpl30;
                        if (typeDescriptor30 == null) {
                            typeDescriptor30 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                        }
                        anyType17 = new AnyType(typeDescriptor30, null);
                    }
                    anyTypeArr10[1] = anyType17;
                    AnyType anyType18 = AnyTypeCache.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
                    if (anyType18 == null) {
                        try {
                            Result.Companion companion61 = Result.INSTANCE;
                            objM12684constructorimpl31 = Result.m12684constructorimpl(new TypeDescriptor(TypeDescriptorOfKt.toRawTypeDescriptor(PTypeDescriptorRegistry.INT), new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$169$$inlined$AsyncFunctionWith2Args$1.3
                                @Override // kotlin.jvm.functions.Function0
                                public final KType invoke() {
                                    return Reflection.typeOf(Integer.TYPE);
                                }
                            }));
                        } catch (Throwable th32) {
                            Result.Companion companion62 = Result.INSTANCE;
                            objM12684constructorimpl31 = Result.m12684constructorimpl(ResultKt.createFailure(th32));
                        }
                        if (Result.m12690isFailureimpl(objM12684constructorimpl31)) {
                            objM12684constructorimpl31 = null;
                        }
                        TypeDescriptor typeDescriptor31 = (TypeDescriptor) objM12684constructorimpl31;
                        if (typeDescriptor31 == null) {
                            typeDescriptor31 = TypeDescriptorKt.toTypeDescriptor(Reflection.typeOf(Integer.TYPE));
                        }
                        anyType18 = new AnyType(typeDescriptor31, null);
                    }
                    anyTypeArr10[2] = anyType18;
                    composeViewBuilderScope73.registerAsyncFunctionWithArgs(name, anyTypeArr10);
                    return new AsyncFunctionHandle2<>(property.getName());
                }
            }.provideDelegate(null, kPropertyArr[64]);
            final AsyncFunctionHandle<Unit> asyncFunctionHandleProvideDelegate9 = composeViewBuilderScope72.AsyncFunction().provideDelegate(null, kPropertyArr[65]);
            final AsyncFunctionHandle<Unit> asyncFunctionHandleProvideDelegate10 = composeViewBuilderScope72.AsyncFunction().provideDelegate(null, kPropertyArr[66]);
            final AsyncFunctionHandle<Unit> asyncFunctionHandleProvideDelegate11 = composeViewBuilderScope72.AsyncFunction().provideDelegate(null, kPropertyArr[67]);
            final EventHandle eventHandle51 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$169$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope72.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function39);
                }
            }.provideDelegate(null, kPropertyArr[68]);
            final EventHandle eventHandle52 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$169$$inlined$Event$default$2
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope72.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function39);
                }
            }.provideDelegate(null, kPropertyArr[69]);
            final EventHandle eventHandle53 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$169$$inlined$Event$default$3
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope72.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function39);
                }
            }.provideDelegate(null, kPropertyArr[70]);
            final EventHandle eventHandle54 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$169$$inlined$Event$default$4
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope72.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function39);
                }
            }.provideDelegate(null, kPropertyArr[71]);
            composeViewBuilderScope72.Content(ComposableLambdaKt.composableLambdaInstance(2116790075, true, new Function4<FunctionalComposableScope, BasicTextFieldProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$86$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, BasicTextFieldProps basicTextFieldProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, basicTextFieldProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, BasicTextFieldProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)801@23829L21,802@23878L22,803@23940L24,804@23997L25,794@23669L363:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2116790075, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:794)");
                    }
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$169$lambda$160 = ExpoUIModule.definition$lambda$180$lambda$169$lambda$160(asyncFunctionHandle6);
                    AsyncFunctionHandle2 asyncFunctionHandle2Definition$lambda$180$lambda$169$lambda$161 = ExpoUIModule.definition$lambda$180$lambda$169$lambda$161(asyncFunctionHandle7);
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$169$lambda$162 = ExpoUIModule.definition$lambda$180$lambda$169$lambda$162(asyncFunctionHandleProvideDelegate9);
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$169$lambda$163 = ExpoUIModule.definition$lambda$180$lambda$169$lambda$163(asyncFunctionHandleProvideDelegate10);
                    AsyncFunctionHandle asyncFunctionHandleDefinition$lambda$180$lambda$169$lambda$164 = ExpoUIModule.definition$lambda$180$lambda$169$lambda$164(asyncFunctionHandleProvideDelegate11);
                    ComposerKt.sourceInformationMarkerStart(composer, -1579230480, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    int i3 = i2 ^ 6;
                    boolean zChangedInstance = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle51);
                    final EventHandle<TextFieldValuePayload> eventHandle55 = eventHandle51;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<TextFieldValuePayload, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$86$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValuePayload textFieldValuePayload) {
                                invoke2(textFieldValuePayload);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValuePayload it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$169$lambda$165(eventHandle55), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function40 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -1579228911, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance2 = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle52);
                    final EventHandle<GenericEventPayload1<Boolean>> eventHandle56 = eventHandle52;
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function1) new Function1<GenericEventPayload1<Boolean>, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$86$1$2$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(GenericEventPayload1<Boolean> genericEventPayload1) {
                                invoke2(genericEventPayload1);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GenericEventPayload1<Boolean> it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$169$lambda$166(eventHandle56), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function41 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -1579226925, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance3 = ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle53);
                    final EventHandle<KeyboardActionEvent> eventHandle57 = eventHandle53;
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = (Function1) new Function1<KeyboardActionEvent, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$86$1$3$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionEvent keyboardActionEvent) {
                                invoke2(keyboardActionEvent);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(KeyboardActionEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$169$lambda$167(eventHandle57), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    Function1 function42 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -1579225100, "CC(remember):ExpoUIModule.kt#9igjgp");
                    boolean zChangedInstance4 = composer.changedInstance(eventHandle54) | ((i3 > 4 && composer.changedInstance(Content)) || (i & 6) == 4);
                    final EventHandle<TextFieldSelectionPayload> eventHandle58 = eventHandle54;
                    Object objRememberedValue4 = composer.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = (Function1) new Function1<TextFieldSelectionPayload, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$86$1$4$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldSelectionPayload textFieldSelectionPayload) {
                                invoke2(textFieldSelectionPayload);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldSelectionPayload it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$169$lambda$168(eventHandle58), it);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    BasicTextFieldKt.BasicTextFieldContent(Content, props, asyncFunctionHandleDefinition$lambda$180$lambda$169$lambda$160, asyncFunctionHandle2Definition$lambda$180$lambda$169$lambda$161, asyncFunctionHandleDefinition$lambda$180$lambda$169$lambda$162, asyncFunctionHandleDefinition$lambda$180$lambda$169$lambda$163, asyncFunctionHandleDefinition$lambda$180$lambda$169$lambda$164, function40, function41, function42, (Function1) objRememberedValue4, composer, FunctionalComposableScope.$stable | i2 | (i & 112) | (AsyncFunctionHandle.$stable << 6) | (AsyncFunctionHandle2.$stable << 9) | (AsyncFunctionHandle.$stable << 12) | (AsyncFunctionHandle.$stable << 15) | (AsyncFunctionHandle.$stable << 18), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope72.build());
            final ComposeViewBuilderScope composeViewBuilderScope73 = new ComposeViewBuilderScope("RadioButtonView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(RadioButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function40 = null;
            final EventHandle eventHandle55 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$171$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope73.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function40);
                }
            }.provideDelegate(null, kPropertyArr[72]);
            composeViewBuilderScope73.Content(ComposableLambdaKt.composableLambdaInstance(716193078, true, new Function4<FunctionalComposableScope, RadioButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$87$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, RadioButtonProps radioButtonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, radioButtonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, RadioButtonProps props, Composer composer, int i) {
                    Function0 function0;
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)818@24307L39:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(716193078, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:813)");
                    }
                    if (props.getClickable()) {
                        composer.startReplaceGroup(-1289479843);
                        ComposerKt.sourceInformation(composer, "814@24231L25");
                        ComposerKt.sourceInformationMarkerStart(composer, 1066782895, "CC(remember):ExpoUIModule.kt#9igjgp");
                        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle55);
                        final EventHandle<Unit> eventHandle56 = eventHandle55;
                        Object objRememberedValue = composer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$87$1$clickHandler$1$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    Content.invoke(ExpoUIModule.definition$lambda$180$lambda$171$lambda$170(eventHandle56), Unit.INSTANCE);
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue);
                        }
                        function0 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(-1289427918);
                        composer.endReplaceGroup();
                        function0 = null;
                    }
                    RadioButtonViewKt.RadioButtonContent(Content, props, function0, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope73.build());
            final ComposeViewBuilderScope composeViewBuilderScope74 = new ComposeViewBuilderScope("FloatingActionButtonView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(FloatingActionButtonProps.__Pika.__pika$IntrospectionData)));
            final Function1 function41 = null;
            final EventHandle eventHandle56 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$173$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope74.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function41);
                }
            }.provideDelegate(null, kPropertyArr[73]);
            composeViewBuilderScope74.Content(ComposableLambdaKt.composableLambdaInstance(-1539262230, true, new Function4<FunctionalComposableScope, FloatingActionButtonProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$88$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, FloatingActionButtonProps floatingActionButtonProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, floatingActionButtonProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, FloatingActionButtonProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)826@24546L25,826@24511L60:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1539262230, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:826)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1762251453, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle56);
                    final EventHandle<Unit> eventHandle57 = eventHandle56;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$88$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$173$lambda$172(eventHandle57), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    FloatingActionButtonKt.FloatingActionButtonContent(Content, props, (Function0) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope74.build());
            ComposeViewBuilderScope composeViewBuilderScope75 = new ComposeViewBuilderScope("SyncSwitchView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(SyncSwitchProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope75.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$967322728$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope75.build());
            final ComposeViewBuilderScope composeViewBuilderScope76 = new ComposeViewBuilderScope("ExposedDropdownMenuBoxView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ExposedDropdownMenuBoxProps.__Pika.__pika$IntrospectionData)));
            final Function1 function42 = null;
            final EventHandle eventHandle57 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$176$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope76.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function42);
                }
            }.provideDelegate(null, kPropertyArr[74]);
            composeViewBuilderScope76.Content(ComposableLambdaKt.composableLambdaInstance(1442187291, true, new Function4<FunctionalComposableScope, ExposedDropdownMenuBoxProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$90$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ExposedDropdownMenuBoxProps exposedDropdownMenuBoxProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, exposedDropdownMenuBoxProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ExposedDropdownMenuBoxProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)841@25024L46,841@24987L83:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1442187291, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:841)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1332448119, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle57);
                    final EventHandle<GenericEventPayload1<Boolean>> eventHandle58 = eventHandle57;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<Boolean, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$90$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z2) {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$176$lambda$175(eventHandle58), new GenericEventPayload1(Boolean.valueOf(z2)));
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ExposedDropdownMenuBoxViewKt.ExposedDropdownMenuBoxContent(Content, props, (Function1) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope76.build());
            final ComposeViewBuilderScope composeViewBuilderScope77 = new ComposeViewBuilderScope("ExposedDropdownMenuView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(ExposedDropdownMenuProps.__Pika.__pika$IntrospectionData)));
            final Function1 function43 = null;
            final EventHandle eventHandle58 = (EventHandle) new PropertyDelegateProvider() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$180$lambda$178$$inlined$Event$default$1
                @Override // kotlin.properties.PropertyDelegateProvider
                public /* bridge */ /* synthetic */ Object provideDelegate(Object obj8, KProperty kProperty) {
                    return provideDelegate(obj8, (KProperty<?>) kProperty);
                }

                @Override // kotlin.properties.PropertyDelegateProvider
                public final EventHandle<T> provideDelegate(Object obj8, KProperty<?> property) {
                    Intrinsics.checkNotNullParameter(property, "property");
                    composeViewBuilderScope77.getEventNames().add(property.getName());
                    return new EventHandle<>(property.getName(), function43);
                }
            }.provideDelegate(null, kPropertyArr[75]);
            composeViewBuilderScope77.Content(ComposableLambdaKt.composableLambdaInstance(-125143025, true, new Function4<FunctionalComposableScope, ExposedDropdownMenuProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$91$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ExposedDropdownMenuProps exposedDropdownMenuProps, Composer composer, Integer num) {
                    invoke(functionalComposableScope, exposedDropdownMenuProps, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final FunctionalComposableScope Content, ExposedDropdownMenuProps props, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(Content, "$this$Content");
                    Intrinsics.checkNotNullParameter(props, "props");
                    ComposerKt.sourceInformation(composer, "CN(props)849@25268L26,849@25234L60:ExpoUIModule.kt#v15e7d");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-125143025, i, -1, "expo.modules.ui.ExpoUIModule.definition.<anonymous>.<anonymous>.<anonymous> (ExpoUIModule.kt:849)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -3361015, "CC(remember):ExpoUIModule.kt#9igjgp");
                    int i2 = i & 14;
                    boolean zChangedInstance = (((i2 ^ 6) > 4 && composer.changedInstance(Content)) || (i & 6) == 4) | composer.changedInstance(eventHandle58);
                    final EventHandle<Unit> eventHandle59 = eventHandle58;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$91$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Content.invoke(ExpoUIModule.definition$lambda$180$lambda$178$lambda$177(eventHandle59), Unit.INSTANCE);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ExposedDropdownMenuViewKt.ExposedDropdownMenuContent(Content, props, (Function0) objRememberedValue, composer, FunctionalComposableScope.$stable | i2 | (i & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope77.build());
            ComposeViewBuilderScope composeViewBuilderScope78 = new ComposeViewBuilderScope("MaskView", PropsParsingStrategy.Introspection.m11979boximpl(PropsParsingStrategy.Introspection.m11980constructorimpl(MaskViewProps.__Pika.__pika$IntrospectionData)));
            composeViewBuilderScope78.Content(ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1078930691$expo_ui_release());
            moduleDefinitionBuilder.registerViewDefinition(composeViewBuilderScope78.build());
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th30) {
            Trace.endSection();
            throw th30;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Unit> definition$lambda$180$lambda$30$lambda$26(AsyncFunctionHandle<Unit> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Unit> definition$lambda$180$lambda$30$lambda$27(AsyncFunctionHandle<Unit> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Unit> definition$lambda$180$lambda$30$lambda$28(AsyncFunctionHandle<Unit> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$30$lambda$29(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[3]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$35$lambda$33(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[4]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<GenericEventPayload1<Boolean>> definition$lambda$180$lambda$35$lambda$34(EventHandle<GenericEventPayload1<Boolean>> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[5]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<CheckedChangeEvent> definition$lambda$180$lambda$37$lambda$36(EventHandle<CheckedChangeEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[6]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<CheckedChangeEvent> definition$lambda$180$lambda$39$lambda$38(EventHandle<CheckedChangeEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[7]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$41$lambda$40(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[8]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ButtonPressedEvent> definition$lambda$180$lambda$43$lambda$42(EventHandle<ButtonPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[9]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ButtonPressedEvent> definition$lambda$180$lambda$45$lambda$44(EventHandle<ButtonPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[10]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ButtonPressedEvent> definition$lambda$180$lambda$47$lambda$46(EventHandle<ButtonPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[11]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ButtonPressedEvent> definition$lambda$180$lambda$49$lambda$48(EventHandle<ButtonPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[12]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ButtonPressedEvent> definition$lambda$180$lambda$51$lambda$50(EventHandle<ButtonPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[13]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ButtonPressedEvent> definition$lambda$180$lambda$53$lambda$52(EventHandle<ButtonPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[14]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ButtonPressedEvent> definition$lambda$180$lambda$55$lambda$54(EventHandle<ButtonPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[15]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ButtonPressedEvent> definition$lambda$180$lambda$57$lambda$56(EventHandle<ButtonPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[16]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ButtonPressedEvent> definition$lambda$180$lambda$59$lambda$58(EventHandle<ButtonPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[17]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<DatePickerResult> definition$lambda$180$lambda$66$lambda$65(EventHandle<DatePickerResult> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[18]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<DateRangePickerResult> definition$lambda$180$lambda$68$lambda$67(EventHandle<DateRangePickerResult> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[19]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<DatePickerResult> definition$lambda$180$lambda$71$lambda$69(EventHandle<DatePickerResult> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[20]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$71$lambda$70(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[21]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<DateRangePickerResult> definition$lambda$180$lambda$74$lambda$72(EventHandle<DateRangePickerResult> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[22]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$74$lambda$73(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[23]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<DatePickerResult> definition$lambda$180$lambda$77$lambda$75(EventHandle<DatePickerResult> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[24]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$77$lambda$76(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[25]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$79$lambda$78(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[26]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$81$lambda$80(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[27]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<GenericEventPayload1<String>> definition$lambda$180$lambda$94$lambda$93(EventHandle<GenericEventPayload1<String>> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[28]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<GenericEventPayload1<String>> definition$lambda$180$lambda$96$lambda$95(EventHandle<GenericEventPayload1<String>> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[29]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$99$lambda$98(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[30]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Integer> definition$lambda$180$lambda$107$lambda$100(AsyncFunctionHandle<Integer> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[31]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Integer> definition$lambda$180$lambda$107$lambda$101(AsyncFunctionHandle<Integer> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[32]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<HorizontalPagerCurrentPageChangeEvent> definition$lambda$180$lambda$107$lambda$102(EventHandle<HorizontalPagerCurrentPageChangeEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[33]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<HorizontalPagerSettledPageChangeEvent> definition$lambda$180$lambda$107$lambda$103(EventHandle<HorizontalPagerSettledPageChangeEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[34]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<HorizontalPagerPageScrollEvent> definition$lambda$180$lambda$107$lambda$104(EventHandle<HorizontalPagerPageScrollEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[35]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<HorizontalPagerScrollInProgressChangeEvent> definition$lambda$180$lambda$107$lambda$105(EventHandle<HorizontalPagerScrollInProgressChangeEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[36]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<HorizontalPagerDragInteractionEvent> definition$lambda$180$lambda$107$lambda$106(EventHandle<HorizontalPagerDragInteractionEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[37]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$112$lambda$111(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[38]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ChipPressedEvent> definition$lambda$180$lambda$114$lambda$113(EventHandle<ChipPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[39]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ChipPressedEvent> definition$lambda$180$lambda$116$lambda$115(EventHandle<ChipPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[40]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ChipPressedEvent> definition$lambda$180$lambda$118$lambda$117(EventHandle<ChipPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[41]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ChipPressedEvent> definition$lambda$180$lambda$120$lambda$119(EventHandle<ChipPressedEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[42]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ToggleButtonValueChangeEvent> definition$lambda$180$lambda$122$lambda$121(EventHandle<ToggleButtonValueChangeEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[43]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ToggleButtonValueChangeEvent> definition$lambda$180$lambda$124$lambda$123(EventHandle<ToggleButtonValueChangeEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[44]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ToggleButtonValueChangeEvent> definition$lambda$180$lambda$126$lambda$125(EventHandle<ToggleButtonValueChangeEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[45]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<ToggleButtonValueChangeEvent> definition$lambda$180$lambda$128$lambda$127(EventHandle<ToggleButtonValueChangeEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[46]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$137$lambda$136(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[47]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$140$lambda$139(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[48]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$143$lambda$141(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[49]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<GenericEventPayload1<Boolean>> definition$lambda$180$lambda$143$lambda$142(EventHandle<GenericEventPayload1<Boolean>> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[50]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<SnackbarShowOptions> definition$lambda$180$lambda$146$lambda$145(AsyncFunctionHandle<SnackbarShowOptions> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[51]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Unit> definition$lambda$180$lambda$149$lambda$147(AsyncFunctionHandle<Unit> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[52]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Unit> definition$lambda$180$lambda$149$lambda$148(AsyncFunctionHandle<Unit> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[53]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<String> definition$lambda$180$lambda$159$lambda$150(AsyncFunctionHandle<String> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[54]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle2<Integer, Integer> definition$lambda$180$lambda$159$lambda$151(AsyncFunctionHandle2<Integer, Integer> asyncFunctionHandle2) {
        return asyncFunctionHandle2.getValue(null, $$delegatedProperties[55]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Unit> definition$lambda$180$lambda$159$lambda$152(AsyncFunctionHandle<Unit> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[56]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Unit> definition$lambda$180$lambda$159$lambda$153(AsyncFunctionHandle<Unit> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[57]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Unit> definition$lambda$180$lambda$159$lambda$154(AsyncFunctionHandle<Unit> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[58]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<TextFieldValuePayload> definition$lambda$180$lambda$159$lambda$155(EventHandle<TextFieldValuePayload> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[59]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<GenericEventPayload1<Boolean>> definition$lambda$180$lambda$159$lambda$156(EventHandle<GenericEventPayload1<Boolean>> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[60]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<KeyboardActionEvent> definition$lambda$180$lambda$159$lambda$157(EventHandle<KeyboardActionEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[61]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<TextFieldSelectionPayload> definition$lambda$180$lambda$159$lambda$158(EventHandle<TextFieldSelectionPayload> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[62]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<String> definition$lambda$180$lambda$169$lambda$160(AsyncFunctionHandle<String> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[63]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle2<Integer, Integer> definition$lambda$180$lambda$169$lambda$161(AsyncFunctionHandle2<Integer, Integer> asyncFunctionHandle2) {
        return asyncFunctionHandle2.getValue(null, $$delegatedProperties[64]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Unit> definition$lambda$180$lambda$169$lambda$162(AsyncFunctionHandle<Unit> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[65]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Unit> definition$lambda$180$lambda$169$lambda$163(AsyncFunctionHandle<Unit> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[66]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncFunctionHandle<Unit> definition$lambda$180$lambda$169$lambda$164(AsyncFunctionHandle<Unit> asyncFunctionHandle) {
        return asyncFunctionHandle.getValue(null, $$delegatedProperties[67]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<TextFieldValuePayload> definition$lambda$180$lambda$169$lambda$165(EventHandle<TextFieldValuePayload> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[68]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<GenericEventPayload1<Boolean>> definition$lambda$180$lambda$169$lambda$166(EventHandle<GenericEventPayload1<Boolean>> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[69]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<KeyboardActionEvent> definition$lambda$180$lambda$169$lambda$167(EventHandle<KeyboardActionEvent> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[70]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<TextFieldSelectionPayload> definition$lambda$180$lambda$169$lambda$168(EventHandle<TextFieldSelectionPayload> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[71]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$171$lambda$170(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[72]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$173$lambda$172(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[73]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<GenericEventPayload1<Boolean>> definition$lambda$180$lambda$176$lambda$175(EventHandle<GenericEventPayload1<Boolean>> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[74]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventHandle<Unit> definition$lambda$180$lambda$178$lambda$177(EventHandle<Unit> eventHandle) {
        return eventHandle.getValue(null, $$delegatedProperties[75]);
    }
}
