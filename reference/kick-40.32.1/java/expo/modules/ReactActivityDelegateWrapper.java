package expo.modules;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.muxer.WebmConstants;
import androidx.mediarouter.media.GlobalMediaRouter;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactDelegate;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactActivityHandler;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import expo.modules.kotlin.Utils;
import expo.modules.kotlin.exception.Exceptions;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.bouncycastle.math.Primes;

/* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0081\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\tJ\n\u0010.\u001a\u0004\u0018\u00010/H\u0014J\n\u00100\u001a\u0004\u0018\u000101H\u0014J\n\u00102\u001a\u0004\u0018\u000103H\u0014J\n\u00104\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u00105\u001a\u000206H\u0016J\n\u00107\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u00108\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010\u0016H\u0014J\u0012\u0010:\u001a\u00020%2\b\u0010;\u001a\u0004\u0018\u00010/H\u0017J\b\u0010<\u001a\u00020%H\u0016J\b\u0010=\u001a\u00020%H\u0016J\b\u0010>\u001a\u00020%H\u0016J\b\u0010?\u001a\u00020%H\u0016J\"\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0018\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020B2\u0006\u0010H\u001a\u00020IH\u0016J\u0018\u0010J\u001a\u00020\u00052\u0006\u0010G\u001a\u00020B2\u0006\u0010H\u001a\u00020IH\u0016J\u0018\u0010K\u001a\u00020\u00052\u0006\u0010G\u001a\u00020B2\u0006\u0010H\u001a\u00020IH\u0016J\b\u0010L\u001a\u00020\u0005H\u0016J\u0012\u0010M\u001a\u00020\u00052\b\u0010N\u001a\u0004\u0018\u00010EH\u0016J\u0010\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020\u0005H\u0016J/\u0010Q\u001a\u00020%2\u000e\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160S2\u0006\u0010A\u001a\u00020B2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0002\u0010VJ-\u0010W\u001a\u00020%2\u0006\u0010A\u001a\u00020B2\u000e\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160S2\u0006\u0010X\u001a\u00020YH\u0016¢\u0006\u0002\u0010ZJ\b\u0010[\u001a\u00020\\H\u0014J\b\u0010]\u001a\u00020^H\u0014J\b\u0010_\u001a\u00020\u0005H\u0014J\b\u0010`\u001a\u00020\u0005H\u0014J\n\u0010a\u001a\u0004\u0018\u00010/H\u0014J\u0010\u0010b\u001a\u00020%2\u0006\u0010c\u001a\u00020dH\u0016J\u001b\u0010e\u001a\u0002Hf\"\u0004\b\u0000\u0010f2\u0006\u0010g\u001a\u00020\u0016H\u0002¢\u0006\u0002\u0010hJC\u0010e\u001a\u0002Hf\"\u0004\b\u0000\u0010f\"\u0004\b\u0001\u0010i2\u0006\u0010g\u001a\u00020\u00162\u0010\u0010j\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030k0S2\f\u0010l\u001a\b\u0012\u0004\u0012\u0002Hi0SH\u0001¢\u0006\u0004\bm\u0010nJ \u0010o\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010\u00162\u0006\u0010p\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010qJ\u000e\u0010r\u001a\u00020%H\u0082@¢\u0006\u0002\u0010sJ\u0018\u0010t\u001a\u00020%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0082@¢\u0006\u0002\u0010uJ@\u0010v\u001a\u00020%2\b\b\u0002\u0010w\u001a\u00020x2'\u0010y\u001a#\b\u0001\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0{\u0012\u0006\u0012\u0004\u0018\u00010|0z¢\u0006\u0002\b}H\u0002¢\u0006\u0002\u0010~J\u000e\u0010\u007f\u001a\u00020%H\u0001¢\u0006\u0003\b\u0080\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00018\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00130\u00130\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001d\u001a\u0004\b+\u0010,¨\u0006\u0082\u0001"}, d2 = {"Lexpo/modules/ReactActivityDelegateWrapper;", "Lcom/facebook/react/ReactActivityDelegate;", "activity", "Lcom/facebook/react/ReactActivity;", "isNewArchitectureEnabled", "", "delegate", "<init>", "(Lcom/facebook/react/ReactActivity;ZLcom/facebook/react/ReactActivityDelegate;)V", "(Lcom/facebook/react/ReactActivity;Lcom/facebook/react/ReactActivityDelegate;)V", "getDelegate$expo_release", "()Lcom/facebook/react/ReactActivityDelegate;", "setDelegate$expo_release", "(Lcom/facebook/react/ReactActivityDelegate;)V", "reactActivityLifecycleListeners", "", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "kotlin.jvm.PlatformType", "reactActivityHandlers", "Lexpo/modules/core/interfaces/ReactActivityHandler;", "methodMap", "Landroidx/collection/ArrayMap;", "", "Ljava/lang/reflect/Method;", "_reactHost", "Lcom/facebook/react/ReactHost;", "get_reactHost", "()Lcom/facebook/react/ReactHost;", "_reactHost$delegate", "Lkotlin/Lazy;", "delayLoadAppHandler", "Lexpo/modules/core/interfaces/ReactActivityHandler$DelayLoadAppHandler;", "getDelayLoadAppHandler", "()Lexpo/modules/core/interfaces/ReactActivityHandler$DelayLoadAppHandler;", "delayLoadAppHandler$delegate", "loadAppReady", "Lkotlinx/coroutines/CompletableDeferred;", "", "localNetworkPermissionResult", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "applicationCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getApplicationCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "applicationCoroutineScope$delegate", "getLaunchOptions", "Landroid/os/Bundle;", "createRootView", "Lcom/facebook/react/ReactRootView;", "getReactDelegate", "Lcom/facebook/react/ReactDelegate;", "getReactHost", "getReactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "getMainComponentName", "loadApp", "appKey", "onCreate", "savedInstanceState", "onResume", "onPause", "onUserLeaveHint", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyLongPress", "onBackPressed", "onNewIntent", "intent", "onWindowFocusChanged", "hasFocus", "requestPermissions", "permissions", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/react/modules/core/PermissionListener;", "([Ljava/lang/String;ILcom/facebook/react/modules/core/PermissionListener;)V", "onRequestPermissionsResult", "grantResults", "", "(I[Ljava/lang/String;[I)V", "getContext", "Landroid/content/Context;", "getPlainActivity", "Landroid/app/Activity;", "isFabricEnabled", "isWideColorGamutEnabled", "composeLaunchOptions", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "invokeDelegateMethod", ExifInterface.GPS_DIRECTION_TRUE, "name", "(Ljava/lang/String;)Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "argTypes", "Ljava/lang/Class;", "args", "invokeDelegateMethod$expo_release", "(Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "loadAppImpl", "supportsDelayLoad", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLocalNetworkPermission", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDelayLoadAppWhenReady", "(Lexpo/modules/core/interfaces/ReactActivityHandler$DelayLoadAppHandler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchLifecycleScopeWithLock", ViewProps.START, "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)V", "setLoadAppReadyForTesting", "setLoadAppReadyForTesting$expo_release", "Companion", "expo_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReactActivityDelegateWrapper extends ReactActivityDelegate {
    private static final String TAG = Reflection.getOrCreateKotlinClass(ReactActivityDelegate.class).getSimpleName();

    /* JADX INFO: renamed from: _reactHost$delegate, reason: from kotlin metadata */
    private final Lazy _reactHost;
    private final ReactActivity activity;

    /* JADX INFO: renamed from: applicationCoroutineScope$delegate, reason: from kotlin metadata */
    private final Lazy applicationCoroutineScope;

    /* JADX INFO: renamed from: delayLoadAppHandler$delegate, reason: from kotlin metadata */
    private final Lazy delayLoadAppHandler;
    private ReactActivityDelegate delegate;
    private final boolean isNewArchitectureEnabled;
    private final CompletableDeferred<Unit> loadAppReady;
    private CompletableDeferred<Unit> localNetworkPermissionResult;
    private final ArrayMap<String, Method> methodMap;
    private final Mutex mutex;
    private final List<ReactActivityHandler> reactActivityHandlers;
    private final List<ReactActivityLifecycleListener> reactActivityLifecycleListeners;

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$awaitLocalNetworkPermission$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper", f = "ReactActivityDelegateWrapper.kt", i = {0}, l = {447}, m = "awaitLocalNetworkPermission", n = {"result"}, nl = {448}, s = {"L$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReactActivityDelegateWrapper.this.awaitLocalNetworkPermission(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$loadAppImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper", f = "ReactActivityDelegateWrapper.kt", i = {0, 0, 0}, l = {426}, m = "loadAppImpl", n = {"appKey", "rootViewContainer", "supportsDelayLoad"}, nl = {427}, s = {"L$0", "L$1", "Z$0"}, v = 2)
    static final class C07961 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C07961(Continuation<? super C07961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReactActivityDelegateWrapper.this.loadAppImpl(null, false, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactActivityDelegateWrapper(ReactActivity activity, boolean z, ReactActivityDelegate delegate) {
        super(activity, (String) null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.activity = activity;
        this.isNewArchitectureEnabled = z;
        this.delegate = delegate;
        List<Package> packageList = ExpoModulesPackage.INSTANCE.getPackageList();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = packageList.iterator();
        while (it.hasNext()) {
            List<? extends ReactActivityLifecycleListener> listCreateReactActivityLifecycleListeners = ((Package) it.next()).createReactActivityLifecycleListeners(this.activity);
            Intrinsics.checkNotNullExpressionValue(listCreateReactActivityLifecycleListeners, "createReactActivityLifecycleListeners(...)");
            CollectionsKt.addAll(arrayList, listCreateReactActivityLifecycleListeners);
        }
        this.reactActivityLifecycleListeners = arrayList;
        List<Package> packageList2 = ExpoModulesPackage.INSTANCE.getPackageList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = packageList2.iterator();
        while (it2.hasNext()) {
            List<? extends ReactActivityHandler> listCreateReactActivityHandlers = ((Package) it2.next()).createReactActivityHandlers(this.activity);
            Intrinsics.checkNotNullExpressionValue(listCreateReactActivityHandlers, "createReactActivityHandlers(...)");
            CollectionsKt.addAll(arrayList2, listCreateReactActivityHandlers);
        }
        this.reactActivityHandlers = arrayList2;
        this.methodMap = new ArrayMap<>();
        this._reactHost = LazyKt.lazy(new Function0() { // from class: expo.modules.ReactActivityDelegateWrapper$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.delegate.getReactHost();
            }
        });
        this.delayLoadAppHandler = LazyKt.lazy(new Function0() { // from class: expo.modules.ReactActivityDelegateWrapper$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReactActivityDelegateWrapper.delayLoadAppHandler_delegate$lambda$0(this.f$0);
            }
        });
        this.loadAppReady = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.applicationCoroutineScope = LazyKt.lazy(new Function0() { // from class: expo.modules.ReactActivityDelegateWrapper$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
            }
        });
    }

    /* JADX INFO: renamed from: getDelegate$expo_release, reason: from getter */
    public final ReactActivityDelegate getDelegate() {
        return this.delegate;
    }

    public final void setDelegate$expo_release(ReactActivityDelegate reactActivityDelegate) {
        Intrinsics.checkNotNullParameter(reactActivityDelegate, "<set-?>");
        this.delegate = reactActivityDelegate;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReactActivityDelegateWrapper(ReactActivity activity, ReactActivityDelegate delegate) {
        this(activity, false, delegate);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    private final ReactHost get_reactHost() {
        return (ReactHost) this._reactHost.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReactActivityHandler.DelayLoadAppHandler getDelayLoadAppHandler() {
        return (ReactActivityHandler.DelayLoadAppHandler) this.delayLoadAppHandler.getValue();
    }

    static final ReactActivityHandler.DelayLoadAppHandler delayLoadAppHandler_delegate$lambda$0(final ReactActivityDelegateWrapper reactActivityDelegateWrapper) {
        return (ReactActivityHandler.DelayLoadAppHandler) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(reactActivityDelegateWrapper.reactActivityHandlers), new Function1() { // from class: expo.modules.ReactActivityDelegateWrapper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactActivityDelegateWrapper.delayLoadAppHandler_delegate$lambda$0$0(this.f$0, (ReactActivityHandler) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReactActivityHandler.DelayLoadAppHandler delayLoadAppHandler_delegate$lambda$0$0(ReactActivityDelegateWrapper reactActivityDelegateWrapper, ReactActivityHandler reactActivityHandler) {
        return reactActivityHandler.getDelayLoadAppHandler(reactActivityDelegateWrapper.activity, reactActivityDelegateWrapper.getReactHost());
    }

    private final CoroutineScope getApplicationCoroutineScope() {
        return (CoroutineScope) this.applicationCoroutineScope.getValue();
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected Bundle getLaunchOptions() {
        return (Bundle) invokeDelegateMethod("getLaunchOptions");
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected ReactRootView createRootView() {
        return (ReactRootView) invokeDelegateMethod("createRootView");
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected ReactDelegate getReactDelegate() {
        return (ReactDelegate) invokeDelegateMethod("getReactDelegate");
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public ReactHost getReactHost() {
        return get_reactHost();
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public ReactInstanceManager getReactInstanceManager() {
        ReactInstanceManager reactInstanceManager = this.delegate.getReactInstanceManager();
        Intrinsics.checkNotNullExpressionValue(reactInstanceManager, "getReactInstanceManager(...)");
        return reactInstanceManager;
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public String getMainComponentName() {
        return this.delegate.getMainComponentName();
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$loadApp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$loadApp$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, nl = {114}, s = {}, v = 2)
    static final class C07951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07951(String str, Continuation<? super C07951> continuation) {
            super(2, continuation);
            this.$appKey = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C07951(this.$appKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppImpl(this.$appKey, true, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.ReactActivityDelegate
    /* JADX INFO: renamed from: loadApp */
    public void lambda$onCreate$0(String appKey) {
        launchLifecycleScopeWithLock(CoroutineStart.UNDISPATCHED, new C07951(appKey, null));
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onCreate(Bundle savedInstanceState) throws IllegalAccessException, NoSuchFieldException {
        ReactActivityDelegate reactActivityDelegate = (ReactActivityDelegate) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactActivityHandlers), new Function1() { // from class: expo.modules.ReactActivityDelegateWrapper$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ReactActivityDelegateWrapper reactActivityDelegateWrapper = this.f$0;
                return ((ReactActivityHandler) obj).onDidCreateReactActivityDelegate(reactActivityDelegateWrapper.activity, reactActivityDelegateWrapper);
            }
        }));
        Iterator<T> it = this.reactActivityHandlers.iterator();
        while (it.hasNext()) {
            ((ReactActivityHandler) it.next()).onDidCreateReactActivityDelegateNotification(this.activity, reactActivityDelegate);
        }
        if (reactActivityDelegate != null && !Intrinsics.areEqual(reactActivityDelegate, this)) {
            Field declaredField = ReactActivity.class.getDeclaredField("mDelegate");
            declaredField.setAccessible(true);
            Field declaredField2 = Field.class.getDeclaredField("accessFlags");
            declaredField2.setAccessible(true);
            declaredField2.setInt(declaredField, declaredField.getModifiers() & (-17));
            declaredField.set(this.activity, reactActivityDelegate);
            this.delegate = reactActivityDelegate;
            reactActivityDelegate.onCreate(savedInstanceState);
        } else {
            launchLifecycleScopeWithLock(CoroutineStart.UNDISPATCHED, new AnonymousClass2(null));
        }
        Iterator<T> it2 = this.reactActivityLifecycleListeners.iterator();
        while (it2.hasNext()) {
            ((ReactActivityLifecycleListener) it2.next()).onCreate(this.activity, savedInstanceState);
        }
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onCreate$2", f = "ReactActivityDelegateWrapper.kt", i = {1, 1, 1, 2, 2, 2}, l = {146, WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL, WebmConstants.MkvEbmlElement.BLOCK_MORE}, m = "invokeSuspend", n = {"launchOptions", "reactDelegate", "mReactDelegate", "launchOptions", "reactDelegate", "mReactDelegate"}, nl = {147, WebmConstants.MkvEbmlElement.BLOCK_MORE, 168}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00f9, code lost:
        
            if (r9.loadAppImpl(r9.getMainComponentName(), false, r8) == r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
            /*
                Method dump skipped, instruction units count: 255
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.ReactActivityDelegateWrapper.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onResume$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, nl = {WebmConstants.MkvEbmlElement.CUE_TIME}, s = {}, v = 2)
    static final class C08021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08021(Continuation<? super C08021> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C08021(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReactActivityDelegateWrapper.this.getDelegate().onResume();
            List list = ReactActivityDelegateWrapper.this.reactActivityLifecycleListeners;
            ReactActivityDelegateWrapper reactActivityDelegateWrapper = ReactActivityDelegateWrapper.this;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ReactActivityLifecycleListener) it.next()).onResume(reactActivityDelegateWrapper.activity);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onResume() {
        launchLifecycleScopeWithLock$default(this, null, new C08021(null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onPause$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onPause$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, nl = {189}, s = {}, v = 2)
    static final class C08001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08001(Continuation<? super C08001> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C08001(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list = ReactActivityDelegateWrapper.this.reactActivityLifecycleListeners;
            ReactActivityDelegateWrapper reactActivityDelegateWrapper = ReactActivityDelegateWrapper.this;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ReactActivityLifecycleListener) it.next()).onPause(reactActivityDelegateWrapper.activity);
            }
            ReactActivityHandler.DelayLoadAppHandler delayLoadAppHandler = ReactActivityDelegateWrapper.this.getDelayLoadAppHandler();
            ReactActivityDelegateWrapper reactActivityDelegateWrapper2 = ReactActivityDelegateWrapper.this;
            if (delayLoadAppHandler != null) {
                try {
                    reactActivityDelegateWrapper2.getDelegate().onPause();
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    Boxing.boxInt(Log.e(ReactActivityDelegateWrapper.TAG, "Exception occurred during onPause with delayed app loading", e));
                }
            } else {
                reactActivityDelegateWrapper2.getDelegate().onPause();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onPause() {
        launchLifecycleScopeWithLock$default(this, null, new C08001(null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onUserLeaveHint$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onUserLeaveHint$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, nl = {Primes.SMALL_FACTOR_LIMIT}, s = {}, v = 2)
    static final class C08031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08031(Continuation<? super C08031> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C08031(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list = ReactActivityDelegateWrapper.this.reactActivityLifecycleListeners;
            ReactActivityDelegateWrapper reactActivityDelegateWrapper = ReactActivityDelegateWrapper.this;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ReactActivityLifecycleListener) it.next()).onUserLeaveHint(reactActivityDelegateWrapper.activity);
            }
            ReactActivityDelegateWrapper.this.getDelegate().onUserLeaveHint();
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onUserLeaveHint() {
        launchLifecycleScopeWithLock$default(this, null, new C08031(null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onDestroy$1", f = "ReactActivityDelegateWrapper.kt", i = {0, 0, 1, 1, 1}, l = {495, 223}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-ReactActivityDelegateWrapper$onDestroy$1$1"}, nl = {496, 224}, s = {"L$0", "I$0", "L$0", "I$0", "I$1"}, v = 2)
    static final class C07991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        C07991(Continuation<? super C07991> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C07991(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x007e A[Catch: all -> 0x001c, LOOP:0: B:23:0x0078->B:25:0x007e, LOOP_END, TryCatch #1 {all -> 0x001c, blocks: (B:7:0x0018, B:22:0x006e, B:23:0x0078, B:25:0x007e, B:26:0x008e, B:28:0x0094, B:33:0x00b6, B:32:0x00af, B:31:0x009f), top: B:42:0x0018, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:32:0x00af A[Catch: all -> 0x001c, TryCatch #1 {all -> 0x001c, blocks: (B:7:0x0018, B:22:0x006e, B:23:0x0078, B:25:0x007e, B:26:0x008e, B:28:0x0094, B:33:0x00b6, B:32:0x00af, B:31:0x009f), top: B:42:0x0018, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            ReactActivityDelegateWrapper reactActivityDelegateWrapper;
            int i;
            Throwable th;
            Mutex mutex2;
            ReactActivityDelegateWrapper reactActivityDelegateWrapper2;
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = ReactActivityDelegateWrapper.this.mutex;
                    reactActivityDelegateWrapper = ReactActivityDelegateWrapper.this;
                    this.L$0 = mutex;
                    this.L$1 = reactActivityDelegateWrapper;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    reactActivityDelegateWrapper2 = (ReactActivityDelegateWrapper) this.L$1;
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        it = reactActivityDelegateWrapper2.reactActivityLifecycleListeners.iterator();
                        while (it.hasNext()) {
                            ((ReactActivityLifecycleListener) it.next()).onDestroy(reactActivityDelegateWrapper2.activity);
                        }
                        if (reactActivityDelegateWrapper2.getDelayLoadAppHandler() != null) {
                            try {
                                reactActivityDelegateWrapper2.getDelegate().onDestroy();
                                Unit unit = Unit.INSTANCE;
                            } catch (Exception e) {
                                Boxing.boxInt(Log.e(ReactActivityDelegateWrapper.TAG, "Exception occurred during onDestroy with delayed app loading", e));
                            }
                        } else {
                            reactActivityDelegateWrapper2.getDelegate().onDestroy();
                        }
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                int i3 = this.I$0;
                ReactActivityDelegateWrapper reactActivityDelegateWrapper3 = (ReactActivityDelegateWrapper) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                i = i3;
                reactActivityDelegateWrapper = reactActivityDelegateWrapper3;
                mutex = mutex3;
                CompletableDeferred completableDeferred = reactActivityDelegateWrapper.loadAppReady;
                this.L$0 = mutex;
                this.L$1 = reactActivityDelegateWrapper;
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 2;
                if (completableDeferred.await(this) != coroutine_suspended) {
                    mutex2 = mutex;
                    reactActivityDelegateWrapper2 = reactActivityDelegateWrapper;
                    it = reactActivityDelegateWrapper2.reactActivityLifecycleListeners.iterator();
                    while (it.hasNext()) {
                        ((ReactActivityLifecycleListener) it.next()).onDestroy(reactActivityDelegateWrapper2.activity);
                    }
                    if (reactActivityDelegateWrapper2.getDelayLoadAppHandler() != null) {
                        reactActivityDelegateWrapper2.getDelegate().onDestroy();
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        reactActivityDelegateWrapper2.getDelegate().onDestroy();
                    }
                    Unit unit4 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onDestroy() {
        BuildersKt__Builders_commonKt.launch$default(getApplicationCoroutineScope(), null, null, new C07991(null), 3, null);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onActivityResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onActivityResult$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {GlobalMediaRouter.CallbackHandler.MSG_ROUTE_CHANGED}, m = "invokeSuspend", n = {}, nl = {GlobalMediaRouter.CallbackHandler.MSG_ROUTE_VOLUME_CHANGED}, s = {}, v = 2)
    static final class C07971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Intent $data;
        final /* synthetic */ int $requestCode;
        final /* synthetic */ int $resultCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07971(int i, int i2, Intent intent, Continuation<? super C07971> continuation) {
            super(2, continuation);
            this.$requestCode = i;
            this.$resultCode = i2;
            this.$data = intent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C07971(this.$requestCode, this.$resultCode, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReactActivityDelegateWrapper.this.getDelegate().onActivityResult(this.$requestCode, this.$resultCode, this.$data);
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        launchLifecycleScopeWithLock$default(this, null, new C07971(requestCode, resultCode, data, null), 1, null);
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.loadAppReady.isCompleted()) {
            return false;
        }
        List<ReactActivityHandler> list = this.reactActivityHandlers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((ReactActivityHandler) it.next()).onKeyDown(keyCode, event)));
        }
        Iterator it2 = arrayList.iterator();
        loop1: while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop1;
                }
                boolean zBooleanValue = ((Boolean) it2.next()).booleanValue();
                if (z || zBooleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onKeyDown(keyCode, event);
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.loadAppReady.isCompleted()) {
            return false;
        }
        List<ReactActivityHandler> list = this.reactActivityHandlers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((ReactActivityHandler) it.next()).onKeyUp(keyCode, event)));
        }
        Iterator it2 = arrayList.iterator();
        loop1: while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop1;
                }
                boolean zBooleanValue = ((Boolean) it2.next()).booleanValue();
                if (z || zBooleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onKeyUp(keyCode, event);
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.loadAppReady.isCompleted()) {
            return false;
        }
        List<ReactActivityHandler> list = this.reactActivityHandlers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((ReactActivityHandler) it.next()).onKeyLongPress(keyCode, event)));
        }
        Iterator it2 = arrayList.iterator();
        loop1: while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop1;
                }
                boolean zBooleanValue = ((Boolean) it2.next()).booleanValue();
                if (z || zBooleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onKeyLongPress(keyCode, event);
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public boolean onBackPressed() {
        boolean z;
        if (!this.loadAppReady.isCompleted()) {
            return false;
        }
        List<ReactActivityLifecycleListener> list = this.reactActivityLifecycleListeners;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((ReactActivityLifecycleListener) it.next()).onBackPressed()));
        }
        Iterator it2 = arrayList.iterator();
        loop1: while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop1;
                }
                boolean zBooleanValue = ((Boolean) it2.next()).booleanValue();
                if (z || zBooleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onBackPressed();
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public boolean onNewIntent(Intent intent) {
        boolean z;
        if (!this.loadAppReady.isCompleted()) {
            return false;
        }
        List<ReactActivityLifecycleListener> list = this.reactActivityLifecycleListeners;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((ReactActivityLifecycleListener) it.next()).onNewIntent(intent)));
        }
        Iterator it2 = arrayList.iterator();
        loop1: while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop1;
                }
                boolean zBooleanValue = ((Boolean) it2.next()).booleanValue();
                if (z || zBooleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onNewIntent(intent);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onWindowFocusChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onWindowFocusChanged$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {MediaError.DetailedErrorCode.DASH_NETWORK}, m = "invokeSuspend", n = {}, nl = {MediaError.DetailedErrorCode.DASH_NO_INIT}, s = {}, v = 2)
    static final class C08041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $hasFocus;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08041(boolean z, Continuation<? super C08041> continuation) {
            super(2, continuation);
            this.$hasFocus = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C08041(this.$hasFocus, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReactActivityDelegateWrapper.this.getDelegate().onWindowFocusChanged(this.$hasFocus);
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onWindowFocusChanged(boolean hasFocus) {
        launchLifecycleScopeWithLock$default(this, null, new C08041(hasFocus, null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$requestPermissions$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$requestPermissions$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {328}, m = "invokeSuspend", n = {}, nl = {329}, s = {}, v = 2)
    static final class C08051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PermissionListener $listener;
        final /* synthetic */ String[] $permissions;
        final /* synthetic */ int $requestCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08051(String[] strArr, int i, PermissionListener permissionListener, Continuation<? super C08051> continuation) {
            super(2, continuation);
            this.$permissions = strArr;
            this.$requestCode = i;
            this.$listener = permissionListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C08051(this.$permissions, this.$requestCode, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReactActivityDelegateWrapper.this.getDelegate().requestPermissions(this.$permissions, this.$requestCode, this.$listener);
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void requestPermissions(String[] permissions, int requestCode, PermissionListener listener) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        launchLifecycleScopeWithLock$default(this, null, new C08051(permissions, requestCode, listener, null), 1, null);
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 19534) {
            CompletableDeferred<Unit> completableDeferred = this.localNetworkPermissionResult;
            if (completableDeferred != null) {
                completableDeferred.complete(Unit.INSTANCE);
                return;
            }
            return;
        }
        launchLifecycleScopeWithLock$default(this, null, new C08011(requestCode, permissions, grantResults, null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onRequestPermissionsResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onRequestPermissionsResult$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {339}, m = "invokeSuspend", n = {}, nl = {340}, s = {}, v = 2)
    static final class C08011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int[] $grantResults;
        final /* synthetic */ String[] $permissions;
        final /* synthetic */ int $requestCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08011(int i, String[] strArr, int[] iArr, Continuation<? super C08011> continuation) {
            super(2, continuation);
            this.$requestCode = i;
            this.$permissions = strArr;
            this.$grantResults = iArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C08011(this.$requestCode, this.$permissions, this.$grantResults, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReactActivityDelegateWrapper.this.getDelegate().onRequestPermissionsResult(this.$requestCode, this.$permissions, this.$grantResults);
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected Context getContext() {
        return (Context) invokeDelegateMethod("getContext");
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected Activity getPlainActivity() {
        return (Activity) invokeDelegateMethod("getPlainActivity");
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected boolean isFabricEnabled() {
        return ((Boolean) invokeDelegateMethod("isFabricEnabled")).booleanValue();
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected boolean isWideColorGamutEnabled() {
        return ((Boolean) invokeDelegateMethod("isWideColorGamutEnabled")).booleanValue();
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected Bundle composeLaunchOptions() {
        return (Bundle) invokeDelegateMethod("composeLaunchOptions");
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onConfigurationChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onConfigurationChanged$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, nl = {367}, s = {}, v = 2)
    static final class C07981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Configuration $newConfig;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07981(Configuration configuration, Continuation<? super C07981> continuation) {
            super(2, continuation);
            this.$newConfig = configuration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C07981(this.$newConfig, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReactActivityDelegateWrapper.this.getDelegate().onConfigurationChanged(this.$newConfig);
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        launchLifecycleScopeWithLock$default(this, null, new C07981(newConfig, null), 1, null);
    }

    private final <T> T invokeDelegateMethod(String name) throws NoSuchMethodException {
        Method declaredMethod = this.methodMap.get(name);
        if (declaredMethod == null) {
            declaredMethod = ReactActivityDelegate.class.getDeclaredMethod(name, null);
            declaredMethod.setAccessible(true);
            this.methodMap.put(name, declaredMethod);
        }
        Intrinsics.checkNotNull(declaredMethod);
        return (T) declaredMethod.invoke(this.delegate, null);
    }

    public final <T, A> T invokeDelegateMethod$expo_release(String name, Class<?>[] argTypes, A[] args) throws NoSuchMethodException {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(argTypes, "argTypes");
        Intrinsics.checkNotNullParameter(args, "args");
        Method declaredMethod = this.methodMap.get(name);
        if (declaredMethod == null) {
            declaredMethod = ReactActivityDelegate.class.getDeclaredMethod(name, (Class[]) Arrays.copyOf(argTypes, argTypes.length));
            declaredMethod.setAccessible(true);
            this.methodMap.put(name, declaredMethod);
        }
        Intrinsics.checkNotNull(declaredMethod);
        return (T) declaredMethod.invoke(this.delegate, Arrays.copyOf(args, args.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object loadAppImpl(String str, boolean z, Continuation<? super Unit> continuation) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        C07961 c07961;
        if (continuation instanceof C07961) {
            c07961 = (C07961) continuation;
            if ((c07961.label & Integer.MIN_VALUE) != 0) {
                c07961.label -= Integer.MIN_VALUE;
            } else {
                c07961 = new C07961(continuation);
            }
        } else {
            c07961 = new C07961(continuation);
        }
        Object obj = c07961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07961.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ViewGroup viewGroup = (ViewGroup) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactActivityHandlers), new Function1() { // from class: expo.modules.ReactActivityDelegateWrapper$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ((ReactActivityHandler) obj2).createReactRootViewContainer(this.f$0.activity);
                }
            }));
            if (viewGroup != null) {
                Field declaredField = ReactActivityDelegate.class.getDeclaredField("mReactDelegate");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(this.delegate);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.facebook.react.ReactDelegate");
                ReactDelegate reactDelegate = (ReactDelegate) obj2;
                if (str != null) {
                    reactDelegate.loadApp(str);
                    ReactRootView reactRootView = reactDelegate.getReactRootView();
                    ViewParent parent = reactRootView != null ? reactRootView.getParent() : null;
                    ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(reactRootView);
                    }
                    viewGroup.addView(reactRootView, -1);
                    this.activity.setContentView(viewGroup);
                    Iterator<T> it = this.reactActivityLifecycleListeners.iterator();
                    while (it.hasNext()) {
                        ((ReactActivityLifecycleListener) it.next()).onContentChanged(this.activity);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            if (z) {
                ReactActivityHandler.DelayLoadAppHandler delayLoadAppHandler = getDelayLoadAppHandler();
                c07961.L$0 = str;
                c07961.L$1 = SpillingKt.nullOutSpilledVariable(viewGroup);
                c07961.Z$0 = z;
                c07961.label = 1;
                if (awaitDelayLoadAppWhenReady(delayLoadAppHandler, c07961) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                invokeDelegateMethod$expo_release("loadApp", new Class[]{String.class}, new String[]{str});
                Iterator<T> it2 = this.reactActivityLifecycleListeners.iterator();
                while (it2.hasNext()) {
                    ((ReactActivityLifecycleListener) it2.next()).onContentChanged(this.activity);
                }
                return Unit.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z2 = c07961.Z$0;
            str = (String) c07961.L$0;
            ResultKt.throwOnFailure(obj);
        }
        invokeDelegateMethod$expo_release("loadApp", new Class[]{String.class}, new String[]{str});
        Iterator<T> it3 = this.reactActivityLifecycleListeners.iterator();
        while (it3.hasNext()) {
            ((ReactActivityLifecycleListener) it3.next()).onContentChanged(this.activity);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object awaitLocalNetworkPermission(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!LocalNetworkPermission.INSTANCE.shouldRequest(this.activity)) {
                return Unit.INSTANCE;
            }
            CompletableDeferred<Unit> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            this.localNetworkPermissionResult = completableDeferredCompletableDeferred$default;
            this.activity.requestPermissions(new String[]{LocalNetworkPermission.PERMISSION}, LocalNetworkPermission.REQUEST_CODE);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(completableDeferredCompletableDeferred$default);
            anonymousClass1.label = 1;
            if (completableDeferredCompletableDeferred$default.await(anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.localNetworkPermissionResult = null;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitDelayLoadAppWhenReady(ReactActivityHandler.DelayLoadAppHandler delayLoadAppHandler, Continuation<? super Unit> continuation) {
        if (delayLoadAppHandler == null) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        delayLoadAppHandler.whenReady(new Runnable() { // from class: expo.modules.ReactActivityDelegateWrapper$awaitDelayLoadAppWhenReady$2$1
            @Override // java.lang.Runnable
            public final void run() throws Exceptions.IncorrectThreadException {
                Utils utils = Utils.INSTANCE;
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m12684constructorimpl(Unit.INSTANCE));
                } else {
                    String name = Thread.currentThread().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    String name2 = Looper.getMainLooper().getThread().getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    throw new Exceptions.IncorrectThreadException(name, name2);
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    static /* synthetic */ void launchLifecycleScopeWithLock$default(ReactActivityDelegateWrapper reactActivityDelegateWrapper, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        reactActivityDelegateWrapper.launchLifecycleScopeWithLock(coroutineStart, function2);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$launchLifecycleScopeWithLock$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$launchLifecycleScopeWithLock$1", f = "ReactActivityDelegateWrapper.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {495, 469}, m = "invokeSuspend", n = {"$this$launch", "$this$withLock_u24default$iv", "$i$f$withLock", "$this$launch", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-ReactActivityDelegateWrapper$launchLifecycleScopeWithLock$1$1"}, nl = {496, 470}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1"}, v = 2)
    static final class C07941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07941(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C07941> continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07941 c07941 = ReactActivityDelegateWrapper.this.new C07941(this.$block, continuation);
            c07941.L$0 = obj;
            return c07941;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2;
            int i;
            Throwable th;
            Mutex mutex2;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = ReactActivityDelegateWrapper.this.mutex;
                    Function2<CoroutineScope, Continuation<? super Unit>, Object> function3 = this.$block;
                    this.L$0 = coroutineScope;
                    this.L$1 = mutex;
                    this.L$2 = function3;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        function2 = function3;
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                i = this.I$0;
                function2 = (Function2) this.L$2;
                Mutex mutex3 = (Mutex) this.L$1;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = mutex;
                this.L$2 = null;
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 2;
                if (function2.invoke(coroutineScope, this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    private final void launchLifecycleScopeWithLock(CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.activity), null, start, new C07941(block, null), 1, null);
    }

    public final void setLoadAppReadyForTesting$expo_release() {
        this.loadAppReady.complete(Unit.INSTANCE);
    }
}
