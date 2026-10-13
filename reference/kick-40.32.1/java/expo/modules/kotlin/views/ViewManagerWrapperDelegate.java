package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ViewManager;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.events.KModuleEventEmitterWrapperKt;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.OnViewDidUpdatePropsException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.fabric.NativeStatePropsGetter;
import expo.modules.kotlin.types.ConverterContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewManagerWrapperDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020$J\u000e\u0010*\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030+J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070-2\u0006\u0010)\u001a\u00020$2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020(2\u0006\u0010)\u001a\u00020$J\u000e\u00101\u001a\u00020(2\u0006\u0010)\u001a\u00020$J\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u001bR\u001e\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001c0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00063"}, d2 = {"Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;", "", "moduleHolder", "Lexpo/modules/kotlin/ModuleHolder;", "definition", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "delegateName", "", "<init>", "(Lexpo/modules/kotlin/ModuleHolder;Lexpo/modules/kotlin/views/ViewManagerDefinition;Ljava/lang/String;)V", "getModuleHolder$expo_modules_core_release", "()Lexpo/modules/kotlin/ModuleHolder;", "setModuleHolder$expo_modules_core_release", "(Lexpo/modules/kotlin/ModuleHolder;)V", "getDefinition$expo_modules_core_release", "()Lexpo/modules/kotlin/views/ViewManagerDefinition;", "getDelegateName$expo_modules_core_release", "()Ljava/lang/String;", "viewGroupDefinition", "Lexpo/modules/kotlin/views/ViewGroupDefinition;", "getViewGroupDefinition$expo_modules_core_release", "()Lexpo/modules/kotlin/views/ViewGroupDefinition;", "name", "getName", "viewManagerName", "getViewManagerName", "props", "", "Lexpo/modules/kotlin/views/AnyViewProp;", "getProps", "()Ljava/util/Map;", "hasStateProps", "", "getHasStateProps", "()Z", "createView", "Landroid/view/View;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "onViewDidUpdateProps", "", "view", "toRNViewManager", "Lcom/facebook/react/uimanager/ViewManager;", "updateProperties", "", "propsMap", "Lcom/facebook/react/bridge/ReadableMap;", "updateStateProps", "onDestroy", "getExportedCustomDirectEventTypeConstants", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ViewManagerWrapperDelegate {
    public static final int $stable = 8;
    private final ViewManagerDefinition definition;
    private final String delegateName;
    private final boolean hasStateProps;
    private ModuleHolder<?> moduleHolder;

    /* JADX INFO: compiled from: ViewManagerWrapperDelegate.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ViewManagerType.values().length];
            try {
                iArr[ViewManagerType.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ViewManagerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ViewManagerWrapperDelegate(ModuleHolder<?> moduleHolder, ViewManagerDefinition definition, String str) {
        Intrinsics.checkNotNullParameter(moduleHolder, "moduleHolder");
        Intrinsics.checkNotNullParameter(definition, "definition");
        this.moduleHolder = moduleHolder;
        this.definition = definition;
        this.delegateName = str;
        Collection<AnyViewProp> collectionValues = definition.getProps$expo_modules_core_release().values();
        boolean z = false;
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((AnyViewProp) it.next()).isStateProp$expo_modules_core_release()) {
                    z = true;
                    break;
                }
            }
        }
        this.hasStateProps = z;
    }

    public /* synthetic */ ViewManagerWrapperDelegate(ModuleHolder moduleHolder, ViewManagerDefinition viewManagerDefinition, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(moduleHolder, viewManagerDefinition, (i & 4) != 0 ? null : str);
    }

    public final ModuleHolder<?> getModuleHolder$expo_modules_core_release() {
        return this.moduleHolder;
    }

    public final void setModuleHolder$expo_modules_core_release(ModuleHolder<?> moduleHolder) {
        Intrinsics.checkNotNullParameter(moduleHolder, "<set-?>");
        this.moduleHolder = moduleHolder;
    }

    /* JADX INFO: renamed from: getDefinition$expo_modules_core_release, reason: from getter */
    public final ViewManagerDefinition getDefinition() {
        return this.definition;
    }

    /* JADX INFO: renamed from: getDelegateName$expo_modules_core_release, reason: from getter */
    public final String getDelegateName() {
        return this.delegateName;
    }

    public final ViewGroupDefinition getViewGroupDefinition$expo_modules_core_release() {
        return this.definition.getViewGroupDefinition();
    }

    public final String getName() {
        String str = this.delegateName;
        if (str != null) {
            return str;
        }
        return this.moduleHolder.getName() + "_" + this.definition.getName();
    }

    public final String getViewManagerName() {
        return "ViewManagerAdapter_" + getName();
    }

    public final Map<String, AnyViewProp> getProps() {
        return this.definition.getProps$expo_modules_core_release();
    }

    public final boolean getHasStateProps() {
        return this.hasStateProps;
    }

    public final View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.definition.createView(context, this.moduleHolder.getModule().getAppContext());
    }

    public final void onViewDidUpdateProps(View view) {
        UnexpectedException unexpectedException;
        UnexpectedException codedException;
        Intrinsics.checkNotNullParameter(view, "view");
        Function1<View, Unit> onViewDidUpdateProps = this.definition.getOnViewDidUpdateProps();
        if (onViewDidUpdateProps != null) {
            try {
                onViewDidUpdateProps.invoke(view);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (th instanceof CodedException) {
                        codedException = (CodedException) th;
                    } else {
                        codedException = th instanceof expo.modules.core.errors.CodedException ? new CodedException(((expo.modules.core.errors.CodedException) th).getCode(), ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause()) : new UnexpectedException(th);
                    }
                    throw new OnViewDidUpdatePropsException(JvmClassMappingKt.getKotlinClass(view.getClass()), codedException);
                } catch (Throwable th2) {
                    if (ErrorViewKt.isErrorView(view)) {
                        return;
                    }
                    if (th2 instanceof CodedException) {
                        unexpectedException = (CodedException) th2;
                    } else if (th2 instanceof expo.modules.core.errors.CodedException) {
                        expo.modules.core.errors.CodedException codedException2 = (expo.modules.core.errors.CodedException) th2;
                        unexpectedException = new CodedException(codedException2.getCode(), codedException2.getMessage(), codedException2.getCause());
                    } else {
                        unexpectedException = new UnexpectedException(th2);
                    }
                    CoreLoggerKt.getLogger().error("❌ Error occurred when invoking 'onViewDidUpdateProps' on '" + view.getClass().getSimpleName() + "'", unexpectedException);
                    this.definition.handleException(view, unexpectedException);
                }
            }
        }
    }

    public final ViewManager<?, ?> toRNViewManager() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.definition.getViewManagerType().ordinal()];
        if (i == 1) {
            return new SimpleViewManagerWrapper(this);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return new GroupViewManagerWrapper(this);
    }

    public final List<String> updateProperties(View view, ReadableMap propsMap) {
        UnexpectedException codedException;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propsMap, "propsMap");
        Map<String, AnyViewProp> props = getProps();
        ArrayList arrayList = new ArrayList();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = propsMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            AnyViewProp anyViewProp = props.get(strNextKey);
            if (anyViewProp != null) {
                if (anyViewProp.isStateProp$expo_modules_core_release()) {
                    anyViewProp = null;
                }
                if (anyViewProp != null) {
                    try {
                        anyViewProp.set(propsMap.getDynamic(strNextKey), view, (ConverterContext) this.moduleHolder.getModule().getAppContext());
                    } catch (Throwable th) {
                        try {
                            if (!ErrorViewKt.isErrorView(view)) {
                                if (th instanceof CodedException) {
                                    codedException = (CodedException) th;
                                } else {
                                    codedException = th instanceof expo.modules.core.errors.CodedException ? new CodedException(((expo.modules.core.errors.CodedException) th).getCode(), ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause()) : new UnexpectedException(th);
                                }
                                CoreLoggerKt.getLogger().error("❌ Cannot set the '" + getName() + "' prop on the '" + view + "'", codedException);
                                this.definition.handleException(view, codedException);
                            }
                        } catch (Throwable th2) {
                            arrayList.add(strNextKey);
                            throw th2;
                        }
                    }
                    arrayList.add(strNextKey);
                } else {
                    continue;
                }
            }
        }
        return arrayList;
    }

    public final void updateStateProps(View view) {
        StateWrapper stateWrapper;
        Map<String, Object> stateProps;
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.hasStateProps) {
            ExpoView expoView = view instanceof ExpoView ? (ExpoView) view : null;
            if (expoView == null || (stateWrapper = expoView.getStateWrapper()) == null || (stateProps = new NativeStatePropsGetter().getStateProps(stateWrapper)) == null) {
                return;
            }
            for (Map.Entry<String, Object> entry : stateProps.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                AnyViewProp anyViewProp = getProps().get(key);
                if (anyViewProp != null && anyViewProp.isStateProp$expo_modules_core_release()) {
                    try {
                        anyViewProp.set(value, view, this.moduleHolder.getModule().getAppContext());
                    } catch (Throwable th) {
                        if (!ErrorViewKt.isErrorView(view)) {
                            if (th instanceof CodedException) {
                                unexpectedException = (CodedException) th;
                            } else if (th instanceof expo.modules.core.errors.CodedException) {
                                expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                                unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
                            } else {
                                unexpectedException = new UnexpectedException(th);
                            }
                            CoreLoggerKt.getLogger().error("❌ Cannot set the '" + key + "' state prop on the '" + view + "'", unexpectedException);
                            this.definition.handleException(view, unexpectedException);
                        }
                    }
                } else {
                    Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Tried to set unknown or non-state prop '" + key + "' on '" + view + "'", null, 2, null);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy(View view) {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            ComposeHostingView composeHostingView = view instanceof ComposeHostingView ? (ComposeHostingView) view : null;
            if (composeHostingView != null) {
                composeHostingView.disposeHostedComposition();
            }
            Function1<View, Unit> onViewDestroys = this.definition.getOnViewDestroys();
            if (onViewDestroys != null) {
                onViewDestroys.invoke(view);
            }
        } catch (Throwable th) {
            if (ErrorViewKt.isErrorView(view)) {
                return;
            }
            if (th instanceof CodedException) {
                unexpectedException = (CodedException) th;
            } else if (th instanceof expo.modules.core.errors.CodedException) {
                expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                unexpectedException = new CodedException(codedException.getCode(), codedException.getMessage(), codedException.getCause());
            } else {
                unexpectedException = new UnexpectedException(th);
            }
            CoreLoggerKt.getLogger().error("❌ '" + view + "' wasn't able to destroy itself", unexpectedException);
            this.definition.handleException(view, unexpectedException);
        }
    }

    public final Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        String[] names;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        CallbacksDefinition callbacksDefinition = this.definition.getCallbacksDefinition();
        if (callbacksDefinition != null && (names = callbacksDefinition.getNames()) != null) {
            for (String str : names) {
                mapCreateMapBuilder.put(KModuleEventEmitterWrapperKt.normalizeEventName(str), MapsKt.mapOf(TuplesKt.to("registrationName", str)));
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }
}
