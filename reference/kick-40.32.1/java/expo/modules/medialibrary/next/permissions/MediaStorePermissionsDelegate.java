package expo.modules.medialibrary.next.permissions;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Process;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import expo.modules.medialibrary.PermissionsException;
import expo.modules.medialibrary.next.extensions.resolver.AssetExtensionsKt;
import expo.modules.medialibrary.next.permissions.contracts.DeleteContractInput;
import expo.modules.medialibrary.next.permissions.contracts.WriteContractInput;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaStorePermissionsDelegate.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0087@¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u0013*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0016H\u0083@¢\u0006\u0002\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f0\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lexpo/modules/medialibrary/next/permissions/MediaStorePermissionsDelegate;", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Lexpo/modules/kotlin/AppContext;)V", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "deleteLauncher", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "Lexpo/modules/medialibrary/next/permissions/contracts/DeleteContractInput;", "", "writeLauncher", "Lexpo/modules/medialibrary/next/permissions/contracts/WriteContractInput;", "launchMediaStoreDeleteRequest", "", "uris", "", "Landroid/net/Uri;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestMediaLibraryWritePermission", "", "(Ljava/lang/Iterable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerMediaStoreContracts", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;", "appContextProvider", "Lexpo/modules/kotlin/providers/AppContextProvider;", "(Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;Lexpo/modules/kotlin/providers/AppContextProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasWritePermissionForUri", "uri", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MediaStorePermissionsDelegate {
    private final AppContext appContext;
    private AppContextActivityResultLauncher<DeleteContractInput, Boolean> deleteLauncher;
    private AppContextActivityResultLauncher<WriteContractInput, Boolean> writeLauncher;

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate$hasWritePermissionForUri$1, reason: invalid class name */
    /* JADX INFO: compiled from: MediaStorePermissionsDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate", f = "MediaStorePermissionsDelegate.kt", i = {0}, l = {65}, m = "hasWritePermissionForUri", n = {"uri"}, s = {"L$0"})
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
            return MediaStorePermissionsDelegate.this.hasWritePermissionForUri(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate$launchMediaStoreDeleteRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MediaStorePermissionsDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate", f = "MediaStorePermissionsDelegate.kt", i = {0}, l = {32}, m = "launchMediaStoreDeleteRequest", n = {"uris"}, s = {"L$0"})
    static final class C09191 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09191(Continuation<? super C09191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaStorePermissionsDelegate.this.launchMediaStoreDeleteRequest(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate$registerMediaStoreContracts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MediaStorePermissionsDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate", f = "MediaStorePermissionsDelegate.kt", i = {0, 0, 1, 1}, l = {56, 57}, m = "registerMediaStoreContracts", n = {"$this$registerMediaStoreContracts", "appContextProvider", "$this$registerMediaStoreContracts", "appContextProvider"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C09201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09201(Continuation<? super C09201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaStorePermissionsDelegate.this.registerMediaStoreContracts(null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate$requestMediaLibraryWritePermission$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MediaStorePermissionsDelegate.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate", f = "MediaStorePermissionsDelegate.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1}, l = {43, 49}, m = "requestMediaLibraryWritePermission", n = {"uris", "$this$filterNot$iv", "$this$filterNotTo$iv$iv", "destination$iv$iv", "element$iv$iv", "uri", "$i$f$filterNot", "$i$f$filterNotTo", "$i$a$-filterNot-MediaStorePermissionsDelegate$requestMediaLibraryWritePermission$urisWithoutPermission$1", "uris", "urisWithoutPermission"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$1"})
    static final class C09211 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C09211(Continuation<? super C09211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaStorePermissionsDelegate.this.requestMediaLibraryWritePermission(null, this);
        }
    }

    public MediaStorePermissionsDelegate(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    public final AppContext getAppContext() {
        return this.appContext;
    }

    private final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = this.appContext.getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object launchMediaStoreDeleteRequest(List<? extends Uri> list, Continuation<? super Unit> continuation) throws PermissionsException {
        C09191 c09191;
        if (continuation instanceof C09191) {
            c09191 = (C09191) continuation;
            if ((c09191.label & Integer.MIN_VALUE) != 0) {
                c09191.label -= Integer.MIN_VALUE;
            } else {
                c09191 = new C09191(continuation);
            }
        } else {
            c09191 = new C09191(continuation);
        }
        Object objLaunch = c09191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09191.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objLaunch);
            AppContextActivityResultLauncher<DeleteContractInput, Boolean> appContextActivityResultLauncher = this.deleteLauncher;
            if (appContextActivityResultLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteLauncher");
                appContextActivityResultLauncher = null;
            }
            DeleteContractInput deleteContractInput = new DeleteContractInput(CollectionsKt.toList(list));
            c09191.L$0 = SpillingKt.nullOutSpilledVariable(list);
            c09191.label = 1;
            objLaunch = appContextActivityResultLauncher.launch(deleteContractInput, c09191);
            if (objLaunch == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objLaunch);
        }
        if (!((Boolean) objLaunch).booleanValue()) {
            throw new PermissionsException(MediaLibraryConstantsKt.ERROR_USER_DID_NOT_GRANT_WRITE_PERMISSIONS_MESSAGE);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x009b  */
    /* JADX WARN: Code duplicated, block: B:26:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:29:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00cf -> B:27:0x00dc). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object requestMediaLibraryWritePermission(java.lang.Iterable<? extends android.net.Uri> r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate.requestMediaLibraryWritePermission(java.lang.Iterable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0094, code lost:
    
        if (r11 == r0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object registerMediaStoreContracts(expo.modules.kotlin.activityresult.AppContextActivityResultCaller r9, expo.modules.kotlin.providers.AppContextProvider r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate.C09201
            if (r0 == 0) goto L14
            r0 = r11
            expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate$registerMediaStoreContracts$1 r0 = (expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate.C09201) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate$registerMediaStoreContracts$1 r0 = new expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate$registerMediaStoreContracts$1
            r0.<init>(r11)
        L19:
            r4 = r0
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L52
            if (r1 == r2) goto L42
            if (r1 != r7) goto L3a
            java.lang.Object r8 = r4.L$2
            expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate r8 = (expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate) r8
            java.lang.Object r9 = r4.L$1
            expo.modules.kotlin.providers.AppContextProvider r9 = (expo.modules.kotlin.providers.AppContextProvider) r9
            java.lang.Object r9 = r4.L$0
            expo.modules.kotlin.activityresult.AppContextActivityResultCaller r9 = (expo.modules.kotlin.activityresult.AppContextActivityResultCaller) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L97
        L3a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L42:
            java.lang.Object r9 = r4.L$2
            expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate r9 = (expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate) r9
            java.lang.Object r10 = r4.L$1
            expo.modules.kotlin.providers.AppContextProvider r10 = (expo.modules.kotlin.providers.AppContextProvider) r10
            java.lang.Object r1 = r4.L$0
            expo.modules.kotlin.activityresult.AppContextActivityResultCaller r1 = (expo.modules.kotlin.activityresult.AppContextActivityResultCaller) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L71
        L52:
            kotlin.ResultKt.throwOnFailure(r11)
            expo.modules.medialibrary.next.permissions.contracts.DeleteContract r11 = new expo.modules.medialibrary.next.permissions.contracts.DeleteContract
            r11.<init>(r10)
            expo.modules.kotlin.activityresult.AppContextActivityResultContract r11 = (expo.modules.kotlin.activityresult.AppContextActivityResultContract) r11
            r4.L$0 = r9
            r4.L$1 = r10
            r4.L$2 = r8
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r1 = r9
            r2 = r11
            java.lang.Object r11 = expo.modules.kotlin.activityresult.AppContextActivityResultCaller.registerForActivityResult$default(r1, r2, r3, r4, r5, r6)
            if (r11 != r0) goto L70
            goto L96
        L70:
            r9 = r8
        L71:
            expo.modules.kotlin.activityresult.AppContextActivityResultLauncher r11 = (expo.modules.kotlin.activityresult.AppContextActivityResultLauncher) r11
            r9.deleteLauncher = r11
            expo.modules.medialibrary.next.permissions.contracts.WriteContract r9 = new expo.modules.medialibrary.next.permissions.contracts.WriteContract
            r9.<init>(r10)
            r2 = r9
            expo.modules.kotlin.activityresult.AppContextActivityResultContract r2 = (expo.modules.kotlin.activityresult.AppContextActivityResultContract) r2
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r4.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$1 = r9
            r4.L$2 = r8
            r4.label = r7
            r3 = 0
            r5 = 2
            r6 = 0
            java.lang.Object r11 = expo.modules.kotlin.activityresult.AppContextActivityResultCaller.registerForActivityResult$default(r1, r2, r3, r4, r5, r6)
            if (r11 != r0) goto L97
        L96:
            return r0
        L97:
            expo.modules.kotlin.activityresult.AppContextActivityResultLauncher r11 = (expo.modules.kotlin.activityresult.AppContextActivityResultLauncher) r11
            r8.writeLauncher = r11
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.next.permissions.MediaStorePermissionsDelegate.registerMediaStoreContracts(expo.modules.kotlin.activityresult.AppContextActivityResultCaller, expo.modules.kotlin.providers.AppContextProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object hasWritePermissionForUri(Uri uri, Continuation<? super Boolean> continuation) {
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
        Object objQueryAssetOwnerPackageName = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryAssetOwnerPackageName);
            ContentResolver contentResolver = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            anonymousClass1.L$0 = uri;
            anonymousClass1.label = 1;
            objQueryAssetOwnerPackageName = AssetExtensionsKt.queryAssetOwnerPackageName(contentResolver, uri, anonymousClass1);
            if (objQueryAssetOwnerPackageName == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            uri = (Uri) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objQueryAssetOwnerPackageName);
        }
        boolean zAreEqual = Intrinsics.areEqual(objQueryAssetOwnerPackageName, getContext().getPackageName());
        boolean z2 = getContext().checkUriPermission(uri, Process.myPid(), Process.myUid(), 2) == 0;
        if (!zAreEqual && !z2) {
            z = false;
        }
        return Boxing.boxBoolean(z);
    }
}
