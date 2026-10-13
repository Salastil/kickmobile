package expo.modules.ui;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.profileinstaller.ProfileVerifier;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedVisibilityView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002\u001a\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002\u001a\u0019\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"toComposeTransition", "Landroidx/compose/animation/EnterTransition;", "Lexpo/modules/ui/EnterTransitionRecord;", "Landroidx/compose/animation/ExitTransition;", "Lexpo/modules/ui/ExitTransitionRecord;", "toComposedEnterTransition", "", "toComposedExitTransition", "AnimatedVisibilityContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/AnimatedVisibilityProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/AnimatedVisibilityProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnimatedVisibilityViewKt {

    /* JADX INFO: compiled from: AnimatedVisibilityView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[EnterTransitionType.values().length];
            try {
                iArr[EnterTransitionType.FADE_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterTransitionType.SLIDE_IN_HORIZONTALLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterTransitionType.SLIDE_IN_VERTICALLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnterTransitionType.EXPAND_IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnterTransitionType.EXPAND_HORIZONTALLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnterTransitionType.EXPAND_VERTICALLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnterTransitionType.SCALE_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ExitTransitionType.values().length];
            try {
                iArr2[ExitTransitionType.FADE_OUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ExitTransitionType.SLIDE_OUT_HORIZONTALLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ExitTransitionType.SLIDE_OUT_VERTICALLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[ExitTransitionType.SHRINK_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[ExitTransitionType.SHRINK_HORIZONTALLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[ExitTransitionType.SHRINK_VERTICALLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[ExitTransitionType.SCALE_OUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static final Unit AnimatedVisibilityContent$lambda$11(FunctionalComposableScope functionalComposableScope, AnimatedVisibilityProps animatedVisibilityProps, int i, Composer composer, int i2) {
        AnimatedVisibilityContent(functionalComposableScope, animatedVisibilityProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final EnterTransition toComposeTransition(final EnterTransitionRecord enterTransitionRecord) {
        switch (WhenMappings.$EnumSwitchMapping$0[enterTransitionRecord.getType().ordinal()]) {
            case 1:
                if (enterTransitionRecord.getInitialAlpha() != null) {
                    return EnterExitTransitionKt.fadeIn$default(null, enterTransitionRecord.getInitialAlpha().floatValue(), 1, null);
                }
                return EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null);
            case 2:
                if (enterTransitionRecord.getInitialOffsetX() != null) {
                    return EnterExitTransitionKt.slideInHorizontally$default(null, new Function1() { // from class: expo.modules.ui.AnimatedVisibilityViewKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(AnimatedVisibilityViewKt.toComposeTransition$lambda$0(enterTransitionRecord, ((Integer) obj).intValue()));
                        }
                    }, 1, null);
                }
                return EnterExitTransitionKt.slideInHorizontally$default(null, null, 3, null);
            case 3:
                if (enterTransitionRecord.getInitialOffsetY() != null) {
                    return EnterExitTransitionKt.slideInVertically$default(null, new Function1() { // from class: expo.modules.ui.AnimatedVisibilityViewKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(AnimatedVisibilityViewKt.toComposeTransition$lambda$1(enterTransitionRecord, ((Integer) obj).intValue()));
                        }
                    }, 1, null);
                }
                return EnterExitTransitionKt.slideInVertically$default(null, null, 3, null);
            case 4:
                return EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null);
            case 5:
                return EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null);
            case 6:
                return EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null);
            case 7:
                if (enterTransitionRecord.getInitialScale() != null) {
                    return EnterExitTransitionKt.m1359scaleInL8ZKhE$default(null, enterTransitionRecord.getInitialScale().floatValue(), 0L, 5, null);
                }
                return EnterExitTransitionKt.m1359scaleInL8ZKhE$default(null, 0.0f, 0L, 7, null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    static final int toComposeTransition$lambda$0(EnterTransitionRecord enterTransitionRecord, int i) {
        return (int) (i * enterTransitionRecord.getInitialOffsetX().floatValue());
    }

    static final int toComposeTransition$lambda$1(EnterTransitionRecord enterTransitionRecord, int i) {
        return (int) (i * enterTransitionRecord.getInitialOffsetY().floatValue());
    }

    private static final ExitTransition toComposeTransition(final ExitTransitionRecord exitTransitionRecord) {
        switch (WhenMappings.$EnumSwitchMapping$1[exitTransitionRecord.getType().ordinal()]) {
            case 1:
                if (exitTransitionRecord.getTargetAlpha() != null) {
                    return EnterExitTransitionKt.fadeOut$default(null, exitTransitionRecord.getTargetAlpha().floatValue(), 1, null);
                }
                return EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null);
            case 2:
                if (exitTransitionRecord.getTargetOffsetX() != null) {
                    return EnterExitTransitionKt.slideOutHorizontally$default(null, new Function1() { // from class: expo.modules.ui.AnimatedVisibilityViewKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(AnimatedVisibilityViewKt.toComposeTransition$lambda$2(exitTransitionRecord, ((Integer) obj).intValue()));
                        }
                    }, 1, null);
                }
                return EnterExitTransitionKt.slideOutHorizontally$default(null, null, 3, null);
            case 3:
                if (exitTransitionRecord.getTargetOffsetY() != null) {
                    return EnterExitTransitionKt.slideOutVertically$default(null, new Function1() { // from class: expo.modules.ui.AnimatedVisibilityViewKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(AnimatedVisibilityViewKt.toComposeTransition$lambda$3(exitTransitionRecord, ((Integer) obj).intValue()));
                        }
                    }, 1, null);
                }
                return EnterExitTransitionKt.slideOutVertically$default(null, null, 3, null);
            case 4:
                return EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null);
            case 5:
                return EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null);
            case 6:
                return EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null);
            case 7:
                if (exitTransitionRecord.getTargetScale() != null) {
                    return EnterExitTransitionKt.m1361scaleOutL8ZKhE$default(null, exitTransitionRecord.getTargetScale().floatValue(), 0L, 5, null);
                }
                return EnterExitTransitionKt.m1361scaleOutL8ZKhE$default(null, 0.0f, 0L, 7, null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    static final int toComposeTransition$lambda$2(ExitTransitionRecord exitTransitionRecord, int i) {
        return (int) (i * exitTransitionRecord.getTargetOffsetX().floatValue());
    }

    static final int toComposeTransition$lambda$3(ExitTransitionRecord exitTransitionRecord, int i) {
        return (int) (i * exitTransitionRecord.getTargetOffsetY().floatValue());
    }

    private static final EnterTransition toComposedEnterTransition(List<EnterTransitionRecord> list) {
        Object obj;
        List<EnterTransitionRecord> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toComposeTransition((EnterTransitionRecord) it.next()));
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            while (it2.hasNext()) {
                next = ((EnterTransition) next).plus((EnterTransition) it2.next());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (EnterTransition) obj;
    }

    private static final ExitTransition toComposedExitTransition(List<ExitTransitionRecord> list) {
        Object obj;
        List<ExitTransitionRecord> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toComposeTransition((ExitTransitionRecord) it.next()));
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            Object next = it2.next();
            while (it2.hasNext()) {
                next = ((ExitTransition) next).plus((ExitTransition) it2.next());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (ExitTransition) obj;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0097  */
    public static final void AnimatedVisibilityContent(final FunctionalComposableScope functionalComposableScope, final AnimatedVisibilityProps props, Composer composer, final int i) {
        int i2;
        EnterTransition enterTransitionPlus;
        ExitTransition exitTransitionPlus;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-874168538);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedVisibilityContent)N(props)161@5779L83,162@5867L39,156@5599L307:AnimatedVisibilityView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-874168538, i2, -1, "expo.modules.ui.AnimatedVisibilityContent (AnimatedVisibilityView.kt:152)");
            }
            List<EnterTransitionRecord> enterTransition = props.getEnterTransition();
            if (enterTransition == null) {
                enterTransitionPlus = null;
            } else {
                if (enterTransition.isEmpty()) {
                    enterTransition = null;
                }
                if (enterTransition != null) {
                    enterTransitionPlus = toComposedEnterTransition(enterTransition);
                } else {
                    enterTransitionPlus = null;
                }
            }
            List<ExitTransitionRecord> exitTransition = props.getExitTransition();
            if (exitTransition == null) {
                exitTransitionPlus = null;
            } else {
                if (exitTransition.isEmpty()) {
                    exitTransition = null;
                }
                if (exitTransition != null) {
                    exitTransitionPlus = toComposedExitTransition(exitTransition);
                } else {
                    exitTransitionPlus = null;
                }
            }
            boolean visible = props.getVisible();
            if (enterTransitionPlus == null) {
                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
            }
            if (exitTransitionPlus == null) {
                exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
            }
            AnimatedVisibilityKt.AnimatedVisibility(visible, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), enterTransitionPlus, exitTransitionPlus, (String) null, ComposableLambdaKt.rememberComposableLambda(-1992728066, true, new Function3() { // from class: expo.modules.ui.AnimatedVisibilityViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AnimatedVisibilityViewKt.AnimatedVisibilityContent$lambda$10(functionalComposableScope, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.AnimatedVisibilityViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AnimatedVisibilityViewKt.AnimatedVisibilityContent$lambda$11(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit AnimatedVisibilityContent$lambda$10(FunctionalComposableScope functionalComposableScope, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C163@5873L29:AnimatedVisibilityView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1992728066, i, -1, "expo.modules.ui.AnimatedVisibilityContent.<anonymous> (AnimatedVisibilityView.kt:163)");
        }
        functionalComposableScope.Children(new UIComposableScope(null, null, null, null, 15, null), composer, FunctionalComposableScope.$stable << 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
